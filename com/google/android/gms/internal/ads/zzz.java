package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzz {
    public static final /* synthetic */ int zzO = 0;
    public final int zzA;
    public final float zzB;
    public final byte[] zzC;
    public final int zzD;
    public final zzk zzE;
    public final int zzF;
    public final int zzG;
    public final int zzH;
    public final int zzI;
    public final int zzJ;
    public final int zzK;
    public final int zzL;
    public final int zzM;
    public final int zzN;
    private int zzP;
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final String zzk;
    public final zzav zzl;
    public final Object zzm;
    public final String zzn;
    public final String zzo;
    public final int zzp;
    public final int zzq;
    public final List zzr;
    public final zzs zzs;
    public final long zzt;
    public final boolean zzu;
    public final int zzv;
    public final int zzw;
    public final int zzx;
    public final int zzy;
    public final float zzz;

    static {
        new zzz(new zzx());
        String str = zzex.zza;
        Integer.toString(0, 36);
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
        Integer.toString(35, 36);
        Integer.toString(36, 36);
    }

    public /* synthetic */ zzz(zzx zzxVar) {
        this(zzxVar);
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzz.class == obj.getClass()) {
            zzz zzzVar = (zzz) obj;
            int i2 = this.zzP;
            if ((i2 == 0 || (i = zzzVar.zzP) == 0 || i2 == i) && this.zze == zzzVar.zze && this.zzf == zzzVar.zzf && this.zzg == zzzVar.zzg && this.zzh == zzzVar.zzh && this.zzi == zzzVar.zzi && this.zzp == zzzVar.zzp && this.zzt == zzzVar.zzt && this.zzv == zzzVar.zzv && this.zzw == zzzVar.zzw && this.zzx == zzzVar.zzx && this.zzy == zzzVar.zzy && this.zzA == zzzVar.zzA && this.zzD == zzzVar.zzD && this.zzF == zzzVar.zzF && this.zzG == zzzVar.zzG && this.zzH == zzzVar.zzH && this.zzI == zzzVar.zzI && this.zzJ == zzzVar.zzJ && this.zzK == zzzVar.zzK && this.zzL == zzzVar.zzL && this.zzN == zzzVar.zzN && Float.compare(this.zzz, zzzVar.zzz) == 0 && Float.compare(this.zzB, zzzVar.zzB) == 0 && Objects.equals(this.zza, zzzVar.zza) && Objects.equals(this.zzb, zzzVar.zzb) && this.zzc.equals(zzzVar.zzc) && Objects.equals(this.zzk, zzzVar.zzk) && Objects.equals(this.zzn, zzzVar.zzn) && Objects.equals(this.zzo, zzzVar.zzo) && Objects.equals(this.zzd, zzzVar.zzd) && Arrays.equals(this.zzC, zzzVar.zzC) && Objects.equals(this.zzl, zzzVar.zzl) && Objects.equals(this.zzE, zzzVar.zzE) && Objects.equals(this.zzs, zzzVar.zzs) && zzd(zzzVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzP;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        int iHashCode2 = this.zzc.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode + 527, 31, str2 == null ? 0 : str2.hashCode(), 31);
        String str3 = this.zzd;
        int iM = (((((((((CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode2, 31, str3 == null ? 0 : str3.hashCode(), 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        int iHashCode3 = (iM + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzav zzavVar = this.zzl;
        int iHashCode4 = iHashCode3 + (zzavVar == null ? 0 : zzavVar.hashCode());
        String str5 = this.zzn;
        int iM2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode4, 961, str5 == null ? 0 : str5.hashCode(), 31);
        String str6 = this.zzo;
        int iFloatToIntBits = ((((((((((((((((((((((Float.floatToIntBits(this.zzB) + ((((Float.floatToIntBits(this.zzz) + ((((((((((((((iM2 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.zzp) * 31) + ((int) this.zzt)) * 31) + this.zzv) * 31) + this.zzw) * 31) + this.zzx) * 31) + this.zzy) * 31)) * 31) + this.zzA) * 31)) * 31) + this.zzD) * 31) + this.zzF) * 31) + this.zzG) * 31) + this.zzH) * 31) + this.zzI) * 31) + this.zzJ) * 31) + this.zzK) * 31) + this.zzL) * 31) - 1) * 31) - 1) * 31) + this.zzN;
        this.zzP = iFloatToIntBits;
        return iFloatToIntBits;
    }

    public final int zza() {
        int i;
        int i2 = this.zzv;
        if (i2 == -1 || (i = this.zzw) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final zzx zzb() {
        return new zzx(this, null);
    }

    public final zzz zzc(int i) {
        zzx zzxVar = new zzx(this, null);
        zzxVar.zzH(i);
        return new zzz(zzxVar);
    }

    public final boolean zzd(zzz zzzVar) {
        List list = this.zzr;
        int size = list.size();
        List list2 = zzzVar.zzr;
        if (size != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    zzz(zzx zzxVar) {
        boolean z;
        String str;
        this.zza = zzxVar.zza;
        String strZzE = zzex.zzE(zzxVar.zzd);
        this.zzd = strZzE;
        if (zzxVar.zzc.isEmpty() && zzxVar.zzb != null) {
            this.zzc = zzfyq.zzo(new zzab(strZzE, zzxVar.zzb));
            this.zzb = zzxVar.zzb;
        } else if (zzxVar.zzc.isEmpty() || zzxVar.zzb != null) {
            if (!zzxVar.zzc.isEmpty() || zzxVar.zzb != null) {
                int i = 0;
                while (true) {
                    if (i >= zzxVar.zzc.size()) {
                        z = false;
                        break;
                    } else {
                        if (((zzab) zzxVar.zzc.get(i)).zzb.equals(zzxVar.zzb)) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
            } else {
                z = true;
                break;
            }
            zzdd.zzf(z);
            this.zzc = zzxVar.zzc;
            this.zzb = zzxVar.zzb;
        } else {
            this.zzc = zzxVar.zzc;
            List list = zzxVar.zzc;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzab) list.get(0)).zzb;
                    break;
                }
                zzab zzabVar = (zzab) it.next();
                if (TextUtils.equals(zzabVar.zza, strZzE)) {
                    str = zzabVar.zzb;
                    break;
                }
            }
            this.zzb = str;
        }
        this.zze = zzxVar.zze;
        zzdd.zzg(zzxVar.zzg == 0 || (zzxVar.zzf & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.zzf = zzxVar.zzf;
        this.zzg = zzxVar.zzg;
        int i2 = zzxVar.zzh;
        this.zzh = i2;
        int i3 = zzxVar.zzi;
        this.zzi = i3;
        this.zzj = i3 != -1 ? i3 : i2;
        this.zzk = zzxVar.zzj;
        this.zzl = zzxVar.zzk;
        this.zzm = null;
        this.zzn = zzxVar.zzl;
        this.zzo = zzxVar.zzm;
        this.zzp = zzxVar.zzn;
        this.zzq = zzxVar.zzo;
        this.zzr = zzxVar.zzp == null ? Collections.emptyList() : zzxVar.zzp;
        zzs zzsVar = zzxVar.zzq;
        this.zzs = zzsVar;
        this.zzt = zzxVar.zzr;
        this.zzu = zzxVar.zzs;
        this.zzv = zzxVar.zzt;
        this.zzw = zzxVar.zzu;
        this.zzx = zzxVar.zzv;
        this.zzy = zzxVar.zzw;
        this.zzz = zzxVar.zzx;
        this.zzA = zzxVar.zzy == -1 ? 0 : zzxVar.zzy;
        this.zzB = zzxVar.zzz == -1.0f ? 1.0f : zzxVar.zzz;
        this.zzC = zzxVar.zzA;
        this.zzD = zzxVar.zzB;
        this.zzE = zzxVar.zzC;
        this.zzF = zzxVar.zzD;
        this.zzG = zzxVar.zzE;
        this.zzH = zzxVar.zzF;
        this.zzI = zzxVar.zzG;
        this.zzJ = zzxVar.zzH == -1 ? 0 : zzxVar.zzH;
        this.zzK = zzxVar.zzI != -1 ? zzxVar.zzI : 0;
        this.zzL = zzxVar.zzJ;
        this.zzM = zzxVar.zzK;
        if (zzxVar.zzL != 0 || zzsVar == null) {
            this.zzN = zzxVar.zzL;
        } else {
            this.zzN = 1;
        }
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzE);
        StringBuilder sb = new StringBuilder("Format(");
        sb.append(this.zza);
        sb.append(", ");
        sb.append(this.zzb);
        sb.append(", ");
        sb.append(this.zzn);
        sb.append(", ");
        sb.append(this.zzo);
        sb.append(", ");
        sb.append(this.zzk);
        sb.append(", ");
        sb.append(this.zzj);
        sb.append(", ");
        sb.append(this.zzd);
        sb.append(", [");
        sb.append(this.zzv);
        sb.append(", ");
        sb.append(this.zzw);
        sb.append(", ");
        sb.append(this.zzz);
        sb.append(", ");
        sb.append(strValueOf);
        sb.append("], [");
        sb.append(this.zzG);
        sb.append(", ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.zzH, QTaELkFI.WSTthBOf);
    }
}
