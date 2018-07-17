package com.chenlong.test.entity;

import java.util.Date;
import java.util.List;

public class User {
    /**
    * id
    */
     private Integer id;
    /**
    * 用户名,不重复，默认为手机号，可用于登录
    */
     private String userName;
    /**
    * 手机号，不重复，可用于登录
    */
     private String phone;
    /**
    * 微信号，不重复，可用于登录
    */
     private String wxId;
    /**
    * 邮箱，不重复，可用于登录
    */
     private String email;
    /**
    * 密码
    */
     private String password;
    /**
    * 创建时间
    */
     private Date createTime = new Date();
    /**
    * 掩码值，用来表示一系列开关（如：是否开启用户名登录、是否已删除、是否开启邮箱登录等）
    */
     private Long mask;
     public Integer getId(){
           return this.id;
     }
     public void setId(Integer id){
           this.id = id;
     }
     public String getUserName(){
           return this.userName;
     }
     public void setUserName(String userName){
           this.userName = userName;
     }
     public String getPhone(){
           return this.phone;
     }
     public void setPhone(String phone){
           this.phone = phone;
     }
     public String getWxId(){
           return this.wxId;
     }
     public void setWxId(String wxId){
           this.wxId = wxId;
     }
     public String getEmail(){
           return this.email;
     }
     public void setEmail(String email){
           this.email = email;
     }
     public String getPassword(){
           return this.password;
     }
     public void setPassword(String password){
           this.password = password;
     }
     public Date getCreateTime(){
           return this.createTime;
     }
     public void setCreateTime(Date createTime){
           this.createTime = createTime;
     }
     public Long getMask(){
           return this.mask;
     }
     public void setMask(Long mask){
           this.mask = mask;
     }


@Override
    public String toString() {
        return "User{" +
            "  id:" + id + "  userName:" + userName + "  phone:" + phone + "  wxId:" + wxId + "  email:" + email + "  password:" + password + "  createTime:" + createTime + "  mask:" + mask + 
        "}";
    }
  }
