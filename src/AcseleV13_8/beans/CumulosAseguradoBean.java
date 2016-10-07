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
 * Created by aazuaje on 18/08/2016.
 */
public class CumulosAseguradoBean implements Serializable {

    private final static Logger log = Logger.getLogger(CumulosAseguradoBean.class);

    private String tipoTerceros;
    private String tipoDocIdentificacion;
    private String pasaporte;
    private String numDocIdentificacion;
    private String primerNombre;
    private String primerApellido;
    private String estadoCivil;
    private String email_1;

    public String getTipoTerceros() {return tipoTerceros;}
    public void setTipoTerceros(String tipoTerceros) {this.tipoTerceros = tipoTerceros;}

    public String getTipoDocIdentificacion() {return tipoDocIdentificacion;}
    public void setTipoDocIdentificacion(String tipoDocIdentificacion) {this.tipoDocIdentificacion = tipoDocIdentificacion;}

    public String getPasaporte() {return pasaporte;}
    public void setPasaporte(String pasaporte) {this.pasaporte = pasaporte;}

    public String getNumDocIdentificacion() {return numDocIdentificacion;}
    public void setNumDocIdentificacion(String numDocIdentificacion) {this.numDocIdentificacion = numDocIdentificacion;}

    public String getPrimerNombre() {return primerNombre;}
    public void setPrimerNombre(String primerNombre) {this.primerNombre = primerNombre;}

    public String getPrimerApellido() {return primerApellido;}
    public void setPrimerApellido(String primerApellido) {this.primerApellido = primerApellido;}

    public String getEstadoCivil() {return estadoCivil;}
    public void setEstadoCivil(String estadoCivil) {this.estadoCivil = estadoCivil;}

    public String getEmail_1() {return email_1;}
    public void setEmail_1(String email_1) {this.email_1 = email_1;}

    public static ArrayList getCumulosAsegurado() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cumulosAsegurado = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Tipo_Terceros,Tipo_Doc_Identificacion,Pasaporte,Num_Doc_Identificacion, Primer_Nombre, Primer_Apellido, Estado_Civil, Email_1 FROM CUMULOS_ASEGURADO ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CumulosAseguradoBean cumulosAseguradoBean = new CumulosAseguradoBean();

                cumulosAseguradoBean.setTipoTerceros(rs.getString("TIPO_TERCEROS"));
                cumulosAseguradoBean.setTipoDocIdentificacion(rs.getString("TIPO_DOC_IDENTIFICACION"));
                cumulosAseguradoBean.setPasaporte(rs.getString("PASAPORTE"));
                cumulosAseguradoBean.setNumDocIdentificacion(rs.getString("NUM_DOC_IDENTIFICACION"));
                cumulosAseguradoBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                cumulosAseguradoBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                cumulosAseguradoBean.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                cumulosAseguradoBean.setEmail_1(rs.getString("EMAIL_1"));

                cumulosAsegurado.add(cumulosAseguradoBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return cumulosAsegurado;

    }
}




