package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaya extends zzayk {
    private List zzh;
    private final Context zzi;

    public zzaya(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, Context context) {
        super(zzawxVar, "G1O+5tqulLBNCxZxcYiJSAGrazgAMWmQ49z8g8PEPhhOgnBizp9p2UWwJMiSx+ju", "xfUFYLaeYlsk7z1gy27YVxCq/UzpfsdVkNtosT4BuNc=", zzastVar, i, 31);
        this.zzh = null;
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        zzast zzastVar = this.zzd;
        zzastVar.zzU(-1L);
        zzastVar.zzQ(-1L);
        Context contextZzb = this.zzi;
        if (contextZzb == null) {
            contextZzb = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke(null, contextZzb);
        }
        List list = this.zzh;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (zzastVar) {
            zzastVar.zzU(((Long) this.zzh.get(0)).longValue());
            zzastVar.zzQ(((Long) this.zzh.get(1)).longValue());
        }
    }
}
