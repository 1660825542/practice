package com.rock.dao.daoimpl;

import com.rock.dao.IUserDao;
import com.rock.entities.Userinfo;
import com.rock.util.JDBCUtil;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-22 13:12:42
 */
public class IUserDaoImpl implements IUserDao {
    private JDBCUtil util = null;

    public IUserDaoImpl() {
        util = new JDBCUtil();
    }

    @Override
    public Userinfo login(String userid, String password) {
        String sql = "select * from userinfo where userid=? and password=?";
        return util.queryById(Userinfo.class, sql, userid, password);
    }

    @Override
    public void register(Userinfo u) {
        String sql="insert into userinfo values(?,?,?,?,?,?,?,?)";
        util.runSql(sql,u.getUserid(),u.getPassword(),u.getSex(),u.getHobby(),u.getQid(),u.getAnswer(),u.getDegree(),u.getRemark());
    }
}