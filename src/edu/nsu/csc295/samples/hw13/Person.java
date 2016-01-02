/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nsu.csc295.samples.hw13;

/**
 *
 * @author thomaskofiannan1
 */
class Person {
int age;
String name;

    public Person( String name,int age) {
        this.age = age;
        this.name = name;
    }

  

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
