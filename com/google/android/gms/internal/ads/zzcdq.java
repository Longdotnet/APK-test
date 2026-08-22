package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdq extends zzcdn {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    private final File zza(File file) {
        return new File(zzfqt.zza(zzfqs.zza(), this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARN: Code duplicated, block: B:178:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:182:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:183:0x0402  */
    /* JADX WARN: Code duplicated, block: B:186:0x0415  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzt(final String str) {
        int i;
        String str2;
        String str3;
        String str4;
        FileOutputStream fileOutputStream;
        Object obj;
        Object obj2;
        String str5;
        int i2;
        int i3;
        int responseCode;
        String str6;
        boolean zDelete;
        FileOutputStream fileOutputStream2 = null;
        if (this.zzg == null) {
            zzg(str, null, "noCacheDir", null);
            return false;
        }
        do {
            File file = this.zzg;
            if (file == null) {
                i = 0;
            } else {
                i = 0;
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().endsWith(".done")) {
                        i++;
                    }
                }
            }
            zzbcv zzbcvVar = zzbde.zzs;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (i <= ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue()) {
                File file3 = new File(zzfqt.zza(zzfqs.zza(), this.zzg, com.google.android.gms.ads.internal.util.client.zzf.zzE(str, "MD5")));
                File fileZza = zza(file3);
                if (file3.isFile() && fileZza.isFile()) {
                    int length = (int) file3.length();
                    String strValueOf = String.valueOf(str);
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Stream cache hit at ".concat(strValueOf));
                    zzh(str, file3.getAbsolutePath(), length);
                    return true;
                }
                String strValueOf2 = String.valueOf(this.zzg.getAbsolutePath());
                String strValueOf3 = String.valueOf(str);
                Set set = zze;
                String strConcat = strValueOf2.concat(strValueOf3);
                synchronized (set) {
                    try {
                        if (set.contains(strConcat)) {
                            int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache already in progress at " + str);
                            zzg(str, file3.getAbsolutePath(), "inProgress", null);
                            return false;
                        }
                        set.add(strConcat);
                        try {
                            HttpURLConnection httpURLConnectionZzn = zzfrf.zza().zzn(new zzfrq() { // from class: com.google.android.gms.internal.ads.zzcdp
                                @Override // com.google.android.gms.internal.ads.zzfrq
                                public final URLConnection zza() throws IOException {
                                    int i6 = zzcdq.zzd;
                                    zzcal zzcalVar = com.google.android.gms.ads.internal.zzv.zza.zzr;
                                    int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzR)).intValue();
                                    URL url = new URL(str);
                                    int i7 = 0;
                                    while (true) {
                                        i7++;
                                        if (i7 > 20) {
                                            throw new IOException("Too many redirects (20)");
                                        }
                                        URLConnection uRLConnectionOpenConnection = url.openConnection();
                                        uRLConnectionOpenConnection.setConnectTimeout(iIntValue);
                                        uRLConnectionOpenConnection.setReadTimeout(iIntValue);
                                        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                                            throw new IOException("Invalid protocol.");
                                        }
                                        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                                        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl();
                                        zzlVar.zzc(httpURLConnection, null);
                                        httpURLConnection.setInstanceFollowRedirects(false);
                                        int responseCode2 = httpURLConnection.getResponseCode();
                                        zzlVar.zze(httpURLConnection, responseCode2);
                                        if (responseCode2 / 100 != 3) {
                                            return httpURLConnection;
                                        }
                                        String headerField = httpURLConnection.getHeaderField("Location");
                                        if (headerField == null) {
                                            throw new IOException("Missing Location header in redirect");
                                        }
                                        URL url2 = new URL(url, headerField);
                                        String protocol = url2.getProtocol();
                                        if (protocol == null) {
                                            throw new IOException("Protocol is null");
                                        }
                                        if (!protocol.equals("http") && !protocol.equals("https")) {
                                            throw new IOException("Unsupported scheme: ".concat(protocol));
                                        }
                                        String strConcat2 = "Redirecting to ".concat(headerField);
                                        int i8 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                        com.google.android.gms.ads.internal.util.client.zzo.zze(strConcat2);
                                        httpURLConnection.disconnect();
                                        url = url2;
                                    }
                                }
                            }, 265, -1);
                            if (!(httpURLConnectionZzn instanceof HttpURLConnection) || (responseCode = httpURLConnectionZzn.getResponseCode()) < 400) {
                                int contentLength = httpURLConnectionZzn.getContentLength();
                                if (contentLength < 0) {
                                    int i6 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache aborted, missing content-length header at " + str);
                                    zzg(str, file3.getAbsolutePath(), "contentLengthMissing", null);
                                    set.remove(strConcat);
                                    return false;
                                }
                                DecimalFormat decimalFormat = zzf;
                                String str7 = decimalFormat.format(contentLength);
                                int iIntValue = ((Integer) zzbdVar.zzd.zzb(zzbde.zzt)).intValue();
                                if (contentLength > iIntValue) {
                                    int i7 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Content length " + str7 + " exceeds limit at " + str);
                                    zzg(str, file3.getAbsolutePath(), "sizeExceeded", "File too big for full file cache. Size: " + str7);
                                    set.remove(strConcat);
                                    return false;
                                }
                                int i8 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zze("Caching " + str7 + " bytes from " + str);
                                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(httpURLConnectionZzn.getInputStream());
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                                try {
                                    FileChannel channel = fileOutputStream3.getChannel();
                                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1048576);
                                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    zzbcv zzbcvVar2 = zzbde.zzQ;
                                    obj = "error";
                                    try {
                                        com.google.android.gms.ads.internal.util.zzbx zzbxVar = new com.google.android.gms.ads.internal.util.zzbx(((Long) zzbdVar.zzd.zzb(zzbcvVar2)).longValue());
                                        long jLongValue = ((Long) zzbdVar.zzd.zzb(zzbde.zzP)).longValue();
                                        int i9 = 0;
                                        com.google.android.gms.ads.internal.util.zzbx zzbxVar2 = zzbxVar;
                                        while (true) {
                                            int i10 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                            if (i10 >= 0) {
                                                int i11 = i9 + i10;
                                                try {
                                                    try {
                                                        if (i11 > iIntValue) {
                                                            String str8 = "File too big for full file cache. Size: " + Integer.toString(i11);
                                                            throw new IOException("stream cache file size limit exceeded");
                                                        }
                                                        try {
                                                            byteBufferAllocate.flip();
                                                            while (channel.write(byteBufferAllocate) > 0) {
                                                            }
                                                            byteBufferAllocate.clear();
                                                            try {
                                                                if (System.currentTimeMillis() - jCurrentTimeMillis > 1000 * jLongValue) {
                                                                    String str9 = "Timeout exceeded. Limit: " + Long.toString(jLongValue) + " sec";
                                                                    throw new IOException("stream cache time limit exceeded");
                                                                }
                                                                ReadableByteChannel readableByteChannel = readableByteChannelNewChannel;
                                                                if (this.zzh) {
                                                                    throw new IOException(xPQrbOSWiEdU.xwRRE);
                                                                }
                                                                if (zzbxVar2.zzb()) {
                                                                    str5 = strConcat;
                                                                    try {
                                                                        i2 = i11;
                                                                        fileOutputStream = fileOutputStream3;
                                                                        i3 = iIntValue;
                                                                        try {
                                                                            try {
                                                                                com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcdh(this, str, file3.getAbsolutePath(), i2, contentLength, false));
                                                                            } catch (RuntimeException e) {
                                                                                e = e;
                                                                            }
                                                                        } catch (IOException e2) {
                                                                            e = e2;
                                                                        }
                                                                    } catch (IOException e3) {
                                                                        e = e3;
                                                                        fileOutputStream = fileOutputStream3;
                                                                        str2 = str5;
                                                                        obj2 = obj;
                                                                        fileOutputStream2 = fileOutputStream;
                                                                        str4 = 0;
                                                                        str3 = obj2;
                                                                        if (e instanceof RuntimeException) {
                                                                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "VideoStreamFullFileCache.preload");
                                                                        }
                                                                        fileOutputStream2.close();
                                                                        if (this.zzh) {
                                                                            String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload aborted for URL \"", str, "\"");
                                                                            int i12 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                                            com.google.android.gms.ads.internal.util.client.zzo.zzi(strM$1);
                                                                        } else {
                                                                            String strM$2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload failed for URL \"", str, "\"");
                                                                            int i13 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                                            com.google.android.gms.ads.internal.util.client.zzo.zzk(strM$2, e);
                                                                        }
                                                                        if (file3.exists()) {
                                                                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                                        }
                                                                        zzg(str, file3.getAbsolutePath(), str3, str4);
                                                                        zze.remove(str2);
                                                                        return false;
                                                                    } catch (RuntimeException e4) {
                                                                        e = e4;
                                                                        fileOutputStream = fileOutputStream3;
                                                                        str2 = str5;
                                                                        obj2 = obj;
                                                                        fileOutputStream2 = fileOutputStream;
                                                                        str4 = 0;
                                                                        str3 = obj2;
                                                                        if (e instanceof RuntimeException) {
                                                                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "VideoStreamFullFileCache.preload");
                                                                        }
                                                                        fileOutputStream2.close();
                                                                        if (this.zzh) {
                                                                            String strM$3 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload aborted for URL \"", str, "\"");
                                                                            int i14 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                                            com.google.android.gms.ads.internal.util.client.zzo.zzi(strM$3);
                                                                        } else {
                                                                            String strM$4 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload failed for URL \"", str, "\"");
                                                                            int i15 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                                                            com.google.android.gms.ads.internal.util.client.zzo.zzk(strM$4, e);
                                                                        }
                                                                        if (file3.exists()) {
                                                                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                                        }
                                                                        zzg(str, file3.getAbsolutePath(), str3, str4);
                                                                        zze.remove(str2);
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    i2 = i11;
                                                                    fileOutputStream = fileOutputStream3;
                                                                    i3 = iIntValue;
                                                                    str5 = strConcat;
                                                                }
                                                                decimalFormat = decimalFormat;
                                                                readableByteChannelNewChannel = readableByteChannel;
                                                                zzbxVar2 = zzbxVar2;
                                                                strConcat = str5;
                                                                byteBufferAllocate = byteBufferAllocate;
                                                                i9 = i2;
                                                                channel = channel;
                                                                fileOutputStream3 = fileOutputStream;
                                                                iIntValue = i3;
                                                                contentLength = contentLength;
                                                            } catch (IOException e5) {
                                                                e = e5;
                                                                fileOutputStream = fileOutputStream3;
                                                                str5 = strConcat;
                                                            } catch (RuntimeException e6) {
                                                                e = e6;
                                                                fileOutputStream = fileOutputStream3;
                                                                str5 = strConcat;
                                                            }
                                                        } catch (IOException e7) {
                                                            e = e7;
                                                        } catch (RuntimeException e8) {
                                                            e = e8;
                                                        }
                                                        fileOutputStream = fileOutputStream3;
                                                        str5 = strConcat;
                                                        str2 = str5;
                                                        obj2 = obj;
                                                        fileOutputStream2 = fileOutputStream;
                                                        str4 = 0;
                                                        str3 = obj2;
                                                    } catch (IOException | RuntimeException e9) {
                                                        e = e9;
                                                        str4 = zzbcvVar2;
                                                        str2 = str5;
                                                        fileOutputStream2 = fileOutputStream;
                                                        str3 = zzbxVar2;
                                                    }
                                                } catch (IOException | RuntimeException e10) {
                                                    e = e10;
                                                    str2 = str5;
                                                    obj2 = zzbxVar2;
                                                }
                                            } else {
                                                fileOutputStream = fileOutputStream3;
                                                DecimalFormat decimalFormat2 = decimalFormat;
                                                str5 = strConcat;
                                                fileOutputStream.close();
                                                if (com.google.android.gms.ads.internal.util.client.zzo.zzm(3)) {
                                                    com.google.android.gms.ads.internal.util.client.zzo.zze(TSDAbK.CficfNYFQEC + decimalFormat2.format(i9) + xPQrbOSWiEdU.NcgoR + str);
                                                }
                                                file3.setReadable(true, false);
                                                if (fileZza.isFile()) {
                                                    fileZza.setLastModified(System.currentTimeMillis());
                                                } else {
                                                    try {
                                                        fileZza.createNewFile();
                                                    } catch (IOException unused) {
                                                    }
                                                }
                                                zzh(str, file3.getAbsolutePath(), i9);
                                                str2 = str5;
                                                try {
                                                    zze.remove(str2);
                                                    return true;
                                                } catch (IOException e11) {
                                                    e = e11;
                                                } catch (RuntimeException e12) {
                                                    e = e12;
                                                }
                                            }
                                        }
                                    } catch (IOException | RuntimeException e13) {
                                        e = e13;
                                        fileOutputStream = fileOutputStream3;
                                        str2 = strConcat;
                                    }
                                } catch (IOException | RuntimeException e14) {
                                    e = e14;
                                    fileOutputStream = fileOutputStream3;
                                    str2 = strConcat;
                                    obj = "error";
                                }
                            } else {
                                String str10 = "badUrl";
                                try {
                                    String str11 = "HTTP request failed. Code: " + Integer.toString(responseCode);
                                    try {
                                        throw new IOException("HTTP status code " + responseCode + " at " + str);
                                    } catch (IOException | RuntimeException e15) {
                                        e = e15;
                                        str6 = str11;
                                        str2 = strConcat;
                                        str4 = str6;
                                        str3 = str10;
                                        if (e instanceof RuntimeException) {
                                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "VideoStreamFullFileCache.preload");
                                        }
                                        fileOutputStream2.close();
                                        if (this.zzh) {
                                            String strM$5 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload aborted for URL \"", str, "\"");
                                            int i16 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzi(strM$5);
                                        } else {
                                            String strM$6 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload failed for URL \"", str, "\"");
                                            int i17 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzk(strM$6, e);
                                        }
                                        if (file3.exists()) {
                                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                        }
                                        zzg(str, file3.getAbsolutePath(), str3, str4);
                                        zze.remove(str2);
                                        return false;
                                    }
                                } catch (IOException | RuntimeException e16) {
                                    e = e16;
                                    str6 = null;
                                }
                            }
                        } catch (IOException | RuntimeException e17) {
                            e = e17;
                            str2 = strConcat;
                            str3 = "error";
                            str4 = 0;
                            fileOutputStream2 = null;
                        }
                        if (e instanceof RuntimeException) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "VideoStreamFullFileCache.preload");
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException | NullPointerException unused2) {
                        }
                        if (this.zzh) {
                            String strM$7 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload aborted for URL \"", str, "\"");
                            int i18 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi(strM$7);
                        } else {
                            String strM$8 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Preload failed for URL \"", str, "\"");
                            int i19 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzk(strM$8, e);
                        }
                        if (file3.exists() && !file3.delete()) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                        }
                        zzg(str, file3.getAbsolutePath(), str3, str4);
                        zze.remove(str2);
                        return false;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            File file4 = this.zzg;
            if (file4 == null) {
                break;
            }
            long j = Long.MAX_VALUE;
            File file5 = null;
            for (File file6 : file4.listFiles()) {
                if (!file6.getName().endsWith(".done")) {
                    long jLastModified = file6.lastModified();
                    if (jLastModified < j) {
                        file5 = file6;
                        j = jLastModified;
                    }
                }
            }
            if (file5 != null) {
                zDelete = file5.delete();
                File fileZza2 = zza(file5);
                if (fileZza2.isFile()) {
                    zDelete &= fileZza2.delete();
                }
            } else {
                zDelete = false;
            }
        } while (zDelete);
        int i20 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to expire stream cache");
        zzg(str, null, "expireFailed", null);
        return false;
    }

    public zzcdq(zzccb zzccbVar) {
        super(zzccbVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfqt.zza(zzfqs.zza(), cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String strValueOf = String.valueOf(this.zzg.getAbsolutePath());
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(JuorMn.tKCOjhnGrwDrd.concat(strValueOf));
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
            return;
        }
        String strValueOf2 = String.valueOf(this.zzg.getAbsolutePath());
        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not set cache file permissions at ".concat(strValueOf2));
        this.zzg = null;
    }
}
