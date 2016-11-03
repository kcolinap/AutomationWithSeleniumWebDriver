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
public class UsoTablasDinamicasImportadasBean extends PolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(UsoTablasDinamicasImportadasBean.class);

    private String nombreTablaDinamica;
    private String rutaTablaDinamica;
    private String valorComparacionTD;

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
                usoTablasDinamicasImportadasBean.setNumeroPoliza(rs.getString("NUM_POLIZA"));
                usoTablasDinamicasImportadasBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                usoTablasDinamicasImportadasBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                usoTablasDinamicasImportadasBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                usoTablasDinamicasImportadasBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setTomadorNombre1(rs.getString("TOMADOR_NOMBRE"));
                usoTablasDinamicasImportadasBean.setNumeroCredito(rs.getString("NUM_CREDITO"));
                usoTablasDinamicasImportadasBean.setFechaProceso(rs.getString("FECHA_PROCESO"));
                usoTablasDinamicasImportadasBean.setDocumentoIdentidadAsegurado(rs.getString("DOC_ID_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setFechaNacimientoAsegurado(rs.getString("FECHA_NAC_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setDireccionAsegurado(rs.getString("DIRECCION_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setDepartamento(rs.getString("DEPARTAMENTO_ASEGURADO"));
                usoTablasDinamicasImportadasBean.setCiudad(rs.getString("CIUDAD_ASEGURADO"));

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
