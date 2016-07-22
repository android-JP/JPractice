package com.androidjp.app.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

import com.androidjp.app.MyAppl;
import com.androidjp.lib_common_util.system.LogUtil;

import java.io.File;

/**
 * 外部SD卡和内部存储相关
 * SD卡相关权限：
 * 1.在SDCard中创建与删除文件权限
 <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
 * 2.往SDCard写入数据权限
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 * Created by JP on 2016/4/4.
 */
public class StorageUtil {





    /**
     * SD卡存在并可用？
     * @return
     */
    public static boolean isSDWorks(){
        String state = Environment.getExternalStorageState();
        if(state!=null &&( state.equals(Environment.MEDIA_MOUNTED) ||!Environment.isExternalStorageRemovable())){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 存储的用量情况
     */
    public static long getUsableSpace(File path){
        if (path == null)
            return -1;
        /*API >=9,直接用File的方法可以计算可用空间*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD){
            return path.getUsableSpace();
        }else {/*API8和以前*/
            if (!path.exists()){
                return 0;
            }else{
                final StatFs statFs = new StatFs(path.getPath());
                return statFs.getBlockSizeLong()*statFs.getAvailableBlocksLong();
            }
        }
    }



    /**
     * 选择获取路径
     * @param choice
     * @return
     */
    public static String getDir(DirEnum choice){
        String res = null;
       switch (choice){
           case DataDir:
               res = Environment.getDataDirectory().getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               break;
           case ExternalStorageDir:
               res = Environment.getExternalStorageDirectory().getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               res = Environment.getExternalStoragePublicDirectory("").getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               break;
           case AppRootDir:
               res = MyAppl.getContext().getPackageName();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               break;
           case DownloadCacheDir:
               res = Environment.getDownloadCacheDirectory().getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               break;
           case SystemDir:
               res = Environment.getRootDirectory().getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               break;
           case FileDir:
               res = Environment.getDataDirectory().getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               res = MyAppl.getContext().getFilesDir().getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               break;
           case ExternalFileDir:
               res = Environment.getExternalStoragePublicDirectory("files").getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               if (StorageUtil.isSDWorks()){
                   res = MyAppl.getContext().getExternalFilesDir("").getAbsolutePath();
                   LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               }
               break;

           case CacheDir:
               res = MyAppl.getContext().getCacheDir().getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               break;
           case ExternalCacheDir:
               res = Environment.getExternalStoragePublicDirectory("cache").getAbsolutePath();
               LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               if (StorageUtil.isSDWorks()){
                   res = MyAppl.getContext().getExternalCacheDir().getAbsolutePath();
                   LogUtil.debug(StorageUtil.class,choice.name()+": "+res);
               }
               break;

           default:
               res = null;
               break;
       }
        if (TextUtils.isEmpty(res)){
            res = "";
        }
        return res;
    }

    public static String getDirs(){
        StringBuilder sb = new StringBuilder();
        sb.append("Environment.getDataDirectory().getAbsolutePath(): "+ Environment.getDataDirectory().getAbsolutePath());
        sb.append("\r\n");
        sb.append("Environment.getExternalStorageDirectory().getAbsolutePath(): "+ Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append("\r\n");
        sb.append("Environment.getExternalStoragePublicDirectory(\"\").getAbsolutePath(): "+Environment.getExternalStoragePublicDirectory("").getAbsolutePath());
        sb.append("\r\n");
        sb.append("MyAppl.getContext().getPackageName(): "+MyAppl.getContext().getPackageName());
        sb.append("\r\n");
        sb.append("Environment.getDownloadCacheDirectory().getAbsolutePath(): "+ Environment.getDownloadCacheDirectory().getAbsolutePath());
        sb.append("\r\n");
        sb.append("Environment.getRootDirectory().getAbsolutePath(): "+ Environment.getRootDirectory().getAbsolutePath());
        sb.append("\r\n");
        sb.append("Environment.getDataDirectory().getAbsolutePath(): "+ Environment.getDataDirectory().getAbsolutePath());
        sb.append("\r\n");

        sb.append("MyAppl.getContext().getFilesDir().getAbsolutePath(): "+ MyAppl.getContext().getFilesDir().getAbsolutePath());
        sb.append("\r\n");

        sb.append("Environment.getExternalStoragePublicDirectory(\"files\").getAbsolutePath(): "+Environment.getExternalStoragePublicDirectory("files").getAbsolutePath());
        sb.append("\r\n");

        if (StorageUtil.isSDWorks()){
            sb.append("MyAppl.getContext().getExternalFilesDir(\"\").getAbsolutePath(): "+MyAppl.getContext().getExternalFilesDir("").getAbsolutePath());
            sb.append("\r\n");
        }

        sb.append("MyAppl.getContext().getCacheDir().getAbsolutePath(): "+ MyAppl.getContext().getCacheDir().getAbsolutePath());
        sb.append("\r\n");

        sb.append("Environment.getExternalStoragePublicDirectory(\"cache\").getAbsolutePath(): "+ Environment.getExternalStoragePublicDirectory("cache").getAbsolutePath());
        sb.append("\r\n");
        if (StorageUtil.isSDWorks()) {
            sb.append("MyAppl.getContext().getExternalCacheDir().getAbsolutePath(): "+ MyAppl.getContext().getExternalCacheDir().getAbsolutePath());
            sb.append("\r\n");
        }

        return sb.toString();
    }


    public static enum DirEnum{
        /*$rootDir*/
        DataDir /*/data*/
        ,ExternalStorageDir/*/storage/sdcard0 或者 /storage/emulated/0*/

        /*appDataDir*/
        ,AppRootDir/*$rootDir/data/$packagename*/
        ,ExternalAppRootDir/*$rootDir/Android/data/$packagename*/

        ,DownloadCacheDir/*/cache*/
        ,SystemDir/*/system*/

        ,CacheDir/*$rootDir/data/#packagename/cache*/
        ,ExternalCacheDir/*$rootDir/Android/data/$packagename/cache*/

        ,FileDir/*$rootDir/data/$package/file*/
        ,ExternalFileDir/*$rootDir*/

    }

}
