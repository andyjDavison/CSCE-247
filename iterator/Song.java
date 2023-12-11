/**
 * A song class
 * @author Andrew Davison
 */
public class Song {
    
    private String name;
    private String artist;
    private double length;
    private Genre genre;

    /**
     * Creates a new instance of a song
     * @param name A string that represents the name of the song
     * @param artist A string that represents the name of the artist
     * @param length A double that represents the length of the song
     * @param genre An Genre that represents the genre of the song
     */
    public Song(String name, String artist, double length, Genre genre) {
        this.name = name;
        this.artist = artist;
        this.length = length;
        this.genre = genre;
    }

    /**
     * Creates a string representation of the song
     * @return A string that holds all the attributes of the song
     */
    public String toString() {
        return this.name + " by " + this.artist + " category: " + this.genre.toString() + " length: " + this.length + " min";
    }
}
