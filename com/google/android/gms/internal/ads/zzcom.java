package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzcom extends zzcra {
    private final zzcfg zzc;
    private final int zzd;
    private final Context zze;
    private final zzcoa zzf;
    private final zzdgn zzg;
    private final zzddh zzh;
    private final zzcwl zzi;
    private final boolean zzj;
    private final zzbzw zzk;
    private boolean zzl;

    public zzcom(zzcqz zzcqzVar, Context context, zzcfg zzcfgVar, int i, zzcoa zzcoaVar, zzdgn zzdgnVar, zzddh zzddhVar, zzcwl zzcwlVar, zzbzw zzbzwVar) {
        super(zzcqzVar);
        this.zzl = false;
        this.zzc = zzcfgVar;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcoaVar;
        this.zzg = zzdgnVar;
        this.zzh = zzddhVar;
        this.zzi = zzcwlVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfK)).booleanValue();
        this.zzk = zzbzwVar;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcra
    public final void zzb() {
        super.zzb();
        zzcfg zzcfgVar = this.zzc;
        if (zzcfgVar != null) {
            zzcfgVar.destroy();
        }
    }

    public final void zzc(zzbaq zzbaqVar) {
        zzcfg zzcfgVar = this.zzc;
        if (zzcfgVar != null) {
            zzcfgVar.zzak(zzbaqVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzd(Activity activity, zzbbd zzbbdVar, boolean z) {
        zzcfg zzcfgVar;
        zzfca zzfcaVarZzD;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        boolean z2 = this.zzj;
        if (z2) {
            this.zzh.zzb();
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        zzdgn zzdgnVar = this.zzg;
        if (!com.google.android.gms.ads.internal.util.zzs.zzO(zzdgnVar.zza())) {
            zzbcv zzbcvVar = zzbde.zzaQ;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
                if (com.google.android.gms.ads.internal.util.zzs.zzH(context)) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzi.zzd();
                    if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzaR)).booleanValue()) {
                        new zzfot(context.getApplicationContext(), zzvVar.zzu.zzb()).zza(this.zza.zzb.zzb.zzb);
                        return;
                    }
                    return;
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmp)).booleanValue() && (zzcfgVar = this.zzc) != null && (zzfcaVarZzD = zzcfgVar.zzD()) != null && zzfcaVarZzD.zzar && zzfcaVarZzD.zzas != this.zzk.zzb()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The app open consent form has been shown.");
            this.zzi.zzc(zzfdx.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzl) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("App open interstitial ad is already visible.");
            this.zzi.zzc(zzfdx.zzd(10, null, null));
        }
        if (this.zzl) {
            return;
        }
        try {
            zzdgnVar.zzb(z, context, this.zzi);
            if (z2) {
                this.zzh.zza();
            }
            this.zzl = true;
        } catch (zzdgm e) {
            this.zzi.zze(e);
        }
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
