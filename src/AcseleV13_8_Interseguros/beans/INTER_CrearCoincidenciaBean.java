package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 31/01/2017.
 */
public class INTER_CrearCoincidenciaBean {

    private final static Logger log = Logger.getLogger(INTER_CrearCoincidenciaBean.class);

    private String nombreLista;
    private String tipoCoincidencia;

    public String getNombreLista() {return nombreLista;}
    public void setNombreLista(String nombreLista) {this.nombreLista = nombreLista;}

    public String getTipoCoincidencia() {return tipoCoincidencia;}
    public void setTipoCoincidencia(String tipoCoincidencia) {this.tipoCoincidencia = tipoCoincidencia;}


    public static ArrayList getINTER_CrearCoincidencia() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interCrearCoincidencia = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,nombre_lista, tipo_coincidencia FROM INTER_COINCIDENCIAS ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CrearCoincidenciaBean inter_crearCoincidenciaBean= new INTER_CrearCoincidenciaBean();

                inter_crearCoincidenciaBean.setNombreLista(rs.getString("NOMBRE_LISTA"));
                inter_crearCoincidenciaBean.setTipoCoincidencia(rs.getString("TIPO_COINCIDENCIA"));

                interCrearCoincidencia.add(inter_crearCoincidenciaBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interCrearCoincidencia;

    }
}
