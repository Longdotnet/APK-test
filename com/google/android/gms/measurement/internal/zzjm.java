package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Pair;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.WorkerWrapper;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.internal.measurement.zzpj;
import com.google.firebase.inject.PVS.jIKWv;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjm extends zzf {
    public final zzjl zza;
    public zzdx zzb;
    public volatile Boolean zzc;
    public final zziw zzd;
    public final HeadersReader zze;
    public final ArrayList zzf;
    public final zziw zzg;

    public zzjm(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = new ArrayList();
        this.zze = new HeadersReader(zzfrVar.zzr);
        this.zza = new zzjl(this);
        this.zzd = new zziw(this, zzfrVar, 0);
        this.zzg = new zziw(this, zzfrVar, 1);
    }

    public static void zzo(zzjm zzjmVar, ComponentName componentName) {
        zzjmVar.zzg();
        if (zzjmVar.zzb != null) {
            zzjmVar.zzb = null;
            zzeh zzehVar = ((zzfr) zzjmVar.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzb(componentName, "Disconnected from device MeasurementService");
            zzjmVar.zzg();
            zzjmVar.zzr();
        }
    }

    public final void zzE(zzac zzacVar) {
        boolean zZzq;
        zzg();
        zza();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.getClass();
        zzea zzeaVarZzi = zzfrVar.zzi();
        zzfr zzfrVar2 = (zzfr) zzeaVarZzi.mBuilder;
        zzfr.zzP(zzfrVar2.zzp);
        byte[] bArrZzan = zzlb.zzan(zzacVar);
        if (bArrZzan.length > 131072) {
            zzeh zzehVar = zzfrVar2.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zze.zza("Conditional user property too long for local database. Sending directly to service");
            zZzq = false;
        } else {
            zZzq = zzeaVarZzi.zzq(2, bArrZzan);
        }
        boolean z = zZzq;
        zzR(new zzio(this, zzO(true), z, new zzac(zzacVar), 2));
    }

    public final boolean zzL() {
        zzg();
        zza();
        return this.zzb != null;
    }

    public final boolean zzM() {
        zzg();
        zza();
        if (!zzN()) {
            return true;
        }
        zzlb zzlbVar = ((zzfr) this.mBuilder).zzp;
        zzfr.zzP(zzlbVar);
        return zzlbVar.zzm() >= ((Integer) zzdu.zzaf.zza(null)).intValue();
    }

    public final boolean zzN() {
        zzg();
        zza();
        if (this.zzc == null) {
            zzg();
            zza();
            zzew zzewVar = ((zzfr) this.mBuilder).zzl;
            zzfr.zzP(zzewVar);
            zzewVar.zzg();
            boolean z = false;
            Boolean boolValueOf = !zzewVar.zza().contains("use_service") ? null : Boolean.valueOf(zzewVar.zza().getBoolean("use_service", false));
            boolean z2 = true;
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                ((zzfr) this.mBuilder).getClass();
                zzdy zzdyVarZzh = ((zzfr) this.mBuilder).zzh();
                zzdyVarZzh.zza();
                if (zzdyVarZzh.zzj == 1) {
                    z = true;
                } else {
                    zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzl.zza("Checking service availability");
                    zzlb zzlbVar = ((zzfr) this.mBuilder).zzp;
                    zzfr.zzP(zzlbVar);
                    int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(((zzfr) zzlbVar.mBuilder).zze, 12451000);
                    if (iIsGooglePlayServicesAvailable == 0) {
                        zzeh zzehVar2 = ((zzfr) this.mBuilder).zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzl.zza("Service available");
                    } else if (iIsGooglePlayServicesAvailable == 1) {
                        zzeh zzehVar3 = ((zzfr) this.mBuilder).zzm;
                        zzfr.zzR(zzehVar3);
                        zzehVar3.zzl.zza("Service missing");
                    } else if (iIsGooglePlayServicesAvailable != 2) {
                        if (iIsGooglePlayServicesAvailable == 3) {
                            zzeh zzehVar4 = ((zzfr) this.mBuilder).zzm;
                            zzfr.zzR(zzehVar4);
                            zzehVar4.zzg.zza("Service disabled");
                        } else if (iIsGooglePlayServicesAvailable == 9) {
                            zzeh zzehVar5 = ((zzfr) this.mBuilder).zzm;
                            zzfr.zzR(zzehVar5);
                            zzehVar5.zzg.zza("Service invalid");
                        } else if (iIsGooglePlayServicesAvailable != 18) {
                            zzeh zzehVar6 = ((zzfr) this.mBuilder).zzm;
                            zzfr.zzR(zzehVar6);
                            zzehVar6.zzg.zzb(Integer.valueOf(iIsGooglePlayServicesAvailable), "Unexpected service status");
                        } else {
                            zzeh zzehVar7 = ((zzfr) this.mBuilder).zzm;
                            zzfr.zzR(zzehVar7);
                            zzehVar7.zzg.zza("Service updating");
                        }
                        z2 = false;
                    } else {
                        zzeh zzehVar8 = ((zzfr) this.mBuilder).zzm;
                        zzfr.zzR(zzehVar8);
                        zzehVar8.zzk.zza("Service container out of date");
                        zzlb zzlbVar2 = ((zzfr) this.mBuilder).zzp;
                        zzfr.zzP(zzlbVar2);
                        if (zzlbVar2.zzm() >= 17443) {
                            z = boolValueOf == null;
                            z2 = false;
                        }
                    }
                    z = true;
                }
                if (!z && ((zzfr) this.mBuilder).zzk.zzx()) {
                    zzeh zzehVar9 = ((zzfr) this.mBuilder).zzm;
                    zzfr.zzR(zzehVar9);
                    zzehVar9.zzd.zza("No way to upload. Consider using the full version of Analytics");
                } else if (z2) {
                    zzew zzewVar2 = ((zzfr) this.mBuilder).zzl;
                    zzfr.zzP(zzewVar2);
                    zzewVar2.zzg();
                    SharedPreferences.Editor editorEdit = zzewVar2.zza().edit();
                    editorEdit.putBoolean("use_service", z);
                    editorEdit.apply();
                }
                z2 = z;
            }
            this.zzc = Boolean.valueOf(z2);
        }
        return this.zzc.booleanValue();
    }

    public final void zzP$1() {
        zzg();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        ArrayList arrayList = this.zzf;
        zzehVar.zzl.zzb(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.zzg.zzb();
    }

    public final void zzQ() {
        zzg();
        HeadersReader headersReader = this.zze;
        ((DefaultClock) headersReader.source).getClass();
        headersReader.headerLimit = SystemClock.elapsedRealtime();
        ((zzfr) this.mBuilder).getClass();
        this.zzd.zzd(((Long) zzdu.zzI.zza(null)).longValue());
    }

    public final void zzR(Runnable runnable) {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.zzf;
        int size = arrayList.size();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.getClass();
        if (size >= 1000) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.zzg.zzd(60000L);
            zzr();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final Boolean zzj() {
        return this.zzc;
    }

    public final void zzr() {
        zzg();
        zza();
        if (zzL()) {
            return;
        }
        if (zzN()) {
            this.zza.zzc();
            return;
        }
        if (((zzfr) this.mBuilder).zzk.zzx()) {
            return;
        }
        ((zzfr) this.mBuilder).getClass();
        List<ResolveInfo> listQueryIntentServices = ((zzfr) this.mBuilder).zze.getPackageManager().queryIntentServices(new Intent().setClassName(((zzfr) this.mBuilder).zze, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(((zzfr) this.mBuilder).zze, "com.google.android.gms.measurement.AppMeasurementService"));
        zzjl zzjlVar = this.zza;
        zzjlVar.zza.zzg();
        Context context = ((zzfr) zzjlVar.zza.mBuilder).zze;
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (zzjlVar) {
            try {
                if (zzjlVar.zzb) {
                    zzeh zzehVar2 = ((zzfr) zzjlVar.zza.mBuilder).zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzl.zza("Connection attempt already in progress");
                } else {
                    zzeh zzehVar3 = ((zzfr) zzjlVar.zza.mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzl.zza("Using local app measurement service");
                    zzjlVar.zzb = true;
                    connectionTracker.zzc(context, context.getClass().getName(), intent, zzjlVar.zza.zza, 129, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzs$1() {
        zzg();
        zza();
        zzjl zzjlVar = this.zza;
        if (zzjlVar.zzc != null && (zzjlVar.zzc.isConnected() || zzjlVar.zzc.isConnecting())) {
            zzjlVar.zzc.disconnect();
        }
        zzjlVar.zzc = null;
        try {
            ConnectionTracker.getInstance().unbindService(((zzfr) this.mBuilder).zze, this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new WorkerWrapper.AnonymousClass1(this, atomicReference, zzO(false), 22));
    }

    /* JADX WARN: Code duplicated, block: B:168:0x02be A[Catch: all -> 0x02c2, TryCatch #25 {all -> 0x02c2, blocks: (B:166:0x02b8, B:168:0x02be, B:171:0x02c4, B:180:0x02ec), top: B:253:0x02b8 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:175:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:183:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:185:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:190:0x0315  */
    /* JADX WARN: Code duplicated, block: B:192:0x031a  */
    /* JADX WARN: Code duplicated, block: B:253:0x02b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x031f A[SYNTHETIC] */
    public final void zzD(zzdx zzdxVar, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) throws Throwable {
        zzfr zzfrVar;
        int i;
        ArrayList arrayList;
        SQLiteDatabase sQLiteDatabaseZzh;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursorQuery;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor3;
        Cursor cursorQuery2;
        long j;
        String str;
        String[] strArr;
        zzac zzacVarCreateFromParcel;
        zzkw zzkwVarCreateFromParcel;
        int size;
        zzg();
        zza();
        zzfr zzfrVar2 = (zzfr) this.mBuilder;
        zzfrVar2.getClass();
        zzfrVar2.getClass();
        int i2 = 100;
        int i3 = 100;
        int i4 = 0;
        while (i4 < 1001 && i3 == i2) {
            ArrayList arrayList2 = new ArrayList();
            zzea zzeaVarZzi = zzfrVar2.zzi();
            String str2 = "rowid";
            zzeaVarZzi.zzg();
            if (zzeaVarZzi.zzb) {
                zzfrVar = zzfrVar2;
                i = i4;
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                zzfr zzfrVar3 = (zzfr) zzeaVarZzi.mBuilder;
                if (zzfrVar3.zze.getDatabasePath("google_app_measurement_local.db").exists()) {
                    int i5 = 5;
                    int i6 = 5;
                    int i7 = 0;
                    while (true) {
                        if (i7 < i5) {
                            try {
                                sQLiteDatabaseZzh = zzeaVarZzi.zzh();
                                if (sQLiteDatabaseZzh == null) {
                                    try {
                                        try {
                                            try {
                                                zzeaVarZzi.zzb = true;
                                                zzfrVar = zzfrVar2;
                                                i = i4;
                                            } catch (SQLiteFullException e) {
                                                e = e;
                                                i4 = i4;
                                                str2 = str2;
                                                cursorQuery = null;
                                                zzeh zzehVar = zzfrVar3.zzm;
                                                zzfr.zzR(zzehVar);
                                                zzehVar.zzd.zzb(e, "Error reading entries from local database");
                                                zzeaVarZzi.zzb = true;
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                                if (sQLiteDatabaseZzh != null) {
                                                    sQLiteDatabaseZzh.close();
                                                }
                                                i6 = i6;
                                                i7++;
                                                zzfrVar2 = zzfrVar2;
                                                str2 = str2;
                                                i4 = i4;
                                                i5 = 5;
                                            } catch (SQLiteException e2) {
                                                e = e2;
                                                i4 = i4;
                                                str2 = str2;
                                                sQLiteDatabase = sQLiteDatabaseZzh;
                                                cursor = null;
                                                if (sQLiteDatabase != null) {
                                                    try {
                                                        if (sQLiteDatabase.inTransaction()) {
                                                            sQLiteDatabase.endTransaction();
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        cursor3 = cursor;
                                                        sQLiteDatabaseZzh = sQLiteDatabase;
                                                    }
                                                }
                                                zzeh zzehVar2 = zzfrVar3.zzm;
                                                zzfr.zzR(zzehVar2);
                                                zzehVar2.zzd.zzb(e, "Error reading entries from local database");
                                                zzeaVarZzi.zzb = true;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                zzfrVar2 = zzfrVar2;
                                                i6 = i6;
                                                i6 = i6;
                                                i7++;
                                                zzfrVar2 = zzfrVar2;
                                                str2 = str2;
                                                i4 = i4;
                                                i5 = 5;
                                            }
                                        } catch (SQLiteDatabaseLockedException unused) {
                                            i4 = i4;
                                            str2 = str2;
                                            sQLiteDatabase2 = sQLiteDatabaseZzh;
                                            cursor2 = null;
                                            SystemClock.sleep(i6);
                                            i6 += 20;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase2 != null) {
                                                sQLiteDatabase2.close();
                                            }
                                            i7++;
                                            zzfrVar2 = zzfrVar2;
                                            str2 = str2;
                                            i4 = i4;
                                            i5 = 5;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } else {
                                    sQLiteDatabaseZzh.beginTransaction();
                                    try {
                                        cursorQuery2 = sQLiteDatabaseZzh.query("messages", new String[]{str2}, "type=?", new String[]{"3"}, null, null, JrbhsraGtto.kkDzcDujO, "1");
                                        try {
                                            long j2 = -1;
                                            if (cursorQuery2.moveToFirst()) {
                                                j = cursorQuery2.getLong(0);
                                                cursorQuery2.close();
                                            } else {
                                                cursorQuery2.close();
                                                j = -1;
                                            }
                                            if (j != -1) {
                                                String[] strArr2 = new String[1];
                                                try {
                                                    strArr2[0] = String.valueOf(j);
                                                    str = "rowid<?";
                                                    strArr = strArr2;
                                                } catch (SQLiteDatabaseLockedException unused2) {
                                                    i4 = i4;
                                                    str2 = str2;
                                                    sQLiteDatabase2 = sQLiteDatabaseZzh;
                                                    cursor2 = null;
                                                    SystemClock.sleep(i6);
                                                    i6 += 20;
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (sQLiteDatabase2 != null) {
                                                        sQLiteDatabase2.close();
                                                    }
                                                    i7++;
                                                    zzfrVar2 = zzfrVar2;
                                                    str2 = str2;
                                                    i4 = i4;
                                                    i5 = 5;
                                                }
                                            } else {
                                                str = null;
                                                strArr = null;
                                            }
                                            try {
                                                cursorQuery = sQLiteDatabaseZzh.query("messages", new String[]{str2, "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                                                while (cursorQuery.moveToNext()) {
                                                    try {
                                                        try {
                                                            boolean z = false;
                                                            try {
                                                                j2 = cursorQuery.getLong(0);
                                                                int i8 = cursorQuery.getInt(1);
                                                                str2 = str2;
                                                                try {
                                                                    byte[] blob = cursorQuery.getBlob(2);
                                                                    if (i8 == 0) {
                                                                        Parcel parcelObtain = Parcel.obtain();
                                                                        try {
                                                                            i4 = i4;
                                                                            try {
                                                                                try {
                                                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                                                    parcelObtain.setDataPosition(0);
                                                                                    zzaw zzawVarCreateFromParcel = zzaw.CREATOR.createFromParcel(parcelObtain);
                                                                                    try {
                                                                                        parcelObtain.recycle();
                                                                                        if (zzawVarCreateFromParcel != null) {
                                                                                            arrayList3.add(zzawVarCreateFromParcel);
                                                                                        }
                                                                                    } catch (SQLiteDatabaseLockedException unused3) {
                                                                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                                                                        cursor2 = cursorQuery;
                                                                                        SystemClock.sleep(i6);
                                                                                        i6 += 20;
                                                                                        if (cursor2 != null) {
                                                                                            cursor2.close();
                                                                                        }
                                                                                        if (sQLiteDatabase2 != null) {
                                                                                            sQLiteDatabase2.close();
                                                                                        }
                                                                                        i7++;
                                                                                        zzfrVar2 = zzfrVar2;
                                                                                        str2 = str2;
                                                                                        i4 = i4;
                                                                                        i5 = 5;
                                                                                    } catch (SQLiteFullException e3) {
                                                                                        e = e3;
                                                                                        zzeh zzehVar3 = zzfrVar3.zzm;
                                                                                        zzfr.zzR(zzehVar3);
                                                                                        zzehVar3.zzd.zzb(e, "Error reading entries from local database");
                                                                                        zzeaVarZzi.zzb = true;
                                                                                        if (cursorQuery != null) {
                                                                                            cursorQuery.close();
                                                                                        }
                                                                                        if (sQLiteDatabaseZzh != null) {
                                                                                            sQLiteDatabaseZzh.close();
                                                                                        }
                                                                                        i6 = i6;
                                                                                        i7++;
                                                                                        zzfrVar2 = zzfrVar2;
                                                                                        str2 = str2;
                                                                                        i4 = i4;
                                                                                        i5 = 5;
                                                                                    } catch (SQLiteException e4) {
                                                                                        e = e4;
                                                                                        z = false;
                                                                                        sQLiteDatabase = sQLiteDatabaseZzh;
                                                                                        cursor = cursorQuery;
                                                                                        if (sQLiteDatabase != null) {
                                                                                            if (sQLiteDatabase.inTransaction()) {
                                                                                                sQLiteDatabase.endTransaction();
                                                                                            }
                                                                                        }
                                                                                        zzeh zzehVar4 = zzfrVar3.zzm;
                                                                                        zzfr.zzR(zzehVar4);
                                                                                        zzehVar4.zzd.zzb(e, "Error reading entries from local database");
                                                                                        zzeaVarZzi.zzb = true;
                                                                                        if (cursor != null) {
                                                                                            cursor.close();
                                                                                        }
                                                                                        if (sQLiteDatabase != null) {
                                                                                            sQLiteDatabase.close();
                                                                                        }
                                                                                        zzfrVar2 = zzfrVar2;
                                                                                        i6 = i6;
                                                                                        i6 = i6;
                                                                                        i7++;
                                                                                        zzfrVar2 = zzfrVar2;
                                                                                        str2 = str2;
                                                                                        i4 = i4;
                                                                                        i5 = 5;
                                                                                    }
                                                                                } catch (Throwable th3) {
                                                                                    th = th3;
                                                                                    parcelObtain.recycle();
                                                                                    throw th;
                                                                                }
                                                                            } catch (SafeParcelReader$ParseException unused4) {
                                                                                zzeh zzehVar5 = zzfrVar3.zzm;
                                                                                zzfr.zzR(zzehVar5);
                                                                                zzehVar5.zzd.zza("Failed to load event from local database");
                                                                                parcelObtain.recycle();
                                                                            }
                                                                        } catch (SafeParcelReader$ParseException unused5) {
                                                                            i4 = i4;
                                                                        } catch (Throwable th4) {
                                                                            th = th4;
                                                                        }
                                                                    } else {
                                                                        i4 = i4;
                                                                        if (i8 == 1) {
                                                                            Parcel parcelObtain2 = Parcel.obtain();
                                                                            try {
                                                                                try {
                                                                                    parcelObtain2.unmarshall(blob, 0, blob.length);
                                                                                    parcelObtain2.setDataPosition(0);
                                                                                    zzkwVarCreateFromParcel = zzkw.CREATOR.createFromParcel(parcelObtain2);
                                                                                    parcelObtain2.recycle();
                                                                                } catch (Throwable th5) {
                                                                                    parcelObtain2.recycle();
                                                                                    throw th5;
                                                                                }
                                                                            } catch (SafeParcelReader$ParseException unused6) {
                                                                                zzeh zzehVar6 = zzfrVar3.zzm;
                                                                                zzfr.zzR(zzehVar6);
                                                                                zzehVar6.zzd.zza("Failed to load user property from local database");
                                                                                parcelObtain2.recycle();
                                                                                zzkwVarCreateFromParcel = null;
                                                                            }
                                                                            if (zzkwVarCreateFromParcel != null) {
                                                                                arrayList3.add(zzkwVarCreateFromParcel);
                                                                            }
                                                                        } else if (i8 == 2) {
                                                                            Parcel parcelObtain3 = Parcel.obtain();
                                                                            try {
                                                                                z = false;
                                                                                try {
                                                                                    try {
                                                                                        parcelObtain3.unmarshall(blob, 0, blob.length);
                                                                                        parcelObtain3.setDataPosition(0);
                                                                                        zzacVarCreateFromParcel = zzac.CREATOR.createFromParcel(parcelObtain3);
                                                                                        try {
                                                                                            parcelObtain3.recycle();
                                                                                        } catch (SQLiteDatabaseLockedException unused7) {
                                                                                            sQLiteDatabase2 = sQLiteDatabaseZzh;
                                                                                            cursor2 = cursorQuery;
                                                                                            SystemClock.sleep(i6);
                                                                                            i6 += 20;
                                                                                            if (cursor2 != null) {
                                                                                                cursor2.close();
                                                                                            }
                                                                                            if (sQLiteDatabase2 != null) {
                                                                                                sQLiteDatabase2.close();
                                                                                            }
                                                                                            i7++;
                                                                                            zzfrVar2 = zzfrVar2;
                                                                                            str2 = str2;
                                                                                            i4 = i4;
                                                                                            i5 = 5;
                                                                                        } catch (SQLiteFullException e5) {
                                                                                            e = e5;
                                                                                            zzeh zzehVar7 = zzfrVar3.zzm;
                                                                                            zzfr.zzR(zzehVar7);
                                                                                            zzehVar7.zzd.zzb(e, "Error reading entries from local database");
                                                                                            zzeaVarZzi.zzb = true;
                                                                                            if (cursorQuery != null) {
                                                                                                cursorQuery.close();
                                                                                            }
                                                                                            if (sQLiteDatabaseZzh != null) {
                                                                                                sQLiteDatabaseZzh.close();
                                                                                            }
                                                                                            i6 = i6;
                                                                                            i7++;
                                                                                            zzfrVar2 = zzfrVar2;
                                                                                            str2 = str2;
                                                                                            i4 = i4;
                                                                                            i5 = 5;
                                                                                        } catch (SQLiteException e6) {
                                                                                            e = e6;
                                                                                            sQLiteDatabase = sQLiteDatabaseZzh;
                                                                                            cursor = cursorQuery;
                                                                                            if (sQLiteDatabase != null) {
                                                                                                if (sQLiteDatabase.inTransaction()) {
                                                                                                    sQLiteDatabase.endTransaction();
                                                                                                }
                                                                                            }
                                                                                            zzeh zzehVar8 = zzfrVar3.zzm;
                                                                                            zzfr.zzR(zzehVar8);
                                                                                            zzehVar8.zzd.zzb(e, "Error reading entries from local database");
                                                                                            zzeaVarZzi.zzb = true;
                                                                                            if (cursor != null) {
                                                                                                cursor.close();
                                                                                            }
                                                                                            if (sQLiteDatabase != null) {
                                                                                                sQLiteDatabase.close();
                                                                                            }
                                                                                            zzfrVar2 = zzfrVar2;
                                                                                            i6 = i6;
                                                                                            i6 = i6;
                                                                                            i7++;
                                                                                            zzfrVar2 = zzfrVar2;
                                                                                            str2 = str2;
                                                                                            i4 = i4;
                                                                                            i5 = 5;
                                                                                        }
                                                                                    } catch (Throwable th6) {
                                                                                        th = th6;
                                                                                        parcelObtain3.recycle();
                                                                                        throw th;
                                                                                    }
                                                                                } catch (SafeParcelReader$ParseException unused8) {
                                                                                    zzeh zzehVar9 = zzfrVar3.zzm;
                                                                                    zzfr.zzR(zzehVar9);
                                                                                    zzehVar9.zzd.zza("Failed to load conditional user property from local database");
                                                                                    parcelObtain3.recycle();
                                                                                    zzacVarCreateFromParcel = null;
                                                                                }
                                                                            } catch (SafeParcelReader$ParseException unused9) {
                                                                            } catch (Throwable th7) {
                                                                                th = th7;
                                                                                z = false;
                                                                            }
                                                                            if (zzacVarCreateFromParcel != null) {
                                                                                arrayList3.add(zzacVarCreateFromParcel);
                                                                            }
                                                                        } else if (i8 == 3) {
                                                                            zzeh zzehVar10 = zzfrVar3.zzm;
                                                                            zzfr.zzR(zzehVar10);
                                                                            zzehVar10.zzg.zza("Skipping app launch break");
                                                                        } else {
                                                                            zzeh zzehVar11 = zzfrVar3.zzm;
                                                                            zzfr.zzR(zzehVar11);
                                                                            zzehVar11.zzd.zza("Unknown record type in local database");
                                                                        }
                                                                        str2 = str2;
                                                                        i4 = i4;
                                                                    }
                                                                    str2 = str2;
                                                                    i4 = i4;
                                                                } catch (SQLiteDatabaseLockedException unused10) {
                                                                    i4 = i4;
                                                                } catch (SQLiteFullException e7) {
                                                                    e = e7;
                                                                    i4 = i4;
                                                                } catch (SQLiteException e8) {
                                                                    e = e8;
                                                                    i4 = i4;
                                                                }
                                                            } catch (SQLiteDatabaseLockedException unused11) {
                                                                i4 = i4;
                                                                str2 = str2;
                                                            } catch (SQLiteFullException e9) {
                                                                e = e9;
                                                                i4 = i4;
                                                                str2 = str2;
                                                            } catch (SQLiteException e10) {
                                                                e = e10;
                                                                i4 = i4;
                                                                str2 = str2;
                                                            }
                                                        } catch (SQLiteDatabaseLockedException unused12) {
                                                            i4 = i4;
                                                            str2 = str2;
                                                        } catch (SQLiteFullException e11) {
                                                            e = e11;
                                                            i4 = i4;
                                                            str2 = str2;
                                                        } catch (SQLiteException e12) {
                                                            e = e12;
                                                            i4 = i4;
                                                            str2 = str2;
                                                        }
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        cursor3 = cursorQuery;
                                                    }
                                                }
                                                i = i4;
                                                if (sQLiteDatabaseZzh.delete("messages", "rowid <= ?", new String[]{Long.toString(j2)}) < arrayList3.size()) {
                                                    zzeh zzehVar12 = zzfrVar3.zzm;
                                                    zzfr.zzR(zzehVar12);
                                                    zzehVar12.zzd.zza("Fewer entries removed from local database than expected");
                                                }
                                                sQLiteDatabaseZzh.setTransactionSuccessful();
                                                sQLiteDatabaseZzh.endTransaction();
                                                cursorQuery.close();
                                                sQLiteDatabaseZzh.close();
                                                zzfrVar = zzfrVar2;
                                            } catch (SQLiteFullException e13) {
                                                e = e13;
                                                i4 = i4;
                                                str2 = str2;
                                                cursorQuery = null;
                                                zzeh zzehVar13 = zzfrVar3.zzm;
                                                zzfr.zzR(zzehVar13);
                                                zzehVar13.zzd.zzb(e, "Error reading entries from local database");
                                                zzeaVarZzi.zzb = true;
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                                if (sQLiteDatabaseZzh != null) {
                                                    sQLiteDatabaseZzh.close();
                                                }
                                                i6 = i6;
                                                i7++;
                                                zzfrVar2 = zzfrVar2;
                                                str2 = str2;
                                                i4 = i4;
                                                i5 = 5;
                                            } catch (SQLiteException e14) {
                                                e = e14;
                                                i4 = i4;
                                                str2 = str2;
                                                sQLiteDatabase = sQLiteDatabaseZzh;
                                                cursor = null;
                                                if (sQLiteDatabase != null) {
                                                    if (sQLiteDatabase.inTransaction()) {
                                                        sQLiteDatabase.endTransaction();
                                                    }
                                                }
                                                zzeh zzehVar14 = zzfrVar3.zzm;
                                                zzfr.zzR(zzehVar14);
                                                zzehVar14.zzd.zzb(e, "Error reading entries from local database");
                                                zzeaVarZzi.zzb = true;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                zzfrVar2 = zzfrVar2;
                                                i6 = i6;
                                                i6 = i6;
                                                i7++;
                                                zzfrVar2 = zzfrVar2;
                                                str2 = str2;
                                                i4 = i4;
                                                i5 = 5;
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            if (cursorQuery2 != null) {
                                                try {
                                                    cursorQuery2.close();
                                                } catch (SQLiteDatabaseLockedException unused13) {
                                                    sQLiteDatabase2 = sQLiteDatabaseZzh;
                                                    cursor2 = null;
                                                    SystemClock.sleep(i6);
                                                    i6 += 20;
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (sQLiteDatabase2 != null) {
                                                        sQLiteDatabase2.close();
                                                    }
                                                    i7++;
                                                    zzfrVar2 = zzfrVar2;
                                                    str2 = str2;
                                                    i4 = i4;
                                                    i5 = 5;
                                                } catch (SQLiteFullException e15) {
                                                    e = e15;
                                                    cursorQuery = null;
                                                    zzeh zzehVar15 = zzfrVar3.zzm;
                                                    zzfr.zzR(zzehVar15);
                                                    zzehVar15.zzd.zzb(e, "Error reading entries from local database");
                                                    zzeaVarZzi.zzb = true;
                                                    if (cursorQuery != null) {
                                                        cursorQuery.close();
                                                    }
                                                    if (sQLiteDatabaseZzh != null) {
                                                        sQLiteDatabaseZzh.close();
                                                    }
                                                    i6 = i6;
                                                    i7++;
                                                    zzfrVar2 = zzfrVar2;
                                                    str2 = str2;
                                                    i4 = i4;
                                                    i5 = 5;
                                                } catch (SQLiteException e16) {
                                                    e = e16;
                                                    sQLiteDatabase = sQLiteDatabaseZzh;
                                                    cursor = null;
                                                    if (sQLiteDatabase != null) {
                                                        if (sQLiteDatabase.inTransaction()) {
                                                            sQLiteDatabase.endTransaction();
                                                        }
                                                    }
                                                    zzeh zzehVar16 = zzfrVar3.zzm;
                                                    zzfr.zzR(zzehVar16);
                                                    zzehVar16.zzd.zzb(e, "Error reading entries from local database");
                                                    zzeaVarZzi.zzb = true;
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    if (sQLiteDatabase != null) {
                                                        sQLiteDatabase.close();
                                                    }
                                                    zzfrVar2 = zzfrVar2;
                                                    i6 = i6;
                                                    i6 = i6;
                                                    i7++;
                                                    zzfrVar2 = zzfrVar2;
                                                    str2 = str2;
                                                    i4 = i4;
                                                    i5 = 5;
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        cursorQuery2 = null;
                                    }
                                }
                                th = th2;
                            } catch (SQLiteDatabaseLockedException unused14) {
                                i4 = i4;
                                str2 = str2;
                                cursor2 = null;
                                sQLiteDatabase2 = null;
                            } catch (SQLiteFullException e17) {
                                e = e17;
                                i4 = i4;
                                str2 = str2;
                                cursorQuery = null;
                                sQLiteDatabaseZzh = null;
                            } catch (SQLiteException e18) {
                                e = e18;
                                i4 = i4;
                                str2 = str2;
                                cursor = null;
                                sQLiteDatabase = null;
                            } catch (Throwable th11) {
                                th = th11;
                                sQLiteDatabaseZzh = null;
                            }
                            cursor3 = null;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (sQLiteDatabaseZzh != null) {
                                sQLiteDatabaseZzh.close();
                            }
                            throw th;
                        }
                        zzfrVar = zzfrVar2;
                        i = i4;
                        zzeh zzehVar17 = zzfrVar3.zzm;
                        zzfr.zzR(zzehVar17);
                        zzehVar17.zzg.zza(jIKWv.gNThHKkF);
                        arrayList = null;
                        i7++;
                        zzfrVar2 = zzfrVar2;
                        str2 = str2;
                        i4 = i4;
                        i5 = 5;
                    }
                } else {
                    zzfrVar = zzfrVar2;
                    i = i4;
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
                size = arrayList.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList2.add(abstractSafeParcelable);
            }
            int size2 = arrayList2.size();
            int i9 = 0;
            while (i9 < size2) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList2.get(i9);
                boolean z2 = abstractSafeParcelable2 instanceof zzaw;
                zzfr zzfrVar4 = zzfrVar;
                zzeh zzehVar18 = zzfrVar4.zzm;
                if (z2) {
                    try {
                        zzdxVar.zzk((zzaw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e19) {
                        zzfr.zzR(zzehVar18);
                        zzehVar18.zzd.zzb(e19, "Failed to send event to the service");
                    }
                } else if (abstractSafeParcelable2 instanceof zzkw) {
                    try {
                        zzdxVar.zzt((zzkw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e20) {
                        zzfr.zzR(zzehVar18);
                        zzehVar18.zzd.zzb(e20, "Failed to send user property to the service");
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzdxVar.zzn((zzac) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e21) {
                        zzfr.zzR(zzehVar18);
                        zzehVar18.zzd.zzb(e21, "Failed to send conditional user property to the service");
                    }
                } else {
                    zzfr.zzR(zzehVar18);
                    zzehVar18.zzd.zza("Discarding data. Unrecognized parcel type.");
                }
                i9++;
                zzfrVar = zzfrVar4;
            }
            i4 = i + 1;
            i3 = size;
            i2 = 100;
            zzfrVar2 = zzfrVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x016f  */
    /* JADX WARN: Code duplicated, block: B:6:0x0024  */
    public final zzq zzO(boolean z) {
        String strM;
        long jZzp;
        long j;
        String str;
        String str2;
        List list;
        String str3;
        long jAbs;
        Pair pair;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.getClass();
        zzdy zzdyVarZzh = zzfrVar.zzh();
        if (z) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzfr zzfrVar2 = (zzfr) zzehVar.mBuilder;
            zzew zzewVar = zzfrVar2.zzl;
            zzfr.zzP(zzewVar);
            if (zzewVar.zzb == null) {
                strM = null;
            } else {
                zzew zzewVar2 = zzfrVar2.zzl;
                zzfr.zzP(zzewVar2);
                zzeu zzeuVar = zzewVar2.zzb;
                zzew zzewVar3 = (zzew) zzeuVar.zzb;
                zzewVar3.zzg();
                zzewVar3.zzg();
                long j2 = ((zzew) zzeuVar.zzb).zza().getLong((String) zzeuVar.zza, 0L);
                if (j2 == 0) {
                    zzeuVar.zzd();
                    jAbs = 0;
                } else {
                    ((zzfr) zzewVar3.mBuilder).zzr.getClass();
                    jAbs = Math.abs(j2 - System.currentTimeMillis());
                }
                long j3 = zzeuVar.zze;
                if (jAbs < j3) {
                    pair = null;
                } else if (jAbs > j3 + j3) {
                    zzeuVar.zzd();
                    pair = null;
                } else {
                    String string = zzewVar3.zza().getString((String) zzeuVar.zzd, null);
                    long j4 = zzewVar3.zza().getLong((String) zzeuVar.zzc, 0L);
                    zzeuVar.zzd();
                    pair = (string == null || j4 <= 0) ? zzew.zza : new Pair(string, Long.valueOf(j4));
                }
                if (pair == null || pair == zzew.zza) {
                    strM = null;
                } else {
                    strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(String.valueOf(pair.second), ":", (String) pair.first);
                }
            }
        } else {
            strM = null;
        }
        zzdyVarZzh.zzg();
        String strZzl = zzdyVarZzh.zzl();
        String strZzm = zzdyVarZzh.zzm();
        zzdyVarZzh.zza();
        String str4 = zzdyVarZzh.zzb;
        zzdyVarZzh.zza();
        long j5 = zzdyVarZzh.zzc;
        zzdyVarZzh.zza();
        com.google.android.gms.common.internal.zzah.checkNotNull(zzdyVarZzh.zzd);
        String str5 = zzdyVarZzh.zzd;
        zzfr zzfrVar3 = (zzfr) zzdyVarZzh.mBuilder;
        zzfrVar3.zzk.zzh();
        zzdyVarZzh.zza();
        zzdyVarZzh.zzg();
        long j6 = zzdyVarZzh.zzf;
        zzlb zzlbVar = zzfrVar3.zzp;
        Context context = zzfrVar3.zze;
        if (j6 == 0) {
            zzfr.zzP(zzlbVar);
            String packageName = context.getPackageName();
            zzlbVar.zzg();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(packageName);
            PackageManager packageManager = context.getPackageManager();
            MessageDigest messageDigestZzF = zzlb.zzF();
            zzfr zzfrVar4 = (zzfr) zzlbVar.mBuilder;
            if (messageDigestZzF == null) {
                zzeh zzehVar2 = zzfrVar4.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zza("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (zzlbVar.zzag(context, packageName)) {
                            jZzp = 0;
                        } else {
                            Signature[] signatureArr = Wrappers.packageManager(context).getPackageInfo(64, zzfrVar4.zze.getPackageName()).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                zzeh zzehVar3 = zzfrVar4.zzm;
                                zzfr.zzR(zzehVar3);
                                zzehVar3.zzg.zza("Could not get signatures");
                            } else {
                                jZzp = zzlb.zzp(messageDigestZzF.digest(signatureArr[0].toByteArray()));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        zzeh zzehVar4 = zzfrVar4.zzm;
                        zzfr.zzR(zzehVar4);
                        zzehVar4.zzd.zzb(e, "Package name not found");
                    }
                } else {
                    jZzp = 0;
                }
                zzdyVarZzh.zzf = jZzp;
            }
            jZzp = -1;
            zzdyVarZzh.zzf = jZzp;
        } else {
            jZzp = j6;
        }
        boolean zZzJ = zzfrVar3.zzJ();
        zzew zzewVar4 = zzfrVar3.zzl;
        zzfr.zzP(zzewVar4);
        boolean z2 = !zzewVar4.zzl;
        zzdyVarZzh.zzg();
        boolean zZzJ2 = zzfrVar3.zzJ();
        zzag zzagVar = zzfrVar3.zzk;
        if (zZzJ2) {
            zzpj.zzc();
            boolean zZzs = zzagVar.zzs(null, zzdu.zzaa);
            zzeh zzehVar5 = zzfrVar3.zzm;
            if (zZzs) {
                zzfr.zzR(zzehVar5);
                zzehVar5.zzl.zza("Disabled IID for tests.");
                j = jZzp;
                str = str5;
                str2 = null;
            } else {
                try {
                    j = jZzp;
                    try {
                        Class<?> clsLoadClass = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                        if (clsLoadClass == null) {
                            str = str5;
                        } else {
                            try {
                                str = str5;
                                try {
                                    Object objInvoke = clsLoadClass.getDeclaredMethod(yzwzcWHcnH.VRr, Context.class).invoke(null, context);
                                    if (objInvoke == null) {
                                        str2 = null;
                                    } else {
                                        try {
                                            str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                                        } catch (Exception unused) {
                                            zzfr.zzR(zzehVar5);
                                            zzehVar5.zzi.zza("Failed to retrieve Firebase Instance Id");
                                            str2 = null;
                                        }
                                    }
                                } catch (Exception unused2) {
                                    zzfr.zzR(zzehVar5);
                                    zzehVar5.zzh.zza("Failed to obtain Firebase Analytics instance");
                                }
                            } catch (Exception unused3) {
                                str = str5;
                            }
                        }
                    } catch (ClassNotFoundException unused4) {
                    }
                } catch (ClassNotFoundException unused5) {
                    j = jZzp;
                }
                str2 = null;
            }
        } else {
            j = jZzp;
            str = str5;
            str2 = null;
        }
        String str6 = str2;
        long jZza = zzewVar4.zzc.zza();
        long j7 = zzfrVar3.zzc;
        long jMin = jZza == 0 ? j7 : Math.min(j7, jZza);
        zzdyVarZzh.zza();
        int i = zzdyVarZzh.zzj;
        Boolean boolZzk = zzagVar.zzk("google_analytics_adid_collection_enabled");
        boolean z3 = boolZzk == null || boolZzk.booleanValue();
        zzewVar4.zzg();
        boolean z4 = zzewVar4.zza().getBoolean("deferred_analytics_collection", false);
        zzdyVarZzh.zza();
        String str7 = zzdyVarZzh.zzl;
        Boolean boolZzk2 = zzagVar.zzk("google_analytics_default_allow_ad_personalization_signals");
        Boolean boolValueOf = boolZzk2 == null ? null : Boolean.valueOf(!boolZzk2.booleanValue());
        List list2 = zzdyVarZzh.zzh;
        String strZzh = zzewVar4.zzc().zzh();
        if (zzdyVarZzh.zzi == null) {
            if (zzagVar.zzs(null, zzdu.zzap)) {
                zzfr.zzP(zzlbVar);
                byte[] bArr = new byte[16];
                zzlbVar.zzG().nextBytes(bArr);
                zzdyVarZzh.zzi = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
            } else {
                zzdyVarZzh.zzi = "";
            }
        }
        String str8 = zzdyVarZzh.zzi;
        zzpd.zzc();
        if (zzagVar.zzs(null, zzdu.zzam)) {
            zzdyVarZzh.zzg();
            if (zzdyVarZzh.zzn == 0) {
                list = list2;
            } else {
                zzfrVar3.zzr.getClass();
                list = list2;
                long jCurrentTimeMillis = System.currentTimeMillis() - zzdyVarZzh.zzn;
                if (zzdyVarZzh.zzm != null && jCurrentTimeMillis > 86400000 && zzdyVarZzh.zzo == null) {
                    zzdyVarZzh.zzo();
                }
            }
            if (zzdyVarZzh.zzm == null) {
                zzdyVarZzh.zzo();
            }
            str3 = zzdyVarZzh.zzm;
        } else {
            list = list2;
            str3 = null;
        }
        return new zzq(strZzl, strZzm, str4, j5, str, 74029L, j, strM, zZzJ, z2, str6, jMin, i, z3, z4, str7, boolValueOf, zzdyVarZzh.zzg, list, strZzh, str8, str3);
    }
}
