import java.util.Iterator;

/**
 * An Iterator that moves through an Album
 * @author Andrew Davison
 */
public class AlbumIterator implements Iterator {
    
    private Song[] songs;
    private int position = 0;

    /**
     * Creates an instance of the album iterator
     * @param songs An array of songs that the iterator will move thru
     */
    public AlbumIterator(Song[] songs) {
        this.songs = songs;
    }

    /**
     * Checks whether the array has a next value
     * @return A boolean that represents if there is a next value
     */
    public boolean hasNext() {
        return position <= songs.length && songs[position] != null;
    }

    /**
     * Moves to the next song in the array
     * @return A song that was next in the array
     */
    public Song next() {
        Song song = songs[position];
        position++;
        return song;
    }
}
