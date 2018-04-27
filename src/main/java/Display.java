import java.util.ArrayList;

public class Display {
    private ArrayList<String> name;
    private ArrayList<Float> price;

    /** Initialize arrayList of names and prices */
    public Display(){
        name = new ArrayList<String>();
        price = new ArrayList<Float>();

    }
    /** Print product's name and price  */
    public void print_product(ArrayList<String> data){

        name.add(data.get(0));
        price.add(Float.parseFloat(data.get(1)));
        System.out.println("Name of the product:" + name.get(name.size()-1) +"\n"+
                "Price:" + price.get(price.size()-1));
    }

    /** Calculate sum prices of all scanned products */
    public void print_sum(Float sum){
        System.out.println("SUM: " + sum);
    }

    public void not_found(){
        System.out.println("Product not found");
    }
    public void invalid(){
        System.out.println("Invalid bar-code");
    }

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<Float> getPrice() {
        return price;
    }
}
