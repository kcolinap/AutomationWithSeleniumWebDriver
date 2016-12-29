package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 29/12/2016.
 */
public class INTER_EditarSiniestroBean implements Serializable{

    private final static Logger log = Logger.getLogger(INTER_EditarSiniestroBean.class);

    private String ordenarPor;
    private String numeroPoliza;
    private String numeroSiniestro;
    private String fechaOcurrenciaSiniestro;
    private String producto;
    private String numeroCaso;
    private String fechaNotificacion;
    private String fechaRecepcionReclamo;
    private String fechaOcurrencia;
    private String lugarOcurrenciaSiniestro;
    private String horaOcurrencia;
    private String observacionesSiniestro;
    private String nombresApellidos;
    private String direccion;
    private String telefonos;
    private String correoElectronico;
    private String envioComunicacionesSiniestro;
    private String correoElectronicoSiniestro;
    private String sexo;

    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getNumeroPoliza() {return numeroPoliza;}
    public void setNumeroPoliza(String numeroPoliza) {this.numeroPoliza = numeroPoliza;}

    public String getNumeroSiniestro() {return numeroSiniestro;}
    public void setNumeroSiniestro(String numeroSiniestro) {this.numeroSiniestro = numeroSiniestro;}

    public String getFechaOcurrenciaSiniestro() {return fechaOcurrenciaSiniestro;}
    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getNumeroCaso() {return numeroCaso;}
    public void setNumeroCaso(String numeroCaso) {this.numeroCaso = numeroCaso;}

    public String getFechaNotificacion() {return fechaNotificacion;}
    public void setFechaNotificacion(String fechaNotificacion) {this.fechaNotificacion = fechaNotificacion;}

    public String getFechaRecepcionReclamo() {return fechaRecepcionReclamo;}
    public void setFechaRecepcionReclamo(String fechaRecepcionReclamo) {this.fechaRecepcionReclamo = fechaRecepcionReclamo;}

    public String getFechaOcurrencia() {return fechaOcurrencia;}
    public void setFechaOcurrencia(String fechaOcurrencia) {this.fechaOcurrencia = fechaOcurrencia;}

    public String getLugarOcurrenciaSiniestro() {return lugarOcurrenciaSiniestro;}
    public void setLugarOcurrenciaSiniestro(String lugarOcurrenciaSiniestro) {this.lugarOcurrenciaSiniestro = lugarOcurrenciaSiniestro;}

    public String getHoraOcurrencia() {return horaOcurrencia;}
    public void setHoraOcurrencia(String horaOcurrencia) {this.horaOcurrencia = horaOcurrencia;}

    public String getObservacionesSiniestro() {return observacionesSiniestro;}
    public void setObservacionesSiniestro(String observacionesSiniestro) {this.observacionesSiniestro = observacionesSiniestro;}


    public String getNombresApellidos() {return nombresApellidos;}
    public void setNombresApellidos(String nombresApellidos) {this.nombresApellidos = nombresApellidos;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getTelefonos() {return telefonos;}
    public void setTelefonos(String telefonos) {this.telefonos = telefonos;}

    public String getCorreoElectronico() {return correoElectronico;}
    public void setCorreoElectronico(String correoElectronico) {this.correoElectronico = correoElectronico;}

    public String getEnvioComunicacionesSiniestro() {return envioComunicacionesSiniestro;}
    public void setEnvioComunicacionesSiniestro(String envioComunicacionesSiniestro) {this.envioComunicacionesSiniestro = envioComunicacionesSiniestro;}

    public String getCorreoElectronicoSiniestro() {return correoElectronicoSiniestro;}
    public void setCorreoElectronicoSiniestro(String correoElectronicoSiniestro) {this.correoElectronicoSiniestro = correoElectronicoSiniestro;}

    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}

    public static ArrayList getINTER_EditarSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interEditarSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from INTER_EDITAR_SINIESTRO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_EditarSiniestroBean inter_editarSiniestroBean = new INTER_EditarSiniestroBean();

                inter_editarSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_editarSiniestroBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_editarSiniestroBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_editarSiniestroBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                inter_editarSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                inter_editarSiniestroBean.setNumeroCaso(rs.getString("NUMERO_CASO"));
                inter_editarSiniestroBean.setFechaNotificacion(rs.getString("FECHA_NOTIFICACION"));
                inter_editarSiniestroBean.setFechaRecepcionReclamo(rs.getString("FECHA_RECEPCION_RECLAMO"));
                inter_editarSiniestroBean.setFechaOcurrencia(rs.getString("FECHA_OCURRENCIA"));
                inter_editarSiniestroBean.setLugarOcurrenciaSiniestro(rs.getString("LUGAR_OCURRENCIA_SINIESTRO"));
                inter_editarSiniestroBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                inter_editarSiniestroBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                inter_editarSiniestroBean.setNombresApellidos(rs.getString("NOMBRES_APELLIDOS"));
                inter_editarSiniestroBean.setDireccion(rs.getString("DIRECCION"));
                inter_editarSiniestroBean.setTelefonos(rs.getString("TELEFONOS"));
                inter_editarSiniestroBean.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                inter_editarSiniestroBean.setEnvioComunicacionesSiniestro(rs.getString("ENVIO_COMUNICACIONES_SINIESTRO"));
                inter_editarSiniestroBean.setCorreoElectronicoSiniestro(rs.getString("CORREO_ELECTRONICO_SINIESTRO"));
                inter_editarSiniestroBean.setSexo(rs.getString("SEXO"));

                interEditarSiniestro.add(inter_editarSiniestroBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return interEditarSiniestro;

    }











}
