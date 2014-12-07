/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javatest;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Process {
    private int state = 0;
    Person Person;
    Semaphore primero = new Semaphore(0,true);
    Semaphore segundo = new Semaphore(0,true);
    Semaphore tercero = new Semaphore(0,true);
    
    public synchronized void toProcess(){
     primero.release();
    }
    
    public synchronized void toWrite(){
     segundo.release();
    }
    
    public synchronized void toRead(){
     tercero.release();
    }
    
   /* public synchronized void toProcess(Person readPerson){
        while(state ==1){
            try {
                System.out.println("Hola");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.Person= readPerson;   
        System.out.println("Cambie de estado");
        state =1;
        notifyAll();
    }
    
    public synchronized Person toWrite(){
        
        
        
        
        return Person;
    }
    
    public synchronized Person toRead(){
        while(state == 0){
            try{
                System.out.println("A ESCRIBIR " + Person.toString());
                wait();
            }catch(InterruptedException ex){
                 Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("algo en to read");
        state =0;
        notifyAll();
        return Person;
    }

    
    */
    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person P){
        this.Person= P;
    }
    
    
    
}
