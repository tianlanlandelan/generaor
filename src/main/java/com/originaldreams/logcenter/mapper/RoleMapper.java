package com.originaldreams.logcenter.mapper;

import com.originaldreams.logcenter.entity.Role;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RoleMapper {
    String tableName = "role";

     @Select("SELECT id, roleName, nodeIds, description FROM " + tableName + " WHERE id = #{id}")
     Role getById(String Id);


     @Select("SELECT id, roleName, nodeIds, description FROM " + tableName + " WHERE roleName = #{roleName}")
     Role getByRoleName(String roleName);


     @Select("SELECT id, roleName, nodeIds, description FROM " + tableName)
     List<Role> getAll();

     @Insert("INSERT INTO " + tableName + "(id, roleName, nodeIds, description) VALUES (#{id}, #{roleName}, #{nodeIds}, #{description})")
     Integer insert(Role role);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(String id);
     @Update("UPDATE " + tableName + " SET roleName=#{roleName}, nodeIds=#{nodeIds}, description=#{description} WHERE id = #{id}")
     Integer update(Role role);


}
