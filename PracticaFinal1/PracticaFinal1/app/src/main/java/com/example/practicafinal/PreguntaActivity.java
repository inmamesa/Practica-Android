package com.example.practicafinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicafinal.controlador.preguntas;
import com.example.practicafinal.controlador.respuestas;

import java.util.ArrayList;

public class PreguntaActivity extends AppCompatActivity {

    private ArrayList<preguntas> preguntas = new ArrayList<preguntas>();
    private respuestas respuesta = new respuestas(1, 0);
    private TextView pregunta;
    private Button boton;
    private RadioGroup grupo;
    private RadioButton respuesta1;
    private RadioButton respuesta2;
    private RadioButton respuesta3;
    private RadioButton respuesta4;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        llenar();

        grupo = findViewById(R.id.radioGroup);
        boton = findViewById(R.id.button2);
        boton.setText("Siguiente");


    }
    public void llenar()
    {
        Conexion con= new Conexion(this,"bd_preguntas",null,1);

        SQLiteDatabase db= con.getWritableDatabase();

        if(db != null) {
            String consulta = "select * from preguntas";
            Cursor c=db.rawQuery(consulta,null);

            if(c.moveToFirst())
            {
                do{
                    int codigo=c.getInt(c.getColumnIndex("codigo"));
                    String pregunta=c.getString(c.getColumnIndex("pregunta"));
                    String respuesta1=c.getString(c.getColumnIndex("respuesta1"));
                    String respuesta2=c.getString(c.getColumnIndex("respuesta2"));
                    String respuesta3=c.getString(c.getColumnIndex("respuesta3"));
                    String respuesta4=c.getString(c.getColumnIndex("respuesta4"));
                    int correcta=c.getInt(c.getColumnIndex("correcta"));

                    preguntas p= new preguntas(codigo, pregunta, respuesta1,respuesta2,respuesta3,respuesta4,correcta);
                    preguntas.add(p);
                }while(c.moveToFirst());

                c.close();

            }
        }


    }

    public void SiguienteBTN(View view)
    {
        if(grupo.getCheckedRadioButtonId() != -1)
        {
            if(respuesta.getContador() <9)
            {
                Comprobar();
                rellenar();
            }else
            {
                if(respuesta.getContador() == 9)
                {
                    respuesta.setContador(respuesta.getCorrecta()+1);
                    Comprobar();
                    boton.setText("Siguiente");
                    rellenar();

                }else
                {
                    Intent intent= new Intent(this,ResultadoActivity.class);
                    startActivity(intent);
                }
            }
        }else{
            Toast.makeText(this, "Debes seleccionar alguna respuesta", Toast.LENGTH_SHORT).show();
        }


    }
    public void rellenar()
    {
        pregunta = findViewById(R.id.textView6);
        pregunta.setText(preguntas.get(respuesta.getContador()-1).getCorrecta());

        respuesta1 = findViewById(R.id.radioButton);
        respuesta1.setText(preguntas.get(respuesta.getContador()-1).getCorrecta());

        respuesta2 = findViewById(R.id.radioButton2);
        respuesta2.setText(preguntas.get(respuesta.getContador()-1).getCorrecta());

        respuesta3 = findViewById(R.id.radioButton3);
        respuesta3.setText(preguntas.get(respuesta.getContador()-1).getCorrecta());

        respuesta4 = findViewById(R.id.radioButton4);
        respuesta4.setText(preguntas.get(respuesta.getContador()-1).getCorrecta());
    }

    public void Comprobar()
    {
            if((grupo.getCheckedRadioButtonId())+1 == preguntas.get(respuesta.getContador()-1).getCorrecta())
            {
                respuesta.setCorrecta(respuesta.getCorrecta()+1);
            }
    }
}
