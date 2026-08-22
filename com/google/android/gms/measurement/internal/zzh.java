package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    public long zzA;
    public String zzB;
    public boolean zzC;
    public long zzD;
    public long zzE;
    public final zzfr zza;
    public final String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public long zzg;
    public long zzh;
    public long zzi;
    public String zzj;
    public long zzk;
    public String zzl;
    public long zzm;
    public long zzn;
    public boolean zzo;
    public boolean zzp;
    public String zzq;
    public Boolean zzr;
    public long zzs;
    public ArrayList zzt;
    public String zzu;
    public long zzv;
    public long zzw;
    public long zzx;
    public long zzy;
    public long zzz;

    public zzh(zzfr zzfrVar, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzfrVar);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = zzfrVar;
        this.zzb = str;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
    }

    public final void zzE() {
        zzfr zzfrVar = this.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(zzeh.zzn(this.zzb), "Bundle index overflow. appId");
            j = 0;
        }
        this.zzC = true;
        this.zzg = j;
    }

    public final void zzF(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzg.zza(this.zzq, str);
        this.zzq = str;
    }

    public final void zzH(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !zzg.zza(this.zzc, str);
        this.zzc = str;
    }

    public final void zzI(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !zzg.zza(this.zzl, str);
        this.zzl = str;
    }

    public final void zzJ(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !zzg.zza(this.zzj, str);
        this.zzj = str;
    }

    public final void zzK(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzk != j;
        this.zzk = j;
    }

    public final void zzL(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzD != j;
        this.zzD = j;
    }

    public final void zzM(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzy != j;
        this.zzy = j;
    }

    public final void zzN(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzz != j;
        this.zzz = j;
    }

    public final void zzO(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzx != j;
        this.zzx = j;
    }

    public final void zzP(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzw != j;
        this.zzw = j;
    }

    public final void zzQ(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzA != j;
        this.zzA = j;
    }

    public final void zzR(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzv != j;
        this.zzv = j;
    }

    public final void zzS(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzn != j;
        this.zzn = j;
    }

    public final void zzT(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzs != j;
        this.zzs = j;
    }

    public final void zzU(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzE != j;
        this.zzE = j;
    }

    public final void zzV(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !zzg.zza(this.zzf, str);
        this.zzf = str;
    }

    public final void zzW(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzg.zza(this.zzd, str);
        this.zzd = str;
    }

    public final void zzX(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzm != j;
        this.zzm = j;
    }

    public final void zzY(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !zzg.zza(this.zzB, str);
        this.zzB = str;
    }

    public final void zzZ(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzi != j;
        this.zzi = j;
    }

    public final void zzaa(long j) {
        com.google.android.gms.common.internal.zzah.checkArgument(j >= 0);
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzg != j;
        this.zzg = j;
    }

    public final void zzab(long j) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzh != j;
        this.zzh = j;
    }

    public final void zzac(boolean z) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzae(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !zzg.zza(this.zze, str);
        this.zze = str;
    }

    public final void zzaf(List list) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (zzg.zza(this.zzt, list)) {
            return;
        }
        this.zzC = true;
        this.zzt = list != null ? new ArrayList(list) : null;
    }

    public final boolean zzah() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzp;
    }

    public final long zzb() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzk;
    }

    public final long zzk() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzs;
    }

    public final String zzr() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzq;
    }

    public final String zzs() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        String str = this.zzB;
        zzY(null);
        return str;
    }

    public final String zzt() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzb;
    }

    public final String zzu() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzc;
    }

    public final String zzw() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzj;
    }

    public final String zzx() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzf;
    }

    public final String zzy() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzd;
    }
}
