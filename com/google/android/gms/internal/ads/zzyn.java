package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzyn extends zzyp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzyn(int i, zzbm zzbmVar, int i2, zzyi zzyiVar, int i3, String str, String str2) {
        int iZzc;
        super(i, zzbmVar, i2);
        int i4 = 0;
        this.zzf = zzmb.zza(i3, false);
        int i5 = this.zzd.zze;
        int i6 = zzyiVar.zzy;
        this.zzg = 1 == (i5 & 1);
        this.zzh = (i5 & 2) != 0;
        zzfyq zzfyqVarZzo = str2 != null ? zzfyq.zzo(str2) : zzyiVar.zzv.isEmpty() ? zzfyq.zzo("") : zzyiVar.zzv;
        int i7 = 0;
        while (true) {
            if (i7 >= zzfyqVarZzo.size()) {
                i7 = Integer.MAX_VALUE;
                iZzc = 0;
                break;
            } else {
                iZzc = zzyu.zzc(this.zzd, (String) zzfyqVarZzo.get(i7), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        this.zzi = i7;
        this.zzj = iZzc;
        int iZzb = zzyu.zzb(this.zzd.zzf, str2 != null ? 1088 : 0);
        this.zzk = iZzb;
        this.zzm = (1088 & this.zzd.zzf) != 0;
        int iZzc2 = zzyu.zzc(this.zzd, str, zzyu.zzh(str) == null);
        this.zzl = iZzc2;
        boolean z = iZzc > 0 || (zzyiVar.zzv.isEmpty() && iZzb > 0) || this.zzg || (this.zzh && iZzc2 > 0);
        if (zzmb.zza(i3, zzyiVar.zzR) && z) {
            i4 = 1;
        }
        this.zze = i4;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzyn zzynVar) {
        zzfyf zzfyfVarZzc = zzfyf.zzj().zzd(this.zzf, zzynVar.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzynVar.zzi), zzgab.zzc().zza());
        int i = this.zzj;
        zzfyf zzfyfVarZzb = zzfyfVarZzc.zzb(i, zzynVar.zzj);
        int i2 = this.zzk;
        zzfyf zzfyfVarZzb2 = zzfyfVarZzb.zzb(i2, zzynVar.zzk).zzd(this.zzg, zzynVar.zzg).zzc(Boolean.valueOf(this.zzh), Boolean.valueOf(zzynVar.zzh), i == 0 ? zzgab.zzc() : zzgab.zzc().zza()).zzb(this.zzl, zzynVar.zzl);
        if (i2 == 0) {
            zzfyfVarZzb2 = zzfyfVarZzb2.zze(this.zzm, zzynVar.zzm);
        }
        return zzfyfVarZzb2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ boolean zzc(zzyp zzypVar) {
        return false;
    }
}
