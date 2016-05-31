package com.example.abhinabera.task0;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaring variables.
    TextView count;
    int counter;
    Button increment, reset;
    String countvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assigning the respective ids to components.
        count = (TextView)findViewById(R.id.textView1);
        increment = (Button)findViewById(R.id.button1);
        reset = (Button)findViewById(R.id.button2);

        //On click function for button 1.
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countvalue = count.getText().toString(); //Getting the text from text view, converting it to string and storing it in a variable.
                counter = Integer.parseInt(countvalue); //Converting the string value to integer.
                counter = counter + 1; //Incrementing by 1.
                count.setText("" + counter); //Setting text in text view.

            }
        });

        //On click function for button 2.
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.setText("" + 0); //Reset the count to 0.
            }
        });

    }
}
