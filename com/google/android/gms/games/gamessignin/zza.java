package com.google.android.gms.games.gamessignin;

import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zza implements Function {
    public static final /* synthetic */ zza zza = new zza();

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        AuthScope authScope = AuthScope.EMAIL;
        Objects.requireNonNull(str, "Input list of scope strings must not be null");
        AuthScope authScope2 = (AuthScope) AuthScope.zzd.get(str);
        if (authScope2 != null) {
            return authScope2;
        }
        throw new IllegalArgumentException("Invalid scope: ".concat(str));
    }
}
