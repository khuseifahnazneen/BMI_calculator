package com.awais.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity<height, weight> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight, height;
        TextView Result;
        Button Calculate;
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        Result = (TextView)findViewById(R.id.Result);
        Calculate=(Button)findViewById(R.id.Calculate);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wei=weight.getText().toString();
                String hei=height.getText().toString();
                if(wei.equals("")){
                    weight.setError("Please Enter Your Weight.");
                    weight.requestFocus();
                    return;
            }
                if(hei.equals("")){
                    height.setError("Please Enter Your Height.");
                    height.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(wei);
                float height = Float.parseFloat(hei)/100;
                float BMIvalue = BMICalculartor(weight,height);
                Result.setText("BMI = "+BMIvalue);
            }
    });
}

    public float BMICalculartor(float weigth, float height){
        return weigth/(height*height);
    }
}
