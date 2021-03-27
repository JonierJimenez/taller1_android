package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    Button regresar, guardarR;
    EditText nombre, apellido, correo, clave, sexo;

    AwesomeValidation validar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.edtNombre);
        apellido = findViewById(R.id.edtApellido);
        correo = findViewById(R.id.edtCorreo);
        clave = findViewById(R.id.edtPasswordR);
        sexo = findViewById(R.id.edtSexo);

        regresar = findViewById(R.id.btnRegresar);
        guardarR= findViewById(R.id.btnGuardar);

        regresar.setOnClickListener(this);
        guardarR.setOnClickListener(this);

        validar = new AwesomeValidation(ValidationStyle.BASIC);
        validar.addValidation(this,R.id.edtPasswordR,".{6,}",R.string.invalid_Password);
        validar.addValidation(this,R.id.edtCorreo, Patterns.EMAIL_ADDRESS,R.string.invalid_Correo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar:
                    if(validar.validate()){
                        limpiar();
                        Toast.makeText(this, "guardando bien", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Ingrese una contraseña de 6 digitos", Toast.LENGTH_SHORT).show();
                    }
                    break;
            case R.id.btnRegresar:
                Toast.makeText(this, "hola mundo regresa", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }

    public void limpiar(){
        nombre.setText("");
        correo.setText("");
        apellido.setText("");
        clave.setText("");
        sexo.setText("");
    }
}