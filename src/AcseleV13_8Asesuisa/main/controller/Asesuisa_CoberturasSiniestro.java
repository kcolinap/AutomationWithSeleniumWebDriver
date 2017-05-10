package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CoberturasSiniestroBean;


import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

/**
 * Created by kcolina on 05/05/2017.
 */
public class Asesuisa_CoberturasSiniestro extends As{

    public void testLink(){

        String cadena = "elemento1 elemento2 elemento3";

        String linea = "0.00 y 700.00", aux="";
        StringTokenizer tokens = new StringTokenizer(linea);
        float nro;
        /*tokens.countTokens();
        while(tokens.hasMoreTokens()){
            System.out.println(tokens.nextToken());
            tokens..countTokens();
        }*/

        for (int i=0; i<3; i++){

            if (i==2){
                aux=tokens.nextToken();
                break;
            }
            tokens.nextToken();
        }
        System.out.println(aux);

        nro=Float.valueOf(aux);
        nro+=1000;
        System.out.println(nro);
    }
}
