package com.fengjustin.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
SeekBar seek;
TextView one;
    TextView two;
    TextView three;
    TextView four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        seek=findViewById(R.id.seek);
        one=findViewById(R.id.textBox1);
        two=findViewById(R.id.textBox2);
        three=findViewById(R.id.textBox3);
        four=findViewById(R.id.textBox4);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub

                one.setTextSize((float)progress*(float)0.2);
                two.setTextSize((float)progress*(float)0.2);
                three.setTextSize((float)progress*(float)0.2);
                four.setTextSize((float)progress*(float)0.2);

            }
    });
    }
    public void onClick (View v) {
        switch(v.getId())
        {
            case R.id.textBox1:

                editor.putInt("Text1", sharedPreferences.getInt("Text1",0)+1);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Textbox 1: "+sharedPreferences.getInt("Text1",0), Toast.LENGTH_LONG) .show();
                break;
            case R.id.textBox2:
                editor.putInt("Text2", sharedPreferences.getInt("Text2",0)+1);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Textbox 2", Toast.LENGTH_LONG) .show();

                break;
            case R.id.textBox3:
                editor.putInt("Text3", sharedPreferences.getInt("Text3",0)+1);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Textbox 3", Toast.LENGTH_LONG) .show();

                break;
            case R.id.textBox4:
                editor.putInt("Text4", sharedPreferences.getInt("Text4",0)+1);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Textbox 4", Toast.LENGTH_LONG) .show();
                break;
        }
    }
}
