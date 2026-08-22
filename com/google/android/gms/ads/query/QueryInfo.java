package com.google.android.gms.ads.query;

import android.content.Context;
import androidx.work.impl.WorkerWrapper;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbuh;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes.dex */
public final class QueryInfo {
    public final Symbol zza;

    public QueryInfo(Symbol symbol) {
        this.zza = symbol;
    }

    public static void generate(Context context, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        AdFormat adFormat = AdFormat.BANNER;
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzj.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                zzb.zzb.execute(new WorkerWrapper.AnonymousClass1(context, adRequest, queryInfoGenerationCallback, 14, false));
                return;
            }
        }
        new zzbuh(context, adFormat, adRequest.zza, null).zzb(queryInfoGenerationCallback);
    }
}
