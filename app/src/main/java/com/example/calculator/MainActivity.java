package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button add,sub,mul,div;
    EditText num1,num2;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        res=findViewById(R.id.result);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(num1.getText().toString()) && TextUtils.isEmpty(num2.getText().toString())){
            Toast.makeText(this, "Please enter any number to calculate!", Toast.LENGTH_SHORT).show();
        }
        int n1= "".equals(num1.getText().toString())?0:Integer.parseInt(num1.getText().toString());
        int n2= "".equals(num2.getText().toString())?0:Integer.parseInt(num2.getText().toString());
        int r=0;
      if(v.getId()==R.id.add){
          r=n1+n2;
          res.setText(String.valueOf(r));
          num1.setText("");
          num2.setText("");
      }
       else if(v.getId()==R.id.sub){
           r=n1-n2;
          res.setText(String.valueOf(r));
          num1.setText("");
          num2.setText("");
        }
        else if(v.getId()==R.id.mul){
            r=n1*n2;
           res.setText(String.valueOf(r));
          num1.setText("");
          num2.setText("");
        }
        else if(v.getId()==R.id.div){
            if(n2!=0){
                r=n1/n2;
                res.setText(String.valueOf(r));
                num1.setText("");
                num2.setText("");
            }
            else{
                Toast.makeText(this, "Can't Divide by Zero!!!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}