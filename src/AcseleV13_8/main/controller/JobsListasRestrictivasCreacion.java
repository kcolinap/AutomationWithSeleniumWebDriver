package AcseleV13_8.main.controller;

import AcseleV13_8.beans.JobsListasRestrictivasCreacionBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.util.List;



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
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Ingreso al menu
            menuMantenimiento.AdminTar_Actividades(a, driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            InsertarActividades(a, driver, jobsListasRestrictivasCreacionBean);
            Thread.sleep(1000);

            BuscarActividades(a, driver, jobsListasRestrictivasCreacionBean);

            Thread.sleep(1000);
            WebElement numActividad = driver.findElement(By.xpath("/html/body/center/div/table/tbody/tr[1]/td[3]"));
            String numeroActividad = numActividad.getText();
            Thread.sleep(1000);

            driver.close(); //Cerrar la pestaña
            a.regresarVentana(driver);
            Thread.sleep(1000);

            menuMantenimiento.AdminTar_EjecucionTareas(a, driver, nombreAutomatizacion, 10);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            InsertarTareas(a, driver, jobsListasRestrictivasCreacionBean, numeroActividad);

            Thread.sleep(1000);
            menuMantenimiento.AdminTar_EjecucionTareas(a, driver, nombreAutomatizacion, 16);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BuscarTareas(a, driver, jobsListasRestrictivasCreacionBean);


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InsertarActividades(Metodos a, WebDriver driver, JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean){

        try {

            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnInsert = driver.findElement(By.xpath("/html/body/div/button"));
            btnInsert.click();

            Thread.sleep(20000);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement descripcion = driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[1]/td[2]/input"));
            WebElement programa = driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[2]/td[2]/div/input"));
            Select tipo = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[3]/td[2]/select")));
            Select nombrePantalla = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[4]/td[2]/select")));
            Select diasFeriados = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[5]/td[2]/select")));
            Select usuarios = new Select(driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody[1]/tr[2]/td/table/tbody/tr[1]/td[1]/select")));
            WebElement pasarTodosUsuarios = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody[1]/tr[2]/td/table/tbody/tr[3]/td/center/input"));
            Select grupos = new Select(driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody[2]/tr/td/table/tbody/tr[1]/td[1]/select")));
            WebElement pasarTodosGrupos = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody[2]/tr/td/table/tbody/tr[3]/td/center/input"));
            WebElement btnInsertarActividad = driver.findElement(By.xpath("/html/body/center/form/input[2]"));

            Thread.sleep(2000);
            if (jobsListasRestrictivasCreacionBean.getJobDescripcion() != null){
                descripcion.sendKeys(jobsListasRestrictivasCreacionBean.getJobDescripcion());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getJobPrograma() != null){
                programa.sendKeys(jobsListasRestrictivasCreacionBean.getJobPrograma());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getJobTipo() != null){
                tipo.selectByValue(jobsListasRestrictivasCreacionBean.getJobTipo()); // 1.0 = JOB
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getJobNombrePantalla() != null){
                nombrePantalla.selectByValue(jobsListasRestrictivasCreacionBean.getJobNombrePantalla());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getJobDiasFeriados() != null){
                diasFeriados.selectByValue(jobsListasRestrictivasCreacionBean.getJobDiasFeriados());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            List<WebElement> usuariosSize = usuarios.getOptions();
            int usuariosListSize = usuariosSize.size();
            // Setting up the loop to print all the options
            for(int i =0; i < usuariosListSize ; i++){
                // Storing the value of the option
                String sValue = usuarios.getOptions().get(i).getText();
                //System.out.println(sValue);
                // Selecting all the elements one by one
                usuarios.selectByIndex(i);
                //Thread.sleep(2000);
            }
            Thread.sleep(1000);
            pasarTodosUsuarios.click();
            Thread.sleep(2000);


            List<WebElement> gruposSize = grupos.getOptions();
            int gruposListSize = gruposSize.size();
            // Setting up the loop to print all the options
            for(int i =0; i < gruposListSize ; i++){
                // Storing the value of the option
                String sValue = grupos.getOptions().get(i).getText();
                //System.out.println(sValue);
                // Selecting all the elements one by one
                grupos.selectByIndex(i);
                //Thread.sleep(2000);
            }
            Thread.sleep(1000);
            pasarTodosGrupos.click();
            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnInsertarActividad.click();

            Thread.sleep(10000);
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);



        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarActividades(Metodos a, WebDriver driver, JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean){
        try {

            Thread.sleep(2000);

            WebElement numActividad = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
            Select diasFeriados = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/select")));
            Select tipo = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/select")));
            WebElement descripcion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input"));
            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/form/center/button[1]"));

            Thread.sleep(1000);

            if (jobsListasRestrictivasCreacionBean.getJobDiasFeriados() != null){
                diasFeriados.selectByValue(jobsListasRestrictivasCreacionBean.getJobDiasFeriados());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getJobTipo() != null){
                tipo.selectByValue(jobsListasRestrictivasCreacionBean.getJobTipo());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getJobDescripcion() != null){
                descripcion.sendKeys(jobsListasRestrictivasCreacionBean.getJobDescripcion());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscar.click();

            Thread.sleep(7000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InsertarTareas(Metodos a, WebDriver driver, JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean, String numeroActividad){

        try {

            Thread.sleep(4000);
            //WebElement btnInsert = driver.findElement(By.xpath(""));
            //WebElement btnInsert = driver.findElement(By.xpath("/html/body/center/div[1]/input"));
            WebElement btnInsert = driver.findElement(By.xpath("//div/input"));
//            WebElement btnInsert = driver.findElement(By.xpath("/html/body/center/div[1]/input"));

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnInsert.click();

            Thread.sleep(4000);

            WebElement descripcion = driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[1]/td[2]/input"));
            WebElement fechaEjecucion = driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[2]/td[2]/input[6]"));
            Select horaEjecucion = new Select(driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[3]/td[2]/select[1]")));
            Select minutoEjecucion = new Select(driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[3]/td[2]/select[2]")));
            Select periodicidad = new Select(driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[4]/td[2]/select")));
            WebElement servidor = driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[6]/td[2]/input"));
            Select actividades = new Select(driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[7]/td[2]/select")));
            Select notificarEjecucion = new Select(driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[8]/td[2]/select")));
            Select ejecutarExclusivamente = new Select(driver.findElement(By.xpath("/html/body/center/form[2]/table[1]/tbody/tr[9]/td[2]/select")));
            Select citasRequeridas = new Select(driver.findElement(By.xpath("/html/body/center/form[2]/table[3]/tbody/tr[1]/td[1]/select")));
            WebElement btnPasarTodasCitas = driver.findElement(By.xpath("/html/body/center/form[2]/table[3]/tbody/tr[3]/td/input"));
            WebElement btnEmail = driver.findElement(By.xpath("/html/body/center/form[2]/input[2]"));
            WebElement btnInsertarTarea = driver.findElement(By.xpath("/html/body/center/form[2]/input[3]"));

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(1000);

            if (jobsListasRestrictivasCreacionBean.getTareaDescripcion() != null){
                descripcion.sendKeys(jobsListasRestrictivasCreacionBean.getTareaDescripcion());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getTareaFechaEjecucion() != null){
                fechaEjecucion.sendKeys(jobsListasRestrictivasCreacionBean.getTareaFechaEjecucion());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getTareaHoraEjecucion() != null){
                horaEjecucion.selectByValue(jobsListasRestrictivasCreacionBean.getTareaHoraEjecucion());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getTareaMinutoEjecucion() != null){
                minutoEjecucion.selectByValue(jobsListasRestrictivasCreacionBean.getTareaMinutoEjecucion());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getTareaPeriodicidad() != null){
                periodicidad.selectByValue(jobsListasRestrictivasCreacionBean.getTareaPeriodicidad()); //1 = Sin periodicidad
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getTareaMinutoEjecucion() != null && servidor.isEnabled()){
                servidor.sendKeys(jobsListasRestrictivasCreacionBean.getTareaMinutoEjecucion());//Enviar vacío
                Thread.sleep(1000);
            }


            Thread.sleep(1000);
            actividades.selectByValue(numeroActividad /*+ " - SearchThirdsInRestrictiveListsGeneratorJob"*/);

            if (jobsListasRestrictivasCreacionBean.getTareaNotificarEjecucion() != null){
                notificarEjecucion.selectByValue(jobsListasRestrictivasCreacionBean.getTareaNotificarEjecucion());
                Thread.sleep(1000);
            }

            if (jobsListasRestrictivasCreacionBean.getTareaEjecutaExclusivamente() != null){
                ejecutarExclusivamente.selectByValue(jobsListasRestrictivasCreacionBean.getTareaEjecutaExclusivamente());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);

            List<WebElement> citasRequeridasSize = citasRequeridas.getOptions();
            int citasRequeridasSizeListSize = citasRequeridasSize.size();
            // Setting up the loop to print all the options
            for(int i =0; i < citasRequeridasSizeListSize ; i++){
                // Storing the value of the option
                String sValue = citasRequeridas.getOptions().get(i).getText();
                //System.out.println(sValue);
                // Selecting all the elements one by one
                citasRequeridas.selectByIndex(i);
                //Thread.sleep(2000);
            }

            btnPasarTodasCitas.click();
            Thread.sleep(1000);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnEmail.click();
            Thread.sleep(4000);

            WebElement emailResponsable = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/center/form/table/tbody[1]/tr/td[2]/input"));
            WebElement btnInsertarEmail = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/center/form/input[1]"));

            if (jobsListasRestrictivasCreacionBean.getTareaEmailResponsable() != null){
                emailResponsable.sendKeys(jobsListasRestrictivasCreacionBean.getTareaEmailResponsable());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnInsertarEmail.click();
            Thread.sleep(1000);

            WebElement btnSi = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/span/button"));
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            btnSi.click();

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnInsertarTarea.click();

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen15", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            driver.close();
            Thread.sleep(1000);
            a.regresarVentana(driver);



        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTareas(Metodos a, WebDriver driver, JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean){

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
            if (jobsListasRestrictivasCreacionBean.getBusqTareaNumCita() != null){
                numCita.sendKeys(jobsListasRestrictivasCreacionBean.getBusqTareaNumCita());
                Thread.sleep(2000);
            }

            if (jobsListasRestrictivasCreacionBean.getBusqTareaEstatus() != null){
                estatus.selectByValue(jobsListasRestrictivasCreacionBean.getBusqTareaEstatus());
                Thread.sleep(2000);
            }

            if (jobsListasRestrictivasCreacionBean.getBusqTareaPeriodicidad() != null){
                periodicidad.selectByValue(jobsListasRestrictivasCreacionBean.getBusqTareaPeriodicidad());
                Thread.sleep(2000);
            }

            if (jobsListasRestrictivasCreacionBean.getBusqTareaDesde() != null){
                desde.sendKeys(jobsListasRestrictivasCreacionBean.getBusqTareaDesde());
                Thread.sleep(2000);
            }

            if (jobsListasRestrictivasCreacionBean.getBusqTareaHasta() != null){
                hasta.sendKeys(jobsListasRestrictivasCreacionBean.getBusqTareaHasta());
                Thread.sleep(2000);
            }

            if (jobsListasRestrictivasCreacionBean.getBusqTareaDescripcion() != null){
                descripcion.sendKeys(jobsListasRestrictivasCreacionBean.getBusqTareaDescripcion());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen17", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscar.click();

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen18", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
