

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Function {
    private Connection getConnection() throws SQLException {
        String url="jdbc:postgresql://localhost:5432/Try";
        String user="postgres";
        String password="nehoraii0556652485";

        Connection connection= DriverManager.getConnection(url,user,password);
        return connection;

    }
    private ResultSet Select() throws SQLException {

        try {
            Connection connection=getConnection();
            System.out.println("GOOD1");
            String query=
                    "select * from my_table_name;";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            //connection.close();
            return resultSet;


        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();
            return  null;
        }

    }
    public List<DataColumns> createObject(){
        try {

            ResultSet resultSet=Select();
            List<DataColumns> listObject=new ArrayList<DataColumns>();
            System.out.println("Good query");
            while (resultSet.next()){
                DataColumns dataColumns=new DataColumns();
                dataColumns.setId(resultSet.getInt("id"));
                dataColumns.setFirst_name(resultSet.getString("first_name"));
                listObject.add(dataColumns);
            }

            return listObject;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
            throw new RuntimeException(e);
        }

    }
    private void insert(String name){
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
    public void updateObject(DataColumns dataColumns,String newName,List<DataColumns> list){
        try {
            boolean flag=false;
            for (int i = 0; i <list.size() ; i++) {
                if(dataColumns.getId()==list.get(i).getId()) {
                    flag=true;
                    break;
                }
            }
            Connection con=getConnection();
            if(flag==false){
                insert(dataColumns.getFirst_name());
            }
            System.out.println("Connetiob GOOD!!!");
            String query="UPDATE \"my_table_name\"\n"+
                    "\tSET first_name=?\n"+
                    "\tWHERE first_name=?";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(2,dataColumns.getFirst_name());
            System.out.print("ID:  "+dataColumns.getId());
            System.out.println(" First Name:  "+dataColumns.getFirst_name());
            dataColumns.setFirst_name(newName);
            preparedStatement.setString(1,dataColumns.getFirst_name());
            System.out.print("ID:  "+dataColumns.getId());
            System.out.println(" First Name:  "+dataColumns.getFirst_name());
            preparedStatement.executeUpdate();
            con.close();
            System.out.println("GOOD Query");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
