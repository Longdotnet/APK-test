package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends zzbz {
    public static final Parcelable.Creator<zzt> CREATOR = new zza(3);
    public static final HashMap zzc;
    public final HashSet zza;
    public final int zzb;
    public zzv zzd;
    public String zze;
    public String zzf;
    public final String zzg;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put("authenticatorInfo", new FastJsonResponse.Field(11, false, 11, false, "authenticatorInfo", 2, zzv.class));
        map.put("signature", new FastJsonResponse.Field(7, false, 7, false, "signature", 3, null));
        map.put("package", new FastJsonResponse.Field(7, false, 7, false, "package", 4, null));
    }

    public zzt(HashSet hashSet, int i, zzv zzvVar, String str, String str2, String str3) {
        this.zza = hashSet;
        this.zzb = i;
        this.zzd = zzvVar;
        this.zze = str;
        this.zzf = str2;
        this.zzg = str3;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int i = field.zaf;
        if (i != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(i), fastJsonResponse.getClass().getCanonicalName()));
        }
        this.zzd = (zzv) fastJsonResponse;
        this.zza.add(Integer.valueOf(i));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* bridge */ /* synthetic */ Map getFieldMappings() {
        return zzc;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int i = field.zaf;
        if (i == 1) {
            return Integer.valueOf(this.zzb);
        }
        if (i == 2) {
            return this.zzd;
        }
        if (i == 3) {
            return this.zze;
        }
        if (i == 4) {
            return this.zzf;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(field.zaf);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zza.contains(Integer.valueOf(field.zaf));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int i = field.zaf;
        if (i == 3) {
            this.zze = str2;
        } else {
            if (i != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(i)));
            }
            this.zzf = str2;
        }
        this.zza.add(Integer.valueOf(i));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        HashSet hashSet = this.zza;
        if (hashSet.contains(1)) {
            CloseableKt.zzc(parcel, 1, 4);
            parcel.writeInt(this.zzb);
        }
        if (hashSet.contains(2)) {
            CloseableKt.writeParcelable(parcel, 2, this.zzd, i, true);
        }
        if (hashSet.contains(3)) {
            CloseableKt.writeString(parcel, 3, this.zze, true);
        }
        if (hashSet.contains(4)) {
            CloseableKt.writeString(parcel, 4, this.zzf, true);
        }
        if (hashSet.contains(5)) {
            CloseableKt.writeString(parcel, 5, this.zzg, true);
        }
        CloseableKt.zzb(parcel, iZza);
    }
}
