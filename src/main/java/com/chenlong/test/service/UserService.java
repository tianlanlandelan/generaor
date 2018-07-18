package com.chenlong.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chenlong.test.entity.User;
import com.chenlong.test.mapper.UserMapper;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getById(Integer id){

        return userMapper.getById(id);
    }

    public User getByUserName(String userName){
        return userMapper.getByUserName(userName);
    }

    public User getByPhone(String phone){
        return userMapper.getByPhone(phone);
    }

    public User getByWxId(String wxId){
        return userMapper.getByWxId(wxId);
    }

    public User getByEmail(String email){
        return userMapper.getByEmail(email);
    }




    public List<User> getAll(){
        return userMapper.getAll();
    }

    public Integer insert(User user){
        return userMapper.insert(user);
    }

    public Integer deleteById(Integer id){
        return userMapper.deleteById(id);
    }

    public Integer update(User user){
        return userMapper.update(user);
    }


}
