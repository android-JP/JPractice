package com.androidjp.lib_common_util.data;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 数据库工具类
 * Created by androidjp on 16/9/25.
 */

public class DBUtil {

    public static DBOperator dbOperator = null;

    /**
     * 将/res/raw 目录下的数据库,拷贝到本地app目录下(data/data/<package-name>/)
     * @return 该数据库对象文件的地址
     */
    public static String getDatabaseFile(Context context, String dbName){
        File db  = null;
        String path = "/data"
                + Environment.getDataDirectory().getAbsolutePath()
                + File.separator + context.getPackageName()
                + File.separator + dbName;

        db = new File(path);
        if (!db.exists()){
            try {
                copyDatabaseFromAssets(context,db, dbName);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return path;
    }


    public static synchronized DBOperator openDatabase(Context context, Class<? extends DBOperator> clazz,  String path){
        if (dbOperator==null||!dbOperator.getClass().equals(clazz)){
            Log.d("DBUtil","openDatabase() operator新建");
            try {
                dbOperator = clazz.newInstance();
                dbOperator.craeteOrOpenDb(context, path);
            } catch (InstantiationException ignored) {
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }else{
            dbOperator.craeteOrOpenDb(context,path);
        }
        return dbOperator;
    }


    /**
     * 将/src/main/assets 目录下的数据库,拷贝到本地app目录下(data/data/<package-name>/)
     */
    public static void copyDatabaseFromAssets(Context context,File file, String dbName) throws IOException {

        if (file==null)
            return;

        InputStream is = context.getAssets().open(dbName);

        FileOutputStream fos = new FileOutputStream(file);
        int len =  -1;
        byte[] buffer = new byte[1024];
        while((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
            fos.flush();
        }
        fos.close();
        is.close();
    }
}
