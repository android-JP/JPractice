package com.androidjp.lib_common_util.data;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件IO操作
 * Created by androidjp on 16-7-21.
 */
public class FileIOUtil {
    private static final String TAG = "FileUtil";


    public static final int TYPE_BUFFERED = 0x1001;
    public static final int TYPE_BYTE = 0x1002;


    /**
     * 读取普通文件内容（非对象文件）
     * @param fileName 文件路径
     * @param type 读取方式
     * @return 文本信息
     */
    public static String readFile(String fileName , int type){
        if (!FileUtil.isExist(fileName))
            return null;

        switch (type){
            case TYPE_BUFFERED:
                StringBuffer sb= new StringBuffer();
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
                    String line = null;
                    while((line = br.readLine())!=null){
                        sb.append(line);
                    }
                    br.close();
                    return sb.toString();
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                    e.printStackTrace();
                }

                break;
            case TYPE_BYTE:
                try {
                    FileInputStream fis = new FileInputStream(new File(fileName));
                    byte[] b  = new byte[1024];
                    int len = fis.read(b);
                    fis.close();
                    String res = new String(b,0,len);
                    return res;
                }catch (IOException e) {
                    Log.e(TAG, e.toString());
                    e.printStackTrace();
                }
            default:
                return null;
        }
        return null;
    }


    /**
     * * 读取dat文件信息
     * @param fileName dat文件路径
     * @return 对象列表数据
     */
    public static List<? extends Object> readDatFile(String fileName){

        if (!FileUtil.isExist(fileName))
            return null;

        List<?> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
            list = (List<?>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            list  = null;
            e.printStackTrace();
        }finally {
            return list;
        }


    }


    /**
     * 写入普通文件
     * @param fileName 文件路径
     * @param content 内容
     * @param type 写入方式
     * @return true：成功 ，false：失败
     */
    public static boolean writeFile(String fileName,String content, int type) {

        if (TextUtils.isEmpty(content))
            return false;

        if (!FileUtil.isExist(fileName))
            return false;


        switch (type) {
            case TYPE_BUFFERED:
                try {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));
                    bw.write(content);
                    bw.close();
                    return true;
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                    e.printStackTrace();
                }

                break;
            case TYPE_BYTE:
                try {
                    FileOutputStream fis = new FileOutputStream(new File(fileName));
                    fis.write(content.getBytes());
                    return true;
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                    e.printStackTrace();
                }
                break;
            default:
                return false;
        }

        return false;
    }


    /**
     *
     * @param fileName dat文件路径
     * @param list 对象列表数据
     * @param <T>  泛型
     * @return
     */
    public static <T> boolean writeDatFile(String fileName, List<T> list){

        if (list==null || list.size()==0)
            return false;

        if (!FileUtil.isExist(fileName))
            return false;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
            oos.writeObject(list);
            oos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }


}
