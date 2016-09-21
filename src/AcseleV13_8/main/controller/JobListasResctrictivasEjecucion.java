package AcseleV13_8.main.controller;

import AcseleV13_8.beans.JobListasResctrictivasEjecucionBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 07/09/2016.
 */
public class JobListasResctrictivasEjecucion {

    private final static Logger log = Logger.getLogger(JobListasResctrictivasEjecucion.class);

    public static String nombreAutomatizacion = "Jobs Listas Restrictivas Ejecucion";

    public void testLink(JobListasResctrictivasEjecucionBean jobListasResctrictivasEjecucionBean, int i) throws IOException, InterruptedException {

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
            menuMantenimiento.AdminTar_EjecucionTareas(a, driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BuscarTareas(a, driver, jobListasResctrictivasEjecucionBean);


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTareas(Metodos a, WebDriver driver, JobListasResctrictivasEjecucionBean jobListasResctrictivasEjecucionBean){

        try {

            Thread.sleep(4000);

            WebElement numCita = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[1]/td[2]/input"));
            Select estatus = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td[2]/select")));
            Select periodicidad = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[3]/td[2]/select")));
            WebElement desde = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[1]/td[4]/input[1]"));
            WebElement hasta = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td[4]/input[1]"));
            WebElement descripcion = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[3]/td[4]/input"));
            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/center/form/center/button[1]"));

            Thread.sleep(1000);
            if (jobListasResctrictivasEjecucionBean.getBusqTareaNumCita() != null){
                numCita.sendKeys(jobListasResctrictivasEjecucionBean.getBusqTareaNumCita());
                Thread.sleep(2000);
            }

            if (jobListasResctrictivasEjecucionBean.getBusqTareaEstatus() != null){
                estatus.selectByValue(jobListasResctrictivasEjecucionBean.getBusqTareaEstatus());
                Thread.sleep(2000);
            }

            if (jobListasResctrictivasEjecucionBean.getBusqTareaPeriodicidad() != null){
                periodicidad.selectByValue(jobListasResctrictivasEjecucionBean.getBusqTareaPeriodicidad());
                Thread.sleep(2000);
            }

            if (jobListasResctrictivasEjecucionBean.getBusqTareaDesde() != null){
                desde.sendKeys(jobListasResctrictivasEjecucionBean.getBusqTareaDesde());
                Thread.sleep(2000);
            }

            if (jobListasResctrictivasEjecucionBean.getBusqTareaHasta() != null){
                hasta.sendKeys(jobListasResctrictivasEjecucionBean.getBusqTareaHasta());
                Thread.sleep(2000);
            }

            if (jobListasResctrictivasEjecucionBean.getBusqTareaDescripcion() != null){
                descripcion.sendKeys(jobListasResctrictivasEjecucionBean.getBusqTareaDescripcion());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscar.click();

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            // Ejecutar Job
            WebElement btnEjecutarJob = driver.findElement(By.xpath("/html/body/center/div[2]/table/tbody/tr/td[4]/img"));
            btnEjecutarJob.click();

            Thread.sleep(2000);

            a.ScreenShot(driver, "screen5", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAgendarCitaSi = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/span/button[1]"));
            btnAgendarCitaSi.click();


            Thread.sleep(4000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
