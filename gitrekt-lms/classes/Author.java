package classes;
import java.util.UUID;
import java.util.ArrayList;

public class Author extends Student{
    private ArrayList<Course> createdCourses;/* An ArrayList of Course objects created by the author */
    private String type = "Author";/* A String representing the type of user, set to "Author" */

    /**
     * Constructor for Author class that takes in user information and initializes the createdCourses ArrayList.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email address of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public Author(String firstName, String lastName, String email, String username, String password){
        super(firstName, lastName, email, username, password);
        this.createdCourses = new ArrayList<>();
    }

    /**
     * Constructor for Author class that takes in user and course information.
     * @param id The unique ID of the user.
     * @param createdCourses An ArrayList of Course objects created by the author.
     * @param courseProgresses An ArrayList of CourseProgress objects representing the author's progress in courses.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email address of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public Author(UUID id, ArrayList<Course> createdCourses, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password){
        super(id, courseProgresses,firstName, lastName, email, username, password);
        this.createdCourses = createdCourses;
    }

    /**
     * Setter for the createdCourses ArrayList.
     * @param createdCourses An ArrayList of Course objects created by the author.
     */
    public void setCreatedCourses(ArrayList<Course> createdCourses){
        this.createdCourses = createdCourses;
    }
    /**
     * Adds course course to createdCourses arraylist
     * @param course
     */
    public void addCreatedCourses(Course course) {
        this.createdCourses.add(course);
    }

    /**
     * Returns a String representation of the Author object.
     * @return A String representing the Author object.
     */
    public String toString(){
        String result = "";
        if(this.courseProgresses == null){
            courseProgresses = new ArrayList<CourseProgress>();
            return result;
        }
        
        result += "Name: "+this.firstName+" "+this.lastName+"\n";
        result += "Username: "+this.username+"\n";       
        result += "Password: "+this.password+"\n";
        result += "Email: "+this.email+"\n";
        result += "Type: "+this.type+"\n";
        result += "Courses: ";
        for (CourseProgress courseProgress : courseProgresses){
            result += courseProgress.toString()+", ";
        }
        result += "\n";
        return result;
    }

/**
    Creates a new course object with the specified topics, title, description, and difficulty, and adds it to the course list.
    @param topics a list of Topic objects that will be covered in the course
    @param title the title of the new course
    @param description brief description of the new course
    @param difficulty integer representing the difficulty level of the new course: 0 for beginner, 1 for intermediate, and 2 for advanced
    */
    public void makeCourse(ArrayList<Topic> topics, String title, String description, int difficulty){
        Difficulty diff;
        if(difficulty == 0){
            diff = Difficulty.BEGINNER;
        } else if(difficulty == 1){
            diff = Difficulty.INTERMEDIATE;
        } else {
            diff = Difficulty.ADVANCED;
        }
        CourseList courseList = CourseList.getInstanceCourseList();
        Course course = new Course(title, description, diff, topics, id);
        courseList.addCourse(course);
        createdCourses.add(course);
        DataWriter.saveCourses();
        }
        
        /**
        Returns a string representation of the titles of all created courses.
        @return a string containing the title of each created course, along with its position in the list
        */
        public String displayCreatedCourses(){
            String result = "";
            int position = 1;
            for(Course course : createdCourses){
                result += Integer.toString(position)+". "+course.getTitle()+"\n";
            }
            return result;
        }

        /**
        Returns a list of all courses created by the user.
        @return an ArrayList containing all courses created by the user
        */
        public ArrayList<Course> getCreatedCourses(){
            return this.createdCourses;
        }
}