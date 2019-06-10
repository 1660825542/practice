package com.rock.service.impl;

import com.rock.dao.IUpPwdDao;
import com.rock.dao.impl.IUpPwdDaoimpl;
import com.rock.service.IUpPwdService;

public class IUpPwdServiceimpl implements IUpPwdService {

    @Override
    public boolean uppwd(String userid, String password, String newpwd) {
        IUpPwdDao iupd=new IUpPwdDaoimpl();
        return iupd.uppwd(userid,password,newpwd);
    }
}
