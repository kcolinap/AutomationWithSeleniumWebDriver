package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionVariosOAVidaIntegralBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_InformacionGeneralPoliza;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_PrePoliza;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_Tomador;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by agil on 21/02/2017.
 */
public class Asesuisa_PolizaEmisionVariosOAVidaIntegral {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionVariosOAVidaIntegral.class);

    public String nombreAutomatizacion = "Asesuisa Poliza Emision Varios OA Vida Integral";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionVariosOAVidaIntegralBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();
            Asesuisa_PrePoliza prePoliza = new Asesuisa_PrePoliza();
            Asesuisa_InformacionGeneralPoliza informacionGeneralPoliza = new Asesuisa_InformacionGeneralPoliza();
            Asesuisa_Tomador tomador = new Asesuisa_Tomador();

           /* Inter_InformacionGeneralPoliza interInformacionGeneralPoliza = new Inter_InformacionGeneralPoliza();
            Inter_Contratante interContratante = new Inter_Contratante();
            Inter_UnidadesRiesgo interUnidadesRiesgo = new Inter_UnidadesRiesgo();
            Inter_ObjetosAsegurados interObjetosAsegurados = new Inter_ObjetosAsegurados();
            Inter_Asegurado interAsegurado = new Inter_Asegurado();
            Inter_Beneficiario interBeneficiario = new Inter_Beneficiario();
            Inter_Calcular interCalcular = new Inter_Calcular();
            Inter_Validar interValidar = new Inter_Validar();
*/
            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            menuOperaciones.OpePol_CotizacionSuscripcionEdicionCrearFrontEnd(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Crear Poliza */

            Thread.sleep(3000);
            prePoliza.AdministracionPropuestaPoliza(a, driver, bean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, bean, nombreAutomatizacion, i, folderName, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneralVidaIntegral(a, driver, bean, nombreAutomatizacion, i, folderName, 4, 5, 6);
            Thread.sleep(2000);
            tomador.AgregarTomador(a, driver, bean, nombreAutomatizacion, i, folderName, 7, 8);
/*            if (interPolizaEmisionVariosOABean.getProducto().equals("Inteligo")) {
                interInformacionGeneralPoliza.InformacionGeneralInteligo(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 5);
                Thread.sleep(2000);
                interContratante.AgregarContratante(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 6, 7);
                Thread.sleep(2000);
                interUnidadesRiesgo.UnidadesRiesgo1(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 8);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado1_Inteligo(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 9);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado1(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 10, 11);
                Thread.sleep(2000);
                interBeneficiario.AgregarBeneficiario1(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 12, 13);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado2_Inteligo(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 14);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado2(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName,15, 16);
                Thread.sleep(2000);
                interBeneficiario.AgregarBeneficiario2(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 17, 18);
                Thread.sleep(2000);
                interCalcular.Calcular(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 19, 20);
                Thread.sleep(2000);
                interValidar.ValidarEmisionPoliza(driver, nombreAutomatizacion);
            }
            else if (interPolizaEmisionVariosOABean.getProducto().equals("DotalSimple")){
                interInformacionGeneralPoliza.InformacionGeneralDotalSimple(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 5, 6, 7);
                Thread.sleep(2000);
                interContratante.AgregarContratante(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 8, 9);
                Thread.sleep(2000);
                interUnidadesRiesgo.UnidadesRiesgo1DotalSimple(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 10);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado1_DotalSimple(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 11, 12, 13);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado1_DotalSimple(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 14);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado2_DotalSimple(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 16, 17, 18, 19);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado2_DotalSimple(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 20, 21);
                Thread.sleep(2000);
                interCalcular.Calcular(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, folderName, 22, 23);
                Thread.sleep(2000);
                interValidar.ValidarEmisionPoliza(driver, nombreAutomatizacion);
            }
*/
            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }
}
