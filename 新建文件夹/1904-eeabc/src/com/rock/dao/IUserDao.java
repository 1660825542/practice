package com.rock.dao;

import com.rock.entities.User;

public interface IUserDao {
    public boolean result(User user);
    public boolean finduserid(String userid);
    public String[] findqa(String userid);
    public  boolean revisionpwd(String userid ,String password);
}
