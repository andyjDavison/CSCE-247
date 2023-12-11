package classes;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class LMSUI {

    private static final String WELCOME_MESSAGE = "\n\nWelcome to our Coding LMS :)";
    private String[] loginMenu = {"Login with Username", "Login with Email", "Create Account", "Quit"};
    private String[] userTypeMenu = {"Student", "Author"};
    private String[] homeMenu = {"Display Current Courses","Search Courses", "Display All Courses", "Create Course", "Edit Course", "View Profile", "Billing Page", "Log Out"};
    private String[] continueCourseMenu = {"Continue Course", "View Grades", "View Topics", "Exit to Home"};
    private String[] completedCourseMenu = {"View Grades", "Print Certificate", "View Topics","Exit to Home"};
    private String[] newCourseMenu = {"Enroll in Course", "View Topics", "Exit to Home"}; 
    private String[] viewTopicsMenu = {"Print a Topic to File", "Exit"};
    private String[] courseListMenu = {"Select Course", "Exit to Home"};
    private String[] editTopicMenu = {"Add Subtopic", "Add Question", "Exit to Home"};
    private String[] topicMenu = {"Quiz", "Display Comments", "Next Topic", "Exit to Home"};
    private String[] commentMenu = {"Comment", "View Comment Replies", "Exit"};
    private String[] basicMenu = {"Exit"};
    private String[] profileMenu = {"Exit to Home"};
    private String[] billingMenu = {"Exit to Home"};
    private String[] subtopicMenu = {"Next", "Previous", "Back to Topic"};
    private String[] difficultyMenu = {"Beginner", "Intermediate", "Advanced"};
    private String[] endOfSubTopsMenu = {"Previous", "Back to Topic"};
    private String[] firstSubTopsMenu = {"Next", "Back to Topic"};
    private String[] oneSubTopMenu = {"Back to Topic"}; 
    private Scanner scanner;
    private LMS lms;

    /**
     * LMSUI constructor
     * initialized the scanner for user input
     */
    LMSUI() {
        scanner = new Scanner(System.in);
        lms = new LMS();
    }

    /**
     * Starts the UI
     * login menu
     * validates user
     */
    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while(true) {
            
            displayMenu(loginMenu, "LOG IN OPTIONS");

            int userCommand;
			
			if ((userCommand = menuCommandValidation(loginMenu)) == -1) continue;

            User user = null;
            
            //have switch return an user
            //if it does, continue to next while loop
            //if it doesn't keep them in login while loop
            
            boolean quit = false;

            switch(userCommand) {
                case(0):
                    user = loginU();
                    clearScreen();
                    break;
                case(1):
                    user = loginE();
                    clearScreen();
                    break;
                case(2):
                    user = createAccount();
                    clearScreen();
                    break;
                case(3):
                    quit = true;
                    clearScreen();
                    break;
            }
            
            if (quit == true) break;
            if (user == null) {
                System.out.println("Invalid Information");
                continue;
            }

            homeMenuInteraction(user);
            
        }
        System.out.println("Goodbye, have a good day.");
    }

    /**
     * Navigation through home menu
     * @param user current user
     */
    public void homeMenuInteraction(User user) {
        
        boolean logout = false;
        int userCommand;

        while (true) {
            displayMenu(homeMenu, "HOME PAGE OPTIONS");

            if ((userCommand = menuCommandValidation(homeMenu)) == -1) continue;

            switch (userCommand) {
                case(0):
                    displayCurrentCourses();
                    clearScreen();
                    break;
                case(1):
                    searchCourses();
                    clearScreen();
                    break;
                case(2):
                    displayAllCourses();
                    clearScreen();
                    break;
                case(3):
                    createCourse();
                    clearScreen();
                    break;
                case(4):
                    editCourse();
                    clearScreen();
                    break;
                case(5):
                    viewProfile(user);
                    clearScreen();
                    break;
                case(6):
                    viewBilling();
                    clearScreen();
                    break;
                case(7):
                    logout = true;
                    logOut();
                    break;
            }
            if (logout == true) break;
        }

    }

    /**
     * loops though and displays menus
     * @param menu menu to be displayed
     * @param pageName menu header
     */
    private void displayMenu(String[] menu, String pageName) {
        System.out.println("\n****** " + pageName + " ******");
        for (int i=0; i < menu.length; i++) {
            System.out.println((i+1) + ". " + menu[i]);
        }
        System.out.println("\n");
    }

    /**
     * gets user input for menus
     * @param numCommands number of possible commands for the menu
     * @return int command or -1 if invalid
     */
    private int getUserCommand(int numCommands) {
		
        while (true) {
            System.out.print("What would you like to do?: ");
            
            String input = scanner.nextLine();
            try {
                int command = Integer.parseInt(input) - 1;
                if(command >= 0 && command <= numCommands -1)
                    return command;
            }
            catch (Exception e) {
                System.out.println("Please enter an integer");
                continue;
            }
            return -1;
        }

	}

    /**
     * gets user integer
     * @param prompt input prompt
     * @return user integer
     */
    private int getUserInt(String prompt) {

        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= 0) 
                    return number;
            }
            catch (Exception e) {
                System.out.println("Please enter an integer");
                continue;
            }
            return -1;
        }

    }
    /**
     * validates the users menu command
     * @param menu menu to be validated with
     * @return validated command
     */
    private int menuCommandValidation (String[] menu) {
        
        int userCommand = getUserCommand(menu.length);
        
        if(userCommand == -1) {
            System.out.println("Not a valid command");
        }
        return userCommand;
    }

    /**
     * logs the user in with username
     * @return user being logged in
     */
    private User loginU() {
        clearScreen();
        System.out.println("\n-----Loging in-----");        

        String username = getUserString("Username");
        String password = getUserString("Password");

        return lms.loginU(username, password);

    }

    /**
     * logs the user in with email
     * @return user being logged in
     */
    private User loginE() {
        clearScreen();
        System.out.println("\n-----Loging in-----");        

        String email = getUserString("Email");
        String password = getUserString("Password");

        return lms.loginE(email, password);

    }

    /**
     * creates an account with user input
     * @return user that just created an account
     */
    private User createAccount() {
        clearScreen();
        System.out.println("\n-----Signing Up-----");        

        String firstName = getUserString("First Name");
        String lastName = getUserString("Last Name");
        String email = getUserString("Email");
        String username = getUserString("Username");
        String password = getUserString("Password");
       
        displayMenu(userTypeMenu, "ACCOUNT OPTIONS");

        int type = getUserCommand(2);
        
        return lms.signUp(firstName, lastName, username, password, email, type);

    }

    /**
     * gets user string input
     * @param category prompt
     * @return user string
     */
    private String getUserString(String category) {
        
        while(true) {
            System.out.print("Enter " + category + ": ");
			String info = scanner.nextLine().trim();
		
			if(!info.contentEquals("")) return info;
			
			System.out.println("You need to actually enter content");
		}

    }

    /**
     * Displays the current course and a menu of options for navigation
     */
    private void displayCurrentCourses() {
        clearScreen();
        
        boolean quit = false;
        
        System.out.println("\n-----Displaying Current Courses-----");

        ArrayList<Course> currentCourses = lms.getCurrentCourses();
        System.out.println(lms.currentCoursesToString());
        
        while (true) {
        
            displayMenu(courseListMenu, "CURRENT COURSE OPTIONS");

            int userCommand;
            if ((userCommand = menuCommandValidation(courseListMenu)) == -1) continue;

            switch(userCommand) {
                case(0):
                    while (true){
                        userCommand = getUserInt("Which course would you like to select? ") -1;
                        if (userCommand < 0 || userCommand >= currentCourses.size()) continue;
                        break;
                    }
                    String courseChoice = currentCourses.get(userCommand).getTitle();
                    Course course = lms.getCourseByTitle(courseChoice);
                    displayCourseDescription(course);
                    return;
                case(1):
                    quit = true;
                    break;
            }
            if (quit == true) return;

        }
    }

    /**
     * continue the course
     * @param course to continue
     * @param courseProgress the users current course progress
     */
    public void continueCourse(Course course, CourseProgress courseProgress) {
        int numCompleteTopics = courseProgress.numCompletedTopics();
        int numTopics = course.getTopics().size();

        for (int i = numCompleteTopics; i < numTopics; i++) {

            int userCommand;
            boolean continueCourse = false;
            
            Topic currentTopic = course.getTopics().get(i);
            printTopic(currentTopic);
            
            while (true) {

                clearScreen();
                
                System.out.print("\n" + currentTopic.getName() + "\n");
                displayMenu(topicMenu, "TOPIC OPTIONS");
                if ((userCommand = menuCommandValidation(topicMenu)) == -1) continue;

            switch (userCommand) {
                case(0):
                    displayQuiz(course, currentTopic);
                    break;
                case(1):
                    displayComments(currentTopic.getComments());
                    break;
                case(2):
                    if (i == numTopics - 1) {
                        System.out.println("No more topics!");
                        break;
                    }
                    continueCourse = true;
                    break;
                case(3):
                    return;
                
            }
            if (continueCourse == true) break;
        }

        }
    }

    /**
     * displays and navigates the quiz for the topic
     * @param currentCourse the current course
     * @param currentTopic the current topic
     */
    private void displayQuiz(Course currentCourse, Topic currentTopic) {

        System.out.println("\n-----Quiz-----\n");
        Quiz quiz = currentTopic.getQuiz();

        for (int i = 0; i < quiz.getQuizSize(); i++) {

            Question question = quiz.getQuestionAt(i);
            System.out.println("\n" + question.toString());

            int userAnswer;

            while (true) {

                userAnswer = getUserInt("Which answer is correct? ") -1;
                if (userAnswer < 0 || userAnswer >= question.getAns().length) {
                    System.out.println("Invalid");
                    continue;
                }
                break;
            }

            if (question.isCorrect(userAnswer)) {
                System.out.println("\n" + "Correct!");
                
            }
            else {

                System.out.println("\n" + "Wrong!");
                System.out.println("Correct Answer: " + question.getCorrectAns());

            }

        }

        double grade = quiz.getGrade();
        System.out.println("\nYour Grade: " + grade);
        lms.updateGrades(currentCourse, grade);

        while (true) {
            displayMenu(basicMenu, "QUIZ OPTIONS");
            int userCommand;
            if ((userCommand = menuCommandValidation(basicMenu)) == -1) continue;
            break;
            }
    }

    /**
     * prints all of the subtopics in topic and navigates
     * @param topic topic to be printed
     */
    private void printTopic(Topic topic) {

        boolean quit = false;

        while (true) {
            for (int i = 0; i < topic.getSubTop().size(); i++) {
                clearScreen();
                
                System.out.println(topic.getSubTop().get(i).toString());
                
                if (topic.getSubTop().size() == 1) {
                    while (true) {
                        displayMenu(oneSubTopMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(oneSubTopMenu)) == -1) {
                            System.out.println("invalid");
                            continue;
                        }
                        
                        switch(userCommand) {
                            case(0):
                                quit = true;
                                System.out.print("\033[H\033[2J");  //these are my chenges to clear the consle when you go to the quiz if it works we will move it to allother metheds that need it 
                                System.out.flush();  //these are my chenges to clear the consle when you go to the quiz if it works we will move it to allother metheds that need it
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
                else if (i != topic.getSubTop().size() - 1 && i != 0) {
                    while (true) {
                        displayMenu(subtopicMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(subtopicMenu)) == -1) continue;
                        
                        switch(userCommand) {
                            case(0):
                                break;
                            case(1):
                                i -= 2;
                                break;
                            case(2):
                                quit = true;
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
                else if (topic.getSubTop().size() != 1 && i==0) {
                    while (true) {
                        displayMenu(firstSubTopsMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(firstSubTopsMenu)) == -1) continue;
                        
                        switch(userCommand) {
                            case(0):
                                break;
                            case(1):
                                quit = true;
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
                else {
                    while (true) {
                        displayMenu(endOfSubTopsMenu, "SUBTOPIC OPTIONS");

                        int userCommand;

                        if ((userCommand = menuCommandValidation(endOfSubTopsMenu)) == -1) continue;
                        
                        switch(userCommand) {
                            case(0):
                                i -= 2;
                                break;
                            case(1):
                                quit = true;
                                break;
                        }
                        if (quit == true) return;
                        break;
                    }
                }
            }     
        } 
    }

    /**
     * searched the courses
     */
    private void searchCourses() {
        clearScreen();
        System.out.println("\n-----Search Courses-----");
        
        ArrayList<Course> results;
        while (true) {
            String word = getUserString("Keyword or # to Exit");
            if (word.equals("#")) return;
            results = lms.searchCourses(word);
            if(results == null){
                System.out.println("No Match");
                continue;
            }
            break;
        }
        int index = 1;
        for(Course course : results){
            String result = "";
            result += Integer.toString(index)+". "+course.getTitle()+"\n";
            System.out.println(result);
            index++;
        }
        int choice = getUserInt("Enter Course Number: \n");
        displayCourseDescription(results.get(choice-1));
    }

    /**
     * displays the courses and different navigation menus based on course status
     * @param course course to display
     */
    private void displayCourseDescription(Course course){
        clearScreen();
        if(lms.isEnrolled(course)){
            if (lms.isCompleted(course)) {
                while(true){
                    clearScreen();
                    System.out.println(course.toString());
                    displayMenu(completedCourseMenu, "COURSE OPTIONS");
                    int userCommand;
                    if ((userCommand = menuCommandValidation(continueCourseMenu)) == -1) continue;
                    clearScreen();
                    switch(userCommand){
                        case(0):
                            viewGrades(course);
                            break;
                        case(1):
                            printCertificate(course);
                            return;
                        case(2):
                            viewTopics(course);
                            break;
                        case(3):
                            return;
                    }
                }
            }
            else {
                while(true){
                    clearScreen();
                    System.out.println(course.toString());
                    displayMenu(continueCourseMenu, "COURSE OPTIONS");
                    int userCommand;
                    if ((userCommand = menuCommandValidation(continueCourseMenu)) == -1) continue;
                    clearScreen();
                    switch(userCommand){
                        case(0):
                            continueCourse(course, lms.getCourseProgress(course.getTitle()));
                            break;
                        case(1):
                            viewGrades(course);
                            break;
                        case(2):
                            viewTopics(course);
                            break;
                        case(3):
                            return;
                    }
                }
            }
        }
        else {
            while(true){
                clearScreen();
                System.out.println(course.toString());
                displayMenu(newCourseMenu, "COURSE OPTIONS");
                int userCommand;
                if ((userCommand = menuCommandValidation(newCourseMenu)) == -1) continue;
                clearScreen();
                switch(userCommand){
                    case(0):
                        enrollCourse(course);
                        break;
                    case(1):
                        viewTopics(course);
                        break;
                    case(2):
                        return;
                }

            }
        }
    }

    /**
     * enrolls user in a course
     * @param course the course to be enrolled
     */
    public void enrollCourse(Course course) {
        System.out.println("\n-----Enrolling Course-----");
        lms.enrollCourse(course.getTitle());

        continueCourse(course, lms.getCourseProgress(course.getTitle()));

    }

    /**
     * displays all of the courses
     */
    private void displayAllCourses() {
        clearScreen();
        System.out.println("\n-----Displaying All Courses-----");
        
        ArrayList<Course> allCourses = lms.getCourseList();
        System.out.println(lms.displayCourseList()+"\n");

        while (true) {
        
            displayMenu(courseListMenu, "ALL COURSE OPTIONS");

            int userCommand;
            if ((userCommand = menuCommandValidation(courseListMenu)) == -1) continue;

            switch(userCommand) {
                case(0):
                    while (true){
                        userCommand = getUserInt("Which course would you like to select? ") -1;
                        if (userCommand < 0 || userCommand >= allCourses.size()) continue;
                        break;
                    }
                    String courseChoice = allCourses.get(userCommand).getTitle();
                    Course course = lms.getCourseByTitle(courseChoice);
                    displayCourseDescription(course);
                    return;
                case(1):
                    return;
            }

        }

    }

    /**
     * creates a course with user input
     */
    private void createCourse() {
        clearScreen();
        System.out.println("\n-----Creating Course-----");

        String courseName = getUserString("Course Name");

        String courseDescription = getUserString("Course Description");

        int difficulty;
        while (true) {

            displayMenu(difficultyMenu, "DIFFICULTY OPTIONS");

            if ((difficulty = menuCommandValidation(continueCourseMenu)) == -1) continue;
            break;
        }
    
        int topicNum = getUserInt("How many topics will this course have? ");

        ArrayList<Topic> topics = new ArrayList<Topic>();

        for (int i = 0; i < topicNum; i++) {

            String topicName = getUserString("Topic Name #" + (i + 1));

            int subtopicNum = getUserInt("How many subtopics will this topic have? ");

            ArrayList<Subtopic> subtopics = new ArrayList<Subtopic>();

            for (int j = 0; j < subtopicNum; j++) {

                String subtopicName = getUserString("Subtopic Name #" + (j + 1));
                String subtopicInfo = getUserString("Subtopic Information");

                Subtopic subtopic = new Subtopic(subtopicName, subtopicInfo);

                subtopics.add(subtopic);

            }
            
            int questionNum = getUserInt("How many questions will this quiz have? ");

            ArrayList<Question> questions = new ArrayList<Question>();

            for (int k = 0; k < questionNum; k++) {

                String questionContent = getUserString("Question #" + (k + 1));
    
                String answers[] = new String[4];
    
                for (int l = 0; l < 4; l++) {
    
                    String answerContent = getUserString("Answer #" + (l + 1));
                    answers[l] = answerContent;
    
                }

                int correctAnswer = getUserInt("Which Answer Number is Correct: ") - 1;

                Question question = new Question(questionContent, answers, correctAnswer);
                questions.add(question);

            }

            Quiz quiz = new Quiz(questions);

            Topic topic = new Topic(subtopics, topicName, quiz);
            topics.add(topic);

        }

        lms.makeCourse(topics, courseName, courseDescription, difficulty);

    }


    /**
     * edit course, subtopic or question
     */
    public void editCourse() {
        clearScreen();
        System.out.println("\n-----Edit Course-----");
        ArrayList<Course> createdCourses = lms.getCreatedCourses();
        System.out.println(lms.displayCreatedCourses());

        int courseChoice;
        while (true) {

            courseChoice = getUserInt("Which course do you want to edit? ") - 1;
                if (courseChoice < 0 || courseChoice >= createdCourses.size()) {
                    System.out.println("Invalid");
                    continue;
                }
                break;
        }

        Course course = createdCourses.get(courseChoice);

        ArrayList<Topic> topics = course.getTopics();
        System.out.println(lms.displayTopics(course));

        int topicChoice;
        while (true) {

            topicChoice = getUserInt("Which topic do you want to edit? ") - 1;
                if (topicChoice < 0 || topicChoice >= topics.size()) {
                    System.out.println("Invalid");
                    continue;
                }
                break;
        }

        Topic topic = topics.get(topicChoice);
        System.out.println(lms.displayTopicInfo(topic));

        int userCommand;
        while (true) {
        
            displayMenu(editTopicMenu, "ALL COURSE OPTIONS");

            if ((userCommand = menuCommandValidation(editTopicMenu)) == -1) continue;

            switch(userCommand) {
                case(0):
                    String subtopicName = getUserString("Subtopic Name");
                    String subtopicInfo = getUserString("Subtopic Info");
                    Subtopic newSubtopic = new Subtopic(subtopicName, subtopicInfo);
                    lms.addSubtopic(topic, newSubtopic);
                    break;
                case(1):
                    String questionContent = getUserString("Question Content");
        
                    String answers[] = new String[4];
        
                    for (int i = 0; i < 4; i++) {
        
                        String answerContent = getUserString("Answer #" + (i + 1));
        
                        answers[i] = answerContent;
        
                    }

                    int correctAnswer = getUserInt("Which Answer Number is Correct: ") - 1;

                    Question question = new Question(questionContent, answers, correctAnswer);
                    lms.addQuestion(topic, question);
                    break;
                case(2):
                    return;
            }
        }

    }

    /**
     * view user profile
     * @param user user who wants to view their profile
     */
    private void viewProfile(User user) {
        clearScreen();
        System.out.println("\n-----Profile-----");
        System.out.println(user.toString());

        int userCommand;
        while (true) {
            
            displayMenu(profileMenu, "PROFILE OPTIONS");
            
            
           if ((userCommand = menuCommandValidation(profileMenu)) == -1) continue;

            break;
        }
    }

    /**
     * displays billing information
     */
    private void viewBilling() {
        clearScreen();
        System.out.println("\n-----Billing-----");
        System.out.println("Free access to learning resources will be available until the end of 2025");
        
        int userCommand;
        while (true) {
            displayMenu(billingMenu, "BILLING OPTIONS");

            if ((userCommand = menuCommandValidation(billingMenu)) == -1) continue;
            break;
        }
    }

    /**
     * logs the user out
     */
    private void logOut() {
        clearScreen();
        System.out.println("See ya!");
        lms.logout();
    }

    /**
     * Comments on a topic
     * @param topic topic to be commented on
     */
    public void commentTopic(Topic topic){
        addComment(topic.getComments());
    }

    /**
     * adds a comment
     * @param comments array list of comments to be added to
     */
    public void addComment(ArrayList<Comment> comments){
        
            String commentInfo = getUserString("Comment");
            Comment comment = new Comment(commentInfo, lms.getCurrentUser().getUsername(), lms.getCurrentUser().id);

            comments.add(comment);
    }

    /**
     * displays the comments
     * @param comments comments to be displayed
     */
    public void displayComments(ArrayList<Comment> comments){
        //clearScreen();
        String result = "";
        if(comments == null)
            result = "No comments on this thread.";
        else {
            int position = 1;
            for(Comment comment : comments){
                result += Integer.toString(position)+". "+comment.toString()+"\n";
                if (comment.getReplies() != null) 
                    result += "     "+comment.getReplies().size() + " replies" + "\n\n";
                position++;
            }
        }
        System.out.println(result);

        commentInteraction(comments);
    }

    /**
     * interaction of comments
     * @param comments comment section to interact with
     */
    public void commentInteraction(ArrayList<Comment> comments) {
        //clearScreen();
        int userCommand;
        while (true) {
            displayMenu(commentMenu, "COMMENT OPTIONS");
            if ((userCommand = menuCommandValidation(commentMenu)) == -1) continue;
            break;
        }
        int commentChoice;
        switch(userCommand) {
            case(0):
                addComment(comments);
                break;
            case(1):
                if (comments == null) {
                    System.out.println("No comments to comment on");
                    break; 
                } 
                while (true) {

                    commentChoice = getUserInt("Which comment do you want to view replies? ") - 1;
                    if (commentChoice < 0 || commentChoice >= comments.size()) {
                        System.out.println("Invalid");
                        continue;
                    }
                    break;
                }

                displayComments(comments.get(commentChoice).getReplies());
                break;
            case(2):
                return;
                
        }
 
    }

    /**
     * Clears the console screen
     */
    public void clearScreen(){
        System.out.print("\033[H\033[2J");  //clear the consle 
        System.out.flush();  //clear the consle
    }

    /**
     * prints grades for a certain course
     * @param course course to have its grades printed
     */
    public void viewGrades(Course course) {

        clearScreen();
        System.out.println("\n-----Displaying Course Grades-----");
        System.out.println(lms.displayTopicGrades(course));
        int userCommand;
        while (true) {
            displayMenu(basicMenu, "OPTIONS");
            if ((userCommand = menuCommandValidation(basicMenu)) == -1) continue;
            break;
        }
    }

    /**
     * prints certificate for a course
     * @param course course to have certficate of
     */
    public void printCertificate(Course course) {

        System.out.println("\n-----Printing Certificate-----");
        lms.printCertificate(course);
        System.out.println("\n-----Success! Redirecting Home-----");
        try{
            TimeUnit.MILLISECONDS.sleep(2000);
            clearScreen();
        } catch(Exception e){
            System.out.println("Timed Out");
        }
    }


    /**
     * prints topics of course + options
     * @param course course to have its comments printed
     */
    public void viewTopics(Course course) {
        ArrayList<Topic> topics = lms.getTopics(course);
        System.out.println(course.displayTopics());

        int userCommand;
        while (true) {
            displayMenu(viewTopicsMenu, "VIEW TOPIC OPTIONS");
            if ((userCommand = menuCommandValidation(viewTopicsMenu)) == -1) continue;
            break;
        }
        int topicChoice;
        switch(userCommand) {
            case(0):
                
                while (true) {
                    topicChoice = getUserInt("Which topic would you like to print? ") -1;
                    if (topicChoice < 0 || topicChoice >= topics.size()) {
                        System.out.println("Invalid");
                        continue;
                    }
                    break;
                }
                Topic topic = topics.get(topicChoice);
                
                printTopicToFile(topic);
                break;
            case(1):
                return;   
        }
    }

    /**
     * prints a topic to a file
     * @param topic topic to be printed to file
     */
    public void printTopicToFile(Topic topic){
        clearScreen();
        lms.printToFileTopic(topic);
    }

    public static void main(String[] args) {
        LMSUI lmsInterface = new LMSUI();
        lmsInterface.run();
    
    }

}
