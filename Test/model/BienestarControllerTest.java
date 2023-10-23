package model;

import Exceptions.AgeException;
import Exceptions.HeightException;
import Exceptions.IDException;
import Exceptions.WeightException;
import junit.framework.TestCase;

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

        assertEquals(38,controller.getStudents().size());

        assertNull(controller.searchStudent("A00370234"));

        assertNotSame("Juliana",controller.getStudents().get(35).getName());

    }
}