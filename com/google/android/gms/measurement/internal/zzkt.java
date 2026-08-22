package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.Service;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.work.impl.WorkDatabase;
import com.android.billingclient.api.zzbc;
import com.android.billingclient.api.zzn;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.facebook.login.vu.dLDI;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.inject.PVS.jIKWv;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkt implements zzgm {
    public static volatile zzkt zzb;
    public final HashMap zzB;
    public final HashMap zzC;
    public zzie zzD;
    public String zzE;
    public long zza;
    public final zzfi zzc;
    public final zzen zzd;
    public zzam zze;
    public zzn zzf;
    public zzkf zzg;
    public zzaa zzh;
    public final zzen zzi;
    public zzen zzj;
    public zzjo zzk;
    public zzs zzm;
    public final zzfr zzn;
    public boolean zzp;
    public ArrayList zzq;
    public int zzr;
    public int zzs;
    public boolean zzt;
    public boolean zzu;
    public boolean zzv;
    public FileLock zzw;
    public FileChannel zzx;
    public ArrayList zzy;
    public ArrayList zzz;
    public boolean zzo = false;
    public final AccessTokenCache zzF = new AccessTokenCache(this, 26);
    public long zzA = -1;
    public final zzki zzl = new zzki(this);

    public zzkt(WorkDatabase.AnonymousClass1 anonymousClass1) {
        this.zzn = zzfr.zzp(anonymousClass1.val$context, null, null);
        zzen zzenVar = new zzen(this, 2);
        zzenVar.zzX();
        this.zzi = zzenVar;
        zzen zzenVar2 = new zzen(this, 0);
        zzenVar2.zzX();
        this.zzd = zzenVar2;
        zzfi zzfiVar = new zzfi(this);
        zzfiVar.zzX();
        this.zzc = zzfiVar;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new com.google.android.gms.tasks.zzg(this, anonymousClass1));
    }

    public static final void zzaa(zzfs zzfsVar, int i, String str) {
        List listZzp = zzfsVar.zzp();
        for (int i2 = 0; i2 < listZzp.size(); i2++) {
            if ("_err".equals(((zzfx) listZzp.get(i2)).zzg())) {
                return;
            }
        }
        zzfw zzfwVarZze = zzfx.zze();
        zzfwVarZze.zzj("_err");
        zzfwVarZze.zzi(i);
        zzfx zzfxVar = (zzfx) zzfwVarZze.zzaC();
        zzfw zzfwVarZze2 = zzfx.zze();
        zzfwVarZze2.zzj("_ev");
        zzfwVarZze2.zzk(str);
        zzfx zzfxVar2 = (zzfx) zzfwVarZze2.zzaC();
        zzfsVar.zzf(zzfxVar);
        zzfsVar.zzf(zzfxVar2);
    }

    public static final void zzab(zzfs zzfsVar, String str) {
        List listZzp = zzfsVar.zzp();
        for (int i = 0; i < listZzp.size(); i++) {
            if (str.equals(((zzfx) listZzp.get(i)).zzg())) {
                zzfsVar.zzh(i);
                return;
            }
        }
    }

    public static final boolean zzak(zzq zzqVar) {
        return (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) ? false : true;
    }

    public static final void zzal(zzkh zzkhVar) {
        if (zzkhVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (!zzkhVar.zza) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzkhVar.getClass())));
        }
    }

    public static zzkt zzt(Service service) {
        com.google.android.gms.common.internal.zzah.checkNotNull(service);
        com.google.android.gms.common.internal.zzah.checkNotNull(service.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkt.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzkt(new WorkDatabase.AnonymousClass1(service));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzb;
    }

    public final void zzA$1() {
        zzaz().zzg();
        zzB$1();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        zzfr zzfrVar = this.zzn;
        if (fileLock == null || !fileLock.isValid()) {
            ((zzfr) this.zze.mBuilder).getClass();
            try {
                FileChannel channel = new RandomAccessFile(new File(zzfrVar.zze.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.zzw = fileLockTryLock;
                if (fileLockTryLock == null) {
                    zzay().zzd.zza("Storage concurrent data access panic");
                    return;
                }
                zzay().zzl.zza("Storage concurrent access okay");
            } catch (FileNotFoundException e) {
                zzay().zzd.zzb(e, "Failed to acquire storage lock");
                return;
            } catch (IOException e2) {
                zzay().zzd.zzb(e2, "Failed to access storage lock file");
                return;
            } catch (OverlappingFileLockException e3) {
                zzay().zzg.zzb(e3, "Storage lock already acquired");
                return;
            }
        } else {
            zzay().zzl.zza("Storage concurrent access okay");
        }
        FileChannel fileChannel = this.zzx;
        zzaz().zzg();
        int i = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzay().zzd.zza("Bad channel to read from");
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i2 = fileChannel.read(byteBufferAllocate);
                if (i2 == 4) {
                    byteBufferAllocate.flip();
                    i = byteBufferAllocate.getInt();
                } else if (i2 != -1) {
                    zzay().zzg.zzb(Integer.valueOf(i2), "Unexpected data length. Bytes read");
                }
            } catch (IOException e4) {
                zzay().zzd.zzb(e4, "Failed to read from channel");
            }
        }
        zzdy zzdyVarZzh = zzfrVar.zzh();
        zzdyVarZzh.zza();
        int i3 = zzdyVarZzh.zzc;
        zzaz().zzg();
        if (i > i3) {
            zzeh zzehVarZzay = zzay();
            zzehVarZzay.zzd.zzc(Integer.valueOf(i), "Panic: can't downgrade version. Previous, current version", Integer.valueOf(i3));
            return;
        }
        if (i < i3) {
            FileChannel fileChannel2 = this.zzx;
            zzaz().zzg();
            if (fileChannel2 == null || !fileChannel2.isOpen()) {
                zzay().zzd.zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                byteBufferAllocate2.putInt(i3);
                byteBufferAllocate2.flip();
                try {
                    fileChannel2.truncate(0L);
                    fileChannel2.write(byteBufferAllocate2);
                    fileChannel2.force(true);
                    if (fileChannel2.size() != 4) {
                        zzay().zzd.zzb(Long.valueOf(fileChannel2.size()), "Error writing to channel. Bytes written");
                    }
                    zzeh zzehVarZzay2 = zzay();
                    zzehVarZzay2.zzl.zzc(Integer.valueOf(i), "Storage version upgraded. Previous, current version", Integer.valueOf(i3));
                    return;
                } catch (IOException e5) {
                    zzay().zzd.zzb(e5, "Failed to write to channel");
                }
            }
            zzeh zzehVarZzay3 = zzay();
            zzehVarZzay3.zzd.zzc(Integer.valueOf(i), "Storage version upgrade failed. Previous, current version", Integer.valueOf(i3));
        }
    }

    public final void zzB$1() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x012e  */
    public final void zzC(zzgc zzgcVar, String str) {
        int iZza;
        int iIndexOf;
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        zzfiVar.zzg();
        zzfiVar.zzC(str);
        ArrayMap arrayMap = zzfiVar.zza;
        Set set = (Set) arrayMap.getOrDefault(str, null);
        if (set != null) {
            zzgcVar.zzi(set);
        }
        zzal(zzfiVar);
        zzfiVar.zzg();
        zzfiVar.zzC(str);
        if (arrayMap.getOrDefault(str, null) != null && (((Set) arrayMap.getOrDefault(str, null)).contains("device_model") || ((Set) arrayMap.getOrDefault(str, null)).contains("device_info"))) {
            zzgcVar.zzp();
        }
        zzal(zzfiVar);
        zzfiVar.zzg();
        zzfiVar.zzC(str);
        if (arrayMap.getOrDefault(str, null) != null && (((Set) arrayMap.getOrDefault(str, null)).contains("os_version") || ((Set) arrayMap.getOrDefault(str, null)).contains("device_info"))) {
            if (zzg().zzs(str, zzdu.zzaq)) {
                String strZzar = zzgcVar.zzar();
                if (!TextUtils.isEmpty(strZzar) && (iIndexOf = strZzar.indexOf(".")) != -1) {
                    zzgcVar.zzY(strZzar.substring(0, iIndexOf));
                }
            } else {
                zzgcVar.zzu();
            }
        }
        zzal(zzfiVar);
        zzfiVar.zzg();
        zzfiVar.zzC(str);
        if (arrayMap.getOrDefault(str, null) != null && ((Set) arrayMap.getOrDefault(str, null)).contains("user_id") && (iZza = zzen.zza(zzgcVar, "_id")) != -1) {
            zzgcVar.zzB(iZza);
        }
        zzal(zzfiVar);
        zzfiVar.zzg();
        zzfiVar.zzC(str);
        if (arrayMap.getOrDefault(str, null) != null && ((Set) arrayMap.getOrDefault(str, null)).contains("google_signals")) {
            zzgcVar.zzq();
        }
        zzal(zzfiVar);
        zzfiVar.zzg();
        zzfiVar.zzC(str);
        if (arrayMap.getOrDefault(str, null) != null && ((Set) arrayMap.getOrDefault(str, null)).contains("app_instance_id")) {
            zzgcVar.zzn();
            HashMap map = this.zzC;
            zzks zzksVar = (zzks) map.get(str);
            if (zzksVar != null) {
                long jZzi = zzg().zzi(str, zzdu.zzR) + zzksVar.zzb;
                ((DefaultClock) zzav()).getClass();
                if (jZzi < SystemClock.elapsedRealtime()) {
                    byte[] bArr = new byte[16];
                    zzv().zzG().nextBytes(bArr);
                    zzksVar = new zzks(this, String.format(Locale.US, "%032x", new BigInteger(1, bArr)));
                    map.put(str, zzksVar);
                }
            } else {
                byte[] bArr2 = new byte[16];
                zzv().zzG().nextBytes(bArr2);
                zzksVar = new zzks(this, String.format(Locale.US, "%032x", new BigInteger(1, bArr2)));
                map.put(str, zzksVar);
            }
            zzgcVar.zzR(zzksVar.zza);
        }
        zzal(zzfiVar);
        zzfiVar.zzg();
        zzfiVar.zzC(str);
        if (arrayMap.getOrDefault(str, null) == null || !((Set) arrayMap.getOrDefault(str, null)).contains("enhanced_user_id")) {
            return;
        }
        zzgcVar.zzy();
    }

    public final void zzE(zzaw zzawVar, zzq zzqVar) {
        List listZzt;
        zzfr zzfrVar;
        List<zzac> listZzt2;
        List listZzt3;
        String str;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzqVar);
        String str2 = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        zzaz().zzg();
        zzB$1();
        RealConnectionPool realConnectionPoolZzb = RealConnectionPool.zzb(zzawVar);
        zzaz().zzg();
        zzie zzieVar = null;
        if (this.zzD != null && (str = this.zzE) != null && str.equals(str2)) {
            zzieVar = this.zzD;
        }
        zzlb.zzK(zzieVar, (Bundle) realConnectionPoolZzb.connections, false);
        zzaw zzawVarZza = realConnectionPoolZzb.zza();
        zzal(this.zzi);
        if (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) {
            return;
        }
        if (!zzqVar.zzh) {
            zzd(zzqVar);
            return;
        }
        List list = zzqVar.zzt;
        if (list != null) {
            String str3 = zzawVarZza.zza;
            if (!list.contains(str3)) {
                zzay().zzk.zzd("Dropping non-safelisted event. appId, event name, origin", str2, str3, zzawVarZza.zzc);
                return;
            } else {
                Bundle bundleZzc = zzawVarZza.zzb.zzc();
                bundleZzc.putLong("ga_safelisted", 1L);
                zzawVarZza = new zzaw(zzawVarZza.zza, new zzau(bundleZzc), zzawVarZza.zzc, zzawVarZza.zzd);
            }
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzw();
        try {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
            zzamVar2.zzg();
            zzamVar2.zzW();
            long j = zzawVar.zzd;
            if (j < 0) {
                zzeh zzehVar = ((zzfr) zzamVar2.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzc(zzeh.zzn(str2), "Invalid time querying timed out conditional properties", Long.valueOf(j));
                listZzt = Collections.emptyList();
            } else {
                listZzt = zzamVar2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
            }
            Iterator it = listZzt.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                zzfrVar = this.zzn;
                if (!zHasNext) {
                    break;
                }
                zzac zzacVar = (zzac) it.next();
                if (zzacVar != null) {
                    zzay().zzl.zzd("User property timed out", zzacVar.zza, zzfrVar.zzq.zzf(zzacVar.zzc.zzb), zzacVar.zzc.zza());
                    zzaw zzawVar2 = zzacVar.zzg;
                    if (zzawVar2 != null) {
                        zzY(new zzaw(zzawVar2, j), zzqVar);
                    }
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzamVar3.zza(str2, zzacVar.zzc.zzb);
                }
            }
            zzam zzamVar4 = this.zze;
            zzal(zzamVar4);
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
            zzamVar4.zzg();
            zzamVar4.zzW();
            if (j < 0) {
                zzeh zzehVar2 = ((zzfr) zzamVar4.mBuilder).zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzg.zzc(zzeh.zzn(str2), "Invalid time querying expired conditional properties", Long.valueOf(j));
                listZzt2 = Collections.emptyList();
            } else {
                listZzt2 = zzamVar4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
            }
            ArrayList arrayList = new ArrayList(listZzt2.size());
            for (zzac zzacVar2 : listZzt2) {
                if (zzacVar2 != null) {
                    zzay().zzl.zzd("User property expired", zzacVar2.zza, zzfrVar.zzq.zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                    zzam zzamVar5 = this.zze;
                    zzal(zzamVar5);
                    zzamVar5.zzA(str2, zzacVar2.zzc.zzb);
                    zzaw zzawVar3 = zzacVar2.zzk;
                    if (zzawVar3 != null) {
                        arrayList.add(zzawVar3);
                    }
                    zzam zzamVar6 = this.zze;
                    zzal(zzamVar6);
                    zzamVar6.zza(str2, zzacVar2.zzc.zzb);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                zzY(new zzaw((zzaw) it2.next(), j), zzqVar);
            }
            zzam zzamVar7 = this.zze;
            zzal(zzamVar7);
            zzfr zzfrVar2 = (zzfr) zzamVar7.mBuilder;
            String str4 = zzawVarZza.zza;
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str4);
            zzamVar7.zzg();
            zzamVar7.zzW();
            if (j < 0) {
                zzeh zzehVar3 = zzfrVar2.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzg.zzd("Invalid time querying triggered conditional properties", zzeh.zzn(str2), zzfrVar2.zzq.zzd(str4), Long.valueOf(j));
                listZzt3 = Collections.emptyList();
            } else {
                listZzt3 = zzamVar7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j)});
            }
            ArrayList arrayList2 = new ArrayList(listZzt3.size());
            Iterator it3 = listZzt3.iterator();
            while (it3.hasNext()) {
                zzac zzacVar3 = (zzac) it3.next();
                if (zzacVar3 != null) {
                    zzkw zzkwVar = zzacVar3.zzc;
                    String str5 = zzacVar3.zza;
                    com.google.android.gms.common.internal.zzah.checkNotNull(str5);
                    String str6 = zzacVar3.zzb;
                    String str7 = zzkwVar.zzb;
                    Object objZza = zzkwVar.zza();
                    com.google.android.gms.common.internal.zzah.checkNotNull(objZza);
                    Iterator it4 = it3;
                    long j2 = j;
                    long j3 = j;
                    zzfr zzfrVar3 = zzfrVar;
                    zzky zzkyVar = new zzky(str5, str6, str7, j2, objZza);
                    Object obj = zzkyVar.zze;
                    String str8 = zzkyVar.zzc;
                    zzam zzamVar8 = this.zze;
                    zzal(zzamVar8);
                    if (zzamVar8.zzL(zzkyVar)) {
                        zzay().zzl.zzd("User property triggered", zzacVar3.zza, zzfrVar3.zzq.zzf(str8), obj);
                    } else {
                        zzay().zzd.zzd("Too many active user properties, ignoring", zzeh.zzn(zzacVar3.zza), zzfrVar3.zzq.zzf(str8), obj);
                    }
                    zzaw zzawVar4 = zzacVar3.zzi;
                    if (zzawVar4 != null) {
                        arrayList2.add(zzawVar4);
                    }
                    zzacVar3.zzc = new zzkw(zzkyVar);
                    zzacVar3.zze = true;
                    zzam zzamVar9 = this.zze;
                    zzal(zzamVar9);
                    zzamVar9.zzK(zzacVar3);
                    it3 = it4;
                    zzfrVar = zzfrVar3;
                    j = j3;
                }
            }
            long j4 = j;
            zzY(zzawVarZza, zzqVar);
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                long j5 = j4;
                zzY(new zzaw((zzaw) it5.next(), j5), zzqVar);
                j4 = j5;
            }
            zzam zzamVar10 = this.zze;
            zzal(zzamVar10);
            zzamVar10.zzC();
        } finally {
            zzam zzamVar11 = this.zze;
            zzal(zzamVar11);
            zzamVar11.zzx();
        }
    }

    public final void zzF(zzaw zzawVar, String str) throws Throwable {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(str);
        if (zzhVarZzj == null || TextUtils.isEmpty(zzhVarZzj.zzw())) {
            zzay().zzk.zzb(str, "No app data available; dropping event");
            return;
        }
        Boolean boolZzad = zzad(zzhVarZzj);
        if (boolZzad == null) {
            if (!"_ui".equals(zzawVar.zza)) {
                zzeh zzehVarZzay = zzay();
                zzehVarZzay.zzg.zzb(zzeh.zzn(str), "Could not find package. appId");
            }
        } else if (!boolZzad.booleanValue()) {
            zzeh zzehVarZzay2 = zzay();
            zzehVarZzay2.zzd.zzb(zzeh.zzn(str), "App version does not match; dropping event. appId");
            return;
        }
        String strZzy = zzhVarZzj.zzy();
        String strZzw = zzhVarZzj.zzw();
        long jZzb = zzhVarZzj.zzb();
        zzfr zzfrVar = zzhVarZzj.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        String str2 = zzhVarZzj.zzl;
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzg();
        long j = zzhVarZzj.zzm;
        zzfo zzfoVar3 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar3);
        zzfoVar3.zzg();
        long j2 = zzhVarZzj.zzn;
        zzfo zzfoVar4 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar4);
        zzfoVar4.zzg();
        boolean z = zzhVarZzj.zzo;
        String strZzx = zzhVarZzj.zzx();
        zzfo zzfoVar5 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar5);
        zzfoVar5.zzg();
        boolean zZzah = zzhVarZzj.zzah();
        String strZzr = zzhVarZzj.zzr();
        zzfo zzfoVar6 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar6);
        zzfoVar6.zzg();
        Boolean bool = zzhVarZzj.zzr;
        long jZzk = zzhVarZzj.zzk();
        zzfo zzfoVar7 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar7);
        zzfoVar7.zzg();
        zzG(zzawVar, new zzq(str, strZzy, strZzw, jZzb, str2, j, j2, null, z, false, strZzx, 0L, 0, zZzah, false, strZzr, bool, jZzk, zzhVarZzj.zzt, zzh(str).zzh(), "", null));
    }

    /* JADX WARN: Code duplicated, block: B:46:0x011f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0131  */
    /* JADX WARN: Code duplicated, block: B:50:0x013f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0154  */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00d1: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:210), block:B:35:0x00d1 */
    public final void zzG(zzaw zzawVar, zzq zzqVar) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzaw zzawVarZza;
        zzau zzauVar;
        String string;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(zzqVar.zza);
        RealConnectionPool realConnectionPoolZzb = RealConnectionPool.zzb(zzawVar);
        zzlb zzlbVarZzv = zzv();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        String str = zzqVar.zza;
        zzfr zzfrVar = (zzfr) zzamVar.mBuilder;
        zzamVar.zzg();
        zzamVar.zzW();
        Cursor cursor2 = null;
        bundle = null;
        Bundle bundle = null;
        try {
            try {
                cursorRawQuery = zzamVar.zzh().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        try {
                            zzft zzftVar = (zzft) ((zzfs) zzen.zzl(zzft.zze(), cursorRawQuery.getBlob(0))).zzaC();
                            zzamVar.zzf.zzu();
                            List<zzfx> listZzi = zzftVar.zzi();
                            Bundle bundle2 = new Bundle();
                            for (zzfx zzfxVar : listZzi) {
                                String strZzg = zzfxVar.zzg();
                                if (zzfxVar.zzu()) {
                                    bundle2.putDouble(strZzg, zzfxVar.zza());
                                } else if (zzfxVar.zzv()) {
                                    bundle2.putFloat(strZzg, zzfxVar.zzb());
                                } else if (zzfxVar.zzy()) {
                                    bundle2.putString(strZzg, zzfxVar.zzh());
                                } else if (zzfxVar.zzw()) {
                                    bundle2.putLong(strZzg, zzfxVar.zzd());
                                }
                            }
                            cursorRawQuery.close();
                            bundle = bundle2;
                        } catch (IOException e) {
                            zzeh zzehVar = zzfrVar.zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzc(zzeh.zzn(str), "Failed to retrieve default event parameters. appId", e);
                            cursorRawQuery.close();
                        }
                        zzlbVarZzv.zzL((Bundle) realConnectionPoolZzb.connections, bundle);
                        zzlb zzlbVarZzv2 = zzv();
                        zzag zzagVarZzg = zzg();
                        zzagVarZzg.getClass();
                        zzlbVarZzv2.zzM(realConnectionPoolZzb, Math.max(Math.min(zzagVarZzg.zze(str, zzdu.zzH), 100), 25));
                        zzawVarZza = realConnectionPoolZzb.zza();
                        if ("_cmp".equals(zzawVarZza.zza)) {
                            zzauVar = zzawVarZza.zzb;
                            if ("referrer API v2".equals(zzauVar.zza.getString("_cis"))) {
                                string = zzauVar.zza.getString("gclid");
                                if (!TextUtils.isEmpty(string)) {
                                    zzW(new zzkw(zzawVarZza.zzd, string, "_lgclid", "auto"), zzqVar);
                                }
                            }
                        }
                        zzE(zzawVarZza, zzqVar);
                    }
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzl.zza("Default event parameters not found");
                } catch (SQLiteException e2) {
                    e = e2;
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzb(e, "Error selecting default event parameters");
                    if (cursorRawQuery != null) {
                    }
                    zzlbVarZzv.zzL((Bundle) realConnectionPoolZzb.connections, bundle);
                    zzlb zzlbVarZzv3 = zzv();
                    zzag zzagVarZzg2 = zzg();
                    zzagVarZzg2.getClass();
                    zzlbVarZzv3.zzM(realConnectionPoolZzb, Math.max(Math.min(zzagVarZzg2.zze(str, zzdu.zzH), 100), 25));
                    zzawVarZza = realConnectionPoolZzb.zza();
                    if ("_cmp".equals(zzawVarZza.zza)) {
                        zzauVar = zzawVarZza.zzb;
                        if ("referrer API v2".equals(zzauVar.zza.getString("_cis"))) {
                            string = zzauVar.zza.getString("gclid");
                            if (!TextUtils.isEmpty(string)) {
                                zzW(new zzkw(zzawVarZza.zzd, string, "_lgclid", "auto"), zzqVar);
                            }
                        }
                    }
                    zzE(zzawVarZza, zzqVar);
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            cursorRawQuery.close();
            zzlbVarZzv.zzL((Bundle) realConnectionPoolZzb.connections, bundle);
            zzlb zzlbVarZzv4 = zzv();
            zzag zzagVarZzg3 = zzg();
            zzagVarZzg3.getClass();
            zzlbVarZzv4.zzM(realConnectionPoolZzb, Math.max(Math.min(zzagVarZzg3.zze(str, zzdu.zzH), 100), 25));
            zzawVarZza = realConnectionPoolZzb.zza();
            if ("_cmp".equals(zzawVarZza.zza)) {
                zzauVar = zzawVarZza.zzb;
                if ("referrer API v2".equals(zzauVar.zza.getString("_cis"))) {
                    string = zzauVar.zza.getString("gclid");
                    if (!TextUtils.isEmpty(string)) {
                        zzW(new zzkw(zzawVarZza.zzd, string, "_lgclid", "auto"), zzqVar);
                    }
                }
            }
            zzE(zzawVarZza, zzqVar);
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0045 A[PHI: r11
  0x0045: PHI (r11v12 int) = (r11v2 int), (r11v0 int) binds: [B:15:0x0047, B:12:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:16:0x0049  */
    /* JADX WARN: Code duplicated, block: B:49:0x0117  */
    public final void zzI(String str, int i, IOException iOException, byte[] bArr, Map map) {
        boolean z;
        String str2;
        zzaz().zzg();
        zzB$1();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th) {
                this.zzt = false;
                zzae();
                throw th;
            }
        }
        zzef zzefVar = zzay().zzl;
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzefVar.zzb(numValueOf, "onConfigFetched. Response size");
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzw();
        try {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzh zzhVarZzj = zzamVar2.zzj(str);
            if (i == 200 || i == 204) {
                if (iOException == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (i == 304) {
                i = 304;
                if (iOException == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (zzhVarZzj == null) {
                zzay().zzg.zzb(zzeh.zzn(str), "App does not exist in onConfigFetched. appId");
            } else {
                zzfi zzfiVar = this.zzc;
                if (z || i == 404) {
                    List list = map != null ? (List) map.get("Last-Modified") : null;
                    String str3 = (list == null || list.isEmpty()) ? null : (String) list.get(0);
                    zzox.zzc();
                    if (zzg().zzs(null, zzdu.zzao)) {
                        List list2 = map != null ? (List) map.get("ETag") : null;
                        if (list2 == null || list2.isEmpty()) {
                            str2 = null;
                        } else {
                            str2 = (String) list2.get(0);
                        }
                    } else {
                        str2 = null;
                    }
                    if (i == 404 || i == 304) {
                        zzal(zzfiVar);
                        if (zzfiVar.zze(str) == null) {
                            zzal(zzfiVar);
                            zzfiVar.zzt(str, null, null, null);
                        }
                    } else {
                        zzal(zzfiVar);
                        zzfiVar.zzt(str, str3, str2, bArr);
                    }
                    ((DefaultClock) zzav()).getClass();
                    zzhVarZzj.zzL(System.currentTimeMillis());
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzamVar3.zzD(zzhVarZzj);
                    if (i == 404) {
                        zzay().zzi.zzb(str, "Config not found. Using empty config. appId");
                    } else {
                        zzay().zzl.zzc(Integer.valueOf(i), "Successfully fetched config. Got network response. code, size", numValueOf);
                    }
                    zzen zzenVar = this.zzd;
                    zzal(zzenVar);
                    if (zzenVar.zza() && zzai()) {
                        zzX();
                    } else {
                        zzag();
                    }
                } else {
                    ((DefaultClock) zzav()).getClass();
                    zzhVarZzj.zzU(System.currentTimeMillis());
                    zzam zzamVar4 = this.zze;
                    zzal(zzamVar4);
                    zzamVar4.zzD(zzhVarZzj);
                    zzay().zzl.zzc(Integer.valueOf(i), "Fetching config failed. code, error", iOException);
                    zzal(zzfiVar);
                    zzfiVar.zzg();
                    zzfiVar.zzk.put(str, null);
                    zzes zzesVar = this.zzk.zzd;
                    ((DefaultClock) zzav()).getClass();
                    zzesVar.zzb(System.currentTimeMillis());
                    if (i == 503 || i == 429) {
                        zzes zzesVar2 = this.zzk.zzb;
                        ((DefaultClock) zzav()).getClass();
                        zzesVar2.zzb(System.currentTimeMillis());
                    }
                    zzag();
                }
            }
            zzam zzamVar5 = this.zze;
            zzal(zzamVar5);
            zzamVar5.zzC();
            zzam zzamVar6 = this.zze;
            zzal(zzamVar6);
            zzamVar6.zzx();
            this.zzt = false;
            zzae();
        } catch (Throwable th2) {
            zzam zzamVar7 = this.zze;
            zzal(zzamVar7);
            zzamVar7.zzx();
            throw th2;
        }
    }

    public final void zzP(zzkw zzkwVar, zzq zzqVar) {
        Boolean bool;
        zzaz().zzg();
        zzB$1();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            if ("_npa".equals(zzkwVar.zzb) && (bool = zzqVar.zzr) != null) {
                zzay().zzk.zza("Falling back to manifest metadata value for ad personalization");
                ((DefaultClock) zzav()).getClass();
                zzW(new zzkw(System.currentTimeMillis(), Long.valueOf(true != bool.booleanValue() ? 0L : 1L), "_npa", "auto"), zzqVar);
                return;
            }
            zzeh zzehVarZzay = zzay();
            zzfr zzfrVar = this.zzn;
            zzec zzecVar = zzfrVar.zzq;
            String str = zzkwVar.zzb;
            zzehVarZzay.zzk.zzb(zzecVar.zzf(str), "Removing user property");
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                boolean zEquals = "_id".equals(str);
                String str2 = zzqVar.zza;
                if (zEquals) {
                    zzam zzamVar2 = this.zze;
                    zzal(zzamVar2);
                    com.google.android.gms.common.internal.zzah.checkNotNull(str2);
                    zzamVar2.zzA(str2, "_lair");
                }
                zzam zzamVar3 = this.zze;
                zzal(zzamVar3);
                com.google.android.gms.common.internal.zzah.checkNotNull(str2);
                zzamVar3.zzA(str2, str);
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzamVar4.zzC();
                zzay().zzk.zzb(zzfrVar.zzq.zzf(str), "User property removed");
            } finally {
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzx();
            }
        }
    }

    public final void zzQ(zzq zzqVar) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzfr zzfrVar = (zzfr) zzamVar.mBuilder;
        String str = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzamVar.zzg();
        zzamVar.zzW();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzamVar.zzh();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zzc(str, "Reset analytics data. app, records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), "Error resetting analytics data. appId, error", e);
        }
        if (zzqVar.zzh) {
            zzL(zzqVar);
        }
    }

    public final void zzV(String str, zzai zzaiVar) {
        zzaz().zzg();
        zzB$1();
        this.zzB.put(str, zzaiVar);
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzfr zzfrVar = (zzfr) zzamVar.mBuilder;
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        zzamVar.zzg();
        zzamVar.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzaiVar.zzh());
        try {
            if (zzamVar.zzh().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(zzeh.zzn(str), "Failed to insert/update consent setting (got -1). appId");
            }
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), "Error storing consent setting. appId, error", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0212 A[Catch: all -> 0x022f, SQLiteException -> 0x0232, TryCatch #11 {all -> 0x022f, blocks: (B:79:0x01a3, B:81:0x01a9, B:86:0x01b9, B:87:0x01bf, B:88:0x01c3, B:89:0x01ce, B:91:0x01e1, B:93:0x01e5, B:95:0x01eb, B:96:0x01f5, B:98:0x01fb, B:102:0x0201, B:104:0x020c, B:106:0x0212, B:107:0x0219, B:132:0x0285, B:114:0x0235, B:119:0x024c, B:147:0x02a9, B:125:0x025b, B:126:0x026c, B:131:0x0274), top: B:279:0x0179 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0249  */
    /* JADX WARN: Code duplicated, block: B:134:0x028b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:152:0x02c9 A[Catch: all -> 0x029b, TRY_LEAVE, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02d5 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x02df A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:167:0x0302 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0316 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:170:0x0317 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0345 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0351  */
    /* JADX WARN: Code duplicated, block: B:182:0x0374 A[Catch: all -> 0x029b, TRY_LEAVE, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0382  */
    /* JADX WARN: Code duplicated, block: B:189:0x0388 A[Catch: all -> 0x029b, TRY_ENTER, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x03be A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x03c3 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x03cb A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x03d3 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x03e2 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x0411 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x041f  */
    /* JADX WARN: Code duplicated, block: B:209:0x0440 A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x0476 A[Catch: all -> 0x029b, TRY_LEAVE, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0492 A[Catch: all -> 0x029b, MalformedURLException -> 0x04fa, TryCatch #13 {MalformedURLException -> 0x04fa, blocks: (B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0), top: B:282:0x0480, outer: #18 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x04a0 A[Catch: all -> 0x029b, MalformedURLException -> 0x04fa, TryCatch #13 {MalformedURLException -> 0x04fa, blocks: (B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0), top: B:282:0x0480, outer: #18 }] */
    /* JADX WARN: Code duplicated, block: B:219:0x04b4 A[Catch: all -> 0x029b, MalformedURLException -> 0x04fa, TryCatch #13 {MalformedURLException -> 0x04fa, blocks: (B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0), top: B:282:0x0480, outer: #18 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x058a A[Catch: all -> 0x029b, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:257:0x0595 A[Catch: all -> 0x029b, TRY_LEAVE, TryCatch #18 {all -> 0x029b, blocks: (B:3:0x0014, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0093, B:34:0x00c8, B:38:0x00e9, B:40:0x00fa, B:67:0x0145, B:69:0x0166, B:73:0x0171, B:77:0x0179, B:150:0x02c3, B:152:0x02c9, B:154:0x02cf, B:156:0x02d5, B:157:0x02d9, B:159:0x02df, B:161:0x02f3, B:165:0x02fc, B:167:0x0302, B:173:0x0327, B:170:0x0317, B:172:0x0321, B:174:0x032a, B:176:0x0345, B:180:0x0352, B:182:0x0374, B:189:0x0388, B:191:0x03be, B:193:0x03c3, B:195:0x03cb, B:196:0x03ce, B:198:0x03d3, B:199:0x03d6, B:201:0x03e2, B:202:0x03f6, B:203:0x03ff, B:205:0x0411, B:207:0x0420, B:209:0x0440, B:213:0x0480, B:215:0x0492, B:217:0x04a9, B:219:0x04b4, B:220:0x04bd, B:216:0x04a0, B:222:0x04fa, B:211:0x0476, B:137:0x0296, B:149:0x02c0, B:224:0x050e, B:225:0x0511, B:226:0x0512, B:228:0x051d, B:233:0x0559, B:253:0x0584, B:255:0x058a, B:257:0x0595, B:241:0x0567, B:261:0x05a0, B:262:0x05a3), top: B:285:0x0014, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:296:0x02f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:? A[LOOP:1: B:157:0x02d9->B:298:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x03ff A[EDGE_INSN: B:303:0x03ff->B:203:0x03ff BREAK  A[LOOP:3: B:187:0x0384->B:202:0x03f6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x03f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:306:0x0296 A[ADDED_TO_REGION, EDGE_INSN: B:306:0x0296->B:137:0x0296 BREAK  A[LOOP:4: B:87:0x01bf->B:136:0x028e], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:0x01eb A[EDGE_INSN: B:310:0x01eb->B:95:0x01eb BREAK  A[LOOP:5: B:280:0x01e5->B:120:0x024f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0141 A[Catch: all -> 0x0034, TryCatch #14 {all -> 0x0034, blocks: (B:5:0x0021, B:13:0x003e, B:18:0x0056, B:22:0x0067, B:26:0x0080, B:31:0x00bf, B:37:0x00d4, B:43:0x0100, B:47:0x0115, B:63:0x013c, B:65:0x0141, B:66:0x0144, B:82:0x01ad), top: B:284:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:71:0x016e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0170  */
    /* JADX WARN: Code duplicated, block: B:75:0x0176  */
    /* JADX WARN: Code duplicated, block: B:76:0x0178  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a9 A[Catch: SQLiteException -> 0x01b4, all -> 0x022f, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x01b4, blocks: (B:79:0x01a3, B:81:0x01a9, B:86:0x01b9, B:87:0x01bf, B:88:0x01c3, B:89:0x01ce, B:91:0x01e1), top: B:265:0x01a3 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01b9 A[Catch: SQLiteException -> 0x01b4, all -> 0x022f, TRY_ENTER, TryCatch #0 {SQLiteException -> 0x01b4, blocks: (B:79:0x01a3, B:81:0x01a9, B:86:0x01b9, B:87:0x01bf, B:88:0x01c3, B:89:0x01ce, B:91:0x01e1), top: B:265:0x01a3 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:209:0x0440, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v3 */
    public final void zzX() throws Throwable {
        boolean z;
        ?? r10;
        Cursor cursorRawQuery;
        String string;
        zzh zzhVarZzj;
        int iZze;
        int iMax;
        zzam zzamVar;
        boolean z2;
        boolean z3;
        zzen zzenVar;
        Cursor cursorQuery;
        List listEmptyList;
        zzai zzaiVarZzh;
        zzah zzahVar;
        zzga zzgaVarZza;
        int size;
        ArrayList arrayList;
        boolean z4;
        boolean zZzi;
        boolean zZzi2;
        boolean z5;
        int i;
        zzen zzenVar2;
        ArrayList arrayList2;
        String strZzm;
        String strZzi;
        String string2;
        String str;
        zzgc zzgcVar;
        Iterator it;
        String strZzJ;
        int i2;
        zzgd zzgdVar;
        zzgd zzgdVar2;
        ArrayList arrayList3;
        int length;
        long j;
        zzam zzamVar2;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i3;
        byte[] byteArray;
        zzgc zzgcVar2;
        Cursor cursorRawQuery2;
        zzen zzenVar3 = this.zzd;
        zzfr zzfrVar = this.zzn;
        zzaz().zzg();
        zzB$1();
        int i4 = 1;
        this.zzv = true;
        int i5 = 0;
        try {
            zzfrVar.getClass();
            Boolean boolZzj = zzfrVar.zzt().zzj();
            try {
                if (boolZzj == null) {
                    zzay().zzk().zza("Upload data called on the client side before use of service was decided");
                    this.zzv = false;
                } else if (boolZzj.booleanValue()) {
                    zzay().zzd().zza("Upload called in the client side when service should be used");
                    this.zzv = false;
                } else if (this.zza > 0) {
                    zzag();
                    this.zzv = false;
                } else {
                    zzaz().zzg();
                    if (this.zzy != null) {
                        zzay().zzj().zza("Uploading requested multiple times");
                        this.zzv = false;
                    } else {
                        zzal(zzenVar3);
                        if (zzenVar3.zza()) {
                            ((DefaultClock) zzav()).getClass();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            Cursor cursor = null;
                            int iZze2 = zzg().zze(null, zzdu.zzP);
                            zzg();
                            long jLongValue = jCurrentTimeMillis - ((Long) zzdu.zzc.zza(null)).longValue();
                            for (int i6 = 0; i6 < iZze2 && zzah(jLongValue); i6++) {
                            }
                            long jZza = this.zzk.zzc.zza();
                            if (jZza != 0) {
                                zzay().zzk.zzb(Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)), "Uploading events. Elapsed time since last upload attempt (ms)");
                            }
                            zzam zzamVar3 = this.zze;
                            zzal(zzamVar3);
                            String strZzr = zzamVar3.zzr();
                            long j2 = -1;
                            if (TextUtils.isEmpty(strZzr)) {
                                this.zzA = -1L;
                                zzam zzamVar4 = this.zze;
                                zzal(zzamVar4);
                                zzfr zzfrVar2 = (zzfr) zzamVar4.mBuilder;
                                try {
                                    zzg();
                                    long jLongValue2 = jCurrentTimeMillis - ((Long) zzdu.zzc.zza(null)).longValue();
                                    zzamVar4.zzg();
                                    zzamVar4.zzW();
                                    try {
                                        cursorRawQuery = zzamVar4.zzh().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jLongValue2)});
                                        try {
                                            if (cursorRawQuery.moveToFirst()) {
                                                string = cursorRawQuery.getString(0);
                                                cursorRawQuery.close();
                                            } else {
                                                zzfrVar2.zzay().zzj().zza("No expired configs for apps with pending events");
                                                cursorRawQuery.close();
                                                string = null;
                                            }
                                        } catch (SQLiteException e) {
                                            e = e;
                                            zzfrVar2.zzay().zzd().zzb(e, "Error selecting expired configs");
                                            if (cursorRawQuery != null) {
                                            }
                                            string = null;
                                            if (!TextUtils.isEmpty(string)) {
                                                zzam zzamVar5 = this.zze;
                                                zzal(zzamVar5);
                                                zzhVarZzj = zzamVar5.zzj(string);
                                                if (zzhVarZzj != null) {
                                                    zzD(zzhVarZzj);
                                                }
                                            }
                                            this.zzv = false;
                                            zzae();
                                        }
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        cursorRawQuery = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        r10 = 0;
                                        if (r10 != 0) {
                                            r10.close();
                                        }
                                        throw th;
                                    }
                                    if (!TextUtils.isEmpty(string)) {
                                        zzam zzamVar6 = this.zze;
                                        zzal(zzamVar6);
                                        zzhVarZzj = zzamVar6.zzj(string);
                                        if (zzhVarZzj != null) {
                                            zzD(zzhVarZzj);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    r10 = zzenVar3;
                                }
                            } else {
                                if (this.zzA == -1) {
                                    zzam zzamVar7 = this.zze;
                                    zzal(zzamVar7);
                                    try {
                                        cursorRawQuery2 = zzamVar7.zzh().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                        try {
                                            try {
                                                if (cursorRawQuery2.moveToFirst()) {
                                                    j2 = cursorRawQuery2.getLong(0);
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                cursor = cursorRawQuery2;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                throw th;
                                            }
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            ((zzfr) zzamVar7.mBuilder).zzay().zzd().zzb(e, "Error querying raw events");
                                            if (cursorRawQuery2 != null) {
                                            }
                                            this.zzA = j2;
                                            iZze = zzg().zze(strZzr, zzdu.zzf);
                                            iMax = Math.max(0, zzg().zze(strZzr, zzdu.zzg));
                                            zzamVar = this.zze;
                                            zzal(zzamVar);
                                            zzfr zzfrVar3 = (zzfr) zzamVar.mBuilder;
                                            zzamVar.zzg();
                                            zzamVar.zzW();
                                            if (iZze > 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            com.google.android.gms.common.internal.zzah.checkArgument(z2);
                                            if (iMax > 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            com.google.android.gms.common.internal.zzah.checkArgument(z3);
                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzr);
                                            try {
                                                cursorQuery = zzamVar.zzh().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze));
                                                if (cursorQuery.moveToFirst()) {
                                                    arrayList3 = new ArrayList();
                                                    length = 0;
                                                    while (true) {
                                                        j = cursorQuery.getLong(i5);
                                                        try {
                                                            byte[] blob = cursorQuery.getBlob(i4);
                                                            zzen zzenVar4 = zzamVar.zzf.zzi;
                                                            zzal(zzenVar4);
                                                            try {
                                                                byteArrayInputStream = new ByteArrayInputStream(blob);
                                                                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                                                byteArrayOutputStream = new ByteArrayOutputStream();
                                                                zzamVar2 = zzamVar;
                                                                try {
                                                                    bArr = new byte[1024];
                                                                    zzenVar = zzenVar3;
                                                                    while (true) {
                                                                        try {
                                                                            try {
                                                                                i3 = gZIPInputStream.read(bArr);
                                                                                if (i3 <= 0) {
                                                                                    break;
                                                                                }
                                                                                ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                                                                                byteArrayOutputStream.write(bArr, 0, i3);
                                                                                byteArrayInputStream = byteArrayInputStream2;
                                                                            } catch (SQLiteException e4) {
                                                                                e = e4;
                                                                                zzfrVar3.zzay().zzd().zzc(zzeh.zzn(strZzr), "Error querying bundles. appId", e);
                                                                                listEmptyList = Collections.emptyList();
                                                                                if (cursorQuery != null) {
                                                                                    cursorQuery.close();
                                                                                }
                                                                            }
                                                                        } catch (IOException e5) {
                                                                            e = e5;
                                                                            try {
                                                                                ((zzfr) zzenVar4.mBuilder).zzay().zzd().zzb(e, "Failed to ungzip content");
                                                                                throw e;
                                                                            } catch (IOException e6) {
                                                                                e = e6;
                                                                                zzfrVar3.zzay().zzd().zzc(zzeh.zzn(strZzr), "Failed to unzip queued bundle. appId", e);
                                                                                if (cursorQuery.moveToNext()) {
                                                                                    break;
                                                                                } else {
                                                                                    break;
                                                                                }
                                                                                cursorQuery.close();
                                                                                listEmptyList = arrayList3;
                                                                                if (!listEmptyList.isEmpty()) {
                                                                                    zzaiVarZzh = zzh(strZzr);
                                                                                    zzahVar = zzah.AD_STORAGE;
                                                                                    if (zzaiVarZzh.zzi(zzahVar)) {
                                                                                        it = listEmptyList.iterator();
                                                                                        while (true) {
                                                                                            if (!it.hasNext()) {
                                                                                                strZzJ = null;
                                                                                                break;
                                                                                            }
                                                                                            zzgdVar2 = (zzgd) ((Pair) it.next()).first;
                                                                                            if (!zzgdVar2.zzJ().isEmpty()) {
                                                                                                strZzJ = zzgdVar2.zzJ();
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        if (strZzJ != null) {
                                                                                            for (i2 = 0; i2 < listEmptyList.size(); i2++) {
                                                                                                zzgdVar = (zzgd) ((Pair) listEmptyList.get(i2)).first;
                                                                                                if (zzgdVar.zzJ().isEmpty()) {
                                                                                                    listEmptyList = listEmptyList.subList(0, i2);
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    zzgaVarZza = zzgb.zza();
                                                                                    size = listEmptyList.size();
                                                                                    arrayList = new ArrayList(listEmptyList.size());
                                                                                    if (zzg().zzt(strZzr)) {
                                                                                        z4 = false;
                                                                                    } else {
                                                                                        z4 = false;
                                                                                    }
                                                                                    zZzi = zzh(strZzr).zzi(zzahVar);
                                                                                    zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                                                    zzpd.zzc();
                                                                                    if (zzg().zzs(null, zzdu.zzal)) {
                                                                                        z5 = false;
                                                                                    } else {
                                                                                        z5 = false;
                                                                                    }
                                                                                    i = 0;
                                                                                    while (true) {
                                                                                        zzenVar2 = this.zzi;
                                                                                        if (i >= size) {
                                                                                            break;
                                                                                        }
                                                                                        zzgcVar = (zzgc) ((zzgd) ((Pair) listEmptyList.get(i)).first).zzby();
                                                                                        arrayList.add((Long) ((Pair) listEmptyList.get(i)).second);
                                                                                        zzg().zzh();
                                                                                        int i7 = size;
                                                                                        ArrayList arrayList4 = arrayList;
                                                                                        zzgcVar.zzal(74029L);
                                                                                        zzgcVar.zzak(jCurrentTimeMillis);
                                                                                        zzgcVar.zzag(false);
                                                                                        if (!z4) {
                                                                                            zzgcVar.zzq();
                                                                                        }
                                                                                        if (!zZzi) {
                                                                                            zzgcVar.zzx();
                                                                                            zzgcVar.zzt();
                                                                                        }
                                                                                        if (!zZzi2) {
                                                                                            zzgcVar.zzn();
                                                                                        }
                                                                                        zzC(zzgcVar, strZzr);
                                                                                        if (!z5) {
                                                                                            zzgcVar.zzy();
                                                                                        }
                                                                                        if (zzg().zzs(strZzr, zzdu.zzT)) {
                                                                                            byte[] bArrZzbu = ((zzgd) zzgcVar.zzaC()).zzbu();
                                                                                            zzal(zzenVar2);
                                                                                            zzgcVar.zzJ(zzenVar2.zzd(bArrZzbu));
                                                                                        }
                                                                                        zzgaVarZza.zza(zzgcVar);
                                                                                        i++;
                                                                                        size = i7;
                                                                                        arrayList = arrayList4;
                                                                                    }
                                                                                    int i8 = size;
                                                                                    arrayList2 = arrayList;
                                                                                    if (Log.isLoggable(zzay().zzq(), 2)) {
                                                                                        zzal(zzenVar2);
                                                                                        strZzm = zzenVar2.zzm((zzgb) zzgaVarZza.zzaC());
                                                                                    } else {
                                                                                        strZzm = null;
                                                                                    }
                                                                                    zzal(zzenVar2);
                                                                                    byte[] bArrZzbu2 = ((zzgb) zzgaVarZza.zzaC()).zzbu();
                                                                                    zzfi zzfiVar = this.zzl.zzf.zzc;
                                                                                    zzal(zzfiVar);
                                                                                    strZzi = zzfiVar.zzi(strZzr);
                                                                                    if (TextUtils.isEmpty(strZzi)) {
                                                                                        string2 = (String) zzdu.zzp.zza(null);
                                                                                    } else {
                                                                                        Uri uri = Uri.parse((String) zzdu.zzp.zza(null));
                                                                                        Uri.Builder builderBuildUpon = uri.buildUpon();
                                                                                        builderBuildUpon.authority(strZzi + "." + uri.getAuthority());
                                                                                        string2 = builderBuildUpon.build().toString();
                                                                                    }
                                                                                    str = string2;
                                                                                    try {
                                                                                        URL url = new URL(str);
                                                                                        com.google.android.gms.common.internal.zzah.checkArgument(!arrayList2.isEmpty());
                                                                                        if (this.zzy != null) {
                                                                                            zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                                                        } else {
                                                                                            this.zzy = new ArrayList(arrayList2);
                                                                                        }
                                                                                        this.zzk.zzd.zzb(jCurrentTimeMillis);
                                                                                        zzay().zzj().zzd("Uploading data. app, uncompressed size, data", i8 > 0 ? zzgaVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbu2.length), strZzm);
                                                                                        this.zzu = true;
                                                                                        zzal(zzenVar);
                                                                                        Fragment.AnonymousClass7 anonymousClass7 = new Fragment.AnonymousClass7(this, strZzr);
                                                                                        zzenVar.zzg();
                                                                                        zzenVar.zzW();
                                                                                        zzen zzenVar5 = zzenVar;
                                                                                        ((zzfr) zzenVar5.mBuilder).zzaz().zzo(new zzem(zzenVar5, strZzr, url, bArrZzbu2, null, anonymousClass7));
                                                                                    } catch (MalformedURLException unused) {
                                                                                        zzay().zzd().zzc(zzeh.zzn(strZzr), "Failed to parse upload URL. Not uploading. appId", str);
                                                                                    }
                                                                                }
                                                                                this.zzv = false;
                                                                                zzae();
                                                                            }
                                                                        }
                                                                    }
                                                                    gZIPInputStream.close();
                                                                    byteArrayInputStream.close();
                                                                    byteArray = byteArrayOutputStream.toByteArray();
                                                                    if (arrayList3.isEmpty()) {
                                                                    }
                                                                    try {
                                                                        zzgcVar2 = (zzgc) zzen.zzl(zzgd.zzt(), byteArray);
                                                                        if (!cursorQuery.isNull(2)) {
                                                                            zzgcVar2.zzaf(cursorQuery.getInt(2));
                                                                        }
                                                                        length += byteArray.length;
                                                                        arrayList3.add(Pair.create((zzgd) zzgcVar2.zzaC(), Long.valueOf(j)));
                                                                    } catch (IOException e7) {
                                                                        zzfrVar3.zzay().zzd().zzc(zzeh.zzn(strZzr), "Failed to merge queued bundle. appId", e7);
                                                                    }
                                                                    if (cursorQuery.moveToNext()) {
                                                                        break;
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    zzamVar = zzamVar2;
                                                                    zzenVar3 = zzenVar;
                                                                    i4 = 1;
                                                                    i5 = 0;
                                                                } catch (IOException e8) {
                                                                    e = e8;
                                                                    zzenVar = zzenVar3;
                                                                }
                                                            } catch (IOException e9) {
                                                                e = e9;
                                                                zzenVar = zzenVar3;
                                                                zzamVar2 = zzamVar;
                                                            }
                                                        } catch (IOException e10) {
                                                            e = e10;
                                                            zzenVar = zzenVar3;
                                                            zzamVar2 = zzamVar;
                                                        }
                                                    }
                                                    cursorQuery.close();
                                                    listEmptyList = arrayList3;
                                                } else {
                                                    listEmptyList = Collections.emptyList();
                                                    cursorQuery.close();
                                                    zzenVar = zzenVar3;
                                                }
                                            } catch (SQLiteException e11) {
                                                e = e11;
                                                zzenVar = zzenVar3;
                                                cursorQuery = null;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                cursor = null;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                throw th;
                                            }
                                            if (!listEmptyList.isEmpty()) {
                                                zzaiVarZzh = zzh(strZzr);
                                                zzahVar = zzah.AD_STORAGE;
                                                if (zzaiVarZzh.zzi(zzahVar)) {
                                                    it = listEmptyList.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            strZzJ = null;
                                                            break;
                                                        }
                                                        zzgdVar2 = (zzgd) ((Pair) it.next()).first;
                                                        if (!zzgdVar2.zzJ().isEmpty()) {
                                                            strZzJ = zzgdVar2.zzJ();
                                                            break;
                                                        }
                                                    }
                                                    if (strZzJ != null) {
                                                        while (i2 < listEmptyList.size()) {
                                                            zzgdVar = (zzgd) ((Pair) listEmptyList.get(i2)).first;
                                                            if (zzgdVar.zzJ().isEmpty()) {
                                                                listEmptyList = listEmptyList.subList(0, i2);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                zzgaVarZza = zzgb.zza();
                                                size = listEmptyList.size();
                                                arrayList = new ArrayList(listEmptyList.size());
                                                if (zzg().zzt(strZzr)) {
                                                    z4 = false;
                                                } else {
                                                    z4 = false;
                                                }
                                                zZzi = zzh(strZzr).zzi(zzahVar);
                                                zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                zzpd.zzc();
                                                if (zzg().zzs(null, zzdu.zzal)) {
                                                    z5 = false;
                                                } else {
                                                    z5 = false;
                                                }
                                                i = 0;
                                                while (true) {
                                                    zzenVar2 = this.zzi;
                                                    if (i >= size) {
                                                        break;
                                                        break;
                                                    }
                                                    zzgcVar = (zzgc) ((zzgd) ((Pair) listEmptyList.get(i)).first).zzby();
                                                    arrayList.add((Long) ((Pair) listEmptyList.get(i)).second);
                                                    zzg().zzh();
                                                    int i9 = size;
                                                    ArrayList arrayList5 = arrayList;
                                                    zzgcVar.zzal(74029L);
                                                    zzgcVar.zzak(jCurrentTimeMillis);
                                                    zzgcVar.zzag(false);
                                                    if (!z4) {
                                                        zzgcVar.zzq();
                                                    }
                                                    if (!zZzi) {
                                                        zzgcVar.zzx();
                                                        zzgcVar.zzt();
                                                    }
                                                    if (!zZzi2) {
                                                        zzgcVar.zzn();
                                                    }
                                                    zzC(zzgcVar, strZzr);
                                                    if (!z5) {
                                                        zzgcVar.zzy();
                                                    }
                                                    if (zzg().zzs(strZzr, zzdu.zzT)) {
                                                        byte[] bArrZzbu3 = ((zzgd) zzgcVar.zzaC()).zzbu();
                                                        zzal(zzenVar2);
                                                        zzgcVar.zzJ(zzenVar2.zzd(bArrZzbu3));
                                                    }
                                                    zzgaVarZza.zza(zzgcVar);
                                                    i++;
                                                    size = i9;
                                                    arrayList = arrayList5;
                                                }
                                                int i10 = size;
                                                arrayList2 = arrayList;
                                                if (Log.isLoggable(zzay().zzq(), 2)) {
                                                    zzal(zzenVar2);
                                                    strZzm = zzenVar2.zzm((zzgb) zzgaVarZza.zzaC());
                                                } else {
                                                    strZzm = null;
                                                }
                                                zzal(zzenVar2);
                                                byte[] bArrZzbu4 = ((zzgb) zzgaVarZza.zzaC()).zzbu();
                                                zzfi zzfiVar2 = this.zzl.zzf.zzc;
                                                zzal(zzfiVar2);
                                                strZzi = zzfiVar2.zzi(strZzr);
                                                if (TextUtils.isEmpty(strZzi)) {
                                                    Uri uri2 = Uri.parse((String) zzdu.zzp.zza(null));
                                                    Uri.Builder builderBuildUpon2 = uri2.buildUpon();
                                                    builderBuildUpon2.authority(strZzi + "." + uri2.getAuthority());
                                                    string2 = builderBuildUpon2.build().toString();
                                                } else {
                                                    string2 = (String) zzdu.zzp.zza(null);
                                                }
                                                str = string2;
                                                URL url2 = new URL(str);
                                                com.google.android.gms.common.internal.zzah.checkArgument(!arrayList2.isEmpty());
                                                if (this.zzy != null) {
                                                    zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                } else {
                                                    this.zzy = new ArrayList(arrayList2);
                                                }
                                                this.zzk.zzd.zzb(jCurrentTimeMillis);
                                                zzay().zzj().zzd("Uploading data. app, uncompressed size, data", i10 > 0 ? zzgaVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbu4.length), strZzm);
                                                this.zzu = true;
                                                zzal(zzenVar);
                                                Fragment.AnonymousClass7 anonymousClass8 = new Fragment.AnonymousClass7(this, strZzr);
                                                zzenVar.zzg();
                                                zzenVar.zzW();
                                                zzen zzenVar6 = zzenVar;
                                                ((zzfr) zzenVar6.mBuilder).zzaz().zzo(new zzem(zzenVar6, strZzr, url2, bArrZzbu4, null, anonymousClass8));
                                            }
                                            this.zzv = false;
                                            zzae();
                                        }
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                        cursorRawQuery2 = null;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                    cursorRawQuery2.close();
                                    this.zzA = j2;
                                }
                                iZze = zzg().zze(strZzr, zzdu.zzf);
                                iMax = Math.max(0, zzg().zze(strZzr, zzdu.zzg));
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                zzfr zzfrVar4 = (zzfr) zzamVar.mBuilder;
                                zzamVar.zzg();
                                zzamVar.zzW();
                                if (iZze > 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                com.google.android.gms.common.internal.zzah.checkArgument(z2);
                                if (iMax > 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                try {
                                    com.google.android.gms.common.internal.zzah.checkArgument(z3);
                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzr);
                                    cursorQuery = zzamVar.zzh().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze));
                                    try {
                                        if (cursorQuery.moveToFirst()) {
                                            listEmptyList = Collections.emptyList();
                                            cursorQuery.close();
                                            zzenVar = zzenVar3;
                                        } else {
                                            arrayList3 = new ArrayList();
                                            length = 0;
                                            while (true) {
                                                j = cursorQuery.getLong(i5);
                                                byte[] blob2 = cursorQuery.getBlob(i4);
                                                zzen zzenVar7 = zzamVar.zzf.zzi;
                                                zzal(zzenVar7);
                                                byteArrayInputStream = new ByteArrayInputStream(blob2);
                                                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                                byteArrayOutputStream = new ByteArrayOutputStream();
                                                zzamVar2 = zzamVar;
                                                bArr = new byte[1024];
                                                zzenVar = zzenVar3;
                                                while (true) {
                                                    i3 = gZIPInputStream.read(bArr);
                                                    if (i3 <= 0) {
                                                        break;
                                                        break;
                                                    } else {
                                                        ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
                                                        byteArrayOutputStream.write(bArr, 0, i3);
                                                        byteArrayInputStream = byteArrayInputStream3;
                                                    }
                                                }
                                                gZIPInputStream.close();
                                                byteArrayInputStream.close();
                                                byteArray = byteArrayOutputStream.toByteArray();
                                                if (arrayList3.isEmpty() && byteArray.length + length > iMax) {
                                                    break;
                                                }
                                                zzgcVar2 = (zzgc) zzen.zzl(zzgd.zzt(), byteArray);
                                                if (!cursorQuery.isNull(2)) {
                                                    zzgcVar2.zzaf(cursorQuery.getInt(2));
                                                }
                                                length += byteArray.length;
                                                arrayList3.add(Pair.create((zzgd) zzgcVar2.zzaC(), Long.valueOf(j)));
                                                if (cursorQuery.moveToNext() || length > iMax) {
                                                    break;
                                                    break;
                                                }
                                                zzamVar = zzamVar2;
                                                zzenVar3 = zzenVar;
                                                i4 = 1;
                                                i5 = 0;
                                            }
                                            cursorQuery.close();
                                            listEmptyList = arrayList3;
                                        }
                                    } catch (SQLiteException e13) {
                                        e = e13;
                                        zzenVar = zzenVar3;
                                    }
                                    if (!listEmptyList.isEmpty()) {
                                        zzaiVarZzh = zzh(strZzr);
                                        zzahVar = zzah.AD_STORAGE;
                                        if (zzaiVarZzh.zzi(zzahVar)) {
                                            it = listEmptyList.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    strZzJ = null;
                                                    break;
                                                }
                                                zzgdVar2 = (zzgd) ((Pair) it.next()).first;
                                                if (!zzgdVar2.zzJ().isEmpty()) {
                                                    strZzJ = zzgdVar2.zzJ();
                                                    break;
                                                }
                                            }
                                            if (strZzJ != null) {
                                                while (i2 < listEmptyList.size()) {
                                                    zzgdVar = (zzgd) ((Pair) listEmptyList.get(i2)).first;
                                                    if (zzgdVar.zzJ().isEmpty() && !zzgdVar.zzJ().equals(strZzJ)) {
                                                        listEmptyList = listEmptyList.subList(0, i2);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        zzgaVarZza = zzgb.zza();
                                        size = listEmptyList.size();
                                        arrayList = new ArrayList(listEmptyList.size());
                                        if (zzg().zzt(strZzr) || !zzh(strZzr).zzi(zzahVar)) {
                                            z4 = false;
                                        } else {
                                            z4 = true;
                                        }
                                        zZzi = zzh(strZzr).zzi(zzahVar);
                                        zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                        zzpd.zzc();
                                        if (zzg().zzs(null, zzdu.zzal) || !zzg().zzs(strZzr, zzdu.zzan)) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                        i = 0;
                                        while (true) {
                                            zzenVar2 = this.zzi;
                                            if (i >= size) {
                                                break;
                                                break;
                                            }
                                            zzgcVar = (zzgc) ((zzgd) ((Pair) listEmptyList.get(i)).first).zzby();
                                            arrayList.add((Long) ((Pair) listEmptyList.get(i)).second);
                                            zzg().zzh();
                                            int i11 = size;
                                            ArrayList arrayList6 = arrayList;
                                            zzgcVar.zzal(74029L);
                                            zzgcVar.zzak(jCurrentTimeMillis);
                                            zzgcVar.zzag(false);
                                            if (!z4) {
                                                zzgcVar.zzq();
                                            }
                                            if (!zZzi) {
                                                zzgcVar.zzx();
                                                zzgcVar.zzt();
                                            }
                                            if (!zZzi2) {
                                                zzgcVar.zzn();
                                            }
                                            zzC(zzgcVar, strZzr);
                                            if (!z5) {
                                                zzgcVar.zzy();
                                            }
                                            if (zzg().zzs(strZzr, zzdu.zzT)) {
                                                byte[] bArrZzbu5 = ((zzgd) zzgcVar.zzaC()).zzbu();
                                                zzal(zzenVar2);
                                                zzgcVar.zzJ(zzenVar2.zzd(bArrZzbu5));
                                            }
                                            zzgaVarZza.zza(zzgcVar);
                                            i++;
                                            size = i11;
                                            arrayList = arrayList6;
                                        }
                                        int i12 = size;
                                        arrayList2 = arrayList;
                                        if (Log.isLoggable(zzay().zzq(), 2)) {
                                            zzal(zzenVar2);
                                            strZzm = zzenVar2.zzm((zzgb) zzgaVarZza.zzaC());
                                        } else {
                                            strZzm = null;
                                        }
                                        zzal(zzenVar2);
                                        byte[] bArrZzbu6 = ((zzgb) zzgaVarZza.zzaC()).zzbu();
                                        zzfi zzfiVar3 = this.zzl.zzf.zzc;
                                        zzal(zzfiVar3);
                                        strZzi = zzfiVar3.zzi(strZzr);
                                        if (TextUtils.isEmpty(strZzi)) {
                                            Uri uri3 = Uri.parse((String) zzdu.zzp.zza(null));
                                            Uri.Builder builderBuildUpon3 = uri3.buildUpon();
                                            builderBuildUpon3.authority(strZzi + "." + uri3.getAuthority());
                                            string2 = builderBuildUpon3.build().toString();
                                        } else {
                                            string2 = (String) zzdu.zzp.zza(null);
                                        }
                                        str = string2;
                                        URL url3 = new URL(str);
                                        com.google.android.gms.common.internal.zzah.checkArgument(!arrayList2.isEmpty());
                                        if (this.zzy != null) {
                                            zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                        } else {
                                            this.zzy = new ArrayList(arrayList2);
                                        }
                                        this.zzk.zzd.zzb(jCurrentTimeMillis);
                                        zzay().zzj().zzd("Uploading data. app, uncompressed size, data", i12 > 0 ? zzgaVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbu6.length), strZzm);
                                        this.zzu = true;
                                        zzal(zzenVar);
                                        Fragment.AnonymousClass7 anonymousClass9 = new Fragment.AnonymousClass7(this, strZzr);
                                        zzenVar.zzg();
                                        zzenVar.zzW();
                                        zzen zzenVar8 = zzenVar;
                                        ((zzfr) zzenVar8.mBuilder).zzaz().zzo(new zzem(zzenVar8, strZzr, url3, bArrZzbu6, null, anonymousClass9));
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                            this.zzv = false;
                        } else {
                            zzay().zzj().zza("Network not connected, ignoring upload request");
                            zzag();
                            this.zzv = false;
                        }
                    }
                }
                zzae();
            } catch (Throwable th7) {
                th = th7;
                z = false;
                this.zzv = z;
                zzae();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            z = false;
            this.zzv = z;
            zzae();
            throw th;
        }
    }

    public final long zza() {
        ((DefaultClock) zzav()).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzjo zzjoVar = this.zzk;
        zzjoVar.zzW();
        zzjoVar.zzg();
        zzes zzesVar = zzjoVar.zze;
        long jZza = zzesVar.zza();
        if (jZza == 0) {
            zzlb zzlbVar = ((zzfr) zzjoVar.mBuilder).zzp;
            zzfr.zzP(zzlbVar);
            jZza = ((long) zzlbVar.zzG().nextInt(86400000)) + 1;
            zzesVar.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    public final zzq zzac(String str) {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(str);
        if (zzhVarZzj == null || TextUtils.isEmpty(zzhVarZzj.zzw())) {
            zzay().zzk.zzb(str, "No app data available; dropping");
            return null;
        }
        Boolean boolZzad = zzad(zzhVarZzj);
        if (boolZzad != null && !boolZzad.booleanValue()) {
            zzeh zzehVarZzay = zzay();
            zzehVarZzay.zzd.zzb(zzeh.zzn(str), "App version does not match; dropping. appId");
            return null;
        }
        String strZzy = zzhVarZzj.zzy();
        String strZzw = zzhVarZzj.zzw();
        long jZzb = zzhVarZzj.zzb();
        zzfr zzfrVar = zzhVarZzj.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        String str2 = zzhVarZzj.zzl;
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzg();
        long j = zzhVarZzj.zzm;
        zzfo zzfoVar3 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar3);
        zzfoVar3.zzg();
        long j2 = zzhVarZzj.zzn;
        zzfo zzfoVar4 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar4);
        zzfoVar4.zzg();
        boolean z = zzhVarZzj.zzo;
        String strZzx = zzhVarZzj.zzx();
        zzfo zzfoVar5 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar5);
        zzfoVar5.zzg();
        boolean zZzah = zzhVarZzj.zzah();
        String strZzr = zzhVarZzj.zzr();
        zzfo zzfoVar6 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar6);
        zzfoVar6.zzg();
        Boolean bool = zzhVarZzj.zzr;
        long jZzk = zzhVarZzj.zzk();
        zzfo zzfoVar7 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar7);
        zzfoVar7.zzg();
        return new zzq(str, strZzy, strZzw, jZzb, str2, j, j2, null, z, false, strZzx, 0L, 0, zZzah, false, strZzr, bool, jZzk, zzhVarZzj.zzt, zzh(str).zzh(), "", null);
    }

    public final Boolean zzad(zzh zzhVar) {
        try {
            long jZzb = zzhVar.zzb();
            zzfr zzfrVar = this.zzn;
            if (jZzb != -2147483648L) {
                if (zzhVar.zzb() == Wrappers.packageManager(zzfrVar.zze).getPackageInfo(0, zzhVar.zzt()).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(zzfrVar.zze).getPackageInfo(0, zzhVar.zzt()).versionName;
                String strZzw = zzhVar.zzw();
                if (strZzw != null && strZzw.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzeh zzehVarZzay = zzay();
            zzehVarZzay.zzl.zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzl.zza("Stopping uploading service(s)");
        ArrayList arrayList = this.zzq;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ArrayList arrayList2 = this.zzq;
        com.google.android.gms.common.internal.zzah.checkNotNull(arrayList2);
        arrayList2.clear();
    }

    public final void zzaf(zzgc zzgcVar, long j, boolean z) {
        zzky zzkyVar;
        Object obj;
        String str = true != z ? "_lte" : "_se";
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzky zzkyVarZzp = zzamVar.zzp(zzgcVar.zzap(), str);
        if (zzkyVarZzp == null || (obj = zzkyVarZzp.zze) == null) {
            String strZzap = zzgcVar.zzap();
            ((DefaultClock) zzav()).getClass();
            zzkyVar = new zzky(strZzap, "auto", str, System.currentTimeMillis(), Long.valueOf(j));
        } else {
            String strZzap2 = zzgcVar.zzap();
            ((DefaultClock) zzav()).getClass();
            zzkyVar = new zzky(strZzap2, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        }
        com.google.android.gms.internal.measurement.zzgl zzglVarZzd = com.google.android.gms.internal.measurement.zzgm.zzd();
        zzglVarZzd.zzf(str);
        ((DefaultClock) zzav()).getClass();
        zzglVarZzd.zzg(System.currentTimeMillis());
        Object obj2 = zzkyVar.zze;
        zzglVarZzd.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) zzglVarZzd.zzaC();
        int iZza = zzen.zza(zzgcVar, str);
        if (iZza >= 0) {
            zzgcVar.zzam(iZza, zzgmVar);
        } else {
            zzgcVar.zzm(zzgmVar);
        }
        if (j > 0) {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzamVar2.zzL(zzkyVar);
            zzay().zzl.zzc(true != z ? "lifetime" : "session-scoped", "Updated engagement user property. scope, value", obj2);
        }
    }

    public final boolean zzai() {
        zzaz().zzg();
        zzB$1();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        if (zzamVar.zzZ("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        zzam zzamVar2 = this.zze;
        zzal(zzamVar2);
        return !TextUtils.isEmpty(zzamVar2.zzr());
    }

    public final boolean zzaj(zzfs zzfsVar, zzfs zzfsVar2) {
        com.google.android.gms.common.internal.zzah.checkArgument("_e".equals(zzfsVar.zzo()));
        zzen zzenVar = this.zzi;
        zzal(zzenVar);
        zzfx zzfxVarZzB = zzen.zzB((zzft) zzfsVar.zzaC(), "_sc");
        String strZzh = zzfxVarZzB == null ? null : zzfxVarZzB.zzh();
        zzal(zzenVar);
        zzfx zzfxVarZzB2 = zzen.zzB((zzft) zzfsVar2.zzaC(), "_pc");
        String strZzh2 = zzfxVarZzB2 != null ? zzfxVarZzB2.zzh() : null;
        if (strZzh2 == null || !strZzh2.equals(strZzh)) {
            return false;
        }
        com.google.android.gms.common.internal.zzah.checkArgument("_e".equals(zzfsVar.zzo()));
        zzal(zzenVar);
        zzfx zzfxVarZzB3 = zzen.zzB((zzft) zzfsVar.zzaC(), "_et");
        if (zzfxVarZzB3 == null || !zzfxVarZzB3.zzw() || zzfxVarZzB3.zzd() <= 0) {
            return true;
        }
        long jZzd = zzfxVarZzB3.zzd();
        zzal(zzenVar);
        zzfx zzfxVarZzB4 = zzen.zzB((zzft) zzfsVar2.zzaC(), "_et");
        if (zzfxVarZzB4 != null && zzfxVarZzB4.zzd() > 0) {
            jZzd += zzfxVarZzB4.zzd();
        }
        zzal(zzenVar);
        zzen.zzz(zzfsVar2, "_et", Long.valueOf(jZzd));
        zzal(zzenVar);
        zzen.zzz(zzfsVar, "_fr", 1L);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Context zzau() {
        return this.zzn.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Clock zzav() {
        zzfr zzfrVar = this.zzn;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzfrVar);
        return zzfrVar.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzdg zzaw() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzeh zzay() {
        zzfr zzfrVar = this.zzn;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzfrVar);
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        return zzehVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzfo zzaz() {
        zzfr zzfrVar = this.zzn;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzfrVar);
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        return zzfoVar;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00fb  */
    public final zzh zzd(zzq zzqVar) {
        zzaz().zzg();
        zzB$1();
        com.google.android.gms.common.internal.zzah.checkNotNull(zzqVar);
        String str = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        String str2 = zzqVar.zzw;
        if (!str2.isEmpty()) {
            this.zzC.put(str, new zzks(this, str2));
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(str);
        zzai zzaiVarZzc = zzh(str).zzc(zzai.zzb(zzqVar.zzv));
        zzah zzahVar = zzah.AD_STORAGE;
        boolean zZzi = zzaiVarZzc.zzi(zzahVar);
        boolean z = zzqVar.zzo;
        String strZzf = zZzi ? this.zzk.zzf(str, z) : "";
        zzah zzahVar2 = zzah.ANALYTICS_STORAGE;
        if (zzhVarZzj == null) {
            zzhVarZzj = new zzh(this.zzn, str);
            if (zzaiVarZzc.zzi(zzahVar2)) {
                zzhVarZzj.zzH(zzw(zzaiVarZzc));
            }
            if (zzaiVarZzc.zzi(zzahVar)) {
                zzhVarZzj.zzae(strZzf);
            }
        } else if (zzaiVarZzc.zzi(zzahVar) && strZzf != null) {
            zzfo zzfoVar = zzhVarZzj.zza.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzg();
            if (!strZzf.equals(zzhVarZzj.zze)) {
                zzhVarZzj.zzae(strZzf);
                if (z) {
                    zzjo zzjoVar = this.zzk;
                    zzjoVar.getClass();
                    if (!"00000000-0000-0000-0000-000000000000".equals((zzaiVarZzc.zzi(zzahVar) ? zzjoVar.zza(str) : new Pair("", Boolean.FALSE)).first)) {
                        zzhVarZzj.zzH(zzw(zzaiVarZzc));
                        zzam zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        if (zzamVar2.zzp(str, "_id") != null) {
                            zzam zzamVar3 = this.zze;
                            zzal(zzamVar3);
                            if (zzamVar3.zzp(str, "_lair") == null) {
                                ((DefaultClock) zzav()).getClass();
                                zzky zzkyVar = new zzky(zzqVar.zza, "auto", "_lair", System.currentTimeMillis(), 1L);
                                zzam zzamVar4 = this.zze;
                                zzal(zzamVar4);
                                zzamVar4.zzL(zzkyVar);
                            }
                        }
                    }
                }
            } else if (TextUtils.isEmpty(zzhVarZzj.zzu())) {
                zzhVarZzj.zzH(zzw(zzaiVarZzc));
            }
        } else if (TextUtils.isEmpty(zzhVarZzj.zzu()) && zzaiVarZzc.zzi(zzahVar2)) {
            zzhVarZzj.zzH(zzw(zzaiVarZzc));
        }
        zzhVarZzj.zzW(zzqVar.zzb);
        zzhVarZzj.zzF(zzqVar.zzq);
        String str3 = zzqVar.zzk;
        if (!TextUtils.isEmpty(str3)) {
            zzhVarZzj.zzV(str3);
        }
        long j = zzqVar.zze;
        if (j != 0) {
            zzhVarZzj.zzX(j);
        }
        String str4 = zzqVar.zzc;
        if (!TextUtils.isEmpty(str4)) {
            zzhVarZzj.zzJ(str4);
        }
        zzhVarZzj.zzK(zzqVar.zzj);
        String str5 = zzqVar.zzd;
        if (str5 != null) {
            zzhVarZzj.zzI(str5);
        }
        zzhVarZzj.zzS(zzqVar.zzf);
        zzhVarZzj.zzac(zzqVar.zzh);
        String str6 = zzqVar.zzg;
        if (!TextUtils.isEmpty(str6)) {
            zzhVarZzj.zzY(str6);
        }
        zzfr zzfrVar = zzhVarZzj.zza;
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzg();
        zzhVarZzj.zzC |= zzhVarZzj.zzp != z;
        zzhVarZzj.zzp = z;
        zzfo zzfoVar3 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar3);
        zzfoVar3.zzg();
        boolean z2 = zzhVarZzj.zzC;
        Boolean bool = zzhVarZzj.zzr;
        Boolean bool2 = zzqVar.zzr;
        zzhVarZzj.zzC = z2 | (!zzg.zza(bool, bool2));
        zzhVarZzj.zzr = bool2;
        zzhVarZzj.zzT(zzqVar.zzs);
        zzpd.zzc();
        if (zzg().zzs(null, zzdu.zzal) && zzg().zzs(str, zzdu.zzan)) {
            zzfo zzfoVar4 = zzfrVar.zzn;
            zzfr.zzR(zzfoVar4);
            zzfoVar4.zzg();
            boolean z3 = zzhVarZzj.zzC;
            String str7 = zzhVarZzj.zzu;
            String str8 = zzqVar.zzx;
            zzhVarZzj.zzC = z3 | (!zzg.zza(str7, str8));
            zzhVarZzj.zzu = str8;
        }
        zznt.zzc();
        if (zzg().zzs(null, zzdu.zzaj)) {
            zzhVarZzj.zzaf(zzqVar.zzt);
        } else {
            zznt.zzc();
            if (zzg().zzs(null, zzdu.zzai)) {
                zzhVarZzj.zzaf(null);
            }
        }
        zzfo zzfoVar5 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar5);
        zzfoVar5.zzg();
        if (zzhVarZzj.zzC) {
            zzam zzamVar5 = this.zze;
            zzal(zzamVar5);
            zzamVar5.zzD(zzhVarZzj);
        }
        return zzhVarZzj;
    }

    public final zzag zzg() {
        zzfr zzfrVar = this.zzn;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzfrVar);
        return zzfrVar.zzk;
    }

    public final zzai zzh(String str) {
        String string;
        zzai zzaiVar = zzai.zza;
        zzaz().zzg();
        zzB$1();
        zzai zzaiVar2 = (zzai) this.zzB.get(str);
        if (zzaiVar2 != null) {
            return zzaiVar2;
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        zzamVar.zzg();
        zzamVar.zzW();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzamVar.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                } else {
                    cursorRawQuery.close();
                    string = "G1";
                }
                zzai zzaiVarZzb = zzai.zzb(string);
                zzV(str, zzaiVarZzb);
                return zzaiVarZzb;
            } catch (SQLiteException e) {
                zzeh zzehVar = ((zzfr) zzamVar.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzc("select consent_state from consent_settings where app_id=? limit 1;", "Database error", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final zzam zzi() {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        return zzamVar;
    }

    public final zzn zzm() {
        zzn zznVar = this.zzf;
        if (zznVar != null) {
            return zznVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzen zzu() {
        zzen zzenVar = this.zzi;
        zzal(zzenVar);
        return zzenVar;
    }

    public final zzlb zzv() {
        zzfr zzfrVar = this.zzn;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzfrVar);
        zzlb zzlbVar = zzfrVar.zzp;
        zzfr.zzP(zzlbVar);
        return zzlbVar;
    }

    public final String zzw(zzai zzaiVar) {
        if (!zzaiVar.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void zzD(zzh zzhVar) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        zzfi zzfiVar = this.zzc;
        zzaz().zzg();
        if (TextUtils.isEmpty(zzhVar.zzy()) && TextUtils.isEmpty(zzhVar.zzr())) {
            String strZzt = zzhVar.zzt();
            com.google.android.gms.common.internal.zzah.checkNotNull(strZzt);
            zzI(strZzt, 204, null, null, null);
            return;
        }
        Uri.Builder builder = new Uri.Builder();
        String strZzy = zzhVar.zzy();
        if (TextUtils.isEmpty(strZzy)) {
            strZzy = zzhVar.zzr();
        }
        ArrayMap arrayMap3 = null;
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) zzdu.zzd.zza(null)).encodedAuthority((String) zzdu.zze.zza(null)).path("config/app/".concat(String.valueOf(strZzy))).appendQueryParameter("platform", kBfGXgdfpo.BCjXjCkjdtuA);
        ((zzfr) this.zzl.mBuilder).zzk.zzh();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(74029L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            String strZzt2 = zzhVar.zzt();
            com.google.android.gms.common.internal.zzah.checkNotNull(strZzt2);
            URL url = new URL(string);
            zzay().zzl.zzb(strZzt2, "Fetching remote configuration");
            zzal(zzfiVar);
            com.google.android.gms.internal.measurement.zzff zzffVarZze = zzfiVar.zze(strZzt2);
            zzal(zzfiVar);
            zzfiVar.zzg();
            String str = (String) zzfiVar.zzk.getOrDefault(strZzt2, null);
            if (zzffVarZze == null) {
                arrayMap = arrayMap3;
            } else {
                if (TextUtils.isEmpty(str)) {
                    arrayMap2 = null;
                } else {
                    arrayMap2 = new ArrayMap();
                    arrayMap2.put("If-Modified-Since", str);
                }
                zzox.zzc();
                if (zzg().zzs(null, zzdu.zzao)) {
                    zzal(zzfiVar);
                    zzfiVar.zzg();
                    String str2 = (String) zzfiVar.zzl.getOrDefault(strZzt2, null);
                    if (!TextUtils.isEmpty(str2)) {
                        if (arrayMap2 == null) {
                            arrayMap2 = new ArrayMap();
                        }
                        arrayMap3 = arrayMap2;
                        arrayMap3.put("If-None-Match", str2);
                        arrayMap = arrayMap3;
                    }
                }
                arrayMap = arrayMap2;
            }
            this.zzt = true;
            zzen zzenVar = this.zzd;
            zzal(zzenVar);
            ProfileCache profileCache = new ProfileCache(this, 28);
            zzenVar.zzg();
            zzenVar.zzW();
            zzfo zzfoVar = ((zzfr) zzenVar.mBuilder).zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzo(new zzem(zzenVar, strZzt2, url, null, arrayMap, profileCache));
        } catch (MalformedURLException unused) {
            zzay().zzd.zzc(zzeh.zzn(zzhVar.zzt()), "Failed to parse config URL. Not fetching. appId", string);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0299 A[Catch: all -> 0x00cd, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x02c0 A[Catch: all -> 0x00cd, TRY_ENTER, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02d0 A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02e2 A[Catch: all -> 0x00cd, TRY_ENTER, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x02ed A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0314 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0320 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0397 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x03d3 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x03ee A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x0420 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0428 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x042e A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x043b  */
    /* JADX WARN: Code duplicated, block: B:160:0x0441 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x044a A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0450  */
    /* JADX WARN: Code duplicated, block: B:166:0x0459  */
    /* JADX WARN: Code duplicated, block: B:167:0x045c  */
    /* JADX WARN: Code duplicated, block: B:170:0x0470  */
    /* JADX WARN: Code duplicated, block: B:176:0x0490 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0496 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x049c  */
    /* JADX WARN: Code duplicated, block: B:182:0x04a4 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x04ad A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x04c8 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x04fa A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0514 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x051b A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0403 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0202  */
    /* JADX WARN: Code duplicated, block: B:75:0x020a A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0215 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0220  */
    /* JADX WARN: Code duplicated, block: B:81:0x0224  */
    /* JADX WARN: Code duplicated, block: B:84:0x0232 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x023e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0242 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0263  */
    /* JADX WARN: Code duplicated, block: B:95:0x0269 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0276 A[Catch: all -> 0x00cd, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0284 A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #6 {all -> 0x00cd, blocks: (B:23:0x00b0, B:25:0x00c0, B:45:0x0117, B:47:0x0125, B:49:0x0138, B:51:0x0154, B:52:0x0161, B:54:0x0172, B:56:0x01b8, B:58:0x01bd, B:60:0x01c3, B:64:0x01cf, B:75:0x020a, B:77:0x0215, B:82:0x0226, B:85:0x0234, B:89:0x023f, B:91:0x0242, B:93:0x0264, B:95:0x0269, B:98:0x0284, B:101:0x0299, B:104:0x02c0, B:139:0x03a1, B:141:0x03d3, B:142:0x03d6, B:144:0x03ee, B:185:0x04ad, B:186:0x04b0, B:194:0x0536, B:147:0x0403, B:152:0x0420, B:154:0x0428, B:156:0x042e, B:160:0x0441, B:164:0x0452, B:168:0x045e, B:171:0x0473, B:176:0x0490, B:178:0x0496, B:180:0x049e, B:182:0x04a4, B:174:0x047e, B:162:0x044a, B:150:0x040e, B:106:0x02d0, B:108:0x02d4, B:111:0x02e2, B:112:0x02ed, B:114:0x0314, B:115:0x0320, B:117:0x0327, B:119:0x032d, B:121:0x0337, B:123:0x033d, B:125:0x0343, B:127:0x0349, B:128:0x034e, B:133:0x0378, B:136:0x037d, B:137:0x038c, B:138:0x0397, B:187:0x04c8, B:189:0x04fa, B:190:0x04fd, B:191:0x0514, B:193:0x051b, B:96:0x0276, B:72:0x01f0, B:31:0x00d0, B:33:0x00d4, B:37:0x00e4, B:39:0x00f5, B:41:0x00ff, B:44:0x0106), top: B:212:0x00b0, inners: #3, #4, #7 }] */
    public final void zzL(zzq zzqVar) {
        String str;
        String str2;
        String str3;
        String str4;
        zzas zzasVarZzn;
        boolean z;
        long j;
        long j2;
        boolean z2;
        Bundle bundle;
        zzs zzsVar;
        boolean zIsEmpty;
        zzfr zzfrVar;
        Context context;
        boolean zZza;
        zzeh zzehVar;
        Intent intent;
        long j3;
        PackageManager packageManager;
        List<ResolveInfo> listQueryIntentServices;
        Bundle bundle2;
        String str5;
        String str6;
        String str7;
        long jZzc;
        PackageInfo packageInfo;
        zzq zzqVar2;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j4;
        long j5;
        boolean z3;
        long j6;
        boolean z4;
        String strZzw;
        boolean z5;
        String str8 = RDFWIi.MaJx;
        zzaz().zzg();
        zzB$1();
        com.google.android.gms.common.internal.zzah.checkNotNull(zzqVar);
        String str9 = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str9);
        if (zzak(zzqVar)) {
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzh zzhVarZzj = zzamVar.zzj(str9);
            String str10 = zzqVar.zzb;
            if (zzhVarZzj != null && TextUtils.isEmpty(zzhVarZzj.zzy()) && !TextUtils.isEmpty(str10)) {
                zzhVarZzj.zzL(0L);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzamVar2.zzD(zzhVarZzj);
                zzfi zzfiVar = this.zzc;
                zzal(zzfiVar);
                zzfiVar.zzg();
                zzfiVar.zzh.remove(str9);
            }
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            long jCurrentTimeMillis = zzqVar.zzm;
            if (jCurrentTimeMillis == 0) {
                ((DefaultClock) zzav()).getClass();
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            zzfr zzfrVar2 = this.zzn;
            zzaq zzaqVarZzg = zzfrVar2.zzg();
            Context context2 = zzfrVar2.zze;
            zzaqVarZzg.zzg();
            zzaqVarZzg.zzd = null;
            zzaqVarZzg.zze = 0L;
            int i = zzqVar.zzn;
            if (i != 0 && i != 1) {
                zzay().zzg.zzc(zzeh.zzn(str9), "Incorrect app type, assuming installed app. appId, appType", Integer.valueOf(i));
                i = 0;
            }
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzamVar3.zzw();
            try {
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzky zzkyVarZzp = zzamVar4.zzp(str9, "_npa");
                if (zzkyVarZzp == null || "auto".equals(zzkyVarZzp.zzb)) {
                    Boolean bool = zzqVar.zzr;
                    if (bool != null) {
                        zzkw zzkwVar = new zzkw(jCurrentTimeMillis, Long.valueOf(true != bool.booleanValue() ? 0L : 1L), "_npa", dLDI.wgJOKae);
                        if (zzkyVarZzp == null || !zzkyVarZzp.zze.equals(zzkwVar.zzd)) {
                            zzW(zzkwVar, zzqVar);
                        }
                    } else if (zzkyVarZzp != null) {
                        zzP(new zzkw(jCurrentTimeMillis, null, "_npa", "auto"), zzqVar);
                    }
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                com.google.android.gms.common.internal.zzah.checkNotNull(str9);
                zzh zzhVarZzj2 = zzamVar5.zzj(str9);
                if (zzhVarZzj2 != null) {
                    zzv();
                    if (zzlb.zzam(str10, zzhVarZzj2.zzy(), zzqVar.zzq, zzhVarZzj2.zzr())) {
                        zzay().zzg.zzb(zzeh.zzn(zzhVarZzj2.zzt()), "New GMP App Id passed in. Removing cached database data. appId");
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzfr zzfrVar3 = (zzfr) zzamVar6.mBuilder;
                        String strZzt = zzhVarZzj2.zzt();
                        zzamVar6.zzW();
                        zzamVar6.zzg();
                        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzt);
                        try {
                            SQLiteDatabase sQLiteDatabaseZzh = zzamVar6.zzh();
                            String[] strArr = {strZzt};
                            str3 = "_sysu";
                            try {
                                int iDelete = sQLiteDatabaseZzh.delete(kBfGXgdfpo.AbTnummlYjQep, "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("consent_settings", "app_id=?", strArr);
                                zzoi.zzc();
                                str = "_pfo";
                                try {
                                    str2 = str8;
                                    try {
                                        if (zzfrVar3.zzk.zzs(null, zzdu.zzat)) {
                                            iDelete += sQLiteDatabaseZzh.delete("default_event_params", "app_id=?", strArr);
                                        }
                                        if (iDelete > 0) {
                                            zzeh zzehVar2 = zzfrVar3.zzm;
                                            zzfr.zzR(zzehVar2);
                                            zzehVar2.zzl.zzc(strZzt, "Deleted application data. app, records", Integer.valueOf(iDelete));
                                        }
                                    } catch (SQLiteException e) {
                                        e = e;
                                        zzeh zzehVar3 = zzfrVar3.zzm;
                                        zzfr.zzR(zzehVar3);
                                        zzehVar3.zzd.zzc(zzeh.zzn(strZzt), yzwzcWHcnH.SvWrWdkPX, e);
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    str2 = str8;
                                    zzeh zzehVar4 = zzfrVar3.zzm;
                                    zzfr.zzR(zzehVar4);
                                    zzehVar4.zzd.zzc(zzeh.zzn(strZzt), yzwzcWHcnH.SvWrWdkPX, e);
                                    zzhVarZzj2 = null;
                                    if (zzhVarZzj2 != null) {
                                        if (zzhVarZzj2.zzb() != -2147483648L) {
                                            str4 = "com.android.vending";
                                            z4 = zzhVarZzj2.zzb() != zzqVar.zzj;
                                            strZzw = zzhVarZzj2.zzw();
                                            if (zzhVarZzj2.zzb() == -2147483648L) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z4 | z5) {
                                                Bundle bundle3 = new Bundle();
                                                bundle3.putString("_pv", strZzw);
                                                zzE(new zzaw("_au", new zzau(bundle3), "auto", jCurrentTimeMillis), zzqVar);
                                            }
                                        } else {
                                            str4 = "com.android.vending";
                                        }
                                        strZzw = zzhVarZzj2.zzw();
                                        if (zzhVarZzj2.zzb() == -2147483648L) {
                                            z5 = false;
                                        } else {
                                            z5 = false;
                                        }
                                        if (z4 | z5) {
                                            Bundle bundle4 = new Bundle();
                                            bundle4.putString("_pv", strZzw);
                                            zzE(new zzaw("_au", new zzau(bundle4), "auto", jCurrentTimeMillis), zzqVar);
                                        }
                                    } else {
                                        str4 = "com.android.vending";
                                    }
                                    zzd(zzqVar);
                                    if (i == 0) {
                                        zzam zzamVar7 = this.zze;
                                        zzal(zzamVar7);
                                        zzasVarZzn = zzamVar7.zzn(str9, "_f");
                                        z = false;
                                    } else {
                                        zzam zzamVar8 = this.zze;
                                        zzal(zzamVar8);
                                        zzasVarZzn = zzamVar8.zzn(str9, "_v");
                                        z = true;
                                    }
                                    if (zzasVarZzn == null) {
                                        j2 = ((jCurrentTimeMillis / 3600000) + 1) * 3600000;
                                        z2 = zzqVar.zzp;
                                        if (z) {
                                            long j7 = jCurrentTimeMillis;
                                            zzW(new zzkw(j7, Long.valueOf(j2), "_fvt", "auto"), zzqVar);
                                            zzaz().zzg();
                                            zzB$1();
                                            bundle = new Bundle();
                                            bundle.putLong("_c", 1L);
                                            bundle.putLong("_r", 1L);
                                            bundle.putLong("_et", 1L);
                                            if (z2) {
                                                bundle.putLong("_dac", 1L);
                                            }
                                            zzG(new zzaw("_v", new zzau(bundle), "auto", j7), zzqVar);
                                        } else {
                                            zzW(new zzkw(jCurrentTimeMillis, Long.valueOf(j2), "_fot", "auto"), zzqVar);
                                            zzaz().zzg();
                                            zzsVar = this.zzm;
                                            com.google.android.gms.common.internal.zzah.checkNotNull(zzsVar);
                                            zIsEmpty = str9.isEmpty();
                                            zzfrVar = zzsVar.zza;
                                            if (zIsEmpty) {
                                                zzeh zzehVar5 = zzfrVar.zzm;
                                                zzfr.zzR(zzehVar5);
                                                zzehVar5.zzh.zza("Install Referrer Reporter was called with invalid app package name");
                                            } else {
                                                zzfo zzfoVar = zzfrVar.zzn;
                                                context = zzfrVar.zze;
                                                zzfr.zzR(zzfoVar);
                                                zzfoVar.zzg();
                                                zZza = zzsVar.zza();
                                                zzehVar = zzfrVar.zzm;
                                                if (zZza) {
                                                    zzbc zzbcVar = new zzbc(zzsVar, str9, 3);
                                                    zzfo zzfoVar2 = zzfrVar.zzn;
                                                    zzfr.zzR(zzfoVar2);
                                                    zzfoVar2.zzg();
                                                    intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                                    j3 = jCurrentTimeMillis;
                                                    intent.setComponent(new ComponentName(str4, "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                                    packageManager = context.getPackageManager();
                                                    if (packageManager == null) {
                                                        zzfr.zzR(zzehVar);
                                                        zzehVar.zzh.zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                                    } else {
                                                        listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                                        if (listQueryIntentServices != null) {
                                                            zzfr.zzR(zzehVar);
                                                            zzehVar.zzj.zza("Play Service for fetching Install Referrer is unavailable on device");
                                                        } else {
                                                            zzfr.zzR(zzehVar);
                                                            zzehVar.zzj.zza("Play Service for fetching Install Referrer is unavailable on device");
                                                        }
                                                    }
                                                    zzaz().zzg();
                                                    zzB$1();
                                                    bundle2 = new Bundle();
                                                    bundle2.putLong("_c", 1L);
                                                    bundle2.putLong("_r", 1L);
                                                    str5 = str2;
                                                    bundle2.putLong(str5, 0L);
                                                    str6 = str;
                                                    bundle2.putLong(str6, 0L);
                                                    bundle2.putLong("_sys", 0L);
                                                    str7 = str3;
                                                    bundle2.putLong(str7, 0L);
                                                    bundle2.putLong("_et", 1L);
                                                    if (z2) {
                                                        bundle2.putLong("_dac", 1L);
                                                    }
                                                    zzam zzamVar9 = this.zze;
                                                    zzal(zzamVar9);
                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str9);
                                                    zzamVar9.zzg();
                                                    zzamVar9.zzW();
                                                    jZzc = zzamVar9.zzc(str9);
                                                    if (context2.getPackageManager() == null) {
                                                        zzay().zzd.zzb(zzeh.zzn(str9), "PackageManager is null, first open report might be inaccurate. appId");
                                                        zzqVar2 = zzqVar;
                                                    } else {
                                                        try {
                                                            packageInfo = Wrappers.packageManager(context2).getPackageInfo(0, str9);
                                                        } catch (PackageManager.NameNotFoundException e3) {
                                                            zzay().zzd.zzc(zzeh.zzn(str9), "Package info is null, first open report might be inaccurate. appId", e3);
                                                            packageInfo = null;
                                                        }
                                                        if (packageInfo != null) {
                                                            j5 = packageInfo.firstInstallTime;
                                                            if (j5 != 0) {
                                                                if (j5 != packageInfo.lastUpdateTime) {
                                                                    applicationInfo = null;
                                                                    if (zzg().zzs(null, zzdu.zzab)) {
                                                                        bundle2.putLong(str5, 1L);
                                                                    } else if (jZzc == 0) {
                                                                        bundle2.putLong(str5, 1L);
                                                                        jZzc = 0;
                                                                    }
                                                                    z3 = false;
                                                                } else {
                                                                    applicationInfo = null;
                                                                    z3 = true;
                                                                }
                                                                if (true != z3) {
                                                                    j6 = 0;
                                                                } else {
                                                                    j6 = 1;
                                                                }
                                                                zzkw zzkwVar2 = new zzkw(j3, Long.valueOf(j6), "_fi", "auto");
                                                                zzqVar2 = zzqVar;
                                                                zzW(zzkwVar2, zzqVar2);
                                                            } else {
                                                                zzqVar2 = zzqVar;
                                                                applicationInfo = null;
                                                            }
                                                        } else {
                                                            zzqVar2 = zzqVar;
                                                            applicationInfo = null;
                                                        }
                                                        try {
                                                            applicationInfo2 = Wrappers.packageManager(context2).getApplicationInfo(0, str9);
                                                        } catch (PackageManager.NameNotFoundException e4) {
                                                            zzay().zzd.zzc(zzeh.zzn(str9), "Application info is null, first open report might be inaccurate. appId", e4);
                                                            applicationInfo2 = applicationInfo;
                                                        }
                                                        if (applicationInfo2 != null) {
                                                            if ((applicationInfo2.flags & 1) != 0) {
                                                                j4 = 1;
                                                                bundle2.putLong("_sys", 1L);
                                                            } else {
                                                                j4 = 1;
                                                            }
                                                            if ((applicationInfo2.flags & 128) != 0) {
                                                                bundle2.putLong(str7, j4);
                                                            }
                                                        }
                                                    }
                                                    if (jZzc >= 0) {
                                                        bundle2.putLong(str6, jZzc);
                                                    }
                                                    zzG(new zzaw("_f", new zzau(bundle2), "auto", j3), zzqVar2);
                                                } else {
                                                    zzfr.zzR(zzehVar);
                                                    zzehVar.zzj.zza("Install Referrer Reporter is not available");
                                                }
                                            }
                                            j3 = jCurrentTimeMillis;
                                            zzaz().zzg();
                                            zzB$1();
                                            bundle2 = new Bundle();
                                            bundle2.putLong("_c", 1L);
                                            bundle2.putLong("_r", 1L);
                                            str5 = str2;
                                            bundle2.putLong(str5, 0L);
                                            str6 = str;
                                            bundle2.putLong(str6, 0L);
                                            bundle2.putLong("_sys", 0L);
                                            str7 = str3;
                                            bundle2.putLong(str7, 0L);
                                            bundle2.putLong("_et", 1L);
                                            if (z2) {
                                                bundle2.putLong("_dac", 1L);
                                            }
                                            zzam zzamVar10 = this.zze;
                                            zzal(zzamVar10);
                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str9);
                                            zzamVar10.zzg();
                                            zzamVar10.zzW();
                                            jZzc = zzamVar10.zzc(str9);
                                            if (context2.getPackageManager() == null) {
                                                zzay().zzd.zzb(zzeh.zzn(str9), "PackageManager is null, first open report might be inaccurate. appId");
                                                zzqVar2 = zzqVar;
                                            } else {
                                                packageInfo = Wrappers.packageManager(context2).getPackageInfo(0, str9);
                                                if (packageInfo != null) {
                                                    j5 = packageInfo.firstInstallTime;
                                                    if (j5 != 0) {
                                                        if (j5 != packageInfo.lastUpdateTime) {
                                                            applicationInfo = null;
                                                            if (zzg().zzs(null, zzdu.zzab)) {
                                                                bundle2.putLong(str5, 1L);
                                                            } else if (jZzc == 0) {
                                                                bundle2.putLong(str5, 1L);
                                                                jZzc = 0;
                                                            }
                                                            z3 = false;
                                                        } else {
                                                            applicationInfo = null;
                                                            z3 = true;
                                                        }
                                                        if (true != z3) {
                                                            j6 = 0;
                                                        } else {
                                                            j6 = 1;
                                                        }
                                                        zzkw zzkwVar3 = new zzkw(j3, Long.valueOf(j6), "_fi", "auto");
                                                        zzqVar2 = zzqVar;
                                                        zzW(zzkwVar3, zzqVar2);
                                                    } else {
                                                        zzqVar2 = zzqVar;
                                                        applicationInfo = null;
                                                    }
                                                } else {
                                                    zzqVar2 = zzqVar;
                                                    applicationInfo = null;
                                                }
                                                applicationInfo2 = Wrappers.packageManager(context2).getApplicationInfo(0, str9);
                                                if (applicationInfo2 != null) {
                                                    if ((applicationInfo2.flags & 1) != 0) {
                                                        j4 = 1;
                                                        bundle2.putLong("_sys", 1L);
                                                    } else {
                                                        j4 = 1;
                                                    }
                                                    if ((applicationInfo2.flags & 128) != 0) {
                                                        bundle2.putLong(str7, j4);
                                                    }
                                                }
                                            }
                                            if (jZzc >= 0) {
                                                bundle2.putLong(str6, jZzc);
                                            }
                                            zzG(new zzaw("_f", new zzau(bundle2), "auto", j3), zzqVar2);
                                        }
                                    } else {
                                        j = jCurrentTimeMillis;
                                        if (zzqVar.zzi) {
                                            zzG(new zzaw("_cd", new zzau(new Bundle()), "auto", j), zzqVar);
                                        }
                                    }
                                    zzam zzamVar11 = this.zze;
                                    zzal(zzamVar11);
                                    zzamVar11.zzC();
                                    zzam zzamVar12 = this.zze;
                                    zzal(zzamVar12);
                                    zzamVar12.zzx();
                                }
                            } catch (SQLiteException e5) {
                                e = e5;
                                str = "_pfo";
                            }
                        } catch (SQLiteException e6) {
                            e = e6;
                            str = "_pfo";
                            str2 = str8;
                            str3 = "_sysu";
                        }
                        zzhVarZzj2 = null;
                    } else {
                        str = "_pfo";
                        str2 = str8;
                        str3 = "_sysu";
                    }
                } else {
                    str = "_pfo";
                    str2 = str8;
                    str3 = "_sysu";
                }
                if (zzhVarZzj2 != null) {
                    if (zzhVarZzj2.zzb() != -2147483648L) {
                        str4 = "com.android.vending";
                        if (zzhVarZzj2.zzb() != zzqVar.zzj) {
                        }
                        strZzw = zzhVarZzj2.zzw();
                        if (zzhVarZzj2.zzb() == -2147483648L || strZzw == null || strZzw.equals(zzqVar.zzc)) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        if (z4 | z5) {
                            Bundle bundle5 = new Bundle();
                            bundle5.putString("_pv", strZzw);
                            zzE(new zzaw("_au", new zzau(bundle5), "auto", jCurrentTimeMillis), zzqVar);
                        }
                    } else {
                        str4 = "com.android.vending";
                    }
                    strZzw = zzhVarZzj2.zzw();
                    if (zzhVarZzj2.zzb() == -2147483648L) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    if (z4 | z5) {
                        Bundle bundle6 = new Bundle();
                        bundle6.putString("_pv", strZzw);
                        zzE(new zzaw("_au", new zzau(bundle6), "auto", jCurrentTimeMillis), zzqVar);
                    }
                } else {
                    str4 = "com.android.vending";
                }
                zzd(zzqVar);
                if (i == 0) {
                    zzam zzamVar13 = this.zze;
                    zzal(zzamVar13);
                    zzasVarZzn = zzamVar13.zzn(str9, "_f");
                    z = false;
                } else {
                    zzam zzamVar14 = this.zze;
                    zzal(zzamVar14);
                    zzasVarZzn = zzamVar14.zzn(str9, "_v");
                    z = true;
                }
                if (zzasVarZzn == null) {
                    j2 = ((jCurrentTimeMillis / 3600000) + 1) * 3600000;
                    z2 = zzqVar.zzp;
                    if (z) {
                        zzW(new zzkw(jCurrentTimeMillis, Long.valueOf(j2), "_fot", "auto"), zzqVar);
                        zzaz().zzg();
                        zzsVar = this.zzm;
                        com.google.android.gms.common.internal.zzah.checkNotNull(zzsVar);
                        zIsEmpty = str9.isEmpty();
                        zzfrVar = zzsVar.zza;
                        if (zIsEmpty) {
                            zzeh zzehVar6 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar6);
                            zzehVar6.zzh.zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzfo zzfoVar3 = zzfrVar.zzn;
                            context = zzfrVar.zze;
                            zzfr.zzR(zzfoVar3);
                            zzfoVar3.zzg();
                            zZza = zzsVar.zza();
                            zzehVar = zzfrVar.zzm;
                            if (zZza) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzj.zza("Install Referrer Reporter is not available");
                            } else {
                                zzbc zzbcVar2 = new zzbc(zzsVar, str9, 3);
                                zzfo zzfoVar4 = zzfrVar.zzn;
                                zzfr.zzR(zzfoVar4);
                                zzfoVar4.zzg();
                                intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                j3 = jCurrentTimeMillis;
                                intent.setComponent(new ComponentName(str4, "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                packageManager = context.getPackageManager();
                                if (packageManager == null) {
                                    zzfr.zzR(zzehVar);
                                    zzehVar.zzh.zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices != null || listQueryIntentServices.isEmpty()) {
                                        zzfr.zzR(zzehVar);
                                        zzehVar.zzj.zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                                        if (serviceInfo != null) {
                                            String str11 = serviceInfo.packageName;
                                            if (serviceInfo.name != null && str4.equals(str11) && zzsVar.zza()) {
                                                try {
                                                    boolean zZzc = ConnectionTracker.getInstance().zzc(context, context.getClass().getName(), new Intent(intent), zzbcVar2, 1, null);
                                                    zzfr.zzR(zzehVar);
                                                    zzehVar.zzl.zzb(true != zZzc ? "not available" : "available", "Install Referrer Service is");
                                                } catch (RuntimeException e7) {
                                                    zzfr.zzR(zzehVar);
                                                    zzehVar.zzd.zzb(e7.getMessage(), "Exception occurred while binding to Install Referrer Service");
                                                }
                                            } else {
                                                zzfr.zzR(zzehVar);
                                                zzehVar.zzg.zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                                zzaz().zzg();
                                zzB$1();
                                bundle2 = new Bundle();
                                bundle2.putLong("_c", 1L);
                                bundle2.putLong("_r", 1L);
                                str5 = str2;
                                bundle2.putLong(str5, 0L);
                                str6 = str;
                                bundle2.putLong(str6, 0L);
                                bundle2.putLong("_sys", 0L);
                                str7 = str3;
                                bundle2.putLong(str7, 0L);
                                bundle2.putLong("_et", 1L);
                                if (z2) {
                                    bundle2.putLong("_dac", 1L);
                                }
                                zzam zzamVar15 = this.zze;
                                zzal(zzamVar15);
                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str9);
                                zzamVar15.zzg();
                                zzamVar15.zzW();
                                jZzc = zzamVar15.zzc(str9);
                                if (context2.getPackageManager() == null) {
                                    zzay().zzd.zzb(zzeh.zzn(str9), "PackageManager is null, first open report might be inaccurate. appId");
                                    zzqVar2 = zzqVar;
                                } else {
                                    packageInfo = Wrappers.packageManager(context2).getPackageInfo(0, str9);
                                    if (packageInfo != null) {
                                        j5 = packageInfo.firstInstallTime;
                                        if (j5 != 0) {
                                            if (j5 != packageInfo.lastUpdateTime) {
                                                applicationInfo = null;
                                                if (zzg().zzs(null, zzdu.zzab)) {
                                                    bundle2.putLong(str5, 1L);
                                                } else if (jZzc == 0) {
                                                    bundle2.putLong(str5, 1L);
                                                    jZzc = 0;
                                                }
                                                z3 = false;
                                            } else {
                                                applicationInfo = null;
                                                z3 = true;
                                            }
                                            if (true != z3) {
                                                j6 = 0;
                                            } else {
                                                j6 = 1;
                                            }
                                            zzkw zzkwVar4 = new zzkw(j3, Long.valueOf(j6), "_fi", "auto");
                                            zzqVar2 = zzqVar;
                                            zzW(zzkwVar4, zzqVar2);
                                        } else {
                                            zzqVar2 = zzqVar;
                                            applicationInfo = null;
                                        }
                                    } else {
                                        zzqVar2 = zzqVar;
                                        applicationInfo = null;
                                    }
                                    applicationInfo2 = Wrappers.packageManager(context2).getApplicationInfo(0, str9);
                                    if (applicationInfo2 != null) {
                                        if ((applicationInfo2.flags & 1) != 0) {
                                            j4 = 1;
                                            bundle2.putLong("_sys", 1L);
                                        } else {
                                            j4 = 1;
                                        }
                                        if ((applicationInfo2.flags & 128) != 0) {
                                            bundle2.putLong(str7, j4);
                                        }
                                    }
                                }
                                if (jZzc >= 0) {
                                    bundle2.putLong(str6, jZzc);
                                }
                                zzG(new zzaw("_f", new zzau(bundle2), "auto", j3), zzqVar2);
                            }
                        }
                        j3 = jCurrentTimeMillis;
                        zzaz().zzg();
                        zzB$1();
                        bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        str5 = str2;
                        bundle2.putLong(str5, 0L);
                        str6 = str;
                        bundle2.putLong(str6, 0L);
                        bundle2.putLong("_sys", 0L);
                        str7 = str3;
                        bundle2.putLong(str7, 0L);
                        bundle2.putLong("_et", 1L);
                        if (z2) {
                            bundle2.putLong("_dac", 1L);
                        }
                        zzam zzamVar16 = this.zze;
                        zzal(zzamVar16);
                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str9);
                        zzamVar16.zzg();
                        zzamVar16.zzW();
                        jZzc = zzamVar16.zzc(str9);
                        if (context2.getPackageManager() == null) {
                            zzay().zzd.zzb(zzeh.zzn(str9), "PackageManager is null, first open report might be inaccurate. appId");
                            zzqVar2 = zzqVar;
                        } else {
                            packageInfo = Wrappers.packageManager(context2).getPackageInfo(0, str9);
                            if (packageInfo != null) {
                                j5 = packageInfo.firstInstallTime;
                                if (j5 != 0) {
                                    if (j5 != packageInfo.lastUpdateTime) {
                                        applicationInfo = null;
                                        if (zzg().zzs(null, zzdu.zzab)) {
                                            bundle2.putLong(str5, 1L);
                                        } else if (jZzc == 0) {
                                            bundle2.putLong(str5, 1L);
                                            jZzc = 0;
                                        }
                                        z3 = false;
                                    } else {
                                        applicationInfo = null;
                                        z3 = true;
                                    }
                                    if (true != z3) {
                                        j6 = 0;
                                    } else {
                                        j6 = 1;
                                    }
                                    zzkw zzkwVar5 = new zzkw(j3, Long.valueOf(j6), "_fi", "auto");
                                    zzqVar2 = zzqVar;
                                    zzW(zzkwVar5, zzqVar2);
                                } else {
                                    zzqVar2 = zzqVar;
                                    applicationInfo = null;
                                }
                            } else {
                                zzqVar2 = zzqVar;
                                applicationInfo = null;
                            }
                            applicationInfo2 = Wrappers.packageManager(context2).getApplicationInfo(0, str9);
                            if (applicationInfo2 != null) {
                                if ((applicationInfo2.flags & 1) != 0) {
                                    j4 = 1;
                                    bundle2.putLong("_sys", 1L);
                                } else {
                                    j4 = 1;
                                }
                                if ((applicationInfo2.flags & 128) != 0) {
                                    bundle2.putLong(str7, j4);
                                }
                            }
                        }
                        if (jZzc >= 0) {
                            bundle2.putLong(str6, jZzc);
                        }
                        zzG(new zzaw("_f", new zzau(bundle2), "auto", j3), zzqVar2);
                    } else {
                        long j8 = jCurrentTimeMillis;
                        zzW(new zzkw(j8, Long.valueOf(j2), "_fvt", "auto"), zzqVar);
                        zzaz().zzg();
                        zzB$1();
                        bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_et", 1L);
                        if (z2) {
                            bundle.putLong("_dac", 1L);
                        }
                        zzG(new zzaw("_v", new zzau(bundle), "auto", j8), zzqVar);
                    }
                } else {
                    j = jCurrentTimeMillis;
                    if (zzqVar.zzi) {
                        zzG(new zzaw("_cd", new zzau(new Bundle()), "auto", j), zzqVar);
                    }
                }
                zzam zzamVar17 = this.zze;
                zzal(zzamVar17);
                zzamVar17.zzC();
                zzam zzamVar18 = this.zze;
                zzal(zzamVar18);
                zzamVar18.zzx();
            } catch (Throwable th) {
                zzam zzamVar19 = this.zze;
                zzal(zzamVar19);
                zzamVar19.zzx();
                throw th;
            }
        }
    }

    public final void zzO(zzac zzacVar, zzq zzqVar) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(zzacVar.zza);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar.zzc);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB$1();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                String str = zzacVar.zza;
                com.google.android.gms.common.internal.zzah.checkNotNull(str);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzac zzacVarZzk = zzamVar2.zzk(str, zzacVar.zzc.zzb);
                zzfr zzfrVar = this.zzn;
                if (zzacVarZzk != null) {
                    zzay().zzk.zzc(zzacVar.zza, FETmZwrVHuasmL.cyydm, zzfrVar.zzq.zzf(zzacVar.zzc.zzb));
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzamVar3.zza(str, zzacVar.zzc.zzb);
                    if (zzacVarZzk.zze) {
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzA(str, zzacVar.zzc.zzb);
                    }
                    zzaw zzawVar = zzacVar.zzk;
                    if (zzawVar != null) {
                        zzau zzauVar = zzawVar.zzb;
                        zzaw zzawVarZzz = zzv().zzz(zzawVar.zza, zzauVar != null ? zzauVar.zzc() : null, zzacVarZzk.zzb, zzawVar.zzd, true);
                        com.google.android.gms.common.internal.zzah.checkNotNull(zzawVarZzz);
                        zzY(zzawVarZzz, zzqVar);
                    }
                } else {
                    zzay().zzg.zzc(zzeh.zzn(zzacVar.zza), "Conditional user property doesn't exist", zzfrVar.zzq.zzf(zzacVar.zzc.zzb));
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    public final void zzU(zzac zzacVar, zzq zzqVar) {
        zzaw zzawVar;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(zzacVar.zza);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar.zzb);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar.zzc);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB$1();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzac zzacVar2 = new zzac(zzacVar);
            boolean z = false;
            zzacVar2.zze = false;
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                String str = zzacVar2.zza;
                com.google.android.gms.common.internal.zzah.checkNotNull(str);
                zzac zzacVarZzk = zzamVar2.zzk(str, zzacVar2.zzc.zzb);
                zzfr zzfrVar = this.zzn;
                if (zzacVarZzk != null && !zzacVarZzk.zzb.equals(zzacVar2.zzb)) {
                    zzay().zzg.zzd(jIKWv.WpjRRwECTSvmqnn, zzfrVar.zzq.zzf(zzacVar2.zzc.zzb), zzacVar2.zzb, zzacVarZzk.zzb);
                }
                if (zzacVarZzk != null && zzacVarZzk.zze) {
                    zzacVar2.zzb = zzacVarZzk.zzb;
                    zzacVar2.zzd = zzacVarZzk.zzd;
                    zzacVar2.zzh = zzacVarZzk.zzh;
                    zzacVar2.zzf = zzacVarZzk.zzf;
                    zzacVar2.zzi = zzacVarZzk.zzi;
                    zzacVar2.zze = true;
                    zzkw zzkwVar = zzacVar2.zzc;
                    zzacVar2.zzc = new zzkw(zzacVarZzk.zzc.zzc, zzkwVar.zza(), zzkwVar.zzb, zzacVarZzk.zzc.zzf);
                } else if (TextUtils.isEmpty(zzacVar2.zzf)) {
                    zzkw zzkwVar2 = zzacVar2.zzc;
                    zzacVar2.zzc = new zzkw(zzacVar2.zzd, zzkwVar2.zza(), zzkwVar2.zzb, zzacVar2.zzc.zzf);
                    zzacVar2.zze = true;
                    z = true;
                }
                if (zzacVar2.zze) {
                    zzkw zzkwVar3 = zzacVar2.zzc;
                    String str2 = zzacVar2.zza;
                    com.google.android.gms.common.internal.zzah.checkNotNull(str2);
                    String str3 = zzacVar2.zzb;
                    String str4 = zzkwVar3.zzb;
                    long j = zzkwVar3.zzc;
                    Object objZza = zzkwVar3.zza();
                    com.google.android.gms.common.internal.zzah.checkNotNull(objZza);
                    zzky zzkyVar = new zzky(str2, str3, str4, j, objZza);
                    Object obj = zzkyVar.zze;
                    String str5 = zzkyVar.zzc;
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    if (zzamVar3.zzL(zzkyVar)) {
                        zzay().zzk.zzd("User property updated immediately", zzacVar2.zza, zzfrVar.zzq.zzf(str5), obj);
                    } else {
                        zzay().zzd.zzd("(2)Too many active user properties, ignoring", zzeh.zzn(zzacVar2.zza), zzfrVar.zzq.zzf(str5), obj);
                    }
                    if (z && (zzawVar = zzacVar2.zzi) != null) {
                        zzY(new zzaw(zzawVar, zzacVar2.zzd), zzqVar);
                    }
                }
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                if (zzamVar4.zzK(zzacVar2)) {
                    zzay().zzk.zzd("Conditional property added", zzacVar2.zza, zzfrVar.zzq.zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                } else {
                    zzay().zzd.zzd("Too many conditional properties, ignoring", zzeh.zzn(zzacVar2.zza), zzfrVar.zzq.zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f8  */
    public final void zzW(zzkw zzkwVar, zzq zzqVar) {
        zzas zzasVarZzn;
        long jLongValue;
        zzaz().zzg();
        zzB$1();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            int iZzl = zzv().zzl(zzkwVar.zzb);
            AccessTokenCache accessTokenCache = this.zzF;
            String str = zzkwVar.zzb;
            if (iZzl != 0) {
                zzv();
                zzg();
                String strZzD = zzlb.zzD(str, 24, true);
                int length = str != null ? str.length() : 0;
                zzv();
                zzlb.zzN(accessTokenCache, zzqVar.zza, iZzl, "_ev", strZzD, length);
                return;
            }
            int iZzd = zzv().zzd(zzkwVar.zza(), str);
            if (iZzd != 0) {
                zzv();
                zzg();
                String strZzD2 = zzlb.zzD(str, 24, true);
                Object objZza = zzkwVar.zza();
                int length2 = (objZza == null || !((objZza instanceof String) || (objZza instanceof CharSequence))) ? 0 : objZza.toString().length();
                zzv();
                zzlb.zzN(accessTokenCache, zzqVar.zza, iZzd, "_ev", strZzD2, length2);
                return;
            }
            Object objZzB = zzv().zzB(zzkwVar.zza(), str);
            if (objZzB == null) {
                return;
            }
            boolean zEquals = GsPcpBmONXh.ButMmc.equals(str);
            String str2 = zzqVar.zza;
            if (zEquals) {
                com.google.android.gms.common.internal.zzah.checkNotNull(str2);
                zzam zzamVar = this.zze;
                zzal(zzamVar);
                zzky zzkyVarZzp = zzamVar.zzp(str2, "_sno");
                if (zzkyVarZzp != null) {
                    Object obj = zzkyVarZzp.zze;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (zzkyVarZzp != null) {
                            zzay().zzg.zzb(zzkyVarZzp.zze, "Retrieved last session number from database does not contain a valid (long) value");
                        }
                        zzam zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        zzasVarZzn = zzamVar2.zzn(str2, "_s");
                        if (zzasVarZzn != null) {
                            zzeh zzehVarZzay = zzay();
                            long j = zzasVarZzn.zzc;
                            zzehVarZzay.zzl.zzb(Long.valueOf(j), "Backfill the session number. Last used session number");
                            jLongValue = j;
                        } else {
                            jLongValue = 0;
                        }
                    }
                } else {
                    if (zzkyVarZzp != null) {
                        zzay().zzg.zzb(zzkyVarZzp.zze, "Retrieved last session number from database does not contain a valid (long) value");
                    }
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzasVarZzn = zzamVar3.zzn(str2, "_s");
                    if (zzasVarZzn != null) {
                        zzeh zzehVarZzay2 = zzay();
                        long j2 = zzasVarZzn.zzc;
                        zzehVarZzay2.zzl.zzb(Long.valueOf(j2), "Backfill the session number. Last used session number");
                        jLongValue = j2;
                    } else {
                        jLongValue = 0;
                    }
                }
                zzW(new zzkw(zzkwVar.zzc, Long.valueOf(jLongValue + 1), "_sno", zzkwVar.zzf), zzqVar);
            }
            com.google.android.gms.common.internal.zzah.checkNotNull(str2);
            String str3 = zzkwVar.zzf;
            com.google.android.gms.common.internal.zzah.checkNotNull(str3);
            zzky zzkyVar = new zzky(str2, str3, zzkwVar.zzb, zzkwVar.zzc, objZzB);
            zzeh zzehVarZzay3 = zzay();
            zzfr zzfrVar = this.zzn;
            zzec zzecVar = zzfrVar.zzq;
            String str4 = zzkyVar.zzc;
            zzehVarZzay3.zzl.zzc(zzecVar.zzf(str4), "Setting user property", objZzB);
            zzam zzamVar4 = this.zze;
            zzal(zzamVar4);
            zzamVar4.zzw();
            try {
                boolean zEquals2 = "_id".equals(str4);
                Object obj2 = zzkyVar.zze;
                if (zEquals2) {
                    zzam zzamVar5 = this.zze;
                    zzal(zzamVar5);
                    zzky zzkyVarZzp2 = zzamVar5.zzp(str2, "_id");
                    if (zzkyVarZzp2 != null && !obj2.equals(zzkyVarZzp2.zze)) {
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zzA(str2, "_lair");
                    }
                }
                zzd(zzqVar);
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                boolean zZzL = zzamVar7.zzL(zzkyVar);
                zzam zzamVar8 = this.zze;
                zzal(zzamVar8);
                zzamVar8.zzC();
                if (!zZzL) {
                    zzay().zzd.zzc(zzfrVar.zzq.zzf(str4), "Too many unique user properties are set. Ignoring user property", obj2);
                    zzv();
                    zzlb.zzN(accessTokenCache, zzqVar.zza, 9, null, null, 0);
                }
            } finally {
                zzam zzamVar9 = this.zze;
                zzal(zzamVar9);
                zzamVar9.zzx();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:234:0x07c3 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x081c  */
    /* JADX WARN: Code duplicated, block: B:252:0x0855 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x085f A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:257:0x086d A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:259:0x0887 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:268:0x08ea A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x0904 A[Catch: all -> 0x0195, TRY_LEAVE, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:279:0x09a0 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:282:0x09b0 A[LOOP:2: B:277:0x099a->B:282:0x09b0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:292:0x0a57 A[Catch: all -> 0x0195, SQLiteException -> 0x0a6f, TRY_LEAVE, TryCatch #5 {SQLiteException -> 0x0a6f, blocks: (B:290:0x0a46, B:292:0x0a57), top: B:323:0x0a46, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:296:0x0a72  */
    /* JADX WARN: Code duplicated, block: B:339:0x09b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:340:0x09ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x01bf A[Catch: all -> 0x0195, TRY_ENTER, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x01d4 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:66:0x021c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0227 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0235 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0246 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x024c  */
    /* JADX WARN: Code duplicated, block: B:77:0x024d A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x027a A[Catch: all -> 0x0195, TRY_LEAVE, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x02f1 A[Catch: all -> 0x0195, TryCatch #2 {all -> 0x0195, blocks: (B:31:0x0176, B:34:0x0183, B:36:0x018b, B:42:0x0199, B:93:0x0325, B:102:0x035b, B:104:0x0396, B:106:0x039d, B:107:0x03b4, B:111:0x03c7, B:113:0x03e1, B:115:0x03ea, B:116:0x0401, B:121:0x042b, B:125:0x0452, B:126:0x0469, B:130:0x047e, B:136:0x04ad, B:137:0x04c3, B:139:0x04cb, B:141:0x04d8, B:143:0x04de, B:144:0x04e7, B:146:0x04f0, B:147:0x04f9, B:149:0x050a, B:151:0x051a, B:163:0x0546, B:164:0x055b, B:166:0x0583, B:169:0x05ae, B:172:0x05fb, B:174:0x062b, B:176:0x0660, B:177:0x0663, B:179:0x0669, B:181:0x0671, B:183:0x0677, B:185:0x067f, B:187:0x068f, B:189:0x069b, B:191:0x06a1, B:195:0x06b2, B:196:0x06b5, B:198:0x06c0, B:200:0x06c8, B:202:0x06ec, B:204:0x06f2, B:207:0x0700, B:208:0x0703, B:210:0x071d, B:214:0x072c, B:215:0x074a, B:217:0x0750, B:219:0x076a, B:221:0x0776, B:223:0x0783, B:230:0x07b9, B:234:0x07c3, B:235:0x07c6, B:239:0x07de, B:241:0x07e9, B:243:0x07fb, B:246:0x0807, B:248:0x0812, B:250:0x081e, B:252:0x0855, B:254:0x085f, B:255:0x0862, B:257:0x086d, B:259:0x0887, B:260:0x0890, B:261:0x08c4, B:263:0x08cc, B:265:0x08d6, B:266:0x08e0, B:268:0x08ea, B:269:0x08f4, B:270:0x08fe, B:272:0x0904, B:274:0x0936, B:275:0x097c, B:276:0x0987, B:277:0x099a, B:279:0x09a0, B:289:0x09f6, B:290:0x0a46, B:292:0x0a57, B:307:0x0ac3, B:297:0x0a74, B:298:0x0a77, B:283:0x09b3, B:285:0x09e1, B:304:0x0a94, B:305:0x0aad, B:306:0x0aae, B:242:0x07f0, B:228:0x07a5, B:173:0x061d, B:160:0x052e, B:133:0x0499, B:96:0x0335, B:97:0x0341, B:99:0x0347, B:101:0x0355, B:49:0x01b1, B:52:0x01bf, B:54:0x01d4, B:60:0x01ea, B:68:0x0221, B:70:0x0227, B:72:0x0235, B:74:0x0246, B:77:0x024d, B:89:0x02e6, B:91:0x02f1, B:78:0x027a, B:79:0x0296, B:81:0x02a4, B:88:0x02c6, B:87:0x02b1, B:63:0x01f6, B:67:0x021d), top: B:318:0x0176, inners: #4, #5, #7 }] */
    public final void zzY(zzaw zzawVar, zzq zzqVar) {
        String strZzg$1;
        String str;
        String str2;
        Bundle bundle;
        long jRound;
        String upperCase;
        String strConcat;
        zzky zzkyVarZzp;
        zzam zzamVar;
        String str3;
        zzky zzkyVar;
        zzam zzamVar2;
        Object obj;
        double dDoubleValue;
        long length;
        String str4;
        String str5;
        long jDelete;
        zzas zzasVarZzc;
        String str6;
        zzgc zzgcVarZzt;
        String str7;
        String str8;
        long j;
        String str9;
        String str10;
        String str11;
        zzar zzarVar;
        long j2;
        zzen zzenVar;
        Map mapZzc;
        String str12;
        zzar zzarVar2;
        long j3;
        ArrayList arrayList;
        zzai zzaiVarZzc;
        zzah zzahVar;
        boolean zZzi;
        boolean z;
        zzh zzhVarZzj;
        List listZzu;
        int i;
        zzam zzamVar3;
        zzgd zzgdVar;
        zzam zzamVar4;
        zzar zzarVar3;
        Iterator<String> it;
        boolean zZzq;
        int i2;
        ContentValues contentValues;
        String str13;
        String str14 = JuorMn.GCF;
        String str15 = "_sno";
        com.google.android.gms.common.internal.zzah.checkNotNull(zzqVar);
        String str16 = zzqVar.zzv;
        long j4 = zzqVar.zze;
        String str17 = zzqVar.zzx;
        String str18 = zzqVar.zzc;
        String str19 = zzqVar.zzd;
        String str20 = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str20);
        long jNanoTime = System.nanoTime();
        zzaz().zzg();
        zzB$1();
        zzen zzenVar2 = this.zzi;
        zzal(zzenVar2);
        String str21 = zzqVar.zzb;
        boolean zIsEmpty = TextUtils.isEmpty(str21);
        String str22 = zzqVar.zzq;
        if (zIsEmpty && TextUtils.isEmpty(str22)) {
            return;
        }
        boolean z2 = zzqVar.zzh;
        if (!z2) {
            zzd(zzqVar);
            return;
        }
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        String str23 = zzqVar.zza;
        String str24 = zzawVar.zza;
        boolean zZzr = zzfiVar.zzr(str23, str24);
        AccessTokenCache accessTokenCache = this.zzF;
        zzfr zzfrVar = this.zzn;
        if (zZzr) {
            zzay().zzk().zzc(zzeh.zzn(str23), "Dropping blocked event. appId", zzfrVar.zzj().zzd(str24));
            zzal(zzfiVar);
            if (!"1".equals(zzfiVar.zza(str23, "measurement.upload.blacklist_internal"))) {
                zzal(zzfiVar);
                if (!"1".equals(zzfiVar.zza(str23, "measurement.upload.blacklist_public"))) {
                    if ("_err".equals(str24)) {
                        return;
                    }
                    zzv();
                    zzlb.zzN(accessTokenCache, str23, 11, "_ev", zzawVar.zza, 0);
                    return;
                }
            }
            zzam zzamVar5 = this.zze;
            zzal(zzamVar5);
            zzh zzhVarZzj2 = zzamVar5.zzj(str23);
            if (zzhVarZzj2 != null) {
                zzfr zzfrVar2 = zzhVarZzj2.zza;
                zzfo zzfoVar = zzfrVar2.zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzg();
                long j5 = zzhVarZzj2.zzE;
                zzfo zzfoVar2 = zzfrVar2.zzn;
                zzfr.zzR(zzfoVar2);
                zzfoVar2.zzg();
                long jMax = Math.max(j5, zzhVarZzj2.zzD);
                ((DefaultClock) zzav()).getClass();
                long jAbs = Math.abs(System.currentTimeMillis() - jMax);
                zzg();
                if (jAbs > ((Long) zzdu.zzy.zza(null)).longValue()) {
                    zzay().zzk.zza("Fetching config for blocked app");
                    zzD(zzhVarZzj2);
                    return;
                }
                return;
            }
            return;
        }
        RealConnectionPool realConnectionPoolZzb = RealConnectionPool.zzb(zzawVar);
        zzlb zzlbVarZzv = zzv();
        zzag zzagVarZzg = zzg();
        zzagVarZzg.getClass();
        zzlbVarZzv.zzM(realConnectionPoolZzb, Math.max(Math.min(zzagVarZzg.zze(str23, zzdu.zzH), 100), 25));
        zzaw zzawVarZza = realConnectionPoolZzb.zza();
        String str25 = zzawVarZza.zza;
        if (Log.isLoggable(zzay().zzq(), 2)) {
            zzay().zzj().zzb(zzfrVar.zzj().zzc(zzawVarZza), "Logging event");
        }
        zzam zzamVar6 = this.zze;
        zzal(zzamVar6);
        zzamVar6.zzw();
        try {
            zzd(zzqVar);
            boolean z3 = "ecommerce_purchase".equals(str25) || FirebaseAnalytics.Event.PURCHASE.equals(str25) || FirebaseAnalytics.Event.REFUND.equals(str25);
            boolean zEquals = "_iap".equals(str25);
            zzau zzauVar = zzawVarZza.zzb;
            if (zEquals) {
                strZzg$1 = zzauVar.zzg$1();
                str = str19;
                str2 = str14;
                bundle = zzauVar.zza;
                if (z3) {
                    dDoubleValue = zzauVar.zzd().doubleValue() * 1000000.0d;
                    if (dDoubleValue == 0.0d) {
                        dDoubleValue = bundle.getLong(FirebaseAnalytics.Param.VALUE) * 1000000.0d;
                    }
                    if (dDoubleValue <= 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                        zzay().zzk().zzc(zzeh.zzn(str23), "Data lost. Currency value is too big. appId", Double.valueOf(dDoubleValue));
                        zzam zzamVar7 = this.zze;
                        zzal(zzamVar7);
                        zzamVar7.zzC();
                        zzam zzamVar8 = this.zze;
                        zzal(zzamVar8);
                        zzamVar8.zzx();
                        return;
                    }
                    jRound = Math.round(dDoubleValue);
                    if (FirebaseAnalytics.Event.REFUND.equals(str25)) {
                        jRound = -jRound;
                    }
                } else {
                    str15 = "_sno";
                    jRound = bundle.getLong(FirebaseAnalytics.Param.VALUE);
                }
                if (!TextUtils.isEmpty(strZzg$1)) {
                    upperCase = strZzg$1.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        strConcat = "_ltv_".concat(upperCase);
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzkyVarZzp = zzamVar9.zzp(str23, strConcat);
                        if (zzkyVarZzp != null) {
                            obj = zzkyVarZzp.zze;
                            if (obj instanceof Long) {
                                long jLongValue = ((Long) obj).longValue();
                                String str26 = zzawVarZza.zzc;
                                ((DefaultClock) zzav()).getClass();
                                zzkyVar = new zzky(str23, str26, strConcat, System.currentTimeMillis(), Long.valueOf(jLongValue + jRound));
                                str3 = str20;
                            } else {
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                int iZze = zzg().zze(str23, zzdu.zzD) - 1;
                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str23);
                                zzamVar.zzg();
                                zzamVar.zzW();
                                try {
                                    str3 = str20;
                                    try {
                                        zzamVar.zzh().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str23, str23, String.valueOf(iZze)});
                                    } catch (SQLiteException e) {
                                        e = e;
                                        ((zzfr) zzamVar.mBuilder).zzay().zzd().zzc(zzeh.zzn(str23), "Error pruning currencies. appId", e);
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    str3 = str20;
                                }
                                String str27 = zzawVarZza.zzc;
                                ((DefaultClock) zzav()).getClass();
                                zzkyVar = new zzky(str23, str27, strConcat, System.currentTimeMillis(), Long.valueOf(jRound));
                            }
                        } else {
                            zzamVar = this.zze;
                            zzal(zzamVar);
                            int iZze2 = zzg().zze(str23, zzdu.zzD) - 1;
                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str23);
                            zzamVar.zzg();
                            zzamVar.zzW();
                            str3 = str20;
                            zzamVar.zzh().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str23, str23, String.valueOf(iZze2)});
                            String str28 = zzawVarZza.zzc;
                            ((DefaultClock) zzav()).getClass();
                            zzkyVar = new zzky(str23, str28, strConcat, System.currentTimeMillis(), Long.valueOf(jRound));
                        }
                        zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        if (!zzamVar2.zzL(zzkyVar)) {
                            zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzeh.zzn(str23), zzfrVar.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                            zzv();
                            zzlb.zzN(accessTokenCache, str23, 9, null, null, 0);
                        }
                    }
                }
                str15 = str15;
                str3 = str20;
            } else {
                if (z3) {
                    z3 = true;
                    strZzg$1 = zzauVar.zzg$1();
                    str = str19;
                    str2 = str14;
                    bundle = zzauVar.zza;
                    if (z3) {
                        dDoubleValue = zzauVar.zzd().doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            dDoubleValue = bundle.getLong(FirebaseAnalytics.Param.VALUE) * 1000000.0d;
                        }
                        if (dDoubleValue <= 9.223372036854776E18d) {
                        }
                        zzay().zzk().zzc(zzeh.zzn(str23), "Data lost. Currency value is too big. appId", Double.valueOf(dDoubleValue));
                        zzam zzamVar10 = this.zze;
                        zzal(zzamVar10);
                        zzamVar10.zzC();
                        zzam zzamVar11 = this.zze;
                        zzal(zzamVar11);
                        zzamVar11.zzx();
                        return;
                    }
                    str15 = "_sno";
                    jRound = bundle.getLong(FirebaseAnalytics.Param.VALUE);
                    if (!TextUtils.isEmpty(strZzg$1)) {
                        upperCase = strZzg$1.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            strConcat = "_ltv_".concat(upperCase);
                            zzam zzamVar12 = this.zze;
                            zzal(zzamVar12);
                            zzkyVarZzp = zzamVar12.zzp(str23, strConcat);
                            if (zzkyVarZzp != null) {
                                obj = zzkyVarZzp.zze;
                                if (obj instanceof Long) {
                                    zzamVar = this.zze;
                                    zzal(zzamVar);
                                    int iZze3 = zzg().zze(str23, zzdu.zzD) - 1;
                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str23);
                                    zzamVar.zzg();
                                    zzamVar.zzW();
                                    str3 = str20;
                                    zzamVar.zzh().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str23, str23, String.valueOf(iZze3)});
                                    String str29 = zzawVarZza.zzc;
                                    ((DefaultClock) zzav()).getClass();
                                    zzkyVar = new zzky(str23, str29, strConcat, System.currentTimeMillis(), Long.valueOf(jRound));
                                } else {
                                    long jLongValue2 = ((Long) obj).longValue();
                                    String str210 = zzawVarZza.zzc;
                                    ((DefaultClock) zzav()).getClass();
                                    zzkyVar = new zzky(str23, str210, strConcat, System.currentTimeMillis(), Long.valueOf(jLongValue2 + jRound));
                                    str3 = str20;
                                }
                            } else {
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                int iZze4 = zzg().zze(str23, zzdu.zzD) - 1;
                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str23);
                                zzamVar.zzg();
                                zzamVar.zzW();
                                str3 = str20;
                                zzamVar.zzh().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str23, str23, String.valueOf(iZze4)});
                                String str211 = zzawVarZza.zzc;
                                ((DefaultClock) zzav()).getClass();
                                zzkyVar = new zzky(str23, str211, strConcat, System.currentTimeMillis(), Long.valueOf(jRound));
                            }
                            zzamVar2 = this.zze;
                            zzal(zzamVar2);
                            if (!zzamVar2.zzL(zzkyVar)) {
                                zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzeh.zzn(str23), zzfrVar.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                                zzv();
                                zzlb.zzN(accessTokenCache, str23, 9, null, null, 0);
                            }
                        }
                    }
                    str15 = str15;
                } else {
                    str2 = str14;
                    str15 = "_sno";
                    str = str19;
                }
                str3 = str20;
            }
            boolean zZzai = zzlb.zzai(str25);
            boolean zEquals2 = "_err".equals(str25);
            zzv();
            if (zzauVar == null) {
                length = 0;
            } else {
                Iterator<String> it2 = zzauVar.zza.keySet().iterator();
                length = 0;
                while (it2.hasNext()) {
                    Object objZzf = zzauVar.zzf(it2.next());
                    if (objZzf instanceof Parcelable[]) {
                        length += (long) ((Parcelable[]) objZzf).length;
                    }
                }
            }
            zzam zzamVar13 = this.zze;
            zzal(zzamVar13);
            zzak zzakVarZzm = zzamVar13.zzm(zza(), str23, length + 1, true, zZzai, false, zEquals2, false);
            long j6 = zzakVarZzm.zzb;
            zzg();
            long jIntValue = j6 - ((long) ((Integer) zzdu.zzj.zza(null)).intValue());
            if (jIntValue > 0) {
                if (jIntValue % 1000 == 1) {
                    zzay().zzd().zzc(zzeh.zzn(str23), "Data loss. Too many events logged. appId, count", Long.valueOf(zzakVarZzm.zzb));
                }
                zzam zzamVar14 = this.zze;
                zzal(zzamVar14);
                zzamVar14.zzC();
                zzam zzamVar15 = this.zze;
                zzal(zzamVar15);
                zzamVar15.zzx();
                return;
            }
            if (zZzai) {
                long j7 = zzakVarZzm.zza;
                zzg();
                long jIntValue2 = j7 - ((long) ((Integer) zzdu.zzl.zza(null)).intValue());
                if (jIntValue2 > 0) {
                    if (jIntValue2 % 1000 == 1) {
                        zzay().zzd().zzc(zzeh.zzn(str23), "Data loss. Too many public events logged. appId, count", Long.valueOf(zzakVarZzm.zza));
                    }
                    zzv();
                    zzlb.zzN(accessTokenCache, str23, 16, "_ev", zzawVarZza.zza, 0);
                    zzam zzamVar16 = this.zze;
                    zzal(zzamVar16);
                    zzamVar16.zzC();
                    zzam zzamVar17 = this.zze;
                    zzal(zzamVar17);
                    zzamVar17.zzx();
                    return;
                }
            }
            if (zEquals2) {
                str4 = str3;
                long jMax2 = zzakVarZzm.zzd - ((long) Math.max(0, Math.min(1000000, zzg().zze(str4, zzdu.zzk))));
                if (jMax2 > 0) {
                    if (jMax2 == 1) {
                        zzay().zzd().zzc(zzeh.zzn(str23), "Too many error events logged. appId, count", Long.valueOf(zzakVarZzm.zzd));
                    }
                    zzam zzamVar18 = this.zze;
                    zzal(zzamVar18);
                    zzamVar18.zzC();
                    zzam zzamVar19 = this.zze;
                    zzal(zzamVar19);
                    zzamVar19.zzx();
                    return;
                }
            } else {
                str4 = str3;
            }
            Bundle bundleZzc = zzauVar.zzc();
            zzv().zzO(bundleZzc, "_o", zzawVarZza.zzc);
            if (TextUtils.isEmpty(str23) ? false : ((zzfr) zzv().mBuilder).zzk.zzB("debug.firebase.analytics.app").equals(str23)) {
                zzv().zzO(bundleZzc, "_dbg", 1L);
                zzv().zzO(bundleZzc, "_r", 1L);
            }
            if ("_s".equals(str25)) {
                zzam zzamVar20 = this.zze;
                zzal(zzamVar20);
                String str30 = str15;
                zzky zzkyVarZzp2 = zzamVar20.zzp(str4, str30);
                if (zzkyVarZzp2 != null && (zzkyVarZzp2.zze instanceof Long)) {
                    zzv().zzO(bundleZzc, str30, zzkyVarZzp2.zze);
                }
            }
            zzam zzamVar21 = this.zze;
            zzal(zzamVar21);
            zzfr zzfrVar3 = (zzfr) zzamVar21.mBuilder;
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str23);
            zzamVar21.zzg();
            zzamVar21.zzW();
            try {
                try {
                    try {
                        try {
                            str5 = str2;
                            try {
                                jDelete = zzamVar21.zzh().delete(str5, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str23, String.valueOf(Math.max(0, Math.min(1000000, zzfrVar3.zzk.zze(str23, zzdu.zzo))))});
                                while (true) {
                                    if (!it.hasNext()) {
                                        zzal(zzfiVar);
                                        zZzq = zzfiVar.zzq(zzarVar3.zza, zzarVar3.zzb);
                                        zzam zzamVar22 = this.zze;
                                        zzal(zzamVar22);
                                        zzak zzakVarZzm2 = zzamVar22.zzm(zza(), zzarVar3.zza, 1L, false, false, false, false, false);
                                        if (zZzq) {
                                        }
                                        i2 = 0;
                                        break;
                                    }
                                    str13 = str11;
                                    if (str13.equals(it.next())) {
                                        str11 = str13;
                                    }
                                    i2 = 1;
                                    break;
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                zzfrVar3.zzay().zzd().zzc(zzeh.zzn(str23), "Error deleting over the limit events. appId", e);
                                jDelete = 0;
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            str5 = str2;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        str5 = str2;
                    }
                    try {
                        if (mapZzc != null && !mapZzc.isEmpty()) {
                            zzarVar2 = zzarVar;
                            arrayList = new ArrayList();
                            j3 = j4;
                            int iIntValue = ((Integer) zzdu.zzO.zza(null)).intValue();
                            Iterator it3 = mapZzc.entrySet().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    str12 = str7;
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it3.next();
                                Iterator it4 = it3;
                                str12 = str7;
                                if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                    try {
                                        int i3 = Integer.parseInt((String) entry.getValue());
                                        if (i3 != 0) {
                                            arrayList.add(Integer.valueOf(i3));
                                            if (arrayList.size() >= iIntValue) {
                                                ((zzfr) zzenVar.mBuilder).zzay().zzk().zzb(Integer.valueOf(arrayList.size()), "Too many experiment IDs. Number of IDs");
                                                break;
                                            }
                                            continue;
                                        } else {
                                            continue;
                                        }
                                    } catch (NumberFormatException e6) {
                                        ((zzfr) zzenVar.mBuilder).zzay().zzk().zzb(e6, "Experiment ID NumberFormatException");
                                    }
                                }
                                it3 = it4;
                                str7 = str12;
                            }
                            if (!arrayList.isEmpty()) {
                                if (arrayList != null) {
                                    zzgcVarZzt.zzh(arrayList);
                                }
                                zzaiVarZzc = zzh(str6).zzc(zzai.zzb(str16));
                                zzahVar = zzah.AD_STORAGE;
                                zZzi = zzaiVarZzc.zzi(zzahVar);
                                z = zzqVar.zzo;
                                if (zZzi || !z) {
                                    zzenVar = zzenVar;
                                } else {
                                    zzjo zzjoVar = this.zzk;
                                    zzjoVar.getClass();
                                    Pair pairZza = zzaiVarZzc.zzi(zzahVar) ? zzjoVar.zza(str6) : new Pair("", Boolean.FALSE);
                                    if (!TextUtils.isEmpty((CharSequence) pairZza.first) && z) {
                                        zzgcVarZzt.zzae((String) pairZza.first);
                                        Object obj2 = pairZza.second;
                                        if (obj2 != null) {
                                            zzgcVarZzt.zzX(((Boolean) obj2).booleanValue());
                                        }
                                    }
                                }
                                zzfrVar.zzg().zzu();
                                zzgcVarZzt.zzN(Build.MODEL);
                                zzfrVar.zzg().zzu();
                                zzgcVarZzt.zzY(Build.VERSION.RELEASE);
                                zzgcVarZzt.zzaj((int) zzfrVar.zzg().zzb());
                                zzgcVarZzt.zzan(zzfrVar.zzg().zzc());
                                if (zzfrVar.zzJ()) {
                                    zzgcVarZzt.zzap();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzgcVarZzt.zzO(null);
                                    }
                                }
                                zzam zzamVar23 = this.zze;
                                zzal(zzamVar23);
                                zzhVarZzj = zzamVar23.zzj(str6);
                                if (zzhVarZzj == null) {
                                    zzhVarZzj = new zzh(zzfrVar, str6);
                                    zzhVarZzj.zzH(zzw(zzaiVarZzc));
                                    zzhVarZzj.zzV(zzqVar.zzk);
                                    zzhVarZzj.zzW(str9);
                                    if (zzaiVarZzc.zzi(zzahVar)) {
                                        zzhVarZzj.zzae(this.zzk.zzf(str6, z));
                                    }
                                    zzhVarZzj.zzaa(0L);
                                    zzhVarZzj.zzab(0L);
                                    zzhVarZzj.zzZ(0L);
                                    zzhVarZzj.zzJ(str8);
                                    zzhVarZzj.zzK(j);
                                    zzhVarZzj.zzI(str12);
                                    zzhVarZzj.zzX(j3);
                                    zzhVarZzj.zzS(j2);
                                    zzhVarZzj.zzac(z2);
                                    zzhVarZzj.zzT(zzqVar.zzs);
                                    zzam zzamVar24 = this.zze;
                                    zzal(zzamVar24);
                                    zzamVar24.zzD(zzhVarZzj);
                                }
                                if (zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzhVarZzj.zzu())) {
                                    String strZzu = zzhVarZzj.zzu();
                                    com.google.android.gms.common.internal.zzah.checkNotNull(strZzu);
                                    zzgcVarZzt.zzE(strZzu);
                                }
                                if (!TextUtils.isEmpty(zzhVarZzj.zzx())) {
                                    String strZzx = zzhVarZzj.zzx();
                                    com.google.android.gms.common.internal.zzah.checkNotNull(strZzx);
                                    zzgcVarZzt.zzT(strZzx);
                                }
                                zzam zzamVar25 = this.zze;
                                zzal(zzamVar25);
                                listZzu = zzamVar25.zzu(str6);
                                i = 0;
                                while (i < listZzu.size()) {
                                    com.google.android.gms.internal.measurement.zzgl zzglVarZzd = com.google.android.gms.internal.measurement.zzgm.zzd();
                                    zzglVarZzd.zzf(((zzky) listZzu.get(i)).zzc);
                                    zzglVarZzd.zzg(((zzky) listZzu.get(i)).zzd);
                                    zzal(zzenVar);
                                    zzen zzenVar3 = zzenVar;
                                    zzenVar3.zzu(zzglVarZzd, ((zzky) listZzu.get(i)).zze);
                                    zzgcVarZzt.zzl(zzglVarZzd);
                                    i++;
                                    zzenVar = zzenVar3;
                                }
                                zzamVar3 = this.zze;
                                zzal(zzamVar3);
                                zzgdVar = (zzgd) zzgcVarZzt.zzaC();
                                zzamVar3.zzg();
                                zzamVar3.zzW();
                                com.google.android.gms.common.internal.zzah.checkNotNull(zzgdVar);
                                com.google.android.gms.common.internal.zzah.checkNotEmpty(zzgdVar.zzx());
                                byte[] bArrZzbu = zzgdVar.zzbu();
                                zzen zzenVar4 = zzamVar3.zzf.zzi;
                                zzal(zzenVar4);
                                long jZzd = zzenVar4.zzd(bArrZzbu);
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("app_id", zzgdVar.zzx());
                                contentValues2.put("metadata_fingerprint", Long.valueOf(jZzd));
                                contentValues2.put("metadata", bArrZzbu);
                                zzamVar3.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                zzamVar4 = this.zze;
                                zzal(zzamVar4);
                                zzarVar3 = zzarVar2;
                                it = zzarVar3.zzf.zza.keySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        str13 = str11;
                                        if (str13.equals(it.next())) {
                                            str11 = str13;
                                        }
                                    } else {
                                        zzal(zzfiVar);
                                        zZzq = zzfiVar.zzq(zzarVar3.zza, zzarVar3.zzb);
                                        zzam zzamVar26 = this.zze;
                                        zzal(zzamVar26);
                                        zzak zzakVarZzm3 = zzamVar26.zzm(zza(), zzarVar3.zza, 1L, false, false, false, false, false);
                                        if (zZzq || zzakVarZzm3.zze >= zzg().zze(zzarVar3.zza, zzdu.zzn)) {
                                            i2 = 0;
                                            break;
                                        }
                                    }
                                    i2 = 1;
                                    break;
                                }
                                zzamVar4.zzg();
                                zzamVar4.zzW();
                                com.google.android.gms.common.internal.zzah.checkNotEmpty(zzarVar3.zza);
                                zzen zzenVar5 = zzamVar4.zzf.zzi;
                                zzal(zzenVar5);
                                byte[] bArrZzbu2 = zzenVar5.zzj(zzarVar3).zzbu();
                                contentValues = new ContentValues();
                                contentValues.put("app_id", zzarVar3.zza);
                                contentValues.put("name", zzarVar3.zzb);
                                contentValues.put("timestamp", Long.valueOf(zzarVar3.zzd));
                                contentValues.put(UUFMQdNK.qiOuPuvvYiQnR, Long.valueOf(jZzd));
                                contentValues.put("data", bArrZzbu2);
                                contentValues.put("realtime", Integer.valueOf(i2));
                                if (zzamVar4.zzh().insert(str10, null, contentValues) == -1) {
                                    ((zzfr) zzamVar4.mBuilder).zzay().zzd().zzb(zzeh.zzn(zzarVar3.zza), "Failed to insert raw event (got -1). appId");
                                } else {
                                    this.zza = 0L;
                                }
                                zzam zzamVar27 = this.zze;
                                zzal(zzamVar27);
                                zzamVar27.zzC();
                                zzam zzamVar28 = this.zze;
                                zzal(zzamVar28);
                                zzamVar28.zzx();
                                zzag();
                                zzay().zzj().zzb(Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000), "Background event processing time, ms");
                                return;
                            }
                            zzam zzamVar29 = this.zze;
                            zzal(zzamVar29);
                            zzamVar29.zzx();
                            throw th;
                        }
                        str12 = str7;
                        zzarVar2 = zzarVar;
                        j3 = j4;
                        if (zzamVar4.zzh().insert(str10, null, contentValues) == -1) {
                            ((zzfr) zzamVar4.mBuilder).zzay().zzd().zzb(zzeh.zzn(zzarVar3.zza), "Failed to insert raw event (got -1). appId");
                        } else {
                            this.zza = 0L;
                        }
                    } catch (SQLiteException e7) {
                        ((zzfr) zzamVar4.mBuilder).zzay().zzd().zzc(zzeh.zzn(zzarVar3.zza), "Error storing raw event. appId", e7);
                    }
                    zzamVar3.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                    zzamVar4 = this.zze;
                    zzal(zzamVar4);
                    zzarVar3 = zzarVar2;
                    it = zzarVar3.zzf.zza.keySet().iterator();
                    zzamVar4.zzg();
                    zzamVar4.zzW();
                    com.google.android.gms.common.internal.zzah.checkNotEmpty(zzarVar3.zza);
                    zzen zzenVar6 = zzamVar4.zzf.zzi;
                    zzal(zzenVar6);
                    byte[] bArrZzbu3 = zzenVar6.zzj(zzarVar3).zzbu();
                    contentValues = new ContentValues();
                    contentValues.put("app_id", zzarVar3.zza);
                    contentValues.put("name", zzarVar3.zzb);
                    contentValues.put("timestamp", Long.valueOf(zzarVar3.zzd));
                    contentValues.put(UUFMQdNK.qiOuPuvvYiQnR, Long.valueOf(jZzd));
                    contentValues.put("data", bArrZzbu3);
                    contentValues.put("realtime", Integer.valueOf(i2));
                    zzam zzamVar210 = this.zze;
                    zzal(zzamVar210);
                    zzamVar210.zzC();
                    zzam zzamVar211 = this.zze;
                    zzal(zzamVar211);
                    zzamVar211.zzx();
                    zzag();
                    zzay().zzj().zzb(Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000), "Background event processing time, ms");
                    return;
                } catch (SQLiteException e8) {
                    ((zzfr) zzamVar3.mBuilder).zzay().zzd().zzc(zzeh.zzn(zzgdVar.zzx()), "Error storing raw event metadata. appId", e8);
                    throw e8;
                }
                zzamVar3 = this.zze;
                zzal(zzamVar3);
                zzgdVar = (zzgd) zzgcVarZzt.zzaC();
                zzamVar3.zzg();
                zzamVar3.zzW();
                com.google.android.gms.common.internal.zzah.checkNotNull(zzgdVar);
                com.google.android.gms.common.internal.zzah.checkNotEmpty(zzgdVar.zzx());
                byte[] bArrZzbu4 = zzgdVar.zzbu();
                zzen zzenVar7 = zzamVar3.zzf.zzi;
                zzal(zzenVar7);
                long jZzd2 = zzenVar7.zzd(bArrZzbu4);
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("app_id", zzgdVar.zzx());
                contentValues3.put("metadata_fingerprint", Long.valueOf(jZzd2));
                contentValues3.put("metadata", bArrZzbu4);
            } catch (IOException e9) {
                zzay().zzd().zzc(zzeh.zzn(zzgcVarZzt.zzap()), "Data loss. Failed to insert raw event metadata. appId", e9);
            }
            if (jDelete > 0) {
                zzay().zzk().zzc(zzeh.zzn(str23), "Data lost. Too many events stored on disk, deleted. appId", Long.valueOf(jDelete));
            }
            zzar zzarVar4 = new zzar(this.zzn, zzawVarZza.zzc, str23, zzawVarZza.zza, zzawVarZza.zzd, bundleZzc);
            String str31 = zzarVar4.zzb;
            zzam zzamVar30 = this.zze;
            zzal(zzamVar30);
            zzas zzasVarZzn = zzamVar30.zzn(str23, str31);
            if (zzasVarZzn == null) {
                zzam zzamVar31 = this.zze;
                zzal(zzamVar31);
                long jZzf = zzamVar31.zzf(str23);
                zzag zzagVarZzg2 = zzg();
                zzagVarZzg2.getClass();
                zzdt zzdtVar = zzdu.zzG;
                if (jZzf >= Math.max(Math.min(zzagVarZzg2.zze(str23, zzdtVar), 2000), 500) && zZzai) {
                    zzef zzefVarZzd = zzay().zzd();
                    zzeg zzegVarZzn = zzeh.zzn(str23);
                    String strZzd = zzfrVar.zzj().zzd(str31);
                    zzag zzagVarZzg3 = zzg();
                    zzagVarZzg3.getClass();
                    zzefVarZzd.zzd("Too many event names used, ignoring event. appId, name, supported count", zzegVarZzn, strZzd, Integer.valueOf(Math.max(Math.min(zzagVarZzg3.zze(str23, zzdtVar), 2000), 500)));
                    zzv();
                    zzlb.zzN(accessTokenCache, str23, 8, null, null, 0);
                    zzam zzamVar32 = this.zze;
                    zzal(zzamVar32);
                    zzamVar32.zzx();
                    return;
                }
                zzasVarZzc = new zzas(str23, zzarVar4.zzb, 0L, 0L, 0L, zzarVar4.zzd, 0L, null, null, null, null);
            } else {
                zzarVar4 = zzarVar4.zza(zzfrVar, zzasVarZzn.zzf);
                zzasVarZzc = zzasVarZzn.zzc(zzarVar4.zzd);
            }
            zzam zzamVar33 = this.zze;
            zzal(zzamVar33);
            zzamVar33.zzE(zzasVarZzc);
            zzaz().zzg();
            zzB$1();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(zzarVar4.zza);
            str6 = str4;
            com.google.android.gms.common.internal.zzah.checkArgument(zzarVar4.zza.equals(str6));
            zzgcVarZzt = zzgd.zzt();
            zzgcVarZzt.zzad(1);
            zzgcVarZzt.zzZ("android");
            if (!TextUtils.isEmpty(str6)) {
                zzgcVarZzt.zzD(str6);
            }
            if (TextUtils.isEmpty(str)) {
                str7 = str;
            } else {
                str7 = str;
                zzgcVarZzt.zzF(str7);
            }
            if (TextUtils.isEmpty(str18)) {
                str8 = str18;
            } else {
                str8 = str18;
                zzgcVarZzt.zzG(str8);
            }
            zzpd.zzc();
            if (zzg().zzs(null, zzdu.zzal) && zzg().zzs(str6, zzdu.zzan) && !TextUtils.isEmpty(str17)) {
                zzgcVarZzt.zzah(str17);
            }
            j = zzqVar.zzj;
            if (j != -2147483648L) {
                zzgcVarZzt.zzH((int) j);
            }
            zzgcVarZzt.zzV(j4);
            if (TextUtils.isEmpty(str21)) {
                str9 = str21;
            } else {
                str9 = str21;
                zzgcVarZzt.zzU(str9);
            }
            com.google.android.gms.common.internal.zzah.checkNotNull(str6);
            str10 = str5;
            str11 = "_r";
            zzgcVarZzt.zzL(zzh(str6).zzc(zzai.zzb(str16)).zzh());
            if (zzgcVarZzt.zzaq().isEmpty() && !TextUtils.isEmpty(str22)) {
                zzgcVarZzt.zzC(str22);
            }
            zzarVar = zzarVar4;
            j2 = zzqVar.zzf;
            if (j2 != 0) {
                zzgcVarZzt.zzM(j2);
            }
            zzgcVarZzt.zzP(zzqVar.zzs);
            zzal(zzenVar2);
            zzenVar = zzenVar2;
            mapZzc = zzdu.zzc(zzenVar.zzf.zzn.zzau());
            arrayList = null;
            if (arrayList != null) {
                zzgcVarZzt.zzh(arrayList);
            }
            zzaiVarZzc = zzh(str6).zzc(zzai.zzb(str16));
            zzahVar = zzah.AD_STORAGE;
            zZzi = zzaiVarZzc.zzi(zzahVar);
            z = zzqVar.zzo;
            if (zZzi) {
                zzenVar = zzenVar;
            } else {
                zzenVar = zzenVar;
            }
            zzfrVar.zzg().zzu();
            zzgcVarZzt.zzN(Build.MODEL);
            zzfrVar.zzg().zzu();
            zzgcVarZzt.zzY(Build.VERSION.RELEASE);
            zzgcVarZzt.zzaj((int) zzfrVar.zzg().zzb());
            zzgcVarZzt.zzan(zzfrVar.zzg().zzc());
            if (zzfrVar.zzJ()) {
                zzgcVarZzt.zzap();
                if (!TextUtils.isEmpty(null)) {
                    zzgcVarZzt.zzO(null);
                }
            }
            zzam zzamVar212 = this.zze;
            zzal(zzamVar212);
            zzhVarZzj = zzamVar212.zzj(str6);
            if (zzhVarZzj == null) {
                zzhVarZzj = new zzh(zzfrVar, str6);
                zzhVarZzj.zzH(zzw(zzaiVarZzc));
                zzhVarZzj.zzV(zzqVar.zzk);
                zzhVarZzj.zzW(str9);
                if (zzaiVarZzc.zzi(zzahVar)) {
                    zzhVarZzj.zzae(this.zzk.zzf(str6, z));
                }
                zzhVarZzj.zzaa(0L);
                zzhVarZzj.zzab(0L);
                zzhVarZzj.zzZ(0L);
                zzhVarZzj.zzJ(str8);
                zzhVarZzj.zzK(j);
                zzhVarZzj.zzI(str12);
                zzhVarZzj.zzX(j3);
                zzhVarZzj.zzS(j2);
                zzhVarZzj.zzac(z2);
                zzhVarZzj.zzT(zzqVar.zzs);
                zzam zzamVar213 = this.zze;
                zzal(zzamVar213);
                zzamVar213.zzD(zzhVarZzj);
            }
            if (zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE)) {
                String strZzu2 = zzhVarZzj.zzu();
                com.google.android.gms.common.internal.zzah.checkNotNull(strZzu2);
                zzgcVarZzt.zzE(strZzu2);
            }
            if (!TextUtils.isEmpty(zzhVarZzj.zzx())) {
                String strZzx2 = zzhVarZzj.zzx();
                com.google.android.gms.common.internal.zzah.checkNotNull(strZzx2);
                zzgcVarZzt.zzT(strZzx2);
            }
            zzam zzamVar214 = this.zze;
            zzal(zzamVar214);
            listZzu = zzamVar214.zzu(str6);
            i = 0;
            while (i < listZzu.size()) {
                com.google.android.gms.internal.measurement.zzgl zzglVarZzd2 = com.google.android.gms.internal.measurement.zzgm.zzd();
                zzglVarZzd2.zzf(((zzky) listZzu.get(i)).zzc);
                zzglVarZzd2.zzg(((zzky) listZzu.get(i)).zzd);
                zzal(zzenVar);
                zzen zzenVar8 = zzenVar;
                zzenVar8.zzu(zzglVarZzd2, ((zzky) listZzu.get(i)).zze);
                zzgcVarZzt.zzl(zzglVarZzd2);
                i++;
                zzenVar = zzenVar8;
            }
        } catch (Throwable th) {
            zzam zzamVar215 = this.zze;
            zzal(zzamVar215);
            zzamVar215.zzx();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0091  */
    public final void zzag() {
        boolean z;
        long jMax;
        long jMax2;
        zzaz().zzg();
        zzB$1();
        if (this.zza > 0) {
            ((DefaultClock) zzav()).getClass();
            long jAbs = 3600000 - Math.abs(SystemClock.elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzay().zzl.zzb(Long.valueOf(jAbs), "Upload has been suspended. Will update scheduling later in approximately ms");
                zzm().zzc();
                zzkf zzkfVar = this.zzg;
                zzal(zzkfVar);
                zzkfVar.zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzai()) {
            zzay().zzl.zza("Nothing to upload or uploading impossible");
            zzm().zzc();
            zzkf zzkfVar2 = this.zzg;
            zzal(zzkfVar2);
            zzkfVar2.zza();
            return;
        }
        ((DefaultClock) zzav()).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzg();
        long jMax3 = Math.max(0L, ((Long) zzdu.zzz.zza(null)).longValue());
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        if (zzamVar.zzZ("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            z = true;
        } else {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            if (zzamVar2.zzZ("select count(1) > 0 from queue where has_realtime = 1", null) != 0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            String strZzB = zzg().zzB("debug.firebase.analytics.app");
            if (TextUtils.isEmpty(strZzB) || yzwzcWHcnH.VNqkYg.equals(strZzB)) {
                zzg();
                jMax = Math.max(0L, ((Long) zzdu.zzt.zza(null)).longValue());
            } else {
                zzg();
                jMax = Math.max(0L, ((Long) zzdu.zzu.zza(null)).longValue());
            }
        } else {
            zzg();
            jMax = Math.max(0L, ((Long) zzdu.zzs.zza(null)).longValue());
        }
        long jZza = this.zzk.zzc.zza();
        long jZza2 = this.zzk.zzd.zza();
        zzam zzamVar3 = this.zze;
        zzal(zzamVar3);
        long jZzaa = zzamVar3.zzaa("select max(bundle_end_timestamp) from queue", null, 0L);
        zzam zzamVar4 = this.zze;
        zzal(zzamVar4);
        long j = jMax;
        long jMax4 = Math.max(jZzaa, zzamVar4.zzaa("select max(timestamp) from raw_events", null, 0L));
        zzen zzenVar = this.zzi;
        if (jMax4 != 0) {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jCurrentTimeMillis - jAbs3, jAbs4);
            long jMin = jMax3 + jAbs2;
            if (z && jMax5 > 0) {
                jMin = Math.min(jAbs2, jMax5) + j;
            }
            zzal(zzenVar);
            jMax2 = !zzenVar.zzw(jMax5, j) ? jMax5 + j : jMin;
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzg();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzdu.zzB.zza(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    zzg();
                    jMax2 += Math.max(0L, ((Long) zzdu.zzA.zza(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } else {
            jMax2 = 0;
            break;
        }
        if (jMax2 == 0) {
            zzay().zzl.zza("Next upload time is 0");
            zzm().zzc();
            zzkf zzkfVar3 = this.zzg;
            zzal(zzkfVar3);
            zzkfVar3.zza();
            return;
        }
        zzen zzenVar2 = this.zzd;
        zzal(zzenVar2);
        if (!zzenVar2.zza()) {
            zzay().zzl.zza("No network");
            zzn zznVarZzm = zzm();
            zzkt zzktVar = (zzkt) zznVarZzm.zza;
            zzktVar.zzB$1();
            zzktVar.zzaz().zzg();
            if (!zznVarZzm.zzb) {
                zzktVar.zzn.zze.registerReceiver(zznVarZzm, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                zzen zzenVar3 = zzktVar.zzd;
                zzal(zzenVar3);
                zznVarZzm.zzc = zzenVar3.zza();
                zzktVar.zzay().zzl.zzb(Boolean.valueOf(zznVarZzm.zzc), "Registering connectivity change receiver. Network connected");
                zznVarZzm.zzb = true;
            }
            zzkf zzkfVar4 = this.zzg;
            zzal(zzkfVar4);
            zzkfVar4.zza();
            return;
        }
        long jZza3 = this.zzk.zzb.zza();
        zzg();
        long jMax6 = Math.max(0L, ((Long) zzdu.zzq.zza(null)).longValue());
        zzal(zzenVar);
        if (!zzenVar.zzw(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzm().zzc();
        ((DefaultClock) zzav()).getClass();
        long jCurrentTimeMillis2 = jMax2 - System.currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzg();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzdu.zzv.zza(null)).longValue());
            zzes zzesVar = this.zzk.zzc;
            ((DefaultClock) zzav()).getClass();
            zzesVar.zzb(System.currentTimeMillis());
        }
        zzay().zzl.zzb(Long.valueOf(jCurrentTimeMillis2), "Upload scheduled in approximately ms");
        zzkf zzkfVar5 = this.zzg;
        zzal(zzkfVar5);
        zzkfVar5.zzW();
        zzfr zzfrVar = (zzfr) zzkfVar5.mBuilder;
        zzfrVar.getClass();
        Context context = zzfrVar.zze;
        boolean zZzaj = zzlb.zzaj(context);
        zzeh zzehVar = zzfrVar.zzm;
        if (!zZzaj) {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zza("Receiver not registered/enabled");
        }
        if (!zzlb.zzak(context)) {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zza("Service not registered/enabled");
        }
        zzkfVar5.zza();
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzb(Long.valueOf(jCurrentTimeMillis2), "Scheduling upload, millis");
        zzfrVar.zzr.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() + jCurrentTimeMillis2;
        if (jCurrentTimeMillis2 < Math.max(0L, ((Long) zzdu.zzw.zza(null)).longValue()) && zzkfVar5.zzi().zzd == 0) {
            zzkfVar5.zzi().zzd(jCurrentTimeMillis2);
        }
        if (Build.VERSION.SDK_INT < 24) {
            AlarmManager alarmManager = zzkfVar5.zza;
            if (alarmManager != null) {
                alarmManager.setInexactRepeating(2, jElapsedRealtime, Math.max(((Long) zzdu.zzr.zza(null)).longValue(), jCurrentTimeMillis2), zzkfVar5.zzh());
                return;
            }
            return;
        }
        ComponentName componentName = new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iZzf = zzkfVar5.zzf();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        zzbt.zza(context, new JobInfo.Builder(iZzf, componentName).setMinimumLatency(jCurrentTimeMillis2).setOverrideDeadline(jCurrentTimeMillis2 + jCurrentTimeMillis2).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    /* JADX WARN: Code duplicated, block: B:145:0x03ac A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x03c4 A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x03df A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x03f5 A[Catch: all -> 0x0110, TRY_ENTER, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0405  */
    /* JADX WARN: Code duplicated, block: B:157:0x0407 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0417  */
    /* JADX WARN: Code duplicated, block: B:163:0x041e  */
    /* JADX WARN: Code duplicated, block: B:164:0x0420 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x044e  */
    /* JADX WARN: Code duplicated, block: B:172:0x0453  */
    /* JADX WARN: Code duplicated, block: B:173:0x0454 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0465  */
    /* JADX WARN: Code duplicated, block: B:178:0x046c A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0476 A[Catch: all -> 0x0110, LOOP:3: B:176:0x0466->B:180:0x0476, LOOP_END, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x049e A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x04af  */
    /* JADX WARN: Code duplicated, block: B:196:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:198:0x04f9 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x0509 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x051a  */
    /* JADX WARN: Code duplicated, block: B:211:0x054b  */
    /* JADX WARN: Code duplicated, block: B:226:0x05a8 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:228:0x05b1 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:230:0x05b7 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:231:0x05c0  */
    /* JADX WARN: Code duplicated, block: B:333:0x0863 A[Catch: all -> 0x0110, TRY_ENTER, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:336:0x0871 A[Catch: all -> 0x0110, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:341:0x0892  */
    /* JADX WARN: Code duplicated, block: B:342:0x0894 A[LOOP:11: B:334:0x086b->B:342:0x0894, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:343:0x0897 A[Catch: all -> 0x09fa, TRY_ENTER, TRY_LEAVE, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:348:0x08ad A[Catch: all -> 0x0110, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:350:0x08d0 A[Catch: all -> 0x09fa, TRY_ENTER, TRY_LEAVE, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:352:0x08dc A[Catch: all -> 0x0110, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:356:0x08f3 A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:362:0x0936 A[PHI: r9
  0x0936: PHI (r9v40 com.google.android.gms.measurement.internal.zzas) = (r9v39 com.google.android.gms.measurement.internal.zzas), (r9v50 com.google.android.gms.measurement.internal.zzas) binds: [B:351:0x08da, B:355:0x08f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:365:0x094b  */
    /* JADX WARN: Code duplicated, block: B:367:0x094e  */
    /* JADX WARN: Code duplicated, block: B:369:0x0952 A[Catch: all -> 0x0110, TRY_ENTER, TryCatch #10 {all -> 0x0110, blocks: (B:13:0x006b, B:15:0x007e, B:18:0x0090, B:20:0x009e, B:22:0x00bc, B:25:0x00cc, B:27:0x00d3, B:31:0x00e5, B:33:0x00ef, B:35:0x00f8, B:215:0x056d, B:46:0x0127, B:49:0x0137, B:51:0x013d, B:54:0x015d, B:56:0x0163, B:58:0x0173, B:60:0x0181, B:62:0x0191, B:63:0x019c, B:64:0x019f, B:66:0x01a6, B:69:0x01b6, B:150:0x03df, B:151:0x03eb, B:154:0x03f5, B:160:0x0418, B:157:0x0407, B:182:0x0492, B:184:0x049e, B:187:0x04b1, B:189:0x04c2, B:191:0x04ce, B:214:0x055d, B:198:0x04f9, B:200:0x0509, B:203:0x051c, B:205:0x052d, B:207:0x0539, B:164:0x0420, B:166:0x042c, B:168:0x0438, B:181:0x047c, B:173:0x0454, B:176:0x0466, B:178:0x046c, B:180:0x0476, B:94:0x0210, B:97:0x021a, B:99:0x0228, B:103:0x0269, B:100:0x0242, B:102:0x0250, B:106:0x0272, B:109:0x02a3, B:110:0x02cb, B:112:0x02d8, B:114:0x02f8, B:116:0x0308, B:118:0x030e, B:121:0x031a, B:123:0x0327, B:125:0x0347, B:127:0x0356, B:129:0x0364, B:130:0x0373, B:132:0x0379, B:134:0x0387, B:138:0x039c, B:135:0x0390, B:142:0x03a5, B:145:0x03ac, B:146:0x03c4, B:148:0x03d2, B:220:0x0588, B:222:0x0596, B:224:0x059f, B:226:0x05a8, B:228:0x05b1, B:230:0x05b7, B:233:0x05c3, B:235:0x05cd, B:243:0x05e9, B:245:0x05fb, B:249:0x0610, B:260:0x065b, B:262:0x066a, B:264:0x0670, B:266:0x067a, B:267:0x06a5, B:269:0x06ab, B:271:0x06b9, B:272:0x06bd, B:273:0x06c0, B:278:0x06d7, B:280:0x06e7, B:281:0x06ee, B:283:0x06fa, B:293:0x0779, B:295:0x0792, B:298:0x079d, B:300:0x07aa, B:303:0x07b2, B:305:0x07b6, B:307:0x07ba, B:309:0x07c4, B:310:0x07cc, B:312:0x07d0, B:314:0x07d6, B:315:0x07e2, B:316:0x07eb, B:323:0x0814, B:333:0x0863, B:334:0x086b, B:336:0x0871, B:338:0x0883, B:348:0x08ad, B:352:0x08dc, B:354:0x08e5, B:356:0x08f3, B:358:0x0901, B:360:0x0914, B:369:0x0952, B:371:0x095d, B:373:0x0961, B:375:0x0965, B:377:0x0969, B:378:0x0975, B:385:0x09a0, B:328:0x0821, B:253:0x061a, B:255:0x062b), top: B:560:0x006b, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:380:0x0983 A[Catch: all -> 0x09fa, TRY_ENTER, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:382:0x0989 A[Catch: all -> 0x09fa, TRY_LEAVE, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:384:0x099f  */
    /* JADX WARN: Code duplicated, block: B:401:0x0a0a A[Catch: all -> 0x09fa, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:403:0x0a1b A[Catch: all -> 0x09fa, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:404:0x0a20 A[Catch: all -> 0x09fa, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:407:0x0a2f A[Catch: all -> 0x09fa, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:409:0x0a55 A[Catch: all -> 0x09fa, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:417:0x0aa6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:418:0x0aa8 A[Catch: all -> 0x09fa, TryCatch #19 {all -> 0x09fa, blocks: (B:290:0x075f, B:420:0x0ab9, B:319:0x07fd, B:321:0x0804, B:331:0x083a, B:350:0x08d0, B:363:0x0938, B:380:0x0983, B:382:0x0989, B:386:0x09a4, B:390:0x09ef, B:419:0x0ab6, B:401:0x0a0a, B:403:0x0a1b, B:407:0x0a2f, B:409:0x0a55, B:410:0x0a5c, B:414:0x0a9d, B:418:0x0aa8, B:404:0x0a20, B:343:0x0897, B:345:0x089e, B:421:0x0acb, B:423:0x0add, B:424:0x0ae3, B:425:0x0aeb, B:427:0x0af1), top: B:578:0x075f }] */
    /* JADX WARN: Code duplicated, block: B:499:0x0c83 A[Catch: all -> 0x0b08, TRY_ENTER, TryCatch #7 {all -> 0x0b08, blocks: (B:429:0x0af9, B:436:0x0b1b, B:438:0x0b2e, B:471:0x0bc7, B:473:0x0bcd, B:475:0x0be5, B:478:0x0bec, B:483:0x0c1f, B:485:0x0c28, B:487:0x0c55, B:492:0x0c6c, B:500:0x0ca4, B:501:0x0ca8, B:502:0x0cb3, B:504:0x0cf5, B:505:0x0d02, B:507:0x0d11, B:511:0x0d29, B:513:0x0d40, B:499:0x0c83, B:479:0x0bf4, B:481:0x0c02, B:482:0x0c06, B:518:0x0d5d, B:519:0x0d77, B:522:0x0d7f, B:523:0x0d84, B:524:0x0d94, B:526:0x0dae, B:527:0x0dcb, B:528:0x0dd4, B:533:0x0df5, B:532:0x0de0, B:439:0x0b49, B:441:0x0b4f, B:445:0x0b61, B:447:0x0b68, B:455:0x0b80, B:457:0x0b87, B:460:0x0b97, B:462:0x0bae, B:464:0x0bb5, B:463:0x0bb2, B:456:0x0b84, B:446:0x0b65, B:536:0x0e07), top: B:555:0x0027, inners: #8, #12, #17 }] */
    /* JADX WARN: Code duplicated, block: B:593:0x0418 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x047c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0883 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x0897 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x01f7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [com.google.android.gms.measurement.internal.zzkt] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.gms.measurement.internal.zzkt] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v74 */
    /* JADX WARN: Type inference failed for: r3v75 */
    /* JADX WARN: Type inference failed for: r3v76 */
    /* JADX WARN: Type inference failed for: r3v77 */
    /* JADX WARN: Type inference failed for: r3v78 */
    public final boolean zzah(long j) throws Throwable {
        ?? r3;
        Throwable th;
        ?? r4;
        String str;
        int i;
        zzfr zzfrVar;
        zzfi zzfiVar;
        zzgc zzgcVar;
        zzen zzenVar;
        zzgc zzgcVar2;
        zzfr zzfrVar2;
        zzfi zzfiVar2;
        zzeu zzeuVar;
        zzfr zzfrVar3;
        long j2;
        long j3;
        long jZzc;
        zzft zzftVar;
        Long l;
        int iZzc;
        zzas zzasVarZza;
        Long l2;
        boolean z;
        HashMap map;
        SecureRandom secureRandom;
        zzeu zzeuVar2;
        zzen zzenVar2;
        int i2;
        zzfs zzfsVar;
        zzgc zzgcVar3;
        Long l3;
        long jZzb;
        Long lValueOf;
        Throwable th2;
        int i3;
        zzgc zzgcVar4;
        Long lValueOf2;
        Iterator it;
        zzfx zzfxVar;
        Iterator it2;
        zzfx zzfxVarZzB;
        Long lValueOf3;
        String str2;
        int i4;
        zzfs zzfsVar2;
        String str3;
        String str4;
        zzgc zzgcVar5;
        int i5;
        int i6;
        int i7;
        int i8;
        ArrayList arrayList;
        int i9;
        int i10;
        int i11;
        String strZzh;
        int iCharCount;
        int iCodePointAt;
        byte b;
        zzkt zzktVar = this;
        String str5 = kBfGXgdfpo.LahFnmOBek;
        ?? r5 = "1";
        String str6 = "_ai";
        zzam zzamVar = zzktVar.zze;
        zzal(zzamVar);
        zzamVar.zzw();
        try {
            zzeu zzeuVar3 = new zzeu(zzktVar);
            zzam zzamVar2 = zzktVar.zze;
            zzal(zzamVar2);
            zzamVar2.zzU(j, zzktVar.zzA, zzeuVar3);
            ArrayList arrayList2 = (ArrayList) zzeuVar3.zzd;
            try {
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    zzam zzamVar3 = zzktVar.zze;
                    zzal(zzamVar3);
                    zzamVar3.zzC();
                    zzam zzamVar4 = zzktVar.zze;
                    zzal(zzamVar4);
                    zzamVar4.zzx();
                    return false;
                }
                zzgc zzgcVar6 = (zzgc) ((zzgd) zzeuVar3.zza).zzby();
                zzgcVar6.zzr();
                int i12 = 0;
                int i13 = 0;
                zzfs zzfsVar3 = null;
                int i14 = -1;
                zzfs zzfsVar4 = null;
                int i15 = -1;
                int i16 = 0;
                ?? r6 = "1";
                while (true) {
                    int size = ((ArrayList) zzeuVar3.zzd).size();
                    String str7 = "_fr";
                    str = str5;
                    i = i13;
                    zzfrVar = zzktVar.zzn;
                    int i17 = i14;
                    zzfiVar = zzktVar.zzc;
                    zzgcVar = zzgcVar6;
                    zzenVar = zzktVar.zzi;
                    if (i12 >= size) {
                        break;
                    }
                    try {
                        try {
                            zzfs zzfsVar5 = (zzfs) ((zzft) ((ArrayList) zzeuVar3.zzd).get(i12)).zzby();
                            zzal(zzfiVar);
                            int i18 = i12;
                            if (zzfiVar.zzr(((zzgd) zzeuVar3.zza).zzx(), zzfsVar5.zzo())) {
                                zzay().zzk().zzc(zzeh.zzn(((zzgd) zzeuVar3.zza).zzx()), "Dropping blocked raw event. appId", zzfrVar.zzj().zzd(zzfsVar5.zzo()));
                                zzal(zzfiVar);
                                try {
                                    if (!r6.equals(zzfiVar.zza(((zzgd) zzeuVar3.zza).zzx(), "measurement.upload.blacklist_internal"))) {
                                        zzal(zzfiVar);
                                        try {
                                            if (!r6.equals(zzfiVar.zza(((zzgd) zzeuVar3.zza).zzx(), TSDAbK.zFyPTJ)) && !"_err".equals(zzfsVar5.zzo())) {
                                                zzv();
                                                zzlb.zzN(zzktVar.zzF, ((zzgd) zzeuVar3.zza).zzx(), 11, "_ev", zzfsVar5.zzo(), 0);
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            th = th;
                                            r4 = zzktVar;
                                            zzam zzamVar5 = r4.zze;
                                            zzal(zzamVar5);
                                            zzamVar5.zzx();
                                            throw th;
                                        }
                                    }
                                    str2 = str6;
                                    i13 = i;
                                    i14 = i17;
                                    zzgcVar5 = zzgcVar;
                                    i7 = i18;
                                    int i19 = i7 + 1;
                                    zzgcVar6 = zzgcVar5;
                                    r6 = r6;
                                    str6 = str2;
                                    i12 = i19;
                                    str5 = str;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } else {
                                try {
                                    zzfs zzfsVar6 = zzfsVar3;
                                    if (zzfsVar5.zzo().equals(zzg.zzb(str6, zzg.zzc, zzg.f3zza))) {
                                        zzfsVar5.zzi(str6);
                                        zzay().zzj().zza("Renaming ad_impression to _ai");
                                        if (Log.isLoggable(zzay().zzq(), 5)) {
                                            for (int i20 = 0; i20 < zzfsVar5.zza(); i20++) {
                                                if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzfsVar5.zzn(i20).zzg()) && !zzfsVar5.zzn(i20).zzh().isEmpty() && "admob".equalsIgnoreCase(zzfsVar5.zzn(i20).zzh())) {
                                                    zzay().zzi.zza("AdMob ad impression logged from app. Potentially duplicative.");
                                                }
                                            }
                                        }
                                    }
                                    zzal(zzfiVar);
                                    boolean zZzq = zzfiVar.zzq(((zzgd) zzeuVar3.zza).zzx(), zzfsVar5.zzo());
                                    if (zZzq) {
                                        str2 = str6;
                                        i4 = i15;
                                    } else {
                                        zzal(zzenVar);
                                        String strZzo = zzfsVar5.zzo();
                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzo);
                                        int iHashCode = strZzo.hashCode();
                                        str2 = str6;
                                        i4 = i15;
                                        if (iHashCode != 94660) {
                                            if (iHashCode != 95025) {
                                                if (iHashCode == 95027 && strZzo.equals("_ui")) {
                                                    b = 1;
                                                } else {
                                                    b = -1;
                                                }
                                            } else if (strZzo.equals("_ug")) {
                                                b = 2;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strZzo.equals("_in")) {
                                            b = 0;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0 && b != 1 && b != 2) {
                                            str7 = "_fr";
                                            str4 = "_c";
                                            zzfsVar2 = zzfsVar4;
                                            zZzq = false;
                                        }
                                        if (zZzq) {
                                            arrayList = new ArrayList(zzfsVar5.zzp());
                                            i10 = -1;
                                            i11 = -1;
                                            for (i9 = 0; i9 < arrayList.size(); i9++) {
                                                if (FirebaseAnalytics.Param.VALUE.equals(((zzfx) arrayList.get(i9)).zzg())) {
                                                    i10 = i9;
                                                } else if (FirebaseAnalytics.Param.CURRENCY.equals(((zzfx) arrayList.get(i9)).zzg())) {
                                                    i11 = i9;
                                                }
                                            }
                                            if (i10 != -1) {
                                                if (!((zzfx) arrayList.get(i10)).zzw() || ((zzfx) arrayList.get(i10)).zzu()) {
                                                    if (i11 == -1) {
                                                        strZzh = ((zzfx) arrayList.get(i11)).zzh();
                                                        if (strZzh.length() == 3) {
                                                            iCharCount = 0;
                                                            while (iCharCount < strZzh.length()) {
                                                                iCodePointAt = strZzh.codePointAt(iCharCount);
                                                                if (Character.isLetter(iCodePointAt)) {
                                                                    iCharCount += Character.charCount(iCodePointAt);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    zzay().zzi.zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                    zzfsVar5.zzh(i10);
                                                    zzab(zzfsVar5, str4);
                                                    zzaa(zzfsVar5, 19, FirebaseAnalytics.Param.CURRENCY);
                                                    break;
                                                }
                                                zzay().zzi.zza("Value must be specified with a numeric type.");
                                                zzfsVar5.zzh(i10);
                                                zzab(zzfsVar5, str4);
                                                zzaa(zzfsVar5, 18, FirebaseAnalytics.Param.VALUE);
                                            }
                                        }
                                        if ("_e".equals(zzfsVar5.zzo())) {
                                            zzal(zzenVar);
                                            if (zzen.zzB((zzft) zzfsVar5.zzaC(), str7) != null) {
                                                zzgcVar5 = zzgcVar;
                                                i5 = i4;
                                                i15 = i5;
                                                i14 = i17;
                                                zzfsVar3 = zzfsVar6;
                                                zzfsVar4 = zzfsVar2;
                                            } else if (zzfsVar2 != null || Math.abs(zzfsVar2.zzc() - zzfsVar5.zzc()) > 1000) {
                                                zzgcVar5 = zzgcVar;
                                                i15 = i4;
                                                zzfsVar3 = zzfsVar5;
                                                i14 = i;
                                                zzfsVar4 = zzfsVar2;
                                            } else {
                                                zzfs zzfsVar7 = (zzfs) zzfsVar2.clone();
                                                if (zzktVar.zzaj(zzfsVar5, zzfsVar7)) {
                                                    zzgcVar5 = zzgcVar;
                                                    i8 = i4;
                                                    zzgcVar5.zzS(i8, zzfsVar7);
                                                    i14 = i17;
                                                    zzfsVar3 = null;
                                                    zzfsVar4 = null;
                                                } else {
                                                    zzgcVar5 = zzgcVar;
                                                    i8 = i4;
                                                    zzfsVar3 = zzfsVar5;
                                                    i14 = i;
                                                    zzfsVar4 = zzfsVar2;
                                                }
                                                i15 = i8;
                                            }
                                        } else {
                                            zzgcVar5 = zzgcVar;
                                            i5 = i4;
                                            if ("_vs".equals(zzfsVar5.zzo())) {
                                                zzal(zzenVar);
                                                if (zzen.zzB((zzft) zzfsVar5.zzaC(), "_et") == null) {
                                                    if (zzfsVar6 != null || Math.abs(zzfsVar6.zzc() - zzfsVar5.zzc()) > 1000) {
                                                        zzfsVar4 = zzfsVar5;
                                                        i14 = i17;
                                                        i15 = i;
                                                        zzfsVar3 = zzfsVar6;
                                                    } else {
                                                        zzfs zzfsVar8 = (zzfs) zzfsVar6.clone();
                                                        if (zzktVar.zzaj(zzfsVar8, zzfsVar5)) {
                                                            i6 = i17;
                                                            zzgcVar5.zzS(i6, zzfsVar8);
                                                            i15 = i5;
                                                            zzfsVar3 = null;
                                                            zzfsVar4 = null;
                                                        } else {
                                                            i6 = i17;
                                                            zzfsVar4 = zzfsVar5;
                                                            i15 = i;
                                                            zzfsVar3 = zzfsVar6;
                                                        }
                                                        i14 = i6;
                                                    }
                                                }
                                            }
                                            i15 = i5;
                                            i14 = i17;
                                            zzfsVar3 = zzfsVar6;
                                            zzfsVar4 = zzfsVar2;
                                        }
                                        i7 = i18;
                                        ((ArrayList) zzeuVar3.zzd).set(i7, (zzft) zzfsVar5.zzaC());
                                        i13 = i + 1;
                                        zzgcVar5.zzk(zzfsVar5);
                                        int i110 = i7 + 1;
                                        zzgcVar6 = zzgcVar5;
                                        r6 = r6;
                                        str6 = str2;
                                        i12 = i110;
                                        str5 = str;
                                    }
                                    int i21 = 0;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    while (true) {
                                        zzfsVar2 = zzfsVar4;
                                        if (i21 >= zzfsVar5.zza()) {
                                            break;
                                        }
                                        if ("_c".equals(zzfsVar5.zzn(i21).zzg())) {
                                            zzfw zzfwVar = (zzfw) zzfsVar5.zzn(i21).zzby();
                                            zzfwVar.zzi(1L);
                                            zzfsVar5.zzk(i21, (zzfx) zzfwVar.zzaC());
                                            z2 = true;
                                        } else if ("_r".equals(zzfsVar5.zzn(i21).zzg())) {
                                            zzfw zzfwVar2 = (zzfw) zzfsVar5.zzn(i21).zzby();
                                            zzfwVar2.zzi(1L);
                                            zzfsVar5.zzk(i21, (zzfx) zzfwVar2.zzaC());
                                            z3 = true;
                                        }
                                        i21++;
                                        zzfsVar4 = zzfsVar2;
                                    }
                                    if (!z2 && zZzq) {
                                        zzay().zzj().zzb(zzfrVar.zzj().zzd(zzfsVar5.zzo()), "Marking event as conversion");
                                        zzfw zzfwVarZze = zzfx.zze();
                                        zzfwVarZze.zzj("_c");
                                        zzfwVarZze.zzi(1L);
                                        zzfsVar5.zze(zzfwVarZze);
                                    }
                                    if (!z3) {
                                        zzay().zzj().zzb(zzfrVar.zzj().zzd(zzfsVar5.zzo()), "Marking event as real-time");
                                        zzfw zzfwVarZze2 = zzfx.zze();
                                        zzfwVarZze2.zzj("_r");
                                        zzfwVarZze2.zzi(1L);
                                        zzfsVar5.zze(zzfwVarZze2);
                                    }
                                    zzam zzamVar6 = zzktVar.zze;
                                    zzal(zzamVar6);
                                    String str8 = "_err";
                                    if (zzamVar6.zzm(zza(), ((zzgd) zzeuVar3.zza).zzx(), 1L, false, false, false, false, true).zze > zzg().zze(((zzgd) zzeuVar3.zza).zzx(), zzdu.zzn)) {
                                        zzab(zzfsVar5, "_r");
                                    } else {
                                        i16 = 1;
                                    }
                                    if (zzlb.zzai(zzfsVar5.zzo()) && zZzq) {
                                        zzam zzamVar7 = zzktVar.zze;
                                        zzal(zzamVar7);
                                        if (zzamVar7.zzm(zza(), ((zzgd) zzeuVar3.zza).zzx(), 1L, false, false, true, false, false).zzc > zzg().zze(((zzgd) zzeuVar3.zza).zzx(), zzdu.zzm)) {
                                            zzay().zzk().zzb(zzeh.zzn(((zzgd) zzeuVar3.zza).zzx()), "Too many conversions. Not logging as conversion. appId");
                                            zzfw zzfwVar3 = null;
                                            int i22 = 0;
                                            boolean z4 = false;
                                            int i23 = -1;
                                            while (i22 < zzfsVar5.zza()) {
                                                zzfx zzfxVarZzn = zzfsVar5.zzn(i22);
                                                if ("_c".equals(zzfxVarZzn.zzg())) {
                                                    zzfwVar3 = (zzfw) zzfxVarZzn.zzby();
                                                    i23 = i22;
                                                    str3 = str8;
                                                } else {
                                                    str3 = str8;
                                                    if (str3.equals(zzfxVarZzn.zzg())) {
                                                        z4 = true;
                                                    }
                                                }
                                                i22++;
                                                str8 = str3;
                                            }
                                            String str9 = str8;
                                            if (z4) {
                                                if (zzfwVar3 != null) {
                                                    zzfsVar5.zzh(i23);
                                                } else {
                                                    zzfwVar3 = null;
                                                    if (zzfwVar3 != null) {
                                                        zzfw zzfwVar4 = (zzfw) zzfwVar3.clone();
                                                        zzfwVar4.zzj(str9);
                                                        zzfwVar4.zzi(10L);
                                                        zzfsVar5.zzk(i23, (zzfx) zzfwVar4.zzaC());
                                                    } else {
                                                        zzay().zzd().zzb(zzeh.zzn(((zzgd) zzeuVar3.zza).zzx()), "Did not find conversion parameter. appId");
                                                    }
                                                }
                                            } else if (zzfwVar3 != null) {
                                                zzfw zzfwVar5 = (zzfw) zzfwVar3.clone();
                                                zzfwVar5.zzj(str9);
                                                zzfwVar5.zzi(10L);
                                                zzfsVar5.zzk(i23, (zzfx) zzfwVar5.zzaC());
                                            } else {
                                                zzay().zzd().zzb(zzeh.zzn(((zzgd) zzeuVar3.zza).zzx()), "Did not find conversion parameter. appId");
                                            }
                                        }
                                    }
                                    if (zZzq) {
                                        arrayList = new ArrayList(zzfsVar5.zzp());
                                        i10 = -1;
                                        i11 = -1;
                                        while (i9 < arrayList.size()) {
                                            if (FirebaseAnalytics.Param.VALUE.equals(((zzfx) arrayList.get(i9)).zzg())) {
                                                i10 = i9;
                                            } else if (FirebaseAnalytics.Param.CURRENCY.equals(((zzfx) arrayList.get(i9)).zzg())) {
                                                i11 = i9;
                                            }
                                        }
                                        if (i10 != -1) {
                                            if (((zzfx) arrayList.get(i10)).zzw()) {
                                            }
                                            if (i11 == -1) {
                                                strZzh = ((zzfx) arrayList.get(i11)).zzh();
                                                if (strZzh.length() == 3) {
                                                    iCharCount = 0;
                                                    while (iCharCount < strZzh.length()) {
                                                        iCodePointAt = strZzh.codePointAt(iCharCount);
                                                        if (Character.isLetter(iCodePointAt)) {
                                                            iCharCount += Character.charCount(iCodePointAt);
                                                        }
                                                    }
                                                }
                                            }
                                            zzay().zzi.zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                            zzfsVar5.zzh(i10);
                                            zzab(zzfsVar5, str4);
                                            zzaa(zzfsVar5, 19, FirebaseAnalytics.Param.CURRENCY);
                                            break;
                                        }
                                    }
                                    if ("_e".equals(zzfsVar5.zzo())) {
                                        zzal(zzenVar);
                                        if (zzen.zzB((zzft) zzfsVar5.zzaC(), str7) != null) {
                                            if (zzfsVar2 != null) {
                                            }
                                            zzgcVar5 = zzgcVar;
                                            i15 = i4;
                                            zzfsVar3 = zzfsVar5;
                                            i14 = i;
                                            zzfsVar4 = zzfsVar2;
                                        } else {
                                            zzgcVar5 = zzgcVar;
                                            i5 = i4;
                                            i15 = i5;
                                            i14 = i17;
                                            zzfsVar3 = zzfsVar6;
                                            zzfsVar4 = zzfsVar2;
                                        }
                                    } else {
                                        zzgcVar5 = zzgcVar;
                                        i5 = i4;
                                        if ("_vs".equals(zzfsVar5.zzo())) {
                                            zzal(zzenVar);
                                            if (zzen.zzB((zzft) zzfsVar5.zzaC(), "_et") == null) {
                                                if (zzfsVar6 != null) {
                                                    zzfsVar4 = zzfsVar5;
                                                    i14 = i17;
                                                    i15 = i;
                                                    zzfsVar3 = zzfsVar6;
                                                } else {
                                                    zzfsVar4 = zzfsVar5;
                                                    i14 = i17;
                                                    i15 = i;
                                                    zzfsVar3 = zzfsVar6;
                                                }
                                            }
                                        }
                                        i15 = i5;
                                        i14 = i17;
                                        zzfsVar3 = zzfsVar6;
                                        zzfsVar4 = zzfsVar2;
                                    }
                                    i7 = i18;
                                    ((ArrayList) zzeuVar3.zzd).set(i7, (zzft) zzfsVar5.zzaC());
                                    i13 = i + 1;
                                    zzgcVar5.zzk(zzfsVar5);
                                    int i111 = i7 + 1;
                                    zzgcVar6 = zzgcVar5;
                                    r6 = r6;
                                    str6 = str2;
                                    i12 = i111;
                                    str5 = str;
                                } catch (Throwable th5) {
                                    th = th5;
                                    th = th;
                                    r4 = zzktVar;
                                    zzam zzamVar8 = r4.zze;
                                    zzal(zzamVar8);
                                    zzamVar8.zzx();
                                    throw th;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            th = th;
                            r4 = zzktVar;
                            zzam zzamVar9 = r4.zze;
                            zzal(zzamVar9);
                            zzamVar9.zzx();
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                    zzam zzamVar10 = r4.zze;
                    zzal(zzamVar10);
                    zzamVar10.zzx();
                    throw th;
                }
                zzgc zzgcVar7 = zzgcVar;
                int i24 = i;
                int i25 = 0;
                long jLongValue = 0;
                while (i25 < i24) {
                    zzft zzftVarZze = zzgcVar7.zze(i25);
                    if ("_e".equals(zzftVarZze.zzh())) {
                        zzal(zzenVar);
                        if (zzen.zzB(zzftVarZze, "_fr") != null) {
                            zzgcVar7.zzA(i25);
                            i24--;
                            i25--;
                        } else {
                            zzal(zzenVar);
                            zzfxVarZzB = zzen.zzB(zzftVarZze, "_et");
                            if (zzfxVarZzB != null) {
                                if (zzfxVarZzB.zzw()) {
                                    lValueOf3 = Long.valueOf(zzfxVarZzB.zzd());
                                } else {
                                    lValueOf3 = null;
                                }
                                if (lValueOf3 != null && lValueOf3.longValue() > 0) {
                                    jLongValue += lValueOf3.longValue();
                                }
                            }
                        }
                    } else {
                        zzal(zzenVar);
                        zzfxVarZzB = zzen.zzB(zzftVarZze, "_et");
                        if (zzfxVarZzB != null) {
                            if (zzfxVarZzB.zzw()) {
                                lValueOf3 = Long.valueOf(zzfxVarZzB.zzd());
                            } else {
                                lValueOf3 = null;
                            }
                            if (lValueOf3 != null) {
                                jLongValue += lValueOf3.longValue();
                            }
                        }
                    }
                    i25++;
                }
                zzktVar.zzaf(zzgcVar7, jLongValue, false);
                Iterator it3 = zzgcVar7.zzas().iterator();
                while (it3.hasNext()) {
                    if ("_s".equals(((zzft) it3.next()).zzh())) {
                        zzam zzamVar11 = zzktVar.zze;
                        zzal(zzamVar11);
                        zzamVar11.zzA(zzgcVar7.zzap(), "_se");
                        break;
                    }
                }
                if (zzen.zza(zzgcVar7, "_sid") >= 0) {
                    zzktVar.zzaf(zzgcVar7, jLongValue, true);
                } else {
                    int iZza = zzen.zza(zzgcVar7, "_se");
                    if (iZza >= 0) {
                        zzgcVar7.zzB(iZza);
                        zzay().zzd().zzb(zzeh.zzn(((zzgd) zzeuVar3.zza).zzx()), "Session engagement user property is in the bundle without session ID. appId");
                    }
                }
                zzal(zzenVar);
                zzkt zzktVar2 = zzenVar.zzf;
                zzfr zzfrVar4 = (zzfr) zzenVar.mBuilder;
                zzfrVar4.zzay().zzj().zza("Checking account type status for ad personalization signals");
                zzfi zzfiVar3 = zzktVar2.zzc;
                zzal(zzfiVar3);
                if (zzfiVar3.zzn(zzgcVar7.zzap())) {
                    zzam zzamVar12 = zzktVar2.zze;
                    zzal(zzamVar12);
                    zzh zzhVarZzj = zzamVar12.zzj(zzgcVar7.zzap());
                    if (zzhVarZzj != null && zzhVarZzj.zzah() && zzfrVar4.zzg().zze()) {
                        zzfrVar4.zzay().zzk.zza("Turning off ad personalization due to account type");
                        com.google.android.gms.internal.measurement.zzgl zzglVarZzd = com.google.android.gms.internal.measurement.zzgm.zzd();
                        zzglVarZzd.zzf(str);
                        zzglVarZzd.zzg(zzfrVar4.zzg().zza());
                        zzglVarZzd.zze(1L);
                        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) zzglVarZzd.zzaC();
                        int i26 = 0;
                        while (true) {
                            if (i26 >= zzgcVar7.zzb()) {
                                zzgcVar7.zzm(zzgmVar);
                                break;
                            }
                            if (str.equals(zzgcVar7.zzao(i26).zzf())) {
                                zzgcVar7.zzam(i26, zzgmVar);
                                break;
                            }
                            i26++;
                        }
                    }
                }
                zzgcVar7.zzai(Long.MAX_VALUE);
                zzgcVar7.zzQ(Long.MIN_VALUE);
                for (int i27 = 0; i27 < zzgcVar7.zza(); i27++) {
                    zzft zzftVarZze2 = zzgcVar7.zze(i27);
                    if (zzftVarZze2.zzd() < zzgcVar7.zzd()) {
                        zzgcVar7.zzai(zzftVarZze2.zzd());
                    }
                    if (zzftVarZze2.zzd() > zzgcVar7.zzc()) {
                        zzgcVar7.zzQ(zzftVarZze2.zzd());
                    }
                }
                zzgcVar7.zzz();
                zzgcVar7.zzo();
                zzaa zzaaVar = zzktVar.zzh;
                zzal(zzaaVar);
                zzgcVar7.zzf(zzaaVar.zza(zzgcVar7.zzap(), zzgcVar7.zzas(), zzgcVar7.zzat(), Long.valueOf(zzgcVar7.zzd()), Long.valueOf(zzgcVar7.zzc())));
                if (zzg().zzw(((zzgd) zzeuVar3.zza).zzx())) {
                    HashMap map2 = new HashMap();
                    ArrayList arrayList3 = new ArrayList();
                    SecureRandom secureRandomZzG = zzv().zzG();
                    int i28 = 0;
                    while (i28 < zzgcVar7.zza()) {
                        try {
                            zzfs zzfsVar9 = (zzfs) zzgcVar7.zze(i28).zzby();
                            String str10 = "_efs";
                            if (zzfsVar9.zzo().equals("_ep")) {
                                zzal(zzenVar);
                                String str11 = (String) zzen.zzC((zzft) zzfsVar9.zzaC(), "_en");
                                zzas zzasVarZzn = (zzas) map2.get(str11);
                                if (zzasVarZzn == null) {
                                    zzam zzamVar13 = zzktVar.zze;
                                    zzal(zzamVar13);
                                    zzfrVar3 = zzfrVar;
                                    String strZzx = ((zzgd) zzeuVar3.zza).zzx();
                                    com.google.android.gms.common.internal.zzah.checkNotNull(str11);
                                    zzasVarZzn = zzamVar13.zzn(strZzx, str11);
                                    if (zzasVarZzn != null) {
                                        map2.put(str11, zzasVarZzn);
                                    }
                                } else {
                                    zzfrVar3 = zzfrVar;
                                }
                                if (zzasVarZzn != null && zzasVarZzn.zzi == null) {
                                    Long l4 = zzasVarZzn.zzj;
                                    if (l4 != null && l4.longValue() > 1) {
                                        zzal(zzenVar);
                                        zzen.zzz(zzfsVar9, "_sr", zzasVarZzn.zzj);
                                    }
                                    Boolean bool = zzasVarZzn.zzk;
                                    if (bool != null && bool.booleanValue()) {
                                        zzal(zzenVar);
                                        zzen.zzz(zzfsVar9, "_efs", 1L);
                                    }
                                    arrayList3.add((zzft) zzfsVar9.zzaC());
                                }
                                zzgcVar7.zzS(i28, zzfsVar9);
                                map = map2;
                                secureRandom = secureRandomZzG;
                                zzeuVar2 = zzeuVar3;
                                zzenVar2 = zzenVar;
                                i3 = i28;
                                zzgcVar4 = zzgcVar7;
                                zzfiVar = zzfiVar;
                            } else {
                                zzfrVar3 = zzfrVar;
                                zzal(zzfiVar);
                                try {
                                    String strZzx2 = ((zzgd) zzeuVar3.zza).zzx();
                                    String strZza = zzfiVar.zza(strZzx2, "measurement.account.time_zone_offset_minutes");
                                    if (!TextUtils.isEmpty(strZza)) {
                                        try {
                                            j2 = Long.parseLong(strZza);
                                            str10 = "_efs";
                                        } catch (NumberFormatException e) {
                                            ((zzfr) zzfiVar.mBuilder).zzay().zzk().zzc(zzeh.zzn(strZzx2), "Unable to parse timezone offset. appId", e);
                                            j2 = 0;
                                        }
                                        zzv();
                                        j3 = j2 * 60000;
                                        jZzc = (j3 + zzfsVar9.zzc()) / 86400000;
                                        zzftVar = (zzft) zzfsVar9.zzaC();
                                        l = 1L;
                                        if (TextUtils.isEmpty("_dbg")) {
                                            zzal(zzfiVar);
                                            iZzc = zzfiVar.zzc(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo());
                                        } else {
                                            it = zzftVar.zzi().iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    zzfxVar = (zzfx) it.next();
                                                    it2 = it;
                                                    if ("_dbg".equals(zzfxVar.zzg())) {
                                                        it = it2;
                                                    } else if (!l.equals(Long.valueOf(zzfxVar.zzd()))) {
                                                        iZzc = 1;
                                                    }
                                                }
                                                zzal(zzfiVar);
                                                iZzc = zzfiVar.zzc(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo());
                                            }
                                        }
                                        if (iZzc <= 0) {
                                            zzay().zzk().zzc(zzfsVar9.zzo(), "Sample rate must be positive. event, rate", Integer.valueOf(iZzc));
                                            arrayList3.add((zzft) zzfsVar9.zzaC());
                                            zzgcVar7.zzS(i28, zzfsVar9);
                                            map = map2;
                                            secureRandom = secureRandomZzG;
                                            zzeuVar2 = zzeuVar3;
                                            zzenVar2 = zzenVar;
                                            i3 = i28;
                                            zzgcVar4 = zzgcVar7;
                                            zzfiVar = zzfiVar;
                                        } else {
                                            zzasVarZza = (zzas) map2.get(zzfsVar9.zzo());
                                            if (zzasVarZza == null) {
                                                zzam zzamVar14 = zzktVar.zze;
                                                zzal(zzamVar14);
                                                zzasVarZza = zzamVar14.zzn(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo());
                                                if (zzasVarZza == null) {
                                                    zzay().zzk().zzc(((zzgd) zzeuVar3.zza).zzx(), "Event being bundled has no eventAggregate. appId, eventName", zzfsVar9.zzo());
                                                    zzasVarZza = new zzas(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo(), 1L, 1L, 1L, zzfsVar9.zzc(), 0L, null, null, null, null);
                                                }
                                            }
                                            zzal(zzenVar);
                                            l2 = (Long) zzen.zzC((zzft) zzfsVar9.zzaC(), "_eid");
                                            if (l2 != null) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (iZzc == 1) {
                                                if (secureRandomZzG.nextInt(iZzc) == 0) {
                                                    zzal(zzenVar);
                                                    lValueOf2 = Long.valueOf(iZzc);
                                                    zzen.zzz(zzfsVar9, "_sr", lValueOf2);
                                                    arrayList3.add((zzft) zzfsVar9.zzaC());
                                                    if (z) {
                                                        zzasVarZza = zzasVarZza.zza(null, lValueOf2, null);
                                                    }
                                                    try {
                                                        secureRandom = secureRandomZzG;
                                                        zzeuVar2 = zzeuVar3;
                                                        zzenVar2 = zzenVar;
                                                        i2 = i28;
                                                        zzfsVar = zzfsVar9;
                                                        zzgcVar3 = zzgcVar7;
                                                        map = map2;
                                                        map.put(zzfsVar9.zzo(), new zzas(zzasVarZza.zza, zzasVarZza.zzb, zzasVarZza.zzc, zzasVarZza.zzd, zzasVarZza.zze, zzasVarZza.zzf, zzfsVar9.zzc(), Long.valueOf(jZzc), zzasVarZza.zzi, zzasVarZza.zzj, zzasVarZza.zzk));
                                                        i3 = i2;
                                                        zzgcVar4 = zzgcVar3;
                                                        zzgcVar4.zzS(i3, zzfsVar);
                                                    } catch (Throwable th8) {
                                                        th2 = th8;
                                                        th = th2;
                                                        r4 = this;
                                                        zzam zzamVar15 = r4.zze;
                                                        zzal(zzamVar15);
                                                        zzamVar15.zzx();
                                                        throw th;
                                                    }
                                                } else {
                                                    map = map2;
                                                    secureRandom = secureRandomZzG;
                                                    zzeuVar2 = zzeuVar3;
                                                    zzenVar2 = zzenVar;
                                                    i2 = i28;
                                                    zzfsVar = zzfsVar9;
                                                    zzgcVar3 = zzgcVar7;
                                                    l3 = zzasVarZza.zzh;
                                                    if (l3 != null) {
                                                        jZzb = l3.longValue();
                                                    } else {
                                                        zzv();
                                                        jZzb = (j3 + zzfsVar.zzb()) / 86400000;
                                                    }
                                                    if (jZzb != jZzc) {
                                                        zzal(zzenVar2);
                                                        zzen.zzz(zzfsVar, str10, 1L);
                                                        zzal(zzenVar2);
                                                        lValueOf = Long.valueOf(iZzc);
                                                        zzen.zzz(zzfsVar, "_sr", lValueOf);
                                                        arrayList3.add((zzft) zzfsVar.zzaC());
                                                        if (z) {
                                                            zzasVarZza = zzasVarZza.zza(null, lValueOf, Boolean.TRUE);
                                                        }
                                                        String strZzo2 = zzfsVar.zzo();
                                                        long jZzc2 = zzfsVar.zzc();
                                                        try {
                                                            zzfsVar = zzfsVar;
                                                            map = map;
                                                            map.put(strZzo2, new zzas(zzasVarZza.zza, zzasVarZza.zzb, zzasVarZza.zzc, zzasVarZza.zzd, zzasVarZza.zze, zzasVarZza.zzf, jZzc2, Long.valueOf(jZzc), zzasVarZza.zzi, zzasVarZza.zzj, zzasVarZza.zzk));
                                                        } catch (Throwable th9) {
                                                            th2 = th9;
                                                            th = th2;
                                                            r4 = this;
                                                            zzam zzamVar16 = r4.zze;
                                                            zzal(zzamVar16);
                                                            zzamVar16.zzx();
                                                            throw th;
                                                        }
                                                    } else if (z) {
                                                        map.put(zzfsVar.zzo(), zzasVarZza.zza(l2, null, null));
                                                    }
                                                    i3 = i2;
                                                    zzgcVar4 = zzgcVar3;
                                                    zzgcVar4.zzS(i3, zzfsVar);
                                                }
                                                zzam zzamVar17 = r4.zze;
                                                zzal(zzamVar17);
                                                zzamVar17.zzx();
                                                throw th;
                                            }
                                            arrayList3.add((zzft) zzfsVar9.zzaC());
                                            if (z && (zzasVarZza.zzi != null || zzasVarZza.zzj != null || zzasVarZza.zzk != null)) {
                                                map2.put(zzfsVar9.zzo(), zzasVarZza.zza(null, null, null));
                                            }
                                            zzgcVar7.zzS(i28, zzfsVar9);
                                            map = map2;
                                            secureRandom = secureRandomZzG;
                                            zzeuVar2 = zzeuVar3;
                                            zzenVar2 = zzenVar;
                                            i3 = i28;
                                            zzgcVar4 = zzgcVar7;
                                        }
                                    }
                                    j2 = 0;
                                    zzv();
                                    j3 = j2 * 60000;
                                    jZzc = (j3 + zzfsVar9.zzc()) / 86400000;
                                    zzftVar = (zzft) zzfsVar9.zzaC();
                                    l = 1L;
                                    if (TextUtils.isEmpty("_dbg")) {
                                        it = zzftVar.zzi().iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                zzfxVar = (zzfx) it.next();
                                                it2 = it;
                                                if ("_dbg".equals(zzfxVar.zzg())) {
                                                    it = it2;
                                                } else if (!l.equals(Long.valueOf(zzfxVar.zzd()))) {
                                                    iZzc = 1;
                                                }
                                            }
                                            zzal(zzfiVar);
                                            iZzc = zzfiVar.zzc(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo());
                                        }
                                    } else {
                                        zzal(zzfiVar);
                                        iZzc = zzfiVar.zzc(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo());
                                    }
                                    if (iZzc <= 0) {
                                        zzay().zzk().zzc(zzfsVar9.zzo(), "Sample rate must be positive. event, rate", Integer.valueOf(iZzc));
                                        arrayList3.add((zzft) zzfsVar9.zzaC());
                                        zzgcVar7.zzS(i28, zzfsVar9);
                                        map = map2;
                                        secureRandom = secureRandomZzG;
                                        zzeuVar2 = zzeuVar3;
                                        zzenVar2 = zzenVar;
                                        i3 = i28;
                                        zzgcVar4 = zzgcVar7;
                                        zzfiVar = zzfiVar;
                                    } else {
                                        zzasVarZza = (zzas) map2.get(zzfsVar9.zzo());
                                        if (zzasVarZza == null) {
                                            zzam zzamVar18 = zzktVar.zze;
                                            zzal(zzamVar18);
                                            zzasVarZza = zzamVar18.zzn(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo());
                                            if (zzasVarZza == null) {
                                                zzay().zzk().zzc(((zzgd) zzeuVar3.zza).zzx(), "Event being bundled has no eventAggregate. appId, eventName", zzfsVar9.zzo());
                                                zzasVarZza = new zzas(((zzgd) zzeuVar3.zza).zzx(), zzfsVar9.zzo(), 1L, 1L, 1L, zzfsVar9.zzc(), 0L, null, null, null, null);
                                            }
                                        }
                                        zzal(zzenVar);
                                        l2 = (Long) zzen.zzC((zzft) zzfsVar9.zzaC(), "_eid");
                                        if (l2 != null) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (iZzc == 1) {
                                            if (secureRandomZzG.nextInt(iZzc) == 0) {
                                                zzal(zzenVar);
                                                lValueOf2 = Long.valueOf(iZzc);
                                                zzen.zzz(zzfsVar9, "_sr", lValueOf2);
                                                arrayList3.add((zzft) zzfsVar9.zzaC());
                                                if (z) {
                                                    zzasVarZza = zzasVarZza.zza(null, lValueOf2, null);
                                                }
                                                secureRandom = secureRandomZzG;
                                                zzeuVar2 = zzeuVar3;
                                                zzenVar2 = zzenVar;
                                                i2 = i28;
                                                zzfsVar = zzfsVar9;
                                                zzgcVar3 = zzgcVar7;
                                                map = map2;
                                                map.put(zzfsVar9.zzo(), new zzas(zzasVarZza.zza, zzasVarZza.zzb, zzasVarZza.zzc, zzasVarZza.zzd, zzasVarZza.zze, zzasVarZza.zzf, zzfsVar9.zzc(), Long.valueOf(jZzc), zzasVarZza.zzi, zzasVarZza.zzj, zzasVarZza.zzk));
                                                i3 = i2;
                                                zzgcVar4 = zzgcVar3;
                                                zzgcVar4.zzS(i3, zzfsVar);
                                            } else {
                                                map = map2;
                                                secureRandom = secureRandomZzG;
                                                zzeuVar2 = zzeuVar3;
                                                zzenVar2 = zzenVar;
                                                i2 = i28;
                                                zzfsVar = zzfsVar9;
                                                zzgcVar3 = zzgcVar7;
                                                l3 = zzasVarZza.zzh;
                                                if (l3 != null) {
                                                    jZzb = l3.longValue();
                                                } else {
                                                    zzv();
                                                    jZzb = (j3 + zzfsVar.zzb()) / 86400000;
                                                }
                                                if (jZzb != jZzc) {
                                                    zzal(zzenVar2);
                                                    zzen.zzz(zzfsVar, str10, 1L);
                                                    zzal(zzenVar2);
                                                    lValueOf = Long.valueOf(iZzc);
                                                    zzen.zzz(zzfsVar, "_sr", lValueOf);
                                                    arrayList3.add((zzft) zzfsVar.zzaC());
                                                    if (z) {
                                                        zzasVarZza = zzasVarZza.zza(null, lValueOf, Boolean.TRUE);
                                                    }
                                                    String strZzo3 = zzfsVar.zzo();
                                                    long jZzc3 = zzfsVar.zzc();
                                                    zzfsVar = zzfsVar;
                                                    map = map;
                                                    map.put(strZzo3, new zzas(zzasVarZza.zza, zzasVarZza.zzb, zzasVarZza.zzc, zzasVarZza.zzd, zzasVarZza.zze, zzasVarZza.zzf, jZzc3, Long.valueOf(jZzc), zzasVarZza.zzi, zzasVarZza.zzj, zzasVarZza.zzk));
                                                } else if (z) {
                                                    map.put(zzfsVar.zzo(), zzasVarZza.zza(l2, null, null));
                                                }
                                                i3 = i2;
                                                zzgcVar4 = zzgcVar3;
                                                zzgcVar4.zzS(i3, zzfsVar);
                                            }
                                            zzam zzamVar19 = r4.zze;
                                            zzal(zzamVar19);
                                            zzamVar19.zzx();
                                            throw th;
                                        }
                                        arrayList3.add((zzft) zzfsVar9.zzaC());
                                        if (z) {
                                            map2.put(zzfsVar9.zzo(), zzasVarZza.zza(null, null, null));
                                        }
                                        zzgcVar7.zzS(i28, zzfsVar9);
                                        map = map2;
                                        secureRandom = secureRandomZzG;
                                        zzeuVar2 = zzeuVar3;
                                        zzenVar2 = zzenVar;
                                        i3 = i28;
                                        zzgcVar4 = zzgcVar7;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                }
                            }
                            i28 = i3 + 1;
                            map2 = map;
                            zzgcVar7 = zzgcVar4;
                            zzfrVar = zzfrVar3;
                            zzfiVar = zzfiVar;
                            secureRandomZzG = secureRandom;
                            zzenVar = zzenVar2;
                            zzeuVar3 = zzeuVar2;
                            zzktVar = this;
                        } catch (Throwable th11) {
                            th = th11;
                            r3 = this;
                            th = th;
                            r4 = r3;
                        }
                    }
                    HashMap map3 = map2;
                    zzeu zzeuVar4 = zzeuVar3;
                    zzgcVar2 = zzgcVar7;
                    zzfrVar2 = zzfrVar;
                    zzfiVar2 = zzfiVar;
                    if (arrayList3.size() < zzgcVar2.zza()) {
                        zzgcVar2.zzr();
                        zzgcVar2.zzg(arrayList3);
                    }
                    for (Map.Entry entry : map3.entrySet()) {
                        zzam zzamVar20 = this.zze;
                        zzal(zzamVar20);
                        zzamVar20.zzE((zzas) entry.getValue());
                    }
                    r5 = this;
                    zzeuVar = zzeuVar4;
                } else {
                    r5 = zzktVar;
                    zzgcVar2 = zzgcVar7;
                    zzfrVar2 = zzfrVar;
                    zzfiVar2 = zzfiVar;
                    zzeuVar = zzeuVar3;
                }
                String strZzx3 = ((zzgd) zzeuVar.zza).zzx();
                zzam zzamVar21 = r5.zze;
                zzal(zzamVar21);
                zzh zzhVarZzj2 = zzamVar21.zzj(strZzx3);
                if (zzhVarZzj2 != null) {
                    if (zzgcVar2.zza() > 0) {
                        try {
                            zzfo zzfoVar = zzhVarZzj2.zza.zzn;
                            zzfr.zzR(zzfoVar);
                            zzfoVar.zzg();
                            long j4 = zzhVarZzj2.zzi;
                            if (j4 != 0) {
                                zzgcVar2.zzab(j4);
                            } else {
                                zzgcVar2.zzv();
                            }
                            try {
                                zzfo zzfoVar2 = zzhVarZzj2.zza.zzn;
                                zzfr.zzR(zzfoVar2);
                                zzfoVar2.zzg();
                                long j5 = zzhVarZzj2.zzh;
                                if (j5 != 0) {
                                    j4 = j5;
                                }
                                if (j4 != 0) {
                                    zzgcVar2.zzac(j4);
                                } else {
                                    zzgcVar2.zzw();
                                }
                                zzhVarZzj2.zzE();
                                try {
                                    zzfo zzfoVar3 = zzhVarZzj2.zza.zzn;
                                    zzfr.zzR(zzfoVar3);
                                    zzfoVar3.zzg();
                                    zzgcVar2.zzI((int) zzhVarZzj2.zzg);
                                    zzhVarZzj2.zzab(zzgcVar2.zzd());
                                    zzhVarZzj2.zzZ(zzgcVar2.zzc());
                                    String strZzs = zzhVarZzj2.zzs();
                                    if (strZzs != null) {
                                        zzgcVar2.zzW(strZzs);
                                    } else {
                                        zzgcVar2.zzs();
                                    }
                                    zzam zzamVar22 = r5.zze;
                                    zzal(zzamVar22);
                                    zzamVar22.zzD(zzhVarZzj2);
                                } catch (Throwable th12) {
                                    th = th12;
                                    th = th;
                                    r4 = r5;
                                    zzam zzamVar110 = r4.zze;
                                    zzal(zzamVar110);
                                    zzamVar110.zzx();
                                    throw th;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                            }
                        } catch (Throwable th14) {
                            th = th14;
                        }
                    }
                    zzam zzamVar111 = r4.zze;
                    zzal(zzamVar111);
                    zzamVar111.zzx();
                    throw th;
                }
                zzay().zzd().zzb(zzeh.zzn(((zzgd) zzeuVar.zza).zzx()), "Bundling raw events w/o app info. appId");
                if (zzgcVar2.zza() > 0) {
                    zzfrVar2.getClass();
                    zzal(zzfiVar2);
                    com.google.android.gms.internal.measurement.zzff zzffVarZze = zzfiVar2.zze(((zzgd) zzeuVar.zza).zzx());
                    if (zzffVarZze != null && zzffVarZze.zzs()) {
                        zzgcVar2.zzK(zzffVarZze.zzc());
                    } else if (((zzgd) zzeuVar.zza).zzF().isEmpty()) {
                        zzgcVar2.zzK(-1L);
                    } else {
                        zzay().zzk().zzb(zzeh.zzn(((zzgd) zzeuVar.zza).zzx()), "Did not find measurement config or missing version info. appId");
                    }
                    zzam zzamVar23 = r5.zze;
                    zzal(zzamVar23);
                    zzfr zzfrVar5 = (zzfr) zzamVar23.mBuilder;
                    zzgd zzgdVar = (zzgd) zzgcVar2.zzaC();
                    zzamVar23.zzg();
                    zzamVar23.zzW();
                    com.google.android.gms.common.internal.zzah.checkNotNull(zzgdVar);
                    com.google.android.gms.common.internal.zzah.checkNotEmpty(zzgdVar.zzx());
                    com.google.android.gms.common.internal.zzah.checkState$1(zzgdVar.zzbe());
                    zzamVar23.zzz();
                    try {
                        ((DefaultClock) zzfrVar5.zzav()).getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jZzk = zzgdVar.zzk();
                        zzdt zzdtVar = zzdu.zzC;
                        try {
                            if (jZzk >= jCurrentTimeMillis - ((Long) zzdtVar.zza(null)).longValue()) {
                                try {
                                    if (zzgdVar.zzk() > ((Long) zzdtVar.zza(null)).longValue() + jCurrentTimeMillis) {
                                        zzfrVar5.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeh.zzn(zzgdVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgdVar.zzk()));
                                    }
                                } catch (Throwable th15) {
                                    th = th15;
                                    th = th;
                                    r4 = r5;
                                    zzam zzamVar112 = r4.zze;
                                    zzal(zzamVar112);
                                    zzamVar112.zzx();
                                    throw th;
                                }
                            } else {
                                zzfrVar5.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeh.zzn(zzgdVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgdVar.zzk()));
                            }
                            byte[] bArrZzbu = zzgdVar.zzbu();
                            try {
                                zzen zzenVar3 = zzamVar23.zzf.zzi;
                                zzal(zzenVar3);
                                byte[] bArrZzy = zzenVar3.zzy(bArrZzbu);
                                zzfrVar5.zzay().zzj().zzb(Integer.valueOf(bArrZzy.length), "Saving bundle, size");
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("app_id", zzgdVar.zzx());
                                contentValues.put("bundle_end_timestamp", Long.valueOf(zzgdVar.zzk()));
                                contentValues.put(wsbWxekY.rINtGlsFqcckDaA, bArrZzy);
                                contentValues.put("has_realtime", Integer.valueOf(i16));
                                if (zzgdVar.zzbk()) {
                                    contentValues.put("retry_count", Integer.valueOf(zzgdVar.zze()));
                                }
                                try {
                                    if (zzamVar23.zzh().insert("queue", null, contentValues) == -1) {
                                        zzfrVar5.zzay().zzd().zzb(zzeh.zzn(zzgdVar.zzx()), "Failed to insert bundle (got -1). appId");
                                    }
                                } catch (SQLiteException e2) {
                                    zzfrVar5.zzay().zzd().zzc(zzeh.zzn(zzgdVar.zzx()), "Error storing bundle. appId", e2);
                                }
                            } catch (IOException e3) {
                                zzfrVar5.zzay().zzd().zzc(zzeh.zzn(zzgdVar.zzx()), "Data loss. Failed to serialize bundle. appId", e3);
                            }
                        } catch (Throwable th16) {
                            th = th16;
                        }
                    } catch (Throwable th17) {
                        th = th17;
                    }
                }
                zzam zzamVar24 = r5.zze;
                zzal(zzamVar24);
                ArrayList arrayList4 = (ArrayList) zzeuVar.zzc;
                com.google.android.gms.common.internal.zzah.checkNotNull(arrayList4);
                zzamVar24.zzg();
                zzamVar24.zzW();
                StringBuilder sb = new StringBuilder("rowid in (");
                for (int i29 = 0; i29 < arrayList4.size(); i29++) {
                    if (i29 != 0) {
                        sb.append(",");
                    }
                    sb.append(((Long) arrayList4.get(i29)).longValue());
                }
                sb.append(")");
                int iDelete = zzamVar24.zzh().delete("raw_events", sb.toString(), null);
                if (iDelete != arrayList4.size()) {
                    ((zzfr) zzamVar24.mBuilder).zzay().zzd().zzc(Integer.valueOf(iDelete), "Deleted fewer rows from raw events table than expected", Integer.valueOf(arrayList4.size()));
                }
                zzam zzamVar25 = r5.zze;
                zzal(zzamVar25);
                try {
                    zzamVar25.zzh().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzx3, strZzx3});
                } catch (SQLiteException e4) {
                    ((zzfr) zzamVar25.mBuilder).zzay().zzd().zzc(zzeh.zzn(strZzx3), "Failed to remove unused event metadata. appId", e4);
                }
                zzam zzamVar26 = r5.zze;
                zzal(zzamVar26);
                zzamVar26.zzC();
                zzam zzamVar27 = r5.zze;
                zzal(zzamVar27);
                zzamVar27.zzx();
                return true;
            } catch (Throwable th18) {
                th = th18;
                r3 = r5;
            }
        } catch (Throwable th19) {
            th = th19;
            r3 = zzktVar;
        }
        th = th;
        r4 = r3;
        zzam zzamVar113 = r4.zze;
        zzal(zzamVar113);
        zzamVar113.zzx();
        throw th;
    }
}
