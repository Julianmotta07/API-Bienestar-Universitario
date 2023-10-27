package model;

import Exceptions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BienestarController {

    ArrayList<Student> students;
    private final String GSON_FILE_NAME = "data/students.json";
    private final String CSV_FILE_NAME = "data/freshman_kgs.csv";
    private final DataReader reader;
    private final DataWriter writer;

    public BienestarController() {
        students = new ArrayList<>();
        reader = new DataReader();
        writer = new DataWriter();
        File file = new File(GSON_FILE_NAME);
        if (file.exists()) {
            reader.readGsonStudentsFile(GSON_FILE_NAME, students);
        }
    }

    public String addStudent(String studentCode, String name, String lastName, int age, char sex, double weightS, double weightA, double height){
        String msg = "Error: A student with the entered ID already exists.";
        if (searchStudent(studentCode) == null){
            BigDecimal decimalS = new BigDecimal(weightS / (height * height));
            decimalS = decimalS.setScale(2, RoundingMode.HALF_UP);
            double bmiS = decimalS.doubleValue();
            BigDecimal decimalsA = new BigDecimal(weightA / (height * height));
            decimalsA = decimalsA.setScale(2, RoundingMode.HALF_UP);
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
            decimalS = decimalS.setScale(2, RoundingMode.HALF_UP);
            student.setBmiS(decimalS.doubleValue());
            BigDecimal decimalA = BigDecimal.valueOf(student.getWeightA() / (h * h));
            decimalA = decimalA.setScale(2, RoundingMode.HALF_UP);
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

    public String classificationReport(int mode, int filter) {

        StringBuilder text = new StringBuilder("Variables:\n\n -Category A: low weight\n -Category B: normal weight\n -Category C: overweight\n -Category D: obesity\n -Category E: morbid obesity\n");

        text.append("\n============================\n");
        text.append("   SEPTEMBER 2022 REPORT        ");
        text.append("\n============================\n");

        if (mode == 2){
            text.append(classificationReportHistogram(1));
        } else {
            text.append(classificationReportList(1, filter));
        }

        text.append("\n============================\n");
        text.append("     APRIL 2023 REPORT          ");
        text.append("\n============================\n");

        if (mode == 2){
            text.append(classificationReportHistogram(2));
        } else {
            text.append(classificationReportList(2, filter));
        }

        return writer.bytesToTxTReport("data/Classification_report.txt", text.toString());
    }

    public String classificationReportHistogram(int month){

        int[] categoryCounts = new int[5];

        for (Student student : students) {
            int bmiCategory = (month == 1) ? getBmiCategory(student.getBmiS()) : getBmiCategory(student.getBmiA());
            categoryCounts[bmiCategory]++;
        }

        String[] category = {"A", "B", "C", "D", "E"};

        StringBuilder text = new StringBuilder("\nDistribution:\n");

        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(": ").append(categoryCounts[i]).append(" students\n");
        }

        text.append("\nHistogram:\n");
        for (int i = 0; i < categoryCounts.length; i++) {
            text.append(category[i]).append(" ").append(generateHistogram(categoryCounts[i])).append("\n");
        }

        return text.toString().trim();
    }


    public String classificationReportList(int month, int filter){

        StringBuilder text = new StringBuilder("\nStudents sorted by ");
        if (filter == 1){
            text.append("BMI ").append(month == 1 ? "September" : "April");
        } else if (filter == 2){
            text.append("age");
        } else {
            text.append("last name");
        }
        text.append(":\n");

        ArrayList<Student> studentsFiltered = new ArrayList<>(students);
        selectionSort(studentsFiltered, filter == 1 ? ((month == 1) ? 4 : 1) : filter);

        String[] category = {"\nA:", "\nB:", "\nC:", "\nD:", "\nE:"};

        for (Student student : studentsFiltered){
            int bmiCategory = (month == 1) ? getBmiCategory(student.getBmiS()) : getBmiCategory(student.getBmiA());
            category[bmiCategory] += "\n-" + student;
        }

        for (String s : category) {
            if (s.length() > 3){
                text.append(s);
            }
        }

        return text.toString();
    }

    public String nutritionalReport(int mode, int filter){

        StringBuilder text = new StringBuilder();
        text.append("====================================================================================\n");
        text.append("                           CHANGES IN NUTRITIONAL STATUS                                ");
        text.append("\n====================================================================================\n");

        if (mode == 1) {
            text.append(nutritionalReportList(filter));
        } else {
            text.append(nutritionalReportIndicators(students));
        }

        text.append("\n====================================================================================");

        return writer.bytesToTxTReport("data/Nutritional_report.txt", text.toString());
    }

    public String nutritionalReportIndicatorsAux(ArrayList<Student> students){
        return nutritionalReportIndicators(students);
    }

    private String nutritionalReportIndicators(ArrayList<Student> students){
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

    public String nutritionalReportList(int filter){

        StringBuilder text = new StringBuilder("\nStudents sorted by ");
        if (filter == 1){
            text.append("BMI (april)");
        } else if (filter == 2){
            text.append("age");
        } else {
            text.append("last name");
        }
        text.append(":\n");

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

    public void selectionSort (ArrayList<Student> list, int filter){
        for (int i = 1; i < list.size(); i++) {
            Student temp = list.get(i);
            int j;
            for (j = i - 1; j >= 0 && temp.compareTo(list.get(j), filter) < 0; j--) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, temp);
        }
    }

    public int getBmiCategory(double bmi){
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

    public String generateHistogram(int count) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < count; i++) {
            bar.append("+");
        }
        return bar.toString();
    }

    public String importData(){
        reader.importStudentsData(CSV_FILE_NAME, students);
        return "Data from csv imported!.";

    }

    public String exportData(){
        writer.writeGsonStudentsFile(GSON_FILE_NAME, students);
        return "Model exported!.";
    }

    public void print(){
        for (Student student: students) {
            System.out.println(student.toString());
            System.out.println();
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

}