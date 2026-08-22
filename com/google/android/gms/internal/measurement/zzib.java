package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzib {
    public static final /* synthetic */ int zzc = 0;
    private static volatile zzhz zze = null;
    private static volatile boolean zzf = false;
    final zzhy zza;
    final String zzb;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;
    private static final Object zzd = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzid zzh = new zzid(zzht.zza, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    public /* synthetic */ zzib(zzhy zzhyVar, String str, Object obj, boolean z, zzia zziaVar) {
        if (zzhyVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzhyVar;
        this.zzb = str;
        this.zzj = obj;
        this.zzm = true;
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zzd;
            synchronized (obj) {
                try {
                    if (zze == null) {
                        synchronized (obj) {
                            try {
                                zzhz zzhzVar = zze;
                                Context applicationContext = context.getApplicationContext();
                                if (applicationContext != null) {
                                    context = applicationContext;
                                }
                                if (zzhzVar == null || zzhzVar.zza() != context) {
                                    zzhf.zze();
                                    zzic.zzc();
                                    zzhn.zze();
                                    zze = new zzhc(context, zzim.zza(new zzii() { // from class: com.google.android.gms.internal.measurement.zzhs
                                        @Override // com.google.android.gms.internal.measurement.zzii
                                        public final Object zza() {
                                            Context context2 = context;
                                            int i = zzib.zzc;
                                            return zzho.zza(context2);
                                        }
                                    }));
                                    zzi.incrementAndGet();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public abstract Object zza(Object obj);

    /* JADX WARN: Code duplicated, block: B:41:0x009f  */
    public final Object zzb() {
        zzhk zzhkVarZza;
        Object objZzb;
        if (!this.zzm && this.zzb == null) {
            throw new NullPointerException("flagName must not be null");
        }
        int i = zzi.get();
        if (this.zzk < i) {
            synchronized (this) {
                try {
                    if (this.zzk < i) {
                        zzhz zzhzVar = zze;
                        if (zzhzVar == null) {
                            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                        }
                        zzhy zzhyVar = this.zza;
                        boolean z = zzhyVar.zzf;
                        if (zzhyVar.zzb == null) {
                            Context contextZza = zzhzVar.zza();
                            String str = this.zza.zza;
                            zzhkVarZza = zzic.zza(contextZza, null, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhr
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzib.zzd();
                                }
                            });
                        } else if (zzhp.zza(zzhzVar.zza(), this.zza.zzb)) {
                            boolean z2 = this.zza.zzh;
                            zzhkVarZza = zzhf.zza(zzhzVar.zza().getContentResolver(), this.zza.zzb, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhr
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzib.zzd();
                                }
                            });
                        } else {
                            zzhkVarZza = null;
                        }
                        Object objZza = (zzhkVarZza == null || (objZzb = zzhkVarZza.zzb(zzc())) == null) ? null : zza(objZzb);
                        if (objZza == null) {
                            if (this.zza.zze) {
                                objZza = null;
                            } else {
                                String strZzb = zzhn.zza(zzhzVar.zza()).zzb(this.zza.zze ? null : this.zzb);
                                if (strZzb != null) {
                                    objZza = zza(strZzb);
                                } else {
                                    objZza = null;
                                }
                            }
                            if (objZza == null) {
                                objZza = this.zzj;
                            }
                        }
                        zzig zzigVar = (zzig) zzhzVar.zzb().zza();
                        if (zzigVar.zzb()) {
                            zzhh zzhhVar = (zzhh) zzigVar.zza();
                            zzhy zzhyVar2 = this.zza;
                            String strZza = zzhhVar.zza(zzhyVar2.zzb, null, zzhyVar2.zzd, this.zzb);
                            objZza = strZza == null ? this.zzj : zza(strZza);
                        }
                        this.zzl = objZza;
                        this.zzk = i;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzl;
    }

    public final String zzc() {
        String str = this.zza.zzd;
        return this.zzb;
    }
}
