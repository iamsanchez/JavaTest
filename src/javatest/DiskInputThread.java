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

        HashSet<String> Registry = new HashSet<>();
        File archivo = new File(directory);
        while (true) {

            File[] files = archivo.listFiles();

            for (int i = 0; i < files.length; i++) {
                if (!(Registry.contains(files[i].toString()))) { //If it encounters a new file, it process it
                    Registry.add(files[i].toString());
                    BufferedReader br = null;
                    String line = "";
                    try {
                        Process.third.release();
                        br = new BufferedReader(new FileReader(files[i].getPath()));
                        while ((line = br.readLine()) != null) { //Begins reading a file
                            Process.third.acquire();
                            String[] read = line.split(",");
                            Person readPerson = new Person(read[0], Integer.parseInt(read[1]));
                            Process.setPerson(readPerson);
                            Process.toProcess();
                        } //finishes a file

                        Process.third.acquire();

                    } catch (FileNotFoundException e) {
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(DiskInputThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        } //end while true

    }

}
