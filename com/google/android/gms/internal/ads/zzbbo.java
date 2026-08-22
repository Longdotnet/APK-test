package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbbo> CREATOR = new zzbbp();
    public final String zza;
    public final long zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final Bundle zzf;
    public final boolean zzg;
    public long zzh;
    public String zzi;
    public int zzj;

    public zzbbo(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2, String str5, int i) {
        this.zza = str;
        this.zzb = j;
        this.zzc = str2 == null ? "" : str2;
        this.zzd = str3 == null ? "" : str3;
        this.zze = str4 == null ? "" : str4;
        this.zzf = bundle == null ? new Bundle() : bundle;
        this.zzg = z;
        this.zzh = j2;
        this.zzi = str5;
        this.zzj = i;
    }

    public static zzbbo zza(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                String str = "Expected 2 path parts for namespace and id, found :" + pathSegments.size();
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(str);
                return null;
            }
            String str2 = pathSegments.get(0);
            String str3 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean zEquals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long j = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str4 : uri.getQueryParameterNames()) {
                if (str4.startsWith("tag.")) {
                    bundle.putString(str4.substring(4), uri.getQueryParameter(str4));
                }
            }
            return new zzbbo(queryParameter, j, host, str2, str3, bundle, zEquals, 0L, "", 0);
        } catch (NullPointerException e) {
            e = e;
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to parse Uri into cache offering.", e);
            return null;
        } catch (NumberFormatException e2) {
            e = e2;
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, str, false);
        long j = this.zzb;
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(j);
        CloseableKt.writeString(parcel, 4, this.zzc, false);
        CloseableKt.writeString(parcel, 5, this.zzd, false);
        CloseableKt.writeString(parcel, 6, this.zze, false);
        CloseableKt.writeBundle(parcel, 7, this.zzf, false);
        boolean z = this.zzg;
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(z ? 1 : 0);
        long j2 = this.zzh;
        CloseableKt.zzc(parcel, 9, 8);
        parcel.writeLong(j2);
        CloseableKt.writeString(parcel, 10, this.zzi, false);
        int i2 = this.zzj;
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(i2);
        CloseableKt.zzb(parcel, iZza);
    }
}
