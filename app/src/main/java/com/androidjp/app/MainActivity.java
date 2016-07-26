package com.androidjp.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidjp.app.actionbar.MyActionbarActivity;
import com.androidjp.app.eventdispatch.EventDispatchActivity;
import com.androidjp.app.fileio.FileIoActivity;
import com.androidjp.app.fragment.FragActivity;
import com.androidjp.app.menutest.MyMenuActivity;
import com.androidjp.app.recyclerview.CommonTabActivity;
import com.androidjp.app.service.MyBroadcastService;
import com.androidjp.lib_custom_view.titlebar.ImmerseTitleBar;
import com.androidjp.lib_four_components.activities.ImmersionActivity;

import java.util.List;

public class MainActivity extends ImmersionActivity implements View.OnClickListener{

    public static final String ACTION_TEST = "com.androidjp.app.ACTION_TEST";

    private boolean isBindService = false;

    private ServiceConnection sc;

    Intent hideCallIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);

        ((ImmerseTitleBar)getTitleBar()).showView(ImmerseTitleBar.TitleBarItem.BTN_LEFT).showView(ImmerseTitleBar.TitleBarItem.TITLE).showView(ImmerseTitleBar.TitleBarItem.BTN_RIGHT);
        ((ImmerseTitleBar)getTitleBar()).setLeftBtnListener(() -> {
            hideCallIntent = new Intent();
            hideCallIntent.setAction("com.androidjp.app.ACTION_TEST");

            startActivityForResult(hideCallIntent,0);
            startService(createExplicitFromImplicitIntent(this,hideCallIntent));
        });


        initView();

        this.setCanceledCallback(() -> {
            Toast.makeText(this,"He canceled!", Toast.LENGTH_SHORT).show();
        });
        this.setOkCallback(() -> {
            Toast.makeText(this,"He OK!", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    protected int setRootLayout() {
        return R.layout.layout_maincontent;
    }

    private void initView() {

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.layout_main);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        Button btn1 = new Button(this);
        btn1.setTag(1001);
        btn1.setText("自定义事件分发顺序");
        btn1.setLayoutParams(layoutParams);
        btn1.setPadding(10,10,10,10);
        btn1.setOnClickListener(this);

        Button btn2 = new Button(this);
        btn2.setTag(1002);
        btn2.setText("测试RecyclerView");
        btn2.setLayoutParams(layoutParams);
        btn2.setPadding(10,10,10,10);
        btn2.setOnClickListener(this);

        Button btn3 = new Button(this);
        btn3.setTag(1003);
        btn3.setText("老式的ActionBar和自定义ActionBar");
        btn3.setLayoutParams(layoutParams);
        btn3.setPadding(10,10,10,10);
        btn3.setOnClickListener(this);

        Button btn4 = new Button(this);
        btn4.setTag(1004);
        btn4.setText("Menu实测");
        btn4.setLayoutParams(layoutParams);
        btn4.setPadding(10,10,10,10);
        btn4.setOnClickListener(this);

        Button btn5 = new Button(this);
        btn5.setTag(1005);
        btn5.setText("绑定一个Service");
        btn5.setLayoutParams(layoutParams);
        btn5.setPadding(10,10,10,10);
        btn5.setOnClickListener(this);

        Button btn6 = new Button(this);
        btn6.setTag(1006);
        btn6.setText("广播一个");
        btn6.setLayoutParams(layoutParams);
        btn6.setPadding(10,10,10,10);
        btn6.setOnClickListener(this);

        Button btn7 = new Button(this);
        btn7.setTag(1007);
        btn7.setText("输出所有可获得的系统路径");
        btn7.setLayoutParams(layoutParams);
        btn7.setPadding(10,10,10,10);
        btn7.setOnClickListener(this);

        Button btn8 = new Button(this);
        btn8.setTag(1008);
        btn8.setText("测试Fragment的addToBackStack()");
        btn8.setLayoutParams(layoutParams);
        btn8.setPadding(10,10,10,10);
        btn8.setOnClickListener(this);


        mainLayout.addView(btn1);
        mainLayout.addView(btn2);
        mainLayout.addView(btn3);
        mainLayout.addView(btn4);
        mainLayout.addView(btn5);
        mainLayout.addView(btn6);
        mainLayout.addView(btn7);
        mainLayout.addView(btn8);

    }


    @Override
    public void onClick(View view) {
        switch (((Integer)view.getTag())){
            case 1001:
                startActivity(EventDispatchActivity.actionView(this, null));
                break;
            case 1002:
                startActivity(new Intent(this, CommonTabActivity.class));
                break;
            case 1003:
                startActivity(new Intent(this, MyActionbarActivity.class));
                break;
            case 1004:
                startActivity(new Intent(this, MyMenuActivity.class));
                break;
            case 1005:
                if (!isBindService) {
                    if (sc == null){
                        sc = new ServiceConnection() {
                            @Override
                            public void onServiceConnected(ComponentName name, IBinder service) {
                                Toast.makeText(MainActivity.this, "连接服务成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onServiceDisconnected(ComponentName name) {
                                Toast.makeText(MainActivity.this, "服务断开", Toast.LENGTH_SHORT).show();
                            }
                        };
                    }

                    bindService(new Intent(this, MyBroadcastService.class), sc, BIND_AUTO_CREATE);
                    isBindService = true;
                }else{
                    unbindService(sc);
                    isBindService = false;
                }

//                startActivity(new Intent(this, MyMenuActivity.class));
                break;
            case 1006:
                sendBroadcast(new Intent(R.string.action_head+"111"));
                sendBroadcast(new Intent("111"));

//                startActivity(new Intent(this, MyMenuActivity.class));
                break;

            case 1007:
                startActivity(new Intent(this, FileIoActivity.class));
                break;

            case 1008:
                startActivity(new Intent(this, FragActivity.class));
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sc!=null){
            unbindService(sc);
        }
        if(hideCallIntent!=null){
            stopService(createExplicitFromImplicitIntent(this,hideCallIntent));
        }
    }



    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }

}


