package com.androidjp.lib_four_components.activities;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 *  * 尝试使用一个自定义的封装好的Activity，作为基础Activity
 * 我们通过判断当前sdk_int大于4.4(kitkat)
 * ，则通过代码的形式设置status bar为透明(这里其实可以通过
 * values-v19 的sytle.xml里设置windowTranslucentStatus属性为true来进行设置
 * ，但是在某些手机会不起效，所以采用代码的形式进行设置)。
 * 还需要注意的是我们这里的AppCompatAcitivity是android.support.v7.app.AppCompatActivity支持包中的AppCompatAcitivity
 * ,也是为了在低版本的android系统中兼容toolbar
 *
 * 沉浸式Activity
 * 包含：头部沉浸式TitleBar
 *
 * Created by androidjp on 16-7-1.
 */
public class ImmersionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
