package AcseleV13_8LBC.main.controller.LBC_PolizaEmision;

import AcseleV13_8LBC.beans.LBC_PolizasBean;
import AcseleV13_8LBC.main.controller.LBC_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 16/09/2016.
 */
public class LBC_PrePoliza {

    private final static Logger log = Logger.getLogger(LBC_PrePoliza.class);

    public void AdminPropuestaPoliza(LBC_Metodos a, WebDriver driver, LBC_PolizasBean lbcPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot) {
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(lbcPolizaBean.getProducto()); //VidaDeudoresAvVillas
            Thread.sleep(2000);

            /*if(polizaBean instanceof ImpresionDocumentosNivelPolizaBean){
                System.out.println("Impresora : -->>" + ((ImpresionDocumentosNivelPolizaBean) polizaBean).getImpresora());
            }*/

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(lbcPolizaBean.getVigencia()); //12= Anual
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(lbcPolizaBean.getFechaDesde()); // 19-07-2016
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (lbcPolizaBean.getFechaHasta() != null) {
                fechaHas.sendKeys(lbcPolizaBean.getFechaHasta());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Administracion Porpuesta de Poliza");
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EvAplicar(LBC_Metodos a, WebDriver driver, LBC_PolizasBean lbcPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot){
        try {
            Thread.sleep(3000);

            if (lbcPolizaBean.getEventoAplicar() != null) {
                Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));
                eventoAplicarSelect.selectByValue(lbcPolizaBean.getEventoAplicar()); // Emitir
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getFechaMovimiento() != null){
                WebElement fechaMovimiento = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_1_fila_fieldDate']"));
                fechaMovimiento.sendKeys(lbcPolizaBean.getFechaMovimiento());
                Thread.sleep(1000);
            }
            if (lbcPolizaBean.getDiasApmpliacion() != null){
                WebElement diasApmpliacion = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_fieldDate']"));
                diasApmpliacion.sendKeys(lbcPolizaBean.getDiasApmpliacion());
                Thread.sleep(1000);
            }


            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Evento a Aplicar");
            }

        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
