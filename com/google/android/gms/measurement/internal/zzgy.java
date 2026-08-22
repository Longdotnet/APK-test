package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.work.impl.WorkerWrapper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.net.URL;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzgy implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzhx zza;

    public /* synthetic */ zzgy(zzhx zzhxVar, int i) {
        this.$r8$classId = i;
        this.zza = zzhxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pair pair;
        NetworkInfo activeNetworkInfo;
        switch (this.$r8$classId) {
            case 0:
                zzhx zzhxVar = this.zza;
                zzhxVar.zzg();
                zzfr zzfrVar = (zzfr) zzhxVar.mBuilder;
                zzew zzewVar = zzfrVar.zzl;
                zzfr.zzP(zzewVar);
                boolean zZzb = zzewVar.zzn.zzb();
                zzeh zzehVar = zzfrVar.zzm;
                if (zZzb) {
                    zzfr.zzR(zzehVar);
                    zzehVar.zzk.zza("Deferred Deep Link already retrieved. Not fetching again.");
                } else {
                    zzew zzewVar2 = zzfrVar.zzl;
                    zzfr.zzP(zzewVar2);
                    long jZza = zzewVar2.zzo.zza();
                    zzfr.zzP(zzewVar2);
                    zzewVar2.zzo.zzb(1 + jZza);
                    boolean z = true;
                    if (jZza >= 5) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzg.zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                        zzfr.zzP(zzewVar2);
                        zzewVar2.zzn.zza(true);
                    } else {
                        zzfo zzfoVar = zzfrVar.zzn;
                        zzfr.zzR(zzfoVar);
                        zzfoVar.zzg();
                        zzib zzibVar = zzfrVar.zzv;
                        zzfr.zzR(zzibVar);
                        zzfr.zzR(zzibVar);
                        String strZzl = zzfrVar.zzh().zzl();
                        zzfr.zzP(zzewVar2);
                        zzewVar2.zzg();
                        zzfr zzfrVar2 = (zzfr) zzewVar2.mBuilder;
                        zzfrVar2.zzr.getClass();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        String str = zzewVar2.zzv;
                        if (str == null || jElapsedRealtime >= zzewVar2.zzx) {
                            zzewVar2.zzx = zzfrVar2.zzk.zzi(strZzl, zzdu.zza) + jElapsedRealtime;
                            try {
                                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzfrVar2.zze);
                                zzewVar2.zzv = "";
                                String str2 = advertisingIdInfo.zza;
                                if (str2 != null) {
                                    zzewVar2.zzv = str2;
                                }
                                zzewVar2.zzw = advertisingIdInfo.zzb;
                            } catch (Exception e) {
                                zzeh zzehVar2 = zzfrVar2.zzm;
                                zzfr.zzR(zzehVar2);
                                zzehVar2.zzk.zzb(e, "Unable to get advertising id");
                                zzewVar2.zzv = "";
                            }
                            pair = new Pair(zzewVar2.zzv, Boolean.valueOf(zzewVar2.zzw));
                        } else {
                            pair = new Pair(str, Boolean.valueOf(zzewVar2.zzw));
                        }
                        Boolean boolZzk = zzfrVar.zzk.zzk(ygoi.cpfLp);
                        if (boolZzk != null && !boolZzk.booleanValue()) {
                            z = false;
                        }
                        if (!z || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzk.zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                        } else {
                            zzfr.zzR(zzibVar);
                            zzibVar.zzu();
                            zzfr zzfrVar3 = (zzfr) zzibVar.mBuilder;
                            ConnectivityManager connectivityManager = (ConnectivityManager) zzfrVar3.zze.getSystemService("connectivity");
                            URL url = null;
                            if (connectivityManager != null) {
                                try {
                                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                } catch (SecurityException unused) {
                                    activeNetworkInfo = null;
                                }
                            } else {
                                activeNetworkInfo = null;
                            }
                            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzg.zza("Network is not available for Deferred Deep Link request. Skipping");
                            } else {
                                zzlb zzlbVar = zzfrVar.zzp;
                                zzfr.zzP(zzlbVar);
                                ((zzfr) zzfrVar.zzh().mBuilder).zzk.zzh();
                                String str3 = (String) pair.first;
                                long jZza2 = zzewVar2.zzo.zza() - 1;
                                zzfr zzfrVar4 = (zzfr) zzlbVar.mBuilder;
                                try {
                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str3);
                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzl);
                                    String strConcat = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v74029." + zzlbVar.zzm()) + "&rdid=" + str3 + "&bundleid=" + strZzl + "&retry=" + jZza2;
                                    if (strZzl.equals(zzfrVar4.zzk.zzB("debug.deferred.deeplink"))) {
                                        strConcat = strConcat.concat(wsbWxekY.ZFrBWYTjywzy);
                                    }
                                    url = new URL(strConcat);
                                } catch (IllegalArgumentException e2) {
                                    e = e2;
                                    zzeh zzehVar3 = zzfrVar4.zzm;
                                    zzfr.zzR(zzehVar3);
                                    zzehVar3.zzd.zzb(e.getMessage(), "Failed to create BOW URL for Deferred Deep Link. exception");
                                } catch (MalformedURLException e3) {
                                    e = e3;
                                    zzeh zzehVar4 = zzfrVar4.zzm;
                                    zzfr.zzR(zzehVar4);
                                    zzehVar4.zzd.zzb(e.getMessage(), "Failed to create BOW URL for Deferred Deep Link. exception");
                                }
                                if (url != null) {
                                    zzfr.zzR(zzibVar);
                                    zzs zzsVar = new zzs(zzfrVar);
                                    zzibVar.zzg();
                                    zzibVar.zzu();
                                    zzfo zzfoVar2 = zzfrVar3.zzn;
                                    zzfr.zzR(zzfoVar2);
                                    zzfoVar2.zzo(new WorkerWrapper.AnonymousClass1(zzibVar, strZzl, url, zzsVar));
                                }
                            }
                        }
                    }
                }
                break;
            default:
                zzs zzsVar2 = this.zza.zzb;
                zzfr zzfrVar5 = zzsVar2.zza;
                zzfo zzfoVar3 = zzfrVar5.zzn;
                zzfr.zzR(zzfoVar3);
                zzfoVar3.zzg();
                if (zzsVar2.zzd()) {
                    boolean zZze = zzsVar2.zze();
                    zzhx zzhxVar2 = zzfrVar5.zzt;
                    zzew zzewVar3 = zzfrVar5.zzl;
                    if (zZze) {
                        zzfr.zzP(zzewVar3);
                        zzewVar3.zzq.zzb(null);
                        Bundle bundle = new Bundle();
                        bundle.putString(FirebaseAnalytics.Param.SOURCE, "(not set)");
                        bundle.putString(FirebaseAnalytics.Param.MEDIUM, "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        zzfr.zzQ(zzhxVar2);
                        zzhxVar2.zzG("auto", "_cmpx", bundle);
                    } else {
                        zzfr.zzP(zzewVar3);
                        String strZza = zzewVar3.zzq.zza();
                        if (TextUtils.isEmpty(strZza)) {
                            zzeh zzehVar5 = zzfrVar5.zzm;
                            zzfr.zzR(zzehVar5);
                            zzehVar5.zze.zza("Cache still valid but referrer not found");
                        } else {
                            zzfr.zzP(zzewVar3);
                            long jZza3 = ((zzewVar3.zzr.zza() / 3600000) - 1) * 3600000;
                            Uri uri = Uri.parse(strZza);
                            Bundle bundle2 = new Bundle();
                            Pair pair2 = new Pair(uri.getPath(), bundle2);
                            for (String str4 : uri.getQueryParameterNames()) {
                                bundle2.putString(str4, uri.getQueryParameter(str4));
                            }
                            ((Bundle) pair2.second).putLong("_cc", jZza3);
                            Object obj = pair2.first;
                            String str5 = obj == null ? "app" : (String) obj;
                            zzfr.zzQ(zzhxVar2);
                            zzhxVar2.zzG(str5, "_cmp", (Bundle) pair2.second);
                        }
                        zzfr.zzP(zzewVar3);
                        zzewVar3.zzq.zzb(null);
                    }
                    zzfr.zzP(zzewVar3);
                    zzewVar3.zzr.zzb(0L);
                    break;
                }
                break;
        }
    }
}
