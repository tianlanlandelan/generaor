package com.sky.blog.mapper;

import com.sky.blog.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface RoleMapper {
    String tableName = "server_role";


     @Select("SELECT id, roleName, nodeIds, description FROM " + tableName + " WHERE id = #{id}")
     Role getById(String Id);

     @Select("SELECT id, roleName, nodeIds, description FROM " + tableName)
     List<Role> getAll();

     @Insert("INSERT INTO " + tableName + "(id, roleName, nodeIds, description) VALUES (#{id}, #{roleName}, #{nodeIds}, #{description})")
     Integer insert(Role role);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(String id);
     @Update("UPDATE " + tableName + " SET roleName=#{roleName}, nodeIds=#{nodeIds}, description=#{description} WHERE id = #{id}")
     Integer update(Role role);


}
