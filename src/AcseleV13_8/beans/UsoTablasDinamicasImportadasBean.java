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
 * Created by agil on 17/08/2016.
 */
public class UsoTablasDinamicasImportadasBean implements Serializable {

    private final static Logger log = Logger.getLogger(UsoTablasDinamicasImportadasBean.class);

    private String nombreTablaDinamica;
    private String rutaTablaDinamica;
    private String valorComparacionTD;
    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String eventoAplicar;
    private String fechaMovimiento;
    private String numPoliza;
    private String lineaCredito;
    private String unidadNegocio;
    private String canalVenta;
    private String tipoValorAsegurado;
    private String tomadorNombre;
    private String numCredito;
    private String fechaProceso;
    private String docIdAsegurado;
    private String fechaNacAsegurado;
    private String direccionAsegurado;
    private String departamentoAsegurado;
    private String ciudadAsegurado;


    public String getNombreTablaDinamica(){
        return nombreTablaDinamica;
    }
    public void setNombreTablaDinamica(String nombreTablaDinamica){
        this.nombreTablaDinamica = nombreTablaDinamica;
    }

    public String getRutaTablaDinamica(){
        return rutaTablaDinamica;
    }
    public void setRutaTablaDinamica(String rutaTablaDinamica){
        this.rutaTablaDinamica = rutaTablaDinamica;
    }

    public String getValorComparacionTD(){
        return valorComparacionTD;
    }
    public void setValorComparacionTD(String valorComparacionTD){
        this.valorComparacionTD = valorComparacionTD;
    }

    public String getProducto(){
        return producto;
    }
    public void setProducto(String producto){
        this.producto = producto;
    }

    public String getVigencia(){
        return vigencia;
    }
    public void setVigencia(String vigencia){
        this.vigencia = vigencia;
    }

    public String getFechaDesde(){
        return fechaDesde;
    }
    public void setFechaDesde(String fechaDesde){
        this.fechaDesde = fechaDesde;
    }

    public String getEventoAplicar(){
        return eventoAplicar;
    }
    public void setEventoAplicar(String eventoAplicar){
        this.eventoAplicar = eventoAplicar;
    }

    public String getFechaMovimiento(){
        return fechaMovimiento;
    }
    public void setFechaMovimiento(String fechaMovimiento){
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getNumPoliza(){
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza){
        this.numPoliza = numPoliza;
    }

    public String getLineaCredito(){
        return lineaCredito;
    }
    public void setLineaCredito(String lineaCredito){
        this.lineaCredito = lineaCredito;
    }

    public String getUnidadNegocio(){
        return unidadNegocio;
    }
    public void setUnidadNegocio(String unidadNegocio){
        this.unidadNegocio = unidadNegocio;
    }

    public String getCanalVenta(){
        return canalVenta;
    }
    public void setCanalVenta(String canalVenta){
        this.canalVenta = canalVenta;
    }

    public String getTipoValorAsegurado(){
        return tipoValorAsegurado;
    }
    public void setTipoValorAsegurado(String tipoValorAsegurado){
        this.tipoValorAsegurado = tipoValorAsegurado;
    }

    public String getTomadorNombre(){
        return tomadorNombre;
    }
    public void setTomadorNombre(String tomadorNombre){
        this.tomadorNombre = tomadorNombre;
    }

    public String getNumCredito(){
        return numCredito;
    }
    public void setNumCredito(String numCredito){
        this.numCredito = numCredito;
    }

    public String getFechaProceso(){
        return fechaProceso;
    }
    public void setFechaProceso(String fechaProceso){
        this.fechaProceso = fechaProceso;
    }

    public String getDocIdAsegurado(){
        return docIdAsegurado;
    }
    public void setDocIdAsegurado(String docIdAsegurado){
        this.docIdAsegurado = docIdAsegurado;
    }

    public String getFechaNacAsegurado(){
        return fechaNacAsegurado;
    }
    public void setFechaNacAsegurado(String fechaNacAsegurado){
        this.fechaNacAsegurado = fechaNacAsegurado;
    }

    public String getDireccionAsegurado(){
        return direccionAsegurado;
    }
    public void setDireccionAsegurado(String direccionAsegurado){
        this.direccionAsegurado = direccionAsegurado;
    }

    public String getDepartamentoAsegurado(){
        return departamentoAsegurado;
    }
    public void setDepartamentoAsegurado(String departamentoAsegurado){
        this.departamentoAsegurado = departamentoAsegurado;
    }

    public String getCiudadAsegurado(){
        return ciudadAsegurado;
    }
    public void setCiudadAsegurado(String ciudadAsegurado){
        this.ciudadAsegurado = ciudadAsegurado;
    }



    public static ArrayList getUsoTablasDinamicasImportadas() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList usoTablas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NOMBRE_TABLA_DINAMICA, RUTA_TABLA_DINAMICA, VALOR_COMPARACION_TD, PRODUCTO, VIGENCIA, FECHA_DESDE, EVENTO_APLICAR, FECHA_MOVIMIENTO, NUM_POLIZA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TOMADOR_NOMBRE, NUM_CREDITO, FECHA_PROCESO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, DEPARTAMENTO_ASEGURADO, CIUDAD_ASEGURADO FROM USO_TABLA_DINAMICA_IMPORTADA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean = new UsoTablasDinamicasImportadasBean();

                usoTablasDinamicasImportadasBean.setNombreTablaDinamica(rs.getString("NOMBRE_TABLA_DINAMICA"));
                usoTablasDinamicasImportadasBean.setRutaTablaDinamica(rs.getString("RUTA_TABLA_DINAMICA"));
                usoTablasDinamicasImportadasBean.setValorComparacionTD(rs.getString("VALOR_COMPARACION_TD"));
                usoTablasDinamicasImportadasBean.setProducto(rs.getString("PRODUCTO"));
                usoTablasDinamicasImportadasBean.setVigencia(rs.getString("VIGENCIA"));
                usoTablasDinamicasImportadasBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                usoTablasDinamicasImportadasBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                usoTablasDinamicasImportadasBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                usoTablasDinamicasImportadasBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                usoTablasDinamicasImportadasBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                usoTablasDinamicasImportadasBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                usoTablasDinamicasImportadasBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                usoTablasDinamicasImportadasBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setTomadorNombre(rs.getString("TOMADOR_NOMBRE"));
                usoTablasDinamicasImportadasBean.setNumCredito(rs.getString("NUM_CREDITO"));
                usoTablasDinamicasImportadasBean.setFechaProceso(rs.getString("FECHA_PROCESO"));
                usoTablasDinamicasImportadasBean.setDocIdAsegurado(rs.getString("DOC_ID_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setFechaNacAsegurado(rs.getString("FECHA_NAC_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setDireccionAsegurado(rs.getString("DIRECCION_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setDepartamentoAsegurado(rs.getString("DEPARTAMENTO_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setCiudadAsegurado(rs.getString("CIUDAD_ASEGURADO"));

                usoTablas.add(usoTablasDinamicasImportadasBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return usoTablas;

    }
}

//NOMBRE_TABLA_DINAMICA, RUTA_TABLA_DINAMICA, VALOR_COMPARACION_TD,
// PRODUCTO, VIGENCIA, FECHA_DESDE, EVENTO_APLICAR, FECHA_MOVIMIENTO,
// NUM_POLIZA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO,
// TOMADOR_NOMBRE, NUM_CREDITO, FECHA_PROCESO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO,
// DIRECCION_ASEGURADO, DEPARTAMENTO_ASEGURADO, CIUDAD_ASEGURADO
