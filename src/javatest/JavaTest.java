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

/**
 *
 * @author samuel
 */
public class JavaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        
        String temp = "C:\\Work\\input_csv.csv";
        
        Process p = new Process();
        DiskInputThread DI = new DiskInputThread(temp,p);
        ProcessingThread Pro = new ProcessingThread(p);
        DI.start();
        Pro.start();
        
        
    
    }
    
}
