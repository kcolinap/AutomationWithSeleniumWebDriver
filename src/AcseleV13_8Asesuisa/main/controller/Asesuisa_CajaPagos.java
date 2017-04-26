package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaPagosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aandrade on 26/04/2017.
 */
public class Asesuisa_CajaPagos {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaPagos.class);

    public String nombreAutomatizacion = "Asesuisa Caja Pagos";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaPagosBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
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
            menuOperaciones.UAA_Caja_ColeccionDeProcesos(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Pagos Caja*/

            PagosCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(5000);

            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }

    public void PagosCaja(Asesuisa_CajaPagosBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        int tamanotr, numpagina;
        String texto = null;
        String texto1 = null;
        WebElement indextr;

        try {

            // Ingresa Poliza a gestionar y presiona el boton Aceptar
            WebElement descripcion = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/form/table/tbody/tr[4]/td[2]/input"));
            descripcion.sendKeys(bean.getPoliza());
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_thirdPartySelection_01\"]")).click();
            Thread.sleep(1000);

            // ***** Pestaña Seleccion de tercero *****
            // Tipo de transaccion
            Select aatipotran = new Select(driver.findElement(By.xpath("//select[@name='transactionType']")));
            aatipotran.selectByVisibleText("Pago");
            //aatipotran.selectByValue("1");
            Thread.sleep(1000);
            // Selecciona Radio Boton ID del Tercero
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td/table/tbody/tr/td/form/table[2]/tbody/tr[4]/td[1]/input")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Clic en Boton Seleccione el tercero
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_thirdPartySelection_02\"]")).click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            // ***** Pestaña  Estado de cuenta *****
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[7]/a")).click();
            Thread.sleep(1000);
            // Selecciona la cuota
            driver.findElement(By.xpath("//*[@id=\"openItemID22050\"]")).click();
            Thread.sleep(1000);
            // Selecciona el boton Aceptar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_statementAccount_01\"]")).click();
            Thread.sleep(1000);


            // ***** Pestaña  Ingreso de caja *****
            driver.findElement(By.xpath("//*[@id=\"link_caja\"]/a")).click();
            Thread.sleep(1000);
            // Clic al check Tipo de pago
            driver.findElement(By.xpath("//*[@id=\"cashierRegisterForm\"]/table/tbody/tr[3]/td[1]/input")).click();
            // Selecciona el Tipo de Pago
            Select aatipopago = new Select(driver.findElement(By.xpath("//*[@id=\"cashierRegisterForm\"]/table/tbody/tr[3]/td[2]/select")));
            aatipopago.selectByVisibleText("Efectivo");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Selecciona el boton Aceptar
            driver.findElement(By.xpath("//*[@id=\"idb_040203703_cashierRegisterReception_01\"]")).click();
            Thread.sleep(2000);









/*
            Thread.sleep(1000);
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
                    if (texto.equals("Valida")) {
                        // Selecciona la linea de la tabla a Anular
                        indextr.click();
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                        Thread.sleep(2000);

                        // Selecciona el boton Anular
                        driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[9]/div/div[5]/div/span")).click();
                        Thread.sleep(2000);

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
                        // Selecciona primer Boton Cancelar
                        else {
                            driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[5]/div/div[3]/div")).click();
                        }

                        // Muestra el resultado de la operacion
                        Thread.sleep(5000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                        break;
                    }

                }

                if (texto.equals("Valida") || l == numpagina) {
                    break; }
                else {
                    //Avanza a la siguiente pagina
                    driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287\"]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[3]/div/div/div[2]/div/div[13]/div/span")).click();
                    Thread.sleep(2000);
                }
            }
            */
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
