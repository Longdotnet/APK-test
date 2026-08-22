package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbok implements zzbnc, zzboj {
    private final zzboj zza;
    private final HashSet zzb = new HashSet();

    public zzbok(zzboj zzbojVar) {
        this.zza = zzbojVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnc, com.google.android.gms.internal.ads.zzbnm
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbnc, com.google.android.gms.internal.ads.zzbnm
    public final /* synthetic */ void zzb(String str, String str2) {
        zzbnb.zzc(this, str, str2);
    }

    public final void zzc() {
        HashSet<AbstractMap.SimpleEntry> hashSet = this.zzb;
        for (AbstractMap.SimpleEntry simpleEntry : hashSet) {
            com.google.android.gms.ads.internal.util.zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzbkf) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbkf) simpleEntry.getValue());
        }
        hashSet.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final /* synthetic */ void zzd(String str, Map map) {
        zzbnb.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbnc, com.google.android.gms.internal.ads.zzbna
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbnb.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final /* synthetic */ void zzp(String str, JSONObject jSONObject) {
        zzbnb.zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzboj
    public final void zzq(String str, zzbkf zzbkfVar) {
        this.zza.zzq(str, zzbkfVar);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbkfVar));
    }

    @Override // com.google.android.gms.internal.ads.zzboj
    public final void zzr(String str, zzbkf zzbkfVar) {
        this.zza.zzr(str, zzbkfVar);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbkfVar));
    }
}
