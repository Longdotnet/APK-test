package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzakd extends zzakh {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    public static boolean zzd(zzen zzenVar) {
        return zzk(zzenVar, zza);
    }

    private static boolean zzk(zzen zzenVar, byte[] bArr) {
        if (zzenVar.zza() < 8) {
            return false;
        }
        int iZzc = zzenVar.zzc();
        byte[] bArr2 = new byte[8];
        zzenVar.zzH(bArr2, 0, 8);
        zzenVar.zzL(iZzc);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final long zza(zzen zzenVar) {
        return zzg(zzaeq.zzd(zzenVar.zzN()));
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final boolean zzc(zzen zzenVar, long j, zzake zzakeVar) {
        if (zzk(zzenVar, zza)) {
            byte[] bArrCopyOf = Arrays.copyOf(zzenVar.zzN(), zzenVar.zzd());
            int i = bArrCopyOf[9] & 255;
            List listZze = zzaeq.zze(bArrCopyOf);
            if (zzakeVar.zza == null) {
                zzx zzxVar = new zzx();
                zzxVar.zzG("audio/ogg");
                zzxVar.zzah("audio/opus");
                zzxVar.zzD(i);
                zzxVar.zzai(48000);
                zzxVar.zzT(listZze);
                zzakeVar.zza = zzxVar.zzan();
                return true;
            }
        } else {
            if (!zzk(zzenVar, zzb)) {
                zzdd.zzb(zzakeVar.zza);
                return false;
            }
            zzdd.zzb(zzakeVar.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzenVar.zzM(8);
                zzav zzavVarZzb = zzafh.zzb(zzfyq.zzm(zzafh.zzc(zzenVar, false, false).zza));
                if (zzavVarZzb != null) {
                    zzx zzxVarZzb = zzakeVar.zza.zzb();
                    zzxVarZzb.zzaa(zzavVarZzb.zzd(zzakeVar.zza.zzl));
                    zzakeVar.zza = zzxVarZzb.zzan();
                }
            }
        }
        return true;
    }
}
