package classes;
import java.util.ArrayList;

public class Question {
    private String question; //holds the question
    private String[] answers = new String[4]; //array size 4 for answers
    private static final int NUM_ANS = 4;//Static int 4
    private int correctAns; //holds the int for the correct answer choice
    private boolean correct; //holds if the question is correct

    /**
     * constructor for question
     * @param question
     * @param answers
     * @param correctAns
     */
    public Question(String question, String[] answers, int correctAns){
        this.question = question;
        for (int i=0; i<NUM_ANS; i++){
            this.answers[i] = answers[i];
        }
        this.correctAns = correctAns;
        this.correct = false; 
    }
    /**
     * checks if question is equal to another question
     * @param q
     * @return true if equal
     */
    public boolean equals(Question q){
        boolean result = false;
        if(this.question.equals(q.getQuestion()) &&
        this.correctAns == q.getCorrectAns()){
            result = true;
        }
        return result;
    }
    /**
     * @return the question
     */
    public String getQuestion(){
        return this.question;
    }
    /**
     * checks if inputted answer is correct
     * @param ans
     * @return true if correct
     */
    public boolean isCorrect(int ans){
        boolean result = false;
        if (ans == this.correctAns){
            this.correct = true;
            result = true;
        } else {
            this.correct = false;
        }
        return result;
    }
    /**
     * returns update score if correct answer
     * @return returns update score if correct answer
     */
    public int score(){
        int score = 0;
        if(this.correct){
            score++;
        }
        this.correct = false;
        return score;
    }
    /**
     * tostring method, prints out question and answers
     */
    public String toString(){
        String result = "";
        result += this.question+"\n";
        result += "\n"+displayAnswers();
        return result;
    }
    /**
     * displays all the answer choices
     * @return string of list of answer choices
     */
    public String displayAnswers(){
        String result = "";
        result += "1. "+this.answers[0]+"\n";
        result += "2. "+this.answers[1]+"\n";
        result += "3. "+this.answers[2]+"\n";
        result += "4. "+this.answers[3]+"\n";
        return result;
    }
    /**
     * @return this correct answer
     */
    public int getCorrectAns() {
        return correctAns;
    }
    /**
     * @return Array of answer choices
     */
    public String[] getAns() {
        if(answers == null)
            return null;
        else
            return this.answers;
    }
}
