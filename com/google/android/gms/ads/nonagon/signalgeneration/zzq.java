package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzq {
    public final QueryInfo zza;
    public final String zzb;
    public final long zzc;
    public final int zzd;
    public final AtomicBoolean zze = new AtomicBoolean(false);

    public zzq(QueryInfo queryInfo, String str, long j, int i) {
        this.zza = queryInfo;
        this.zzb = str;
        this.zzc = j;
        this.zzd = i;
    }
}
