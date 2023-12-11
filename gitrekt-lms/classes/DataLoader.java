package classes;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * A class that loads data from JSON
 * @author Andrew Davison
 */
public class DataLoader extends DataConstants {

    /**
     * Loads the list of users from users.JSON
     * @return An arrayList holding stored users
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)parser.parse(reader);

            // Loop through users
            for(int i=0;i<usersJSON.size();i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                String type = (String)userJSON.get(USER_TYPE);
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String username = (String)userJSON.get(USER_USER_NAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                String email = (String)userJSON.get(USER_EMAIL);

                //Set user based on
                if(type.equalsIgnoreCase("student")) {
                    users.add(new Student(id, new ArrayList<>(), firstName, lastName,email,username,password));
                } else {
                    users.add(new Author(id, new ArrayList<>(), new ArrayList<>(), firstName,lastName,email,username,password));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Loads the list of courses from courses.JSON
     * @return An ArrayList holding stored courses
     */
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<User> users = UserList.getInstanceUserList().getUsers();
        HashMap<User, ArrayList<Double>> userProgress = new HashMap<>();
        
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();

            // Loop through courses
            JSONArray coursesArray = (JSONArray)parser.parse(reader);
            for(int i=0;i<coursesArray.size();i++) {
                ArrayList<Student> students = new ArrayList<>();
                ArrayList<Topic> topics = new ArrayList<>();
                ArrayList<UUID> studentIDs = new ArrayList<>();
                ArrayList<UUID> authorIDs = new ArrayList<>();
                JSONObject courseJSON = (JSONObject)coursesArray.get(i);
                UUID id = UUID.fromString((String)courseJSON.get(COURSE_ID));
                String title = (String)courseJSON.get(COURSE_TITLE);
                String description = (String)courseJSON.get(COURSE_DESCRIPTION);
                UUID authorID = UUID.fromString((String)courseJSON.get(COURSE_AUTHOR_ID));
                authorIDs.add(authorID);

                // Loop thru students
                JSONArray studentsArray = (JSONArray)courseJSON.get(COURSE_STUDENTS_ARRAY);
                for(int j=0;j<studentsArray.size();j++) {
                    JSONObject studentJSON = (JSONObject)studentsArray.get(j);
                    UUID studentID = UUID.fromString((String)studentJSON.get(COURSE_STUDENTS_ID));
                    studentIDs.add(studentID);
                    ArrayList<Double> scores = new ArrayList<>();

                    // Loop thru grades
                    JSONArray gradesArray = (JSONArray)studentJSON.get(COURSE_STUDENT_GRADES);
                    for(int k=0;k<gradesArray.size();k++) {
                        double score = (double)gradesArray.get(k);
                        scores.add(score);
                    }
                    
                    // Add the user and their scores to the userProgress hash map
                    for(User user : users) {
                        if(studentID.toString().equals(user.getID())) {
                            userProgress.put(user, scores);
                        }
                    }
                }
                String difficulty = (String)courseJSON.get(COURSE_DIFFICULTY);

                // Loop thru topics
                JSONArray topicsArray = (JSONArray)courseJSON.get(COURSE_TOPICS);
                for(int j=0;j<topicsArray.size();j++) {
                    JSONObject topicJSON = (JSONObject)topicsArray.get(j);
                    String topicTitle = (String)topicJSON.get(COURSE_TOPIC_TITLE);

                    // Loop thru subtopics
                    ArrayList<Subtopic> subtopics = new ArrayList<>();
                    JSONArray subtopicsArray = (JSONArray)topicJSON.get(COURSE_TOPIC_SUBTOPICS);
                    for(int k=0;k<subtopicsArray.size();k++) {
                        JSONObject subtopicJSON = (JSONObject)subtopicsArray.get(k);
                        String subtopicTitle = (String)subtopicJSON.get(COURSE_TOPIC_SUBTOPICS_TITLE);
                        String info = (String)subtopicJSON.get(COURSE_TOPIC_SUBTOPICS_INFO);
                        subtopics.add(new Subtopic(subtopicTitle, info));
                    }

                    // Loop thru quizzes
                    ArrayList<Question> questions = new ArrayList<>();
                    JSONArray quizArray = (JSONArray)topicJSON.get(COURSE_TOPIC_QUIZ);
                    for(int k=0;k<quizArray.size();k++) {
                        JSONObject quizJSON = (JSONObject)quizArray.get(k);
                        String question = (String)quizJSON.get(COURSE_TOPIC_QUIZ_QUESTION);

                        // Loop thru answers
                        JSONArray answersArray = (JSONArray)quizJSON.get(COURSE_TOPIC_QUIZ_ANSWERS);
                        String[] answers = new String[4];
                        for(int y = 0; y < answers.length; y++) {
                            String answer = (String)answersArray.get(y);
                            answers[y] = answer;
                        }
                        int correct = ((Long)quizJSON.get(COURSE_TOPIC_QUIZ_CORRECT)).intValue();
                        questions.add(new Question(question, answers, correct));
                    }

                    // Loop thru comments
                    ArrayList<Comment> comments = new ArrayList<>();
                    JSONArray commentsArray = (JSONArray)topicJSON.get(COURSE_TOPIC_COMMENTS);
                    for(int k=0;k<commentsArray.size();k++) {
                        JSONObject commentJSON = (JSONObject)commentsArray.get(k);
                        String commentContent = (String)commentJSON.get(COURSE_TOPIC_COMMENTS_CONTENT);
                        UUID creatorID = UUID.fromString((String)commentJSON.get(COURSE_TOPIC_COMMENTS_CREATOR_ID));

                        // Loop thru replies
                        JSONArray repliesArray = (JSONArray)commentJSON.get(COURSE_TOPIC_COMMENTS_REPLIES);
                        ArrayList<Comment> replies = new ArrayList<>();
                        //replies = repliesJsonToList(repliesArray, replies, false, users);
                        for(int y=0;y<repliesArray.size();y++) {
                                JSONObject repliesJSON = (JSONObject)repliesArray.get(y);

                                // Get User by UUID
                                // String username = "";
                                // for(User user : users) {
                                //     if(user.getID().equals(replyID.toString())) {
                                //         username = user.getUsername();
                                //     }
                                // }
                                repliesJsonToList(repliesArray, replies, false, users);
                            }

                        // Get User by UUID
                        String username = "";
                        for(User user : users) {
                            if(user.getID().equals(creatorID.toString())) {
                                username = user.getUsername();
                            }
                        }
                        comments.add(new Comment(creatorID, commentContent, username, replies));
                    }
                    topics.add(new Topic(subtopics, comments, topicTitle, new Quiz(questions)));
                }

                // Add students of the course
                for(User user : users) {
                    for(UUID stuID : studentIDs) {
                        if(user.getID().equals(stuID.toString())) {
                            students.add((Student)user);
                        }
                    }
                }
                Course course = new Course(id, topics, students, title, description, Difficulty.valueOf(difficulty), authorID);
                courses.add(course);

                // Add authors created courses
                for(User user : users) {
                    if(user.getClass().getName().equals("Author") && authorID.toString().equals(user.getID())) {
                        Author author = (Author)user;
                        author.addCreatedCourses(course);
                    }
                }

                // Add course progress for each user
                for(User user : userProgress.keySet()) {
                    user.addCourseProgress(course, userProgress.get(user));
                }
            }
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    /**
     * Recursively gets the replies tree from comments
     * @param repliesArray The JSON array of replies
     * @param replies The ArrayList of replies
     * @param includeNode A boolean that either includes the node or not
     * @param users The ArrayList of users stored in JSON
     */
    public static void repliesJsonToList(JSONArray repliesArray, ArrayList<Comment> replies, boolean includeNode, ArrayList<User> users) {
        ArrayList<Comment> subComments = new ArrayList<>();
        for(int i=0;i<repliesArray.size();i++) {
            JSONObject replyJSON = (JSONObject)repliesArray.get(i);
            String replyContent = (String)replyJSON.get(COURSE_TOPIC_COMMENTS_REPLIES_CONTENT);
            UUID replyID = UUID.fromString((String)replyJSON.get(COURSE_TOPIC_COMMENTS_REPLIES_ID));
            // Get User by UUID
            String username = "";
            for(User user : users) {
                if(user.getID().equals(replyID.toString())) {
                    username = user.getUsername();
                }
            }

            boolean hasSubArray = false;
            JSONArray subArray = null;
            if(replyJSON.containsKey(COURSE_TOPIC_COMMENTS_REPLIES)) {
                Object possibleSubArray = replyJSON.get(COURSE_TOPIC_COMMENTS_REPLIES);
                if(possibleSubArray instanceof JSONArray) {
                    subArray = (JSONArray)possibleSubArray;
                    if(!subArray.isEmpty()) {
                        hasSubArray = true;
                        includeNode = false;
                    }
                }
            }
            if(hasSubArray) {
                if(includeNode) {
                    replies.add(new Comment(replyID, replyContent, username, subComments));
                }
                repliesJsonToList(subArray, replies, includeNode, users);
            } else {
                // for(int j=0;j<subArray.size();j++) {
                //     JSONObject subJSON = (JSONObject)subArray.get(j);
                //     String subContent = (String)subJSON.get(COURSE_TOPIC_COMMENTS_REPLIES_CONTENT);
                //     UUID subID = UUID.fromString((String)subJSON.get(COURSE_TOPIC_COMMENTS_REPLIES_ID));
                //     subComments.add(new Comment(subContent, username, subID));

                // }
                replies.add(new Comment(replyContent, username, replyID));
            }
        }
    }
    
    public static void main(String[] args) {
        
        UserList list = UserList.getInstanceUserList();
        ArrayList<User> users = list.getUsers();
        CourseList list2 = CourseList.getInstanceCourseList();
        ArrayList<Course> courses = list2.getCourses();

        for(Course course : courses) {
            for(Topic topic : course.getTopics()) {
                for(Comment comment : topic.getComments()) {
                    for(Comment reply : comment.getReplies()) {
                        System.out.println(reply.getContent());
                        for(Comment reply2 : reply.getReplies()) {
                            System.out.println(reply2.getContent());
                        }
                    }
                }
            }
        }
    }
}
