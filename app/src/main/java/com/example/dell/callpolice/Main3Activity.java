package com.example.dell.callpolice;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class Main3Activity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private SystemBarTintManager tintManager;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main3);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null)
            actionBar.hide();

        initWindow();
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_na_1);
        navigationView = (NavigationView) findViewById(R.id.nav_1);

        View headerView = navigationView.getHeaderView(0);//获取头布局

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //item.setChecked(true);
                Toast.makeText(Main3Activity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
    }




    private void initWindow() {//初始化窗口属性，让状态栏和导航栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            tintManager = new SystemBarTintManager(this);
            int statusColor = Color.parseColor("#1976d2");
            tintManager.setStatusBarTintColor(statusColor);
            tintManager.setStatusBarTintEnabled(true);
        }
    }

}
