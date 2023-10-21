package src.model;

import src.Exceptions.InvalidAgeException;

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

    public String addStudent(String name,String lastname, String studentCode, int age,  double height, double weightS, double weightA){
        return "ADDED";
    }

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 8 || age > 100) {
            throw new InvalidAgeException("Rango de edad inválido");
        }
    }

}
