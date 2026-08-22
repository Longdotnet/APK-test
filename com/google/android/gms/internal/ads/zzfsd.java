package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class zzfsd {
    static final String zza = new UUID(0, 0).toString();
    final zzfsc zzb;
    final zzfsb zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;

    public zzfsd(Context context, String str, String str2, String str3) {
        this.zzb = zzfsc.zzb(context);
        this.zzc = zzfsb.zza(context);
        this.zzd = str;
        this.zze = str.concat("_3p");
        this.zzf = str2;
        this.zzg = str2.concat("_3p");
        this.zzh = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            return UUID.nameUUIDFromBytes(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, str2, str3).getBytes(StandardCharsets.UTF_8)).toString();
        }
        String str4 = this.zzh;
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
        sb.append(str2 == null ? "null" : "not null");
        sb.append(", hashKey is ");
        sb.append(str3 == null ? "null" : "not null");
        throw new IllegalArgumentException(sb.toString());
    }

    public final long zza(boolean z) {
        return this.zzb.zza(z ? this.zzg : this.zzf, -1L);
    }

    public final zzfsa zzb(String str, String str2, long j, boolean z) throws IOException {
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String strZze = zze(true);
                    String strZzc = this.zzb.zzc("paid_3p_hash_key", null);
                    if (strZze != null && strZzc != null && !strZze.equals(zzh(str, str2, strZzc))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfsa();
        }
        boolean z2 = str != null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzh.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        long jZza = zza(z2);
        if (jZza != -1) {
            if (jCurrentTimeMillis < jZza) {
                this.zzb.zzd(z2 ? this.zzg : this.zzf, Long.valueOf(jCurrentTimeMillis));
            } else if (jCurrentTimeMillis >= jZza + j) {
                return zzc(str, str2);
            }
        }
        String strZze2 = zze(z2);
        return (strZze2 != null || z) ? new zzfsa(strZze2, zza(z2)) : zzc(str, str2);
    }

    public final zzfsa zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String string = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", string);
        return zzd(zzh(str, str2, string), true);
    }

    public final zzfsa zzd(String str, boolean z) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzh.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        zzfsc zzfscVar = this.zzb;
        zzfscVar.zzd(z ? this.zzg : this.zzf, Long.valueOf(jCurrentTimeMillis));
        zzfscVar.zzd(z ? this.zze : this.zzd, str);
        return new zzfsa(str, jCurrentTimeMillis);
    }

    public final String zze(boolean z) {
        return this.zzb.zzc(z ? this.zze : this.zzd, null);
    }

    public final void zzf(boolean z) throws IOException {
        String str = z ? this.zzg : this.zzf;
        zzfsc zzfscVar = this.zzb;
        zzfscVar.zze(str);
        zzfscVar.zze(z ? this.zze : this.zzd);
    }

    public final boolean zzg(boolean z) {
        return this.zzb.zzg(this.zzd);
    }
}
