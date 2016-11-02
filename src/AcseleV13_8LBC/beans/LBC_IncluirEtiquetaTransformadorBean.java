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
 * Created by rmontilla on 01/11/2016.
 */
public class LBC_IncluirEtiquetaTransformadorBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_IncluirEtiquetaTransformadorBean.class);

    private String propiedad;
    private String valor;
    private String label;
    private String locale;
    private String producto;


    public String getPropiedad() {return propiedad;}
    public void setPropiedad (String propiedad) {this.propiedad = propiedad;}

    public String getValor() {return valor;}
    public void setValor (String valor) {this.valor = valor;}

    public String getLabel() {return label;}
    public void setLabel (String label) {this.label = label;}

    public String getLocale() {return locale;}
    public void setLocale (String locale) {this.locale = locale;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}


    public static ArrayList getLBC_IncluirEtiquetaTransformador() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList lbc_IncluirEtiquetaTransformador = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM LBC_ETIQUETA_TRANSFORMADORES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_IncluirEtiquetaTransformadorBean lbc_IncluirEtiquetaTransformadorBean = new LBC_IncluirEtiquetaTransformadorBean();

                lbc_IncluirEtiquetaTransformadorBean.setPropiedad(rs.getString("PROPIEDAD"));
                lbc_IncluirEtiquetaTransformadorBean.setValor(rs.getString("VALOR"));
                lbc_IncluirEtiquetaTransformadorBean.setLabel(rs.getString("ETIQUETA"));
                lbc_IncluirEtiquetaTransformadorBean.setLocale(rs.getString("LOCALE"));
                lbc_IncluirEtiquetaTransformadorBean.setProducto(rs.getString("PRODUCTO"));

                lbc_IncluirEtiquetaTransformador.add(lbc_IncluirEtiquetaTransformadorBean);


            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return lbc_IncluirEtiquetaTransformador;
    }

}
