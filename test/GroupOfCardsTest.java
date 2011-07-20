import canastra.models.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rudy
 */
public class GroupOfCardsTest {
    private GroupOfCards grp;
    
    public GroupOfCardsTest() {
        grp = new GroupOfCards();        
    }
        
    @Before
    public void setUp() {
        Card card1 = new Card(CardValue.CardA,CardSuite.Club);
        Card card2 = new Card(CardValue.Card10,CardSuite.Spade);
        Card card3 = new Card(CardValue.Card5,CardSuite.Spade);
        grp.add(card1);
        grp.add(card2);
        grp.add(card3);            
    }
    
    @Test
    public void GroupOfCardsATotalValue_3CardsIncluded()
    {       
       assertEquals(30, grp.getTotalCardsValue());       
    }
    
    @Test
    public void GroupOfCardsMustHaveATotalValue_NoCardsIncluded()
    {
       grp.clear();
       assertEquals(0, grp.getTotalCardsValue());       
    }
}
