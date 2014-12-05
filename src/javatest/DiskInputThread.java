/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javatest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class DiskInputThread extends Thread{

    private String directory = "";
    private String file ="";
    private Process Process;
    public DiskInputThread(String Path,Process Process) throws Exception{
        this.file=Path;
        this.Process=Process;
    }
    
    
    
    @Override
    public void run(){
        
        BufferedReader br = null;
	String line = "";
        try{

        br = new BufferedReader(new FileReader(file));
        while((line=br.readLine()) != null){
            String[] leido = line.split(",");
            System.out.println("Leo Primero " + leido[0] + " segundo " + leido[1]);
            Person readPerson = new Person(leido[0],Integer.parseInt(leido[1]));
            Process.toProcess(readPerson);
        }
        
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(DiskInputThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
    }
    
    
}
