package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzhh {
    private final SimpleArrayMap zza;

    public zzhh(SimpleArrayMap simpleArrayMap) {
        this.zza = simpleArrayMap;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.zza.getOrDefault(uri.toString(), null);
        if (simpleArrayMap == null) {
            return null;
        }
        return (String) simpleArrayMap.getOrDefault("".concat(String.valueOf(str3)), null);
    }
}
