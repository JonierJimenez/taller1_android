package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeGeometriaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button regresarG, calcularG;
    Spinner opciones;
    TextView Respuesta;

    String[] arrayOpciones = { "Cuadrante", "Pendiente", "Distancia"};
    String opcionSeleccionada = "Cuadrante";

    EditText x1,x2,y1,y2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_geometria);

        calcularG = findViewById(R.id.btnGCalcular);
        opciones = findViewById(R.id.spOpciones);
        Respuesta = findViewById(R.id.textViewRespuesta);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, arrayOpciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opciones.setAdapter(adapter);
        opciones.setOnItemSelectedListener(this);

        inicializarPuntos();

        regresarG=findViewById(R.id.btnGRegresar);

        regresarG.setOnClickListener(this);
        calcularG.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGRegresar:
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
                finish();
                break;

            case R.id.btnGCalcular:
                boolean validarCampo = camposCompletos();
                if(validarCampo){

                    if(opcionSeleccionada == "Cuadrante"){
                        cuadrante();
                    }
                    else if(opcionSeleccionada == "Pendiente"){
                        pendiente();
                    }
                    else if(opcionSeleccionada == "Distancia"){
                        distancia();
                    }
                }else{
                    Toast.makeText(this, "ingrese todos los campo", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        opcionSeleccionada = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void distancia(){
        float nx1,nx2,ny1,ny2;
        nx1 = Float.parseFloat(x1.getText().toString());
        ny1 = Float.parseFloat(y1.getText().toString());
        nx2 = Float.parseFloat(x2.getText().toString());
        ny2 = Float.parseFloat(y2.getText().toString());

        float distancia = (float) Math.sqrt( (nx2-nx1)*(nx2-nx1) + (ny2-ny1)*(ny2-ny1) );
        //Toast.makeText(getApplicationContext(),"distancia "+distancia,Toast.LENGTH_LONG).show();
        Respuesta.setText("La Distancia es: "+distancia);
    }

    public  void  cuadrante(){
        float nx1,nx2,ny1,ny2;
        nx1 = Float.parseFloat(x1.getText().toString());
        ny1 = Float.parseFloat(y1.getText().toString());
        nx2 = Float.parseFloat(x2.getText().toString());
        ny2 = Float.parseFloat(y2.getText().toString());

        if(nx1>0 && ny1>0){
            //Toast.makeText(getApplicationContext(),"PUNTO 1 Cuadrante I ",Toast.LENGTH_LONG).show();
            Respuesta.setText("PUNTO 1 Cuadrante I");
        }
        else if(nx1<0 && ny1>0){
            //Toast.makeText(getApplicationContext(),"PUNTO 1 Cuadrante II ",Toast.LENGTH_LONG).show();
            Respuesta.setText("PUNTO 1 Cuadrante II");
        }
        else if(nx1<0 && ny1<0){
            //Toast.makeText(getApplicationContext(),"PUNTO 1 Cuadrante III ",Toast.LENGTH_LONG).show();
            Respuesta.setText("PUNTO 1 Cuadrante III");
        }
        else{
            //Toast.makeText(getApplicationContext(),"PUNTO 1 Cuadrante VI ",Toast.LENGTH_LONG).show();
            Respuesta.setText("PUNTO 1 Cuadrante VI");
        }

        //CUADRANTE PUNTO 2
        if(nx2>0 && ny2>0){
            Toast.makeText(getApplicationContext(),"PUNTO 2 Cuadrante I ",Toast.LENGTH_LONG).show();
            Respuesta.setText(Respuesta.getText()+"\nPUNTO 2 Cuadrante I");
        }
        else if(nx2<0 && ny2>0){
            //Toast.makeText(getApplicationContext(),"PUNTO 2 Cuadrante II ",Toast.LENGTH_LONG).show();
            Respuesta.setText(Respuesta.getText()+"\nPUNTO 2 Cuadrante II");
        }
        else if(nx2<0 && ny2<0){
            //Toast.makeText(getApplicationContext(),"PUNTO 2 Cuadrante III ",Toast.LENGTH_LONG).show();
            Respuesta.setText(Respuesta.getText()+"\nPUNTO 2 Cuadrante III");
        }
        else{
            //Toast.makeText(getApplicationContext(),"PUNTO 2 Cuadrante VI ",Toast.LENGTH_LONG).show();
            Respuesta.setText(Respuesta.getText()+"\nPUNTO 2 Cuadrante VI");
        }




    }

    public  void pendiente(){
        float nx1,nx2,ny1,ny2;
        nx1 = Float.parseFloat(x1.getText().toString());
        ny1 = Float.parseFloat(y1.getText().toString());
        nx2 = Float.parseFloat(x2.getText().toString());
        ny2 = Float.parseFloat(y2.getText().toString());

        float numerador = ny2-ny1;
        float denominador= nx2-nx1;
        float Pendiente = numerador/denominador;
        //Toast.makeText(this, "La pendiente es: "+Pendiente, Toast.LENGTH_SHORT).show();
        Respuesta.setText("La Pendiente es: "+Pendiente);
    }

    public void inicializarPuntos(){
        x1=findViewById(R.id.edtX1);
        y1=findViewById(R.id.edtY1);
        x2=findViewById(R.id.edtX2);
        y2=findViewById(R.id.edtY2);
    }

    public boolean camposCompletos(){
        String Sx1 = x1.getText().toString();
        String Sy1 = y1.getText().toString();
        String Sx2 = x2.getText().toString();
        String Sy2 = y2.getText().toString();

        if(TextUtils.isEmpty(Sx1)){
            return false;
        }
        else if(TextUtils.isEmpty(Sy1)){
            return  false;
        }else if(TextUtils.isEmpty(Sx2)){
            return false;
        }else if(TextUtils.isEmpty(Sy2)){
            return false;
        }else{
            return true;
        }

    }
}