import java.util.HashMap;
import java.util.Map;

/**
 * PACKAGE_NAME
 * User: eveil
 * Date: 10/13/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sky {
    Map<String, HeavenlyBody> sky_bodies = new HashMap<String, HeavenlyBody>();

    public Sky(){
        sky_bodies.put("Sun", new HeavenlyBody("Sun", 15, 0));
        sky_bodies.put("Moon", new HeavenlyBody("Moon", 18, 1 / 30));
    }

    public void calcAllPositions(int hour){
        for(Map.Entry<String,HeavenlyBody> body_set : sky_bodies.entrySet()){
            String key=body_set.getKey();
            HeavenlyBody body=body_set.getValue();

            body.setPosition(hour);

            //System.out.println(body.name+" position: "+body.loc.x+", "+body.loc.y);
        }

        HeavenlyBody body=sky_bodies.get("Moon");
        Coordinate loc= body.getPosition(hour);
        String msg =body.name+" position: "+loc.x+", "+loc.y;
        System.out.println(msg);
    }
}
