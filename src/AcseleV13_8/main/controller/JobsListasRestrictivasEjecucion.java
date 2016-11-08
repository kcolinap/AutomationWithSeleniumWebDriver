package AcseleV13_8.main.controller;

import AcseleV13_8.beans.JobsListasRestrictivasCreacionBean;
import AcseleV13_8.beans.JobsListasRestrictivasEjecucionBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 25/08/2016.
 */
public class JobsListasRestrictivasEjecucion {

    private final static Logger log = Logger.getLogger(JobsListasRestrictivasEjecucion.class);

    public static String nombreAutomatizacion = "Jobs Listas Restrictivas Ejecucion";

    public void testLink(JobsListasRestrictivasEjecucionBean JobsListasRestrictivasEjecucionBean, int i) throws IOException, InterruptedException {

        try {

            //implementando clases
            Metodos a = new Metodos();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Ingreso al menu
            menuMantenimiento.MantGeral_TablasDinamicas(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            //      BuscarTabla(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
