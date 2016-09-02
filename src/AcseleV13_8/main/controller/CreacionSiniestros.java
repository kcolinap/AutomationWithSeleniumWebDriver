package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CreacionSiniestrosBean;
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
 * Created by aazuaje on 27/07/2016.
 */
public class CreacionSiniestros {

    private final static Logger log = Logger.getLogger(CreacionSiniestros.class);

    public String nombreAutomatizacion = "Creacion Siniestros";

    public void testLink(CreacionSiniestrosBean creacionSiniestrosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        m.OpeSini_CreacionSiniestro(driver, a, nombreAutomatizacion);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, creacionSiniestrosBean);
        ResultadoBusqueda(driver, a, creacionSiniestrosBean);
        AgregarObjetoAfectado(driver, a, creacionSiniestrosBean);
        AgregarCobertura(driver, a, creacionSiniestrosBean);
        AgregarRequisitos(driver, a, creacionSiniestrosBean);
        AgregarPagos(driver, a, creacionSiniestrosBean);

    }

    public void BuscarPoliza(WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean) throws IOException, InterruptedException{

        try {

            if (creacionSiniestrosBean.getOrdenarPor() != null){
                Thread.sleep(2000);
                Select ordenarPor = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(creacionSiniestrosBean.getOrdenarPor());
            }
            if (creacionSiniestrosBean.getProducto() != null){
                Thread.sleep(2000);
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));
                producto.selectByValue(creacionSiniestrosBean.getProducto());
                Thread.sleep(8000);
            }

            if (creacionSiniestrosBean.getEstadosCicloVida() != null){
                Thread.sleep(2000);
                Select estadosCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));
                estadosCicloVida.selectByValue(creacionSiniestrosBean.getEstadosCicloVida());
            }

            if (creacionSiniestrosBean.getContratante() != null){
                Thread.sleep(2000);
                WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(creacionSiniestrosBean.getContratante());
            }

            if (creacionSiniestrosBean.getAsegurado() != null){
                Thread.sleep(2000);
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(creacionSiniestrosBean.getAsegurado());
            }

            if (creacionSiniestrosBean.getIdPoliza() != null){
                Thread.sleep(2000);
                WebElement idPoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]" ));
                idPoliza.sendKeys(creacionSiniestrosBean.getIdPoliza());
            }

            if (creacionSiniestrosBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]" ));
                fechaDesde.sendKeys(creacionSiniestrosBean.getFechaDesde());
            }

            if (creacionSiniestrosBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("//*[@id=\"_toDateShow\"]" ));
                fechaHasta.sendKeys(creacionSiniestrosBean.getFechaHasta());
            }

            if (creacionSiniestrosBean.getSucursalPoliza() != null){
                Thread.sleep(2000);
                Select sucursalPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1829934\"]/td[3]/font/select")));
                sucursalPoliza.selectByValue(creacionSiniestrosBean.getSucursalPoliza());
            }

            if (creacionSiniestrosBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"1829814\"]/td[3]/font/input[1]" ));
                numeroPoliza.sendKeys(creacionSiniestrosBean.getNumeroPoliza());
            }

            if (creacionSiniestrosBean.getFechaEmision() != null){
                Thread.sleep(2000);
                WebElement fechaEmision = driver.findElement(By.xpath("//*[@id=\"1829854\"]/td[3]/font/input[1]" ));
                fechaEmision.sendKeys(creacionSiniestrosBean.getFechaEmision());
            }

            if (creacionSiniestrosBean.getMonedaPoliza() != null){
                Thread.sleep(2000);
                Select monedaPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"1828494\"]/td[3]/font/select")));
                monedaPoliza.selectByValue(creacionSiniestrosBean.getMonedaPoliza());
            }

            if (creacionSiniestrosBean.getTipoMonedaPoliza() != null){
                Thread.sleep(2000);
                Select tipoMonedaPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"30598294\"]/td[3]/font/select")));
                tipoMonedaPoliza.selectByValue(creacionSiniestrosBean.getTipoMonedaPoliza());
            }

            if (creacionSiniestrosBean.getTipoProduccion() != null){
                Thread.sleep(2000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//*[@id=\"1829894\"]/td[3]/font/select")));
                tipoProduccion.selectByValue(creacionSiniestrosBean.getTipoProduccion());
            }

            if (creacionSiniestrosBean.getTipoVigencia() != null){
                Thread.sleep(2000);
                Select tipoVigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830014\"]/td[3]/font/select")));
                tipoVigencia.selectByValue(creacionSiniestrosBean.getTipoVigencia());
            }

            if (creacionSiniestrosBean.getVigencia() != null){
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//*[@id=\"1830054\"]/td[3]/font/select")));
                vigencia.selectByValue(creacionSiniestrosBean.getVigencia());
            }

            if (creacionSiniestrosBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//*[@id=\"1933894\"]/td[3]/font/select")));
                canalVenta.selectByValue(creacionSiniestrosBean.getCanalVenta());
            }

            if (creacionSiniestrosBean.getFrecuenciaPago() != null){
                Thread.sleep(2000);
                Select frecuenciaPago = new Select(driver.findElement(By.xpath("//*[@id=\"1830294\"]/td[3]/font/select")));
                frecuenciaPago.selectByValue(creacionSiniestrosBean.getFrecuenciaPago());
            }

            if (creacionSiniestrosBean.getFechaEventoAnterior() != null){
                Thread.sleep(2000);
                WebElement fechaEventoAnterior = driver.findElement(By.xpath("//*[@id=\"1933934\"]/td[3]/font/input[1]" ));
                fechaEventoAnterior.sendKeys(creacionSiniestrosBean.getFechaEventoAnterior());
            }

            if (creacionSiniestrosBean.getFechaProximaGeneracionPrima() != null){
                Thread.sleep(2000);
                WebElement fechaProximaGeneracionPrima = driver.findElement(By.xpath("//*[@id=\"1830374\"]/td[3]/font/input[1]" ));
                fechaProximaGeneracionPrima.sendKeys(creacionSiniestrosBean.getFechaProximaGeneracionPrima());
            }

            if (creacionSiniestrosBean.getFechaProximaFacturacion() != null){
                Thread.sleep(2000);
                WebElement fechaProximaFacturacion = driver.findElement(By.xpath("//*[@id=\"1830214\"]/td[3]/font/input[1]" ));
                fechaProximaFacturacion.sendKeys(creacionSiniestrosBean.getFechaProximaFacturacion());
            }

            if (creacionSiniestrosBean.getTipoPoliza() != null){
                Thread.sleep(2000);
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"2878614\"]/td[3]/font/select")));
                tipoPoliza.selectByValue(creacionSiniestrosBean.getTipoPoliza());
            }

            if (creacionSiniestrosBean.getNumeroCotizacion() != null){
                Thread.sleep(2000);
                WebElement numeroCotizacion = driver.findElement(By.xpath("//*[@id=\"9480594\"]/td[3]/font/input[1]" ));
                numeroCotizacion.sendKeys(creacionSiniestrosBean.getNumeroCotizacion());
            }

            if (creacionSiniestrosBean.getNumeroPropuesta() != null){
                Thread.sleep(2000);
                WebElement numeroPropuesta = driver.findElement(By.xpath("//*[@id=\"9452594\"]/td[3]/font/input[1]" ));
                numeroPropuesta.sendKeys(creacionSiniestrosBean.getNumeroPropuesta());
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

            Thread.sleep(5000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_07\"]"));
            btnAceptar.click();

            Thread.sleep(20000);
            a.ScreenShot(driver,"screen8",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean){
       try {
           Thread.sleep(2000);
           WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
           btnAgregar.click();

           Thread.sleep(20000);

           // Cambiar de frame
           driver.switchTo().frame("plantilla");

           Thread.sleep(3000);
           Select horaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"1837254\"]/td[3]/font/select")));
           horaOcurrencia.selectByValue(creacionSiniestrosBean.getHoraOcurrencia());

           WebElement fechaAvisoCompania = driver.findElement(By.xpath("//*[@id=\"1837174\"]/td[3]/font/input[1]"));
           fechaAvisoCompania.sendKeys(creacionSiniestrosBean.getFechaAvisoCompania());

           if (creacionSiniestrosBean.getHoraNotificacion() != null){
           Select horaNotificacion = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
           horaNotificacion.selectByValue(creacionSiniestrosBean.getHoraNotificacion());
           }

           if (creacionSiniestrosBean.getFechaReclFormalizacion() != null){
           WebElement fechaReclFormalizacion = driver.findElement(By.xpath("//*[@id=\"28932594\"]/td[3]/font/input[1]"));
           fechaReclFormalizacion.sendKeys(creacionSiniestrosBean.getFechaReclFormalizacion());
           }

           if (creacionSiniestrosBean.getFechaInterrupcionTerminos() != null){
               WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"30022594\"]/td[3]/font/input[1]"));
               fechaInterrupcionTerminos.sendKeys(creacionSiniestrosBean.getFechaInterrupcionTerminos());
           }

           if (creacionSiniestrosBean.getDocumentoIdentReclamante() != null){
               WebElement documentoIdentReclamante = driver.findElement(By.xpath("//*[@id=\"31763194\"]/td[3]/font/input[1]"));
               documentoIdentReclamante.sendKeys(creacionSiniestrosBean.getDocumentoIdentReclamante());
           }

           if (creacionSiniestrosBean.getReclamante() != null){
           WebElement reclamante = driver.findElement(By.xpath("//*[@id=\"23937694\"]/td[3]/font/input[1]"));
           reclamante.sendKeys(creacionSiniestrosBean.getReclamante());
           }

           Select causaGeneralMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"23854894\"]/td[3]/font/select")));
           causaGeneralMuerte.selectByValue(creacionSiniestrosBean.getCausaGeneralMuerte());

           Select causalesEspecifCobertMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"29997794\"]/td[3]/font/select")));
           causalesEspecifCobertMuerte.selectByValue(creacionSiniestrosBean.getCausalesEspecifCobertMuerte());

           Select departamento = new Select(driver.findElement(By.xpath("//*[@id=\"1934614\"]/td[3]/font/select")));
           departamento.selectByValue(creacionSiniestrosBean.getDepartamento());

           Select ciudad = new Select(driver.findElement(By.xpath("//*[@id=\"9508794\"]/td[3]/font/select")));
           ciudad.selectByValue(creacionSiniestrosBean.getCiudad());

           if (creacionSiniestrosBean.getGeneroAsegurado() != null){
               Select generoAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763594\"]/td[3]/font/select")));
               generoAsegurado.selectByValue(creacionSiniestrosBean.getGeneroAsegurado());
           }

           if (creacionSiniestrosBean.getProfesionAsegurado() != null){
               Select profesionAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763694\"]/td[3]/font/input[2]")));
               profesionAsegurado.selectByValue(creacionSiniestrosBean.getProfesionAsegurado());
           }
           WebElement btnLimpiar = driver.findElement(By.xpath("//*[@id=\"ProfesionAseguradoClearLink\"]"));
           btnLimpiar.click();

           if (creacionSiniestrosBean.getActividadSiniestro() != null){
           Select actividadSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"30018694\"]/td[3]/font/select")));
           actividadSiniestro.selectByValue(creacionSiniestrosBean.getActividadSiniestro());
           }

           if (creacionSiniestrosBean.getFechaActividad() != null){
           WebElement fechaActividad = driver.findElement(By.xpath("//*[@id=\"30018794\"]/td[3]/font/input[1]"));
           fechaActividad.sendKeys(creacionSiniestrosBean.getFechaActividad());
           }

           if (creacionSiniestrosBean.getObservacionesSiniestro() != null){
           WebElement observacionesSiniestro = driver.findElement(By.xpath("//*[@id=\"3746174\"]/td[3]/font/textarea"));
           observacionesSiniestro.sendKeys(creacionSiniestrosBean.getObservacionesSiniestro());
           }
           Thread.sleep(2000);
           a.ScreenShot(driver,"screen9",nombreAutomatizacion);

           // Salir del frame
           //driver.switchTo().parentFrame();
           driver.switchTo().defaultContent();

           Thread.sleep(2000);
           WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
           btnAceptar.click();

           Thread.sleep(25000);

           Thread.sleep(2000);
           a.ScreenShot(driver,"screen10",nombreAutomatizacion);

       }catch (Exception e) {
        e.printStackTrace();
//                log.info(e);
        log.info("Test Case - " + nombreAutomatizacion + " - " + e);
       }
    }

    public void AgregarCobertura (WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean){
        try{

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]"));
            btnAgregar.click();
            Thread.sleep(15000);

            if (creacionSiniestrosBean.getObjetosAsegurados() != null){
            Select objetosAsegurados = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[1]/tr[2]/td[2]/select")));
            objetosAsegurados.selectByValue(creacionSiniestrosBean.getObjetosAsegurados());
            }

            if (creacionSiniestrosBean.getCoberturaAfectada() != null){
            Select coberturaAfectada = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[1]/tr[3]/td[2]/select")));
            coberturaAfectada.selectByValue(creacionSiniestrosBean.getCoberturaAfectada());
            }

            Thread.sleep(3000);
            WebElement pagoMaximo = driver.findElement(By.xpath("//*[@id=\"maxBenefitAmount1\"]"));
            pagoMaximo.clear();
            pagoMaximo.sendKeys(creacionSiniestrosBean.getPagoMaximo());

            Thread.sleep(2000);
            Select monedaSiniestro = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/center/table/tbody[2]/tr[4]/td[2]/select")));
            monedaSiniestro.selectByValue(creacionSiniestrosBean.getMonedaSiniestro());

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
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarRequisitos (WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean){
        try {

            Thread.sleep(6000);
            Select cobertura = new Select(driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]")));
            cobertura.selectByIndex(0);
            Thread.sleep(4000);
            WebElement cobertura2 = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]"));
            cobertura2.click();

            Thread.sleep(2000);
            WebElement btnRequisitos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_14\"]"));
            btnRequisitos.click();


            Thread.sleep(15000);
            WebElement btnRecibido = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/thead/tr/th[3]/input"));
            btnRecibido.click();
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen12",nombreAutomatizacion);

            Thread.sleep(2000);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_requisites_02\"]"));
            btnEnviar.click();
            Thread.sleep(10000);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarPagos (WebDriver driver, Metodos a, CreacionSiniestrosBean creacionSiniestrosBean){
        try {
            Thread.sleep(5000);
            Select cobertura = new Select(driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]")));
            cobertura.selectByIndex(0);

            Thread.sleep(4000);
            WebElement cobertura2 = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]"));
            cobertura2.click();

            Thread.sleep(2000);
            WebElement btnPagos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]"));
            btnPagos.click();

            Thread.sleep(20000);
            a.ScreenShot(driver,"screen13",nombreAutomatizacion);
            WebElement tercerosPoliza = driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]"));
            tercerosPoliza.click();

            Thread.sleep(10000);
            WebElement seleccionTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input"));
            seleccionTercero.click();
            a.ScreenShot(driver,"screen14",nombreAutomatizacion);

            Thread.sleep(4000);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_resultClaimThirdParty_01\"]"));
            btnEnviar.click();

            Thread.sleep(15000);
            a.ScreenShot(driver,"screen15",nombreAutomatizacion);
            WebElement btnEditar = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[1]/input[2]"));
            btnEditar.click();
            Thread.sleep(10000);
            a.ScreenShot(driver,"screen16",nombreAutomatizacion);

            if (creacionSiniestrosBean.getFechaCompromiso() != null){
                Thread.sleep(2000);
                WebElement fechaCompromiso = driver.findElement(By.xpath("//*[@id=\"calendarcommitmentDateShow\"]"));
                fechaCompromiso.sendKeys(creacionSiniestrosBean.getFechaCompromiso());
            }

            if (creacionSiniestrosBean.getFechaInicial() != null){
                Thread.sleep(2000);
                WebElement fechaInicial = driver.findElement(By.xpath("//*[@id=\"calendarstartDateShow\"]"));
                fechaInicial.sendKeys(creacionSiniestrosBean.getFechaInicial());
            }

            if (creacionSiniestrosBean.getFechaFinal() != null){
                Thread.sleep(2000);
                WebElement fechaFinal = driver.findElement(By.xpath("//*[@id=\"calendarendDateShow\"]"));
                fechaFinal.sendKeys(creacionSiniestrosBean.getFechaFinal());
            }

            if (creacionSiniestrosBean.getRazon() != null){
                Thread.sleep(2000);
                WebElement razon = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[11]/textarea"));
                razon.sendKeys(creacionSiniestrosBean.getRazon());
            }

            if (creacionSiniestrosBean.getEstado() != null){
                Thread.sleep(2000);
                Select estado = new Select(driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[12]/select")));
                estado.selectByValue(creacionSiniestrosBean.getEstado());
            }

            if (creacionSiniestrosBean.getTipo() != null){
                Thread.sleep(2000);
                Select tipo = new Select(driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[13]/select")));
                tipo.selectByValue(creacionSiniestrosBean.getTipo());
            }

            Thread.sleep(4000);
            WebElement montoSiniestro = driver.findElement(By.xpath("//*[@id=\"amount1\"]"));
            montoSiniestro.clear();
            montoSiniestro.sendKeys(creacionSiniestrosBean.getMontoSiniestro());
            Thread.sleep(1000);
            WebElement razon2 = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[11]/textarea"));
            razon2.click();


            Thread.sleep(15000);
            a.ScreenShot(driver,"screen17",nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement btnEnviar2 = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimPaymentDetail_01\"]"));
            btnEnviar2.click();
            Thread.sleep(20000);


            if (ExpectedConditions.alertIsPresent() != null) {
                driver.switchTo().alert();
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
            }

            Thread.sleep(4000);
            a.ScreenShot(driver,"screen18",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}





































































