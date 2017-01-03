package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_EditarSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
/**
 * Created by aazuaje on 29/12/2016.
 */
public class INTER_EditarSiniestro {

    private final static Logger log = Logger.getLogger(INTER_EditarSiniestroBean.class);

    public String nombreAutomatizacion = "Editar Siniestro";

    public void testLink(INTER_EditarSiniestroBean inter_editarSiniestroBean,int i) throws IOException, InterruptedException {

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
        BuscarPoliza(driver, a, inter_editarSiniestroBean, i);
        ResultadoBusqueda(driver, a, inter_editarSiniestroBean, i);
        EditarObjetoAfectado(driver, a, inter_editarSiniestroBean, i);

    }

    public void BuscarPoliza(WebDriver driver, Interseguros_Metodos a, INTER_EditarSiniestroBean inter_editarSiniestroBean, int i) throws IOException, InterruptedException{

        try {

            if (inter_editarSiniestroBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (inter_editarSiniestroBean.getOrdenarPor() == "Número de Reclamo"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (inter_editarSiniestroBean.getOrdenarPor() == "Producto"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (inter_editarSiniestroBean.getOrdenarPor() == "Fecha de Ocurrencia"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (inter_editarSiniestroBean.getOrdenarPor() == "Estado del siniestro"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (inter_editarSiniestroBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numSiniestro.sendKeys(inter_editarSiniestroBean.getNumeroSiniestro());
            }

            if (inter_editarSiniestroBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numPoliza.sendKeys(inter_editarSiniestroBean.getNumeroPoliza());
            }

            if (inter_editarSiniestroBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaOcurrenciaSiniestro  = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaOcurrenciaSiniestro.sendKeys(inter_editarSiniestroBean.getFechaOcurrenciaSiniestro());
            }

            String productos = "DotalSimple";

            if (inter_editarSiniestroBean.getProducto() != null){
                //if (editarSiniestrosBean.getProducto() == productos){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[7]/td/span"));
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

    public void ResultadoBusqueda(WebDriver driver,Interseguros_Metodos a, INTER_EditarSiniestroBean inter_editarSiniestroBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[2]/td[3]/div"));
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

    public void EditarObjetoAfectado (WebDriver driver, Interseguros_Metodos a, INTER_EditarSiniestroBean inter_editarSiniestroBean, int i){
        try {
            Thread.sleep(2000);
            Select objetoAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"ioID\"]")));
            objetoAsegurado.selectByIndex(0);
            WebElement btnSeleccionOA = driver.findElement(By.xpath("//*[@id=\"ioID\"]/option"));
            btnSeleccionOA.click();
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);

            Thread.sleep(2000);
            WebElement btnEditar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_03\"]"));
            btnEditar.click();

            Thread.sleep(20000);
            a.ScreenShotPool(driver,i,"screen7", nombreAutomatizacion);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Thread.sleep(5000);
            if (inter_editarSiniestroBean.getNumeroCaso() != null){
                Select numeroCaso = new Select(driver.findElement(By.xpath("//*[@id=\"NumeroCaso\"]")));
                numeroCaso.selectByValue(inter_editarSiniestroBean.getNumeroCaso());
            }

            if (inter_editarSiniestroBean.getFechaNotificacion() != null){
                WebElement fechaNotificacion = driver.findElement(By.xpath("//*[@id=\"FechaNotificacion\"]"));
            fechaNotificacion.sendKeys(inter_editarSiniestroBean.getFechaNotificacion());
            }

            Thread.sleep(1000);
            if (inter_editarSiniestroBean.getFechaRecepcionReclamo() != null){
            WebElement fechaRecepcionReclamo = driver.findElement(By.xpath("//*[@id=\"FechaRecepcion\"]"));
            fechaRecepcionReclamo.sendKeys(inter_editarSiniestroBean.getFechaRecepcionReclamo());
            }

            if (inter_editarSiniestroBean.getFechaOcurrencia() != null){
                Select fechaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
                fechaOcurrencia.selectByValue(inter_editarSiniestroBean.getFechaOcurrencia());
            }

            if (inter_editarSiniestroBean.getLugarOcurrenciaSiniestro() != null){
                WebElement lugarOcurrenciaSiniestro = driver.findElement(By.xpath("//*[@id=\"LugarOcurrencia\"]"));
                lugarOcurrenciaSiniestro.clear();
                lugarOcurrenciaSiniestro.sendKeys(inter_editarSiniestroBean.getLugarOcurrenciaSiniestro());
            }

            if (inter_editarSiniestroBean.getHoraOcurrencia() != null){
                WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"HoraOcurrencia\"]"));
                fechaInterrupcionTerminos.sendKeys(inter_editarSiniestroBean.getHoraOcurrencia());
            }

            if (inter_editarSiniestroBean.getObservacionesSiniestro() != null){
                WebElement observacionesSiniestro = driver.findElement(By.xpath("//*[@id=\"ObservacionesSin\"]"));
                observacionesSiniestro.sendKeys(inter_editarSiniestroBean.getObservacionesSiniestro());
            }

            if (inter_editarSiniestroBean.getNombresApellidos() != null){
                WebElement nombresApellidos = driver.findElement(By.xpath("//*[@id=\"NombreSolSin\"]"));
                nombresApellidos.sendKeys(inter_editarSiniestroBean.getNombresApellidos());
            }

            if (inter_editarSiniestroBean.getDireccion() != null){
                WebElement direccion = driver.findElement(By.xpath("//*[@id=\"DireccionSolSin\"]"));
                direccion.sendKeys(inter_editarSiniestroBean.getDireccion());
            }

            if (inter_editarSiniestroBean.getTelefonos() != null){
                WebElement telefonos = driver.findElement(By.xpath("//*[@id=\"TelefonoSolSin\"]"));
                telefonos.sendKeys(inter_editarSiniestroBean.getTelefonos());
            }

            if (inter_editarSiniestroBean.getCorreoElectronico() != null){
                WebElement correoElectronico = driver.findElement(By.xpath("//*[@id=\"EmailSolSin\"]"));
                correoElectronico.sendKeys(inter_editarSiniestroBean.getCorreoElectronico());
            }

            if (inter_editarSiniestroBean.getEnvioComunicacionesSiniestro() != null){
                Select envioComunicacionesSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"ComunicacionSiniestro\"]")));
                envioComunicacionesSiniestro.selectByValue(inter_editarSiniestroBean.getEnvioComunicacionesSiniestro());
            }

            if (inter_editarSiniestroBean.getCorreoElectronicoSiniestro() != null){
                Select envioComunicacionesSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"EmailEnvioSiniestro\"]")));
                envioComunicacionesSiniestro.selectByValue(inter_editarSiniestroBean.getCorreoElectronicoSiniestro());
            }
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i,"screen8", nombreAutomatizacion);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
            btnAceptar.click();

            Thread.sleep(15000);

            Thread.sleep(5000);
            a.ScreenShotPool(driver,i, "screen9",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }





}
