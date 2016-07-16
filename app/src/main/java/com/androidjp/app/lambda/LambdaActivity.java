package com.androidjp.app.lambda;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.File;
import java.io.FileFilter;

/**
 * 使用 Java 8 Lambda 表达式
 *
 * <p>
 *   需要配置的几个步骤：
 *   1）在Project的build.gradle 中 buildscript->dependences->加入classpath 'me.tatarka:gradle-retrolambda:3.2.0'
 *   2）在app 的 build.gradle 中 头部，加上：apply plugin: 'me.tatarka.retrolambda'
 *   3）在app 的 build.gradle 的 android 块中， 加上：
 *   compileOptions {
 *   targetCompatibility 1.8
 *   sourceCompatibility 1.8
 *   }
 *
 *  最终：
 *  android {
 compileSdkVersion 24
 buildToolsVersion "24.0.0"

 defaultConfig {
 applicationId "com.androidjp.app"
 minSdkVersion 15
 targetSdkVersion 24
 versionCode 1
 versionName "1.0"
 }
 buildTypes {
 release {
 minifyEnabled false
 proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
 }
 }
 }
    注意：和compileSdkVersion等关系不大
 *   插件将lambda表达式的jdk支持降低了，允许android使用了
 * <p/>
 *
 * Created by androidjp on 16-7-4.
 */
public class LambdaActivity extends Activity{

    private static Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("gggg", "ggggg");
        }
    };

    FileFilter directoryFilter = File::isDirectory;//等价于： file -> file.isDirectory()

    FileFilter filter  = file -> {
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        testHandler();
    }

    private void testHandler() {
        Message message = new Message();
        message.what = 1;

        handler.sendMessage(message);
    }
}
