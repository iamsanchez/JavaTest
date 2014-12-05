/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javatest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Process {
    private boolean state = false;
    Person Person = new Person("hoas",11);
    
    public synchronized void toProcess(Person readPerson){
        while(state ==true){
            try {
                System.out.println("Hola");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.Person= readPerson;   
        System.out.println("Cambie de estado");
        state =true;
        notifyAll();
    }
    
    public synchronized Person toWrite(){
     
        
        
        
        return Person;
    }
    
    public synchronized Person toRead(){
        while(state == false){
            try{
                System.out.println("A ESCRIBIR " + Person.toString());
                wait();
            }catch(InterruptedException ex){
                 Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("algo en to read");
        state =false;
        notifyAll();
        return Person;
    }

    public Person getPerson() {
        return Person;
    }

    
    
    
}
