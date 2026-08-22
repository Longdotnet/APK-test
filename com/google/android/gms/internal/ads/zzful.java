package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzful implements ServiceConnection {
    final /* synthetic */ zzfun zza;

    public /* synthetic */ zzful(zzfun zzfunVar, zzfum zzfumVar) {
        Objects.requireNonNull(zzfunVar);
        this.zza = zzfunVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        zzfun zzfunVar = this.zza;
        zzfunVar.zzc.zzc("LmdServiceConnectionManager.onServiceConnected(%s)", componentName);
        zzfunVar.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfuj
            @Override // java.lang.Runnable
            public final void run() {
                zzfsn zzfsnVarZzb = zzfsm.zzb(iBinder);
                zzful zzfulVar = this.zza;
                zzfun zzfunVar2 = zzfulVar.zza;
                zzfunVar2.zzj = zzfsnVarZzb;
                zzfunVar2.zzc.zzc("linkToDeath", new Object[0]);
                try {
                    IInterface iInterface = zzfunVar2.zzj;
                    if (iInterface == null) {
                        throw null;
                    }
                    iInterface.asBinder().linkToDeath(zzfunVar2.zzh, 0);
                    zzfun zzfunVar3 = zzfulVar.zza;
                    zzfunVar3.zzf = false;
                    synchronized (zzfunVar3.zze) {
                        try {
                            Iterator it = zzfunVar3.zze.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                            zzfunVar3.zze.clear();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (RemoteException e) {
                    zzfulVar.zza.zzc.zzb(e, "linkToDeath failed", new Object[0]);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzfun zzfunVar = this.zza;
        zzfunVar.zzc.zzc("LmdServiceConnectionManager.onServiceDisconnected(%s)", componentName);
        zzfunVar.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfuk
            @Override // java.lang.Runnable
            public final void run() {
                zzfun zzfunVar2 = this.zza.zza;
                zzfunVar2.zzc.zzc("unlinkToDeath", new Object[0]);
                IInterface iInterface = zzfunVar2.zzj;
                iInterface.getClass();
                iInterface.asBinder().unlinkToDeath(zzfunVar2.zzh, 0);
                zzfunVar2.zzj = null;
                zzfunVar2.zzf = false;
            }
        });
    }
}
