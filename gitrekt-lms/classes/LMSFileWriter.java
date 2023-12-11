package classes;
import java.util.ArrayList;
import java.io.*;
import java.util.Formatter;


//2 mehtods to pring out the info for any topic 
// to print out the course certificate

public class LMSFileWriter {
    /**
     * method to print a completion certificate for a course to a txt file
     * @param courseTitle
     * @param Grade
     * @param FirstName
     * @param LastName
     */
    public static void writeCourseCertificate(String courseTitle, double Grade, String FirstName, String LastName){
        String title = "CousreCertificate"+courseTitle;
        String FullName = FirstName+" "+LastName;
        try { 
            Formatter f = new Formatter(title+".txt");
            //f.format("%30s%n%n", ""); // center-align the next line
            f.format("%35s%n", "Certificate of completion: "+courseTitle); // center-align text
            //f.format("%30s%n%n", ""); // center-align the next line
            //f.format("%-15s", "Name:");
            f.format("%30s%n", FullName); // bold text
            ///f.format("%-15s", "Age:");
            f.format("%27s%n", "Grade: "+Grade); // center-align text
            f.format("%s%n", "-----------------------------------------------");
            f.format("%37s%n", "Certified by the GitRekt LMS team"); // bold text
            f.close();
          } catch (IOException e) {
            System.out.println("An error occurred trying to create your course certificate");
            e.printStackTrace();
          }
    }
    /**
     * method to print out all the information in a topic to a file
     * @param topic
     */
    public static void topicToFile(Topic topic){
      String title = topic.getName();
      try { 
          Formatter f = new Formatter(title+".txt");
          f.format("%30s%n%n", topic.getName());
          f.format("%s%n", "-----------------------------------------------");
          for(Subtopic sub: topic.getSubTop()){
            f.format("%n%27s%n%n", sub.getName());
            f.format("%27s", sub.getInfo());
            f.format("%n%27s%n", ".............");
          }
          f.close();
        } catch (IOException e) {
          System.out.println("An error occurred trying to create your topic info files");
          e.printStackTrace();
        }
  }
}
