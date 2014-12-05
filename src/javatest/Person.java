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
public class Person {
  
    
    
    private String Name;
    private String AgeBand;
    private int Age;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" + "Name=" + Name + ", Age=" + Age + ", Ageband= " + AgeBand + "}";
    }

    
    
    public Person(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
    }

    
    
    public int getAge() {
        return Age;
    }

   
    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getAgeBand() {
        return AgeBand;
    }

   
    public void setAgeBand(String AgeBand) {
        this.AgeBand = AgeBand;
    }

    
    public String getName() {
        return Name;
    }

   
    public void setName(String Name) {
        this.Name = Name;
    }

}
