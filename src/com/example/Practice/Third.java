package com.example.Practice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ImageView.ScaleType;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;
import android.view.View.OnLongClickListener;

/**
 * Created with IntelliJ IDEA.
 * User: prisekin
 * Date: 26.10.13
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class Third extends Activity implements OnItemSelectedListener,OnLongClickListener {
ImageView image; RadioGroup scale_group; Spinner spinner;
    @Override
    public void onCreate(Bundle bund){
        super.onCreate(bund);
        setContentView(R.layout.task3_spinner);
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinner_adapter=ArrayAdapter.createFromResource(this,R.array.spinner,android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinner_adapter);
        image=(ImageView)findViewById(R.id.image);
        image.setImageResource(R.drawable.kotik);
        spinner.setOnItemSelectedListener(this);
        image.setOnLongClickListener(this);
/*        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.task3);
        image=(ImageView)findViewById(R.id.image);
        //LayoutParams lay_pars=image.getLayoutParams(); lay_pars.height=(int)(0.7*(float)lay_pars.height);
        //image.setLayoutParams(lay_pars);
        image.setScaleType(ScaleType.CENTER); ((RadioButton)findViewById(R.id.center)).setChecked(true);
        image.setBackgroundColor(0xff7f007f);
        image.setImageResource(R.drawable.kotik);

        scale_group=(RadioGroup)findViewById(R.id.scale_types);
        scale_group.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radio, int id){
                switch(id){
                    case R.id.center: image.setScaleType(ScaleType.CENTER); break;
                    case R.id.center_crop: image.setScaleType(ScaleType.CENTER_CROP); break;
                    case R.id.center_inside: image.setScaleType(ScaleType.CENTER_INSIDE); break;
                    case R.id.fit_center: image.setScaleType(ScaleType.FIT_CENTER); break;
                    case R.id.fit_end: image.setScaleType(ScaleType.FIT_END); break;
                    case R.id.fit_start: image.setScaleType(ScaleType.FIT_START); break;
                    case R.id.fit_xy: image.setScaleType(ScaleType.FIT_XY); break;
                    case R.id.matrix: Matrix matrix=new Matrix(); matrix.reset();
                        matrix.postScale((float) 0.4, (float) 0.4); matrix.postRotate((float)15.0,(float)0,(float)0);
                        matrix.postTranslate((float)30,(float)0);
                        image.setScaleType(ScaleType.MATRIX); image.setImageMatrix(matrix);  break;
                }
            }
        });*/
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
       switch(position){
           case 0: image.setScaleType(ScaleType.CENTER); break;
           case 1: image.setScaleType(ScaleType.CENTER_CROP); break;
           case 2: image.setScaleType(ScaleType.CENTER_INSIDE); break;
           case 3: image.setScaleType(ScaleType.FIT_CENTER); break;
           case 4: image.setScaleType(ScaleType.FIT_END); break;
           case 5: image.setScaleType(ScaleType.FIT_START); break;
           case 6: image.setScaleType(ScaleType.FIT_XY); break;
           case 7: image.setScaleType(ScaleType.MATRIX); Matrix matrix=new Matrix(); matrix.reset();
               matrix.postScale((float) 0.4, (float) 0.4); matrix.postRotate((float)15.0,(float)0,(float)0);
               matrix.postTranslate((float) 30, (float) 0); image.setImageMatrix(matrix); break;
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    public boolean onLongClick(View v){
        Intent helper=new Intent(this,WebHelp.class);
        helper.putExtra("path","http://developer.android.com/reference/android/widget/ImageView.ScaleType.html");
        startActivity(helper);
        return true;
    }
}


