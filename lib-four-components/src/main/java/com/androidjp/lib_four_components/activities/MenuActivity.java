package com.androidjp.lib_four_components.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * 用于测试ToolBar、ActionBar、Menu的布局
 * Created by androidjp on 16-7-18.
 */
public class MenuActivity extends AppCompatActivity {

    protected boolean isMenuWork = true;

    protected static final int EIGHT_ID = Menu.FIRST +1;///其中：Menu.FIRST为最小编号
    protected static final int SIXTEEN_ID = Menu.FIRST+2;
    protected static final int TWENTY_FOUR_ID = Menu.FIRST+3;
    protected static final int TWO_ID = Menu.FIRST+4;
    protected static final int THIRTY_TWO_ID = Menu.FIRST+5;
    protected static final int FORTY_ID = Menu.FIRST+6;
    protected static final int ONE_ID = Menu.FIRST+7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * 设置是否启动Menu功能
     * @param b true or false
     */
    protected void setMenuWork(boolean b){
        isMenuWork = b;
    }


    ///--------------------对于OptionsMenu（点击硬件按钮“Menu”时触发）
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*第一个参数是groupId，如果不需要可以设置为Menu.NONE。
        将若干个menu item都设置在同一个Group中，可以使用setGroupVisible()，setGroupEnabled()，setGroupCheckable()这样的方法，
        而不需要对每个item都进行setVisible(), setEnable(), setCheckable()这样的处理，这样对我们进行统一的管理比较方便
       * 第二个参数就是item的ID，我们可以通过menu.findItem(id)来获取具体的item
       * 第三个参数是item的顺序，一般可采用Menu.NONE，具体看本文最后MenuInflater的部分
       * 第四个参数是显示的内容，可以是String，或者是引用Strings.xml的ID*/
        MenuItem item1 = menu.add(Menu.NONE, ONE_ID,Menu.NONE,"1 Pixel");
        item1.setIcon(android.R.drawable.ic_menu_search);///设置图片

        menu.add(Menu.NONE, TWO_ID, Menu.NONE, "2 Pixels");
        menu.add(Menu.NONE, EIGHT_ID, Menu.NONE, "8 Pixels");
        menu.add(Menu.NONE, SIXTEEN_ID, Menu.NONE, "16 Pixels");
        menu.add(Menu.NONE, TWENTY_FOUR_ID, Menu.NONE, "24 Pixels");
        menu.add(Menu.NONE, THIRTY_TWO_ID, Menu.NONE, "32 Pixels");
        menu.add(Menu.NONE, FORTY_ID, Menu.NONE, "40 Pixels");



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    ///----------------------对于ContextMenu（长按指定View时会弹出）


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }
}
