package com.androidjp.app.fileio;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidjp.app.R;
import com.androidjp.app.utils.StorageUtil;
import com.androidjp.lib_four_components.activities.LogActivity;

/**
 *
 * 文件IO操作使用示例
 * Created by androidjp on 16-7-21.
 */
public class FileIoActivity extends LogActivity implements View.OnClickListener{

    private LinearLayout layoutBtnList;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fileio);

        initView();

    }

    private void initView() {
        layoutBtnList = (LinearLayout) findViewById(R.id.layout_file_btnlist);
        textView = (TextView) findViewById(R.id.tv_content);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button btn1 = new Button(this);
        btn1.setLayoutParams(layoutParams);
        btn1.setPadding(20,20,20,20);
        btn1.setText("输出所有相关系统路径");
        btn1.setTag(1001);
        btn1.setOnClickListener(this);

        layoutBtnList.addView(btn1);



    }


    @Override
    public void onClick(View v) {
        switch (((Integer)v.getTag())){
            case 1001:

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        String s = StorageUtil.getDirs();
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(s);
                            }
                        });
                    }
                };

                new Thread(runnable).start();


                break;

            case 1002:
                break;

        }
    }
}
