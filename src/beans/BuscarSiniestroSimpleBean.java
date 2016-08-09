package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by mchurion on 09/08/2016.
 */
public class BuscarSiniestroSimpleBean {

    private String ordenar;
    private String numSiniestro;
    private String numPoliza;
    private String ocurrencia;
    private String producto;

    public String getOrdenar() {
        return ordenar;
    }
    public void setOrdenar(String ordenar) {
        this.ordenar = ordenar;
    }

    public String getNumSiniestro(){
        return numSiniestro;
    }
    public void setNumSiniestro(String numSiniestro){
        this.numSiniestro = numSiniestro;
    }

    public String getNumPoliza(){
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getOcurrencia(){
        return ocurrencia;
    }
    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
}
