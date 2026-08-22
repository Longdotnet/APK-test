package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;

/* JADX INFO: loaded from: classes2.dex */
final class zzle implements zzly {
    private static final zzlk zza = new zzlc();
    private final zzlk zzb;

    private static boolean zzb(zzlj zzljVar) {
        return zzljVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final zzlx zza(Class cls) {
        zzlz.zzG(cls);
        zzlj zzljVarZzb = this.zzb.zzb(cls);
        if (zzljVarZzb.zzb()) {
            return zzkf.class.isAssignableFrom(cls) ? zzlq.zzc(zzlz.zzB(), zzju.zzb(), zzljVarZzb.zza()) : zzlq.zzc(zzlz.zzz(), zzju.zza(), zzljVarZzb.zza());
        }
        if (zzkf.class.isAssignableFrom(cls)) {
            return zzb(zzljVarZzb) ? zzlp.zzl(cls, zzljVarZzb, zzls.zzb(), zzla.zzd(), zzlz.zzB(), zzju.zzb(), zzli.zzb()) : zzlp.zzl(cls, zzljVarZzb, zzls.zzb(), zzla.zzd(), zzlz.zzB(), null, zzli.zzb());
        }
        return zzb(zzljVarZzb) ? zzlp.zzl(cls, zzljVarZzb, zzls.zza(), zzla.zzc(), zzlz.zzz(), zzju.zza(), zzli.zza()) : zzlp.zzl(cls, zzljVarZzb, zzls.zza(), zzla.zzc(), zzlz.zzA(), null, zzli.zza());
    }

    public zzle() {
        zzlk zzlkVar;
        zzka zzkaVarZza = zzka.zza();
        try {
            zzlkVar = (zzlk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzlkVar = zza;
        }
        zzld zzldVar = new zzld(zzkaVarZza, zzlkVar);
        zzkn.zzf(zzldVar, MnHfHMYQDPUO.zFlvXzGaAYy);
        this.zzb = zzldVar;
    }
}
