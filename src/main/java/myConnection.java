

import java.sql.*;

public class myConnection {


    private Connection getConnection() throws SQLException {
        String url="jdbc:postgresql://localhost:5432/Try";
        String user="postgres";
        String password="nehoraii0556652485";

        Connection connection=DriverManager.getConnection(url,user,password);
        return connection;

    }
    public ResultSet Select() throws SQLException {

        try {
            Connection connection=getConnection();
            System.out.println("GOOD1");
            String query=
                    "select * from my_table_name;";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            connection.close();
            return resultSet;


        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();
            return  null;
        }

    }
    public void  veiwTable(String colum){
        try {
            String query="SELECT "+colum+" FROM my_table_name";
            Connection connection=getConnection();
            System.out.println("There is connection");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            System.out.println("Query is working!!!");
            while (resultSet.next()){
                System.out.print(" Name:  "+resultSet.getString("first_name")+"\n");
                System.out.print("ID:  "+resultSet.getInt("id"));
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }

    }
    public void insert(String name){
        Connection connection= null;
        try {
            String query="INSERT INTO my_table_name(first_name)"+
                    "VALUES (?)";
            connection = getConnection();
            System.out.println("connection good");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);
            statement.executeUpdate();
            System.out.println("query Good!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   /* public void update(String nameUpdate,int ConditionID){
        try {
            String qw= Integer.toString(ConditionID);
            String query=String.format("UPDATE \"my_table_name\""+
                    "SET first_name='%s'"+
                    "WHERE id= %s;",nameUpdate,Integer.toString(ConditionID));

            Connection connection=getConnection();
            System.out.println("connection good");
            Statement statement=connection.createStatement();
            int resultSet=statement.executeUpdate(query);
            System.out.println("query Good!");
            System.out.println("re:  "+resultSet);
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    */

    public void update(String nameUpdate,int ConditionID,String colom){//with??????????????????????????????????????
        try {
            Connection connection=getConnection();
            System.out.println("connection good");
            String qw= Integer.toString(ConditionID);
            String query="UPDATE \"my_table_name\"\n"+
                    "\tSET "+colom+"=?\n"+
                    "\tWHERE id= ?";

            PreparedStatement statement=connection.prepareStatement(query);

            System.out.println("query Good!");
            statement.setString(1,nameUpdate);
            statement.setInt(2,ConditionID);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
