package org.rodrigez.util;

import com.google.gson.Gson;
import org.rodrigez.model.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FileTool {
    private File fileIn;
    private File fileOut;
    private TypeSave typeSave;

    public File getFileIn() {
        return fileIn;
    }

    public File getFileOut() {
        return fileOut;
    }

    public enum TypeSave{
        STRING,OBJECT,JSON
    }

    public FileTool(TypeSave typeSave) {
        this.fileIn = new File("src/main/resources/in-string.txt");
        this.fileOut = new File("src/main/resources/out-string.txt");
        this.typeSave = typeSave;
    }

    public void write(Object o) throws IOException, IllegalAccessException {
        switch (typeSave){
            case STRING: writeString(o); break;
            case OBJECT: writeObject(o); break;
            case JSON: writeJson(o); break;
        }
    }

    private void writeString(Object o) throws IOException, IllegalAccessException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut, true));
        for(Field field: o.getClass().getFields()){
            bufferedWriter.write(field.getName() + ":" + field.get(o));
        }
        bufferedWriter.write(o.toString());
    }

    private void writeObject(Object o) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileOut));
        stream.writeObject(o);
    }

    private void writeJson(Object o) throws FileNotFoundException {
        Gson gson = new Gson();
        PrintWriter writer = new PrintWriter(fileOut);
        String json = gson.toJson(o);
        writer.write(json);
    }

    public Object read(Class aClass) throws IOException, ClassNotFoundException {
        switch (typeSave){
            case STRING: return readString(aClass);
            case OBJECT: return readObject();
            case JSON: return readJson(aClass);
            default: return null;
        }
    }

    private Object readString(Class aClass) throws IOException {
        Map<String,String> parameters = new HashMap<>();
        String str;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
        while ((str = bufferedReader.readLine()) != null) {
            String[] keyValue = str.split("=");
            parameters.put(keyValue[0],keyValue[1]);
        }
        if(aClass.equals(BuildingProject.class)){
            return readBuildingProject(parameters);
        }
        return null;
    }

    private BuildingProject readBuildingProject(Map<String, String> parameters) {
        int floorsNumber = Integer.valueOf(parameters.get("building-project.floors-number"));
        int housingClass = Integer.valueOf(parameters.get("building-project.housing-class"));
        String address = parameters.get("building-project.address");
        return new BuildingProject(floorsNumber,housingClass,address);
    }

    private Object readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileIn));
        return stream.readObject();
    }

    private Object readJson(Class aClass) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        String json = reader.readLine();
        return gson.fromJson(json, aClass);
    }
}