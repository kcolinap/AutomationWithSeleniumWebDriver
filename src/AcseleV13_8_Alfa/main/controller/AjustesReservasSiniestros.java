package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.AjustesReservasSiniestrosBean;
import AcseleV13_8_Alfa.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by rmontilla on 19/09/2016.
 */
public class AjustesReservasSiniestros {

    private final static Logger log = Logger.getLogger(AjustesReservasSiniestros.class);

    public String nombreAutomatizacion = "Ajustes a las Reservas de Siniestros";

    public void testLink(AjustesReservasSiniestrosBean ajustesReservasSiniestrosBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones menuOperaciones = new MenuOperaciones();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion);

            a.ValidandoSesion(driver, nombreAutomatizacion);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion);

            //
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaSiniestro(driver, ajustesReservasSiniestrosBean, a, i);
            ResultadoBusqueda(driver, ajustesReservasSiniestrosBean, a, i);
            ConsultaReserva(driver, ajustesReservasSiniestrosBean, a, i);
            AjusteReserva(driver, ajustesReservasSiniestrosBean, a, i);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }



    public void BusquedaSiniestro (WebDriver driver, AjustesReservasSiniestrosBean ajustesReservasSiniestrosBean, Metodos a, int i) throws InterruptedException, IOException {

        try{
            if (ajustesReservasSiniestrosBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (ajustesReservasSiniestrosBean.getOrdenarPor().equals("Número de Reclamo")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (ajustesReservasSiniestrosBean.getOrdenarPor().equals("Producto")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (ajustesReservasSiniestrosBean.getOrdenarPor().equals("Fecha de Ocurrencia")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (ajustesReservasSiniestrosBean.getOrdenarPor().equals("Estado del siniestro")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (ajustesReservasSiniestrosBean.getNumSiniestro() != null){
                Thread.sleep(1000);
                WebElement numSiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                numSiniestro.sendKeys(ajustesReservasSiniestrosBean.getNumSiniestro());
            }

            if (ajustesReservasSiniestrosBean.getNumPoliza() != null){
                Thread.sleep(1000);
                WebElement numPoliza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[8]/input"));
                numPoliza.sendKeys(ajustesReservasSiniestrosBean.getNumPoliza());
            }

            if (ajustesReservasSiniestrosBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(1000);
                WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[6]/div/input"));
                fechaOcurrenciaSiniestro.sendKeys(ajustesReservasSiniestrosBean.getFechaOcurrenciaSiniestro());


            }

            String productos = "VidaDeudoresAvVillas";

            if (ajustesReservasSiniestrosBean.getProducto() != null){
                //if (editarSiniestrosBean.getProducto() == productos){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                producto.click();
                //}
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div/div[3]/div/span/span"));
            btnBuscar.click();

            Thread.sleep(4000);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


    private void ResultadoBusqueda(WebDriver driver, AjustesReservasSiniestrosBean ajustesReservasSiniestrosBean, Metodos a, int i) {
        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(1000);
            a.changeLastWindows(driver);


        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void ConsultaReserva(WebDriver driver, AjustesReservasSiniestrosBean ajustesReservasSiniestrosBean, Metodos a, int i) {
        try{
            Thread.sleep(10000);
            WebElement btnSeleccionarCover  = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            btnSeleccionarCover.click();

            Thread.sleep(5000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnReserva = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_08\"]"));
            btnReserva.click();

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void AjusteReserva(WebDriver driver, AjustesReservasSiniestrosBean ajustesReservasSiniestrosBean, Metodos a, int i) {
        try{
            Thread.sleep(15000);
            WebElement btnAgregarAjuste = driver.findElement(By.xpath("//*[@id=\"idb_0402006_editReverse_02\"]"));
            btnAgregarAjuste.click();
            //->/html/body/div[14]/div[2]/form/table/tbody[3]/tr[9]/td/center/input[1]

            Thread.sleep(15000);
            for (int x = 1; x < 100 ; x++){

                WebElement razonAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + x + "]/td[5]/textarea"));
                if (razonAjuste.isEnabled()){

                    //Tipo Ajuste
                    if (ajustesReservasSiniestrosBean.getTipoAjuste() != null){
                        Thread.sleep(5000);

                        Select tipo = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + x + "]/td[1]/select")));

                        if (ajustesReservasSiniestrosBean.getTipoAjuste().toUpperCase().equals("INCREMENTO")){
                            Thread.sleep(2000);
                            tipo.selectByValue("1");
                        }

                        if (ajustesReservasSiniestrosBean.getTipoAjuste().toUpperCase().equals("DECREMENTO")) {
                            Thread.sleep(2000);
                            tipo.selectByValue("2");
                        }
                    }

                    // Razon Ajuste

                    if (ajustesReservasSiniestrosBean.getRazonAjuste() != null){
                        Thread.sleep(2000);
                        razonAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + x + "]/td[5]/textarea"));
                        razonAjuste.sendKeys(ajustesReservasSiniestrosBean.getRazonAjuste());
                    }

                    // Monto Ajuste

                    if (ajustesReservasSiniestrosBean.getMontoAjuste() != null){
                        Thread.sleep(2000);
                        WebElement montoAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[" + x + "]/td[6]/input[1]"));
                        montoAjuste.clear();
                        montoAjuste.sendKeys(ajustesReservasSiniestrosBean.getMontoAjuste());
                    }
                    break;
                }
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_editReverse_03\"]"));
            btnAceptar.click();

                Thread.sleep(2000);
            a.changeLastWindows(driver);

            Thread.sleep(15000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
