package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.impl.WorkerWrapper;
import com.facebook.ProfileCache;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzhz implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ Cloneable zzd;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ zzhz(WorkerWrapper.AnonymousClass1 anonymousClass1, int i, IOException iOException, byte[] bArr, Map map) {
        this.zza = anonymousClass1;
        this.zzb = i;
        this.zzc = iOException;
        this.zzd = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0064  */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArr;
        switch (this.$r8$classId) {
            case 0:
                zzfr zzfrVar = ((zzs) ((WorkerWrapper.AnonymousClass1) this.zza).this$0).zza;
                zzlb zzlbVar = zzfrVar.zzp;
                int i = this.zzb;
                IOException iOException = (IOException) this.zzc;
                zzeh zzehVar = zzfrVar.zzm;
                if (i == 200 || i == 204) {
                    if (iOException == null) {
                        zzew zzewVar = zzfrVar.zzl;
                        zzfr.zzP(zzewVar);
                        zzewVar.zzn.zza(true);
                        bArr = (byte[]) this.zzd;
                        if (bArr != null || bArr.length == 0) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzk.zza("Deferred Deep Link response empty.");
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(new String(bArr));
                                String strOptString = jSONObject.optString("deeplink", "");
                                String strOptString2 = jSONObject.optString("gclid", "");
                                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                                if (TextUtils.isEmpty(strOptString)) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzk.zza("Deferred Deep Link is empty.");
                                } else {
                                    zzfr.zzP(zzlbVar);
                                    zzfr zzfrVar2 = (zzfr) zzlbVar.mBuilder;
                                    if (!TextUtils.isEmpty(strOptString)) {
                                        Context context = zzfrVar2.zze;
                                        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0);
                                        if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("gclid", strOptString2);
                                            bundle.putString("_cis", "ddp");
                                            zzfrVar.zzt.zzG("auto", "_cmp", bundle);
                                            if (!TextUtils.isEmpty(strOptString)) {
                                                try {
                                                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                                    editorEdit.putString("deeplink", strOptString);
                                                    editorEdit.putLong("timestamp", Double.doubleToRawLongBits(dOptDouble));
                                                    if (editorEdit.commit()) {
                                                        context.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                                    }
                                                } catch (RuntimeException e) {
                                                    zzeh zzehVar2 = zzfrVar2.zzm;
                                                    zzfr.zzR(zzehVar2);
                                                    zzehVar2.zzd.zzb(e, "Failed to persist Deferred Deep Link. exception");
                                                }
                                            }
                                        }
                                    }
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzg.zzc(strOptString2, "Deferred Deep Link validation failed. gclid, deep link", strOptString);
                                }
                            } catch (JSONException e2) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zzb(e2, "Failed to parse the Deferred Deep Link response. exception");
                                return;
                            }
                        }
                    }
                } else if (i == 304) {
                    i = 304;
                    if (iOException == null) {
                        zzew zzewVar2 = zzfrVar.zzl;
                        zzfr.zzP(zzewVar2);
                        zzewVar2.zzn.zza(true);
                        bArr = (byte[]) this.zzd;
                        if (bArr != null) {
                        }
                        zzfr.zzR(zzehVar);
                        zzehVar.zzk.zza("Deferred Deep Link response empty.");
                    }
                }
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzc(Integer.valueOf(i), "Network Request for Deferred Deep Link failed. response, exception", iOException);
                break;
            default:
                ProfileCache profileCache = (ProfileCache) this.zza;
                zzjs zzjsVar = (zzjs) ((Service) profileCache.sharedPreferences);
                int i2 = this.zzb;
                if (zzjsVar.zzc(i2)) {
                    ((zzeh) this.zzc).zzl.zzb(Integer.valueOf(i2), "Local AppMeasurementService processed last upload request. StartId");
                    profileCache.zzk().zzl.zza("Completed wakeful intent.");
                    zzjsVar.zza((Intent) this.zzd);
                }
                break;
        }
    }

    public /* synthetic */ zzhz(ProfileCache profileCache, int i, zzeh zzehVar, Intent intent) {
        this.zza = profileCache;
        this.zzb = i;
        this.zzc = zzehVar;
        this.zzd = intent;
    }
}
