/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa o baralho de cartas
 * @author rudy
 */
public class Deck extends ArrayList<Card> {

    public Deck() {
        setInitialAmountOfCards();
    }
    
    public void shuffle(){ 
        Collections.shuffle(this);
    }
        
    private void setInitialAmountOfCards(){        
        int suiteInc = 0;
        int valueInc = 0;
        for (int i = 0; i < 104; i++) {           
           if (valueInc == 13)
               valueInc = 0;
           if (this.size() > 1 && this.size() % 26 == 0)
               suiteInc += 1;                     
           CardValue currentCardValue = CardValueFactory.getCardValueByIndex(valueInc);
           CardSuite currentSuite = CardSuiteFactory.getSuiteByValue(suiteInc);                      
           this.add(new Card(currentCardValue,currentSuite));
           valueInc += 1;
        }             
        this.add(new Card(CardValue.Joker));
        this.add(new Card(CardValue.Joker));
        this.add(new Card(CardValue.Joker));
        this.add(new Card(CardValue.Joker));
    }          
}
