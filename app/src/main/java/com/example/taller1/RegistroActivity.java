package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    Spinner genero;
    String[] generos={"Hombre","Mujer"};
    String Sgenero="Hombre";
    Button regresar, guardarR;
    EditText nombre, apellido, correo, clave;

    AwesomeValidation validar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.edtNombre);
        apellido = findViewById(R.id.edtApellido);
        correo = findViewById(R.id.edtCorreo);
        clave = findViewById(R.id.edtPasswordR);


        regresar = findViewById(R.id.btnRegresar);
        guardarR= findViewById(R.id.btnGuardar);

        regresar.setOnClickListener(this);
        guardarR.setOnClickListener(this);

        //implementamos el spinner
        genero = findViewById(R.id.spGenero);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, generos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genero.setAdapter(adapter);
        genero.setOnItemSelectedListener(this);

        validar = new AwesomeValidation(ValidationStyle.BASIC);
        validar.addValidation(this,R.id.edtPasswordR,".{6,}",R.string.invalid_Password);
        validar.addValidation(this,R.id.edtCorreo, Patterns.EMAIL_ADDRESS,R.string.invalid_Correo);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar:
                    if(validar.validate()){
                        MainActivity.usuarios.add(new Usuarios(nombre.getText().toString(),apellido.getText().toString(),correo.getText().toString(),clave.getText().toString(),Sgenero));
                        Toast.makeText(this, "AGREGADO CON EXITO", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        i.putExtra("bandera",1);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(this, "Ingrese una contraseña de 6 digitos", Toast.LENGTH_SHORT).show();
                    }
                    break;
            case R.id.btnRegresar:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("bandera",1);
                startActivity(i);
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Sgenero = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, Sgenero, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void limpiar(){
        nombre.setText("");
        correo.setText("");
        apellido.setText("");
        clave.setText("");
    }
}