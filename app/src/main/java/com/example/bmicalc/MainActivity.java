package com.example.bmicalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight , edtHeightft, edtHeightin;
        AppCompatButton btncalc;
        LinearLayout ll;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightft = findViewById(R.id.edtHeightFt);
        edtHeightin = findViewById(R.id.edtHeightIn);
        btncalc = findViewById(R.id.btncalc);
        txtResult = findViewById(R.id.txtResult);
        ll=findViewById(R.id.llmain);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightft.getText().toString());
                int in=Integer.parseInt(edtHeightin.getText().toString());

                double totalm= ((ft*12+in) * 2.53)/100 ;
                double bmi = wt/(totalm*totalm);

                if(bmi>25){
                    txtResult.setText("You are Overweight");
                    ll.setBackgroundColor(getColor(R.color.colorow));
                }
                else if(bmi<18){
                    txtResult.setText("You are Underweight");
                    ll.setBackgroundColor(getColor(R.color.coloruw));
                }
                else{
                    txtResult.setText("You are Healthy");
                    ll.setBackgroundColor(getColor(R.color.colorh));
                }



            }
        });

    }
}