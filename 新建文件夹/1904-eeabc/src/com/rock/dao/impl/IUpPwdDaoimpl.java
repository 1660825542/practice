package com.rock.dao.impl;

import com.rock.dao.IUpPwdDao;
import com.rock.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IUpPwdDaoimpl implements IUpPwdDao {


    Connection conn=JDBCUtil.getconnerction();
    String sq="update userinfo set user_password=? where userid=? and user_password=? ";
    public boolean uppwd(String userid, String password, String newpwd) {
        try {
            PreparedStatement pres=conn.prepareStatement(sq);
            pres.setString(1,newpwd);
            pres.setString(2,userid);
            pres.setString(3,password);
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