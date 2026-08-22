package com.google.android.gms.measurement.internal;

import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzjo extends zzkh {
    public final zzes zza;
    public final zzes zzb;
    public final zzes zzc;
    public final zzes zzd;
    public final zzes zze;
    public final HashMap zzg;

    public zzjo(zzkt zzktVar) {
        super(zzktVar);
        this.zzg = new HashMap();
        zzew zzewVar = ((zzfr) this.mBuilder).zzl;
        zzfr.zzP(zzewVar);
        this.zza = new zzes(zzewVar, "last_delete_stale", 0L);
        zzew zzewVar2 = ((zzfr) this.mBuilder).zzl;
        zzfr.zzP(zzewVar2);
        this.zzb = new zzes(zzewVar2, "backoff", 0L);
        zzew zzewVar3 = ((zzfr) this.mBuilder).zzl;
        zzfr.zzP(zzewVar3);
        this.zzc = new zzes(zzewVar3, "last_upload", 0L);
        zzew zzewVar4 = ((zzfr) this.mBuilder).zzl;
        zzfr.zzP(zzewVar4);
        this.zzd = new zzes(zzewVar4, "last_upload_attempt", 0L);
        zzew zzewVar5 = ((zzfr) this.mBuilder).zzl;
        zzfr.zzP(zzewVar5);
        this.zze = new zzes(zzewVar5, "midnight_offset", 0L);
    }

    public final Pair zza(String str) {
        zzjn zzjnVar;
        zzg();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.zzr.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = this.zzg;
        zzjn zzjnVar2 = (zzjn) map.get(str);
        if (zzjnVar2 != null && jElapsedRealtime < zzjnVar2.zzc) {
            return new Pair(zzjnVar2.zza, Boolean.valueOf(zzjnVar2.zzb));
        }
        long jZzi = zzfrVar.zzk.zzi(str, zzdu.zza) + jElapsedRealtime;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzfrVar.zze);
            String str2 = advertisingIdInfo.zza;
            boolean z = advertisingIdInfo.zzb;
            zzjnVar = str2 != null ? new zzjn(z, str2, jZzi) : new zzjn(z, "", jZzi);
        } catch (Exception e) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zzb(e, "Unable to get advertising id");
            zzjnVar = new zzjn(false, "", jZzi);
        }
        map.put(str, zzjnVar);
        return new Pair(zzjnVar.zza, Boolean.valueOf(zzjnVar.zzb));
    }

    public final String zzf(String str, boolean z) {
        zzg();
        String str2 = z ? (String) zza(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestZzF = zzlb.zzF();
        if (messageDigestZzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzF.digest(str2.getBytes())));
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }
}
