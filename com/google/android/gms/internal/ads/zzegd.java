package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes.dex */
public final class zzegd implements zzeds {
    private final Context zza;
    private final zzdhb zzb;
    private final Executor zzc;

    public zzegd(Context context, zzdhb zzdhbVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdhbVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfcn zzfcnVar, int i) {
        return zzfcnVar.zza.zza.zzg.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzdit zzditVarZzah;
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        zzbqb zzbqbVarZzD = zzfduVar.zzD();
        zzbqc zzbqcVarZzE = zzfduVar.zzE();
        zzbqf zzbqfVarZzd = zzfduVar.zzd();
        if (zzbqfVarZzd != null && zzc(zzfcnVar, 6)) {
            zzditVarZzah = zzdit.zzt(zzbqfVarZzd);
        } else if (zzbqbVarZzD != null && zzc(zzfcnVar, 6)) {
            zzditVarZzah = zzdit.zzai(zzbqbVarZzD);
        } else if (zzbqbVarZzD != null && zzc(zzfcnVar, 2)) {
            zzditVarZzah = zzdit.zzag(zzbqbVarZzD);
        } else if (zzbqcVarZzE != null && zzc(zzfcnVar, 6)) {
            zzditVarZzah = zzdit.zzaj(zzbqcVarZzE);
        } else {
            if (zzbqcVarZzE == null || !zzc(zzfcnVar, 1)) {
                throw new zzehf(1, "No native ad mappers");
            }
            zzditVarZzah = zzdit.zzah(zzbqcVarZzE);
        }
        if (zzditVarZzah != null) {
            zzfcw zzfcwVar = zzfcnVar.zza.zza;
            if (zzfcwVar.zzg.contains(Integer.toString(zzditVarZzah.zzc()))) {
                zzdiv zzdivVarZze = this.zzb.zze(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdjf(zzditVarZzah), new zzdky(zzbqcVarZzE, zzbqbVarZzD, zzbqfVarZzd));
                ((zzefd) zzedpVar.zzc).zzc(zzdivVarZze.zzk());
                zzdivVarZze.zzd().zzo(new zzcmg(zzfduVar), this.zzc);
                return zzdivVarZze.zza();
            }
        }
        throw new zzehf(1, "No corresponding native ad listener");
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        String string = zzfcaVar.zzv.toString();
        String strZzm = AsyncTimeout.Companion.zzm(zzfcaVar.zzs);
        zzfduVar.zzp(this.zza, zzfcwVar.zzd, string, strZzm, (zzbpw) zzedpVar.zzc, zzfcwVar.zzi, zzfcwVar.zzg);
    }
}
