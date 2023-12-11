package classes;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Abstract class that represents a user
 */
public abstract class User {
    
    protected ArrayList<CourseProgress> courseProgresses;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String email;
    protected UUID id;

    /**
     * Creates a new instance of new user
     * @param firstName String representing the users firstname
     * @param lastName String representing the users lastname
     * @param email String representing the users email
     * @param username String representing the users username
     * @param password String representing the users password
     */
    public User(String firstName, String lastName, String email, String username, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.courseProgresses = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    /**
     * Creates a new instance of a returning user
     * @param id UUID representing the users id
     * @param courseProgresses ArrayList representing the users progress in the course
     * @param firstName String representing the users first name
     * @param lastName String representing the users last name
     * @param email String representing the users email
     * @param username String representing the users username
     * @param password String representing the users password
     */
    public User(UUID id, ArrayList<CourseProgress> courseProgresses, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        setCourseProgress(courseProgresses);
    }

    /**
     * Add a new course progress to the user
     * @param course A course that the user is taking
     */
    public void addCourseProgress(Course course) {
        this.courseProgresses.add(new CourseProgress(course));
    }

    /**
     * Add a current course progress to the user
     * @param course A course that the user is taking
     * @param grades ArrayList that holds the grades
     */
    public void addCourseProgress(Course course, ArrayList<Double> grades) {
        this.courseProgresses.add(new CourseProgress(course, grades));
    }

    /**
     * Set the users course progress
     * @param courseProgresses Current ArrayList of users course progress
     */
    public void setCourseProgress(ArrayList<CourseProgress> courseProgresses) {
        if(courseProgresses == null) {
            this.courseProgresses = new ArrayList<>();
        }
        this.courseProgresses = courseProgresses;
    }

    /**
     * Get the grades for the current course
     * @param course The current course that the user is taking
     * @return An array list of the courses grades
     */
    public ArrayList<Double> getGrades(Course course) {
        //find the course by uuid a]get return that course s grades 
        String id = course.getID();
        for(int i=0; i<courseProgresses.size(); i++){
            ArrayList<Student> students = courseProgresses.get(i).getCourse().getStudents();
            for(int j=0;j<students.size();j++) {
                String IDthis = students.get(j).getID();
                if(IDthis.equalsIgnoreCase(id)){
                    return courseProgresses.get(i).getGrades();
                }
            }
        }
        return null;
    }

    /**
     * Write the certificate once user completes a course
     * @param course The course the user has finished
     */
    public void writeCertificate(Course course){
        CourseProgress progress = getCourseProgress(course);
        double grade = progress.getGrade();
        LMSFileWriter.writeCourseCertificate(course.getTitle(), grade, firstName, lastName);
    }

    /**
     * Gets the current course progress by course title
     * @param title The title of the course
     * @return The course progress for that course
     */
    public CourseProgress getCourseProgress(String title){
        for(CourseProgress course : this.courseProgresses){
            if(course.getCourse().getTitle().equalsIgnoreCase(title)){
                return course;
            }
        }
        return null;
    }

    /**
     * Gets the course progress from the course
     * @param course The course the user is in
     * @return The course progress for the course
     */
    public CourseProgress getCourseProgress(Course course){
        if(!isEnrolled(course)){
            this.courseProgresses.add(new CourseProgress(course));
        }
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().getTitle().equals(course.getTitle())){
                return progress;
            }
        }
        return null;
    }

    /**
     * Checks if the current user is enrolled in the course
     * @param course The course the user is checking
     * @return The boolean if the user is enrolled or not
     */
    public boolean isEnrolled(Course course){
        boolean result = false;
        for (CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().getTitle().equals(course.getTitle())){
                result = true;
            }
        }
        return result;
    }
    
    /**
     * abstract method for make course
     * @param topics
     * @param title
     * @param description
     * @param difficulty
     */
    public abstract void makeCourse(ArrayList<Topic> topics, String title, String description, int difficulty);
    /**
     * abstract method for displayCreatedCourses
     * @return returns created courses if user is author
     */
    public abstract String displayCreatedCourses();
    /**
     * abstract method for get Created courses
     * @return returns arraylist of created courses if user is author
     */
    public abstract ArrayList<Course> getCreatedCourses();
    
    /**
     * Gets the courseprogress for the current user
     * @return An ArrayList of courseprogresses
     */
    public ArrayList<CourseProgress> getCourseProgresses() {
        return this.courseProgresses;
    }

    /**
     * Gets the users username
     * @return A string of the users username
     */
    public String getUsername() {
        if(username == null)
            return null;
        else
            return this.username;
    }

    /**
     * Gets the users id
     * @return A string of the users id
     */
    public String getID() {
        if(id == null)
            return null;
        else
            return this.id.toString();
    }

    /**
     * Gets the users first name
     * @return A string of the users first name
     */
    public String getFirstName() {
        if(firstName == null)
            return null;
        else
            return this.firstName;
    }

    /**
     * Get the users last name
     * @return A string of the users last name
     */
    public String getLastName() {
        if(lastName == null)
            return null;
        else
            return this.lastName;
    }

    /**
     * Get the users password
     * @return A string of the users password
     */
    public String getPassword() {
        if(password == null)
            return null;
        else
            return this.password;
    }

    /**
     * Enroll the user in a course
     * @param course The course the user will enroll in
     */
    public void enrollCourse(Course course){  
        this.addCourseProgress(course);
    }

    /**
     * Get the users email
     * @return A string of the users email
     */
    public String getEmail() {
        if(email == null)
            return null;
        else
        return this.email;
    }

    /**
     * Prints the user to string
     * @return The user as a string
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
        result += "Courses: ";
        for (CourseProgress courseProgress : courseProgresses){
            result += courseProgress.toString()+", ";
        }
        result += "\n";
        return result;
    }
    
    /**
     * Get the current courses the user is enrolled in
     * @return A list of courses the user is in
     */
    public ArrayList<Course> getCurrentCourses() {

        ArrayList<Course> currentCourses = new ArrayList<Course>();
        for (CourseProgress courseProgress : courseProgresses) {
            
            currentCourses.add(courseProgress.getCourse());

        }

        return currentCourses;

    }

    /**
     * Returns whether the course is complete or not
     * @param course The course the user watns to check
     * @return A boolean representing whether the course was finished
     */
    public boolean courseComplete(Course course){
        boolean result = false;
        int position = 0;
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().equals(course)){
                break;
            }
            position++;
        }
        if(this.courseProgresses.get(position).getGrades().size() == course.getTopics().size()){
            result = true;
        }
        return result;
    }

    /**
     * Calculates the students grade for the course
     * @param course The course the user wants to get the grade for
     * @return A double representig
     */
    public double calcGrade(Course course){
        double result = 0.0;
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().getTitle().equals(course.getTitle())){
                result = progress.getGrade();
            }
        }
        return result;
    }
    /**
     * method to update the arraylist of grades for a course
     * @param course
     * @param grade
     */
    public void updateGrades(Course course, double grade){
        if(!isEnrolled(course)){
            this.courseProgresses.add(new CourseProgress(course));
        }
        for(CourseProgress progress : this.courseProgresses){
            if(progress.getCourse().getTitle().equals(course.getTitle())){
                progress.addGrade(grade);
            }
        }
    }
    /**
     * method to get a string of all the currently enrolled courses
     * @return string of all the currently enrolled courses
     */
    public String currentCoursesToString(){
        String result = "";
        int position = 1;
        for(CourseProgress course : courseProgresses){
            result += Integer.toString(position)+". "+course.getCourse().getTitle()+"\n";
            position++;
        }
        return result;
    }
}


