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
 * Created by aazuaje on 23/08/2016.
 */
public class FormulacionesBean implements Serializable   {

    private final static Logger log = Logger.getLogger(FormulacionesBean.class);

    private String regla ;
    private String descripcionFormula ;
    private String buscar ;

    public String getRegla() {return regla;}
    public void setRegla(String regla) {this.regla = regla;}

    public String getDescripcionFormula() {return descripcionFormula;}
    public void setDescripcionFormula(String descripcionFormula) {this.descripcionFormula = descripcionFormula;}

    public String getBuscar() {return buscar;}
    public void setBuscar(String buscar) {this.buscar = buscar;}

    public static ArrayList getFormulaciones() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList formulaciones = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba, Regla, Descripcion_Formula, Buscar  from FORMULACIONES ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {

                FormulacionesBean formulacionesBean = new FormulacionesBean();

                formulacionesBean.setRegla(rs.getString("REGLA"));
                formulacionesBean.setDescripcionFormula(rs.getString("DESCRIPCION_FORMULA"));
                formulacionesBean.setBuscar(rs.getString("BUSCAR"));

                formulaciones.add(formulacionesBean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return formulaciones;

    }
}