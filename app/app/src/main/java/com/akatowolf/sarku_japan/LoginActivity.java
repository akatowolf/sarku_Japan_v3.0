package com.akatowolf.sarku_japan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button rRegistrar, rEntrar;
    EditText rContrasena, rUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rRegistrar = (Button) findViewById(R.id.rRegistro);
        rEntrar = (Button) findViewById(R.id.rEntrar);
        rUsuario = (EditText) findViewById(R.id.rUsuario);
        rContrasena = (EditText) findViewById(R.id.rContraseña);
        rRegistrar.setOnClickListener(this);
        rEntrar.setOnClickListener(this);

    }

    public void onClick(View view){
        int id = view.getId();

        switch (id) {
            case R.id.rRegistro:
                Intent intent = new Intent(this,RegistroActivity.class);
                startActivityForResult(intent,1234);
                break;
            case R.id.rEntrar:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode == RESULT_OK) {
            String user = data.getExtras().getString("usuario");
            String contrasena = data.getExtras().getString("contrasena");
            Log.d("user",user);
            Log.d("contraseña",contrasena);
        }
            if (requestCode==1234 && resultCode == RESULT_CANCELED){
                Log.d("mensaje","no se cargaron los datos");
                Log.d("contraseña",contrasena);
        }
    }
}
