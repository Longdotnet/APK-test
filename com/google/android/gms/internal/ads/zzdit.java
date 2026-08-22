package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdit {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzed zzb;
    private zzbgi zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzfa zzg;
    private Bundle zzh;
    private zzcfg zzi;
    private zzcfg zzj;
    private zzcfg zzk;
    private zzedh zzl;
    private ListenableFuture zzm;
    private zzcak zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbgp zzs;
    private zzbgp zzt;
    private String zzu;
    private float zzx;
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.emptyList();

    public static zzdit zzag(zzbqb zzbqbVar) {
        try {
            zzdis zzdisVarZzak = zzak(zzbqbVar.zzg(), null);
            zzbgi zzbgiVarZzh = zzbqbVar.zzh();
            View view = (View) zzam(zzbqbVar.zzj());
            String strZzo = zzbqbVar.zzo();
            List listZzr = zzbqbVar.zzr();
            String strZzm = zzbqbVar.zzm();
            Bundle bundleZzf = zzbqbVar.zzf();
            String strZzn = zzbqbVar.zzn();
            View view2 = (View) zzam(zzbqbVar.zzk());
            IObjectWrapper iObjectWrapperZzl = zzbqbVar.zzl();
            String strZzq = zzbqbVar.zzq();
            String strZzp = zzbqbVar.zzp();
            double dZze = zzbqbVar.zze();
            zzbgp zzbgpVarZzi = zzbqbVar.zzi();
            zzdit zzditVar = new zzdit();
            zzditVar.zza = 2;
            zzditVar.zzb = zzdisVarZzak;
            zzditVar.zzc = zzbgiVarZzh;
            zzditVar.zzd = view;
            zzditVar.zzZ("headline", strZzo);
            zzditVar.zze = listZzr;
            zzditVar.zzZ("body", strZzm);
            zzditVar.zzh = bundleZzf;
            zzditVar.zzZ("call_to_action", strZzn);
            zzditVar.zzo = view2;
            zzditVar.zzq = iObjectWrapperZzl;
            zzditVar.zzZ("store", strZzq);
            zzditVar.zzZ(xPQrbOSWiEdU.tqvSodTWTXZs, strZzp);
            zzditVar.zzr = dZze;
            zzditVar.zzs = zzbgpVarZzi;
            return zzditVar;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdit zzah(zzbqc zzbqcVar) {
        try {
            zzdis zzdisVarZzak = zzak(zzbqcVar.zzf(), null);
            zzbgi zzbgiVarZzg = zzbqcVar.zzg();
            View view = (View) zzam(zzbqcVar.zzi());
            String strZzo = zzbqcVar.zzo();
            List listZzp = zzbqcVar.zzp();
            String strZzm = zzbqcVar.zzm();
            Bundle bundleZze = zzbqcVar.zze();
            String strZzn = zzbqcVar.zzn();
            View view2 = (View) zzam(zzbqcVar.zzj());
            IObjectWrapper iObjectWrapperZzk = zzbqcVar.zzk();
            String strZzl = zzbqcVar.zzl();
            zzbgp zzbgpVarZzh = zzbqcVar.zzh();
            zzdit zzditVar = new zzdit();
            zzditVar.zza = 1;
            zzditVar.zzb = zzdisVarZzak;
            zzditVar.zzc = zzbgiVarZzg;
            zzditVar.zzd = view;
            zzditVar.zzZ("headline", strZzo);
            zzditVar.zze = listZzp;
            zzditVar.zzZ("body", strZzm);
            zzditVar.zzh = bundleZze;
            zzditVar.zzZ("call_to_action", strZzn);
            zzditVar.zzo = view2;
            zzditVar.zzq = iObjectWrapperZzk;
            zzditVar.zzZ("advertiser", strZzl);
            zzditVar.zzt = zzbgpVarZzh;
            return zzditVar;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdit zzai(zzbqb zzbqbVar) {
        try {
            return zzal(zzak(zzbqbVar.zzg(), null), zzbqbVar.zzh(), (View) zzam(zzbqbVar.zzj()), zzbqbVar.zzo(), zzbqbVar.zzr(), zzbqbVar.zzm(), zzbqbVar.zzf(), zzbqbVar.zzn(), (View) zzam(zzbqbVar.zzk()), zzbqbVar.zzl(), zzbqbVar.zzq(), zzbqbVar.zzp(), zzbqbVar.zze(), zzbqbVar.zzi(), null, 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdit zzaj(zzbqc zzbqcVar) {
        try {
            return zzal(zzak(zzbqcVar.zzf(), null), zzbqcVar.zzg(), (View) zzam(zzbqcVar.zzi()), zzbqcVar.zzo(), zzbqcVar.zzp(), zzbqcVar.zzm(), zzbqcVar.zze(), zzbqcVar.zzn(), (View) zzam(zzbqcVar.zzj()), zzbqcVar.zzk(), null, null, -1.0d, zzbqcVar.zzh(), zzbqcVar.zzl(), 0.0f);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdis zzak(com.google.android.gms.ads.internal.client.zzed zzedVar, zzbqf zzbqfVar) {
        if (zzedVar == null) {
            return null;
        }
        return new zzdis(zzedVar, zzbqfVar);
    }

    private static zzdit zzal(com.google.android.gms.ads.internal.client.zzed zzedVar, zzbgi zzbgiVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbgp zzbgpVar, String str6, float f) {
        zzdit zzditVar = new zzdit();
        zzditVar.zza = 6;
        zzditVar.zzb = zzedVar;
        zzditVar.zzc = zzbgiVar;
        zzditVar.zzd = view;
        zzditVar.zzZ("headline", str);
        zzditVar.zze = list;
        zzditVar.zzZ("body", str2);
        zzditVar.zzh = bundle;
        zzditVar.zzZ("call_to_action", str3);
        zzditVar.zzo = view2;
        zzditVar.zzq = iObjectWrapper;
        zzditVar.zzZ("store", str4);
        zzditVar.zzZ(FirebaseAnalytics.Param.PRICE, str5);
        zzditVar.zzr = d;
        zzditVar.zzs = zzbgpVar;
        zzditVar.zzZ("advertiser", str6);
        zzditVar.zzR(f);
        return zzditVar;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized String zzE() {
        return zzF("store");
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.getOrDefault(str, null);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        try {
            zzcfg zzcfgVar = this.zzi;
            if (zzcfgVar != null) {
                zzcfgVar.destroy();
                this.zzi = null;
            }
            zzcfg zzcfgVar2 = this.zzj;
            if (zzcfgVar2 != null) {
                zzcfgVar2.destroy();
                this.zzj = null;
            }
            zzcfg zzcfgVar3 = this.zzk;
            if (zzcfgVar3 != null) {
                zzcfgVar3.destroy();
                this.zzk = null;
            }
            ListenableFuture listenableFuture = this.zzm;
            if (listenableFuture != null) {
                listenableFuture.cancel(false);
                this.zzm = null;
            }
            zzcak zzcakVar = this.zzn;
            if (zzcakVar != null) {
                zzcakVar.cancel(false);
                this.zzn = null;
            }
            this.zzl = null;
            this.zzv.clear();
            this.zzw.clear();
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzh = null;
            this.zzo = null;
            this.zzp = null;
            this.zzq = null;
            this.zzs = null;
            this.zzt = null;
            this.zzu = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzJ(zzbgi zzbgiVar) {
        this.zzc = zzbgiVar;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(com.google.android.gms.ads.internal.client.zzfa zzfaVar) {
        this.zzg = zzfaVar;
    }

    public final synchronized void zzM(zzbgp zzbgpVar) {
        this.zzs = zzbgpVar;
    }

    public final synchronized void zzN(String str, zzbgc zzbgcVar) {
        try {
            if (zzbgcVar == null) {
                this.zzv.remove(str);
            } else {
                this.zzv.put(str, zzbgcVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzO(zzcfg zzcfgVar) {
        this.zzj = zzcfgVar;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbgp zzbgpVar) {
        this.zzt = zzbgpVar;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcfg zzcfgVar) {
        this.zzk = zzcfgVar;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzedh zzedhVar) {
        this.zzl = zzedhVar;
    }

    public final synchronized void zzX(zzcak zzcakVar) {
        this.zzn = zzcakVar;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        try {
            if (str2 == null) {
                this.zzw.remove(str);
            } else {
                this.zzw.put(str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(com.google.android.gms.ads.internal.client.zzed zzedVar) {
        this.zzb = zzedVar;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcfg zzcfgVar) {
        this.zzi = zzcfgVar;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        try {
            if (this.zzh == null) {
                this.zzh = new Bundle();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzed zzj() {
        return this.zzb;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzfa zzk() {
        return this.zzg;
    }

    public final synchronized zzbgi zzl() {
        return this.zzc;
    }

    public final zzbgp zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbgo.zzh((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbgp zzn() {
        return this.zzs;
    }

    public final synchronized zzbgp zzo() {
        return this.zzt;
    }

    public final synchronized zzcak zzp() {
        return this.zzn;
    }

    public final synchronized zzcfg zzq() {
        return this.zzj;
    }

    public final synchronized zzcfg zzr() {
        return this.zzk;
    }

    public final synchronized zzcfg zzs() {
        return this.zzi;
    }

    public final synchronized zzedh zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }

    public static zzdit zzt(zzbqf zzbqfVar) {
        try {
            return zzal(zzak(zzbqfVar.zzj(), zzbqfVar), zzbqfVar.zzk(), (View) zzam(zzbqfVar.zzm()), zzbqfVar.zzs(), zzbqfVar.zzv(), zzbqfVar.zzq(), zzbqfVar.zzi(), zzbqfVar.zzr(), (View) zzam(zzbqfVar.zzn()), zzbqfVar.zzo(), zzbqfVar.zzu(), zzbqfVar.zzt(), zzbqfVar.zze(), zzbqfVar.zzl(), zzbqfVar.zzp(), zzbqfVar.zzf());
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk(dLDI.qHpBa, e);
            return null;
        }
    }
}
