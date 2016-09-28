package com.akatowolf.sarku_japan;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String nombre, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent in = getIntent();
        Bundle extras=in.getExtras();
        nombre= (String) extras.get("nombre");
        mail = (String) extras.get("correo");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.menu_miperfil:
                Intent intent = new Intent(this, PerfilActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("correo", mail);
                setResult(RESULT_OK,intent);
                startActivity(intent);
                break;
            case R.id.menu_producto:
                Intent intent2 = new Intent(this, Producto.class);
                setResult(RESULT_OK,intent2);
                startActivity(intent2);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
