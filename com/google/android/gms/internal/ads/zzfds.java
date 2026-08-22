package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzfds {
    private static zzfds zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcy zzc;
    private final AtomicReference zzd = new AtomicReference();

    public zzfds(Context context, com.google.android.gms.ads.internal.client.zzcy zzcyVar) {
        this.zzb = context;
        this.zzc = zzcyVar;
    }

    public static com.google.android.gms.ads.internal.client.zzcy zza(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzcx.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfds zzd(Context context) {
        synchronized (zzfds.class) {
            try {
                zzfds zzfdsVar = zza;
                if (zzfdsVar != null) {
                    return zzfdsVar;
                }
                Context applicationContext = context.getApplicationContext();
                long jLongValue = ((Long) zzbff.zzb.zze()).longValue();
                com.google.android.gms.ads.internal.client.zzcy zzcyVarZza = null;
                if (jLongValue > 0 && jLongValue <= 252530000) {
                    zzcyVarZza = zza(applicationContext);
                }
                zzfds zzfdsVar2 = new zzfds(applicationContext, zzcyVarZza);
                zza = zzfdsVar2;
                return zzfdsVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final com.google.android.gms.ads.internal.client.zzfd zzg() {
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = this.zzc;
        if (zzcyVar != null) {
            try {
                return zzcyVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbpq zzb() {
        return (zzbpq) this.zzd.get();
    }

    public final VersionInfoParcel zzc(int i, boolean z, int i2) {
        com.google.android.gms.ads.internal.client.zzfd zzfdVarZzg;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        boolean zZzF = com.google.android.gms.ads.internal.util.zzs.zzF(this.zzb);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i2, true, zZzF);
        return (((Boolean) zzbff.zzc.zze()).booleanValue() && (zzfdVarZzg = zzg()) != null) ? new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, zzfdVarZzg.zzb, true, zZzF) : versionInfoParcel;
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzfd zzfdVarZzg = zzg();
        if (zzfdVarZzg != null) {
            return zzfdVarZzg.zzc;
        }
        return null;
    }

    public final void zzf(zzbpq zzbpqVar) {
        zzbpq adapterCreator;
        if (!((Boolean) zzbff.zza.zze()).booleanValue()) {
            zzfdr.zza(this.zzd, null, zzbpqVar);
            return;
        }
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = this.zzc;
        if (zzcyVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzcyVar.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference = this.zzd;
        if (adapterCreator != null) {
            zzbpqVar = adapterCreator;
        }
        zzfdr.zza(atomicReference, null, zzbpqVar);
    }
}
