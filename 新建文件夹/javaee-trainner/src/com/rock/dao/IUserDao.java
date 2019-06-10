package com.rock.dao;

import com.rock.entities.Userinfo;

public interface IUserDao {
    public Userinfo login(String userid, String password);

    void register(Userinfo userinfo);
}
