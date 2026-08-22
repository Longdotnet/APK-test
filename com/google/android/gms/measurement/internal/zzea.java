package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzea extends zzf {
    public final zzal zza;
    public boolean zzb;

    public zzea(zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = new zzal(this, ((zzfr) this.mBuilder).zze);
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final SQLiteDatabase zzh() {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    public final void zzj() {
        int iDelete;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzg();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzh();
            if (sQLiteDatabaseZzh == null || (iDelete = sQLiteDatabaseZzh.delete("messages", null, null)) <= 0) {
                return;
            }
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzb(Integer.valueOf(iDelete), "Reset local analytics data. records");
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e, "Error resetting local analytics data. error");
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0071 A[PHI: r4
  0x0071: PHI (r4v4 int) = (r4v1 int), (r4v2 int), (r4v1 int) binds: [B:35:0x0081, B:32:0x006f, B:29:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    public final void zzm() {
        zzg();
        if (this.zzb) {
            return;
        }
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zzfrVar.zze.getDatabasePath("google_app_measurement_local.db").exists()) {
            int i = 5;
            for (int i2 = 0; i2 < 5; i2++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        SQLiteDatabase sQLiteDatabaseZzh = zzh();
                        if (sQLiteDatabaseZzh == null) {
                            this.zzb = true;
                            return;
                        }
                        sQLiteDatabaseZzh.beginTransaction();
                        sQLiteDatabaseZzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                        sQLiteDatabaseZzh.setTransactionSuccessful();
                        sQLiteDatabaseZzh.endTransaction();
                        sQLiteDatabaseZzh.close();
                        return;
                    } catch (SQLiteDatabaseLockedException unused) {
                        SystemClock.sleep(i);
                        i += 20;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    } catch (SQLiteFullException e) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzb(e, "Error deleting app launch break from local database");
                        this.zzb = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteException e2) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzb(e2, "Error deleting app launch break from local database");
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzg.zza("Error deleting app launch break from local database in reasonable time");
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00eb A[PHI: r10
  0x00eb: PHI (r10v3 android.database.sqlite.SQLiteDatabase) = (r10v2 android.database.sqlite.SQLiteDatabase), (r10v4 android.database.sqlite.SQLiteDatabase) binds: [B:61:0x00e9, B:77:0x0117] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x0122  */
    /* JADX WARN: Code duplicated, block: B:83:0x0127  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final boolean zzq(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabaseZzh;
        ?? RawQuery;
        ?? r12;
        zzg();
        ?? r2 = 0;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.getClass();
        int i2 = 5;
        int i3 = 0;
        int i4 = 5;
        while (true) {
            zzeh zzehVar = zzfrVar.zzm;
            if (i3 >= i2) {
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza("Failed to write entry to local database");
                return false;
            }
            ?? r10 = 0;
             = 0;
            ?? r11 = 0;
            sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseZzh = zzh();
                try {
                    if (sQLiteDatabaseZzh == null) {
                        this.zzb = true;
                        return r2;
                    }
                    sQLiteDatabaseZzh.beginTransaction();
                    RawQuery = sQLiteDatabaseZzh.rawQuery("select count(1) from messages", null);
                    long j = 0;
                    if (RawQuery != 0) {
                        try {
                            if (RawQuery.moveToFirst()) {
                                j = RawQuery.getLong(r2);
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            r11 = RawQuery;
                            try {
                                SystemClock.sleep(i4);
                                i4 += 20;
                                if (r11 != 0) {
                                    r11.close();
                                }
                                if (sQLiteDatabaseZzh != null) {
                                    sQLiteDatabaseZzh.close();
                                }
                                i3++;
                                r2 = 0;
                                i2 = 5;
                            } catch (Throwable th) {
                                th = th;
                                r10 = r11;
                                if (r10 != 0) {
                                    r10.close();
                                }
                                if (sQLiteDatabaseZzh != null) {
                                    sQLiteDatabaseZzh.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteFullException e) {
                            e = e;
                            sQLiteDatabase = sQLiteDatabaseZzh;
                            r12 = RawQuery;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzb(e, "Error writing entry; local database full");
                            this.zzb = true;
                            if (r12 != 0) {
                                r12.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            r2 = 0;
                            i2 = 5;
                        } catch (SQLiteException e2) {
                            e = e2;
                            sQLiteDatabase = sQLiteDatabaseZzh;
                            RawQuery = RawQuery;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseZzh = sQLiteDatabase;
                                    r10 = RawQuery;
                                    if (r10 != 0) {
                                        r10.close();
                                    }
                                    if (sQLiteDatabaseZzh != null) {
                                        sQLiteDatabaseZzh.close();
                                    }
                                    throw th;
                                }
                            }
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzb(e, "Error writing entry to local database");
                            this.zzb = true;
                            if (RawQuery != 0) {
                                RawQuery.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            r2 = 0;
                            i2 = 5;
                        } catch (Throwable th3) {
                            th = th3;
                            r10 = RawQuery;
                            if (r10 != 0) {
                                r10.close();
                            }
                            if (sQLiteDatabaseZzh != null) {
                                sQLiteDatabaseZzh.close();
                            }
                            throw th;
                        }
                    }
                    if (j >= 100000) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zza("Data loss, local db full");
                        long j2 = 100001 - j;
                        long jDelete = sQLiteDatabaseZzh.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                        if (jDelete != j2) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                        }
                    }
                    sQLiteDatabaseZzh.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabaseZzh.setTransactionSuccessful();
                    sQLiteDatabaseZzh.endTransaction();
                    if (RawQuery != 0) {
                        RawQuery.close();
                    }
                    sQLiteDatabaseZzh.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused2) {
                } catch (SQLiteFullException e3) {
                    e = e3;
                    RawQuery = 0;
                } catch (SQLiteException e4) {
                    e = e4;
                    RawQuery = 0;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabaseZzh = null;
            } catch (SQLiteFullException e5) {
                e = e5;
                r12 = 0;
            } catch (SQLiteException e6) {
                e = e6;
                RawQuery = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseZzh = null;
                if (r10 != 0) {
                    r10.close();
                }
                if (sQLiteDatabaseZzh != null) {
                    sQLiteDatabaseZzh.close();
                }
                throw th;
            }
            i3++;
            r2 = 0;
            i2 = 5;
        }
    }
}
