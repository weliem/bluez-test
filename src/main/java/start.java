import org.bluez.AgentManager1;
import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.connections.impl.DBusConnection;

public class start {

    public static void main(String[] args) throws Exception {
        System.out.println("hello world");

        DBusConnection connection = DBusConnection.newConnection(DBusConnection.DBusBusType.SYSTEM);
            System.out.println("Retrieving AgentManager1");
            AgentManager1 agentManager1 = connection.getRemoteObject("org.bluez", "/org/bluez", AgentManager1.class);
            System.out.println("Creating Agent1");
            Agent1Impl btAgent = new Agent1Impl();

            System.out.println("Registering Agent1 on AgentManager1");
            agentManager1.RegisterAgent(new DBusPath(btAgent.getObjectPath()), "NoInputNoOutput");
            System.out.println("All Done");
    }
}