package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.support.customtabs.ICustomTabsService;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {
    private Context mApplicationContext;

    /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsServiceConnection$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 extends CustomTabsClient {
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient);

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ICustomTabsService iCustomTabsService;
        if (this.mApplicationContext == null) {
            throw new IllegalStateException(GsPcpBmONXh.OOfmwQotZwCaP);
        }
        int i = ICustomTabsService.Stub.$r8$clinit;
        if (iBinder == null) {
            iCustomTabsService = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICustomTabsService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICustomTabsService)) {
                ICustomTabsService.Stub.Proxy proxy = new ICustomTabsService.Stub.Proxy();
                proxy.mRemote = iBinder;
                iCustomTabsService = proxy;
            } else {
                iCustomTabsService = (ICustomTabsService) iInterfaceQueryLocalInterface;
            }
        }
        onCustomTabsServiceConnected(componentName, new AnonymousClass1(iCustomTabsService, componentName));
    }
}
