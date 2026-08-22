package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzfx implements Comparable {
    public long zzb = -9223372036854775807L;
    public final List zza = new ArrayList();

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.zzb, ((zzfx) obj).zzb);
    }
}
