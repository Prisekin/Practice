package com.example.Practice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

/**
 * Created with IntelliJ IDEA.
 * User: prisekin
 * Date: 26.10.13
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class Second extends Activity{
     Button button; RadioGroup colors_group; Button button_more,button_less;
     RadioButton radio_red,radio_green,radio_blue;
    @Override
    public void onCreate(Bundle bund){
        super.onCreate(bund);
        setContentView(R.layout.task2);
        button=(Button)findViewById(R.id.button);
        colors_group=(RadioGroup)findViewById(R.id.colors);
        radio_red=(RadioButton)findViewById(R.id.red); radio_green=(RadioButton)findViewById(R.id.green);
        radio_blue=(RadioButton)findViewById(R.id.blue);
        if(radio_red.isChecked()){button.setTextColor(0xffff0000);}
        if(radio_green.isChecked()){button.setTextColor(0xff00ff00);}
        if(radio_blue.isChecked()){button.setTextColor(0xff0000ff);}
        button_more=(Button)findViewById(R.id.more);
        button_less=(Button)findViewById(R.id.less);
        button_more.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                button.setTextSize(button.getTextSize()+1);
            }
        });
        button_less.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                button.setTextSize(button.getTextSize()-1);
            }
        });
        colors_group.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radio_group, int id){
                switch(id){
                    case R.id.red: button.setTextColor(0xffff0000); break;
                    case R.id.green: button.setTextColor(0xff00ff00); break;
                    case R.id.blue: button.setTextColor(0xff0000ff); break;
                }
            }
        });
    }
}

