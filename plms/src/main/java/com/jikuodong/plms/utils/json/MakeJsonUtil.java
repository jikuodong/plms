package com.jikuodong.plms.utils.json;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Date;
import java.util.Map;

public class MakeJsonUtil {
    private static JsonConfig jsonConfig = null;

    /**
     * 返回jsonobject
     * @param obj
     * @return
     */
    public static JSONObject createJson(Map<String, Object> obj) {

        jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,
                new JsonDateValueProcessor());
        JSONObject jsonObject = JSONObject.fromObject(obj,jsonConfig);
        return jsonObject;
    }

    /**
     * 返回jsonobject,并且去除不想要的字段
     * @param obj
     * @param excludes
     * @return
     */
    public static JSONObject createJsonExclude(Map<String, Object> obj, String[] excludes) {

        jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludes);
        jsonConfig.registerJsonValueProcessor(Date.class,
                new JsonDateValueProcessor());
        JSONObject jsonObject = JSONObject.fromObject(obj,jsonConfig);
        return jsonObject;
    }
}
