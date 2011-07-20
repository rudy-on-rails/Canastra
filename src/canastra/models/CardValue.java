/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canastra.models;

/**
 *
 * @author rudy
 */
public enum CardValue {
    Joker(20),
    CardA(15),
    Card2(10),
    Card3(5),
    Card4(5),
    Card5(5),
    Card6(5),
    Card7(5),
    Card8(10),
    Card9(10),
    Card10(10),
    CardJ(10),
    CardQ(10),
    CardK(10);
    
    private final int value;
    
    private CardValue(int Cardvalue) {
        value = Cardvalue;
    }
    public int getBuracoValue(){
        return value;
    }
}
