import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Database database = new Database();
        Display display = new Display();

        Code_scanner codescanner = new Code_scanner();


        while(true) {
            //scan product
            String id_scanner = codescanner.read();

            //invalid bar-code
            if(id_scanner.equals("")){
                display.invalid();
            }
            //exit the program
            else if(id_scanner.equals("exit")){
                Printer printer = new Printer();
                printer.setNames(display.getName());
                printer.setPrices(display.getPrice());
                printer.print();
                display.print_sum(printer.getSum());
                break;
            }

            //correct bar-code
            else {
                int id = Integer.parseInt(id_scanner);

                //bar-code exists in database
                if (database.does_exist(id)) {
                    ArrayList<String> data = database.check_product(id);
                    display.print_product(data);
                }
                //bar-code not found
                else {
                    display.not_found();
                }
            }
        }


        //cleaning
        database.drop_table();






    }
}
