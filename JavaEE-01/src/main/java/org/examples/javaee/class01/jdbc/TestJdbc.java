package org.examples.javaee.class01.jdbc;

import java.sql.*;

public class TestJdbc {
    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String driverName = "com.mysql.jdbc.Driver";
        String sqlString = "select * from s_student_homework";
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url, "root", "12345678");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);
            while(resultSet.next()){
                String re = resultSet.getString("id");
                System.out.println(re);
            }
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "";
    }
    public static void main(String[] args){
        getMysql();
    }
}
