package com.google.android.gms.ads.internal.util.client;

import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class zzt {
    public static final zzt zza;
    public static final zzt zzb;
    public static final zzt zzc;
    public static final zzt zzd;
    public static final /* synthetic */ zzt[] zze;

    static {
        zzt zztVar = new zzt("SUCCESS", 0);
        zza = zztVar;
        zzt zztVar2 = new zzt(DaWYVMJ.aHYlMlP, 1);
        zzb = zztVar2;
        zzt zztVar3 = new zzt("RETRIABLE_FAILURE", 2);
        zzc = zztVar3;
        zzt zztVar4 = new zzt("BUFFERED", 3);
        zzd = zztVar4;
        zze = new zzt[]{zztVar, zztVar2, zztVar3, zztVar4};
    }

    public static zzt[] values() {
        return (zzt[]) zze.clone();
    }
}
