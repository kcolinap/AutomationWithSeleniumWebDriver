package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaAnularFacturaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aandrade on 24/04/2017.
 */
public class Asesuisa_CajaAnularFactura {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaAnularFactura.class);

    public String nombreAutomatizacion = "Asesuisa Caja Anular Factura";
    private WebDriver driver;
    Metodos a = new Metodos();

    public void testLink(Asesuisa_CajaAnularFacturaBean bean, int i, String folderName){

        try {

            // Instanciando clases
            //Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando primero en el Menu de Inicio de Sesion
            menuOperaciones.UAA_Caja_InicioSesion(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            driver.close();
            a.regresarVentana(driver);
            //Entrando en Menu de Facturas Generadas
            menuOperaciones.UAA_Caja_ConsultaFacturasGeneradas(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Anular Factura Caja*/

            AnularFacturaCaja(bean, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(5000);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void AnularFacturaCaja(Asesuisa_CajaAnularFacturaBean bean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        int tamanotr, numpagina;
        String texto = null;
        String texto1 = null;
        String fechastring = null;
        WebElement indextr;
        boolean anulacion = false;
        int dias;

        try {
            Thread.sleep(3000);
            // Seleccionar el boton Buscar
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span")).click();
            Thread.sleep(2000);
            // Obtiene el total de paginas mostradas
            numpagina = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[3]/div/div/div[2]/div/div[11]/div")).getText());

            for (int l = 1; l < (numpagina); l++){

                // Busca las facturas que esten en estado "Valida"
                tamanotr = driver.findElements(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[3]/div[1]/table/tbody/tr")).size();
                for (int j = 1; j < (tamanotr + 1); j++) {
                    indextr = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[8]/div"));
                    texto = indextr.getText();

                    // Verifica que la fecha de emision sea menor a 30 dias de la fecha acual
                    // Fecha de emision
                    fechastring = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[2]/div")).getText();
                    DateFormat fechaHora = new SimpleDateFormat("dd-MM-yyyy");
                    Date convertido = fechaHora.parse(fechastring);
                    // Fecha Actual
                    java.util.Date date = new java.util.Date();
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
                    // Calcula el nuemro de dias
                    dias=(int) ((date.getTime()-convertido.getTime())/86400000);

                    // Si la factura es Valida y la fecha de emision es menor a 30 dias
                    if (texto.equals("Valida") && dias <= 30) {
                        // Selecciona la linea de la tabla a Anular
                        indextr.click();
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                        Thread.sleep(2000);

                        // Si selecciona la opcion ANULAR
                        if(bean.getAnular() != null) {
                            // Selecciona el boton Anular
                            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[5]/div/span")).click();
                            Thread.sleep(2000);

                                // Si la razon de anulacion no esta en blanco
                                if (bean.getRazon() != null) {

                                    // Click a la lista Razon de Anulacion
                                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[3]/div/div")).click();

                                    // Selecciona la razon de anulacion
                                    Thread.sleep(1000);
                                    tamanotr = driver.findElements(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr")).size();
                                    for (int k = 1; k < tamanotr; k++) {
                                        indextr = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[" + k + "]/td/span"));
                                        texto1 = indextr.getText();

                                        if (bean.getRazon().equals(texto1)) {
                                            indextr.click();
                                            Thread.sleep(2000);
                                            break;
                                        }
                                    }
                                }

                                // Selecciona Generar Nota de Credito Si
                                Thread.sleep(1000);
                                if (bean.getGenerar().equals("Si")) {
                                    driver.findElement(By.xpath("//*[@id=\"gwt-uid-48\"]")).click();
                                }
                                // Selecciona Generar Nota de Credito No
                                else if (bean.getGenerar().equals("No")) {
                                    driver.findElement(By.xpath("//*[@id=\"gwt-uid-49\"]")).click();
                                }

                                Thread.sleep(1000);
                                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                                Thread.sleep(1000);


                                // Selecciona primer Boton Aceptar
                                if (bean.getAceptar1().equals("Si")) {
                                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[5]/div/div[1]/div")).click();
                                    // Si la razon de anulacion no esta en blanco
                                    if (bean.getRazon() != null) {

                                        // Selecciona segundo Boton Aceptar
                                        Thread.sleep(1000);
                                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                                        Thread.sleep(1000);
                                        if (bean.getAceptar2().equals("Si")) {
                                            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div/div[3]/div/div[1]/button")).click();
                                        }
                                        // Selecciona segundo Boton Cancelar
                                        else {
                                            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div/div[3]/div/div[2]/button")).click();
                                        }
                                    }

                                }
                                // Selecciona primer Boton Cancelar
                                else {
                                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[5]/div/div[3]/div")).click();
                                }
                        }
                        // Si Anular esta vacio
                        else {
                            // Selecciona el boton Ver detalle
                            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[1]/div/span")).click();
                            Thread.sleep(2000);

                        }

                        // Muestra el resultado de la operacion
                        Thread.sleep(5000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                        anulacion = true;
                            break;
                    }

                }

                if (anulacion || l == numpagina) {
                    break; }
                else {
                    //Avanza a la siguiente pagina
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[3]/div/div/div[2]/div/div[13]/div/span")).click();
                    Thread.sleep(2000);
                }
            } // for
        } catch (Exception e) {

            try {
                a.ScreenShotPool(driver, i, "error AnularFacturaCaja", nombreAutomatizacion, folderName);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
