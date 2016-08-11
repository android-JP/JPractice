package com.androidjp.lib_mvp.frame;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.androidjp.lib_mvp.base.BaseView;

/**
 * Created by androidjp on 16-8-9.
 */
public abstract class MvpActivity <P extends MvpPresenter> extends AppCompatActivity implements MvpView{
    public P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initMvp();
    }

    private void initMvp() {
        Mvp mvp = Mvp.getInstance();
        mvp.registerView(this.getClass(),this);
        mPresenter = (P) mvp.getPresenter(Mvp.getGenericType(this,0));
        mPresenter.initPresenter(getBaseView());
    }

    /**
     *
     * @return 确定关联的View
     */
    protected abstract BaseView getBaseView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Mvp.getInstance().unRegister(this.getClass());
        mPresenter.destory();///让View 和Presenter 解绑
    }
}
