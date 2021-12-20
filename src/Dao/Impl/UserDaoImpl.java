package Dao.Impl;

import Dao.UserDao;
import pojo.DBUtil;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User queryOneUser(User user) {
        String sql="select * from cacss.user where username=? and password=? and role=?";
        User u=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            DBUtil jdbc=new DBUtil();
            conn=jdbc.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getRole());
            rs=pstmt.executeQuery();
            if(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String pass=rs.getString(3);
                String role=rs.getString(4);

                u=new User(id,name,pass,role);
                System.out.println(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(conn,pstmt,rs);
        return u;
    }

    @Override
    public int insertUser(User user) {
        String sql="INSERT INTO cacss.user (username,password,role) values (?,?,?)";
        DBUtil jdbc=new DBUtil();
        Connection conn=jdbc.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getRole());
            row=pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public boolean queryUserByUsername(String username) {
        String sql="select * from cacss.user where username=?";

        Connection conn=DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        User user=null;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs=pstmt.executeQuery();

            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return false;
    }
}
