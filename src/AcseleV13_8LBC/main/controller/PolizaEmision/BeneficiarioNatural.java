package AcseleV13_8LBC.main.controller.PolizaEmision;

import AcseleV13_8.beans.PolizaBean;
import AcseleV13_8.main.controller.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 10/08/2016.
 */
public class BeneficiarioNatural {

    private final static Logger log = Logger.getLogger(BeneficiarioNatural.class);

    public void AgregarBneficiarioNaturalBusquedaSimple(Metodos a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot,
                                                        int numScreenShoot2, int numScreenShoot3){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (polizaBean.getBeneficiarioNaturalNombre1() != null || polizaBean.getBeneficiarioNaturalNombre2() != null || polizaBean.getBeneficiarioNaturalApellido1() != null || polizaBean.getBeneficiarioNaturalApellido2() != null) {
                WebElement inputBeneficiarioNatural = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                inputBeneficiarioNatural.click();
                inputBeneficiarioNatural = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (polizaBean.getBeneficiarioNaturalNombre1() != null && polizaBean.getBeneficiarioNaturalNombre2() != null && polizaBean.getBeneficiarioNaturalApellido1() != null && polizaBean.getBeneficiarioNaturalApellido2() != null){
                    inputBeneficiarioNatural.sendKeys(polizaBean.getBeneficiarioNaturalNombre1() + " " + polizaBean.getBeneficiarioNaturalNombre2() + " " + polizaBean.getBeneficiarioNaturalApellido1() + " " +polizaBean.getBeneficiarioNaturalApellido2());
                }
                else if (polizaBean.getBeneficiarioNaturalNombre1() != null && polizaBean.getBeneficiarioNaturalNombre2() != null && polizaBean.getBeneficiarioNaturalApellido1() != null && polizaBean.getBeneficiarioNaturalApellido2() == null){
                    inputBeneficiarioNatural.sendKeys(polizaBean.getBeneficiarioNaturalNombre1() + " " + polizaBean.getBeneficiarioNaturalNombre2() + " " + polizaBean.getBeneficiarioNaturalApellido1());
                }
                else if (polizaBean.getBeneficiarioNaturalNombre1() != null && polizaBean.getBeneficiarioNaturalNombre2() == null && polizaBean.getBeneficiarioNaturalApellido1() != null && polizaBean.getBeneficiarioNaturalApellido2() != null){
                    inputBeneficiarioNatural.sendKeys(polizaBean.getBeneficiarioNaturalNombre1() + " " + polizaBean.getBeneficiarioNaturalApellido1() + " " +polizaBean.getBeneficiarioNaturalApellido2());
                }
                else if (polizaBean.getBeneficiarioNaturalNombre1() != null && polizaBean.getBeneficiarioNaturalNombre2() == null && polizaBean.getBeneficiarioNaturalApellido1() != null && polizaBean.getBeneficiarioNaturalApellido2() == null){
                    inputBeneficiarioNatural.sendKeys(polizaBean.getBeneficiarioNaturalNombre1() + " " + polizaBean.getBeneficiarioNaturalApellido1());
                }

            }

            Thread.sleep(3000);
            WebElement selBeneficiarioNatural = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li"));
            selBeneficiarioNatural.click();

            WebElement btnAsociarBenNat = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AssociateButton']"));
            btnAsociarBenNat.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Asociar Beneficiario Natural");
            }

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Select tipoBeneficiario = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement benefIrrevocableNo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_1_radio']"));
            WebElement benefIrrevocableSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_2_radio']"));
            WebElement porcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
            WebElement codBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_2_fila_field']"));
            Select parentezcoBeneficiario = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_3_fila_repeaterSelect_1_field']")));

            Thread.sleep(2000);
            if (polizaBean.getTipoBeneficiario() != null) {
                tipoBeneficiario.selectByValue(polizaBean.getTipoBeneficiario());
                Thread.sleep(1000);
            }

            if (polizaBean.getBeneficiarioIrrevocable() != null) {
                if (polizaBean.getBeneficiarioIrrevocable().toLowerCase().equals("si")) {
                    benefIrrevocableSi.click();
                } else if (polizaBean.getBeneficiarioIrrevocable().toLowerCase().equals("no")) {
                    benefIrrevocableNo.click();
                }
            }

            Thread.sleep(1000);

            if (polizaBean.getPorcentajeParticipacionBeneficiarioNatural() != null) {
                porcentaje.clear();
                porcentaje.sendKeys(polizaBean.getPorcentajeParticipacionBeneficiarioNatural());
                Thread.sleep(1000);
            }

            if (polizaBean.getCodigoBeneficiario() != null) {
                Thread.sleep(1000);
                codBeneficiario.sendKeys(polizaBean.getCodigoBeneficiario());
            }

            Thread.sleep(1000);
            if (polizaBean.getParentesco() != null) {
                parentezcoBeneficiario.selectByValue(polizaBean.getParentesco());
                Thread.sleep(1000);
            }

            Thread.sleep(2000);
            WebElement modoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            modoPago.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver,i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarBenNat = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarBenNat.click();

            /** Espere **/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Guardar Beneficiario Natural");
            }

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e) {
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EditarBeneficiarioNatural(Metodos a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i,
                                          int numScreenShoot, int numScreenShoot2){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement selBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_Container_sorting_1_Checked']"));
            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_EditButton']"));

            selBeneficiario.click();

            Thread.sleep(1000);
            //Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnParticipacion.click();


            Thread.sleep(3000);
            Select nuevoTipoBeneficiario = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement nuevoBenefIrrevocableNo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_1_radio']"));
            WebElement nuevoBenefIrrevocableSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_2_radio']"));
            WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
            WebElement nuevoCodBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_2_fila_field']"));
            Select nuevoParentezcoBeneficiario = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_3_fila_repeaterSelect_1_field']")));
            WebElement nuevoModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));

            Thread.sleep(2000);
            if (polizaBean.getNuevoTipoBeneficiario() != null){
                nuevoTipoBeneficiario.selectByValue(polizaBean.getNuevoTipoBeneficiario());
                Thread.sleep(1000);
            }

            if (polizaBean.getNuevoBeneficiarioIrrevocable() != null) {
                if (polizaBean.getNuevoBeneficiarioIrrevocable().toLowerCase().equals("si")) {
                    nuevoBenefIrrevocableSi.click();
                } else if (polizaBean.getNuevoBeneficiarioIrrevocable().toLowerCase().equals("no")) {
                    nuevoBenefIrrevocableNo.click();
                }
            }

            Thread.sleep(1000);

            if (polizaBean.getNuevoPorcentajeParticipacionBeneficiarioNatural() != null) {
                nuevoPorcentaje.clear();
                nuevoPorcentaje.sendKeys(polizaBean.getNuevoPorcentajeParticipacionBeneficiarioNatural());
                Thread.sleep(1000);
            }

            if (polizaBean.getNuevoCodigoBeneficiario() != null) {
                nuevoCodBeneficiario.sendKeys(polizaBean.getNuevoCodigoBeneficiario());
            }

            if (polizaBean.getNuevoParentesco() != null) {
                nuevoParentezcoBeneficiario.selectByValue(polizaBean.getNuevoParentesco());
            }
            Thread.sleep(1000);
            nuevoModoPago.click();

            /*Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_Container_sorting_1_radio']"));
            btnGuardar.click();
            */

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarBenNat = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarBenNat.click();

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EliminarBeneficiarioNatural(Metodos a, WebDriver driver, String nombreAutomatizacion, int i, int numScreenShoot,
                                            int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(3000);
            WebElement selBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
            WebElement btnEliminar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_DeleteButton']"));

            selBeneficiario.click();

            Thread.sleep(1000);
            //Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


            btnEliminar.click();

            Thread.sleep(1000);
            //Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            btnSi.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarBeneficiarioNaturalBusquedaAvanzada(Metodos a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion){
        try {
            //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);
            WebElement btnBusquedaAvanzada = driver.findElement(By.xpath("//a[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearchLink']"));
            btnBusquedaAvanzada.click();

            Thread.sleep(2000);

            Select tipoBenNatSelect1 = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_thirdPartyTypes']")));
            Select tipoDocIdSelect1 = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement cedulaInput1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            WebElement nombreInput1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            WebElement apellidoInput1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
            WebElement btnBuscarBenNat1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_searchButton']"));

            /*
            if (emisionPolizaBeneficiarioNaturalBean.getTipoTerceroBN() != null){
                Thread.sleep(2000);
                tipoBenNatSelect1.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoTerceroBN());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getTipoDocIdBN() != null){
                Thread.sleep(2000);
                tipoDocIdSelect1.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoDocIdBN());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNumDocIdBN() != null){
                Thread.sleep(2000);
                cedulaInput1.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumDocIdBN());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNombreBN() != null){
                Thread.sleep(2000);
                nombreInput1.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNombreBN());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getApellidoBN() != null){
                Thread.sleep(2000);
                apellidoInput1.sendKeys(emisionPolizaBeneficiarioNaturalBean.getApellidoBN());
            }
            */
            Thread.sleep(2000);
            btnBuscarBenNat1.click();

            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            Thread.sleep(2000);
            WebElement btnSelBenNat = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            btnSelBenNat.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAsociarBenNat = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnAsociarBenNat.click();

            /** Espere **/
            WebElement mensajeEspera2 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera2.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Select tipoBeneficiario = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement benefIrrevocableNo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_1_radio']"));
            WebElement benefIrrevocableSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_2_radio']"));
            WebElement porcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
            WebElement codBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_2_fila_field']"));
            Select parentezcoBeneficiario = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_3_fila_repeaterSelect_1_field']")));
            WebElement modoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_radio']"));
            /*
            tipoBeneficiario.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoBeneficiario());
            Thread.sleep(1000);

            if (emisionPolizaBeneficiarioNaturalBean.getBeneficiarioIrrevocable() == "SI" || emisionPolizaBeneficiarioNaturalBean.getBeneficiarioIrrevocable() == "si"
                    || emisionPolizaBeneficiarioNaturalBean.getBeneficiarioIrrevocable() == "Si"){
                benefIrrevocableSi.click();
            }
            else if (emisionPolizaBeneficiarioNaturalBean.getBeneficiarioIrrevocable() == "NO" || emisionPolizaBeneficiarioNaturalBean.getBeneficiarioIrrevocable() == "no"
                    || emisionPolizaBeneficiarioNaturalBean.getBeneficiarioIrrevocable() == "No"){
                benefIrrevocableNo.click();
            }

            Thread.sleep(1000);

            if (emisionPolizaBeneficiarioNaturalBean.getPorcBeneficiario() != null) {
                porcentaje.clear();
                porcentaje.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcBeneficiario());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getCodBeneficiario() != null) {
                Thread.sleep(1000);
                codBeneficiario.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcBeneficiario());
            }

            Thread.sleep(1000);
            parentezcoBeneficiario.selectByValue(emisionPolizaBeneficiarioNaturalBean.getParentezco());
            Thread.sleep(1000);
            modoPago.click();
            */
            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen15", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarBenNat = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarBenNat.click();

            /** Espere **/
            WebElement mensajeEspera3 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera3.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            // Cerrar el buscador
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_detailSearch_closeDetailSearch_container']")).click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen16", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
