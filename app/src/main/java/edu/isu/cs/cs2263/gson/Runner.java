package edu.isu.cs.cs2263.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Professor isaac = new Professor("Isaac", "Griffith",
                new PhoneNumber("208", "282-4876"), "grifisaa@isu.edu", "BA 315");

        Professor paul = new Professor("Paul", "Bodily",
                new PhoneNumber("208", "282-4932"), "bodipaul@isu.edu", "BA 5XX");

        Professor dave = new Professor("Dave", "Beard",
                new PhoneNumber("208", "282-2684"), "beard@isu.edu", "BA 3XX");

        System.out.println(isaac);
        System.out.println(paul);
        System.out.println(dave);

        gsonSerialize(isaac);
        List<Professor> profList = new ArrayList<>();
        profList.add(isaac);
        profList.add(dave);
        profList.add(paul);
        gsonSerializeList(profList);

        //gsonSerializeList(Lists.newArrayList(isaac, paul, dave));
    }

    public static void gsonSerializeList(List<Professor> list){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(list);
        System.out.println();
        System.out.println(json);

        //Write data out to a new file name ./faculty.json
        try { Files.writeString(Paths.get("./faculty.json"), json);}
        catch (IOException ex) {ex.printStackTrace();}

        String json2 = "";
        try {json2 = Files.readString(Paths.get("./faculty.json"));}
        catch (IOException ex) {ex.printStackTrace();}

        Type listType = new TypeToken<ArrayList<Professor>>() {}.getType();
        List<Professor> other = gson.fromJson(json2, listType);

        for (Professor p : other)
            System.out.println(p);
    }
    public static void gsonSerialize(Professor prof){
        //Default constructor for Gson
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(prof);

        System.out.println();
        System.out.println(json);

        //Print this out to a file
        try{
            Files.writeString(Paths.get("./prof.json"), json);
        } catch(IOException ex) { ex.printStackTrace(); }

        //Read the file back in
        String json2 = "";
        try { json2 = Files.readString(Paths.get("./prof.json"));}
        catch (IOException ex) {ex.printStackTrace();}

        Professor other = gson.fromJson(json2, Professor.class);

        if(other.equals(prof))
            System.out.println("They are the same.");
        else
            throw new RuntimeException("Something bad happened.");

    }
}
