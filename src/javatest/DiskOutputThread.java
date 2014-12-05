/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class DiskOutputThread extends Thread {

    Process Process;
    String Path;

    public DiskOutputThread(String Path, Process Process) {
        this.Process = Process;
        this.Path = Path;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Process.segundo.acquire();
                System.out.println("Sigo en 3");
            } catch (InterruptedException ex) {
                Logger.getLogger(DiskOutputThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            PrintWriter printer = null;
            try {
                printer = new PrintWriter(new BufferedWriter(new FileWriter(Path, true)));
                System.out.println(Process.getPerson().getName() + "," + Process.getPerson().getAge() + "," + Process.getPerson().getAgeBand());
                printer.println(Process.getPerson().getName() + "," + Process.getPerson().getAge() + "," + Process.getPerson().getAgeBand());

            } catch (IOException ex) {
                Logger.getLogger(DiskOutputThread.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                printer.close();
            }

            Process.toRead();
        }
    }
}
