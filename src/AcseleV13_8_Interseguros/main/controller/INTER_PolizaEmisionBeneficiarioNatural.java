package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_PolizaEmisionBeneficiarioNaturalBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.*;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by aazuaje on 02/12/2016.
 */
public class INTER_PolizaEmisionBeneficiarioNatural {

    private final static Logger log = Logger.getLogger(INTER_PolizaEmisionBeneficiarioNatural.class);

    public String nombreAutomatizacion = "INTER Poliza Emision Beneficiario Natural";
    private WebDriver driver;

    public void testLink(INTER_PolizaEmisionBeneficiarioNaturalBean inter_polizaEmisionBeneficiarioNaturalBean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones intersegurosMenuOperaciones = new Interseguros_MenuOperaciones();
            Inter_PrePoliza interPrePoliza = new Inter_PrePoliza();
            Inter_InformacionGeneralPoliza interInformacionGeneralPoliza = new Inter_InformacionGeneralPoliza();
            Inter_Contratante interContratante = new Inter_Contratante();
            Inter_UnidadesRiesgo interUnidadesRiesgo = new Inter_UnidadesRiesgo();
            Inter_ObjetosAsegurados interObjetosAsegurados = new Inter_ObjetosAsegurados();
            Inter_Asegurado interAsegurado = new Inter_Asegurado();
            Inter_Beneficiario interBeneficiario = new Inter_Beneficiario();
            Inter_Calcular interCalcular = new Inter_Calcular();
            Inter_Validar interValidar = new Inter_Validar();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            intersegurosMenuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Crear Poliza */

            Thread.sleep(3000);
            interPrePoliza.AdministracionPropuestaPoliza(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(2000);
            interPrePoliza.EvAplicar(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 4);
            Thread.sleep(2000);
            if (inter_polizaEmisionBeneficiarioNaturalBean.getProducto().equals("Inteligo")) {
                interInformacionGeneralPoliza.InformacionGeneralInteligo(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 5);
                Thread.sleep(2000);
                interContratante.AgregarContratante(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 6, 7);
                Thread.sleep(2000);
                interUnidadesRiesgo.UnidadesRiesgo1(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 8);
                Thread.sleep(2000);
                interObjetosAsegurados.ObjetoAsegurado1_Inteligo(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 9);
                Thread.sleep(2000);
                interAsegurado.AgregarAsegurado1(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 10, 11);
                Thread.sleep(2000);
                interBeneficiario.AgregarBeneficiario1(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 12, 13);
                Thread.sleep(2000);
                //interObjetosAsegurados.ObjetoAsegurado2_Inteligo(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, 14);
                //Thread.sleep(2000);
                interAsegurado.AgregarAsegurado2(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 15, 16);
                Thread.sleep(2000);
                interBeneficiario.AgregarBeneficiario2(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 17, 18);
                Thread.sleep(2000);
                interCalcular.Calcular(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 19, 20);
                Thread.sleep(2000);
                interValidar.ValidarEmisionPoliza(driver, nombreAutomatizacion);
            }
            else if (inter_polizaEmisionBeneficiarioNaturalBean.getProducto().equals("Inteligo")){
                interInformacionGeneralPoliza.InformacionGeneralDotalSimple(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 5, 6, 7);
                Thread.sleep(2000);
                interContratante.AgregarContratante(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 8, 9);
                Thread.sleep(2000);
                interUnidadesRiesgo.UnidadesRiesgo1DotalSimple(a, driver, inter_polizaEmisionBeneficiarioNaturalBean, nombreAutomatizacion, i, folderName, 10);
                Thread.sleep(2000);
                //interObjetosAsegurados.ObjetoAsegurado1_DotalSimple(a, driver, interPolizaEmisionVariosOABean, nombreAutomatizacion, i, 9);
            }

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

}
