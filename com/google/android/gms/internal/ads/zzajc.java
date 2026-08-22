package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzajc {
    public final zzafb zza;
    public zzajs zzd;
    public zzaiy zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final String zzj;
    private boolean zzm;
    public final zzajr zzb = new zzajr();
    public final zzen zzc = new zzen();
    private final zzen zzk = new zzen(1);
    private final zzen zzl = new zzen();

    public zzajc(zzafb zzafbVar, zzajs zzajsVar, zzaiy zzaiyVar, String str) {
        this.zza = zzafbVar;
        this.zzd = zzajsVar;
        this.zze = zzaiyVar;
        this.zzj = str;
        zzh(zzajsVar, zzaiyVar);
    }

    public final int zza() {
        int i;
        if (this.zzm) {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        } else {
            i = this.zzd.zzg[this.zzf];
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        return !this.zzm ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzen zzenVar;
        zzajq zzajqVarZzf = zzf();
        if (zzajqVarZzf == null) {
            return 0;
        }
        int i3 = zzajqVarZzf.zzd;
        if (i3 != 0) {
            zzenVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzajqVarZzf.zze;
            String str = zzex.zza;
            zzen zzenVar2 = this.zzl;
            int length = bArr.length;
            zzenVar2.zzJ(bArr, length);
            zzenVar = zzenVar2;
            i3 = length;
        }
        zzajr zzajrVar = this.zzb;
        boolean zZzb = zzajrVar.zzb(this.zzf);
        boolean z = zZzb || i2 != 0;
        zzen zzenVar3 = this.zzk;
        zzenVar3.zzN()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzenVar3.zzL(0);
        zzafb zzafbVar = this.zza;
        zzafbVar.zzs(zzenVar3, 1, 1);
        zzafbVar.zzs(zzenVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zZzb) {
            zzen zzenVar4 = this.zzc;
            zzenVar4.zzI(8);
            byte[] bArrZzN = zzenVar4.zzN();
            bArrZzN[0] = 0;
            bArrZzN[1] = 1;
            bArrZzN[2] = 0;
            bArrZzN[3] = (byte) i2;
            bArrZzN[4] = (byte) ((i >> 24) & 255);
            bArrZzN[5] = (byte) ((i >> 16) & 255);
            bArrZzN[6] = (byte) ((i >> 8) & 255);
            bArrZzN[7] = (byte) (i & 255);
            zzafbVar.zzs(zzenVar4, 8, 1);
            return i3 + 9;
        }
        int i4 = i3 + 1;
        zzen zzenVar5 = zzajrVar.zzn;
        int iZzq = zzenVar5.zzq();
        zzenVar5.zzM(-2);
        int i5 = (iZzq * 6) + 2;
        if (i2 != 0) {
            zzen zzenVar6 = this.zzc;
            zzenVar6.zzI(i5);
            byte[] bArrZzN2 = zzenVar6.zzN();
            zzenVar5.zzH(bArrZzN2, 0, i5);
            int i6 = (((bArrZzN2[2] & 255) << 8) | (bArrZzN2[3] & 255)) + i2;
            bArrZzN2[2] = (byte) ((i6 >> 8) & 255);
            bArrZzN2[3] = (byte) (i6 & 255);
            zzenVar5 = zzenVar6;
        }
        zzafbVar.zzs(zzenVar5, i5, 1);
        return i4 + i5;
    }

    public final long zzd() {
        return !this.zzm ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzm) {
            return this.zzd.zzf[this.zzf];
        }
        zzajr zzajrVar = this.zzb;
        return zzajrVar.zzi[this.zzf];
    }

    public final zzajq zzf() {
        if (!this.zzm) {
            return null;
        }
        zzajr zzajrVar = this.zzb;
        zzaiy zzaiyVar = zzajrVar.zza;
        String str = zzex.zza;
        int i = zzaiyVar.zza;
        zzajq zzajqVarZzb = zzajrVar.zzm;
        if (zzajqVarZzb == null) {
            zzajqVarZzb = this.zzd.zza.zzb(i);
        }
        if (zzajqVarZzb == null || !zzajqVarZzb.zza) {
            return null;
        }
        return zzajqVarZzb;
    }

    public final void zzh(zzajs zzajsVar, zzaiy zzaiyVar) {
        this.zzd = zzajsVar;
        this.zze = zzaiyVar;
        zzx zzxVarZzb = zzajsVar.zza.zzg.zzb();
        zzxVarZzb.zzG(this.zzj);
        this.zza.zzm(zzxVarZzb.zzan());
        zzi();
    }

    public final void zzi() {
        zzajr zzajrVar = this.zzb;
        zzajrVar.zzd = 0;
        zzajrVar.zzp = 0L;
        zzajrVar.zzq = false;
        zzajrVar.zzk = false;
        zzajrVar.zzo = false;
        zzajrVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzm = false;
    }

    public final void zzj(zzs zzsVar) {
        zzajp zzajpVar = this.zzd.zza;
        zzaiy zzaiyVar = this.zzb.zza;
        String str = zzex.zza;
        zzajq zzajqVarZzb = zzajpVar.zzb(zzaiyVar.zza);
        zzs zzsVarZzb = zzsVar.zzb(zzajqVarZzb != null ? zzajqVarZzb.zzb : null);
        zzz zzzVar = this.zzd.zza.zzg;
        String str2 = this.zzj;
        zzx zzxVarZzb = zzzVar.zzb();
        zzxVarZzb.zzG(str2);
        zzxVarZzb.zzL(zzsVarZzb);
        this.zza.zzm(zzxVarZzb.zzan());
    }

    public final boolean zzl() {
        this.zzf++;
        if (!this.zzm) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
