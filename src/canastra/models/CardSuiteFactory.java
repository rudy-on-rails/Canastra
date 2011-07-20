/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

/**
 *
 * @author rudy
 */
public class CardSuiteFactory {
    public static CardSuite getSuiteByValue(int suiteValue) throws UnsupportedOperationException{
        switch(suiteValue){
            case 0 : return CardSuite.Heart;
            case 1 : return CardSuite.Diamond;
            case 2 : return CardSuite.Club;
            case 3 : return CardSuite.Spade;
            default: throw new UnsupportedOperationException("No Such Card Suite " + suiteValue + " Exists!");
        }            
    }
}
