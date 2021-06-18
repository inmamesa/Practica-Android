package com.example.practicafinal.controlador;

public class respuestas {
    private int contador;
    private int correcta;

    public respuestas(int contador, int correcta) {
        this.contador = contador;
        this.correcta = correcta;
    }

    public int getContador() {
        return contador;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }
}
