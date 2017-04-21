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
 * Created by agil on 17/04/2017.
 */
public class Asesuisa_TercerosEditarBean extends Asesuisa_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCreacionRepetidaBean.class);

    public static ArrayList getAsesuisa_TercerosEditar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_TERCERO_EDITAR ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_TercerosEditarBean bean = new Asesuisa_TercerosEditarBean();

                bean.setAseguradoAp(rs.getString("ASEGURADO_AP"));
                bean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                bean.setPrimerNombre(rs.getString("TERCERO_NOMBRE_1"));
                bean.setSegundoNombre(rs.getString("TERCERO_NOMBRE_2"));
                bean.setPrimerApellido(rs.getString("TERCERO_APELLIDO_1"));
                bean.setSegundoApellido(rs.getString("TERCERO_APELLIDO_2"));
                bean.setPaisOrigen(rs.getString("PAIS_ORIGEN"));
                bean.setNacionalidad(rs.getString("NACIONALIDAD"));
                bean.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                bean.setNumeroDUI(rs.getString("DUI"));
                bean.setNumeroNIT(rs.getString("NIT"));
                bean.setTipoDocumentoIdentificacion(rs.getString("TIPO_DOC_ID"));
                bean.setNumeroDocumentoIdentificacion(rs.getString("NUM_DOC_ID"));
                bean.setNumeroUnicoBanco(rs.getString("NUM_UNICO_BANCO"));
                bean.setNumeroNUP(rs.getString("NUP"));
                bean.setCorreoElectronicoPrincipal(rs.getString("EMAIL_PRINCIPAL"));
                bean.setCorreoElectronicoOpcional(rs.getString("EMAIL_OPCIONAL"));
                bean.setUsuario(rs.getString("USUARIO"));
                bean.setIdFacebook(rs.getString("ID_FACEBOOK"));
                bean.setIdTwitter(rs.getString("ID_TWITTER"));
                bean.setIdLinkedin(rs.getString("ID_LINKEDIN"));
                bean.setGenero(rs.getString("GENERO"));
                bean.setEstadoCivil(rs.getString("EDO_CIVIL"));
                bean.setNumeroHijos(rs.getString("NUM_HIJOS"));
                bean.setNivelEstudio(rs.getString("NIVEL_ESTUDIO"));
                bean.setOcupacion(rs.getString("OCUPACION"));
                bean.setTlfDomicilio(rs.getString("TELEFONO_DOMICILIO"));
                bean.setNumeroTelefonoTrabajo(rs.getString("TELEFONO_TRABAJO"));
                bean.setNumeroCelular(rs.getString("CELULAR"));
                bean.setNumeroRegistroContribuyente(rs.getString("NRC"));
                bean.setCategoriaContribuyente(rs.getString("CATEG_CONTRIBUYENTE"));
                bean.setActividadEconomica(rs.getString("GIRO_ACTIV_ECONOMICA"));
                bean.setNivelSalarial(rs.getString("NIVEL_SALARIAL"));
                bean.setTipoEmpresa(rs.getString("TIPO_EMPRESA"));
                bean.setCategoriaEmpresa(rs.getString("CATEG_EMPRESA"));
                bean.setExentoIVA(rs.getString("EXENTO_IVA"));
                bean.setPredeterminedName(rs.getString("PREDETERMINED_NAME"));
                bean.setChequeoUnicidad(rs.getString("CHEQUEO_UNICIDAD"));
                bean.setIdioma(rs.getString("IDIOMA"));
                bean.setIdiomaOmision(rs.getString("IDIOMA_OMISION"));
                bean.setLogin(rs.getString("LOGIN"));
                bean.setNumeroDocumentoIdentificacion2(rs.getString("NUM_DOC_ID_2"));
                bean.setNitBuscar(rs.getString("NIT_BUSCAR"));

                tercero.add(bean);
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
