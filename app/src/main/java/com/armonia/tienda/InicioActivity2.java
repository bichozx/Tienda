package com.armonia.tienda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class InicioActivity2 extends AppCompatActivity {

    EditText edtemail, edtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_inicio2);


        edtemail = findViewById(R.id.edtemail);
        edtpassword = findViewById(R.id.editpassword);

    }

    public void ingreso(View view)
    {
    if (validacionentrada())
    {
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();



    }
    }

    public boolean validacionentrada(){
         String email = edtemail.getText().toString();
         String password = edtpassword.getText().toString();
         Pattern validar = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");


         boolean retorno = true;


        if (email.isEmpty()) {

            edtemail.setError(" Campo Obligatorio");
            retorno = false;
        }

        if (password.isEmpty()){

            edtpassword.setError(" Campo Obligatorio ");

        }else if( validar.matcher(password).matches() == false){

            edtpassword.setError(" Debe incluir mayuscul, minuscula, @#$%^&+=, minimo 8 caracteres ");
            retorno = false;


        }else
        {
            edtpassword.setError(null);
        }


        return retorno;

    }
}