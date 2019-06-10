package com.rock.dao.impl;

import com.rock.dao.IUserDao;
import com.rock.entities.User;
import com.rock.service.IUserService;
import com.rock.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IUserDaoimpl implements IUserDao {


    Connection conn=JDBCUtil.getconnerction();

    public boolean result(User user){
        try {
            String sq="select * from userinfo where userid=? and user_password=?";
            PreparedStatement pres=conn.prepareStatement(sq);
            pres.setString(1,user.getUserid());
            pres.setString(2,user.getPassword());
            ResultSet rs=pres.executeQuery();
            if (rs.next())
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean finduserid(String userid) {
        try {
            String sq="select * from userinfo where userid=?";
            PreparedStatement pres=conn.prepareStatement(sq);
            pres.setString(1,userid);
            ResultSet rs=pres.executeQuery();
            if (rs.next())
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String[] findqa(String userid) {
        String []s=new String[2];
        try {
            String sq="select * from userinfo where userid=?";
            PreparedStatement pres=conn.prepareStatement(sq);
            pres.setString(1,userid);
            ResultSet rs=pres.executeQuery();
            if (rs.next())
            {
                s[0]=rs.getString("question");
                s[1]=rs.getString("answer");
                return s;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean revisionpwd(String userid,String password) {
        try {
            String sq="update userinfo set user_password=? where userid=?  ";
            PreparedStatement pres=conn.prepareStatement(sq);

            pres.setString(2,userid);
            pres.setString(1,password);
            int s=pres.executeUpdate();
            if (s>0)
            {
                return true;
            }
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
