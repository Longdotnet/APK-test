package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzaqz implements zzapn {
    private final zzaqy zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaqz(zzaqy zzaqyVar, int i) {
        this.zzc = zzaqyVar;
    }

    public static int zze(InputStream inputStream) {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    public static long zzf(InputStream inputStream) {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    public static String zzh(zzaqx zzaqxVar) {
        return new String(zzm(zzaqxVar, zzf(zzaqxVar)), "UTF-8");
    }

    public static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    public static byte[] zzm(zzaqx zzaqxVar, long j) throws IOException {
        long jZza = zzaqxVar.zza();
        if (j >= 0 && j <= jZza) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzaqxVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jZza);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzaqw zzaqwVar) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            this.zzb = (zzaqwVar.zza - ((zzaqw) map.get(str)).zza) + this.zzb;
        } else {
            this.zzb += zzaqwVar.zza;
        }
        map.put(str, zzaqwVar);
    }

    private final void zzp(String str) {
        zzaqw zzaqwVar = (zzaqw) this.zza.remove(str);
        if (zzaqwVar != null) {
            this.zzb -= zzaqwVar.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final synchronized zzapm zza(String str) {
        zzaqw zzaqwVar = (zzaqw) this.zza.get(str);
        if (zzaqwVar == null) {
            return null;
        }
        File fileZzg = zzg(str);
        try {
            zzaqx zzaqxVar = new zzaqx(new BufferedInputStream(new FileInputStream(fileZzg)), fileZzg.length());
            try {
                String str2 = zzaqw.zza(zzaqxVar).zzb;
                if (!TextUtils.equals(str, str2)) {
                    zzaqp.zza("%s: key=%s, found=%s", fileZzg.getAbsolutePath(), str, str2);
                    zzp(str);
                    zzaqxVar.close();
                    return null;
                }
                byte[] bArrZzm = zzm(zzaqxVar, zzaqxVar.zza());
                zzapm zzapmVar = new zzapm();
                zzapmVar.zza = bArrZzm;
                zzapmVar.zzb = zzaqwVar.zzc;
                zzapmVar.zzc = zzaqwVar.zzd;
                zzapmVar.zzd = zzaqwVar.zze;
                zzapmVar.zze = zzaqwVar.zzf;
                zzapmVar.zzf = zzaqwVar.zzg;
                List<zzapv> list = zzaqwVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzapv zzapvVar : list) {
                    treeMap.put(zzapvVar.zza(), zzapvVar.zzb());
                }
                zzapmVar.zzg = treeMap;
                zzapmVar.zzh = Collections.unmodifiableList(list);
                zzaqxVar.close();
                return zzapmVar;
            } catch (Throwable th) {
                zzaqxVar.close();
                throw th;
            }
        } catch (IOException e) {
            zzaqp.zza("%s: %s", fileZzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final synchronized void zzb() {
        synchronized (this) {
            File fileZza = this.zzc.zza();
            if (fileZza.exists()) {
                File[] fileArrListFiles = fileZza.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        try {
                            long length = file.length();
                            zzaqx zzaqxVar = new zzaqx(new BufferedInputStream(new FileInputStream(file)), length);
                            try {
                                zzaqw zzaqwVarZza = zzaqw.zza(zzaqxVar);
                                zzaqwVarZza.zza = length;
                                zzo(zzaqwVarZza.zzb, zzaqwVarZza);
                                zzaqxVar.close();
                            } catch (Throwable th) {
                                zzaqxVar.close();
                                throw th;
                            }
                        } catch (IOException unused) {
                            file.delete();
                        }
                    }
                }
            } else if (!fileZza.mkdirs()) {
                zzaqp.zzb("Unable to create cache dir %s", fileZza.getAbsolutePath());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final synchronized void zzc(String str, boolean z) {
        zzapm zzapmVarZza = zza(str);
        if (zzapmVarZza != null) {
            zzapmVarZza.zzf = 0L;
            zzapmVarZza.zze = 0L;
            zzd(str, zzapmVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final synchronized void zzd(String str, zzapm zzapmVar) {
        try {
            long j = this.zzb;
            int length = zzapmVar.zza.length;
            long j2 = j + ((long) length);
            int i = this.zzd;
            if (j2 <= i || length <= i * 0.9f) {
                File fileZzg = zzg(str);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzg));
                    zzaqw zzaqwVar = new zzaqw(str, zzapmVar);
                    try {
                        zzj(bufferedOutputStream, 538247942);
                        zzl(bufferedOutputStream, zzaqwVar.zzb);
                        String str2 = zzaqwVar.zzc;
                        if (str2 == null) {
                            str2 = "";
                        }
                        zzl(bufferedOutputStream, str2);
                        zzk(bufferedOutputStream, zzaqwVar.zzd);
                        zzk(bufferedOutputStream, zzaqwVar.zze);
                        zzk(bufferedOutputStream, zzaqwVar.zzf);
                        zzk(bufferedOutputStream, zzaqwVar.zzg);
                        List<zzapv> list = zzaqwVar.zzh;
                        if (list != null) {
                            zzj(bufferedOutputStream, list.size());
                            for (zzapv zzapvVar : list) {
                                zzl(bufferedOutputStream, zzapvVar.zza());
                                zzl(bufferedOutputStream, zzapvVar.zzb());
                            }
                        } else {
                            zzj(bufferedOutputStream, 0);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.write(zzapmVar.zza);
                        bufferedOutputStream.close();
                        zzaqwVar.zza = fileZzg.length();
                        zzo(str, zzaqwVar);
                        long j3 = this.zzb;
                        int i2 = this.zzd;
                        if (j3 >= i2) {
                            boolean z = zzaqp.zzb;
                            if (z) {
                                zzaqp.zzd("Pruning old cache entries.", new Object[0]);
                            }
                            long j4 = this.zzb;
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            Iterator it = this.zza.entrySet().iterator();
                            int i3 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    j4 = j4;
                                    break;
                                }
                                zzaqw zzaqwVar2 = (zzaqw) ((Map.Entry) it.next()).getValue();
                                String str3 = zzaqwVar2.zzb;
                                if (zzg(str3).delete()) {
                                    this.zzb -= zzaqwVar2.zza;
                                } else {
                                    zzaqp.zza("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                                }
                                it.remove();
                                i3++;
                                if (this.zzb < i2 * 0.9f) {
                                    break;
                                } else {
                                    j4 = j4;
                                }
                            }
                            if (z) {
                                zzaqp.zzd("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.zzb - j4), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                            }
                        }
                    } catch (IOException e) {
                        zzaqp.zza("%s", e.toString());
                        bufferedOutputStream.close();
                        zzaqp.zza("Failed to write header for %s", fileZzg.getAbsolutePath());
                        throw new IOException();
                    }
                } catch (IOException unused) {
                    if (!fileZzg.delete()) {
                        zzaqp.zza("Could not clean up file %s", fileZzg.getAbsolutePath());
                    }
                    if (!this.zzc.zza().exists()) {
                        zzaqp.zza("Re-initializing cache after external clearing.", new Object[0]);
                        this.zza.clear();
                        this.zzb = 0L;
                        zzb();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean zDelete = zzg(str).delete();
        zzp(str);
        if (zDelete) {
            return;
        }
        zzaqp.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public zzaqz(File file, int i) {
        this.zzc = new zzaqv(this, file);
    }
}
