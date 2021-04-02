package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContrasenaActivity extends AppCompatActivity implements View.OnClickListener {
    Button regresar;
    ConstraintLayout bloque;
    Button enviar, validar, restablecer;
    EditText correo, edCodigo, pa1, pa2;
    int codigo = 0, pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasena);

        bloque = findViewById(R.id.bloque);
        bloque.setVisibility(View.INVISIBLE);

        enviar = findViewById(R.id.Benviar);
        validar = findViewById(R.id.Bvalidar);
        validar.setEnabled(false);
        restablecer = findViewById(R.id.Brestablecer);

        correo = findViewById(R.id.Edcorreo);
        edCodigo = findViewById(R.id.Edcodigo);
        pa1 = findViewById(R.id.Edpassword1);
        pa2 = findViewById(R.id.Edpassword2);

        edCodigo.setEnabled(false);

        enviar.setOnClickListener(this);
        validar.setOnClickListener(this);
        restablecer.setOnClickListener(this);


        regresar = findViewById(R.id.btnCregresar);
        regresar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Benviar:
                if (!correo.getText().toString().isEmpty()) {
                    pos = existeCorreo(correo.getText().toString());
                    if (pos != -1) {
                        codigo = generarCodigo();
                        Toast.makeText(this, "El codigo es:" + String.valueOf(codigo), Toast.LENGTH_LONG).show();
                        edCodigo.setEnabled(true);
                        validar.setEnabled(true);
                    } else {
                        Toast.makeText(this, "Email Incorrecto", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "Email Vacio", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.Bvalidar:
               // dialogo.settitle(R.string.dialogERROR);
                if (!edCodigo.getText().toString().isEmpty()) {
                    int auxcodigo = Integer.parseInt(edCodigo.getText().toString());
                    if (auxcodigo == codigo) {
                        Toast.makeText(this, "Codigo correcto", Toast.LENGTH_SHORT).show();
                        bloque.setVisibility(View.VISIBLE);
                        correo.setEnabled(false);
                        enviar.setEnabled(false);
                        edCodigo.setEnabled(false);
                        validar.setEnabled(false);
                    } else {
                        Toast.makeText(this, "Codigo incorrecto", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Codigo vacio", Toast.LENGTH_SHORT).show();
                }



            case R.id.Brestablecer:

                if (!pa1.getText().toString().isEmpty() && !pa2.getText().toString().isEmpty()) {
                    if (pa1.getText().toString().equalsIgnoreCase(pa2.getText().toString())) {
                        if (pa1.getText().length() >= 6) {
                            Usuarios useraux = MainActivity.usuarios.get(pos);
                            useraux.password = pa1.getText().toString();
                            MainActivity.usuarios.set(pos,useraux);
                            Toast.makeText(this, "Restablecido correctamente", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            i.putExtra("bandera",1);
                            startActivity(i);
                            finish();

                        }else {
                            Toast.makeText(this, "password corta", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(this, "password Diferentes", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "llenar campos", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnCregresar:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("bandera",1);
                startActivity(i);
                finish();
                break;
        }
    }

    public int existeCorreo(String correo) {
        for (int i = 0; i < MainActivity.usuarios.size(); i++) {
            if (MainActivity.usuarios.get(i).correo.equalsIgnoreCase(correo)) {
                return i;
            }
        }
        return -1;
    }

    public int generarCodigo() {
        int num1 = (int) ((Math.random() * 9) + 1);
        int num2 = (int) ((Math.random() * 9) + 1);
        int num3 = (int) ((Math.random() * 9) + 1);
        int num4 = (int) ((Math.random() * 9) + 1);

        return Integer.parseInt(String.valueOf(num1) + String.valueOf(num2) + String.valueOf(num3) + String.valueOf(num4));
    }
}