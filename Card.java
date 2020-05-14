import java.util.*;
/**
 * Freeston Athill
 * Senior Profile Management
 * Mr. Canedo
 * 04/19/20
 */
public class Card implements Comparable
{
    String suit = "";
    String rank = "";

    String[] suitList = {"Clubs","Diamonds","Hearts","Spades"};
    String[] rankList = {"Ace","2","3","4","5","6","7", "8","9","10","Jack","Queen","King"};

    int valueToReturn = 0;

    boolean exist = true;

    /**
     * Normal Constructor
     * 
     * Doesn't check if card already exists,
     *      simply creates a new card.
     */
    public Card()
    {
        suit = suitList[new Random().nextInt(suitList.length)];
        rank = rankList[new Random().nextInt(rankList.length)];
    }

    /**
     * Overloaded Constructor to create a specific card
     */
    public Card(String suitTemp, String rankTemp)
    {
        suit = suitTemp;
        rank = rankTemp;
    }

    /**
     * Overloaded Constructor to create new cards that have not
     *      been created yet
     * 
     * When creating Card() in tester class, add a list of cards in
     *      the parameter. Use a list of created Card() objects that 
     *      you create in tester class CardGame() before creating a new card.
     *      
     * This checks to see if card has already been created before 
     *      creating a new card.   
     *      
     * This constructor is used in this class' getListOfCards() method     
     */
    public Card(Card listOfCards[])
    {
        try
        {
            do
            {
                suit = suitList[new Random().nextInt(suitList.length)];
                rank = rankList[new Random().nextInt(rankList.length)];

                //{"Clubs","Diamonds","Hearts","Spades"};

                int dupes = 0;

                for(Card tempCard : listOfCards)
                {
                    if(this.getSuit().equalsIgnoreCase(((Card)tempCard).getSuit()) 
                    && this.getRank().equalsIgnoreCase(((Card)tempCard).getRank()))
                    {
                        dupes = dupes + 1;
                        break;
                    }
                }

                if(dupes == 0)
                {
                    exist = false;
                }
            }
            while(exist);
        }
        catch (NullPointerException exception)
        {
            /**
             * This exception is thrown because static method getListOfCards() 
             *      calls the constructor to make new cards for a list of cards.
             * The list is initally empty so when the two lined if statement 
             *      above calls the getSuit or getRank method to an empty 
             *      element in the list it throws this exception. 
             * Nothing needs to happen as it will continue to cycle through
             *      the list and run correctly.
             */
        }
    }

    /**
     * Compares two cards to check rank
     * 
     * Returns 0 if this is same as tempCard
     * Returns a negative integer if this is greater than tempCard
     * Returns a positive integer if this is less than tempCard
     * 
     * Ranking of suits according to Wikipedia: (Lowest to highest)
     *      Clubs, Diamonds, Hearts, Spades
     */
    //check to see if rank comes first in rankList[]
    public int compareTo(Object tempCard)
    {
        return this.getSuit().compareTo(((Card)tempCard).getSuit());
    }

    public String toString()
    {
        return "This suit is " + this.getSuit() + " and the rank is " + this.getRank() + ".";
    }

    public String getSuit()
    {
        return suit;
    }

    public String getRank()
    {
        return rank;
    }

    public static Card[] getListOfCards(int length)
    {
        Card[] listOfCards = new Card[length];

        for(int i = 0; i < length; i++)
        {
            listOfCards[i] = new Card(listOfCards);
        }

        return listOfCards;
    }

    //Greatest to Least
    public static Card orderCards(Card[] listToOrder)
    {
        Card maxCard = null;
        
        for(int i = 0; i < listToOrder.length; i++)
        {
            for(int k = 0; k < listToOrder.length; k++)
            {
                if(listToOrder[i].getSuit().compareTo(listToOrder[k].getSuit()) < 0)
                {
                    maxCard = listToOrder[i];
                }
            }
        }
        
        return maxCard;
    }

}
