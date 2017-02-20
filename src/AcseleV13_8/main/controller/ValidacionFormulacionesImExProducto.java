package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ValidacionFormulacionesImExProductoBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import AcseleV13_8.main.controller.PolizaEmision.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 22/08/2016.
 */
public class ValidacionFormulacionesImExProducto {

    private final static Logger log = Logger.getLogger(ValidacionFormulacionesImExProducto.class);

    public static String nombreAutomatizacion = "Validacion de formulaciones Inport Export Producto";

    public void testLink(ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean, int i) throws IOException, InterruptedException {

        try {
            //implementando clases
            Metodos13_8 a = new Metodos13_8();

            MenuConfiguracion menuConfiguracion = new MenuConfiguracion();
            MenuOperaciones menuOperaciones = new MenuOperaciones();

            //PrePoliza
            PrePoliza prePoliza = new PrePoliza();
            InformacionGeneralPoliza informacionGeneralPoliza = new InformacionGeneralPoliza();
            TerceroTomador terceroTomador = new TerceroTomador();
            UnidadesRiesgo unidadesRiesgo = new UnidadesRiesgo();
            ObjetoAsegurado objetoAsegurado = new ObjetoAsegurado();
            AseguradoVida aseguradoVida = new AseguradoVida();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Ingreso al menu
            menuConfiguracion.MantenimientoProducto(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            IngresarProductTool(a, driver, validacionFormulacionesImExProductoBean, i, 3, 4, 5, 6, 7);
            Thread.sleep(1000);
            //ImportTablaDinamica(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            driver.close();

            a.regresarVentana(driver);

            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 7, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            // PrePoliza
            Thread.sleep(2000);
            prePoliza.AdminPropuestaPoliza(a, driver, validacionFormulacionesImExProductoBean, nombreAutomatizacion, i, 8);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, validacionFormulacionesImExProductoBean, nombreAutomatizacion, i, 9);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneral(a, driver, validacionFormulacionesImExProductoBean, nombreAutomatizacion, i, 10);
            Thread.sleep(2000);
            terceroTomador.TomadorTercero(a, driver, validacionFormulacionesImExProductoBean, nombreAutomatizacion, i, 11, 12);
            //Thread.sleep(2000);
            unidadesRiesgo.UnidadesRiesgo(a, driver, validacionFormulacionesImExProductoBean, nombreAutomatizacion, i, 13, 14);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAsegurado(a, driver, validacionFormulacionesImExProductoBean, nombreAutomatizacion, i, 15);
            Thread.sleep(2000);
            aseguradoVida.AseguradoVida(a, driver, validacionFormulacionesImExProductoBean, nombreAutomatizacion, i, 16);
            Thread.sleep(2000);
            IngresarCobertura(a, driver, validacionFormulacionesImExProductoBean, i, 17, 18);
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void IngresarProductTool(Metodos13_8 a, WebDriver driver, ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean, int i,
                                    int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            Thread.sleep(7000);
            WebElement seleccionProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li/div/a/span"));
            seleccionProducto.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement pestanaProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span"));
            pestanaProducto.click();

            Thread.sleep(2000);
            WebElement expandirCarpetaProducto1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/div/img[1]"));
            expandirCarpetaProducto1.click();

            Thread.sleep(2000);
            WebElement expandirCarpetaProducto2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/div/img[1]"));
            expandirCarpetaProducto2.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaPlanes = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/div/img[1]"));
            expandirCarpetaPlanes.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaPlVDeudoresVillas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/div/img[1]"));
            expandirCarpetaPlVDeudoresVillas.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaObjetosAsegurados = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/div/img[1]"));
            expandirCarpetaObjetosAsegurados.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaOaVDeudoresVillas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/div/img[1]"));
            expandirCarpetaOaVDeudoresVillas.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaCoberturas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/div/img[1]"));
            expandirCarpetaCoberturas.click();

            Thread.sleep(1000);
            WebElement seleccionarDesaparicionForzada = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/ul/li[1]/div/a/span"));
            seleccionarDesaparicionForzada.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            //WebElement btnEditar = driver.findElement(By.xpath(""));
            WebElement btnEditar = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/div/div/div/div/table/tbody/tr[4]/td/div/div/div/img"));
            btnEditar.click();

            Thread.sleep(3000);

            Thread.sleep(1000);
            WebElement seleccionFormula = driver.findElement(By.xpath("//div[18]/table/tbody/tr/td[4]/div"));
            seleccionFormula.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnEditarFormula = driver.findElement(By.xpath("//td[2]/table/tbody/tr/td[2]/em/button"));
            btnEditarFormula.click();

            Thread.sleep(4000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            //WebElement campoFormula = driver.findElement(By.xpath("//div[24]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/form/table/tbody[2]/tr[2]/td/textarea"));
            WebElement campoFormula = driver.findElement(By.xpath("//*[@id=\"isc_3R\"]"));
            campoFormula.clear();
            campoFormula.sendKeys(validacionFormulacionesImExProductoBean.getFormula());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            //WebElement btnAceptar = driver.findElement(By.xpath("//div[20]/div/div[2]/div/div/div/div[2]/div/div/div/table/tbody/tr/td"));
            WebElement btnAceptar = driver.findElement(Sc.locator("scLocator=//IButton[ID=\"isc_OID_77\"]/"));
            btnAceptar.click();

            WebElement btnCancelar = driver.findElement(Sc.locator("scLocator=//IButton[ID=\"isc_OID_78\"]/"));
            btnCancelar.click();

            Thread.sleep(2000);

            WebElement btnSalvar = driver.findElement(By.xpath("//div[3]/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button"));
            btnSalvar.click();





        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void IngresarCobertura(Metodos13_8 a, WebDriver driver, ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean, int i, int numScreenShoot, int numScreenShoot2){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();

            /***Espera***/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Calcular");
            }

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnCerrar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_CloseSummary']"));
            btnCerrar.click();

            /***Espera***/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Cerrar");
            }

            WebElement secuestroExtorsivo = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_Coverage_contentForm_CoverageContent_sorting_1_coverageItem_link_nameCoverage']"));
            WebElement desaparicionForzada = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_Coverage_contentForm_CoverageContent_sorting_2_coverageItem_link_nameCoverage']"));
            WebElement muerte = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_Coverage_contentForm_CoverageContent_sorting_3_coverageItem_link_nameCoverage']"));
            WebElement incapacidadTotalPermanente = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_Coverage_contentForm_CoverageContent_sorting_4_coverageItem_link_nameCoverage']"));

            if (secuestroExtorsivo.getText().equals("DESAPARICION FORZADA")){

                secuestroExtorsivo.click();
                ValidarFormula(a, driver, validacionFormulacionesImExProductoBean, i, numScreenShoot2);
            }
            else if (desaparicionForzada.getText().equals("DESAPARICION FORZADA")){

                desaparicionForzada.click();
                ValidarFormula(a, driver, validacionFormulacionesImExProductoBean, i, numScreenShoot2);
            }
            else if (muerte.getText().equals("DESAPARICION FORZADA")){

                muerte.click();
                ValidarFormula(a, driver, validacionFormulacionesImExProductoBean, i, numScreenShoot2);
            }
            else if (incapacidadTotalPermanente.getText().equals("DESAPARICION FORZADA")){

                incapacidadTotalPermanente.click();
                ValidarFormula(a, driver, validacionFormulacionesImExProductoBean, i, numScreenShoot2);
            }

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ValidarFormula (Metodos13_8 a, WebDriver driver, ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean, int i, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(3000);

            WebElement sumaAseguradaTotal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_Coverage_editCoveragePanel_BasicInformationCoverage_registerForm_templateCoverage_repeaterPanel1_5_fila_field']"));
            double montoAsegurado = Double.parseDouble(validacionFormulacionesImExProductoBean.getMontoAsegurado()); //Double.parseDouble(sumaAseguradaTotal.getText())

            double montoAseguradoVida;

            if (validacionFormulacionesImExProductoBean.getPorcentajeParticipacionAseguradoVida() != null) {
                montoAseguradoVida = Double.parseDouble(validacionFormulacionesImExProductoBean.getPorcentajeParticipacionAseguradoVida()) / 100;
            }
            else{
                montoAseguradoVida = 1;
            }

            //String sumAseg = sumaAseguradaTotal.getText();
            double formula = montoAsegurado * montoAseguradoVida;
            String texto = sumaAseguradaTotal.getAttribute("value");
            System.out.println("Texto: " + texto);
            String textoFormateado = texto.replaceAll(",","");
            System.out.println("Texto formateado: " + textoFormateado);
            double sumaAseguradaTotalNum = Double.parseDouble(textoFormateado);

            System.out.println("Valor de la Formula:              " + formula);
            System.out.println("Valor de la Suma Asegurada Total: " + sumaAseguradaTotalNum);

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();


            if (formula == sumaAseguradaTotalNum){
                System.out.println("Son iguales. Prueba Exitosa!");
                log.info("Test Case - " + nombreAutomatizacion + " - Son iguales. Prueba Exitosa!");
            }
            else if (formula != sumaAseguradaTotalNum){
                System.out.println("Son diferentes. Prueba Fallida!");
                log.info("Test Case - " + nombreAutomatizacion + " - Son diferentes. Prueba Fallida!");
            }

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

        String Str = new String("Welcome to Tutorialspoint.com");

        System.out.print("Return Value :" );
        System.out.println(Str.replaceAll("(.*)Tutorials(.*)", "AMROOD"));
    }
}
