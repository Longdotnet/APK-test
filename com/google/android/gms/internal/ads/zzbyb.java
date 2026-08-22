package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import java.util.Objects;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyb implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private String zzd = "-1";
    private int zze = -1;

    public zzbyb(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzgVar;
        this.zza = context;
    }

    private final void zzb() {
        ((com.google.android.gms.ads.internal.util.zzj) this.zzc).zzD(true);
        StringsKt__IndentKt.zzc(this.zza);
    }

    private final void zzc(String str, int i) {
        Context context;
        zzbcv zzbcvVar = zzbde.zzaN;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        boolean z = true;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? !(str.isEmpty() || str.charAt(0) != '1') : !(i == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1")))) {
            z = false;
        }
        ((com.google.android.gms.ads.internal.util.zzj) this.zzc).zzD(z);
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzgv)).booleanValue() && z && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    public final void zza() {
        SharedPreferences sharedPreferences = this.zzb;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(sharedPreferences, "gad_has_consent_for_cookies");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaP)).booleanValue()) {
            onSharedPreferenceChanged(sharedPreferences, "IABTCF_TCString");
        } else {
            onSharedPreferenceChanged(sharedPreferences, "IABTCF_PurposeConsents");
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008e  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        byte b;
        try {
            zzbcv zzbcvVar = zzbde.zzaP;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
            String str2 = nYVxXTZQ.hEbFPF;
            if (zBooleanValue) {
                if (Objects.equals(str, str2)) {
                    int i = sharedPreferences.getInt(str2, -1);
                    com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzc;
                    com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) zzgVar;
                    zzjVar.zzR();
                    if (i != zzjVar.zzm) {
                        zzb();
                    }
                    ((com.google.android.gms.ads.internal.util.zzj) zzgVar).zzA(i);
                    return;
                }
                if (Objects.equals(str, "IABTCF_TCString")) {
                    String string = sharedPreferences.getString(str, "-1");
                    com.google.android.gms.ads.internal.util.zzg zzgVar2 = this.zzc;
                    com.google.android.gms.ads.internal.util.zzj zzjVar2 = (com.google.android.gms.ads.internal.util.zzj) zzgVar2;
                    zzjVar2.zzR();
                    if (!Objects.equals(string, zzjVar2.zzl)) {
                        zzb();
                    }
                    ((com.google.android.gms.ads.internal.util.zzj) zzgVar2).zzJ(string);
                    return;
                }
                return;
            }
            String string2 = sharedPreferences.getString("IABTCF_PurposeConsents", "-1");
            int i2 = sharedPreferences.getInt(str2, -1);
            String strValueOf = String.valueOf(str);
            int iHashCode = strValueOf.hashCode();
            if (iHashCode != -2004976699) {
                if (iHashCode == -527267622 && strValueOf.equals(str2)) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (strValueOf.equals("IABTCF_PurposeConsents")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                if (string2.equals("-1") || this.zzd.equals(string2)) {
                    return;
                }
                this.zzd = string2;
                zzc(string2, i2);
                return;
            }
            if (b != 1) {
                return;
            }
            if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzaN)).booleanValue() || i2 == -1 || this.zze == i2) {
                return;
            }
            this.zze = i2;
            zzc(string2, i2);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "AdMobPlusIdlessListener.onSharedPreferenceChanged");
            com.google.android.gms.ads.internal.util.zze.zzb("onSharedPreferenceChanged, errorMessage = ", th);
        }
    }
}
