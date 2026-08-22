package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzfex {
    private final HashMap zza = new HashMap();

    public final zzfew zza(zzfen zzfenVar, Context context, zzfef zzfefVar, zzffd zzffdVar) {
        HashMap map = this.zza;
        zzfew zzfewVar = (zzfew) map.get(zzfenVar);
        if (zzfewVar != null) {
            return zzfewVar;
        }
        zzfek zzfekVar = new zzfek(zzfeq.zza(zzfenVar, context));
        zzfew zzfewVar2 = new zzfew(zzfekVar, new zzfff(zzfekVar, zzfefVar, zzffdVar));
        map.put(zzfenVar, zzfewVar2);
        return zzfewVar2;
    }
}
