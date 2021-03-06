package AcseleV13_8LBC.principal;

import AcseleV13_8LBC.tests.VistaLBC_CreacionCajaTest;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SyslogAppender;

/**
 * Created by agil on 04/11/2016.
 */
public class Ejecutar {
    private final static Logger log = Logger.getLogger(Ejecutar.class);

    public static void main(String[] args) throws Exception {

        log.info("Arrancando el main");
        log.error("Arrancando el main");
        log.debug("Arrancando el main");

        VistaLBC_CreacionCajaTest vistaLBCCreacionCajaTest = new VistaLBC_CreacionCajaTest();
        vistaLBCCreacionCajaTest.setUp();
        vistaLBCCreacionCajaTest.mainTest();
        vistaLBCCreacionCajaTest.tearDown();

    }
}
