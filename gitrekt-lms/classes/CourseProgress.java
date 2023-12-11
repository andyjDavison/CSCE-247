package classes;
import java.util.ArrayList;
import java.util.UUID;

public class CourseProgress {
    private Course course; // The unique identifier for this course progress.
    private ArrayList<Double> grades; // The list of grades associated with the given course
    
    /**
    *Constructs a new CourseProgress object with the specified UUID and list of grades.
    *@param id the unique identifier for this course progress.
    *@param grades the list of grades associated with the given course
    */
    public CourseProgress(Course course, ArrayList<Double> grades) {
        this.course = course;
        this.grades = grades;
    }

    /**
    Constructs a new CourseProgress object with the specified course and an empty list of grades.
    @param course the course that the progress is being tracked for
    */
    public CourseProgress(Course course){
        this.course = course;
        this.grades = new ArrayList<>();
    }

    /**
    Returns a boolean value indicating whether the course associated with this progress object has been completed by the student.
    The method checks whether the number of topics in the course matches the number of grades in the progress object.
    @param course the course to check completion status for
    @return true if the course is completed, false otherwise
    */
    public boolean isCompleted(Course course){
        boolean result = false;
        if(course.getTopics().size() == this.grades.size()){
            result = true;
        }
        return result;
    }

    /**
    *Returns a string representation of this CourseProgress object
    *@return a string representation of this CourseProgress object
    */
    public String toString() {
        return this.course.toString();
    }

    /**
    *Adds a grade to the list of grades associated with this course progress
    *@param grade the grade to add to the list of grades.
    */
    public void addGrade(double grade){
        this.grades.add(grade);
    }

    /**
    *Returns the average grade for this course progress.
    *@return the average grade for this course progress.
    */
    public double getGrade(){
        int questions = this.grades.size();
        double grade = 0.0;
        for(double score : grades) {
        grade += score;
        }
        grade /= (double)questions;
        return grade;
    }

    /**
    *Returns the list of grades associated with the given course.
    *@return the list of grades associated with the given course
    */
    public ArrayList<Double> getGrades(){
        return this.grades;
    }

    /** 
    Returns a string representation of the topic grades for this student, where each grade is displayed as a percentage.
    The method iterates over the grades of the student and creates a string that displays the position of the grade
    and the grade value as a percentage, separated by a dot and a newline character.
    @return a string representation of the topic grades for this student
    */
    public String displayTopicGrades(){
        String result = "";
        int position = 1;
        for(double grade : this.grades){
            double percent = grade*100;
            result += Integer.toString(position)+". "+Double.toString(percent)+"%\n";
            position++;
        }
        return result;
    }

    /**
    *Returns the course associated with this course progress.
    *@return Course associated with this course progress.
    */
    public Course getCourse() {
        return this.course;
    }

    /**
    Returns the number of completed topics for this course progress.
    @return the number of completed topics for this course progress.
    */
    public int numCompletedTopics(){
        return this.grades.size();
    }
    
}
