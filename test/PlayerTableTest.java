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
public class PlayerTableTest {
    private PlayerTable playerTable;
    private GroupOfCardsOnTable cardsGroup;
    
    public PlayerTableTest() {
        playerTable = new PlayerTable(new Player("Jogador"));        
    }   
    
    @Before
    public void setUp() {        
        cardsGroup = new GroupOfCardsOnTable();
        cardsGroup.add(new Card(CardValue.Card2, CardSuite.Diamond));
        cardsGroup.add(new Card(CardValue.Card3, CardSuite.Diamond));        
    }
    
    @After
    public void tearDown() {
        cardsGroup = null;
    }
    
    @Test
    public void cannotAddGroupToTableUnlessThereIsMoreThan3Cards_Adding2Cards(){        
        assertFalse(playerTable.addGroupToTable(cardsGroup));
    }
    
    @Test
    public void cannotAddGroupToTableUnlessThereIsMoreThan3Cards_Adding3Cards(){
        cardsGroup.add(new Card(CardValue.Card4, CardSuite.Diamond));
        assertTrue(playerTable.addGroupToTable(cardsGroup));
    }
}
