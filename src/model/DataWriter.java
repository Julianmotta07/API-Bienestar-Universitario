package model;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DataWriter {

    private final Gson gson;

    public DataWriter(){
        gson = new Gson();
    }

    public void writeGsonStudentsFile(String file, ArrayList<Student> students){
        String json = gson.toJson(students);
        try{
            FileOutputStream fos = new FileOutputStream((file));
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String bytesToTxTReport(String pathName, String text){
        File file = new File(pathName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Report generated!";
    }

}

