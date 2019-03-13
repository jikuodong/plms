package com.jikuodong.plms.utils.mybatisplugs;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Mybatis Plugs 代码自动生成器
 * @author JKD
 * @version 1.0.0
 * @ClassName MpGenerator.java
 * @createTime 2019年03月07日 09:40:00
 */
public class MpGenerator {
    // 生成的文件项目路径
    private static String baseProjectPath = "F:/Study/mybatisplus-generator/generator/";

    // 基本包名
    private static String basePackage = "com.jikuodong";

    // 模块名
    private static String moduleName = "plms";
    // 作者
    private static String authorName = "jikuodong";

    // 要生成的表名
    private static String[] tables = {"t_eps_laboratory"};

    // table的前缀
    private static String prefix = "t_eps_";

    // 数据库类型
    private static DbType dyType = DbType.MYSQL;

    // MySql数据库配置
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/wpc?Unicode=true&useSSL=false&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "123456";

    // 自定义数据库表字段类型转换【可选】
    private static class  MysqlConvert extends MySqlTypeConvert {
        @Override
        public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            System.out.println("转换类型：" + fieldType);
            // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
            //    return DbColumnType.BOOLEAN;
            // }
            return super.processTypeConvert(globalConfig, fieldType);
        }
    }

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        /**
         * 设置数据库
         */
        generator.setDataSource(new DataSourceConfig()
                .setDbType(dyType)
                .setDriverName(driverName)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
                .setTypeConvert(new MysqlConvert())
        );

        /**
         * 全局配置
         *
         */
        generator.setGlobalConfig(new GlobalConfig()
                .setOutputDir(baseProjectPath + "/src/main/java") // 输出目录
                .setFileOverride(true)      // 是否覆盖文件
                .setActiveRecord(true)      // 是否开启ActiveRecord模式
                .setEnableCache(false)      // 是否开启二级缓存
                .setBaseResultMap(true)     // 是否XML 添加ResultMap
                .setBaseColumnList(true)    // 同上
                .setOpen(true)             // 是否生成后打开文件夹
                .setAuthor(authorName)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
        );

        /**
         * 策略配置
         *
         */
        generator.setStrategy(new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        //.setDbColumnUnderline(true)//全局下划线命名
                        .setTablePrefix(new String[]{prefix})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(tables) // 需要生成的表
                        .setRestControllerStyle(true)
                        //.setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                        // 自定义实体，公共字段
                        //.setSuperEntityColumns(new String[]{"test_id"})
                        //.setTableFillList(tableFillList)
                        // 自定义 mapper 父类 默认BaseMapper
                        //.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
                        // 自定义 service 父类 默认IService
                        // .setSuperServiceClass("com.baomidou.demo.TestService")
                        // 自定义 service 实现类父类 默认ServiceImpl
                        // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                        // 自定义 controller 父类
                        //.setSuperControllerClass("com.kichun."+packageName+".controller.AbstractController")
                        // 【实体】是否生成字段常量（默认 false）
                        // public static final String ID = "test_id";
                        // .setEntityColumnConstant(true)
                        // 【实体】是否为构建者模型（默认 false）
                        // public User setName(String name) {this.name = name; return this;}
                        // .setEntityBuilderModel(true)
                        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                        .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        );

        /**
         * 包配置
         *
         */
        generator.setPackageInfo(new PackageConfig()
                .setModuleName(moduleName)
                .setParent(basePackage)// 自定义包路径
                .setController("controller")// 这里是控制器包名，默认 web
                .setEntity("po") // PO类所在包名
                .setMapper("mapper") // mapper类所在包名
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("mapper")
        );

        /**
         * 注入自定义配置
         *
         */
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        generator.setCfg(new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>(5);
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.ftl") {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return baseProjectPath + "/src/main/resources/mappers/" + tableInfo.getEntityName() + "Mapper.xml";
                    }
                }))
        );

        // 指定模板引擎
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        /**
         * 模板配置
         *
         */
        generator.setTemplate(
                // 关闭默认 xml 生成，调整生成 至 根目录
                new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        );

        // 执行生成
        generator.execute();
    }

}
