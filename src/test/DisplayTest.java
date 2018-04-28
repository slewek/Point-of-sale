import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DisplayTest {

    private Display display;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        this.display = new Display();

    }

    @Test
    void print_product() {
        setUp();
        System.setOut(new PrintStream(outContent));


        ArrayList<String> arrayList = new ArrayList<String>(){
            {
                add("PEPSI");
                add("2.30");
            }};

        display.print_product(arrayList);
        String expectedOutput  = "Name of the product:" + "PEPSI" +"\n"+
                "Price:" + "2.3";

        assertEquals(expectedOutput+System.getProperty("line.separator"), outContent.toString());

        System.setOut(System.out);

    }
}