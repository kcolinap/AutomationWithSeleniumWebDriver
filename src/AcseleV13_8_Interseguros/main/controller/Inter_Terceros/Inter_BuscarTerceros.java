package AcseleV13_8_Interseguros.main.controller.Inter_Terceros;

import AcseleV13_8_Interseguros.beans.Inter_TercerosBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 26/01/2017.
 */
public class Inter_BuscarTerceros {

    private final static Logger log = Logger.getLogger(Inter_BuscarTerceros.class);

    public void BusquedaT(WebDriver driver, Interseguros_Metodos a, Inter_TercerosBean interTercerosBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {

            Thread.sleep(3000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title); // //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            //Tipo de tercero

            if (interTercerosBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(interTercerosBean.getTipoTercero());
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroDocumentoIdentidad() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNumeroDocumentoIdentidad());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroPasaporte() != null) {
                WebElement pass = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                pass.sendKeys(interTercerosBean.getNumeroPasaporte());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroCarnetExtranjeria() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNumeroCarnetExtranjeria());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroCarnetAutomatizacionMinTrabajo() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNumeroCarnetAutomatizacionMinTrabajo());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroPartidaNacimiento() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNumeroPartidaNacimiento());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroCarnetIdPolicia() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_3_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNumeroCarnetIdPolicia());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroRucPersonaNatural() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNumeroRucPersonaNatural());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getLibretaMilitar() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_field']"));
                cedu.sendKeys(interTercerosBean.getLibretaMilitar());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNumeroCarnetFuerzasArmadas() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNumeroCarnetFuerzasArmadas());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCarnetDiplomatico() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_5_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCarnetDiplomatico());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getIndicadorColaborador() != null) {

                if (interTercerosBean.getIndicadorColaborador().toLowerCase().equals("no")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_6_fila_field_repeaterChoice_1_radio']"));
                    cedu.sendKeys(interTercerosBean.getIndicadorColaborador());
                    otro.click();
                    Thread.sleep(500);
                }
                else if (interTercerosBean.getIndicadorColaborador().toLowerCase().equals("si")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_6_fila_field_repeaterChoice_2_radio']"));
                    cedu.sendKeys(interTercerosBean.getIndicadorColaborador());
                    otro.click();
                    Thread.sleep(500);
                }
            }

            if (interTercerosBean.getCodigoColaboradorIS() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_6_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCodigoColaboradorIS());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getApellidoPaterno() != null) {
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                apellido.clear();
                Thread.sleep(1500);
                WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_etiqueta']"));
                otroElemento.click();
                Thread.sleep(1000);
                apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                apellido.sendKeys(interTercerosBean.getApellidoPaterno());
                Thread.sleep(1500);
                otro.click();
            }

            if (interTercerosBean.getApellidoMaterno() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_field']"));
                cedu.clear();
                Thread.sleep(500);
                cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_field']"));
                cedu.sendKeys(interTercerosBean.getApellidoMaterno());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNombrePrimero() != null) {
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nombre.clear();
                Thread.sleep(1500);
                WebElement otroEelemento = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_etiqueta']"));
                otroEelemento.click();
                Thread.sleep(1000);
                nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nombre.sendKeys(interTercerosBean.getNombrePrimero());
                Thread.sleep(1500);
                otro.click();
            }

            if (interTercerosBean.getNombreSegundo() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_8_fila_field']"));
                cedu.clear();
                Thread.sleep(500);
                cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_8_fila_field']"));
                cedu.sendKeys(interTercerosBean.getNombreSegundo());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getAutorizaEnvioCorreoElectronico() != null) {
                if (interTercerosBean.getAutorizaEnvioCorreoElectronico().toLowerCase().equals("no")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_9_fila_field_repeaterChoice_1_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaEnvioCorreoElectronico());
                    otro.click();
                    Thread.sleep(500);
                }
                else if (interTercerosBean.getAutorizaEnvioCorreoElectronico().toLowerCase().equals("si")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_9_fila_field_repeaterChoice_2_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaEnvioCorreoElectronico());
                    otro.click();
                    Thread.sleep(500);
                }

            }

            if (interTercerosBean.getAutorizaEnvioSMS() != null) {
                if (interTercerosBean.getAutorizaEnvioSMS().toLowerCase().equals("no")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_9_fila_field_repeaterChoice_1_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaEnvioSMS());
                    otro.click();
                    Thread.sleep(500);
                }
                else if (interTercerosBean.getAutorizaEnvioSMS().toLowerCase().equals("si")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_9_fila_field_repeaterChoice_2_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaEnvioSMS());
                    otro.click();
                    Thread.sleep(500);
                }

            }

            if (interTercerosBean.getAutorizaEnvioLlamadas() != null) {
                if (interTercerosBean.getAutorizaEnvioLlamadas().toLowerCase().equals("no")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_10_fila_field_repeaterChoice_1_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaEnvioLlamadas());
                    otro.click();
                    Thread.sleep(500);
                }
                else if (interTercerosBean.getAutorizaEnvioLlamadas().toLowerCase().equals("si")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_10_fila_field_repeaterChoice_2_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaEnvioLlamadas());
                    otro.click();
                    Thread.sleep(500);
                }

            }

            if (interTercerosBean.getAutorizaComercializacionDatos() != null) {
                if (interTercerosBean.getAutorizaComercializacionDatos().toLowerCase().equals("no")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_10_fila_field_repeaterChoice_1_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaComercializacionDatos());
                    otro.click();
                    Thread.sleep(500);
                }
                else if (interTercerosBean.getAutorizaComercializacionDatos().toLowerCase().equals("si")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_10_fila_field_repeaterChoice_2_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaComercializacionDatos());
                    otro.click();
                    Thread.sleep(500);
                }

            }

            if (interTercerosBean.getAutorizaTratamientoDatos() != null) {
                if (interTercerosBean.getAutorizaTratamientoDatos().toLowerCase().equals("no")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_11_fila_field_repeaterChoice_1_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaTratamientoDatos());
                    otro.click();
                    Thread.sleep(500);
                }
                else if (interTercerosBean.getAutorizaTratamientoDatos().toLowerCase().equals("si")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_11_fila_field_repeaterChoice_2_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaTratamientoDatos());
                    otro.click();
                    Thread.sleep(500);
                }

            }

            if (interTercerosBean.getAutorizaAccesoDatos() != null) {
                if (interTercerosBean.getAutorizaAccesoDatos().toLowerCase().equals("no")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_11_fila_field_repeaterChoice_1_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaAccesoDatos());
                    otro.click();
                    Thread.sleep(500);
                }
                else if (interTercerosBean.getAutorizaAccesoDatos().toLowerCase().equals("si")){
                    WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_11_fila_field_repeaterChoice_2_radio']"));
                    cedu.sendKeys(interTercerosBean.getAutorizaAccesoDatos());
                    otro.click();
                    Thread.sleep(500);
                }

            }

            if (interTercerosBean.getProfesion() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_12_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getProfesion());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getActividadEconomica() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_12_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getActividadEconomica());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCodigoApfPertenece() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_13_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getCodigoApfPertenece());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getNacionalidad() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_13_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getNacionalidad());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getFechaNacimiento() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_14_fila_fieldDate']"));
                cedu.sendKeys(interTercerosBean.getFechaNacimiento());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getEstadoCivil() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_14_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getEstadoCivil());
                otro.click();
                Thread.sleep(500);
            }


            if (interTercerosBean.getFechaMatrimonio() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_15_fila_fieldDate']"));
                cedu.sendKeys(interTercerosBean.getFechaMatrimonio());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getFechaFallecimiento() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_15_fila_fieldDate']"));
                cedu.sendKeys(interTercerosBean.getFechaFallecimiento());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getFumador() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_16_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getFumador());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getSexo() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_16_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getSexo());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getTelefonoCelular1() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_17_fila_field']"));
                cedu.sendKeys(interTercerosBean.getTelefonoCelular1());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getTelefonoCelular2() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_17_fila_field']"));
                cedu.sendKeys(interTercerosBean.getTelefonoCelular2());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getTelefonoCelular3() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_18_fila_field']"));
                cedu.sendKeys(interTercerosBean.getTelefonoCelular3());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCorreoElectronico1() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_18_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCorreoElectronico1());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCorreoElectronico2() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCorreoElectronico2());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCorreoElectronico3() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_19_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCorreoElectronico3());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getFacebookId() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_20_fila_field']"));
                cedu.sendKeys(interTercerosBean.getFacebookId());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getTwitterId() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_20_fila_field']"));
                cedu.sendKeys(interTercerosBean.getTwitterId());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getSkypeId() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_21_fila_field']"));
                cedu.sendKeys(interTercerosBean.getSkypeId());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getYahooId() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_21_fila_field']"));
                cedu.sendKeys(interTercerosBean.getYahooId());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getIndicadorPEP() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_22_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getIndicadorPEP());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getComunicacionesGenerales() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_22_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getComunicacionesGenerales());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCentroAseguradoTrabajo() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_23_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCentroAseguradoTrabajo());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getActividadEconomicaOtra() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_23_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getActividadEconomicaOtra());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCargoDesempenaAsegurado() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_24_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCargoDesempenaAsegurado());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getIdOrigenTercero() != null) {
                Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_24_fila_repeaterSelect_1_field']")));
                cedu.selectByValue(interTercerosBean.getIdOrigenTercero());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getUserLogin() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_25_fila_field']"));
                cedu.sendKeys(interTercerosBean.getUserLogin());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCodigoIdentificador() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_25_fila_field']"));
                cedu.sendKeys(interTercerosBean.getCodigoIdentificador());
                otro.click();
                Thread.sleep(500);
            }

            if (interTercerosBean.getCodigoInterno() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='wicketpath=\"SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_26_fila_field\"']"));
                cedu.sendKeys(interTercerosBean.getCodigoInterno());
                otro.click();
                Thread.sleep(500);
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            a.waitSearchWicket(driver, "Espera busqueda 1");

            Thread.sleep(500);
            buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            a.waitSearchWicket(driver, "Espera busqueda 2");

            Thread.sleep(500);
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
