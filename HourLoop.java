/**
 * Created with IntelliJ IDEA.
 * User: alienpriest
 * Date: 10/11/13
 * Time: 3:00 PM
 *
 * Items that occur at an hourly granulation
 */
public class HourLoop {

    public void runHour(){
        long length=400;

        for(int hour=0;hour<24;++hour)
        {
            hourlyEvents(hour);
            try{
                Thread.sleep(length);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }

    public void hourlyEvents(int hour){
        int solar_position=Sun.getPosition(hour);

        System.out.println("Hour: "+hour+" Sun Position: "+solar_position);
    }
}
