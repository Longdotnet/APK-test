package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbwo> CREATOR = new zzbwp();
    public final String zza;
    public final int zzb;

    public zzbwo(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public static zzbwo zza(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzbwo(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbwo)) {
            zzbwo zzbwoVar = (zzbwo) obj;
            if (com.google.android.gms.common.internal.zzah.equal(this.zza, zzbwoVar.zza)) {
                if (com.google.android.gms.common.internal.zzah.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbwoVar.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, str, false);
        int i2 = this.zzb;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i2);
        CloseableKt.zzb(parcel, iZza);
    }
}
