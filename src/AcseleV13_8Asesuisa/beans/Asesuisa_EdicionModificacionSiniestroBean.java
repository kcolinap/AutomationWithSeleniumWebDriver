package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by cortiz on 09/05/2017.
 */
public class Asesuisa_EdicionModificacionSiniestroBean extends Asesuisa_SiniestroBean{

    private final static Logger log = Logger.getLogger(Asesuisa_EdicionModificacionSiniestroBean.class);

    private String NSINIESTRO;
    private String FOCURRENCIA;
    private String PRODUCTO;
    private String FOPERACION;
    private String CCOMENTARIO;
    private String MONTOSINI;
    private String HORASINIESTRO;
    private String FASTTRACK;
    private String TALLER;
    private String AJUSTADOREXT;
    private String AJUSTADOR;
    private String MONPREINI;
    private String MONPRE;
    private String MONDEC;
    private String RESPONSABILIDAD;
    private String CODESTADO;
    private String SUBESTADO;
    private String TIPORECLAMO;
    private String VALORPAGO;
    private String AUTORIZADOPOR;
    private String TERCEROSAFECTADOS;
    private String AFECTADOS;
    private String TALLERDOS;
    private String ID;
    private String NOMAPEELIDO;
    private String NOLICENCIA;
    private String VTOLICENCIA;
    private String EDAD;
    private String PLACA;
    private String MARCA;
    private String MODELO;
    private String AJUSTEXT2;
    private String AJUSTADOR2;
    private String FECHAASIGAJUST;
    private String MONPREINI2;
    private String NOMAPEELID2;
    private String NOLICENCIA2;
    private String ano;

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNSINIESTRO() {
        return NSINIESTRO;
    }

    public void setNSINIESTRO(String NSINIESTRO) {
        this.NSINIESTRO = NSINIESTRO;
    }


    public String getFOCURRENCIA() {
        return FOCURRENCIA;
    }

    public void setFOCURRENCIA(String FOCURRENCIA) {
        this.FOCURRENCIA = FOCURRENCIA;
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }

    public String getFOPERACION() {
        return FOPERACION;
    }

    public void setFOPERACION(String FOPERACION) {
        this.FOPERACION = FOPERACION;
    }

    public String getCCOMENTARIO() {
        return CCOMENTARIO;
    }

    public void setCCOMENTARIO(String CCOMENTARIO) {
        this.CCOMENTARIO = CCOMENTARIO;
    }

    public String getMONTOSINI() {
        return MONTOSINI;
    }

    public void setMONTOSINI(String MONTOSINI) {
        this.MONTOSINI = MONTOSINI;
    }

    public String getHORASINIESTRO() {
        return HORASINIESTRO;
    }

    public void setHORASINIESTRO(String HORASINIESTRO) {
        this.HORASINIESTRO = HORASINIESTRO;
    }

    public String getFASTTRACK() {
        return FASTTRACK;
    }

    public void setFASTTRACK(String FASTTRACK) {
        this.FASTTRACK = FASTTRACK;
    }

    public String getTALLER() {
        return TALLER;
    }

    public void setTALLER(String TALLER) {
        this.TALLER = TALLER;
    }

    public String getAJUSTADOREXT() {
        return AJUSTADOREXT;
    }

    public void setAJUSTADOREXT(String AJUSTADOREXT) {
        this.AJUSTADOREXT = AJUSTADOREXT;
    }

    public String getAJUSTADOR() {
        return AJUSTADOR;
    }

    public void setAJUSTADOR(String AJUSTADOR) {
        this.AJUSTADOR = AJUSTADOR;
    }

    public String getMONPREINI() {
        return MONPREINI;
    }

    public void setMONPREINI(String MONPREINI) {
        this.MONPREINI = MONPREINI;
    }

    public String getMONPRE() {
        return MONPRE;
    }

    public void setMONPRE(String MONPRE) {
        this.MONPRE = MONPRE;
    }

    public String getMONDEC() {
        return MONDEC;
    }

    public void setMONDEC(String MONDEC) {
        this.MONDEC = MONDEC;
    }

    public String getRESPONSABILIDAD() {
        return RESPONSABILIDAD;
    }

    public void setRESPONSABILIDAD(String RESPONSABILIDAD) {
        this.RESPONSABILIDAD = RESPONSABILIDAD;
    }

    public String getCODESTADO() {
        return CODESTADO;
    }

    public void setCODESTADO(String CODESTADO) {
        this.CODESTADO = CODESTADO;
    }

    public String getSUBESTADO() {
        return SUBESTADO;
    }

    public void setSUBESTADO(String SUBESTADO) {
        this.SUBESTADO = SUBESTADO;
    }

    public String getTIPORECLAMO() {
        return TIPORECLAMO;
    }

    public void setTIPORECLAMO(String TIPORECLAMO) {
        this.TIPORECLAMO = TIPORECLAMO;
    }

    public String getVALORPAGO() {
        return VALORPAGO;
    }

    public void setVALORPAGO(String VALORPAGO) {
        this.VALORPAGO = VALORPAGO;
    }

    public String getAUTORIZADOPOR() {
        return AUTORIZADOPOR;
    }

    public void setAUTORIZADOPOR(String AUTORIZADOPOR) {
        this.AUTORIZADOPOR = AUTORIZADOPOR;
    }

    public String getTERCEROSAFECTADOS() {
        return TERCEROSAFECTADOS;
    }

    public void setTERCEROSAFECTADOS(String TERCEROSAFECTADOS) {
        this.TERCEROSAFECTADOS = TERCEROSAFECTADOS;
    }

    public String getAFECTADOS() {
        return AFECTADOS;
    }

    public void setAFECTADOS(String AFECTADOS) {
        this.AFECTADOS = AFECTADOS;
    }

    public String getTALLERDOS() {
        return TALLERDOS;
    }

    public void setTALLERDOS(String TALLERDOS) {
        this.TALLERDOS = TALLERDOS;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNOMAPEELIDO() {
        return NOMAPEELIDO;
    }

    public void setNOMAPEELIDO(String NOMAPEELIDO) {
        this.NOMAPEELIDO = NOMAPEELIDO;
    }

    public String getNOLICENCIA() {
        return NOLICENCIA;
    }

    public void setNOLICENCIA(String NOLICENCIA) {
        this.NOLICENCIA = NOLICENCIA;
    }

    public String getVTOLICENCIA() {
        return VTOLICENCIA;
    }

    public void setVTOLICENCIA(String VTOLICENCIA) {
        this.VTOLICENCIA = VTOLICENCIA;
    }

    public String getEDAD() {
        return EDAD;
    }

    public void setEDAD(String EDAD) {
        this.EDAD = EDAD;
    }

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String PLACA) {
        this.PLACA = PLACA;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String MODELO) {
        this.MODELO = MODELO;
    }

    public String getAJUSTEXT2() {
        return AJUSTEXT2;
    }

    public void setAJUSTEXT2(String AJUSTEXT2) {
        this.AJUSTEXT2 = AJUSTEXT2;
    }

    public String getAJUSTADOR2() {
        return AJUSTADOR2;
    }

    public void setAJUSTADOR2(String AJUSTADOR2) {
        this.AJUSTADOR2 = AJUSTADOR2;
    }

    public String getFECHAASIGAJUST() {
        return FECHAASIGAJUST;
    }

    public void setFECHAASIGAJUST(String FECHAASIGAJUST) {
        this.FECHAASIGAJUST = FECHAASIGAJUST;
    }

    public String getMONPREINI2() {
        return MONPREINI2;
    }

    public void setMONPREINI2(String MONPREINI2) {
        this.MONPREINI2 = MONPREINI2;
    }

    public String getNOMAPEELID2() {
        return NOMAPEELID2;
    }

    public void setNOMAPEELID2(String NOMAPEELID2) {
        this.NOMAPEELID2 = NOMAPEELID2;
    }

    public String getNOLICENCIA2() {
        return NOLICENCIA2;
    }

    public void setNOLICENCIA2(String NOLICENCIA2) {
        this.NOLICENCIA2 = NOLICENCIA2;
    }

    public static ArrayList getEdicionSiniestroBean() throws SQLException {


        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList edicionSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_EDICIONSINIESTRO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()){
                Asesuisa_EdicionModificacionSiniestroBean bean = new Asesuisa_EdicionModificacionSiniestroBean();

                bean.setNSINIESTRO(rs.getString("NSINIESTRO"));
                bean.setFOCURRENCIA(rs.getString("FOCURRENCIA"));
                bean.setPRODUCTO(rs.getString("PRODUCTO"));
                bean.setFOPERACION(rs.getString("FOPERACION"));
                bean.setCCOMENTARIO(rs.getString("CCOMENTARIO"));
                bean.setMONTOSINI(rs.getString("MONTOSINI"));
                bean.setHORASINIESTRO(rs.getString("HORASINIESTRO"));
                bean.setFASTTRACK(rs.getString("FASTTRACK"));
                bean.setTALLER(rs.getString("TALLER"));
                bean.setAJUSTADOREXT(rs.getString("AJUSTADOREXT"));
                bean.setAJUSTADOR(rs.getString("AJUSTADOR"));
                bean.setMONPREINI(rs.getString("MONPREINI"));
                bean.setMONPRE(rs.getString("MONPRE"));
                bean.setMONDEC(rs.getString("MONDEC"));
                bean.setRESPONSABILIDAD(rs.getString("RESPONSABILIDAD"));
                bean.setCODESTADO(rs.getString("CODESTADO"));
                bean.setSUBESTADO(rs.getString("SUBESTADO"));
                bean.setTIPORECLAMO(rs.getString("TIPORECLAMO"));
                bean.setVALORPAGO(rs.getString("VALORPAGO"));
                bean.setAUTORIZADOPOR(rs.getString("AUTORIZADOPOR"));
                bean.setTERCEROSAFECTADOS(rs.getString("TERCEROSAFECTADOS"));
                bean.setAFECTADOS(rs.getString("AFECTADOS"));
                bean.setTALLERDOS(rs.getString("TALLERDOS"));
                bean.setID(rs.getString("ID"));
                bean.setNOMAPEELIDO(rs.getString("NOMAPEELIDO"));
                bean.setNOLICENCIA(rs.getString("NOLICENCIA"));
                bean.setVTOLICENCIA(rs.getString("VTOLICENCIA"));
                bean.setEDAD(rs.getString("EDAD"));
                bean.setPLACA(rs.getString("PLACA"));
                bean.setMARCA(rs.getString("MARCA"));
                bean.setMODELO(rs.getString("MODELO"));
                bean.setAJUSTEXT2(rs.getString("AJUSTEXT2"));
                bean.setAJUSTADOR2(rs.getString("AJUSTADOR2"));
                bean.setFECHAASIGAJUST(rs.getString("FECHAASIGAJUST"));
                bean.setMONPREINI2(rs.getString("MONPREINI2"));
                bean.setNOMAPEELID2(rs.getString("NOMAPEELID2"));
                bean.setNOLICENCIA2(rs.getString("NOLICENCIA2"));

                edicionSiniestro.add(bean);


            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return edicionSiniestro;
    }
}
