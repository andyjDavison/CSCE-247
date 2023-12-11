import java.util.concurrent.TimeUnit;

public class StopWatch {
    
    /**
     * Creates a StopWatch
     */
    public StopWatch(){

    }

    /**
     * Counts down from one minute
     */
    public void countDownOneMin(){
        countDownSeconds(60);
    }

    /**
     * Counts down from 5 minutes
     */
    public void countDownFiveMin(){
        for (int i=1; i<=5; i++){
            for (int j=1; j<=60; j++){
                try{
                    System.out.print("0"+(5-i)+":"+(60-j));
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } catch(Exception e){
                    System.out.println("Timed Out");
                }
            }
        }

    /**
     * Counts down from 30 seconds
     */
    }
    public void countDownThirtySec(){
        countDownSeconds(30);
    }

    /**
     * Counts down a variable number of seconds
     * @param seconds The number of seconds to count down
     */
    private void countDownSeconds(int seconds) {
        for (int i=1; i<=seconds; i++){
            try{
                System.out.print("00:"+(seconds-i));
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } catch(Exception e){
                System.out.println("Timed Out");
            }
        }
    }
}
