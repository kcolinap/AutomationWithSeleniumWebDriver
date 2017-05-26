package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosEditarBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by agil on 17/04/2017.
 */
public class Asesuisa_TercerosEditar {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCreacionRepetida.class);

    public String nombreAutomatizacion = "Asesuisa Terceros Editar";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosEditarBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Buscar Poliza */

            BuscarTercero(bean, a, i, folderName, 3, 4, 5, 6);
            Thread.sleep(3000);
            EditarTercero(bean, a, i, folderName, 7, 8, 9, 10, 11, 12);


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void BuscarTercero(Asesuisa_TercerosEditarBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        what: try {

            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(3000);

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            if (bean.getNitBuscar() != null) {
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                nit.sendKeys(bean.getNitBuscar());
                Thread.sleep(1000);
                otro.click();
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(500);

            //jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            btnBuscar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Buscando Tercero");
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);

            WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            seleccionTercero.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Ingresando a la edicion del Tercero");

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EditarTercero(Asesuisa_TercerosEditarBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4,
                              int numScreenShoot5, int numScreenShoot6){

        try {

            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));

            if (bean.getAseguradoAp() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getAseguradoAp());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getPrimerNombre() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                // Si es igual
                if (campo.getAttribute("value").toLowerCase().equals(bean.getPrimerNombre())) {
                    campo.clear();
                    campo.sendKeys(bean.getPrimerNombre());
                    Thread.sleep(1000);
                    otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                    otro.click();
                    Thread.sleep(1000);
                }
            }

            if (bean.getSegundoNombre() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_2_fila_field']"));
                campo.sendKeys(bean.getSegundoNombre());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getPrimerApellido() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
                campo.sendKeys(bean.getPrimerApellido());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getSegundoApellido() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
                campo.sendKeys(bean.getSegundoApellido());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getPaisOrigen() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_3_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getPaisOrigen());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getFechaNacimiento() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_fieldDate']"));
                campo.sendKeys(bean.getFechaNacimiento());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNacionalidad() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getNacionalidad());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroDUI() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_5_fila_field']"));
                campo.sendKeys(bean.getNumeroDUI());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroNIT() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));
                campo.sendKeys(bean.getNumeroNIT());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getTipoDocumentoIdentificacion() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getTipoDocumentoIdentificacion());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroDocumentoIdentificacion() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                campo.sendKeys(bean.getNumeroDocumentoIdentificacion());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getEdadPersonaNatural() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_6_fila_field']"));
                campo.sendKeys(bean.getEdadPersonaNatural());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroUnicoBanco() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                campo.sendKeys(bean.getNumeroUnicoBanco());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }
            if (bean.getNumeroNUP() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                campo.sendKeys(bean.getNumeroNUP());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getCorreoElectronicoPrincipal() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_8_fila_field']"));
                campo.sendKeys(bean.getCorreoElectronicoPrincipal());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getCorreoElectronicoOpcional() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_9_fila_field']"));
                campo.sendKeys(bean.getCorreoElectronicoOpcional());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getUsuario() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_9_fila_field']"));
                campo.sendKeys(bean.getUsuario());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getIdFacebook() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_10_fila_field']"));
                campo.sendKeys(bean.getIdFacebook());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getIdTwitter() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_10_fila_field']"));
                campo.sendKeys(bean.getIdTwitter());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getIdLinkedin() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_11_fila_field']"));
                campo.sendKeys(bean.getIdLinkedin());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getGenero() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_11_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getGenero());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroHijos() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_12_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getNumeroHijos());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getEstadoCivil() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_12_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getEstadoCivil());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }
            if (bean.getOcupacion() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_13_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getOcupacion());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNivelEstudio() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_13_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getNivelEstudio());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroTelefonoTrabajo() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_14_fila_field']"));
                campo.sendKeys(bean.getNumeroTelefonoTrabajo());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getTlfDomicilio() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_14_fila_field']"));
                campo.sendKeys(bean.getTlfDomicilio());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroCelular() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_15_fila_field']"));
                campo.sendKeys(bean.getNumeroCelular());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroRegistroContribuyente() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_15_fila_field']"));
                campo.sendKeys(bean.getNumeroRegistroContribuyente());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getCategoriaContribuyente() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_16_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getCategoriaContribuyente());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getActividadEconomica() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_16_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getActividadEconomica());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNivelSalarial() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_17_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getNivelSalarial());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getTipoEmpresa() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_17_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getTipoEmpresa());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getCategoriaEmpresa() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_18_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getCategoriaEmpresa());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getExentoIVA() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_18_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getExentoIVA());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getPredeterminedName() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_19_fila_field']"));
                campo.sendKeys(bean.getPredeterminedName());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getLogin() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_19_fila_field']"));
                campo.sendKeys(bean.getLogin());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getChequeoUnicidad() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_20_fila_field']"));
                campo.sendKeys(bean.getChequeoUnicidad());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getCodigoIdentificador() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_20_fila_field']"));
                campo.sendKeys(bean.getCodigoIdentificador());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getIdioma() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_21_fila_field']"));
                campo.sendKeys(bean.getIdioma());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getIdiomaOmision() != null){
                Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_21_fila_repeaterSelect_1_field']")));
                campo.selectByValue(bean.getIdiomaOmision());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

            if (bean.getNumeroDocumentoIdentificacion2() != null){
                WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_22_fila_field']"));
                campo.sendKeys(bean.getNumeroDocumentoIdentificacion2());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                otro.click();
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
