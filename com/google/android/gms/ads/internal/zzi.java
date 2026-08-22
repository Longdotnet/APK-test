package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzarv;
import com.google.android.gms.internal.ads.zzarx;
import com.google.android.gms.internal.ads.zzavm;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzhx;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzi(Object obj, boolean z, int i) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = z;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0089  */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzk zzkVar = (zzk) this.zza;
                boolean z = this.zzb;
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    Context context = zzkVar.zzl;
                    VersionInfoParcel versionInfoParcel = zzkVar.zzn;
                    boolean z2 = zzkVar.zzo;
                    zzarv zzarvVarZza = zzarx.zza();
                    zzarvVarZza.zza(z);
                    zzarvVarZza.zzb(versionInfoParcel.afmaVersion);
                    zzarx zzarxVar = (zzarx) zzarvVarZza.zzbr();
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    zzavm.zza(context, zzarxVar, z2).zzp();
                } catch (NullPointerException e) {
                    zzkVar.zzj.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e);
                    return;
                }
                break;
            case 1:
                ((com.google.android.gms.ads.nonagon.signalgeneration.zzo) this.zza).zzj(this.zzb, false);
                break;
            default:
                boolean zZzJ = ((zzfr) ((zzhx) this.zza).mBuilder).zzJ();
                zzfr zzfrVar = (zzfr) ((zzhx) this.zza).mBuilder;
                boolean z3 = false;
                boolean z4 = zzfrVar.zzE != null && zzfrVar.zzE.booleanValue();
                ((zzfr) ((zzhx) this.zza).mBuilder).zzE = Boolean.valueOf(this.zzb);
                if (z4 == this.zzb) {
                    zzeh zzehVar = ((zzfr) ((zzhx) this.zza).mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzl.zzb(Boolean.valueOf(this.zzb), "Default data collection state already set to");
                }
                if (((zzfr) ((zzhx) this.zza).mBuilder).zzJ() != zZzJ) {
                    boolean zZzJ2 = ((zzfr) ((zzhx) this.zza).mBuilder).zzJ();
                    zzfr zzfrVar2 = (zzfr) ((zzhx) this.zza).mBuilder;
                    if (zzfrVar2.zzE != null && zzfrVar2.zzE.booleanValue()) {
                        z3 = true;
                    }
                    if (zZzJ2 != z3) {
                        zzeh zzehVar2 = ((zzfr) ((zzhx) this.zza).mBuilder).zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzi.zzc(Boolean.valueOf(this.zzb), "Default data collection is different than actual status", Boolean.valueOf(zZzJ));
                    }
                } else {
                    zzeh zzehVar3 = ((zzfr) ((zzhx) this.zza).mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzi.zzc(Boolean.valueOf(this.zzb), "Default data collection is different than actual status", Boolean.valueOf(zZzJ));
                }
                ((zzhx) this.zza).zzab();
                break;
        }
    }
}
