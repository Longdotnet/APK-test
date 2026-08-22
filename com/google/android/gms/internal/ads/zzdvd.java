package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvd {
    private final zzdun zza;
    private final zzdpw zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    public zzdvd(zzdun zzdunVar, zzdpw zzdpwVar) {
        this.zza = zzdunVar;
        this.zzb = zzdpwVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(List list) {
        zzdpv zzdpvVarZza;
        zzdpv zzdpvVarZza2;
        zzbse zzbseVar;
        synchronized (this.zzc) {
            try {
                if (this.zze) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbmd zzbmdVar = (zzbmd) it.next();
                    zzbcv zzbcvVar = zzbde.zzjL;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                    String string = (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || (zzdpvVarZza2 = this.zzb.zza(zzbmdVar.zza)) == null || (zzbseVar = zzdpvVarZza2.zzc) == null) ? "" : zzbseVar.toString();
                    String str = string;
                    boolean z = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzjM)).booleanValue() && (zzdpvVarZza = this.zzb.zza(zzbmdVar.zza)) != null && zzdpvVarZza.zzd;
                    List list2 = this.zzd;
                    String str2 = zzbmdVar.zza;
                    list2.add(new zzdvc(str2, str, this.zzb.zzb(str2), zzbmdVar.zzb ? 1 : 0, zzbmdVar.zzd, zzbmdVar.zzc, z));
                }
                this.zze = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002f A[Catch: all -> 0x001c, LOOP:0: B:15:0x0029->B:17:0x002f, LOOP_END, TryCatch #0 {all -> 0x001c, blocks: (B:4:0x0008, B:6:0x000c, B:8:0x0014, B:11:0x001e, B:12:0x0021, B:14:0x0023, B:15:0x0029, B:17:0x002f, B:18:0x003d), top: B:22:0x0008 }] */
    public final JSONArray zza() {
        Iterator it;
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            try {
                if (this.zze) {
                    it = this.zzd.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((zzdvc) it.next()).zza());
                    }
                } else {
                    zzdun zzdunVar = this.zza;
                    if (zzdunVar.zzt()) {
                        zzd(zzdunVar.zzg());
                        it = this.zzd.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(((zzdvc) it.next()).zza());
                        }
                    } else {
                        zzc();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONArray;
    }

    public final void zzc() {
        this.zza.zzs(new zzdvb(this));
    }
}
