package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class zzajy extends zzakh {
    private zzaeg zza;
    private zzajx zzb;

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final long zza(zzen zzenVar) {
        if (!zzd(zzenVar.zzN())) {
            return -1L;
        }
        int i = (zzenVar.zzN()[2] & 255) >> 4;
        if (i == 6) {
            zzenVar.zzM(4);
            zzenVar.zzx();
        } else if (i == 7) {
            i = 7;
            zzenVar.zzM(4);
            zzenVar.zzx();
        }
        int iZza = zzaec.zza(zzenVar, i);
        zzenVar.zzL(0);
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final boolean zzc(zzen zzenVar, long j, zzake zzakeVar) {
        byte[] bArrZzN = zzenVar.zzN();
        zzaeg zzaegVar = this.zza;
        if (zzaegVar == null) {
            zzaeg zzaegVar2 = new zzaeg(bArrZzN, 17);
            this.zza = zzaegVar2;
            zzx zzxVarZzb = zzaegVar2.zzc(Arrays.copyOfRange(bArrZzN, 9, zzenVar.zzd()), null).zzb();
            zzxVarZzb.zzG(ZRqOdXiy.YcaaWT);
            zzakeVar.zza = zzxVarZzb.zzan();
            return true;
        }
        if ((bArrZzN[0] & 127) == 3) {
            zzaef zzaefVarZzb = zzaed.zzb(zzenVar);
            zzaeg zzaegVarZzf = zzaegVar.zzf(zzaefVarZzb);
            this.zza = zzaegVarZzf;
            this.zzb = new zzajx(zzaegVarZzf, zzaefVarZzb);
            return true;
        }
        if (!zzd(bArrZzN)) {
            return true;
        }
        zzajx zzajxVar = this.zzb;
        if (zzajxVar != null) {
            zzajxVar.zza(j);
            zzakeVar.zzb = this.zzb;
        }
        zzakeVar.zza.getClass();
        return false;
    }
}
