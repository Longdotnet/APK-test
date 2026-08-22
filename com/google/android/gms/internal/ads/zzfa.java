package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzfa implements zzau {
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    public zzfa(String str, byte[] bArr, int i, int i2) {
        byte b;
        byte b2;
        boolean z = true;
        switch (str) {
            case "com.android.capture.fps":
                b = 0;
                break;
            case "auxiliary.tracks.interleaved":
                b = 4;
                break;
            case "auxiliary.tracks.length":
                b = 2;
                break;
            case "auxiliary.tracks.offset":
                b = 1;
                break;
            case "auxiliary.tracks.map":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            if (i2 != 23) {
                z = false;
            } else if (bArr.length == 4) {
                i2 = 23;
            } else {
                i2 = 23;
                z = false;
            }
            zzdd.zzd(z);
        } else if (b == 1 || b == 2) {
            if (i2 != 78) {
                z = false;
            } else if (bArr.length == 8) {
                i2 = 78;
            } else {
                i2 = 78;
                z = false;
            }
            zzdd.zzd(z);
        } else if (b == 3) {
            zzdd.zzd(i2 == 0);
        } else if (b == 4) {
            if (i2 != 75) {
                z = false;
            } else if (bArr.length == 1 && ((b2 = bArr[0]) == 0 || b2 == 1)) {
                i2 = 75;
            } else {
                i2 = 75;
                z = false;
            }
            zzdd.zzd(z);
        }
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfa.class == obj.getClass()) {
            zzfa zzfaVar = (zzfa) obj;
            if (this.zza.equals(zzfaVar.zza) && Arrays.equals(this.zzb, zzfaVar.zzb) && this.zzc == zzfaVar.zzc && this.zzd == zzfaVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        return ((((Arrays.hashCode(this.zzb) + (iHashCode * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0079  */
    /* JADX WARN: Code duplicated, block: B:25:0x0087 A[LOOP:0: B:23:0x0084->B:25:0x0087, LOOP_END] */
    public final String toString() {
        String string;
        byte[] bArr;
        StringBuilder sb;
        int i = this.zzd;
        if (i != 0) {
            if (i == 1) {
                string = zzex.zzB(this.zzb);
            } else if (i == 23) {
                string = String.valueOf(Float.intBitsToFloat(zzgbt.zzd(this.zzb)));
            } else if (i == 67) {
                string = String.valueOf(zzgbt.zzd(this.zzb));
            } else if (i == 75) {
                string = String.valueOf(this.zzb[0] & 255);
            } else if (i != 78) {
                bArr = this.zzb;
                String str = zzex.zza;
                int length = bArr.length;
                sb = new StringBuilder(length + length);
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
                    sb.append(Character.forDigit(bArr[i2] & 15, 16));
                }
                string = sb.toString();
            } else {
                string = String.valueOf(new zzen(this.zzb).zzw());
            }
        } else if (this.zza.equals("auxiliary.tracks.map")) {
            List listZzb = zzb();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("track types = ");
            zzfvh.zzb(sb2, listZzb, ",");
            string = sb2.toString();
        } else {
            bArr = this.zzb;
            String str2 = zzex.zza;
            int length2 = bArr.length;
            sb = new StringBuilder(length2 + length2);
            while (i2 < bArr.length) {
                sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
                sb.append(Character.forDigit(bArr[i2] & 15, 16));
            }
            string = sb.toString();
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("mdta: key=", this.zza, ", value=", string);
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }

    public final List zzb() {
        zzdd.zzg(this.zza.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte[] bArr = this.zzb;
        byte b = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b; i++) {
            arrayList.add(Integer.valueOf(bArr[i + 2]));
        }
        return arrayList;
    }
}
