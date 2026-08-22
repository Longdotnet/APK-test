package okhttp3.internal.connection;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzen;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes3.dex */
public final class RealConnectionPool {
    public final /* synthetic */ int $r8$classId = 2;
    public Object cleanupQueue;
    public Object cleanupTask;
    public final Object connections;
    public long keepAliveDurationNs;

    public static RealConnectionPool zzb(zzaw zzawVar) {
        Bundle bundleZzc = zzawVar.zzb.zzc();
        long j = zzawVar.zzd;
        return new RealConnectionPool(zzawVar.zza, zzawVar.zzc, bundleZzc, j);
    }

    public boolean callAcquirePooledConnection(Address address, RealCall call, List list, boolean z) {
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator it = ((ConcurrentLinkedQueue) this.connections).iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            RealConnection connection = (RealConnection) it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (z) {
                    if (!(connection.http2Connection != null)) {
                    }
                }
                if (connection.isEligible$okhttp(address, list)) {
                    call.acquireConnectionNoEvents(connection);
                    return true;
                }
            }
        }
    }

    public int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = realConnection.calls;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + realConnection.route.address.url + " was leaked. Did you forget to close a response body?";
                Platform platform = Platform.platform;
                Platform.platform.logCloseableLeak(((RealCall.CallReference) reference).callStackTrace, str);
                arrayList.remove(i);
                realConnection.noNewExchanges = true;
                if (arrayList.isEmpty()) {
                    realConnection.idleAtNs = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    /* JADX WARN: Code duplicated, block: B:72:0x01d0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v15 */
    public zzft zza(zzft zzftVar, String str) throws Throwable {
        ?? r2;
        Cursor cursorRawQuery;
        Pair pairCreate;
        Object obj;
        String strZzh = zzftVar.zzh();
        List listZzi = zzftVar.zzi();
        zzaa zzaaVar = (zzaa) this.connections;
        zzaaVar.zzf.zzu();
        Long l = (Long) zzen.zzC(zzftVar, "_eid");
        if (l != null) {
            boolean zEquals = strZzh.equals("_ep");
            Object obj2 = zzaaVar.mBuilder;
            zzfr zzfrVar = (zzfr) obj2;
            zzkt zzktVar = zzaaVar.zzf;
            if (zEquals) {
                zzktVar.zzu();
                String str2 = (String) zzen.zzC(zzftVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zze.zzb(l, "Extra parameter without an event name. eventId");
                    return null;
                }
                if (((zzft) this.cleanupQueue) == null || ((Long) this.cleanupTask) == null || l.longValue() != ((Long) this.cleanupTask).longValue()) {
                    zzam zzamVar = zzktVar.zze;
                    zzkt.zzal(zzamVar);
                    zzfr zzfrVar2 = (zzfr) zzamVar.mBuilder;
                    zzamVar.zzg();
                    zzamVar.zzW();
                    try {
                        try {
                            cursorRawQuery = zzamVar.zzh().rawQuery(CyjpdoedCdLTIO.lcNh, new String[]{str, l.toString()});
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    try {
                                        pairCreate = Pair.create((zzft) ((zzfs) zzen.zzl(zzft.zze(), cursorRawQuery.getBlob(0))).zzaC(), Long.valueOf(cursorRawQuery.getLong(1)));
                                        cursorRawQuery.close();
                                    } catch (IOException e) {
                                        zzeh zzehVar2 = zzfrVar2.zzm;
                                        zzfr.zzR(zzehVar2);
                                        zzehVar2.zzd.zzd("Failed to merge main event. appId, eventId", zzeh.zzn(str), l, e);
                                        cursorRawQuery.close();
                                        pairCreate = null;
                                    }
                                } else {
                                    zzeh zzehVar3 = zzfrVar2.zzm;
                                    zzfr.zzR(zzehVar3);
                                    zzehVar3.zzl.zza("Main event not found");
                                    cursorRawQuery.close();
                                    pairCreate = null;
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                zzeh zzehVar4 = zzfrVar2.zzm;
                                zzfr.zzR(zzehVar4);
                                zzehVar4.zzd.zzb(e, "Error selecting main event");
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                pairCreate = null;
                                if (pairCreate != null) {
                                }
                                zzeh zzehVar5 = zzfrVar.zzm;
                                zzfr.zzR(zzehVar5);
                                zzehVar5.zze.zzc(str2, "Extra parameter without existing main event. eventName, eventId", l);
                                return null;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            cursorRawQuery = null;
                        } catch (Throwable th) {
                            th = th;
                            r2 = 0;
                            if (r2 != 0) {
                                r2.close();
                            }
                            throw th;
                        }
                        if (pairCreate != null || (obj = pairCreate.first) == null) {
                            zzeh zzehVar6 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar6);
                            zzehVar6.zze.zzc(str2, "Extra parameter without existing main event. eventName, eventId", l);
                            return null;
                        }
                        this.cleanupQueue = (zzft) obj;
                        this.keepAliveDurationNs = ((Long) pairCreate.second).longValue();
                        zzktVar.zzu();
                        this.cleanupTask = (Long) zzen.zzC((zzft) this.cleanupQueue, "_eid");
                    } catch (Throwable th2) {
                        th = th2;
                        r2 = obj2;
                        if (r2 != 0) {
                            r2.close();
                        }
                        throw th;
                    }
                }
                long j = this.keepAliveDurationNs - 1;
                this.keepAliveDurationNs = j;
                if (j <= 0) {
                    zzam zzamVar2 = zzktVar.zze;
                    zzkt.zzal(zzamVar2);
                    zzamVar2.zzg();
                    zzfr zzfrVar3 = (zzfr) zzamVar2.mBuilder;
                    zzeh zzehVar7 = zzfrVar3.zzm;
                    zzfr.zzR(zzehVar7);
                    zzehVar7.zzl.zzb(str, TSDAbK.iFDPdeky);
                    try {
                        zzamVar2.zzh().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e4) {
                        zzeh zzehVar8 = zzfrVar3.zzm;
                        zzfr.zzR(zzehVar8);
                        zzehVar8.zzd.zzb(e4, "Error clearing complex main event");
                    }
                } else {
                    zzam zzamVar3 = zzktVar.zze;
                    zzkt.zzal(zzamVar3);
                    zzamVar3.zzJ(str, l, this.keepAliveDurationNs, (zzft) this.cleanupQueue);
                }
                ArrayList arrayList = new ArrayList();
                for (zzfx zzfxVar : ((zzft) this.cleanupQueue).zzi()) {
                    zzktVar.zzu();
                    if (zzen.zzB(zzftVar, zzfxVar.zzg()) == null) {
                        arrayList.add(zzfxVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    zzeh zzehVar9 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar9);
                    zzehVar9.zze.zzb(str2, "No unique parameters in main event. eventName");
                } else {
                    arrayList.addAll(listZzi);
                    listZzi = arrayList;
                }
                strZzh = str2;
            } else {
                this.cleanupTask = l;
                this.cleanupQueue = zzftVar;
                zzktVar.zzu();
                Serializable serializableZzC = zzen.zzC(zzftVar, "_epc");
                long jLongValue = ((Long) (serializableZzC != null ? serializableZzC : 0L)).longValue();
                this.keepAliveDurationNs = jLongValue;
                if (jLongValue <= 0) {
                    zzeh zzehVar10 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar10);
                    zzehVar10.zze.zzb(strZzh, "Complex event with zero extra param count. eventName");
                } else {
                    zzam zzamVar4 = zzktVar.zze;
                    zzkt.zzal(zzamVar4);
                    zzamVar4.zzJ(str, l, this.keepAliveDurationNs, zzftVar);
                }
            }
        }
        zzfs zzfsVar = (zzfs) zzftVar.zzby();
        zzfsVar.zzi(strZzh);
        zzfsVar.zzg();
        zzfsVar.zzd(listZzi);
        return (zzft) zzfsVar.zzaC();
    }

    public RealConnectionPool(String str, String str2, Bundle bundle, long j) {
        this.cleanupQueue = str;
        this.cleanupTask = str2;
        this.connections = bundle;
        this.keepAliveDurationNs = j;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                String string = ((Bundle) this.connections).toString();
                StringBuilder sb = new StringBuilder("origin=");
                sb.append((String) this.cleanupTask);
                sb.append(GsPcpBmONXh.eTV);
                return Fragment$$ExternalSyntheticOutline0.m(sb, (String) this.cleanupQueue, ",params=", string);
            default:
                return super.toString();
        }
    }

    public RealConnectionPool(TaskRunner taskRunner, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.keepAliveDurationNs = timeUnit.toNanos(5L);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new TaskQueue$execute$1(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(), Util.okHttpName, " ConnectionPool"), 1, this);
        this.connections = new ConcurrentLinkedQueue();
    }

    public zzaw zza() {
        return new zzaw((String) this.cleanupQueue, new zzau(new Bundle((Bundle) this.connections)), (String) this.cleanupTask, this.keepAliveDurationNs);
    }
}
