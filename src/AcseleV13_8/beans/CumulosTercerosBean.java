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
 * Created by aazuaje on 17/08/2016.
 */
public class CumulosTercerosBean  implements Serializable {

    private final static Logger log = Logger.getLogger(CumulosTercerosBean.class);

    private String tipoTerceros;
    //private String rol;
    private String tipoDocIdentificacion;
    private String pasaporte;
    private String numDocIdentificacion;
    private String primerNombre;
    private String telefonoOficina;
    private String primerApellido;
    private String moneda;
    private String moneda2;

    public String getTipoTerceros() {return tipoTerceros;}
    public void setTipoTerceros(String tipoTerceros) {this.tipoTerceros = tipoTerceros;}

    /*public String getRol() {return rol;}
    public void setRol(String rol) {this.rol = rol;}*/

    public String getTipoDocIdentificacion() {return tipoDocIdentificacion;}
    public void setTipoDocIdentificacion(String tipoDocIdentificacion) {this.tipoDocIdentificacion = tipoDocIdentificacion;}

    public String getPasaporte() {return pasaporte;}
    public void setPasaporte(String pasaporte) {this.pasaporte = pasaporte;}

    public String getNumDocIdentificacion() {return numDocIdentificacion;}
    public void setNumDocIdentificacion(String numDocIdentificacion) {this.numDocIdentificacion = numDocIdentificacion;}

    public String getPrimerNombre() {return primerNombre;}
    public void setPrimerNombre(String primerNombre) {this.primerNombre = primerNombre;}

    public String getTelefonoOficina() {return telefonoOficina;}
    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public String getPrimerApellido() {return primerApellido;}
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMoneda2() {return moneda2;}
    public void setMoneda2(String moneda2) {
        this.moneda2 = moneda2;
    }

    public static ArrayList getCumulosTerceros() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cumulosTerceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Tipo_Terceros,Tipo_Doc_Identificacion, Pasaporte, Num_Doc_Identificacion,Primer_Nombre,Telefono_Oficina,Primer_Apellido, Moneda, Moneda2 from CUMULOS_TERCEROS ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CumulosTercerosBean cumulosTercerosBean = new CumulosTercerosBean();

                cumulosTercerosBean.setTipoTerceros(rs.getString("TIPO_TERCEROS"));
                //cumulosTercerosBean.setRol(rs.getString("ROL"));
                cumulosTercerosBean.setTipoDocIdentificacion(rs.getString("TIPO_DOC_IDENTIFICACION"));
                cumulosTercerosBean.setPasaporte(rs.getString("PASAPORTE"));
                cumulosTercerosBean.setNumDocIdentificacion(rs.getString("NUM_DOC_IDENTIFICACION"));
                cumulosTercerosBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                cumulosTercerosBean.setTelefonoOficina(rs.getString("TELEFONO_OFICINA"));
                cumulosTercerosBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                cumulosTercerosBean.setMoneda(rs.getString("MONEDA"));
                cumulosTercerosBean.setMoneda2(rs.getString("MONEDA2"));

                cumulosTerceros.add(cumulosTercerosBean);

        }


    }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return cumulosTerceros;

    }

}
