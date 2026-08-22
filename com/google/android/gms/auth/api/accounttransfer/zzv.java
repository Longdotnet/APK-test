package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
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
public final class zzv extends zzbz {
    public static final Parcelable.Creator<zzv> CREATOR = new zza(4);
    public static final HashMap zzc;
    public final HashSet zza;
    public final int zzb;
    public String zzd;
    public int zze;
    public byte[] zzf;
    public final PendingIntent zzg;
    public final DeviceMetaData zzh;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put("accountType", new FastJsonResponse.Field(7, false, 7, false, "accountType", 2, null));
        map.put("status", new FastJsonResponse.Field(0, false, 0, false, "status", 3, null));
        map.put("transferBytes", new FastJsonResponse.Field(8, false, 8, false, "transferBytes", 4, null));
    }

    public zzv(HashSet hashSet, int i, String str, int i2, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.zza = hashSet;
        this.zzb = i;
        this.zzd = str;
        this.zze = i2;
        this.zzf = bArr;
        this.zzg = pendingIntent;
        this.zzh = deviceMetaData;
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
            return Integer.valueOf(this.zze);
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
    public final void setDecodedBytesInternal(FastJsonResponse.Field field, String str, byte[] bArr) {
        int i = field.zaf;
        if (i == 4) {
            this.zzf = bArr;
            this.zza.add(Integer.valueOf(i));
        } else {
            StringBuilder sb = new StringBuilder(59);
            sb.append("Field with id=");
            sb.append(i);
            sb.append(" is not known to be an byte array.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i) {
        int i2 = field.zaf;
        if (i2 == 3) {
            this.zze = i;
            this.zza.add(Integer.valueOf(i2));
        } else {
            StringBuilder sb = new StringBuilder(52);
            sb.append("Field with id=");
            sb.append(i2);
            sb.append(" is not known to be an int.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int i = field.zaf;
        if (i != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(i)));
        }
        this.zzd = str2;
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
            CloseableKt.writeString(parcel, 2, this.zzd, true);
        }
        if (hashSet.contains(3)) {
            int i2 = this.zze;
            CloseableKt.zzc(parcel, 3, 4);
            parcel.writeInt(i2);
        }
        if (hashSet.contains(4)) {
            CloseableKt.writeByteArray(parcel, 4, this.zzf, true);
        }
        if (hashSet.contains(5)) {
            CloseableKt.writeParcelable(parcel, 5, this.zzg, i, true);
        }
        if (hashSet.contains(6)) {
            CloseableKt.writeParcelable(parcel, 6, this.zzh, i, true);
        }
        CloseableKt.zzb(parcel, iZza);
    }
}
