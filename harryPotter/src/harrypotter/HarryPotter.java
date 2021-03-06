/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrypotter;

import byui.cit260.harryPotter.model.Character;
import byui.cit260.harryPotter.model.CharacterScene;
import byui.cit260.harryPotter.model.Game;
import byui.cit260.harryPotter.model.HousePoints;
import byui.cit260.harryPotter.model.Inventory;
import byui.cit260.harryPotter.model.Location;
import byui.cit260.harryPotter.model.Map;
import byui.cit260.harryPotter.model.Player;
import byui.cit260.harryPotter.model.Potions;
import byui.cit260.harryPotter.model.Quidditch;
import byui.cit260.harryPotter.model.ResourceTypeScene;
import byui.cit260.harryPotter.model.Scene;
import byui.cit260.harryPotter.model.Spells;
import byui.cit260.harryPotter.view.ErrorView;
import byui.cit260.harryPotter.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cami
 */
public class HarryPotter {
    private static Game currentGame = null;
    private static Player player = null;
        
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // create StartProgramViewOrg and display start program view
       
       try {
           
           //open character stream files for end user input and output
           HarryPotter.inFile = 
                   new BufferedReader(new InputStreamReader(System.in));
           HarryPotter.outFile =
                   new PrintWriter(System.out, true);
           //open log file
           String filePath = "log.txt";
           HarryPotter.logFile = new PrintWriter(filePath);
           
           StartProgramView startProgramView = new StartProgramView();
           startProgramView.displayStartProgramView(); 
           return;
       } catch (Throwable te) {
           ErrorView.display(HarryPotter.class.getName(), "Exception: " + te.toString()+
                               "\nCause: " + te.getCause()+
                               "\nMessage:" + te.getMessage());
           
           te.printStackTrace();;
         
       }
       
       finally{
           try {
              if (HarryPotter.inFile !=null)
                      HarryPotter.inFile.close();
              if (HarryPotter.outFile !=null)
               HarryPotter.outFile.close();
              
              if (HarryPotter.logFile !=null)
                  HarryPotter.logFile.close();
           } catch (IOException ex) {
                ErrorView.display(HarryPotter.class.getName(),"Error closing files");
              return;
           }
           
           
       }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        HarryPotter.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        HarryPotter.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        HarryPotter.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        HarryPotter.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        HarryPotter.logFile = logFile;
    }
    
}
