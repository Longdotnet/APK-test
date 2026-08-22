package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgo {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzaq.zzb("media3.datasource");
    }

    public /* synthetic */ zzgo(Uri uri, Map map, long j, long j2, int i) {
        this(uri, 0L, 1, null, map, j, j2, null, i, null);
    }

    public final String toString() {
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("DataSpec[GET ", this.zza.toString(), ", ");
        sbM21m.append(this.zze);
        sbM21m.append(", ");
        sbM21m.append(this.zzf);
        sbM21m.append(", null, ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sbM21m, this.zzg, "]");
    }

    public final zzgm zza() {
        return new zzgm(this, null);
    }

    public final boolean zzb(int i) {
        return (this.zzg & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzgo(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        boolean z = false;
        boolean z2 = j2 >= 0;
        zzdd.zzd(z2);
        zzdd.zzd(z2);
        if (j3 > 0) {
            z = true;
        } else if (j3 == -1) {
            j3 = -1;
            z = true;
        }
        zzdd.zzd(z);
        uri.getClass();
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zze = j2;
        this.zzf = j3;
        this.zzg = i2;
    }

    @Deprecated
    public zzgo(Uri uri, long j, long j2, String str) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j, j2, null, 0, null);
    }
}
