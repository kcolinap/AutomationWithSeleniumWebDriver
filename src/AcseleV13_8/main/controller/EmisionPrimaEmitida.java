package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPrimaEmitidaBean;
import AcseleV13_8.main.controller.Menu.MenuConsultas;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by kzambrano on 29/09/2016.
 */
public class EmisionPrimaEmitida {

    private final static Logger log = Logger.getLogger(EmisionPrimaEmitida.class);

    public String nombreAutomatizacion = "Generacion de open item prima emitida";

    public void testLink(EmisionPrimaEmitidaBean emisionPrimaEmitidaBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones menuOperaciones = new MenuOperaciones();
            MenuConsultas menuConsultas = new MenuConsultas();
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
            Thread.sleep(2000);
            prePoliza.AdminPropuestaPoliza(a, driver, emisionPrimaEmitidaBean, nombreAutomatizacion, i, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, emisionPrimaEmitidaBean, nombreAutomatizacion, i, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, emisionPrimaEmitidaBean, nombreAutomatizacion, i, 5);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero(a, driver, emisionPrimaEmitidaBean, nombreAutomatizacion, i, 6, 7);
            //Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, emisionPrimaEmitidaBean, nombreAutomatizacion, i, 8, 9);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, emisionPrimaEmitidaBean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            aseguradoVida.AseguradoVida(a, driver, emisionPrimaEmitidaBean, nombreAutomatizacion, i, 11);
            Thread.sleep(2000);
            Calcular(a, driver, i, 12, 13);
            Thread.sleep(100);

            a.regresarVentana(driver);
            Thread.sleep(1000);
            menuConsultas.EstadoCuentas(a, driver, nombreAutomatizacion,14, i);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(3000);

            ConsultaEstadoCuenta(driver, a, emisionPrimaEmitidaBean, i);


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void Calcular (Metodos a, WebDriver driver, int i, int numScreenShoot2, int numScreenShoot3){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            Thread.sleep(1500);

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
            Thread.sleep(2000);

            driver.close();



        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ConsultaEstadoCuenta (WebDriver driver, Metodos a, EmisionPrimaEmitidaBean emisionPrimaEmitidaBean, int i) throws IOException, InterruptedException{

        try {
            a.changeLastWindows(driver);

            Thread.sleep(2000);


           if (emisionPrimaEmitidaBean.getTipoTerceroTomador() != null){
                Select tipoTercero = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
                Thread.sleep(1500);

                tipoTercero.selectByValue(emisionPrimaEmitidaBean.getTipoTerceroTomador());
            }


            Thread.sleep(5000);

            WebElement primerNombre = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[5]/tbody/tr/td[3]/font/input[1]"));
            primerNombre.sendKeys(emisionPrimaEmitidaBean.getTomadorNombre1());
            Thread.sleep(1000);

            WebElement segundoNombre = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[7]/tbody/tr/td[3]/font/input[1]"));
            segundoNombre.sendKeys(emisionPrimaEmitidaBean.getTomadorNombre2());
            Thread.sleep(1000);

            WebElement primerApellido = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[9]/tbody/tr/td[3]/font/input[1]"));
            primerApellido.sendKeys(emisionPrimaEmitidaBean.getTomadorApellido1());
            Thread.sleep(1000);

            WebElement segundoApellido = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[11]/tbody/tr/td[3]/font/input[1]"));
            segundoApellido.sendKeys(emisionPrimaEmitidaBean.getTomadorApellido2());
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen15", nombreAutomatizacion);

            Thread.sleep(1500);


            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[4]/td/button[1]"));
            btnBuscar.click();

            Thread.sleep(3000);

            WebElement selectTercero = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
            Thread.sleep(1000);
            selectTercero.click();
            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen16", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input"));
            btnAceptar.click();
            Thread.sleep(2000);

            WebElement nroPoliza = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[9]/td[2]/input"));
            Thread.sleep(1000);
            nroPoliza.sendKeys(emisionPrimaEmitidaBean.getNumeroPoliza());
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen17", nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement btnEnviar = driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[2]/tbody/tr/td/input"));
            btnEnviar.click();

            Thread.sleep(3000);

            a.ScreenShotPool(driver, i, "screen18", nombreAutomatizacion);


























        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }




}
