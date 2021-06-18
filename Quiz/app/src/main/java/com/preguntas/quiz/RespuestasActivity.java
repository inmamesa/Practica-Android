package com.preguntas.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class RespuestasActivity extends AppCompatActivity {
    private String Resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);

        Bundle datos = this.getIntent().getExtras();
        int correctas = datos.getInt("correctas");
        Resultado=String.format("Correctas: ",correctas);

        Toast.makeText(getApplicationContext(),Resultado, Toast.LENGTH_SHORT).show();
    }
}