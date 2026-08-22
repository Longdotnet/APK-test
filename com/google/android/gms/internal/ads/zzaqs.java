package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class zzaqs implements zzapw {
    protected final zzaqu zza;
    private final zzaqr zzb;

    public zzaqs(zzaqr zzaqrVar) {
        zzaqu zzaquVar = new zzaqu(4096);
        this.zzb = zzaqrVar;
        this.zza = zzaquVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapw
    public zzapz zza(zzaqd zzaqdVar) throws Throwable {
        zzarb zzarbVarZza;
        byte[] bArr;
        int i;
        zzarf zzarfVar;
        zzarf zzarfVar2;
        Map mapEmptyMap;
        byte[] bArr2;
        byte[] bArrZzb;
        int i2 = 0;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                zzapm zzapmVarZzd = zzaqdVar.zzd();
                if (zzapmVarZzd == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str = zzapmVarZzd.zzb;
                    if (str != null) {
                        map.put("If-None-Match", str);
                    }
                    long j = zzapmVarZzd.zzd;
                    if (j > 0) {
                        map.put("If-Modified-Since", zzara.zzc(j));
                    }
                    mapEmptyMap = map;
                }
                zzarbVarZza = this.zzb.zza(zzaqdVar, mapEmptyMap);
                try {
                    int iZzb = zzarbVarZza.zzb();
                    List listZzd = zzarbVarZza.zzd();
                    if (iZzb == 304) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        zzapm zzapmVarZzd2 = zzaqdVar.zzd();
                        if (zzapmVarZzd2 == null) {
                            return new zzapz(304, (byte[]) null, true, jElapsedRealtime2, listZzd);
                        }
                        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                        if (!listZzd.isEmpty()) {
                            Iterator it = listZzd.iterator();
                            while (it.hasNext()) {
                                treeSet.add(((zzapv) it.next()).zza());
                            }
                        }
                        ArrayList arrayList = new ArrayList(listZzd);
                        List list = zzapmVarZzd2.zzh;
                        if (list != null) {
                            if (!list.isEmpty()) {
                                for (zzapv zzapvVar : zzapmVarZzd2.zzh) {
                                    if (!treeSet.contains(zzapvVar.zza())) {
                                        arrayList.add(zzapvVar);
                                    }
                                }
                            }
                        } else if (!zzapmVarZzd2.zzg.isEmpty()) {
                            for (Map.Entry entry : zzapmVarZzd2.zzg.entrySet()) {
                                if (!treeSet.contains(entry.getKey())) {
                                    arrayList.add(new zzapv((String) entry.getKey(), (String) entry.getValue()));
                                }
                            }
                        }
                        return new zzapz(304, zzapmVarZzd2.zza, true, jElapsedRealtime2, (List) arrayList);
                    }
                    InputStream inputStreamZzc = zzarbVarZza.zzc();
                    if (inputStreamZzc != null) {
                        int iZza = zzarbVarZza.zza();
                        zzaqu zzaquVar = this.zza;
                        zzarh zzarhVar = new zzarh(zzaquVar, iZza);
                        try {
                            bArrZzb = zzaquVar.zzb(1024);
                            while (true) {
                                try {
                                    int i3 = inputStreamZzc.read(bArrZzb);
                                    if (i3 == -1) {
                                        break;
                                    }
                                    zzarhVar.write(bArrZzb, i2, i3);
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        inputStreamZzc.close();
                                    } catch (IOException unused) {
                                        zzaqp.zzd("Error occurred when closing InputStream", new Object[i2]);
                                    }
                                    zzaquVar.zza(bArrZzb);
                                    zzarhVar.close();
                                    throw th;
                                }
                                e = e;
                                bArr = null;
                                if (e instanceof SocketTimeoutException) {
                                    zzarfVar2 = new zzarf("socket", new zzaql(), null);
                                    i = 0;
                                } else {
                                    if (e instanceof MalformedURLException) {
                                        throw new RuntimeException("Bad URL ".concat(String.valueOf(zzaqdVar.zzk())), e);
                                    }
                                    if (zzarbVarZza == null) {
                                        throw new zzaqa(e);
                                    }
                                    int iZzb2 = zzarbVarZza.zzb();
                                    i = 0;
                                    zzaqp.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb2), zzaqdVar.zzk());
                                    if (bArr != null) {
                                        zzapz zzapzVar = new zzapz(iZzb2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzarbVarZza.zzd());
                                        if (iZzb2 != 401 && iZzb2 != 403) {
                                            if (iZzb2 < 400 || iZzb2 > 499) {
                                                throw new zzaqk(zzapzVar);
                                            }
                                            throw new zzapq(zzapzVar);
                                        }
                                        zzarfVar = new zzarf("auth", new zzapl(zzapzVar), null);
                                    } else {
                                        zzarfVar = new zzarf("network", new zzapy(), null);
                                    }
                                    zzarfVar2 = zzarfVar;
                                }
                                zzapr zzaprVarZzy = zzaqdVar.zzy();
                                int iZzb3 = zzaqdVar.zzb();
                                try {
                                    zzaprVarZzy.zzc(zzarfVar2.zzb);
                                    zzaqdVar.zzm(zzarfVar2.zza + "-retry [timeout=" + iZzb3 + "]");
                                    i2 = i;
                                } catch (zzaqm e) {
                                    zzaqdVar.zzm(zzarfVar2.zza + "-timeout-giveup [timeout=" + iZzb3 + "]");
                                    throw e;
                                }
                            }
                            byte[] byteArray = zzarhVar.toByteArray();
                            try {
                                inputStreamZzc.close();
                            } catch (IOException unused2) {
                                zzaqp.zzd("Error occurred when closing InputStream", new Object[i2]);
                            }
                            zzaquVar.zza(bArrZzb);
                            zzarhVar.close();
                            bArr2 = byteArray;
                        } catch (Throwable th2) {
                            th = th2;
                            bArrZzb = null;
                        }
                    } else {
                        bArr2 = new byte[i2];
                    }
                    try {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (zzaqp.zzb || jElapsedRealtime3 > 3000) {
                            zzaqp.zza("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", zzaqdVar, Long.valueOf(jElapsedRealtime3), bArr2 != null ? Integer.valueOf(bArr2.length) : "null", Integer.valueOf(iZzb), Integer.valueOf(zzaqdVar.zzy().zza()));
                        }
                        if (iZzb < 200 || iZzb > 299) {
                            throw new IOException();
                        }
                        return new zzapz(iZzb, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listZzd);
                    } catch (IOException e2) {
                        e = e2;
                        bArr = bArr2;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e = e4;
                zzarbVarZza = null;
            }
        }
    }
}
