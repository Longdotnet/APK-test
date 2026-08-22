package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzem implements Runnable {
    public final /* synthetic */ zzen zza;
    public final URL zzb;
    public final byte[] zzc;
    public final zzej zzd;
    public final String zze;
    public final ArrayMap zzf;

    public zzem(zzen zzenVar, String str, URL url, byte[] bArr, ArrayMap arrayMap, zzej zzejVar) {
        this.zza = zzenVar;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzejVar;
        this.zze = str;
        this.zzf = arrayMap;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x00db A[EDGE_INSN: B:102:0x00db->B:38:0x00db BREAK  A[LOOP:1: B:33:0x00cf->B:35:0x00d5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00d5 A[Catch: all -> 0x00d9, LOOP:1: B:33:0x00cf->B:35:0x00d5, LOOP_END, TryCatch #9 {all -> 0x00d9, blocks: (B:32:0x00cd, B:33:0x00cf, B:35:0x00d5, B:38:0x00db), top: B:90:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0142  */
    /* JADX WARN: Code duplicated, block: B:84:0x0175  */
    /* JADX WARN: Code duplicated, block: B:86:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0106: MOVE (r11 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:263), block:B:52:0x0105 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0109: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:266), block:B:53:0x0108 */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException iOException;
        int responseCode;
        Map map2;
        zzee zzeeVar;
        zzfo zzfoVar;
        Map map3;
        Map map4;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i2;
        String str = this.zze;
        zzen zzenVar = this.zza;
        zzfr zzfrVar = (zzfr) zzenVar.mBuilder;
        zzfr zzfrVar2 = (zzfr) zzenVar.mBuilder;
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzax();
        OutputStream outputStream = null;
        try {
            URLConnection uRLConnectionOpenConnection = this.zzb.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzfrVar2.getClass();
            httpURLConnection.setConnectTimeout(60000);
            zzfrVar2.getClass();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                ArrayMap arrayMap = this.zzf;
                if (arrayMap != null) {
                    for (Map.Entry entry : (MapCollections$KeySet) arrayMap.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                byte[] bArr2 = this.zzc;
                if (bArr2 != null) {
                    zzen zzenVar2 = zzenVar.zzf.zzi;
                    zzkt.zzal(zzenVar2);
                    byte[] bArrZzy = zzenVar2.zzy(bArr2);
                    zzeh zzehVar = zzfrVar2.zzm;
                    zzfr.zzR(zzehVar);
                    zzef zzefVar = zzehVar.zzl;
                    int length = bArrZzy.length;
                    zzefVar.zzb(Integer.valueOf(length), "Uploading data. size");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArrZzy);
                        outputStream2.close();
                        responseCode = httpURLConnection.getResponseCode();
                        try {
                            try {
                                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    inputStream = httpURLConnection.getInputStream();
                                    try {
                                        bArr = new byte[1024];
                                        while (true) {
                                            i2 = inputStream.read(bArr);
                                            if (i2 > 0) {
                                                break;
                                            } else {
                                                byteArrayOutputStream.write(bArr, 0, i2);
                                            }
                                        }
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        inputStream.close();
                                        httpURLConnection.disconnect();
                                        zzfoVar = zzfrVar2.zzn;
                                        zzfr.zzR(zzfoVar);
                                        zzeeVar = new zzee(this.zze, this.zzd, responseCode, (IOException) null, byteArray, headerFields);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = null;
                                }
                            } catch (IOException e) {
                                e = e;
                                map2 = map4;
                                iOException = e;
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e2) {
                                        zzeh zzehVar2 = zzfrVar2.zzm;
                                        zzfr.zzR(zzehVar2);
                                        zzehVar2.zzd.zzc(zzeh.zzn(str), "Error closing HTTP compressed POST connection output stream. appId", e2);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                zzfoVar = zzfrVar2.zzn;
                                zzfr.zzR(zzfoVar);
                                zzeeVar = new zzee(this.zze, this.zzd, responseCode, iOException, (byte[]) null, map2);
                            } catch (Throwable th3) {
                                th = th3;
                                i = responseCode;
                                map = map3;
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e3) {
                                        zzeh zzehVar3 = zzfrVar2.zzm;
                                        zzfr.zzR(zzehVar3);
                                        zzehVar3.zzd.zzc(zzeh.zzn(str), "Error closing HTTP compressed POST connection output stream. appId", e3);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                zzfo zzfoVar3 = zzfrVar2.zzn;
                                zzfr.zzR(zzfoVar3);
                                zzfoVar3.zzp(new zzee(this.zze, this.zzd, i, (IOException) null, (byte[]) null, map));
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            map2 = null;
                            iOException = e;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzfoVar = zzfrVar2.zzn;
                            zzfr.zzR(zzfoVar);
                            zzeeVar = new zzee(this.zze, this.zzd, responseCode, iOException, (byte[]) null, map2);
                        } catch (Throwable th4) {
                            th = th4;
                            map = null;
                            i = responseCode;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzfo zzfoVar4 = zzfrVar2.zzn;
                            zzfr.zzR(zzfoVar4);
                            zzfoVar4.zzp(new zzee(this.zze, this.zzd, i, (IOException) null, (byte[]) null, map));
                            throw th;
                        }
                    } catch (IOException e5) {
                        iOException = e5;
                        responseCode = 0;
                        map2 = null;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzfoVar = zzfrVar2.zzn;
                        zzfr.zzR(zzfoVar);
                        zzeeVar = new zzee(this.zze, this.zzd, responseCode, iOException, (byte[]) null, map2);
                        zzfoVar.zzp(zzeeVar);
                    } catch (Throwable th5) {
                        th = th5;
                        i = 0;
                        map = null;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzfo zzfoVar5 = zzfrVar2.zzn;
                        zzfr.zzR(zzfoVar5);
                        zzfoVar5.zzp(new zzee(this.zze, this.zzd, i, (IOException) null, (byte[]) null, map));
                        throw th;
                    }
                } else {
                    responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields2 = httpURLConnection.getHeaderFields();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    inputStream = httpURLConnection.getInputStream();
                    bArr = new byte[1024];
                    while (true) {
                        i2 = inputStream.read(bArr);
                        if (i2 > 0) {
                            break;
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    zzfoVar = zzfrVar2.zzn;
                    zzfr.zzR(zzfoVar);
                    zzeeVar = new zzee(this.zze, this.zzd, responseCode, (IOException) null, byteArray2, headerFields2);
                }
            } catch (IOException e6) {
                iOException = e6;
                responseCode = 0;
                map2 = null;
            } catch (Throwable th6) {
                th = th6;
                i = 0;
                map = null;
            }
            zzfoVar.zzp(zzeeVar);
        } catch (IOException e7) {
            iOException = e7;
            responseCode = 0;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th7) {
            th = th7;
            i = 0;
            httpURLConnection = null;
            map = null;
        }
    }
}
