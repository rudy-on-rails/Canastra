/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

/**
 *
 * @author rudy
 */
public class CardValueFactory {
    public static CardValue getCardValueByIndex(int indexValue) throws UnsupportedOperationException{
        switch(indexValue){
            case 0 : return CardValue.CardA;
            case 1 : return CardValue.Card2;
            case 2 : return CardValue.Card3;
            case 3 : return CardValue.Card4;
            case 4 : return CardValue.Card5;
            case 5 : return CardValue.Card6;
            case 6 : return CardValue.Card7;
            case 7 : return CardValue.Card8;
            case 8 : return CardValue.Card9;
            case 9 : return CardValue.Card10;    
            case 10 : return CardValue.CardJ;
            case 11 : return CardValue.CardQ;
            case 12 : return CardValue.CardK;    
            default: throw new UnsupportedOperationException("No Such Card Value " + indexValue + " Exists!");
        }            
    }
}
