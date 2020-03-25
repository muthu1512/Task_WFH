package com.example.taskworkfromhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
private static final String LOG_TAG=MainActivity.class.getSimpleName();
private static  int count=0;
    TextView ColorShow;
private String colorArray[]={"red","pink","purple","deep_purple","indigo","blue","light_blue","cyan","teal","green",
        "light_green","lime","yellow","amber","orange","deep_orange","brown","grey","blue_grey","black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Countclick=findViewById(R.id.Count);
        final TextView Countshow=findViewById(R.id.DisplayCount);
        ColorShow=findViewById(R.id.DisplayColor);
        Button ChangeColor=findViewById(R.id.Color);
        Countclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hi hello", LENGTH_SHORT).show();
                count++;

                Countshow.setText(String.valueOf(count));
            }
        });
        Log.i(LOG_TAG,"Hi It's Working");
        Intent i=new Intent(getApplicationContext(),Article.class);
        startActivity(i);
        
    }

    public void ColourChange(View view) {
        Random random=new Random();
        String color=colorArray[random.nextInt(20)];
        int colorResourceName=getResources().getIdentifier(color,"color",getApplicationContext().getPackageName());
        int colorRes= ContextCompat.getColor(this,colorResourceName);
        ColorShow.setBackgroundColor(colorRes);
    }
}
