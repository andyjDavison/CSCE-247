package classes;
import java.util.ArrayList;
/**
 * topic class
 */
public class Topic {
    private ArrayList<Subtopic> subtopics; //arraylist of subtopics
    private ArrayList<Comment> comments; //arraylist of comments on topic
    private String name; //name for topic
    private Quiz quiz; //quiz for topic
    private int position; //position for iterator

    /**
     * constructor for topic (new)
     * @param subtopics
     * @param name
     * @param quiz
     */
    public Topic(ArrayList<Subtopic> subtopics, String name, Quiz quiz){
        this.subtopics = subtopics;
        this.name = name;
        this.quiz = quiz;
        comments = new ArrayList<Comment>();
        this.position = 0;
    }
    /**
     * contsructor for topic (loading)
     * @param subtopics
     * @param comments
     * @param name
     * @param quiz
     */
    public Topic(ArrayList<Subtopic> subtopics, ArrayList<Comment> comments, String name,Quiz quiz){
        this.subtopics = subtopics;
        this.comments = comments;
        this.name = name;
        this.quiz = quiz;
        this.position =0;
    }
    /**
     * equals method for topic
     * @param topic
     * @return true if this topic is equal to other topic
     */
    public boolean equals(Topic topic){
        boolean result = false;
        boolean subtopicCheck = false;
        int position = 0;
        int numMatchingSubtopics = 0;
        for(Subtopic subtopic : subtopics){
            Subtopic correctSubTop = topic.getSubTop().get(position);
            if(subtopic.toString().equals(correctSubTop.toString())){
                numMatchingSubtopics++;
            }
            position++;
        }
        if(numMatchingSubtopics == subtopics.size()){
            subtopicCheck = true;
        }
        if(topic != null &&
        subtopicCheck &&
        this.name.equals(topic.getName()) &&
        this.quiz.equals(topic.getQuiz())){
            result = true;
        }
        return result;
    }
    /**
     * test to see if topic is complete (uses iterator)
     * @return true if topic is complete
     */
    public boolean completionStatus(){
        boolean result;
        if(!hasNext()){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * next subtopic method as part of iterator
     * @return next subtopic if there is one
     */
    public Subtopic nextSubtopic(){
        if(!hasNext()){
            return null;
        }
        Subtopic subtopic = subtopics.get(position);
        position++;
        return subtopic;
    }
    /**
     * checks to see if topic has a next subtopic
     * @return true if there are more subtopic(s) in the arraylist
     */
    public boolean hasNext(){
        return subtopics.get(position) != null && position < subtopics.size();
    }
    /**
     * displays string of all subtopics
     * @return string of list of all subtopics
     */
    public String displaySubtopics(){
        String result = "";
        int position = 1;
        for(Subtopic subtopic : this.subtopics){
            result += Integer.toString(position)+". "+subtopic.toString()+"\n";
            position++;
        }
        return result;
    }
    /**
     * displays topics quiz
     * @return string of topics quiz
     */
    public String displayQuiz(){
        return this.quiz.toString();
    }
    /**
     * displays all info of topic
     * @return string of subtopics and quiz for topic
     */
    public String displayTopicInfo(){
        String result = this.displaySubtopics()+"\n";
        result += this.displayQuiz();
        return result;
    }
    /**
     * prints contents of topic to file (subtopics)
     */
    public void printToFileTopic() {
        LMSFileWriter.topicToFile(this);
    }
    /**
     * adds comment to arraylist
     * @param comment
     */
    public void addComment(Comment comment){
        comments.add(comment);
    }
    /**
     * setter for quiz
     * @param quiz
     */
    public void addQuiz(Quiz quiz){
        this.quiz = quiz;
    }
    /**
     * adds subtopic to arraylist
     * @param subtopic
     */
    public void addSubtopic(Subtopic subtopic){
        subtopics.add(subtopic);
    }
    /**
     * @return returns arraylist of subtopics
     */
    public ArrayList<Subtopic> getSubTop() {
        if(subtopics == null){
            subtopics = new ArrayList<Subtopic>();
            return subtopics;
        }
        else
            return this.subtopics;
    }
    /**
     * @return returns quiz for topic
     */
    public Quiz getQuiz() {
        return this.quiz;
    }
    /**
     * @return returns name for topic
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return returns arraylist of comments for topic
     */
    public ArrayList<Comment> getComments() {
        if(comments == null) {
            comments = new ArrayList<Comment>();
            return comments;
        } 
        else
            return this.comments;
    }
}
