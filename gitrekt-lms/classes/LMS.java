package classes;
import java.util.ArrayList;
public class LMS {
    private static UserList userList = UserList.getInstanceUserList(); //instance of userList
    private static CourseList courseList = CourseList.getInstanceCourseList(); //instance of course list
    private User currentUser; //user current user
    private Course currentCourse; // course current course

    /**
     * Log in by email method, checks if user is in user list and sets current user
     * @param email
     * @param password
     * @return current user logged in
     */
    public User loginE(String email, String password){
        currentUser = userList.loginE(email, password);
        return currentUser;
    }
    /**
     * Log in by username method, checks if user is in user list and sets current user
     * @param email
     * @param password
     * @return current user logged in
     */
    public User loginU(String username, String password){
        currentUser = userList.loginU(username, password);
        return currentUser;
    }
    /**
     * logout method, saves the users and courses to JSON
     */
    public void logout(){
        userList.saveUsers();
        courseList.saveCourses();
    }
    /**
     * Signup method to create new user
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param type
     * @return the current user signed up
     */
    public User signUp(String firstName, String lastName, String username, String password, String email, int type){
        currentUser = userList.signUp(firstName, lastName, username, password, email, type);
        return currentUser;
    }
    /** 
     * Enroll in course method, adds course to users courseProgresses
     * @param title
     */
    public void enrollCourse(String title){
        //courseList.enrollCourse(title, currentUser);
        //courseList.getCourseByTitle(title)//totdoaddStudent(currentUser);
        currentUser.enrollCourse(courseList.getCourseByTitle(title));
    }
    /**
     * returns the course progress for a certain course 
     * @param title
     * @return returns the course progress for a certain course 
     */
    public CourseProgress getCourseProgress(String title){
        CourseProgress courseProgress = currentUser.getCourseProgress(title);
        return courseProgress;
    }
    /**
     * calls search course method and returns arraylist of search results
     * @param title
     * @return returns arraylist of search results
     */
    public ArrayList<Course> searchCourses(String title){
        return courseList.searchCourses(title);
    }
    /**
     * returns a course from the course list by title
     * @param title
     * @return returns a course from the course list
     */
    public Course getCourseByTitle(String title){
        return courseList.getCourseByTitle(title);
    }
    /**
     * checks if student is enrolled in the course
     * @param course
     * @return true if the student is enrolled, false if they are not
     */
    public boolean isEnrolled(Course course){
        return currentUser.isEnrolled(course);
    }
    /**
     * displays list of all courses in the system.
     * @return string of all courses in the system
     */
    public String displayCourseList(){
        return courseList.displayCourseList();
    }
    /**
     * getCurrentCourses method
     * @return returns an arraylist of all of the users currently enrolled courses
     */
    public ArrayList<Course> getCurrentCourses(){
        return currentUser.getCurrentCourses();
    }
    /**
     * updates the users grades for a course
     * @param course
     * @param grade
     */
    public void updateGrades(Course course, double grade){
        currentUser.updateGrades(course, grade);
    }
    /**
     * displays all the courses an author has created
     * @return a string of the list of all the courses an author has created
     */
    public String displayCreatedCourses(){
        return currentUser.displayCreatedCourses();
    }
    /**
     * getCreatedCourses method
     * @return arraylist of author's created courses
     */
    public ArrayList<Course> getCreatedCourses(){
        return currentUser.getCreatedCourses();
    }
    /**
     * displays string of topics for a course
     * @param course
     * @return string of topics for a course
     */
    public String displayTopics(Course course){
        return course.displayTopics();
    }
    /**
     * returns arraylist of topics for a course
     * @param course
     * @return arraylist of topics for a course
     */
    public ArrayList<Topic> getTopics(Course course){
        return course.getTopics();
    }
    /**
     * displays string of subtopics for topic
     * @param topic
     * @return string of subtopics for topic
     */
    public String displaySubtopics(Topic topic){
        return topic.displaySubtopics();
    }
    /**
     * returns topics arraylist of subtopics
     * @param topic
     * @return returns arraylist of subtopics for a topic
     */
    public ArrayList<Subtopic> getSubtopics(Topic topic){
        return topic.getSubTop();
    }
    /**
     * displays a topics quiz
     * @param topic
     * @return String of a topics quiz
     */
    public String displayQuiz(Topic topic){
        return topic.displayQuiz();
    }
    /**
     * returns quiz for a topic
     * @param topic
     * @return returns quiz for a topic
     */
    public Quiz getQuiz(Topic topic){
        return topic.getQuiz();
    }
    /**
     * displays all the info for a topic
     * @param topic
     * @return a string of all the info in a topic (Subtopics and Quiz)
     */
    public String displayTopicInfo(Topic topic){
        return topic.displayTopicInfo();
    }
    /**
     * currentCoursesToString method
     * @return returns a string of a list of all the users enrolled courses
     */
    public String currentCoursesToString() {
        return currentUser.currentCoursesToString();
    }
    /**
     * method to check if course is complete
     * @param course
     * @return true if user completed course, false if not
     */
    public boolean isCompleted(Course course){
        return currentUser.getCourseProgress(course.getTitle()).isCompleted(course);
    }
    /**
     * get course list (list of courses)
     * @return returns arraylist of all courses in system
     */
    public ArrayList<Course> getCourseList(){
        return courseList.getCourses();
    }
    /**
     * displays grades for each topic for a course
     * @param course
     * @return String list of grades for each topic in a course
     */
    public String displayTopicGrades(Course course){
        return currentUser.getCourseProgress(course.getTitle()).displayTopicGrades();
    }
    /**
     * method to add subtopic to a course
     * @param topic
     * @param subtopic
     */
    public void addSubtopic(Topic topic, Subtopic subtopic){
        topic.addSubtopic(subtopic);
        courseList.saveCourses();
    }
    /**
     * method to add question to a course's quiz
     * @param topic
     * @param question
     */
    public void addQuestion(Topic topic, Question question){
        topic.getQuiz().addQuestion(question);
        courseList.saveCourses();
    }
    /**
     * method to make/write a new course
     * @param topics
     * @param title
     * @param description
     * @param difficulty
     */
    public void makeCourse(ArrayList<Topic> topics, String title, String description, int difficulty){
        currentUser.makeCourse(topics, title, description, difficulty);
    }
    /**
     * checks if course is complete
     * @param course
     * @return true if currentUser completed course, false if not
     */
    public boolean courseComplete(Course course){
        return currentUser.courseComplete(course);
    }
    /**
     * method to print all the info in a topic to a file
     * @param topic
     */
    public void printToFileTopic(Topic topic) {
        topic.printToFileTopic();;
    }
    /**
     * prints a completion certificate for a course to a file
     * @param course
     */
    public void printCertificate(Course course){
        currentUser.writeCertificate(course);
    }
    /**
     * get current user method
     * @return returns the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }
}
