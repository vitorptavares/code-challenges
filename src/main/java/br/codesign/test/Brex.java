package br.codesign.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Brex {

    /*
Splendor is a card-based board game where players buy cards in exchange for colored gems. In this game, today, we care about two things, gems and cards.

Players can have any number of gems of five different colors: (B)lue, (W)hite, (G)reen, (R)ed, and (Y)ellow.

Players can exchange gems for cards. A card appears as such:

+----------+
|        G |
|          |
|          |
| 3W       |
| 2G       |
| 1R       |
+----------+

This indicates that the card costs 3 (W)hite gems, 2 (G)reen gems, and 1 (R)ed. The “G” in the upper right indicates the color of the card (this will be useful later). Cards colors are als (B)lue, (W)hite, (G)reen, (R)ed, and (Y)ellow.

For this entire problem, we want to keep things simple by assuming that there is only one player.

The data model and structure of the program is up to you.

Questions
1. We want to write a function can_purchase() such that, given a particular card and collection of gems for a player, we return true if the player can afford the card, and false if they cannot.

2.
3.
4.


*/

// Main class should be named 'Solution' and should not be public.


    public static boolean canPurchase(Card card, Map<String, List<Gem>> gems, Card cardPlayer){

        return cardPlayer.getColor().equals(card.getColor()) && compareColorGems(gems, cardPlayer);

    }

    public static void main(String[] args) {
        Card card = new Card("B");

        Gem gem1 = new Gem("B");
        Gem gem2 = new Gem("B");
        Gem gem3 = new Gem("B");

        Gem gem4 = new Gem("R");
        Gem gem5 = new Gem("R");
        Gem gem6 = new Gem("R");


        List<Gem> listOfGems = new ArrayList<>();
        List<Gem> listOfGemsToBeCompared = new ArrayList<>();

        listOfGems.add(gem1);
        listOfGems.add(gem2);
        listOfGems.add(gem3);

        listOfGemsToBeCompared.add(gem1);
        listOfGemsToBeCompared.add(gem2);
        listOfGemsToBeCompared.add(gem3);

       // card    ''


        Card cardToBeCompared = new Card("blue");
     //   List<Gem> listOfGems = new ArrayList<>();
        Map<String, List<Gem>> gemsToBeCompared = new HashMap();

        listOfGems.add(gem1);
        listOfGems.add(gem2);
        listOfGems.add(gem3);

        gemsToBeCompared.put("B", listOfGems);



     //  canPurchase(cardToBeCompared, gemsToBeCompared, card1);
    }

    public static boolean compareColorGems(Map<String, List<Gem>> gems,  Card cardPlayer){
        AtomicBoolean  gemsColors = new AtomicBoolean(true);
        gems.forEach((key, value) -> {
            if(cardPlayer.getGems(key).size()!=value.size()){
                gemsColors.set(false);
            }
        });
        return gemsColors.get();


    }

    static class Card{
        private String color;
        private Map<String, List<Gem>> gems;

        public String getColor(){
            return this.color;
        }

        public void setColor(String color){
            this.color = color;
        }

        public Card(String color){
            this.color= color;
            gems = new HashMap<>();
        }

        public List<Gem> getGems(String color){
            return gems.get(color);
        }

        public void setGems(String color, List<Gem> gems){
            this.gems.put(color, gems);
        }


    }

    static class Gem{
        private String color;
        public String getColor(){
            return this.color;
        }

        public void setColor(String color){
            this.color = color;
        }

        public Gem(String color){
            this.color = color;
        }

    }
}
