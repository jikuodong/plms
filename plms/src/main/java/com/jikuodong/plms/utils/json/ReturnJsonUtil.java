package com.jikuodong.plms.utils.json;



import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
    返回JSON格式数据工具
 */
public class ReturnJsonUtil {
    /**
     * 返回成功数据
     * @param resObj
     * @return
     */
    public static JSONObject returnSucc(Object resobj){
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("result", "1");
        obj.put("desc","系统提示：操作已成功完成！");
        //obj.put("info", "success");
        obj.put("data", resobj);

        JSONObject jsonObject = MakeJsonUtil.createJson(obj);
        return jsonObject;
    }

    /**
     * 返回成功数据
     * 排除不想要的数据字段
     * @param resobj
     * @param excludes
     * @return
     */
    public static JSONObject returnSuccAndExclude(Object resobj, String[] excludes){
        //定义一个map
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("result", "1");
        obj.put("desc","系统提示：操作已成功完成！");
        //obj.put("info", "success");
        obj.put("data", resobj);

        JSONObject jsonObject = MakeJsonUtil.createJsonExclude(obj, excludes);

        return jsonObject;
    }

    /**
     * 返回成功数据以及其他相加的数据
     * 排除不想要的数据字段
     * @param resObj
     * @return
     */
    public static JSONObject returnSuccForOtherAndExclude(Object resobj, Object other
            , String[] excludes){

        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("result", "1");
        obj.put("desc","系统提示：操作已成功完成！");
        //obj.put("info", "success");
        obj.put("data", resobj);
        obj.put("other", other);

        JSONObject jsonObject = MakeJsonUtil.createJsonExclude(obj, excludes);

        return jsonObject;
    }

    /**
     * 返回成功数据以及其他想加的数据
     * @param resobj
     * @param other
     * @return
     */
    public static JSONObject returnSuccForOther(Object resobj, Object other){

        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("result", "1");
        obj.put("desc","系统提示：操作已成功完成！");
        //obj.put("info", "success");
        obj.put("data", resobj);
        obj.put("other", other);

        JSONObject jsonObject = MakeJsonUtil.createJson(obj);

        return jsonObject;
    }

    /**
     * 返回错误结果
     * @param resObj
     * @return
     */
    public static JSONObject returnFail(Object resobj){
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("result", "0");
        obj.put("desc","系统提示：操作失败！");
        //obj.put("info", "success");
        obj.put("data", resobj);

        JSONObject jsonObject = MakeJsonUtil.createJson(obj);

        return jsonObject;
    }

    /**
     * 返回错误数据
     * 排除不想要的数据字段
     * @param resobj
     * @param excludes
     * @return
     */
    public static JSONObject returnFailAndExclude(Object resobj, String[] excludes){
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("result", "0");
        obj.put("desc","系统提示：操作失败！");
        //obj.put("info", "success");
        obj.put("data", resobj);

        JSONObject jsonObject = MakeJsonUtil.createJsonExclude(obj, excludes);
        return jsonObject;
    }

    public static void main(String[] args) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("result", "0");
        //obj.put("info", "success");
        obj.put("desc","系统提示：操作已成功完成！");
        obj.put("data", "resobj");
        obj.put("other", "other");
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setIgnoreDefaultExcludes(true);  //默认为false，即过滤默认的key
        jsonConfig.setExcludes(new String[]{"other"});
        jsonConfig.registerJsonValueProcessor(Date.class,
                new JsonDateValueProcessor());
        JSONObject jsonObject = JSONObject.fromObject(obj,jsonConfig);

        System.out.println(jsonObject);
    }
}
