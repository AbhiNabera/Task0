package com.example.abhinabera.task0;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView count;
    Button increment, reset;
    String countvalue;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences("File", Context.MODE_PRIVATE);
        counter = sp.getInt("count", 0);
        count = (TextView) findViewById(R.id.textView1);
        increment = (Button) findViewById(R.id.button1);
        reset = (Button) findViewById(R.id.button2);
        count.setText("" + counter);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countvalue = count.getText().toString();
                counter = Integer.parseInt(countvalue);
                counter = counter + 1;
                count.setText("" + counter);


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                count.setText("" + counter);
            }
        });



    }

    @Override
    public void onStop(){
        super.onStop();
        SharedPreferences sp = getSharedPreferences("File", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt("count", counter);
        ed.apply();
        count = (TextView) findViewById(R.id.textView1);
        count.setText(counter + "");
    }

}
