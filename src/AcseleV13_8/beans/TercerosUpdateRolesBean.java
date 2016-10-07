package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 23/06/2016.
 */
public class TercerosUpdateRolesBean implements Serializable {

        private String tipoTercero;
        private String tipoDocId;
        private String cedula;
        private String nombre;
        private String apellido;
        private String genero;
        private String fechaNac;
        private String audFechaDesde;
        private String audFechaHasta;

        public String getTipoTercero() {
            return tipoTercero;
        }
        public void setTipoTercero(String tipoTercero) {
            this.tipoTercero = tipoTercero;
        }

        public String getTipoDocId() {
            return tipoDocId;
        }
        public void setTipoDocId(String tipoDocId) {
            this.tipoDocId = tipoDocId;
        }

        public String getCedula() {
            return cedula;
        }
        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getGenero() {
            return genero;
        }
        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getFechaNac() {
            return fechaNac;
        }
        public void setFechaNac(String fechaNac) {
            this.fechaNac = fechaNac;
        }

        public String getAudFechaDesde() {
            return audFechaDesde;
        }
        public void setAudFechaDesde(String audFechaDesde) {
            this.audFechaDesde = audFechaDesde;
        }

        public String getAudFechaHasta() {
            return audFechaHasta;
        }
        public void setAudFechaHasta(String audFechaHasta) {
            this.audFechaHasta = audFechaHasta;
        }

    public static ArrayList getTercerosUpdateRoles() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, GENERO, FECHA_NAC, AUD_FECHA_DESDE, AUD_FECHA_HASTA FROM TERCEROS_UPDATE_ROL ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosUpdateRolesBean tercerosUpdateRolesBean = new TercerosUpdateRolesBean();
                tercerosUpdateRolesBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                tercerosUpdateRolesBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                tercerosUpdateRolesBean.setCedula(rs.getString("CEDULA"));
                tercerosUpdateRolesBean.setNombre(rs.getString("NOMBRE"));
                tercerosUpdateRolesBean.setApellido(rs.getString("APELLIDO"));
                tercerosUpdateRolesBean.setGenero(rs.getString("GENERO"));
                tercerosUpdateRolesBean.setFechaNac(rs.getString("FECHA_NAC"));
                tercerosUpdateRolesBean.setAudFechaDesde(rs.getString("AUD_FECHA_DESDE"));
                tercerosUpdateRolesBean.setAudFechaHasta(rs.getString("AUD_FECHA_HASTA"));
                terceros.add(tercerosUpdateRolesBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return terceros;
    }

}
