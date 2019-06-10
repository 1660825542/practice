package com.rock.serivce.serviceimpl;

import com.rock.dao.IUserDao;
import com.rock.dao.daoimpl.IUserDaoImpl;
import com.rock.entities.User;
import com.rock.entities.Userinfo;
import com.rock.serivce.IUserService;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-20 14:40:10
 */
public class IUserServiceImpl implements IUserService {
    private IUserDao iUserDao=null;
    public IUserServiceImpl(){
        iUserDao=new IUserDaoImpl();
    }
    @Override
    public User login(User user) {
        return iUserDao.isTrue(user.getUserid(),user.getPassword());
    }

    @Override
    public boolean register(Userinfo userinfo) {
        return iUserDao.register(userinfo);
    }

    @Override
    public boolean updatePassword(String userid, String password, String newpwd) {
       return iUserDao.updatePwd(userid,password,newpwd);
    }

    @Override
    public String queryQuestionById(String userid) {
        return iUserDao.queryQuestionById(userid);
    }

    @Override
    public boolean judgeUser(String answer, String userid) {
        String answerFromDB=iUserDao.queryAnswerById(userid);
        System.out.println(answerFromDB+"\t"+answer+"\t"+userid);
        if(answer.equals(answerFromDB))
            return true;
        return false;
    }

    @Override
    public int doPwd(String userid, String password) {
        return iUserDao.doPwd(userid,password);
    }
}
