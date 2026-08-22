package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzfjx implements zzgdj {
    final /* synthetic */ zzfhj zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzcyi zzc;
    final /* synthetic */ zzfjy zzd;

    public zzfjx(zzfjy zzfjyVar, zzfhj zzfhjVar, zzfhu zzfhuVar, zzcyi zzcyiVar) {
        this.zza = zzfhjVar;
        this.zzb = zzfhuVar;
        this.zzc = zzcyiVar;
        Objects.requireNonNull(zzfjyVar);
        this.zzd = zzfjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhj zzfhjVar = this.zza;
        if (zzfhjVar == null) {
            return;
        }
        zzfhjVar.zzg(false);
        zzfhu zzfhuVar = this.zzb;
        if (zzfhuVar == null) {
            this.zzd.zzf.zzc(zzfhjVar.zzm());
        } else {
            zzfhuVar.zza(zzfhjVar);
            zzfhuVar.zzh();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e6  */
    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        byte b;
        int i;
        long j;
        int iHashCode;
        int i2;
        zzfhj zzfhjVar = this.zza;
        com.google.android.gms.ads.internal.util.client.zzt zztVar = (com.google.android.gms.ads.internal.util.client.zzt) obj;
        if (zzfhjVar != null) {
            zzfhjVar.zzg(zztVar == com.google.android.gms.ads.internal.util.client.zzt.zza);
            zzfhu zzfhuVar = this.zzb;
            if (zzfhuVar == null) {
                this.zzd.zzf.zzc(zzfhjVar.zzm());
            } else {
                zzfhuVar.zza(zzfhjVar);
                zzfhuVar.zzh();
            }
        }
        zzcyi zzcyiVar = this.zzc;
        if (zzcyiVar != null) {
            String str = this.zzd.zzd.zzc;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("type");
                String strOptString2 = jSONObject.optString("precision");
                String strOptString3 = jSONObject.optString(FirebaseAnalytics.Param.CURRENCY);
                long jOptLong = jSONObject.optLong(FirebaseAnalytics.Param.VALUE, 0L);
                int iHashCode2 = strOptString.hashCode();
                byte b2 = -1;
                if (iHashCode2 != 66934) {
                    if (iHashCode2 != 66944) {
                        if (iHashCode2 == 1349395245 && strOptString.equals("ONE_PIXEL")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strOptString.equals("CPM")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strOptString.equals("CPC")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b != 0) {
                    if (b == 1) {
                        j = jOptLong;
                        i = 2;
                    } else if (b != 2) {
                        i = 0;
                    } else {
                        jOptLong /= 1000;
                        i = 3;
                    }
                    iHashCode = strOptString2.hashCode();
                    if (iHashCode != -2131980260) {
                        if (iHashCode != 399232571) {
                            if (iHashCode == 1271254246 && strOptString2.equals("PUBLISHER_PROVIDED")) {
                                b2 = 1;
                            }
                        } else if (strOptString2.equals("PRECISE")) {
                            b2 = 2;
                        }
                    } else if (strOptString2.equals("ESTIMATED")) {
                        b2 = 0;
                    }
                    if (b2 != 0) {
                        i2 = 1;
                    } else if (b2 != 1) {
                        i2 = 2;
                    } else if (b2 != 2) {
                        i2 = 0;
                    } else {
                        i2 = 3;
                    }
                    zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, i2, j, strOptString3));
                }
                i = 1;
                j = jOptLong;
                iHashCode = strOptString2.hashCode();
                if (iHashCode != -2131980260) {
                    if (iHashCode != 399232571) {
                        if (iHashCode == 1271254246) {
                            b2 = 1;
                        }
                    } else if (strOptString2.equals("PRECISE")) {
                        b2 = 2;
                    }
                } else if (strOptString2.equals("ESTIMATED")) {
                    b2 = 0;
                }
                if (b2 != 0) {
                    i2 = 1;
                } else if (b2 != 1) {
                    i2 = 2;
                } else if (b2 != 2) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
                zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, i2, j, strOptString3));
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "UrlPinger.pingUrl");
            }
        }
    }
}
