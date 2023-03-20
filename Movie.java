/*CSC1 2300
 * Project 2 - Movie Theatre
 * 
 * Done by Ana Belen Ortiz and Valeria Galiano 
 * 5/3/23
 */
import javax.swing.Icon;

public class Movie {
    private String name;
    private String genre;
    private Icon icon;
    private int minutes;
    private int ticketsBought;
    private String releaseDate;

    public Movie(String name, String genre, Icon icon, int minutes, String releaseDate) {
        this.name = name;
        this.genre = genre;
        this.icon = icon;
        this.minutes = minutes;
        this.releaseDate = releaseDate;
        this.ticketsBought = 0;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Icon getIcon() {
        return icon;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getTicketsBought() {
        return ticketsBought;
    }

    public void buyTickets(int numTickets) {
        ticketsBought += numTickets;
    }
}