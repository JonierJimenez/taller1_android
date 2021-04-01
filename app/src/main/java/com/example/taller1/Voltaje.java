package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Voltaje extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button regresar;
    EditText intensidad, re1, re2, re3;
    TextView resultadoV;
    Button calcularV, regresarFV;
    Spinner numResistencias;
    CheckBox cParalelo;

    String[] arrayOpciones = {"", "2", "3"};
    String opcionSelect = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voltaje);

        intensidad = (EditText) findViewById(R.id.edtIntensidad);
        re1 = (EditText) findViewById(R.id.edtR1);
        re2 = (EditText) findViewById(R.id.edtR2);
        re3 = (EditText) findViewById(R.id.edtR3);
        resultadoV= (TextView) findViewById(R.id.tvResulV);
        numResistencias = (Spinner) findViewById(R.id.spinner);
        cParalelo = (CheckBox) findViewById(R.id.cbParalelo);
        calcularV = (Button) findViewById(R.id.btnCalcularV);
        //regresarFV = (Button) findViewById(R.id.btnRegresarV);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, arrayOpciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numResistencias.setAdapter(adapter);
        numResistencias.setOnItemSelectedListener(this);

        calcularV.setOnClickListener(this);
        //regresarFV.setOnClickListener(this);


        regresar= findViewById(R.id.btnVoRegresar);

        regresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnCalcularV:
                boolean validarCampos = camposVacios();
                if(validarCampos){
                    if(cParalelo.isChecked() == false){
                        calcularSerie();
                    }else{
                        calcularParalelo();
                    }
                }else{
                    Toast.makeText(this, "ingrese todos los campo", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnVoRegresar :
                Intent i = new Intent(this,HomeFisicaActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        opcionSelect = parent.getItemAtPosition(position).toString();
        if(opcionSelect == ""){
            re1.setEnabled(false);
            re2.setEnabled(false);
            re3.setEnabled(false);
        }else if(opcionSelect == "2"){
            re1.setEnabled(true);
            re2.setEnabled(true);
            re3.setEnabled(false);
        }else{
            re1.setEnabled(true);
            re2.setEnabled(true);
            re3.setEnabled(true);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public boolean camposVacios(){
        String intensidad_String = intensidad.getText().toString();
        String re1_String = re1.getText().toString();
        String re2_String = re2.getText().toString();
        String re3_String = re3.getText().toString();

        if(TextUtils.isEmpty(intensidad_String)){
            return false;
        }else if(TextUtils.isEmpty(re1_String)){
            return false;
        }else if(TextUtils.isEmpty(re2_String)){
            return false;
        }else if(TextUtils.isEmpty(re3_String)){
            return false;
        }else if(opcionSelect == ""){
            return false;
        }else{
            return true;
        }
    }

    public void calcularSerie(){
        Float intensidad_float = Float.parseFloat(intensidad.getText().toString());
        Float re1_float = Float.parseFloat(re1.getText().toString());
        Float re2_float = Float.parseFloat(re2.getText().toString());
        Float re3_float = Float.parseFloat(re3.getText().toString());

        if(opcionSelect.equals("2")){
            Float result = (re1_float + re2_float) * intensidad_float;
            resultadoV.setText("El voltaje del circuito en serie es: " + String.valueOf(result) + " V");
        }else if(opcionSelect.equals("3")){
            Float result = (re1_float + re2_float + re3_float) * intensidad_float;
            resultadoV.setText("El voltaje del circuito en serie es: " + String.valueOf(result)+ " V");
        }else{
            Toast.makeText(this, "Selecciona el número de Resistencias", Toast.LENGTH_SHORT).show();
        }

    }

    public void calcularParalelo(){
        Float intensidad_float = Float.parseFloat(intensidad.getText().toString());
        Float re1_float = Float.parseFloat(re1.getText().toString());
        Float re2_float = Float.parseFloat(re2.getText().toString());
        Float re3_float = Float.parseFloat(re3.getText().toString());

        if(re1_float != 0 || re2_float != 0 || re3_float != 0){
            if(opcionSelect.equals("2")){
                Float result = (1 / ((1 / re1_float) + (1 / re2_float))) * intensidad_float;
                resultadoV.setText("El voltaje del circuito en paralelo es: " + String.valueOf(result) + " V");
            }else if(opcionSelect.equals("3")){
                Float result = (1 / ((1 / re1_float) + (1 / re2_float) + (1 / re3_float))) * intensidad_float;
                resultadoV.setText("El voltaje del circuito en paralelo es: " + String.valueOf(result) + " V");
            }else{
                Toast.makeText(this, "Selecciona el número de Resistencias", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Ingrese valor diferente de cero", Toast.LENGTH_SHORT).show();
        }

    }



}//fin