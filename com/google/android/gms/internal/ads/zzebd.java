package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzebd implements zzgdj {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzebe zzb;

    public zzebd(zzebe zzebeVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzebeVar);
        this.zzb = zzebeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:25:0x006e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x0078  */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:33:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0094  */
    /* JADX WARN: Code duplicated, block: B:37:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ab  */
    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listEmptyList;
        List listAsList;
        final ArrayList arrayList;
        Iterator it;
        byte b;
        zzbcj.zzd.zza zzaVar;
        zzebe zzebeVar = this.zzb;
        zzcva zzcvaVar = (zzcva) obj;
        if (zzebeVar.zzf()) {
            return;
        }
        Bundle bundle = zzcvaVar.zza;
        Object obj2 = bundle.get("ad_types");
        if (!(obj2 instanceof List)) {
            if (obj2 instanceof String[]) {
                listAsList = Arrays.asList((String[]) obj2);
            } else {
                listEmptyList = Collections.emptyList();
            }
            arrayList = new ArrayList();
            it = listEmptyList.iterator();
            while (it.hasNext()) {
                switch ((String) it.next()) {
                    case "banner":
                        b = 0;
                        break;
                    case "native":
                        b = 2;
                        break;
                    case "rewarded":
                        b = 3;
                        break;
                    case "interstitial":
                        b = 1;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b != 0) {
                    zzaVar = zzbcj.zzd.zza.BANNER;
                } else if (b != 1) {
                    zzaVar = zzbcj.zzd.zza.INTERSTITIAL;
                } else if (b != 2) {
                    zzaVar = zzbcj.zzd.zza.NATIVE_APP_INSTALL;
                } else if (b != 3) {
                    zzaVar = zzbcj.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                } else {
                    zzaVar = zzbcj.zzd.zza.REWARD_BASED_VIDEO_AD;
                }
                arrayList.add(zzaVar);
            }
            final zzbcj.zzaf.zzd zzdVarZzb = zzebe.zzb(zzebeVar, bundle);
            final zzbcj.zzab zzabVarZza = zzebe.zza(zzebeVar, bundle);
            final boolean z = this.zza;
            zzebeVar.zza.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebc
                @Override // com.google.android.gms.internal.ads.zzfge
                public final Object zza(Object obj3) {
                    zzebe zzebeVar2 = this.zza.zzb;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj3;
                    if (zzebeVar2.zzf()) {
                        return null;
                    }
                    zzbcj.zzaf.zzd zzdVar = zzdVarZzb;
                    zzbcj.zzab zzabVar = zzabVarZza;
                    ArrayList arrayList2 = arrayList;
                    boolean z2 = z;
                    byte[] bArrZze = zzebe.zze(zzebeVar2, z2, arrayList2, zzabVar, zzdVar);
                    zzebh.zzf(sQLiteDatabase, z2, true);
                    zzebh.zzc(sQLiteDatabase, zzebeVar2.zzf.zzd(), bArrZze);
                    return null;
                }
            });
        }
        listAsList = (List) obj2;
        ArrayList arrayList2 = new ArrayList(listAsList.size());
        for (Object obj3 : listAsList) {
            if (obj3 instanceof String) {
                arrayList2.add((String) obj3);
            }
        }
        listEmptyList = Collections.unmodifiableList(arrayList2);
        arrayList = new ArrayList();
        it = listEmptyList.iterator();
        while (it.hasNext()) {
            switch ((String) it.next()) {
                case -1396342996:
                    if (!r2.equals("banner")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    break;
                case -1052618729:
                    if (!r2.equals("native")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case -239580146:
                    if (!r2.equals("rewarded")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    break;
                case 604727084:
                    if (!r2.equals("interstitial")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b != 0) {
                zzaVar = zzbcj.zzd.zza.BANNER;
            } else if (b != 1) {
                zzaVar = zzbcj.zzd.zza.INTERSTITIAL;
            } else if (b != 2) {
                zzaVar = zzbcj.zzd.zza.NATIVE_APP_INSTALL;
            } else if (b != 3) {
                zzaVar = zzbcj.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
            } else {
                zzaVar = zzbcj.zzd.zza.REWARD_BASED_VIDEO_AD;
            }
            arrayList.add(zzaVar);
        }
        final zzbcj.zzaf.zzd zzdVarZzb2 = zzebe.zzb(zzebeVar, bundle);
        final zzbcj.zzab zzabVarZza2 = zzebe.zza(zzebeVar, bundle);
        final boolean z2 = this.zza;
        zzebeVar.zza.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebc
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj4) {
                zzebe zzebeVar2 = this.zza.zzb;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj4;
                if (zzebeVar2.zzf()) {
                    return null;
                }
                zzbcj.zzaf.zzd zzdVar = zzdVarZzb2;
                zzbcj.zzab zzabVar = zzabVarZza2;
                ArrayList arrayList3 = arrayList;
                boolean z3 = z2;
                byte[] bArrZze = zzebe.zze(zzebeVar2, z3, arrayList3, zzabVar, zzdVar);
                zzebh.zzf(sQLiteDatabase, z3, true);
                zzebh.zzc(sQLiteDatabase, zzebeVar2.zzf.zzd(), bArrZze);
                return null;
            }
        });
    }
}
