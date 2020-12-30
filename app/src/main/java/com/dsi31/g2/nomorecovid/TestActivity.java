package com.dsi31.g2.nomorecovid;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity
{
    private int check = 0;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked())
                {
                    check++;
                }
                else
                {
                    check--;
                }
            }
        });

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (check >= 4)
                {
                    new AlertDialog.Builder(TestActivity.this)
                            .setTitle("Alert")
                            .setMessage(getResources().getString(R.string.msg_test_positif))
                            .setPositiveButton("OK", null).show();                }
                else
                {
                    new AlertDialog.Builder(TestActivity.this)
                            .setTitle("Alert")
                            .setMessage(getResources().getString(R.string.msg_test_negatif))
                            .setPositiveButton("OK", null).show();
                }
            }
        });
    }
}