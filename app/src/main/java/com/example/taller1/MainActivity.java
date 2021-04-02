package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean control=false;
    int bandera=0;
    EditText usuario, clave;
    Button registrar, login,recuperarPass;
    CheckBox termycon,recordar;
    public static ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario =findViewById(R.id.edtUsuario);
        clave = findViewById(R.id.edtPassword);

        //inicializamos usuarios iniciales
        bandera = getIntent().getIntExtra("bandera", 0);
        if(bandera != 1){
            usuariosIniciales();
        }

        //botones
        login = findViewById(R.id.btnLogin);
        registrar = findViewById(R.id.btnRegistro);
        recuperarPass = findViewById(R.id.btnRecuperarPass);

        termycon = findViewById(R.id.idCheck);
        recordar = findViewById(R.id.idCheckR);


        //botones escuchadores
        login.setOnClickListener(this);
        registrar.setOnClickListener(this);
        termycon.setOnClickListener(this);
        recordar.setOnClickListener(this);
        recuperarPass.setOnClickListener(this);
        recuperarPass.setVisibility(View.INVISIBLE);

        login.setEnabled(false);//boton desactivado
        cargarPreferencias();

       /*for (int i = 0; i < usuarios.size(); i ++){
            Toast.makeText(this, "m: "+usuarios.get(i).usuario.toString(), Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < usuarios.size(); i ++){
            Toast.makeText(this, "m: "+usuarios.get(i).password.toString(), Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.btnLogin:

                String nombre = usuario.getText().toString();
                String contra = clave.getText().toString();
                Usuarios user = new Usuarios(nombre,contra);

                //validamos si el usuario existe
               if(usuarios.contains(user)){
                    if(recordar.isChecked()==true){
                        guardarPreferencias();
                    }
                    i = new Intent(this,HomeActivity.class);
                    i.putExtra("usuario",user.usuario);
                    startActivity(i);
               }
               else{
                    Toast.makeText(getApplicationContext(),"Error Credenciales",Toast.LENGTH_LONG).show();
                    recuperarPass.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.btnRegistro:
                i = new Intent(getApplicationContext(),RegistroActivity.class);
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

            case R.id.idCheckR:
                guardarPreferencias();
                break;

            case R.id.btnRecuperarPass:
                i = new Intent(getApplicationContext(),ContrasenaActivity.class);
                startActivity(i);
                break;
        }
    }

    public boolean validarCampos(){
        return true;
    }

    public void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String nombre = usuario.getText().toString();
        String password = clave.getText().toString();

        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user",nombre);
        editor.putString("pass",password);

        editor.commit();
    }

    public  void cargarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user = preferences.getString("user","");
        String pass = preferences.getString("pass","");

        usuario.setText(user);
        //usuario.setHint(""+user);
        clave.setText(pass);
    }

    public void usuariosIniciales(){
        if(control == false){
            usuarios.add(0,new Usuarios("jhonier","jimenez","ejemplo1@gmail.com","123456"));
            usuarios.add(1,new Usuarios("erwin","cacua","ejemplo2@gmail.com","123456","hombre"));
            usuarios.add(2,new Usuarios("javier","de az","ejemplo3@gmail.com","123456","hombre"));
            control=true;
        }

    }


}//fin classs