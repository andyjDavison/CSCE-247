package tests;

package tests;
import classes.*;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {

    private static UserList list = UserList.getInstanceUserList();
    private static ArrayList<User> users = list.getUsers();
    private static CourseList list2 = CourseList.getInstanceCourseList();
    private static ArrayList<Course> courses = list2.getCourses();

    @BeforeEach
    public void setup() {
        users.clear();
        courses.clear();
        users.add(null);
        users.add(new Student(null, null, null, null, null));
        users.add(new Author(null, null, null, null, null));
        users.add(new Student(UUID.fromString("639c95e5-aa4b-4cec-92b9-aff471b4103b"), new ArrayList<>(), null, "lastname", "email", "username", "password"));
        users.add(new Student(UUID.fromString("639c95e5-aa4b-4cec-92b9-aff471b4103b"), new ArrayList<>(), "firstname", null, "email", "username", "password"));
        users.add(new Student(null, new ArrayList<>(), "firstname", "lastname", "email", "username", "password"));

        courses.add(new Course(null,"", Difficulty.BEGINNER, new ArrayList<>(), UUID.fromString("4e3a6bab-50e0-49cb-b174-d4adb96cf4e9")));
        courses.add(new Course("", null, Difficulty.BEGINNER, new ArrayList<>(), UUID.fromString("4e3a6bab-50e0-49cb-b174-d4adb96cf4e9")));
        courses.add(new Course("", "", Difficulty.BEGINNER, null, UUID.fromString("4e3a6bab-50e0-49cb-b174-d4adb96cf4e9")));
        courses.add(new Course("", "", Difficulty.BEGINNER, null, null));

        //DataWriter.saveUsers();
        //DataWriter.saveCourses();
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstanceUserList().getUsers().clear();
        CourseList.getInstanceCourseList().getCourses().clear();
        DataWriter.saveUsers();
        DataWriter.saveCourses();
    }

    @Test
    public void addNullUser() {
        //users = DataLoader.getUsers();
        assertNull(users);
    }

    @Test
    public void addStudentAllNull() {
        //users = DataLoader.getUsers();
        assertEquals(0, users.size());
    }
    
    @Test
    public void addAuthorAllNull() {
        //users = DataLoader.getUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void addUserNullFirstName() {
        //users = DataLoader.getUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void addUserNullLastName() {
        assertEquals(0, users.size());
    }

    @Test
    public void addUserNullID() {
        assertEquals(0, users.size());
    }

    @Test
    public void addCourseNullTitle() {
        assertEquals(0, courses.size());
    }

    @Test
    public void addCourseNullDescription() {
        assertEquals(0, courses.size());
    }

    @Test
    public void addCourseNullTopics() {
        assertEquals(0, courses.size());
    }

    @Test
    public void addCourseNullAuthorID() {
        assertEquals(0, courses.size());
    }
}
