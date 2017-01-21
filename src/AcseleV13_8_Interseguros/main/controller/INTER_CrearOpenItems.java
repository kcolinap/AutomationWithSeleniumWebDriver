package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_CrearOpenItemsBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 19/01/2017.
 */
public class INTER_CrearOpenItems {
    private final static Logger log = Logger.getLogger(INTER_CrearOpenItemsBean.class);

    public String nombreAutomatizacion = "Crear Open Items INTER";

    public void testLink(INTER_CrearOpenItemsBean interCrearOpenItemsBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        Interseguros_Metodos a = new Interseguros_Metodos();
        Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(4000);

        // Busqueda de Siniestro
        m.UAA_ModificacionMovimientosTercero(driver, a, nombreAutomatizacion, 50);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);

        InsertarDatos(a, driver, interCrearOpenItemsBean); //Insertar Datos de busqueda

        //Selecciono el Siniestro a consultar
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]")).click();
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        //Presiono el botón Aceptar
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[3]/td/input")).click();

        BorrarFechas(a, driver); //Insertar Datos de busqueda

        //Presiono el botón Insertar
        //Thread.sleep(1000);
        a.cambiarVentana(driver);
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[8]/div/div[3]/div[2]/span[2]/button")).click();
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        //a.ScreenShot(driver, "screen9", nombreAutomatizacion);

        FormularioOpenItem(a, driver, interCrearOpenItemsBean); //Llenar formulario de Inserción del OpenItem

        //Presiono el botón Insertar OpenItem
        driver.findElement(By.xpath("//*[@id=\"idb_040203715_thirdPartyMovsInsert_01\"]")).click();
        Thread.sleep(1500);
        //a.ScreenShot(driver, "screen10", nombreAutomatizacion);
        if (ExpectedConditions.alertIsPresent() != null) {
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(1000);
            driver.switchTo().defaultContent();
        }
        a.ScreenShot(driver, "screen10", nombreAutomatizacion);
        Thread.sleep(1000);


    }


    public void InsertarDatos(AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos a, WebDriver driver, INTER_CrearOpenItemsBean interCrearOpenItemsBean) throws InterruptedException, IOException {
        try {
            Thread.sleep(3000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Selecionar Tipo Tercero

            if (interCrearOpenItemsBean.getTipoTercero() != null) {

                WebElement desplegarComboTercero = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select"));
                desplegarComboTercero.click();
                Thread.sleep(1000);

                WebElement seleccionarValorTercero = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select/option[3]"));

                Thread.sleep(1000);
                seleccionarValorTercero.click();
                Thread.sleep(5000);

            }

            //Insertar Apellido
            if (interCrearOpenItemsBean.getApellidoPaterno() != null) {
                Thread.sleep(2000);
                WebElement apellidoPaterno = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[13]/tbody/tr/td[2]/font/input[1]"));
                apellidoPaterno.sendKeys(interCrearOpenItemsBean.getApellidoPaterno());
            }
            //Insertar Nombre
            if (interCrearOpenItemsBean.getPrimerNombre() != null) {
                Thread.sleep(2000);
                WebElement primerNombre = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[15]/tbody/tr/td[2]/font/input[1]"));
                primerNombre.sendKeys(interCrearOpenItemsBean.getPrimerNombre());
            }

            if (interCrearOpenItemsBean.getTipoDocIdent() != null) {
                Thread.sleep(1000);
                Select tipoDoc = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[7]/tbody/tr/td[3]/select")));
                tipoDoc.selectByValue(interCrearOpenItemsBean.getTipoDocIdent());
            }

            //Insertar Número de Documento

            if (interCrearOpenItemsBean.getNumDocIdent() != null) {
                WebElement numDocumento = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[8]/tbody/tr/td[3]/input[1]"));
                numDocumento.sendKeys(interCrearOpenItemsBean.getNumDocIdent());
            }

            Thread.sleep(2000);

            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }
        catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Crear Open Items LBC - " + e);
        }

        //Presiono el botón Buscar
        driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForStatementAccount_01\"]")).click();
        a.cambiarVentana(driver);
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Thread.sleep(2000);
    }


    private void BorrarFechas(Interseguros_Metodos a, WebDriver driver) {

        try {
            Thread.sleep(3000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Borrar fechas y procesar
            driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[5]/td[2]/input[1]")).clear();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[6]/td[2]/input[1]")).clear();
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);


            driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]")).click();
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Crear Open Items - " + e);
        }
    }

    private void FormularioOpenItem(Interseguros_Metodos a, WebDriver driver, INTER_CrearOpenItemsBean interCrearOpenItemsBean) {
        try {
            //LLenar formulario

            if (interCrearOpenItemsBean.getRol2() != null) {

                Select rolOpenItem = new Select(driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[3]/td[2]/select")));
                rolOpenItem.selectByVisibleText(interCrearOpenItemsBean.getRol2());
                Thread.sleep(1500);
            }
            if (interCrearOpenItemsBean.getConceptoCuenta() != null) {

                Select conceptoCta = new Select(driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[4]/td[2]/select")));
                conceptoCta.selectByVisibleText(interCrearOpenItemsBean.getConceptoCuenta());
                Thread.sleep(1500);
            }

/*        //Se seleciona la fecha de movimiento
        if (lbcCrearOpenItemsBean.getFechaMov() != null) {
            WebElement fechaMov = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
            fechaMov.sendKeys(lbcCrearOpenItemsBean.getFechaMov());
            Thread.sleep(1500);
        }*/
            //Se seleciona la fecha de vencimiento
            if (interCrearOpenItemsBean.getFechaVencimiento() != null) {
                driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).clear();
                WebElement fechaMov = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[6]/td[2]/input"));
                fechaMov.sendKeys(interCrearOpenItemsBean.getFechaVencimiento());
                Thread.sleep(1500);
            }

            //Se seleciona la Moneda
            if (interCrearOpenItemsBean.getMoneda() != null) {

                Select moneda = new Select(driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[7]/td[2]/select")));
                moneda.selectByVisibleText(interCrearOpenItemsBean.getMoneda());
                Thread.sleep(1500);
            }

            //Se ingresa el monto
            if (interCrearOpenItemsBean.getMonto() != null) {
                WebElement monto = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));
                monto.sendKeys(interCrearOpenItemsBean.getMonto());
                Thread.sleep(1000);
            }
            //Se selecciona el tipo de referencia
            if (interCrearOpenItemsBean.getTipoRef() != null) {

                Select tipoRef = new Select(driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[10]/td[2]/select")));
                tipoRef.selectByVisibleText(interCrearOpenItemsBean.getTipoRef());
                Thread.sleep(1500);
                a.ScreenShot(driver, "screen9", nombreAutomatizacion);
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info(e);
            log.info("Test Case ?? - Crear Open Items - " + e);
        }

    }

}
