package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CancelacionAnulacionPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

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

            btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']"));
            btnBuscar.click();
            Thread.sleep(1000);

            //Valido la busqueda
            ValidaBusqueda(m, driver, nombreAutomatizacion, asesuisaCancelacionAnulacionPolizaBean, i, 3, folderName,
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
                              int screenShoot1, String folderName, String nroPoliza ){

        try {

            String msj;

            //Evaluo si el campo nroPoliza esta en blanco
            if (nroPoliza.equals("")){
                msj=(driver.findElement(By.id("_wicket_window_15")).getText());
                System.out.println(msj);
                System.out.println("");
                Thread.sleep(500);

                //pantallazo
            }else if ((driver.findElement(By.id("_wicket_window_15")).isDisplayed())){//Nro de poliza no encontrado
                msj=(driver.findElement(By.id("_wicket_window_15")).getText());
                System.out.println(msj);
                System.out.println("");
                Thread.sleep(500);

                //pantallazo
            }else{//Poliza encontrada
                WebElement optPoliza, btnCancelar;
                boolean dialog;
                String message;

                msj="Poliza encontrada";
                System.out.println(msj);
                System.out.println("");
                Thread.sleep(500);

                optPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_2_policy']"));
                optPoliza.click();

                //Pantallazo

                Thread.sleep(800);
                btnCancelar = driver.findElement(By.xpath("ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_CancelPolicyButton"));
                btnCancelar.click();
                Thread.sleep(1000);

                //Evaluo si hay mensaje de error
                dialog = (driver.findElement(By.xpath("modalWindowForm_ErrorDialog_content")).isDisplayed());
                message = (driver.findElement(By.xpath("modalWindowForm_ErrorDialog_content")).getText());
                if (dialog && (message.equals("No existen eventos disponibles para el estado Rescate"))){
                    System.out.println("No se puede cancelar. Poliza en estatus RESCATE");
                    System.out.println("");
                    //pantallazos
                }else if(dialog && (message.equals("No existen eventos disponibles para el estado Cancelado"))){
                    System.out.println("No se puede cancelar. Poliza en estatus CANCELADO");
                    System.out.println("");
                    //pantallazos
                }else{
                    CancelarPoliza(m,driver,nombreAutomatizacion,i,5,folderName);
                }

            }

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CancelarPoliza(Metodos m, WebDriver driver, String nombreAutomatizacion, int i,
                               int screenShoot1, String folderName){

        try {

            /********************************************************************
             * ******************************************************************
             * formulario evento a aplicar
             */
            Select razon, operacion;
            int valor = (int)(Math.random() * 3 + 2);
            razon = new Select(driver.findElement(By.xpath("modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_repeaterSelect_1_field")));
            razon.selectByValue("88152"+valor);
            Thread.sleep(1000);

            valor=0;
            valor = (int)(Math.random() * 1 + 0);
            operacion = new Select(driver.findElement(By.xpath("modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_3_fila_repeaterSelect_1_field")));
            operacion.selectByValue("88142"+valor);
            Thread.sleep(1000);

            //pantallazo

            WebElement btnContinuar;
            btnContinuar = driver.findElement(By.xpath("modalWindowForm_EventSection_content_Form_continueButton"));
            btnContinuar.click();
            Thread.sleep(1000);
            /**************************************************************
             * Fin formulario
             */

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
