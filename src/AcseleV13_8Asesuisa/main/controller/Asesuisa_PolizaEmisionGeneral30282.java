package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionGeneral30282Bean;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.*;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
//import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by kcolina on 03/04/2017.
 */
public class Asesuisa_PolizaEmisionGeneral30282 {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionGeneral30282.class);

    public String nombreAutomatizacion = "Emision poliza 30282";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionGeneral30282Bean bean, int i, String folderName){


        try{

            //instanciar clase metodos
            Metodos metodos = new Metodos();
            Asesuisa_PrePoliza prePoliza = new Asesuisa_PrePoliza();
            //Asesuisa_InformacionGeneralPoliza informacionGeneralPoliza = new Asesuisa_InformacionGeneralPoliza();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = metodos.entrarPagina(metodos.UrlAsesuisa());
            metodos.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            metodos.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            menuOperaciones.OpePol_CotizacionSuscripcionEdicionCrearFrontEnd(driver, nombreAutomatizacion, 2, i,
                    folderName);
            Thread.sleep(1500);
            metodos.cambiarVentana(driver);

            /******************************
             * Comienzo de generacion de poliza
             */
            /**
             * PREPOLIZA
             */
            prePoliza.AdministracionPropuestaPoliza(metodos,driver,bean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(800);

            prePoliza.EvAplicar(metodos,driver,bean,nombreAutomatizacion,i,folderName,4);
            Thread.sleep(800);
            /**
             * **********************************
             */

            /**
             * INFORMACION GENERAL POLIZA
             */
            InformacionGeneralRoboYHurto30282(metodos, driver, bean, nombreAutomatizacion, i,
                    folderName, 6, 7, 8);
            Thread.sleep(800);

            Tomador(metodos, driver,bean,nombreAutomatizacion,i,9,10);
            Asegurado(metodos,driver,bean,nombreAutomatizacion,i,11,12);
            Beneficiario(metodos,driver,bean,nombreAutomatizacion,i,13,14);
            UnidadRiesgo(metodos,driver,bean,nombreAutomatizacion,i);
            ObjetosAsegurados(metodos,driver,bean,nombreAutomatizacion,i);
            Pantallazo(1, metodos, driver, i, nombreAutomatizacion,folderName);

            //Boton calcular
            Thread.sleep(1500);
            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();
            metodos.waitSearchWicket(driver,"Calculando");

            //Pantallazos despues de calcular
            Pantallazo(2, metodos, driver, i, nombreAutomatizacion,folderName);

            //WebElement lblTomador = driver.findElement(By.xpath("//li[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']"));
            //lblTomador.click();
            /**
             * ***************** fin informacion general
             */

            /***
             * FIN GENERACION DE POLIZA
             */
            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void InformacionGeneralRoboYHurto30282(Metodos a, WebDriver driver, Asesuisa_PolizaEmisionGeneral30282Bean bean, String nombreAutomatizacion, int i, String folderName,int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            if (bean.getPlanesFinanciamiento()!=null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(bean.getPlanesFinanciamiento());
                Thread.sleep(2000);
            }

            if (bean.getMonedas() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(bean.getMonedas());
                Thread.sleep(2000);
            }

            if (bean.getSucursal() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(bean.getSucursal());
                Thread.sleep(2000);
            }

            if (bean.getNumeroPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(bean.getNumeroPoliza());
                Thread.sleep(2000);
                //otroElemento.click();
                //Thread.sleep(3000);
            }

            if (bean.getTipoProduccion()!=null){
                Select tipoProduccion= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(bean.getTipoProduccion());
                Thread.sleep(2000);
            }

            if (bean.getFuncionamientoPoliza()!=null){
                Select funcionamientoPoliza= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                funcionamientoPoliza.selectByValue(bean.getFuncionamientoPoliza());
                Thread.sleep(2000);
            }

            if (bean.getCanalVenta()!=null){
                Select canalVenta= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']")));
                canalVenta.selectByValue(bean.getCanalVenta());
                Thread.sleep(2000);
                canalVenta= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']")));
                canalVenta.selectByValue(bean.getCanalVenta());
            }

            if (bean.getComisionNegociable()!=null){
                Select comisionNegociable= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_9_fila_repeaterSelect_1_field']")));
                comisionNegociable.selectByValue(bean.getComisionNegociable());
                Thread.sleep(2000);
            }

            if (bean.getUnidadComercial()!=null){
                Select unidadComercial= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_10_fila_repeaterSelect_1_field']")));
                unidadComercial.selectByValue(bean.getUnidadComercial());
                Thread.sleep(2000);
                unidadComercial= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_10_fila_repeaterSelect_1_field']")));
                unidadComercial.selectByValue(bean.getUnidadComercial());
            }

            if (bean.getGiro()!=null){
                Select giro= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_4_fila_repeaterSelect_1_field']")));
                giro.selectByValue(bean.getGiro());
                Thread.sleep(2000);
                giro= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_4_fila_repeaterSelect_1_field']")));
                giro.selectByValue(bean.getGiro());
            }

            if (bean.getActvidadEconomica()!=null){
                Select actividadComercial= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_4_fila_repeaterSelect_2_field']")));
                actividadComercial.selectByIndex(0);
                Thread.sleep(2000);
                actividadComercial= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_4_fila_repeaterSelect_2_field']")));
                actividadComercial.selectByValue(bean.getActvidadEconomica());
                Thread.sleep(2000);
                actividadComercial= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_4_fila_repeaterSelect_2_field']")));
                actividadComercial.selectByValue(bean.getActvidadEconomica());
            }

            if (bean.getSumaAsegurada()!=null){
                WebElement sumaAsegurada= driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater2_1_fila_field']"));
                sumaAsegurada.click();
                sumaAsegurada.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(150);
                sumaAsegurada.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(150);
                sumaAsegurada.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(150);
                sumaAsegurada.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(2500);
                WebElement click = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater2_2_fila_field']"));
                click.click();
                Thread.sleep(1000);
                sumaAsegurada= driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater2_1_fila_field']"));
                sumaAsegurada.sendKeys(bean.getSumaAsegurada());
                Thread.sleep(2000);
               // actividadComercial= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_2_fila_repeaterSelect_2_field']")));
                //actividadComercial.selectByValue(bean.getActvidadEconomica());
            }

            if (bean.getTipoPoliza()!=null){
                Select tipoPoliza= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_4_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                tipoPoliza.selectByValue(bean.getTipoPoliza());
                Thread.sleep(2000);
                tipoPoliza= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_4_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                tipoPoliza.selectByValue(bean.getTipoPoliza());
            }

            //Guardar
            Thread.sleep(1000);

            boolean boolTomador=driver.findElements(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']")).size()>0;
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            while (!boolTomador){
                btnGuardar.click();
                a.waitSearchWicket(driver,"Guardando");
                if (boolTomador=driver.findElements(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']")).size()>0){
                    break;
                }
            }




        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Tomador(Metodos m,WebDriver driver, Asesuisa_PolizaEmisionGeneral30282Bean bean,
                        String nombreAutomatizacion, int i, int screen1, int screen2){
        try {
            //Tomador
            System.out.println("Entre a tomador");
            //*[@id="14048736244722304-autocomplete"]/ul/li
            if (bean.getTomador1Nombre1()!=null){
                WebElement txtTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                txtTomador.click();
                Thread.sleep(500);
                txtTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                txtTomador.sendKeys(bean.getTomador1Nombre1());
                Thread.sleep(1000);
                txtTomador.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(500);
                txtTomador.sendKeys(Keys.ENTER);

                //Asociar
                WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
                btnAsociar.click();
                Thread.sleep(1500);

                //Agregar
                WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_1_addPaymentModeButton']"));
                btnAgregar.click();
                Thread.sleep(1500);

                //GuardarTomador
                WebElement bntGuardarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
                bntGuardarTomador.click();
                m.waitSearchWicket(driver,"Guardando tomador");
                System.out.println("Tomador 1 guardado");
                Thread.sleep(2000);
                 //WebElement lblTomador = driver.findElement(By.xpath("//li[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']"));
                //lblTomador.click();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Asegurado(Metodos m,WebDriver driver,Asesuisa_PolizaEmisionGeneral30282Bean bean,
                          String nombreAutomatizacion,int i,int screen1,int screen2){
        try {
            //Asegurado
            System.out.println("Entre a asegurado");
            //*[@id="14048736244722304-autocomplete"]/ul/li
            if (bean.getAsegurado1Nombre1()!=null){
                WebElement txtAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                txtAsegurado.click();
                Thread.sleep(500);
                txtAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                txtAsegurado.sendKeys(bean.getAsegurado1Nombre1());
                Thread.sleep(1000);
                txtAsegurado.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(500);
                txtAsegurado.sendKeys(Keys.ENTER);

                //Asociar
                WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AssociateButton']"));
                btnAsociar.click();
                Thread.sleep(1500);

                /*//Agregar
                WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_1_addPaymentModeButton']"));
                btnAgregar.click();
                Thread.sleep(1500);*/

                //GuardarAsegurado
                WebElement bntGuardarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
                bntGuardarAsegurado.click();
                m.waitSearchWicket(driver,"Guardando Asegurado");
                System.out.println("Asegurado 1 guardado");
                Thread.sleep(2000);
                //WebElement lblTomador = driver.findElement(By.xpath("//li[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']"));
                //lblTomador.click();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Beneficiario(Metodos m,WebDriver driver,Asesuisa_PolizaEmisionGeneral30282Bean bean,
                             String nombreAutomatizacion,int i,int screen1,int screen2){
        try {
            //Beneficiario
            System.out.println("Entre a beneficiario");
            //*[@id="14048736244722304-autocomplete"]/ul/li
            if (bean.getBeneficiario1Nombre1()!=null){
                WebElement txtBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_3_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                txtBeneficiario.click();
                Thread.sleep(500);
                txtBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_3_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                txtBeneficiario.sendKeys(bean.getBeneficiario1Nombre1());
                Thread.sleep(1000);
                txtBeneficiario.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(500);
                txtBeneficiario.sendKeys(Keys.ENTER);

                //Asociar
                WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_3_thirdRole_Tomador_thirdForm_AssociateButton']"));
                btnAsociar.click();
                Thread.sleep(1500);

                /*//Agregar
                WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_1_addPaymentModeButton']"));
                btnAgregar.click();
                Thread.sleep(1500);*/

                //GuardarBeneficiario
                Select tipo= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_3_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipo.selectByValue(bean.getTipoBeneficiario1());
                Thread.sleep(2000);
                WebElement bntGuardarBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_3_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
                bntGuardarBeneficiario.click();
                m.waitSearchWicket(driver,"Guardando Beneficiario");
                System.out.println("Beneficiario 1 guardado");
                Thread.sleep(2000);
                //WebElement lblTomador = driver.findElement(By.xpath("//li[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']"));
                //lblTomador.click();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void UnidadRiesgo(Metodos metodos,WebDriver driver,Asesuisa_PolizaEmisionGeneral30282Bean bean,
                             String nombreAutomatizacion,int i){
        try {
            //Boton nuevo
            System.out.println("Ingresando a unidades de riesgo");
            WebElement btnNuevo= driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();
            metodos.waitSearchWicket(driver,"Agregando unidad de riesgo");

            //Guardar unidad de riesgo
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();
            metodos.waitSearchWicket(driver,"Guardando unidad de riesgo");
            System.out.println("Unidad de riesgo guardada de manrea correcta");

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetosAsegurados(Metodos metodos,WebDriver driver,Asesuisa_PolizaEmisionGeneral30282Bean bean,
                                  String nombreAutomatizacion,int i){
        try {
            //Objetos asegurados
            System.out.println("Ingresando a objetos asegurados");

            if (bean.getNombrePredio()!=null){
                WebElement txtNombrePredio = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_textarea_field']"));
                txtNombrePredio.sendKeys(bean.getNombrePredio());
                Thread.sleep(1500);
            }

            if (bean.getDepartamento()!=null){
                Select dpto= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_1_fila_repeaterSelect_1_field']")));
                dpto.selectByValue(bean.getDepartamento());
                Thread.sleep(3000);
                dpto= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_1_fila_repeaterSelect_1_field']")));
                dpto.selectByValue(bean.getDepartamento());
            }

            if (bean.getMunicipio()!=null){
                Select mun= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_1_fila_repeaterSelect_2_field']")));
                mun.selectByIndex(0);
                Thread.sleep(2000);
                WebElement txtNombrePredio = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_textarea_field']"));
                txtNombrePredio.click();
                Thread.sleep(500);
                mun= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_1_fila_repeaterSelect_2_field']")));
                mun.selectByIndex(0);
                Thread.sleep(500);
                mun.selectByValue(bean.getMunicipio());
                Thread.sleep(2000);
                mun= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_1_fila_repeaterSelect_2_field']")));
                mun.selectByValue(bean.getMunicipio());
            }

            if (bean.getColonia()!=null){
                Select colonia= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                colonia.selectByVisibleText("Seleccione uno");
                Thread.sleep(500);
                WebElement txtNombrePredio = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_textarea_field']"));
                txtNombrePredio.click();
                Thread.sleep(500);
               /* colonia= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                colonia.selectByIndex(0);*/
                Thread.sleep(2000);
                colonia= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                colonia.selectByValue(bean.getColonia());
                Thread.sleep(2000);
                colonia= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                colonia.selectByValue(bean.getColonia());
            }

            if (bean.getDireccion()!=null){
                WebElement txtdireccion = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_textarea_field']"));
                txtdireccion.sendKeys(bean.getDireccion());
                Thread.sleep(1500);
                txtdireccion = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_textarea_field']"));
                txtdireccion.click();
                Thread.sleep(1000);
                txtdireccion = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_textarea_field']"));
                txtdireccion.sendKeys(Keys.TAB);
                //txtdireccion.clear();
                Thread.sleep(500);
                txtdireccion = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_textarea_field']"));
                txtdireccion.sendKeys(bean.getDireccion());
                Thread.sleep(1500);

               /* WebElement lbl = driver.findElement(By.xpath("/*//*[@id=\"campos_obligatoriosPan\"]/h1/div"));
                lbl.click();
                Thread.sleep(500);*/
                                /*WebElement txtNombrePredio = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_textarea_field']"));
                txtNombrePredio.click();
                Thread.sleep(500);*/
            }

            //boton guardar
            WebElement btnGuardar= driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();
            metodos.waitSearchWicket(driver,"Guardando objetos asegurados");
            System.out.println("Objetos guardados");

            //Chequear todos los botones
            WebElement btnChk = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RequirementsContainer_headerRecieved_recieve']"));
            btnChk.click();
            Thread.sleep(2000);
            System.out.println("Seleccionados todos los documentos");

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Pantallazo(int id, Metodos metodos, WebDriver driver, int i, String nombreAutomatizacion,
                           String folderName){
        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            switch (id){
                case 1:
                    jse.executeScript("window.scrollBy(0,-10000)", "");
                    metodos.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen9",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen10",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen11",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen12",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen13",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen14",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen15",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen16",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen17",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    jse.executeScript("window.scrollBy(0,570)", "");
                    metodos.ScreenShotPool(driver,i,"screen18",nombreAutomatizacion, folderName);
                    Thread.sleep(800);

                    break;
                case 2:
                    metodos.ScreenShotPool(driver,i,"screen19",nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    WebElement btnAplicar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
                    btnAplicar.click();
                    Thread.sleep(1000);
                    metodos.waitSearchWicket(driver,"Aplicando la configuracion para la emision de la poliza");
                    boolean avd = driver.findElements(By.className("w_windowMessage")).size()>0;
                    if (avd){
                        WebElement chk = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_ErrorDialog_content_questionForm_check']"));
                        chk.click();
                        Thread.sleep(800);

                        //boton continuar
                        WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_ErrorDialog_content_questionForm_ignoreValidationButton']"));
                        btnContinuar.click();
                        Thread.sleep(800);

                        metodos.waitSearchWicket(driver,"Emitiendo poliza");
                        metodos.ScreenShotPool(driver,i,"screen20",nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                    }
                    //Boton finalizar
                    WebElement btnFin = driver.findElement(By.xpath("//span[@wicketpath='modalWindowForm_EventSection_content_pdfForm_CloseFinalize_closeFinalize']"));
                    btnFin.click();
                    Thread.sleep(1000);

            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
