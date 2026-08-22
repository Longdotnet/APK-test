package com.google.android.gms.ads.internal.util;

import androidx.sqlite.db.SimpleSQLiteQuery;
import com.android.billingclient.api.zzda;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzapz;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzara;
import com.google.android.gms.internal.ads.zzcak;
import java.util.Map;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class zzbm extends zzaqd {
    public final zzcak zza;
    public final zzl zzb;

    public zzbm(String str, zzcak zzcakVar) {
        super(0, str, new ProfileCache(zzcakVar, 23));
        this.zza = zzcakVar;
        zzl zzlVar = new zzl();
        this.zzb = zzlVar;
        if (zzl.zzk()) {
            zzlVar.zzn("onNetworkRequest", new Dispatcher(str, "GET", null, null));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    public final zzaqj zzh(zzapz zzapzVar) {
        return zzaqj.zzb(zzapzVar, zzara.zzb(zzapzVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    public final void zzo(Object obj) {
        zzapz zzapzVar = (zzapz) obj;
        Map map = zzapzVar.zzc;
        int i = zzapzVar.zza;
        zzl zzlVar = this.zzb;
        zzlVar.getClass();
        if (zzl.zzk()) {
            zzlVar.zzn("onNetworkResponse", new zzda(i, map));
            if (i < 200 || i >= 300) {
                zzlVar.zzn("onNetworkRequestError", new SimpleSQLiteQuery(null));
            }
        }
        byte[] bArr = zzapzVar.zzb;
        if (zzl.zzk() && bArr != null) {
            zzlVar.zzn("onNetworkResponseBody", new AccessTokenCache(bArr, 18));
        }
        this.zza.zzc(zzapzVar);
    }
}
