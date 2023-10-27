package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class DataReader {

    private final Gson gson;

    public DataReader(){
        gson = new Gson();
    }

    public void importStudentsData(String pathName, ArrayList<Student> students){
        try {
            FileReader fileReader = new FileReader(pathName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\,");
                if (parts.length >= 10) {
                    String studentCode = parts[0];
                    boolean alreadyExists = false;
                    for (int i = 0; i < students.size() && !alreadyExists; i++){
                        Student existingStudent = students.get(i);
                        if (studentCode.equals(existingStudent.getStudentCode())){
                            alreadyExists = true;
                        }
                    }
                    if (!alreadyExists){
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
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readGsonStudentsFile(String pathName, ArrayList<Student> students){
        try {

            FileInputStream fs = new FileInputStream(pathName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String json = br.readLine();

            Student[] array = gson.fromJson(json, Student[].class);

            for (Student student : array) {
                boolean alreadyExists = false;
                for (int i = 0; i < students.size() && !alreadyExists; i++) {
                    Student existingStudent = students.get(i);
                    if (existingStudent.getStudentCode().equals(student.getStudentCode())) {
                        alreadyExists = true;
                    }
                }
                if (!alreadyExists) {
                    students.add(student);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
