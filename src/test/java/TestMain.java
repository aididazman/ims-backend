import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestMain {

    public static void main(String[] args) {

        ZonedDateTime localTime = ZonedDateTime.now(ZoneId.systemDefault());
        LocalDateTime test = localTime.toLocalDateTime();

        // Convert local time to Instant with correct local time
        Instant localInstant = localTime.toInstant();
        Instant test2 = test.atZone(ZoneId.systemDefault()).toInstant();

        // Convert local time to Instant with correct local time and zone offset
        Instant localInstantWithOffset = localTime.toInstant().atZone(ZoneId.systemDefault()).toInstant();
        LocalDateTime test3 = LocalDateTime.now(ZoneId.systemDefault());

        // Print the results
        System.out.println("Local Time: " + localTime);
        System.out.println("Local Date Time: " + test);
        System.out.println("Instant with Correct Local Time: " + localInstant);
        System.out.println("Instant with Correct Local Time: " + test2);
        System.out.println("Instant with Correct Local Time and Zone Offset: " + localInstantWithOffset);
        System.out.println("Local Date Time with Correct Local Time: " + test3);

    }

}
