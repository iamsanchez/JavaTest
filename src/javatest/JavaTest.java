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
import java.util.concurrent.Semaphore;

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
        String temp2 = "C:\\Work\\output_csv.csv";
        
        Semaphore Sema = new Semaphore(1);
        System.out.println(Sema.availablePermits());
        
        Process p = new Process();
        
        DiskInputThread in = new DiskInputThread(temp,p);
        ProcessingThread Pro = new ProcessingThread(p);
        DiskOutputThread out = new DiskOutputThread(temp2,p);
        in.start();
        Pro.start();
        out.start();
        
        
        
        
    }
    
}
