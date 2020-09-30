package Task3.Part2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Main2 {
    public static void main(String[] args) throws IOException {

        Gson g = new GsonBuilder().setPrettyPrinting().create();
        MainModel p = null;
        try (Reader reader = new FileReader("/home/kostya/Task2.3.Maven/src/test/java/Task3/Part2/input2.json")) {
            p = g.fromJson(reader, MainModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        p.getMenu().setId("666");
        p.getMenu().setValue("New File");
        p.getMenu().getPopup().getMenuitem().get(0).setValue("Delete");
        p.getMenu().getPopup().getMenuitem().get(0).setOnclick("Something");

        try (FileWriter writer = new FileWriter("/home/kostya/Task2.3.Maven/src/test/java/Task3/Part2/result2.json")) {
            g.toJson(p, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
