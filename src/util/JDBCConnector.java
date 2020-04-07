package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class JDBCConnector {

    //数据库用户名
    public static final String USERNAME = "root";

    //数据库密码
    public static final String PASSWORD = "123456";

    //数据库连接地址  数据库名：zuiyou
    public static final String URL = "jdbc:mysql://localhost:3306/zuiyou??serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public JDBCConnector(){

    }


    //连接
    public void connect(){
        //驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("-----" + new Date() + ": 没有数据库驱动" + "-----");
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("-----" + new Date() + ": 数据库连接不成功" + "-----");
        }
    }

    //关闭数据库连接
    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("-----" + new Date() + ": 数据库连接关闭不成功" + "-----");
        }
    }



}
