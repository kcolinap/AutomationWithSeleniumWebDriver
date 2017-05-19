package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroBusquedaSimpleBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

/**
 * Created by kcolina on 19/05/2017.
 */
public class Asesuisa_SiniestroBusquedaSimple {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaSimple.class);

    public String nombreAutomatizacion = "Busqueda simple de siniestro";
    private WebDriver driver;

    public void TestLink(Asesuisa_SiniestroBusquedaSimpleBean bean, int i, String folderName){
        try {

            String idCampo="";
            int nroCampo;
            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion Mantenimiento de Siniestro
            menuOperaciones.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(1000);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Evaluo por cual campo se hara la busqueda
            idCampo=bean.getIdCampo();
            Thread.sleep(1000);
            nroCampo=Integer.parseInt(idCampo);

            //Llamada al metodo BuscarSiniestro
            BuscarSiniestro(driver,bean,m,i,nombreAutomatizacion,folderName,nroCampo);
            Thread.sleep(1500);

            //Salida de la funcionalidad
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarSiniestro(WebDriver driver, Asesuisa_SiniestroBusquedaSimpleBean bean, Metodos m,
                                int i, String nombreAutomatizacion, String folderName, int idCampo){
        try {

            WebElement txtCampo;

            //Selecciono el metodo de ordenamiento en caso de estar establecido en el xml
            if (bean.getOrdenarPor()!=null){

                //Click a la flecha para desplegar combo ordenarPor
                driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[3]/div/div")).click();
                Thread.sleep(800);

                //Evaluo el nro de elemnto del combo
                int nroOpciones= driver.findElements(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr")).size();
                for (int k=1;k==nroOpciones;k++){
                    if( (driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+k+"]/td")).equals(bean.getOrdenarPor())) ){
                        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/table/tbody/tr["+k+"]/td")).click();
                        Thread.sleep(1000);
                        break;
                    }
                }
            }

            //Evaluo el campo por el cual se realizara la busqueda simple
            switch (idCampo){
                case 1:
                    System.out.println("Búsqueda por: Nro de Siniestro");
                    txtCampo = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                    txtCampo.sendKeys(bean.getNroSiniestro());

                    //Click al elemento label del campo nro de siniestro
                    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[2]/div")).click();
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Llamada al metodo ValidarBusqueda
                    //ValidarBusqueda(driver,m,i,nombreAutomatizacion,folderName);
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
