package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_InformacionFinancieraBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
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
public class LBC_InformacionFinanciera {

    private final static Logger log = Logger.getLogger(LBC_InformacionFinanciera.class);

    public String nombreAutomatizacion = "LBC Terceros Informacion Financiera";

    public void testLink(LBC_InformacionFinancieraBean lbcInformacionFinancieraBean, int i) throws Exception {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuMantenimiento menuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, lbcInformacionFinancieraBean); //Busqueda Tercero
            Formulario(a, driver, lbcInformacionFinancieraBean);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BusquedaT(LBC_Metodos a, WebDriver driver, LBC_InformacionFinancieraBean lbcInformacionFinancieraBean) throws InterruptedException, IOException {

        try {

            //   Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (lbcInformacionFinancieraBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                Select tipoT = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[1]/div/div[2]/select")));
                if (lbcInformacionFinancieraBean.getTipoTercero().equals("Persona Natural")) {
                    tipoT.selectByValue("NaturalPerson");
                }

                if (lbcInformacionFinancieraBean.getTipoTercero().equals("Persona Juridica")) {
                    tipoT.selectByValue("LegalPerson");
                }
            }

            //    Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (lbcInformacionFinancieraBean.getTipoDocId() != null) {
                Select tipoDocId = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[4]/div/div/div/select")));

                if (lbcInformacionFinancieraBean.getTipoDocId().equals("CÉDULA DE EXTRANJERO")) {

                    tipoDocId.selectByValue("778589");
                    Thread.sleep(1000);
                }

                if (lbcInformacionFinancieraBean.getTipoDocId().equals("CÉDULA DE IDENTIDAD")) {

                    tipoDocId.selectByValue("778590");
                    Thread.sleep(1000);
                }

                if (lbcInformacionFinancieraBean.getTipoDocId().equals("PASAPORTE")) {

                    tipoDocId.selectByValue("778591");
                    Thread.sleep(1000);
                }

                if (lbcInformacionFinancieraBean.getTipoDocId().equals("REGISTRO UNICO NACIONAL")) {

                    tipoDocId.selectByValue("778592");
                    Thread.sleep(1000);
                }

                if (lbcInformacionFinancieraBean.getTipoDocId().equals("SIN VALOR EN MIGRACION")) {

                    tipoDocId.selectByValue("778593");
                    Thread.sleep(1000);
                }
            }

            if (lbcInformacionFinancieraBean.getCedula() != null) {
                WebElement cedu = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[2]/div[4]/div/div/input[2]"));
                cedu.sendKeys(lbcInformacionFinancieraBean.getCedula());
            }

            if (lbcInformacionFinancieraBean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[2]/div/div/input[2]"));
                nTercero.sendKeys(lbcInformacionFinancieraBean.getNombre());
            }

            if (lbcInformacionFinancieraBean.getApellido() != null) {
                WebElement aTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[1]/div/div/input[2]"));
                aTercero.sendKeys(lbcInformacionFinancieraBean.getApellido());
            }

            Thread.sleep(3000);
            //Screenshot
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            if (lbcInformacionFinancieraBean.getCodIdentificador() != null) {
                WebElement codTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/div[4]/div/div/input[2]"));
                codTercero.sendKeys(lbcInformacionFinancieraBean.getCodIdentificador());
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

    public void Formulario(LBC_Metodos a, WebDriver driver, LBC_InformacionFinancieraBean lbcInformacionFinancieraBean) throws InterruptedException {
        Thread.sleep(5000);
        try {
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            WebElement agrcover = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/form/div[2]/div[1]/input"));
            agrcover.click();
            Thread.sleep(3000);

            WebElement puntero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[1]"));

            if (lbcInformacionFinancieraBean.getActivos() != null) {
                WebElement activos = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[1]/div/div/input[2]"));
                activos.sendKeys(lbcInformacionFinancieraBean.getActivos());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getActivosFijos() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement activosf = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[1]/div/div/input[2]"));
                activosf.sendKeys(lbcInformacionFinancieraBean.getActivosFijos());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getInversiones() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement inver = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[2]/div/div/input[2]"));
                inver.sendKeys(lbcInformacionFinancieraBean.getInversiones());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getOtrosActivos() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement otrosact = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[2]/div/div/input[2]"));
                otrosact.sendKeys(lbcInformacionFinancieraBean.getOtrosActivos());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getTotalActivos() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement totalact = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[3]/div/div/input[2]"));
                totalact.sendKeys(lbcInformacionFinancieraBean.getTotalActivos());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getPasivoCirculante() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement pascir = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[3]/div/div/input[2]"));
                pascir.sendKeys(lbcInformacionFinancieraBean.getPasivoCirculante());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getPasivosLargoPlazo() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement paslar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[4]/div/div/input[2]"));
                paslar.sendKeys(lbcInformacionFinancieraBean.getPasivosLargoPlazo());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getCapitalPagado() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement cappag = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[4]/div/div/input[2]"));
                cappag.sendKeys(lbcInformacionFinancieraBean.getCapitalPagado());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getCapitalReserva() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement capres = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[5]/div/div/input[2]"));
                capres.sendKeys(lbcInformacionFinancieraBean.getCapitalReserva());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getExcedente() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement exc = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[5]/div/div/input[2]"));
                exc.sendKeys(lbcInformacionFinancieraBean.getExcedente());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getTotPasCap() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement totpascap = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[6]/div/div/input[2]"));
                totpascap.sendKeys(lbcInformacionFinancieraBean.getTotPasCap());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getCapitalTrabajo() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement captra = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[6]/div/div/input[2]"));
                captra.sendKeys(lbcInformacionFinancieraBean.getCapitalTrabajo());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getSolvencia() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement sol = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/div[7]/div/div/input[2]"));
                sol.sendKeys(lbcInformacionFinancieraBean.getSolvencia());
                Thread.sleep(2000);
            }

            if (lbcInformacionFinancieraBean.getLiquidez() != null) {
                puntero.click();
                Thread.sleep(2000);
                WebElement liq = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/form/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/div[7]/div/div/input[2]"));
                liq.sendKeys(lbcInformacionFinancieraBean.getLiquidez());
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



