package com.jikuodong.plms.utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *  PropertiesConfiguration代替Properties,实现更多功能的工具类
 * @author JKD
 * @version 1.0.0
 * @ClassName PropertiesConfigUtil.java
 * @createTime 2019年03月22日 13:22:00
 */
public class PropertiesConfigUtil {

    private PropertiesConfiguration propConfig;
    /**
     * 配置文件路径
     */
    private String file;

    static {
        FileBasedConfigurationBuilder.setDefaultEncoding(PropertiesConfiguration.class, "UTF-8");
    }

    public PropertiesConfigUtil(String file) throws ConfigurationException {
        // 初始化FileBasedConfigurationBuilder
        Configurations config = new Configurations();
        propConfig = config.properties(file);
        this.file = file;
    }

    /**
     * 读取配置文件中内容，支持多种方式，这里只写了String
     * @method getProperty
     * @author JKD
     * @param key
     * @return java.lang.String
     * @data 2019/3/22 13:35
     * @throws
     */
    public String getProperty(String key) {
        return propConfig.getString(key);
    }

    /**
     *  读取配置文件中内容(int类型)
     * @method getIntProperty
     * @author JKD
     * @param key
     * @return int
     * @data 2019/3/22 16:16
     */
    public int getIntProperty(String key) {
        return propConfig.getInt(key);
    }

    /**
     *  写入配置文件[默认 uncode，无法写入中文，需要自定义 PropertiesWriter ]
     * @method setProperties
     * @author JKD
     * @param key
     * @param value
     * @return void
     * @data 2019/3/22 14:37
     * @throws
     */
    public void setProperties(String key, String value) {
        propConfig.setProperty(key, value);
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), StandardCharsets.UTF_8);
            propConfig.write(writer);
        } catch (IOException | ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ConfigurationException {
        PropertiesConfigUtil prop  = new PropertiesConfigUtil("C:\\his\\his-docking.properties");
        System.out.println(prop.getProperty("sync.lasttime"));
        prop.setProperties("sync.lasttime", "2019-3-12 17:35:13");
    }
}
