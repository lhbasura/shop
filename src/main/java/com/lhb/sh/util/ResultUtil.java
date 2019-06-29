/*Copyright ©  2017 Lyons. All rights reserved. */
package com.lhb.sh.util;

import com.google.gson.Gson;
import com.lhb.sh.util.enums.AccountStaEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @Description: 消息结果集
 * @ClassName: ResultMap
 * @author: lyons<zhanglei>
 * @date: 2017年1月19日 下午1:18:00
 * @version: [1.0]
 */
public class ResultUtil
{
    private static Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    
    public ResultUtil(){}
    
    /**
     * 
     * @Title: putLinkedMap
     * @Description: Message 消息结果
     * @param object
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putMessageMap(Object object)
    {
        resultMap.put("Message", object);
        return resultMap;
    }
    
    /**
     * 
     * @Title: putLinkedMap
     * @Description: code 消息状态
     * @param object
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putcodeMap(Object object)
    {
        resultMap.put("code", object);
        return resultMap;
    }
    
    /**
     * 
     * @Title: putLinkedMap
     * @Description: Url 请求地址
     * @param object
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putUrlMap(Object object)
    {
        resultMap.put("Url", object);
        return resultMap;
    }
    
    /**
     * 
     * @Title: clearMap
     * @Description: 清空消息集
     * @return: void
     */
    public static void clearMap()
    {
        resultMap.clear();
    }
    
    /**
     * 
     * @Title: getLinkedMap
     * @Description: 返回消息集
     * @return: Map<String,Object>
     */
    public static Map<String, Object> getLinkedMap()
    {
        return resultMap;
    }
    
    /**
     * 
     * @Title: getJson
     * @Description: String -> Map("message",Object) -> json
     * @param message
     * @return
     * @return: String(json)
     */
    public static String getJson(String message)
    {
        resultMap.clear();
        resultMap.put("message", message);
        return toJson(resultMap);
    }

    public static String getJson(int code,String message)
    {
        resultMap.clear();
        resultMap.put("code", code);
        resultMap.put("message", message);
        return toJson(resultMap);
    }

    /**
     * 
     * @Title: getJson
     * @Description: int -> Map("message",Object) -> json
     * @param code
     * @return: String(json)
     */
    public static String getJson(int code)
    {
        resultMap.clear();
        resultMap.put("code", code);
        return toJson(resultMap);
    }
    
    /**
     * 
     * @Title: getUrlJson
     * @Description: after login success,return the url(json)
     * @param request
     * @return: String
     */
    public static String getUrlJson(HttpServletRequest request)
    {
        resultMap.clear();
        resultMap.put("code", AccountStaEnum.success.getCode());
        return toJson(resultMap);
    }
    
    /**
     * 
     * @Title: toJson
     * @Description: object -> json
     * @param object
     * @return: String
     */
    public static String toJson(Object object)
    {
        return new Gson().toJson(object);
    }
}
