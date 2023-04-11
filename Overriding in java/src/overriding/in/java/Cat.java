/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overriding.in.java;

/**
 *
 * @author thien
 */
public class Cat extends Animal{

    public Cat() {
        super("Thien");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void eat() {
        System.out.println("Fish");
    }
    
    
}
