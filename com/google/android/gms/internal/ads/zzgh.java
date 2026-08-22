package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public final class zzgh extends zzgc {
    private zzgo zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgh() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        String str = zzex.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws zzaz, zzgk {
        zzi(zzgoVar);
        this.zza = zzgoVar;
        Uri uriNormalizeScheme = zzgoVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzdd.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        String str = zzex.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzaz.zzb("Unexpected URI format: ".concat(String.valueOf(uriNormalizeScheme)), null);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str2, 0);
            } catch (IllegalArgumentException e) {
                throw zzaz.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str2)), e);
            }
        } else {
            this.zzb = URLDecoder.decode(str2, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        long j = zzgoVar.zze;
        int length = this.zzb.length;
        if (j > length) {
            this.zzb = null;
            throw new zzgk(2008);
        }
        int i = (int) j;
        this.zzc = i;
        int i2 = length - i;
        this.zzd = i2;
        long j2 = zzgoVar.zzf;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i2, j2);
        }
        zzj(zzgoVar);
        return j2 != -1 ? j2 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        zzgo zzgoVar = this.zza;
        if (zzgoVar != null) {
            return zzgoVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
