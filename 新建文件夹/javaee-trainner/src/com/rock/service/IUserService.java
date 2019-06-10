package com.rock.service;

import com.rock.entities.Userinfo;

public interface IUserService {
    public Userinfo login(String userid, String password);

    void register(Userinfo userinfo);
}
