package com.techexpert.ipaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        button = findViewById(R.id.btn);

        button.setOnClickListener(view -> {

            String s = text.getText().toString().trim();

            if(s.isEmpty())
                Toast.makeText(this, "InValid", Toast.LENGTH_SHORT).show();
            else if(!Character.isDigit(s.charAt(0))||!Character.isDigit(s.charAt(s.length()-1)))
            {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            }
            else {

                String[] str = s.split("\\.");
                if(str.length != 4) {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean b = false;
                    for(String sr : str)
                    {
                        char[] ch = sr.toCharArray();
                        int j=0;
                        while(j<ch.length && Character.isDigit(ch[j]))
                        {
                            j++;
                        }
                        if(j!=sr.length())
                        {
                            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                            b=true;
                            break;
                        }
                        int i= Integer.parseInt(sr);
                        if((i<0) || (i>255))
                        {
                            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                            b=true;
                            break;
                        }
                    }
                    if(!b)
                        Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();

                }


            }

        });

    }
}