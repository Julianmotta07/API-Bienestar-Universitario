package src.ui;

import src.Exceptions.InvalidAgeException;
import src.Exceptions.InvalidHeightException;
import src.Exceptions.InvalidWeightException;
import src.model.BienestarController;

import java.util.Scanner;

public class Main {

    public static BienestarController controller ;
    public static Scanner sc;

    public Main() {
        controller = new BienestarController();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main objMain = new Main();
        objMain.menu();
    }

    public void menu(){
        int choice;
        do {
            System.out.println("--------------WELCOME TO THE MENU--------------");
            System.out.println("1: Register student............................");
            System.out.println("2: Edit student................................");
            System.out.println("3: Delete student..............................");
            System.out.println("4: Generate classification report..............");
            System.out.println("5: Generate report of nutritional change states");
            System.out.println("6: Export current state of the model...........");
            System.out.println("7: Exit........................................");
            System.out.println("-----------------------------------------------");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    registerStudent();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 2:
                    editStudent();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 3:
                    deleteStudent();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 4:
                    classificationReport();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 5:
                    nutritionalReport();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 6:
                    exportModel();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 7:
                    print();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                default:
                    System.out.println("Invalid option, try again!");
                    sc.nextLine();
            }
        } while (choice != 7);
    }

    public void registerStudent(){
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter the last name:");
        String lastname = sc.nextLine();
        System.out.println("Enter the student code:");
        String studentCode = sc.nextLine();
        boolean flag = false;
        int age = 0;
        while(!flag){
            System.out.println("Enter the age:");
            String s1 = sc.nextLine();
            try{
                age = Integer.parseInt(s1);
                controller.validateAge(age);
                flag = true;
            } catch (InvalidAgeException e) {
                System.out.println("Error: "+ e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: "+ e.getMessage());
                System.out.println("Enter numbers, not text.");
            }
        }
        flag = false;
        double height = 0;
        while(!flag){
            System.out.println("Enter the height (in meters):");
            String s2 = sc.nextLine();
            try{
                height = Double.parseDouble(s2);
                controller.validateHeight(height);
                flag = true;
            } catch (InvalidHeightException e) {
                System.out.println("Error: "+ e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: "+ e.getMessage());
                System.out.println("Enter numbers, not text.");
            }
        }
        flag = false;
        double weightS = 0;
        double weightA = 0;
        while(!flag){
            System.out.println("Enter weight of september (in kg):");
            String s3 = sc.nextLine();
            System.out.println("Enter weight of april (in kg):");
            String s4 = sc.nextLine();
            try{
                weightS = Double.parseDouble(s3);
                weightA = Double.parseDouble(s4);
                controller.validateWeight(weightS);
                controller.validateWeight(weightA);
                flag = true;
            } catch (InvalidWeightException e) {
                System.out.println("Error: "+ e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: "+ e.getMessage());
                System.out.println("Enter numbers, not text.");
            }
        }
        String msg = controller.addStudent(name, lastname, studentCode, age, height, weightS, weightA);
        System.out.println(msg);
    }

    public void editStudent(){

    }

    public void deleteStudent(){

    }

    public void classificationReport(){

    }

    public void nutritionalReport(){

    }

    public void exportModel(){

    }

    public void print(){
        controller.print();
    }

}
