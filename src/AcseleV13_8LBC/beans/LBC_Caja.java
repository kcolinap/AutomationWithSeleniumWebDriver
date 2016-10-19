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
}
