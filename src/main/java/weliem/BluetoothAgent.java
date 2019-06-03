package weliem;

import com.github.hypfvieh.bluetooth.wrapper.AbstractBluetoothObject;
import com.github.hypfvieh.bluetooth.wrapper.BluetoothAdapter;
import com.github.hypfvieh.bluetooth.wrapper.BluetoothDeviceType;
import org.bluez.Agent1;
import org.bluez.exceptions.BluezCanceledException;
import org.bluez.exceptions.BluezRejectedException;
import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.types.UInt16;
import org.freedesktop.dbus.types.UInt32;

public class BluetoothAgent extends AbstractBluetoothObject implements Agent1 {

    private static String TAG = "Agent";
    private final BluetoothAdapter adapter;

    // Constructor for creating a new agent. This will create a new object on the DBus
    public BluetoothAgent(BluetoothAdapter _adapter, String _dbusPath, DBusConnection _dbusConnection) {
        super(BluetoothDeviceType.NONE, _dbusConnection, _dbusPath);

        adapter = _adapter;
//        try {
//            _dbusConnection.exportObject(_dbusPath, this);
//        } catch (DBusException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected Class<? extends DBusInterface> getInterfaceClass() {
        return Agent1.class;
    }

    @Override
    public void Release() {

    }

    @Override
    public String RequestPinCode(DBusPath _device) throws BluezRejectedException, BluezCanceledException {
        System.out.println("called agent RequestPinCode");
        return null;
    }

    @Override
    public void DisplayPinCode(DBusPath _device, String _pincode) throws BluezRejectedException, BluezCanceledException {
        System.out.println("called agent DisplayPinCode");
    }

    @Override
    public UInt32 RequestPasskey(DBusPath _device) throws BluezRejectedException, BluezCanceledException {
        System.out.println("called agent RequestPasskey");
        return null;
    }

    @Override
    public void DisplayPasskey(DBusPath _device, UInt32 _passkey, UInt16 _entered) {
        System.out.println("called agent DisplayPasskey");
    }

    @Override
    public void RequestConfirmation(DBusPath _device, UInt32 _passkey) throws BluezRejectedException, BluezCanceledException {
        System.out.println("called agent RequestConfirmation");
    }

    @Override
    public void RequestAuthorization(DBusPath _device) throws BluezRejectedException, BluezCanceledException {
        System.out.println("called agent RequestAuthorizatoin");
    }

    @Override
    public void AuthorizeService(DBusPath _device, String _uuid) throws BluezRejectedException, BluezCanceledException {
        System.out.println("called agent AuthorizeService");
    }

    @Override
    public void Cancel() {

    }

    @Override
    public boolean isRemote() {
        return false;
    }

    @Override
    public String getObjectPath() {
        return getDbusPath();
    }
}
