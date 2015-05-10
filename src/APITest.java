import java.util.Arrays;

import com.arrayprolc.lunadb.api.LunaDBScript;
import com.arrayprolc.lunadb.api.LunaServer;

public class APITest {

    public static void main(String[] arg) {
        // Create the server object using its IP and the access key we want to
        // use.
        LunaServer server = new LunaServer("localhost:415", "testKey");

        // This is optional but useful for determining where requests come from.
        server.programName = "java_api_example";

        // Define where the script is located. If the script is packaged inside
        // the .jar, use */ as a prefix. The third argument is the "run name",
        // or the name that the database will know the file as.
        LunaDBScript script = new LunaDBScript("*/test.luna-scr", "testCategory", "test");

        try {

            // The script.send() method uses our LunaServer object. Also note
            // that if you are looking
            // inside the packaged JAR you must specify the main class object,
            // otherwise set it to null.
            System.out.println("Sent success?: " + script.send(server, APITest.class));

            // The script.run() method only takes our server object, and returns
            // an ArrayList of strings (result of each line). This program
            // simply prints them on the screen.
            System.out.println("Running results: " + Arrays.toString(script.run(server).toArray()));
        } catch (Exception e) {
            // If it failed, print out why.
            e.printStackTrace();
        }
    }

}