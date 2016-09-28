package com.akatowolf.sarku_japan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {
    Button rEntrar, rCancelar;
    EditText rUsuario, rCorreo, rContrasena, rrContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        rAceptar = (Button) findViewById(R.id.rEntrar);
        rCancelar = (Button) findViewById(R.id.rCancelar);


        rAceptar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
            /*Intent intent = new Intent(getApplicationContext(), LoginActivity.class);*/
                Intent intent = new Intent();
                intent.putExtra("usuario",rUsuario.getText().toString());
                intent.putExtra("Contrasena",rContrasena.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }


        });
        rCancelar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
};
