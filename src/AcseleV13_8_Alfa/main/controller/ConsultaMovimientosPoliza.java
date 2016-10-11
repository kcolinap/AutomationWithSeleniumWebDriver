package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.ConsultaMovimientosPolizaBean;
import AcseleV13_8_Alfa.main.controller.Menu.MenuConsultas;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by rmontilla on 28/09/2016.
 */
public class ConsultaMovimientosPoliza {

    private final static Logger log = Logger.getLogger(ConsultaMovimientosPoliza.class);

    public String nombreAutomatizacion = "Consulta de Movimientos de Poliza";

    public void testLink(ConsultaMovimientosPolizaBean consultaMovimientosPolizaBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuConsultas menuConsultas = new MenuConsultas();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion);

            a.ValidandoSesion(driver, nombreAutomatizacion);
            Thread.sleep(5000);

            //Entrando en Menu
            menuConsultas.MovimientoPolizas (driver, nombreAutomatizacion, i);

            //
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);


            ConsultaPol(driver, consultaMovimientosPolizaBean, a, i);
            SeleccionarPol(driver, a, i);
            SeleccionarMov(driver, a, i);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void ConsultaPol(WebDriver driver, ConsultaMovimientosPolizaBean consultaMovimientosPolizaBean, Metodos a, int i) {
        try{
            Thread.sleep(5000);
                              //Ordenar Por
                    if (consultaMovimientosPolizaBean.getOrdenarPor() != null){
                        Thread.sleep(5000);

                        Select orden = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/select")));

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Número de Póliza")){
                            Thread.sleep(2000);
                            orden.selectByValue("1");
                        }

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Producto")) {
                            Thread.sleep(2000);
                            orden.selectByValue("2");
                        }

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Fecha de Inicio")) {
                            Thread.sleep(2000);
                            orden.selectByValue("3");
                        }

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Fecha Fin")) {
                            Thread.sleep(2000);
                            orden.selectByValue("4");
                        }

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Estado")) {
                            Thread.sleep(2000);
                            orden.selectByValue("5");
                        }

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Contratante")) {
                            Thread.sleep(2000);
                            orden.selectByValue("6");
                        }

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Asegurado")) {
                            Thread.sleep(2000);
                            orden.selectByValue("7");
                        }

                        if (consultaMovimientosPolizaBean.getOrdenarPor().equals("Estados del ciclo de vida")) {
                            Thread.sleep(2000);
                            orden.selectByValue("8");
                        }

                    }

            //Producto

            if (consultaMovimientosPolizaBean.getProducto() != null){

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"_productId\"]")));

                if (consultaMovimientosPolizaBean.getProducto().equals("VidaDeudoresAvVillas")){
                    Thread.sleep(2000);
                    orden.selectByValue("46897");
                }

            }

            //Estado del ciclo de vida

            if (consultaMovimientosPolizaBean.getEstadoVida() != null){

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"_stateProductId\"]")));

                if (consultaMovimientosPolizaBean.getEstadoVida().equals("Anulada")){
                    Thread.sleep(2000);
                    orden.selectByValue("Anulada");
                }

                if (consultaMovimientosPolizaBean.getEstadoVida().equals("Excluido")){
                    Thread.sleep(2000);
                    orden.selectByValue("Excluido");
                }

                if (consultaMovimientosPolizaBean.getEstadoVida().equals("Cotizado")){
                    Thread.sleep(2000);
                    orden.selectByValue("Cotizado");
                }

                if (consultaMovimientosPolizaBean.getEstadoVida().equals("Cancelada")){
                    Thread.sleep(2000);
                    orden.selectByValue("Cancelada");
                }

                if (consultaMovimientosPolizaBean.getEstadoVida().equals("Inicial")){
                    Thread.sleep(2000);
                    orden.selectByValue("Inicial");
                }

                if (consultaMovimientosPolizaBean.getEstadoVida().equals("Emitida")){
                    Thread.sleep(2000);
                    orden.selectByValue("Emitida");
                }

            }

            // Contratante

            if (consultaMovimientosPolizaBean.getContratante() != null){
                Thread.sleep(2000);
               WebElement contratante = driver.findElement(By.xpath("//*[@id=\"_clientName\"]"));
                contratante.sendKeys(consultaMovimientosPolizaBean.getContratante());
            }

            //Asegurado

            if (consultaMovimientosPolizaBean.getAsegurado() != null){
                Thread.sleep(2000);
                WebElement asegurado = driver.findElement(By.xpath("//*[@id=\"_insuredName\"]"));
                asegurado.sendKeys(consultaMovimientosPolizaBean.getAsegurado());
            }

            //ID Poliza

            if (consultaMovimientosPolizaBean.getIdPoliza() != null){
                Thread.sleep(2000);
                WebElement idpoliza = driver.findElement(By.xpath("//*[@id=\"_policyId\"]"));
                idpoliza.sendKeys(consultaMovimientosPolizaBean.getIdPoliza());
            }

            //Fecha desde

            if (consultaMovimientosPolizaBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechdes = driver.findElement(By.xpath("//*[@id=\"_fromDateShow\"]"));
                fechdes.sendKeys(consultaMovimientosPolizaBean.getFechaDesde());
            }

            //Fecha hasta

            if (consultaMovimientosPolizaBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechas = driver.findElement(By.xpath("//*[@id=\"_toDateShow\"]"));
                fechas.sendKeys(consultaMovimientosPolizaBean.getFechaHasta());
            }

            //Sucursal

            if (consultaMovimientosPolizaBean.getSucursal() != null){

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"1829934\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getSucursal().equals("Cali")){
                    Thread.sleep(2000);
                    orden.selectByValue("Cali");
                }

                if (consultaMovimientosPolizaBean.getSucursal().equals("Cartagena")){
                    Thread.sleep(2000);
                    orden.selectByValue("Cartagena");
                }

                if (consultaMovimientosPolizaBean.getSucursal().equals("Direccion General")){
                    Thread.sleep(2000);
                    orden.selectByValue("Direccion General");
                }

                if (consultaMovimientosPolizaBean.getSucursal().equals("Medellin")){
                    Thread.sleep(2000);
                    orden.selectByValue("Medellin");
                }

                if (consultaMovimientosPolizaBean.getSucursal().equals("San Diego")){
                    Thread.sleep(2000);
                    orden.selectByValue("San Diego");
                }
            }

            //Numero Poliza

            if (consultaMovimientosPolizaBean.getNumPoliza() != null){
                Thread.sleep(2000);
                WebElement numpol = driver.findElement(By.xpath("//*[@id=\"1829814\"]/td[3]/font/input[1]"));
                numpol.sendKeys(consultaMovimientosPolizaBean.getNumPoliza());
            }

            //Fecha Emision

            if (consultaMovimientosPolizaBean.getFechaEmision() != null){
                Thread.sleep(2000);
                WebElement numpol = driver.findElement(By.xpath("//*[@id=\"1829814\"]/td[3]/font/input[1]"));
                numpol.sendKeys(consultaMovimientosPolizaBean.getFechaEmision());
            }

            //Moneda

            if (consultaMovimientosPolizaBean.getMoneda() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"1828494\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getMoneda().equals("Pesos Colombianos")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Pesos Colombianos");
                }

                if (consultaMovimientosPolizaBean.getMoneda().equals("US Dolar")) {
                    Thread.sleep(2000);
                    orden.selectByValue("US Dolar");
                }
            }

            //Tipo Moneda

            if (consultaMovimientosPolizaBean.getTipoMoneda() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"30598294\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getTipoMoneda().equals("Pesos Colombianos")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Pesos Colombianos");
                }

                if (consultaMovimientosPolizaBean.getTipoMoneda().equals("US Dolar")) {
                    Thread.sleep(2000);
                    orden.selectByValue("US Dolar");
                }
            }

            //Tipo de Produccion

            if (consultaMovimientosPolizaBean.getTipoProduccion() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"1829894\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getTipoProduccion().equals("Coaseguro Aceptado")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Coaseguro Aceptado");
                }

                if (consultaMovimientosPolizaBean.getTipoProduccion().equals("Coaseguro Cedido")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Coaseguro Cedido");
                }

                if (consultaMovimientosPolizaBean.getTipoProduccion().equals("Directa")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Directa");
                }
            }

            //Tipo Vigencia

            if (consultaMovimientosPolizaBean.getTipoVigencia() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"1830014\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getTipoVigencia().equals("Abierta")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Abierta");
                }

                if (consultaMovimientosPolizaBean.getTipoVigencia().equals("Anual")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Anual");
                }

                if (consultaMovimientosPolizaBean.getTipoVigencia().equals("Especial")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Especial");
                }

                if (consultaMovimientosPolizaBean.getTipoVigencia().equals("Mensual")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Mensual");
                }

                if (consultaMovimientosPolizaBean.getTipoVigencia().equals("Semestral")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Semestral");
                }

                if (consultaMovimientosPolizaBean.getTipoVigencia().equals("Trimestral")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Trimestral");
                }
            }

            //Vigencia

            if (consultaMovimientosPolizaBean.getVigencia() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"1830054\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getVigencia().equals("Abierta")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Abierta");
                }

                if (consultaMovimientosPolizaBean.getVigencia().equals("Anual")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Anual");
                }

                if (consultaMovimientosPolizaBean.getVigencia().equals("Especial")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Especial");
                }

                if (consultaMovimientosPolizaBean.getVigencia().equals("Mensual")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Mensual");
                }

                if (consultaMovimientosPolizaBean.getVigencia().equals("Semestral")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Semestral");
                }

                if (consultaMovimientosPolizaBean.getVigencia().equals("Trimestral")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Trimestral");
                }
            }

            //Canal Venta

            if (consultaMovimientosPolizaBean.getCanalVenta() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"1933894\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("ATM")) {
                    Thread.sleep(2000);
                    orden.selectByValue("ATM");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Agentes/Intermediarios")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Agentes/Intermediarios");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Corredores de seguros")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Corredores de seguros");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Corresponsales bancarios")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Corresponsales bancarios");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Directo")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Directo");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Fuerza de venta propia")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Fuerza de venta propia");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Fuerza ventas propia")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Fuerza ventas propia");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Fuerza ventas sponsor")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Fuerza ventas sponsor");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Internet")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Internet");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("Móviles")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Móviles");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("TMK Inbound")) {
                    Thread.sleep(2000);
                    orden.selectByValue("TMK Inbound");
                }

                if (consultaMovimientosPolizaBean.getCanalVenta().equals("TMK Outbound")) {
                    Thread.sleep(2000);
                    orden.selectByValue("TMK Outbound");
                }
            }

            //Frecuencia de Pago

            if (consultaMovimientosPolizaBean.getFrecuenciaPago() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"1830294\"]/td[3]/font/select")));


                if (consultaMovimientosPolizaBean.getFrecuenciaPago().equals("Anual")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Anual");
                }

                if (consultaMovimientosPolizaBean.getFrecuenciaPago().equals("Mensual")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Mensual");
                }

                if (consultaMovimientosPolizaBean.getFrecuenciaPago().equals("PagoUnico")) {
                    Thread.sleep(2000);
                    orden.selectByValue("PagoUnico");
                }

                if (consultaMovimientosPolizaBean.getFrecuenciaPago().equals("Semestral")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Semestral");
                }

                if (consultaMovimientosPolizaBean.getFrecuenciaPago().equals("Trimestral")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Trimestral");
                }
            }

            //Fecha del Evento Anterior

            if (consultaMovimientosPolizaBean.getFechaEventAnt() != null){
                Thread.sleep(2000);
                WebElement fecant = driver.findElement(By.xpath("//*[@id=\"1933934\"]/td[3]/font/input[1]"));
                fecant.sendKeys(consultaMovimientosPolizaBean.getFechaEventAnt());
            }

            //Fecha Próxima Generación de Prima

            if (consultaMovimientosPolizaBean.getFechaProxGenPri() != null){
                Thread.sleep(2000);
                WebElement fecproxan = driver.findElement(By.xpath("//*[@id=\"1830374\"]/td[3]/font/input[1]"));
                fecproxan.sendKeys(consultaMovimientosPolizaBean.getFechaProxGenPri());
            }

            //Fecha Próxima Facturación

            if (consultaMovimientosPolizaBean.getFechaProxFact() != null){
                Thread.sleep(2000);
                WebElement fecproxfac = driver.findElement(By.xpath("//*[@id=\"1830214\"]/td[3]/font/input[1]"));
                fecproxfac.sendKeys(consultaMovimientosPolizaBean.getFechaProxFact());
            }

            //Tipo de Poliza

            if (consultaMovimientosPolizaBean.getTipoPol() != null) {

                Select orden = new Select(driver.findElement(By.xpath("//*[@id=\"2878614\"]/td[3]/font/select")));

                if (consultaMovimientosPolizaBean.getTipoPol().equals("Grupo Colectivo")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Grupo Colectivo");
                }

                if (consultaMovimientosPolizaBean.getTipoPol().equals("Individual")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Individual");
                }

                if (consultaMovimientosPolizaBean.getTipoPol().equals("Individual Agrupada")) {
                    Thread.sleep(2000);
                    orden.selectByValue("Individual Agrupada");
                }
            }

            //Número de Cotización

            if (consultaMovimientosPolizaBean.getNumCot() != null){
                Thread.sleep(2000);
                WebElement numcot = driver.findElement(By.xpath("//*[@id=\"9480594\"]/td[3]/font/input[1]"));
                numcot.sendKeys(consultaMovimientosPolizaBean.getNumCot());
            }

            //Número de Propuesta

            if (consultaMovimientosPolizaBean.getNumPro() != null){
                Thread.sleep(2000);
                WebElement numpro = driver.findElement(By.xpath("//*[@id=\"9452594\"]/td[3]/font/input[1]"));
                numpro.sendKeys(consultaMovimientosPolizaBean.getNumPro());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformpolicy_01\"]"));
            btnBuscar.click();



            Thread.sleep(2000);
            a.changeLastWindows(driver);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void SeleccionarPol(WebDriver driver, Metodos a, int i) {
        try{

            Thread.sleep(15000);
            // Cambiar de frame
            driver.switchTo().frame("frameData");

            //driver.switchTo().parentFrame();
            //driver.switchTo().defaultContent(); // to move back to most parent or main frame

            Thread.sleep(500);
            WebElement btnSeleccionarpol = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/input"));
            btnSeleccionarpol.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);

            //driver.switchTo().parentFrame();    // to move back to parent frame
            // Salir del frame
            driver.switchTo().defaultContent(); // to move back to most parent or main frame

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[4]/center/table/tbody/tr[2]/td[2]/input[1]"));
            btnAceptar.click();

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void SeleccionarMov(WebDriver driver, Metodos a, int i) {
        try{
            Thread.sleep(15000);
            WebElement btnSeleccionarmov = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr/td[1]/div/input"));
            btnSeleccionarmov.click();

            Thread.sleep(5000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnVermov = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[7]/td/input[2]"));
            btnVermov.click();

            Thread.sleep(10000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}