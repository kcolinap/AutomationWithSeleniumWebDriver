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
 * Created by kcolina on 17/05/2017.
 */
public class Asesuisa_SiniestroBusquedaAvanzadaBean extends Asesuisa_SiniestroBean
        implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaAvanzadaBean.class);

    private String idCampo;

    public String getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(String idCampo) {
        this.idCampo = idCampo;
    }

    public static ArrayList getSiniestroBusquedaAvanzada() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaSiniestroBusquedaAvanzada = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from ASESUISA_SINIESTRO_BAVANZADA ORDER BY PRUEBA ASC");

        try {

            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_SiniestroBusquedaAvanzadaBean bean = new Asesuisa_SiniestroBusquedaAvanzadaBean();

                bean.setSucursal(rs.getString("SUCURSAL"));
                bean.setNroPoliza(rs.getString("NROPOLIZA"));
                bean.setTipoPoliza(rs.getString("TIPOPOLIZA"));
                bean.setTipoProduccion(rs.getString("TIPOPRODUCCION"));
                bean.setCodigoIdentificador(rs.getString("CODIGOIDENTIFICADOR"));
                bean.setTipoTercero(rs.getString("TIPOTERCERO"));
                bean.setIdCampo(rs.getString("IDCAMPO"));

                asesuisaSiniestroBusquedaAvanzada.add(bean);
            }

        }catch (SQLException e){
            log.error(e);
        }finally {
            if (conexion!=null){
                conexion.close();
            }
        }
        return  asesuisaSiniestroBusquedaAvanzada;
    }
}
