package com.preguntas.quiz;

import java.util.ArrayList;

public class Respuestas {
    private int contador;
    private int correctas;
    private ArrayList<Preguntas> preguntas = new ArrayList<Preguntas>();

    public Respuestas(int contador, int correctas) {
        this.contador = contador;
        this.correctas = correctas;
    }
    public void rellenar()
    {
        contador=1;
        correctas=0;

        Preguntas p= new Preguntas(1,"Nos encanta mirar al cielo pero hay un mamifero el que esta acción le es fisicamente imposible.¿De qué animal se trata?","jirafa","cerdo","rinoceronte","cebra",2);
        preguntas.add(p);
        p= new Preguntas(2,"¿Cuantos dientes posee un tiburon ballena de media?","mas de 3500","mas de 4500","mas de 5500","mas de 7000",2);
        preguntas.add(p);
        p= new Preguntas(3,"¿Que animales  son incapaces de vomitar?","ranas, caballos y ratas","ranas, ratas y elefantes","caballos, elefantes y jirafas","ranas,caballos y elefantes",1);
        preguntas.add(p);
        p= new Preguntas(4,"¿Que simio se contagia de la risa con una facilidad pasmosa?","gorila","chimpances","orangutan","mono",3);
        preguntas.add(p);
        p =new Preguntas(5,"¿Como se llama el escarabajo mas grande del mundo?","escarabajo titan","escarabajo violín","escarabajo ciervo","escarabajo gigante",1);
        preguntas.add(p);
    }

    public int getContador() {
        return contador;
    }

    public int getCorrectas() {
        return correctas;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setCorrectas(int correctas) {
        this.correctas = correctas;
    }

    public ArrayList<Preguntas> getPre() {
        return preguntas;
    }

    public void setPre(ArrayList<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }
}


