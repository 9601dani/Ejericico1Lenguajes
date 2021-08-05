package Practica1;

/**
 *
 * @author daniel
 */
public class Token {
    private char[] cadena;
    private Identificador tipo;
    
    public Token(char[] cadena, Identificador tipo) {
        this.cadena = cadena;
        this.tipo = tipo;
    }

    public char[] getCadena() {
        return cadena;
    }

    public Identificador getTipo() {
        return tipo;
    }

    public void setCadena(char[] cadena) {
        this.cadena = cadena;
    }

    public void setTipo(Identificador tipo) {
        this.tipo = tipo;
    }
    
}
