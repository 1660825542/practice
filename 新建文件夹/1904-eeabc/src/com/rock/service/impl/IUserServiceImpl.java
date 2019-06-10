package com.rock.service.impl;

import com.rock.dao.IUserDao;
import com.rock.dao.impl.IUserDaoimpl;
import com.rock.entities.User;
import com.rock.service.IUserService;
import com.rock.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IUserServiceImpl implements IUserService {
    private IUserDao iud=new IUserDaoimpl();
    public boolean reuser(User user){
        return  iud.result(user);
    }

    @Override
    public boolean finduserid(String userid) {
        return iud.finduserid(userid);
    }

    @Override
    public String[] findqa(String userid) {
        return iud.findqa(userid);
    }

    @Override
    public boolean revisionpwd(String userid,String password) {
        return iud.revisionpwd(userid,password);
    }

}
