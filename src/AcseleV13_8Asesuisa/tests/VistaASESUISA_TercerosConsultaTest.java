package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.ASESUISA_TercerosConsultaBean;
import AcseleV13_8Asesuisa.main.controller.ASESUISA_TercerosConsulta;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 21/02/2017.
 */
public class VistaASESUISA_TercerosConsultaTest {

    private final static Logger Log = Logger.getLogger(VistaASESUISA_TercerosConsultaTest.class);

    @Test
    public void mainTest() throws SQLException{
        ArrayList asesuisaTercerosConsulta = null;

        try{
            asesuisaTercerosConsulta = ASESUISA_TercerosConsultaBean.getTecerosConsultaBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTercerosConsulta.size(); j++){
            ASESUISA_TercerosConsultaBean asesuisaTercerosConsultaBean = (ASESUISA_TercerosConsultaBean)asesuisaTercerosConsulta.get(j);
            ASESUISA_TercerosConsulta a = new ASESUISA_TercerosConsulta();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try{
                a.testLink
            }
        }
    }
}
