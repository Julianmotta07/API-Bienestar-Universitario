package model;

import Exceptions.AgeException;
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

    public void testAddStudentsWithFailes() throws AgeException {

        setUpScenario1();




    }

    public void testEditStudent(){

      setUpScenario2();

      String editStudent = controller.editStudent("A00369076", "Juan", "Toledo", 23, 'M', 80, 78, 1.87);

      String editStudent2 = controller.editStudent("A00467589", "Juan", "Toledo", 23, 'M', 80, 78, 1.87);

      assertEquals("Student information successfully edited!",editStudent);
      assertEquals("The student is not registered in the system\nEnter an existing student in the system and try again.",editStudent2);

    }


}