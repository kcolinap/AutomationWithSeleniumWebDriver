package AcseleV13_8_Alfa.beans;

import org.apache.log4j.Logger;
import org.apache.xpath.operations.*;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.lang.String;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by yalvarez on 28/09/2016.
 */
public class ConsultaCoberturaBean implements Serializable /*Implementar Serializable

 Para que un programa java pueda convertir un objeto en un montón de bytes y pueda luego recuperarlo,
 el objeto necesita ser Serializable. Al poder convertir el objeto a bytes, ese objeto se
 puede enviar a través de red, guardarlo en un fichero, y después reconstruirlo al otra lado
 de la red, leerlo del fichero,....*/{

    private final static Logger log = Logger.getLogger(ConsultaCoberturaBean.class);

    private String producto;
    private String numPoliza;


    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }

    public static ArrayList getConsultaCobertura() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaCobertura = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO,  ESTADOS_VIDA, CONTRATANTE, ASEGURADO, ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL, NUM_POLIZA, FECHA_EMISION, MONEDA, TIPO_MONEDA, TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENT_ANT, FECHA_PROX_GEN_PRI, FECHA_PROX_FACT, TIPO_POL, NUM_COT, NUM_PRO  FROM ConsultaCobertura ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ConsultaCoberturaBean consultaCoberturaBean = new ConsultaCoberturaBean();


                consultaCoberturaBean.setProducto(rs.getString("PRODUCTO"));
                consultaCoberturaBean.setNumPoliza(rs.getString("NUM_POLIZA"));


                consultaCobertura.add(consultaCoberturaBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return consultaCobertura;

    }


}
