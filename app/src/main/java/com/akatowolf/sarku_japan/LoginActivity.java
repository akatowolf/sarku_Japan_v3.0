package com.akatowolf.sarku_japan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button rRegistrar, rEntrar;
    EditText rContrasena, rUsuario;
    String user, pass, user2, pass2, falta, noreg, correo, msn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
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
                /*startActivity(intent);*/
                break;
            case R.id.rEntrar:
                    user = rUsuario.getText().toString();
                    pass = rContrasena.getText().toString();
                    falta = getResources().getString(R.string.repetir);
                    noreg = getResources().getString(R.string.noreg);
                    msn = getResources().getString(R.string.bienvenido);
                    if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                        Context cont = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        CharSequence text = falta;
                        Toast toast = Toast.makeText(cont, text, duration);
                        toast.show();
                    }else if(user.equals(user2)){
                        Context cont = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        CharSequence text = msn;
                        Toast toast = Toast.makeText(cont, text, duration);
                        toast.show();
                        Intent in = new Intent(cont, MainActivity.class);
                        in.putExtra("nombre", user2);
                        in.putExtra("correo", correo);
                        setResult(RESULT_OK,in);
                        startActivity(in);
                        finish();
                    }else{
                        Context cont = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        CharSequence text = noreg;
                        Toast toast = Toast.makeText(cont, noreg, duration);
                        toast.show();
                    }
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            user2 = data.getExtras().getString("nombre");
            pass2 = data.getExtras().getString("contrasena");
            correo = data.getExtras().getString("correo");


        }

    }
}
