package com.giit.www.system.service;

import com.giit.www.entity.User;


public interface AccountBiz {

    public User findByIdAndPassword(String username, String password);

    public void updatePassword(String id, String password);
}
