package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfb extends zzcra {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzddh zze;
    private final zzdgn zzf;
    private final zzcrv zzg;
    private final zzfot zzh;
    private final zzcwl zzi;
    private final zzbzw zzj;
    private boolean zzk;

    public zzdfb(zzcqz zzcqzVar, Context context, zzcfg zzcfgVar, zzddh zzddhVar, zzdgn zzdgnVar, zzcrv zzcrvVar, zzfot zzfotVar, zzcwl zzcwlVar, zzbzw zzbzwVar) {
        super(zzcqzVar);
        this.zzk = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcfgVar);
        this.zze = zzddhVar;
        this.zzf = zzdgnVar;
        this.zzg = zzcrvVar;
        this.zzh = zzfotVar;
        this.zzi = zzcwlVar;
        this.zzj = zzbzwVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcfg zzcfgVar = (zzcfg) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgU)).booleanValue()) {
                if (!this.zzk && zzcfgVar != null) {
                    zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdfa
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcfgVar.destroy();
                        }
                    });
                }
            } else if (zzcfgVar != null) {
                zzcfgVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x005d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0078 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:21:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:26:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x00bf  */
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
    public final boolean zzc(boolean z, Activity activity) {
        Context context;
        zzfca zzfcaVarZzD;
        zzddh zzddhVar = this.zze;
        zzddhVar.zzb();
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        zzdgn zzdgnVar = this.zzf;
        if (com.google.android.gms.ads.internal.util.zzs.zzO(zzdgnVar.zza())) {
            zzcfg zzcfgVar = (zzcfg) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmp)).booleanValue()) {
                if (this.zzk) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                    this.zzi.zzc(zzfdx.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdgnVar.zzb(z, context, this.zzi);
                    zzddhVar.zza();
                    this.zzk = true;
                    return true;
                }
            } else {
                if (this.zzk) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                    this.zzi.zzc(zzfdx.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdgnVar.zzb(z, context, this.zzi);
                    zzddhVar.zza();
                    this.zzk = true;
                    return true;
                }
            }
        } else {
            zzbcv zzbcvVar = zzbde.zzaQ;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
                if (com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc)) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://goo.gle/admob-interstitial-policies");
                    this.zzi.zzd();
                    if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzaR)).booleanValue()) {
                        this.zzh.zza(this.zza.zzb.zzb.zzb);
                    }
                } else {
                    zzcfg zzcfgVar2 = (zzcfg) this.zzd.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmp)).booleanValue() || zzcfgVar2 == null || (zzfcaVarZzD = zzcfgVar2.zzD()) == null || !zzfcaVarZzD.zzar || zzfcaVarZzD.zzas == this.zzj.zzb()) {
                        if (this.zzk) {
                            int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                            this.zzi.zzc(zzfdx.zzd(10, null, null));
                        }
                        context = activity;
                        if (!this.zzk) {
                            if (activity == null) {
                                context = this.zzc;
                            }
                            try {
                                zzdgnVar.zzb(z, context, this.zzi);
                                zzddhVar.zza();
                                this.zzk = true;
                                return true;
                            } catch (zzdgm e) {
                                this.zzi.zze(e);
                            }
                        }
                    } else {
                        int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial consent form has been shown.");
                        this.zzi.zzc(zzfdx.zzd(12, "The consent form has already been shown.", null));
                    }
                }
            } else {
                zzcfg zzcfgVar3 = (zzcfg) this.zzd.get();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmp)).booleanValue()) {
                    if (this.zzk) {
                        int i6 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                        this.zzi.zzc(zzfdx.zzd(10, null, null));
                    }
                    context = activity;
                    if (!this.zzk) {
                        if (activity == null) {
                            context = this.zzc;
                        }
                        zzdgnVar.zzb(z, context, this.zzi);
                        zzddhVar.zza();
                        this.zzk = true;
                        return true;
                    }
                } else {
                    if (this.zzk) {
                        int i7 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("The interstitial ad has been shown.");
                        this.zzi.zzc(zzfdx.zzd(10, null, null));
                    }
                    context = activity;
                    if (!this.zzk) {
                        if (activity == null) {
                            context = this.zzc;
                        }
                        zzdgnVar.zzb(z, context, this.zzi);
                        zzddhVar.zza();
                        this.zzk = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
