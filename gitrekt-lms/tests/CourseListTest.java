package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.*;
import java.util.UUID;
public class CourseListTest {
   
    private UserList userList =  UserList.getInstanceUserList();
    private CourseList courseList = CourseList.getInstanceCourseList();
    private Difficulty difficulty = Difficulty.INTERMEDIATE;
    private ArrayList<Topic> topics = new ArrayList<Topic>();
    private UUID authorID = UUID.randomUUID();;

    

    @BeforeEach
    public void setup() {
        userList.getUsers().clear();
        userList.addStudent("Jane", "Shmoe", "jane@gmail.com", "jane", "lovJoe");
        DataWriter.saveUsers();
        courseList.getCourses().clear();
        Course newCourse1 = new Course("Java 1", "Java Course", difficulty, topics, null);
        Course newCourse2 = new Course("Java Basics", "Java Course", difficulty, topics, null);
        courseList.addCourse(newCourse1);
        courseList.addCourse(newCourse2);
        DataWriter.saveCourses();

    }

    @AfterEach
    public void tearDown() {
        UserList.getInstanceUserList().getUsers().clear();
        DataWriter.saveUsers();
        CourseList.getInstanceCourseList().getCourses().clear();
        DataWriter.saveCourses();

    }

    @Test
    public void testing() {

        assertTrue(true);
    }

    /*CourseList
- enrollCourseTitleNull
- enrollCourseUserNull
- enrollCourseCourseProgressNull
- searchCourseTitleNull
- searchCourseTitleEmpty
- displayCourseListNull
- displayCourseListEmpty
*/

  
  @Test
  public void testGetInstanceCourseList() {
    CourseList courseList1 = CourseList.getInstanceCourseList();
    CourseList courseList2 = CourseList.getInstanceCourseList();
    assertSame(courseList1, courseList2);
  }
  
  @Test
  public void testAddCourse() {
    CourseList courseList = CourseList.getInstanceCourseList();
    Course newCourse = new Course("Java 2", "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse);
    assertTrue(courseList.getCourses().contains(newCourse));
  }

  @Test
  public void testAddNullCourse() {
    CourseList courseList = CourseList.getInstanceCourseList();
    Course newCourse = null;
    courseList.addCourse(newCourse);
    assertFalse(courseList.getCourses().contains(newCourse));
  }

  @Test
  public void testAddCourseNullTitle() {
    CourseList courseList = CourseList.getInstanceCourseList();
    int initialSize = courseList.getCourses().size();
    Course newCourse = new Course(null, "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse);;
    assertFalse(courseList.getCourses().contains(newCourse));
  }

  @Test
  public void testAddDuplicateCourse() {
    CourseList courseList = CourseList.getInstanceCourseList();
    Course newCourse = new Course("Python", "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse);
    Course newCourse1 = new Course("Python", "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse1);
    assertFalse(courseList.getCourses().contains(newCourse) && courseList.getCourses().contains(newCourse1));
  }

  @Test
  public void testAddCourseNullDescription() {
    CourseList courseList = CourseList.getInstanceCourseList();
    int initialSize = courseList.getCourses().size();
    Course newCourse = new Course("Java", null, difficulty, topics, null);
    courseList.addCourse(newCourse);;
    assertFalse(courseList.getCourses().contains(newCourse));
  }

  @Test
  public void testAddCourseNullDifficulty() {
    CourseList courseList = CourseList.getInstanceCourseList();
    int initialSize = courseList.getCourses().size();
    Course newCourse = new Course("Java", "Java Course", null, topics, null);
    courseList.addCourse(newCourse);;
    assertFalse(courseList.getCourses().contains(newCourse));
  }

  @Test
  public void testAddCourseNullTopics() {
    CourseList courseList = CourseList.getInstanceCourseList();
    int initialSize = courseList.getCourses().size();
    topics = null;
    Course newCourse = new Course("Java", "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse);;
    assertFalse(courseList.getCourses().contains(newCourse));
  }

  @Test
  public void testAddCourseNullAuthor() {
    CourseList courseList = CourseList.getInstanceCourseList();
    topics = null;
    Course newCourse = new Course("Java", "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse);;
    assertFalse(courseList.getCourses().contains(newCourse));
  }
  
  @Test
  public void testGetCourseByUUID() {
    CourseList courseList = CourseList.getInstanceCourseList();
    
    Course newCourse = new Course("Java", "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse);
    UUID uuid = newCourse.getUuid();
    Course retrievedCourse = courseList.getCourseByUUID(uuid);
    assertNotNull(retrievedCourse);
    assertEquals(uuid.toString(), retrievedCourse.getID());
  }
  
  @Test
  public void testGetCourseByTitle() {
    CourseList courseList = CourseList.getInstanceCourseList();
    ArrayList<Topic> topics = new ArrayList<Topic>();
    Course newCourse = new Course("Java", "Java Course", difficulty, topics, null);
    String title = "Java";
    courseList.addCourse(newCourse);
    Course retrievedCourse = courseList.getCourseByTitle(title);
    assertNotNull(retrievedCourse);
    assertEquals(title, retrievedCourse.getTitle());
  }

  @Test
  public void testGetCourseByNullTitle() {
    Course retrievedCourse = courseList.getCourseByTitle(null);
    assertNull(retrievedCourse);
  }

  @Test
  public void testGetCourseByEmptyTitle() {
    Course retrievedCourse = courseList.getCourseByTitle("");
    assertNull(retrievedCourse);
  }
  
  @Test
  public void testEnrollCourse() {
    CourseList courseList = CourseList.getInstanceCourseList();
    ArrayList<Topic> topics = new ArrayList<Topic>();
    User user = new Student("Cal", "Hribar", "email", "cj", "password");
    Course newCourse = new Course("HTML", "HTML Course", difficulty, topics, authorID);

    String title = "HTML";

    courseList.addCourse(newCourse);
    courseList.enrollCourse(title, user);
    assertTrue(user.getCourseProgresses().get(0).getCourse().equals(newCourse));
  }

  @Test
  public void testEnrollNullCourse() {
    CourseList courseList = CourseList.getInstanceCourseList();
    ArrayList<Topic> topics = new ArrayList<Topic>();
    User user = new Student("Cal", "Hribar", "email", "cj", "password");
    Course newCourse = null;

    String title = null;
    int initialSize = user.getCourseProgresses().size();
    courseList.enrollCourse(title, user);
    assertNotEquals(initialSize, user.getCourseProgresses().size());
  }

  @Test
  public void testEnrollCourseEmptyTitle() {
    CourseList courseList = CourseList.getInstanceCourseList();
    ArrayList<Topic> topics = new ArrayList<Topic>();
    User user = new Student("Cal", "Hribar", "email", "cj", "password");
    String title = "";
    courseList.enrollCourse(title, user);
    assertTrue(user.getCourseProgresses().get(0).getCourse() == null);
  }


  
  
  @Test
  public void testSearchCourses() {
    CourseList courseList = CourseList.getInstanceCourseList();
    courseList.getCourses().clear();
    ArrayList<Topic> topics = new ArrayList<Topic>();
    Course newCourse1 = new Course("Java 1", "Java Course", difficulty, topics, null);

    courseList.addCourse(newCourse1);
    Course newCourse2 = new Course("Java 2", "Java Course", difficulty, topics, null);
    courseList.addCourse(newCourse2);
    Course newCourse3 = new Course("HTML", "HTML Course", difficulty, topics, null);

    courseList.addCourse(newCourse2);
    courseList.addCourse(newCourse3);
    ArrayList<Course> searchResults = courseList.searchCourses("Java");
    assertNotNull(searchResults);
    assertEquals(2, searchResults.size());
  }

  @Test
  public void testSearchNullCourses() {
    CourseList courseList = CourseList.getInstanceCourseList();
    courseList.getCourses().clear();
    ArrayList<Topic> topics = new ArrayList<Topic>();
    Course newCourse1 = new Course("Java 1", "Java Course", difficulty, topics, null);
    //newCourse1.setTitle("Java Programming 1");
    courseList.addCourse(newCourse1);
    Course newCourse2 = null;
    //newCourse2.setTitle("Java Programming 2");
    courseList.addCourse(newCourse2);
    ArrayList<Course> searchResults = courseList.searchCourses("Java");
    assertNotNull(searchResults);
    assertEquals(1, searchResults.size());
  }
  
  @Test
  public void testDisplayCourseList() {
    CourseList courseList = CourseList.getInstanceCourseList();
    ArrayList<Topic> topics = new ArrayList<Topic>();
    courseList.getCourses().clear();
    Course newCourse1 = new Course("Java 1", "Java Course", difficulty, topics, null);
    //newCourse1.setTitle("Java Programming 1");
    courseList.addCourse(newCourse1);
    Course newCourse2 = new Course("Java 2", "Java Course", difficulty, topics, null);
    //newCourse2.setTitle("Java Programming 2");
    courseList.addCourse(newCourse2);
    String expectedOutput = "1. Java 1\n2. Java 2\n";
    assertEquals(expectedOutput, courseList.displayCourseList());
  }

  @Test
  public void testDisplayEmptyCourseList() {
    CourseList courseList = CourseList.getInstanceCourseList();
    courseList.getCourses().clear();
    String expectedOutput = "No Courses";
    assertEquals(expectedOutput, courseList.displayCourseList());
  }
}


