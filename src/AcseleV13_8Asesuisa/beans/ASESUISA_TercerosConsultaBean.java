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
 * Created by kcolina on 21/02/2017.
 */
public class ASESUISA_TercerosConsultaBean extends ASESUISA_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(ASESUISA_TercerosConsultaBean.class);

    public static ArrayList getTecerosConsultaBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosConsulta = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM asesuisa_terceros_consulta ORDER BY prueba ASC");

        try{
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){

                ASESUISA_TercerosConsultaBean asesuisaTercerosConsultaBean = new ASESUISA_TercerosConsultaBean();

                asesuisaTercerosConsultaBean.setTipoTercero(rs.getString("tipoTercero"));
                asesuisaTercerosConsultaBean.setAseguradoAp(rs.getString("aseguradoAp"));
                asesuisaTercerosConsultaBean.setPrimerNombre(rs.getString("primerNombre"));
                asesuisaTercerosConsultaBean.setSegundoNombre(rs.getString("segundoNombre"));
                asesuisaTercerosConsultaBean.setPrimerApellido(rs.getString("primerApellido"));
                asesuisaTercerosConsultaBean.setSegundoApellido(rs.getString("segundoApellido"));
                asesuisaTercerosConsultaBean.setNacionalidad(rs.getString("nacionalidad"));
                asesuisaTercerosConsultaBean.setPaisOrigen(rs.getString("paisOrigen"));
                asesuisaTercerosConsultaBean.setEdadPersonaNatural(rs.getString("edadPersonaNatural"));
                asesuisaTercerosConsultaBean.setFechaNacimiento(rs.getString("fechaNacimiento"));
                asesuisaTercerosConsultaBean.setNumeroDUI(rs.getString("numeroDUI"));
                asesuisaTercerosConsultaBean.setNumeroNIT(rs.getString("numeroNIT"));
                asesuisaTercerosConsultaBean.setNumeroDocumento(rs.getString("numeroDocumento"));
                asesuisaTercerosConsultaBean.setNumeroNUP(rs.getString("numeroNUP"));
                asesuisaTercerosConsultaBean.setTipoDocumentoIdentificacion(rs.getString("tipoDocumentoIdentificacion"));
                asesuisaTercerosConsultaBean.setCorreoElectronicoPrincipal(rs.getString("correoElectronicoPrincipal"));
                asesuisaTercerosConsultaBean.setCorreoElectronicoOpcional(rs.getString("correoElectronicoOpcional"));
                asesuisaTercerosConsultaBean.setUsuario(rs.getString("usuario"));
                asesuisaTercerosConsultaBean.setIdFacebook(rs.getString("idFacebook"));
                asesuisaTercerosConsultaBean.setIdTwitter(rs.getString("idTwitter"));
                asesuisaTercerosConsultaBean.setIdLinkedin(rs.getString("idLinkedin"));
                asesuisaTercerosConsultaBean.setEstadoCivil(rs.getString("estadoCivil"));
                asesuisaTercerosConsultaBean.setGenero(rs.getString("genero"));
                asesuisaTercerosConsultaBean.setNivelEstudio(rs.getString("nivelEstudio"));
                asesuisaTercerosConsultaBean.setNumeroHijos(rs.getString("numeroHijos"));
                asesuisaTercerosConsultaBean.setTlfDomicilio(rs.getString("tlfDomicilio"));
                asesuisaTercerosConsultaBean.setOcupacion(rs.getString("ocupacion"));
                asesuisaTercerosConsultaBean.setNumeroRegistroContribuyente(rs.getString("numeroRegistroContribuyente"));
                asesuisaTercerosConsultaBean.setNumeroCelular(rs.getString("numeroCelular"));
                asesuisaTercerosConsultaBean.setCategoriaContribuyente(rs.getString("categoriaContribuyente"));
                asesuisaTercerosConsultaBean.setActividadEconomica(rs.getString("actividadEconomica"));
                asesuisaTercerosConsultaBean.setNivelSalarial(rs.getString("nivelSalarial"));
                asesuisaTercerosConsultaBean.setTipoEmpresa(rs.getString("tipoEmpresa"));
                asesuisaTercerosConsultaBean.setCategoriaEmpresa(rs.getString("categoriaEmpresa"));
                asesuisaTercerosConsultaBean.setExentoIVA(rs.getString("exentoIVA"));
                asesuisaTercerosConsultaBean.setCodigoIdentificador(rs.getString("codigoIdentificador"));
                asesuisaTercerosConsultaBean.setLogin(rs.getString("login"));
                asesuisaTercerosConsultaBean.setNumeroDocumentoIdentificacion(rs.getString("numeroDocumentoIdentificacion"));

                asesuisaTercerosConsulta.add(asesuisaTercerosConsultaBean);
            }
        }catch (SQLException e){
            log.error(e);
        }finally{
            if (conexion != null){
                conexion.close();
            }
        }

        return asesuisaTercerosConsulta;
    }
}
