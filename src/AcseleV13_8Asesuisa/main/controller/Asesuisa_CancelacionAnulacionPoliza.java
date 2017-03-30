package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CancelacionAnulacionPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

import java.util.List;

/**
 * Created by kcolina on 29/03/2017.
 */
public class Asesuisa_CancelacionAnulacionPoliza {

    private final static Logger Log = Logger.getLogger(Asesuisa_ConsultaEdoCuentaTerceros.class);
    public String nombreAutomatizacion = "Cancelacion-Anulacion de Poliza";
    private WebDriver driver;

    public void testLink(Asesuisa_CancelacionAnulacionPolizaBean asesuisaCancelacionAnulacionPolizaBean, int i,
                         String folderName){
        try{
            WebElement txtNroPoliza,btnBuscar;
            String nroPoliza;
            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

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
            nroPoliza=asesuisaCancelacionAnulacionPolizaBean.getNroPoliza();
            txtNroPoliza= driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
            txtNroPoliza.sendKeys(nroPoliza);
            Thread.sleep(500);

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
            Thread.sleep(500);

            btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']"));
            btnBuscar.click();
            Thread.sleep(1000);

            //Valido la busqueda
            ValidaBusqueda(m, driver, nombreAutomatizacion, asesuisaCancelacionAnulacionPolizaBean, i, 4,5, folderName,
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
                              Asesuisa_CancelacionAnulacionPolizaBean asesuisaCancelacionAnulacionPoliza, int i,
                              int screenShoot1, int screenShoot2, String folderName, String nroPoliza ){

        try {

            String msj;

            //Evaluo si el campo nroPoliza esta en blanco
            if (nroPoliza.equals("")){
                msj=(driver.findElement(By.id("_wicket_window_15")).getText());
                System.out.println(msj);
                System.out.println("");
                Thread.sleep(500);

                //pantallazo
                m.ScreenShotPool(driver,i,"screen"+screenShoot1,nombreAutomatizacion,folderName);
                Thread.sleep(800);

            }else if (driver.findElements(By.id("_wicket_window_15")).size()>0){//Nro de poliza no encontrado
                msj=(driver.findElement(By.id("_wicket_window_15")).getText());
                System.out.println(msj);
                System.out.println("");
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
                    CancelarPoliza(m,driver,nombreAutomatizacion,i,6,7,8,folderName);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CancelarPoliza(Metodos m, WebDriver driver, String nombreAutomatizacion, int i,
                               int screenShoot1, int screenShoot2,int screenShoot3, String folderName){

        try {

            /********************************************************************
             * ******************************************************************
             * formulario evento a aplicar
             */
            Select razon, operacion;
            String cast="";
            int valor, opciones;
            List<WebElement> element;

            razon = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_repeaterSelect_1_field']")));
            opciones=(razon.getOptions().size());
            element=razon.getOptions();
            for(int k=1; k<opciones; k++){
                valor=(int)(Math.random() * (opciones-2) + 1);
                cast=(element.get(valor).getAttribute("value"));
                break;
            }

            razon.selectByValue(cast);
            Thread.sleep(1000);

            element.clear();
            opciones=0;
            valor=0;cast="";
            operacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_3_fila_repeaterSelect_1_field']")));
            opciones=(operacion.getOptions().size());
            element=operacion.getOptions();
            for(int k=1; k<opciones; k++){
                valor=(int)(Math.random() * (opciones-2) + 1);
                cast=(element.get(valor).getAttribute("value"));
                break;
            }

            operacion.selectByValue(cast);
            Thread.sleep(1000);

            //pantallazo
            m.ScreenShotPool(driver,i,"screen"+screenShoot1,nombreAutomatizacion,folderName);
            Thread.sleep(800);

            WebElement btnContinuar;
            btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();
            Thread.sleep(1000);
            m.waitSearchWicket(driver,": Se esta procesando su solicitud");
            /**************************************************************
             * Fin formulario
             */
            //pantallazo
            Thread.sleep(800);
            m.ScreenShotPool(driver,i,"screen"+screenShoot2,nombreAutomatizacion,folderName);
            Thread.sleep(800);

            //Boton calcular
            WebElement btnCalcular, div;
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("window.scrollBy(0,5000)", "");
            Thread.sleep(800);

            //pantallazo
            m.ScreenShotPool(driver,i,"screen"+screenShoot3,nombreAutomatizacion,folderName);
            Thread.sleep(800);

            btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();
            Thread.sleep(1000);
            m.waitSearchWicket(driver, "Se esta procesando su solicitud");

            //Ventana aplicar
            Thread.sleep(1000);
            WebElement btnAplicar;

            btnAplicar=driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
            btnAplicar.click();
            m.waitSearchWicket(driver, "Se esta aplicando el evento");

            //Validar mensaje de error

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
