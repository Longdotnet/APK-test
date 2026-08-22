package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfju {
    private final zzehb zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfco zzf;
    private final zzfcp zzg;
    private final Clock zzh;
    private final zzavu zzi;

    public zzfju(zzehb zzehbVar, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzfco zzfcoVar, zzfcp zzfcpVar, Clock clock, zzavu zzavuVar) {
        this.zza = zzehbVar;
        this.zzb = versionInfoParcel.afmaVersion;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfcoVar;
        this.zzg = zzfcpVar;
        this.zzh = clock;
        this.zzi = zzavuVar;
    }

    public static String zzc(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public static String zzg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.google.android.gms.ads.internal.util.client.zzl.zzk() ? "fakeForAdDebugLog" : str;
    }

    public final List zzd(zzfcn zzfcnVar, zzfca zzfcaVar, List list) {
        return zze(zzfcnVar, zzfcaVar, false, "", "", list, null);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0110  */
    public final List zze(zzfcn zzfcnVar, zzfca zzfcaVar, boolean z, String str, String str2, List list, zzcuu zzcuuVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            String strZzc = zzc(zzc(zzc((String) it.next(), "@gw_adlocid@", zzfcnVar.zza.zza.zzf), "@gw_adnetrefresh@", true != z ? "0" : "1"), "@gw_sdkver@", this.zzb);
            if (zzfcaVar != null) {
                String strZzc2 = zzc(zzc(zzc(strZzc, "@gw_qdata@", zzfcaVar.zzy), "@gw_adnetid@", zzfcaVar.zzx), "@gw_allocid@", zzfcaVar.zzw);
                Context context = this.zze;
                strZzc = zzbyq.zzc(strZzc2, context, zzfcaVar.zzW, zzfcaVar.zzaw);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznK)).booleanValue() && zzfcaVar.zze == 4) {
                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    strZzc = zzc(strZzc, "@gw_aps@", true != com.google.android.gms.ads.internal.util.zzs.zzH(context) ? "0" : "1");
                }
            }
            zzehb zzehbVar = this.zza;
            String strZzc3 = zzc(zzc(zzc(zzc(strZzc, "@gw_adnetstatus@", zzehbVar.zzg()), "@gw_ttr@", Long.toString(zzehbVar.zza(), 10)), eoBKjVuj.TxHLvq, this.zzc), "@gw_sessid@", this.zzd);
            zzbcv zzbcvVar = zzbde.zznR;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                String str3 = kBfGXgdfpo.OdsfztTmTtmM;
                strZzc3 = (zzcuuVar == null || zzcuuVar.zza() <= 0) ? zzc(strZzc3, str3, "") : zzc(strZzc3, str3, Long.toString(zzcuuVar.zza(), 10));
            }
            boolean z3 = false;
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdO)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            boolean z4 = !zIsEmpty;
            if (z3) {
                z2 = z4;
            } else {
                if (!zIsEmpty) {
                }
                arrayList.add(strZzc3);
            }
            if (this.zzi.zzf(Uri.parse(strZzc3))) {
                Uri.Builder builderBuildUpon = Uri.parse(strZzc3).buildUpon();
                if (z3) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("attok", str2);
                }
                strZzc3 = builderBuildUpon.build().toString();
            }
            arrayList.add(strZzc3);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006b A[LOOP:0: B:13:0x0065->B:15:0x006b, LOOP_END] */
    public final List zzf(zzfca zzfcaVar, List list, zzbwc zzbwcVar) {
        zzfco zzfcoVar;
        zzfvn zzfvnVarZzd;
        String str;
        String str2;
        Iterator it;
        ArrayList arrayList = new ArrayList();
        ((DefaultClock) this.zzh).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            String strZzc = zzbwcVar.zzc();
            String string = Integer.toString(zzbwcVar.zzb());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdP)).booleanValue()) {
                zzfcp zzfcpVar = this.zzg;
                if (zzfcpVar == null) {
                    zzfvnVarZzd = zzfvn.zzc();
                } else {
                    zzfcoVar = zzfcpVar.zza;
                }
                str = (String) zzfvnVarZzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjs
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return zzfju.zzg(((zzfco) obj).zza);
                    }
                }).zzb("");
                str2 = (String) zzfvnVarZzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjt
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return zzfju.zzg(((zzfco) obj).zzb);
                    }
                }).zzb("");
                it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(zzbyq.zzc(zzc(zzc(zzc(zzc(zzc(zzc((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfcaVar.zzW, zzfcaVar.zzaw));
                }
                return arrayList;
            }
            zzfcoVar = this.zzf;
            zzfvnVarZzd = zzfvn.zzd(zzfcoVar);
            str = (String) zzfvnVarZzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjs
                @Override // com.google.android.gms.internal.ads.zzfve
                public final Object apply(Object obj) {
                    return zzfju.zzg(((zzfco) obj).zza);
                }
            }).zzb("");
            str2 = (String) zzfvnVarZzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjt
                @Override // com.google.android.gms.internal.ads.zzfve
                public final Object apply(Object obj) {
                    return zzfju.zzg(((zzfco) obj).zzb);
                }
            }).zzb("");
            it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzbyq.zzc(zzc(zzc(zzc(zzc(zzc(zzc((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfcaVar.zzW, zzfcaVar.zzaw));
            }
            return arrayList;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
