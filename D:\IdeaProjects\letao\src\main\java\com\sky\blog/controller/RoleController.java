package com.sky.blog.controller;

import com.sky.blog.entity.Role;
import com.sky.blog.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    ResponseEntity getById(String id){        Role result = roleService.getById(id);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResponseEntity getAll(){
        List<Role> result = roleService.getAll();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResponseEntity insert(Role role){
        Integer result = roleService.insert(role);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    ResponseEntity deleteById(String id){        Integer result = roleService.deleteById(id);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    ResponseEntity update(Role role){
        Integer result = roleService.update(role);
        return ResponseEntity.ok(result);
    }

}
