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
public class DiskOutputThread extends Thread{
    Process P;

    public DiskOutputThread(Process P) {
        this.P = P;
    }
    
    @Override
    public void run(){
        while(true){
            System.out.println("EN OUTPUT" + P.getPerson());
        }
    } 
}
