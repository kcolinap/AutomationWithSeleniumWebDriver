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
 * Created by agil on 13/10/2016.
 */
public class LBC_CreacionTercerosBean extends LBC_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_CreacionTercerosBean.class);

    public static ArrayList getLBC_CreacionTercerosBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, Tipo_Terceros, Apellido_Paterno, Apellido_Materno, Primer_Nombre, Segundo_Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion, Sexo, Estado_Civil, Factura_CI_NIT, Nacionalidad, Fecha_Nacimiento, Categ_Activ_Eco_Ocu_Ppal, Activ_Eco_Ocu_Ppal, Tipo_Trabajador, Telefono_Fijo_1 FROM CREACION_TERCEROS_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_CreacionTercerosBean LBCCreacionTercerosBean = new LBC_CreacionTercerosBean();

                LBCCreacionTercerosBean.setTipoTerceros(rs.getString("Tipo_Terceros"));
                LBCCreacionTercerosBean.setApellidoPaterno(rs.getString("Apellido_Paterno"));
                LBCCreacionTercerosBean.setApellidoMaterno(rs.getString("Apellido_Materno"));
                LBCCreacionTercerosBean.setPrimerNombre(rs.getString("Primer_Nombre"));
                LBCCreacionTercerosBean.setSegundoNombre(rs.getString("Segundo_Nombre"));
                LBCCreacionTercerosBean.setTipoDocumentoIdentificacion(rs.getString("Tipo_Doc_Identificacion"));
                LBCCreacionTercerosBean.setNumeroDocumentoIdentificacion(rs.getString("Num_Doc_Identificacion"));
                LBCCreacionTercerosBean.setSexo(rs.getString("Sexo"));
                LBCCreacionTercerosBean.setEstadoCivil(rs.getString("Estado_Civil"));
                LBCCreacionTercerosBean.setPrefiereFacturaCI_NIT(rs.getString("Factura_CI_NIT"));
                LBCCreacionTercerosBean.setNacionalidad(rs.getString("Nacionalidad"));
                LBCCreacionTercerosBean.setFechaNacimiento(rs.getString("Fecha_Nacimiento"));
                LBCCreacionTercerosBean.setCategoriaActividadEconomicaOcupacionPrincipal(rs.getString("Categ_Activ_Eco_Ocu_Ppal"));
                LBCCreacionTercerosBean.setActividadEconomicaOcupacionPrincipal(rs.getString("Activ_Eco_Ocu_Ppal"));
                LBCCreacionTercerosBean.setTipoTrabajador(rs.getString("Tipo_Trabajador"));
                LBCCreacionTercerosBean.setTelefonoFijo1(rs.getString("Telefono_Fijo_1"));


                emision.add(LBCCreacionTercerosBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return emision;
    }
}
