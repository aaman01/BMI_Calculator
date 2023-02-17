package com.example.bmicalculator;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight = findViewById(R.id.weighttext);
        EditText heightF = findViewById(R.id.heightF);
        EditText heightI = findViewById(R.id.heightI);
        Button button = findViewById(R.id.button);
        LinearLayout ll=findViewById(R.id.mainlayout);
        TextView textresult = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String W = weight.getText().toString();
                int weight = Integer.parseInt(W);
                int height_F = Integer.parseInt(heightF.getText().toString());
                int height_I = Integer.parseInt(heightI.getText().toString());
                 double height_meter = (height_F*12+height_I)*(0.0254);

                 double BMI= weight/(height_meter*height_meter);
                 if(BMI>25){
                     textresult.setText("You are OverWeight!!!");
                     ll.setBackgroundColor(getResources().getColor(R.color.red));

                 }else if(BMI<18){
                     textresult.setText("You are UnderWeight!");
                     ll.setBackgroundColor(getResources().getColor(R.color.green));
                 }else{
                     textresult.setText("You are Healthy!!");
                     ll.setBackgroundColor(getResources().getColor(R.color.yellow));
                 }


            }
        });
    }
}