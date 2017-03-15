package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kcolina on 15/03/2017.
 */
public class Asesuisa_SiniestroBusquedaSimpleBean extends Asesuisa_SiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaSimpleBean.class);

    public static ArrayList getSiniestroBusquedaSimpleBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaSiniestroBusquedaSimple = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select");
    }
}
