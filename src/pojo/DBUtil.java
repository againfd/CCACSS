package pojo;

import java.sql.*;

public class DBUtil {
    private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/cacss";
    public static final String DBUSER="root";
    public static final String PASSWORD="12345";

    static{
        try{
            Class.forName(DBRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt){
        try {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
