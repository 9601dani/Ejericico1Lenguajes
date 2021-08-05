package Practica1;

import java.time.format.DecimalStyle;

/**
 *
 * @author daniel
 */
public class Manejador {

    private Token token;
    private String palabra;
    private Ventana datos;
    private char []cadena;
    private char[] digitos = {'0','1','2','3','4','5','6','7','8','9'};
    private char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private char[] simbolos={'[',']','{','}',',',';'};

    public Manejador(String palabra, Ventana datos, Token token) {
        this.palabra = palabra;
        this.datos = datos;
        this.token= token;
        String segundaP= palabra.toLowerCase().trim();
        this.cadena = segundaP.toCharArray();
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void IniciciarVerificacion() {
        
        
        boolean error = false;
        boolean numeroEntero = false;
        boolean numeroDecimal=false;
        boolean id=false;
        boolean simbolo= false;
        
        int contL=0;
        int contS=0;
        
        for(int y=0;y<letras.length;y++){
            if(cadena[0]==letras[y] ){
                id=true;
                contL++;
            }else{
                id=false;
                
            }
        }
        
        for(int g=0;g<cadena.length;g++){
            for (int k=0;k<simbolos.length;k++){
                if(cadena[g]== simbolos[k]){
                    token.setTipo(Identificador.SIMBOLO);
                    datos.introducirDatosALaLista(cadena[g] +" ES UN "+token.getTipo());
                    contS++;
                    contL++;
                }
            }
        }
        
        
        if(contL==0){
            VerificarNumero();
        }else if(contS!=0){
            
        } 
        else {
            VerificarIdentificador();
        }
        
    }
    
    public void VerificarNumero(){
        int contadorLetra=0;
        int contadorDecimal=0;
        for(int i=0;i<letras.length;i++){
            for(int p=0;p<cadena.length;p++){
                if(cadena[p]==letras[i]){
                    contadorLetra++;
                }
            }
        }
        if(contadorLetra==0){
            for(int j=0;j<cadena.length;j++){
                if(cadena[j]== '.'){
                    contadorDecimal++;
                    
                }
            }
        }else{
            token.setTipo(Identificador.ERROR);
            System.out.println("error 1");
            datos.introducirDatosALaLista(palabra+" ES UN "+token.getTipo());
            contadorDecimal++;
        }
        
        if(contadorDecimal==0){
            token.setTipo(Identificador.NUMERO_ENTERO);
           datos.introducirDatosALaLista(palabra+" ES UN "+token.getTipo());
        }else{
           if(contadorLetra==0){
               VerificarDecimal();
           }
            
        }
        
    }
    
    public void VerificarDecimal() {
        int posicion = 0;
        int contadorD=0;
        boolean encontrado = false;

        for (int i = 0; i < cadena.length; i++) {
            if(cadena[i]=='.'){
                posicion=i;
                contadorD++;
            }
        }
        
        if(contadorD==1){
            int contadorLe=0;
            for(int x=posicion+1;x<cadena.length;x++){
                for(int v=0;v<letras.length;v++){
                    if(cadena[x]==letras[v]){
                        contadorLe++;
                    }
                }
            }
            
                if(contadorLe==0){
                    token.setTipo(Identificador.NUMERO_DECIMAL);
                    datos.introducirDatosALaLista(palabra+" ES UN "+token.getTipo());
                }
        }else{
            System.out.println("error2");
            token.setTipo(Identificador.ERROR);
            datos.introducirDatosALaLista(palabra+" ES UN "+token.getTipo());
        }

    }

    public void VerificarIdentificador(){
        int contadorS=0;
        for(int i=0;i<cadena.length;i++){
            for(int j=0;j<simbolos.length;j++){
                if(cadena[i]==simbolos[j]){
                    contadorS++;
                }
            }
        }
        
        if(contadorS==0){
            token.setTipo(Identificador.ID);
            datos.introducirDatosALaLista(palabra+" ES UN "+token.getTipo());
        }else{
            token.setTipo(Identificador.ERROR);
            System.out.println("error 3");
            datos.introducirDatosALaLista(palabra+" ES UN "+token.getTipo());
        }
    }
}
