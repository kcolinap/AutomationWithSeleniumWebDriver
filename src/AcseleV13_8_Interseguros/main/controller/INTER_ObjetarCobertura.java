package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ObjetarCoberturaBean;
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
 * Created by aazuaje on 20/12/2016.
 */
public class INTER_ObjetarCobertura {

    private final static Logger log = Logger.getLogger(INTER_ObjetarCobertura.class);

    public String nombreAutomatizacion = "Objetar Cobertura";
    private WebDriver driver;

    public void testLink(INTER_ObjetarCoberturaBean inter_objetarCoberturaBean, int i, String folderName){

        try {

            //implementando clase de metodos
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            m.OpeSini_CreacionSiniestro(driver, a, nombreAutomatizacion, 3, i);
            Thread.sleep(5000);
            a.cambiarVentana(driver);
            BuscarPoliza(a, inter_objetarCoberturaBean, i, folderName, 4);
            ResultadoBusqueda(a, inter_objetarCoberturaBean, i, folderName, 5, 6, 7, 8);
            AgregarObjetoAfectado(a, inter_objetarCoberturaBean, i, folderName, 9, 10);
            AgregarCobertura(a, inter_objetarCoberturaBean, i, folderName, 11, 12, 13);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarPoliza(Interseguros_Metodos a, INTER_ObjetarCoberturaBean inter_objetarCoberturaBean, int i, String folderName, int numScreenShoot){

        try {

            if (inter_objetarCoberturaBean.getOrdenarPor() != null){
                Thread.sleep(2000);
                Select ordenarPor = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));
                ordenarPor.selectByValue(inter_objetarCoberturaBean.getOrdenarPor());
            }
            if (inter_objetarCoberturaBean.getProducto() != null){
                Thread.sleep(2000);
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));
                producto.selectByValue(inter_objetarCoberturaBean.getProducto());
                Thread.sleep(8000);
            }

            if (inter_objetarCoberturaBean.getEstadosCicloVida() != null){
                Thread.sleep(2000);
                Select estadosCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));
                estadosCicloVida.selectByValue(inter_objetarCoberturaBean.getEstadosCicloVida());
            }

            if (inter_objetarCoberturaBean.getContratante() != null){
                Thread.sleep(2000);
                WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(inter_objetarCoberturaBean.getContratante());
            }

            if (inter_objetarCoberturaBean.getAseguradoEstipulante() != null){
                Thread.sleep(2000);
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(inter_objetarCoberturaBean.getAseguradoEstipulante());
            }

            if (inter_objetarCoberturaBean.getIdPoliza() != null){
                Thread.sleep(2000);
                WebElement idPoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]" ));
                idPoliza.sendKeys(inter_objetarCoberturaBean.getIdPoliza());
            }

            if (inter_objetarCoberturaBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]" ));
                fechaDesde.sendKeys(inter_objetarCoberturaBean.getFechaDesde());
            }

            if (inter_objetarCoberturaBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("//*[@id=\"_toDateShow\"]" ));
                fechaHasta.sendKeys(inter_objetarCoberturaBean.getFechaHasta());
            }

            if (inter_objetarCoberturaBean.getOficina() != null){
                Thread.sleep(2000);
                Select oficina = new Select(driver.findElement(By.xpath("//*[@id=\"Oficina\"]")));
                oficina.selectByValue(inter_objetarCoberturaBean.getOficina());
            }

            if (inter_objetarCoberturaBean.getNumeroCotizacion() != null){
                Thread.sleep(2000);
                WebElement numeroCotizacion = driver.findElement(By.xpath("//*[@id=\"NumeroCotizacion\"]" ));
                numeroCotizacion.sendKeys(inter_objetarCoberturaBean.getNumeroCotizacion());
            }

            if (inter_objetarCoberturaBean.getNumeroPropuesta() != null){
                Thread.sleep(2000);
                WebElement numeroPropuesta = driver.findElement(By.xpath("//*[@id=\"NumeroPropuesta\"]" ));
                numeroPropuesta.sendKeys(inter_objetarCoberturaBean.getNumeroPropuesta());
            }

            if (inter_objetarCoberturaBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"NumeroPoliza\"]" ));
                numeroPoliza.sendKeys(inter_objetarCoberturaBean.getNumeroPoliza());
            }

            if (inter_objetarCoberturaBean.getFechaEmision() != null){
                Thread.sleep(2000);
                WebElement fechaEmision = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]" ));
                fechaEmision.sendKeys(inter_objetarCoberturaBean.getFechaEmision());
            }

            if (inter_objetarCoberturaBean.getMoneda() != null){
                Thread.sleep(2000);
                Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"Moneda\"]")));
                moneda.selectByValue(inter_objetarCoberturaBean.getMoneda());
            }

            if (inter_objetarCoberturaBean.getTipoProduccion() != null){
                Thread.sleep(2000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//*[@id=\"TipoProduccion\"]")));
                tipoProduccion.selectByValue(inter_objetarCoberturaBean.getTipoProduccion());
            }

            if (inter_objetarCoberturaBean.getRenovacionAutomatica() != null){
                Thread.sleep(2000);
                WebElement renovacionAutomatica = driver.findElement(By.xpath("//*[@id=\"INDAutRenovacion\"]"));
                renovacionAutomatica.sendKeys(inter_objetarCoberturaBean.getRenovacionAutomatica());
            }

            if (inter_objetarCoberturaBean.getTipoMoneda() != null){
                Thread.sleep(2000);
                Select tipoMoneda = new Select(driver.findElement(By.xpath("//*[@id=\"TipoMoneda\"]")));
                tipoMoneda.selectByValue(inter_objetarCoberturaBean.getTipoMoneda());
            }

            if (inter_objetarCoberturaBean.getTipoVigencia() != null){
                Thread.sleep(2000);
                Select tipoVigencia = new Select(driver.findElement(By.xpath("//*[@id=\"TipoVigencia\"]")));
                tipoVigencia.selectByValue(inter_objetarCoberturaBean.getTipoVigencia());
            }

            if (inter_objetarCoberturaBean.getVigencia() != null){
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//*[@id=\"Vigencia\"]")));
                vigencia.selectByValue(inter_objetarCoberturaBean.getVigencia());
            }

            if (inter_objetarCoberturaBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//*[@id=\"CanalVenta\"]")));
                canalVenta.selectByValue(inter_objetarCoberturaBean.getCanalVenta());
            }

            if (inter_objetarCoberturaBean.getFrecuenciaPago() != null){
                Thread.sleep(2000);
                Select frecuenciaPago = new Select(driver.findElement(By.xpath("//*[@id=\"FrecuenciaPago\"]")));
                frecuenciaPago.selectByValue(inter_objetarCoberturaBean.getFrecuenciaPago());
            }

            if (inter_objetarCoberturaBean.getFechaEventoAnterior() != null){
                Thread.sleep(2000);
                WebElement fechaEventoAnterior = driver.findElement(By.xpath("//*[@id=\"FechaEventoAnterior\"]" ));
                fechaEventoAnterior.sendKeys(inter_objetarCoberturaBean.getFechaEventoAnterior());
            }

            if (inter_objetarCoberturaBean.getFechaProximaGeneracionPrima() != null){
                Thread.sleep(2000);
                WebElement fechaProximaGeneracionPrima = driver.findElement(By.xpath("//*[@id=\"FechaProximaGenPrima\"]" ));
                fechaProximaGeneracionPrima.sendKeys(inter_objetarCoberturaBean.getFechaProximaGeneracionPrima());
            }

            if (inter_objetarCoberturaBean.getFechaProximaFacturacion() != null){
                Thread.sleep(2000);
                WebElement fechaProximaFacturacion = driver.findElement(By.xpath("//*[@id=\"FechaProxFacturacion\"]" ));
                fechaProximaFacturacion.sendKeys(inter_objetarCoberturaBean.getFechaProximaFacturacion());
            }

            if (inter_objetarCoberturaBean.getTipoPoliza() != null){
                Thread.sleep(2000);
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//*[@id=\"TipoPoliza\"]")));
                tipoPoliza.selectByValue(inter_objetarCoberturaBean.getTipoPoliza());
            }


            if (inter_objetarCoberturaBean.getNumeroPolizaAs() != null){
                Thread.sleep(2000);
                WebElement numeroPolizaAs = driver.findElement(By.xpath("//*[@id=\"NumeroPolizaAS\"]" ));
                numeroPolizaAs.sendKeys(inter_objetarCoberturaBean.getNumeroPolizaAs());
            }

            if (inter_objetarCoberturaBean.getFlagSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement flagSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"FlagSuspCancel\"]" ));
                flagSuspensionCancelacion.sendKeys(inter_objetarCoberturaBean.getFlagSuspensionCancelacion());
            }

            if (inter_objetarCoberturaBean.getFechaSuspensionCancelacon() != null){
                Thread.sleep(2000);
                WebElement fechaSuspensionCancelacon = driver.findElement(By.xpath("//*[@id=\"FechaSuspCancel\"]" ));
                fechaSuspensionCancelacon.sendKeys(inter_objetarCoberturaBean.getFechaSuspensionCancelacon());
            }

            if (inter_objetarCoberturaBean.getCodigoSuperintendencia() != null){
                Thread.sleep(2000);
                WebElement codigoSuperintendencia = driver.findElement(By.xpath("//*[@id=\"CodSuperint\"]" ));
                codigoSuperintendencia.sendKeys(inter_objetarCoberturaBean.getCodigoSuperintendencia());
            }

            if (inter_objetarCoberturaBean.getNombreArchivoTramas() != null){
                Thread.sleep(2000);
                WebElement nombreArchivoTramas = driver.findElement(By.xpath("//*[@id=\"NombreArchivoTrama\"]" ));
                nombreArchivoTramas.sendKeys(inter_objetarCoberturaBean.getNombreArchivoTramas());
            }

            /*if (inter_objetarCoberturaBean.getNúmeroPlan() != null){
                Thread.sleep(2000);
                WebElement númeroPlan = driver.findElement(By.xpath("/*//*[@id=\"NumPlanInter\"]" ));
                númeroPlan.sendKeys(inter_objetarCoberturaBean.getNúmeroPlan());
            }*/

            if (inter_objetarCoberturaBean.getFechaInicialPolizaMatriz() != null){
                Thread.sleep(2000);
                WebElement fechaInicialPolizaMatriz = driver.findElement(By.xpath("//*[@id=\"FecIniPolMatriz\"]" ));
                fechaInicialPolizaMatriz.sendKeys(inter_objetarCoberturaBean.getFechaInicialPolizaMatriz());
            }

            if (inter_objetarCoberturaBean.getFechaFinalPolizaMatriz() != null){
                Thread.sleep(2000);
                WebElement fechaFinalPolizaMatriz = driver.findElement(By.xpath("//*[@id=\"FecFinPolMatriz\"]" ));
                fechaFinalPolizaMatriz.sendKeys(inter_objetarCoberturaBean.getFechaFinalPolizaMatriz());
            }

            if (inter_objetarCoberturaBean.getNombreAsegurado() != null){
                Thread.sleep(2000);
                WebElement nombreAsegurado = driver.findElement(By.xpath("//*[@id=\"NomComAseguradoPol\"]" ));
                nombreAsegurado.sendKeys(inter_objetarCoberturaBean.getNombreAsegurado());
            }

            if (inter_objetarCoberturaBean.getNombreBeneficiario() != null){
                Thread.sleep(2000);
                WebElement nombreBeneficiario = driver.findElement(By.xpath("//*[@id=\"NomComBeneficiarioPol\"]" ));
                nombreBeneficiario.sendKeys(inter_objetarCoberturaBean.getNombreBeneficiario());
            }

            if (inter_objetarCoberturaBean.getPeriodoSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement periodoSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"JobSupDays\"]" ));
                periodoSuspensionCancelacion.sendKeys(inter_objetarCoberturaBean.getPeriodoSuspensionCancelacion());
            }

            if (inter_objetarCoberturaBean.getFechaInicioSuspCanc() != null){
                Thread.sleep(2000);
                WebElement fechaInicioSuspCanc = driver.findElement(By.xpath("//*[@id=\"JobSupDate\"]" ));
                fechaInicioSuspCanc.sendKeys(inter_objetarCoberturaBean.getFechaInicioSuspCanc());
            }

            if (inter_objetarCoberturaBean.getProcSuspensionCancelacion() != null){
                Thread.sleep(2000);
                WebElement procSuspensionCancelacion = driver.findElement(By.xpath("//*[@id=\"JobSupInd\"]" ));
                procSuspensionCancelacion.sendKeys(inter_objetarCoberturaBean.getProcSuspensionCancelacion());
            }

            if (inter_objetarCoberturaBean.getMontoPrimaArchivoTrama() != null){
                Thread.sleep(2000);
                WebElement montoPrimaArchivoTrama = driver.findElement(By.xpath("//*[@id=\"PrimaTrama\"]" ));
                montoPrimaArchivoTrama.sendKeys(inter_objetarCoberturaBean.getMontoPrimaArchivoTrama());
            }

            if (inter_objetarCoberturaBean.getFechaEmisionAcsele() != null){
                Thread.sleep(2000);
                WebElement fechaEmisionAcsele = driver.findElement(By.xpath("//*[@id=\"FechaCargaSistema\"]" ));
                fechaEmisionAcsele.sendKeys(inter_objetarCoberturaBean.getFechaEmisionAcsele());
            }

            if (inter_objetarCoberturaBean.getNumeroSolicitud() != null){
                Thread.sleep(2000);
                WebElement numeroSolicitud = driver.findElement(By.xpath("//*[@id=\"NumeroSolicitud\"]" ));
                numeroSolicitud.sendKeys(inter_objetarCoberturaBean.getNumeroSolicitud());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformpolicy_01\"]"));
            btnBuscar.click();

            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda (Interseguros_Metodos a, INTER_ObjetarCoberturaBean inter_objetarCoberturaBean, int i, String folderName,
                                   int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){
        try {
            Thread.sleep(1000);

            WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr/td[2]/input[4]"));
            fechaOcurrenciaSiniestro.sendKeys(inter_objetarCoberturaBean.getFechaOcurrenciaSiniestro());

            Thread.sleep(2000);
            Select sucursal = new Select(driver.findElement(By.xpath("//*[@id=\"userAgency\"]")));
            sucursal.selectByValue(inter_objetarCoberturaBean.getSucursal());

            // Cambiar de frame
            driver.switchTo().frame("frameData");
            Thread.sleep(2000);
            WebElement btnSeleccionarPoliza = driver.findElement(By.xpath("//*[@id=\"form1\"]/table/tbody/tr/td[1]/input"));
            btnSeleccionarPoliza.click();
            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnSelecUnidadesRiesgo = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_02\"]"));
            btnSelecUnidadesRiesgo.click();

            Thread.sleep(4000);

            WebElement selecUnidadRiesgo = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[5]/td[1]/input"));
            selecUnidadRiesgo.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_selectRiskUnitToClaim_05\"]"));
            btnEnviar.click();

            Thread.sleep(4000);


            WebElement btnSelecEvento = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_03\"]"));
            btnSelecEvento.click();

            Thread.sleep(3000);

            WebElement selecEvento = driver.findElement(By.xpath("/html/body/center/form/table[2]/tbody/tr[3]/td[1]/input"));
            selecEvento.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            btnEnviar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_policyEventsToClaim_01\"]"));
            btnEnviar.click();

            Thread.sleep(3000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_07\"]"));
            btnAceptar.click();

            Thread.sleep(5000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (Interseguros_Metodos a, INTER_ObjetarCoberturaBean inter_objetarCoberturaBean, int i, String folderName, int numScreenShoot, int numScreenShoot2){
        try {
            Thread.sleep(1000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
            btnAgregar.click();

            Thread.sleep(5000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Thread.sleep(1000);
            if (inter_objetarCoberturaBean.getNumeroCaso() != null){
                Select numeroCaso = new Select(driver.findElement(By.xpath("//*[@id=\"NumeroCaso\"]")));
                numeroCaso.selectByValue(inter_objetarCoberturaBean.getNumeroCaso());
            }

            WebElement fechaNotificacion = driver.findElement(By.xpath("//*[@id=\"FechaNotificacion\"]"));
            fechaNotificacion.sendKeys(inter_objetarCoberturaBean.getFechaNotificacion());

            Thread.sleep(1000);
            WebElement fechaRecepcionReclamo = driver.findElement(By.xpath("//*[@id=\"FechaRecepcion\"]"));
            fechaRecepcionReclamo.sendKeys(inter_objetarCoberturaBean.getFechaRecepcionReclamo());


            if (inter_objetarCoberturaBean.getFechaOcurrencia() != null){
                Select fechaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
                fechaOcurrencia.selectByValue(inter_objetarCoberturaBean.getFechaOcurrencia());
            }

            if (inter_objetarCoberturaBean.getLugarOcurrenciaSiniestro() != null){
                WebElement lugarOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"LugarOcurrencia\"]"));
                lugarOcurrenciaSiniestro.sendKeys(inter_objetarCoberturaBean.getLugarOcurrenciaSiniestro());
            }

            if (inter_objetarCoberturaBean.getHoraOcurrencia() != null){
                WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"HoraOcurrencia\"]"));
                fechaInterrupcionTerminos.sendKeys(inter_objetarCoberturaBean.getHoraOcurrencia());
            }

            if (inter_objetarCoberturaBean.getNombresApellidos() != null){
                WebElement nombresApellidos = driver.findElement(By.xpath("//*[@id=\"NombreSolSin\"]"));
                nombresApellidos.sendKeys(inter_objetarCoberturaBean.getNombresApellidos());
            }

            if (inter_objetarCoberturaBean.getDireccion() != null){
                WebElement direccion = driver.findElement(By.xpath("//*[@id=\"DireccionSolSin\"]"));
                direccion.sendKeys(inter_objetarCoberturaBean.getDireccion());
            }


            if (inter_objetarCoberturaBean.getTelefonos() != null){
                WebElement telefonos = driver.findElement(By.xpath("//*[@id=\"TelefonoSolSin\"]"));
                telefonos.sendKeys(inter_objetarCoberturaBean.getTelefonos());
            }

            if (inter_objetarCoberturaBean.getCorreoElectronico() != null){
                WebElement correoElectronico = driver.findElement(By.xpath("//*[@id=\"EmailSolSin\"]"));
                correoElectronico.sendKeys(inter_objetarCoberturaBean.getCorreoElectronico());
            }

            if (inter_objetarCoberturaBean.getEnvioComunicacionesSiniestro() != null){
                Select envioComunicacionesSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"ComunicacionSiniestro\"]")));
                envioComunicacionesSiniestro.selectByValue(inter_objetarCoberturaBean.getEnvioComunicacionesSiniestro());
            }

            if (inter_objetarCoberturaBean.getCorreoElectronicoSiniestro() != null){
                Select correoElectronicoSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"EmailEnvioSiniestro\"]")));
                correoElectronicoSiniestro.selectByValue(inter_objetarCoberturaBean.getCorreoElectronicoSiniestro());
            }

            /*if (inter_objetarCoberturaBean.getSexo() != null){
                Select sexo = new Select(driver.findElement(By.xpath("/*//*[@id=\"SexoSolSin\"]")));
                sexo.selectByValue(inter_objetarCoberturaBean.getSexo());
            }*/


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
            btnAceptar.click();

            Thread.sleep(6000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarCobertura (Interseguros_Metodos a, INTER_ObjetarCoberturaBean inter_objetarCoberturaBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3) {
        try{

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_04\"]"));
            btnAgregar.click();
            Thread.sleep(5000);

            WebElement pagoMaximo = driver.findElement(By.xpath("//*[@id=\"maxBenefitAmount1\"]"));
            pagoMaximo.clear();
            pagoMaximo.sendKeys(inter_objetarCoberturaBean.getPagoMaximo());

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
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

            /*WebElement btnAceptardos = driver.findElement(By.xpath("/*//*[@id=\"idb_0402006_contextPageClaimTool_01\"]"));
            btnAceptardos.click();*/

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

            if (inter_objetarCoberturaBean.getMotivoRechazo() != null){
                Select motivoRechazo = new Select(driver.findElement(By.xpath("")));
                motivoRechazo.selectByValue(inter_objetarCoberturaBean.getMotivoRechazo());
            }

            if (inter_objetarCoberturaBean.getComentariosSiniestro() != null){
                WebElement comentariosSiniestro = driver.findElement(By.xpath("//*[@id=\"EmailSolSin\"]"));
                comentariosSiniestro.sendKeys(inter_objetarCoberturaBean.getComentariosSiniestro());
            }

            if (inter_objetarCoberturaBean.getNombreBeneficiarioObjetar() != null){
                WebElement nombreBeneficiarioObjetar = driver.findElement(By.xpath("//*[@id=\"EmailSolSin\"]"));
                nombreBeneficiarioObjetar.sendKeys(inter_objetarCoberturaBean.getNombreBeneficiarioObjetar());
            }

            if (inter_objetarCoberturaBean.getDirecciónBeneficiario() != null){
                WebElement direccionBeneficiario = driver.findElement(By.xpath("//*[@id=\"EmailSolSin\"]"));
                direccionBeneficiario.sendKeys(inter_objetarCoberturaBean.getDirecciónBeneficiario());
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            WebElement btnAceptar2 = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[4]/input"));
            btnAceptar2.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}
