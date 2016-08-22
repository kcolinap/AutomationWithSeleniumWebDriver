package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.BusquedaAvanzadaSiniestroBean;
import AcseleV13_8_Alfa.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by mchurion on 09/08/2016.
 */
public class BusquedaAvanzadaSiniestro {
    private final static Logger log = Logger.getLogger(BusquedaAvanzadaSiniestro.class);

    public String nombreAutomatizacion = "Busqueda Avanzada Siniestro";

    public void testLink(BusquedaAvanzadaSiniestroBean busquedaAvanzadaSiniestroBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Busqueda de Siniestro
        m.OpeSini_MantenimientoSiniestro(driver, a, nombreAutomatizacion);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        //Thread.sleep(2000);

        InsertarDatos(a, driver, busquedaAvanzadaSiniestroBean); //Insertar Datos de Caja

        //Presiono el botón Buscar
        driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span")).click();
        a.changeLastWindows(driver);
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Thread.sleep(1500);

        //Selecciono el Siniestro a consultar
        driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[2]/div")).click();
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        //Presiono el botón Consultar
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[5]/div/div/div[1]/div/span/span")).click();

        Thread.sleep(2000);
        //a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        a.changeLastWindows(driver);
        Thread.sleep(25000);
        //Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[1]/center/table/tbody/tr[3]/td[2]/span")).click();
        //Thread.sleep(1000);
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        Thread.sleep(1000);
    }

    public void InsertarDatos(Metodos a, WebDriver driver, BusquedaAvanzadaSiniestroBean busquedaAvanzadaSiniestroBean) throws InterruptedException, IOException {

        try{
            Thread.sleep(3000);
/*            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);*/
            //Presiono el botón Busqueda Avanzada
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Thread.sleep(1500);
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[5]/div/div/div[3]/div/span/span")).click();
            a.cambiarVentana(driver);


           //Se seleciona un orden
            if (busquedaAvanzadaSiniestroBean.getOrdenar() != null) {
                WebElement desplegarCombo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div[3]/div/div/div[3]/div/input"));
                desplegarCombo.click();

                Thread.sleep(1000);
                WebElement seleccionarValorOrden = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td/span"));
                seleccionarValorOrden.click();
                Thread.sleep(1000);

            }
            //Se seleciona un producto
            if (busquedaAvanzadaSiniestroBean.getProducto() != null) {
                WebElement desplegarCombo2 = driver.findElement(By.xpath("//*[@id=\"comboProductoAdvancedSearch\"]/div"));
                desplegarCombo2.click();

                Thread.sleep(1000);
                WebElement seleccionarValorproducto2 = driver.findElement(By.xpath(" "));
                seleccionarValorproducto2.click();
                Thread.sleep(1000);

            }
            //Se seleciona un Evento
            if (busquedaAvanzadaSiniestroBean.getEvento() != null) {
                WebElement desplegarCombo3 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo3.click();

                Thread.sleep(1000);
                WebElement seleccionarValorproducto3 = driver.findElement(By.xpath(" "));
                seleccionarValorproducto3.click();
                Thread.sleep(1000);

            }
            //Se seleciona una sucursal
            if (busquedaAvanzadaSiniestroBean.getSucursal() != null) {
                WebElement desplegarCombo4 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo4.click();

                Thread.sleep(1000);
                WebElement seleccionarValorSucursal = driver.findElement(By.xpath(" "));
                seleccionarValorSucursal.click();
                Thread.sleep(1000);

            }

            //Se selecionael numero de poliza
            if (busquedaAvanzadaSiniestroBean.getNumPoliza() != null) {
                WebElement poliza = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                poliza.sendKeys(busquedaAvanzadaSiniestroBean.getNumPoliza());
                Thread.sleep(1000);
            }

            //Se seleciona la fecha de emisión
            if (busquedaAvanzadaSiniestroBean.getEmision() != null) {
                WebElement emision = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                emision.sendKeys(busquedaAvanzadaSiniestroBean.getEmision());
                Thread.sleep(1000);
            }

            //Se seleciona Tipo de Produccion
            if (busquedaAvanzadaSiniestroBean.getTipoProduccion() != null) {
                WebElement desplegarCombo5 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo5.click();

                Thread.sleep(1000);
                WebElement seleccionarTipoProduccion = driver.findElement(By.xpath(" "));
                seleccionarTipoProduccion.click();
                Thread.sleep(1000);

            }

            //Se seleciona el canal de venta
            if (busquedaAvanzadaSiniestroBean.getCanalVenta() != null) {
                WebElement desplegarCombo6 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo6.click();

                Thread.sleep(1000);
                WebElement seleccionarValorCanalVenta = driver.findElement(By.xpath(" "));
                seleccionarValorCanalVenta.click();
                Thread.sleep(1000);

            }

            //Se seleciona Frecuencia de Pago
            if (busquedaAvanzadaSiniestroBean.getFrecuenciaPago() != null) {
                WebElement desplegarCombo7 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo7.click();

                Thread.sleep(1000);
                WebElement seleccionarFrecuenciaPago = driver.findElement(By.xpath(" "));
                seleccionarFrecuenciaPago.click();
                Thread.sleep(1000);

            }

            //Se seleciona Tipo de Tercero
            if (busquedaAvanzadaSiniestroBean.getTipoTercero() != null) {
                WebElement desplegarCombo8 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo8.click();

                Thread.sleep(1000);
                WebElement seleccionarTipoTercero = driver.findElement(By.xpath(" "));
                seleccionarTipoTercero.click();
                Thread.sleep(1000);

            }

            //Se seleciona Tipo de Documento de Identidad
            if (busquedaAvanzadaSiniestroBean.getTipoDocumento() != null) {
                WebElement desplegarCombo9 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo9.click();

                Thread.sleep(1000);
                WebElement seleccionarTipoDocumento = driver.findElement(By.xpath(" "));
                seleccionarTipoDocumento.click();
                Thread.sleep(1000);

            }

            //Ingresa Numero de documento de identidad
            if (busquedaAvanzadaSiniestroBean.getNumDocumento() != null) {
                WebElement identidad = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                identidad.sendKeys(busquedaAvanzadaSiniestroBean.getNumDocumento());
                Thread.sleep(1000);
            }

            //Ingresa Nombre y Apellido
            if (busquedaAvanzadaSiniestroBean.getNombreApellido() != null) {
                WebElement nombreAp = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                nombreAp.sendKeys(busquedaAvanzadaSiniestroBean.getNombreApellido());
                Thread.sleep(1000);
            }

            //Ingresa Fecha de inclusion
            if (busquedaAvanzadaSiniestroBean.getFechaInclusion() != null) {
                WebElement fechaInclusion = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                fechaInclusion.sendKeys(busquedaAvanzadaSiniestroBean.getFechaInclusion());
                Thread.sleep(1000);
            }

            //Ingresa Telefono de Oficina
            if (busquedaAvanzadaSiniestroBean.getTlfOficina() != null) {
                WebElement telefono1 = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                telefono1.sendKeys(busquedaAvanzadaSiniestroBean.getTlfOficina());
                Thread.sleep(1000);
            }

            //Ingresa Extension
            if (busquedaAvanzadaSiniestroBean.getExtension() != null) {
                WebElement extension = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                extension.sendKeys(busquedaAvanzadaSiniestroBean.getExtension());
                Thread.sleep(1000);
            }

            //Ingresa Telefono completo
            if (busquedaAvanzadaSiniestroBean.getTlfOficinaComp() != null) {
                WebElement tlfCompleto = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                tlfCompleto.sendKeys(busquedaAvanzadaSiniestroBean.getTlfOficinaComp());
                Thread.sleep(1000);
            }

            //Ingresa email1
            if (busquedaAvanzadaSiniestroBean.getEmail1() != null) {
                WebElement email1 = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                email1.sendKeys(busquedaAvanzadaSiniestroBean.getEmail1());
                Thread.sleep(1000);
            }

            //Ingresa email2
            if (busquedaAvanzadaSiniestroBean.getEmail2() != null) {
                WebElement email2 = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                email2.sendKeys(busquedaAvanzadaSiniestroBean.getEmail2());
                Thread.sleep(1000);
            }


            //Ingresa codigo interno
            if (busquedaAvanzadaSiniestroBean.getCodigoInterno() != null) {
                WebElement codigoIn = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                codigoIn.sendKeys(busquedaAvanzadaSiniestroBean.getCodigoInterno());
                Thread.sleep(1000);
            }

            //Ingresa codigo identificador
            if (busquedaAvanzadaSiniestroBean.getCodigoIdentificador() != null) {
                WebElement codigoId = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                codigoId.sendKeys(busquedaAvanzadaSiniestroBean.getCodigoIdentificador());
                Thread.sleep(1000);
            }

            //Ingresa indicativo
            if (busquedaAvanzadaSiniestroBean.getIndicativo() != null) {
                WebElement indicativo = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                indicativo.sendKeys(busquedaAvanzadaSiniestroBean.getIndicativo());
                Thread.sleep(1000);
            }

            //Ingresa rol
            if (busquedaAvanzadaSiniestroBean.getRol() != null) {
                WebElement rol = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                rol.sendKeys(busquedaAvanzadaSiniestroBean.getRol());
                Thread.sleep(1000);
            }

            //Ingresa numero unidad riesgo
            if (busquedaAvanzadaSiniestroBean.getNumUnidadRiesgo() != null) {
                WebElement riesgo = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                riesgo.sendKeys(busquedaAvanzadaSiniestroBean.getNumUnidadRiesgo());
                Thread.sleep(1000);
            }

            //Se seleciona el tipo objeto asegurado
            if (busquedaAvanzadaSiniestroBean.getTipoObjAsegurado() != null) {
                WebElement desplegarCombo10 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                desplegarCombo10.click();

                Thread.sleep(1000);
                WebElement seleccionarTipoObjeto = driver.findElement(By.xpath(" "));
                seleccionarTipoObjeto.click();
                Thread.sleep(1000);

            }

            //Ingresa numero objeto asegurado
            if (busquedaAvanzadaSiniestroBean.getNumObjAsegurado() != null) {
                WebElement numAsegurado = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                numAsegurado.sendKeys(busquedaAvanzadaSiniestroBean.getNumObjAsegurado());
                Thread.sleep(1000);
            }

            //Ingresa nombre asegurado
            if (busquedaAvanzadaSiniestroBean.getNombreAsegurado() != null) {
                WebElement nombreAsegurado = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                nombreAsegurado.sendKeys(busquedaAvanzadaSiniestroBean.getNombreAsegurado());
                Thread.sleep(1000);
            }


            //Ingresa nombre beneficiario
            if (busquedaAvanzadaSiniestroBean.getNombreBeneficiario() != null) {
                WebElement beneficiario = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
                beneficiario.sendKeys(busquedaAvanzadaSiniestroBean.getNombreBeneficiario());
                Thread.sleep(1000);
            }

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Buscar Siniestro - " + e);
        }

    }

}
