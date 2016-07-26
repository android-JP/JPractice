package com.androidjp.lib_common_util.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by androidjp on 16-7-23.
 */
public class GsonUtil {
    private static Gson gson = null;

    static{
        if (gson == null){
            gson = new Gson();
        }
    }

    private GsonUtil(){

    }

    /**
     * Object 转 json String
     * @param object 对象
     * @return json String
     */
    public static String gsonString(Object object){
        String gsonString = null;
        if (gson != null)
            gsonString = gson.toJson(object);
        return gsonString;
    }


    /**
     * json String 转 Object
     * @param gsonString
     * @param cls
     * @param <T>
     * @return
     */
    public  static <T> T gsonToBean(String gsonString, Class<T> cls){
        T t = null;
        if (gson != null && gsonString !=null && !gsonString.equals("")){
           try{
               t = gson.fromJson(gsonString,cls);
           }catch (Exception e){
               System.out.println(cls.getSimpleName()+" "+ e.toString());
           }
        }
        return t;
    }




}
