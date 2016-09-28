package com.akatowolf.sarku_japan;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    String nombre, pass, repass, mail, falta, falla, exito;
    Button rEntrar, rCancelar;
    EditText rUser, rCorreo, rContrasena, rrContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        rEntrar = (Button) findViewById(R.id.rRegistro);
        rCancelar = (Button) findViewById(R.id.rCancelar);
        rUser = (EditText) findViewById(R.id.rUser);
        rContrasena = (EditText) findViewById(R.id.rContrasena);
        rrContrasena = (EditText) findViewById(R.id.rrContrasena);
        rCorreo = (EditText) findViewById(R.id.rCorreo);

        rEntrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
            /*Intent intent = new Intent(getApplicationContext(), LoginActivity.class);*/
                /*nombre = rUsuario.getText().toString();
                pass = rContrasena.getText().toString();
                repass = rrContrasena.getText().toString();
                mail = rCorreo.getText().toString();*/

                        nombre = rUser.getText().toString();
                        pass = rContrasena.getText().toString();
                        repass = rrContrasena.getText().toString();
                        mail = rCorreo.getText().toString();
                        falta = getResources().getString(R.string.repetir);
                        falla = getResources().getString(R.string.igual);
                        exito = getResources().getString(R.string.exito);
                        if(TextUtils.isEmpty(nombre) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) || TextUtils.isEmpty(mail)){
                            Context cont = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;
                            CharSequence text = falta;
                            Toast toast = Toast.makeText(cont, text, duration);
                            toast.show();
                        }else if(pass.equals(repass)){
                            String key = null;
                            Context cont = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;
                            CharSequence text = exito;
                            Toast toast = Toast.makeText(cont, text, duration);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            intent.putExtra("nombre", nombre);
                            intent.putExtra("contrasena",pass);
                            intent.putExtra("correo",mail);
                            setResult(RESULT_OK,intent);
                            finish();

                        }else{
                            Context cont = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;
                            CharSequence text = falla;
                            Toast toast = Toast.makeText(cont, text, duration);
                            toast.show();
                        }



                    }
        });
        rCancelar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}
