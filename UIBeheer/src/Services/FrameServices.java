/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.swing.JFrame;
import uibeheer.*;

/**
 *
 * @author Ikke
 */
public class FrameServices {
    
    public static void GoToStart(JFrame frame)
    {        
        StartFrame s = new StartFrame();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
        frame.dispose();
    }
    
    public static void GoTo(String s,JFrame frame)
    {
        JFrame f = null;
        if(s.equalsIgnoreCase("Film toevoegen")){
        f = new AddFilmFrame();
        }
        if(s.equalsIgnoreCase("Genre toevoegen")){
        f = new AddGenreFrame();
        }
        if(s.equalsIgnoreCase("Acteur/Actrice toevoegen")){
        f = new AddActeurFrame();
        }
        if(s.equalsIgnoreCase("Film verwijderen")){
        f = new DeleteFilmFrame();
        }        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        frame.dispose();
        
    }
    
}
