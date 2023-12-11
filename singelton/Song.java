/**
 * A song class
 * @author Andrew Davison
 */
public class Song {

    private String title;
    private String artist;

    /**
     * Creates a new instance of a song
     * @param title A string representation of the song's title
     * @param artist A string representation of the song's author
     */
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Creates a string representation of the song
     * @return a string representation of the song
     */
    public String toString() {
        return this.title + " - " + this.artist;
    }

    /**
     * Gets the songs title
     * @return a string representing the song's title
     */
    public String getTitle() {
        return this.title;
    }
}