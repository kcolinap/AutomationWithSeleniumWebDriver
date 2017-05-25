package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PagosPorConceptoBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroCrearBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kcolina on 16/05/2017.
 */
public class Asesuisa_PagosPorConcepto extends Asesuisa_SiniestroCrear {

    private final static Logger log = Logger.getLogger(Asesuisa_PagosPorConcepto.class);

    public String nombreAutomatizacion = "Pagos por concepto";
    private WebDriver driver;
    private int siniestroEncontrado=0;

    public void testLink(Asesuisa_PagosPorConceptoBean bean, int i, String folderName) {

        try {

            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menu = new Asesuisa_MenuOperaciones();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(2000);

            //Ingreso a la mantenimiento de Siniestro
            menu.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(1200);

            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Llamada al metodo BuscarSiniestro
            BuscarSiniestro(driver, bean, nombreAutomatizacion, m, i, folderName);
            Thread.sleep(1500);

            if (siniestroEncontrado == 0) {

            } else {
                //Agrego la cobertura
                Asesuisa_SiniestroCrearBean bean2 = new Asesuisa_SiniestroCrearBean();
                AgregarCobertura(driver,bean2,i,m,nombreAutomatizacion,folderName);
                Thread.sleep(1500);
            }

            //Salida
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }

        }
    }

    public void BuscarSiniestro(WebDriver driver, Asesuisa_PagosPorConceptoBean bean,
                                String nombreAutomatizacion, Metodos m, int i, String folderName){
        salidaBusqueda:try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            int camino;
            //Evaluo los campos

            if ( (bean.getNroSiniestro()==null) && (bean.getNroPoliza()==null) && (bean.getFechaOcurrencia()==null) &&
                    (bean.getProducto()==null) ) {
                camino = 1;
            }else if ( (bean.getNroSiniestro()==null) && (bean.getNroPoliza()==null) && (bean.getFechaOcurrencia()==null) &&
                    (bean.getProducto()==null) && (bean.getIdTest().equals("4")) ) {
                camino=2;
            }else {//
                camino=3;
            }


            Thread.sleep(4000);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div/div[3]/div/span")));
            Thread.sleep(2000);

            //boton buscar
            WebElement btnBuscar= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div/div[3]/div/span/span"));
            Thread.sleep(400);

            switch (camino){
                case  1:
                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    btnBuscar.click();
                    // m.waitSearchWicket(driver, "Buscando siniestro");
                    Thread.sleep(2000);

                    if (   (driver.findElements(By.className("v-window-wrap")).size()>0) &&
                            (driver.findElement(By.className("v-window-header")).getText().equals("Mensaje de error"))){
                        System.out.println("El proceso no puede continuar. Al menos un campo debe estar lleno");
                        Thread.sleep(500);

                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                        Thread.sleep(800);

                        siniestroEncontrado=0;
                        break salidaBusqueda;
                    }


                    break;
                case 3:
                    //evaluo los campos que tienen data


                    if(bean.getNroSiniestro()!=null){//Campo nro de siniestro
                        WebElement txtSiniestro;
                        txtSiniestro= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                        txtSiniestro.sendKeys(bean.getNroSiniestro());
                        Thread.sleep(800);
                    }

                    if(bean.getNroPoliza()!=null){//Campo nro de poliza
                        WebElement txtPoliza;
                        txtPoliza= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[8]/input"));
                        txtPoliza.sendKeys(bean.getNroPoliza());
                        Thread.sleep(800);
                    }

                    if(bean.getFechaOcurrencia()!=null){//Campo fecha de ocurrencia
                        WebElement txtFecha;
                        txtFecha= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[6]/div/input"));
                        txtFecha.sendKeys(bean.getFechaOcurrencia());
                        Thread.sleep(800);
                    }

                    if(bean.getProducto()!=null){//Campo producto
                        WebElement txtProducto;
                        txtProducto= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[11]/div/input"));
                        txtProducto.sendKeys(bean.getProducto());
                        Thread.sleep(800);
                    }

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    btnBuscar.click();
                    // m.waitSearchWicket(driver, "Buscando siniestro");
                    Thread.sleep(2000);

                    if (   (driver.findElements(By.className("v-window-wrap")).size()>0) &&
                            (driver.findElement(By.className("v-window-header")).getText().equals("Mensaje"))) {
                        System.out.println("El proceso no puede continuar. El siniestro buscado no existe");
                        Thread.sleep(500);

                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                        Thread.sleep(800);

                        siniestroEncontrado=0;
                        break salidaBusqueda;
                    }

                    Thread.sleep(1000);
                    //Selecciono el siniestro buscado
                    WebElement divSiniestro;
                    divSiniestro=driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/table/tbody/tr/td[1]/div"));
                    divSiniestro.click();
                    Thread.sleep(800);

                    //Valido el estatus del siniestro
                    String lblEstatus = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/table/tbody/tr/td[3]/div")).getText();
                    if (lblEstatus.equals("Rechazado")){
                        System.out.println("Siniestro con estatus: "+lblEstatus+". No se puede continuar con la operacion");
                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                        Thread.sleep(800);
                        siniestroEncontrado=0;
                        break salidaBusqueda;
                    }else if ( lblEstatus.equals("")){
                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                        Thread.sleep(800);
                        siniestroEncontrado=0;
                        break salidaBusqueda;
                    }

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Boton OK
                    WebElement btnOk = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[5]/div/div/div[1]/div/span"));
                    btnOk.click();
                    Thread.sleep(4000);

                    //Pantalla siniestro

                    //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[13]/form[1]/div[2]/input[1]")));
                    Thread.sleep(2000);
                    m.changeLastWindows(driver);
                    Thread.sleep(2000);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Evaluo si hay objeto afectado agregado
                    if ((driver.findElements(By.xpath("html/body/div[13]/form[1]/div[1]/select/option")).size()==0)){
                        System.out.println("No se ha agregado objeto afectado. No se puede continuar con la operacion");
                        siniestroEncontrado=0;
                        break salidaBusqueda;
                    }

                    //Si llega a este punto significa que el siniestro ha sido encontrado, no se
                    //encuentra en rechazo y tiene objeto afectado
                    //se procede a activar centinela para agregar cobertura
                    siniestroEncontrado=1;

                    break;

                default:
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
