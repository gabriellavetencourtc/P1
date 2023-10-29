/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author daniela
 */
/**
 * La clase Relacion representa una conexión entre dos usuarios en la red social.
 */
public class Relacion {
    private Usuario usuario1;
    private Usuario usuario2;
    private String relacion;
    private Circulo circulo;

/**
     * Crea una nueva instancia de la clase Relacion.
     *
     * @param usuario1 El primer usuario en la relación.
     * @param usuario2 El segundo usuario en la relación.
     */
    public Relacion(Usuario usuario1, Usuario usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.relacion = relacion;
    }

    /**
     * Obtiene el primer usuario en la relación.
     *
     * @return El primer usuario en la relación.
     */
    public Usuario getUsuario1() {
        return usuario1;
    }

    /**
     * Establece el primer usuario en la relación.
     *
     * @param usuario1 El primer usuario en la relación.
     */
    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    /**
     * Obtiene el segundo usuario en la relación.
     *
     * @return El segundo usuario en la relación.
     */
    public Usuario getUsuario2() {
        return usuario2;
    }

    /**
     * Establece el segundo usuario en la relación.
     *
     * @param usuario2 El segundo usuario en la relación.
     */
    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    /**
     * Obtiene el tipo de relación entre los usuarios.
     *
     * @return El tipo de relación.
     */
    public String getRelacion() {
        return relacion;
    }

    /**
     * Establece el tipo de relación entre los usuarios.
     *
     * @param relacion El tipo de relación.
     */
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    /**
     * Obtiene el círculo asociado a esta relación en el mapa.
     *
     * @return El círculo asociado a esta relación.
     */
    public Circulo getCirculo() {
        return circulo;
    }

    /**
     * Establece el círculo asociado a esta relación en el mapa.
     *
     * @param circulo El círculo asociado a esta relación.
     */
    public void setCirculo(Circulo circulo) {
        this.circulo = circulo;
    }
    
}



   
   


    

