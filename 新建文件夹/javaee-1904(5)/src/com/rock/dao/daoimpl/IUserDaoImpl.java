package com.rock.dao.daoimpl;

import com.rock.dao.IUserDao;
import com.rock.entities.User;
import com.rock.entities.Userinfo;
import com.rock.util.JDBC;
import com.rock.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-20 14:41:33
 */
public class IUserDaoImpl implements IUserDao {
    @Override
    public User isTrue(String userid, String password) {
        Connection conn= JDBC.getConnection();
        String sql="select * from user1 where userid=? and password=?";
        try {
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,userid);
            stmt.setString(2,password);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                //合法
                User u=new User();
                u.setUserid(rs.getString("userid"));
                u.setPassword(rs.getString("password"));
                u.setAnwser(rs.getString("anwser"));
                u.setQid(rs.getString("qid"));
                u.setScore(rs.getString("score"));
                return u;
            }
            else{
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean register(Userinfo userinfo) {
        String sql="insert into userinfo(userid,password,sex,hobby,qid,answer,degree,remark) values(?,?,?,?,?,?,?,?)";

        Connection conn=JDBC.getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,userinfo.getUserid());
            stmt.setString(2,userinfo.getPassword());
            stmt.setString(3,userinfo.getSex());
            stmt.setString(4,userinfo.getHobby());
            stmt.setString(5,userinfo.getQid());
            stmt.setString(6,userinfo.getAnswer());
            stmt.setString(7,userinfo.getDegree());
            stmt.setString(8,userinfo.getRemark());

            int a=stmt.executeUpdate();
            if(a>0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePwd(String userid, String password, String newpwd) {
        String sql="update userinfo set password=? where userid=? and password=?";
        Connection conn=JDBC.getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,newpwd);
            stmt.setString(2,userid);
            stmt.setString(3,password);
            int a=stmt.executeUpdate();
            if(a>0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String queryQuestionById(String userid) {
        String sql="select a.qcontent qtxt from question a inner join userinfo b on a.qid=b.qid  where b.userid=?";
        Connection conn=JDBC.getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,userid);
            ResultSet rs=stmt.executeQuery();
            String q="";
            if(rs.next())
                q=rs.getString("qtxt");
            return q;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String queryAnswerById(String userid) {
        String sql="select answer from userinfo where userid=?";

        Connection conn=JDBC.getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,userid);
            ResultSet rs=stmt.executeQuery();
            if(rs.next())
                return rs.getString("answer");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int doPwd(String userid, String password) {
        String sql="update userinfo set password=? where userid=?";
        Connection conn=JDBC.getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,password);
            stmt.setString(2,userid);
            int a=stmt.executeUpdate();
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
