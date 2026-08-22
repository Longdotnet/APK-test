package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzfi implements zzgc {
    private static final zzfo zza = new zzfg();
    private final zzfo zzb;

    public zzfi() {
        zzfo zzfoVar;
        zzen zzenVarZza = zzen.zza();
        try {
            zzfoVar = (zzfo) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzfoVar = zza;
        }
        zzfh zzfhVar = new zzfh(zzenVarZza, zzfoVar);
        zzev.zzf(zzfhVar, "messageInfoFactory");
        this.zzb = zzfhVar;
    }

    private static boolean zzb(zzfn zzfnVar) {
        return zzfnVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.auth.zzgc
    public final <T> zzgb<T> zza(Class<T> cls) {
        zzgd.zzg(cls);
        zzfn zzfnVarZzb = this.zzb.zzb(cls);
        if (zzfnVarZzb.zzb()) {
            return zzeq.class.isAssignableFrom(cls) ? zzfu.zzb(zzgd.zzc(), zzej.zzb(), zzfnVarZzb.zza()) : zzfu.zzb(zzgd.zza(), zzej.zza(), zzfnVarZzb.zza());
        }
        if (zzeq.class.isAssignableFrom(cls)) {
            return zzb(zzfnVarZzb) ? zzft.zzj(cls, zzfnVarZzb, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), zzej.zzb(), zzfm.zzb()) : zzft.zzj(cls, zzfnVarZzb, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), null, zzfm.zzb());
        }
        return zzb(zzfnVarZzb) ? zzft.zzj(cls, zzfnVarZzb, zzfw.zza(), zzfe.zzc(), zzgd.zza(), zzej.zza(), zzfm.zza()) : zzft.zzj(cls, zzfnVarZzb, zzfw.zza(), zzfe.zzc(), zzgd.zzb(), null, zzfm.zza());
    }
}
