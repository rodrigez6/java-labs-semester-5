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
    public void write(Object o) {
        switch (typeSave){
            case "String": writeString(o); break;
            case "Object": writeObject(o); break;
            case "JSON": writeJson(o); break;
        }
    }

    private void writeString(Object o){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileOut))) {
            stream.writeObject(o.toString());
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
            case "String": return readString();
            case "Object": return readObject();
            case "JSON": return readJson(aClass);
            default: return null;
        }
    }

    private String readString(){
        String s = null;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileIn))){
            s = (String) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return s;
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