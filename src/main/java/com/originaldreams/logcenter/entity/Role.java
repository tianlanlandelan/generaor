package com.originaldreams.logcenter.entity;

import java.util.Date;
import java.util.List;

public class Role {
    /**
    * 角色ID
    */
     private String id;
    /**
    * 角色名称
    */
     private String roleName;
    /**
    * 角色功能ID
    */
     private String nodeIds;
    /**
    * 角色描述
    */
     private String description;
     public String getId(){
           return this.id;
     }
     public void setId(String id){
           this.id = id;
     }
     public String getRoleName(){
           return this.roleName;
     }
     public void setRoleName(String roleName){
           this.roleName = roleName;
     }
     public String getNodeIds(){
           return this.nodeIds;
     }
     public void setNodeIds(String nodeIds){
           this.nodeIds = nodeIds;
     }
     public String getDescription(){
           return this.description;
     }
     public void setDescription(String description){
           this.description = description;
     }

@Override
    public String toString() {
        return "Role{" +
            "  id:" + id + "  roleName:" + roleName + "  nodeIds:" + nodeIds + "  description:" + description + 
        "}";
    }
  }
