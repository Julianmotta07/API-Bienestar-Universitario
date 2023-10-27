package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.TestCase;

public class DataWriterTest extends TestCase {

    private DataWriter dataWriter;

    public void setUpScenario1() {

        dataWriter = new DataWriter();

    }

    public void testBytesToTxTReport(){

        setUpScenario1();

        String pathName = "unitTest.txt";

        String text = "This is a unit test \nAt the moment, the quality indicators are: \nError-failure density = 0.3\nReliability = 0.7\nCompleteness = 1.66";

        String actual = dataWriter.bytesToTxTReport(pathName, text);

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


}
