package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzfun {
    private final zzfwh zza;
    private final Context zzb;
    private final zzfuo zzc;
    private boolean zzf;
    private final Intent zzg;
    private ServiceConnection zzi;
    private IInterface zzj;
    private final List zze = new ArrayList();
    private final String zzd = "OverlayDisplayService";
    private final IBinder.DeathRecipient zzh = new IBinder.DeathRecipient() { // from class: com.google.android.gms.internal.ads.zzfuf
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzfun.zzh(this.zza);
        }
    };

    public zzfun(Context context, zzfuo zzfuoVar, String str, Intent intent, zzfts zzftsVar) {
        this.zzb = context;
        this.zzc = zzfuoVar;
        final String str2 = "OverlayDisplayService";
        this.zzg = intent;
        this.zza = zzfwl.zza(new zzfwh(str2) { // from class: com.google.android.gms.internal.ads.zzfue
            public final /* synthetic */ String zza = "OverlayDisplayService";

            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                HandlerThread handlerThread = new HandlerThread(this.zza, 10);
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            }
        });
    }

    public static /* synthetic */ void zzf(zzfun zzfunVar, Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            zzfunVar.zzc.zza("error caused by ", e);
        }
    }

    public static /* synthetic */ void zzg(zzfun zzfunVar, Runnable runnable) {
        if (zzfunVar.zzj != null || zzfunVar.zzf) {
            if (!zzfunVar.zzf) {
                runnable.run();
                return;
            }
            zzfunVar.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            List list = zzfunVar.zze;
            synchronized (list) {
                list.add(runnable);
            }
            return;
        }
        zzfunVar.zzc.zzc("Initiate binding to the service.", new Object[0]);
        List list2 = zzfunVar.zze;
        synchronized (list2) {
            list2.add(runnable);
        }
        zzful zzfulVar = new zzful(zzfunVar, null);
        zzfunVar.zzi = zzfulVar;
        zzfunVar.zzf = true;
        if (zzfunVar.zzb.bindService(zzfunVar.zzg, zzfulVar, 1)) {
            return;
        }
        zzfunVar.zzc.zzc("Failed to bind to the service.", new Object[0]);
        zzfunVar.zzf = false;
        List list3 = zzfunVar.zze;
        synchronized (list3) {
            list3.clear();
        }
    }

    public static /* synthetic */ void zzh(zzfun zzfunVar) {
        zzfunVar.zzc.zzc("%s : Binder has died.", zzfunVar.zzd);
        List list = zzfunVar.zze;
        synchronized (list) {
            list.clear();
        }
    }

    public static /* synthetic */ void zzi(zzfun zzfunVar) {
        if (zzfunVar.zzj != null) {
            zzfunVar.zzc.zzc("Unbind from service.", new Object[0]);
            Context context = zzfunVar.zzb;
            ServiceConnection serviceConnection = zzfunVar.zzi;
            serviceConnection.getClass();
            context.unbindService(serviceConnection);
            zzfunVar.zzf = false;
            zzfunVar.zzj = null;
            zzfunVar.zzi = null;
            List list = zzfunVar.zze;
            synchronized (list) {
                list.clear();
            }
        }
    }

    public final void zzo(final Runnable runnable) {
        ((Handler) this.zza.zza()).post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfug
            @Override // java.lang.Runnable
            public final void run() {
                zzfun.zzf(this.zza, runnable);
            }
        });
    }

    public final IInterface zzc() {
        return this.zzj;
    }

    public final void zzm(final Runnable runnable) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfuh
            @Override // java.lang.Runnable
            public final void run() {
                zzfun.zzg(this.zza, runnable);
            }
        });
    }

    public final void zzn() {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfui
            @Override // java.lang.Runnable
            public final void run() {
                zzfun.zzi(this.zza);
            }
        });
    }
}
