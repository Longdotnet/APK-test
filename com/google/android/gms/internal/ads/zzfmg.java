package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmg implements zzfmj {
    private static final zzfmg zza = new zzfmg(new zzfmk());
    private Date zzb;
    private boolean zzc;
    private final zzfmk zzd;
    private boolean zze;

    private zzfmg(zzfmk zzfmkVar) {
        this.zzd = zzfmkVar;
    }

    public static zzfmg zza() {
        return zza;
    }

    public final Date zzb() {
        Date date = this.zzb;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfmj
    public final void zzc(boolean z) {
        if (!this.zze && z) {
            Date date = new Date();
            Date date2 = this.zzb;
            if (date2 == null || date.after(date2)) {
                this.zzb = date;
                if (this.zzc) {
                    Iterator it = zzfmi.zza().zzb().iterator();
                    while (it.hasNext()) {
                        ((zzflp) it.next()).zzg().zzg(zzb());
                    }
                }
            }
        }
        this.zze = z;
    }

    public final void zzd(Context context) {
        if (this.zzc) {
            return;
        }
        zzfmk zzfmkVar = this.zzd;
        zzfmkVar.zzd(context);
        zzfmkVar.zze(this);
        zzfmkVar.zzf();
        this.zze = zzfmkVar.zza;
        this.zzc = true;
    }
}
