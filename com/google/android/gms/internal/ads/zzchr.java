package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zzchr implements zzhgr {
    private zzchr(zzchh zzchhVar) {
    }

    public static zzchr zza(zzchh zzchhVar) {
        return new zzchr(zzchhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.android.vending");
        intent.setData(Uri.parse("https://play.google.com/d"));
        return intent;
    }
}
