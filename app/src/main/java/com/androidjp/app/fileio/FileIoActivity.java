package com.androidjp.app.fileio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidjp.app.R;
import com.androidjp.app.fileio.bean.Student;
import com.androidjp.app.utils.StorageUtil;
import com.androidjp.lib_four_components.activities.LogActivity;

import java.util.List;

/**
 *
 * 文件IO操作使用示例
 * Created by androidjp on 16-7-21.
 */
public class FileIoActivity extends LogActivity implements View.OnClickListener{

    private LinearLayout layoutBtnList;
    private TextView textView;

    private List<Student> studentList;



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

        Button btn2 = new Button(this);
        btn2.setLayoutParams(layoutParams);
        btn2.setPadding(20,20,20,20);
        btn2.setText("存储Student列表到文件");
        btn2.setTag(1002);
        btn2.setOnClickListener(this);
        layoutBtnList.addView(btn2);




    }


    @Override
    public void onClick(View v) {
        switch (((Integer)v.getTag())){
            case 1001:

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        String s = StorageUtil.getDirs();
                        Log.e("各个路径",s);
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
