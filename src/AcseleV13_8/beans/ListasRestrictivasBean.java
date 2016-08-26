package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kzambrano on 25/08/2016.
 */
public class ListasRestrictivasBean implements Serializable{

    private final static Logger log = Logger.getLogger(ListasRestrictivasBean.class);

    private String tipoLista;
    private String nombreLista;
    private String archivo;
    private String listaNombre;
    private String tipoCoincidencia;
    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String eventoAplicar;
    private String numPoliza;
    private String lineaCredito;
    private String unidadNegocio;
    private String canalVenta;
    private String tipoValorAsegurado;
    private String tomadorNombre;
    private String numCredito;
    private String fechaProceso;
    private String montoAsegurado;
    private String docIdAsegurado;
    private String fechaNacAsegurado;
    private String direccionAsegurado;
    private String departamentoAsegurado;
    private String ciudadAsegurado;
    private String asegurado;





    public String getTipoLista() {return tipoLista;}
    public void setTipoLista (String tipoLista) {this.tipoLista = tipoLista;}

    public String getNombreLista() {return nombreLista;}
    public void setNombreLista (String nombreLista) {this.nombreLista = nombreLista;}

    public String getArchivo() {return archivo;}
    public void setArchivo (String archivo) {this.archivo = archivo;}

    public String getListaNombre() {return listaNombre;}
    public void setListaNombre (String listaNombre) {this.listaNombre = listaNombre;}

    public String getTipoCoincidencia() {return tipoCoincidencia;}
    public void setTipoCoincidencia (String tipoCoincidencia) {this.tipoCoincidencia = tipoCoincidencia;}

    public String getProducto() {return producto;}
    public void setProducto (String producto) {this.producto = producto;}

    public String getVigencia() {return vigencia;}
    public void setVigencia (String vigencia) {this.vigencia = vigencia;}

    public String getFechaDesde() {return fechaDesde;}
    public void setFechaDesde (String fechaDesde) {this.fechaDesde = fechaDesde;}

    public String getEventoAplicar() {return eventoAplicar;}
    public void setEventoAplicar (String eventoAplicar) {this.eventoAplicar = eventoAplicar;}

    public String getNumPoliza() {return numPoliza;}
    public void setNumPoliza (String numPoliza) {this.numPoliza = numPoliza;}

    public String getLineaCredito() {return lineaCredito;}
    public void setLineaCredito (String lineaCredito) {this.lineaCredito = lineaCredito;}

    public String getUnidadNegocio() {return unidadNegocio;}
    public void setUnidadNegocio (String unidadNegocio) {this.unidadNegocio = unidadNegocio;}

    public String getCanalVenta() {return canalVenta;}
    public void setCanalVenta (String canalVenta) {this.canalVenta = canalVenta;}

    public String getTipoValorAsegurado() {return tipoValorAsegurado;}
    public void setTipoValorAsegurado (String tipoValorAsegurado) {this.tipoValorAsegurado = tipoValorAsegurado;}

    public String getTomadorNombre() {return tomadorNombre;}
    public void setTomadorNombre (String tomadorNombre) {this.tomadorNombre = tomadorNombre;}

    public String getNumCredito() {return numCredito;}
    public void setNumCredito (String numCredito) {this.numCredito = numCredito;}

    public String getFechaProceso() {return fechaProceso;}
    public void setFechaProceso (String fechaProceso) {this.fechaProceso = fechaProceso;}

    public String getMontoAsegurado() {return montoAsegurado;}
    public void setMontoAsegurado (String montoAsegurado) {this.montoAsegurado = montoAsegurado;}

    public String getDocIdAsegurado() {return docIdAsegurado;}
    public void setDocIdAsegurado (String docIdAsegurado) {this.docIdAsegurado = docIdAsegurado;}

    public String getFechaNacAsegurado() {return fechaNacAsegurado;}
    public void setFechaNacAsegurado (String fechaNacAsegurado) {this.fechaNacAsegurado = fechaNacAsegurado;}


    public String getDireccionAsegurado() {return direccionAsegurado;}
    public void setDireccionAsegurado (String direccionAsegurado) {this.direccionAsegurado = direccionAsegurado;}

    public String getDepartamentoAsegurado() {return departamentoAsegurado;}
    public void setDepartamentoAsegurado (String departamentoAsegurado) {this.departamentoAsegurado = departamentoAsegurado;}

    public String getCiudadAsegurado() {return ciudadAsegurado;}
    public void setCiudadAsegurado (String ciudadAsegurado) {this.ciudadAsegurado = ciudadAsegurado;}

    public String getAsegurado() {return asegurado;}
    public void setAsegurado (String asegurado) {this.asegurado = asegurado;}


    public static ArrayList getListasRestrictivas() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList listasRestrictivas = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPOLISTA, NOMBRELISTA, ARCHIVO, LISTANOMBRE, TIPOCOINCIDENCIA, PRODUCTO, VIGENCIA, FECHADESDE, EVENTOAPLICAR, NUMPOLIZA, LINEACREDITO, UNIDADNEGOCIO, CANALVENTA, TIPOVALORASEGURADO, TOMADORNOMBRE, NUMCREDITO, FECHAPROCESO, MONTOASEGURADO, DOCIDASEGURADO, FECHANACASEGURADO, DIRECCIONASEGURADO, DEPARTAMENTOASEGURADO , CIUDADASEGURADO, ASEGURADO FROM LISTAS_RESTRICTIVAS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ListasRestrictivasBean listasRestrictivasBean = new ListasRestrictivasBean();

                listasRestrictivasBean.setTipoLista(rs.getString("TIPOLISTA"));
                listasRestrictivasBean.setNombreLista(rs.getString("NOMBRELISTA"));
                listasRestrictivasBean.setArchivo(rs.getString("ARCHIVO"));
                listasRestrictivasBean.setListaNombre(rs.getString("LISTANOMBRE"));
                listasRestrictivasBean.setTipoCoincidencia(rs.getString("TIPOCOINCIDENCIA"));
                listasRestrictivasBean.setProducto(rs.getString("PRODUCTO"));
                listasRestrictivasBean.setVigencia(rs.getString("VIGENCIA"));
                listasRestrictivasBean.setFechaDesde(rs.getString("FECHADESDE"));
                listasRestrictivasBean.setEventoAplicar(rs.getString("EVENTOAPLICAR"));
                listasRestrictivasBean.setNumPoliza(rs.getString("NUMPOLIZA"));
                listasRestrictivasBean.setLineaCredito(rs.getString("LINEACREDITO"));
                listasRestrictivasBean.setUnidadNegocio(rs.getString("UNIDADNEGOCIO"));
                listasRestrictivasBean.setCanalVenta(rs.getString("CANALVENTA"));
                listasRestrictivasBean.setTipoValorAsegurado(rs.getString("TIPOVALORASEGURADO"));
                listasRestrictivasBean.setTomadorNombre(rs.getString("TOMADORNOMBRE"));
                listasRestrictivasBean.setNumCredito(rs.getString("NUMCREDITO"));
                listasRestrictivasBean.setFechaProceso(rs.getString("FECHAPROCESO"));
                listasRestrictivasBean.setMontoAsegurado(rs.getString("MONTOASEGURADO"));
                listasRestrictivasBean.setDocIdAsegurado(rs.getString("DOCIDASEGURADO"));
                listasRestrictivasBean.setFechaNacAsegurado(rs.getString("FECHANACASEGURADO"));
                listasRestrictivasBean.setDireccionAsegurado(rs.getString("DIRECCIONASEGURADO"));
                listasRestrictivasBean.setDepartamentoAsegurado(rs.getString("DEPARTAMENTOASEGURADO"));
                listasRestrictivasBean.setCiudadAsegurado(rs.getString("CIUDADASEGURADO"));
                listasRestrictivasBean.setAsegurado(rs.getString("ASEGURADO"));



                listasRestrictivas.add(listasRestrictivasBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return listasRestrictivas;

    }





}
