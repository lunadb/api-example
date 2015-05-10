import com.arrayprolc.lunadb.api.LunaDBScript;
import com.arrayprolc.lunadb.api.LunaServer;

public class APITest {

    public static void main(String[] arg) {
        // Create the server object using its IP and the access key we want to
        // use.
        LunaServer server = new LunaServer("localhost:415", "testKey");

        // Define where the script is located. If the script is packaged inside
        // the .jar, use */ as a prefix.
        LunaDBScript script = new LunaDBScript("*/test.luna-scr", "testCategory");

        try {
            
            // The script.send() method uses our LunaServer object. Also note
            // that if you are looking
            // inside the packaged JAR you must specify the main class object,
            // otherwise set it to null.
            System.out.println("Sent success?: " + script.send(server, APITest.class));
        } catch (Exception e) {
            
            // If it failed, print out why.
            e.printStackTrace();
        }
    }

}