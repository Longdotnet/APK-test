package com.google.android.gms.internal.ads;

import com.google.protobuf.DescriptorProtos;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzat {
    public static final zzat zza = new zzat(new zzar());
    public final Integer zzA;
    public final zzfyq zzB;
    public final CharSequence zzb;
    public final CharSequence zzc;
    public final CharSequence zzd;
    public final CharSequence zze;
    public final CharSequence zzf;
    public final byte[] zzg;
    public final Integer zzh;
    public final Integer zzi;
    public final Integer zzj;

    @Deprecated
    public final Integer zzk;
    public final Boolean zzl;

    @Deprecated
    public final Integer zzm;
    public final Integer zzn;
    public final Integer zzo;
    public final Integer zzp;
    public final Integer zzq;
    public final Integer zzr;
    public final Integer zzs;
    public final CharSequence zzt;
    public final CharSequence zzu;
    public final CharSequence zzv;
    public final Integer zzw;
    public final Integer zzx;
    public final CharSequence zzy;
    public final CharSequence zzz;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
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
        Integer.toString(1000, 36);
    }

    public /* synthetic */ zzat(zzar zzarVar) {
        this(zzarVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzat.class == obj.getClass()) {
            zzat zzatVar = (zzat) obj;
            if (Objects.equals(this.zzb, zzatVar.zzb) && Objects.equals(this.zzc, zzatVar.zzc) && Objects.equals(this.zzd, zzatVar.zzd) && Objects.equals(this.zze, zzatVar.zze) && Objects.equals(this.zzf, zzatVar.zzf) && Arrays.equals(this.zzg, zzatVar.zzg) && Objects.equals(this.zzh, zzatVar.zzh) && Objects.equals(this.zzi, zzatVar.zzi) && Objects.equals(this.zzj, zzatVar.zzj) && Objects.equals(this.zzk, zzatVar.zzk) && Objects.equals(this.zzl, zzatVar.zzl) && Objects.equals(this.zzn, zzatVar.zzn) && Objects.equals(this.zzo, zzatVar.zzo) && Objects.equals(this.zzp, zzatVar.zzp) && Objects.equals(this.zzq, zzatVar.zzq) && Objects.equals(this.zzr, zzatVar.zzr) && Objects.equals(this.zzs, zzatVar.zzs) && Objects.equals(this.zzt, zzatVar.zzt) && Objects.equals(this.zzu, zzatVar.zzu) && Objects.equals(this.zzv, zzatVar.zzv) && Objects.equals(this.zzw, zzatVar.zzw) && Objects.equals(this.zzx, zzatVar.zzx) && Objects.equals(this.zzy, zzatVar.zzy) && Objects.equals(this.zzz, zzatVar.zzz) && Objects.equals(this.zzA, zzatVar.zzA) && Objects.equals(this.zzB, zzatVar.zzB)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zzb, this.zzc, this.zzd, this.zze, null, null, this.zzf, null, null, null, Integer.valueOf(Arrays.hashCode(this.zzg)), this.zzh, null, this.zzi, this.zzj, this.zzk, this.zzl, null, this.zzn, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx, this.zzy, null, this.zzz, this.zzA, Boolean.TRUE, this.zzB);
    }

    public final zzar zza() {
        return new zzar(this, null);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    zzat(zzar zzarVar) {
        Boolean boolValueOf = zzarVar.zzk;
        Integer numValueOf = zzarVar.zzj;
        Integer numValueOf2 = zzarVar.zzy;
        int i = 1;
        int i2 = 0;
        if (boolValueOf != null) {
            if (!boolValueOf.booleanValue()) {
                numValueOf = -1;
            } else if (numValueOf == null || numValueOf.intValue() == -1) {
                if (numValueOf2 != null) {
                    switch (numValueOf2.intValue()) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        case 20:
                        default:
                            i = 0;
                            break;
                        case 21:
                            i = 2;
                            break;
                        case 22:
                            i = 3;
                            break;
                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                            i = 4;
                            break;
                        case 24:
                            i = 5;
                            break;
                        case 25:
                            i = 6;
                            break;
                    }
                } else {
                    i = 0;
                }
                numValueOf = Integer.valueOf(i);
            }
        } else if (numValueOf != null) {
            boolean z = numValueOf.intValue() != -1;
            boolValueOf = Boolean.valueOf(z);
            if (z && numValueOf2 == null) {
                switch (numValueOf.intValue()) {
                    case 1:
                        break;
                    case 2:
                        i2 = 21;
                        break;
                    case 3:
                        i2 = 22;
                        break;
                    case 4:
                        i2 = 23;
                        break;
                    case 5:
                        i2 = 24;
                        break;
                    case 6:
                        i2 = 25;
                        break;
                    default:
                        i2 = 20;
                        break;
                }
                numValueOf2 = Integer.valueOf(i2);
            }
        } else {
            numValueOf = null;
        }
        this.zzb = zzarVar.zza;
        this.zzc = zzarVar.zzb;
        this.zzd = zzarVar.zzc;
        this.zze = zzarVar.zzd;
        this.zzf = zzarVar.zze;
        this.zzg = zzarVar.zzf;
        this.zzh = zzarVar.zzg;
        this.zzi = zzarVar.zzh;
        this.zzj = zzarVar.zzi;
        this.zzk = numValueOf;
        this.zzl = boolValueOf;
        this.zzm = zzarVar.zzl;
        this.zzn = zzarVar.zzl;
        this.zzo = zzarVar.zzm;
        this.zzp = zzarVar.zzn;
        this.zzq = zzarVar.zzo;
        this.zzr = zzarVar.zzp;
        this.zzs = zzarVar.zzq;
        this.zzt = zzarVar.zzr;
        this.zzu = zzarVar.zzs;
        this.zzv = zzarVar.zzt;
        this.zzw = zzarVar.zzu;
        this.zzx = zzarVar.zzv;
        this.zzy = zzarVar.zzw;
        this.zzz = zzarVar.zzx;
        this.zzA = numValueOf2;
        this.zzB = zzarVar.zzz;
    }
}
