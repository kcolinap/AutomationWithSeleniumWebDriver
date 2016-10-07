
package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.CancelarPagosBean;
import AcseleV13_8_Alfa.beans.EditarSiniestrosBean;
import AcseleV13_8_Alfa.beans.ObjetarCoberturaBean;
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
 * Created by aazuaje on 15/08/2016.
 */

public class EditarSiniestros {

    private final static Logger log = Logger.getLogger(EditarSiniestros.class);

    public String nombreAutomatizacion = "Editar Siniestros";

    public void testLink(EditarSiniestrosBean editarSiniestrosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        MenuCreacionSiniestro(driver, a);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, editarSiniestrosBean);
        ResultadoBusqueda(driver, a, editarSiniestrosBean);
        AgregarObjetoAfectado(driver, a, editarSiniestrosBean);


    }

    public void MenuCreacionSiniestro(WebDriver driver, Metodos a) throws IOException, InterruptedException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));//operaciones siniestros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[10]/div[2]"));//mantenimiento de siniestro

        menu1.click();
        menu2.click();
        Thread.sleep(2000);
        a.ScreenShot(driver,"screen3",nombreAutomatizacion);
        Thread.sleep(3000);
        menu3.click();

    }

    public void BuscarPoliza(WebDriver driver, Metodos a, EditarSiniestrosBean editarSiniestrosBean) throws IOException, InterruptedException{

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


            if (editarSiniestrosBean.getProducto() == "VidaDeudoresAvVillas"){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformpolicy_01\"]"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                producto.click();
            }

            Thread.sleep(1000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);

            WebElement btnBuscar  = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span"));
            btnBuscar.click();

            Thread.sleep(4000);

            }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda(WebDriver driver, Metodos a, EditarSiniestrosBean editarSiniestrosBean) throws IOException, InterruptedException{

        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[4]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(1000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);

            WebElement btnConsultar  = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(2000);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAfectado (WebDriver driver, Metodos a, EditarSiniestrosBean editarSiniestrosBean){
        try {
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));
            btnAgregar.click();

            Thread.sleep(15000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Select horaOcurrencia = new Select(driver.findElement(By.xpath("//*[@id=\"1837254\"]/td[3]/font/select")));
            horaOcurrencia.selectByValue(editarSiniestrosBean.getHoraOcurrencia());

            Thread.sleep(1000);
            WebElement fechaAvisoCompania = driver.findElement(By.xpath("//*[@id=\"1837174\"]/td[3]/font/input[1]"));
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
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_04020099_content_01\"]"));
            btnAceptar.click();

            Thread.sleep(15000);

            Thread.sleep(2000);
            a.ScreenShot(driver,"screen7",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}
