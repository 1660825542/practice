package com.rock.service.serviceimpl;

import com.rock.dao.IUserDao;
import com.rock.dao.daoimpl.IUserDaoImpl;
import com.rock.entities.Userinfo;
import com.rock.service.IUserService;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-22 13:07:28
 */
public class IUserServiceImpl implements IUserService {
    private IUserDao iUserDao=null;
    public IUserServiceImpl(){
        //dao:data access object;
        iUserDao=new IUserDaoImpl();
    }
    @Override
    public Userinfo login(String userid, String password) {
        return iUserDao.login(userid,password);
    }

    @Override
    public void register(Userinfo userinfo) {
        iUserDao.register(userinfo);
    }
}
