package model;

import static org.junit.jupiter.api.Assertions.*;
import Exceptions.AgeException;
import Exceptions.HeightException;
import Exceptions.IDException;
import Exceptions.WeightException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;



public class BienestarControllerTest  {

    private BienestarController controller;

    public void setUpStage1() {

        controller = new BienestarController();
        controller.getStudents().clear();
        controller.importData();

    }

    public void setUpStage2() {

        controller = new BienestarController();
        controller.getStudents().clear();
        controller.importData();

        controller.addStudent("A00369076", "Juan", "Tobar", 23, 'M', 80, 78, 1.83);
        controller.addStudent("A00370234", "Juliana", "Parra",22,'F',55,50,1.60);
        controller.addStudent("A00356473", "Jose","Perez",24,'M', 50, 57,1.70);
        controller.addStudent("A00380345","Pablo","Blandon",20,'M',75,73,1.71);
        controller.addStudent("A00370768","Ana","Gomez",21,'F',65,66,1.70);


    }

    public void setUpStage3() {

        controller = new BienestarController();

        controller.getStudents().clear();

        controller.addStudent("A00408965", "Martina", "Perez", 18, 'F',60 , 66, 1.64);
        controller.addStudent("A00387964", "Yeison", "Rodriguez",20,'M',74,74,1.70);
        controller.addStudent("A00397065", "Camilo","Barona",19,'M',72 , 70,1.82);
        controller.addStudent("A00345231","Pedro","Aguirre",24,'M',76,76,1.78);
        controller.addStudent("A00386954","Cristina","Mendoza",21,'F',65,66,1.62);


    }


    public void setUpStage4(){

        controller = new BienestarController();

        controller.getStudents().clear();

        controller.addStudent("A00154324","Ronny","Rios",20,'M',78,78,1.80);
        controller.addStudent("A00986756","Valeria","Espinosa",23,'F',76,75,1.65);
    }


    @Test
    //Verificar el cargue del archivo csv
    public void testAddStudentsFromCvsFile() {

        setUpStage1();

        assertNotNull(controller.getStudents());

        assertEquals(34, controller.getStudents().size());

        assertEquals("Maria",controller.getStudents().get(0).getName());
        assertEquals("Karen",controller.getStudents().get(33).getName());

        assertEquals("Juan Jose",controller.getStudents().get(23).getName());

    }

    @Test
    public void testAddStudents (){

        setUpStage1();

        String student =  controller.addStudent("A00350678","Alejandro", "Arteaga",23,'M',60,62,1.78);
        String student2 = controller.addStudent("A00350678","Alejandro", "Arteaga",23,'M',60,62,1.78);

        assertEquals(controller.getStudents().get(34).getBmiA(),19.57);
        assertEquals("Student successfully registered!.",student);
        assertEquals("Error: A student with the entered ID already exists.",student2);
        assertEquals(35,controller.getStudents().size());

    }


    @Test
    public void testExceptions() {

        try {

            setUpStage1();

            controller.addStudent("A00345674", "Vanesa","Jaramillo",-3,'F', 62,66,-1.70);
            controller.addStudent("B00345674", "Miranda","Montes",23,'F', -52,66,1.70);

            controller.validateAge(controller.students.get(34).getAge());
            controller.validateHeight(controller.students.get(34).getHeight());

            controller.validateWeight(controller.getStudents().get(35).getWeightS());
            controller.validateID(controller.getStudents().get(35).getStudentCode());

        } catch (AgeException e) {

            assertEquals("Invalid age range.",e.getMessage());

        } catch (IDException e) {

            assertEquals("The code must begin with A.", e.getMessage());

        } catch (HeightException e) {

            assertEquals("Invalid height range.", e.getMessage());

        } catch (WeightException e){

            assertEquals("Invalid weight range.", e.getMessage());

        }


    }

    @Test
    public void testEditStudent(){

        setUpStage2();

        String editStudent = controller.editStudent("A00369076", "Juan", "Toledo", 23, 'M', 80, 78, 1.87);

        assertNull(controller.searchStudent("A00467589"));

        assertEquals("Juan",controller.getStudents().get(34).getName());

        assertNotEquals(1.83,controller.getStudents().get(34).getHeight());

        assertEquals("Student information successfully edited!",editStudent);

        assertEquals(22.88,controller.getStudents().get(34).getBmiS());

    }

    @Test
    public  void testEditStudent2(){

        setUpStage3();

        String[] names = {"Mara","Yeison", "Cristian", "Pedro", "Cristina"};

        String[] surname = {"Guerrero","Rodriguez", "Barrera", "Aguirre", "Mendoza"};

        int[] ages = {23,25, 19, 24, 28};

        char[] sex = {'F','O', 'M', 'M', 'F'};

        double[] weightsS= {60,72, 72, 78, 65};

        double[] weightsA= {66, 70, 75, 76, 65};

        double[] heights  = {1.74,1.71, 1.82, 1.78, 1.64};


       for (int i = 0; i <5; i++){

           String actualStudent = (controller.getStudents().get(i).getStudentCode());

           controller.editStudent(actualStudent,names[i],surname[i],ages[i],sex[i],weightsS[i],weightsA[i],heights[i]);
       }

       String expected_studentZero = """
                Code: A00408965
               Name: Martina Perez
               Age: 18
               Sex: F
               Height: 1.64
               Sep. Weight: 60.0
               Apr. weight: 66.0
               Sep. BMI: 22.31
               Apr. BMI: 24.54
               """;
       String expected_studentOne = """
                Code: A00387964
               Name: Yeison Rodriguez
               Age: 25
               Sex: O
               Height: 1.71
               Sep. Weight: 72.0
               Apr. weight: 70.0
               Sep. BMI: 24.62
               Apr. BMI: 23.94
               """ ;

       assertNotEquals(expected_studentZero,controller.getStudents().get(0).toString());

       assertEquals(expected_studentOne,controller.getStudents().get(1).toString());

       assertEquals(21.74,controller.getStudents().get(2).getBmiS());

       assertNotEquals(76,controller.getStudents().get(3).getWeightS());

       assertNotEquals(66,controller.getStudents().get(4).getWeightA());

    }


    @Test
    public void testDeleteStudent() {

        setUpStage2();

        controller.deleteStudent("A00370234");

        String studentNotFound =  controller.deleteStudent("A00354637");

        assertEquals(38,controller.getStudents().size());

        assertNull(controller.searchStudent("A00370234"));

        assertNotEquals("Juliana",controller.getStudents().get(35).getName());

        assertEquals("Error: A student with the entered ID does not exist.", studentNotFound);

    }

    @Test
    public void deleteStudent2(){

        setUpStage4();

        controller.deleteStudent("A00154324");
        controller.deleteStudent("A00986756");

        assertTrue(controller.getStudents().isEmpty());
        assertFalse(controller.getStudents().size()!=0);
    }

    /*Validación: Se validará que los usuarios se agrupen según la categoria que corresponda:

       0 = Peso bajo
       1 = Peso normal
       2 = Sobrepeso
       3 = Obesidad
       4 = Obesidad morbida

     */
    @Test
    public void testgetBmiCategory() {

        setUpStage1();

        ArrayList<String> bmiCategories = new ArrayList<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 5; i++) {

            double bmi = controller.getStudents().get(i).getBmiA();

            String category = String.valueOf(controller.getBmiCategory(bmi));

            bmiCategories.add(category);

        }

        String expected = """
                Estudiante 1: Maria - Categoría BMI Abril: 2
                Estudiante 2: Maria Carmen - Categoría BMI Abril: 1
                Estudiante 3: Carmen - Categoría BMI Abril: 2
                Estudiante 4: Josefa - Categoría BMI Abril: 2
                Estudiante 5: Ana Maria - Categoría BMI Abril: 1""";


        for (int i = 0; i < 5; i++) {

            String nombre = controller.getStudents().get(i).getName();

            String categoria = bmiCategories.get(i);

            result.append("Estudiante ").append(i + 1).append(": ").append(nombre).append(" - Categoría BMI Abril: ").append(categoria).append("\n");
        }


        String actual = result.toString().trim();

        assertEquals(expected,actual);

    }

    @Test
    public void testGenerateHistogram(){

        setUpStage1();

        int lowWeight = 0;

        int normalWeight = 0;

        int overweight = 0;

        int obesity = 0;

        int morbidObesity = 0;

        assertEquals("",controller.generateHistogram(0));

        for (int i = 0; i < 5; i++) {

            double bmi = controller.getStudents().get(i).getBmiS();

            if (bmi < 18.50) {

                lowWeight++;

            } else if (bmi < 24.99) {

                normalWeight++;

            } else if (bmi < 29.99) {

                overweight++;

            }else if (bmi < 39.99) {

                obesity++;

            }else{

                morbidObesity ++;

            }

        }


        String lowWeightH = controller.generateHistogram(lowWeight);

        String normalWeightH = controller.generateHistogram(normalWeight);

        String overweightH = controller.generateHistogram(overweight);

        String obesityH = controller.generateHistogram(obesity);

        String morbidObesityH = controller.generateHistogram(morbidObesity);


        assertEquals("", lowWeightH);

        assertEquals("+", normalWeightH);

        assertEquals("++", overweightH);

        assertEquals("++", obesityH);

        assertEquals("",morbidObesityH);

    }

    @Test
    public void testSelectionSortByAge (){

        setUpStage3();

        StringBuilder act = new StringBuilder();

        String expected = """
                Martina - Edad : 18
                Camilo - Edad : 19
                Yeison - Edad : 20
                Cristina - Edad : 21
                Pedro - Edad : 24""";


        controller.selectionSort(controller.getStudents(),2);


        for (Student student : controller.getStudents()){

            act.append(student.getName()).append(" - Edad : ").append(student.getAge()).append("\n");
        }

        String actual = act.toString().trim();

        assertEquals(expected, actual);
    }

    @Test
    public void testSelectionSortByLastName (){

        setUpStage3();

        StringBuilder result = new StringBuilder();


        String expected = """
                Pedro Aguirre
                Camilo Barona
                Cristina Mendoza
                Martina Perez
                Yeison Rodriguez""";


        controller.selectionSort(controller.getStudents(),3);


        for (Student student : controller.getStudents()){

            result.append(student.getName()).append(" ").append(student.getLastName()).append("\n");
        }

        String actual = result.toString().trim();

        assertEquals(expected, actual);

    }

    @Test
    public void testSelectionSortByBMISep (){

        setUpStage3();

        StringBuilder result = new StringBuilder();


        String expected = """
                Camilo Barona - BMI : 21.74
                Martina Perez - BMI : 22.31
                Pedro Aguirre - BMI : 23.99
                Cristina Mendoza - BMI : 24.77
                Yeison Rodriguez - BMI : 25.61""";


        controller.selectionSort(controller.getStudents(),4);


        for (Student student : controller.getStudents()){

            result.append(student.getName()).append(" ").append(student.getLastName()).append(" - BMI : ").append(student.getBmiS()).append("\n");
        }

        String actual = result.toString().trim();

        assertEquals(expected, actual);

    }

    @Test
    public void testSelectionSortByBMIApr(){

        setUpStage3();

        StringBuilder result = new StringBuilder();


        String expected = """
                Camilo Barona - BMI : 21.13
                Pedro Aguirre - BMI : 23.99
                Martina Perez - BMI : 24.54
                Cristina Mendoza - BMI : 25.15
                Yeison Rodriguez - BMI : 25.61""";


        controller.selectionSort(controller.getStudents(),1);


        for (Student student : controller.getStudents()){

            result.append(student.getName()).append(" ").append(student.getLastName()).append(" - BMI : ").append(student.getBmiA()).append("\n");
        }

        String actual = result.toString().trim();

        assertEquals(expected, actual);

    }

    @Test
    public void testNutritionalReportIndicators() {


        setUpStage1();

        ArrayList <Student> studentsOnTrial = new ArrayList<>();

        for (int i = 0; i <5 ; i++) {

            studentsOnTrial.add(controller.getStudents().get(i));

        }


        String expected = """

                3 students had change in their nutritional status.

                3 students presented a favorable change in their health, distributed as follows:

                0 changed from low weight to normal weight.
                1 changed from overweight to normal weight.
                2 changed from obesity to overweight or normal weight.
                0 changed from morbid weight to overweight or normal weight.

                0 students presented an unfavorable change in their health, distributed as follows:

                0 changed from normal weight to low weight.
                0 changed from normal weight to overweight or obesity.
                0 changed from overweight to obesity or morbid obesity.
                0 changed from obesity to morbid obesity.
                """;

        assertEquals(expected,controller.nutritionalReportIndicatorsAux(studentsOnTrial));


    }

    @Test
    public void testNutritionalReportListByBMI() {

        setUpStage3();

        String expected = """
         Students sorted by BMI (april):
                                
         - Code: A00386954
         Name: Cristina Mendoza
         Age: 21
         Sex: F
         Height: 1.62
         Sep. Weight: 65.0
         Apr. weight: 66.0
         Sep. BMI: 24.77
         Apr. BMI: 25.15
                                
         A total of 1 students had change in their nutritional status.""";

        String actual = controller.nutritionalReportList(1);
        assertEquals(expected,actual);

    }

    @Test
    public void testNutritionalReportListByBMIUnchanged() {

       setUpStage4();

        String expected = """
        Students sorted by BMI (april):
        
        A total of 0 students had change in their nutritional status.""";

        String actual = controller.nutritionalReportList(1);
        assertEquals(expected,actual);


    }

    @Test
    public void testNutritionalReportListByAge(){

        setUpStage2();

        String expected = """
                Students sorted by age:
                                
                - Code: A00380779
                Name: Maria Carmen Hernandez
                Age: 19
                Sex: F
                Height: 1.62
                Sep. Weight: 72.0
                Apr. weight: 59.0
                Sep. BMI: 27.43
                Apr. BMI: 22.48
                                
                - Code: A00380776
                Name: Maria Garcia
                Age: 20
                Sex: F
                Height: 1.72
                Sep. Weight: 97.0
                Apr. weight: 86.0
                Sep. BMI: 32.79
                Apr. BMI: 29.07
                                
                - Code: A00370864
                Name: Jose Antonio Munoz
                Age: 20
                Sex: O
                Height: 1.69
                Sep. Weight: 53.0
                Apr. weight: 52.0
                Sep. BMI: 18.56
                Apr. BMI: 18.21
                                
                - Code: A00380345
                Name: Pablo Blandon
                Age: 20
                Sex: M
                Height: 1.71
                Sep. Weight: 75.0
                Apr. weight: 73.0
                Sep. BMI: 25.65
                Apr. BMI: 24.96
                                
                - Code: A00370987
                Name: Josefa Lopez
                Age: 21
                Sex: F
                Height: 1.74
                Sep. Weight: 93.0
                Apr. weight: 88.0
                Sep. BMI: 30.72
                Apr. BMI: 29.07
                                
                - Code: A00347601
                Name: Cristina Moreno
                Age: 24
                Sex: F
                Height: 1.66
                Sep. Weight: 68.0
                Apr. weight: 69.0
                Sep. BMI: 24.68
                Apr. BMI: 25.04
                                
                - Code: A00356473
                Name: Jose Perez
                Age: 24
                Sex: M
                Height: 1.7
                Sep. Weight: 50.0
                Apr. weight: 57.0
                Sep. BMI: 17.3
                Apr. BMI: 19.72
                                
                A total of 7 students had change in their nutritional status.""";

        String actual = controller.nutritionalReportList(2);

        assertEquals(expected,actual);
    }

    @Test
    public void testNutritionalReportListByLastname(){

        setUpStage2();

        String expected = """
                Students sorted by last name:
                
                - Code: A00380345
                Name: Pablo Blandon
                Age: 20
                Sex: M
                Height: 1.71
                Sep. Weight: 75.0
                Apr. weight: 73.0
                Sep. BMI: 25.65
                Apr. BMI: 24.96
                
                - Code: A00380776
                Name: Maria Garcia
                Age: 20
                Sex: F
                Height: 1.72
                Sep. Weight: 97.0
                Apr. weight: 86.0
                Sep. BMI: 32.79
                Apr. BMI: 29.07
                                
                - Code: A00380779
                Name: Maria Carmen Hernandez
                Age: 19
                Sex: F
                Height: 1.62
                Sep. Weight: 72.0
                Apr. weight: 59.0
                Sep. BMI: 27.43
                Apr. BMI: 22.48
                
                - Code: A00370987
                Name: Josefa Lopez
                Age: 21
                Sex: F
                Height: 1.74
                Sep. Weight: 93.0
                Apr. weight: 88.0
                Sep. BMI: 30.72
                Apr. BMI: 29.07
                                
                - Code: A00347601
                Name: Cristina Moreno
                Age: 24
                Sex: F
                Height: 1.66
                Sep. Weight: 68.0
                Apr. weight: 69.0
                Sep. BMI: 24.68
                Apr. BMI: 25.04
                
                - Code: A00370864
                Name: Jose Antonio Munoz
                Age: 20
                Sex: O
                Height: 1.69
                Sep. Weight: 53.0
                Apr. weight: 52.0
                Sep. BMI: 18.56
                Apr. BMI: 18.21
                
                - Code: A00356473
                Name: Jose Perez
                Age: 24
                Sex: M
                Height: 1.7
                Sep. Weight: 50.0
                Apr. weight: 57.0
                Sep. BMI: 17.3
                Apr. BMI: 19.72
                                
                A total of 7 students had change in their nutritional status.""";

        String actual = controller.nutritionalReportList(3);

        assertEquals(expected,actual);
    }
    @Test
    public void testClassificationReportListByAge() {

        setUpStage3();

       String expected = """
                Students sorted by age:
                
                B:
                - Code: A00408965
                Name: Martina Perez
                Age: 18
                Sex: F
                Height: 1.64
                Sep. Weight: 60.0
                Apr. weight: 66.0
                Sep. BMI: 22.31
                Apr. BMI: 24.54

                - Code: A00397065
                Name: Camilo Barona
                Age: 19
                Sex: M
                Height: 1.82
                Sep. Weight: 72.0
                Apr. weight: 70.0
                Sep. BMI: 21.74
                Apr. BMI: 21.13

                - Code: A00386954
                Name: Cristina Mendoza
                Age: 21
                Sex: F
                Height: 1.62
                Sep. Weight: 65.0
                Apr. weight: 66.0
                Sep. BMI: 24.77
                Apr. BMI: 25.15

                - Code: A00345231
                Name: Pedro Aguirre
                Age: 24
                Sex: M
                Height: 1.78
                Sep. Weight: 76.0
                Apr. weight: 76.0
                Sep. BMI: 23.99
                Apr. BMI: 23.99

                C:
                - Code: A00387964
                Name: Yeison Rodriguez
                Age: 20
                Sex: M
                Height: 1.7
                Sep. Weight: 74.0
                Apr. weight: 74.0
                Sep. BMI: 25.61
                Apr. BMI: 25.61""";

        String actual = controller.classificationReportList(1, 2);

        assertEquals(expected,actual);

    }

    @Test
    public void testClassificationByLastname(){

        setUpStage3();

        String expected = """
                Students sorted by last name:
                
                B:
                - Code: A00345231
                Name: Pedro Aguirre
                Age: 24
                Sex: M
                Height: 1.78
                Sep. Weight: 76.0
                Apr. weight: 76.0
                Sep. BMI: 23.99
                Apr. BMI: 23.99

                - Code: A00397065
                Name: Camilo Barona
                Age: 19
                Sex: M
                Height: 1.82
                Sep. Weight: 72.0
                Apr. weight: 70.0
                Sep. BMI: 21.74
                Apr. BMI: 21.13

                - Code: A00386954
                Name: Cristina Mendoza
                Age: 21
                Sex: F
                Height: 1.62
                Sep. Weight: 65.0
                Apr. weight: 66.0
                Sep. BMI: 24.77
                Apr. BMI: 25.15
                
                - Code: A00408965
                Name: Martina Perez
                Age: 18
                Sex: F
                Height: 1.64
                Sep. Weight: 60.0
                Apr. weight: 66.0
                Sep. BMI: 22.31
                Apr. BMI: 24.54

                C:
                - Code: A00387964
                Name: Yeison Rodriguez
                Age: 20
                Sex: M
                Height: 1.7
                Sep. Weight: 74.0
                Apr. weight: 74.0
                Sep. BMI: 25.61
                Apr. BMI: 25.61""";

        String actual = controller.classificationReportList(1, 3);

        assertEquals(expected,actual);

    }

    @Test
    public void testClassificationReportHistogram () {

        setUpStage3();

        String act = controller.classificationReportHistogram(1);

       String expected = """
               Distribution:
               A: 0 students
               B: 4 students
               C: 1 students
               D: 0 students
               E: 0 students
               
               Histogram:
               A\s
               B ++++
               C +
               D\s
               E""";


       assertEquals(expected,act);
    }

    @Test
    public void testSearch(){

        setUpStage2();

        Student s = controller.searchStudent("A00360987");

        assertEquals(controller.getStudents().get(21).getName(),s.getName());

        assertNull(controller.searchStudent("A00897654"));

        assertNull(controller.searchStudent(""));

        assertNotNull(s);

    }
}