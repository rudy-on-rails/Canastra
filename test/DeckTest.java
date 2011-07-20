/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import canastra.models.Card;
import canastra.models.CardSuite;
import canastra.models.CardValue;
import canastra.models.Deck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
/**
 *
 * @author rudy
 */
public class DeckTest {
    private Deck deck;
    private ArrayList<Card> AllCards;
    private HashMap<Card,Integer> CardCount;
    public DeckTest() {
        deck = new Deck();
        CardCount = new HashMap<Card, Integer>();
    }
    
    @Before
    public void setUp() {
        AllCards = new ArrayList<Card>();
        /* Hearts Cards */
        AllCards.add(new Card(CardValue.CardA, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card2, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card3, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card4, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card5, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card6, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card7, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card8, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card9, CardSuite.Heart));
        AllCards.add(new Card(CardValue.Card10, CardSuite.Heart));
        AllCards.add(new Card(CardValue.CardJ, CardSuite.Heart));
        AllCards.add(new Card(CardValue.CardQ, CardSuite.Heart));
        AllCards.add(new Card(CardValue.CardK, CardSuite.Heart));
        
        /* Spades Cards */        
        AllCards.add(new Card(CardValue.CardA, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card2, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card3, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card4, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card5, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card6, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card7, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card8, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card9, CardSuite.Spade));
        AllCards.add(new Card(CardValue.Card10, CardSuite.Spade));
        AllCards.add(new Card(CardValue.CardJ, CardSuite.Spade));
        AllCards.add(new Card(CardValue.CardQ, CardSuite.Spade));
        AllCards.add(new Card(CardValue.CardK, CardSuite.Spade));
        
        /* Clubs Cards */
        AllCards.add(new Card(CardValue.CardA, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card2, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card3, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card4, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card5, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card6, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card7, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card8, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card9, CardSuite.Club));
        AllCards.add(new Card(CardValue.Card10, CardSuite.Club));
        AllCards.add(new Card(CardValue.CardJ, CardSuite.Club));
        AllCards.add(new Card(CardValue.CardQ, CardSuite.Club));
        AllCards.add(new Card(CardValue.CardK, CardSuite.Club));
        
        /* Diamonds Cards */
        AllCards.add(new Card(CardValue.CardA, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card2, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card3, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card4, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card5, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card6, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card7, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card8, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card9, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.Card10, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.CardJ, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.CardQ, CardSuite.Diamond));
        AllCards.add(new Card(CardValue.CardK, CardSuite.Diamond));                
    }
    
    @Test
    public void EachDeckShouldBeInitializedWith108Cards(){
        assertEquals(108, deck.size());
    }
    
    @Test
    public void EachDeckShouldContainCompleteSuitesForEachValue(){        
        for (int i = 0; i < AllCards.size(); i++) {
            assertTrue("Deck does not contains " + GetFormattedCardString(AllCards.get(i)), deck.contains(AllCards.get(i)));            
        }
    }
    
    @Test
    public void EachDeckShouldCointain4Jokers(){
        int count = 0;
        for (int i = 0; i < deck.size(); i++) {     
            if (deck.get(i).equals(new Card(CardValue.Card10.Joker)))
                count += 1;
        }
        assertEquals(4, count);
    }
    @Test
    public void EachDeckShouldContaintTwoCardsOfEachType(){
        for (int i = 0; i < deck.size(); i++) {  
            if (!deck.get(i).equals(new Card(CardValue.Card10.Joker)))
            {
                if (CardCount.containsKey(deck.get(i))){                
                    CardCount.put(deck.get(i), CardCount.get(deck.get(i)) + 1);               
                }
                else
                    CardCount.put(deck.get(i), 1);
            }
        }        
        Iterator it = CardCount.keySet().iterator();        
        while (it.hasNext()) {
            Card key = (Card)it.next();
            int cardAmt = (int)CardCount.get(key);            
            assertEquals(2, cardAmt);
        }                
    }
    
    @Test
    public void DeckCanBeShuffled(){
        int value_1_to_20_before_shuffling = 0;
        int value_1_to_20_after_shuffling = 0;
        for (int i = 0; i < 20; i++) {
            if (deck.get(i) != null)
                value_1_to_20_before_shuffling += deck.get(i).getCardValue().getBuracoValue();
        }                
        deck.shuffle();
        for (int i = 0; i < 20; i++) {
            if (deck.get(i) != null)
                value_1_to_20_after_shuffling += deck.get(i).getCardValue().getBuracoValue();
        }
        
        assertNotSame(value_1_to_20_after_shuffling, value_1_to_20_before_shuffling);
    }
    
    public String GetFormattedCardString(Card card){
        return card.getCardValue().name() + " of " + card.getCardSuite().name();
    }   
}
