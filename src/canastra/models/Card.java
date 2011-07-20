/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

/**
 *
 * @author rudy
 */
public class Card {
    private CardSuite cardSuite;
    private CardValue cardValue;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.cardSuite != other.cardSuite) {
            return false;
        }
        if (this.cardValue != other.cardValue) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.cardSuite != null ? this.cardSuite.hashCode() : 0);
        hash = 97 * hash + (this.cardValue != null ? this.cardValue.hashCode() : 0);
        return hash;
    }
        
    public Card(CardValue cardValue) {
        this.cardValue = cardValue;
    }
    public Card(CardValue cardValue, CardSuite cardSuite) {
        this.cardSuite = cardSuite;
        this.cardValue = cardValue;
    }

    /**
     * @return the cardSuite
     */
    public CardSuite getCardSuite() {
        return cardSuite;
    }

    /**
     * @param cardSuite the cardSuite to set
     */
    public void setCardSuite(CardSuite cardSuite) {
        this.cardSuite = cardSuite;
    }

    /**
     * @return the cardValue
     */
    public CardValue getCardValue() {
        return cardValue;
    }

    /**
     * @param cardValue the cardValue to set
     */
    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }
    
}
