/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventario;

import exception.InvalidPersonaDataException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import services.PersonaService;

/**
 *
 * @author sofia
 */
public class Inventario {

    public static void main(String[] args) throws SQLException {
        
        PersonaService ps = new PersonaService();
        
        try {
            ps.createPersona(0, "1", "1", 20, "admin@admin", "Admin", "1");
            JOptionPane.showConfirmDialog(null, "yes");
        } catch (InvalidPersonaDataException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
    }
}
