package com.androidjp.lib_mvp.frame;

import android.content.Context;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例模式
 * M和P 实例，一次创建，多次复用
 * V 实例，会不断更新为最近使用的实例
 * Created by androidjp on 16-8-9.
 */
public class Mvp<M extends MvpModel, V extends MvpView, P extends MvpPresenter> {
    public Map<String, Object> sInstanceMap;
    public Context mContext;

    private Mvp() {

    }

    private static class InstanceHolder {
        private static final Mvp SINSTANCE = new Mvp();
    }

    public static Mvp getInstance() {
        return InstanceHolder.SINSTANCE;
    }

    //-----------------------------------------------------


    public void init(Context context){
        this.mContext = context;
    }

    public Context getApplicationContext(){
        return mContext;
    }


    /**
     * 实例化Map
     */
    private void initMap() {
        if (sInstanceMap == null) {
            sInstanceMap = new ConcurrentHashMap<>();
        }
    }

    /**
     * 注册Model层实例
     *
     * @param mClass
     */
    public void registerModel(Class<M> mClass) {
        initMap();

        M mInstance = null;

        ///通过类名作为键，这样一来，model层中的每一个类，就只能有一个实例存在,
        ///于是，省去了创建model层单例模式的类的过程
        if (!sInstanceMap.containsKey(mClass.getName())) {
            try {
                mInstance = (M) Class.forName(mClass.getName()).newInstance();
                sInstanceMap.put(mClass.getName(), mInstance);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 注册View层实例
     *
     * @param vClass
     * @param vInstance
     */
    public void registerView(Class<V> vClass, V vInstance) {
        initMap();

        sInstanceMap.put(vClass.getName(), vInstance);
    }


    /**
     * 注册 Presenter 实例，同样是保证每一个Presenter类只有一个存在
     *
     * @param pClass
     */
    public void registerPresenter(Class<P> pClass) {
        initMap();
        P pInstance = null;

        if (!sInstanceMap.containsKey(pClass.getName())) {
            try {
                pInstance = (P) Class.forName(pClass.getName()).newInstance();
                sInstanceMap.put(pClass.getName(), pInstance);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取Model层 类实例
     * @param mClass
     * @return
     */
    public M getModel(Class<M> mClass) {
        initMap();

        if (!sInstanceMap.containsKey(mClass.getName())) {
            registerModel(mClass);
        }
        return (M) sInstanceMap.get(mClass.getName());
    }


    /**
     * 每次返回这个View的最新实例
     */
    public V getView(Class<V> vClass) {
        if (sInstanceMap == null)
            return null;
        if (!sInstanceMap.containsKey(vClass.getName()))
            return null;
        else
            return (V) sInstanceMap.get(vClass.getName());
    }


    /**
     * 返回Presenter类实例
     * @param pClass
     * @return
     */
    public P getPresenter(Class<P> pClass){
        initMap();

        if (!sInstanceMap.containsKey(pClass.getName())) {
            registerPresenter(pClass);
        }
        return (P) sInstanceMap.get(pClass.getName());
    }


    /**
     * 取消注册这个类实例
     * @param clazz
     */
    public  void unRegister(Class clazz){
        if (sInstanceMap == null)
            return;
        sInstanceMap.remove(clazz.getName());
    }


    /**
     * 获取父类泛型的类型
     *
     * @param o
     * @param i
     * @return
     */
    public static Class getGenericType(Object o, int i) {
        Type type = o.getClass().getGenericSuperclass();
        ParameterizedType p = (ParameterizedType) type;
        Class c = (Class) p.getActualTypeArguments()[i];
        return c;
    }


}
