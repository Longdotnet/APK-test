package androidx.browser.customtabs;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;

/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsSession {
    public final CustomTabsClient.AnonymousClass2 mCallback;
    public final ComponentName mComponentName;
    public final Object mLock = new Object();
    public final ICustomTabsService mService;

    public CustomTabsSession(ICustomTabsService iCustomTabsService, CustomTabsClient.AnonymousClass2 anonymousClass2, ComponentName componentName) {
        this.mService = iCustomTabsService;
        this.mCallback = anonymousClass2;
        this.mComponentName = componentName;
    }

    public final void postMessage(String str) {
        Bundle bundle = new Bundle();
        synchronized (this.mLock) {
            try {
                try {
                    ((ICustomTabsService.Stub.Proxy) this.mService).postMessage(this.mCallback, str, bundle);
                } catch (RemoteException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
