package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fuerza extends AppCompatActivity implements View.OnClickListener {
    Button regresar,calcular,borrar;
    EditText masa,aceleracion;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuerza);

        resultado= findViewById(R.id.textViewFResultado);

        masa =findViewById(R.id.edtMasa);
        aceleracion =findViewById(R.id.edtAceleracion);
        borrar = findViewById(R.id.btnFFBorrar);

        calcular= findViewById(R.id.btnFFCalcular);
        regresar= findViewById(R.id.btnFFRegresar);

        calcular.setOnClickListener(this);
        regresar.setOnClickListener(this);
        borrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFFCalcular:
                if( !masa.getText().toString().isEmpty() && !aceleracion.getText().toString().isEmpty()){
                    float fmasa = Float.valueOf(masa.getText().toString());
                    float faceleracion = Float.valueOf(aceleracion.getText().toString());

                    //Toast.makeText(this, "La Fuerza es :  "+( fmasa * faceleracion )+" N", Toast.LENGTH_SHORT).show();
                    resultado.setText("El resultado es: "+(fmasa*faceleracion)+" N");
                }else {
                    Toast.makeText(this, "CAMPOS INCOMPLETOS",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnFFRegresar:
                Intent i = new Intent(this,HomeFisicaActivity.class);
                startActivity(i);
                finish();

            case R.id.btnFFBorrar: masa.setText(""); aceleracion.setText(""); resultado.setText(""); break;

        }
    }


}//fin