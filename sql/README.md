用Json格式描述数据表字段：
请注意：
   1.必须有id字段
   2.id字段固定格式：
        {
          "name":"id",
          "type":"String",
          "isIndex":false,
          "isNull":true,
          "defaultValue":null,
          "description":"id"
        }

Json格式如下：
[
    {
      "name":"id",               //name，标记字段名
      "type":"String",           //type，标记字段类型 支持各种基本类型和List、Map
      "isIndex":false,           //标注该字段是否是索引字段，如果是索引字段，则会创建以该字段为条件的查询，暂时未做以该字段为条件的删除操作
      "isNull":true,             //标注该字段是否可为空，如果标注不可为空，则在插入和修改操作时会对该字段做非空判断，当为空时，插入或删除操作失败
      "defaultValue":null,       //默认值，数字直接写值，String 型用 "\" 开始，\"" 结束，如："\"男\""
      "description":"id"         //注释
    },
   {
      "name":"age",
      "type":"Integer",
      "isIndex":false,
      "isNull":false,
      "defaultValue":10,
      "description":"年龄"
    },
    {
      "name":"sex",
      "type":"String",
      "isIndex":false,
      "isNull":true,
      "defaultValue":"\"男\"",
      "description":"性别"
    }
    ...
    ...
 ]