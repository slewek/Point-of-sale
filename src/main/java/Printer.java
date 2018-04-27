import java.io.*;
import java.util.ArrayList;

public class Printer {
    private ArrayList<String> names;
    private ArrayList<Float> prices;
    private OutputStream outputStream;
    private Writer outputStreamWriter;
    private Float sum;

    /** Initialize arrayList of names and prices,
     * set OutputSteramWriter */
    public Printer(){
        names = new ArrayList<String>();
        prices = new ArrayList<Float>();
        try {
            outputStream = new FileOutputStream("printer.txt");
            outputStreamWriter = new OutputStreamWriter(outputStream);
        }catch (FileNotFoundException ex){
            System.out.println(ex.toString());
        }
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public void setPrices(ArrayList<Float> prices) {
        this.prices = prices;
    }

    public Float getSum() {
        return sum;
    }


    /** Print list of all scanned products
     * and sum price */
    public void print(){
        try {
            sum=0.0F;
            for (int i=0;i<names.size();i++) {
                sum+=prices.get(i);
                outputStreamWriter.write("Product: " + names.get(i) + " Price: " + prices.get(i) + "\n");
            }
            outputStreamWriter.write("SUM: " + sum);
            outputStreamWriter.close();
        }catch (IOException ex){
        }
    }
}
