package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.internal.measurement.zzft;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzeu {
    public Object zza;
    public final /* synthetic */ zzgm zzb;
    public Serializable zzc;
    public Serializable zzd;
    public long zze;

    public /* synthetic */ zzeu(zzkt zzktVar) {
        this.zzb = zzktVar;
    }

    public boolean zza(zzft zzftVar, long j) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzftVar);
        if (((ArrayList) this.zzd) == null) {
            this.zzd = new ArrayList();
        }
        if (((ArrayList) this.zzc) == null) {
            this.zzc = new ArrayList();
        }
        if (!((ArrayList) this.zzd).isEmpty() && ((((zzft) ((ArrayList) this.zzd).get(0)).zzd() / 1000) / 60) / 60 != ((zzftVar.zzd() / 1000) / 60) / 60) {
            return false;
        }
        long jZzbw = this.zze + ((long) zzftVar.zzbw());
        zzkt zzktVar = (zzkt) this.zzb;
        zzktVar.zzg();
        if (jZzbw >= Math.max(0, ((Integer) zzdu.zzh.zza(null)).intValue())) {
            return false;
        }
        this.zze = jZzbw;
        ((ArrayList) this.zzd).add(zzftVar);
        ((ArrayList) this.zzc).add(Long.valueOf(j));
        int size = ((ArrayList) this.zzd).size();
        zzktVar.zzg();
        return size < Math.max(1, ((Integer) zzdu.zzi.zza(null)).intValue());
    }

    public void zzd() {
        zzew zzewVar = (zzew) this.zzb;
        zzewVar.zzg();
        ((zzfr) zzewVar.mBuilder).zzr.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = zzewVar.zza().edit();
        editorEdit.remove((String) this.zzc);
        editorEdit.remove((String) this.zzd);
        editorEdit.putLong((String) this.zza, jCurrentTimeMillis);
        editorEdit.apply();
    }

    public /* synthetic */ zzeu(zzew zzewVar, long j) {
        this.zzb = zzewVar;
        com.google.android.gms.common.internal.zzah.checkNotEmpty("health_monitor");
        com.google.android.gms.common.internal.zzah.checkArgument(j > 0);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }
}
