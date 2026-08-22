package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.facebook.login.vu.dLDI;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzam extends zzkh {
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] zzb = {FirebaseAnalytics.Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", DYYbQc.GcrOdGOtxpUxD, "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", YcVWhnLsj.BzaObEN, "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", gZrKCJ.CbxF, "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final zzal zzj;
    public final HeadersReader zzk;

    public zzam(zzkt zzktVar) {
        super(zzktVar);
        this.zzk = new HeadersReader(((zzfr) this.mBuilder).zzr);
        ((zzfr) this.mBuilder).getClass();
        this.zzj = new zzal(this, ((zzfr) this.mBuilder).zze);
    }

    public static final void zzV(ContentValues contentValues, Object obj) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(FirebaseAnalytics.Param.VALUE);
        com.google.android.gms.common.internal.zzah.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(FirebaseAnalytics.Param.VALUE, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(FirebaseAnalytics.Param.VALUE, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(FirebaseAnalytics.Param.VALUE, (Double) obj);
        }
    }

    public final void zzA(String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzfr zzfrVar = (zzfr) this.mBuilder;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzd("Error deleting user property. appId", zzeh.zzn(str), zzfrVar.zzq.zzf(str2), e);
        }
    }

    public final void zzC() {
        zzW();
        zzh().setTransactionSuccessful();
    }

    public final boolean zzK(zzac zzacVar) {
        zzg();
        zzW();
        String str = zzacVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        zzky zzkyVarZzp = zzp(str, zzacVar.zzc.zzb);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zzkyVarZzp == null) {
            long jZzZ = zzZ("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            zzfrVar.getClass();
            if (jZzZ >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzacVar.zzb);
        contentValues.put("name", zzacVar.zzc.zzb);
        Object objZza = zzacVar.zzc.zza();
        com.google.android.gms.common.internal.zzah.checkNotNull(objZza);
        zzV(contentValues, objZza);
        contentValues.put("active", Boolean.valueOf(zzacVar.zze));
        contentValues.put("trigger_event_name", zzacVar.zzf);
        contentValues.put("trigger_timeout", Long.valueOf(zzacVar.zzh));
        zzlb zzlbVar = zzfrVar.zzp;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzP(zzlbVar);
        contentValues.put("timed_out_event", zzlb.zzan(zzacVar.zzg));
        contentValues.put("creation_timestamp", Long.valueOf(zzacVar.zzd));
        zzlb zzlbVar2 = zzfrVar.zzp;
        zzfr.zzP(zzlbVar2);
        contentValues.put("triggered_event", zzlb.zzan(zzacVar.zzi));
        contentValues.put("triggered_timestamp", Long.valueOf(zzacVar.zzc.zzc));
        contentValues.put("time_to_live", Long.valueOf(zzacVar.zzj));
        zzfr.zzP(zzlbVar2);
        contentValues.put("expired_event", zzlb.zzan(zzacVar.zzk));
        try {
            if (zzh().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(zzeh.zzn(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzc(zzeh.zzn(str), "Error storing conditional user property", e);
            return true;
        }
    }

    public final boolean zzL(zzky zzkyVar) {
        zzg();
        zzW();
        String str = zzkyVar.zza;
        String str2 = zzkyVar.zzc;
        zzky zzkyVarZzp = zzp(str, str2);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        String str3 = zzkyVar.zzb;
        if (zzkyVarZzp == null) {
            if (zzlb.zzai(str2)) {
                if (zzZ("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= Math.max(Math.min(zzfrVar.zzk.zze(str, zzdu.zzF), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jZzZ = zzZ("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, str3});
                zzfrVar.getClass();
                if (jZzZ >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, str3);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzkyVar.zzd));
        zzV(contentValues, zzkyVar.zze);
        try {
            if (zzh().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(zzeh.zzn(str), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), "Error storing user property. appId", e);
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:83:0x01e7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public final void zzU(long j, long j2, zzeu zzeuVar) throws Throwable {
        String string;
        String str;
        String[] strArr;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        ?? r4 = "select app_id, metadata_fingerprint from raw_events where ";
        zzg();
        zzW();
        ?? r5 = 0;
        String string2 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZzh = zzh();
                try {
                    if (TextUtils.isEmpty(null)) {
                        Cursor cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select app_id, metadata_fingerprint from raw_events where " + (j2 != -1 ? "rowid <= ? and " : "") + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)});
                        if (!cursorRawQuery.moveToFirst()) {
                            cursorRawQuery.close();
                            return;
                        } else {
                            string2 = cursorRawQuery.getString(0);
                            string = cursorRawQuery.getString(1);
                            cursorRawQuery.close();
                        }
                    } else {
                        Cursor cursorRawQuery2 = sQLiteDatabaseZzh.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + (j2 != -1 ? " and rowid <= ?" : "") + " order by rowid limit 1;", j2 != -1 ? new String[]{null, String.valueOf(j2)} : new String[]{null});
                        if (!cursorRawQuery2.moveToFirst()) {
                            cursorRawQuery2.close();
                            return;
                        } else {
                            string = cursorRawQuery2.getString(0);
                            cursorRawQuery2.close();
                        }
                    }
                    Cursor cursorQuery = sQLiteDatabaseZzh.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string2, string}, null, null, "rowid", "2");
                    if (!cursorQuery.moveToFirst()) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(zzeh.zzn(string2), "Raw event metadata record is missing. appId");
                        cursorQuery.close();
                        return;
                    }
                    try {
                        zzgd zzgdVar = (zzgd) ((zzgc) zzen.zzl(zzgd.zzt(), cursorQuery.getBlob(0))).zzaC();
                        if (cursorQuery.moveToNext()) {
                            zzeh zzehVar2 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzg.zzb(zzeh.zzn(string2), "Get multiple raw event metadata records, expected one. appId");
                        }
                        cursorQuery.close();
                        com.google.android.gms.common.internal.zzah.checkNotNull(zzgdVar);
                        zzeuVar.zza = zzgdVar;
                        if (j2 != -1) {
                            str = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                            strArr = new String[]{string2, string, String.valueOf(j2)};
                        } else {
                            str = "app_id = ? and metadata_fingerprint = ?";
                            strArr = new String[]{string2, string};
                        }
                        Cursor cursorQuery2 = sQLiteDatabaseZzh.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str, strArr, null, null, "rowid", null);
                        if (!cursorQuery2.moveToFirst()) {
                            zzeh zzehVar3 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar3);
                            zzehVar3.zzg.zzb(zzeh.zzn(string2), "Raw event data disappeared while in transaction. appId");
                            cursorQuery2.close();
                            return;
                        }
                        do {
                            long j3 = cursorQuery2.getLong(0);
                            try {
                                zzfs zzfsVar = (zzfs) zzen.zzl(zzft.zze(), cursorQuery2.getBlob(3));
                                zzfsVar.zzi(cursorQuery2.getString(1));
                                zzfsVar.zzm(cursorQuery2.getLong(2));
                                if (!zzeuVar.zza((zzft) zzfsVar.zzaC(), j3)) {
                                    cursorQuery2.close();
                                    return;
                                }
                            } catch (IOException e) {
                                zzeh zzehVar4 = zzfrVar.zzm;
                                zzfr.zzR(zzehVar4);
                                zzehVar4.zzd.zzc(zzeh.zzn(string2), "Data loss. Failed to merge raw event. appId", e);
                            }
                        } while (cursorQuery2.moveToNext());
                        cursorQuery2.close();
                    } catch (IOException e2) {
                        zzeh zzehVar5 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzd.zzc(zzeh.zzn(string2), "Data loss. Failed to merge raw event metadata. appId", e2);
                        cursorQuery.close();
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    zzeh zzehVar6 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar6);
                    zzehVar6.zzd.zzc(zzeh.zzn(null), "Data loss. Error selecting raw event. appId", e);
                    if (r4 != 0) {
                        r4.close();
                    }
                }
            } catch (SQLiteException e4) {
                e = e4;
                r4 = 0;
            } catch (Throwable th) {
                th = th;
                if (r5 != 0) {
                    r5.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r5 = "select app_id, metadata_fingerprint from raw_events where ";
            if (r5 != 0) {
                r5.close();
            }
            throw th;
        }
    }

    public final long zzZ(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = zzh().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzc(str, "Database error", e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzfr zzfrVar = (zzfr) this.mBuilder;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzd("Error deleting conditional property", zzeh.zzn(str), zzfrVar.zzq.zzf(str2), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    public final long zzaa(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzh().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j;
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e) {
                zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzc(str, "Database error", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }

    public final long zzc(String str) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty("first_open_count");
        zzg();
        zzW();
        SQLiteDatabase sQLiteDatabaseZzh = zzh();
        sQLiteDatabaseZzh.beginTransaction();
        long j = 0;
        try {
            try {
                long jZzaa = zzaa("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (jZzaa == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseZzh.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzc(zzeh.zzn(str), "Failed to insert column (got -1). appId", "first_open_count");
                        return -1L;
                    }
                    jZzaa = 0;
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzd("Error inserting column. appId", zzeh.zzn(str), "first_open_count", e);
                    return j;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("first_open_count", Long.valueOf(1 + jZzaa));
                    if (sQLiteDatabaseZzh.update("app2", contentValues2, "app_id = ?", new String[]{str}) != 0) {
                        sQLiteDatabaseZzh.setTransactionSuccessful();
                        return jZzaa;
                    }
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzc(zzeh.zzn(str), "Failed to update column (got 0). appId", "first_open_count");
                    return -1L;
                } catch (SQLiteException e) {
                    e = e;
                    j = jZzaa;
                }
            } finally {
                sQLiteDatabaseZzh.endTransaction();
            }
        } catch (SQLiteException e2) {
            e = e2;
        }
    }

    public final long zzf(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final SQLiteDatabase zzh() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error opening database");
            throw e;
        }
    }

    public final zzak zzm(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzg();
        zzW();
        String[] strArr = {str};
        zzak zzakVar = new zzak();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZzh = zzh();
                Cursor cursorQuery = sQLiteDatabaseZzh.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zzb(zzeh.zzn(str), "Not updating daily counts, app is not known. appId");
                    cursorQuery.close();
                    return zzakVar;
                }
                if (cursorQuery.getLong(0) == j) {
                    zzakVar.zzb = cursorQuery.getLong(1);
                    zzakVar.zza = cursorQuery.getLong(2);
                    zzakVar.zzc = cursorQuery.getLong(3);
                    zzakVar.zzd = cursorQuery.getLong(4);
                    zzakVar.zze = cursorQuery.getLong(5);
                }
                if (z) {
                    zzakVar.zzb += j2;
                }
                if (z2) {
                    zzakVar.zza += j2;
                }
                if (z3) {
                    zzakVar.zzc += j2;
                }
                if (z4) {
                    zzakVar.zzd += j2;
                }
                if (z5) {
                    zzakVar.zze += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzakVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzakVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzakVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzakVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzakVar.zze));
                sQLiteDatabaseZzh.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return zzakVar;
            } catch (SQLiteException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzc(zzeh.zzn(str), "Error updating daily counts. appId", e);
                if (0 != 0) {
                    cursor.close();
                }
                return zzakVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0099  */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0074: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:117), block:B:24:0x0074 */
    public final zzky zzp(String str, String str2) {
        SQLiteException e;
        Cursor cursorQuery;
        Cursor cursor;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        zzg();
        zzW();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = zzh().query("user_attributes", new String[]{"set_timestamp", FirebaseAnalytics.Param.VALUE, FirebaseAnalytics.Param.ORIGIN}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    Object objZzq = zzq(cursorQuery, 1);
                    if (objZzq == null) {
                        cursorQuery.close();
                        return null;
                    }
                    zzky zzkyVar = new zzky(str, cursorQuery.getString(2), str2, j, objZzq);
                    if (cursorQuery.moveToNext()) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(zzeh.zzn(str), "Got multiple records for user property, expected one. appId");
                    }
                    cursorQuery.close();
                    return zzkyVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzd("Error querying user property. appId", zzeh.zzn(str), zzfrVar.zzq.zzf(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final Object zzq(Cursor cursor, int i) {
        int type = cursor.getType(i);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (type == 0) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzeh zzehVar3 = zzfrVar.zzm;
        zzfr.zzR(zzehVar3);
        zzehVar3.zzd.zzb(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0043  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final String zzr() throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseZzh = zzh();
        ?? r1 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zzb(e, "Database error getting next bundle app id");
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            r1 = sQLiteDatabaseZzh;
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public final List zzs(String str, String str2, String str3) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List zzu(String str) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                zzfrVar.getClass();
                cursorQuery = zzh().query("user_attributes", new String[]{"name", FirebaseAnalytics.Param.ORIGIN, "set_timestamp", FirebaseAnalytics.Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursorQuery.getLong(2);
                    Object objZzq = zzq(cursorQuery, 3);
                    if (objZzq == null) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(zzeh.zzn(str), "Read invalid user property value, ignoring it. appId");
                    } else {
                        arrayList.add(new zzky(str, str2, string, j, objZzq));
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzc(zzeh.zzn(str), "Error querying user properties. appId", e);
                List listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void zzw() {
        zzW();
        zzh().beginTransaction();
    }

    public final void zzx() {
        zzW();
        zzh().endTransaction();
    }

    public final void zzy(ArrayList arrayList) {
        zzg();
        zzW();
        com.google.android.gms.common.internal.zzah.checkNotNull(arrayList);
        if (arrayList.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zzfrVar.zze.getDatabasePath("google_app_measurement.db").exists()) {
            String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("(", TextUtils.join(",", arrayList), ")");
            if (zzZ("SELECT COUNT(1) FROM queue WHERE rowid IN " + strM$1 + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                zzh().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + strM$1 + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Error incrementing retry count. error");
            }
        }
    }

    public final void zzD(zzh zzhVar) {
        zzg();
        zzW();
        String strZzt = zzhVar.zzt();
        com.google.android.gms.common.internal.zzah.checkNotNull(strZzt);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzt);
        contentValues.put("app_instance_id", zzhVar.zzu());
        contentValues.put("gmp_app_id", zzhVar.zzy());
        zzfr zzfrVar = zzhVar.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        contentValues.put("resettable_device_id_hash", zzhVar.zze);
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzg();
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzg));
        zzfo zzfoVar3 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar3);
        zzfoVar3.zzg();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzh));
        zzfo zzfoVar4 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar4);
        zzfoVar4.zzg();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzi));
        contentValues.put("app_version", zzhVar.zzw());
        zzfo zzfoVar5 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar5);
        zzfoVar5.zzg();
        contentValues.put("app_store", zzhVar.zzl);
        zzfo zzfoVar6 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar6);
        zzfoVar6.zzg();
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzm));
        zzfo zzfoVar7 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar7);
        zzfoVar7.zzg();
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzn));
        zzfo zzfoVar8 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar8);
        zzfoVar8.zzg();
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzo));
        zzfo zzfoVar9 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar9);
        zzfoVar9.zzg();
        contentValues.put("day", Long.valueOf(zzhVar.zzv));
        zzfo zzfoVar10 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzw));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzx));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzy));
        zzfo zzfoVar11 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar11);
        zzfoVar11.zzg();
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzD));
        zzfo zzfoVar12 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar12);
        zzfoVar12.zzg();
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzE));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzb()));
        contentValues.put(DaWYVMJ.mJDnv, zzhVar.zzx());
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzz));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzA));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("health_monitor_sample", zzhVar.zzB);
        zzfo zzfoVar13 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar13);
        zzfoVar13.zzg();
        contentValues.put(dLDI.uAEcHnFwF, (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzah()));
        contentValues.put("admob_app_id", zzhVar.zzr());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzk()));
        zzfo zzfoVar14 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar14);
        zzfoVar14.zzg();
        contentValues.put("session_stitching_token", zzhVar.zzu);
        zzfo zzfoVar15 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar15);
        zzfoVar15.zzg();
        ArrayList arrayList = zzhVar.zzt;
        zzfr zzfrVar2 = (zzfr) this.mBuilder;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                zzeh zzehVar = zzfrVar2.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(strZzt, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        zznt.zzc();
        zzag zzagVar = zzfrVar2.zzk;
        zzeh zzehVar2 = zzfrVar2.zzm;
        if (zzagVar.zzs(null, zzdu.zzai) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzh();
            if (sQLiteDatabaseZzh.update("apps", contentValues, "app_id = ?", new String[]{strZzt}) == 0 && sQLiteDatabaseZzh.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(zzeh.zzn(strZzt), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(strZzt), "Error storing app. appId", e);
        }
    }

    public final void zzE(zzas zzasVar) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzasVar);
        zzg();
        zzW();
        ContentValues contentValues = new ContentValues();
        String str = zzasVar.zza;
        contentValues.put("app_id", str);
        contentValues.put("name", zzasVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzasVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzasVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzasVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzasVar.zzg));
        contentValues.put("last_bundled_day", zzasVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzasVar.zzi);
        contentValues.put("last_sampling_rate", zzasVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzasVar.zze));
        Boolean bool = zzasVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zzh().insertWithOnConflict(DaWYVMJ.cqtUYI, null, contentValues, 5) == -1) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(zzeh.zzn(str), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), "Error storing event aggregates. appId", e);
        }
    }

    public final zzh zzj(String str) {
        Cursor cursorQuery;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzg();
        zzW();
        Cursor cursor = null;
        try {
            cursorQuery = zzh().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", kBfGXgdfpo.vBiFQcQPAVv, "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    zzh zzhVar = new zzh(this.zzf.zzn, str);
                    zzfr zzfrVar2 = zzhVar.zza;
                    zzhVar.zzH(cursorQuery.getString(0));
                    zzhVar.zzW(cursorQuery.getString(1));
                    zzhVar.zzae(cursorQuery.getString(2));
                    zzhVar.zzaa(cursorQuery.getLong(3));
                    zzhVar.zzab(cursorQuery.getLong(4));
                    zzhVar.zzZ(cursorQuery.getLong(5));
                    zzhVar.zzJ(cursorQuery.getString(6));
                    zzhVar.zzI(cursorQuery.getString(7));
                    zzhVar.zzX(cursorQuery.getLong(8));
                    zzhVar.zzS(cursorQuery.getLong(9));
                    zzhVar.zzac(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    zzhVar.zzR(cursorQuery.getLong(11));
                    zzhVar.zzP(cursorQuery.getLong(12));
                    zzhVar.zzO(cursorQuery.getLong(13));
                    zzhVar.zzM(cursorQuery.getLong(14));
                    zzhVar.zzL(cursorQuery.getLong(15));
                    zzhVar.zzU(cursorQuery.getLong(16));
                    zzhVar.zzK(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    zzhVar.zzV(cursorQuery.getString(18));
                    zzhVar.zzN(cursorQuery.getLong(19));
                    zzhVar.zzQ(cursorQuery.getLong(20));
                    zzhVar.zzY(cursorQuery.getString(21));
                    boolean z = cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0;
                    zzfo zzfoVar = zzfrVar2.zzn;
                    zzfr.zzR(zzfoVar);
                    zzfoVar.zzg();
                    zzhVar.zzC |= zzhVar.zzp != z;
                    zzhVar.zzp = z;
                    zzhVar.zzF(cursorQuery.getString(24));
                    zzhVar.zzT(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                    if (!cursorQuery.isNull(26)) {
                        zzhVar.zzaf(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                    }
                    zzpd.zzc();
                    if (zzfrVar.zzk.zzs(null, zzdu.zzal) && zzfrVar.zzk.zzs(str, zzdu.zzan)) {
                        String string = cursorQuery.getString(28);
                        zzfo zzfoVar2 = zzfrVar2.zzn;
                        zzfr.zzR(zzfoVar2);
                        zzfoVar2.zzg();
                        zzhVar.zzC = (true ^ zzg.zza(zzhVar.zzu, string)) | zzhVar.zzC;
                        zzhVar.zzu = string;
                    }
                    zzfo zzfoVar3 = zzfrVar2.zzn;
                    zzfr.zzR(zzfoVar3);
                    zzfoVar3.zzg();
                    zzhVar.zzC = false;
                    if (cursorQuery.moveToNext()) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(zzeh.zzn(str), "Got multiple records for app, expected one. appId");
                    }
                    cursorQuery.close();
                    return zzhVar;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                }
            } catch (SQLiteException e) {
                e = e;
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzc(zzeh.zzn(str), "Error querying app. appId", e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x011f  */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00fb: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:249), block:B:29:0x00fb */
    public final zzac zzk(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        zzkt zzktVar = this.zzf;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        zzg();
        zzW();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = zzh().query("conditional_properties", new String[]{FirebaseAnalytics.Param.ORIGIN, FirebaseAnalytics.Param.VALUE, "active", wsbWxekY.WuHjny, "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", wsbWxekY.CBD, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    String str3 = string;
                    Object objZzq = zzq(cursorQuery, 1);
                    boolean z = cursorQuery.getInt(2) != 0;
                    String string2 = cursorQuery.getString(3);
                    long j = cursorQuery.getLong(4);
                    zzen zzenVar = zzktVar.zzi;
                    zzen zzenVar2 = zzktVar.zzi;
                    zzkt.zzal(zzenVar);
                    byte[] blob = cursorQuery.getBlob(5);
                    Parcelable.Creator<zzaw> creator = zzaw.CREATOR;
                    zzaw zzawVar = (zzaw) zzenVar.zzh(blob, creator);
                    long j2 = cursorQuery.getLong(6);
                    zzkt.zzal(zzenVar2);
                    zzaw zzawVar2 = (zzaw) zzenVar2.zzh(cursorQuery.getBlob(7), creator);
                    long j3 = cursorQuery.getLong(8);
                    long j4 = cursorQuery.getLong(9);
                    zzkt.zzal(zzenVar2);
                    zzac zzacVar = new zzac(str, str3, new zzkw(j3, objZzq, str2, str3), j2, z, string2, zzawVar, j, zzawVar2, j4, (zzaw) zzenVar2.zzh(cursorQuery.getBlob(10), creator));
                    if (cursorQuery.moveToNext()) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzc(zzeh.zzn(str), "Got multiple records for conditional property, expected one", zzfrVar.zzq.zzf(str2));
                    }
                    cursorQuery.close();
                    return zzacVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzd("Error querying conditional property", zzeh.zzn(str), zzfrVar.zzq.zzf(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0133  */
    /* JADX WARN: Multi-variable type inference failed */
    public final zzas zzn(String str, String str2) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        zzg();
        zzW();
        AbstractWindowedCursor abstractWindowedCursor = 0;
        try {
            try {
                cursorQuery = zzh().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", nYVxXTZQ.QQyMYdktCHH, "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    long j2 = cursorQuery.getLong(1);
                    long j3 = cursorQuery.getLong(2);
                    long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                    }
                    zzas zzasVar = new zzas(str, str2, j, j2, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j3, j4, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursorQuery.moveToNext()) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(zzeh.zzn(str), "Got multiple records for event aggregates, expected one. appId");
                    }
                    cursorQuery.close();
                    return zzasVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzd(RDFWIi.eFl, zzeh.zzn(str), zzfrVar.zzq.zzd(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (abstractWindowedCursor != 0) {
                    abstractWindowedCursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            abstractWindowedCursor = "current_bundle_count";
            if (abstractWindowedCursor != 0) {
                abstractWindowedCursor.close();
            }
            throw th;
        }
    }

    public final List zzt(String str, String[] strArr) {
        zzkt zzktVar = this.zzf;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZzh = zzh();
                String[] strArr2 = {"app_id", FirebaseAnalytics.Param.ORIGIN, "name", FirebaseAnalytics.Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"};
                String str2 = ehgOP.daEK;
                zzfrVar.getClass();
                cursorQuery = sQLiteDatabaseZzh.query("conditional_properties", strArr2, str, strArr, null, null, str2, "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objZzq = zzq(cursorQuery, 3);
                    boolean z = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(5);
                    long j = cursorQuery.getLong(6);
                    zzen zzenVar = zzktVar.zzi;
                    zzen zzenVar2 = zzktVar.zzi;
                    zzkt.zzal(zzenVar);
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<zzaw> creator = zzaw.CREATOR;
                    zzaw zzawVar = (zzaw) zzenVar.zzh(blob, creator);
                    long j2 = cursorQuery.getLong(8);
                    zzkt.zzal(zzenVar2);
                    zzaw zzawVar2 = (zzaw) zzenVar2.zzh(cursorQuery.getBlob(9), creator);
                    long j3 = cursorQuery.getLong(10);
                    long j4 = cursorQuery.getLong(11);
                    zzkt.zzal(zzenVar2);
                    arrayList.add(new zzac(string, string2, new zzkw(j3, objZzq, string3, string2), j2, z, string4, zzawVar, j, zzawVar2, j4, (zzaw) zzenVar2.zzh(cursorQuery.getBlob(12), creator)));
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                }
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(1000, "Read more than the max allowed conditional properties, ignoring extra");
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Error querying conditional user property value");
                List listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0120  */
    /* JADX WARN: Code duplicated, block: B:50:0x0126  */
    public final List zzv(String str, String str2, String str3) throws Throwable {
        Cursor cursorQuery;
        String string;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                try {
                    arrayList2.add(str);
                    StringBuilder sb = new StringBuilder("app_id=?");
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList2.add(str2);
                        sb.append(" and origin=?");
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(str3 + "*");
                        sb.append(" and name glob ?");
                    }
                    String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    SQLiteDatabase sQLiteDatabaseZzh = zzh();
                    String str4 = QTaELkFI.PeHKivrytaFp;
                    String[] strArr2 = {"name", "set_timestamp", FirebaseAnalytics.Param.VALUE, FirebaseAnalytics.Param.ORIGIN};
                    String string2 = sb.toString();
                    zzfrVar.getClass();
                    cursorQuery = sQLiteDatabaseZzh.query(str4, strArr2, string2, strArr, null, null, "rowid", "1001");
                    try {
                        try {
                            if (!cursorQuery.moveToFirst()) {
                                cursorQuery.close();
                                return arrayList;
                            }
                            string = str2;
                            do {
                                try {
                                    int size = arrayList.size();
                                    zzeh zzehVar = zzfrVar.zzm;
                                    if (size >= 1000) {
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzd.zzb(1000, "Read more than the max allowed user properties, ignoring excess");
                                        break;
                                    }
                                    String string3 = cursorQuery.getString(0);
                                    long j = cursorQuery.getLong(1);
                                    Object objZzq = zzq(cursorQuery, 2);
                                    string = cursorQuery.getString(3);
                                    if (objZzq == null) {
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzd.zzd("(2)Read invalid user property value, ignoring it", zzeh.zzn(str), string, str3);
                                    } else {
                                        arrayList.add(new zzky(str, string, string3, j, objZzq));
                                    }
                                } catch (SQLiteException e) {
                                    e = e;
                                    zzeh zzehVar2 = zzfrVar.zzm;
                                    zzfr.zzR(zzehVar2);
                                    zzehVar2.zzd.zzd("(2)Error querying user properties", zzeh.zzn(str), string, e);
                                    List listEmptyList = Collections.emptyList();
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    return listEmptyList;
                                }
                            } while (cursorQuery.moveToNext());
                            cursorQuery.close();
                            return arrayList;
                        } catch (SQLiteException e2) {
                            e = e2;
                            string = str2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    string = str2;
                    cursorQuery = null;
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzd("(2)Error querying user properties", zzeh.zzn(str), string, e);
                    List listEmptyList2 = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
        }
    }

    public final void zzJ(String str, Long l, long j, zzft zzftVar) {
        zzg();
        zzW();
        com.google.android.gms.common.internal.zzah.checkNotNull(zzftVar);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        byte[] bArrZzbu = zzftVar.zzbu();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzeh zzehVar = zzfrVar.zzm;
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzc(zzfrVar.zzq.zzd(str), "Saving complex main event, appId, data size", Integer.valueOf(bArrZzbu.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put(wsbWxekY.cviZBMOWSODoNz, Long.valueOf(j));
        contentValues.put("main_event", bArrZzbu);
        try {
            if (zzh().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(zzeh.zzn(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), "Error storing complex main event. appId", e);
        }
    }

    public final void zzz() {
        zzg();
        zzW();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        Context context = zzfrVar.zze;
        String str = MnHfHMYQDPUO.BuLg;
        if (context.getDatabasePath(str).exists()) {
            zzkt zzktVar = this.zzf;
            long jZza = zzktVar.zzk.zza.zza();
            zzfrVar.zzr.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > ((Long) zzdu.zzx.zza(null)).longValue()) {
                zzktVar.zzk.zza.zzb(jElapsedRealtime);
                zzg();
                zzW();
                if (zzfrVar.zze.getDatabasePath(str).exists()) {
                    SQLiteDatabase sQLiteDatabaseZzh = zzh();
                    zzfrVar.zzr.getClass();
                    int iDelete = sQLiteDatabaseZzh.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) zzdu.zzC.zza(null)).longValue())});
                    if (iDelete > 0) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzl.zzb(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }
}
