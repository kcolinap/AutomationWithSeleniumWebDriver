package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ImpresionDocumentosNivelURBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

/**
 * Created by agil on 23/09/2016.
 */
public class ImpresionDocumentosNivelUR {

    private final static Logger log = Logger.getLogger(ImpresionDocumentosNivelUR.class);

    public String nombreAutomatizacion = "Impresion de Documentos a Nivel de UR";

    public void testLink(ImpresionDocumentosNivelURBean impresionDocumentosNivelURBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos13_8 a = new Metodos13_8();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            //PrePoliza
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();
            UnidadesRiesgo unidadesRiesgo = new UnidadesRiesgo();
            ObjetoAsegurado objetoAsegurado = new ObjetoAsegurado();
            AseguradoVida aseguradoVida = new AseguradoVida();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la póliza */

            // PrePoliza
            Thread.sleep(3000);
            prePoliza.AdminPropuestaPoliza(a, driver, impresionDocumentosNivelURBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, impresionDocumentosNivelURBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, impresionDocumentosNivelURBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero(a, driver, impresionDocumentosNivelURBean, nombreAutomatizacion, i, 6, 7);
            //Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, impresionDocumentosNivelURBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, impresionDocumentosNivelURBean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            aseguradoVida.AseguradoVida(a, driver, impresionDocumentosNivelURBean, nombreAutomatizacion, i, 11);
            Thread.sleep(2000);
            Calcular(a, driver, i, 12, 13, 14, 15);


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void Calcular (Metodos13_8 a, WebDriver driver, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            btnCalcular.click();

            /***Espera***/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Calcular Poliza");
            }

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAplicar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
            btnAplicar.click();

            /***Espera***/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Aplicar Poliza");
            }

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement linkVerDocumentos = driver.findElement(By.xpath("//a[@wicketpath='modalWindowForm_EventSection_content_applyForm_CalculateDoc']"));
            linkVerDocumentos.click();

            /***Espera***/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Lista de Documentos");
            }

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement linkdocumentoImprimir = driver.findElement(By.xpath("//a[@wicketpath='modalWindowForm_EventSection_content_DivDocumentsPdf_container_DocumentsPdf_1_LinkPdf']"));
            linkdocumentoImprimir.click();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
