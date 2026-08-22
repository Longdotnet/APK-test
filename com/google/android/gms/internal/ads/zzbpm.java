package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpm extends zzbpp {
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final zzbpt zzb(String str) throws RemoteException {
        zzbqr zzbqrVar;
        try {
            try {
                Class<?> cls = Class.forName(str, false, zzbpm.class.getClassLoader());
                if (MediationAdapter.class.isAssignableFrom(cls)) {
                    return new zzbqr((MediationAdapter) cls.getDeclaredConstructor(null).newInstance(null));
                }
                if (Adapter.class.isAssignableFrom(cls)) {
                    return new zzbqr((Adapter) cls.getDeclaredConstructor(null).newInstance(null));
                }
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            } catch (Throwable unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zze("Reflection failed, retrying using direct instantiation");
                if (!"com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                    if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                        zzbqrVar = new zzbqr(new CustomEventAdapter());
                    }
                    throw new RemoteException();
                }
                zzbqrVar = new zzbqr(new AdMobAdapter());
                return zzbqrVar;
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not instantiate mediation adapter: " + str + ". ", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final zzbrp zzc(String str) throws RemoteException {
        try {
            return new zzbsc((RtbAdapter) Class.forName(str, false, zzbrt.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final boolean zzd(String str) {
        try {
            return Adapter.class.isAssignableFrom(Class.forName(str, false, zzbpm.class.getClassLoader()));
        } catch (Throwable unused) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not load custom event implementation class as Adapter: " + str + ", assuming old custom event implementation.");
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final boolean zze(String str) {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzbpm.class.getClassLoader()));
        } catch (Throwable unused) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not load custom event implementation class: " + str + ", trying Adapter implementation class.");
            return false;
        }
    }
}
