package classes;
import java.util.ArrayList;
import java.util.UUID;

public class Comment {
    private ArrayList<Comment> subComments; // stores sub-comments for the comment
    private String mainComment; // the main comment content
    private String username; // username of the user who posted the comment
    private UUID userID; // unique ID of the user who posted the comment


    /**
     * Creates a new Comment object with the specified parameters.
     * @param mainComment the main content of the comment
     * @param username the username of the user who posted the comment
     * @param userId the unique ID of the user who posted the comment
     */
    public Comment(String mainComment, String username, UUID userId){
        this.mainComment = mainComment;
        this.username = username;
        this.userID = userId;
        subComments = new ArrayList<Comment>();
    }

    /**
     * Creates a new Comment object with the specified parameters.
     * @param userID the unique ID of the user who posted the comment
     * @param mainComment the main content of the comment
     * @param username the username of the user who posted the comment
     * @param subComments an ArrayList of sub-comments for the comment
     */
    public Comment(UUID userID, String mainComment, String username, ArrayList<Comment> subComments){
        this.mainComment = mainComment;
        this.username = username;
        this.subComments = subComments;
        this.userID = userID;
    }

    /**
     * Returns a string representation of the Comment object.
     * @return a string representation of the Comment object
     */
    public String toString(){
        String result = "";
        result += this.username+":\n";
        result += "     '"+mainComment+"'";
        return result;
    }

    /**
     * Adds a sub-comment to the Comment object.
     * @param Comment the sub-comment to add
     */
    public void addSubComment(Comment subComment){
        subComments.add(subComment);
    }


    /**
     * Returns the main content of this comment.
     * @return the main content of this comment
     */
    public String getContent() {
        return this.mainComment;
    }

    /**
     * Returns the username of the user who posted this comment.
     *
     * @return the username of the user who posted this comment
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Returns the UUID of the user who posted this comment.
     * @return the UUID of the user who posted this comment
     */
    public UUID getID() {
        return this.userID;
    }

    /**
     * Returns a list of all sub-comments associated with this comment. If there are no
     * sub-comments, this method returns an empty ArrayList.
     * @return a list of all sub-comments associated with this comment
     */
    public ArrayList<Comment> getReplies() {
        if(subComments == null)
        {
            subComments = new ArrayList<Comment>();
            return subComments;
        }  
        else
            return this.subComments;
    }
}
