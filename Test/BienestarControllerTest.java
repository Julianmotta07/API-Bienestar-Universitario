
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.model.BienestarController;


public class BienestarControllerTest {


        private BienestarController controller;

        public void setUpScenario1() {

            controller = new BienestarController() ;

            controller.addStudent("A00380779","Lina","Andrade",19,'F',58,56,1.57);

        }

        @Test
        public void testAddStudent() {

            setUpScenario1();

            controller.addStudent("A00390876","Martina","Arteaga",20,'F',62,64,1.68);
            Assertions.assertEquals(controller.getStudents().size(), 36);
        }



    }


