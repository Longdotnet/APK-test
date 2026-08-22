package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.android.billingclient.api.zzaz;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.measurement.zzei;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfi extends zzkh implements zzaf {
    public final ArrayMap zza;
    public final ArrayMap zzb;
    public final ArrayMap zzc;
    public final zzff zzd;
    public final Fragment.AnonymousClass7 zze;
    public final ArrayMap zzg;
    public final ArrayMap zzh;
    public final ArrayMap zzi;
    public final ArrayMap zzj;
    public final ArrayMap zzk;
    public final ArrayMap zzl;

    public zzfi(zzkt zzktVar) {
        super(zzktVar);
        this.zzg = new ArrayMap();
        this.zza = new ArrayMap();
        this.zzb = new ArrayMap();
        this.zzc = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzd = new zzff(this);
        this.zze = new Fragment.AnonymousClass7(this, 23);
    }

    public static final ArrayMap zzE(com.google.android.gms.internal.measurement.zzff zzffVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzffVar != null) {
            for (zzfj zzfjVar : zzffVar.zzn()) {
                arrayMap.put(zzfjVar.zzb(), zzfjVar.zzc());
            }
        }
        return arrayMap;
    }

    public final com.google.android.gms.internal.measurement.zzff zzA(String str, byte[] bArr) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzff.zzg();
        }
        try {
            com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((zzfe) zzen.zzl(com.google.android.gms.internal.measurement.zzff.zze(), bArr)).zzaC();
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzc(zzffVar.zzs() ? Long.valueOf(zzffVar.zzc()) : null, "Parsed config. version, gmp_app_id", zzffVar.zzr() ? zzffVar.zzh() : null);
            return zzffVar;
        } catch (zzkp e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzg.zzc(zzeh.zzn(str), "Unable to merge remote config. appId", e);
            return com.google.android.gms.internal.measurement.zzff.zzg();
        } catch (RuntimeException e2) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzg.zzc(zzeh.zzn(str), "Unable to merge remote config. appId", e2);
            return com.google.android.gms.internal.measurement.zzff.zzg();
        }
    }

    public final void zzB(String str, zzfe zzfeVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = zzfeVar.zzg().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzfb) it.next()).zzb());
        }
        for (int i = 0; i < zzfeVar.zza(); i++) {
            zzfc zzfcVar = (zzfc) zzfeVar.zzb(i).zzby();
            boolean zIsEmpty = zzfcVar.zzc().isEmpty();
            zzfr zzfrVar = (zzfr) this.mBuilder;
            if (zIsEmpty) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zza("EventConfig contained null event name");
            } else {
                String strZzc = zzfcVar.zzc();
                String strZzb = zzg.zzb(zzfcVar.zzc(), zzg.f3zza, zzg.zzc);
                if (!TextUtils.isEmpty(strZzb)) {
                    zzfcVar.zzb(strZzb);
                    zzfeVar.zzd(i, zzfcVar);
                }
                if (zzfcVar.zzf() && zzfcVar.zzd()) {
                    arrayMap.put(strZzc, Boolean.TRUE);
                }
                if (zzfcVar.zzg() && zzfcVar.zze()) {
                    arrayMap2.put(zzfcVar.zzc(), Boolean.TRUE);
                }
                if (zzfcVar.zzh()) {
                    if (zzfcVar.zza() < 2 || zzfcVar.zza() > 65535) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzg.zzc(zzfcVar.zzc(), "Invalid sampling rate. Event name, sample rate", Integer.valueOf(zzfcVar.zza()));
                    } else {
                        arrayMap3.put(zzfcVar.zzc(), Integer.valueOf(zzfcVar.zza()));
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:38:0x00da  */
    /* JADX WARN: Code duplicated, block: B:41:0x0122  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final void zzC(String str) {
        SQLiteException e;
        Cursor cursorQuery;
        com.google.firebase.auth.zzaa zzaaVar;
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        ArrayMap arrayMap3;
        ArrayMap arrayMap4;
        zzW();
        zzg();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        ArrayMap arrayMap5 = this.zzh;
        ?? r1 = 0;
        if (arrayMap5.getOrDefault(str, null) == null) {
            zzam zzamVar = this.zzf.zze;
            zzkt.zzal(zzamVar);
            zzfr zzfrVar = (zzfr) zzamVar.mBuilder;
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
            zzamVar.zzg();
            zzamVar.zzW();
            try {
                try {
                    cursorQuery = zzamVar.zzh().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            byte[] blob = cursorQuery.getBlob(0);
                            String string = cursorQuery.getString(1);
                            String string2 = zzfrVar.zzk.zzs(null, zzdu.zzao) ? cursorQuery.getString(2) : null;
                            if (cursorQuery.moveToNext()) {
                                zzeh zzehVar = zzfrVar.zzm;
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zzb(zzeh.zzn(str), "Got multiple records for app config, expected one. appId");
                            }
                            if (blob != null) {
                                zzaaVar = new com.google.firebase.auth.zzaa(string, blob, string2);
                                cursorQuery.close();
                            }
                            arrayMap = this.zzl;
                            arrayMap2 = this.zzk;
                            arrayMap3 = this.zzj;
                            arrayMap4 = this.zzg;
                            if (zzaaVar != null) {
                                zzfe zzfeVar = (zzfe) zzA(str, (byte[]) zzaaVar.zzb).zzby();
                                zzB(str, zzfeVar);
                                arrayMap4.put(str, zzE((com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaC()));
                                arrayMap5.put(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaC());
                                zzD(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaC());
                                arrayMap3.put(str, zzfeVar.zze());
                                arrayMap2.put(str, (String) zzaaVar.zza);
                                arrayMap.put(str, (String) zzaaVar.zzc);
                                return;
                            }
                            arrayMap4.put(str, null);
                            this.zzb.put(str, null);
                            this.zza.put(str, null);
                            this.zzc.put(str, null);
                            arrayMap5.put(str, null);
                            arrayMap3.put(str, null);
                            arrayMap2.put(str, null);
                            arrayMap.put(str, null);
                            this.zzi.put(str, null);
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zzc(zzeh.zzn(str), "Error querying remote config. appId", e);
                        if (cursorQuery != null) {
                        }
                        zzaaVar = null;
                        arrayMap = this.zzl;
                        arrayMap2 = this.zzk;
                        arrayMap3 = this.zzj;
                        arrayMap4 = this.zzg;
                        if (zzaaVar != null) {
                            zzfe zzfeVar2 = (zzfe) zzA(str, (byte[]) zzaaVar.zzb).zzby();
                            zzB(str, zzfeVar2);
                            arrayMap4.put(str, zzE((com.google.android.gms.internal.measurement.zzff) zzfeVar2.zzaC()));
                            arrayMap5.put(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar2.zzaC());
                            zzD(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar2.zzaC());
                            arrayMap3.put(str, zzfeVar2.zze());
                            arrayMap2.put(str, (String) zzaaVar.zza);
                            arrayMap.put(str, (String) zzaaVar.zzc);
                            return;
                        }
                        arrayMap4.put(str, null);
                        this.zzb.put(str, null);
                        this.zza.put(str, null);
                        this.zzc.put(str, null);
                        arrayMap5.put(str, null);
                        arrayMap3.put(str, null);
                        arrayMap2.put(str, null);
                        arrayMap.put(str, null);
                        this.zzi.put(str, null);
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    cursorQuery = null;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        r1.close();
                    }
                    throw th;
                }
                cursorQuery.close();
                zzaaVar = null;
                arrayMap = this.zzl;
                arrayMap2 = this.zzk;
                arrayMap3 = this.zzj;
                arrayMap4 = this.zzg;
                if (zzaaVar != null) {
                    zzfe zzfeVar3 = (zzfe) zzA(str, (byte[]) zzaaVar.zzb).zzby();
                    zzB(str, zzfeVar3);
                    arrayMap4.put(str, zzE((com.google.android.gms.internal.measurement.zzff) zzfeVar3.zzaC()));
                    arrayMap5.put(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar3.zzaC());
                    zzD(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar3.zzaC());
                    arrayMap3.put(str, zzfeVar3.zze());
                    arrayMap2.put(str, (String) zzaaVar.zza);
                    arrayMap.put(str, (String) zzaaVar.zzc);
                    return;
                }
                arrayMap4.put(str, null);
                this.zzb.put(str, null);
                this.zza.put(str, null);
                this.zzc.put(str, null);
                arrayMap5.put(str, null);
                arrayMap3.put(str, null);
                arrayMap2.put(str, null);
                arrayMap.put(str, null);
                this.zzi.put(str, null);
            } catch (Throwable th2) {
                th = th2;
                r1 = zzamVar;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        }
    }

    public final void zzD(String str, com.google.android.gms.internal.measurement.zzff zzffVar) {
        int iZza = zzffVar.zza();
        zzff zzffVar2 = this.zzd;
        if (iZza == 0) {
            zzffVar2.remove(str);
            return;
        }
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzeh zzehVar = zzfrVar.zzm;
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzb(Integer.valueOf(zzffVar.zza()), "EES programs found");
        zzgt zzgtVar = (zzgt) zzffVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
            zzcVar.zzd("internal.remoteConfig", new zzfb(this, str, 1));
            zzcVar.zzd("internal.appMetadata", new zzfb(this, str, 2));
            zzcVar.zzd("internal.logger", new zzaz(this, 7));
            zzcVar.zzc(zzgtVar);
            zzffVar2.put(str, zzcVar);
            zzfr.zzR(zzehVar2);
            zzehVar2.zzl.zzc(str, "EES program loaded for appId, activities", Integer.valueOf(zzgtVar.zza().zza()));
            for (com.google.android.gms.internal.measurement.zzgr zzgrVar : zzgtVar.zza().zzd()) {
                zzfr.zzR(zzehVar2);
                zzehVar2.zzl.zzb(zzgrVar.zzb(), "EES program activity");
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(str, "Failed to load EES program. appId");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    public final String zza(String str, String str2) {
        zzg();
        zzC(str);
        Map map = (Map) this.zzg.getOrDefault(str, null);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }

    public final int zzc(String str, String str2) {
        Integer num;
        zzg();
        zzC(str);
        Map map = (Map) this.zzi.getOrDefault(str, null);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final com.google.android.gms.internal.measurement.zzff zze(String str) {
        zzW();
        zzg();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzC(str);
        return (com.google.android.gms.internal.measurement.zzff) this.zzh.getOrDefault(str, null);
    }

    public final String zzi(String str) {
        zzg();
        zzC(str);
        return (String) this.zzj.getOrDefault(str, null);
    }

    public final boolean zzn(String str) {
        zzg();
        com.google.android.gms.internal.measurement.zzff zzffVarZze = zze(str);
        if (zzffVarZze == null) {
            return false;
        }
        return zzffVarZze.zzq();
    }

    public final boolean zzq(String str, String str2) {
        Boolean bool;
        zzg();
        zzC(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.getOrDefault(str, null);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean zzr(String str, String str2) {
        Boolean bool;
        zzg();
        zzC(str);
        if ("1".equals(zza(str, "measurement.upload.blacklist_internal")) && zzlb.zzah(str2)) {
            return true;
        }
        if ("1".equals(zza(str, "measurement.upload.blacklist_public")) && zzlb.zzai(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.getOrDefault(str, null);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void zzt(String str, String str2, String str3, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        zzfr zzfrVar;
        byte[] bArrZzbu;
        zzfe zzfeVar;
        boolean z;
        zzW();
        zzg();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzfe zzfeVar2 = (zzfe) zzA(str, bArr).zzby();
        zzB(str, zzfeVar2);
        zzD(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar2.zzaC());
        com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) zzfeVar2.zzaC();
        ArrayMap arrayMap = this.zzh;
        arrayMap.put(str, zzffVar);
        this.zzj.put(str, zzfeVar2.zze());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzg.put(str, zzE((com.google.android.gms.internal.measurement.zzff) zzfeVar2.zzaC()));
        zzkt zzktVar = this.zzf;
        zzam zzamVar = zzktVar.zze;
        zzkt.zzal(zzamVar);
        ArrayList<zzei> arrayList = new ArrayList(zzfeVar2.zzf());
        String str4 = "app_id=? and audience_id=?";
        int i = 0;
        while (i < arrayList.size()) {
            com.google.android.gms.internal.measurement.zzeh zzehVar = (com.google.android.gms.internal.measurement.zzeh) ((zzei) arrayList.get(i)).zzby();
            if (zzehVar.zza() != 0) {
                int i2 = 0;
                while (i2 < zzehVar.zza()) {
                    com.google.android.gms.internal.measurement.zzej zzejVar = (com.google.android.gms.internal.measurement.zzej) zzehVar.zze(i2).zzby();
                    com.google.android.gms.internal.measurement.zzej zzejVar2 = (com.google.android.gms.internal.measurement.zzej) zzejVar.clone();
                    zzkt zzktVar2 = zzktVar;
                    String strZzb = zzg.zzb(zzejVar.zze(), zzg.f3zza, zzg.zzc);
                    if (strZzb != null) {
                        zzejVar2.zzb(strZzb);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < zzejVar.zza()) {
                        com.google.android.gms.internal.measurement.zzem zzemVarZzd = zzejVar.zzd(i3);
                        com.google.android.gms.internal.measurement.zzej zzejVar3 = zzejVar;
                        zzfe zzfeVar3 = zzfeVar2;
                        String str5 = str4;
                        String strZzb2 = zzg.zzb(zzemVarZzd.zze(), zzg.zza$1, zzg.zzb$1);
                        if (strZzb2 != null) {
                            zzel zzelVar = (zzel) zzemVarZzd.zzby();
                            zzelVar.zza(strZzb2);
                            zzejVar2.zzc(i3, (com.google.android.gms.internal.measurement.zzem) zzelVar.zzaC());
                            z = true;
                        }
                        i3++;
                        zzejVar = zzejVar3;
                        zzfeVar2 = zzfeVar3;
                        str4 = str5;
                    }
                    zzfe zzfeVar4 = zzfeVar2;
                    String str6 = str4;
                    if (z) {
                        zzehVar.zzc(i2, zzejVar2);
                        arrayList.set(i, (zzei) zzehVar.zzaC());
                    }
                    i2++;
                    zzktVar = zzktVar2;
                    zzfeVar2 = zzfeVar4;
                    str4 = str6;
                }
                zzfeVar = zzfeVar2;
            } else {
                zzfeVar = zzfeVar2;
            }
            zzkt zzktVar3 = zzktVar;
            String str7 = str4;
            if (zzehVar.zzb() != 0) {
                for (int i4 = 0; i4 < zzehVar.zzb(); i4++) {
                    zzet zzetVarZzf = zzehVar.zzf(i4);
                    String strZzb3 = zzg.zzb(zzetVarZzf.zze(), zzg.zza$2, zzg.zzb$2);
                    if (strZzb3 != null) {
                        com.google.android.gms.internal.measurement.zzes zzesVar = (com.google.android.gms.internal.measurement.zzes) zzetVarZzf.zzby();
                        zzesVar.zza(strZzb3);
                        zzehVar.zzd(i4, zzesVar);
                        arrayList.set(i, (zzei) zzehVar.zzaC());
                    }
                }
            }
            i++;
            arrayMap = arrayMap;
            zzktVar = zzktVar3;
            zzfeVar2 = zzfeVar;
            str4 = str7;
        }
        zzfe zzfeVar5 = zzfeVar2;
        ArrayMap arrayMap2 = arrayMap;
        zzkt zzktVar4 = zzktVar;
        String str8 = str4;
        zzamVar.zzW();
        zzamVar.zzg();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        SQLiteDatabase sQLiteDatabaseZzh = zzamVar.zzh();
        sQLiteDatabaseZzh.beginTransaction();
        try {
            zzamVar.zzW();
            zzamVar.zzg();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseZzh2 = zzamVar.zzh();
            sQLiteDatabaseZzh2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseZzh2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = arrayList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                zzfrVar = (zzfr) zzamVar.mBuilder;
                if (!zHasNext) {
                    break;
                }
                zzei zzeiVar = (zzei) it.next();
                zzamVar.zzW();
                zzamVar.zzg();
                com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
                com.google.android.gms.common.internal.zzah.checkNotNull(zzeiVar);
                if (zzeiVar.zzk()) {
                    int iZza = zzeiVar.zza();
                    Iterator it2 = zzeiVar.zzg().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((zzek) it2.next()).zzp()) {
                                zzeh zzehVar2 = zzfrVar.zzm;
                                zzfr.zzR(zzehVar2);
                                zzehVar2.zzg.zzc(zzeh.zzn(str), "Event filter with no ID. Audience definition ignored. appId, audienceId", Integer.valueOf(iZza));
                                break;
                            }
                        } else {
                            Iterator it3 = zzeiVar.zzh().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!((zzet) it3.next()).zzj()) {
                                        zzeh zzehVar3 = zzfrVar.zzm;
                                        zzfr.zzR(zzehVar3);
                                        zzehVar3.zzg.zzc(zzeh.zzn(str), "Property filter with no ID. Audience definition ignored. appId, audienceId", Integer.valueOf(iZza));
                                        break;
                                    }
                                } else {
                                    Iterator it4 = zzeiVar.zzg().iterator();
                                    while (true) {
                                        boolean zHasNext2 = it4.hasNext();
                                        String str9 = sgtsHsWT.hembQQTl;
                                        Iterator it5 = it;
                                        String str10 = "app_id";
                                        try {
                                            if (!zHasNext2) {
                                                sQLiteDatabase = sQLiteDatabaseZzh;
                                                Iterator it6 = zzeiVar.zzh().iterator();
                                                while (true) {
                                                    if (it6.hasNext()) {
                                                        zzet zzetVar = (zzet) it6.next();
                                                        zzamVar.zzW();
                                                        zzamVar.zzg();
                                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
                                                        com.google.android.gms.common.internal.zzah.checkNotNull(zzetVar);
                                                        if (zzetVar.zze().isEmpty()) {
                                                            zzeh zzehVar4 = zzfrVar.zzm;
                                                            zzfr.zzR(zzehVar4);
                                                            zzehVar4.zzg.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzeh.zzn(str), Integer.valueOf(iZza), String.valueOf(zzetVar.zzj() ? Integer.valueOf(zzetVar.zza()) : null));
                                                        } else {
                                                            byte[] bArrZzbu2 = zzetVar.zzbu();
                                                            ContentValues contentValues = new ContentValues();
                                                            contentValues.put(str10, str);
                                                            Iterator it7 = it6;
                                                            contentValues.put("audience_id", Integer.valueOf(iZza));
                                                            contentValues.put("filter_id", zzetVar.zzj() ? Integer.valueOf(zzetVar.zza()) : null);
                                                            String str11 = str10;
                                                            contentValues.put("property_name", zzetVar.zze());
                                                            contentValues.put("session_scoped", zzetVar.zzk() ? Boolean.valueOf(zzetVar.zzi()) : null);
                                                            contentValues.put(str9, bArrZzbu2);
                                                            try {
                                                                if (zzamVar.zzh().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                                                                    zzeh zzehVar5 = zzfrVar.zzm;
                                                                    zzfr.zzR(zzehVar5);
                                                                    zzehVar5.zzd.zzb(zzeh.zzn(str), "Failed to insert property filter (got -1). appId");
                                                                } else {
                                                                    it6 = it7;
                                                                    str10 = str11;
                                                                }
                                                            } catch (SQLiteException e) {
                                                                zzeh zzehVar6 = zzfrVar.zzm;
                                                                zzfr.zzR(zzehVar6);
                                                                zzehVar6.zzd.zzc(zzeh.zzn(str), "Error storing property filter. appId", e);
                                                            }
                                                        }
                                                    }
                                                    it = it5;
                                                    sQLiteDatabaseZzh = sQLiteDatabase;
                                                    break;
                                                }
                                            }
                                            zzek zzekVar = (zzek) it4.next();
                                            zzamVar.zzW();
                                            zzamVar.zzg();
                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
                                            com.google.android.gms.common.internal.zzah.checkNotNull(zzekVar);
                                            if (!zzekVar.zzg().isEmpty()) {
                                                Iterator it8 = it4;
                                                byte[] bArrZzbu3 = zzekVar.zzbu();
                                                sQLiteDatabase = sQLiteDatabaseZzh;
                                                ContentValues contentValues2 = new ContentValues();
                                                contentValues2.put("app_id", str);
                                                contentValues2.put("audience_id", Integer.valueOf(iZza));
                                                contentValues2.put("filter_id", zzekVar.zzp() ? Integer.valueOf(zzekVar.zzb()) : null);
                                                contentValues2.put("event_name", zzekVar.zzg());
                                                contentValues2.put("session_scoped", zzekVar.zzq() ? Boolean.valueOf(zzekVar.zzn()) : null);
                                                contentValues2.put(str9, bArrZzbu3);
                                                try {
                                                    if (zzamVar.zzh().insertWithOnConflict("event_filters", null, contentValues2, 5) == -1) {
                                                        zzeh zzehVar7 = zzfrVar.zzm;
                                                        zzfr.zzR(zzehVar7);
                                                        zzehVar7.zzd.zzb(zzeh.zzn(str), "Failed to insert event filter (got -1). appId");
                                                    }
                                                    it = it5;
                                                    it4 = it8;
                                                    sQLiteDatabaseZzh = sQLiteDatabase;
                                                } catch (SQLiteException e2) {
                                                    zzeh zzehVar8 = zzfrVar.zzm;
                                                    zzfr.zzR(zzehVar8);
                                                    zzehVar8.zzd.zzc(zzeh.zzn(str), "Error storing event filter. appId", e2);
                                                    zzamVar.zzW();
                                                    zzamVar.zzg();
                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
                                                    SQLiteDatabase sQLiteDatabaseZzh3 = zzamVar.zzh();
                                                    String str12 = str8;
                                                    sQLiteDatabaseZzh3.delete("property_filters", str12, new String[]{str, String.valueOf(iZza)});
                                                    sQLiteDatabaseZzh3.delete("event_filters", str12, new String[]{str, String.valueOf(iZza)});
                                                    str8 = str12;
                                                    it = it5;
                                                    sQLiteDatabaseZzh = sQLiteDatabase;
                                                    break;
                                                }
                                            } else {
                                                zzeh zzehVar9 = zzfrVar.zzm;
                                                zzfr.zzR(zzehVar9);
                                                zzehVar9.zzg.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzeh.zzn(str), Integer.valueOf(iZza), String.valueOf(zzekVar.zzp() ? Integer.valueOf(zzekVar.zzb()) : null));
                                                sQLiteDatabase = sQLiteDatabaseZzh;
                                            }
                                            zzamVar.zzW();
                                            zzamVar.zzg();
                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
                                            SQLiteDatabase sQLiteDatabaseZzh4 = zzamVar.zzh();
                                            String str13 = str8;
                                            sQLiteDatabaseZzh4.delete("property_filters", str13, new String[]{str, String.valueOf(iZza)});
                                            sQLiteDatabaseZzh4.delete("event_filters", str13, new String[]{str, String.valueOf(iZza)});
                                            str8 = str13;
                                            it = it5;
                                            sQLiteDatabaseZzh = sQLiteDatabase;
                                            break;
                                            break;
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    zzeh zzehVar10 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar10);
                    zzehVar10.zzg.zzb(zzeh.zzn(str), "Audience with no ID. appId");
                }
                th = th;
                sQLiteDatabase.endTransaction();
                throw th;
            }
            sQLiteDatabase = sQLiteDatabaseZzh;
            ArrayList arrayList2 = new ArrayList();
            for (zzei zzeiVar2 : arrayList) {
                arrayList2.add(zzeiVar2.zzk() ? Integer.valueOf(zzeiVar2.zza()) : null);
            }
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
            zzamVar.zzW();
            zzamVar.zzg();
            SQLiteDatabase sQLiteDatabaseZzh5 = zzamVar.zzh();
            try {
                long jZzZ = zzamVar.zzZ("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int iMax = Math.max(0, Math.min(2000, zzfrVar.zzk.zze(str, zzdu.zzE)));
                if (jZzZ > iMax) {
                    ArrayList arrayList3 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= arrayList2.size()) {
                            String strJoin = TextUtils.join(oKjScaD.NCFjFKdKfTshE, arrayList3);
                            StringBuilder sb = new StringBuilder();
                            sb.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
                            sb.append("(" + strJoin + ")");
                            sb.append(" order by rowid desc limit -1 offset ?)");
                            sQLiteDatabaseZzh5.delete("audience_filter_values", sb.toString(), new String[]{str, Integer.toString(iMax)});
                            break;
                        }
                        Integer num = (Integer) arrayList2.get(i5);
                        if (num == null) {
                            break;
                        }
                        arrayList3.add(Integer.toString(num.intValue()));
                        i5++;
                    }
                }
            } catch (SQLiteException e3) {
                zzeh zzehVar11 = zzfrVar.zzm;
                zzfr.zzR(zzehVar11);
                zzehVar11.zzd.zzc(zzeh.zzn(str), "Database error querying filters. appId", e3);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            try {
                zzfeVar5.zzc();
                bArrZzbu = ((com.google.android.gms.internal.measurement.zzff) zzfeVar5.zzaC()).zzbu();
            } catch (RuntimeException e4) {
                zzeh zzehVar12 = ((zzfr) this.mBuilder).zzm;
                zzfr.zzR(zzehVar12);
                zzehVar12.zzg.zzc(zzeh.zzn(str), "Unable to serialize reduced-size config. Storing full config instead. appId", e4);
                bArrZzbu = bArr;
            }
            zzam zzamVar2 = zzktVar4.zze;
            zzkt.zzal(zzamVar2);
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
            zzamVar2.zzg();
            zzamVar2.zzW();
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("remote_config", bArrZzbu);
            contentValues3.put("config_last_modified_time", str2);
            zzfr zzfrVar2 = (zzfr) zzamVar2.mBuilder;
            zzag zzagVar = zzfrVar2.zzk;
            zzeh zzehVar13 = zzfrVar2.zzm;
            if (zzagVar.zzs(null, zzdu.zzao)) {
                contentValues3.put("e_tag", str3);
            }
            try {
                if (zzamVar2.zzh().update("apps", contentValues3, "app_id = ?", new String[]{str}) == 0) {
                    zzfr.zzR(zzehVar13);
                    zzehVar13.zzd.zzb(zzeh.zzn(str), "Failed to update remote config (got 0). appId");
                }
            } catch (SQLiteException e5) {
                zzfr.zzR(zzehVar13);
                zzehVar13.zzd.zzc(zzeh.zzn(str), "Error storing remote config. appId", e5);
            }
            arrayMap2.put(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar5.zzaC());
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = sQLiteDatabaseZzh;
        }
    }
}
