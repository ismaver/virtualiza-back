package com.web.servicios;

//clase para devoler un mensaje de error
public class ErrorMessage {

    private int codigo;//codigo de error del mensaje
    private String mensaje;//mensaje explicando el error

    //constructor de la clase
    public ErrorMessage(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    //obtener el codigo del error
    public int getCodigo() {
        return codigo;
    }

    //asignar el codigo del error
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //obtener el mensaje del error
    public String getMensaje() {
        return mensaje;
    }

    //asignar el mensaje de error
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
