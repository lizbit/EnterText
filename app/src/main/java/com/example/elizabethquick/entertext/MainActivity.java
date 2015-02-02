package com.example.elizabethquick.entertext;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    Button hello;
    EditText entext;
    RadioGroup textColorChoice;
    RadioGroup bgColorChoice;
    EditText textSizeChoice;
    int textColor;
    int bgColor;
    int textSize;
    int bgColorValue;
    int textColorValue;
    String textSizeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = (Button) findViewById(R.id.button);
        entext = (EditText) findViewById(R.id.editText);
        textColorChoice = (RadioGroup) findViewById(R.id.textcolorradio);
        bgColorChoice = (RadioGroup) findViewById(R.id.bgcolorradio);
        textSizeChoice = (EditText) findViewById(R.id.textsize);
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
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_about){
            Intent aboutintent = new Intent(MainActivity.this, about.class);
            startActivity(aboutintent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeText(View view){
        Intent intent = new Intent(MainActivity.this, ShowText.class);
        bgColor = bgColorChoice.getCheckedRadioButtonId();
        textColor = textColorChoice.getCheckedRadioButtonId();
        textSizeString = textSizeChoice.getText().toString();
        if(textSizeString.equals("")){
            textSize = 24;
        }else{
            textSize = Integer.parseInt(textSizeString);
        }
        if(bgColor == R.id.bgRed){
            bgColorValue = 0xFFFF0000;
        }else if(bgColor == R.id.bgOrange){
            bgColorValue = 0xFFFFA000;
        }else if(bgColor == R.id.bgYellow){
            bgColorValue = 0xFFFFFF00;
        }else if(bgColor == R.id.bgGreen){
            bgColorValue = 0xFF00FF00;
        }else if(bgColor == R.id.bgBlue){
            bgColorValue = 0xFF0000FF;
        }else if(bgColor == R.id.bgPurple){
            bgColorValue = 0xFFC100FF;
        }else{
            bgColorValue = 0xFFFFFFFF;
        }
        if(textColor == R.id.textRed){
            textColorValue = 0xFFFF0000;
        }else if(textColor == R.id.textOrange){
            textColorValue = 0xFFFFA000;
        }else if(textColor == R.id.textYellow){
            textColorValue = 0xFFFFFF00;
        }else if(textColor == R.id.textGreen){
            textColorValue = 0xFF00FF00;
        }else if(textColor == R.id.textBlue){
            textColorValue = 0xFF0000FF;
        }else if(textColor == R.id.textPurple){
            textColorValue = 0xFFC100FF;
        }else{
            textColorValue = 0xFF000000;
        }
        intent.putExtra("textEntered", entext.getText().toString());
        intent.putExtra("bgColor", bgColorValue);
        intent.putExtra("textColor", textColorValue);
        intent.putExtra("textSize", textSize);
        startActivity(intent);
    }
}
