package MainThing;

/**
 * Created by Kay on 4/9/2017.
 */
public class EntryPoint {
    public static void main(String[] args) {
        System.out.println("Initializing Booststrapper...");
        Bootstrapper bootstrapper = new Bootstrapper();

        System.out.println("Composing Dependencies...");
        bootstrapper.Compose();

        System.out.println("Starting work...");
        bootstrapper.Start();

        System.out.println("Disposing dependencies...");
        bootstrapper.Dispose();
    }
}
