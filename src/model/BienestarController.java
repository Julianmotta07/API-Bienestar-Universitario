package src.model;

import src.Exceptions.InvalidAgeException;
import src.Exceptions.InvalidHeightException;
import src.Exceptions.InvalidWeightException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BienestarController {

    static String folder = "data";
    static String path = "data/data.txt";

    ArrayList<Student> students;

    public BienestarController() {
        students = new ArrayList<>();
        loadDataBase();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String addStudent(String name,String lastname, String studentCode, int age,  double height, double weightS, double weightA){
        return "ADDED";
    }

    public void print(){
        for (Student student: students) {
            System.out.println(student.toString());
            System.out.println();
        }
    }

    private void loadDataBase(){
        try {
            FileReader fileReader = new FileReader("data/freshman_kgs.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\,");
                if (parts.length >= 10) {
                    String studentCode = parts[0];
                    String name = parts[1];
                    String lastName = parts[2];
                    int age = Integer.parseInt(parts[3]);
                    char sex = parts[4].charAt(0);
                    double weightS = Double.parseDouble(parts[5]);
                    double weightA = Double.parseDouble(parts[6]);
                    double height = Double.parseDouble(parts[7]);
                    double bmiS = Double.parseDouble(parts[8]);
                    double bmiA = Double.parseDouble(parts[9]);
                    Student student = new Student(studentCode, name, lastName, age, sex, weightS, weightA, height, bmiS, bmiA);
                    students.add(student);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 100) {
            throw new InvalidAgeException("Invalid age range");
        }
    }

    public void validateHeight(double height) throws InvalidHeightException {
        if (height < 0) {
            throw new InvalidHeightException("Invalid height range");
        }
    }

    public void validateWeight(double weight) throws InvalidWeightException {
        if (weight < 0) {
            throw new InvalidWeightException("Invalid weight range");
        }
    }
}
