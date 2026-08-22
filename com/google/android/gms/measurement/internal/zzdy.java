package com.google.android.gms.measurement.internal;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzdy extends zzf {
    public String zza;
    public String zzb;
    public int zzc;
    public String zzd;
    public long zzf;
    public final long zzg;
    public List zzh;
    public String zzi;
    public int zzj;
    public String zzk;
    public String zzl;
    public String zzm;
    public long zzn;
    public String zzo;

    public zzdy(zzfr zzfrVar, long j) {
        super(zzfrVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return true;
    }

    public final String zzl() {
        zza();
        com.google.android.gms.common.internal.zzah.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzg();
        zza();
        com.google.android.gms.common.internal.zzah.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final void zzo() {
        String str;
        zzg();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        boolean zZzi = zzewVar.zzc().zzi(zzah.ANALYTICS_STORAGE);
        zzeh zzehVar = zzfrVar.zzm;
        if (zZzi) {
            byte[] bArr = new byte[16];
            zzlb zzlbVar = zzfrVar.zzp;
            zzfr.zzP(zzlbVar);
            zzlbVar.zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.zzm = str;
        zzfrVar.zzr.getClass();
        this.zzn = System.currentTimeMillis();
    }
}
