package AcseleV13_8Asesuisa.main.controller.polizaEmision;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizasBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 06/03/2017.
 */
public class Asesuisa_ObjetoAsegurado {

    private final static Logger log = Logger.getLogger(Asesuisa_ObjetoAsegurado.class);

    public void ObjetoAsegurado1(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,1000)", "");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));
            //a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (bean.getOpcionAsegurado1() != null) {
                Select opcionSeguro = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                opcionSeguro.selectByValue(bean.getOpcionAsegurado1());
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();
            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espere Objeto Asegurado 1");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Asegurado1(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2) {

        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,500)", "");

            if (bean.getAsegurado1Nombre1() != null || bean.getAsegurado1Nombre2() != null || bean.getAsegurado1Apellido1() != null || bean.getAsegurado1Apellido2() != null) {

                Thread.sleep(1500);
                WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                asegurado.click();
                Thread.sleep(500);
                asegurado.click();
                asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (bean.getAsegurado1Nombre1() != null && bean.getAsegurado1Nombre2() != null && bean.getAsegurado1Apellido1() != null && bean.getAsegurado1Apellido2() != null) {
                    asegurado.sendKeys(bean.getAsegurado1Nombre1() + " " + bean.getAsegurado1Nombre2() + " " + bean.getAsegurado1Apellido1() + " " + bean.getAsegurado1Apellido2());
                }
                else if (bean.getAsegurado1Nombre1() != null && bean.getAsegurado1Nombre2() != null && bean.getAsegurado1Apellido1() != null && bean.getAsegurado1Apellido2() == null) {
                    asegurado.sendKeys(bean.getAsegurado1Nombre1() + " " + bean.getAsegurado1Nombre2() + " " + bean.getAsegurado1Apellido1());
                }
                else if (bean.getAsegurado1Nombre1() != null && bean.getAsegurado1Nombre2() == null && bean.getAsegurado1Apellido1() != null && bean.getAsegurado1Apellido2() != null) {
                    asegurado.sendKeys(bean.getAsegurado1Nombre1() + " " + bean.getAsegurado1Apellido1() + " " + bean.getAsegurado1Apellido2());
                }
                else if (bean.getAsegurado1Nombre1() != null && bean.getAsegurado1Nombre2() == null && bean.getAsegurado1Apellido1() != null && bean.getAsegurado1Apellido2() == null) {
                    asegurado.sendKeys(bean.getAsegurado1Nombre1() + " " + bean.getAsegurado1Apellido1());
                }
                Thread.sleep(2000);
                asegurado.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(500);
                asegurado.sendKeys(Keys.ENTER);
            }

            Thread.sleep(2000);
            //WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            //selAsegurado.click();
            Thread.sleep(2000);

            WebElement asociarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Asegurado");

            if (bean.getPorcentajeAsegurado1() != null && !bean.getPorcentajeAsegurado1().equals("100")){
                WebElement porcentajeAsegurado1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeAsegurado1.sendKeys(bean.getPorcentajeAsegurado1());
                Thread.sleep(1000);
            }


            //jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarAsegurado.click();

            a.waitSearchWicket(driver, "Espere Guardando Asegurado");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Requisitos1(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {

            try {

                JavascriptExecutor jse = (JavascriptExecutor)driver;

                Thread.sleep(1500);
                WebElement recibirBtn = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RequirementsContainer_headerRecieved_recieve']"));
                recibirBtn.click();

                jse.executeScript("window.scrollBy(0,400)", "");
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(1000);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Beneficiario1(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2) {

        try {

            try {

                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,500)", "");

                if (bean.getBeneficiario1Nombre1() != null || bean.getBeneficiario1Nombre2() != null || bean.getBeneficiario1Apellido1() != null || bean.getBeneficiario1Apellido2() != null) {

                    Thread.sleep(1500);
                    WebElement beneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                    beneficiario.click();
                    Thread.sleep(500);
                    beneficiario.click();
                    beneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                    if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() != null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() != null) {
                        beneficiario.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Nombre2() + " " + bean.getBeneficiario1Apellido1() + " " + bean.getBeneficiario1Apellido2());
                    }
                    else if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() != null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() == null) {
                        beneficiario.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Nombre2() + " " + bean.getBeneficiario1Apellido1());
                    }
                    else if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() == null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() != null) {
                        beneficiario.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Apellido1() + " " + bean.getBeneficiario1Apellido2());
                    }
                    else if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() == null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() == null) {
                        beneficiario.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Apellido1());
                    }
                    Thread.sleep(2000);
                    beneficiario.sendKeys(Keys.ARROW_DOWN);
                    Thread.sleep(500);
                    beneficiario.sendKeys(Keys.ENTER);
                }

                Thread.sleep(2000);
                WebElement selBeneficiario = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[1]"));
                // /html/body/div[6]/div/ul/li[1]
                selBeneficiario.click();
                Thread.sleep(2000);

                WebElement asociarBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AssociateButton']"));
                asociarBeneficiario.click();
                Thread.sleep(1000);

                a.waitSearchWicket(driver, "Asociar Beneficiario");

                if (bean.getTipoBeneficiario1() != null){
                    Select tipoBeneficiario1 = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                    tipoBeneficiario1.selectByValue(bean.getTipoBeneficiario1());
                    Thread.sleep(1000);
                }

                if (bean.getPorcentajeBeneficiario1() != null && !bean.getPorcentajeBeneficiario1().equals("100")){
                    WebElement porcentajeBeneficiario1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                    porcentajeBeneficiario1.sendKeys(bean.getPorcentajeBeneficiario1());
                    Thread.sleep(1000);
                }


                jse.executeScript("window.scrollBy(0,400)", "");
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(1000);

                WebElement btnGuardarBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
                btnGuardarBeneficiario.click();

                a.waitSearchWicket(driver, "Espere Guardando Beneficiario");

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Toolkit.getDefaultToolkit().beep();

            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAsegurado2(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,-2000)", "");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));
            //a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            WebElement agregarOA = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_containerButton_NewButtonInsurance']"));
            agregarOA.click();
            a.waitSearchWicket(driver, "Espere Agregando 2do Objeto Asegurado");

            if (bean.getOpcionAsegurado1() != null) {
                Select opcionSeguro = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                opcionSeguro.selectByValue(bean.getOpcionAsegurado1());
                Thread.sleep(1000);
            }

            //jse.executeScript("window.scrollBy(0,2500)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();
            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espere Objeto Asegurado 1");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Asegurado2(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2) {

        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,500)", "");

            if (bean.getAsegurado2Nombre1() != null || bean.getAsegurado2Nombre2() != null || bean.getAsegurado2Apellido1() != null || bean.getAsegurado2Apellido2() != null) {

                Thread.sleep(1500);
                WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                asegurado.click();
                Thread.sleep(500);
                asegurado.click();
                asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (bean.getAsegurado2Nombre1() != null && bean.getAsegurado2Nombre2() != null && bean.getAsegurado2Apellido1() != null && bean.getAsegurado2Apellido2() != null) {
                    asegurado.sendKeys(bean.getAsegurado2Nombre1() + " " + bean.getAsegurado2Nombre2() + " " + bean.getAsegurado2Apellido1() + " " + bean.getAsegurado2Apellido2());
                }
                else if (bean.getAsegurado2Nombre1() != null && bean.getAsegurado2Nombre2() != null && bean.getAsegurado2Apellido1() != null && bean.getAsegurado2Apellido2() == null) {
                    asegurado.sendKeys(bean.getAsegurado2Nombre1() + " " + bean.getAsegurado2Nombre2() + " " + bean.getAsegurado2Apellido1());
                }
                else if (bean.getAsegurado2Nombre1() != null && bean.getAsegurado2Nombre2() == null && bean.getAsegurado2Apellido1() != null && bean.getAsegurado2Apellido2() != null) {
                    asegurado.sendKeys(bean.getAsegurado2Nombre1() + " " + bean.getAsegurado2Apellido1() + " " + bean.getAsegurado2Apellido2());
                }
                else if (bean.getAsegurado2Nombre1() != null && bean.getAsegurado2Nombre2() == null && bean.getAsegurado2Apellido1() != null && bean.getAsegurado2Apellido2() == null) {
                    asegurado.sendKeys(bean.getAsegurado2Nombre1() + " " + bean.getAsegurado2Apellido1());
                }
                Thread.sleep(3000);
                asegurado.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(500);
                asegurado.sendKeys(Keys.ENTER);
            }

            Thread.sleep(2000);
            //WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            //selAsegurado.click();
            Thread.sleep(2000);

            WebElement asociarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Asegurado");

            if (bean.getPorcentajeAsegurado2() != null && !bean.getPorcentajeAsegurado2().equals("100")){
                WebElement porcentajeAsegurado2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeAsegurado2.sendKeys(bean.getPorcentajeAsegurado2());
                Thread.sleep(1000);
            }


            //jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarAsegurado.click();

            a.waitSearchWicket(driver, "Espere Guardando Asegurado");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Requisitos2(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {

            try {

                JavascriptExecutor jse = (JavascriptExecutor)driver;

                Thread.sleep(1500);
                WebElement recibirBtn = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RequirementsContainer_headerRecieved_recieve']"));
                recibirBtn.click();

                jse.executeScript("window.scrollBy(0,400)", "");
                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(1000);


            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAseguradoAutomotores1(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2,
                                            int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7, int numScreenShoot8) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,1000)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_containerButton_NewButtonInsurance']"));
            btnAgregar.click();

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Agregando Objeto Asegurado");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (bean.getTipoObjetoAsegurado1().toLowerCase().equals("plan full extras - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_1_insurance']"));
                plan.click();
                Thread.sleep(1000);

            }
            else if (bean.getTipoObjetoAsegurado1().toLowerCase().equals("plan full extras advanced - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_2_insurance']"));
                plan.click();
                Thread.sleep(1000);
            }
            else if (bean.getTipoObjetoAsegurado1().toLowerCase().equals("paquete full extras - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_3_insurance']"));
                plan.click();
                Thread.sleep(1000);
            }
            else if (bean.getTipoObjetoAsegurado1().toLowerCase().equals("plan rc básico - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_4_insurance']"));
                plan.click();
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_addButton']"));
            btnAceptar.click();
            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espere Agregando el Tipo de Objeto Asegurado 1");

            Thread.sleep(2000);

            /******/
            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));

            if (bean.getMarca1() != null){
                Select marca= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                //marca.selectByValue(bean.getMarca1());
                marca.selectByVisibleText(bean.getMarca1());
                otro.click();
                Thread.sleep(30000);
            }

            if (bean.getModelo1() != null){
                Select modelo= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_2_field']")));
                //modelo.selectByValue(bean.getModelo1());
                modelo.selectByVisibleText(bean.getModelo1());
                otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(15000);
            }

            if (bean.getAnio1() != null){
                Thread.sleep(2000);
                Select anio= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                //anio.selectByValue(bean.getAnio1());
                anio.selectByVisibleText(bean.getAnio1());
                otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(20000);
            }

            if (bean.getNumeroAsientos1() != null){
                WebElement numAsientos= driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_7_fila_field']"));
                numAsientos.sendKeys(bean.getNumeroAsientos1());
                otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,-500)", "");
            jse.executeScript("hideWait()", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Agregando OA");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAseguradoAutomotores2(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2,
                                            int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7, int numScreenShoot8) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,-2500)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_containerButton_NewButtonInsurance']"));
            btnAgregar.click();

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Agregando Objeto Asegurado");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (bean.getTipoObjetoAsegurado2().toLowerCase().equals("plan full extras - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_1_insurance']"));
                plan.click();
                Thread.sleep(1000);

            }
            else if (bean.getTipoObjetoAsegurado2().toLowerCase().equals("plan full extras advanced - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_2_insurance']"));
                plan.click();
                Thread.sleep(1000);
            }
            else if (bean.getTipoObjetoAsegurado2().toLowerCase().equals("paquete full extras - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_3_insurance']"));
                plan.click();
                Thread.sleep(1000);
            }
            else if (bean.getTipoObjetoAsegurado2().toLowerCase().equals("plan rc básico - automotores")) {

                WebElement plan = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_groupInsurance_addInsuranceObjectTable_4_insurance']"));
                plan.click();
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_AddInsuranceObjectTable_buttonForm_addButton']"));
            btnAceptar.click();
            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espere Agregando el Tipo de Objeto Asegurado 1");

            Thread.sleep(1000);

            /******/
            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));

            if (bean.getMarca2() != null){
                Select marca= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
//                marca.selectByValue(bean.getMarca2());
                marca.selectByVisibleText(bean.getMarca2());
                otro.click();
                Thread.sleep(30000);
            }

            if (bean.getModelo2() != null){
                Select modelo= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_repeaterSelect_2_field']")));
//                modelo.selectByValue(bean.getModelo2());
                modelo.selectByVisibleText(bean.getModelo2());
                otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(15000);
            }

            if (bean.getAnio2() != null){
                Thread.sleep(2000);
                Select anio= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
//                anio.selectByValue(bean.getAnio2());
                anio.selectByVisibleText(bean.getAnio2());
                otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(15000);
            }

            if (bean.getNumeroAsientos2() != null){
                WebElement numAsientos= driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_8_fila_field']"));
                numAsientos.sendKeys(bean.getNumeroAsientos2());
                otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,-500)", "");
            jse.executeScript("hideWait()", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot8, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Agregando OA");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
