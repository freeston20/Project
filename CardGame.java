import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 * Freeston Athill
 * Senior Profile Management
 * Mr. Canedo
 * 04/19/20
 */
public class CardGame extends Card
{
    public static void main(String[] args) 
    {
        int points = 0;
        boolean run = true;
        boolean needsSuit = true;
        boolean needsRank = true;

        String guessedSuit = "";
        String guessedRank = "";

        System.out.println("\f");

        //examples of constructors that could be used if needed
        Card card1 = new Card();
        Card card2 = new Card("Hearts", "Ace");
        Card[] forExample = new Card[5];    //used for third type of constructor
        Card card3 = new Card(forExample);

        Card[] cardList;
        cardList = CardGame.getListOfCards(6);
        Card newCard = CardGame.orderCards(cardList);

        //Beggining of tester method
        Scanner scan = new Scanner(System.in);
        System.out.println("Press Enter key to begin...");
        scan.nextLine();

        String[] options1 = new String[] {"Play a guessing game","Cancel"};
        int response1 = JOptionPane.showOptionDialog(null, "Welcome", "Card Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, options1[0]);

        if(response1 == 0)
        {
            do
            {
                System.out.println("\f");

                if(points > 0)
                {
                    System.out.println("Current points: " + points);
                }

                if(needsSuit)
                {
                    System.out.println("Guess the suit");
                    guessedSuit = scan.nextLine();
                    if(newCard.getSuit().equalsIgnoreCase(guessedSuit))
                    {
                        System.out.println("You correctly guessed the suit! +1 point");
                        points = points + 1;
                        needsSuit = false;
                    }
                    else
                    {
                        System.out.println("Guess was incorrect.");
                    }
                }

                if(needsRank)
                {
                    System.out.println("Guess the rank");
                    guessedRank = scan.nextLine();
                    if(newCard.getRank().equalsIgnoreCase(guessedRank))
                    {
                        System.out.println("You correctly guessed the rank! +1 point");
                        points = points + 1;
                        needsRank = false;
                    }
                    else
                    {
                        System.out.println("Guess was incorrect.");
                    }
                }

                String[] options2 = new String[] {"Keep guessing?","New game","Cancel"};
                int response2 = JOptionPane.showOptionDialog(null, "Guessing Game", "'Guess the card!'",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options2, options2[0]);
                if(response2 == 0)
                {
                    run = true;
                }
                else if(response2 == 1)
                {
                    cardList = CardGame.getListOfCards(6);
                    newCard = CardGame.orderCards(cardList);

                    System.out.println("\fResults:\n\tThe suit was " + newCard.getSuit() 
                        + "\n\tThe rank was " + newCard.getRank()
                        + "\n\tThe score was " + points);

                    System.out.println("Press Enter key to begin new game...");
                    scan.nextLine();

                    points = 0;

                    guessedSuit = "";
                    guessedRank = "";

                    needsSuit = true;
                    needsRank = true;

                    run = true;
                }
                else if(response2 == 2)
                {
                    System.out.println("\fGuessing game finished");
                    System.out.println("Results:\n\tThe suit was " + newCard.getSuit() 
                        + "\n\tThe rank was " + newCard.getRank()
                        + "\n\tThe score was " + points);

                    run = false;
                }
            }
            while(run);
        }
        else if(response1 == 1)
        {
            System.out.println("\f");
            System.out.println("Guessing game finished");

            if(points > 0)
            {
                System.out.println("Final points: " + points);
            }
        }
    }
}
