package com.originaldreams.logcenter.mapper;

import com.originaldreams.logcenter.entity.SMSLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface SMSLogMapper {
    String tableName = "sms_log";

     @Select("SELECT id, phone, type, templateId, codeStr, minuteStr, result, stateCode, createTime FROM " + tableName + " WHERE id = #{id}")
     SMSLog getById(Integer Id);


     @Select("SELECT id, phone, type, templateId, codeStr, minuteStr, result, stateCode, createTime FROM " + tableName + " WHERE phone = #{phone}")
     SMSLog getByPhone(String phone);


     @Select("SELECT id, phone, type, templateId, codeStr, minuteStr, result, stateCode, createTime FROM " + tableName + " WHERE type = #{type}")
     SMSLog getByType(Integer type);


     @Select("SELECT id, phone, type, templateId, codeStr, minuteStr, result, stateCode, createTime FROM " + tableName)
     List<SMSLog> getAll();

     @Insert("INSERT INTO " + tableName + "(phone, type, templateId, codeStr, minuteStr, result, stateCode, createTime) VALUES (#{phone}, #{type}, #{templateId}, #{codeStr}, #{minuteStr}, #{result}, #{stateCode}, #{createTime})")
     @Options(useGeneratedKeys = true)
     Integer insert(SMSLog smsLog);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(Integer id);
     @Update("UPDATE " + tableName + " SET phone=#{phone}, type=#{type}, templateId=#{templateId}, codeStr=#{codeStr}, minuteStr=#{minuteStr}, result=#{result}, stateCode=#{stateCode}, createTime=#{createTime} WHERE id = #{id}")
     Integer update(SMSLog smsLog);


}
