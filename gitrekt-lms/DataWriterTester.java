

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.*;

public class DataWriterTester {
    private UserList userList = UserList.getInstanceUserList();
    private ArrayList<User> users = userList.getUsers();
    private CourseList courseList = CourseList.getInstanceCourseList();
    private ArrayList<Course> courses = courseList.getCourses();
    
    @BeforeEach
    public void setup(){
        UserList.getInstanceUserList().getUsers().clear();
        DataWriter.saveUsers();
        CourseList.getInstanceCourseList().getCourses().clear();
        DataWriter.saveCourses();
    }

    @AfterEach
    public void tearDown(){
        UserList.getInstanceUserList().getUsers().clear();
        DataWriter.saveUsers();
        CourseList.getInstanceCourseList().getCourses().clear();
        DataWriter.saveCourses();
    }
    
    @Test
    void testWritingEmptyUsers(){
        users = DataLoader.getUsers();
        assertEquals(0, users.size());
    }

    @Test
    void testWritingEmptyCourses(){
        courses = DataLoader.getCourses();
        assertEquals(0, courses.size());
    }

    @Test
    void testWritingOneStudent(){
        users.add(new Student("bob","jon","eamil","userName","password")); 
        DataWriter.saveUsers();
        assertEquals("bob", DataLoader.getUsers().get(0).getFirstName()); 
    }

    @Test
    void testWritingOneAuthor(){
        users.add(new Author("jon","long","eamil","userName","password")); 
        DataWriter.saveUsers();
        assertEquals("jon", DataLoader.getUsers().get(0).getFirstName()); 
    }

    @Test
    void testWritingOneCourse(){
        courses.add(new Course("testcourse", "test", null, null, null));
        DataWriter.saveCourses();
        assertEquals("testcourse", DataLoader.getCourses().get(0).getTitle());         
    }

    @Test
    void testWriting3Students(){
        users.add(new Student("bob","jon","eamil","userName","password")); 
        users.add(new Student("hobs","tokin","eamil","userName","password"));
        users.add(new Student("andrew","longson","email@good.com","userName","password"));
        DataWriter.saveUsers();
        assertEquals("andrew", DataLoader.getUsers().get(2).getFirstName());

    }

    @Test
    void testWriting3Author(){
        users.add(new Author("jack","cokistock","eamil","userName","password")); 
        users.add(new Author("mac","liken","eamil","userName","password"));
        users.add(new Author("thomas","longson","email@good.com","userName","password"));
        DataWriter.saveUsers();
        assertEquals("thomas", DataLoader.getUsers().get(2).getFirstName());

    }

    @Test
    void testWritingNullAuthor(){
        users.add(new Author(null,null,null,null,null)); 
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getFirstName());

    }

    @Test
    void testWritingNullStudent(){
        users.add(new Student(null,null,null,null,null)); 
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers());
    }

    @Test
    void testWritingNUllCourse(){
        courses.add(new Course(null, null, null, null, null));
        DataWriter.saveCourses();
        assertEquals(null, DataLoader.getCourses());

    }







}
