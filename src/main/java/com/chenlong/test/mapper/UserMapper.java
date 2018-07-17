package com.chenlong.test.mapper;

import com.chenlong.test.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface UserMapper {
    String tableName = "user";


     @Select("SELECT id, userName, phone, wxId, email, password, createTime, mask FROM " + tableName + " WHERE id = #{id}")
     User getById(Integer Id);


@Select("SELECT id, userName, phone, wxId, email, password, createTime, mask FROM " + tableName + " WHERE userName = #{userName}")

     User getByUserName(String userName);


@Select("SELECT id, userName, phone, wxId, email, password, createTime, mask FROM " + tableName + " WHERE phone = #{phone}")

     User getByPhone(String phone);


@Select("SELECT id, userName, phone, wxId, email, password, createTime, mask FROM " + tableName + " WHERE wxId = #{wxId}")

     User getByWxId(String wxId);


@Select("SELECT id, userName, phone, wxId, email, password, createTime, mask FROM " + tableName + " WHERE email = #{email}")

     User getByEmail(String email);



     @Select("SELECT id, userName, phone, wxId, email, password, createTime, mask FROM " + tableName)
     List<User> getAll();

     @Insert("INSERT INTO " + tableName + "(id, userName, phone, wxId, email, password, createTime, mask) VALUES (#{id}, #{userName}, #{phone}, #{wxId}, #{email}, #{password}, #{createTime}, #{mask})")
     Integer insert(User user);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(Integer id);
     @Update("UPDATE " + tableName + " SET userName=#{userName}, phone=#{phone}, wxId=#{wxId}, email=#{email}, password=#{password}, createTime=#{createTime}, mask=#{mask} WHERE id = #{id}")
     Integer update(User user);


}
