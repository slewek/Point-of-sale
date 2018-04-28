import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DatabaseTest {

    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;
    @Mock private Database mockDB;
    Database dbConnection;


    @Before
    public void setUp() {
        mockDB = mock(Database.class);
        dbConnection = new Database();


    }


    @Test
    public void test_does_exist_false(){
        setUp();
        Mockito.when(mockDB.does_exist(10)).thenReturn(false);
        Boolean state = dbConnection.does_exist(10);
        assertEquals(state,false);

    }



    @Test
    public void test_check_product_corect(){
        setUp();

        ArrayList<String> arrayList = new ArrayList<String>(){
            {
                add("PEPSI");
                add("2.30");
            }};
        Mockito.when(mockDB.check_product(1)).thenReturn(arrayList);
        ArrayList<String> data = dbConnection.check_product(1);
        Assert.assertTrue(arrayList.equals(data));

    }

    @Test
    public void test_check_product_false(){
        setUp();

        ArrayList<String> arrayList = new ArrayList<String>();
        Mockito.when(mockDB.check_product(10)).thenReturn(arrayList);
        ArrayList<String> data = dbConnection.check_product(10);
        Assert.assertTrue(arrayList.equals(data));

    }



}

