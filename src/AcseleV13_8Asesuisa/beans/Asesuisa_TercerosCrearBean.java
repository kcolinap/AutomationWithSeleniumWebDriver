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
 * Created by kcolina on 24/02/2017.
 */
public class Asesuisa_TercerosCrearBean extends Asesuisa_TercerosBean implements Serializable {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosCrearBean.class);

    public static ArrayList getTercerosCrearBean() throws SQLException{

        Connection conexion = null;
        Statement stmt;
        ResultSet rs;
        ArrayList asesuisaTercerosCrear = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM asesuisa_terceros_crear ORDER BY prueba ASC");

        try{
            conexion = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_TercerosCrearBean asesuisaTercerosCrearBean = new Asesuisa_TercerosCrearBean();

                asesuisaTercerosCrearBean.setTipoTercero(rs.getString("tipoTercero"));
                asesuisaTercerosCrearBean.setAseguradoAp(rs.getString("aseguradoAp"));
                asesuisaTercerosCrearBean.setPrimerNombre(rs.getString("primerNombre"));
                asesuisaTercerosCrearBean.setSegundoNombre(rs.getString("segundoNombre"));
                asesuisaTercerosCrearBean.setPrimerApellido(rs.getString("primerApellido"));
                asesuisaTercerosCrearBean.setSegundoApellido(rs.getString("segundoApellido"));
                asesuisaTercerosCrearBean.setNacionalidad(rs.getString("nacionalidad"));
                asesuisaTercerosCrearBean.setPaisOrigen(rs.getString("paisOrigen"));
                asesuisaTercerosCrearBean.setEdadPersonaNatural(rs.getString("edadPersonaNatural"));
                asesuisaTercerosCrearBean.setFechaNacimiento(rs.getString("fechaNacimiento"));
                asesuisaTercerosCrearBean.setNumeroDUI(rs.getString("numeroDUI"));
                asesuisaTercerosCrearBean.setNumeroNIT(rs.getString("numeroNIT"));
                asesuisaTercerosCrearBean.setNumeroDocumento(rs.getString("numeroDocumento"));
                asesuisaTercerosCrearBean.setNumeroNUP(rs.getString("numeroNUP"));
                asesuisaTercerosCrearBean.setTipoDocumentoIdentificacion(rs.getString("tipoDocumentoIdentificacion"));
                asesuisaTercerosCrearBean.setCorreoElectronicoPrincipal(rs.getString("correoElectronicoPrincipal"));
                asesuisaTercerosCrearBean.setCorreoElectronicoOpcional(rs.getString("correoElectronicoOpcional"));
                asesuisaTercerosCrearBean.setUsuario(rs.getString("usuario"));
                asesuisaTercerosCrearBean.setIdFacebook(rs.getString("idFacebook"));
                asesuisaTercerosCrearBean.setIdTwitter(rs.getString("idTwitter"));
                asesuisaTercerosCrearBean.setIdLinkedin(rs.getString("idLinkedin"));
                asesuisaTercerosCrearBean.setEstadoCivil(rs.getString("estadoCivil"));
                asesuisaTercerosCrearBean.setGenero(rs.getString("genero"));
                asesuisaTercerosCrearBean.setNivelEstudio(rs.getString("nivelEstudio"));
                asesuisaTercerosCrearBean.setNumeroHijos(rs.getString("numeroHijos"));
                asesuisaTercerosCrearBean.setTlfDomicilio(rs.getString("tlfDomicilio"));
                asesuisaTercerosCrearBean.setOcupacion(rs.getString("ocupacion"));
                asesuisaTercerosCrearBean.setNumeroRegistroContribuyente(rs.getString("numeroRegistroContribuyente"));
                asesuisaTercerosCrearBean.setNumeroCelular(rs.getString("numeroCelular"));
                asesuisaTercerosCrearBean.setCategoriaContribuyente(rs.getString("categoriaContribuyente"));
                asesuisaTercerosCrearBean.setActividadEconomica(rs.getString("actividadEconomica"));
                asesuisaTercerosCrearBean.setNivelSalarial(rs.getString("nivelSalarial"));
                asesuisaTercerosCrearBean.setTipoEmpresa(rs.getString("tipoEmpresa"));
                asesuisaTercerosCrearBean.setCategoriaEmpresa(rs.getString("categoriaEmpresa"));
                asesuisaTercerosCrearBean.setExentoIVA(rs.getString("exentoIVA"));
                asesuisaTercerosCrearBean.setCodigoIdentificador(rs.getString("codigoIdentificador"));
                asesuisaTercerosCrearBean.setLogin(rs.getString("login"));
                asesuisaTercerosCrearBean.setNumeroDocumentoIdentificacion(rs.getString("numeroDocumentoIdentificacion"));

                asesuisaTercerosCrear.add(asesuisaTercerosCrearBean);
            }
        }catch (SQLException e){
            Log.error(e);
        }finally{
            if (conexion != null){
                conexion.close();
            }
        }

        return asesuisaTercerosCrear;
    }
}
