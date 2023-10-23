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
            BigDecimal decimalS = new BigDecimal(weightS / (height * height));
            decimalS = decimalS.setScale(decimalPlaces, RoundingMode.HALF_UP);
            double bmiS = decimalS.doubleValue();
            BigDecimal decimalsA = new BigDecimal(weightA / (height * height));
            decimalsA = decimalsA.setScale(decimalPlaces, RoundingMode.HALF_UP);
            double bmiA = decimalsA.doubleValue();
            Student student = new Student(studentCode, name, lastName, age, sex, weightS, weightA, height, bmiS, bmiA);
            students.add(student);
            msg = "Student successfully registered!.";
        }
        return msg;
    }

    public String editStudent(String studentCode, String name, String lastName, int age, char sex, double weightS, double weightA, double height){
        Student student = searchStudent(studentCode);
        student.setName(name != null ? name : student.getName());
        student.setLastName(lastName != null ? lastName : student.getLastName());
        student.setAge(age != 0 ? age : student.getAge());
        student.setSex(sex != 'N' ? sex : student.getSex());
        student.setWeightS(weightS != 0 ? weightS : student.getWeightS());
        student.setWeightA(weightA != 0 ? weightA : student.getWeightA());
        student.setHeight(height != 0 ? height : student.getHeight());
        if (weightS != 0 || weightA != 0 || height != 0){
            double h = student.getHeight();
            BigDecimal decimalS = new BigDecimal(student.getWeightS() / (h * h));
            decimalS = decimalS.setScale(decimalPlaces, RoundingMode.HALF_UP);
            student.setBmiS(decimalS.doubleValue());
            BigDecimal decimalA = new BigDecimal(student.getWeightA() / (h * h));
            decimalA = decimalA.setScale(decimalPlaces, RoundingMode.HALF_UP);
            student.setBmiA(decimalA.doubleValue());
        }
        return "Student information successfully edited!";
    }

    public String deleteStudent(String studentCode){
        Student student = searchStudent(studentCode);
        if (student != null){
            students.remove(student);
        } else {
            return "Error: A student with the entered ID does not exist.";
        }
        return "Student successfully removed!";
    }

    public String classificationReport() {

        StringBuilder text = new StringBuilder("Indicators:\n\n -Category A: low weight\n -Category B: normal weight\n -Category C: overweight\n -Category D: obesity\n -Category E: morbid obesity\n");
        text.append("\n============================\n");
        text.append("   SEPTEMBER 2022 REPORT        ");
        text.append("\n============================\n");

        int[] categoryCounts = new int[5];

        for (Student student: students) {
            double bmiS = student.getBmiS();
            if (bmiS < 18.50){
                categoryCounts[0]++;
            } else if (bmiS < 24.99){
                categoryCounts[1]++;
            } else if (bmiS < 29.99){
                categoryCounts[2]++;
            } else if (bmiS < 39.99){
                categoryCounts[3]++;
            } else {
                categoryCounts[4]++;
            }
        }

        String[] category = {"A", "B", "C", "D", "E"};

        text.append("\nDistribution:\n");
        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(": ").append(categoryCounts[i]).append(" students\n");
        }

        text.append("\nHistogram:\n");
        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(" ").append(generateHistogram(categoryCounts[i])).append("\n");
        }

        Arrays.fill(categoryCounts, 0);

        text.append("\n============================\n");
        text.append("      APRIL 2022 REPORT         ");
        text.append("\n============================\n");

        for (Student student: students) {
            double bmiA = student.getBmiA();
            if (bmiA < 18.50){
                categoryCounts[0]++;
            } else if (bmiA < 24.99){
                categoryCounts[1]++;
            } else if (bmiA < 29.99){
                categoryCounts[2]++;
            } else if (bmiA < 39.99){
                categoryCounts[3]++;
            } else {
                categoryCounts[4]++;
            }
        }

        text.append("\nDistribution:\n");
        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(": ").append(categoryCounts[i]).append(" students\n");
        }

        text.append("\nHistogram:\n");
        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(" ").append(generateHistogram(categoryCounts[i])).append("\n");
        }

        File file = new File("data/Classification report.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytes = text.toString().getBytes(StandardCharsets.UTF_8);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return "Report generated!";
    }

    private String generateHistogram(int count) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < count; i++) {
            bar.append("+");
        }
        return bar.toString();
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
        for (int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            list.append(i+1).append(". ").append(student.getStudentCode()).append(": ").append(student.getName()).append(" ").append(student.getLastName()).append("\n");
        }
        return list.toString();
    }

    public Student searchStudent(String studentCode){
        Student studentFound = null;
        boolean found = false;
        for (int i = 0; i < students.size() && !found; i++) {
            Student student = students.get(i);
            if (student.getStudentCode().equals(studentCode)){
                studentFound = student;
                found = true;
            }
        }
        return studentFound;
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