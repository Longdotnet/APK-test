package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import kotlin.io.CloseableKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzaal extends AbstractSafeParcelable implements zzxm {
    public static final Parcelable.Creator<zzaal> CREATOR = new zzaam();
    private final String zza;
    private final long zzb;
    private final boolean zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final String zzh;
    private zzza zzi;

    public zzaal(String str, long j, boolean z, String str2, String str3, String str4, boolean z2, String str5) {
        zzah.checkNotEmpty(str);
        this.zza = str;
        this.zzb = j;
        this.zzc = z;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = str4;
        this.zzg = z2;
        this.zzh = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        long j = this.zzb;
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(j);
        boolean z = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.writeString(parcel, 5, this.zze, false);
        CloseableKt.writeString(parcel, 6, this.zzf, false);
        boolean z2 = this.zzg;
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.writeString(parcel, 8, this.zzh, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("phoneNumber", this.zza);
        String str = this.zze;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            jSONObject.put("recaptchaToken", str2);
        }
        zzza zzzaVar = this.zzi;
        if (zzzaVar != null) {
            jSONObject.put("autoRetrievalInfo", zzzaVar.zza());
        }
        String str3 = this.zzh;
        if (str3 != null) {
            jSONObject.put("safetyNetToken", str3);
        }
        return jSONObject.toString();
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zza;
    }

    public final void zze(zzza zzzaVar) {
        this.zzi = zzzaVar;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return this.zzg;
    }
}
