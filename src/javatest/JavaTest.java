/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
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

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the directory to listen from:  ");
        String directory = in.nextLine();
        System.out.println("Enter the path of the file to write in(.csv): ");
        String outPath = in.nextLine();
        Process p = new Process();

        DiskInputThread DIT = new DiskInputThread(directory, p);
        ProcessingThread PT = new ProcessingThread(p);
        DiskOutputThread DOT = new DiskOutputThread(outPath, p);
        DIT.start();
        PT.start();
        DOT.start();

    }

}
