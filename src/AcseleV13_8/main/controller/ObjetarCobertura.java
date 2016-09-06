
package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ObjetarCoberturaBean;
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
 * Created by aazuaje on 03/08/2016.
 */

public class ObjetarCobertura {

    private final static Logger log = Logger.getLogger(ObjetarCobertura.class);

    public String nombreAutomatizacion = "Objetar Cobertura";

    public void testLink(ObjetarCoberturaBean objetarCoberturaBean,int i) throws IOException, InterruptedException{

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_CreacionSiniestro(driver, a, nombreAutomatizacion);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, objetarCoberturaBean);
        ResultadoBusqueda(driver, a, objetarCoberturaBean);
        AgregarObjetoAfectado(driver, a, objetarCoberturaBean);
        AgregarCobertura(driver, a, objetarCoberturaBean);

    }

    public void BuscarPoliza(WebDriver driver, Metodos a, ObjetarCoberturaBean objetarCoberturaBean) throws IOException, InterruptedException{

        try {

            if (objetarCoberturaBean.getOrdenarPor() != null){
                Thread.sleep(2000);
                Select ordenarPor = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(objetarCoberturaBean.getOrdenarPor());
            }
            if (objetarCoberturaBean.getProducto() != null){
                Thread.sleep(2000);
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));
                producto.selectByValue(objetarCoberturaBean.getProducto());
                Thread.sleep(8000);
            }

            if (objetarCoberturaBean.getEstadosCicloVida() != null){
                Thread.sleep(2000);
                Select estadosCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));
                estadosCicloVida.selectByValue(objetarCoberturaBean.getEstadosCicloVida());
            }

            if (objetarCoberturaBean.getContratante() != null){
                Thread.sleep(2000);
                WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(objetarCoberturaBean.getContratante());
            }

            if (objetarCoberturaBean.getAsegurado() != null){
                Thread.sleep(2000);
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(objetarCoberturaBean.getAsegurado());
            }

            if (objetarCoberturaBean.getIdPoliza() != null){
                Thread.sleep(2000);
                WebElement idPoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]" ));
                idPoliza.sendKeys(objetarCoberturaBean.getIdPoliza());
            }

            if (objetarCoberturaBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]" ));
                fechaDesde.sendKeys(objetarCoberturaBean.getFechaDesde());
            }

            if (objetarCoberturaBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("//*[@id=\"_toDateShow\"]" ));
                fechaHasta.sendKeys(objetarCoberturaBean.getFechaHasta());
            }

            if (objetarCoberturaBean.getSucursalPoliza() != null){
                Thread.sleep(2000);
                Select sucursalPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1829934\"]/td[3]/font/select")));
                sucursalPoliza.selectByValue(objetarCoberturaBean.getSucursalPoliza());
            }

            if (objetarCoberturaBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"1829814\"]/td[3]/font/input[1]" ));
                numeroPoliza.sendKeys(objetarCoberturaBean.getNumeroPoliza());
            }

            if (objetarCoberturaBean.getFechaEmision() != null){
                Thread.sleep(2000);
                WebElement fechaEmision = driver.findElement(By.xpath("//*[@id=\"1829854\"]/td[3]/font/input[1]" ));
                fechaEmision.sendKeys(objetarCoberturaBean.getFechaEmision());
            }

            if (objetarCoberturaBean.getMonedaPoliza() != null){
                Thread.sleep(2000);
                Select monedaPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1828494\"]/td[3]/font/select")));
                monedaPoliza.selectByValue(objetarCoberturaBean.getMonedaPoliza());
            }

            if (objetarCoberturaBean.getTipoMonedaPoliza() != null){
                Thread.sleep(2000);
                Select tipoMonedaPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"30598294\"]/td[3]/font/select")));
                tipoMonedaPoliza.selectByValue(objetarCoberturaBean.getTipoMonedaPoliza());
            }

            if (objetarCoberturaBean.getTipoProduccion() != null){
                Thread.sleep(2000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//*[@id=\"1829894\"]/td[3]/font/select")));
                tipoProduccion.selectByValue(objetarCoberturaBean.getTipoProduccion());
            }

            if (objetarCoberturaBean.getTipoVigencia() != null){
                Thread.sleep(2000);
                Select tipoVigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830014\"]/td[3]/font/select")));
                tipoVigencia.selectByValue(objetarCoberturaBean.getTipoVigencia());
            }

            if (objetarCoberturaBean.getVigencia() != null){
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830054\"]/td[3]/font/select")));
                vigencia.selectByValue(objetarCoberturaBean.getVigencia());
            }

            if (objetarCoberturaBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//*[@id=\"1933894\"]/td[3]/font/select")));
                canalVenta.selectByValue(objetarCoberturaBean.getCanalVenta());
            }

            if (objetarCoberturaBean.getFrecuenciaPago() != null){
                Thread.sleep(2000);
                Select frecuenciaPago = new Select(driver.findElement(By.xpath("//*[@id=\"1830294\"]/td[3]/font/select")));
                frecuenciaPago.selectByValue(objetarCoberturaBean.getFrecuenciaPago());
            }

            if (objetarCoberturaBean.getFechaEventoAnterior() != null){
                Thread.sleep(2000);
                WebElement fechaEventoAnterior = driver.findElement(By.xpath("//*[@id=\"1933934\"]/td[3]/font/input[1]" ));
                fechaEventoAnterior.sendKeys(objetarCoberturaBean.getFechaEventoAnterior());
            }

            if (objetarCoberturaBean.getFechaProximaGeneracionPrima() != null){
                Thread.sleep(2000);
                WebElement fechaProximaGeneracionPrima = driver.findElement(By.xpath("//*[@id=\"1830374\"]/td[3]/font/input[1]" ));
                fechaProximaGeneracionPrima.sendKeys(objetarCoberturaBean.getFechaProximaGeneracionPrima());
            }

            if (objetarCoberturaBean.getFechaProximaFacturacion() != null){
                Thread.sleep(2000);
                WebElement fechaProximaFacturacion = driver.findElement(By.xpath("//*[@id=\"1830214\"]/td[3]/font/input[1]" ));
                fechaProximaFacturacion.sendKeys(objetarCoberturaBean.getFechaProximaFacturacion());
            }

            if (objetarCoberturaBean.getTipoPoliza() != null){
                Thread.sleep(2000);
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"2878614\"]/td[3]/font/select")));
                tipoPoliza.selectByValue(objetarCoberturaBean.getTipoPoliza());
            }

            if (objetarCoberturaBean.getNumeroCotizacion() != null){
                Thread.sleep(2000);
                WebElement numeroCotizacion = driver.findElement(By.xpath("//*[@id=\"9480594\"]/td[3]/font/input[1]" ));
                numeroCotizacion.sendKeys(objetarCoberturaBean.getNumeroCotizacion());
            }

            if (objetarCoberturaBean.getNumeroPropuesta() != null){
                Thread.sleep(2000);
                WebElement numeroPropuesta = driver.findElement(By.xpath("//*[@id=\"9452594\"]/td[3]/font/input[1]" ));
                numeroPropuesta.sendKeys(objetarCoberturaBean.getNumeroPropuesta());
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

    public void ResultadoBusqueda (WebDriver driver, Metodos a, ObjetarCoberturaBean objetarCoberturaBean){
        try {
            Thread.sleep(2000);
            WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr/td[2]/input[4]"));
            fechaOcurrenciaSiniestro.sendKeys(objetarCoberturaBean.getFechaOcurrenciaSiniestro());

            Thread.sleep(2000);
            Select sucursalSiniestros = new Select(driver.findElement(By.xpath("//*[@id=\"userAgency\"]")));
            sucursalSiniestros.selectByValue(objetarCoberturaBean.getSucursalSiniestros());

            // Cambiar de frame
            driver.switchTo().frame("frameData");
            Thread.sleep(2000);
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
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);

            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_selectRiskUnitToClaim_05\"]"));
            btnEnviar.click();

            Thread.sleep(13000);


            WebElement btnSelecEvento = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_03\"]"));
            btnSelecEvento.click();

            Thread.sleep(5000);

            WebElement selecEvento = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[4]/td[1]/input"));
            selecEvento.click();

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen7",nombreAutomatizacion);

            btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_policyEventsToClaim_01\"]"));
            btnEnviar.click();

            Thread.sleep(10000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_07\"]"));
            btnAceptar.click();

            Thread.sleep(25000);
            a.ScreenShot(driver,"screen8",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (WebDriver driver, Metodos a, ObjetarCoberturaBean objetarCoberturaBean){
        try {
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
            btnAgregar.click();

            Thread.sleep(20000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Select horaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"1837254\"]/td[3]/font/select")));
            horaOcurrencia.selectByValue(objetarCoberturaBean.getHoraOcurrencia());

            WebElement fechaAvisoCompania = driver.findElement(By.xpath("//*[@id=\"1837174\"]/td[3]/font/input[1]"));
            fechaAvisoCompania.sendKeys(objetarCoberturaBean.getFechaAvisoCompania());

            if (objetarCoberturaBean.getHoraNotificacion() != null){
                Select horaNotificacion = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
                horaNotificacion.selectByValue(objetarCoberturaBean.getHoraNotificacion());
            }

            if (objetarCoberturaBean.getFechaReclFormalizacion() != null){
                WebElement fechaReclFormalizacion = driver.findElement(By.xpath("//*[@id=\"28932594\"]/td[3]/font/input[1]"));
                fechaReclFormalizacion.sendKeys(objetarCoberturaBean.getFechaReclFormalizacion());
            }

            if (objetarCoberturaBean.getFechaInterrupcionTerminos() != null){
                WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"30022594\"]/td[3]/font/input[1]"));
                fechaInterrupcionTerminos.sendKeys(objetarCoberturaBean.getFechaInterrupcionTerminos());
            }

            if (objetarCoberturaBean.getDocumentoIdentReclamante() != null){
                WebElement documentoIdentReclamante = driver.findElement(By.xpath("//*[@id=\"31763194\"]/td[3]/font/input[1]"));
                documentoIdentReclamante.sendKeys(objetarCoberturaBean.getDocumentoIdentReclamante());
            }

            if (objetarCoberturaBean.getReclamante() != null){
                WebElement reclamante = driver.findElement(By.xpath("//*[@id=\"23937694\"]/td[3]/font/input[1]"));
                reclamante.sendKeys(objetarCoberturaBean.getReclamante());
            }

            Select causaGeneralMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"23854894\"]/td[3]/font/select")));
            causaGeneralMuerte.selectByValue(objetarCoberturaBean.getCausaGeneralMuerte());

            Select causalesEspecifCobertMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"29997794\"]/td[3]/font/select")));
            causalesEspecifCobertMuerte.selectByValue(objetarCoberturaBean.getCausalesEspecifCobertMuerte());

            Select departamento = new Select(driver.findElement(By.xpath("//*[@id=\"1934614\"]/td[3]/font/select")));
            departamento.selectByValue(objetarCoberturaBean.getDepartamento());

            Select ciudad = new Select(driver.findElement(By.xpath("//*[@id=\"9508794\"]/td[3]/font/select")));
            ciudad.selectByValue(objetarCoberturaBean.getCiudad());

            if (objetarCoberturaBean.getGeneroAsegurado() != null){
                Select generoAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763594\"]/td[3]/font/select")));
                generoAsegurado.selectByValue(objetarCoberturaBean.getGeneroAsegurado());
            }

            if (objetarCoberturaBean.getProfesionAsegurado() != null){
                Select profesionAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763694\"]/td[3]/font/input[2]")));
                profesionAsegurado.selectByValue(objetarCoberturaBean.getProfesionAsegurado());
            }

            WebElement btnLimpiar = driver.findElement(By.xpath("//*[@id=\"ProfesionAseguradoClearLink\"]"));
            btnLimpiar.click();

            if (objetarCoberturaBean.getActividadSiniestro() != null){
                Select actividadSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"30018694\"]/td[3]/font/select")));
                actividadSiniestro.selectByValue(objetarCoberturaBean.getActividadSiniestro());
            }

            if (objetarCoberturaBean.getFechaActividad() != null){
                WebElement fechaActividad = driver.findElement(By.xpath("//*[@id=\"30018794\"]/td[3]/font/input[1]"));
                fechaActividad.sendKeys(objetarCoberturaBean.getFechaActividad());
            }

            if (objetarCoberturaBean.getObservacionesSiniestro() != null){
                WebElement observacionesSiniestro = driver.findElement(By.xpath("//*[@id=\"3746174\"]/td[3]/font/textarea"));
                observacionesSiniestro.sendKeys(objetarCoberturaBean.getObservacionesSiniestro());
            }
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
            btnAceptar.click();

            Thread.sleep(15000);

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen10",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarCobertura (WebDriver driver, Metodos a, ObjetarCoberturaBean objetarCoberturaBean){
        try{

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]"));
            btnAgregar.click();
            Thread.sleep(10000);

            if (objetarCoberturaBean.getObjetosAsegurados() != null){
                Select objetosAsegurados = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[1]/tr[2]/td[2]/select")));
                objetosAsegurados.selectByValue(objetarCoberturaBean.getObjetosAsegurados());
            }

            if (objetarCoberturaBean.getCoberturaAfectada() != null){
                Select coberturaAfectada = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[1]/tr[3]/td[2]/select")));
                coberturaAfectada.selectByValue(objetarCoberturaBean.getCoberturaAfectada());
            }

            Thread.sleep(10000);
            WebElement pagoMaximo = driver.findElement(By.xpath("//*[@id=\"maxBenefitAmount1\"]"));
            pagoMaximo.clear();
            pagoMaximo.sendKeys(objetarCoberturaBean.getPagoMaximo());

            Thread.sleep(2000);
            Select monedaSiniestro = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[2]/tr[4]/td[2]/select")));
            monedaSiniestro.selectByValue(objetarCoberturaBean.getMonedaSiniestro());

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen11",nombreAutomatizacion);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_addCoverages_03\"]"));
            btnEnviar.click();

            Thread.sleep(6000);

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

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.dismiss();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            Thread.sleep(10000);
            a.ScreenShot(driver,"screen12",nombreAutomatizacion);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_contextPageClaimTool_01\"]"));
            btnAceptar.click();


            Thread.sleep(10000);
            Select cobertura = new Select(driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]")));
            cobertura.selectByIndex(0);
            Thread.sleep(4000);
            WebElement cobertura2 = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura2.click();

            WebElement rechazar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_07\"]"));
            rechazar.click();
            Thread.sleep(3000);

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }


            Thread.sleep(15000);
            // Cambiar de frame
            driver.switchTo().frame("plantilla");
            Thread.sleep(2000);
            WebElement fechaObjecion = driver.findElement(By.xpath("//*[@id=\"28482594\"]/td[3]/font/input[1]"));
            fechaObjecion.click();
            fechaObjecion.sendKeys(objetarCoberturaBean.getFechaObjecion());

            if (objetarCoberturaBean.getComentariosSiniestro() != null){
                Select comentariosSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"1929454\"]/td[3]/font/textarea")));
                comentariosSiniestro.selectByValue(objetarCoberturaBean.getComentariosSiniestro());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen13",nombreAutomatizacion);
            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            WebElement btnAceptar2 = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[4]/input"));
            btnAceptar2.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen14",nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
