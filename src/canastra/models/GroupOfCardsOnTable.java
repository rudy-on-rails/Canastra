/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

import java.util.Collection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author rudy
 */
public class GroupOfCardsOnTable extends GroupOfCards {

    @Override
    public boolean add(Card e) throws IllegalArgumentException{
        if (e.getCardValue() != CardValue.Card2 &&
            e.getCardValue() != CardValue.Joker &&
            this.isThereADifferentSuiteThan(e.getCardSuite()))
            return false;
        return super.add(e);
    }

    @Override
    public void add(int index, Card element) {        
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(Collection<? extends Card> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends Card> c) {
        throw new NotImplementedException();
    }

    @Override
    public int getTotalCardsValue() {
        int cardsValue = 0;        
        cardsValue += (this.isASingleCanastra()) ? 100 : 0; 
        cardsValue += (this.isARealCanastra()) ? 200 : 0; 
        cardsValue += super.getTotalCardsValue();
        return cardsValue;
    }        

    public boolean isASingleCanastra() {
        return this.size() >= 7 && (!this.doesNotIncludeJoker() || !this.thereIsNoTwoOrItIsOfSameSuite());
    }

    public boolean isARealCanastra() {
        return this.size() >= 7 && this.doesNotIncludeJoker() && this.thereIsNoTwoOrItIsOfSameSuite();
    }

    private boolean doesNotIncludeJoker() {
        return !this.contains(new Card(CardValue.Joker));
    }

    private boolean thereIsNoTwoOrItIsOfSameSuite() {
        return (!this.contains(new Card(CardValue.Card2, CardSuite.Club)) &&
                !this.contains(new Card(CardValue.Card2, CardSuite.Diamond)) &&
                !this.contains(new Card(CardValue.Card2, CardSuite.Heart)) &&
                !this.contains(new Card(CardValue.Card2, CardSuite.Spade))) ||
                this.allCardsAreSameSuite();
    }

    private boolean allCardsAreSameSuite() {        
        for (int i = 0; i < this.size() - 1; i++) {            
            if (this.get(i).getCardSuite() != this.get(i + 1).getCardSuite())
                return false;
        }
        return true;
    }

    private boolean isThereADifferentSuiteThan(CardSuite cardSuite) {
        for (int i = 0; i < this.size(); i++) {            
            if (this.get(i).getCardSuite() != cardSuite)
                return true;
        }
        return false;
    }
       
}
