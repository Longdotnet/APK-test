package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat$Style;
import com.google.android.gms.common.util.DefaultClock;
import okhttp3.internal.concurrent.onZL.mnwSv;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzal extends SQLiteOpenHelper {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ NotificationCompat$Style zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(zzam zzamVar, Context context) {
        super(context, "google_app_measurement.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzamVar;
    }

    private final void onDowngrade$com$google$android$gms$measurement$internal$zzal(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private final void onDowngrade$com$google$android$gms$measurement$internal$zzdz(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private final void onUpgrade$com$google$android$gms$measurement$internal$zzal(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private final void onUpgrade$com$google$android$gms$measurement$internal$zzdz(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        switch (this.$r8$classId) {
            case 0:
                zzeh zzehVar = ((zzfr) ((zzam) this.zza).mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzg.zzb(zzehVar, sQLiteDatabase);
                break;
            default:
                zzeh zzehVar2 = ((zzfr) ((zzea) this.zza).mBuilder).zzm;
                zzfr.zzR(zzehVar2);
                zzg.zzb(zzehVar2, sQLiteDatabase);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = this.$r8$classId;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                zzam zzamVar = (zzam) this.zza;
                zzeh zzehVar = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzg.zza(zzehVar, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", zzam.zza);
                zzeh zzehVar2 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar2);
                zzg.zza(zzehVar2, sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
                zzeh zzehVar3 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar3);
                zzg.zza(zzehVar3, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzam.zzb);
                zzeh zzehVar4 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar4);
                zzg.zza(zzehVar4, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzam.zzc);
                zzeh zzehVar5 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar5);
                zzg.zza(zzehVar5, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzam.zze);
                zzeh zzehVar6 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar6);
                zzg.zza(zzehVar6, sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
                zzeh zzehVar7 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar7);
                zzg.zza(zzehVar7, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzam.zzd);
                zzeh zzehVar8 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar8);
                zzg.zza(zzehVar8, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", zzam.zzg);
                zzeh zzehVar9 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar9);
                zzg.zza(zzehVar9, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", zzam.zzh);
                zzeh zzehVar10 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar10);
                zzg.zza(zzehVar10, sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
                zzeh zzehVar11 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar11);
                zzg.zza(zzehVar11, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzam.zzi);
                zzeh zzehVar12 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar12);
                zzg.zza(zzehVar12, sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
                zzeh zzehVar13 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar13);
                zzg.zza(zzehVar13, sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
                zzeh zzehVar14 = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar14);
                zzg.zza(zzehVar14, sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", null);
                break;
            default:
                zzeh zzehVar15 = ((zzfr) ((zzea) this.zza).mBuilder).zzm;
                zzfr.zzR(zzehVar15);
                zzg.zza(zzehVar15, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = this.$r8$classId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(zzea zzeaVar, Context context) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzeaVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        switch (this.$r8$classId) {
            case 0:
                zzam zzamVar = (zzam) this.zza;
                HeadersReader headersReader = zzamVar.zzk;
                zzfr zzfrVar = (zzfr) zzamVar.mBuilder;
                zzfrVar.getClass();
                if (headersReader.headerLimit != 0) {
                    ((DefaultClock) headersReader.source).getClass();
                    if (SystemClock.elapsedRealtime() - headersReader.headerLimit < 3600000) {
                        throw new SQLiteException("Database open failed");
                    }
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException unused) {
                    HeadersReader headersReader2 = zzamVar.zzk;
                    ((DefaultClock) headersReader2.source).getClass();
                    headersReader2.headerLimit = SystemClock.elapsedRealtime();
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zza(mnwSv.tqMiEkDtWkytYzR);
                    zzfrVar.getClass();
                    if (!zzfrVar.zze.getDatabasePath("google_app_measurement.db").delete()) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zzb("google_app_measurement.db", "Failed to delete corrupted db file");
                    }
                    try {
                        SQLiteDatabase writableDatabase = super.getWritableDatabase();
                        headersReader2.headerLimit = 0L;
                        return writableDatabase;
                    } catch (SQLiteException e) {
                        zzeh zzehVar3 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar3);
                        zzehVar3.zzd.zzb(e, "Failed to open freshly created database");
                        throw e;
                    }
                }
            default:
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteDatabaseLockedException e2) {
                    throw e2;
                } catch (SQLiteException unused2) {
                    zzea zzeaVar = (zzea) this.zza;
                    zzeh zzehVar4 = ((zzfr) zzeaVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar4);
                    zzehVar4.zzd.zza("Opening the local database failed, dropping and recreating it");
                    ((zzfr) zzeaVar.mBuilder).getClass();
                    if (!((zzfr) zzeaVar.mBuilder).zze.getDatabasePath("google_app_measurement_local.db").delete()) {
                        zzeh zzehVar5 = ((zzfr) zzeaVar.mBuilder).zzm;
                        zzfr.zzR(zzehVar5);
                        zzehVar5.zzd.zzb("google_app_measurement_local.db", "Failed to delete corrupted local db file");
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e3) {
                        zzeh zzehVar6 = ((zzfr) zzeaVar.mBuilder).zzm;
                        zzfr.zzR(zzehVar6);
                        zzehVar6.zzd.zzb(e3, "Failed to open local database. Events will bypass local storage");
                        return null;
                    }
                }
        }
    }
}
