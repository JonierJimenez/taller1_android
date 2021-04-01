package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContrasenaActivity extends AppCompatActivity implements View.OnClickListener {
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasena);

        regresar = findViewById(R.id.btnCregresar);
        regresar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCregresar:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("bandera",1);
                startActivity(i);
                finish();
                break;
        }
    }
}