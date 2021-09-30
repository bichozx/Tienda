package com.armonia.tienda;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegistroActivity2 extends AppCompatActivity {

    EditText  edtnombre,edtapellido, edtemail,edtciudad,edpassword1,edtconfirpassword;
    Button btninicioregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_registro2);
        edtnombre = findViewById(R.id.edtnombre);
        edtapellido = findViewById(R.id.edtapellido);
        edtemail = findViewById(R.id.edtemail1);
        edtciudad = findViewById(R.id.edtciudad);
        edpassword1 = findViewById(R.id.edpassword1);
        edtconfirpassword = findViewById(R.id.edtconfirpassword);
        btninicioregistro = findViewById(R.id.btninicioregistro);

    }  public void registroext(View view)
    {
        if (regiuser())
        {
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();



        }

    }


    public  boolean regiuser (){

        boolean retornado = true;

        String nombre = edtnombre.getText().toString();
        String apellido = edtapellido.getText().toString();
        String email = edtemail.getText().toString();
        String ciudad = edtciudad.getText().toString();
        String password = edpassword1.getText().toString();
        String confirpassword =  edtconfirpassword.getText().toString();
        Pattern passuser = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");


        if (nombre.isEmpty())
        {
           edtnombre.setError("Campo Obligatorio");
            retornado = false;
        }


        if (apellido.isEmpty())
        {
            edtapellido.setError("Campo Obligatorio");
            retornado = false;
        }


        if (email.isEmpty())
        {
            edtemail.setError("Campo Obligatorio");
            retornado = false;
        }


        if (ciudad.isEmpty())
        {
            edtciudad.setError("Campo Obligatorio");
            retornado = false;
        }


        if (password.isEmpty())
        {
            edpassword1.setError("Campo Obligatorio");
            retornado = false;

        }else  if (passuser.matcher(password).matches() == false)

        {
            edpassword1.setError(" Debe incluir mayuscul, minuscula, @#$%^&+=, minimo 8 caracteres ");
            retornado = false;

        }else
        {
            edpassword1.setError(null);
        }

        if (confirpassword.equals(password))
        {
            Toast.makeText(getApplicationContext(), "las contraseña son iguales", Toast.LENGTH_SHORT).show();

        }else
        {
            edtconfirpassword.setError("las contraseña deben ser iguales");
        }
      


        return retornado;




    }
}