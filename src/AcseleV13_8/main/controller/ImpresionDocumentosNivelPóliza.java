package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ImpresionDocumentosNivelPólizaBean;
import AcseleV13_8.main.controller.PolizaEmision.TerceroTomador;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.InformacionGeneralPoliza;
import AcseleV13_8.main.controller.PolizaEmision.PrePoliza;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by agil on 16/09/2016.
 */
public class ImpresionDocumentosNivelPóliza {

    private final static Logger log = Logger.getLogger(ImpresionDocumentosNivelPóliza.class);

    public String nombreAutomatizacion = "Terceros Documentos";

    public void testLink(ImpresionDocumentosNivelPólizaBean impresionDocumentosNivelPólizaBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            //PrePoliza
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la póliza */

            // PrePoliza
            prePoliza.AdminPropuestaPoliza(a, driver, impresionDocumentosNivelPólizaBean, nombreAutomatizacion, i, 3);
            prePoliza.EvAplicar(a, driver, impresionDocumentosNivelPólizaBean, nombreAutomatizacion, i, 4);
            informacionGeneralPoliza.InformacionGeneral(a, driver, impresionDocumentosNivelPólizaBean, nombreAutomatizacion, i, 5);
            terceroTomador.TomadorTercero(a, driver, impresionDocumentosNivelPólizaBean, nombreAutomatizacion, i, 6, 7);





        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
