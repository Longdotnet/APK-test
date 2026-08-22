package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzebe extends zzebf {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcvb zzd;
    private final TelephonyManager zze;
    private final zzeaw zzf;
    private zzbcj.zzq zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbcj.zzaf.zzd.CONNECTED);
        int iOrdinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbcj.zzaf.zzd zzdVar = zzbcj.zzaf.zzd.CONNECTING;
        sparseArray.put(iOrdinal, zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbcj.zzaf.zzd.DISCONNECTING);
        int iOrdinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbcj.zzaf.zzd zzdVar2 = zzbcj.zzaf.zzd.DISCONNECTED;
        sparseArray.put(iOrdinal2, zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbcj.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzdVar);
    }

    public zzebe(Context context, zzcvb zzcvbVar, zzeaw zzeawVar, zzeas zzeasVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzeasVar, zzgVar);
        this.zzc = context;
        this.zzd = zzcvbVar;
        this.zzf = zzeawVar;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    public static /* bridge */ /* synthetic */ zzbcj.zzab zza(zzebe zzebeVar, Bundle bundle) {
        zzbcj.zzab.zzb zzbVar;
        zzbcj.zzab.zza zzaVarZza = zzbcj.zzab.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzebeVar.zzg = zzbcj.zzq.ENUM_TRUE;
        } else {
            zzebeVar.zzg = zzbcj.zzq.ENUM_FALSE;
            if (i == 0) {
                zzaVarZza.zzd(zzbcj.zzab.zzc.CELL);
            } else if (i != 1) {
                zzaVarZza.zzd(zzbcj.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarZza.zzd(zzbcj.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzbcj.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzbcj.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzbcj.zzab.zzb.LTE;
                    break;
                default:
                    zzbVar = zzbcj.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarZza.zzc(zzbVar);
        }
        return zzaVarZza.zzbr();
    }

    public static byte[] zze(zzebe zzebeVar, boolean z, ArrayList arrayList, zzbcj.zzab zzabVar, zzbcj.zzaf.zzd zzdVar) {
        zzbcj.zzaf.zza.C0003zza c0003zzaZzn = zzbcj.zzaf.zza.zzn();
        c0003zzaZzn.zzn(arrayList);
        Context context = zzebeVar.zzc;
        c0003zzaZzn.zzD(zzg(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0));
        TelephonyManager telephonyManager = zzebeVar.zze;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        c0003zzaZzn.zzE(zzvVar.zzg.zzg(context, telephonyManager));
        zzeaw zzeawVar = zzebeVar.zzf;
        c0003zzaZzn.zzM(zzeawVar.zze());
        c0003zzaZzn.zzL(zzeawVar.zzb());
        c0003zzaZzn.zzG(zzeawVar.zza());
        c0003zzaZzn.zzH(zzdVar);
        c0003zzaZzn.zzJ(zzabVar);
        c0003zzaZzn.zzK(zzebeVar.zzg);
        c0003zzaZzn.zzN(zzg(z));
        c0003zzaZzn.zzP(zzeawVar.zzd());
        zzvVar.zzl.getClass();
        c0003zzaZzn.zzO(System.currentTimeMillis());
        c0003zzaZzn.zzQ(zzg(Settings.Global.getInt(context.getContentResolver(), "wifi_on", 0) != 0));
        return c0003zzaZzn.zzbr().zzaV();
    }

    private static final zzbcj.zzq zzg(boolean z) {
        return z ? zzbcj.zzq.ENUM_TRUE : zzbcj.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgdn.zzr(this.zzd.zzb(new Bundle()), new zzebd(this, z), zzcaf.zzg);
    }

    public static /* bridge */ /* synthetic */ zzbcj.zzaf.zzd zzb(zzebe zzebeVar, Bundle bundle) {
        return (zzbcj.zzaf.zzd) zzb.get(zzfdk.zza(zzfdk.zza(bundle, "device"), JrbhsraGtto.hcclVkvEwbMxczJ).getInt("active_network_state", -1), zzbcj.zzaf.zzd.UNSPECIFIED);
    }
}
