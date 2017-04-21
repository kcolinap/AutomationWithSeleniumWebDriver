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
 * Created by kcolina on 18/04/2017.
 */
public class Asesuisa_TercerosCambioTipoDocumentoBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCambioTipoDocumentoBean.class);

    private String tipoTercero;
    private String primerNombre;
    private String primerApellido;
    private String numeroDocumento;
    private String codigoIdentificador;
    private String tipoDocumento;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public static ArrayList getBean() throws SQLException{
        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosCambioTipoDoc = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM Asesuisa_terc_CambioTipoDoc ORDER BY prueba ASC");

        try{
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                Asesuisa_TercerosCambioTipoDocumentoBean bean = new Asesuisa_TercerosCambioTipoDocumentoBean();

                bean.setTipoTercero(rs.getString("TIPOTERCERO"));
                bean.setPrimerNombre(rs.getString("PRIMERNOMBRE"));
                bean.setPrimerApellido(rs.getString("PRIMERAPELLIDO"));
                bean.setNumeroDocumento(rs.getString("NUMERODOCUMENTO"));
                bean.setCodigoIdentificador(rs.getString("CODIGOIDENTIFICADOR"));
                bean.setTipoDocumento(rs.getString("TIPODOCUMENTO"));

                asesuisaTercerosCambioTipoDoc.add(bean);
            }
        }catch (SQLException e){
            log.error(e);
        }finally{
            if (conexion != null){
                conexion.close();
            }
        }

        return asesuisaTercerosCambioTipoDoc;
    }
}
