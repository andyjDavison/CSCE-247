package classes;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class Course {
    private ArrayList<Topic> topics;
    private ArrayList<Student> students;
    private String title;
    private String description;
    private Difficulty difficulty;
    private UUID id; 
    private UUID authorID;

    /**
     * Constructs a new Course object with the specified title, description, difficulty,
     * and author UUID. The topics and students lists are initially empty and will be populated
     * as necessary using the corresponding add methods.
     *
     * @param title the title of the course
     * @param description the description of the course
     * @param difficulty the difficulty of the course
     * @param topics to be in course
     * @param authorID the UUID of the author who created the course
     */
    public Course(String title, String description,  Difficulty difficulty, ArrayList<Topic> topics, UUID authorID) {
        this.topics = topics;
        this.students = new ArrayList<Student>();
        this.title = title;
        this. description =  description;
        this.id = UUID.randomUUID();
        this.authorID = authorID;
        this.difficulty = difficulty;
    }

    /**
     * Constructs a new Course object with the specified UUID, topics, students, title, description,
     * difficulty, and author UUID.
     *
     * @param id the UUID of the course
     * @param topics the list of topics associated with the course
     * @param students the list of students enrolled in the course
     * @param title the title of the course
     * @param description the description of the course
     * @param difficulty the difficulty of the course
     * @param authorID the UUID of the author who created the course
     */
    public Course(UUID id, ArrayList<Topic> topics, ArrayList<Student> students, String title, String description, Difficulty difficulty, UUID authorID) {
        this.topics = topics;
        this.students = students;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.id = id;
        this.authorID = authorID;
    }

    /**
    Returns a string representation of the Course object, including its title, description, and difficulty level.
    @return a string containing the title, description, and difficulty level of the course
    */
    public String toString(){
        String result = "";
        result += this.title+"\n";
        result += this.description+"\n";
        result += "Difficulty: "+this.difficulty.toString();
        return result;
    }


    /**
     * Adds the specified topic to the list of topics associated with this course.
     * @param topic the topic to add to the list of topics
     */
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    /**
     * Returns the list of students enrolled in this course. If there are no students
     * currently enrolled, this method returns an empty ArrayList.
     * @return the list of students enrolled in this course
     */
    public ArrayList<Student> getStudents(){
        if(students != null){
            return this.students;
        }
        else
            students = new ArrayList<Student>();
            return null;
    }

    /**
     * Returns the UUID of this course as a string. If the UUID is null, this method returns null.
     * @return the UUID of this course as a string, or null if the UUID is null
     */
    public String getID() {
        if(id == null)
            return null;
        else
            return this.id.toString();
    }
    
    /**
     * Returns the UUID of this course. If the UUID is null, this method returns null.
     * @return the UUID of this course, or null if the UUID is null
     */
    public UUID getUuid(){
        return this.id;
    }

    /**
     * Returns the title of the course.
     * @return the title of the course or null if it is not set.
     */
    public String getTitle() {
        if(title == null)
            return null;
        else
            return this.title;
    }

    /**
     * Returns the description of the course.
     * @return the description of the course or null if it is not set.
     */
    public String getDescription() {
        if(description == null)
            return null;
        else
            return this.description;
    }

    /**
     * Returns the ID of the course author in string format
     * @return the ID of the course author in string format or null if it is not set
     */
    public String getAuthorIDstring() {
        if(authorID == null)
            return null;
        else
            return this.authorID.toString();
    }

    /**
     * Returns the ID of the course author in UUID format.
     * @return the ID of the course author in UUID format or null if it is not set
     */
    public UUID getAuthorIDuui(){
        if(authorID == null)
            return null;
        else
            return this.authorID;
    }


    /** 
    Compares this Course object to another Course object to determine if they are equal.
    @param course the Course object to compare
    @return true if the Course objects are equal, false otherwise
    */
    public boolean equals(Course course){
        boolean result = false;
        boolean topicCheck = false;
        int position = 0;
        int numMatchingTopics = 0;
        for(Topic topic : topics){
        if(topic.equals(course.getTopics().get(position))){
            numMatchingTopics++;
        }
            position++;
        }
        if(numMatchingTopics == topics.size()){
            topicCheck = true;
        }
        if(course != null &&
            topicCheck &&
        this.title.equals(course.getTitle()) &&
        this.description.equals(course.getDescription()) &&
        this.difficulty.equals(course.getEnumDifficulty()) &&
        this.id.toString().equals(course.getID()) &&
        this.authorID.toString().equals(course.getAuthorIDstring())){
            result = true;
        }
        return result;
    }

    /**
     * Returns the list of topics covered in the course.
     * @return the list of topics covered in the course or null if it is not set.
     */
    public ArrayList<Topic> getTopics(){
        if(topics != null){
            return this.topics;
        }
        else    
            return null;
    }
    
    /**
    Generates a string containing the names of all the topics included in the Course, numbered in order.
    @return a string containing the names of all the topics included in the Course, numbered in order
    */
public String displayTopics(){
    String result = "";
    int position = 1;
    for(Topic topic : this.topics){
            result += Integer.toString(position)+". "+topic.getName()+"\n";
            position++;
        }
        return result;
    }

    /**
     * Returns the difficulty level of the course.
     * @return the difficulty level of the course or null if it is not set.
     */
    public String getDifficulty() {
        if(difficulty != null)
            return this.difficulty.toString();
        else
            return null;
    }
    
    /**
     * Returns the difficulty level of the course in enum type.
     * @return the difficulty level of the course in enum type or null if it is not set.
     */
    public Difficulty getEnumDifficulty(){
        if (this.difficulty != null){
            return this.difficulty;
        } else {
            return null;
        }
    }
    
    /**
    Adds a Student object to the list of students enrolled in the Course.
    @param student the Student object to add to the Course
    */
    public void addStudent(Student student){
        this.students.add(student);
    }


    
}
