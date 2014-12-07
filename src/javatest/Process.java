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
    Semaphore first = new Semaphore(0, true);
    Semaphore second = new Semaphore(0, true);
    Semaphore third = new Semaphore(0, true);

    public synchronized void toProcess() {
        first.release();
    }

    public synchronized void toWrite() {
        second.release();
    }

    public synchronized void toRead() {
        third.release();
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person P) {
        this.Person = P;
    }

}
