package com.lu.edu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/4/19 20:04
 */
public class AutoMain {
    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

//        设置全局配置
        GlobalConfig config = new GlobalConfig();
        String s = System.getProperty("user.dir");
        config.setOutputDir(s+"/src/main/java");
        config.setAuthor("mybatis自动生成");
        config.setOpen(false);
        config.setFileOverride(false);  //是否文件覆盖
        config.setSwagger2(true);
        config.setServiceName("%sService");  //去掉Service前面的I
        config.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        generator.setGlobalConfig(config);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://43.138.27.94:3306/invigilate?serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("mall-123456");
        dsc.setDbType(DbType.MYSQL);
        generator.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("edu"); //模块名
        // 包：com.lu.edu
        pc.setParent("com.lu");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        generator.setPackageInfo(pc);


        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("scy_security","scy_teacher"); // 设置要映射的表名
         //数据库表 映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段 映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //生成实体时去掉表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntityLombokModel(true); // 自动lombok；
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符


//        strategy.setLogicDeleteFieldName("deleted");  //逻辑字段，数据库字段里面有deteted,然后自动配置

        // 自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);




        generator.setStrategy(strategy);
        generator.execute();
    }
}
