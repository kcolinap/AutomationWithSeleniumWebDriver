package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8.beans.CreacionSiniestrosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.Metodos;
import AcseleV13_8_Interseguros.beans.INTER_CreacionSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
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
 * Created by aazuaje on 13/12/2016.
 */
public class INTER_CreacionSiniestro {

    private final static Logger log = Logger.getLogger(INTER_CreacionSiniestro.class);

    public String nombreAutomatizacion = "Creacion Siniestros";

    public void testLink(INTER_CreacionSiniestroBean inter_creacionSiniestroBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Interseguros_Metodos a = new Interseguros_Metodos();
        Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_CreacionSiniestro(driver,a,nombreAutomatizacion,3, i);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, inter_creacionSiniestroBean ,i);
        ResultadoBusqueda(driver, a, inter_creacionSiniestroBean , i);
        AgregarObjetoAfectado(driver, a, inter_creacionSiniestroBean, i);
        AgregarCobertura(driver, a, inter_creacionSiniestroBean, i);
        AgregarRequisitos(driver, a, inter_creacionSiniestroBean,i);
        AgregarPagos(driver, a, inter_creacionSiniestroBean, i);

    }

    public void BuscarPoliza(WebDriver driver, Interseguros_Metodos a, INTER_CreacionSiniestroBean inter_creacionSiniestroBean, int i) throws IOException, InterruptedException{

        try {

            if (inter_creacionSiniestroBean.getOrdenarPor() != null){
                Thread.sleep(2000);
                Select ordenarPor = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(inter_creacionSiniestroBean.getOrdenarPor());
            }
            if (inter_creacionSiniestroBean.getProducto() != null){
                Thread.sleep(2000);
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));
                producto.selectByValue(inter_creacionSiniestroBean.getProducto());
                Thread.sleep(8000);
            }

            if (inter_creacionSiniestroBean.getEstadosCicloVida() != null){
                Thread.sleep(2000);
                Select estadosCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));
                estadosCicloVida.selectByValue(inter_creacionSiniestroBean.getEstadosCicloVida());
            }

            if (inter_creacionSiniestroBean.getContratante() != null){
                Thread.sleep(2000);
                WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(inter_creacionSiniestroBean.getContratante());
            }

            if (inter_creacionSiniestroBean.getAseguradoEstipulante() != null){
                Thread.sleep(2000);
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(inter_creacionSiniestroBean.getAseguradoEstipulante());
            }

            if (inter_creacionSiniestroBean.getIdPoliza() != null){
                Thread.sleep(2000);
                WebElement idPoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]" ));
                idPoliza.sendKeys(inter_creacionSiniestroBean.getIdPoliza());
            }

            if (inter_creacionSiniestroBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]" ));
                fechaDesde.sendKeys(inter_creacionSiniestroBean.getFechaDesde());
            }

            if (inter_creacionSiniestroBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("//*[@id=\"_toDateShow\"]" ));
                fechaHasta.sendKeys(inter_creacionSiniestroBean.getFechaHasta());
            }

            if (inter_creacionSiniestroBean.getOficina() != null){
                Thread.sleep(2000);
                Select oficina = new Select(driver.findElement(By.xpath("//*[@id=\"Oficina\"]")));
                oficina.selectByValue(inter_creacionSiniestroBean.getOficina());
            }

            if (inter_creacionSiniestroBean.getNumeroCotizacion() != null){
                Thread.sleep(2000);
                WebElement numeroCotizacion = driver.findElement(By.xpath("//*[@id=\"NumeroCotizacion\"]" ));
                numeroCotizacion.sendKeys(inter_creacionSiniestroBean.getNumeroCotizacion());
            }

            if (inter_creacionSiniestroBean.getNumeroPropuesta() != null){
                Thread.sleep(2000);
                WebElement numeroPropuesta = driver.findElement(By.xpath("//*[@id=\"NumeroPropuesta\"]" ));
                numeroPropuesta.sendKeys(inter_creacionSiniestroBean.getNumeroPropuesta());
            }

            if (inter_creacionSiniestroBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"NumeroPoliza\"]" ));
                numeroPoliza.sendKeys(inter_creacionSiniestroBean.getNumeroPoliza());
            }

            if (inter_creacionSiniestroBean.getFechaEmision() != null){
                Thread.sleep(2000);
                WebElement fechaEmision = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]" ));
                fechaEmision.sendKeys(inter_creacionSiniestroBean.getFechaEmision());
            }

            if (inter_creacionSiniestroBean.getMoneda() != null){
                Thread.sleep(2000);
                Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"Moneda\"]")));
                moneda.selectByValue(inter_creacionSiniestroBean.getMoneda());
            }

            if (inter_creacionSiniestroBean.getTipoProduccion() != null){
                Thread.sleep(2000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//*[@id=\"TipoProduccion\"]")));
                tipoProduccion.selectByValue(inter_creacionSiniestroBean.getTipoProduccion());
            }

            if (inter_creacionSiniestroBean.getRenovacionAutomatica() != null){
                Thread.sleep(2000);
                WebElement renovacionAutomatica = driver.findElement(By.xpath("//*[@id=\"INDAutRenovacion\"]"));
                renovacionAutomatica.sendKeys(inter_creacionSiniestroBean.getRenovacionAutomatica());
            }

            if (inter_creacionSiniestroBean.getTipoMoneda() != null){
                Thread.sleep(2000);
                Select tipoMoneda = new Select(driver.findElement(By.xpath("//*[@id=\"TipoMoneda\"]")));
                tipoMoneda.selectByValue(inter_creacionSiniestroBean.getTipoMoneda());
            }

            if (inter_creacionSiniestroBean.getTipoVigencia() != null){
                Thread.sleep(2000);
                Select tipoVigencia = new Select(driver.findElement(By.xpath("//*[@id=\"TipoVigencia\"]")));
                tipoVigencia.selectByValue(inter_creacionSiniestroBean.getTipoVigencia());
            }

            if (inter_creacionSiniestroBean.getVigencia() != null){
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//*[@id=\"Vigencia\"]")));
                vigencia.selectByValue(inter_creacionSiniestroBean.getVigencia());
            }

            if (inter_creacionSiniestroBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//*[@id=\"CanalVenta\"]")));
                canalVenta.selectByValue(inter_creacionSiniestroBean.getCanalVenta());
            }

            if (inter_creacionSiniestroBean.getFrecuenciaPago() != null){
                Thread.sleep(2000);
                Select frecuenciaPago = new Select(driver.findElement(By.xpath("//*[@id=\"FrecuenciaPago\"]")));
                frecuenciaPago.selectByValue(inter_creacionSiniestroBean.getFrecuenciaPago());
            }

            if (inter_creacionSiniestroBean.getFechaEventoAnterior() != null){
                Thread.sleep(2000);
                WebElement fechaEventoAnterior = driver.findElement(By.xpath("//*[@id=\"FechaEventoAnterior\"]" ));
                fechaEventoAnterior.sendKeys(inter_creacionSiniestroBean.getFechaEventoAnterior());
            }

            if (inter_creacionSiniestroBean.getFechaProximaGeneracionPrima() != null){
                Thread.sleep(2000);
                WebElement fechaProximaGeneracionPrima = driver.findElement(By.xpath("//*[@id=\"FechaProximaGenPrima\"]" ));
                fechaProximaGeneracionPrima.sendKeys(inter_creacionSiniestroBean.getFechaProximaGeneracionPrima());
            }

            if (inter_creacionSiniestroBean.getFechaProximaFacturacion() != null){
                Thread.sleep(2000);
                WebElement fechaProximaFacturacion = driver.findElement(By.xpath("//*[@id=\"FechaProxFacturacion\"]" ));
                fechaProximaFacturacion.sendKeys(inter_creacionSiniestroBean.getFechaProximaFacturacion());
            }

            if (inter_creacionSiniestroBean.getTipoPoliza() != null){
                Thread.sleep(2000);
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"TipoPoliza\"]")));
                tipoPoliza.selectByValue(inter_creacionSiniestroBean.getTipoPoliza());
            }


            if (inter_creacionSiniestroBean.getNumeroPolizaAs() != null){
                Thread.sleep(2000);
                WebElement numeroPolizaAs = driver.findElement(By.xpath("//*[@id=\"NumeroPolizaAS\"]" ));
                numeroPolizaAs.sendKeys(inter_creacionSiniestroBean.getNumeroPolizaAs());
            }

            if (inter_creacionSiniestroBean.getFlagSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement flagSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"FlagSuspCancel\"]" ));
                flagSuspensionCancelacion.sendKeys(inter_creacionSiniestroBean.getFlagSuspensionCancelacion());
            }

            if (inter_creacionSiniestroBean.getFechaSuspensionCancelacon() != null){
                Thread.sleep(2000);
                WebElement fechaSuspensionCancelacon = driver.findElement(By.xpath("//*[@id=\"FechaSuspCancel\"]" ));
                fechaSuspensionCancelacon.sendKeys(inter_creacionSiniestroBean.getFechaSuspensionCancelacon());
            }

            if (inter_creacionSiniestroBean.getCodigoSuperintendencia() != null){
                Thread.sleep(2000);
                WebElement codigoSuperintendencia = driver.findElement(By.xpath("//*[@id=\"CodSuperint\"]" ));
                codigoSuperintendencia.sendKeys(inter_creacionSiniestroBean.getCodigoSuperintendencia());
            }

            if (inter_creacionSiniestroBean.getNombreArchivoTramas() != null){
                Thread.sleep(2000);
                WebElement nombreArchivoTramas = driver.findElement(By.xpath("//*[@id=\"NombreArchivoTrama\"]" ));
                nombreArchivoTramas.sendKeys(inter_creacionSiniestroBean.getNombreArchivoTramas());
            }

            if (inter_creacionSiniestroBean.getNúmeroPlan() != null){
                Thread.sleep(2000);
                WebElement númeroPlan = driver.findElement(By.xpath("//*[@id=\"NumPlanInter\"]" ));
                númeroPlan.sendKeys(inter_creacionSiniestroBean.getNúmeroPlan());
            }

            if (inter_creacionSiniestroBean.getFechaInicialPolizaMatriz() != null){
                Thread.sleep(2000);
                WebElement fechaInicialPolizaMatriz = driver.findElement(By.xpath("//*[@id=\"FecIniPolMatriz\"]" ));
                fechaInicialPolizaMatriz.sendKeys(inter_creacionSiniestroBean.getFechaInicialPolizaMatriz());
            }

            if (inter_creacionSiniestroBean.getFechaFinalPolizaMatriz() != null){
                Thread.sleep(2000);
                WebElement fechaFinalPolizaMatriz = driver.findElement(By.xpath("//*[@id=\"FecFinPolMatriz\"]" ));
                fechaFinalPolizaMatriz.sendKeys(inter_creacionSiniestroBean.getFechaFinalPolizaMatriz());
            }

            if (inter_creacionSiniestroBean.getNombreAsegurado() != null){
                Thread.sleep(2000);
                WebElement nombreAsegurado = driver.findElement(By.xpath("//*[@id=\"NomComAseguradoPol\"]" ));
                nombreAsegurado.sendKeys(inter_creacionSiniestroBean.getNombreAsegurado());
            }

            if (inter_creacionSiniestroBean.getNombreBeneficiario() != null){
                Thread.sleep(2000);
                WebElement nombreBeneficiario = driver.findElement(By.xpath("//*[@id=\"NomComBeneficiarioPol\"]" ));
                nombreBeneficiario.sendKeys(inter_creacionSiniestroBean.getNombreBeneficiario());
            }

            if (inter_creacionSiniestroBean.getPeriodoSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement periodoSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"JobSupDays\"]" ));
                periodoSuspensionCancelacion.sendKeys(inter_creacionSiniestroBean.getPeriodoSuspensionCancelacion());
            }

            if (inter_creacionSiniestroBean.getFechaInicioSuspCanc() != null){
                Thread.sleep(2000);
                WebElement fechaInicioSuspCanc = driver.findElement(By.xpath("//*[@id=\"JobSupDate\"]" ));
                fechaInicioSuspCanc.sendKeys(inter_creacionSiniestroBean.getFechaInicioSuspCanc());
            }

            if (inter_creacionSiniestroBean.getProcSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement procSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"JobSupInd\"]" ));
                procSuspensionCancelacion.sendKeys(inter_creacionSiniestroBean.getProcSuspensionCancelacion());
            }

            if (inter_creacionSiniestroBean.getMontoPrimaArchivoTrama() != null){
                Thread.sleep(2000);
                WebElement montoPrimaArchivoTrama = driver.findElement(By.xpath("//*[@id=\"PrimaTrama\"]" ));
                montoPrimaArchivoTrama.sendKeys(inter_creacionSiniestroBean.getMontoPrimaArchivoTrama());
            }

            if (inter_creacionSiniestroBean.getFechaEmisionAcsele() != null){
                Thread.sleep(2000);
                WebElement fechaEmisionAcsele = driver.findElement(By.xpath("//*[@id=\"FechaCargaSistema\"]" ));
                fechaEmisionAcsele.sendKeys(inter_creacionSiniestroBean.getFechaEmisionAcsele());
            }

            if (inter_creacionSiniestroBean.getNumeroSolicitud() != null){
                Thread.sleep(2000);
                WebElement numeroSolicitud = driver.findElement(By.xpath("//*[@id=\"NumeroSolicitud\"]" ));
                numeroSolicitud.sendKeys(inter_creacionSiniestroBean.getNumeroSolicitud());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i, "screen4",nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformpolicy_01\"]"));
            btnBuscar.click();

            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda (WebDriver driver, Interseguros_Metodos a, INTER_CreacionSiniestroBean inter_creacionSiniestroBean, int i){
        try {
            Thread.sleep(2000);

            WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr/td[2]/input[4]"));
            fechaOcurrenciaSiniestro.sendKeys(inter_creacionSiniestroBean.getFechaOcurrenciaSiniestro());

            Thread.sleep(2000);
            Select sucursal = new Select(driver.findElement(By.xpath("//*[@id=\"userAgency\"]")));
            sucursal.selectByValue(inter_creacionSiniestroBean.getSucursal());

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

            WebElement selecEvento = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[6]/td[1]/input"));
            selecEvento.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);

            btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_policyEventsToClaim_01\"]"));
            btnEnviar.click();

            Thread.sleep(5000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_07\"]"));
            btnAceptar.click();

            Thread.sleep(20000);
            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (WebDriver driver, Interseguros_Metodos a, INTER_CreacionSiniestroBean inter_creacionSiniestroBean, int i){
        try {
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
            btnAgregar.click();

            Thread.sleep(20000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Thread.sleep(3000);
            if (inter_creacionSiniestroBean.getNumeroCaso() != null){
            Select numeroCaso = new Select(driver.findElement(By.xpath("//*[@id=\"NumeroCaso\"]")));
            numeroCaso.selectByValue(inter_creacionSiniestroBean.getNumeroCaso());
            }

            WebElement fechaNotificacion = driver.findElement(By.xpath("//*[@id=\"FechaNotificacion\"]"));
            fechaNotificacion.sendKeys(inter_creacionSiniestroBean.getFechaNotificacion());

            Thread.sleep(1000);
            WebElement fechaRecepcionReclamo = driver.findElement(By.xpath("//*[@id=\"FechaRecepcion\"]"));
            fechaRecepcionReclamo.sendKeys(inter_creacionSiniestroBean.getFechaRecepcionReclamo());


            if (inter_creacionSiniestroBean.getFechaOcurrencia() != null){
                Select fechaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
                fechaOcurrencia.selectByValue(inter_creacionSiniestroBean.getFechaOcurrencia());
            }

            if (inter_creacionSiniestroBean.getLugarOcurrenciaSiniestro() != null){
                WebElement lugarOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"LugarOcurrencia\"]"));
                lugarOcurrenciaSiniestro.sendKeys(inter_creacionSiniestroBean.getLugarOcurrenciaSiniestro());
            }

            if (inter_creacionSiniestroBean.getHoraOcurrencia() != null){
                WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"HoraOcurrencia\"]"));
                fechaInterrupcionTerminos.sendKeys(inter_creacionSiniestroBean.getHoraOcurrencia());
            }

            if (inter_creacionSiniestroBean.getObservacionesSiniestro() != null){
                WebElement observacionesSiniestro = driver.findElement(By.xpath("//*[@id=\"ObservacionesSin\"]"));
                observacionesSiniestro.sendKeys(inter_creacionSiniestroBean.getObservacionesSiniestro());
            }

            if (inter_creacionSiniestroBean.getNombresApellidos() != null){
                WebElement nombresApellidos = driver.findElement(By.xpath("//*[@id=\"NombreSolSin\"]"));
                nombresApellidos.sendKeys(inter_creacionSiniestroBean.getNombresApellidos());
            }

            if (inter_creacionSiniestroBean.getDireccion() != null){
                WebElement direccion = driver.findElement(By.xpath("//*[@id=\"DireccionSolSin\"]"));
                direccion.sendKeys(inter_creacionSiniestroBean.getDireccion());
            }

            if (inter_creacionSiniestroBean.getTelefonos() != null){
                WebElement telefonos = driver.findElement(By.xpath("//*[@id=\"TelefonoSolSin\"]"));
                telefonos.sendKeys(inter_creacionSiniestroBean.getTelefonos());
            }

            if (inter_creacionSiniestroBean.getCorreoElectronico() != null){
                WebElement correoElectronico = driver.findElement(By.xpath("//*[@id=\"EmailSolSin\"]"));
                correoElectronico.sendKeys(inter_creacionSiniestroBean.getCorreoElectronico());
            }

            if (inter_creacionSiniestroBean.getEnvioComunicacionesSiniestro() != null){
                Select envioComunicacionesSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"ComunicacionSiniestro\"]")));
                envioComunicacionesSiniestro.selectByValue(inter_creacionSiniestroBean.getEnvioComunicacionesSiniestro());
            }

            if (inter_creacionSiniestroBean.getCorreoElectronicoSiniestro() != null){
                Select envioComunicacionesSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"EmailEnvioSiniestro\"]")));
                envioComunicacionesSiniestro.selectByValue(inter_creacionSiniestroBean.getCorreoElectronicoSiniestro());
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

    public void AgregarCobertura (WebDriver driver, Interseguros_Metodos a, INTER_CreacionSiniestroBean inter_creacionSiniestroBean, int i){
        try{

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]"));
            btnAgregar.click();
            Thread.sleep(15000);

            WebElement pagoMaximo = driver.findElement(By.xpath("//*[@id=\"maxBenefitAmount1\"]"));
            pagoMaximo.clear();
            pagoMaximo.sendKeys(inter_creacionSiniestroBean.getPagoMaximo());

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen11",nombreAutomatizacion);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_addCoverages_03\"]"));
            btnEnviar.click();

            Thread.sleep(3000);

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            Thread.sleep(3000);

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

            WebElement btnAceptardos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_contextPageClaimTool_01\"]"));
            btnAceptardos.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarRequisitos (WebDriver driver, Interseguros_Metodos a, INTER_CreacionSiniestroBean inter_creacionSiniestroBean, int i){
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
            a.ScreenShotPool(driver,i,"screen12",nombreAutomatizacion);

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

    public void AgregarPagos (WebDriver driver, Interseguros_Metodos a, INTER_CreacionSiniestroBean inter_creacionSiniestroBean, int i){
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
            a.ScreenShotPool(driver,i,"screen13",nombreAutomatizacion);
            WebElement tercerosPoliza = driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]"));
            tercerosPoliza.click();

            Thread.sleep(10000);
            WebElement seleccionTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input"));
            seleccionTercero.click();
            a.ScreenShotPool(driver,i,"screen14",nombreAutomatizacion);

            Thread.sleep(4000);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_resultClaimThirdParty_01\"]"));
            btnEnviar.click();

            Thread.sleep(15000);
            a.ScreenShotPool(driver,i,"screen15",nombreAutomatizacion);
            WebElement btnEditar = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[1]/input[2]"));
            btnEditar.click();
            Thread.sleep(10000);
            a.ScreenShotPool(driver,i,"screen16",nombreAutomatizacion);

           /* if (inter_creacionSiniestroBean.getFechaCompromiso() != null){
                Thread.sleep(2000);
                WebElement fechaCompromiso = driver.findElement(By.xpath("/*//*[@id=\"calendarcommitmentDateShow\"]"));
                fechaCompromiso.sendKeys(inter_creacionSiniestroBean.getFechaCompromiso());
            }

            if (inter_creacionSiniestroBean.getFechaInicial() != null){
                Thread.sleep(2000);
                WebElement fechaInicial = driver.findElement(By.xpath("/*//*[@id=\"calendarstartDateShow\"]"));
                fechaInicial.sendKeys(inter_creacionSiniestroBean.getFechaInicial());
            }

            if (inter_creacionSiniestroBean.getFechaFinal() != null){
                Thread.sleep(2000);
                WebElement fechaFinal = driver.findElement(By.xpath("/*//*[@id=\"calendarendDateShow\"]"));
                fechaFinal.sendKeys(inter_creacionSiniestroBean.getFechaFinal());
            }*/

            if (inter_creacionSiniestroBean.getRazon() != null){
                Thread.sleep(2000);
                WebElement razon = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[11]/textarea"));
                razon.sendKeys(inter_creacionSiniestroBean.getRazon());
            }

            /*if (inter_creacionSiniestroBean.getEstado() != null){
                Thread.sleep(2000);
                Select estado = new Select(driver.findElement(By.xpath("/*//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[12]/select")));
                estado.selectByValue(inter_creacionSiniestroBean.getEstado());
            }

            if (inter_creacionSiniestroBean.getTipo() != null){
                Thread.sleep(2000);
                Select tipo = new Select(driver.findElement(By.xpath("/*//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[13]/select")));
                tipo.selectByValue(inter_creacionSiniestroBean.getTipo());
            }*/

            Thread.sleep(4000);
            WebElement montoSiniestro = driver.findElement(By.xpath("//*[@id=\"amount1\"]"));
            montoSiniestro.clear();
            montoSiniestro.sendKeys(inter_creacionSiniestroBean.getMontoSiniestro());
            Thread.sleep(1000);
            WebElement razon2 = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[11]/textarea"));
            razon2.click();


            Thread.sleep(15000);
            a.ScreenShotPool(driver,i,"screen17",nombreAutomatizacion);

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
            a.ScreenShotPool(driver,i,"screen18",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }





}
