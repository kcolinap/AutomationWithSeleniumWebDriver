package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_RenovacionPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kcolina on 11/04/2017.
 */
public class Asesuisa_RenovacionPoliza {

    private final static Logger Log = Logger.getLogger(Asesuisa_ConsultaEdoCuentaTerceros.class);
    public String nombreAutomatizacion = "Renovacion de Poliza";
    private WebDriver driver;
    Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

    public void testLink(Asesuisa_RenovacionPolizaBean bean, int i, String folderName){

        try {
            WebElement txtNroPoliza,btnBuscar;
            String nroPoliza;
            Metodos m = new Metodos();

            //Inicio y valido sesion a la aplicacion
            driver=m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion: Cotizacion-suscripcion-mantenimiento de edicion(FrontEnd)
            menuOperaciones.OpePol_CotizacionSuscripcionEdicion_MantenimientoEdicionFrontEnd(driver, nombreAutomatizacion,
                    2,i,folderName);
            Thread.sleep(1200);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Capturo nro de poliza y click en buscar
            nroPoliza=bean.getNroPoliza();
            txtNroPoliza= driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
            if (nroPoliza==null){
                nroPoliza="";
                txtNroPoliza.sendKeys(nroPoliza);
            }else {
                txtNroPoliza.sendKeys(nroPoliza);
            }
            Thread.sleep(500);

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
            Thread.sleep(500);

            btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']"));
            btnBuscar.click();
            Thread.sleep(1000);

            //Valido la busqueda
            ValidaBusqueda(m, driver, nombreAutomatizacion, bean, i, 4,5, folderName,
                    nroPoliza);

            //Cierra navegador
            Thread.sleep(1000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void ValidaBusqueda(Metodos m, WebDriver driver, String nombreAutomatizacion,
                               Asesuisa_RenovacionPolizaBean bean, int i,
                               int screenShoot1, int screenShoot2, String folderName, String nroPoliza ){

        try {

            String msj;

            //Evaluo si el campo nroPoliza esta en blanco
            if (nroPoliza.equals("")){
                msj=(driver.findElement(By.className("w_windowMessage")).getText());
                System.out.println(msj);
                System.out.println("Nro de póliza en blanco. No se encontró resultados asociados con esta búsqueda");
                Thread.sleep(500);

                //pantallazo
                m.ScreenShotPool(driver,i,"screen"+screenShoot1,nombreAutomatizacion,folderName);
                Thread.sleep(800);

            }else if (driver.findElements(By.className("w_windowMessage")).size()>0){//Nro de poliza no encontrado
                msj=(driver.findElement(By.className("w_windowMessage")).getText());
                System.out.println(msj);
                System.out.println("No se encontró resultados asociados con esta búsqueda");
                Thread.sleep(500);

                //pantallazo
                m.ScreenShotPool(driver,i,"screen"+screenShoot1,nombreAutomatizacion,folderName);
                Thread.sleep(800);

            }else{//Poliza encontrada
                WebElement optPoliza, btnCancelar;
                String message;

                msj="Poliza encontrada";
                System.out.println(msj);
                System.out.println("");
                Thread.sleep(500);

                optPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']"));
                optPoliza.click();

                //Pantallazo
                m.ScreenShotPool(driver,i,"screen"+screenShoot1,nombreAutomatizacion,folderName);
                Thread.sleep(800);

                Thread.sleep(800);
                btnCancelar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_CancelPolicyButton']"));
                btnCancelar.click();
                Thread.sleep(1000);

                //Evaluo si hay mensaje de error
                boolean dialog= driver.findElements(By.id("_wicket_window_1")).size()>0;
                if (dialog &&(driver.findElements(By.className("w_windowMessage"))).size()>0){
                    message = (driver.findElement(By.id("id3c")).getText());
                    if (message.equals("No existen eventos disponibles para el estado Rescate")) {
                        System.out.println(message);
                        System.out.println("No se puede cancelar. Poliza en estatus RESCATE");
                        System.out.println("");
                        //pantallazo
                        m.ScreenShotPool(driver,i,"screen"+screenShoot2,nombreAutomatizacion,folderName);
                        Thread.sleep(800);

                    }else if (message.equals("No existen eventos disponibles para el estado Cancelado")){
                        System.out.println(message);
                        System.out.println("No se puede cancelar. Poliza en estatus CANCELADO");
                        System.out.println("");

                        //pantallazo
                        m.ScreenShotPool(driver,i,"screen"+screenShoot2,nombreAutomatizacion,folderName);
                        Thread.sleep(800);
                    }
                }else if (dialog &&(driver.findElements(By.className("w_windowPanel"))).size()>0){
                    RenovarPoliza(m, driver, nombreAutomatizacion, i, 5, 6, 7, 8, 9, 11, 12, 13, folderName, bean);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void RenovarPoliza(Metodos m, WebDriver driver, String nombreAutomatizacion, int i,
                               int screenShoot1, int screenShoot2,int screenShoot3, int screenShoot4, int screenShoot5,
                               int screenShoot6,int screenShoot7, int screenShoot8, String folderName,
                               Asesuisa_RenovacionPolizaBean bean){

    }
}
