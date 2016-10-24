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
 * Created by aazuaje on 24/10/2016.
 */
public class LBC_TercerosUpdateRolBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_TercerosUpdateRolBean.class);


        private String tipoTerceros;
        private String apellido;
        private String nombre;
        private String tipoDocIdentificacion;
        private String numDocIdentificacion;
        private String genero;
        private String fechaNac;
        private String audFechaDesde;
        private String audFechaHasta;

        public String getTipoTerceros() {return tipoTerceros;}
        public void setTipoTerceros(String tipoTerceros) {this.tipoTerceros = tipoTerceros;}

        public String getApellido() {return apellido;}
        public void setApellido(String apellido) {this.apellido = apellido;}

        public String getNombre() {return nombre;}
        public void setNombre(String nombre) {this.nombre = nombre;}

        public String getTipoDocIdentificacion() {return tipoDocIdentificacion;}
        public void setTipoDocIdentificacion(String tipoDocIdentificacion) {this.tipoDocIdentificacion = tipoDocIdentificacion;}

        public String getNumDocIdentificacion() {return numDocIdentificacion;}
        public void setNumDocIdentificacion(String numDocIdentificacion) {this.numDocIdentificacion = numDocIdentificacion;}


        public String getGenero() {return genero;}
        public void setGenero(String genero) {this.genero = genero;}

        public String getFechaNac() {return fechaNac;}
        public void setFechaNac(String fechaNac) {this.fechaNac = fechaNac;}

        public String getAudFechaDesde() {return audFechaDesde;}
        public void setAudFechaDesde(String audFechaDesde) {this.audFechaDesde = audFechaDesde;}

        public String getAudFechaHasta() {return audFechaHasta;}
        public void setAudFechaHasta(String audFechaHasta) {this.audFechaHasta = audFechaHasta;}

        public static ArrayList getLbcTercerosUpdateRol()  throws SQLException {

            Connection conn = null;
            Statement stmt;
            ResultSet rs;
            ArrayList tercerosRolLBC = new ArrayList();

            StringBuilder queryLoad = new StringBuilder();
            queryLoad.append("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion,Num_Doc_Identificacion, Genero, Fecha_Nac,aud_Fecha_Desde,aud_Fecha_Hasta FROM TERCEROS_MOD_ROLES ORDER BY PRUEBA ASC");

            try {
                conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(queryLoad.toString());

                while (rs.next()) {
                    LBC_TercerosUpdateRolBean lbc_tercerosUpdateRolBean = new LBC_TercerosUpdateRolBean();
                    lbc_tercerosUpdateRolBean.setTipoTerceros(rs.getString("TIPO_TERCEROS"));
                    lbc_tercerosUpdateRolBean.setApellido(rs.getString("APELLIDO"));
                    lbc_tercerosUpdateRolBean.setNombre(rs.getString("NOMBRE"));
                    lbc_tercerosUpdateRolBean.setTipoDocIdentificacion(rs.getString("TIPO_DOC_IDENTIFICACION"));
                    lbc_tercerosUpdateRolBean.setNumDocIdentificacion(rs.getString("NUM_DOC_IDENTIFICACION"));
                    lbc_tercerosUpdateRolBean.setGenero(rs.getString("GENERO"));
                    lbc_tercerosUpdateRolBean.setFechaNac(rs.getString("FECHA_NAC"));
                    lbc_tercerosUpdateRolBean.setAudFechaDesde(rs.getString("AUD_FECHA_DESDE"));
                    lbc_tercerosUpdateRolBean.setAudFechaHasta(rs.getString("AUD_FECHA_HASTA"));
                    tercerosRolLBC.add(lbc_tercerosUpdateRolBean);
                }
            }catch(SQLException e){
        log.error(e);
        }finally{
        if (conn != null) {
            conn.close();
        }
    }

    return tercerosRolLBC;

}

    }


