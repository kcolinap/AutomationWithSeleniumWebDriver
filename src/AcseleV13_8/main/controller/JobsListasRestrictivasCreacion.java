package AcseleV13_8.main.controller;

import AcseleV13_8.beans.JobsListasRestrictivasCreacionBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 25/08/2016.
 */
public class JobsListasRestrictivasCreacion {

    private final static Logger log = Logger.getLogger(JobsListasRestrictivasCreacion.class);

    public static String nombreAutomatizacion = "Jobs Listas Restrictivas Creacion";

    public void testLink(JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean, int i) throws IOException, InterruptedException {

        try {

            //implementando clases
            Metodos a = new Metodos();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion);
            Thread.sleep(5000);

            // Ingreso al menu
            menuMantenimiento.MantGeral_TablasDinamicas(driver, nombreAutomatizacion, 2);

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
