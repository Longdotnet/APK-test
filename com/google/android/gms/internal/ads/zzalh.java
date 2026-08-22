package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class zzalh implements zzakt {
    private final zzen zza = new zzen();
    private final zzen zzb = new zzen();
    private final zzalg zzc = new zzalg();
    private Inflater zzd;

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
        zzalg zzalgVar = this.zzc;
        zzalgVar.zze();
        ArrayList arrayList = new ArrayList();
        while (zzenVar.zza() >= 3) {
            int iZzd = zzenVar.zzd();
            int iZzm = zzenVar.zzm();
            int iZzq = zzenVar.zzq();
            int iZzc = zzenVar.zzc() + iZzq;
            zzcu zzcuVarZza = null;
            if (iZzc > iZzd) {
                zzenVar.zzL(iZzd);
            } else {
                if (iZzm != 128) {
                    switch (iZzm) {
                        case 20:
                            zzalg.zzd(zzalgVar, zzenVar, iZzq);
                            break;
                        case 21:
                            zzalg.zzb(zzalgVar, zzenVar, iZzq);
                            break;
                        case 22:
                            zzalg.zzc(zzalgVar, zzenVar, iZzq);
                            break;
                    }
                } else {
                    zzcuVarZza = zzalgVar.zza();
                    zzalgVar.zze();
                }
                zzenVar.zzL(iZzc);
            }
            if (zzcuVarZza != null) {
                arrayList.add(zzcuVarZza);
            }
        }
        zzdnVar.zza(new zzakl(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
