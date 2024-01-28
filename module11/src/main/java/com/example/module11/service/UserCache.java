package com.example.module11.service;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserCache {

    private final Map<String, UserInfo> users = new HashMap<>();

    @PostConstruct
    public void init(){
        create(new UserInfo("1", "Ivan"));
        create(new UserInfo("2", "Den"));
    }

    public Collection<UserInfo> getAll(){
        return users.values();
    }
    public String getById(String id){
        return users.get(id).toString();
    }
    public UserInfo create(UserInfo info){
        return users.put(info.getId(), info);
    }

    public UserInfo update(UserInfo info){
        return users.put(info.getId(), info);
    }

    public UserInfo remove(String id){
        return users.remove(id);
    }

}
