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
public class Dog extends Animal{

    public Dog() {
        super("Huyeen");
    }

    @Override
    public void makeSound() {
        System.out.println("GOGO");
    }

    @Override
    public void eat() {
        System.out.println("Tbone");
    }
    
    
}
