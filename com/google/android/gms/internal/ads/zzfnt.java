package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfnt extends zzfnu {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfnt(zzfnm zzfnmVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnmVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
