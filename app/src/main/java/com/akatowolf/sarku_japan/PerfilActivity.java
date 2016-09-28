package com.akatowolf.sarku_japan;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    TextView rNombre, rMail, rNombre2, rMail2;
    String nombre, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        rNombre = (TextView) findViewById(R.id.rNombre);
        rMail = (TextView) findViewById(R.id.rMail);
        rNombre2 = (TextView) findViewById(R.id.rNombre2);
        rMail2 = (TextView) findViewById(R.id.rMail2);
        Intent in = getIntent();
        Bundle extras=in.getExtras();
        nombre= (String) extras.get("nombre");
        mail = (String) extras.get("correo");
        rNombre2.setText(nombre);
        rMail2.setText(mail);

    }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu2, menu);
            return true;

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id) {

                case R.id.ractivity:
                    Intent intent = new Intent(this, MainActivity.class);
                    finish();
                    break;
            }
                return super.onOptionsItemSelected(item);
            }
        }



