package com.androidjp.lib_binder_aidl;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.android.internal.telephony.ITelephony;

/**
 * 电话工具类
 * Created by androidjp on 16-7-15.
 */
public class PhoneUtils {


    private static PhoneUtils sInstance;

    //电话监听功能启动与否
    private boolean functionOpen = true;
    private TelephonyManager mTelephonyManager;
    private AudioManager mAudioManager;
    private Context mContext = null;
    private PhoneCallListener mPhoneCallListener;

    private PhoneUtils(Context context){
        if(mContext==null){
            mContext = context;
        }

        mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mPhoneCallListener = new PhoneCallListener();
        mTelephonyManager.listen(mPhoneCallListener, PhoneCallListener.LISTEN_CALL_STATE);
    }

    public PhoneUtils getInstance(Context context){

        if (sInstance==null){
            synchronized (PhoneUtils.class){
                if (sInstance == null){
                    sInstance = new PhoneUtils(context);
                }
            }
        }
        return sInstance;
    }




    //识别电话并挂电话
    public void endCall(Context context){


        /**
         * 方式一
         **/
        Class<TelephonyManager> clazz = TelephonyManager.class;
        Method getITelephonyMethod = null;

        try {
            getITelephonyMethod = clazz.getDeclaredMethod("getITelephony", (Class[])null);
            getITelephonyMethod.setAccessible(true);
            ITelephony iTelephony  = (ITelephony) getITelephonyMethod.invoke(mTelephonyManager,(Object[])null);
            iTelephony.endCall();
            Log.v(this.getClass().getName(), "endCall......");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        /**
         * 方式二
         */
        try {

            Class cla = PhoneUtils.class.getClassLoader().loadClass("android.os.ServiceManager");
            Method method  = cla.getDeclaredMethod("getService",String.class);
            IBinder iBinder = (IBinder) method.invoke(null, "TELEPHONE_SERVICE");
            ITelephony.Stub.asInterface(iBinder).endCall();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }


    /**
     * 重写的PhoneStateListener
     * Created by androidjp on 16-7-15.
     */
    public class PhoneCallListener extends PhoneStateListener {



        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            Log.v(this.getClass().getName(), "onCallStateChanged-state: " + state);
            Log.v(this.getClass().getName(), "onCallStateChanged-incomingNumber: " + incomingNumber);
            switch (state)  {
                case TelephonyManager.CALL_STATE_IDLE:
                    mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    //CALL_STATE_OFFHOOK;
                    break;
                case TelephonyManager.CALL_STATE_RINGING:

                    ////TODO：这里，应该可以读取数据库或者SharedPreferred的文件中的黑名单

                    if ("123456".equals(incomingNumber)){
                        //mTelephonyService.endCall();
                        endCall(mContext);
                    }else{
                        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    }
                    break;
                default:
                    break;
            }
            super.onCallStateChanged(state, incomingNumber);
        }
        @Override
        public void onDataConnectionStateChanged(int state) {
            Log.v(this.getClass().getName(), "onDataConnectionStateChanged-state: " + state);
            super.onDataConnectionStateChanged(state);
        }
        @Override
        public void onDataConnectionStateChanged(int state, int networkType) {
            Log.v(this.getClass().getName(), "onDataConnectionStateChanged-state: " + state);
            Log.v(this.getClass().getName(), "onDataConnectionStateChanged-networkType: " + networkType);
            super.onDataConnectionStateChanged(state, networkType);
        }
        @Override
        public void onServiceStateChanged(ServiceState serviceState) {
            Log.v(this.getClass().getName(), "onServiceStateChanged-ServiceState: " + serviceState);
            super.onServiceStateChanged(serviceState);
        }
        @Override
        public void onSignalStrengthChanged(int asu) {
            Log.v(this.getClass().getName(), "onSignalStrengthChanged-asu: " + asu);
            super.onSignalStrengthChanged(asu);
        }
        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            Log.v(this.getClass().getName(), "onSignalStrengthsChanged-signalStrength: " + signalStrength);
            super.onSignalStrengthsChanged(signalStrength);
        }
    }
}
