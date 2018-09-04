import java.util.*;



public class TableController {
    
    private List<Player> listOfPlayers = new ArrayList<Player>();
    private Deck deck;
  
    
    public void game() {
        this.deck = new Deck();
        createPlayers(4);
        dealCards();
        // for (int i = 0; i < deck.getDeck().size(); i++ ){
        //     System.out.println(deck.getDeck().get(i).getName());
        //     System.out.println(deck.getDeck().get(i).getFirstParameter());
        //     System.out.println(deck.getDeck().get(i).getSecondParameter());
        //     System.out.println(deck.getDeck().get(i).getThirdParameter());
        //     System.out.println(deck.getDeck().get(i).getFourthParameter());
        // }
        
        // cards printing
        
        int num = 0;
        for (Player player : this.listOfPlayers) {
            num ++;
            for (Card card : player.hand.getHandontent()){
                System.out.println("karta playera :" + num);
                System.out.println(card.getFirstParameter());
                System.out.println(card.getSecondParameter());
                System.out.println(card.getThirdParameter());
                System.out.println(card.getFourthParameter());
            }
        }

        /// dealed car printing

    }

    private void createPlayers(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i ++) {
            listOfPlayers.add(new CPU());
        }
    }

    private void dealCards() {
        while (deckIsNotEmpty(this.deck)) {
            for (int i = 0; i < listOfPlayers.size(); i++) {
                listOfPlayers.get(i).hand.getHandontent().add(this.deck.pickCard());
            }
        }
        
    } 

    private boolean deckIsNotEmpty(Deck deck) {
        if (deck.getDeck().size() > 0) {
            return true;
        }
        else 
            return false;
    }
}

