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
 * Created by agil on 17/11/2016.
 */
public class Inter_CrearTercero {

    private final static Logger log = Logger.getLogger(Inter_CrearTercero.class);

    public void CrearTerceroNatural(Interseguros_Metodos a, WebDriver driver, Inter_TercerosBean interTercerosBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            //WebElement input = driver.findElement(By.xpath("//input[@wicketpath='']"));
            //Select select = new Select(driver.findElement(By.xpath("//select[@wicketpath='']")));

            if (interTercerosBean.getTipoTercero() != null) {
                Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
                tipoTercero.selectByValue(interTercerosBean.getTipoTercero());
                Thread.sleep(2000);
            }

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(3000);

            WebElement clicOut = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_ThirdInformationLabel']"));

            if (interTercerosBean.getNumeroDocumentoIdentidad() != null){
                WebElement documentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_field']"));
                documentoIdentidad.sendKeys(interTercerosBean.getNumeroDocumentoIdentidad());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNumeroPasaporte() != null){
                WebElement numeroPasaporte = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                numeroPasaporte.sendKeys(interTercerosBean.getNumeroPasaporte());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNumeroCarnetExtranjeria() != null){
                WebElement numeroCarnetExtranjeria = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_2_fila_field']"));
                numeroCarnetExtranjeria.sendKeys(interTercerosBean.getNumeroCarnetExtranjeria());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNumeroCarnetAutomatizacionMinTrabajo() != null){
                WebElement numeroCarnetAutomatizacionMinTrabajo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
                numeroCarnetAutomatizacionMinTrabajo.sendKeys(interTercerosBean.getNumeroCarnetAutomatizacionMinTrabajo());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNumeroPartidaNacimiento() != null){
                WebElement numeroPartidaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
                numeroPartidaNacimiento.sendKeys(interTercerosBean.getNumeroPartidaNacimiento());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNumeroCarnetIdPolicia() != null){
                WebElement numeroCarnetPolicia = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_3_fila_field']"));
                numeroCarnetPolicia.sendKeys(interTercerosBean.getNumeroCarnetIdPolicia());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNumeroRucPersonaNatural() != null){
                WebElement numeroRucPersonaNatual = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_4_fila_field']"));
                numeroRucPersonaNatual.sendKeys(interTercerosBean.getNumeroRucPersonaNatural());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getLibretaMilitar() != null){
                WebElement libretaMilitar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_field']"));
                libretaMilitar.sendKeys(interTercerosBean.getLibretaMilitar());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNumeroCarnetFuerzasArmadas() != null){
                WebElement numeroCarnetFuerzasArmadas = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));
                numeroCarnetFuerzasArmadas.sendKeys(interTercerosBean.getNumeroCarnetFuerzasArmadas());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getCarnetDiplomatico() != null){
                WebElement carnetDiplomatico = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_5_fila_field']"));
                carnetDiplomatico.sendKeys(interTercerosBean.getCarnetDiplomatico());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getIndicadorColaborador() != null){
                Thread.sleep(1000);

                if (interTercerosBean.getIndicadorColaborador().toLowerCase().equals("no")){
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_6_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
                else if (interTercerosBean.getIndicadorColaborador().toLowerCase().equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_6_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getCodigoColaboradorIS() != null){
                WebElement codigoColaboradorIS = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_field']"));
                codigoColaboradorIS.sendKeys(interTercerosBean.getCodigoColaboradorIS());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getApellidoPaterno() != null){
                WebElement apellidoPaterno = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                apellidoPaterno.clear();
                apellidoPaterno = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                apellidoPaterno.click();
                Thread.sleep(400);
                apellidoPaterno.clear();
                Thread.sleep(400);
                WebElement otroEelemento = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_etiqueta']"));
                otroEelemento.click();
                Thread.sleep(500);
                apellidoPaterno = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                apellidoPaterno.click();
                apellidoPaterno.sendKeys(interTercerosBean.getApellidoPaterno());
                Thread.sleep(1000);

            }

            if (interTercerosBean.getApellidoMaterno() != null){
                WebElement apellidoMaterno = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                apellidoMaterno.sendKeys(interTercerosBean.getApellidoMaterno());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNombrePrimero() != null){
                WebElement nombrePrimero = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                nombrePrimero.click();
                Thread.sleep(800);
                nombrePrimero.clear();
                Thread.sleep(800);
                nombrePrimero = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                nombrePrimero.sendKeys(interTercerosBean.getNombrePrimero());
                //clicOut.click();
                Thread.sleep(4000);
            }

            if (interTercerosBean.getNombreSegundo() != null){
                WebElement nombreSegundo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_8_fila_field']"));
                nombreSegundo.sendKeys(interTercerosBean.getNombreSegundo());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getAutorizaEnvioCorreoElectronico() != null){
                Thread.sleep(1000);
                if (interTercerosBean.getAutorizaEnvioCorreoElectronico().toLowerCase().equals("no")){
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_9_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
                else if (interTercerosBean.getAutorizaEnvioCorreoElectronico().toLowerCase().equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_9_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getAutorizaEnvioSMS() != null){
                Thread.sleep(1000);
                if (interTercerosBean.getAutorizaEnvioSMS().toLowerCase().equals("no")){
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_9_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
                else if (interTercerosBean.getAutorizaEnvioSMS().toLowerCase().equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_9_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getAutorizaEnvioLlamadas() != null){
                Thread.sleep(1000);
                if (interTercerosBean.getAutorizaEnvioLlamadas().toLowerCase().equals("no")){
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_10_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
                else if (interTercerosBean.getAutorizaEnvioLlamadas().toLowerCase().equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_10_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getAutorizaComercializacionDatos() != null){
                Thread.sleep(1000);
                if (interTercerosBean.getAutorizaComercializacionDatos().toLowerCase().equals("no")){
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_10_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
                else if (interTercerosBean.getAutorizaComercializacionDatos().toLowerCase().equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_10_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getAutorizaTratamientoDatos() != null){
                Thread.sleep(1000);
                if (interTercerosBean.getAutorizaTratamientoDatos().toLowerCase().equals("no")){
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_11_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
                else if (interTercerosBean.getAutorizaTratamientoDatos().toLowerCase().equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_11_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getAutorizaAccesoDatos() != null){
                Thread.sleep(1000);
                if (interTercerosBean.getAutorizaAccesoDatos().toLowerCase().equals("no")){
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_11_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
                else if (interTercerosBean.getAutorizaAccesoDatos().toLowerCase().equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_11_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getProfesion() != null){
                Select profesion = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_12_fila_repeaterSelect_1_field']")));
                profesion.selectByValue(interTercerosBean.getProfesion());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getActividadEconomica() != null){
                Select actividadEconomica = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_12_fila_repeaterSelect_1_field']")));
                actividadEconomica.selectByValue(interTercerosBean.getActividadEconomica());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getCodigoApfPertenece() != null){
                Select codigoApfPertenece = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_13_fila_repeaterSelect_1_field']")));
                codigoApfPertenece.selectByValue(interTercerosBean.getCodigoApfPertenece());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getNacionalidad() != null){
                Select nacionalidad = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_13_fila_repeaterSelect_1_field']")));
                nacionalidad.selectByValue(interTercerosBean.getNacionalidad());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getFechaNacimiento() != null){
                WebElement fechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_14_fila_fieldDate']"));
                fechaNacimiento.sendKeys(interTercerosBean.getFechaNacimiento());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getEstadoCivil() != null){
                Select estadoCivil = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_14_fila_repeaterSelect_1_field']")));
                estadoCivil.selectByValue(interTercerosBean.getEstadoCivil());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getFechaMatrimonio() != null){
                WebElement fechaMatrimonio = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_15_fila_fieldDate']"));
                fechaMatrimonio.sendKeys(interTercerosBean.getFechaMatrimonio());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getFechaFallecimiento() != null){
                WebElement fechaFallecimiento = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_15_fila_fieldDate']"));
                fechaFallecimiento.sendKeys(interTercerosBean.getFechaFallecimiento());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getFumador() != null){
                Select fumador = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_16_fila_repeaterSelect_1_field']")));
                fumador.selectByValue(interTercerosBean.getFumador());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getSexo() != null){
                Select tipoDocumentoIdentificacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_16_fila_repeaterSelect_1_field']")));
                tipoDocumentoIdentificacion.selectByValue(interTercerosBean.getSexo());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getTelefonoCelular1() != null){
                WebElement telefonoCelular1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_17_fila_field']"));
                telefonoCelular1.sendKeys(interTercerosBean.getTelefonoCelular1());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getTelefonoCelular2() != null){
                WebElement telefonoCelular2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_17_fila_field']"));
                telefonoCelular2.sendKeys(interTercerosBean.getTelefonoCelular2());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getTelefonoCelular3() != null){
                WebElement telefonoCelular3 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_18_fila_field']"));
                telefonoCelular3.sendKeys(interTercerosBean.getTelefonoCelular3());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getCorreoElectronico1() != null){
                WebElement correoElectronico1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_18_fila_field']"));
                correoElectronico1.sendKeys(interTercerosBean.getCorreoElectronico1());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getCorreoElectronico2() != null){
                WebElement correoElectronico2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_19_fila_field']"));
                correoElectronico2.sendKeys(interTercerosBean.getCorreoElectronico2());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getCorreoElectronico3() != null){
                WebElement correoElectronico3 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_19_fila_field']"));
                correoElectronico3.sendKeys(interTercerosBean.getCorreoElectronico3());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getFacebookId() != null){
                WebElement facebookId = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_20_fila_field']"));
                facebookId.sendKeys(interTercerosBean.getFacebookId());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getTwitterId() != null){
                WebElement twitterId = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_20_fila_field']"));
                twitterId.sendKeys(interTercerosBean.getTwitterId());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getSkypeId() != null){
                WebElement skypeId = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_21_fila_field']"));
                skypeId.sendKeys(interTercerosBean.getSkypeId());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getYahooId() != null){
                WebElement yahooId = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_21_fila_field']"));
                yahooId.sendKeys(interTercerosBean.getYahooId());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getIndicadorPEP() != null){
                Select indicadorPEP = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_22_fila_repeaterSelect_1_field']")));
                indicadorPEP.selectByValue(interTercerosBean.getIndicadorPEP());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getComunicacionesGenerales() != null){
                Select comunicacionesGenerales = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_22_fila_repeaterSelect_1_field']")));
                comunicacionesGenerales.selectByValue(interTercerosBean.getComunicacionesGenerales());
                Thread.sleep(2000);
            }

            if (interTercerosBean.getCentroAseguradoTrabajo() != null){
                WebElement centroAseguradoTrabajo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_23_fila_field']"));
                centroAseguradoTrabajo.sendKeys(interTercerosBean.getCentroAseguradoTrabajo());
                clicOut.click();
                Thread.sleep(2000);
            }

            /*if (interTercerosBean.getActividadEconomicaOtra() != null){
                Select actividadEconomicaOtra = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_23_fila_repeaterSelect_1_field']")));
                actividadEconomicaOtra.selectByValue(interTercerosBean.getActividadEconomicaOtra());
                Thread.sleep(2000);
            }*/

            if (interTercerosBean.getCargoDesempenaAsegurado() != null){
                WebElement cargoDesempenaAsegurado = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_24_fila_field']"));
                cargoDesempenaAsegurado.sendKeys(interTercerosBean.getCargoDesempenaAsegurado());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getIdOrigenTercero() != null){
                WebElement idOrigenTerceroValidar = driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_23_fila_repeaterSelect_1_field']"));
                if (idOrigenTerceroValidar.isEnabled()) {
                    Select idOrigenTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_23_fila_repeaterSelect_1_field']")));
                    idOrigenTercero.selectByValue(interTercerosBean.getIdOrigenTercero());
                }
                Thread.sleep(2000);
            }

            if (interTercerosBean.getUserLogin() != null){
                WebElement userLogin = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_25_fila_field']"));
                userLogin.sendKeys(interTercerosBean.getUserLogin());
                clicOut.click();
                Thread.sleep(2000);
            }

            if (interTercerosBean.getCodigoIdentificador() != null){
                WebElement codigoIdentificador = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_24_fila_field']"));
                if (codigoIdentificador.isEnabled()) {
                    codigoIdentificador.sendKeys(interTercerosBean.getCodigoIdentificador());
                    clicOut.click();
                    Thread.sleep(2000);
                }
            }

            if (interTercerosBean.getCodigoInterno() != null){
                WebElement codigoInterno = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_25_fila_field']"));
                codigoInterno.sendKeys(interTercerosBean.getCodigoInterno());
                clicOut.click();
                Thread.sleep(2000);
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
            Thread.sleep(1000);
            btnGuardar.click();

            Thread.sleep(2000);
            //a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ValidarCreacionTercero(WebDriver driver, String nombreAutomatizacion){

        // Validacion de la prueba
        Boolean exitosa = driver.findElements(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdRolPanel_rolLabel']")).size() > 0;
        //Boolean apellidoObligatorio = driver.findElements(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_feedbackLabel']")).size() > 0;
        //Boolean nombreObligatorio = driver.findElements(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_feedbackLabel']")).size() > 0;
        //Boolean sexoObligatorio = driver.findElements(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_16_fila_repeaterSelect_1_feedbackLabel']")).size() > 0;
        Boolean apellidoObligatorio = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_feedbackLabel']")).isDisplayed();
        Boolean nombreObligatorio = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_feedbackLabel']")).isDisplayed();
        Boolean sexoObligatorio = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_16_fila_repeaterSelect_1_feedbackLabel']")).isDisplayed();
        Boolean mensajeErrores = driver.findElements(By.id("_wicket_window_12")).size() > 0;

        if (exitosa){
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Exitosa");
        }
        else if (apellidoObligatorio || nombreObligatorio || sexoObligatorio){
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: * Todos los campos son obligatorios");
            if (apellidoObligatorio)
                log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: El campo  'Apellido Paterno'  es obligatorio.");
            if (nombreObligatorio)
                log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: El campo  'Primer Nombre'  es obligatorio.");
            if (sexoObligatorio)
                log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: El campo  'Sexo'  es obligatorio.");
        }

        else if (mensajeErrores && driver.findElement(By.id("_wicket_window_12")).getText().equals("Se encontraron los siguientes errores, por favor verifique")){
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: Se encontraron los siguientes errores, por favor verifique");
            Boolean numDocIdError = driver.findElements(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_1_error']")).size() > 0;
            if (numDocIdError && driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_1_errorsMessage1_repeaterMessage_1_message']")).getText().equals("[ERROR] El identificador dado ya existe.")){
                log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: [ERROR] El identificador dado ya existe.");
            }
            else if (numDocIdError && driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_1_errorsMessage1_repeaterMessage_1_message']")).getText().equals("Debe incluir por lo menos una Identificacion")){
                log.error("Test Case - " + nombreAutomatizacion + " - " + "Debe incluir por lo menos una Identificacion");
            }
            else if (numDocIdError && driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_table_repeaterErrors_1_errorsMessage1_repeaterMessage_1_message']")).getText().equals("[Advertencia] La propiedad no cumple con las validaciones configuradas :\\d{8}")){
                log.error("Test Case - " + nombreAutomatizacion + " - " + "[Advertencia]  La propiedad  no cumple con las validaciones configuradas :\\d{8}");
            }
        }
    }
}
