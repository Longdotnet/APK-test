package com.google.android.gms.dynamic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public abstract class RemoteCreator {
    private final String zza;
    private Object zzb;

    public final class RemoteCreatorException extends Exception {
    }

    public RemoteCreator(String str) {
        this.zza = str;
    }

    public abstract Object getRemoteCreator(IBinder iBinder);

    public final Object getRemoteCreatorInstance(Context context) throws RemoteCreatorException {
        Context contextCreatePackageContext;
        if (this.zzb == null) {
            zzah.checkNotNull(context);
            int i = GooglePlayServicesUtil.$r8$clinit;
            try {
                contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                contextCreatePackageContext = null;
            }
            if (contextCreatePackageContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.zzb = getRemoteCreator((IBinder) contextCreatePackageContext.getClassLoader().loadClass(this.zza).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new RemoteCreatorException("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new RemoteCreatorException("Could not instantiate creator.", e3);
            }
        }
        return this.zzb;
    }
}
