package beetl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanli on 2017/4/6.
 */
public class MyTemplate {
    //文件路径
    private String  rootPath ;
    //包路径
    private String rootPackageName ;
    //包名（模块名）
    private String packageName;
    //实体类名
    private String entityClassName;
    //实体对象名
    private String entityName;
    //模板名称
    private String templateName;
    //Controller RequestMapping
    private String packageMapPath;

    private String collectionName;
    private List<MongoFields> list = new ArrayList<MongoFields>();

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getRootPackageName() {
        return rootPackageName;
    }

    public void setRootPackageName(String rootPackageName) {
        this.rootPackageName = rootPackageName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getEntityClassName() {
        return entityClassName;
    }

    public void setEntityClassName(String entityClassName) {
        this.entityClassName = entityClassName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public String getPackagePath(){
        String packagePath = "";
        String[] array = packageName.split("\\.");
        for(String str : array){
            packagePath += str + File.separator;
        }
        return packagePath;
    }
    public void setPackageMapPath(){
        String mapPath = "";

        String[] array = packageName.split("\\.");
        for(String str : array){
            mapPath += "/" + str;
        }
        this.packageMapPath = mapPath;
    }
    public String getPackageMapPath(){
        return packageMapPath;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public List<MongoFields> getList() {
        return list;
    }

    public void setList(List<MongoFields> list) {
        this.list = list;
    }
}
