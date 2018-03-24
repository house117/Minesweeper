/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author cavr0
 */
public class Celda {
    private Estado estado;
    private Boolean mina;
    private Integer numero;
    private Integer x;
    private Integer y;
    
    public Celda(Integer x, Integer y){
        this.x=x;
        this.y=y;
        this.estado = Estado.CERRADO;
        this.mina = false;
        
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public Boolean isMina() {
        return mina;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setMina(Boolean mina) {
        this.mina = mina;
    }
    
    public void marcarCelda(){
        switch(estado){
            case CERRADO:
                this.setEstado(Estado.BANDERA);
            case BANDERA:
                this.setEstado(Estado.INTERROGACION);
            case INTERROGACION:
                this.setEstado(Estado.CERRADO);
            default:
                throw new AssertionError();
        }
    }
    public void nextEdo(){
        switch (estado) {
            case CERRADO:
                estado = Estado.BANDERA;
                break;
            case BANDERA:
                estado = Estado.INTERROGACION;
                break;
            case INTERROGACION:
                estado = Estado.CERRADO;
                break;                
        }
    }
    public void abrirCelda(){
        if (estado == Estado.CERRADO){
            this.estado = Estado.ABIERTO;
        }
    }
    
    public String toString(){
        
        switch(estado){
            case CERRADO:
                //if(this.isMina()){
                   // return "[*]";
                //}else{
                     return String.format("[-]");
                //}
            case BANDERA:
                return String.format("[^]");
            case BANDERAMALA:
                return String.format("[X]");
            case MINA:
                return String.format("[*]");
            case INTERROGACION:
                return String.format("[?]");
            case ABIERTO:
               if(numero==0){
                    return "[ ]";
                }else{
                    return "["+numero+"]";
                }
            case BOOM:
                return String.format("[B]");
            default:
                throw new AssertionError();
        }
    }
   
    
}
