package com.rock.dao.impl;

import com.rock.dao.IRegisterDao;
import com.rock.entities.User;
import com.rock.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IRegisterDaoimpl implements IRegisterDao {
    Connection conn=JDBCUtil.getconnerction();
    String sq="insert into userinfo values(?,?,?,?,?,?,?,?)";
    public boolean insertUser(User user){
        try {
            PreparedStatement pres=conn.prepareStatement(sq);
            pres.setString(1,user.getUserid());
            pres.setString(2,user.getPassword());
            pres.setString(3,user.getMail());
            pres.setString(4,user.getSex());
            pres.setString(5,user.getHobby());
            pres.setString(6,user.getDegree());
            pres.setString(7,user.getQuestion());
            pres.setString(8,user.getAnswer());

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
