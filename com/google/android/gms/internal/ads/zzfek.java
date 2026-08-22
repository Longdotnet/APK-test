package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class zzfek implements zzfej {
    private final ConcurrentHashMap zza;
    private final zzfeq zzb;
    private final zzfem zzc = new zzfem();

    public zzfek(zzfeq zzfeqVar) {
        this.zza = new ConcurrentHashMap(zzfeqVar.zzd);
        this.zzb = zzfeqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final zzfeq zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final synchronized zzfes zzb(zzfet zzfetVar) {
        zzfes zzfesVarZze;
        try {
            zzfei zzfeiVar = (zzfei) this.zza.get(zzfetVar);
            if (zzfeiVar != null) {
                zzfesVarZze = zzfeiVar.zze();
                if (zzfesVarZze == null) {
                    this.zzc.zze();
                }
                zzffg zzffgVarZzf = zzfeiVar.zzf();
                if (zzfesVarZze != null) {
                    zzbcj.zzb.zzc zzcVarZzd = zzbcj.zzb.zzd();
                    zzbcj.zzb.zza.C0004zza c0004zzaZza = zzbcj.zzb.zza.zza();
                    c0004zzaZza.zzf(zzbcj.zzb.zzd.IN_MEMORY);
                    zzbcj.zzb.zze.zza zzaVarZzb = zzbcj.zzb.zze.zzb();
                    zzaVarZzb.zzd(zzffgVarZzf.zza);
                    zzaVarZzb.zze(zzffgVarZzf.zzb);
                    c0004zzaZza.zzg(zzaVarZzb);
                    zzcVarZzd.zzd(c0004zzaZza);
                    zzfesVarZze.zza.zzb().zzc().zzi(zzcVarZzd.zzbr());
                }
                zzf();
            } else {
                this.zzc.zzf();
                zzf();
                zzfesVarZze = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzfesVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    @Deprecated
    public final zzfet zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzfeq zzfeqVar = this.zzb;
        return new zzfeu(zzmVar, str, new zzbvt(zzfeqVar.zza).zza().zzj, zzfeqVar.zzf, zzxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final synchronized boolean zzd(zzfet zzfetVar, zzfes zzfesVar) {
        boolean zZzh;
        try {
            ConcurrentHashMap concurrentHashMap = this.zza;
            zzfei zzfeiVar = (zzfei) concurrentHashMap.get(zzfetVar);
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzfesVar.zzd = System.currentTimeMillis();
            if (zzfeiVar == null) {
                zzfeq zzfeqVar = this.zzb;
                zzfei zzfeiVar2 = new zzfei(zzfeqVar.zzd, zzfeqVar.zze * 1000);
                if (concurrentHashMap.size() == zzfeqVar.zzc) {
                    int i = zzfeqVar.zzg;
                    int i2 = i - 1;
                    zzfet zzfetVar2 = null;
                    if (i == 0) {
                        throw null;
                    }
                    long jZzc = Long.MAX_VALUE;
                    if (i2 == 0) {
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            if (((zzfei) entry.getValue()).zzc() < jZzc) {
                                jZzc = ((zzfei) entry.getValue()).zzc();
                                zzfetVar2 = (zzfet) entry.getKey();
                            }
                        }
                        if (zzfetVar2 != null) {
                            concurrentHashMap.remove(zzfetVar2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                            if (((zzfei) entry2.getValue()).zzd() < jZzc) {
                                jZzc = ((zzfei) entry2.getValue()).zzd();
                                zzfetVar2 = (zzfet) entry2.getKey();
                            }
                        }
                        if (zzfetVar2 != null) {
                            concurrentHashMap.remove(zzfetVar2);
                        }
                    } else if (i2 == 2) {
                        int iZza = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                            if (((zzfei) entry3.getValue()).zza() < iZza) {
                                iZza = ((zzfei) entry3.getValue()).zza();
                                zzfetVar2 = (zzfet) entry3.getKey();
                            }
                        }
                        if (zzfetVar2 != null) {
                            concurrentHashMap.remove(zzfetVar2);
                        }
                    }
                    this.zzc.zzg();
                }
                concurrentHashMap.put(zzfetVar, zzfeiVar2);
                this.zzc.zzd();
                zzfeiVar = zzfeiVar2;
            }
            zZzh = zzfeiVar.zzh(zzfesVar);
            zzfem zzfemVar = this.zzc;
            zzfemVar.zzc();
            zzfel zzfelVarZza = zzfemVar.zza();
            zzffg zzffgVarZzf = zzfeiVar.zzf();
            zzbcj.zzb.zzc zzcVarZzd = zzbcj.zzb.zzd();
            zzbcj.zzb.zza.C0004zza c0004zzaZza = zzbcj.zzb.zza.zza();
            c0004zzaZza.zzf(zzbcj.zzb.zzd.IN_MEMORY);
            zzbcj.zzb.zzg.zza zzaVarZzb = zzbcj.zzb.zzg.zzb();
            zzaVarZzb.zze(zzfelVarZza.zza);
            zzaVarZzb.zzf(zzfelVarZza.zzb);
            zzaVarZzb.zzg(zzffgVarZzf.zzb);
            c0004zzaZza.zzi(zzaVarZzb);
            zzcVarZzd.zzd(c0004zzaZza);
            zzfesVar.zza.zzb().zzc().zzj(zzcVarZzd.zzbr());
            zzf();
        } catch (Throwable th) {
            throw th;
        }
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfej
    public final synchronized boolean zze(zzfet zzfetVar) {
        zzfei zzfeiVar = (zzfei) this.zza.get(zzfetVar);
        if (zzfeiVar == null) {
            return true;
        }
        return zzfeiVar.zzb() < this.zzb.zzd;
    }

    private final void zzf() {
        Parcelable.Creator<zzfeq> creator = zzfeq.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgB)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfeq zzfeqVar = this.zzb;
            sb.append(zzfeqVar.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfet) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfei) entry.getValue()).zzb(); i2++) {
                    sb.append(QTaELkFI.GjPjsPk);
                }
                for (int iZzb = ((zzfei) entry.getValue()).zzb(); iZzb < zzfeqVar.zzd; iZzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfei) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < zzfeqVar.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze(string);
        }
    }
}
