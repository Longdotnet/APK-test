package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.gson.yWTz.kBfGXgdfpo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzae implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzau zza;

    public /* synthetic */ zzae(zzau zzauVar, int i) {
        this.$r8$classId = i;
        this.zza = zzauVar;
    }

    private final void run$com$google$android$gms$ads$internal$util$zzag() {
        zzau zzauVar = this.zza;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzay zzayVar = zzvVar.zzp;
        Context context = zzauVar.zza;
        String str = zzauVar.zzd;
        String str2 = zzauVar.zze;
        zzayVar.getClass();
        zzbcv zzbcvVar = zzbde.zzfi;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        String strZzo = zzay.zzo(context, zzayVar.zzp(context, (String) zzbdVar.zzd.zzb(zzbcvVar), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strZzo)) {
            int i = zze.$r8$clinit;
            zzo.zze("Not linked for in app preview.");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(strZzo.trim());
                String strOptString = jSONObject.optString("gct");
                zzayVar.zza = jSONObject.optString(DaWYVMJ.xwbXW);
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjE)).booleanValue()) {
                    boolean z = "0".equals(zzayVar.zza) || "2".equals(zzayVar.zza);
                    zzayVar.zzf(z);
                    ((zzj) zzvVar.zzi.zzi()).zzw(!z ? "" : str);
                }
                synchronized (zzayVar.zzb) {
                    zzayVar.zzd = strOptString;
                }
                if ("2".equals(zzayVar.zza)) {
                    int i2 = zze.$r8$clinit;
                    zzo.zze("Creative is not pushed for this device.");
                    zzayVar.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
                    return;
                } else if ("1".equals(zzayVar.zza)) {
                    int i3 = zze.$r8$clinit;
                    zzo.zze("The app is not linked for creative preview.");
                    zzayVar.zzd(context, str, str2);
                    return;
                } else {
                    if ("0".equals(zzayVar.zza)) {
                        int i4 = zze.$r8$clinit;
                        zzo.zze("Device is linked for in app preview.");
                        zzayVar.zzi(context, "The device is successfully linked for creative preview.", false, true);
                        return;
                    }
                    return;
                }
            } catch (JSONException e) {
                int i5 = zze.$r8$clinit;
                zzo.zzk("Fail to get in app preview response json.", e);
            }
        }
        zzayVar.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzau zzauVar = this.zza;
                zzauVar.zzs(zzauVar.zza);
                return;
            case 1:
                zzau zzauVar2 = this.zza;
                zzauVar2.zzg = 4;
                zzauVar2.zzr();
                return;
            case 2:
                run$com$google$android$gms$ads$internal$util$zzag();
                return;
            case 3:
                com.google.android.gms.ads.internal.zzv.zza.zzp.zzc(this.zza.zza);
                return;
            case 4:
                zzau zzauVar3 = this.zza;
                zzauVar3.zzs(zzauVar3.zza);
                return;
            case 5:
                com.google.android.gms.ads.internal.zzv.zza.zzp.zzc(this.zza.zza);
                return;
            default:
                zzau zzauVar4 = this.zza;
                zzay zzayVar = com.google.android.gms.ads.internal.zzv.zza.zzp;
                String str = zzauVar4.zzd;
                String str2 = zzauVar4.zze;
                String str3 = zzauVar4.zzf;
                boolean zZzm = zzayVar.zzm();
                Context context = zzauVar4.zza;
                boolean zZzj = zzayVar.zzj(context, str, str2);
                synchronized (zzayVar.zzb) {
                    zzayVar.zze = zZzj;
                    break;
                }
                if (!zzayVar.zzm()) {
                    zzayVar.zzd(context, str, str2);
                    return;
                }
                if (!zZzm && !TextUtils.isEmpty(str3)) {
                    zzayVar.zze(context, str2, str3, str);
                }
                int i = zze.$r8$clinit;
                zzo.zze("Device is linked for debug signals.");
                zzayVar.zzi(context, kBfGXgdfpo.qhxxCXBMtNz, false, true);
                return;
        }
    }
}
