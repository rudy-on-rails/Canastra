/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

/**
 *
 * @author rudy
 */
public enum CardSuite {
    Heart(0),
    Diamond(1),
    Club(2),
    Spade(3);
    
    private int suiteValue;
    private CardSuite(int internalValue){
        suiteValue = internalValue;
    }       
}
