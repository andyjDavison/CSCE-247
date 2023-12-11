import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A Juke Box class
 * @author Andrew Davison
 */
public class JukeBox {
    
    private static JukeBox jukeBox;
    private ArrayList<Song> songs;
    private Queue<String> songQueue = new LinkedList<String>();

    /**
     * Creates an instance of the JukeBox class and loads it with songs
     */
    private JukeBox() {
        songs = DataLoader.getSongs();
    }

    /**
     * Gets the one instance of the JukeBox class
     * @return the single instance of the JukeBox class
     */
    public static JukeBox getInstance() {
        if(jukeBox == null) {
            jukeBox = new JukeBox();
        }
        return jukeBox;
    }

    /**
     * Plays the next song in the queue
     * @return a string representing the next song in the queue
     */
    public String playNextSong() {
        if(songQueue == null) {
            return "You need to add songs to the list";
        }
        return "Let's jam to " + songQueue.remove();
    }

    /**
     * Requests a song and adds it to the queue if available
     * @param title a string representation of the song to be requested
     * @return a string indicating whether the request was successful or not
     */
    public String requestSong(String title) {
        boolean flag = false;
        for(int i=0;i<songs.size();i++) {
            if(title.equals(songs.get(i).getTitle())) {
                flag = true;
                songQueue.add(title);
            }
        }
        return (flag) ? (title + " is now number " + songQueue.size() + " in the list") : ("Sorry we do not have the song " + title);
        
    }

    /**
     * Sees if the queue has anymore songs
     * @return A boolean representing whether the queue has any more songs
     */
    public boolean hasMoreSongs() {
        return !songQueue.isEmpty();
    }

}
