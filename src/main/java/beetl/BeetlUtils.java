package beetl;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lanli on 2017/4/7.
 */
public class BeetlUtils {
    public static void main(String[] args){

        try{
//          加载配置文件
            String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "config" + File.separator;
            String fileName = "myBeetl.properties";
            Properties properties = new Properties();
            properties.load(new FileInputStream(dir + fileName));
            //构建模板对象
            MyTemplate myTemplate = new MyTemplate();

            /*
            设置公共属性：实体类名，模块包名
             */

            myTemplate.setRootPath(properties.getProperty("RootPath"));
//            myTemplate.setRootPackageName(RootPackageName);
            myTemplate.setEntityClassName(properties.getProperty("EntityClassName"));
            myTemplate.setEntityName(properties.getProperty("EntityName"));
            myTemplate.setPackageName(properties.getProperty("PackageName"));
            myTemplate.setCollectionName(properties.getProperty("CollectionName"));
            myTemplate.setList(getMongFieldList(properties.getProperty("SqlFile")));



            /*
            设置Entity属性，生成Entity
             */
            myTemplate.setTemplateName("Entity.txt");
            createEntity(myTemplate);

            /*
            生成DAO
             */
            myTemplate.setTemplateName("Mapper.txt");
            createDaoInterface(myTemplate);

            /*
             生成Service
             */
            myTemplate.setTemplateName("Service.txt");
            createServiceInterface(myTemplate);

            /*
            设置Controller属性，生成Controller
             */
            myTemplate.setPackageMapPath();
            myTemplate.setTemplateName("Controller.txt");
            createController(myTemplate);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void createController(MyTemplate myTemplate){
        String filePath = myTemplate.getPackagePath() + "controller";
        String fileName = myTemplate.getEntityClassName() + "Controller.java";
        createJavaFile(myTemplate,filePath,fileName);
    }
    public static void createEntity(MyTemplate myTemplate){
        String filePath = myTemplate.getPackagePath() + "entity";
        String fileName = myTemplate.getEntityClassName() + ".java";
        createJavaFile(myTemplate,filePath,fileName);
    }
    public static void createServiceInterface(MyTemplate myTemplate){
        String filePath = myTemplate.getPackagePath() + "service";

        String fileName = myTemplate.getEntityClassName() + "Service.java";
        createJavaFile(myTemplate,filePath,fileName);
    }
    public static void createDaoInterface(MyTemplate myTemplate){
        String filePath = myTemplate.getPackagePath() + "mapper";
        String fileName = myTemplate.getEntityClassName() + "Mapper.java";
        createJavaFile(myTemplate,filePath,fileName);
    }

    public static void createJavaFile(MyTemplate myTemplate,String filePath,String fileName){
        try{
            //指定模板路径
            String root = System.getProperty("user.dir") + File.separator + "newTemplate" + File.separator;
            FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
            Configuration cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
            //指定要加载的模板
            Template t = gt.getTemplate(myTemplate.getTemplateName());
            //绑定全局变量
            t.binding("myUtil",myTemplate);
            //读取模板输出的文本
            String str = t.render();
            System.out.println(str);
            File dir = new File(myTemplate.getRootPath() + File.separator + filePath);
            if(!dir.exists() && !dir.isDirectory()){
                dir.mkdirs();
            }
            File file = new File( dir + File.separator + fileName );
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(str);
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static List<MongoFields> getMongFieldList(String fileName) throws Exception{
        List<MongoFields> mongoFieldsList = new ArrayList<MongoFields>();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> list = (List<Map<String,Object>>)objectMapper.readValue(new FileInputStream(System.getProperty("user.dir") + File.separator + "sql" + File.separator + fileName), List.class);
        for(Map<String,Object> map : list){
            MongoFields mongoFields = new MongoFields();
            mongoFields.setName(map.get("name").toString());
            mongoFields.setType(map.get("type").toString());
            mongoFields.setNull((Boolean) map.get("isNull"));
            mongoFields.setIndex((Boolean)map.get("isIndex"));
            mongoFields.setDefaultValue(map.get("defaultValue"));
            if(map.containsKey("autoIncrement")){
                mongoFields.setAutoIncrement((Boolean)map.get("autoIncrement"));
            }
            mongoFields.setCamelCaseName(map.get("name").toString().substring(0, 1).toUpperCase() + map.get("name").toString().substring(1));
            if(map.get("description") != null)
            mongoFields.setDescription(map.get("description").toString());
            mongoFieldsList.add(mongoFields);
        }
        return mongoFieldsList;
    }
}
