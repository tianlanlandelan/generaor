package com.originaldreams.logcenter.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.originaldreams.logcenter.entity.Role;
import com.originaldreams.logcenter.mapper.RoleMapper;
import java.util.List;

@Service
public class RoleService {
    @Resource
    private RoleMapper roleMapper;

    public Role getById(String id){

        return roleMapper.getById(id);
    }

    public Role getByRoleName(String roleName){
        return roleMapper.getByRoleName(roleName);
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
