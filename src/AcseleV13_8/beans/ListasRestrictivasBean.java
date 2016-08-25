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

    public static ArrayList getListasRestrictivas() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList listasRestrictivas = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPOLISTA, NOMBRELISTA, ARCHIVO, LISTANOMBRE, TIPOCOINCIDENCIA FROM LISTAS_RESTRICTIVAS ORDER BY PRUEBA ASC");

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
