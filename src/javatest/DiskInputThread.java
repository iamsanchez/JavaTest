/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class DiskInputThread extends Thread {

    private String directory = "";
    private String file = "";
    private Process Process;

    public DiskInputThread(String Path, Process Process) throws Exception {
        this.directory = Path;
        this.Process = Process;
    }

    @Override
    public void run() {

        HashSet<String> tempSet = new HashSet<>();
        File archivo = new File(directory);
        while (true) {

            File[] files = archivo.listFiles();
            System.out.println("Contiene ???? " + tempSet.contains(files[0].toString()));
            for (int i = 0; i < files.length; i++) {
                System.out.println("voy pr " + i);
                if (!(tempSet.contains(files[i].toString()))) {
                    tempSet.add(files[i].toString());
                    BufferedReader br = null;
                    String line = "";
                    try {
                        Process.tercero.release();
                        br = new BufferedReader(new FileReader(files[i].getPath()));
                        while ((line = br.readLine()) != null) {
                            Process.tercero.acquire();
                            String[] leido = line.split(",");
                            System.out.println("Leo Primero " + leido[0] + " segundo " + leido[1]);
                            Person readPerson = new Person(leido[0], Integer.parseInt(leido[1]));
                            Process.setPerson(readPerson);
                            Process.toProcess();
                        }
                        System.out.println("cuantos" + Process.tercero.availablePermits());
                        Process.tercero.acquire();
                        System.out.println("cuantos" + Process.tercero.availablePermits());

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException ex) {
                        Logger.getLogger(DiskInputThread.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("waht");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DiskInputThread.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("aja");
                    }
                }
                System.out.println("Fin iteracion 1 del for");
                System.out.println("for = " + files.length);
            }

            // Hace la magia de la navidad
            System.out.println("Alguna vez Salgo????????????");
        //termina la magia de la navidad

        } //end while true

    }

}
