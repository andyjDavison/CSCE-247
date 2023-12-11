/**
 * An album class
 * @author Andrew Davison
 */
public class Album {
    
    private Song[] songs;
    private static final int MAX_SIZE = 20;
    private int count = 0;
    private String name;

    /**
     * Creates a new instance of an album
     * @param name A string that represents the name of the album
     */
    public Album(String name) {
        this.name = name;
        this.songs = new Song[MAX_SIZE];
    }

    /**
     * Adds a song to the album
     * @param name A string that represents the name of the song being added
     * @param artist A string that represents the name of the artist of the song being added
     * @param length A double that represents the length of the song being added
     * @param genre A genre that represents the genre of the song being added
     * @return A boolean that represents wether the song was added successfully or not
     */
    public boolean addSong(String name, String artist, double length, Genre genre) {
        Song song = new Song(name, artist, length, genre);
        if(count >= MAX_SIZE) {
            return false;
        }
        songs[count] = song;
        count++;
        return true;
    }

    /**
     * Creates an iterator for the album class
     * @return A new Iterator that moves over the albums songs array
     */
    public AlbumIterator createIterator() {
        return new AlbumIterator(songs);
    }

    /**
     * Gets the name of the album
     * @return a string that represents the name of the album
     */
    public String getName() {
        return this.name;
    }
}
