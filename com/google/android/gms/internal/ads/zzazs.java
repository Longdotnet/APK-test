package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzazs {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzbah zze;
    private final zzbap zzf;
    private int zzn;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzazs(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
        this.zze = new zzbah(i4);
        this.zzf = new zzbap(i5, i6, i7);
    }

    private final void zzm(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null) {
            if (str.length() < this.zzc) {
                return;
            }
            synchronized (this.zzg) {
                try {
                    this.zzh.add(str);
                    this.zzk += str.length();
                    if (z) {
                        ArrayList arrayList = this.zzi;
                        arrayList.add(str);
                        this.zzj.add(new zzbad(f, f2, f3, f4, arrayList.size() - 1));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static final String zzn(ArrayList arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            sb.append((String) arrayList.get(i2));
            sb.append(' ');
            i2++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzazs)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzazs) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        ArrayList arrayList = this.zzh;
        int i = this.zzl;
        int i2 = this.zzn;
        int i3 = this.zzk;
        String strZzn = zzn(arrayList, 100);
        String strZzn2 = zzn(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("ActivityContent fetchId: ", i, " score:", i2, " total_length:");
        sbM.append(i3);
        sbM.append("\n text: ");
        sbM.append(strZzn);
        sbM.append("\n viewableText");
        sbM.append(strZzn2);
        sbM.append("\n signture: ");
        sbM.append(str);
        sbM.append("\n viewableSignture: ");
        return Fragment$$ExternalSyntheticOutline0.m(sbM, str2, "\n viewableSignatureForVertical: ", str3);
    }

    public final int zza(int i, int i2) {
        if (this.zzd) {
            return this.zzb;
        }
        return (i2 * this.zzb) + (i * this.zza);
    }

    public final int zzb() {
        return this.zzk;
    }

    public final String zzc() {
        return this.zzo;
    }

    public final String zzd() {
        return this.zzq;
    }

    public final void zze() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzf() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzg(int i) {
        this.zzl = i;
    }

    public final void zzh(String str, boolean z, float f, float f2, float f3, float f4) {
        zzm(str, z, f, f2, f3, f4);
    }

    public final void zzi(String str, boolean z, float f, float f2, float f3, float f4) {
        zzm(str, z, f, f2, f3, f4);
        synchronized (this.zzg) {
            try {
                if (this.zzm < 0) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("ActivityContent: negative number of WebViews.");
                }
                zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj() {
        synchronized (this.zzg) {
            try {
                int iZza = zza(this.zzk, this.zzl);
                if (iZza > this.zzn) {
                    this.zzn = iZza;
                    com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                    if (!((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzK()) {
                        zzbah zzbahVar = this.zze;
                        this.zzo = zzbahVar.zza(this.zzh);
                        this.zzp = zzbahVar.zza(this.zzi);
                    }
                    if (!((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzL()) {
                        this.zzq = this.zzf.zza(this.zzi, this.zzj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzk() {
        synchronized (this.zzg) {
            try {
                int iZza = zza(this.zzk, this.zzl);
                if (iZza > this.zzn) {
                    this.zzn = iZza;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.zzg) {
            z = this.zzm == 0;
        }
        return z;
    }
}
