package classes;
import java.util.ArrayList;

/**
 * A quiz class
 */
public class Quiz {
    private ArrayList<Question> questions; 

    /**
     * Creates a new instance of a quiz
     * @param questions An array list of the questions in the quiz
     */
    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }

    /**
     * Adds a question to the quiz
     * @param question The question to be added to the quiz
     */
    public void addQuestion(Question question){
        questions.add(question);
    }

    /**
     * Checks if this quiz is the same as another quiz
     * @param quiz The quiz that is checked against the current instance
     * @return A boolean representing whether the quizzes are equal
     */
    public boolean equals(Quiz quiz){
        boolean result = false;
        int position = 0;
        int numMatchingQuestions = 0;
        for(Question question : this.questions){
            if(question.equals(quiz.getQuestionAt(position))){
                numMatchingQuestions++;
            }
            position++;
        }
        if(quiz != null && numMatchingQuestions == questions.size()){
            result = true;
        }
        return result;
    }

    /**
     * Get the questions of the quiz
     * @return An array list of questions
     */
    public ArrayList<Question> getQuestions() {
        if(questions == null){
            questions = new ArrayList<Question>();
            return questions;
        }
        else
            return this.questions;
    }

    /**
     * Gets the question at an index
     * @param index The index that the question to get is at
     * @return A question at the index
     */
    public Question getQuestionAt(int index){
        if(questions != null)
            return questions.get(index);
        else
            return null;
    }

    //TODO
    /**
     * Gets the string representation of the quiz
     * @return a string representing the quiz
     */
    public String toString(){
        String result = "**QUIZ**\n";
        for(Question question : this.questions){
            result += question.toString()+"\n";
        }
        return result;
    }
    
    /**
     * Gets the grade associated with the quiz
     * @return A double representing the grade
     */
    public double getGrade(){
        int score = 0;
        for(Question question : questions){
            score += question.score();
        }
        double grade;
        grade = (double)score/((double)questions.size());
        return grade;
    }

    /**
     * Gets the size of the quiz
     * @return An int representing the size of the quiz
     */
    public int getQuizSize(){
        return questions.size();
    }
}
