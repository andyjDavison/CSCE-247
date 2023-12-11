package classes;
import java.util.ArrayList;
import java.util.UUID;

/**
 * A UserList class that gets the current instance of the list
 */
public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    /**
     * Sets the users ArrayList to the getUsers method
     */
    private UserList(){
        users = DataLoader.getUsers();
    }

    /**
     * Gets the user by its userID
     * @param id A UUID that represents the users id
     * @return A user
     */
    public User getUserByUUID(UUID id){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getID().equalsIgnoreCase(id.toString())){
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the user by its email
     * @param email A string that represents the users email
     * @return A user
     */
    public User getUserByEmail(String email){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getEmail().equalsIgnoreCase(email)){
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the user by its username
     * @param username A string that represents the users username
     * @return A user
     */
    public User getUserByUsername(String username){
        for (int i=0; i<users.size(); i++){
            if(users.get(i).getUsername().equalsIgnoreCase(username)){
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the instance of the UserList if there is one already in mem
     * @return The instance of the UserList
     */
    public static UserList getInstanceUserList(){
        if(userList == null){
            //creating new users list
            userList = new UserList();
        }
        return userList;
    }

    /**
     * Adds a student to the user list
     * @param firstName String representing the students firstname
     * @param lastName String representing the students lastname
     * @param email String representing the students email
     * @param username String representing the students username
     * @param password String representing the students password
     */
    public void addStudent(String firstName, String lastName, String email, String username, String password){
        users.add(new Student(firstName, lastName, email, username, password));
    }

    /**
     * Adds an author to the user list
     * @param firstName String representing the authors firstname 
     * @param lastName String representing the authors lastname
     * @param email String representing the authors email
     * @param username String representing the authors username
     * @param password String representing the authors password
     */
    public void addAuthor(String firstName, String lastName, String email, String username, String password){
        users.add(new Author(firstName, lastName, email, username, password));
    }

    /**
     * Gets the users
     * @return An ArrayList with all the current users
     */
    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Saves the users to the users.json
     */
    public void saveUsers(){
        DataWriter.saveUsers();
    }

    /**
     * Logs a user in with email and password
     * @param email String representing the users email
     * @param password String representing the users password
     * @return A user
     */
    public User loginE(String email, String password){
        User user = getUserByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    /**
     * Logs a user in with username and password
     * @param username String representing the users usersname
     * @param password String representing the users password
     * @return
     */
    public User loginU(String username, String password){
        User user = getUserByUsername(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    /**
     * Signs a new user up
     * @param firstName String representing the users first name
     * @param lastName String representing the users last name
     * @param username String representing the users username
     * @param password String representing the users password
     * @param email String representing the users email
     * @param type Int representing the users type
     * @return A user
     */
    public User signUp(String firstName, String lastName, String username, String password, String email, int type){
        if(type == 0){
            Student user = new Student(firstName, lastName, email, username, password);
            addStudent(firstName, lastName, email, username, password);
            DataWriter.saveUsers();
            return user;
        } else if (type == 1){
            Author user = new Author(firstName, lastName, email, username, password);
            addAuthor(firstName, lastName, email, username, password);
            DataWriter.saveUsers();
            return user;
        } else {
            return null;
        }
    }
}
