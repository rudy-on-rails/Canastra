/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;
import java.util.ArrayList;

/**
 * Representation of a table where players set their cards
 * @author rudy
 */
public class PlayerTable {
    private ArrayList<GroupOfCardsOnTable> listOfGroupOfCardsOnTable;
    private boolean hasTakenMorto;
    private Player playerUsingTheTable;
    
    public PlayerTable(Player playerUsingTable) {
        listOfGroupOfCardsOnTable = new ArrayList<GroupOfCardsOnTable>();
        playerUsingTheTable = playerUsingTable;
        hasTakenMorto = false;
    }
            
    public boolean addCardToAGroup(Card card, int indexOfGroupOfCards){
        return listOfGroupOfCardsOnTable.get(indexOfGroupOfCards).add(card);
    }
    
    public boolean addGroupToTable(GroupOfCardsOnTable groupOfCardsOnTable){
        if (groupOfCardsOnTable.size() < 3)
            return false;
        else                
            return this.listOfGroupOfCardsOnTable.add(groupOfCardsOnTable);
    }
    
    public int getTotalAmountOfPointsOnTable(){
        int totalOfPoints = 0;
        for (int i = 0; i < listOfGroupOfCardsOnTable.size(); i++) {
            totalOfPoints += listOfGroupOfCardsOnTable.get(i).getTotalCardsValue();
        }
        totalOfPoints -= this.hasTakenMorto ? 0 : 100;
        return totalOfPoints;
    }
    
    public void takeMorto(){
        hasTakenMorto = true;
    }
}
