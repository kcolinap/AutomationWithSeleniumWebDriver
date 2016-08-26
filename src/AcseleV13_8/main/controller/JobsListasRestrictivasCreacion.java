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
            a.IniciarSesion(driver, nombreAutomatizacion);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion);
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

            a.regresarVentana(driver);
            Thread.sleep(1000);

            menuMantenimiento.AdminTar_EjecucionTareas(a, driver, nombreAutomatizacion, 9);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            InsertarTaress(a, driver, jobsListasRestrictivasCreacionBean, numeroActividad);



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

            descripcion.sendKeys("SearchThirdsInRestrictiveListsGeneratorJob");
            Thread.sleep(1000);
            programa.sendKeys("com.consisint.acsele.jobs.restrictivelist.SearchThirdsInRestrictiveListsGeneratorJob");
            Thread.sleep(1000);
            tipo.selectByValue("1.0"); // 1.0 = JOB
            Thread.sleep(1000);
            nombrePantalla.selectByValue("ASLFile");
            Thread.sleep(1000);
            diasFeriados.selectByValue("false");
            Thread.sleep(1000);

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

            Thread.sleep(1000);

            WebElement numActividad = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
            Select diasFeriados = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/select")));
            Select tipo = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/select")));
            WebElement descripcion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input"));
            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/form/center/button[1]"));

            Thread.sleep(1000);
            diasFeriados.selectByValue("false");
            Thread.sleep(1000);
            tipo.selectByValue("1.0");
            Thread.sleep(1000);
            descripcion.sendKeys("SearchThirdsInRestrictiveListsGeneratorJob");

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscar.click();

            Thread.sleep(7000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InsertarTaress(Metodos a, WebDriver driver, JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean, String numeroActividad){

        try {

            Thread.sleep(2000);
            //WebElement btnInsert = driver.findElement(By.xpath(""));
            WebElement btnInsert = driver.findElement(By.xpath("/html/body/center/div[1]/input"));

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
            descripcion.sendKeys("Proceso de Listas Restrictivas");
            Thread.sleep(1000);
            fechaEjecucion.sendKeys("26-08-2016");
            Thread.sleep(1000);

            /** if (horaEjecucion != null)*/
            Thread.sleep(1000);
            horaEjecucion.selectByValue("");
            Thread.sleep(1000);
            minutoEjecucion.selectByValue("");

            Thread.sleep(1000);
            periodicidad.selectByValue("1 "); //1 = Sin periodicidad

            Thread.sleep(1000);
            servidor.sendKeys("");

            Thread.sleep(1000);
            actividades.selectByValue(numeroActividad + " - SearchThirdsInRestrictiveListsGeneratorJob");

            Thread.sleep(1000);
            notificarEjecucion.selectByValue("false");

            Thread.sleep(1000);
            ejecutarExclusivamente.selectByValue("false");

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
            Thread.sleep(3000);

            WebElement emailResponsable = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/center/form/table/tbody[1]/tr/td[2]/input"));
            WebElement btnInsertarEmail = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/center/form/input[1]"));

            emailResponsable.sendKeys("correo@correo.com");
            Thread.sleep(1000);

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





        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTaress(Metodos a, WebDriver driver, JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean){

        try {

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
