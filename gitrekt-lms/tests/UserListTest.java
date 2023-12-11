package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.*;

public class UserListTest {
    private UserList userList = UserList.getInstanceUserList();
    private ArrayList<User> users = userList.getUsers();

    @BeforeEach
	public void setup() {
        
		userList.addStudent("Robert", "Smith", "rsmith@gmail.com", "rsmitty", "password");
		userList.addStudent("Will", "Ross", "wross@gmail.com", "wross", "12345");
		DataWriter.saveUsers();
	}

}
