package org.rodrigez.view;

import com.google.gson.Gson;
import org.rodrigez.model.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileView implements View {
    private File fileIn;
    private File fileOut;
    private String typeSave;

    // TODO: 08.11.2018 typesave in enum
    public FileView(String typeSave) {
        this.fileIn = new File("src/main/resources/in-string.txt");
        this.fileOut = new File("src/main/resources/out-string.txt");
        this.typeSave = typeSave;
    }

    @Override
    public void write(Object o) {
        switch (typeSave){
            case "String": writeString(o); break;
            case "Object": writeObject(o); break;
            case "JSON": writeJson(o); break;
        }
    }

    private void writeString(Object o){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut, true))) {
            bufferedWriter.write("message=" + o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeObject(Object o){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileOut))) {
            stream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJson(Object o){
        Gson gson = new Gson();
        try (PrintWriter writer = new PrintWriter(fileOut)){
            String json = gson.toJson(o);
            writer.write(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read(Class aClass) {
        switch (typeSave){
            case "String": return readString(aClass);
            case "Object": return readObject();
            case "JSON": return readJson(aClass);
            default: return null;
        }
    }

    private Serializable readString(Class aClass){
        Map<String,String> parameters = new HashMap<>();
        try {
            String str;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
            while ((str = bufferedReader.readLine()) != null) {
                String[] keyValue = str.split("=");
                parameters.put(keyValue[0],keyValue[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(aClass.equals(Manager.class)){
            return readManager(parameters);
        } else if(aClass.equals(Customer.class)){
            return readCustomer(parameters);
        } else if(aClass.equals(Designer.class)){
            return readDesigner(parameters);
        } else if(aClass.equals(BuildingProject.class)){
            return readBuildingProject(parameters);
        } else {
            return null;
        }
    }

    private BuildingProject readBuildingProject(Map<String, String> parameters) {
        int floorsNumber = Integer.valueOf(parameters.get("building-project.floors-number"));
        int housingClass = Integer.valueOf(parameters.get("building-project.housing-class"));
        String address = parameters.get("building-project.address");
        return new BuildingProject(floorsNumber,housingClass,address);
    }

    private Designer readDesigner(Map<String, String> parameters) {
        String name = parameters.get("designer.name");
        return new Designer(name);
    }

    private Customer readCustomer(Map<String, String> parameters) {
        String name = parameters.get("customer.name");
        return new Customer(name);
    }

    private Manager readManager(Map<String, String> parameters) {
        String name = parameters.get("manager.name");
        return new Manager(name);
    }

    private Object readObject(){
        Object o = null;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileIn))){
            o = stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    private Object readJson(Class aClass){
        Object o = null;
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIn))) {
            String json = reader.readLine();
            o = gson.fromJson(json, aClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }
}