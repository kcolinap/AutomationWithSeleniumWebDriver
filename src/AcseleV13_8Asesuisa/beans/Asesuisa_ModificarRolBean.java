package AcseleV13_8Asesuisa.beans;


import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by agil on 17/04/2017.
 */
public class Asesuisa_ModificarRolBean extends Asesuisa_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCreacionRepetidaBean.class);

    private String TIPOROL;

    public String getTIPOROL() {
        return TIPOROL;
    }

    public void setTIPOROL(String TIPOROL) {
        this.TIPOROL = TIPOROL;
    }


    public static ArrayList getAsesuisa_TercerosEditar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_MODIFICARROL ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_ModificarRolBean bean = new Asesuisa_ModificarRolBean();


                bean.setNitBuscar(rs.getString("NIT_BUSCAR"));
                bean.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                bean.setGenero(rs.getString("GENERO"));
                bean.setTIPOROL(rs.getString("TIPOROL"));



                tercero.add(bean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tercero;
    }

}
