package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaOrdenesPagosBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 05/01/2017.
 */
public class INTER_ConsultaOrdenesPagos {

    private final static Logger log = Logger.getLogger(INTER_ConsultaOrdenesPagos.class);

    public String nombreAutomatizacion = "Ordenes Pagos";

    public void testLink(INTER_ConsultaOrdenesPagosBean inter_consultaOrdenesPagosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Interseguros_Metodos a = new Interseguros_Metodos();
        Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_MantenimientoSiniestro(driver, a, nombreAutomatizacion, 3, i);
        Thread.sleep(10000);

        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, inter_consultaOrdenesPagosBean, i);
        ResultadoBusqueda(driver, a, inter_consultaOrdenesPagosBean, i);
        ConsultaPagos(driver, a, inter_consultaOrdenesPagosBean, i);

    }

    public void BuscarPoliza(WebDriver driver, Interseguros_Metodos a, INTER_ConsultaOrdenesPagosBean inter_consultaOrdenesPagosBean, int i) throws IOException, InterruptedException{

        try {

            if (inter_consultaOrdenesPagosBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (inter_consultaOrdenesPagosBean.getOrdenarPor() == "Número de Reclamo"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (inter_consultaOrdenesPagosBean.getOrdenarPor() == "Producto"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (inter_consultaOrdenesPagosBean.getOrdenarPor() == "Fecha de Ocurrencia"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (inter_consultaOrdenesPagosBean.getOrdenarPor() == "Estado del siniestro"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (inter_consultaOrdenesPagosBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numSiniestro.sendKeys(inter_consultaOrdenesPagosBean.getNumeroSiniestro());
            }

            if (inter_consultaOrdenesPagosBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numPoliza.sendKeys(inter_consultaOrdenesPagosBean.getNumeroPoliza());
            }

            if (inter_consultaOrdenesPagosBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaOcurrenciaSiniestro  = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaOcurrenciaSiniestro.sendKeys(inter_consultaOrdenesPagosBean.getFechaOcurrenciaSiniestro());
            }

            String productos = "EducacionGarantizada";

            if (inter_consultaOrdenesPagosBean.getProducto() != null){
                //if (editarSiniestrosBean.getProducto() == productos){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[8]/td/span"));
                producto.click();
                //}
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i,"screen4",nombreAutomatizacion);

            WebElement btnBuscar  = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));
            btnBuscar.click();

            Thread.sleep(4000);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda(WebDriver driver,Interseguros_Metodos a, INTER_ConsultaOrdenesPagosBean inter_consultaOrdenesPagosBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[6]/td[3]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(15000);
            a.changeLastWindows(driver);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void ConsultaPagos(WebDriver driver, Interseguros_Metodos a, INTER_ConsultaOrdenesPagosBean inter_consultaOrdenesPagosBean, int i) {
        try{
            Thread.sleep(1000);
            WebElement btnSelecCover  = driver.findElement(By.xpath("/html/body/div[13]/form[2]/select/option"));
            btnSelecCover.click();


            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);


            WebElement btnPagos = driver.findElement(By.xpath("/html/body/div[13]/form[2]/div[3]/input[6]"));
            btnPagos.click();

            Thread.sleep(1000);
            a.changeLastWindows(driver);

            Thread.sleep(5000);
            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);


        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}
