package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzak {
    public final Uri zza;
    public final String zzb;
    public final zzah zzc;
    public final zzac zzd;
    public final List zze;
    public final String zzf;
    public final zzfyq zzg;
    public final Object zzh;
    public final long zzi;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    public /* synthetic */ zzak(Uri uri, String str, zzah zzahVar, zzac zzacVar, List list, String str2, zzfyq zzfyqVar, Object obj, long j, zzao zzaoVar) {
        this.zza = uri;
        int i = zzay.zza;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfyqVar;
        int i2 = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        if (zzfyqVar.size() > 0) {
            throw null;
        }
        zzfynVar.zzi();
        this.zzh = null;
        this.zzi = -9223372036854775807L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzakVar = (zzak) obj;
        return this.zza.equals(zzakVar.zza) && this.zze.equals(zzakVar.zze) && this.zzg.equals(zzakVar.zzg);
    }

    public final int hashCode() {
        return (int) ((((long) ((this.zzg.hashCode() + ((this.zze.hashCode() + (this.zza.hashCode() * 923521)) * 961)) * 31)) * 31) - Long.MAX_VALUE);
    }
}
