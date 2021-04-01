package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Velocidad extends AppCompatActivity implements View.OnClickListener {
    Button regresar;
    EditText distancia, tiempo;
    TextView resultado;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad);

        distancia = (EditText) findViewById(R.id.edtDistancia);
        tiempo = (EditText) findViewById(R.id.edtTiempo);
        resultado = (TextView) findViewById(R.id.tvResultados);
        calcular= (Button) findViewById(R.id.btnCalcular);


        calcular.setOnClickListener(this);


        regresar= findViewById(R.id.btnaVeRegresar);

        regresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnCalcular:
                boolean validarCampos = camposCompletos();
                if(validarCampos){
                    calcularVelocidad();
                }else{
                    Toast.makeText(this, "ingrese todos los campo", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnaVeRegresar:
                Intent i = new Intent(this,HomeFisicaActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }


    public void calcularVelocidad(){
        Float distancia_float = Float.parseFloat(distancia.getText().toString());
        Float tiempo_float = Float.parseFloat(tiempo.getText().toString());

        if(tiempo_float != 0){
            float resul = distancia_float / tiempo_float;
            resultado.setText("La velocidad es: " + String.valueOf(resul) + " m/s");
        }else{
            Toast.makeText(this, "Ingrese valor diferente de cero", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean camposCompletos(){
        String distancia_String = distancia.getText().toString();
        String tiempo_String = tiempo.getText().toString();

        if(TextUtils.isEmpty(distancia_String)){
            return false;
        }else if(TextUtils.isEmpty(tiempo_String)){
            return false;
        }else{
            return true;
        }
    }
}//fin