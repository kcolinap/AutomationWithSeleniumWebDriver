package AcseleV13_8.main.controller.PolizaEmision;

import AcseleV13_8.beans.ImpresionDocumentosNivelPolizaBean;
import AcseleV13_8.beans.PolizaBean;
import AcseleV13_8.main.controller.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 16/09/2016.
 */
public class PrePoliza {

    private final static Logger log = Logger.getLogger(PrePoliza.class);

    public void AdminPropuestaPoliza(Metodos a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot) {
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(polizaBean.getProducto()); //VidaDeudoresAvVillas
            Thread.sleep(2000);

            /*if(polizaBean instanceof ImpresionDocumentosNivelPolizaBean){
                System.out.println("Impresora : -->>" + ((ImpresionDocumentosNivelPolizaBean) polizaBean).getImpresora());
            }*/

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(polizaBean.getVigencia()); //12= Anual
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(polizaBean.getFechaDesde()); // 19-07-2016
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (polizaBean.getFechaHasta() != null) {
                fechaHas.sendKeys(polizaBean.getFechaHasta());
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
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EvAplicar(Metodos a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot){
        try {
            Thread.sleep(3000);
            Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));

            eventoAplicarSelect.selectByValue(polizaBean.getEventoAplicar()); // Emitir
            Thread.sleep(2000);

            if (polizaBean.getFechaMovimiento() != null){
                WebElement fechaMovimiento = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_1_fila_fieldDate']"));
                fechaMovimiento.sendKeys(polizaBean.getFechaMovimiento());
                Thread.sleep(1000);
            }
            if (polizaBean.getFechaEfectivaAplicacionEvento() != null){
                WebElement fechaEfecAplicEvent = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_fieldDate']"));
                fechaEfecAplicEvent.sendKeys(polizaBean.getFechaEfectivaAplicacionEvento());
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
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
