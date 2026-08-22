package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzin implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzq zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ Object zze;
    public final /* synthetic */ zzjm zzf;

    public zzin(zzjm zzjmVar, String str, String str2, zzq zzqVar, boolean z, zzcf zzcfVar) {
        this.zzf = zzjmVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = z;
        this.zze = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        AtomicReference atomicReference;
        switch (this.$r8$classId) {
            case 0:
                zzq zzqVar = this.zzc;
                String str = this.zza;
                zzcf zzcfVar = (zzcf) this.zze;
                zzjm zzjmVar = this.zzf;
                zzfr zzfrVar = (zzfr) zzjmVar.mBuilder;
                Bundle bundle = new Bundle();
                try {
                    try {
                        zzdx zzdxVar = zzjmVar.zzb;
                        String str2 = this.zzb;
                        if (zzdxVar == null) {
                            zzeh zzehVar = zzfrVar.zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzc(str, "Failed to get user properties; not connected to service", str2);
                            zzlb zzlbVar = zzfrVar.zzp;
                            zzfr.zzP(zzlbVar);
                            zzlbVar.zzR(zzcfVar, bundle);
                            return;
                        }
                        List<zzkw> listZzh = zzdxVar.zzh(str, str2, this.zzd, zzqVar);
                        Bundle bundle2 = new Bundle();
                        if (listZzh != null) {
                            for (zzkw zzkwVar : listZzh) {
                                String str3 = zzkwVar.zze;
                                String str4 = zzkwVar.zzb;
                                if (str3 != null) {
                                    bundle2.putString(str4, str3);
                                } else {
                                    Long l = zzkwVar.zzd;
                                    if (l != null) {
                                        bundle2.putLong(str4, l.longValue());
                                    } else {
                                        Double d = zzkwVar.zzg;
                                        if (d != null) {
                                            bundle2.putDouble(str4, d.doubleValue());
                                        }
                                    }
                                }
                            }
                        }
                        try {
                            zzjmVar.zzQ();
                            zzlb zzlbVar2 = zzfrVar.zzp;
                            zzfr.zzP(zzlbVar2);
                            zzlbVar2.zzR(zzcfVar, bundle2);
                            return;
                        } catch (RemoteException e) {
                            e = e;
                            bundle = bundle2;
                            zzeh zzehVar2 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzd.zzc(str, "Failed to get user properties; remote exception", e);
                            zzlb zzlbVar3 = zzfrVar.zzp;
                            zzfr.zzP(zzlbVar3);
                            zzlbVar3.zzR(zzcfVar, bundle);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bundle = bundle2;
                            zzlb zzlbVar4 = zzfrVar.zzp;
                            zzfr.zzP(zzlbVar4);
                            zzlbVar4.zzR(zzcfVar, bundle);
                            throw th;
                        }
                    } catch (RemoteException e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
            default:
                synchronized (((AtomicReference) this.zze)) {
                    try {
                        try {
                            zzjm zzjmVar2 = this.zzf;
                            zzdx zzdxVar2 = zzjmVar2.zzb;
                            if (zzdxVar2 == null) {
                                zzeh zzehVar3 = ((zzfr) zzjmVar2.mBuilder).zzm;
                                zzfr.zzR(zzehVar3);
                                zzehVar3.zzd.zzd("(legacy) Failed to get user properties; not connected to service", null, this.zza, this.zzb);
                                ((AtomicReference) this.zze).set(Collections.emptyList());
                                ((AtomicReference) this.zze).notify();
                                return;
                            }
                            if (TextUtils.isEmpty(null)) {
                                ((AtomicReference) this.zze).set(zzdxVar2.zzh(this.zza, this.zzb, this.zzd, this.zzc));
                            } else {
                                ((AtomicReference) this.zze).set(zzdxVar2.zzi(null, this.zza, this.zzb, this.zzd));
                            }
                            this.zzf.zzQ();
                            atomicReference = (AtomicReference) this.zze;
                            atomicReference.notify();
                            return;
                        } catch (Throwable th3) {
                            ((AtomicReference) this.zze).notify();
                            throw th3;
                        }
                    } catch (RemoteException e3) {
                        zzeh zzehVar4 = ((zzfr) this.zzf.mBuilder).zzm;
                        zzfr.zzR(zzehVar4);
                        zzehVar4.zzd.zzd("(legacy) Failed to get user properties; remote exception", null, this.zza, e3);
                        ((AtomicReference) this.zze).set(Collections.emptyList());
                        atomicReference = (AtomicReference) this.zze;
                    }
                }
                break;
        }
    }

    public zzin(zzjm zzjmVar, AtomicReference atomicReference, String str, String str2, zzq zzqVar, boolean z) {
        this.zzf = zzjmVar;
        this.zze = atomicReference;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = z;
    }
}
