package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class HomeTextoActivity extends AppCompatActivity implements View.OnClickListener {
    Button regresarT;
    CheckBox negrita, italica, subraya;
    EditText entrada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_texto);

        entrada =findViewById(R.id.edtMensage);

        negrita = findViewById(R.id.checkNegrita);
        italica = findViewById(R.id.checkItalica);
        subraya = findViewById(R.id.checkSubrayada);

        negrita.setOnClickListener(this);
        italica.setOnClickListener(this);
        subraya.setOnClickListener(this);

        regresarT=findViewById(R.id.btnTRegresar);
        regresarT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        verifyTypeface();

        switch (v.getId()){
            case R.id.btnTRegresar:
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }

    public void verifyTypeface() {
        if (negrita.isChecked() && !italica.isChecked() && !subraya.isChecked()) {
            entrada.setTypeface(null, Typeface.BOLD);
            entrada.getPaint().setUnderlineText(false);
            entrada.setText(entrada.getText());
        } else if (!negrita.isChecked() && italica.isChecked() && !subraya.isChecked()) {
            entrada.setTypeface(null, Typeface.ITALIC);
            entrada.getPaint().setUnderlineText(false);
            entrada.setText(entrada.getText());
        } else if (negrita.isChecked() && italica.isChecked() && !subraya.isChecked()) {
            entrada.setTypeface(null, Typeface.BOLD_ITALIC);
            entrada.getPaint().setUnderlineText(false);
            entrada.setText(entrada.getText());
        } else if (!negrita.isChecked() && !italica.isChecked() && subraya.isChecked()) {
            entrada.setTypeface(null, Typeface.NORMAL);
            entrada.getPaint().setUnderlineText(true);
            entrada.setText(entrada.getText());
        }else if(!negrita.isChecked() && italica.isChecked() && subraya.isChecked()){
            entrada.setTypeface(null, Typeface.ITALIC);
            entrada.getPaint().setUnderlineText(true);
            entrada.setText(entrada.getText());
        }else if(negrita.isChecked() && !italica.isChecked() && subraya.isChecked()){
            entrada.setTypeface(null, Typeface.BOLD);
            entrada.getPaint().setUnderlineText(true);
            entrada.setText(entrada.getText());
        }else if(negrita.isChecked() && italica.isChecked() && subraya.isChecked()){
            entrada.setTypeface(null, Typeface.BOLD_ITALIC);
            entrada.getPaint().setUnderlineText(true);
            entrada.setText(entrada.getText());
        }else {
            entrada.setTypeface(null, Typeface.NORMAL);
            entrada.getPaint().setUnderlineText(false);
            entrada.setText(entrada.getText());
        }

    }
}