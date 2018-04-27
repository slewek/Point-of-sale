import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    /**initialize database */
    public Database(){
        try {

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "pass";

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            String sql =
                    "CREATE TABLE SHOP " +
                            "(id INT not NULL, " +
                            " NAME VARCHAR(255) NOT NULL , " +
                            " PRICE DECIMAL(18,2) NOT NULL, " +
                            " PRIMARY KEY ( id ))";
            statement = connection.createStatement();
            statement.execute(sql);
            sql = "INSERT INTO SHOP VALUES(1,'PEPSI',2.30)";
            statement.execute(sql);
            sql = "INSERT INTO SHOP VALUES(2,'TV',999.99)";
            statement.execute(sql);
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());

        }
    }

    /**Droping the table after exiting */
    public void drop_table(){
        try {
            String sql = "DROP TABLE SHOP";
            statement = connection.createStatement();
            statement.execute(sql);

            connection.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }


    /** Check if product exists */
    public Boolean does_exist(int id){
        ArrayList<String> data =check_product(id);
        if(data.size()==0){
            return false;
        }else{
            return true;
        }
    }

    /** Check name and price of the product */
    public ArrayList<String> check_product(int id){
        ArrayList<String> data = new ArrayList<String>();

        try {
            String sql = "SELECT * FROM SHOP WHERE ID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                data.add(resultSet.getString(2));
                data.add(resultSet.getString(3));
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return data;

    }
}
