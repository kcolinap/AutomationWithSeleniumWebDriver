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
 * Created by agil on 17/11/2016.
 */
public class Inter_TercerosCrearBean extends Inter_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Inter_TercerosCrearBean.class);

    public static ArrayList getInter_TercerosCrear() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        //queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, NUM_DOC_ID, NUM_PASAPORTE, NUM_CARNET_EXTRAN, NUM_CARNET_AUTOMA_MIN_TRABAJO, NUM_PARTIDA_NAC, NUM_CARNET_ID_POLICIA, NUM_RUC_PERSONA_NATURAL, LIBRETA_MILITAR, NUM_CARNET_FUERZAS_ARMADAS, CARNET_DIPLOMATICO, INDICADOR_COLABORADOR, CODIGO_COLABORADOR_IS, APELLIDO_PATERNO, APELLIDO_MATERNO, NOMBRE_PRIMERO, NOMBRE_SEGUNDO, AUTORIZA_ENVIO_CORREO, AUTORIZA_ENVIO_SMS, AUTORIZA_ENVIO_LLAMADAS, AUTORIZA_COMERCIALIZA_DATOS, AUTORIZA_TRATAMIENTO_DATOS, AUTORIZA_ACCESO_DATOS, PROFESION, ACTIVIDAD_ECONOMICA, CODIGO_APF_PERTENECE, NACIONALIDAD, FECHA_NACIMIENTO, ESTADO_CIVIL, FECHA_MATRIMONIO, FECHA_FALLECIMIENTO, FUMADOR, SEXO, TELEFONO_CELULAR_1, TELEFONO_CELULAR_2, TELEFONO_CELULAR_3, CORREO_ELECTRONICO_1, CORREO_ELECTRONICO_2, CORREO_ELECTRONICO_3, FACEBOOK_ID, TWITTER_ID, SKYPE_ID, YAHOO_ID, INDICADOR_PEP, COMUNICACIONES_GENERALES, CENTRO_ASEGURADO_TRABAJO, ACTIVIDAD_ECONOMICA_OTRA, CARGO_DESEMPENA_ASEGURADO, ID_ORIGEN_TERCERO, USER_LOGIN, CODIGO_IDENTIFICADOR, CODIGO_INTERNO FROM CREACION_TERCEROS_INTER ORDER BY PRUEBA ASC");
        queryLoad.append("SELECT * FROM CREACION_TERCEROS_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Inter_TercerosCrearBean interTercerosCrearBean = new Inter_TercerosCrearBean();

                interTercerosCrearBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                interTercerosCrearBean.setNumeroDocumentoIdentidad(rs.getString("NUM_DOC_ID"));
                interTercerosCrearBean.setNumeroPasaporte(rs.getString("NUM_PASAPORTE"));
                interTercerosCrearBean.setNumeroCarnetExtranjeria(rs.getString("NUM_CARNET_EXTRAN"));
                interTercerosCrearBean.setNumeroCarnetAutomatizacionMinTrabajo(rs.getString("NUM_CARNET_AUTOMA_MIN_TRABAJO"));
                interTercerosCrearBean.setNumeroPartidaNacimiento(rs.getString("NUM_PARTIDA_NAC"));
                interTercerosCrearBean.setNumeroCarnetIdPolicia(rs.getString("NUM_CARNET_ID_POLICIA"));
                interTercerosCrearBean.setNumeroRucPersonaNatural(rs.getString("NUM_RUC_PERSONA_NATURAL"));
                interTercerosCrearBean.setLibretaMilitar(rs.getString("LIBRETA_MILITAR"));
                interTercerosCrearBean.setNumeroCarnetFuerzasArmadas(rs.getString("NUM_CARNET_FUERZAS_ARMADAS"));
                interTercerosCrearBean.setCarnetDiplomatico(rs.getString("CARNET_DIPLOMATICO"));
                interTercerosCrearBean.setIndicadorColaborador(rs.getString("INDICADOR_COLABORADOR"));
                interTercerosCrearBean.setCodigoColaboradorIS(rs.getString("CODIGO_COLABORADOR_IS"));
                interTercerosCrearBean.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                interTercerosCrearBean.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                interTercerosCrearBean.setNombrePrimero(rs.getString("NOMBRE_PRIMERO"));
                interTercerosCrearBean.setNombreSegundo(rs.getString("NOMBRE_SEGUNDO"));
                interTercerosCrearBean.setAutorizaEnvioCorreoElectronico(rs.getString("AUTORIZA_ENVIO_CORREO"));
                interTercerosCrearBean.setAutorizaEnvioSMS(rs.getString("AUTORIZA_ENVIO_SMS"));
                interTercerosCrearBean.setAutorizaEnvioLlamadas(rs.getString("AUTORIZA_ENVIO_LLAMADAS"));
                interTercerosCrearBean.setAutorizaComercializacionDatos(rs.getString("AUTORIZA_COMERCIALIZA_DATOS"));
                interTercerosCrearBean.setAutorizaTratamientoDatos(rs.getString("AUTORIZA_TRATAMIENTO_DATOS"));
                interTercerosCrearBean.setAutorizaAccesoDatos(rs.getString("AUTORIZA_ACCESO_DATOS"));
                interTercerosCrearBean.setProfesion(rs.getString("PROFESION"));
                interTercerosCrearBean.setActividadEconomica(rs.getString("ACTIVIDAD_ECONOMICA"));
                interTercerosCrearBean.setCodigoApfPertenece(rs.getString("CODIGO_APF_PERTENECE"));
                interTercerosCrearBean.setNacionalidad(rs.getString("NACIONALIDAD"));
                interTercerosCrearBean.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                interTercerosCrearBean.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                interTercerosCrearBean.setFechaMatrimonio(rs.getString("FECHA_MATRIMONIO"));
                interTercerosCrearBean.setFechaFallecimiento(rs.getString("FECHA_FALLECIMIENTO"));
                interTercerosCrearBean.setFumador(rs.getString("FUMADOR"));
                interTercerosCrearBean.setSexo(rs.getString("SEXO"));
                interTercerosCrearBean.setTelefonoCelular1(rs.getString("TELEFONO_CELULAR_1"));
                interTercerosCrearBean.setTelefonoCelular2(rs.getString("TELEFONO_CELULAR_2"));
                interTercerosCrearBean.setTelefonoCelular3(rs.getString("TELEFONO_CELULAR_3"));
                interTercerosCrearBean.setCorreoElectronico1(rs.getString("CORREO_ELECTRONICO_1"));
                interTercerosCrearBean.setCorreoElectronico2(rs.getString("CORREO_ELECTRONICO_2"));
                interTercerosCrearBean.setCorreoElectronico3(rs.getString("CORREO_ELECTRONICO_3"));
                interTercerosCrearBean.setFacebookId(rs.getString("FACEBOOK_ID"));
                interTercerosCrearBean.setTwitterId(rs.getString("TWITTER_ID"));
                interTercerosCrearBean.setSkypeId(rs.getString("SKYPE_ID"));
                interTercerosCrearBean.setYahooId(rs.getString("YAHOO_ID"));
                interTercerosCrearBean.setIndicadorPEP(rs.getString("INDICADOR_PEP"));
                interTercerosCrearBean.setComunicacionesGenerales(rs.getString("COMUNICACIONES_GENERALES"));
                interTercerosCrearBean.setCentroAseguradoTrabajo(rs.getString("CENTRO_ASEGURADO_TRABAJO"));
                interTercerosCrearBean.setActividadEconomicaOtra(rs.getString("ACTIVIDAD_ECONOMICA_OTRA"));
                interTercerosCrearBean.setCargoDesempenaAsegurado(rs.getString("CARGO_DESEMPENA_ASEGURADO"));
                interTercerosCrearBean.setIdOrigenTercero(rs.getString("ID_ORIGEN_TERCERO"));
                interTercerosCrearBean.setUserLogin(rs.getString("USER_LOGIN"));
                interTercerosCrearBean.setCodigoIdentificador(rs.getString("CODIGO_IDENTIFICADOR"));
                interTercerosCrearBean.setCodigoInterno(rs.getString("CODIGO_INTERNO"));

                tercero.add(interTercerosCrearBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tercero;
    }
}
