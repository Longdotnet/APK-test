package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.UUID;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdhx implements zzhgr {
    private final zzhha zza;

    private zzdhx(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
    }

    public static zzdhx zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdhx(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        VersionInfoParcel versionInfoParcelZza = ((zzchz) this.zza).zza();
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        return new zzayz(UUID.randomUUID().toString(), versionInfoParcelZza, mnwSv.hZcQigDi, new JSONObject(), false, true);
    }
}
