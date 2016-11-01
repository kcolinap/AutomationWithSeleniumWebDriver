package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CrearOpenItemsBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuOperaciones;
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
 * Created by mchurion on 26/10/2016.
 */

public class LBC_CrearOpenItems {

    private final static Logger log = Logger.getLogger(LBC_CrearOpenItemsBean.class);

    public String nombreAutomatizacion = "Crear Open Items LBC";

    public void testLink(LBC_CrearOpenItemsBean lbcCrearOpenItemsBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        LBC_Metodos a = new LBC_Metodos();
        LBC_MenuOperaciones m = new LBC_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        // Busqueda de Siniestro
        m.UAA_ModificacionMovimientosTercero(driver, a, nombreAutomatizacion, 50);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);

        InsertarDatos(a, driver, lbcCrearOpenItemsBean); //Insertar Datos de busqueda

        //Selecciono el Siniestro a consultar
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]")).click();
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        //Presiono el botón Aceptar
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input")).click();

        BorrarFechas(a, driver); //Insertar Datos de busqueda

        //Presiono el botón Insertar
        //Thread.sleep(1000);
        a.cambiarVentana(driver);
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[8]/div/div[3]/div[2]/span[2]/button")).click();
        a.cambiarVentana(driver);
        //a.ScreenShot(driver, "screen9", nombreAutomatizacion);

        FormularioOpenItem(a, driver, lbcCrearOpenItemsBean); //Llenar formulario de Inserción del OpenItem

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


    public void InsertarDatos(AcseleV13_8LBC.main.controller.LBC_Metodos a, WebDriver driver, LBC_CrearOpenItemsBean lbcCrearOpenItemsBean) throws InterruptedException, IOException {
        try {
            Thread.sleep(3000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Selecionar Tipo Tercero

            if (lbcCrearOpenItemsBean.getTipoTercero() != null) {

                WebElement desplegarComboTercero = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select"));
                desplegarComboTercero.click();
                Thread.sleep(1000);

                WebElement seleccionarValorTercero = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select/option[2]"));

                Thread.sleep(1000);
                seleccionarValorTercero.click();
                Thread.sleep(7000);

            }
/*            //Insertar Apellido Paterno
            if (lbcCrearOpenItemsBean.getApellidoPaterno() != null) {
                Thread.sleep(2000);
                Select apellidoPaterno = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[1]/tbody/tr/td[3]/input[1]")));
                apellidoPaterno.selectByValue(lbcCrearOpenItemsBean.getApellidoPaterno());
            }*/
            //Insertar Apellido
            if (lbcCrearOpenItemsBean.getApellidoPaterno() != null) {
                Thread.sleep(2000);
                WebElement apellidoPaterno = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[1]/tbody/tr/td[3]/input[1]"));
                apellidoPaterno.sendKeys(lbcCrearOpenItemsBean.getApellidoPaterno());
            }
            //Insertar Nombre
            if (lbcCrearOpenItemsBean.getPrimerNombre() != null) {
                Thread.sleep(2000);
                WebElement primerNombre = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[3]/tbody/tr/td[3]/input[1]"));
                primerNombre.sendKeys(lbcCrearOpenItemsBean.getPrimerNombre());
            }

            if (lbcCrearOpenItemsBean.getTipoDocIdent() != null) {
                //Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
                Select tipoDoc = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[7]/tbody/tr/td[3]/select")));
                tipoDoc.selectByValue(lbcCrearOpenItemsBean.getTipoDocIdent());
            }

            //Insertar Número de Documento

            if (lbcCrearOpenItemsBean.getNumDocIdent() != null) {
                WebElement numDocumento = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[8]/tbody/tr/td[3]/input[1]"));
                numDocumento.sendKeys(lbcCrearOpenItemsBean.getNumDocIdent());
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


    private void BorrarFechas(LBC_Metodos a, WebDriver driver) {

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

    private void FormularioOpenItem(LBC_Metodos a, WebDriver driver, LBC_CrearOpenItemsBean lbcCrearOpenItemsBean) {
        try {
            //LLenar formulario

            if (lbcCrearOpenItemsBean.getRol2() != null) {

                Select rolOpenItem = new Select(driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[3]/td[2]/select")));
                rolOpenItem.selectByVisibleText(lbcCrearOpenItemsBean.getRol2());
                Thread.sleep(1500);
            }
            if (lbcCrearOpenItemsBean.getConceptoCuenta() != null) {

                Select conceptoCta = new Select(driver.findElement(By.xpath("/[@id=\"inputDTY_ID\"]")));
                conceptoCta.selectByVisibleText(lbcCrearOpenItemsBean.getConceptoCuenta());
                Thread.sleep(1500);
            }

        //Se seleciona la fecha de movimiento
        if (lbcCrearOpenItemsBean.getFechaMov() != null) {
            WebElement fechaMov = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
            fechaMov.sendKeys(lbcCrearOpenItemsBean.getFechaMov());
            Thread.sleep(1000);
        }
            //Se seleciona la fecha de vencimiento
            if (lbcCrearOpenItemsBean.getFechaVencimiento() != null) {
                driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).clear();
                WebElement fechaMov = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[6]/td[2]/input"));
                fechaMov.sendKeys(lbcCrearOpenItemsBean.getFechaVencimiento());
                Thread.sleep(1500);
            }
            //Se seleciona la Moneda
            if (lbcCrearOpenItemsBean.getMoneda() != null) {

                Select moneda = new Select(driver.findElement(By.xpath("/[@id=\"inputCURRENCYID\"]")));
                moneda.selectByVisibleText(lbcCrearOpenItemsBean.getMoneda());
                Thread.sleep(1500);
            }
            //Se ingresa el monto
            if (lbcCrearOpenItemsBean.getMonto() != null) {
                WebElement monto = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));
                monto.sendKeys(lbcCrearOpenItemsBean.getMonto());
                Thread.sleep(1000);
            }
            //Se selecciona el tipo de referencia
            if (lbcCrearOpenItemsBean.getTipoRef() != null) {

                Select tipoRef = new Select(driver.findElement(By.xpath("/[@id=\"inputREFERENCETYPE\"]")));
                tipoRef.selectByVisibleText(lbcCrearOpenItemsBean.getTipoRef());
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