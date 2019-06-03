import com.github.hypfvieh.DbusHelper;
import com.github.hypfvieh.bluetooth.DeviceManager;
import com.github.hypfvieh.bluetooth.wrapper.BluetoothDevice;
import org.bluez.Device1;
import weliem.BluetoothAgentManager;
import org.bluez.AgentManager1;
import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.connections.impl.DBusConnection;


public class start {

    private static BluetoothAgentManager bluetoothAgentManager;

    public static void main(String[] args) throws Exception {
        System.out.println("hello world");

        DeviceManager deviceManager = DeviceManager.createInstance(false);
        DBusConnection connection = DBusConnection.getConnection(DBusConnection.DBusBusType.SYSTEM);

        System.out.println("Retrieving AgentManager1");
        AgentManager1 agentManager1 = DbusHelper.getRemoteObject(connection, "/org/bluez", AgentManager1.class);
        bluetoothAgentManager = new BluetoothAgentManager(agentManager1, deviceManager.getAdapter(), agentManager1.getObjectPath(), connection);

        System.out.println("Creating Agent1");
        Agent1Impl btAgent = new Agent1Impl();

        System.out.println("Registering Agent1 on AgentManager1");
        agentManager1.RegisterAgent(new DBusPath(btAgent.getObjectPath()), "KeyboardOnly");

        System.out.println("Registering Agent1 as default agent");
        agentManager1.RequestDefaultAgent(new DBusPath(btAgent.getObjectPath()));

        System.out.println("Connecting to device");
        String devicePath =  "/org/bluez/hci0/dev_B0_49_5F_02_A5_F5";
        Device1 device = DbusHelper.getRemoteObject(connection, devicePath, Device1.class);
        if (device != null) {
            BluetoothDevice bluetoothDevice = new BluetoothDevice(device, deviceManager.getAdapter(), devicePath, connection);
            bluetoothDevice.connect();
        }
    }
}
