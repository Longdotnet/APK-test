package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzfz implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgj zzb;

    public /* synthetic */ zzfz(zzgj zzgjVar, zzq zzqVar, int i) {
        this.$r8$classId = i;
        this.zzb = zzgjVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzgj zzgjVar = this.zzb;
                zzgjVar.zza.zzA$1();
                zzgjVar.zza.zzQ(this.zza);
                break;
            case 1:
                zzgj zzgjVar2 = this.zzb;
                zzgjVar2.zza.zzA$1();
                zzkt zzktVar = zzgjVar2.zza;
                zzktVar.zzaz().zzg();
                zzktVar.zzB$1();
                zzq zzqVar = this.zza;
                com.google.android.gms.common.internal.zzah.checkNotEmpty(zzqVar.zza);
                zzktVar.zzd(zzqVar);
                break;
            case 2:
                zzgj zzgjVar3 = this.zzb;
                zzgjVar3.zza.zzA$1();
                zzkt zzktVar2 = zzgjVar3.zza;
                zzktVar2.zzaz().zzg();
                zzktVar2.zzB$1();
                zzq zzqVar2 = this.zza;
                com.google.android.gms.common.internal.zzah.checkNotEmpty(zzqVar2.zza);
                zzai zzaiVarZzb = zzai.zzb(zzqVar2.zzv);
                String str = zzqVar2.zza;
                zzai zzaiVarZzh = zzktVar2.zzh(str);
                zzktVar2.zzay().zzl.zzc(str, "Setting consent, package, consent", zzaiVarZzb);
                zzktVar2.zzV(str, zzaiVarZzb);
                if (zzaiVarZzb.zzl(zzaiVarZzh, (zzah[]) zzaiVarZzb.zzb.keySet().toArray(new zzah[0]))) {
                    zzktVar2.zzQ(zzqVar2);
                }
                break;
            default:
                zzgj zzgjVar4 = this.zzb;
                zzgjVar4.zza.zzA$1();
                zzgjVar4.zza.zzL(this.zza);
                break;
        }
    }
}
