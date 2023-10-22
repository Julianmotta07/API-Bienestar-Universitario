package model;

public class Student implements Comparable<Student> {

    private String studentCode;
    private String name;
    private String lastName;
    private int age;
    private char sex;
    private double weightS;
    private double weightA;
    private double height;
    private double bmiS;
    private double bmiA;


    public Student(String studentCode, String name, String lastName, int age, char sex, double weightS, double weightA, double height, double bmiS,double bmiA) {
        this.studentCode = studentCode;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.weightS = weightS;
        this.weightA = weightA;
        this.height = height;
        this.bmiS = bmiS;
        this.bmiA = bmiA;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getWeightS() {
        return weightS;
    }

    public void setWeightS(double weightS) {
        this.weightS = weightS;
    }

    public double getWeightA() {
        return weightA;
    }

    public void setWeightA(double weightA) {
        this.weightA = weightA;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmiS() {
        return bmiS;
    }

    public void setBmiS(double bmiS) {
        this.bmiS = bmiS;
    }

    public double getBmiA() {
        return bmiA;
    }

    public void setBmiA(double bmiA) {
        this.bmiA = bmiA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", weightS=" + weightS +
                ", weightA=" + weightA +
                ", height=" + height +
                ", bmiS=" + bmiS +
                ", bmiA=" + bmiA +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
