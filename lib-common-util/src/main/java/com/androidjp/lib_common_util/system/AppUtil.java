package com.androidjp.lib_common_util.system;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;

import java.util.List;

/**
 * Created by androidjp on 16-7-1.
 */
public class AppUtil {

    //------------------------------------------------

    /**
     * 获取当前的App的任务栈情况
     * @param context 被检测的app上下文环境
     * @return 返回 当前app的任务栈信息
     */
    public static String getCurrentStack(Context context){

        StringBuilder sb = new StringBuilder();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> infos = am.getRunningTasks(Integer.MAX_VALUE);
        for (int i = 0; i < infos.size(); i++) {
            ActivityManager.RunningTaskInfo info = infos.get(i);
            sb.append("<font color=\"#ff0000\">Stack" + i + "</font>").append("<br/>");
            sb.append("\t <b><i>ID:</i></b>" + info.id).append("<br/>");
            sb.append("\t <b><i>Num Running:</i></b>" + info.numRunning).append("<br/>");
            sb.append("\t <b><i>Num Activities:</i></b>" + info.numActivities).append("<br/>");
            sb.append("\t <b><i>Description:</i></b>" + info.description).append("<br/>");
            sb.append("\t <b><i>Top Activity:</i></b>" + toComponentName(info.topActivity)).append("<br/>");
            sb.append("\t <b><i>Base Activity:</i></b>" + toComponentName(info.baseActivity)).append("<br/>");
        }
        return sb.toString();
    }

    private static String toComponentName(ComponentName cn){
        if (cn==null)
            return null;
        else
            return cn.getPackageName()+"/"+cn.getShortClassName();
    }


    //----------------------------------------------------------
}
