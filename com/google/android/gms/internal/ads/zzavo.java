package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes.dex */
public final class zzavo {
    protected volatile Boolean zzb;
    private final zzawx zze;
    private static final ConditionVariable zzc = new ConditionVariable();
    protected static volatile zzfqi zza = null;
    private static volatile Random zzd = null;

    public zzavo(zzawx zzawxVar) {
        this.zze = zzawxVar;
        zzawxVar.zzj().execute(new zzavn(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zzd == null) {
                synchronized (zzavo.class) {
                    try {
                        if (zzd == null) {
                            zzd = new Random();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzd.nextInt();
        }
    }

    public final void zzc(int i, int i2, long j, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzarz zzarzVarZza = zzasd.zza();
            zzarzVarZza.zza(this.zze.zza.getPackageName());
            zzarzVarZza.zze(j);
            if (str != null) {
                zzarzVarZza.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzarzVarZza.zzf(stringWriter.toString());
                zzarzVarZza.zzd(exc.getClass().getName());
            }
            zzfqg zzfqgVarZza = zza.zza(((zzasd) zzarzVarZza.zzbr()).zzaV());
            zzfqgVarZza.zza(i);
            if (i2 != -1) {
                zzfqgVarZza.zzb(i2);
            }
            zzfqgVarZza.zzc();
        } catch (Exception unused) {
        }
    }
}
