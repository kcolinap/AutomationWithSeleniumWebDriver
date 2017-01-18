package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CancelarPagosBean;
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
 * Created by aazuaje on 16/01/2017.
 */
public class INTER_CancelarPagos {

    private final static Logger log = Logger.getLogger(INTER_CreacionSiniestro.class);

    public String nombreAutomatizacion = "Creacion Siniestros";

    public void testLink(INTER_CancelarPagosBean inter_cancelarPagosBean,int i) throws IOException, InterruptedException {

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
        BuscarPoliza(driver, a, inter_cancelarPagosBean ,i);
        ResultadoBusqueda(driver, a, inter_cancelarPagosBean , i);
        AgregarObjetoAfectado(driver, a, inter_cancelarPagosBean, i);
        AgregarCobertura(driver, a, inter_cancelarPagosBean, i);
        AgregarRequisitos(driver, a, inter_cancelarPagosBean,i);
        AgregarPagos(driver, a, inter_cancelarPagosBean, i);

    }

    public void BuscarPoliza(WebDriver driver, Interseguros_Metodos a, INTER_CancelarPagosBean inter_cancelarPagosBean, int i) throws IOException, InterruptedException{

        try {

            if (inter_cancelarPagosBean.getOrdenarPor() != null){
                Thread.sleep(2000);
                Select ordenarPor = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(inter_cancelarPagosBean.getOrdenarPor());
            }
            if (inter_cancelarPagosBean.getProducto() != null){
                Thread.sleep(2000);
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));
                producto.selectByValue(inter_cancelarPagosBean.getProducto());
                Thread.sleep(8000);
            }

            if (inter_cancelarPagosBean.getEstadosCicloVida() != null){
                Thread.sleep(2000);
                Select estadosCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));
                estadosCicloVida.selectByValue(inter_cancelarPagosBean.getEstadosCicloVida());
            }

            if (inter_cancelarPagosBean.getContratante() != null){
                Thread.sleep(2000);
                WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(inter_cancelarPagosBean.getContratante());
            }

            if (inter_cancelarPagosBean.getAseguradoEstipulante() != null){
                Thread.sleep(2000);
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(inter_cancelarPagosBean.getAseguradoEstipulante());
            }

            if (inter_cancelarPagosBean.getIdPoliza() != null){
                Thread.sleep(2000);
                WebElement idPoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]" ));
                idPoliza.sendKeys(inter_cancelarPagosBean.getIdPoliza());
            }

            if (inter_cancelarPagosBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]" ));
                fechaDesde.sendKeys(inter_cancelarPagosBean.getFechaDesde());
            }

            if (inter_cancelarPagosBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("//*[@id=\"_toDateShow\"]" ));
                fechaHasta.sendKeys(inter_cancelarPagosBean.getFechaHasta());
            }

            if (inter_cancelarPagosBean.getOficina() != null){
                Thread.sleep(2000);
                Select oficina = new Select(driver.findElement(By.xpath("//*[@id=\"Oficina\"]")));
                oficina.selectByValue(inter_cancelarPagosBean.getOficina());
            }

            if (inter_cancelarPagosBean.getNumeroCotizacion() != null){
                Thread.sleep(2000);
                WebElement numeroCotizacion = driver.findElement(By.xpath("//*[@id=\"NumeroCotizacion\"]" ));
                numeroCotizacion.sendKeys(inter_cancelarPagosBean.getNumeroCotizacion());
            }

            if (inter_cancelarPagosBean.getNumeroPropuesta() != null){
                Thread.sleep(2000);
                WebElement numeroPropuesta = driver.findElement(By.xpath("//*[@id=\"NumeroPropuesta\"]" ));
                numeroPropuesta.sendKeys(inter_cancelarPagosBean.getNumeroPropuesta());
            }

            if (inter_cancelarPagosBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"NumeroPoliza\"]" ));
                numeroPoliza.sendKeys(inter_cancelarPagosBean.getNumeroPoliza());
            }

            if (inter_cancelarPagosBean.getFechaEmision() != null){
                Thread.sleep(2000);
                WebElement fechaEmision = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]" ));
                fechaEmision.sendKeys(inter_cancelarPagosBean.getFechaEmision());
            }

            if (inter_cancelarPagosBean.getMoneda() != null){
                Thread.sleep(2000);
                Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"Moneda\"]")));
                moneda.selectByValue(inter_cancelarPagosBean.getMoneda());
            }

            if (inter_cancelarPagosBean.getTipoProduccion() != null){
                Thread.sleep(2000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//*[@id=\"TipoProduccion\"]")));
                tipoProduccion.selectByValue(inter_cancelarPagosBean.getTipoProduccion());
            }

            if (inter_cancelarPagosBean.getRenovacionAutomatica() != null){
                Thread.sleep(2000);
                WebElement renovacionAutomatica = driver.findElement(By.xpath("//*[@id=\"INDAutRenovacion\"]"));
                renovacionAutomatica.sendKeys(inter_cancelarPagosBean.getRenovacionAutomatica());
            }

            if (inter_cancelarPagosBean.getTipoMoneda() != null){
                Thread.sleep(2000);
                Select tipoMoneda = new Select(driver.findElement(By.xpath("//*[@id=\"TipoMoneda\"]")));
                tipoMoneda.selectByValue(inter_cancelarPagosBean.getTipoMoneda());
            }

            if (inter_cancelarPagosBean.getTipoVigencia() != null){
                Thread.sleep(2000);
                Select tipoVigencia = new Select(driver.findElement(By.xpath("//*[@id=\"TipoVigencia\"]")));
                tipoVigencia.selectByValue(inter_cancelarPagosBean.getTipoVigencia());
            }

            if (inter_cancelarPagosBean.getVigencia() != null){
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//*[@id=\"Vigencia\"]")));
                vigencia.selectByValue(inter_cancelarPagosBean.getVigencia());
            }

            if (inter_cancelarPagosBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//*[@id=\"CanalVenta\"]")));
                canalVenta.selectByValue(inter_cancelarPagosBean.getCanalVenta());
            }

            if (inter_cancelarPagosBean.getFrecuenciaPago() != null){
                Thread.sleep(2000);
                Select frecuenciaPago = new Select(driver.findElement(By.xpath("//*[@id=\"FrecuenciaPago\"]")));
                frecuenciaPago.selectByValue(inter_cancelarPagosBean.getFrecuenciaPago());
            }

            if (inter_cancelarPagosBean.getFechaEventoAnterior() != null){
                Thread.sleep(2000);
                WebElement fechaEventoAnterior = driver.findElement(By.xpath("//*[@id=\"FechaEventoAnterior\"]" ));
                fechaEventoAnterior.sendKeys(inter_cancelarPagosBean.getFechaEventoAnterior());
            }

            if (inter_cancelarPagosBean.getFechaProximaGeneracionPrima() != null){
                Thread.sleep(2000);
                WebElement fechaProximaGeneracionPrima = driver.findElement(By.xpath("//*[@id=\"FechaProximaGenPrima\"]" ));
                fechaProximaGeneracionPrima.sendKeys(inter_cancelarPagosBean.getFechaProximaGeneracionPrima());
            }

            if (inter_cancelarPagosBean.getFechaProximaFacturacion() != null){
                Thread.sleep(2000);
                WebElement fechaProximaFacturacion = driver.findElement(By.xpath("//*[@id=\"FechaProxFacturacion\"]" ));
                fechaProximaFacturacion.sendKeys(inter_cancelarPagosBean.getFechaProximaFacturacion());
            }

            if (inter_cancelarPagosBean.getTipoPoliza() != null){
                Thread.sleep(2000);
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"TipoPoliza\"]")));
                tipoPoliza.selectByValue(inter_cancelarPagosBean.getTipoPoliza());
            }


            if (inter_cancelarPagosBean.getNumeroPolizaAs() != null){
                Thread.sleep(2000);
                WebElement numeroPolizaAs = driver.findElement(By.xpath("//*[@id=\"NumeroPolizaAS\"]" ));
                numeroPolizaAs.sendKeys(inter_cancelarPagosBean.getNumeroPolizaAs());
            }

            if (inter_cancelarPagosBean.getFlagSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement flagSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"FlagSuspCancel\"]" ));
                flagSuspensionCancelacion.sendKeys(inter_cancelarPagosBean.getFlagSuspensionCancelacion());
            }

            if (inter_cancelarPagosBean.getFechaSuspensionCancelacon() != null){
                Thread.sleep(2000);
                WebElement fechaSuspensionCancelacon = driver.findElement(By.xpath("//*[@id=\"FechaSuspCancel\"]" ));
                fechaSuspensionCancelacon.sendKeys(inter_cancelarPagosBean.getFechaSuspensionCancelacon());
            }

            if (inter_cancelarPagosBean.getCodigoSuperintendencia() != null){
                Thread.sleep(2000);
                WebElement codigoSuperintendencia = driver.findElement(By.xpath("//*[@id=\"CodSuperint\"]" ));
                codigoSuperintendencia.sendKeys(inter_cancelarPagosBean.getCodigoSuperintendencia());
            }

            if (inter_cancelarPagosBean.getNombreArchivoTramas() != null){
                Thread.sleep(2000);
                WebElement nombreArchivoTramas = driver.findElement(By.xpath("//*[@id=\"NombreArchivoTrama\"]" ));
                nombreArchivoTramas.sendKeys(inter_cancelarPagosBean.getNombreArchivoTramas());
            }

            if (inter_cancelarPagosBean.getNúmeroPlan() != null){
                Thread.sleep(2000);
                WebElement númeroPlan = driver.findElement(By.xpath("//*[@id=\"NumPlanInter\"]" ));
                númeroPlan.sendKeys(inter_cancelarPagosBean.getNúmeroPlan());
            }

            if (inter_cancelarPagosBean.getFechaInicialPolizaMatriz() != null){
                Thread.sleep(2000);
                WebElement fechaInicialPolizaMatriz = driver.findElement(By.xpath("//*[@id=\"FecIniPolMatriz\"]" ));
                fechaInicialPolizaMatriz.sendKeys(inter_cancelarPagosBean.getFechaInicialPolizaMatriz());
            }

            if (inter_cancelarPagosBean.getFechaFinalPolizaMatriz() != null){
                Thread.sleep(2000);
                WebElement fechaFinalPolizaMatriz = driver.findElement(By.xpath("//*[@id=\"FecFinPolMatriz\"]" ));
                fechaFinalPolizaMatriz.sendKeys(inter_cancelarPagosBean.getFechaFinalPolizaMatriz());
            }

            if (inter_cancelarPagosBean.getNombreAsegurado() != null){
                Thread.sleep(2000);
                WebElement nombreAsegurado = driver.findElement(By.xpath("//*[@id=\"NomComAseguradoPol\"]" ));
                nombreAsegurado.sendKeys(inter_cancelarPagosBean.getNombreAsegurado());
            }

            if (inter_cancelarPagosBean.getNombreBeneficiario() != null){
                Thread.sleep(2000);
                WebElement nombreBeneficiario = driver.findElement(By.xpath("//*[@id=\"NomComBeneficiarioPol\"]" ));
                nombreBeneficiario.sendKeys(inter_cancelarPagosBean.getNombreBeneficiario());
            }

            if (inter_cancelarPagosBean.getPeriodoSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement periodoSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"JobSupDays\"]" ));
                periodoSuspensionCancelacion.sendKeys(inter_cancelarPagosBean.getPeriodoSuspensionCancelacion());
            }

            if (inter_cancelarPagosBean.getFechaInicioSuspCanc() != null){
                Thread.sleep(2000);
                WebElement fechaInicioSuspCanc = driver.findElement(By.xpath("//*[@id=\"JobSupDate\"]" ));
                fechaInicioSuspCanc.sendKeys(inter_cancelarPagosBean.getFechaInicioSuspCanc());
            }

            if (inter_cancelarPagosBean.getProcSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement procSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"JobSupInd\"]" ));
                procSuspensionCancelacion.sendKeys(inter_cancelarPagosBean.getProcSuspensionCancelacion());
            }

            if (inter_cancelarPagosBean.getMontoPrimaArchivoTrama() != null){
                Thread.sleep(2000);
                WebElement montoPrimaArchivoTrama = driver.findElement(By.xpath("//*[@id=\"PrimaTrama\"]" ));
                montoPrimaArchivoTrama.sendKeys(inter_cancelarPagosBean.getMontoPrimaArchivoTrama());
            }

            if (inter_cancelarPagosBean.getFechaEmisionAcsele() != null){
                Thread.sleep(2000);
                WebElement fechaEmisionAcsele = driver.findElement(By.xpath("//*[@id=\"FechaCargaSistema\"]" ));
                fechaEmisionAcsele.sendKeys(inter_cancelarPagosBean.getFechaEmisionAcsele());
            }

            if (inter_cancelarPagosBean.getNumeroSolicitud() != null){
                Thread.sleep(2000);
                WebElement numeroSolicitud = driver.findElement(By.xpath("//*[@id=\"NumeroSolicitud\"]" ));
                numeroSolicitud.sendKeys(inter_cancelarPagosBean.getNumeroSolicitud());
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

    public void ResultadoBusqueda (WebDriver driver, Interseguros_Metodos a, INTER_CancelarPagosBean inter_cancelarPagosBean, int i){
        try {
            Thread.sleep(2000);

            WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr/td[2]/input[4]"));
            fechaOcurrenciaSiniestro.sendKeys(inter_cancelarPagosBean.getFechaOcurrenciaSiniestro());

            Thread.sleep(2000);
            Select sucursal = new Select(driver.findElement(By.xpath("//*[@id=\"userAgency\"]")));
            sucursal.selectByValue(inter_cancelarPagosBean.getSucursal());

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

            WebElement selecEvento = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[3]/td[1]/input"));
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

    public void AgregarObjetoAfectado (WebDriver driver, Interseguros_Metodos a, INTER_CancelarPagosBean inter_cancelarPagosBean, int i){
        try {
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
            btnAgregar.click();

            Thread.sleep(20000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Thread.sleep(3000);
            if (inter_cancelarPagosBean.getNumeroCaso() != null){
                Select numeroCaso = new Select(driver.findElement(By.xpath("//*[@id=\"NumeroCaso\"]")));
                numeroCaso.selectByValue(inter_cancelarPagosBean.getNumeroCaso());
            }

            WebElement fechaNotificacion = driver.findElement(By.xpath("//*[@id=\"FechaNotificacion\"]"));
            fechaNotificacion.sendKeys(inter_cancelarPagosBean.getFechaNotificacion());

            Thread.sleep(1000);
            WebElement fechaRecepcionReclamo = driver.findElement(By.xpath("//*[@id=\"FechaRecepcion\"]"));
            fechaRecepcionReclamo.sendKeys(inter_cancelarPagosBean.getFechaRecepcionReclamo());


            if (inter_cancelarPagosBean.getFechaOcurrencia() != null){
                Select fechaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
                fechaOcurrencia.selectByValue(inter_cancelarPagosBean.getFechaOcurrencia());
            }

            if (inter_cancelarPagosBean.getLugarOcurrenciaSiniestro() != null){
                WebElement lugarOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"LugarOcurrencia\"]"));
                lugarOcurrenciaSiniestro.sendKeys(inter_cancelarPagosBean.getLugarOcurrenciaSiniestro());
            }

            if (inter_cancelarPagosBean.getHoraOcurrencia() != null){
                WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"HoraOcurrencia\"]"));
                fechaInterrupcionTerminos.sendKeys(inter_cancelarPagosBean.getHoraOcurrencia());
            }

            /*if (inter_cancelarPagosBean.getObservacionesSiniestro() != null){
                WebElement observacionesSiniestro = driver.findElement(By.xpath("/*//*[@id=\"ObservacionesSin\"]"));
                observacionesSiniestro.sendKeys(inter_cancelarPagosBean.getObservacionesSiniestro());
            }*/

            if (inter_cancelarPagosBean.getNombresApellidos() != null){
                WebElement nombresApellidos = driver.findElement(By.xpath("//*[@id=\"NombreSolSin\"]"));
                nombresApellidos.sendKeys(inter_cancelarPagosBean.getNombresApellidos());
            }

            if (inter_cancelarPagosBean.getDireccion() != null){
                WebElement direccion = driver.findElement(By.xpath("//*[@id=\"DireccionSolSin\"]"));
                direccion.sendKeys(inter_cancelarPagosBean.getDireccion());
            }

            if (inter_cancelarPagosBean.getTelefonos() != null){
                WebElement telefonos = driver.findElement(By.xpath("//*[@id=\"TelefonoSolSin\"]"));
                telefonos.sendKeys(inter_cancelarPagosBean.getTelefonos());
            }

            if (inter_cancelarPagosBean.getCorreoElectronico() != null){
                WebElement correoElectronico = driver.findElement(By.xpath("//*[@id=\"EmailSolSin\"]"));
                correoElectronico.sendKeys(inter_cancelarPagosBean.getCorreoElectronico());
            }

            if (inter_cancelarPagosBean.getEnvioComunicacionesSiniestro() != null){
                Select envioComunicacionesSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"ComunicacionSiniestro\"]")));
                envioComunicacionesSiniestro.selectByValue(inter_cancelarPagosBean.getEnvioComunicacionesSiniestro());
            }

            if (inter_cancelarPagosBean.getCorreoElectronicoSiniestro() != null){
                Select envioComunicacionesSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"EmailEnvioSiniestro\"]")));
                envioComunicacionesSiniestro.selectByValue(inter_cancelarPagosBean.getCorreoElectronicoSiniestro());
            }

            /*if (inter_cancelarPagosBean.getSexo() != null){
                Select sexo = new Select(driver.findElement(By.xpath("/*//*[@id=\"SexoSolSin\"]")));
                sexo.selectByValue(inter_cancelarPagosBean.getSexo());
            }*/


            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen9",nombreAutomatizacion);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
            btnAceptar.click();

            Thread.sleep(8000);

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarCobertura (WebDriver driver, Interseguros_Metodos a, INTER_CancelarPagosBean inter_cancelarPagosBean, int i){
        try{

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]"));
            btnAgregar.click();
            Thread.sleep(7000);

            WebElement pagoMaximo = driver.findElement(By.xpath("//*[@id=\"maxBenefitAmount1\"]"));
            pagoMaximo.clear();
            pagoMaximo.sendKeys(inter_cancelarPagosBean.getPagoMaximo());

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen11",nombreAutomatizacion);
            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_addCoverages_03\"]"));
            btnEnviar.click();

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

            Thread.sleep(3000);

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

            Thread.sleep(5000);
            WebElement btnAceptaruno = driver.findElement(By.xpath("//*[@id=\"idb_0402006_contextPageClaimTool_01\"]"));
            btnAceptaruno.click();

            Thread.sleep(6000);
            WebElement cobertura2 = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura2.click();

            Thread.sleep(2000);
            WebElement btnAceptardos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_06\"]"));
            btnAceptardos.click();


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

    public void AgregarRequisitos (WebDriver driver, Interseguros_Metodos a, INTER_CancelarPagosBean inter_cancelarPagosBean, int i){
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

    public void AgregarPagos (WebDriver driver, Interseguros_Metodos a, INTER_CancelarPagosBean inter_cancelarPagosBean, int i){
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
            a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion);
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

            if (inter_cancelarPagosBean.getRazon() != null){
                Thread.sleep(2000);
                WebElement razon = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[11]/textarea"));
                razon.sendKeys(inter_cancelarPagosBean.getRazon());
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
            montoSiniestro.sendKeys(inter_cancelarPagosBean.getMontoSiniestro());
            Thread.sleep(1000);
            WebElement razon2 = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[4]/td[11]/textarea"));
            razon2.click();


            Thread.sleep(15000);
            a.ScreenShotPool(driver,i,"screen17",nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement btnEnviar2 = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimPaymentDetail_01\"]"));
            btnEnviar2.click();
            Thread.sleep(20000);


            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]"));
            btnSeleccionar.click();

            Thread.sleep(2000);
            Select aprobar = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
            aprobar.selectByValue(inter_cancelarPagosBean.getAprobar());
            Thread.sleep(3000);


            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            Thread.sleep(5000);

            /*Select sucursalSiniestros = new Select(driver.findElement(By.xpath("/*//*[@id=\"divBranchOffice\"]/form/table/tbody/tr[3]/td[1]/table/tbody/tr/td[2]/select")));
            sucursalSiniestros.selectByValue(inter_cancelarPagosBean.getSucursalSiniestros());
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen18",nombreAutomatizacion);*/

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"divBranchOffice\"]/form/table/tbody/tr[5]/td/button"));
            btnAceptar.click();

            Thread.sleep(3000);


/*if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }*/
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen19",nombreAutomatizacion);

            WebElement btnSeleccionar2 = driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]"));
            btnSeleccionar2.click();

            Thread.sleep(2000);
            Select cancelar = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
            cancelar.selectByValue(inter_cancelarPagosBean.getCancelar());
            Thread.sleep(2000);


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
    
}
