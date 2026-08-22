package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class zzagu implements zzau {
    public final String zza;
    public final String zzb;

    public zzagu(String str, String str2) {
        this.zza = zzfuv.zzb(str);
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagu zzaguVar = (zzagu) obj;
            if (this.zza.equals(zzaguVar.zza) && this.zzb.equals(zzaguVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        return this.zzb.hashCode() + (iHashCode * 31);
    }

    public final String toString() {
        return "VC: " + this.zza + "=" + this.zzb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0071  */
    @Override // com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        switch (this.zza) {
            case "TITLE":
                zzarVar.zzr(this.zzb);
                break;
            case "ARTIST":
                zzarVar.zze(this.zzb);
                break;
            case "ALBUM":
                zzarVar.zzd(this.zzb);
                break;
            case "ALBUMARTIST":
                zzarVar.zzc(this.zzb);
                break;
            case "TRACKNUMBER":
                Integer numZzg = zzgbt.zzg(this.zzb, 10);
                if (numZzg != null) {
                    zzarVar.zzu(numZzg);
                    break;
                }
                break;
            case "TOTALTRACKS":
                Integer numZzg2 = zzgbt.zzg(this.zzb, 10);
                if (numZzg2 != null) {
                    zzarVar.zzt(numZzg2);
                    break;
                }
                break;
            case "DISCNUMBER":
                Integer numZzg3 = zzgbt.zzg(this.zzb, 10);
                if (numZzg3 != null) {
                    zzarVar.zzi(numZzg3);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer numZzg4 = zzgbt.zzg(this.zzb, 10);
                if (numZzg4 != null) {
                    zzarVar.zzs(numZzg4);
                    break;
                }
                break;
            case "GENRE":
                zzarVar.zzj(this.zzb);
                break;
            case "DESCRIPTION":
                zzarVar.zzh(this.zzb);
                break;
        }
    }
}
