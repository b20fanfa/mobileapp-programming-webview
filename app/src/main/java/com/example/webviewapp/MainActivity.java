package com.example.webviewapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    private Object MyWebViewClient;


    public void showExternalWebPage(){
        WebView webView= new WebView(this);
        setContentView(webView);
        webView.loadUrl("https://synonymer.se//");
    }

    public void showInternalWebPage(){
        //WebViewClient myWebViewClient = new WebViewClient();
        //myWebView.setWebViewClient(myWebViewClient);
        WebViewClient myWebViewClient = new WebViewClient();
        myWebView.setWebViewClient((WebViewClient) MyWebViewClient);
        myWebView.loadUrl("file:///android_asset/assignment2.html");
        //myWebView.loadUrl("https://synonymer.se//");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myWebView = findViewById(R.id.my_webview);
        //myWebView.loadUrl("http://www.example.com");

        WebSettings webSettings = myWebView.getSettings();
        webSettings. setJavaScriptEnabled (true);



        //myWebView.loadUrl("file:///android_asset/assignment2.html");

        //har lagt till ett webview-element EXTERNAL
        // WebView webView= new WebView(this);
        //setContentView(webView);
        //webView.loadUrl("https://synonymer.se//");

        //LA till INTERNAL
        //WebViewClient myWebViewClient = new WebViewClient();
        //myWebView.setWebViewClient(myWebViewClient);
        // myWebView.loadUrl("https://synonymer.se//");
        //myWebView.loadUrl("file:///android_asset/assignment2.html");


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_external_web) {
            Log.d("==>","Will display external web page");
            showExternalWebPage();
            //return true;
        }

        if (id == R.id.action_internal_web) {
            Log.d("==>","Will display internal web page");
            showInternalWebPage();
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyWebViewClient {
    }
}

