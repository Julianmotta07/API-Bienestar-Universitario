package src.model;

import java.util.ArrayList;

public class BienestarController {

    static String folder = "data";
    static String path = "data/data.txt";

    ArrayList<Student> students;

    public BienestarController() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
