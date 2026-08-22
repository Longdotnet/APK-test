package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbky implements zzbkf {
    private final Context zza;

    public zzbky(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        if (!map.containsKey("text") || TextUtils.isEmpty((CharSequence) map.get("text"))) {
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("Opening Share Sheet with text: ".concat(String.valueOf((String) map.get("text"))));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(YcVWhnLsj.SracNZEW);
        intent.putExtra("android.intent.extra.TEXT", (String) map.get("text"));
        if (map.containsKey("title")) {
            intent.putExtra("android.intent.extra.TITLE", (String) map.get("title"));
        }
        try {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            com.google.android.gms.ads.internal.util.zzs.zzU(this.zza, intent);
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to open Share Sheet", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "ShareSheetGmsgHandler.onGmsg");
        }
    }
}
