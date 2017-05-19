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
 * Created by kcolina on 19/05/2017.
 */
public class Asesuisa_SiniestroBusquedaSimpleBean extends Asesuisa_SiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaSimpleBean.class);

    private String idCampo;

    public String getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(String idCampo) {
        this.idCampo = idCampo;
    }

    public static ArrayList getSiniestroBusquedaSimpleBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaSiniestroBusquedaSimple = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from ASESUISA_SINIESTRO_BSIMPLE ORDER BY PRUEBA ASC");

        try{
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_SiniestroBusquedaSimpleBean bean = new Asesuisa_SiniestroBusquedaSimpleBean();

                bean.setOrdenarPor(rs.getString("ORDENARPOR"));
                bean.setNroSiniestro(rs.getString("NROSINIESTRO"));
                bean.setNroPoliza(rs.getString("FECHAOCURRENCIA"));
                bean.setFechaOcurrencia(rs.getString("NROPOLIZA"));
                bean.setProducto(rs.getString("PRODUCTO"));
                bean.setIdCampo(rs.getString("IDCAMPO"));

                asesuisaSiniestroBusquedaSimple.add(bean);
            }

        }catch (SQLException e){
            log.error(e);
        }finally {
            if (conexion!=null){
                conexion.close();
            }
        }

        return asesuisaSiniestroBusquedaSimple;
    }
}
