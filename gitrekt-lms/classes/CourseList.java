package classes;
import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    /**
    Constructs a new CourseList object by loading the courses from the data source.
    */
    private CourseList(){
        courses = DataLoader.getCourses();
    }

    /**
    Returns the singleton instance of the CourseList.
    If no instance exists, creates a new instance and returns it.
    @return the singleton instance of the CourseList
    */
    public static CourseList getInstanceCourseList(){
        if(courseList == null){
            //createnew cousre list
            courseList = new CourseList();
        }
        return courseList;
    }

    /**
    Adds a new course to the course list with the given parameters.
    @param topics - the list of topics for the course
    @param title - the title of the course
    @param description - the description of the course
    @param difficulty - the difficulty level of the course
    @param authorID - the ID of the author of the course
    */
    public void addCourse(Course course){
        courses.add(course);
    }

    /**
    Returns the course with the given UUID.
    @param uuid - the UUID of the course to be retrieved
    @return the course with the given UUID, or null if no course with that UUID exists in the list.
    */
    public Course getCourseByUUID(UUID uuid){
        for(int i=0; i<courses.size(); i++){
            if(courses.get(i).getID().equalsIgnoreCase(uuid.toString())){
                return courses.get(i);
            }
        }
        return null;
    }
    /**
     * returns the course based on what title you enter
     * @param title
     * @return returns the course based on what title you enter
     */
    public Course getCourseByTitle(String title){
        for(int i=0; i<courses.size(); i++){
            if(courses.get(i).getTitle().equalsIgnoreCase(title)){
                return courses.get(i);
            }
        }
        return null;
    }

    /**
    Returns the list of courses.
    @return the list of courses
    */
    public ArrayList<Course> getCourses(){
        return courses;
    }

    /**
    Saves the courses to the JSON.
    */
    public void saveCourses(){
        DataWriter.saveCourses();
    }

    /**
    Enrolls a User in a Course with the specified title by creating a new CourseProgress object for the Course and adding it to the User's courseProgresses list.
    @param title the title of the Course to enroll in
    @param user the User to enroll in the Course
    */
    public void enrollCourse(String title, User user){
        Course course = getCourseByTitle(title);
        CourseProgress courseProgress = new CourseProgress(course);
        user.courseProgresses.add(courseProgress);
    }

    /**
    Searches for Courses with titles that contain the specified search string and returns an ArrayList of matching Course objects.
    @param title the search string to match Course titles against
    @return an ArrayList of Course objects that match the search string, or null if no matches were found
    */
    public ArrayList<Course> searchCourses(String title){
        ArrayList<Course> results = new ArrayList<Course>();
        ArrayList<Course> courses = getCourses();
        title = title.toLowerCase();
        for (Course course : courses){
            String courseTitle = course.getTitle().toLowerCase();
            if(courseTitle.contains(title)){
                results.add(course);
            }
        }
        if(results.size() == 0){
        return null;
        }
        return results;
    }

    /**
    Generates a string containing the titles of all the Courses in the system, numbered in order.
    @return a string containing the titles of all the Courses in the system, numbered in order
    */
    public String displayCourseList(){
    String result = "";
    int index = 1;
    for(Course course : courses){
        result += Integer.toString(index)+". "+course.getTitle()+"\n";
        index ++;
    }
    return result;
    }
}
