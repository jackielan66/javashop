package com.example.hm_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hm_ui.model.Role;
import com.example.hm_ui.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Role role1 = new Role(0, "承运人员", "实名上岗收入高涨", "/static/img/role1.png");
    Role role2 = new Role(1, "商家", "轻松获取周边客流", "/static/img/role2.png");
    Role role3 = new Role(2, "消费者", "门店自提省时省钱", "/static/img/role1.png");


    List<Role> roles = new ArrayList<>();


    private void addItemView(final Role data){
        LinearLayout roleWrap = findViewById(R.id.role_wrap);

        // 外围item创建个线性Item布局
        LinearLayout item = new LinearLayout(this);
        item.setOrientation(LinearLayout.HORIZONTAL);
        item.setPadding(42,42,42,0);
        item.setBackgroundColor(Color.parseColor("#ffffff"));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0,0,0,60);
        item.setLayoutParams(lp);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(HomeActivity.this, LogActivity.class);
                intent.putExtra("title", data.role);
                intent.putExtra("id", data.id);
                startActivity(intent);
            }
        });


        // 左边开始
        LinearLayout leftArea = new LinearLayout(this);
        LinearLayout.LayoutParams leftAreaParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,2);
        leftArea.setLayoutParams(leftAreaParams);
        leftArea.setOrientation(LinearLayout.VERTICAL);

        TextView textName = new TextView(this);
        textName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textName.setTextColor(Color.parseColor("#000000"));
        textName.setTextSize(21);
        textName.setText(data.role);


        TextView textDsc = new TextView(this);
        textDsc.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        textDsc.setTextSize(14);
        textDsc.setText(data.xtitle);

        leftArea.addView(textName);
        leftArea.addView(textDsc);

        // 左边结束

        // 右边开始
        LinearLayout rightArea = new LinearLayout(this);
        LinearLayout.LayoutParams rightParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        rightParams.gravity = Gravity.RIGHT;
//        rightParams.lay
        rightArea.setLayoutParams(rightParams);
        rightArea.setGravity(Gravity.END);

        ImageView avatar = new ImageView(this);
        LinearLayout.LayoutParams imLp = new LinearLayout.LayoutParams(160,160);
        avatar.setLayoutParams(imLp);
        avatar.setImageResource(data.id == 1 ?  R.mipmap.role1 : data.id == 2 ? R.mipmap.role2:R.mipmap.role3);
        rightArea.addView(avatar);
        // 右边end



        item.addView(leftArea);
        item.addView(rightArea);

        roleWrap.addView(item);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);


        for (Role r : roles){
            addItemView(r);
        }



    }
}
