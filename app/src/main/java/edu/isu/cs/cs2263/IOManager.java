package edu.isu.cs.cs2263;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import edu.isu.cs.cs2263.gson.Professor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOManager {
    //Instance variables
    private ArrayList<Student> students = new ArrayList<>();

    //Empty constructor
    public IOManager() {}

    public void writeFile(String file, Student[] data) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter(file);

        gson.toJson(data, writer);
        writer.close();
    }

    public ArrayList<Student> readFile(String file) throws IOException {
        Gson gson = new Gson();
        ArrayList<Student> other = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get(file));
        //Create Type for ArrayList
        Type arrayList = new TypeToken<ArrayList<Student>>() {}.getType();
        other = gson.fromJson(reader, arrayList);
        reader.close();
        return other;
    }
}
