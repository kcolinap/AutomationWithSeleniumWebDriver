package AcseleV13_8LBC.beans;

import org.apache.log4j.Logger;

/**
 * Created by agil on 19/10/2016.
 */
public class LBC_Caja {

    private final static Logger log = Logger.getLogger(LBC_Caja.class);

    private String descripcion;
    private String ubicacion;
    private String sucursal;
    private String cajero;
    private String numeroCaja;
    private String nombreCajero;
    private String apellidoCajero;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(String numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public String getApellidoCajero() {
        return apellidoCajero;
    }

    public void setApellidoCajero(String apellidoCajero) {
        this.apellidoCajero = apellidoCajero;
    }
}
