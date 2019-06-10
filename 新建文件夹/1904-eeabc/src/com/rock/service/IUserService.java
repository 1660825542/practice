package com.rock.service;

import com.rock.entities.User;

public interface IUserService {
    public boolean reuser(User user);
    public boolean finduserid(String userid);
    public String[] findqa(String userid);
    public  boolean revisionpwd(String userid,String password);
}
