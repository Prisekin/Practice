package com.example.Practice;
import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;
import android.webkit.WebView;
/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 27.10.13
 * Time: 0:27
 * To change this template use File | Settings | File Templates.
 */
public class WebHelp extends Activity {
    @Override
    public void onCreate(Bundle bund){
        super.onCreate(bund);
        LinearLayout line=new LinearLayout(this);
        WebView web_view_help=new WebView(this);
        web_view_help.loadUrl(getIntent().getStringExtra("path"));
        line.addView(web_view_help);
        setContentView(line);
    }
}
