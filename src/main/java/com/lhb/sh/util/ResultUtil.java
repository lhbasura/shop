/*Copyright ©  2017 Lyons. All rights reserved. */
package com.lhb.sh.util;

import com.google.gson.Gson;
import com.lhb.sh.util.enums.AccountStaEnum;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 消息结果集
 * @ClassName: ResultMap
 */
public class ResultUtil {
    private static Map getInstance()
    {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        return resultMap;
    }
    /**
     * @param message
     * @return
     * @Title: getJson
     * @Description: String -> Map("message",Object) -> json
     * @return: String(json)
     */
    public static String getJson(String message) {
        Map<String,Object> resultMap=getInstance();
        resultMap.clear();
        resultMap.put("message", message);
        return toJson(resultMap);
    }

    public static String getJson(int code, String message) {
        Map<String,Object> resultMap=getInstance();
        resultMap.put("code", code);
        resultMap.put("message", message);
        return toJson(resultMap);
    }




    /**
     * @param object
     * @Title: toJson
     * @Description: object -> json
     * @return: String
     */
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static String toJson(List<ObjectError>errors)
    {
        StringBuilder str=new StringBuilder();
        errors.forEach(error->{
            str.append(error.getDefaultMessage());
        });
        return str.toString();
    }
}
