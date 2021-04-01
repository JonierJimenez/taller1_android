package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeFisicaActivity extends AppCompatActivity implements View.OnClickListener {

    Button regresarF,fuerza,velocidad,voltaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fisica);

        fuerza = findViewById(R.id.btnFFuerza);
        velocidad = findViewById(R.id.btnFVelocidad);
        voltaje = findViewById(R.id.btnFVoltaje);
        regresarF=findViewById(R.id.btnFRegresar);

        fuerza.setOnClickListener(this);
        velocidad.setOnClickListener(this);
        voltaje.setOnClickListener(this);
        regresarF.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.btnFFuerza:
                i = new Intent(getApplicationContext(),Fuerza.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnFVelocidad:
                i = new Intent(getApplicationContext(),Velocidad.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnFVoltaje:
                i = new Intent(getApplicationContext(),Voltaje.class);
                startActivity(i);
                finish();
                break;

            case R.id.btnFRegresar:
                i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}