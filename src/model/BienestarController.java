package model;

import Exceptions.*;
import com.google.gson.Gson;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            BigDecimal decimalS = BigDecimal.valueOf(student.getWeightS() / (h * h));
            decimalS = decimalS.setScale(decimalPlaces, RoundingMode.HALF_UP);
            student.setBmiS(decimalS.doubleValue());
            BigDecimal decimalA = BigDecimal.valueOf(student.getWeightA() / (h * h));
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
            int bmiSCategory = getBmiCategory(student.getBmiS());
            categoryCounts[bmiSCategory]++;
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
        text.append("     APRIL 2022 REPORT          ");
        text.append("\n============================\n");

        for (Student student: students) {
            int bmiACategory = getBmiCategory(student.getBmiA());
            categoryCounts[bmiACategory]++;
        }

        text.append("\nDistribution:\n");
        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(": ").append(categoryCounts[i]).append(" students\n");
        }

        text.append("\nHistogram:\n");
        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(" ").append(generateHistogram(categoryCounts[i])).append("\n");
        }

        return bytesToTxTReport("data/Classification_report.txt", text.toString());
    }

    public String nutritionalReport(int mode, int filter){

        StringBuilder text = new StringBuilder();
        text.append("====================================================================================\n");
        text.append("                           CHANGES IN NUTRITIONAL STATUS                                ");
        text.append("\n====================================================================================\n");

        if (mode == 1) {
            text.append(nutritionalReportIndicators());
        } else {
            text.append(nutritionalReportList(filter));
        }

        text.append("\n====================================================================================");

        return bytesToTxTReport("data/Nutritional_report.txt", text.toString());
    }

    private String nutritionalReportIndicators(){
        int[] goodChanges = new int[4], badChanges = new int[4];
        for (Student student : students){
            int bmiSepCategory = getBmiCategory(student.getBmiS());
            int bmiAprCategory = getBmiCategory(student.getBmiA());
            if (bmiSepCategory < bmiAprCategory){
                if (bmiSepCategory == 0 && bmiAprCategory == 1){
                    goodChanges[0]++; // low weight to normal weight
                }
                if (bmiSepCategory == 1 && (bmiAprCategory == 2 || bmiAprCategory == 3)){
                    badChanges[1]++; // normal weight to overweight or obesity
                }
                if (bmiSepCategory == 2 && (bmiAprCategory == 3 || bmiAprCategory == 4 )){
                    badChanges[2]++; // overweight to obesity or morbid obesity
                }
                if (bmiSepCategory == 3 && bmiAprCategory == 4){
                    badChanges[3]++; // obesity to morbid obesity
                }
            } else {
                if (bmiSepCategory == 2 && bmiAprCategory == 1){
                    goodChanges[1]++; // overweight to normal weight
                }
                if (bmiSepCategory == 3 && (bmiAprCategory == 2 || bmiAprCategory == 1)){
                    goodChanges[2]++; // obesity to overweight or normal weight
                }
                if (bmiSepCategory == 4 && (bmiAprCategory == 2 || bmiAprCategory == 1)){
                    goodChanges[3]++; // morbid weight to overweight or normal weight
                }
                if (bmiSepCategory == 1 && bmiAprCategory == 0){
                    badChanges[0]++; // normal weight to low weight
                }
            }
        }

        int goodChangesCount = 0;
        for (int goodChange : goodChanges) {
            goodChangesCount += goodChange;
        }

        int badChangesCount = 0;
        for (int badChange : badChanges){
            badChangesCount += badChange;
        }

        int changesCount = goodChangesCount + badChangesCount;

        return "\n" + changesCount + " students had change in their nutritional status.\n" +
                "\n" + goodChangesCount + " students presented a favorable change in their health, distributed as follows:\n" +
                "\n" + goodChanges[0] + " changed from low weight to normal weight." +
                "\n" + goodChanges[1] + " changed from overweight to normal weight." +
                "\n" + goodChanges[2] + " changed from obesity to overweight or normal weight." +
                "\n" + goodChanges[3] + " changed from morbid weight to overweight or normal weight.\n" +
                "\n" + badChangesCount + " students presented an unfavorable change in their health, distributed as follows:\n" +
                "\n" + badChanges[0] + " changed from normal weight to low weight." +
                "\n" + badChanges[1] + " changed from normal weight to overweight or obesity." +
                "\n" + badChanges[2] + " changed from overweight to obesity or morbid obesity." +
                "\n" + badChanges[3] + " changed from obesity to morbid obesity.\n";
    }

    private String nutritionalReportList(int filter){

        StringBuilder text = new StringBuilder("\nStudents sorted by ");
        if (filter == 1){
            text.append("BMI (april).");
        } else if (filter == 2){
            text.append("age.");
        } else {
            text.append("last name.");
        }
        text.append("\n");

        ArrayList<Student> studentsFiltered = new ArrayList<>(students);
        selectionSort(studentsFiltered, filter);
        int changesCount = 0;
        for (Student student : studentsFiltered){
            int bmiSepCategory = getBmiCategory(student.getBmiS());
            int bmiAprCategory = getBmiCategory(student.getBmiA());
            if (bmiSepCategory != bmiAprCategory){
                changesCount++;
                text.append("\n-").append(student);
            }
        }

        text.append("\nA total of ").append(changesCount).append(" students had change in their nutritional status.\n");

        return text.toString();
    }

    private void selectionSort (ArrayList<Student> list, int filter){
        for (int i = 1; i < list.size(); i++) {
            Student temp = list.get(i);
            int j;
            for (j = i - 1; j >= 0 && temp.compareTo(list.get(j), filter) < 0; j--) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, temp);
        }
    }

    public int getBmiCategoryAux(double bmi){

        return  getBmiCategory(bmi);

    }
    private int getBmiCategory(double bmi){
        if (bmi < 18.50) {
            return 0; // Category A
        } else if (bmi < 24.99) {
            return 1; // Category B
        } else if (bmi < 29.99) {
            return 2; // Category C
        } else if (bmi < 39.99) {
            return 3; // Category D
        } else {
            return 4; // Category E
        }
    }

    /*Método auxiliar usado para imprimir los resultados del método "getBmiCategoryAux"
    Para un número determinado de estudiantes y no para todos los estudiantes registrados
    Nota: Este método solo es usado para validar un test.
    */
    public  String printStudentInfoAndBmiCategories(List<Student> students, List<String> bmiCategories) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            String nombre = students.get(i).getName();
            String categoria = bmiCategories.get(i);
            result.append("Estudiante ").append(i + 1).append(": ").append(nombre)
                    .append(" - Categoría BMI Abril: ").append(categoria).append("\n");
        }

        return result.toString().trim();
    }

    public String generateHistogramAux (int count){
        return generateHistogram(count);
    }
    private String generateHistogram(int count) {
        StringBuilder bar = new StringBuilder();
        bar.append("+".repeat(Math.max(0, count)));
        return bar.toString();
    }

    public String bytesToTxTReportAux(String pathName, String text){

        return bytesToTxTReport(pathName,text);

    }
    private String bytesToTxTReport(String pathName, String text){
        File file = new File(pathName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return "Report generated!";
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