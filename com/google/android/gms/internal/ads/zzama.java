package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class zzama implements zzakt {
    private final zzen zza = new zzen();
    private final zzen zzb = new zzen();
    private final zzalz zzc;
    private Inflater zzd;

    public zzama(List list) {
        zzalz zzalzVar = new zzalz();
        this.zzc = zzalzVar;
        zzalzVar.zzb(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i2 + i);
        zzenVar.zzL(i);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzen zzenVar2 = this.zzb;
        if (zzex.zzO(zzenVar, zzenVar2, this.zzd)) {
            zzenVar.zzJ(zzenVar2.zzN(), zzenVar2.zzd());
        }
        zzalz zzalzVar = this.zzc;
        zzalzVar.zzd();
        int iZza = zzenVar.zza();
        zzcu zzcuVarZza = null;
        if (iZza >= 2 && zzenVar.zzq() == iZza) {
            zzalzVar.zzc(zzenVar);
            zzcuVarZza = zzalzVar.zza(zzenVar);
        }
        zzdnVar.zza(new zzakl(zzcuVarZza != null ? zzfyq.zzo(zzcuVarZza) : zzfyq.zzn(), -9223372036854775807L, 5000000L));
    }
}
