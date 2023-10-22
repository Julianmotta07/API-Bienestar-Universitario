package model;

import Exceptions.*;
import com.google.gson.Gson;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class BienestarController {


    ArrayList<Student> students;

    public static int decimalPlaces = 2;

    Gson gson;

    public BienestarController() {
        students = new ArrayList<>();
        loadDataBase();
    }

    public String addStudent(String studentCode, String name, String lastName, int age, char sex, double weightS, double weightA, double height){
        String msg = "Error: A student with the entered ID already exists.";
        if (searchStudent(studentCode) == null){

            double bmiSep = weightS / (height * height);
            double bmiApr = weightA / (height * height);

            BigDecimal decimals = new BigDecimal(bmiSep);
            decimals= decimals.setScale(decimalPlaces, RoundingMode.HALF_UP);

            BigDecimal decimalsA = new BigDecimal(bmiApr);
            decimalsA= decimalsA.setScale(decimalPlaces, RoundingMode.HALF_UP);

            double bmiS = decimals.doubleValue();
            double bmiA = decimalsA.doubleValue();

            Student student = new Student(studentCode, name, lastName, age, sex, weightS, weightA, height, bmiS, bmiA);
            students.add(student);
            msg = "Student successfully registered!.";
        }
        return msg;
    }

    public String editStudent(String studentCode, String name, String lastName, int age, char sex, double weightS, double weightA, double height){
        Student student = searchStudent(studentCode);
        if(student != null) {
            student.setName(name != null ? name : student.getName());
            student.setLastName(lastName != null ? lastName : student.getLastName());
            student.setAge(age != 0 ? age : student.getAge());
            student.setSex(sex != 'N' ? sex : student.getSex());
            student.setWeightS(weightS != 0 ? weightS : student.getWeightS());
            student.setWeightA(weightA != 0 ? weightA : student.getWeightA());
            student.setHeight(height != 0 ? height : student.getHeight());
            return "Student information successfully edited!";
        }else {
            return "The student is not registered in the system\nEnter an existing student in the system and try again.";
        }
    }

    public String deleteStudent(String studentCode){
        students.remove(searchStudent(studentCode));
        return "Student successfully removed!";
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

    public void validateID(String studentCode) throws IDException {
        if (studentCode.length() != 9) {
            throw new IDException("The code must be 9 characters.");
        } else if (studentCode.charAt(0) != 'A'){
            throw new IDException("The code must begin with A.");
        }
    }

    public void validateAge(int age) throws AgeException {
        if (age < 0 || age > 100) {
            throw new AgeException("Invalid age range.");
        }
    }

    public void validateHeight(double height) throws HeightException {
        if (height < 0) {
            throw new HeightException("Invalid height range.");
        }
    }

    public void validateWeight(double weight) throws WeightException {
        if (weight < 0) {
            throw new WeightException("Invalid weight range.");
        }
    }

    public String showStudentList(){
        StringBuilder list = new StringBuilder("Students list:\n");
        for (Student student : students){
            list.append(student.getStudentCode()).append(": ").append(student.getName()).append(" ").append(student.getLastName()).append("\n");
        }
        return list.toString();
    }

    public Student searchStudent(String studentCode){
        Student userFound = null;
        boolean found = false;
        for (int i = 0; i < students.size() && !found; i++) {
            Student user = students.get(i);
            if (user.getStudentCode().equals(studentCode)){
                userFound = user;
                found = true;
            }
        }
        return userFound;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void writeGsonStudents(){

        String json = gson.toJson(students);

        try{
            FileOutputStream fos = new FileOutputStream(("data/studentList.json"));
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readGsonStudent(){

        File file = new File("studentList.json");

        if (file.exists()){

            try {
                FileInputStream fis = new FileInputStream(file);

                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

                String json = "";
                String line;

                if ((line = reader.readLine())!=null){
                    json = line;
                }

                fis.close();

                Student [] student = gson.fromJson(json, Student[].class);

                students.addAll(Arrays.asList(student));

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}

