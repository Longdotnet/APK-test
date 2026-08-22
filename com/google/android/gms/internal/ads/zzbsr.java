package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.daerisoft.thespikerm.R;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbsr extends zzbsu {
    private final Map zza;
    private final Context zzb;

    public zzbsr(zzcfg zzcfgVar, Map map) {
        super(zzcfgVar, "storePicture");
        this.zza = map;
        this.zzb = zzcfgVar.zzi();
    }

    public final void zzb() {
        Context context = this.zzb;
        if (context == null) {
            zzh("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        if (!new zzbcm(context).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzh("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzh("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZze = zzvVar.zzi.zze();
        com.google.android.gms.ads.internal.util.zzs zzsVar3 = zzvVar.zzd;
        AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.util.zzs.zzL(context);
        builderZzL.setTitle(resourcesZze != null ? resourcesZze.getString(R.string.s1) : "Save image");
        builderZzL.setMessage(resourcesZze != null ? resourcesZze.getString(R.string.s2) : jIKWv.Pdh);
        builderZzL.setPositiveButton(resourcesZze != null ? resourcesZze.getString(R.string.s3) : "Accept", new zzbsp(this, str, lastPathSegment));
        builderZzL.setNegativeButton(resourcesZze != null ? resourcesZze.getString(R.string.s4) : "Decline", new zzbsq(this));
        builderZzL.create().show();
    }
}
