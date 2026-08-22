package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class zzaay {
    private final Context zza;
    private boolean zzb;
    private zztr zzc = zztr.zza;
    private final zztd zzd;
    private Handler zze;
    private zzacj zzf;

    public zzaay(Context context) {
        this.zza = context;
        this.zzd = new zzsx(context, null, null);
    }

    public final zzaay zze(Handler handler) {
        this.zze = handler;
        return this;
    }

    public final zzaay zzf(zzacj zzacjVar) {
        this.zzf = zzacjVar;
        return this;
    }

    public final zzaay zzg(zztr zztrVar) {
        this.zzc = zztrVar;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0010  */
    public final zzaba zzh() {
        boolean z;
        zzdd.zzf(!this.zzb);
        Handler handler = this.zze;
        if (handler == null && this.zzf == null) {
            z = true;
        } else {
            z = false;
            if (handler != null && this.zzf != null) {
                z = true;
            }
        }
        zzdd.zzf(z);
        this.zzb = true;
        return new zzaba(this);
    }
}
