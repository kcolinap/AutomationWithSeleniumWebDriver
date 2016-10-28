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
 * Created by aazuaje on 27/10/2016.
 */
public class LBC_ConsultaListasRestricBean implements Serializable{

    public final static Logger log = Logger.getLogger(LBC_ConsultaListasRestricBean.class);

    private String listaLbc;
    //private String identLista;
    private String nomApellLista;
    private String docIdenLista;

    public String getListaLbc() {return listaLbc;}
    public void setListaLbc(String listaLbc) {this.listaLbc = listaLbc;}

    /*public String getIdentLista() {return identLista;}
    public void setIdentLista(String identLista) {this.identLista = identLista;}*/

    public String getNomApellLista() {return nomApellLista;}
    public void setNomApellLista(String nomApellLista) {this.nomApellLista = nomApellLista;}

    public String getDocIdenLista() {return docIdenLista;}
    public void setDocIdenLista(String docIdenLista) {this.docIdenLista = docIdenLista;}

    public static ArrayList getConsultaListasRestric() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList lbcListasRestrictivas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Lista_LBC,Ident_Lista,NomApell_Lista,DocIden_Lista FROM LISTA_RESTRICTIVA_LBC ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                LBC_ConsultaListasRestricBean lbc_consultaListasRestricBean = new LBC_ConsultaListasRestricBean();

                lbc_consultaListasRestricBean.setListaLbc(rs.getString("LISTA_LBC"));
                //lbc_consultaListasRestricBean.setIdentLista(rs.getString("IDENT_LISTA"));
                lbc_consultaListasRestricBean.setNomApellLista(rs.getString("NOMAPELL_LISTA"));
                lbc_consultaListasRestricBean.setDocIdenLista(rs.getString("DOCIDEN_LISTA"));


                lbcListasRestrictivas.add(lbc_consultaListasRestricBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return lbcListasRestrictivas;
    }


}
