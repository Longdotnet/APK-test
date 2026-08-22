package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzuk implements zzwz {
    public final zzwz zza;
    final /* synthetic */ zzul zzb;
    private boolean zzc;

    public zzuk(zzul zzulVar, zzwz zzwzVar) {
        Objects.requireNonNull(zzulVar);
        this.zzb = zzulVar;
        this.zza = zzwzVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0039  */
    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zza(zzkv zzkvVar, zzhs zzhsVar, int i) {
        zzul zzulVar = this.zzb;
        if (zzulVar.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhsVar.zzc(4);
            return -4;
        }
        long jZzb = zzulVar.zzb();
        int iZza = this.zza.zza(zzkvVar, zzhsVar, i);
        if (iZza != -5) {
            long j = zzulVar.zzb;
            if (j == Long.MIN_VALUE || ((iZza != -4 || zzhsVar.zze < j) && !(iZza == -3 && jZzb == Long.MIN_VALUE && !zzhsVar.zzd))) {
                return iZza;
            }
            zzhsVar.zzb();
            zzhsVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        zzz zzzVar = zzkvVar.zza;
        zzzVar.getClass();
        int i2 = zzzVar.zzJ;
        if (i2 != 0) {
            int i3 = zzulVar.zzb == Long.MIN_VALUE ? zzzVar.zzK : 0;
            zzx zzxVarZzb = zzzVar.zzb();
            zzxVarZzb.zzM(i2);
            zzxVarZzb.zzN(i3);
            zzkvVar.zza = zzxVarZzb.zzan();
        } else if (zzzVar.zzK != 0) {
            i2 = 0;
            if (zzulVar.zzb == Long.MIN_VALUE) {
            }
            zzx zzxVarZzb2 = zzzVar.zzb();
            zzxVarZzb2.zzM(i2);
            zzxVarZzb2.zzN(i3);
            zzkvVar.zza = zzxVarZzb2.zzan();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzd() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
