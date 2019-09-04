package com.qingshangzuo.shape_demo;


import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import static android.graphics.Color.BLACK;

public class MainActivity extends AppCompatActivity {

    //用户名、手机号
    private TextView usernameLogin,phoneLogin;
    //输入框
    private EditText edt_username,edt_password,edt_phone,edt_yanzhengma;
    //下划线
    private View line1,line2;
    //布局
    private LinearLayout userLoginLayout,phoneLoginLayout;
    //登录
    private Button login;
    //验证码
    private Button btn_yanzhnegma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bmob.initialize(MainActivity.this,"3a2ddaeaecbf9f860131474e24633c54");


        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        userLoginLayout = findViewById(R.id.userLoginLayout);
        phoneLoginLayout = findViewById(R.id.phoneLoginLayout);

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        edt_phone = findViewById(R.id.edt_phone);
        edt_yanzhengma = findViewById(R.id.edt_yanzhengma);
        btn_yanzhnegma = findViewById(R.id.btn_yanzhnegma);  //获取验证码

        login = findViewById(R.id.login);  // 组件化登录按钮

        //用户名登录布局
        findViewById(R.id.phoneLogin).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                line1.setVisibility(View.GONE);    // GONE ：隐藏并且不占空间  INVISIBLE ：隐藏并且占空间
                line2.setVisibility(View.VISIBLE);  // VISIBLE ：显示
                userLoginLayout.setVisibility(View.GONE);
                phoneLoginLayout.setVisibility(View.VISIBLE);
            }
        });

        //手机号登录布局
        findViewById(R.id.usernameLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.GONE);
                userLoginLayout.setVisibility(View.VISIBLE);
                phoneLoginLayout.setVisibility(View.GONE);
            }
        });

        findViewById(R.id.btn_yanzhnegma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*BmobSMS.requestSMSCode(edt_phone.getText().toString(), "验证码",
                        new QueryListener<Integer>() {
                    @Override
                    public void done(Integer smsId, BmobException e) {
                        if(e == null){
                            Toast.makeText(MainActivity.this,"验证码已发送",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/
            }
        });

        //登录
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断 userLoginLayout 布局是否显示
                if(userLoginLayout.getVisibility() == View.VISIBLE){
                    Toast.makeText(MainActivity.this, edt_username.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, edt_phone.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
