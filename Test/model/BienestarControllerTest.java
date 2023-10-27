package model;

import Exceptions.AgeException;
import Exceptions.HeightException;
import Exceptions.IDException;
import Exceptions.WeightException;
import junit.framework.TestCase;
import java.util.ArrayList;

public class BienestarControllerTest extends TestCase {

    private BienestarController controller;

    public void setUpScenario1() {

        controller = new BienestarController();
        controller.getStudents().clear();
        controller.importData();

    }

    public void setUpScenario2() {

        controller = new BienestarController();
        controller.getStudents().clear();
        controller.importData();

        controller.addStudent("A00369076", "Juan", "Tobar", 23, 'M', 80, 78, 1.83);
        controller.addStudent("A00370234", "Juliana", "Parra",22,'F',55,50,1.60);
        controller.addStudent("A00356473", "Jose","Perez",24,'M', 50, 57,1.70);
        controller.addStudent("A00380345","Pablo","Blandon",20,'M',75,73,1.71);
        controller.addStudent("A00370768","Ana","Gomez",21,'F',65,66,1.70);


    }

    public void setUpScenario3() {

        controller = new BienestarController();

        controller.getStudents().clear();

        controller.addStudent("A00408965", "Martina", "Perez", 18, 'F',60 , 66, 1.64);
        controller.addStudent("A00387964", "Yeison", "Rodriguez",20,'M',74,74,1.70);
        controller.addStudent("A00397065", "Camilo","Barona",19,'M',72 , 70,1.82);
        controller.addStudent("A00345231","Pedro","Aguirre",24,'M',76,76,1.78);
        controller.addStudent("A00386954","Cristina","Mendoza",21,'F',65,66,1.62);


    }


    //Verificar el cargue del archivo csv
    public void testAddStudentsFromCvsFile() {

        setUpScenario1();

        assertNotNull(controller.getStudents());
        assertEquals(34, controller.getStudents().size());
        assertEquals("Maria",controller.getStudents().get(0).getName());

    }

    public void testAddStudents (){

        setUpScenario1();

        String student =  controller.addStudent("A00350678","Alejandro", "Arteaga",23,'M',60,62,1.78);
        String student2 = controller.addStudent("A00350678","Alejandro", "Arteaga",23,'M',60,62,1.78);

        assertEquals(controller.getStudents().get(34).getBmiA(),19.57);
        assertEquals("Student successfully registered!.",student);
        assertEquals("Error: A student with the entered ID already exists.",student2);
        assertEquals(35,controller.getStudents().size());

    }

    public void testExceptions() {

        try {

            setUpScenario1();

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

    public void testEditStudent(){

        setUpScenario2();

        String editStudent = controller.editStudent("A00369076", "Juan", "Toledo", 23, 'M', 80, 78, 1.87);

        assertNull(controller.searchStudent("A00467589"));

        assertEquals("Juan",controller.getStudents().get(34).getName());

        assertNotSame(1.83,controller.getStudents().get(34).getHeight());

        assertEquals("Student information successfully edited!",editStudent);

        assertEquals(22.88,controller.getStudents().get(34).getBmiS());

    }


    public void testDeleteStudent() {

        setUpScenario2();

        controller.deleteStudent("A00370234");
        String studentNotFound =  controller.deleteStudent("A00354637");

        assertEquals(38,controller.getStudents().size());

        assertNull(controller.searchStudent("A00370234"));

        assertNotSame("Juliana",controller.getStudents().get(35).getName());

        assertEquals("Error: A student with the entered ID does not exist.", studentNotFound);

    }

    /*Validación: Se validará que los usuarios se agrupen según la categoria que corresponda:

       0 = Peso bajo
       1 = Peso normal
       2 = Sobrepeso
       3 = Obesidad
       4 = Obesidad morbida

     */
    public void testgetBmiCategory() {

        setUpScenario1();

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


    public void testGenerateHistogram(){

        setUpScenario1();

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

    public void testSelectionSortByAge (){

        setUpScenario3();

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

    public void testSelectionSortByLastName (){

        setUpScenario3();

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

    public void testSelectionSortByBMI (){

        setUpScenario3();

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

    public void testNutritionalReportIndicators() {


        setUpScenario1();

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

    public void testNutritionalReportListAux() {

        setUpScenario3();

        assertNull(controller.nutritionalReportList(2));
    }
}