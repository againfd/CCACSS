package Dao.Impl;

import Dao.PersonDao;
import com.mysql.cj.Session;
import pojo.DBUtil;
import pojo.EchartsBean;
import pojo.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public int getTotalRecords() {
        String sql="select count(*) from cacss.person";
        DBUtil jdbc=new DBUtil();
        Connection conn=jdbc.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        int count=0;
        try{
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            if(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return count;
    }

    @Override
    public List<Person> queryPersonsByPage(int currentPage, int pageSize) {
        String sql="select * from cacss.person limit ?,?";
        DBUtil jdbc=new DBUtil();
        Connection conn=jdbc.getConnection();
        List<Person> list=new ArrayList<>();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,(currentPage-1)*pageSize);
            pstmt.setInt(2,pageSize);
            rs=pstmt.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String sex=rs.getString(3);
                int age=rs.getInt(4);
                String address=rs.getString(5);
                String tele=rs.getString(6);
                String picture=rs.getString(7);
                Person person=new Person(id,name,sex,age,address,tele,picture);
                list.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }

    @Override
    public int addPerson(Person person) {
        String sql="insert into cacss.person(name,sex,age,address,tele,picture) values (?,?,?,?,?,?)";
        DBUtil jdbc=new DBUtil();
        Connection conn=jdbc.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,person.getName());
            pstmt.setString(2,person.getSex());
            pstmt.setInt(3,person.getAge());
            pstmt.setString(4,person.getAddress());
            pstmt.setString(5,person.getTele());
            pstmt.setString(6,person.getPicture());
            row=pstmt.executeUpdate();
            System.out.println("row="+row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

    @Override
    public int updatePerson(Person person) {
        String sql="update cacss.person set name=?,sex=?,age=?,address=?,tele=?,picture=? where id=?";
        DBUtil jdbc=new DBUtil();
        Connection conn=jdbc.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,person.getName());
            pstmt.setString(2,person.getSex());
            pstmt.setInt(3,person.getAge());
            pstmt.setString(4,person.getAddress());
            pstmt.setString(5,person.getTele());
            pstmt.setString(6,person.getPicture());
            pstmt.setInt(7,person.getId());
            row=pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

    @Override
    public Person queryOnePersonById(Integer id) {
        String sql="select * from cacss.person where id=?";
        DBUtil jdbc=new DBUtil();
        Connection conn=jdbc.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Person person=null;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            if(rs.next()){
                int idd=rs.getInt(1);
                String name=rs.getString(2);
                String sex=rs.getString(3);
                int age=rs.getInt(4);
                String address=rs.getString(5);
                String tele=rs.getString(6);
                String picture=rs.getString(7);
                person=new Person(idd,name,sex,age,address,tele,picture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return person;
    }

    @Override
    public int deletePersonById(Integer id) {
        String sql="delete from cacss.person where id=?";
        DBUtil jdbc=new DBUtil();
        Connection conn=jdbc.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            row=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

    @Override
    public List<Person> getListByName(String name) {
        String sql = "select * from cacss.person where name like ?";
        Connection conn = DBUtil.getConnection();
        List<Person> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String sname = rs.getString(2);
                String sex = rs.getString(3);
                int age = rs.getInt(4);
                String address = rs.getString(5);
                String tele = rs.getString(6);
                String picture = rs.getString(7);
                Person person = new Person(id, sname, sex, age, address, tele, picture);
                list.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Person> getListByTel(String tele) {
        String sql = "select * from cacss.person where tele like ?";
        Connection conn = DBUtil.getConnection();
        List<Person> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + tele + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String sex = rs.getString(3);
                int age = rs.getInt(4);
                String address = rs.getString(5);
                String stele = rs.getString(6);
                String picture = rs.getString(7);
                Person person = new Person(id, name, sex, age, address, stele, picture);
                list.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<EchartsBean> findCountByAddress() {
        String sql="select address,COUNT(*) from cacss.person group by address";

        Connection conn=DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<EchartsBean> list=new ArrayList<>();
        try{
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                String address=rs.getString(1);
                int count=rs.getInt(2);
                EchartsBean echarts=new EchartsBean(address,count);
                list.add(echarts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }
}
