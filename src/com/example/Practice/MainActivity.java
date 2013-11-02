package com.example.Practice;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {
Intent intent1,intent2,intent3,intent4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        intent1=new Intent(this,First.class);
        intent2=new Intent(this,Second.class);
        intent3=new Intent(this,Third.class);
        intent4=new Intent(this,FourthListView.class);
        setContentView(R.layout.main);

    }
    public void ButtonClick(View v){
        switch(v.getId()){
            case R.id.button1: startActivity(intent1); finish(); break;
            case R.id.button2: startActivity(intent2); break;
            case R.id.button3: startActivity(intent3); break;
            case R.id.button4: startActivity(intent4); break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
