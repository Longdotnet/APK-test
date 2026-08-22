package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.billingclient.api.BillingFlowParams;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzefb implements zzedm {
    private final Context zza;
    private final zzdgf zzb;
    private final Executor zzc;
    private final zzfbz zzd;
    private final zzdsj zze;

    public zzefb(Context context, Executor executor, zzdgf zzdgfVar, zzfbz zzfbzVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzdgfVar;
        this.zzc = executor;
        this.zzd = zzfbzVar;
        this.zze = zzdsjVar;
    }

    public static ListenableFuture zzd(zzefb zzefbVar, Uri uri, zzfcn zzfcnVar, zzfca zzfcaVar, zzfcd zzfcdVar, Object obj) {
        try {
            Intent intent = (Intent) new BillingFlowParams().build().mConfiguration;
            intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(intent, null);
            zzcak zzcakVar = new zzcak();
            zzdfc zzdfcVarZzd = zzefbVar.zzb.zzd(new zzcrq(zzfcnVar, zzfcaVar, null), new zzdff(new zzefa(zzefbVar, zzcakVar, zzfcaVar), null));
            zzcakVar.zzc(new AdOverlayInfoParcel(zzcVar, null, zzdfcVarZzd.zza(), null, new VersionInfoParcel(0, 0, false, false), null, null, zzfcdVar.zzb));
            zzefbVar.zzd.zza();
            return zzgdn.zzh(zzdfcVarZzd.zzg());
        } catch (Throwable th) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznw)).booleanValue()) {
            zzdsi zzdsiVarZza = this.zze.zza();
            zzdsiVarZza.zzb("action", "cstm_tbs_rndr");
            zzdsiVarZza.zzj();
        }
        String strZze = zze(zzfcaVar);
        final Uri uri = strZze != null ? Uri.parse(strZze) : null;
        final zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeez
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzefb.zzd(this.zza, uri, zzfcnVar, zzfcaVar, zzfcdVar, obj);
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbef.zzg(context) && !TextUtils.isEmpty(zze(zzfcaVar));
    }

    private static String zze(zzfca zzfcaVar) {
        try {
            return zzfcaVar.zzv.getString(kBfGXgdfpo.hRuQGOcWrq);
        } catch (Exception unused) {
            return null;
        }
    }
}
