package com.rock.service.impl;

import com.rock.dao.IRegisterDao;
import com.rock.dao.impl.IRegisterDaoimpl;
import com.rock.entities.User;
import com.rock.service.IRegisterService;

public class IRegisterServiceimpl  implements IRegisterService {
    public boolean register(User user){
        IRegisterDao iri=new IRegisterDaoimpl();
        return iri.insertUser(user);
    }
}
