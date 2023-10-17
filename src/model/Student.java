package src.model;

public class Student implements Comparable<Student> {

    private String name;

    private String lastName;
    private int age;

    private double weightS;

    private double weightA;
    private double height;

    private double imcS;

    private double imcA;
    private String gender;

    public Student(String name, String lastName, int age, double weightS, double weightA, double height, double imcS,double imcA, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.weightS = weightS;
        this.height = height;
        this.imcS = imcS;
        this.imcA = imcA;
        this.gender = gender;
        this.weightA = weightA;
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

    public double getImcS() {
        return imcS;
    }

    public void setImcS(double imcS) {
        this.imcS = imcS;
    }

    public double getImcA() {
        return imcA;
    }

    public void setImcA(double imcA) {
        this.imcA = imcA;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", weightS=" + weightS +
                ", weightA=" + weightA +
                ", height=" + height +
                ", imcS=" + imcS +
                ", gender='" + gender + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
