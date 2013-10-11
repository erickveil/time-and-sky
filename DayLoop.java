/**
 * Created with IntelliJ IDEA.
 * User: alienpriest
 * Date: 10/11/13
 * Time: 2:18 PM
 *
 * Handles the passage of time on a day long granularity.
 */
public class DayLoop {

    public int day=0;
    public HourLoop currentHour=new HourLoop();

    public void runDay(){
        //long length=4000;

        while(true){
            ++day;
            System.out.println("Day: "+day);

            currentHour.runHour();

            /*
            try{
                Thread.sleep(length);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            */
        }
    }
}
