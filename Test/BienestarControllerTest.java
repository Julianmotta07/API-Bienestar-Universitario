import src.model.BienestarController;

import static org.junit.Assert.*;

public class BienestarControllerTest {

        private BienestarController controller;

        public void setUpScenario1() {
            controller = new BienestarController() ;
            controller.addStudent("A00380779","Lina","Andrade",19,'F',58,56,1.57);

        }

        public void testAddStudent() {
            controller.addStudent("A00390876","Martina","Arteaga",20,'F',62,64,1.68);
            assertEquals(controller.getStudents().size(), 36);
        }

    }


