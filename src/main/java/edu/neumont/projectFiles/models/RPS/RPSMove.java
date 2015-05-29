package edu.neumont.projectFiles.models.RPS;
/**
 * Created by Anthony on 3/24/2015.
 */
public enum RPSMove {
    Rock("Rock"),
    Paper("Paper"),
    Scissors("Scissors"),
    Lizard("Lizard"),
    Spock("Spock"),
    Spiderman("Spiderman"),
    Wizard("Wizard"),
    Glock("Glock"),
    Batman("Batman");

    private String text;

    RPSMove(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }

    public static RPSMove fromString(String text)
    {
        if(text != null && !text.isEmpty())
        {
            for (RPSMove r : RPSMove.values()) {
                if (text.equalsIgnoreCase(r.text)) {
                    return r;
                }
            }
        }
        return null;
    }
}
