/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package starter;

import datenverarbeitung.dv;
import fk.fk;
import gui.MainView;

/**
 *
 * @author Niko
 */
public class Start_app {

    public static void main (String[] args){
        datenverarbeitung.dv dv = new dv();
        fk fk = new fk(dv);
        gui.MainView view = new MainView(fk);
        
    }


}
