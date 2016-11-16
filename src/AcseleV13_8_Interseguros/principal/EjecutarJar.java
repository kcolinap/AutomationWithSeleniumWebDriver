package AcseleV13_8_Interseguros.principal;

import AcseleV13_8_Interseguros.tests.VistaINTER_ConsultaTerceroTest;
import org.apache.log4j.Logger;

/**
 * Created by agil on 11/15/16.
 */
public class EjecutarJar {

    private final static Logger log = Logger.getLogger(EjecutarJar.class);

    public static void main(String[] args) throws Exception {

        log.info("Arrancando el main");
        log.error("Arrancando el main");
        log.debug("Arrancando el main");

        VistaINTER_ConsultaTerceroTest vistaINTER_consultaTerceroTest = new VistaINTER_ConsultaTerceroTest();
        vistaINTER_consultaTerceroTest.setUp();
        vistaINTER_consultaTerceroTest.mainTest();
        vistaINTER_consultaTerceroTest.tearDown();

    }
}
