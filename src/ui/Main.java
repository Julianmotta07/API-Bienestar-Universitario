package ui;

import Exceptions.*;
import model.BienestarController;
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
            System.out.println("---WELCOME TO THE MENU---");
            System.out.println("1: Register student......");
            System.out.println("2: Edit student..........");
            System.out.println("3: Delete student........");
            System.out.println("4: Generate report.......");
            System.out.println("5: Import data...........");
            System.out.println("6: Save data.............");
            System.out.println("7: Exit..................");
            System.out.println("-------------------------");
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
                    generateReport();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 5:
                    importData();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 6:
                    exportModel();
                    System.out.println("Press Enter to return to the menu...");
                    sc.nextLine();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid option, try again!");
                    sc.nextLine();
            }
        } while (choice != 7);
    }

    public void registerStudent(){
        boolean flag = false;
        String studentCode = null;
        while(!flag){
            System.out.println("Enter student code:");
            studentCode = sc.nextLine();
            try{
                controller.validateID(studentCode);
                flag = true;
            } catch (IDException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter the last name:");
        String lastname = sc.nextLine();
        flag = false;
        int age = 0;
        while(!flag){
            System.out.println("Enter the age:");
            String input = sc.nextLine();
            try{
                age = Integer.parseInt(input);
                controller.validateAge(age);
                flag = true;
            } catch (AgeException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numbers, not text.\n");
            }
        }
        flag = false;
        int sexOpt = 1;
        while (!flag){
            System.out.println("Select sex: \n 1: Male \n 2: Female");
            String input = sc.nextLine();
            try {
                sexOpt = Integer.parseInt(input);
                if (sexOpt == 1 || sexOpt == 2){
                    flag = true;
                } else {
                    System.out.println("Error: Enter 1 or 2.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numbers, not text.\n");
            }
        }
        flag = false;
        double height = 0;
        while(!flag){
            System.out.println("Enter the height (in meters):");
            String input = sc.nextLine();
            try{
                height = Double.parseDouble(input);
                controller.validateHeight(height);
                flag = true;
            } catch (HeightException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numbers, not text.\n");
            }
        }
        flag = false;
        double weightS = 0;
        while(!flag){
            System.out.println("Enter weight of september (in kg):");
            String input = sc.nextLine();
            try{
                weightS = Double.parseDouble(input);
                controller.validateWeight(weightS);;
                flag = true;
            } catch (WeightException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numbers, not text.\n");
            }
        }
        flag = false;
        double weightA = 0;
        while(!flag){
            System.out.println("Enter weight of april (in kg):");
            String input = sc.nextLine();
            try{
                weightA = Double.parseDouble(input);
                controller.validateWeight(weightA);
                flag = true;
            } catch (WeightException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numbers, not text.\n");
            }
        }
        String msg = controller.addStudent(studentCode, name, lastname, age, sexOpt == 1 ? 'M' : 'F', weightS, weightA, height);
        System.out.println(msg);
    }

    public void editStudent(){
        String list = controller.showStudentList();
        System.out.println(list);
        System.out.println("Enter student code:");
        String studentCode = sc.nextLine();
        if (controller.searchStudent(studentCode) == null){
            System.out.println("Error: A student with the entered ID does not exist.");
        } else {
            String name = null, lastName = null;
            double weightS = 0, weightA = 0, height = 0;
            char sex = 'N';
            int age = 0;
            System.out.println("Write the letters of the items to change:");
            System.out.println(" a. Name\n b. Last name\n c. Age\n d. Sex\n e. September weight\n f. April weight\n g. Height");
            String[] input = sc.nextLine().split(" ");
            for (String s : input) {
                char letter = s.charAt(0);
                boolean flag = false;
                switch (letter) {
                    case 'a' -> {
                        System.out.println("Enter the new name:");
                        name = sc.nextLine();
                    }
                    case 'b' -> {
                        System.out.println("Enter the new last name:");
                        lastName = sc.nextLine();
                    }
                    case 'c' -> {
                        while (!flag) {
                            System.out.println("Enter the new age:");
                            String inp = sc.nextLine();
                            try {
                                age = Integer.parseInt(inp);
                                controller.validateAge(age);
                                flag = true;
                            } catch (AgeException e) {
                                System.out.println("Error: " + e.getMessage() + "\n");
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Enter numbers, not text.\n");
                            }
                        }
                    }
                    case 'd' -> {
                        while (!flag) {
                            System.out.println("Select new sex: \n 1: Male \n 2: Female");
                            String inp = sc.nextLine();
                            try {
                                int sexOpt = Integer.parseInt(inp);
                                if (sexOpt == 1) {
                                    sex = 'M';
                                    flag = true;
                                } else if (sexOpt == 2){
                                    sex = 'F';
                                    flag = true;
                                } else {
                                    System.out.println("Error: Enter 1 or 2.\n");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Enter numbers, not text.\n");
                            }
                        }
                    }
                    case 'e' -> {
                        while (!flag) {
                            System.out.println("Enter the new weight of september (in kg):");
                            String inp = sc.nextLine();
                            try {
                                weightS = Double.parseDouble(inp);
                                controller.validateWeight(weightS);
                                flag = true;
                            } catch (WeightException e) {
                                System.out.println("Error: " + e.getMessage() + "\n");
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Enter numbers, not text.\n");
                            }
                        }
                    }
                    case 'f' -> {
                        while (!flag) {
                            System.out.println("Enter the new weight of april (in kg):");
                            String inp = sc.nextLine();
                            try {
                                weightA = Double.parseDouble(inp);
                                controller.validateWeight(weightA);
                                flag = true;
                            } catch (WeightException e) {
                                System.out.println("Error: " + e.getMessage() + "\n");
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Enter numbers, not text.\n");
                            }
                        }
                    }
                    case 'g' -> {
                        while (!flag) {
                            System.out.println("Enter the new height (in meters):");
                            String inp = sc.nextLine();
                            try {
                                height = Double.parseDouble(inp);
                                controller.validateHeight(height);
                                flag = true;
                            } catch (HeightException e) {
                                System.out.println("Error: " + e.getMessage() + "\n");
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Enter numbers, not text.\n");
                            }
                        }
                    }
                }
            }
            String msg = controller.editStudent(studentCode, name, lastName, age, sex, weightS, weightA, height);
            System.out.println(msg);
        }
    }

    public void deleteStudent(){
        String list = controller.showStudentList();
        System.out.println(list);
        System.out.println("Enter student code:");
        String studentCode = sc.nextLine();
        String msg = controller.deleteStudent(studentCode);
        System.out.println(msg);
    }

    public void generateReport() {
        boolean flag = false;
        int reportType = 0;
        while (!flag) {
            System.out.println("Select report type:\n 1. Classification Report\n 2. Nutritional Report");
            String inp = sc.nextLine();
            try {
                reportType = Integer.parseInt(inp);
                if (reportType == 1 || reportType == 2) {
                    flag = true;
                } else {
                    System.out.println("Error: Enter 1 or 2.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numbers, not text.\n");
            }
        }

        int mode = 0;
        flag = false;
        while (!flag) {
            System.out.print("Select mode:\n 1. List\n 2. ");
            if (reportType == 1){
                System.out.println("Histogram");
            } else {
                System.out.println("Indicators");
            }
            String inp = sc.nextLine();
            try {
                mode = Integer.parseInt(inp);
                if (mode == 1 || mode == 2) {
                    flag = true;
                } else {
                    System.out.println("Error: Enter 1 or 2.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter numbers, not text.\n");
            }
        }

        flag = false;
        int filter = 0;
        if (mode == 1){
            while (!flag) {
                System.out.println("Select filter:\n 1. BMI\n 2. Age\n 3. Last name");
                String inp = sc.nextLine();
                try {
                    filter = Integer.parseInt(inp);
                    if (filter == 1 || filter == 2 || filter == 3) {
                        flag = true;
                    } else {
                        System.out.println("Error: Enter 1, 2 or 3.\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Enter numbers, not text.\n");
                }
            }
        }

        String msg = reportType == 1 ? controller.classificationReport(mode, filter) : controller.nutritionalReport(mode, filter);
        System.out.println(msg);
    }

    public void importData(){
        String msg = controller.importData();
        System.out.println(msg);
    }

    public void exportModel(){
        String msg = controller.exportData();
        System.out.println(msg);
    }

}