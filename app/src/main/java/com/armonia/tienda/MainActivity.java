package com.armonia.tienda;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnregistro, btninicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        btnregistro = findViewById(R.id.btnregistro);
        btninicio = findViewById(R.id.btnIniciar);
        btninicio.setOnClickListener(this);
        btnregistro.setOnClickListener(this);



    }
    public void registro(){
        Intent i =new Intent(this, RegistroActivity2.class);
        startActivity(i);


    }
    public void iniciosesion(){
        Intent i =new Intent(this, InicioActivity2.class);
        startActivity(i);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnIniciar:
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                iniciosesion();
                break;

            case R.id.btnregistro:
                Toast.makeText(this, "Vamos a Registrarnos", Toast.LENGTH_SHORT).show();
                registro();
                break;
        }

    }
}