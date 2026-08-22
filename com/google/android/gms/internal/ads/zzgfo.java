package com.google.android.gms.internal.ads;

import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgfo {
    public static byte[] zzb(zzgfm zzgfmVar) {
        return ((zzgoy) zzgny.zzc().zze(zzgfmVar, zzgoy.class)).zzc().zzaV();
    }

    public static zzgfm zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzguf zzgufVarZzf = zzguf.zzf(bArr, zzgyr.zza());
            zzgny zzgnyVarZzc = zzgny.zzc();
            zzgoy zzgoyVarZza = zzgoy.zza(zzgufVarZzf);
            if (!zzgnyVarZzc.zzk(zzgoyVarZza)) {
                return new zzgne(zzgoyVarZza);
            }
            return zzgnyVarZzc.zzb(zzgoyVarZza);
        } catch (IOException e) {
            throw new GeneralSecurityException(YcVWhnLsj.GgAcBkUM, e);
        }
    }
}
