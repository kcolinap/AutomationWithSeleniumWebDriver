package AcseleV13_8_Rimac.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kcolina on 20/03/2017.
 */
public class Rimac_ClonarProductoBean {

    private final static Logger log = Logger.getLogger(Rimac_ClonarProductoBean.class);

    private String nombreProducto;
    private String nombreProductoClonado;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreProductoClonado() {
        return nombreProductoClonado;
    }

    public void setNombreProductoClonado(String nombreProductoClonado) {
        this.nombreProductoClonado = nombreProductoClonado;
    }

    public static ArrayList getClonarProductoBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList rimacClonarProducto = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM RIMAC_CLONARPRODUCTO ORDER BY prueba ASC");

        try {
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Rimac_ClonarProductoBean rimacClonarProductoBean = new Rimac_ClonarProductoBean();

                rimacClonarProductoBean.setNombreProducto(rs.getString("nombreproducto"));
                rimacClonarProductoBean.setNombreProductoClonado(rs.getString("NOMBREPRODUCTOCLONADO"));

                rimacClonarProducto.add(rimacClonarProductoBean);
            }
        }catch (Exception e){
            log.error(e);
        }finally {
            if (conexion != null){
                conexion.close();
            }
        }

        return rimacClonarProducto;
    }
}
