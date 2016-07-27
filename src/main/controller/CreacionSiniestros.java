package main.controller;

import beans.CreacionSiniestrosBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by aazuaje on 27/07/2016.
 */
public class CreacionSiniestros {

    private final static Logger log = Logger.getLogger(CreacionSiniestros.class);

    public String nombreAutomatizacion = "Creacion Siniestros";

    public void testLink(CreacionSiniestrosBean creacionSiniestrosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        /** Pendiente **/
    }
}
