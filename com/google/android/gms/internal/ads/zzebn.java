package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzebn {
    private final zzbcc zza;
    private final Context zzb;
    private final zzeas zzc;
    private final VersionInfoParcel zzd;

    public zzebn(Context context, VersionInfoParcel versionInfoParcel, zzbcc zzbccVar, zzeas zzeasVar) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbccVar;
        this.zzc = zzeasVar;
    }

    public static Void zza(zzebn zzebnVar, boolean z, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            zzebnVar.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(zzbcj.zzaf.zza.zzx(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzgzw e) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to deserialize proto from offline signals database:");
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(e.getMessage());
                }
            }
            cursorQuery.close();
            Context context = zzebnVar.zzb;
            zzbcj.zzaf.zzc zzcVarZzi = zzbcj.zzaf.zzi();
            zzcVarZzi.zzv(context.getPackageName());
            zzcVarZzi.zzy(Build.MODEL);
            zzcVarZzi.zzA(zzebh.zza(sQLiteDatabase, 0));
            zzcVarZzi.zzh(arrayList);
            zzcVarZzi.zzE(zzebh.zza(sQLiteDatabase, 1));
            zzcVarZzi.zzx(zzebh.zza(sQLiteDatabase, 3));
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzcVarZzi.zzF(System.currentTimeMillis());
            zzcVarZzi.zzB(zzebh.zzb(sQLiteDatabase, 2));
            final zzbcj.zzaf zzafVarZzbr = zzcVarZzi.zzbr();
            int size = arrayList.size();
            long jZze = 0;
            for (int i2 = 0; i2 < size; i2++) {
                zzbcj.zzaf.zza zzaVar = (zzbcj.zzaf.zza) arrayList.get(i2);
                if (zzaVar.zzk() == zzbcj.zzq.ENUM_TRUE && zzaVar.zze() > jZze) {
                    jZze = zzaVar.zze();
                }
            }
            if (jZze != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(FirebaseAnalytics.Param.VALUE, Long.valueOf(jZze));
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
            }
            zzbcc zzbccVar = zzebnVar.zza;
            zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzebl
                @Override // com.google.android.gms.internal.ads.zzbcb
                public final void zza(zzbcj.zzt.zza zzaVar2) {
                    zzaVar2.zzW(zzafVarZzbr);
                }
            });
            VersionInfoParcel versionInfoParcel = zzebnVar.zzd;
            zzbcj.zzar.zza zzaVarZzd = zzbcj.zzar.zzd();
            zzaVarZzd.zzg(versionInfoParcel.buddyApkVersion);
            zzaVarZzd.zzi(versionInfoParcel.clientJarVersion);
            zzaVarZzd.zzh(true == versionInfoParcel.isClientJar ? 0 : 2);
            final zzbcj.zzar zzarVarZzbr = zzaVarZzd.zzbr();
            zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzebm
                @Override // com.google.android.gms.internal.ads.zzbcb
                public final void zza(zzbcj.zzt.zza zzaVar2) {
                    zzbcj.zzm.zza zzaVarZzbM = zzaVar2.zzg().zzbM();
                    zzaVarZzbM.zzw(zzarVarZzbr);
                    zzaVar2.zzK(zzaVarZzbM);
                }
            });
            zzbccVar.zzc(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED);
            zzebh.zze(sQLiteDatabase);
        }
        return null;
    }

    public final void zzb(final boolean z) {
        try {
            this.zzc.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebk
                @Override // com.google.android.gms.internal.ads.zzfge
                public final Object zza(Object obj) {
                    zzebn.zza(this.zza, z, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error in offline signals database startup: ".concat(strValueOf));
        }
    }
}
