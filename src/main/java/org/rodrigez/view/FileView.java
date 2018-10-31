package org.rodrigez.view;

import com.google.gson.Gson;

import java.io.*;

public class FileView implements View {
    private File fileIn;
    private File fileOut;
    private String typeSave;

    public FileView(String fileInPath, String fileOutPath, String typeSave) {
        this.fileIn = new File(fileInPath);
        this.fileOut = new File(fileOutPath);
        this.typeSave = typeSave;
    }

    @Override
    public void print(Object o) {
        switch (typeSave){
            // TODO: 31.10.2018 яка різниця між стрінг і обджект
            case "String": printString(o); break;
            case "Object": printObject(o); break;
            case "JSON": printJson(o); break;
        }
    }

    private void printString(Object o){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileOut))) {
            stream.writeObject(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printObject(Object o){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileOut))) {
            stream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printJson(Object o){
        Gson gson = new Gson();
        try (PrintWriter writer = new PrintWriter(fileOut)){
            String json = gson.toJson(o);
            writer.write(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read(String attribute) {
        switch (typeSave){
            // TODO: 31.10.2018 яка різниця між стрінг і обджект
            case "String": return readString(attribute);
            case "Object": return readObject(attribute);
            case "JSON": return readJson(attribute);
            default: return null;
        }
    }

    private String readString(String attribute){
        String s = null;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileIn))){
            s = (String) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

    private Object readObject(String attribute){
        Object o = null;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileIn))){
            o = stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    private Object readJson(String attribute){
        Object o = null;
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileIn))) {
            String json = reader.readLine();
            // TODO: 31.10.2018 як передати???
            o = gson.fromJson(json, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }
}