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
 * Created by agil on 09/06/2016.
 */
public class TercerosDireccionesBean implements Serializable {

    private final static Logger log = Logger.getLogger(TercerosDireccionesBean.class);

    //NUEVO_TIPO_DIRECCION, NUEVO_TIPO_VIA, NUEVO_NUM_NOMBRE_VIA_PPAL, NUEVO_PREFIJO_BIS_VIA_PPAL,
    // NUEVO_LETRA_NUM_PREF_VIA_PPAL, NUEVO_CUADRANTE_VIA_PPAL, NUEVO_NUM_VIA_GENERADORA, NUEVO_PAIS,
    // NUEVO_DEPARTAMENTO, NUEVO_CIUDAD
    private String nuevoTipoDireccion;
    private String tipoTercero;
    private String tipoDocId;
    private String numCedula;
    private String nombre;
    private String apellido;
    private String tipoDireccion;
    private String tipoVia;
    private String numNomViaPpal;
    private String prefBisViaPpal;
    private String letraNumPrefViaPpal;
    private String cuadranteViaPpal;
    private String numViaGeneradora;
    private String pais;
    private String departamento;
    private String ciudad;
    private String nuevoTipoVia;
    private String nuevoNumNomViaPpal;
    private String nuevoPrefBisViaPpal;
    private String nuevoLetraNumPrefViaPpal;
    private String nuevoCuadranteViaPpal;
    private String nuevoNumViaGeneradora;
    private String nuevoPais;
    private String nuevoDepartamento;
    private String nuevoCiudad;

    public String getTipoTercero(){
        return tipoTercero;
    }
    public void setTipoTercero(String tipoTercero){
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocId() {
        return tipoDocId;
    }
    public void setTipoDocId(String tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public String getNumCedula() {
        return numCedula;
    }
    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getTipoDireccion(){
        return tipoDireccion;
    }
    public void setTipoDireccion(String tipoDireccion){
        this.tipoDireccion= tipoDireccion;
    }

    public String getTipoVia(){
        return  tipoVia;
    }
    public void setTipoVia(String tipoVia){
        this.tipoVia = tipoVia;
    }

    public String getNumNomViaPpal(){
        return numNomViaPpal;
    }
    public void setNumNomViaPpal(String numNomViaPpal){
        this.numNomViaPpal = numNomViaPpal;
    }

    public String getPrefBisViaPpal(){
        return prefBisViaPpal;
    }
    public void setPrefBisViaPpal(String prefBisViaPpal){
        this.prefBisViaPpal = prefBisViaPpal;
    }

    public String getLetraNumPrefViaPpal(){
        return letraNumPrefViaPpal;
    }
    public void setLetraNumPrefViaPpal(String letraNumPrefViaPpal){
        this.letraNumPrefViaPpal = letraNumPrefViaPpal;
    }

    public String getCuadranteViaPpal(){
        return cuadranteViaPpal;
    }
    public void setCuadranteViaPpal(String cuadranteViaPpal){
        this.cuadranteViaPpal = cuadranteViaPpal;
    }

    public String getNumViaGeneradora(){
        return numViaGeneradora;
    }
    public void setNumViaGeneradora(String numViaGeneradora){
        this.numViaGeneradora = numViaGeneradora;
    }

    public String getPais(){
        return pais;
    }
    public void setPais(String pais){
        this.pais = pais;
    }

    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public String getCiudad(){
        return ciudad;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getNuevoTipoDireccion(){
        return nuevoTipoDireccion;
    }
    public void setNuevoTipoDireccion(String nuevoTipoDireccion){
        this.nuevoTipoDireccion= nuevoTipoDireccion;
    }

    public String getNuevoTipoVia(){
        return  nuevoTipoVia;
    }
    public void setNuevoTipoVia(String nuevoTipoVia){
        this.nuevoTipoVia = nuevoTipoVia;
    }

    public String getNuevoNumNomViaPpal(){
        return nuevoNumNomViaPpal;
    }
    public void setNuevoNumNomViaPpal(String nuevoNumNomViaPpal){
        this.nuevoNumNomViaPpal = nuevoNumNomViaPpal;
    }

    public String getNuevoPrefBisViaPpal(){
        return nuevoPrefBisViaPpal;
    }
    public void setNuevoPrefBisViaPpal(String nuevoPrefBisViaPpal){
        this.nuevoPrefBisViaPpal = nuevoPrefBisViaPpal;
    }

    public String getNuevoLetraNumPrefViaPpal(){
        return nuevoLetraNumPrefViaPpal;
    }
    public void setNuevoLetraNumPrefViaPpal(String nuevoLetraNumPrefViaPpal){
        this.nuevoLetraNumPrefViaPpal = nuevoLetraNumPrefViaPpal;
    }

    public String getNuevoCuadranteViaPpal(){
        return nuevoCuadranteViaPpal;
    }
    public void setNuevoCuadranteViaPpal(String nuevoCuadranteViaPpal){
        this.nuevoCuadranteViaPpal = nuevoCuadranteViaPpal;
    }

    public String getNuevoNumViaGeneradora(){
        return nuevoNumViaGeneradora;
    }
    public void setNuevoNumViaGeneradora(String nuevoNumViaGeneradora){
        this.nuevoNumViaGeneradora = nuevoNumViaGeneradora;
    }

    public String getNuevoPais(){
        return nuevoPais;
    }
    public void setNuevoPais(String nuevoPais){
        this.nuevoPais = nuevoPais;
    }

    public String getNuevoDepartamento(){
        return nuevoDepartamento;
    }
    public void setNuevoDepartamento(String nuevoDepartamento){
        this.nuevoDepartamento = nuevoDepartamento;
    }

    public String getNuevoCiudad(){
        return nuevoCiudad;
    }
    public void setNuevoCiudad(String nuevoCiudad){
        this.ciudad = nuevoCiudad;
    }

    public static ArrayList getTercerodDirecciones() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList direcciones = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM TERCEROS_DIRECCIONES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosDireccionesBean tercerosDireccionesBean = new TercerosDireccionesBean();
                tercerosDireccionesBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                tercerosDireccionesBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                tercerosDireccionesBean.setNumCedula(rs.getString("CEDULA"));
                tercerosDireccionesBean.setNombre(rs.getString("NOMBRE"));
                tercerosDireccionesBean.setApellido(rs.getString("APELLIDO"));
                tercerosDireccionesBean.setTipoDireccion(rs.getString("TIPO_DIRECCION"));
                tercerosDireccionesBean.setTipoVia(rs.getString("TIPO_VIA"));
                tercerosDireccionesBean.setNumNomViaPpal(rs.getString("NUM_NOMBRE_VIA_PPAL"));
                tercerosDireccionesBean.setPrefBisViaPpal(rs.getString("PREFIJO_BIS_VIA_PPAL"));
                tercerosDireccionesBean.setLetraNumPrefViaPpal(rs.getString("LETRA_NUM_PREF_VIA_PPAL"));
                tercerosDireccionesBean.setCuadranteViaPpal(rs.getString("CUADRANTE_VIA_PPAL"));
                tercerosDireccionesBean.setNumViaGeneradora(rs.getString("NUM_VIA_GENERADORA"));
                tercerosDireccionesBean.setPais(rs.getString("PAIS"));
                tercerosDireccionesBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                tercerosDireccionesBean.setCiudad(rs.getString("CIUDAD"));
                tercerosDireccionesBean.setNuevoTipoDireccion(rs.getString("NUEVO_TIPO_DIRECCION"));
                tercerosDireccionesBean.setNuevoTipoVia(rs.getString("NUEVO_TIPO_VIA"));
                tercerosDireccionesBean.setNuevoNumNomViaPpal(rs.getString("NUEVO_NUM_NOMBRE_VIA_PPAL"));
                tercerosDireccionesBean.setNuevoPrefBisViaPpal(rs.getString("NUEVO_PREFIJO_BIS_VIA_PPAL"));
                tercerosDireccionesBean.setNuevoLetraNumPrefViaPpal(rs.getString("NUEVO_LETRA_NUM_PREF_VIA_PPAL"));
                tercerosDireccionesBean.setNuevoCuadranteViaPpal(rs.getString("NUEVO_CUADRANTE_VIA_PPAL"));
                tercerosDireccionesBean.setNuevoNumViaGeneradora(rs.getString("NUEVO_NUM_VIA_GENERADORA"));
                tercerosDireccionesBean.setNuevoPais(rs.getString("NUEVO_PAIS"));
                tercerosDireccionesBean.setNuevoDepartamento(rs.getString("NUEVO_DEPARTAMENTO"));
                tercerosDireccionesBean.setNuevoCiudad(rs.getString("NUEVO_CIUDAD"));
                direcciones.add(tercerosDireccionesBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return direcciones;
    }
}
