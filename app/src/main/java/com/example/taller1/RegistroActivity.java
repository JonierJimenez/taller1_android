package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        regresar = findViewById(R.id.btnRegresar);

        regresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegresar:
                Toast.makeText(this, "hola mundo regresa", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}