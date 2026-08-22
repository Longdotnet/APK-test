package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzaec implements zzaex {
    private static final zzaei zza = new zzaea();
    private final zzaei zzb;

    public zzaec() {
        zzaei zzaeiVar;
        zzada zzadaVarZza = zzada.zza();
        try {
            zzaeiVar = (zzaei) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzaeiVar = zza;
        }
        zzaeb zzaebVar = new zzaeb(zzadaVarZza, zzaeiVar);
        zzadl.zzf(zzaebVar, "messageInfoFactory");
        this.zzb = zzaebVar;
    }

    private static boolean zzb(zzaeh zzaehVar) {
        return zzaehVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final zzaew zza(Class cls) {
        zzaey.zzG(cls);
        zzaeh zzaehVarZzb = this.zzb.zzb(cls);
        if (zzaehVarZzb.zzb()) {
            return zzadf.class.isAssignableFrom(cls) ? zzaeo.zzc(zzaey.zzB(), zzacv.zzb(), zzaehVarZzb.zza()) : zzaeo.zzc(zzaey.zzz(), zzacv.zza(), zzaehVarZzb.zza());
        }
        if (zzadf.class.isAssignableFrom(cls)) {
            return zzb(zzaehVarZzb) ? zzaen.zzl(cls, zzaehVarZzb, zzaeq.zzb(), zzady.zze(), zzaey.zzB(), zzacv.zzb(), zzaeg.zzb()) : zzaen.zzl(cls, zzaehVarZzb, zzaeq.zzb(), zzady.zze(), zzaey.zzB(), null, zzaeg.zzb());
        }
        return zzb(zzaehVarZzb) ? zzaen.zzl(cls, zzaehVarZzb, zzaeq.zza(), zzady.zzd(), zzaey.zzz(), zzacv.zza(), zzaeg.zza()) : zzaen.zzl(cls, zzaehVarZzb, zzaeq.zza(), zzady.zzd(), zzaey.zzA(), null, zzaeg.zza());
    }
}
