package model;

import Exceptions.AgeException;
import Exceptions.HeightException;
import Exceptions.IDException;
import Exceptions.WeightException;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BienestarControllerTest extends TestCase {

    private BienestarController controller;
    public void setUpScenario1() {
        controller = new BienestarController();

    }

    public void setUpScenario2() {

        controller = new BienestarController();

        controller.addStudent("A00369076", "Juan", "Tobar", 23, 'M', 80, 78, 1.83);
        controller.addStudent("A00370234", "Juliana", "Parra",22,'F',55,50,1.60);
        controller.addStudent("A00356473", "Jose","Perez",24,'M', 50, 57,1.70);
        controller.addStudent("A00380345","Pablo","Blandon",20,'M',75,73,1.71);
        controller.addStudent("A00370768","Ana","Gomez",21,'F',65,66,1.70);


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

        for (int i = 0; i < 5; i++) {

            double bmi = controller.getStudents().get(i).getBmiA();

            String category = String.valueOf(controller.getBmiCategoryAux(bmi));
            bmiCategories.add(category);
        }


        String expected = """
                Estudiante 1: Maria - Categoría BMI Abril: 2
                Estudiante 2: Maria Carmen - Categoría BMI Abril: 1
                Estudiante 3: Carmen - Categoría BMI Abril: 2
                Estudiante 4: Josefa - Categoría BMI Abril: 2
                Estudiante 5: Ana Maria - Categoría BMI Abril: 1""";

        String actual = controller.printStudentInfoAndBmiCategories(controller.getStudents(),bmiCategories);

        assertEquals(expected,actual);
        
    }


    public void testGenerateHistogram(){

        setUpScenario1();

        int lowWeight = 0;

        int normalWeight = 0;

        int overweight = 0;

        int obesity = 0;

        int morbidObesity = 0;

        assertEquals("",controller.generateHistogramAux(0));

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


        String lowWeightH = controller.generateHistogramAux(lowWeight);

        String normalWeightH = controller.generateHistogramAux(normalWeight);

        String overweightH = controller.generateHistogramAux(overweight);

        String obesityH = controller.generateHistogramAux(obesity);

        String morbidObesityH = controller.generateHistogramAux(morbidObesity);


        assertEquals("", lowWeightH);

        assertEquals("+", normalWeightH);

        assertEquals("++", overweightH);

        assertEquals("++", obesityH);

        assertEquals("",morbidObesityH);

    }

    public void testSelection (){}

    public void testBytesToTxTReport(){

        setUpScenario1();

        String pathName = "unitTest.txt";

        String text = "This is a unit test \nAt the moment, the quality indicators are: \nError-failure density = 0.3\nReliability = 0.7\nCompleteness = 1.66";

        String actual = controller.bytesToTxTReportAux(pathName, text);

        assertEquals("Report generated!", actual);


        File file = new File(pathName);

        assertTrue(file.exists());

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            StringBuilder textFromFile = new StringBuilder();

            while ((line = reader.readLine()) != null) {

                textFromFile.append(line).append("\n");

            }

            reader.close();

        } catch (IOException e) {

            fail("Error al leer el archivo"+e.getMessage());

        } finally {

            file.delete(); //Se elimina el archivo generado, pues es solo un archivo de prueba para comparar.
        }
    }


    public void testNutritionalReport() {
    }
}