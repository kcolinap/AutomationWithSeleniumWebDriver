package main.controller;

import beans.CreacionSiniestrosBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 27/07/2016.
 */
public class CreacionSiniestros {

    private final static Logger log = Logger.getLogger(CreacionSiniestros.class);

    public String nombreAutomatizacion = "Creacion Siniestros";

    public void testLink(CreacionSiniestrosBean creacionSiniestrosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        MenuCreacionSiniestro(driver, a);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarPoliza(driver,a,creacionSiniestrosBean);
        ResultadoBusqueda(driver,a,creacionSiniestrosBean);
        AgregarObjetoAfectado(driver,a,creacionSiniestrosBean);
    }

    public void MenuCreacionSiniestro(WebDriver driver,Metodos a) throws IOException, InterruptedException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));//operaciones siniestros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[10]/div[6]"));//crear siniestro

        menu1.click();
        menu2.click();
        Thread.sleep(1000);
        a.ScreenShot(driver,"screen3",nombreAutomatizacion);
        menu3.click();
    }

    public void BuscarPoliza(WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean) throws IOException, InterruptedException{

        try {

            if (creacionSiniestrosBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(creacionSiniestrosBean.getOrdenarPor());
            }
            if (creacionSiniestrosBean.getProducto() != null){
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));
                producto.selectByValue(creacionSiniestrosBean.getProducto());
                Thread.sleep(8000);
            }

            if (creacionSiniestrosBean.getEstadosCicloVida() != null){
                Select estadosCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));
                estadosCicloVida.selectByValue(creacionSiniestrosBean.getEstadosCicloVida());
            }

            if (creacionSiniestrosBean.getContratante() != null){
                WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(creacionSiniestrosBean.getContratante());
            }

            if (creacionSiniestrosBean.getAsegurado() != null){
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(creacionSiniestrosBean.getAsegurado());
            }

            if (creacionSiniestrosBean.getIdPoliza() != null){
                WebElement idPoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]" ));
                idPoliza.sendKeys(creacionSiniestrosBean.getIdPoliza());
            }

            if (creacionSiniestrosBean.getFechaDesde() != null){
                WebElement fechaDesde = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]" ));
                fechaDesde.sendKeys(creacionSiniestrosBean.getFechaDesde());
            }

            if (creacionSiniestrosBean.getSucursalPoliza() != null){
                Select sucursalPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1829934\"]/td[3]/font/select")));
                sucursalPoliza.selectByValue(creacionSiniestrosBean.getSucursalPoliza());
            }

            if (creacionSiniestrosBean.getNumeroPoliza() != null){
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"1829814\"]/td[3]/font/input[1]" ));
                numeroPoliza.sendKeys(creacionSiniestrosBean.getNumeroPoliza());
            }

            if (creacionSiniestrosBean.getFechaEmision() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//*[@id=\"1829854\"]/td[3]/font/input[1]" ));
                fechaEmision.sendKeys(creacionSiniestrosBean.getFechaEmision());
            }

            if (creacionSiniestrosBean.getMonedaPoliza() != null){
                Select monedaPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1828494\"]/td[3]/font/select")));
                monedaPoliza.selectByValue(creacionSiniestrosBean.getMonedaPoliza());
            }

            if (creacionSiniestrosBean.getTipoProduccion() != null){
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//*[@id=\"1829894\"]/td[3]/font/select")));
                tipoProduccion.selectByValue(creacionSiniestrosBean.getTipoProduccion());
            }

            if (creacionSiniestrosBean.getTipoVigencia() != null){
                Select tipoVigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830014\"]/td[3]/font/select")));
                tipoVigencia.selectByValue(creacionSiniestrosBean.getTipoVigencia());
            }

            if (creacionSiniestrosBean.getVigencia() != null){
                Select vigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830054\"]/td[3]/font/select")));
                vigencia.selectByValue(creacionSiniestrosBean.getVigencia());
            }

            if (creacionSiniestrosBean.getCanalVenta() != null){
                Select canalVenta = new Select(driver.findElement(By.xpath("//*[@id=\"1933894\"]/td[3]/font/select")));
                canalVenta.selectByValue(creacionSiniestrosBean.getCanalVenta());
            }

            if (creacionSiniestrosBean.getFrecuenciaPago() != null){
                Select frecuenciaPago = new Select(driver.findElement(By.xpath("//*[@id=\"1830294\"]/td[3]/font/select")));
                frecuenciaPago.selectByValue(creacionSiniestrosBean.getFrecuenciaPago());
            }

            if (creacionSiniestrosBean.getFechaEventoAnterior() != null){
                WebElement fechaEventoAnterior = driver.findElement(By.xpath("//*[@id=\"1933934\"]/td[3]/font/input[1]" ));
                fechaEventoAnterior.sendKeys(creacionSiniestrosBean.getFechaEventoAnterior());
            }

            if (creacionSiniestrosBean.getFechaProximaGeneracionPrima() != null){
                WebElement fechaProximaGeneracionPrima = driver.findElement(By.xpath("//*[@id=\"1830374\"]/td[3]/font/input[1]" ));
                fechaProximaGeneracionPrima.sendKeys(creacionSiniestrosBean.getFechaProximaGeneracionPrima());
            }

            if (creacionSiniestrosBean.getFechaProximaFacturacion() != null){
                WebElement fechaProximaFacturacion = driver.findElement(By.xpath("//*[@id=\"1830214\"]/td[3]/font/input[1]" ));
                fechaProximaFacturacion.sendKeys(creacionSiniestrosBean.getFechaProximaFacturacion());
            }

            if (creacionSiniestrosBean.getTipoPoliza() != null){
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"2878614\"]/td[3]/font/select")));
                tipoPoliza.selectByValue(creacionSiniestrosBean.getTipoPoliza());
            }

            if (creacionSiniestrosBean.getNumeroCotizacion() != null){
                WebElement numeroCotizacion = driver.findElement(By.xpath("//*[@id=\"9480594\"]/td[3]/font/input[1]" ));
                numeroCotizacion.sendKeys(creacionSiniestrosBean.getNumeroCotizacion());
            }

            if (creacionSiniestrosBean.getNumeroPropuesta() != null){
                WebElement numeroPropuesta = driver.findElement(By.xpath("//*[@id=\"9452594\"]/td[3]/font/input[1]" ));
                numeroPropuesta.sendKeys(creacionSiniestrosBean.getNumeroPropuesta());
            }

            if (creacionSiniestrosBean.getTipoMoneda() != null){
                Select tipoMoneda = new Select(driver.findElement(By.xpath("//*[@id=\"29008194\"]/td[3]/font/select")));
                tipoMoneda.selectByValue(creacionSiniestrosBean.getTipoMoneda());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformpolicy_01\"]"));
            btnBuscar.click();

            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda (WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean){
        try {
            Thread.sleep(2000);
            WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr/td[2]/input[4]"));
            fechaOcurrenciaSiniestro.sendKeys(creacionSiniestrosBean.getFechaOcurrenciaSiniestro());

            Thread.sleep(2000);
            Select sucursalSiniestros = new Select(driver.findElement(By.xpath("//*[@id=\"userAgency\"]")));
            sucursalSiniestros.selectByValue(creacionSiniestrosBean.getSucursalSiniestros());

            // Cambiar de frame
            driver.switchTo().frame("frameData");
            WebElement btnSeleccionarPoliza = driver.findElement(By.xpath("//*[@id=\"form1\"]/table/tbody/tr/td[1]/input"));
            btnSeleccionarPoliza.click();
            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);

            WebElement btnSelecUnidadesRiesgo = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_02\"]"));
            btnSelecUnidadesRiesgo.click();

            Thread.sleep(7000);

            WebElement selecUnidadRiesgo = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[5]/td[1]/input"));
            selecUnidadRiesgo.click();

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen6",nombreAutomatizacion);

            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_selectRiskUnitToClaim_05\"]"));
            btnEnviar.click();

            Thread.sleep(10000);


            WebElement btnSelecEvento = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_03\"]"));
            btnSelecEvento.click();

            Thread.sleep(5000);

            WebElement selecEvento = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[4]/td[1]/input"));
            selecEvento.click();

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen7",nombreAutomatizacion);

            btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_policyEventsToClaim_01\"]"));
            btnEnviar.click();

            Thread.sleep(8000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_07\"]"));
            btnAceptar.click();

            Thread.sleep(10000);
            a.ScreenShot(driver,"screen8",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean){
       try {
           WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
           btnAgregar.click();

           Select horaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"1837254\"]/td[3]/font/select")));
           horaOcurrencia.selectByValue(creacionSiniestrosBean.getHoraOcurrencia());

           WebElement fechaAvisoCompania = driver.findElement(By.xpath("//*[@id=\"1837174\"]/td[3]/font/input[1]"));
           fechaAvisoCompania.sendKeys(creacionSiniestrosBean.getFechaAvisoCompania());

           Select horaNotificacion = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
           horaNotificacion.selectByValue(creacionSiniestrosBean.getHoraNotificacion());

           WebElement fechaReclFormalizacion = driver.findElement(By.xpath("//*[@id=\"28932594\"]/td[3]/font/input[1]"));
           fechaReclFormalizacion.sendKeys(creacionSiniestrosBean.getFechaReclFormalizacion());

           WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"30022594\"]/td[3]/font/input[1]"));
           fechaInterrupcionTerminos.sendKeys(creacionSiniestrosBean.getFechaInterrupcionTerminos());

           WebElement reclamante = driver.findElement(By.xpath("//*[@id=\"23937694\"]/td[3]/font/input[1]"));
           reclamante.sendKeys(creacionSiniestrosBean.getReclamante());

           Select causaMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"23854894\"]/td[3]/font/select")));
           causaMuerte.selectByValue(creacionSiniestrosBean.getCausaMuerte());

           Select causalesCoberturaMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"29997794\"]/td[3]/font/select")));
           causalesCoberturaMuerte.selectByValue(creacionSiniestrosBean.getCausalesCoberturaMuerte());

           Select departamento = new Select(driver.findElement(By.xpath("//*[@id=\"1934614\"]/td[3]/font/select")));
           departamento.selectByValue(creacionSiniestrosBean.getDepartamento());

           Select ciudad = new Select(driver.findElement(By.xpath("//*[@id=\"9508794\"]/td[3]/font/select")));
           ciudad.selectByValue(creacionSiniestrosBean.getCiudad());

           Select actividadSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"30018694\"]/td[3]/font/select")));
           actividadSiniestro.selectByValue(creacionSiniestrosBean.getActividadSiniestro());

           WebElement fechaActividad = driver.findElement(By.xpath("//*[@id=\"30018794\"]/td[3]/font/input[1]"));
           fechaActividad.sendKeys(creacionSiniestrosBean.getFechaActividad());

           WebElement observacionesSiniestro = driver.findElement(By.xpath("//*[@id=\"3746174\"]/td[3]/font/textarea"));
           observacionesSiniestro.sendKeys(creacionSiniestrosBean.getObservacionesSiniestro());

           




















    }catch (Exception e) {
        e.printStackTrace();
//                log.info(e);
        log.info("Test Case - " + nombreAutomatizacion + " - " + e);
    }
}




}
