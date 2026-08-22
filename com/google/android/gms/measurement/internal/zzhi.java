package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzhi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzhx zzb;

    public /* synthetic */ zzhi(zzhx zzhxVar, AtomicReference atomicReference, int i) {
        this.$r8$classId = i;
        this.zzb = zzhxVar;
        this.zza = atomicReference;
    }

    private final void run$com$google$android$gms$measurement$internal$zzhi() {
        synchronized (this.zza) {
            try {
                try {
                    AtomicReference atomicReference = this.zza;
                    zzfr zzfrVar = (zzfr) this.zzb.mBuilder;
                    atomicReference.set(Boolean.valueOf(zzfrVar.zzk.zzs(zzfrVar.zzh().zzl(), zzdu.zzJ)));
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void run$com$google$android$gms$measurement$internal$zzhm() {
        String str;
        synchronized (this.zza) {
            try {
                try {
                    AtomicReference atomicReference = this.zza;
                    zzfr zzfrVar = (zzfr) this.zzb.mBuilder;
                    zzag zzagVar = zzfrVar.zzk;
                    String strZzl = zzfrVar.zzh().zzl();
                    zzdt zzdtVar = zzdu.zzK;
                    if (strZzl == null) {
                        zzagVar.getClass();
                        str = (String) zzdtVar.zza(null);
                    } else {
                        str = (String) zzdtVar.zza(zzagVar.zzb.zza(strZzl, zzdtVar.zzb));
                    }
                    atomicReference.set(str);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void run$com$google$android$gms$measurement$internal$zzhn() {
        synchronized (this.zza) {
            try {
                try {
                    AtomicReference atomicReference = this.zza;
                    zzfr zzfrVar = (zzfr) this.zzb.mBuilder;
                    atomicReference.set(Long.valueOf(zzfrVar.zzk.zzi(zzfrVar.zzh().zzl(), zzdu.zzL)));
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void run$com$google$android$gms$measurement$internal$zzho() {
        synchronized (this.zza) {
            try {
                try {
                    AtomicReference atomicReference = this.zza;
                    zzfr zzfrVar = (zzfr) this.zzb.mBuilder;
                    atomicReference.set(Integer.valueOf(zzfrVar.zzk.zze(zzfrVar.zzh().zzl(), zzdu.zzM)));
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                run$com$google$android$gms$measurement$internal$zzhi();
                return;
            case 1:
                run$com$google$android$gms$measurement$internal$zzhm();
                return;
            case 2:
                run$com$google$android$gms$measurement$internal$zzhn();
                return;
            case 3:
                run$com$google$android$gms$measurement$internal$zzho();
                return;
            default:
                synchronized (this.zza) {
                    try {
                        try {
                            AtomicReference atomicReference = this.zza;
                            zzfr zzfrVar = (zzfr) this.zzb.mBuilder;
                            atomicReference.set(Double.valueOf(zzfrVar.zzk.zza(zzfrVar.zzh().zzl(), zzdu.zzN)));
                            this.zza.notify();
                        } catch (Throwable th) {
                            this.zza.notify();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
        }
    }
}
