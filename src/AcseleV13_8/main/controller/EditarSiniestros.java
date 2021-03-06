
package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EditarSiniestrosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 15/08/2016.
 */

public class EditarSiniestros {

    private final static Logger log = Logger.getLogger(EditarSiniestros.class);

    public String nombreAutomatizacion = "Editar Siniestros";

    public void testLink(EditarSiniestrosBean editarSiniestrosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos13_8 a = new Metodos13_8();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion,3, i);
        Thread.sleep(10000);

        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, editarSiniestrosBean, i);
        ResultadoBusqueda(driver, a, editarSiniestrosBean, i);
        AgregarObjetoAfectado(driver, a, editarSiniestrosBean, i);


    }


    public void BuscarPoliza(WebDriver driver, Metodos13_8 a, EditarSiniestrosBean editarSiniestrosBean, int i) throws IOException, InterruptedException{

        try {

            if (editarSiniestrosBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (editarSiniestrosBean.getOrdenarPor() == "Número de Reclamo"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (editarSiniestrosBean.getOrdenarPor() == "Producto"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (editarSiniestrosBean.getOrdenarPor() == "Fecha de Ocurrencia"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (editarSiniestrosBean.getOrdenarPor() == "Estado del siniestro"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (editarSiniestrosBean.getNumSiniestro() != null){
                Thread.sleep(2000);
                WebElement numSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numSiniestro.sendKeys(editarSiniestrosBean.getNumSiniestro());
            }

            if (editarSiniestrosBean.getNumPoliza() != null){
                Thread.sleep(2000);
                WebElement numPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numPoliza.sendKeys(editarSiniestrosBean.getNumPoliza());
            }

            if (editarSiniestrosBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaOcurrenciaSiniestro  = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/button"));
                fechaOcurrenciaSiniestro.sendKeys(editarSiniestrosBean.getFechaOcurrenciaSiniestro());
            }

            String productos = "VidaDeudoresAvVillas";

            if (editarSiniestrosBean.getProducto() != null){
                //if (editarSiniestrosBean.getProducto() == productos){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                    btnSeleccionar.click();
                    Thread.sleep(1000);
                    WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    producto.click();
                //}
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i,"screen4",nombreAutomatizacion);

            WebElement btnBuscar  = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span"));
            btnBuscar.click();

            Thread.sleep(4000);

            }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda(WebDriver driver,Metodos13_8 a, EditarSiniestrosBean editarSiniestrosBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(25000);
            a.changeLastWindows(driver);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (WebDriver driver, Metodos13_8 a, EditarSiniestrosBean editarSiniestrosBean, int i){
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
            Select horaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"1837254\"]/td[3]/font/select")));
            horaOcurrencia.selectByValue(editarSiniestrosBean.getHoraOcurrencia());

            Thread.sleep(2000);
            WebElement fechaAvisoCompania = driver.findElement(By.xpath("//*[@id=\"1837174\"]/td[3]/font/input[1]"));
            fechaAvisoCompania.clear();
            fechaAvisoCompania.sendKeys(editarSiniestrosBean.getFechaAvisoCompania());

            if (editarSiniestrosBean.getHoraNotificacion() != null){
                Select horaNotificacion = new Select(driver.findElement(By.xpath("//*[@id=\"9486594\"]/td[3]/font/select")));
                horaNotificacion.selectByValue(editarSiniestrosBean.getHoraNotificacion());
            }

            if (editarSiniestrosBean.getFechaReclFormalizacion() != null){
                WebElement fechaReclFormalizacion = driver.findElement(By.xpath("//*[@id=\"28932594\"]/td[3]/font/input[1]"));
                fechaReclFormalizacion.sendKeys(editarSiniestrosBean.getFechaReclFormalizacion());
            }

            if (editarSiniestrosBean.getFechaInterrupcionTerminos() != null){
                WebElement fechaInterrupcionTerminos = driver.findElement(By.xpath("//*[@id=\"30022594\"]/td[3]/font/input[1]"));
                fechaInterrupcionTerminos.sendKeys(editarSiniestrosBean.getFechaInterrupcionTerminos());
            }

            if (editarSiniestrosBean.getDocumentoIdentReclamante() != null){
                WebElement documentoIdentReclamante = driver.findElement(By.xpath("//*[@id=\"31763194\"]/td[3]/font/input[1]"));
                documentoIdentReclamante.sendKeys(editarSiniestrosBean.getDocumentoIdentReclamante());
            }

            if (editarSiniestrosBean.getReclamante() != null){
                WebElement reclamante = driver.findElement(By.xpath("//*[@id=\"23937694\"]/td[3]/font/input[1]"));
                reclamante.sendKeys(editarSiniestrosBean.getReclamante());
            }

            Thread.sleep(1000);
            Select causaGeneralMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"23854894\"]/td[3]/font/select")));
            causaGeneralMuerte.selectByValue(editarSiniestrosBean.getCausaGeneralMuerte());

            Thread.sleep(1000);
            Select causalesEspecifCobertMuerte = new Select(driver.findElement(By.xpath("//*[@id=\"29997794\"]/td[3]/font/select")));
            causalesEspecifCobertMuerte.selectByValue(editarSiniestrosBean.getCausalesEspecifCobertMuerte());

            Thread.sleep(1000);
            Select departamento = new Select(driver.findElement(By.xpath("//*[@id=\"1934614\"]/td[3]/font/select")));
            departamento.selectByValue(editarSiniestrosBean.getDepartamento());

            Thread.sleep(1000);
            Select ciudad = new Select(driver.findElement(By.xpath("//*[@id=\"9508794\"]/td[3]/font/select")));
            ciudad.selectByValue(editarSiniestrosBean.getCiudad());

            if (editarSiniestrosBean.getGeneroAsegurado() != null){
                Select generoAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763594\"]/td[3]/font/select")));
                generoAsegurado.selectByValue(editarSiniestrosBean.getGeneroAsegurado());
            }

            if (editarSiniestrosBean.getProfesionAsegurado() != null){
                Select profesionAsegurado = new Select(driver.findElement(By.xpath("//*[@id=\"31763694\"]/td[3]/font/input[2]")));
                profesionAsegurado.selectByValue(editarSiniestrosBean.getProfesionAsegurado());
            }

            WebElement btnLimpiar = driver.findElement(By.xpath("//*[@id=\"ProfesionAseguradoClearLink\"]"));
            btnLimpiar.click();


            if (editarSiniestrosBean.getActividadSiniestro() != null){
                Select actividadSiniestro = new Select(driver.findElement(By.xpath("//*[@id=\"30018694\"]/td[3]/font/select")));
                actividadSiniestro.selectByValue(editarSiniestrosBean.getActividadSiniestro());
            }

            if (editarSiniestrosBean.getFechaActividad() != null){
                WebElement fechaActividad = driver.findElement(By.xpath("//*[@id=\"30018794\"]/td[3]/font/input[1]"));
                fechaActividad.sendKeys(editarSiniestrosBean.getFechaActividad());
            }

            if (editarSiniestrosBean.getObservacionesSiniestro() != null){
                WebElement observacionesSiniestro = driver.findElement(By.xpath("//*[@id=\"3746174\"]/td[3]/font/textarea"));
                observacionesSiniestro.sendKeys(editarSiniestrosBean.getObservacionesSiniestro());
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
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}
