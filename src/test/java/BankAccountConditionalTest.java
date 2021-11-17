import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

@DisplayName("Show Conditional Testing")
public class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC})
    @DisplayName("Test running should run on Mac Only")
    public void testMac(){
        System.out.println("I know Tim Cook");
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    @DisplayName("Test running should run on Windows Only")
    public void testWindows(){
        System.out.println("I know Satya Nadela");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_16,JRE.JAVA_17})
    @DisplayName("Test running should run on JRE 16 or 17")
    public void testJRE(){
        System.out.println("Running on my fav JRE!");
    }

    @Test
    @DisplayName("Testing run if Not JRE 16")
    @DisabledOnJre({JRE.JAVA_8,JRE.JAVA_13})
    public void testNoJRE16(){
        System.out.println("Me no likey Java 16");

    }

}
