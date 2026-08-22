package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzesh implements zzeub {
    private final zzfcw zza;
    private final PackageInfo zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;

    public zzesh(zzfcw zzfcwVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfcwVar;
        this.zzb = packageInfo;
        this.zzc = zzgVar;
    }

    private final void zzc(Bundle bundle) {
        int i;
        zzbge zzbgeVar = this.zza.zzi;
        if (zzbgeVar == null || (i = zzbgeVar.zzi) == 0) {
            return;
        }
        bundle.putBoolean("sccg_tap", zzbgeVar.zzj);
        bundle.putInt("sccg_dir", i);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ArrayList arrayList = this.zza.zzg;
        zzcva zzcvaVar = (zzcva) obj;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        zzc(zzcvaVar.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        int i;
        String str;
        JSONArray jSONArrayOptJSONArray;
        String str2;
        String str3;
        zzfcw zzfcwVar = this.zza;
        ArrayList<String> arrayList = zzfcwVar.zzg;
        zzcva zzcvaVar = (zzcva) obj;
        if (arrayList == null) {
            return;
        }
        if (arrayList.isEmpty()) {
            zzcvaVar.zza.putInt("native_version", 0);
            return;
        }
        Bundle bundle = zzcvaVar.zza;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", zzfcwVar.zzh);
        zzbge zzbgeVar = zzfcwVar.zzi;
        if (zzbgeVar != null) {
            if (zzbgeVar.zza > 3) {
                bundle.putBoolean("enable_native_media_orientation", true);
                int i2 = zzbgeVar.zzh;
                if (i2 == 1) {
                    str3 = "any";
                } else if (i2 == 2) {
                    str3 = "landscape";
                } else if (i2 != 3) {
                    str3 = i2 != 4 ? "unknown" : "square";
                } else {
                    str3 = "portrait";
                }
                if (!"unknown".equals(str3)) {
                    bundle.putString("native_media_orientation", str3);
                }
            }
            int i3 = zzbgeVar.zzc;
            if (i3 == 0) {
                str2 = "any";
            } else if (i3 != 1) {
                str2 = i3 != 2 ? "unknown" : "landscape";
            } else {
                str2 = FKidOcdAYt.NMBEK;
            }
            if (!"unknown".equals(str2)) {
                bundle.putString("native_image_orientation", str2);
            }
            bundle.putBoolean("native_multiple_images", zzbgeVar.zzd);
            bundle.putBoolean("use_custom_mute", zzbgeVar.zzg);
            zzc(bundle);
        }
        PackageInfo packageInfo = this.zzb;
        int i4 = packageInfo != null ? packageInfo.versionCode : 0;
        com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) this.zzc;
        zzjVar.zzR();
        synchronized (zzjVar.zza) {
            i = zzjVar.zzr;
        }
        if (i4 > i) {
            zzjVar.zzq();
            zzjVar.zzt(i4);
        }
        JSONObject jSONObjectZzn = zzjVar.zzn();
        String string = null;
        if (jSONObjectZzn != null && (jSONArrayOptJSONArray = jSONObjectZzn.optJSONArray(zzfcwVar.zzf)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i5 = zzfcwVar.zzk;
        if (i5 > 1) {
            bundle.putInt("max_num_ads", i5);
        }
        zzbmp zzbmpVar = zzfcwVar.zzb;
        if (zzbmpVar != null) {
            String str4 = zzbmpVar.zzc;
            if (TextUtils.isEmpty(str4)) {
                if (zzbmpVar.zza >= 2) {
                    int i6 = zzbmpVar.zzd;
                    str = (i6 == 2 || i6 != 3) ? "l" : "p";
                } else {
                    int i7 = zzbmpVar.zzb;
                    if (i7 == 1) {
                        str = "l";
                    } else if (i7 != 2) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Instream ad video aspect ratio " + i7 + " is wrong.");
                        str = "l";
                    } else {
                        str = "p";
                    }
                }
                bundle.putString("ia_var", str);
            } else {
                bundle.putString("ad_tag", str4);
            }
            bundle.putBoolean("instr", true);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmn)).booleanValue() || zzbgeVar == null) {
            return;
        }
        com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzbgeVar.zzf;
        if (zzgcVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("startMuted", zzgcVar.zza);
            bundle2.putBoolean("clickToExpandRequested", zzgcVar.zzc);
            bundle2.putBoolean("customControlsRequested", zzgcVar.zzb);
            bundle.putBundle("video", bundle2);
        }
        bundle.putBoolean("disable_image_loading", zzbgeVar.zzb);
        bundle.putInt("preferred_ad_choices_position", zzbgeVar.zze);
    }
}
