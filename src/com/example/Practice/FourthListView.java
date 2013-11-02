package com.example.Practice;

/**
 * Created with IntelliJ IDEA.
 * User: prisekin
 * Date: 02.11.13
 * Time: 10:48
 * To change this template use File | Settings | File Templates.
 */
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.view.KeyEvent;
import android.widget.TextView;
import android.text.TextWatcher;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.view.View;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.content.Intent;

public class FourthListView extends Activity implements TextWatcher,ListView.OnItemClickListener{
    ListView list_view; ArrayAdapter<String> adapter; EditText input_text; LinearLayout layout;
    ListView hints_list; ArrayAdapter<String> hints_list_adapter; String[] text_hints;
    ArrayList<String> visible_hints;
    @Override
    public void onCreate(Bundle bund){
        super.onCreate(bund);
        setContentView(R.layout.task4_list_view);
        list_view=(ListView)findViewById(R.id.spisok);
        layout=(LinearLayout)findViewById(R.id.layout);
        text_hints=getResources().getStringArray(R.array.text_hints);
        visible_hints=new ArrayList<String>();        //visible_hints=text_hints.clone()
        hints_list=(ListView)findViewById(R.id.hints_list);
        hints_list_adapter=new ArrayAdapter(this,R.layout.hint_list,visible_hints);
        hints_list.setAdapter(hints_list_adapter);
        hints_list.setVisibility(View.GONE);
        hints_list.setOnItemClickListener(this);
        input_text=(EditText)findViewById(R.id.text);
        input_text.addTextChangedListener(this);
        //String[] items= new String[]{"first","second","third"};
        String[] items=getResources().getStringArray(R.array.listview_strings);
        adapter=new ArrayAdapter(this,R.layout.listview_item,R.id.list_item,items);
        list_view.setAdapter(adapter);
    }
    public void beforeTextChanged(CharSequence s,int start,int before,int count){
        /*String typed_text=s.toString();
        Toast.makeText(this,typed_text,Toast.LENGTH_SHORT);*/
    }
    public void onTextChanged(CharSequence s,int start,int before,int count){
        /*String typed_text=s.toString();
        Toast.makeText(this,typed_text,Toast.LENGTH_SHORT);*/
    }
    public void afterTextChanged(Editable e){
        String typed_text=e.toString();
        //Toast.makeText(this,typed_text,Toast.LENGTH_SHORT).show();
        /*TextView show_typed_text=new TextView(this);
        show_typed_text.setText(typed_text);*/
        //hints_list_adapter.clear();
        int coincidence_count=0; visible_hints.clear();
        if(typed_text.length()!=0){
        for(int i=0;i<text_hints.length;i++){
            if(text_hints[i].contains(typed_text)){
            visible_hints.add(text_hints[i]);
            coincidence_count++;}
        }}
        if(coincidence_count!=0){ hints_list.setVisibility(View.VISIBLE);}else{hints_list.setVisibility(View.GONE);}
        hints_list_adapter.notifyDataSetInvalidated();  //.notifyDataSetChanged();
    }
    @Override
    public void onItemClick(AdapterView<?> a, View v,int pos,long l){
        String selected_text=visible_hints.get(pos);
        Toast.makeText(this,selected_text,Toast.LENGTH_LONG).show();
        input_text.setText(selected_text);
    }
    public void openURL(View v){
        Intent URL_intent=new Intent(this,WebHelp.class);
        URL_intent.putExtra("path",input_text.getText().toString());
        startActivity(URL_intent);
    }
}
