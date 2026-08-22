package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcke extends com.google.android.gms.ads.internal.client.zzda {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdpz zzc;
    private final zzedo zzd;
    private final zzeju zze;
    private final zzdun zzf;
    private final zzbyo zzg;
    private final zzdqe zzh;
    private final zzdvi zzi;
    private final zzbfx zzj;
    private final zzfhx zzk;
    private final zzfds zzl;
    private final zzctl zzm;
    private final zzdsj zzn;
    private boolean zzo = false;
    private final Long zzp;

    public zzcke(Context context, VersionInfoParcel versionInfoParcel, zzdpz zzdpzVar, zzedo zzedoVar, zzeju zzejuVar, zzdun zzdunVar, zzbyo zzbyoVar, zzdqe zzdqeVar, zzdvi zzdviVar, zzbfx zzbfxVar, zzfhx zzfhxVar, zzfds zzfdsVar, zzctl zzctlVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdpzVar;
        this.zzd = zzedoVar;
        this.zze = zzejuVar;
        this.zzf = zzdunVar;
        this.zzg = zzbyoVar;
        this.zzh = zzdqeVar;
        this.zzi = zzdviVar;
        this.zzj = zzbfxVar;
        this.zzk = zzfhxVar;
        this.zzl = zzfdsVar;
        this.zzm = zzctlVar;
        this.zzn = zzdsjVar;
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzp = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public static void zzb(zzcke zzckeVar) {
        com.google.android.gms.ads.internal.zzv.zza.zzo.zzd(zzckeVar.zza, zzckeVar.zzn);
    }

    public static void zzc(zzcke zzckeVar, Runnable runnable) {
        com.google.android.gms.common.internal.zzah.checkMainThread$1("Adapters must be initialized on the main thread.");
        Map mapZze = ((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzg().zze();
        if (mapZze.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (zzckeVar.zzc.zzd()) {
            HashMap map = new HashMap();
            Iterator it = mapZze.values().iterator();
            while (it.hasNext()) {
                for (zzbpj zzbpjVar : ((zzbpk) it.next()).zza) {
                    String str = zzbpjVar.zzb;
                    for (String str2 : zzbpjVar.zza) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzedp zzedpVarZza = zzckeVar.zzd.zza(str3, jSONObject);
                    if (zzedpVarZza != null) {
                        zzfdu zzfduVar = (zzfdu) zzedpVarZza.zzb;
                        if (!zzfduVar.zzC() && zzfduVar.zzB()) {
                            zzfduVar.zzj(zzckeVar.zza, (zzefe) zzedpVarZza.zzc, (List) entry.getValue());
                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Initialized rewarded video mediation adapter " + str3);
                        }
                    }
                } catch (zzfdd e) {
                    String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Failed to initialize rewarded video mediation adapter \"", str3, "\"");
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk(strM$1, e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized float zze() {
        return com.google.android.gms.ads.internal.zzv.zza.zzj.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzg() {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzi() {
        this.zzf.zzq();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzj(boolean z) throws RemoteException {
        try {
            Context context = this.zza;
            zzfsb.zza(context).zzc(z);
            if (z) {
                return;
            }
            try {
                if (context.getSharedPreferences("query_info_shared_prefs", 0).edit().clear().commit()) {
                    return;
                } else {
                    throw new IOException("Failed to remove query_info_shared_prefs");
                }
            } catch (IOException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "clearStorageOnGpidPubDisable_scar");
                return;
            }
            throw new RemoteException(e.getMessage());
        } catch (IOException e2) {
            throw new RemoteException(e2.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzk() {
        if (this.zzo) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Mobile ads is initialized already.");
            return;
        }
        Context context = this.zza;
        zzbde.zza(context);
        VersionInfoParcel versionInfoParcel = this.zzb;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzi.zzu(context, versionInfoParcel);
        this.zzm.zzd();
        zzvVar.zzk.zzi(context);
        this.zzo = true;
        this.zzf.zzr();
        this.zze.zzf();
        zzbcv zzbcvVar = zzbde.zzeq;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            this.zzh.zzf();
        }
        this.zzi.zzg();
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjE)).booleanValue()) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx();
                }
            });
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzls)).booleanValue()) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj.zza(new zzbus());
                }
            });
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdl)).booleanValue()) {
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcka
                @Override // java.lang.Runnable
                public final void run() {
                    zzfea.zzb(this.zza.zza, true);
                }
            });
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzeT)).booleanValue()) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzeU)).booleanValue()) {
                zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckb
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcke.zzb(this.zza);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
        String strZzq;
        Runnable runnable;
        Context context = this.zza;
        zzbde.zza(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzev)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                strZzq = com.google.android.gms.ads.internal.util.zzs.zzq(context);
            } catch (RemoteException | RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "NonagonMobileAdsSettingManager_AppId");
                strZzq = "";
            }
        } else {
            strZzq = "";
        }
        boolean z = true;
        String str2 = true == TextUtils.isEmpty(strZzq) ? str : strZzq;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzbcv zzbcvVar = zzbde.zzeo;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        zzbcv zzbcvVar2 = zzbde.zzbe;
        zzbdc zzbdcVar = zzbdVar.zzd;
        boolean zBooleanValue2 = zBooleanValue | ((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue();
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzckd
                @Override // java.lang.Runnable
                public final void run() {
                    zzgdy zzgdyVar = zzcaf.zzf;
                    final zzcke zzckeVar = this.zza;
                    final Runnable runnable3 = runnable2;
                    zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjy
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcke.zzc(zzckeVar, runnable3);
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z = zBooleanValue2;
        }
        zzckd zzckdVar = runnable;
        if (z) {
            com.google.android.gms.ads.internal.zzv.zza.zzm.zzd(this.zza, this.zzb, true, null, str2, null, zzckdVar, this.zzk, this.zzn, this.zzp, this.zzi.zzq());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzm(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        this.zzi.zzh(zzdnVar, zzdvh.API);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Context is null. Failed to open debug menu.");
        } else {
            com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
            zzauVar.zzd = str;
            zzauVar.zze = this.zzb.afmaVersion;
            zzauVar.zzr();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzo(zzbpq zzbpqVar) {
        this.zzl.zzf(zzbpqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzp(boolean z) {
        com.google.android.gms.ads.internal.zzv.zza.zzj.zzc(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzq(float f) {
        com.google.android.gms.ads.internal.zzv.zza.zzj.zzd(f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zzr(String str) {
        Context context = this.zza;
        zzbde.zza(context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeo)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzm.zzd(context, this.zzb, true, null, str, null, null, this.zzk, null, null, this.zzi.zzq());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs(zzbmk zzbmkVar) {
        this.zzf.zzs(zzbmkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjQ)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzz(str);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzu(com.google.android.gms.ads.internal.client.zzfx zzfxVar) {
        this.zzg.zzn(this.zza, zzfxVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized boolean zzv() {
        return com.google.android.gms.ads.internal.zzv.zza.zzj.zze();
    }

    public final void zzx() {
        String str;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        if (((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzM()) {
            com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi();
            zzjVar.zzR();
            synchronized (zzjVar.zza) {
                str = zzjVar.zzz;
            }
            if (zzvVar.zzp.zzj(this.zza, str, this.zzb.afmaVersion)) {
                return;
            }
            ((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzx(false);
            ((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzw("");
        }
    }
}
