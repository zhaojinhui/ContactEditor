/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacteditor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.contacteditor.ContactEditorUI;

/**
 *
 * @author Jinhui Zhao
 */
public class ContactEditor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ContactEditorUI con = new ContactEditorUI();
        ContactEditorUI.main(args);
        Runtime.getRuntime().addShutdownHook(
            new Thread() {            
                public void run() {                
                    try {
                        Runtime.getRuntime().exec("Taskkill /IM python.exe /F");
                        System.out.println("i am running");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Shutdown Hook is running !");           
            }       
        });        
    }
}
