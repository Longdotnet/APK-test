package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzbao implements Comparator {
    public zzbao(zzbap zzbapVar) {
        Objects.requireNonNull(zzbapVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbad zzbadVar = (zzbad) obj;
        zzbad zzbadVar2 = (zzbad) obj2;
        if (zzbadVar.zzd() < zzbadVar2.zzd()) {
            return -1;
        }
        if (zzbadVar.zzd() <= zzbadVar2.zzd()) {
            if (zzbadVar.zzb() < zzbadVar2.zzb()) {
                return -1;
            }
            if (zzbadVar.zzb() <= zzbadVar2.zzb()) {
                float fZza = (zzbadVar.zza() - zzbadVar.zzd()) * (zzbadVar.zzc() - zzbadVar.zzb());
                float fZza2 = (zzbadVar2.zza() - zzbadVar2.zzd()) * (zzbadVar2.zzc() - zzbadVar2.zzb());
                if (fZza > fZza2) {
                    return -1;
                }
                if (fZza >= fZza2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
