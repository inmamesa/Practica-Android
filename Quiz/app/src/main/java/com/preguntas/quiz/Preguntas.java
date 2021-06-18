package com.preguntas.quiz;

public class Preguntas {
    private int codigo;
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private int correcta;

    public Preguntas (int codigo, String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, int correcta)
    {
        this.codigo = codigo;
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.correcta = correcta;
    }

    //MÉTODOS 'GETTERS':
    public int getCodigo()
    {
        return codigo;
    }

    public String getPregunta()
    {
        return pregunta;
    }

    public String getRespuesta1()
    {
        return respuesta1;
    }

    public String getRespuesta2()
    {
        return respuesta2;
    }

    public String getRespuesta3()
    {
        return respuesta3;
    }

    public String getRespuesta4()
    {
        return respuesta4;
    }

    public int getCorrecta()
    {
        return correcta;
    }
}
