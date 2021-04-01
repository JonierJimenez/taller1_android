package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton fisica,geometria,texto,regresar,ayuda;
    String usuario;
    TextView User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fisica = findViewById(R.id.imgbFisica);
        geometria = findViewById(R.id.imgbGeometria);
        texto = findViewById(R.id.imgbTexto);
        regresar = findViewById(R.id.imgbRegresar);
        ayuda = findViewById(R.id.imgbAyuda);

        User=findViewById(R.id.textViewUser);
        usuario = getIntent().getStringExtra("usuario");
        User.setText(usuario);

        fisica.setOnClickListener(this);
        geometria.setOnClickListener(this);
        texto.setOnClickListener(this);
        regresar.setOnClickListener(this);
        ayuda.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.imgbFisica:
                i = new Intent(getApplicationContext(),HomeFisicaActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.imgbGeometria:
                i = new Intent(getApplicationContext(),HomeGeometriaActivity.class);
                startActivity(i);
                finish();
                break;

            case R.id.imgbTexto:
                i = new Intent(getApplicationContext(),HomeTextoActivity.class);
                startActivity(i);
                finish();
                break;

            case R.id.imgbRegresar:
                i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("bandera",1);
                startActivity(i);
                finish(); break;

            case R.id.imgbAyuda:
                Toast.makeText(this, "APP Creada por: \n Erwin cacua \n Jonier Jimenez \n Javier De Az", Toast.LENGTH_SHORT).show();
            break;
        }
    }
}