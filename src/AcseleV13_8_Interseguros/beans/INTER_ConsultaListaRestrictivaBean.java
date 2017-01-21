package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 18/01/2017.
 */
public class INTER_ConsultaListaRestrictivaBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaListaRestrictivaBean.class);

    private String lista;
    private String nombre;
    private String apellido;

    public String getLista() {return lista;}
    public void setLista(String lista) {this.lista = lista;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public static ArrayList getINTER_ConsultaListaRestrictiva() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interConsultaLista = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,lista, nombre,apellido FROM INTER_CONSULTA_LISTA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ConsultaListaRestrictivaBean inter_consultaListaRestrictivaBean = new INTER_ConsultaListaRestrictivaBean();

                inter_consultaListaRestrictivaBean.setLista(rs.getString("LISTA"));
                inter_consultaListaRestrictivaBean.setNombre(rs.getString("NOMBRE"));
                inter_consultaListaRestrictivaBean.setApellido(rs.getString("APELLIDO"));

                interConsultaLista.add(inter_consultaListaRestrictivaBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return interConsultaLista;
    }
}
