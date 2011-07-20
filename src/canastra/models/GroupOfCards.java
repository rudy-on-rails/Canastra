/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

import java.util.ArrayList;

/**
 *
 * @author rudy
 */
public class GroupOfCards extends ArrayList<Card> {
    public int getTotalCardsValue(){        
        int totalValue = 0;
        for (int i = 0; i < this.size(); i++) {
            totalValue += this.get(i).getCardValue().getBuracoValue();
        }
        return totalValue;
    }
}
