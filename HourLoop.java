/**
 * Created with IntelliJ IDEA.
 * User: alienpriest
 * Date: 10/11/13
 * Time: 3:00 PM
 *
 * Items that occur at an hourly granulation
 */
public class HourLoop {

    public void runHour(Sky heavens){
        long length=400;

        for(int hour=0;hour<24;++hour)
        {
            hourlyEvents(hour,heavens);
            try{
                Thread.sleep(length);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }

    public void hourlyEvents(int hour, Sky heavens){
        heavens.calcAllPositions(hour);
    }
}
