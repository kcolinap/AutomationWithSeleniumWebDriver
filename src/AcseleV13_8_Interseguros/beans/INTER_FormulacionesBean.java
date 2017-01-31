package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 27/01/2017.
 */
public class INTER_FormulacionesBean {

    private final static Logger log = Logger.getLogger(INTER_FormulacionesBean.class);

    private String regla;
    private String descripcionFormula;
    private String buscar;



    public String getRegla() {return regla;}
    public void setRegla(String regla) {this.regla = regla;}

    public String getDescripcionFormula() {return descripcionFormula;}
    public void setDescripcionFormula(String descripcionFormula) {this.descripcionFormula = descripcionFormula;}

    public String getBuscar() {return buscar;}
    public void setBuscar(String buscar) {this.buscar = buscar;}

    public static ArrayList getINTER_Formulaciones() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interFormulaciones = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,regla, descripcion_formula,buscar FROM INTER_FORMULACIONES ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_FormulacionesBean inter_formulacionesBean= new INTER_FormulacionesBean();

                inter_formulacionesBean.setRegla(rs.getString("REGLA"));
                inter_formulacionesBean.setDescripcionFormula(rs.getString("DESCRIPCION_FORMULA"));
                inter_formulacionesBean.setBuscar(rs.getString("BUSCAR"));

                interFormulaciones.add(inter_formulacionesBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interFormulaciones;

    }


}
