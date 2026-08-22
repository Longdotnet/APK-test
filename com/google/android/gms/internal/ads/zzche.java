package com.google.android.gms.internal.ads;

import android.content.Context;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzche implements zzcld {
    private static zzche zza;

    private static synchronized zzche zzE(Context context, zzbpq zzbpqVar, int i, boolean z, int i2, zzcik zzcikVar) {
        try {
            zzche zzcheVar = zza;
            if (zzcheVar != null) {
                return zzcheVar;
            }
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzvVar.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzbde.zza(context);
            if (((Boolean) zzbew.zze.zze()).booleanValue()) {
                zzbco.zzd(context);
            }
            zzfds zzfdsVarZzd = zzfds.zzd(context);
            VersionInfoParcel versionInfoParcelZzc = zzfdsVarZzd.zzc(ModuleDescriptor.MODULE_VERSION, false, i2);
            zzfdsVarZzd.zzf(zzbpqVar);
            zzciz zzcizVar = new zzciz(null);
            zzchf zzchfVar = new zzchf();
            zzchfVar.zzf(versionInfoParcelZzc);
            zzchfVar.zze(context);
            zzchfVar.zzd(jCurrentTimeMillis);
            zzcizVar.zzb(new zzchh(zzchfVar, null));
            zzcizVar.zzc(new zzcjt(zzcikVar));
            zzche zzcheVarZza = zzcizVar.zza();
            zzbcv zzbcvVar = zzbde.zznS;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                zzvVar.zzf.zzb(zzffu.zzc(), zzcheVarZza.zzi());
                zzvVar.zzf.zzc();
            }
            zzvVar.zzi.zzu(context, versionInfoParcelZzc);
            zzvVar.zzk.zzi(context);
            zzvVar.zzd.zzm(context);
            zzvVar.zzd.zzl(context);
            GamepadHandler_API19.zza(context);
            zzvVar.zzh.zzd(context);
            zzvVar.zzC.zzb(context);
            ((com.google.android.gms.ads.internal.util.zzcb) ((zzcio) zzcheVarZza).zzak.zzb()).zzc();
            zzbyp.zzb(context);
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzgv)).booleanValue()) {
                if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzaM)).booleanValue()) {
                    new zzebn(context, versionInfoParcelZzc, new zzbcc(new zzbci(context)), new zzeas(new zzeao(context), (zzgdy) ((zzcio) zzcheVarZza).zzd.zzb())).zzb(((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzN());
                }
            }
            zza = zzcheVarZza;
            return zzcheVarZza;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static zzche zza(Context context, zzbpq zzbpqVar, int i) {
        return zzE(context, zzbpqVar, ModuleDescriptor.MODULE_VERSION, false, i, new zzcik());
    }

    public abstract Executor zzA();

    public abstract ScheduledExecutorService zzB();

    public abstract zzbzh zzC();

    @Override // com.google.android.gms.internal.ads.zzcld
    public final zzbzh zzD() {
        return zzC();
    }

    public abstract zzcke zzb();

    public abstract zzcof zzc();

    public abstract zzcpw zzd();

    public abstract zzcyv zze();

    public abstract zzdge zzf();

    public abstract zzdha zzg();

    public abstract zzdor zzh();

    public abstract zzdsj zzi();

    public abstract zzdtt zzj();

    public abstract zzdvi zzk();

    public abstract zzdwf zzl();

    public abstract zzecl zzm();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzv zzn();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzab zzo();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzau zzp();

    @Override // com.google.android.gms.internal.ads.zzcld
    public final zzevf zzq(zzbvq zzbvqVar, int i) {
        return zzr(new zzewi(zzbvqVar, i));
    }

    public abstract zzevf zzr(zzewi zzewiVar);

    public abstract zzexa zzs();

    public abstract zzeyo zzt();

    public abstract zzfaf zzu();

    public abstract zzfbt zzv();

    public abstract zzfdl zzw();

    public abstract zzfdv zzx();

    public abstract zzfhx zzy();

    public abstract zzfkj zzz();
}
