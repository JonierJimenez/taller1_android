package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText usuario, clave;
    Button registrar, login;
    CheckBox termycon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario =findViewById(R.id.edtUsuario);
        clave = findViewById(R.id.edtPassword);


        //botones
        login = findViewById(R.id.btnLogin);
        registrar = findViewById(R.id.btnRegistro);

        termycon = findViewById(R.id.idCheck);

        //botones escuchadores
        login.setOnClickListener(this);
        registrar.setOnClickListener(this);
        termycon.setOnClickListener(this);

        login.setEnabled(false);//boton desactivado



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:

                if(User1()){
                    Toast.makeText(getApplicationContext(),"User 1" + usuario.getText().toString(),Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                    finish();
                }
                else if(User2()){
                    Toast.makeText(getApplicationContext(),"User 2"+ usuario.getText().toString(),Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                    finish();
                }
                else if(User3()){
                    Toast.makeText(getApplicationContext(),"User 3"+  usuario.getText().toString(),Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error credenciales",Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.btnRegistro:
                Intent i = new Intent(getApplicationContext(),RegistroActivity.class);
                startActivity(i);
                if (termycon.isChecked()){
                    login.setEnabled(true);
                }
                break;

            case R.id.idCheck:
                if (termycon.isChecked()){
                    login.setEnabled(true);
                    break;
                }
                login.setEnabled(false);
                break;
        }
    }

    public boolean validarCampos(){
        return true;
    }

    public boolean User1(){
        if(usuario.getText().toString().equalsIgnoreCase("erwin") && clave.getText().toString().equalsIgnoreCase("12345")) {

            Toast.makeText(getApplicationContext(),"en hora buena",Toast.LENGTH_SHORT).show();
            return true;

        }else{
            return false;
        }

    }

    public boolean User2(){
        if(usuario.getText().toString().equalsIgnoreCase("jhonier") && clave.getText().toString().equalsIgnoreCase("2207")) {
            return true;

        }else{
            return false;
        }

    }

    public boolean User3(){
        if(usuario.getText().toString().equalsIgnoreCase("admin") && clave.getText().toString().equalsIgnoreCase("12345")) {


            return true;

        }else{
            if(usuario.getText().toString().equalsIgnoreCase("javier") && clave.getText().toString().equalsIgnoreCase("123")) {


                return true;

            }else{
                return false;
            }

        }

    }

}//fin classs