package com.example.iudigigital_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarActivity extends Activity {

    EditText usuario;
    EditText contrasena;
    EditText confirmarContrasena;
    Button crearCuentaButton;
    TextView volverInicio;
    EditText numeroCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuario = findViewById(R.id.usuario);
        contrasena = findViewById(R.id.contrasena);
        confirmarContrasena = findViewById(R.id.confirmarContrasena);
        crearCuentaButton = findViewById(R.id.crearCuentaButton);
        volverInicio = findViewById(R.id.volverInicio);
        numeroCelular = findViewById(R.id.numeroCelular);

        crearCuentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });

        volverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

    private void performRegistration() {

        String usuarios = usuario.getText().toString().trim();
        String contrasenas = contrasena.getText().toString().trim();
        String confirmarContrasenas = confirmarContrasena.getText().toString().trim();
        String numeroCelulars = numeroCelular.getText().toString().trim();

        if (usuarios.isEmpty()) {
            showToast("El usuario no puede estar vacío");
            return;
        }
        if (contrasenas.isEmpty()) {
            showToast("La contraseña no puede estar vacía");
            return;
        }
        if (!confirmarContrasenas.equals(contrasenas)) {
            showToast("Las contraseñas no coinciden");
            return;
        }
        if (numeroCelulars.isEmpty()) {
            showToast("El número de teléfono no puede estar vacío");
            return;
        }

        showToast("Registro efectuado con éxito");

        navigateToLogin();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
