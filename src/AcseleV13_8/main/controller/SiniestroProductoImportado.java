package AcseleV13_8.main.controller;
import AcseleV13_8.beans.SiniestroProductoImportadoBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by kzambrano on 27/09/2016.
 */
public class SiniestroProductoImportado {

    private final static Logger log = Logger.getLogger(SiniestroProductoImportado.class);

    public String nombreAutomatizacion = "Siniestro con Producto Importado";

    public void testLink(SiniestroProductoImportadoBean siniestroProductoImportadoBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_CreacionSiniestro(driver, a, nombreAutomatizacion,3, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, siniestroProductoImportadoBean,i);
        ResultadoBusqueda(driver, a, siniestroProductoImportadoBean, i);
        AgregarObjetoAfectado(driver, a, siniestroProductoImportadoBean, i);
        AgregarCobertura(driver, a, siniestroProductoImportadoBean, i);

    }

    public void BuscarPoliza(WebDriver driver, Metodos a, SiniestroProductoImportadoBean siniestroProductoImportadoBean, int i) throws IOException, InterruptedException{

        try {

            if (siniestroProductoImportadoBean.getOrdenarPor() != null){
                Thread.sleep(2000);
                Select ordenarPor = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(siniestroProductoImportadoBean.getOrdenarPor());
            }
            if (siniestroProductoImportadoBean.getProducto() != null){
                Thread.sleep(2000);
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));
                producto.selectByValue(siniestroProductoImportadoBean.getProducto());
                Thread.sleep(8000);
            }

            if (siniestroProductoImportadoBean.getEstadosCicloVida() != null){
                Thread.sleep(2000);
                Select estadosCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));
                estadosCicloVida.selectByValue(siniestroProductoImportadoBean.getEstadosCicloVida());
            }

            if (siniestroProductoImportadoBean.getContratante() != null){
                Thread.sleep(2000);
                WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(siniestroProductoImportadoBean.getContratante());
            }

            if (siniestroProductoImportadoBean.getAsegurado() != null){
                Thread.sleep(2000);
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(siniestroProductoImportadoBean.getAsegurado());
            }

            if (siniestroProductoImportadoBean.getIdPoliza() != null){
                Thread.sleep(2000);
                WebElement idPoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]" ));
                idPoliza.sendKeys(siniestroProductoImportadoBean.getIdPoliza());
            }

            if (siniestroProductoImportadoBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]" ));
                fechaDesde.sendKeys(siniestroProductoImportadoBean.getFechaDesde());
            }

            if (siniestroProductoImportadoBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("//*[@id=\"_toDateShow\"]" ));
                fechaHasta.sendKeys(siniestroProductoImportadoBean.getFechaHasta());
            }

            if (siniestroProductoImportadoBean.getSucursalPoliza() != null){
                Thread.sleep(2000);
                Select sucursalPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1829934\"]/td[3]/font/select")));
                sucursalPoliza.selectByValue(siniestroProductoImportadoBean.getSucursalPoliza());
            }

            if (siniestroProductoImportadoBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"1829814\"]/td[3]/font/input[1]" ));
                numeroPoliza.sendKeys(siniestroProductoImportadoBean.getNumeroPoliza());
            }

            if (siniestroProductoImportadoBean.getFechaEmision() != null){
                Thread.sleep(2000);
                WebElement fechaEmision = driver.findElement(By.xpath("//*[@id=\"1829854\"]/td[3]/font/input[1]" ));
                fechaEmision.sendKeys(siniestroProductoImportadoBean.getFechaEmision());
            }

            if (siniestroProductoImportadoBean.getMonedaPoliza() != null){
                Thread.sleep(2000);
                Select monedaPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1828494\"]/td[3]/font/select")));
                monedaPoliza.selectByValue(siniestroProductoImportadoBean.getMonedaPoliza());
            }

            if (siniestroProductoImportadoBean.getTipoMonedaPoliza() != null){
                Thread.sleep(2000);
                Select tipoMonedaPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"30598294\"]/td[3]/font/select")));
                tipoMonedaPoliza.selectByValue(siniestroProductoImportadoBean.getTipoMonedaPoliza());
            }

            if (siniestroProductoImportadoBean.getTipoProduccion() != null){
                Thread.sleep(2000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//*[@id=\"1829894\"]/td[3]/font/select")));
                tipoProduccion.selectByValue(siniestroProductoImportadoBean.getTipoProduccion());
            }

            if (siniestroProductoImportadoBean.getTipoVigencia() != null){
                Thread.sleep(2000);
                Select tipoVigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830014\"]/td[3]/font/select")));
                tipoVigencia.selectByValue(siniestroProductoImportadoBean.getTipoVigencia());
            }

            if (siniestroProductoImportadoBean.getVigencia() != null){
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830054\"]/td[3]/font/select")));
                vigencia.selectByValue(siniestroProductoImportadoBean.getVigencia());
            }

            if (siniestroProductoImportadoBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//*[@id=\"1933894\"]/td[3]/font/select")));
                canalVenta.selectByValue(siniestroProductoImportadoBean.getCanalVenta());
            }

            if (siniestroProductoImportadoBean.getFrecuenciaPago() != null){
                Thread.sleep(2000);
                Select frecuenciaPago = new Select(driver.findElement(By.xpath("//*[@id=\"1830294\"]/td[3]/font/select")));
                frecuenciaPago.selectByValue(siniestroProductoImportadoBean.getFrecuenciaPago());
            }

            if (siniestroProductoImportadoBean.getFechaEventoAnterior() != null){
                Thread.sleep(2000);
                WebElement fechaEventoAnterior = driver.findElement(By.xpath("//*[@id=\"1933934\"]/td[3]/font/input[1]" ));
                fechaEventoAnterior.sendKeys(siniestroProductoImportadoBean.getFechaEventoAnterior());
            }

            if (siniestroProductoImportadoBean.getFechaProximaGeneracionPrima() != null){
                Thread.sleep(2000);
                WebElement fechaProximaGeneracionPrima = driver.findElement(By.xpath("//*[@id=\"1830374\"]/td[3]/font/input[1]" ));
                fechaProximaGeneracionPrima.sendKeys(siniestroProductoImportadoBean.getFechaProximaGeneracionPrima());
            }

            if (siniestroProductoImportadoBean.getFechaProximaFacturacion() != null){
                Thread.sleep(2000);
                WebElement fechaProximaFacturacion = driver.findElement(By.xpath("//*[@id=\"1830214\"]/td[3]/font/input[1]" ));
                fechaProximaFacturacion.sendKeys(siniestroProductoImportadoBean.getFechaProximaFacturacion());
            }

            if (siniestroProductoImportadoBean.getTipoPoliza() != null){
                Thread.sleep(2000);
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"2878614\"]/td[3]/font/select")));
                tipoPoliza.selectByValue(siniestroProductoImportadoBean.getTipoPoliza());
            }

            if (siniestroProductoImportadoBean.getNumeroCotizacion() != null){
                Thread.sleep(2000);
                WebElement numeroCotizacion = driver.findElement(By.xpath("//*[@id=\"9480594\"]/td[3]/font/input[1]" ));
                numeroCotizacion.sendKeys(siniestroProductoImportadoBean.getNumeroCotizacion());
            }

            if (siniestroProductoImportadoBean.getNumeroPropuesta() != null){
                Thread.sleep(2000);
                WebElement numeroPropuesta = driver.findElement(By.xpath("//*[@id=\"9452594\"]/td[3]/font/input[1]" ));
                numeroPropuesta.sendKeys(siniestroProductoImportadoBean.getNumeroPropuesta());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i, "screen4",nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformpolicy_01\"]"));
            btnBuscar.click();

            Thread.sleep(6000);

        } catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda (WebDriver driver, Metodos a, SiniestroProductoImportadoBean siniestroProductoImportadoBean, int i){
        try {
            Thread.sleep(2000);
            WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr/td[2]/input[4]"));
            fechaOcurrenciaSiniestro.sendKeys(siniestroProductoImportadoBean.getFechaOcurrenciaSiniestro());

            Thread.sleep(2000);
            Select sucursalSiniestros = new Select(driver.findElement(By.xpath("//*[@id=\"userAgency\"]")));
            sucursalSiniestros.selectByValue(siniestroProductoImportadoBean.getSucursalSiniestros());

            // Cambiar de frame
            driver.switchTo().frame("frameData");
            Thread.sleep(2000);
            WebElement btnSeleccionarPoliza = driver.findElement(By.xpath("//*[@id=\"form1\"]/table/tbody/tr/td[1]/input"));
            btnSeleccionarPoliza.click();
            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnSelecUnidadesRiesgo = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_02\"]"));
            btnSelecUnidadesRiesgo.click();

            Thread.sleep(7000);

            WebElement selecUnidadRiesgo = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[5]/td[1]/input"));
            selecUnidadRiesgo.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i, "screen6", nombreAutomatizacion);

            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_selectRiskUnitToClaim_05\"]"));
            btnEnviar.click();

            Thread.sleep(10000);


            WebElement btnSelecEvento = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_03\"]"));
            btnSelecEvento.click();

            Thread.sleep(5000);

            WebElement selecEvento = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[4]/td[1]/input"));
            selecEvento.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);

            btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_policyEventsToClaim_01\"]"));
            btnEnviar.click();

            Thread.sleep(5000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_07\"]"));
            btnAceptar.click();

            Thread.sleep(10000);
            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (WebDriver driver, Metodos a, SiniestroProductoImportadoBean siniestroProductoImportadoBean, int i){
        try {
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
            btnAgregar.click();

            Thread.sleep(20000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Thread.sleep(3000);
            Select horaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"1837254\"]/td[3]/font/select")));
            horaOcurrencia.selectByValue(siniestroProductoImportadoBean.getHoraOcurrencia());

            WebElement fechaAvisoCompania = driver.findElement(By.xpath("//*[@id=\"1837174\"]/td[3]/font/input[1]"));
            fechaAvisoCompania.sendKeys(siniestroProductoImportadoBean.getFechaAvisoCompania());

            if (siniestroProductoImportadoBean.getHoraNotificacion() != null){
                Select horaNotificacion = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
                horaNotificacion.selectByValue(siniestroProductoImportadoBean.getHoraNotificacion());
            }

            if (siniestroProductoImportadoBean.getFechaReclFormalizacion() != null){
                WebElement fechaReclFormalizacion = driver.findElement(By.xpath("//*[@id=\"28932594\"]/td[3]/font/input[1]"));
                fechaReclFormalizacion.sendKeys(siniestroProductoImportadoBean.getFechaReclFormalizacion());
            }

            if (siniestroProductoImportadoBean.getFechaInterrupcionTerminos() != null){
                WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"30022594\"]/td[3]/font/input[1]"));
                fechaInterrupcionTerminos.sendKeys(siniestroProductoImportadoBean.getFechaInterrupcionTerminos());
            }

            if (siniestroProductoImportadoBean.getDocumentoIdentReclamante() != null){
                WebElement documentoIdentReclamante = driver.findElement(By.xpath("//*[@id=\"31763194\"]/td[3]/font/input[1]"));
                documentoIdentReclamante.sendKeys(siniestroProductoImportadoBean.getDocumentoIdentReclamante());
            }

            if (siniestroProductoImportadoBean.getReclamante() != null){
                WebElement reclamante = driver.findElement(By.xpath("//*[@id=\"23937694\"]/td[3]/font/input[1]"));
                reclamante.sendKeys(siniestroProductoImportadoBean.getReclamante());
            }

            Select causaGeneralMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"23854894\"]/td[3]/font/select")));
            causaGeneralMuerte.selectByValue(siniestroProductoImportadoBean.getCausaGeneralMuerte());

            Select causalesEspecifCobertMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"29997794\"]/td[3]/font/select")));
            causalesEspecifCobertMuerte.selectByValue(siniestroProductoImportadoBean.getCausalesEspecifCobertMuerte());

            Select departamento = new Select(driver.findElement(By.xpath("//*[@id=\"1934614\"]/td[3]/font/select")));
            departamento.selectByValue(siniestroProductoImportadoBean.getDepartamento());

            Select ciudad = new Select(driver.findElement(By.xpath("//*[@id=\"9508794\"]/td[3]/font/select")));
            ciudad.selectByValue(siniestroProductoImportadoBean.getCiudad());

            if (siniestroProductoImportadoBean.getGeneroAsegurado() != null){
                Select generoAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763594\"]/td[3]/font/select")));
                generoAsegurado.selectByValue(siniestroProductoImportadoBean.getGeneroAsegurado());
            }

            if (siniestroProductoImportadoBean.getProfesionAsegurado() != null){
                Select profesionAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763694\"]/td[3]/font/input[2]")));
                profesionAsegurado.selectByValue(siniestroProductoImportadoBean.getProfesionAsegurado());
            }
            WebElement btnLimpiar = driver.findElement(By.xpath("//*[@id=\"ProfesionAseguradoClearLink\"]"));
            btnLimpiar.click();

            if (siniestroProductoImportadoBean.getActividadSiniestro() != null){
                Select actividadSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"30018694\"]/td[3]/font/select")));
                actividadSiniestro.selectByValue(siniestroProductoImportadoBean.getActividadSiniestro());
            }

            if (siniestroProductoImportadoBean.getFechaActividad() != null){
                WebElement fechaActividad = driver.findElement(By.xpath("//*[@id=\"30018794\"]/td[3]/font/input[1]"));
                fechaActividad.sendKeys(siniestroProductoImportadoBean.getFechaActividad());
            }

            if (siniestroProductoImportadoBean.getObservacionesSiniestro() != null){
                WebElement observacionesSiniestro = driver.findElement(By.xpath("//*[@id=\"3746174\"]/td[3]/font/textarea"));
                observacionesSiniestro.sendKeys(siniestroProductoImportadoBean.getObservacionesSiniestro());
            }
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen9",nombreAutomatizacion);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
            btnAceptar.click();

            Thread.sleep(25000);

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen10",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarCobertura (WebDriver driver, Metodos a, SiniestroProductoImportadoBean siniestroProductoImportadoBean, int i){
        try{

            Thread.sleep(5000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]"));
            btnAgregar.click();
            Thread.sleep(15000);

            if (siniestroProductoImportadoBean.getObjetosAsegurados() != null){
                Select objetosAsegurados = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[1]/tr[2]/td[2]/select")));
                objetosAsegurados.selectByValue(siniestroProductoImportadoBean.getObjetosAsegurados());
            }

            if (siniestroProductoImportadoBean.getCoberturaAfectada() != null){
                Select coberturaAfectada = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[1]/tr[3]/td[2]/select")));
                coberturaAfectada.selectByValue(siniestroProductoImportadoBean.getCoberturaAfectada());
            }

            Thread.sleep(3000);
            WebElement pagoMaximo = driver.findElement(By.xpath("//*[@id=\"maxBenefitAmount1\"]"));
            pagoMaximo.clear();
            pagoMaximo.sendKeys(siniestroProductoImportadoBean.getPagoMaximo());
/*
            Thread.sleep(2000);
            Select monedaSiniestro = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[2]/tr[4]/td[2]/select")));
            monedaSiniestro.selectByValue(siniestroProductoImportadoBean.getMonedaSiniestro());
*/
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen11",nombreAutomatizacion);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_addCoverages_03\"]"));
            btnEnviar.click();

            Thread.sleep(3000);

            /*if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }*/

            Thread.sleep(3000);
/*
            Set<String> sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            String childId = it.next();
            String childId2 = it.next();
            System.out.println("Prueba " + childId);
            System.out.println("Prueba " + childId2);
            //swtiching control to child Window
            driver.switchTo().window(childId2);

            Thread.sleep(6000);

            WebElement btnAceptarOtro = driver.findElement(By.xpath("//*[@id=\"u70\"]/input"));
            btnAceptarOtro.click();

            Thread.sleep(3000);

            sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            it = sid.iterator();
            parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            childId = it.next();
            System.out.println("Prueba " + childId);
            //swtiching control to child Window
            driver.switchTo().window(childId);

            Thread.sleep(3000);

*/
            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }
            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen12",nombreAutomatizacion);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
