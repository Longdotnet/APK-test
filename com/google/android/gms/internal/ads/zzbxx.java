package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.CloseableKt;
import okio.AsyncTimeout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbxx> CREATOR = new zzbxy();
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final List zze;
    public final boolean zzf;
    public final boolean zzg;
    public final List zzh;

    public zzbxx(String str, String str2, boolean z, boolean z2, List list, boolean z3, boolean z4, List list2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = z2;
        this.zze = list;
        this.zzf = z3;
        this.zzg = z4;
        this.zzh = list2 == null ? new ArrayList() : list2;
    }

    public static zzbxx zza(JSONObject jSONObject) {
        return new zzbxx(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), AsyncTimeout.Companion.zzc(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), AsyncTimeout.Companion.zzc(jSONObject.optJSONArray("webview_permissions"), null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, str, false);
        CloseableKt.writeString(parcel, 3, this.zzb, false);
        boolean z = this.zzc;
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzd;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.writeStringList(parcel, 6, this.zze);
        boolean z3 = this.zzf;
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = this.zzg;
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(z4 ? 1 : 0);
        CloseableKt.writeStringList(parcel, 9, this.zzh);
        CloseableKt.zzb(parcel, iZza);
    }
}
