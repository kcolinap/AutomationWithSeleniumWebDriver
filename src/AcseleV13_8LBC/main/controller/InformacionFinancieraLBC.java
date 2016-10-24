package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.InformacionFinancieraLBCBean;
import AcseleV13_8LBC.main.controller.Menu.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by rmontilla on 20/10/2016.
 */
public class InformacionFinancieraLBC {

    private final static Logger log = Logger.getLogger(InformacionFinancieraLBC.class);

    public String nombreAutomatizacion = "LBC Terceros Informacion Financiera";

    public void testLink(InformacionFinancieraLBCBean informacionFinancieraLBCBean, int i) throws Exception {

        try {

            // Instanciando clases
            MetodosLBC a = new MetodosLBC();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, i);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, informacionFinancieraLBCBean); //Busqueda Tercero
            Formulario(a, driver, informacionFinancieraLBCBean);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BusquedaT(MetodosLBC a, WebDriver driver, InformacionFinancieraLBCBean informacionFinancieraLBCBean) throws InterruptedException, IOException {

        try {

            //   Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (informacionFinancieraLBCBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                Select tipoT = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[1]/div/div[2]/select")));
                if (informacionFinancieraLBCBean.getTipoTercero().equals("Persona Natural")) {
                    tipoT.selectByValue("NaturalPerson");
                }

                if (informacionFinancieraLBCBean.getTipoTercero().equals("Persona Juridica")) {
                    tipoT.selectByValue("LegalPerson");
                }
            }

            //    Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (informacionFinancieraLBCBean.getTipoDocId() != null) {
                Select tipoDocId = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[4]/div/div/div/select")));

                if (informacionFinancieraLBCBean.getTipoDocId().equals("CÉDULA DE EXTRANJERO")) {

                    tipoDocId.selectByValue("778589");
                    Thread.sleep(1000);
                }

                if (informacionFinancieraLBCBean.getTipoDocId().equals("CÉDULA DE IDENTIDAD")) {

                    tipoDocId.selectByValue("778590");
                    Thread.sleep(1000);
                }

                if (informacionFinancieraLBCBean.getTipoDocId().equals("PASAPORTE")) {

                    tipoDocId.selectByValue("778591");
                    Thread.sleep(1000);
                }

                if (informacionFinancieraLBCBean.getTipoDocId().equals("REGISTRO UNICO NACIONAL")) {

                    tipoDocId.selectByValue("778592");
                    Thread.sleep(1000);
                }

                if (informacionFinancieraLBCBean.getTipoDocId().equals("SIN VALOR EN MIGRACION")) {

                    tipoDocId.selectByValue("778593");
                    Thread.sleep(1000);
                }
            }

            if (informacionFinancieraLBCBean.getCedula() != null) {
                WebElement cedu = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[2]/div[4]/div/div/input[2]"));
                cedu.sendKeys(informacionFinancieraLBCBean.getCedula());
            }

            if (informacionFinancieraLBCBean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[2]/div/div/input[2]"));
                nTercero.sendKeys(informacionFinancieraLBCBean.getNombre());
            }

            if (informacionFinancieraLBCBean.getApellido() != null) {
                WebElement aTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[1]/div/div/input[2]"));
                aTercero.sendKeys(informacionFinancieraLBCBean.getApellido());
            }

            Thread.sleep(3000);
            //Screenshot
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            if (informacionFinancieraLBCBean.getCodIdentificador() != null) {
                WebElement codTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/div[4]/div/div/input[2]"));
                codTercero.sendKeys(informacionFinancieraLBCBean.getCodIdentificador());
            }



            //WebElement buscar = driver.findElement(By.name("searchButton"));
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            //WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();


            Thread.sleep(2000);
            WebElement editarTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[2]/div/form/input[1]"));
            editarTercero.click();
            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Formulario(MetodosLBC a, WebDriver driver, InformacionFinancieraLBCBean informacionFinancieraLBCBean) throws InterruptedException {
        Thread.sleep(5000);
        try {
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            WebElement agrcover = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/form/div[2]/div[1]/input"));
            agrcover.click();
            Thread.sleep(3000);

            WebElement puntero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[1]"));

            if (informacionFinancieraLBCBean.getActivos() != null) {
                WebElement activos = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[1]/div/div/input[2]"));
                activos.sendKeys(informacionFinancieraLBCBean.getActivos());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getActivosFijos() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement activosf = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[1]/div/div/input[2]"));
                activosf.sendKeys(informacionFinancieraLBCBean.getActivosFijos());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getInversiones() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement inver = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[2]/div/div/input[2]"));
                inver.sendKeys(informacionFinancieraLBCBean.getInversiones());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getOtrosActivos() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement otrosact = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[2]/div/div/input[2]"));
                otrosact.sendKeys(informacionFinancieraLBCBean.getOtrosActivos());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getTotalActivos() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement totalact = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[3]/div/div/input[2]"));
                totalact.sendKeys(informacionFinancieraLBCBean.getTotalActivos());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getPasivoCirculante() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement pascir = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[3]/div/div/input[2]"));
                pascir.sendKeys(informacionFinancieraLBCBean.getPasivoCirculante());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getPasivosLargoPlazo() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement paslar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[4]/div/div/input[2]"));
                paslar.sendKeys(informacionFinancieraLBCBean.getPasivosLargoPlazo());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getCapitalPagado() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement cappag = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[4]/div/div/input[2]"));
                cappag.sendKeys(informacionFinancieraLBCBean.getCapitalPagado());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getCapitalReserva() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement capres = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[5]/div/div/input[2]"));
                capres.sendKeys(informacionFinancieraLBCBean.getCapitalReserva());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getExcedente() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement exc = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[5]/div/div/input[2]"));
                exc.sendKeys(informacionFinancieraLBCBean.getExcedente());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getTotPasCap() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement totpascap = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[6]/div/div/input[2]"));
                totpascap.sendKeys(informacionFinancieraLBCBean.getTotPasCap());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getCapitalTrabajo() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement captra = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[6]/div/div/input[2]"));
                captra.sendKeys(informacionFinancieraLBCBean.getCapitalTrabajo());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getSolvencia() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement sol = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[7]/div/div/input[2]"));
                sol.sendKeys(informacionFinancieraLBCBean.getSolvencia());
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getLiquidez() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement liq = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[7]/div/div/input[2]"));
                liq.sendKeys(informacionFinancieraLBCBean.getLiquidez());
                Thread.sleep(4000);
            }


            //Thread.sleep(2000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            puntero.click();
            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[2]/div/div[2]/input"));
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            btnGuardar.click();
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
}



