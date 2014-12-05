/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javatest;

/**
 *
 * @author samuel
 */
public class ProcessingThread extends Thread{

    private Process Process;
    
    public ProcessingThread(Process Process) {
    this.Process = Process;
    }
    
    @Override
    public void run(){
        while(true){
            Person P = Process.toRead();
            System.out.println("entre a Procesar");
            if(P.getAge()<=17){
                
            }
            if(P.getAge()>=18 && P.getAge()<=24){
                P.setAgeBand("18-30");
            }
            if(P.getAge()>=25 && P.getAge()<=30){
                P.setAgeBand("25-30");
            }
            if(P.getAge()>=31 && P.getAge()<=40){
                P.setAgeBand("31-40");
            }
            if(P.getAge()>=41 && P.getAge()<=55){
                P.setAgeBand("41-55");
            }
            if(P.getAge()>=56 && P.getAge()<=70){
                P.setAgeBand("56-70");
            }
            if(P.getAge()>=71){
                P.setAgeBand("71+");
            }
            
        }
    }
}
