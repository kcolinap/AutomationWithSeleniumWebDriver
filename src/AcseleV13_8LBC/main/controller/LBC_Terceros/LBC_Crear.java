package AcseleV13_8LBC.main.controller.LBC_Terceros;

import AcseleV13_8LBC.beans.LBC_TercerosBean;
import AcseleV13_8LBC.main.controller.MetodosLBC;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 18/10/2016.
 */
public class LBC_Crear {

    private final static Logger log = Logger.getLogger(LBC_Crear.class);

    public void CrearTercero(MetodosLBC a, WebDriver driver, LBC_TercerosBean lbcTercerosBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;


            //WebElement input = driver.findElement(By.xpath("//input[@wicketpath='']"));
            //Select select = new Select(driver.findElement(By.xpath("//select[@wicketpath='']")));

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            if (lbcTercerosBean.getTipoTerceros() != null) {
                Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
                tipoTercero.selectByValue(lbcTercerosBean.getTipoTerceros());
                Thread.sleep(2000);
            }

            Thread.sleep(3000);

            WebElement clicOut = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_ThirdInformationLabel']"));

            if (lbcTercerosBean.getApellidoPaterno() != null){
                WebElement apellidoPaterno = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_field']"));
                apellidoPaterno.sendKeys(lbcTercerosBean.getApellidoPaterno());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getApellidoMaterno() != null){
                WebElement apellidoMaterno = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                apellidoMaterno.sendKeys(lbcTercerosBean.getApellidoMaterno());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getPrimerNombre() != null){
                WebElement primerNombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_2_fila_field']"));
                primerNombre.sendKeys(lbcTercerosBean.getPrimerNombre());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getSegundoNombre() != null){
                WebElement segundoNombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
                segundoNombre.sendKeys(lbcTercerosBean.getSegundoNombre());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getTipoDocumentoIdentificacion() != null){
                Select tipoDocumentoIdentificacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                tipoDocumentoIdentificacion.selectByValue(lbcTercerosBean.getTipoDocumentoIdentificacion());
                Thread.sleep(2000);
            }


            if (lbcTercerosBean.getNumeroDocumentoIdentificacion() != null){
                WebElement numeroDocumentoIdentificacion = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_field']"));
                numeroDocumentoIdentificacion.sendKeys(lbcTercerosBean.getNumeroDocumentoIdentificacion());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getSexo() != null){
                Select sexo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_6_fila_repeaterSelect_1_field']")));
                sexo.selectByValue(lbcTercerosBean.getSexo());
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getEstadoCivil() != null){
                Select estadoCivil = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                estadoCivil.selectByValue(lbcTercerosBean.getEstadoCivil());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(2000);
            //clicOut = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_9_fila_mandatory']"));
            // Asterisco de Prefiere que se facture a CI o NIT?

            if (lbcTercerosBean.getPrefiereFacturaCI_NIT() != null){
                if (lbcTercerosBean.getPrefiereFacturaCI_NIT().toLowerCase().equals("ci")){
                    WebElement ci = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_9_fila_field_repeaterChoice_1_radio']"));
                    ci.click();
                    jse.executeScript("window.scrollBy(0,500)", "");
                    Thread.sleep(2000);
                }
                else if (lbcTercerosBean.getPrefiereFacturaCI_NIT().toLowerCase().equals("nit")){
                    WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_9_fila_field_repeaterChoice_2_radio']"));
                    nit.click();
                    jse.executeScript("window.scrollBy(0,500)", "");
                    Thread.sleep(2000);
                }
            }

            if (lbcTercerosBean.getNacionalidad() != null){
                Select nacionalidad = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_10_fila_repeaterSelect_1_field']")));
                nacionalidad.selectByValue(lbcTercerosBean.getNacionalidad());
                jse.executeScript("window.scrollBy(0,500)", "");
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getFechaNacimiento() != null){
                Thread.sleep(2000);
                WebElement fechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_10_fila_fieldDate']"));
                fechaNacimiento.sendKeys(lbcTercerosBean.getFechaNacimiento());
                clicOut.click();
                jse.executeScript("window.scrollBy(0,500)", "");
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getCategoriaActividadEconomicaOcupacionPrincipal() != null){
                Select categoriaActividadEconomicaOcupacionPrincipal = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_11_fila_repeaterSelect_1_field']")));
                categoriaActividadEconomicaOcupacionPrincipal.selectByValue(lbcTercerosBean.getCategoriaActividadEconomicaOcupacionPrincipal());
                jse.executeScript("window.scrollBy(0,500)", "");
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getActividadEconomicaOcupacionPrincipal() != null){
                Select actividadEconomicaOcupacionPrincipal = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_11_fila_repeaterSelect_2_field']")));
                actividadEconomicaOcupacionPrincipal.selectByValue(lbcTercerosBean.getActividadEconomicaOcupacionPrincipal());
                jse.executeScript("window.scrollBy(0,500)", "");
                Thread.sleep(2000);
            }

            if (lbcTercerosBean.getTipoTrabajador() != null){
                Select tipoTrabajador = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_12_fila_repeaterSelect_1_field']")));
                tipoTrabajador.selectByValue(lbcTercerosBean.getTipoTrabajador());
                jse.executeScript("window.scrollBy(0,500)", "");
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,1000)", "");
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            if (lbcTercerosBean.getTelefonoFijo1() != null){
                WebElement telefonoFijo1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_1_fila_field']"));
                telefonoFijo1.sendKeys(lbcTercerosBean.getTelefonoFijo1());
                clicOut.click();
                Thread.sleep(2000);
            }


            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
            Thread.sleep(1000);
            btnGuardar.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
