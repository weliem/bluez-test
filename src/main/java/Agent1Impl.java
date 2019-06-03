import org.bluez.Agent1;
import org.bluez.exceptions.BluezCanceledException;
import org.bluez.exceptions.BluezRejectedException;
import org.freedesktop.dbus.DBusPath;
import org.freedesktop.dbus.types.UInt16;
import org.freedesktop.dbus.types.UInt32;

    public class Agent1Impl implements Agent1 {

        public void Release() {
            System.out.println("release called");
        }

        public String RequestPinCode(DBusPath _device) throws BluezRejectedException, BluezCanceledException {
            System.out.println("RequestPinCode called");
            return null;
        }

        public void DisplayPinCode(DBusPath _device, String _pincode) throws BluezRejectedException, BluezCanceledException {
            System.out.println("DisplayPinCode called");
        }

        public UInt32 RequestPasskey(DBusPath _device) throws BluezRejectedException, BluezCanceledException {
            System.out.println("RequestPasskey called");
            return null;
        }

        public void DisplayPasskey(DBusPath _device, UInt32 _passkey, UInt16 _entered) {
            System.out.println("DisplayPasskey called");
        }

        public void RequestConfirmation(DBusPath _device, UInt32 _passkey) throws BluezRejectedException, BluezCanceledException {
            System.out.println("RequestConfirmation called");
        }

        public void RequestAuthorization(DBusPath _device) throws BluezRejectedException, BluezCanceledException {
            System.out.println("RequestAuthorization called");
        }

        public void AuthorizeService(DBusPath _device, String _uuid) throws BluezRejectedException, BluezCanceledException {
            System.out.println("AuthorizeService called");
        }

        public void Cancel() {
            System.out.println("cancel called");
        }

        public boolean isRemote() {
            return false;
        }

        public String getObjectPath() {
            return "/";
        }
    }

