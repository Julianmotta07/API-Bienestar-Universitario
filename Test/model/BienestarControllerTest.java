package model;

import junit.framework.TestCase;

public class BienestarControllerTest extends TestCase {

    private BienestarController controller;
    public void setUpScenario1() {
        controller = new BienestarController();

    }

    public void testAddStudent() {
        setUpScenario1();
        assertEquals(controller.getStudents().size(), 33);
    }

}