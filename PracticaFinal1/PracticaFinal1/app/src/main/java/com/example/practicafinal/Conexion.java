package com.example.practicafinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {

    final String CREATE_TABLE_PREGUNTAS="CREATE TABLE PREGUNTAS(codigo number primary key,pregunta text,respuesta1 text,respuesta2 text,respuesta3 text,respuesta4 text,correcta number)";

    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PREGUNTAS);
        db.execSQL("insert into preguntas values(1,'Nos encanta mirar al cielo pero hay un mamifero el que esta acción le es fisicamente imposible.¿De qué animal se trata?','jirafa','cerdo','rinoceronte','cebra',2)");
        db.execSQL("insert into preguntas values(2,'¿Cuantos dientes posee un tiburon ballena de media?','mas de 3500','mas de 4500','mas de 5500','mas de 7000',2)");
        db.execSQL("insert into preguntas values(3,'¿Que animales  son incapaces de vomitar?','ranas, caballos y ratas','ranas, ratas y elefantes','caballos, elefantes y jirafas','ranas,caballos y elefantes',1)");
        db.execSQL("insert into preguntas values(4,'¿Que simio se contagia de la risa con una facilidad pasmosa?','gorila','chimpances','orangutan','mono',3)");
        db.execSQL("insert into preguntas values(5,'¿Como se llama el escarabajo mas grande del mundo?','escarabajo titan','escarabajo violín','escarabajo ciervo','escarabajo gigante',1)");
        db.execSQL("insert into preguntas values(6,'¿Animal que tiene mas de 2000 musculos?','anaconda','cerdo','caracol','oruga',4)");
        db.execSQL("insert into preguntas values(7,'Es el macho el que gesta las crias¿A que animal se trata?','Rana dorada','hipopotamo','rinoceronte','caballito de mar',4)");
        db.execSQL("insert into preguntas values(8,'¿Cual es el unico mamifero del mundo que no tiene cuerdas vocales?','jirafas','topos','equidnas','cebra',1)");
        db.execSQL("insert into preguntas values(9,'¿Por que motivo cambian de color los camaleones?','para adaptarse a un entorno','para expresar emociones','para camuflarse','todas las anteriores',2)");
        db.execSQL("insert into preguntas values(10,'¿Cual es el animal con el mejor oido del reino animal?','polilla de la cera','murcielago orejudo dorado','delfín mular','cebra',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS preguntas");
        onCreate(db);
    }
}
