package canastra.models;
/**
 * Representation of a Player
 * @author rudy
 */
public class Player {
    private String playerName;
    private GroupOfCards playerCardsOnHand;    

    public Player(String playerName) {
        this.playerName = playerName;        
    }

    /**
     * @return the playerCardHand
     */
    public GroupOfCards getPlayerCardsHand() {
        return playerCardsOnHand;
    }

    /**
     * @param playerCardHand the playerCardHand to set
     */
    public void setPlayerCardHand(GroupOfCards playerCardHand) {
        this.playerCardsOnHand = playerCardHand;
    }
        
    public void addCardToPlayerHand(Card card){
        this.playerCardsOnHand.add(card);
    }
    
    public void removeCardFromPlayerHand(Card card){
        if (this.playerCardsOnHand.contains(card)){
            int idx = this.playerCardsOnHand.indexOf(card);
            this.playerCardsOnHand.remove(idx);
        }
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }    
}
