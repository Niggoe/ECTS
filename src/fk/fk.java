/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fk;

import datenverarbeitung.dv;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Niko
 */
public class fk {

    private dv dv;
    private HashMap<String, ArrayList<String>> fachrichtungen = new HashMap<String, ArrayList<String>>();

    

    public fk(dv dv){
        this.dv = dv;
    }

    public void setVorlesungen(String studiengang, ArrayList<String> bereiche){
        
        this.fachrichtungen.put(studiengang, bereiche);

        System.out.println(this.fachrichtungen);

    }


    public HashMap<String, ArrayList<String>> getMap(){
        return fachrichtungen;
    }

}
