import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_scanner {

    private BufferedReader bufferedReader;
    private String id_result;

    /** Initialize bufferReader */
    public Code_scanner() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    /** Read next line of input */
    public String read(){
        try {
            id_result = bufferedReader.readLine();
        }catch (IOException ex){
            System.out.println(ex.toString());
        }
        return id_result;
    }
}
