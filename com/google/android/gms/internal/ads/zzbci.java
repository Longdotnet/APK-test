package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbci {
    zzayy zza;
    boolean zzb;
    private final ExecutorService zzc;

    public zzbci() {
        this.zzc = com.google.android.gms.ads.internal.util.client.zzb.zzb;
    }

    public zzbci(final Context context) {
        ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.zzb;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbcd
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzft)).booleanValue();
                zzbci zzbciVar = this.zza;
                Context context2 = context;
                if (zBooleanValue) {
                    try {
                        zzbciVar.zza = (zzayy) ExceptionsKt.zzb(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.internal.ads.zzbce
                            @Override // com.google.android.gms.ads.internal.util.client.zzq
                            public final Object zza(Object obj) {
                                return zzayx.zzb((IBinder) obj);
                            }
                        });
                        zzbciVar.zza.zze(new ObjectWrapper(context2), "GMA_SDK");
                        zzbciVar.zzb = true;
                    } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
                        com.google.android.gms.ads.internal.util.client.zzo.zze("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}
