package it.oop.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opencsv.CSVWriter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.stream.Stream;
import it.oop.core.Date;

public class MainIO {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/Date.class");
            FileChannel fc = fis.getChannel();
            int b;
            while ((b = fis.read()) != -1) {
                System.out.println((char) b);
            }
            fc.position(0);
            StringBuilder sb = new StringBuilder();
            for (byte bb : fis.readAllBytes()) {
                sb.append((char) bb);
            }
            System.out.println("-----");
            System.out.println(sb.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
        try (FileWriter fw = new FileWriter("src/main/resources/file.txt")) {
            StringBuilder sb = new StringBuilder();
            Stream.iterate("a", s -> s + "a")
                    .limit(15)
                    .forEach(s -> sb.append(s).append("\n"));
            fw.write(sb.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        //
        try (CSVWriter csvw = new CSVWriter(new FileWriter("src/main/resources/data.csv"))) {
            String[] row = { "id", "name", "address"};
            csvw.writeNext(row);
            row[0] = "3";
            row[1] = "Paul";
            row[2] = "Strada le Grazie, 15";
            csvw.writeNext(row);
            row[0] = "6";
            row[1] = "Sam";
            row[2] = "Strada le Grazie, 18";
            csvw.writeNext(row);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        Gson gson = new Gson();
        Date date = new Date(1,1,1970);
        String json = gson.toJson(date);
        System.out.println(json);
        Date date1 = gson.fromJson("{\"day\":1,\"month\":1,\"year\":1971}", Date.class);
        System.out.println(date1.toString());
        try (FileWriter fw = new FileWriter("src/main/resources/file.json")) {
            new GsonBuilder().setPrettyPrinting().create().toJson(date, fw);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        JsonObject obj = new JsonObject();
        obj.addProperty("id", 2);
        JsonArray arr = new JsonArray();
    }
}
