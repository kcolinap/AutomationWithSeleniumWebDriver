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
 * Created by agil on 26/01/2017.
 */
public class Inter_TercerosDocumentosBean extends Inter_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Inter_TercerosDocumentosBean.class);

    public static ArrayList getInter_TercerosDocumentos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList documentos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM INTER_TERCEROS_DOCUMENTOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Inter_TercerosDocumentosBean interTercerosDocumentosBean = new Inter_TercerosDocumentosBean();

                interTercerosDocumentosBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                interTercerosDocumentosBean.setNumeroDocumentoIdentidad(rs.getString("NUM_DOC_ID"));
                interTercerosDocumentosBean.setNumeroPasaporte(rs.getString("NUM_PASAPORTE"));
                interTercerosDocumentosBean.setNumeroCarnetExtranjeria(rs.getString("NUM_CARNET_EXTRAN"));
                interTercerosDocumentosBean.setNumeroCarnetAutomatizacionMinTrabajo(rs.getString("NUM_CARNET_AUTOMA_MIN_TRABAJO"));
                interTercerosDocumentosBean.setNumeroPartidaNacimiento(rs.getString("NUM_PARTIDA_NAC"));
                interTercerosDocumentosBean.setNumeroCarnetIdPolicia(rs.getString("NUM_CARNET_ID_POLICIA"));
                interTercerosDocumentosBean.setNumeroRucPersonaNatural(rs.getString("NUM_RUC_PERSONA_NATURAL"));
                interTercerosDocumentosBean.setLibretaMilitar(rs.getString("LIBRETA_MILITAR"));
                interTercerosDocumentosBean.setNumeroCarnetFuerzasArmadas(rs.getString("NUM_CARNET_FUERZAS_ARMADAS"));
                interTercerosDocumentosBean.setCarnetDiplomatico(rs.getString("CARNET_DIPLOMATICO"));
                interTercerosDocumentosBean.setIndicadorColaborador(rs.getString("INDICADOR_COLABORADOR"));
                interTercerosDocumentosBean.setCodigoColaboradorIS(rs.getString("CODIGO_COLABORADOR_IS"));
                interTercerosDocumentosBean.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                interTercerosDocumentosBean.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                interTercerosDocumentosBean.setNombrePrimero(rs.getString("NOMBRE_PRIMERO"));
                interTercerosDocumentosBean.setNombreSegundo(rs.getString("NOMBRE_SEGUNDO"));
                interTercerosDocumentosBean.setAutorizaEnvioCorreoElectronico(rs.getString("AUTORIZA_ENVIO_CORREO"));
                interTercerosDocumentosBean.setAutorizaEnvioSMS(rs.getString("AUTORIZA_ENVIO_SMS"));
                interTercerosDocumentosBean.setAutorizaEnvioLlamadas(rs.getString("AUTORIZA_ENVIO_LLAMADAS"));
                interTercerosDocumentosBean.setAutorizaComercializacionDatos(rs.getString("AUTORIZA_COMERCIALIZA_DATOS"));
                interTercerosDocumentosBean.setAutorizaTratamientoDatos(rs.getString("AUTORIZA_TRATAMIENTO_DATOS"));
                interTercerosDocumentosBean.setAutorizaAccesoDatos(rs.getString("AUTORIZA_ACCESO_DATOS"));
                interTercerosDocumentosBean.setProfesion(rs.getString("PROFESION"));
                interTercerosDocumentosBean.setActividadEconomica(rs.getString("ACTIVIDAD_ECONOMICA"));
                interTercerosDocumentosBean.setCodigoApfPertenece(rs.getString("CODIGO_APF_PERTENECE"));
                interTercerosDocumentosBean.setNacionalidad(rs.getString("NACIONALIDAD"));
                interTercerosDocumentosBean.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                interTercerosDocumentosBean.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                interTercerosDocumentosBean.setFechaMatrimonio(rs.getString("FECHA_MATRIMONIO"));
                interTercerosDocumentosBean.setFechaFallecimiento(rs.getString("FECHA_FALLECIMIENTO"));
                interTercerosDocumentosBean.setFumador(rs.getString("FUMADOR"));
                interTercerosDocumentosBean.setSexo(rs.getString("SEXO"));
                interTercerosDocumentosBean.setTelefonoCelular1(rs.getString("TELEFONO_CELULAR_1"));
                interTercerosDocumentosBean.setTelefonoCelular2(rs.getString("TELEFONO_CELULAR_2"));
                interTercerosDocumentosBean.setTelefonoCelular3(rs.getString("TELEFONO_CELULAR_3"));
                interTercerosDocumentosBean.setCorreoElectronico1(rs.getString("CORREO_ELECTRONICO_1"));
                interTercerosDocumentosBean.setCorreoElectronico2(rs.getString("CORREO_ELECTRONICO_2"));
                interTercerosDocumentosBean.setCorreoElectronico3(rs.getString("CORREO_ELECTRONICO_3"));
                interTercerosDocumentosBean.setFacebookId(rs.getString("FACEBOOK_ID"));
                interTercerosDocumentosBean.setTwitterId(rs.getString("TWITTER_ID"));
                interTercerosDocumentosBean.setSkypeId(rs.getString("SKYPE_ID"));
                interTercerosDocumentosBean.setYahooId(rs.getString("YAHOO_ID"));
                interTercerosDocumentosBean.setIndicadorPEP(rs.getString("INDICADOR_PEP"));
                interTercerosDocumentosBean.setComunicacionesGenerales(rs.getString("COMUNICACIONES_GENERALES"));
                interTercerosDocumentosBean.setCentroAseguradoTrabajo(rs.getString("CENTRO_ASEGURADO_TRABAJO"));
                interTercerosDocumentosBean.setActividadEconomicaOtra(rs.getString("ACTIVIDAD_ECONOMICA_OTRA"));
                interTercerosDocumentosBean.setCargoDesempenaAsegurado(rs.getString("CARGO_DESEMPENA_ASEGURADO"));
                interTercerosDocumentosBean.setIdOrigenTercero(rs.getString("ID_ORIGEN_TERCERO"));
                interTercerosDocumentosBean.setCodigoIdentificador(rs.getString("CODIGO_IDENTIFICADOR"));
                interTercerosDocumentosBean.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
                interTercerosDocumentosBean.setUserLogin(rs.getString("USER_LOGIN"));
                interTercerosDocumentosBean.setDescripcion(rs.getString("DESCRIPCION"));
                interTercerosDocumentosBean.setTipoArchivoAdjuntar(rs.getString("TIPO_ARCHIVO_ADJUNTAR"));
                interTercerosDocumentosBean.setComentarioArchivoAdjuntado(rs.getString("COMENTARIO_ARCHIVO_ADJ"));

                documentos.add(interTercerosDocumentosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return documentos;
    }
}
