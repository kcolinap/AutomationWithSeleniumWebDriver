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
 * Created by aazuaje on 25/08/2016.
 */
public class ConsultaListasRestrictivasBean  implements Serializable{

    private final static Logger log = Logger.getLogger(ConsultaListasRestrictivasBean.class);

    private String listaRestrictiva;
    private String identListaRestrictiva;
    private String nombreListaRestrictiva;
    private String apellidoListaRestrictiva;
    private String codigoListaRestrictiva;
    private String observacionListaRestrictiva;
    private String listaRelativaSanciones;

    public String getListaRestrictiva() {return listaRestrictiva;}
    public void setListaRestrictiva(String listaRestrictiva) {this.listaRestrictiva = listaRestrictiva;}

    public String getIdentListaRestrictiva() {return identListaRestrictiva;}
    public void setIdentListaRestrictiva(String identListaRestrictiva) {this.identListaRestrictiva = identListaRestrictiva;}

    public String getNombreListaRestrictiva() {return nombreListaRestrictiva;}
    public void setNombreListaRestrictiva(String nombreListaRestrictiva) {this.nombreListaRestrictiva = nombreListaRestrictiva;}

    public String getApellidoListaRestrictiva() {return apellidoListaRestrictiva;}
    public void setApellidoListaRestrictiva(String apellidoListaRestrictiva) {this.apellidoListaRestrictiva = apellidoListaRestrictiva;}

    public String getCodigoListaRestrictiva() {return codigoListaRestrictiva;}
    public void setCodigoListaRestrictiva(String codigoListaRestrictiva) {this.codigoListaRestrictiva = codigoListaRestrictiva;}

    public String getObservacionListaRestrictiva() {return observacionListaRestrictiva;}
    public void setObservacionListaRestrictiva(String observacionListaRestrictiva) {this.observacionListaRestrictiva = observacionListaRestrictiva;}

    public String getListaRelativaSanciones() {return listaRelativaSanciones;}
    public void setListaRelativaSanciones(String listaRelativaSanciones) {this.listaRelativaSanciones = listaRelativaSanciones;}

    public static ArrayList getConsultaListasRestrictivas() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList listasRestrictivas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Lista_Restrictiva,Ident_Lista_Restrictiva,Nombre_Lista_Restrictiva,Apellido_Lista_Restrictiva,Codigo_Lista_Restrictiva,Observacion_Lista_Restrictiva,Lista_Relativa_Sanciones FROM LISTA_RESTRICTIVA ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                ConsultaListasRestrictivasBean consultaListasRestrictivasBean = new ConsultaListasRestrictivasBean();

                consultaListasRestrictivasBean.setListaRestrictiva(rs.getString("LISTA_RESTRICTIVA"));
                consultaListasRestrictivasBean.setIdentListaRestrictiva(rs.getString("IDENT_LISTA_RESTRICTIVA"));
                consultaListasRestrictivasBean.setNombreListaRestrictiva(rs.getString("NOMBRE_LISTA_RESTRICTIVA"));
                consultaListasRestrictivasBean.setApellidoListaRestrictiva(rs.getString("APELLIDO_LISTA_RESTRICTIVA"));
                consultaListasRestrictivasBean.setCodigoListaRestrictiva(rs.getString("CODIGO_LISTA_RESTRICTIVA"));
                consultaListasRestrictivasBean.setObservacionListaRestrictiva(rs.getString("OBSERVACION_LISTA_RESTRICTIVA"));
                consultaListasRestrictivasBean.setListaRelativaSanciones(rs.getString("LISTA_RELATIVA_SANCIONES"));

                listasRestrictivas.add(consultaListasRestrictivasBean);

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
