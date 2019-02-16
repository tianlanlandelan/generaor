package com.originaldreams.logcenter.entity;

import java.util.Date;
import java.util.List;

public class SMSLog {
    /**
    * id
    */
     private Integer id;
    /**
    * 用户ID
    */
     private String phone;
    /**
    * 类型
    */
     private Integer type;
    /**
    * 短信模板ID
    */
     private String templateId;
    /**
    * 验证码
    */
     private String codeStr;
    /**
    * 有效时间
    */
     private String minuteStr;
    /**
    * 返回结果
    */
     private String result;
    /**
    * 返回码
    */
     private String stateCode;
    /**
    * 时间
    */
     private Date createTime = new Date();
     public Integer getId(){
           return this.id;
     }
     public void setId(Integer id){
           this.id = id;
     }
     public String getPhone(){
           return this.phone;
     }
     public void setPhone(String phone){
           this.phone = phone;
     }
     public Integer getType(){
           return this.type;
     }
     public void setType(Integer type){
           this.type = type;
     }
     public String getTemplateId(){
           return this.templateId;
     }
     public void setTemplateId(String templateId){
           this.templateId = templateId;
     }
     public String getCodeStr(){
           return this.codeStr;
     }
     public void setCodeStr(String codeStr){
           this.codeStr = codeStr;
     }
     public String getMinuteStr(){
           return this.minuteStr;
     }
     public void setMinuteStr(String minuteStr){
           this.minuteStr = minuteStr;
     }
     public String getResult(){
           return this.result;
     }
     public void setResult(String result){
           this.result = result;
     }
     public String getStateCode(){
           return this.stateCode;
     }
     public void setStateCode(String stateCode){
           this.stateCode = stateCode;
     }
     public Date getCreateTime(){
           return this.createTime;
     }
     public void setCreateTime(Date createTime){
           this.createTime = createTime;
     }

@Override
    public String toString() {
        return "SMSLog{" +
            "  id:" + id + "  phone:" + phone + "  type:" + type + "  templateId:" + templateId + "  codeStr:" + codeStr + "  minuteStr:" + minuteStr + "  result:" + result + "  stateCode:" + stateCode + "  createTime:" + createTime + 
        "}";
    }
  }
