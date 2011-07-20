/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import canastra.models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rudy
 */
public class GroupOfCardsOnTableTest {
    private GroupOfCardsOnTable groupOfCardsOnTable;
    public GroupOfCardsOnTableTest() {
        groupOfCardsOnTable = new GroupOfCardsOnTable();
    }
        
    @Before
    public void setUp() {
        Card card1 = new Card(CardValue.Card3, CardSuite.Club);
        Card card2 = new Card(CardValue.Card4, CardSuite.Club);
        Card card3 = new Card(CardValue.Card5, CardSuite.Club);
        Card card4 = new Card(CardValue.Card6, CardSuite.Club);
        Card card5 = new Card(CardValue.Card7, CardSuite.Club);
        Card card6 = new Card(CardValue.Card8, CardSuite.Club);
        groupOfCardsOnTable.add(card1);
        groupOfCardsOnTable.add(card2);
        groupOfCardsOnTable.add(card3);
        groupOfCardsOnTable.add(card4);
        groupOfCardsOnTable.add(card5);
        groupOfCardsOnTable.add(card6);        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void mustKnowIfThereIsACanastra_LessThan7Cards(){
        assertFalse(groupOfCardsOnTable.isARealCanastra());
        assertFalse(groupOfCardsOnTable.isASingleCanastra());
    }          
    
    @Test
    public void mustKnowIfCanastraIsReal_IncludeAJoker(){  
        groupOfCardsOnTable.add(new Card(CardValue.Joker));
        assertTrue(groupOfCardsOnTable.isASingleCanastra());
        assertFalse(groupOfCardsOnTable.isARealCanastra());
    }
    
    @Test
    public void mustKnowIfCanastraIsReal_DoesntIncludeAJokerAllSameSuite(){
        groupOfCardsOnTable.add(new Card(CardValue.Card9, CardSuite.Club));
        assertFalse(groupOfCardsOnTable.isASingleCanastra());
        assertTrue(groupOfCardsOnTable.isARealCanastra());
    }
    
    @Test
    public void mustKnowIfCanastraIsReal_DoesntIncludeAJokerTwoOfADifferentSuite(){
        groupOfCardsOnTable.add(new Card(CardValue.Card2, CardSuite.Diamond));
        assertTrue(groupOfCardsOnTable.isASingleCanastra());
        assertFalse(groupOfCardsOnTable.isARealCanastra());
    }
    
    @Test
    public void mustKnowIfCanastraIsReal_DoesntIncludeAJokerTwoOfSameSuite(){
        groupOfCardsOnTable.add(new Card(CardValue.Card2, CardSuite.Club));
        assertFalse(groupOfCardsOnTable.isASingleCanastra());
        assertTrue(groupOfCardsOnTable.isARealCanastra());
    }    
    
    @Test
    public void mustKnowCorrectPoints_RealCanastra(){
        groupOfCardsOnTable.add(new Card(CardValue.Card2, CardSuite.Club));
        assertEquals(245, groupOfCardsOnTable.getTotalCardsValue());
    }   
    
    @Test
    public void mustKnowCorrectPoints_SingleCanastra(){
        groupOfCardsOnTable.add(new Card(CardValue.Card2, CardSuite.Diamond));
        assertEquals(145, groupOfCardsOnTable.getTotalCardsValue());
    }
    
    @Test
    public void cannotInsertDifferentSuiteCardsOnSameGroupUnlessItsTwoOrJoker_InsertJoker(){
        assertTrue(groupOfCardsOnTable.add(new Card(CardValue.Joker)));
    }            
    
    @Test
    public void cannotInsertDifferentSuiteCardsOnSameGroupUnlessItsTwoOrJoker_InsertTwoOfSameSuite(){
        assertTrue(groupOfCardsOnTable.add(new Card(CardValue.Card2, CardSuite.Club)));
    }            
    
    @Test
    public void cannotInsertDifferentSuiteCardsOnSameGroupUnlessItsTwoOrJoker_InsertTwoOfDifferentSuite(){
        assertTrue(groupOfCardsOnTable.add(new Card(CardValue.Card2, CardSuite.Heart)));
    }            
    
    @Test
    public void cannotInsertDifferentSuiteCardsOnSameGroupUnlessItsTwoOrJoker_InsertDifferentSuiteCard(){
        assertFalse(groupOfCardsOnTable.add(new Card(CardValue.CardA, CardSuite.Heart)));
    }            
}
