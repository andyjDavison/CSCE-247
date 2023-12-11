package classes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {


    
    /**
     * Saves all courses in the course list to a JSON file.
     */
    public static void saveCourses() {
        CourseList courseList = CourseList.getInstanceCourseList(); 
        ArrayList<Course> courses = courseList.getCourses();
        JSONArray jsonCourses = new JSONArray();
        
        //creating all the json objects
        for (int i = 0; i < courses.size(); i++) {
            jsonCourses.add(getCourseJSON(courses.get(i)));
        }
        
        //Write JSON file
        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the JSON representation of the given course.
     *
     * @param course the course to convert to JSON format
     * @return the JSON representation of the given course
     */
    public static JSONObject getCourseJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURSE_ID, course.getID());
        courseDetails.put(COURSE_TITLE, course.getTitle());
        courseDetails.put(COURSE_DESCRIPTION, course.getDescription());
        courseDetails.put(COURSE_AUTHOR_ID, course.getAuthorIDstring());
        courseDetails.put(COURSE_STUDENTS_ARRAY, getStudentsJSON(course));
        courseDetails.put(COURSE_DIFFICULTY, course.getDifficulty());
        courseDetails.put(COURSE_TOPICS, getTopicsJSON(course));
        return courseDetails;
    }
    
    /**
     * Returns a JSONArray containing JSON representation of all topics of the given course.
     *
     * @param course the course to get topics of
     * @return a JSONArray containing JSON representation of all topics of the given course
     */
    private static JSONArray getTopicsJSON(Course course) {
        JSONArray jsonTopics = new JSONArray();
        ArrayList<Topic> topics = course.getTopics();
        for (int i = 0; i < topics.size(); i++) {
            jsonTopics.add(getTopicJSON(topics.get(i)));
        }
        return jsonTopics;
    
    }

    /**
     * Returns a JSONObject representing a single topic, including its subtopics, quiz questions, and comments.
     *
     * @param topic the topic to represent as a JSONObject
     * @return a JSONObject representing the topic
     */
    private static JSONObject getTopicJSON(Topic topic) {
        JSONObject topicsDetails = new JSONObject();
        topicsDetails.put(COURSE_TOPIC_TITLE, topic.getName());
        topicsDetails.put(COURSE_TOPIC_SUBTOPICS, getTopicSubTopicsJSON(topic));
        topicsDetails.put(COURSE_TOPIC_QUIZ, getTopicQuizJSON(topic));
        topicsDetails.put(COURSE_TOPIC_COMMENTS, getTopicComments(topic));
        return topicsDetails;
    }

    /**
     * Returns a JSONArray of JSONObjects representing all the comments on a given topic.
     *
     * @param topic the topic whose comments should be represented as JSONObjects
     * @return a JSONArray of JSONObjects representing the comments on the topic
     */
    private static JSONArray getTopicComments(Topic topic) {
        return getAllCommets(topic.getComments());
    }

    /**
     * Returns a JSONArray of JSONObjects representing all the comments, including replies, in a given ArrayList.
     *
     * @param comments the ArrayList of comments to represent as JSONObjects
     * @return a JSONArray of JSONObjects representing the comments and replies
     */
    public static JSONArray getAllCommets(ArrayList<Comment> comments){
        JSONArray jsonComments = new JSONArray();
        for(int i=0; i<comments.size(); i++){
            jsonComments.add(commentJSON(comments.get(i)));
        }
        return jsonComments;
    }

    /**
     * Returns a JSONObject representing a single comment, including its content, ID, and replies.
     *
     * @param comment the comment to represent as a JSONObject
     * @return a JSONObject representing the comment
     */
    private static JSONObject commentJSON(Comment comment) {
        JSONObject commentDetail = new JSONObject();
        commentDetail.put(COURSE_TOPIC_COMMENTS_CONTENT, comment.getContent());
        commentDetail.put(COURSE_TOPIC_COMMENTS_CREATOR_ID, comment.getID().toString());
        commentDetail.put(COURSE_TOPIC_COMMENTS_REPLIES, replysJSON(comment.getReplies()));

        return commentDetail;
    }

    /**
     * Returns a JSONArray of JSONObjects representing all the replies to a given comment.
     *
     * @param comments the ArrayList of comments representing the replies
     * @return a JSONArray of JSONObjects representing the replies
     */
    public static JSONArray replysJSON(ArrayList<Comment> comments){
        JSONArray jsonCommentsComments = new JSONArray();
        if(comments != null)
        {
            for(int i=0; i<comments.size(); i++){
                jsonCommentsComments.add(commentJSON(comments.get(i)));
            }
            return jsonCommentsComments;
        }
        return jsonCommentsComments;
    } 

    /**
     * Returns a JSONArray of the quiz
     * @param topic which containes the quiz
     * @return the jsonArrray with the quiz
     */
    private static JSONArray getTopicQuizJSON(Topic topic) {
        JSONArray jsonQuiz = new JSONArray();
        ArrayList<Question> quiz=  topic.getQuiz().getQuestions();
        for(int i=0; i<quiz.size(); i++){
            jsonQuiz.add(questionJSON(quiz.get(i)));
        }
        return jsonQuiz;
    }

   /**
    * Returns a JSONObject representing all the questions.
    * @param question the question to turn into json
    * @return the json question
    */
    private static JSONObject questionJSON(Question question) {
        JSONObject questionDetail = new JSONObject();
        questionDetail.put(COURSE_TOPIC_QUIZ_QUESTION, question.getQuestion());
        questionDetail.put(COURSE_TOPIC_QUIZ_CORRECT, question.getCorrectAns());
        JSONArray jsonAns = new JSONArray();
        for(int i = 0; i < question.getAns().length; i++){
            jsonAns.add(question.getAns()[i]);
        }
        questionDetail.put(COURSE_TOPIC_QUIZ_ANSWERS, jsonAns);



        return questionDetail;
    }

    /**
     * Returns a JSONArray representing all the topic
     * @param topic to go json
     * @return topic in json
     */
    private static JSONArray getTopicSubTopicsJSON(Topic topic) {
        JSONArray jsonSubTop = new JSONArray();
        ArrayList<Subtopic> subTops =  topic.getSubTop();
        for(int i=0; i<subTops.size(); i++){
            jsonSubTop.add(subTopInfoJSON(subTops.get(i)));
        }
        return jsonSubTop;
    }

    /**
     * Returns a JSONArray representing all the topic
     * @param subTop to tun into json
     * @return
     */
    private static JSONObject subTopInfoJSON(Subtopic subTop){
        JSONObject subTopDetail = new JSONObject();
        subTopDetail.put(COURSE_TOPIC_SUBTOPICS_TITLE, subTop.getName());
        subTopDetail.put(COURSE_TOPIC_SUBTOPICS_INFO, subTop.getInfo());
        return subTopDetail;
    }



    /** 
     * Converts a list of students in a given course into a JSONArray of JSONObjects representing each student.
    @param course the course containing the list of students to convert
    @return a JSONArray of JSONObjects representing each student in the course
    */
    private static JSONArray getStudentsJSON(Course course) {
        JSONArray jsonStudents = new JSONArray();
        ArrayList<Student> students = course.getStudents();
        for(int i=0; i < students.size(); i++){
            jsonStudents.add(getStudentJSON(students.get(i), course));
        }
        return jsonStudents;
    }

    /**
    Converts a Student object to a JSONObject containing relevant information.
    @param student The Student object to be converted.
    @param course The Course object to which the student belongs.
    @return A JSONObject containing the student's ID and grades for the given course.
    */
    private static JSONObject getStudentJSON(Student student, Course course) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(COURSE_STUDENTS_ID, student.getID());
        //studentDetails.put(COURSE_STUDENT_COMP_TOPICS, student.getTopicsCompleted());
        studentDetails.put(COURSE_STUDENT_GRADES, getGradesJSON(student, course));

        return studentDetails;
    }

    /**
    Returns a JSON array of grades for a given student in a course.
    @param student the student for whom to retrieve the grades.
    @param course the course for which the grades are being retrieved.
    @return a JSON array of grades for the given student in the given course, or an empty array if no grades are found.
    */
    private static JSONArray getGradesJSON(Student student, Course course) {
        JSONArray jsonGradess = new JSONArray();
        ArrayList<Double> grades = student.getGrades(course);
        if(grades == null){
            return jsonGradess;
        }
        for(int i=0; i<grades.size(); i++){
            jsonGradess.add(grades.get(i));
        }
        return jsonGradess;
    }
	
    //-----------------------------------------

    /**
    * Saves the list of users to a JSON file.
    */
    public static void saveUsers() {
		UserList userlist = UserList.getInstanceUserList(); 
		ArrayList<User> users = userlist.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i < users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * Returns a JSONObject containing the details of the given User object.
     * 
     * @param user the User object to get the details from
     * @return a JSONObject containing the user's details
     */
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID());
        //here we check if they are student of aouther type
        if(user instanceof Author)
            userDetails.put(USER_TYPE, "author");
        else // they are an author
            userDetails.put(USER_TYPE, "student");
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_USER_NAME, user.getUsername());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_EMAIL,user.getEmail());
        
        return userDetails;
	}

}