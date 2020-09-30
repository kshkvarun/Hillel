package Lesson20.Task3.Part1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {

        Gson g = new GsonBuilder().setPrettyPrinting().create();
        MainModel1 p = null;
        try (Reader reader = new FileReader("/home/kostya/Task2.3.Maven/src/test/java/Task3/Part1/input.json")) {
            p = g.fromJson(reader, MainModel1.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert p != null;
        p.getWidget().setDebug("off");
        p.getWidget().getWindow().setHeight(5001);
        p.getWidget().getImage().setHOffset(35);
        p.getWidget().getText().setOnMouseUp("400-100+200");


        try (FileWriter writer = new FileWriter("/home/kostya/Task2.3.Maven/src/test/java/Task3/Part1/result.json")) {
            g.toJson(p, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
