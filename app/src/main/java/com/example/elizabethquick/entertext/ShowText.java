package com.example.elizabethquick.entertext;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ShowText extends ActionBarActivity {
    TextView showingtext;
    RelativeLayout rl;
    Intent intent;
    String stringData;
    int bgColor;
    int textColor;
    int textSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);
        showingtext = (TextView) findViewById(R.id.showhw);
        rl = (RelativeLayout) findViewById(R.id.screen2);
        intent = getIntent();
        if(intent != null){
            stringData = intent.getStringExtra("textEntered");
            bgColor = intent.getIntExtra("bgColor", 0xFFFFFFFF);
            textColor = intent.getIntExtra("textColor", 0xFF000000);
            textSize = intent.getIntExtra("textSize", 24);
        }
        showingtext.setText(stringData);
        showingtext.setTextColor(textColor);
        showingtext.setTextSize(textSize);
        rl.setBackgroundColor(bgColor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_text, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_about){
            Intent aboutintent = new Intent(ShowText.this, about.class);
            startActivity(aboutintent);
        }

        return super.onOptionsItemSelected(item);
    }
}
