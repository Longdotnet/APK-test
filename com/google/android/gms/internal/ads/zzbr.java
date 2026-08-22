package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzbr {
    public final zzfyt zzD;
    public final zzfyv zzE;
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zzi;
    public final int zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final zzfyq zzm;
    public final zzfyq zzn;
    public final zzfyq zzp;
    public final int zzr;
    public final int zzs;
    public final zzfyq zzt;
    public final zzbp zzu;
    public final zzfyq zzv;
    public final boolean zzx;
    public final int zze = 0;
    public final int zzf = 0;
    public final int zzg = 0;
    public final int zzh = 0;
    public final int zzo = 0;
    public final int zzq = 0;
    public final int zzw = 0;
    public final int zzy = 0;
    public final boolean zzz = false;
    public final boolean zzA = false;
    public final boolean zzB = false;
    public final boolean zzC = false;

    static {
        new zzbr(new zzbq());
        String str = zzex.zza;
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
    }

    public zzbr(zzbq zzbqVar) {
        this.zza = zzbqVar.zza;
        this.zzb = zzbqVar.zzb;
        this.zzc = zzbqVar.zzc;
        this.zzd = zzbqVar.zzd;
        this.zzi = zzbqVar.zze;
        this.zzj = zzbqVar.zzf;
        this.zzk = zzbqVar.zzg;
        this.zzl = zzbqVar.zzh;
        this.zzm = zzbqVar.zzi;
        this.zzn = zzbqVar.zzj;
        this.zzp = zzbqVar.zzk;
        this.zzr = zzbqVar.zzl;
        this.zzs = zzbqVar.zzm;
        this.zzt = zzbqVar.zzn;
        this.zzu = zzbqVar.zzo;
        this.zzv = zzbqVar.zzp;
        this.zzx = zzbqVar.zzq;
        this.zzD = zzfyt.zzc(zzbqVar.zzr);
        this.zzE = zzfyv.zzl(zzbqVar.zzs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbr zzbrVar = (zzbr) obj;
            if (this.zza == zzbrVar.zza && this.zzb == zzbrVar.zzb && this.zzc == zzbrVar.zzc && this.zzd == zzbrVar.zzd && this.zzl == zzbrVar.zzl && this.zzi == zzbrVar.zzi && this.zzj == zzbrVar.zzj && this.zzk == zzbrVar.zzk && this.zzm.equals(zzbrVar.zzm) && this.zzn.equals(zzbrVar.zzn) && this.zzp.equals(zzbrVar.zzp) && this.zzr == zzbrVar.zzr && this.zzs == zzbrVar.zzs && this.zzt.equals(zzbrVar.zzt) && this.zzu.equals(zzbrVar.zzu) && this.zzv.equals(zzbrVar.zzv) && this.zzx == zzbrVar.zzx && this.zzD.equals(zzbrVar.zzD) && this.zzE.equals(zzbrVar.zzE)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((((((this.zza + 31) * 31) + this.zzb) * 31) + this.zzc) * 31) + this.zzd;
        zzfyq zzfyqVar = this.zzm;
        int iHashCode = zzfyqVar.hashCode() + (((((((((i * 28629151) + (this.zzl ? 1 : 0)) * 31) + this.zzi) * 31) + this.zzj) * 31) + (this.zzk ? 1 : 0)) * 31);
        int iHashCode2 = this.zzn.hashCode() + (iHashCode * 31);
        int iHashCode3 = this.zzp.hashCode() + (iHashCode2 * 961);
        zzfyq zzfyqVar2 = this.zzt;
        int iHashCode4 = (zzfyqVar2.hashCode() + (((((iHashCode3 * 961) + this.zzr) * 31) + this.zzs) * 31)) * 31;
        int iHashCode5 = ((this.zzv.hashCode() + ((iHashCode4 + 29791) * 31)) * 961) + (this.zzx ? 1 : 0);
        int iHashCode6 = this.zzD.hashCode() + (iHashCode5 * 887503681);
        return this.zzE.hashCode() + (iHashCode6 * 31);
    }
}
