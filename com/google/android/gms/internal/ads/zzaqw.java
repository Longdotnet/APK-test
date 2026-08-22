package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzaqw {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    public zzaqw(String str, zzapm zzapmVar) {
        String str2 = zzapmVar.zzb;
        long j = zzapmVar.zzc;
        long j2 = zzapmVar.zzd;
        long j3 = zzapmVar.zze;
        long j4 = zzapmVar.zzf;
        ?? arrayList = zzapmVar.zzh;
        if (arrayList == 0) {
            Map map = zzapmVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzapv((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    public static zzaqw zza(zzaqx zzaqxVar) throws IOException {
        if (zzaqz.zze(zzaqxVar) != 538247942) {
            throw new IOException();
        }
        String strZzh = zzaqz.zzh(zzaqxVar);
        String strZzh2 = zzaqz.zzh(zzaqxVar);
        long jZzf = zzaqz.zzf(zzaqxVar);
        long jZzf2 = zzaqz.zzf(zzaqxVar);
        long jZzf3 = zzaqz.zzf(zzaqxVar);
        long jZzf4 = zzaqz.zzf(zzaqxVar);
        int iZze = zzaqz.zze(zzaqxVar);
        if (iZze < 0) {
            throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZze, "readHeaderList size="));
        }
        List listEmptyList = iZze == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < iZze; i++) {
            listEmptyList.add(new zzapv(zzaqz.zzh(zzaqxVar).intern(), zzaqz.zzh(zzaqxVar).intern()));
        }
        return new zzaqw(strZzh, strZzh2, jZzf, jZzf2, jZzf3, jZzf4, listEmptyList);
    }

    private zzaqw(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
