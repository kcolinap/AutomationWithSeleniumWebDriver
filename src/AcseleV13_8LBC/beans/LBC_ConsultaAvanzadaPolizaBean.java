package AcseleV13_8LBC.beans;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Created by aazuaje on 11/10/2016.
 */
public class LBC_ConsultaAvanzadaPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_ConsultaAvanzadaPolizaBean.class);

    private String ordenarPor;
    private String buscarPor;
    private String producto;
    private String edoCicloVida;
    private String numPoliza;
    private String numPropuesta;
    private String fechaEmision;


    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getBuscarPor() {return buscarPor;}
    public void setBuscarPor(String buscarPor) {this.buscarPor = buscarPor;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getEdoCicloVida() {return edoCicloVida;}
    public void setEdoCicloVida(String edoCicloVida) {this.edoCicloVida = edoCicloVida;}

    public String getNumPoliza() {return numPoliza;}
    public void setNumPoliza(String numPoliza) {this.numPoliza = numPoliza;}

    public String getNumPropuesta() {return numPropuesta;}
    public void setNumPropuesta(String numPropuesta) {this.numPropuesta = numPropuesta;}

    public String getFechaEmision() {return fechaEmision;}
    public void setFechaEmision(String fechaEmision) {this.fechaEmision = fechaEmision;}

    public static ArrayList getLBC_ConsultaAvanzadaPolizaBean() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaAvanzada = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,ORDENAR_POR,BUSCAR_POR,PRODUCTO,EDO_CICLO_VIDA, NUM_POLIZA, NUM_PROPUESTA,FECHA_EMISION from CONSULTA_POLIZA_AVANZADA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_ConsultaAvanzadaPolizaBean lbcConsultaAvanzadaPolizaBean = new LBC_ConsultaAvanzadaPolizaBean();

                lbcConsultaAvanzadaPolizaBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                lbcConsultaAvanzadaPolizaBean.setBuscarPor(rs.getString("BUSCAR_POR"));
                lbcConsultaAvanzadaPolizaBean.setProducto(rs.getString("PRODUCTO"));
                lbcConsultaAvanzadaPolizaBean.setEdoCicloVida(rs.getString("EDO_CICLO_VIDA"));
                lbcConsultaAvanzadaPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                lbcConsultaAvanzadaPolizaBean.setNumPropuesta(rs.getString("NUM_PROPUESTA"));
                lbcConsultaAvanzadaPolizaBean.setFechaEmision(rs.getString("FECHA_EMISION"));


                consultaAvanzada.add(lbcConsultaAvanzadaPolizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return consultaAvanzada;

    }


}
