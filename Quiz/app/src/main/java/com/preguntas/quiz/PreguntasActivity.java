package com.preguntas.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class PreguntasActivity extends AppCompatActivity {
    private ArrayList<Preguntas> preguntas = new ArrayList<Preguntas>();
    private Respuestas respuesta = new Respuestas(1, 0);
    private TextView pregunta;
    private Button boton;
    private RadioGroup grupo;
    private RadioButton respuesta1;
    private RadioButton respuesta2;
    private RadioButton respuesta3;
    private RadioButton respuesta4;
    private String cor;
    private int ids_answers[] = { R.id.answer1RadioButton, R.id.answer2RadioButton, R.id.answer3RadioButton, R.id.answer4RadioButton };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        respuesta.rellenar();
        preguntas =respuesta.getPre();
        grupo = findViewById(R.id.radioGroup);
        boton = findViewById(R.id.button);
        boton.setText("Siguiente");
        llenar();
    }
    public void llenar()
    {
        pregunta = findViewById(R.id.textView6);
        pregunta.setText(preguntas.get(respuesta.getContador()-1).getPregunta());

        respuesta1 = findViewById(R.id.answer1RadioButton);
        respuesta1.setText(preguntas.get(respuesta.getContador()-1).getRespuesta1());

        respuesta2 = findViewById(R.id.answer2RadioButton);
        respuesta2.setText(preguntas.get(respuesta.getContador()-1).getRespuesta2());

        respuesta3 = findViewById(R.id.answer3RadioButton);
        respuesta3.setText(preguntas.get(respuesta.getContador()-1).getRespuesta3());

        respuesta4 = findViewById(R.id.answer4RadioButton);
        respuesta4.setText(preguntas.get(respuesta.getContador()-1).getRespuesta4());
        
    }

    public void siBTN(View view)
    {
        if(grupo.getCheckedRadioButtonId() != -1)
        {
            if(respuesta.getContador() < 4)
            {
                Comprobar();
                respuesta.setContador(respuesta.getContador()+1);
                llenar();
            }else
            {
                if(respuesta.getContador() == 4)
                {
                    Comprobar();
                    respuesta.setContador(respuesta.getContador()+1);
                    boton.setText("Finalizar");
                    llenar();

                }else
                {
                    //Intent intent= new Intent(this,RespuestasActivity.class);
                   // intent.putExtra("correctas", respuesta.getCorrectas());
                   // startActivity(intent);


                        cor = String.format("Correctas: " + respuesta.getCorrectas());
                        Toast.makeText(getApplicationContext(), cor, Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(this,MainActivity.class);
                        startActivity(intent);
                }
            }
        }else {
            Toast.makeText(getApplicationContext(), "Debes seleccionar alguna respuesta", Toast.LENGTH_SHORT).show();
        }
    }
    public void Comprobar()
    {
        int id = grupo.getCheckedRadioButtonId();
        int answer = -1;

        for (int i = 0; i < ids_answers.length; i++) {
            if(ids_answers[i] == id)
            {
                answer = i+1;
            }
        }

        if(answer == (preguntas.get(respuesta.getContador()-1).getCorrecta())) {
            respuesta.setCorrectas(respuesta.getCorrectas()+1);
        }
    }

}