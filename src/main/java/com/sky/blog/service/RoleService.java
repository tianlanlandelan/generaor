package com.sky.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sky.blog.entity.Role;
import com.sky.blog.mapper.RoleMapper;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Role getById(String id){
        return roleMapper.getById(id);
    }

    public List<Role> getAll(){
        return roleMapper.getAll();
    }

    public Integer insert(Role role){
        return roleMapper.insert(role);
    }

    public Integer deleteById(String id){
        return roleMapper.deleteById(id);
    }

    public Integer update(Role role){
        return roleMapper.update(role);
    }


}
