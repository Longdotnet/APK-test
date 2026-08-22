package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzakn {
    public static void zza(zzako zzakoVar, zzaks zzaksVar, zzdn zzdnVar) {
        for (int i = 0; i < zzakoVar.zza(); i++) {
            long jZzb = zzakoVar.zzb(i);
            List listZzc = zzakoVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i == zzakoVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzakoVar.zzb(i + 1) - zzakoVar.zzb(i);
                if (jZzb2 > 0) {
                    zzdnVar.zza(new zzakl(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
