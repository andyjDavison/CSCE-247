import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The media adapter class
 * @author Andrew Davison
 */
public class MediaAdapter implements Media {
    private LittleMedia littleMedia;

    /**
     * Creates a new instance of the MediaAdapter class
     * @param littleMedia A lttleMedia that gets set to this instance's little media to be adapted
     */
    public MediaAdapter(LittleMedia littleMedia) {
        this.littleMedia = littleMedia;
    }

    /**
     * Gets the little media's title
     * @return A string representing the little media's title
     */
    public String getTitle() {
        return this.littleMedia.getTitle();
    }

    /**
     * Gets the little media's author
     * @return A string representing the little media's author
     */
    public Author getAuthor() {
        String[] author = this.littleMedia.getAuthor().split(" ");
        return new Author(author[0], author[1]);
    }

    /**
     * Gets the little media's description
     * @return A string representing the little media's description
     */
    public String getDescription() {
        return this.littleMedia.getDescription();
    }

    /**
     * Adds a review to the little media's list of reviews
     * @param firstName A string of the first name
     * @param lastName A string of the last name
     * @param date A date representing the reviews date
     * @param rating A double representing the reviews rating
     * @param comment A string of the comment
     */
    public void addReview(String firstName, String lastName, Date date, double rating, String comment) {
        this.littleMedia.addReview(firstName+ " " + lastName, date, (int)Math.round(rating), comment);
    }

    /**
     * Gets the little media's reviews
     * @return An ArrayList of type review representing the little media's reviews
     */
    public ArrayList<Review> getReviews() {
        ArrayList<String> reviewString = this.littleMedia.getReviews();
        ArrayList<Review> reviewAdapt = new ArrayList<>();
        for(String review : reviewString) {
            int ratingIndex = review.indexOf(" stars - ");
            int commentIndex = review.indexOf(" by ");
            int userNameIndex = review.lastIndexOf(" - ");
            Double rating = Double.parseDouble(review.substring(0, ratingIndex));
            String comment = review.substring(ratingIndex+9, commentIndex);
            String username = review.substring(commentIndex+4, userNameIndex);
            String[] name = username.split(" ");
            String firstName = name[0];
            String lastName = name[1];
            String sDate = review.substring(userNameIndex+2);
            Date date = parseDate(sDate);
            reviewAdapt.add(new Review(firstName, lastName, date, rating, comment));
        }
        return reviewAdapt;
    }

    /**
     * Parses the string date into a Date object
     * @param date A string that is to be parsed
     * @return The parsed string as a Date object
     */
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy").parse(date);
        } catch(ParseException e) {
            return null;
        }
    }
}