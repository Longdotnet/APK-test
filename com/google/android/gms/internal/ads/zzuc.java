package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzuc {
    public static final /* synthetic */ int zza = 0;
    private static final HashMap zzb = new HashMap();

    public static zzti zza() {
        List listZzd = zzd("audio/raw", false, false);
        if (listZzd.isEmpty()) {
            return null;
        }
        return (zzti) listZzd.get(0);
    }

    public static String zzb(zzz zzzVar) {
        Pair pairZza;
        String str = zzzVar.zzo;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str) && (pairZza = zzdk.zza(zzzVar)) != null) {
            int iIntValue = ((Integer) pairZza.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str)) {
            return "video/hevc";
        }
        return null;
    }

    public static List zzc(zztr zztrVar, zzz zzzVar, boolean z, boolean z2) {
        String strZzb = zzb(zzzVar);
        return strZzb == null ? zzfyq.zzn() : zztrVar.zza(strZzb, z, z2);
    }

    public static List zze(zztr zztrVar, zzz zzzVar, boolean z, boolean z2) {
        List listZza = zztrVar.zza(zzzVar.zzo, z, z2);
        List listZzc = zzc(zztrVar, zzzVar, z, z2);
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        zzfynVar.zzh(listZza);
        zzfynVar.zzh(listZzc);
        return zzfynVar.zzi();
    }

    public static List zzf(List list, final zzz zzzVar) {
        ArrayList arrayList = new ArrayList(list);
        zzh(arrayList, new zzua() { // from class: com.google.android.gms.internal.ads.zztu
            @Override // com.google.android.gms.internal.ads.zzua
            public final int zza(Object obj) {
                int i = zzuc.zza;
                return ((zzti) obj).zze(zzzVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    private static void zzh(List list, final zzua zzuaVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzts
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zzuc.zza;
                zzua zzuaVar2 = zzuaVar;
                return zzuaVar2.zza(obj2) - zzuaVar2.zza(obj);
            }
        });
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzay.zzh(str)) {
            return true;
        }
        String strZza = zzfuv.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }

    public static synchronized List zzd(String str, boolean z, boolean z2) {
        try {
            zztv zztvVar = new zztv(str, z, z2);
            HashMap map = zzb;
            List list = (List) map.get(zztvVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListZzg = zzg(zztvVar, new zztz(z, z2, str.equals("video/mv-hevc")));
            if (z && arrayListZzg.isEmpty() && Build.VERSION.SDK_INT <= 23) {
                arrayListZzg = zzg(zztvVar, new zzty(null));
                if (!arrayListZzg.isEmpty()) {
                    zzea.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzti) arrayListZzg.get(0)).zza);
                }
            }
            if ("audio/raw".equals(str)) {
                if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayListZzg.size() == 1 && ((zzti) arrayListZzg.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    arrayListZzg.add(zzti.zzd("OMX.google.raw.decoder", gZrKCJ.tDYqTdJuone, "audio/raw", null, false, true, false, false, false));
                }
                zzh(arrayListZzg, new zzua() { // from class: com.google.android.gms.internal.ads.zztt
                    @Override // com.google.android.gms.internal.ads.zzua
                    public final int zza(Object obj) {
                        int i = zzuc.zza;
                        String str2 = ((zzti) obj).zza;
                        if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                            return 1;
                        }
                        return (Build.VERSION.SDK_INT >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                    }
                });
            }
            if (Build.VERSION.SDK_INT < 32 && arrayListZzg.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzti) arrayListZzg.get(0)).zza)) {
                arrayListZzg.add((zzti) arrayListZzg.remove(0));
            }
            zzfyq zzfyqVarZzl = zzfyq.zzl(arrayListZzg);
            map.put(zztvVar, zzfyqVarZzl);
            return zzfyqVarZzl;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x017e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0185 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:89:0x0155, B:95:0x016c, B:101:0x017f, B:103:0x0185, B:110:0x019d, B:112:0x01a5, B:113:0x01aa, B:115:0x01ba, B:117:0x01c2, B:106:0x0193), top: B:153:0x0155 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0193 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:89:0x0155, B:95:0x016c, B:101:0x017f, B:103:0x0185, B:110:0x019d, B:112:0x01a5, B:113:0x01aa, B:115:0x01ba, B:117:0x01c2, B:106:0x0193), top: B:153:0x0155 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0199  */
    /* JADX WARN: Code duplicated, block: B:109:0x019b  */
    /* JADX WARN: Code duplicated, block: B:112:0x01a5 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:89:0x0155, B:95:0x016c, B:101:0x017f, B:103:0x0185, B:110:0x019d, B:112:0x01a5, B:113:0x01aa, B:115:0x01ba, B:117:0x01c2, B:106:0x0193), top: B:153:0x0155 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01aa A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:89:0x0155, B:95:0x016c, B:101:0x017f, B:103:0x0185, B:110:0x019d, B:112:0x01a5, B:113:0x01aa, B:115:0x01ba, B:117:0x01c2, B:106:0x0193), top: B:153:0x0155 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x01ba A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:89:0x0155, B:95:0x016c, B:101:0x017f, B:103:0x0185, B:110:0x019d, B:112:0x01a5, B:113:0x01aa, B:115:0x01ba, B:117:0x01c2, B:106:0x0193), top: B:153:0x0155 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:122:0x01d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:126:0x01d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ff A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:153:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0270 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c0 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c9 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00d3 A[Catch: Exception -> 0x0034, LOOP:1: B:49:0x00c7->B:53:0x00d3, LOOP_END, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00de A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e6 A[EDGE_INSN: B:58:0x00e6->B:88:0x0153 BREAK  A[LOOP:1: B:49:0x00c7->B:53:0x00d3]] */
    /* JADX WARN: Code duplicated, block: B:59:0x00ea A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f2 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00fb A[EDGE_INSN: B:64:0x00fb->B:88:0x0153 BREAK  A[LOOP:1: B:49:0x00c7->B:53:0x00d3]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0100 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0108 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0110 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x011b A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0123 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x012e A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0136 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0141 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0149 A[Catch: Exception -> 0x0034, TryCatch #3 {Exception -> 0x0034, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0037, B:16:0x0045, B:20:0x004f, B:22:0x0057, B:24:0x005f, B:26:0x006a, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:40:0x00a4, B:44:0x00b0, B:46:0x00b8, B:48:0x00c0, B:50:0x00c9, B:141:0x0226, B:144:0x022e, B:146:0x0234, B:147:0x024e, B:148:0x026f, B:53:0x00d3, B:54:0x00d6, B:56:0x00de, B:59:0x00ea, B:61:0x00f2, B:66:0x0100, B:68:0x0108, B:70:0x0110, B:73:0x011b, B:75:0x0123, B:78:0x012e, B:80:0x0136, B:83:0x0141, B:85:0x0149), top: B:159:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0165 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0167  */
    /* JADX WARN: Code duplicated, block: B:93:0x0168 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x016a  */
    /* JADX WARN: Code duplicated, block: B:95:0x016c A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:89:0x0155, B:95:0x016c, B:101:0x017f, B:103:0x0185, B:110:0x019d, B:112:0x01a5, B:113:0x01aa, B:115:0x01ba, B:117:0x01c2, B:106:0x0193), top: B:153:0x0155 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0178 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:98:0x017a  */
    /* JADX WARN: Code duplicated, block: B:99:0x017c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:9:0x002d  */
    private static ArrayList zzg(zztv zztvVar, zztx zztxVar) throws zztw {
        String[] supportedTypes;
        int length;
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        String str3;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean zZzd;
        boolean zZzc;
        boolean zZzd2;
        boolean z;
        int i4;
        boolean zIsHardwareAccelerated;
        boolean zZzi;
        String strZza;
        boolean zIsVendor;
        boolean z2;
        zztv zztvVar2 = zztvVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str4 = zztvVar2.zza;
            boolean zZze = zztxVar.zze();
            int i5 = 0;
            for (int iZza = zztxVar.zza(); i5 < iZza; iZza = i3) {
                MediaCodecInfo mediaCodecInfoZzb = zztxVar.zzb(i5);
                int i6 = Build.VERSION.SDK_INT;
                if (i6 < 29 || !mediaCodecInfoZzb.isAlias()) {
                    String name = mediaCodecInfoZzb.getName();
                    if (mediaCodecInfoZzb.isEncoder() || (!zZze && name.endsWith(".secure"))) {
                        i2 = i5;
                        i3 = iZza;
                        str3 = str4;
                    } else if (i6 < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && oKjScaD.uHtKSoHgdCB.equals(Build.MANUFACTURER))) {
                        String str5 = Build.DEVICE;
                        if (str5.startsWith("zeroflte") || str5.startsWith("zerolte") || str5.startsWith("zenlte") || "SC-05G".equals(str5) || "marinelteatt".equals(str5) || "404SC".equals(str5) || "SC-04G".equals(str5) || "SCV31".equals(str5)) {
                            i2 = i5;
                            i3 = iZza;
                            str3 = str4;
                        } else if (i6 > 23) {
                            supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                            length = supportedTypes.length;
                            i = 0;
                            while (true) {
                                if (i >= length) {
                                    if (!str4.equals("video/dolby-vision")) {
                                        if (!str4.equals("video/mv-hevc")) {
                                            if (!str4.equals("audio/alac")) {
                                                if (!str4.equals("audio/flac")) {
                                                    if (!str4.equals("audio/ac3")) {
                                                        str = null;
                                                        break;
                                                    }
                                                    str = null;
                                                    break;
                                                }
                                                if (!str4.equals("audio/ac3")) {
                                                    str = null;
                                                    break;
                                                }
                                                str = null;
                                                break;
                                            }
                                            if (!str4.equals("audio/flac")) {
                                                if (!str4.equals("audio/ac3")) {
                                                    str = null;
                                                    break;
                                                }
                                                str = null;
                                                break;
                                            }
                                            if (!str4.equals("audio/ac3")) {
                                                str = null;
                                                break;
                                            }
                                            str = null;
                                            break;
                                        }
                                        if ("c2.qti.mvhevc.decoder".equals(name)) {
                                        }
                                        str = "video/x-mvhevc";
                                        break;
                                    }
                                    if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                        if ("OMX.RTK.video.decoder".equals(name)) {
                                        }
                                        str = "video/dv_hevc";
                                        break;
                                    }
                                    str = "video/hevcdv";
                                    break;
                                }
                                str = supportedTypes[i];
                                if (str.equalsIgnoreCase(str4)) {
                                    break;
                                    break;
                                }
                                i++;
                            }
                            if (str != null) {
                                capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str);
                                zZzd = zztxVar.zzd("tunneled-playback", str, capabilitiesForType);
                                zZzc = zztxVar.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztvVar2.zzc) {
                                    if (zZzd) {
                                        zZzd2 = zztxVar.zzd("secure-playback", str, capabilitiesForType);
                                        boolean zZzc2 = zztxVar.zzc("secure-playback", str, capabilitiesForType);
                                        z = zztvVar2.zzb;
                                        if (z) {
                                            if (z) {
                                                if (zZzd2) {
                                                    zZzd2 = true;
                                                }
                                            }
                                            i4 = Build.VERSION.SDK_INT;
                                            if (i4 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzi(mediaCodecInfoZzb, str4)) {
                                                zIsHardwareAccelerated = false;
                                            } else {
                                                zIsHardwareAccelerated = true;
                                            }
                                            zZzi = zzi(mediaCodecInfoZzb, str4);
                                            if (i4 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (!zZze) {
                                                z2 = zZzd2;
                                            } else if (z != zZzd2) {
                                                z2 = true;
                                            } else {
                                                boolean z3 = zIsHardwareAccelerated;
                                                str2 = name;
                                                i2 = i5;
                                                i3 = iZza;
                                                str3 = str4;
                                                arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z3, zZzi, zIsVendor, false, false));
                                            }
                                            if (zZze) {
                                            }
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            if (zZze) {
                                                continue;
                                            }
                                        } else {
                                            if (z) {
                                                if (zZzd2) {
                                                    zZzd2 = true;
                                                }
                                            }
                                            i4 = Build.VERSION.SDK_INT;
                                            if (i4 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzi(mediaCodecInfoZzb, str4)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzi = zzi(mediaCodecInfoZzb, str4);
                                            if (i4 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (!zZze) {
                                                z2 = zZzd2;
                                            } else if (z != zZzd2) {
                                                z2 = true;
                                            } else {
                                                boolean z4 = zIsHardwareAccelerated;
                                                str2 = name;
                                                i2 = i5;
                                                i3 = iZza;
                                                str3 = str4;
                                                arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z4, zZzi, zIsVendor, false, false));
                                            }
                                            if (zZze) {
                                            }
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            if (zZze) {
                                                continue;
                                            }
                                        }
                                    }
                                } else if (!zZzc) {
                                    zZzd2 = zztxVar.zzd("secure-playback", str, capabilitiesForType);
                                    boolean zZzc3 = zztxVar.zzc("secure-playback", str, capabilitiesForType);
                                    z = zztvVar2.zzb;
                                    if (z) {
                                        if (z) {
                                            if (zZzd2) {
                                                zZzd2 = true;
                                            }
                                        }
                                        i4 = Build.VERSION.SDK_INT;
                                        if (i4 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzi(mediaCodecInfoZzb, str4)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzi = zzi(mediaCodecInfoZzb, str4);
                                        if (i4 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (!zZze) {
                                            z2 = zZzd2;
                                        } else if (z != zZzd2) {
                                            z2 = true;
                                        } else {
                                            boolean z5 = zIsHardwareAccelerated;
                                            str2 = name;
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z5, zZzi, zIsVendor, false, false));
                                        }
                                        if (zZze) {
                                        }
                                        i2 = i5;
                                        i3 = iZza;
                                        str3 = str4;
                                        if (zZze) {
                                            continue;
                                        }
                                    } else {
                                        if (z) {
                                            if (zZzd2) {
                                                zZzd2 = true;
                                            }
                                        }
                                        i4 = Build.VERSION.SDK_INT;
                                        if (i4 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzi(mediaCodecInfoZzb, str4)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzi = zzi(mediaCodecInfoZzb, str4);
                                        if (i4 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (!zZze) {
                                            z2 = zZzd2;
                                        } else if (z != zZzd2) {
                                            z2 = true;
                                        } else {
                                            boolean z6 = zIsHardwareAccelerated;
                                            str2 = name;
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z6, zZzi, zIsVendor, false, false));
                                        }
                                        if (zZze) {
                                        }
                                        i2 = i5;
                                        i3 = iZza;
                                        str3 = str4;
                                        if (zZze) {
                                            continue;
                                        }
                                    }
                                }
                                i2 = i5;
                                i3 = iZza;
                                str3 = str4;
                            } else {
                                i2 = i5;
                                i3 = iZza;
                                str3 = str4;
                            }
                        } else {
                            supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                            length = supportedTypes.length;
                            i = 0;
                            while (true) {
                                if (i >= length) {
                                    if (!str4.equals("video/dolby-vision")) {
                                        if (!str4.equals("video/mv-hevc")) {
                                            if (!str4.equals("audio/alac")) {
                                                if (!str4.equals("audio/flac")) {
                                                    if (!str4.equals("audio/ac3")) {
                                                        str = null;
                                                        break;
                                                    }
                                                    str = null;
                                                    break;
                                                }
                                                if (!str4.equals("audio/ac3")) {
                                                    str = null;
                                                    break;
                                                }
                                                str = null;
                                                break;
                                            }
                                            if (!str4.equals("audio/flac")) {
                                                if (!str4.equals("audio/ac3")) {
                                                    str = null;
                                                    break;
                                                }
                                                str = null;
                                                break;
                                            }
                                            if (!str4.equals("audio/ac3")) {
                                                str = null;
                                                break;
                                            }
                                            str = null;
                                            break;
                                        }
                                        if ("c2.qti.mvhevc.decoder".equals(name)) {
                                        }
                                        str = "video/x-mvhevc";
                                        break;
                                    }
                                    if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                        if ("OMX.RTK.video.decoder".equals(name)) {
                                        }
                                        str = "video/dv_hevc";
                                        break;
                                    }
                                    str = "video/hevcdv";
                                    break;
                                }
                                str = supportedTypes[i];
                                if (str.equalsIgnoreCase(str4)) {
                                    break;
                                    break;
                                }
                                i++;
                            }
                            if (str != null) {
                                capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str);
                                zZzd = zztxVar.zzd("tunneled-playback", str, capabilitiesForType);
                                zZzc = zztxVar.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztvVar2.zzc) {
                                    if (!zZzc) {
                                        zZzd2 = zztxVar.zzd("secure-playback", str, capabilitiesForType);
                                        boolean zZzc4 = zztxVar.zzc("secure-playback", str, capabilitiesForType);
                                        z = zztvVar2.zzb;
                                        if (z) {
                                            if (z) {
                                                if (zZzd2) {
                                                    zZzd2 = true;
                                                }
                                            }
                                            i4 = Build.VERSION.SDK_INT;
                                            if (i4 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzi(mediaCodecInfoZzb, str4)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzi = zzi(mediaCodecInfoZzb, str4);
                                            if (i4 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (!zZze) {
                                                z2 = zZzd2;
                                            } else if (z != zZzd2) {
                                                z2 = true;
                                            } else {
                                                boolean z7 = zIsHardwareAccelerated;
                                                str2 = name;
                                                i2 = i5;
                                                i3 = iZza;
                                                str3 = str4;
                                                arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z7, zZzi, zIsVendor, false, false));
                                            }
                                            if (zZze) {
                                            }
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            if (zZze) {
                                                continue;
                                            }
                                        } else {
                                            if (z) {
                                                if (zZzd2) {
                                                    zZzd2 = true;
                                                }
                                            }
                                            i4 = Build.VERSION.SDK_INT;
                                            if (i4 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzi(mediaCodecInfoZzb, str4)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzi = zzi(mediaCodecInfoZzb, str4);
                                            if (i4 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (!zZze) {
                                                z2 = zZzd2;
                                            } else if (z != zZzd2) {
                                                z2 = true;
                                            } else {
                                                boolean z8 = zIsHardwareAccelerated;
                                                str2 = name;
                                                i2 = i5;
                                                i3 = iZza;
                                                str3 = str4;
                                                arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z8, zZzi, zIsVendor, false, false));
                                            }
                                            if (zZze) {
                                            }
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            if (zZze) {
                                                continue;
                                            }
                                        }
                                    }
                                } else if (zZzd) {
                                    zZzd2 = zztxVar.zzd("secure-playback", str, capabilitiesForType);
                                    boolean zZzc5 = zztxVar.zzc("secure-playback", str, capabilitiesForType);
                                    z = zztvVar2.zzb;
                                    if (z) {
                                        if (z) {
                                            if (zZzd2) {
                                                zZzd2 = true;
                                            }
                                        }
                                        i4 = Build.VERSION.SDK_INT;
                                        if (i4 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzi(mediaCodecInfoZzb, str4)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzi = zzi(mediaCodecInfoZzb, str4);
                                        if (i4 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (!zZze) {
                                            z2 = zZzd2;
                                        } else if (z != zZzd2) {
                                            z2 = true;
                                        } else {
                                            boolean z9 = zIsHardwareAccelerated;
                                            str2 = name;
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z9, zZzi, zIsVendor, false, false));
                                        }
                                        if (zZze) {
                                        }
                                        i2 = i5;
                                        i3 = iZza;
                                        str3 = str4;
                                        if (zZze) {
                                            continue;
                                        }
                                    } else {
                                        if (z) {
                                            if (zZzd2) {
                                                zZzd2 = true;
                                            }
                                        }
                                        i4 = Build.VERSION.SDK_INT;
                                        if (i4 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzi(mediaCodecInfoZzb, str4)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzi = zzi(mediaCodecInfoZzb, str4);
                                        if (i4 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (!zZze) {
                                            z2 = zZzd2;
                                        } else if (z != zZzd2) {
                                            z2 = true;
                                        } else {
                                            boolean z10 = zIsHardwareAccelerated;
                                            str2 = name;
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z10, zZzi, zIsVendor, false, false));
                                        }
                                        if (zZze) {
                                        }
                                        i2 = i5;
                                        i3 = iZza;
                                        str3 = str4;
                                        if (zZze) {
                                            continue;
                                        }
                                    }
                                }
                                i2 = i5;
                                i3 = iZza;
                                str3 = str4;
                            } else {
                                i2 = i5;
                                i3 = iZza;
                                str3 = str4;
                            }
                        }
                    } else if (i6 > 23 && "audio/eac3-joc".equals(str4) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(name)) {
                        i2 = i5;
                        i3 = iZza;
                        str3 = str4;
                    } else {
                        supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                        length = supportedTypes.length;
                        i = 0;
                        while (true) {
                            if (i >= length) {
                                if (!str4.equals("video/dolby-vision")) {
                                    if (!str4.equals("video/mv-hevc")) {
                                        if (!str4.equals("audio/alac") && "OMX.lge.alac.decoder".equals(name)) {
                                            str = "audio/x-lg-alac";
                                            break;
                                        }
                                        if (!str4.equals("audio/flac") && "OMX.lge.flac.decoder".equals(name)) {
                                            str = "audio/x-lg-flac";
                                            break;
                                        }
                                        if (!str4.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(name)) {
                                            str = "audio/lg-ac3";
                                            break;
                                        }
                                        str = null;
                                        break;
                                    }
                                    if ("c2.qti.mvhevc.decoder".equals(name) && !"c2.qti.mvhevc.decoder.secure".equals(name)) {
                                        str = null;
                                        break;
                                    }
                                    str = "video/x-mvhevc";
                                    break;
                                }
                                if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                    if ("OMX.RTK.video.decoder".equals(name) && !"OMX.realtek.video.decoder.tunneled".equals(name)) {
                                        str = null;
                                        break;
                                    }
                                    str = "video/dv_hevc";
                                    break;
                                }
                                str = "video/hevcdv";
                                break;
                            }
                            str = supportedTypes[i];
                            if (str.equalsIgnoreCase(str4)) {
                                break;
                            }
                            i++;
                        }
                        if (str != null) {
                            try {
                                capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str);
                                zZzd = zztxVar.zzd("tunneled-playback", str, capabilitiesForType);
                                zZzc = zztxVar.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztvVar2.zzc) {
                                    if (!zZzc) {
                                        zZzd2 = zztxVar.zzd("secure-playback", str, capabilitiesForType);
                                        boolean zZzc6 = zztxVar.zzc("secure-playback", str, capabilitiesForType);
                                        z = zztvVar2.zzb;
                                        if (z || !zZzc6) {
                                            if (z) {
                                                if (zZzd2) {
                                                    zZzd2 = true;
                                                }
                                            }
                                            i4 = Build.VERSION.SDK_INT;
                                            if (i4 >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzi(mediaCodecInfoZzb, str4)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzi = zzi(mediaCodecInfoZzb, str4);
                                            if (i4 >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = true;
                                                }
                                            }
                                            if (!zZze) {
                                                z2 = zZzd2;
                                            } else if (z != zZzd2) {
                                                z2 = true;
                                            } else {
                                                boolean z11 = zIsHardwareAccelerated;
                                                str2 = name;
                                                i2 = i5;
                                                i3 = iZza;
                                                str3 = str4;
                                                try {
                                                    arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z11, zZzi, zIsVendor, false, false));
                                                } catch (Exception e) {
                                                    e = e;
                                                    if (Build.VERSION.SDK_INT <= 23 || arrayList.isEmpty()) {
                                                        zzea.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                        throw e;
                                                    }
                                                    zzea.zzc("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                }
                                            }
                                            if (!zZze || z) {
                                                i2 = i5;
                                                i3 = iZza;
                                                str3 = str4;
                                                if (zZze && z2) {
                                                    try {
                                                        boolean z12 = zIsHardwareAccelerated;
                                                        str2 = name;
                                                        arrayList.add(zzti.zzd(name + ".secure", str3, str, capabilitiesForType, z12, zZzi, zIsVendor, false, true));
                                                        break;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        str2 = name;
                                                        if (Build.VERSION.SDK_INT <= 23) {
                                                        }
                                                        zzea.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                        throw e;
                                                    }
                                                }
                                            } else {
                                                boolean z13 = zIsHardwareAccelerated;
                                                str2 = name;
                                                i2 = i5;
                                                i3 = iZza;
                                                str3 = str4;
                                                arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z13, zZzi, zIsVendor, false, false));
                                            }
                                        }
                                    }
                                } else if (zZzd) {
                                    zZzd2 = zztxVar.zzd("secure-playback", str, capabilitiesForType);
                                    boolean zZzc7 = zztxVar.zzc("secure-playback", str, capabilitiesForType);
                                    z = zztvVar2.zzb;
                                    if (z) {
                                        if (z) {
                                            if (zZzd2) {
                                                zZzd2 = true;
                                            }
                                        }
                                        i4 = Build.VERSION.SDK_INT;
                                        if (i4 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzi(mediaCodecInfoZzb, str4)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzi = zzi(mediaCodecInfoZzb, str4);
                                        if (i4 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (!zZze) {
                                            z2 = zZzd2;
                                        } else if (z != zZzd2) {
                                            z2 = true;
                                        } else {
                                            boolean z14 = zIsHardwareAccelerated;
                                            str2 = name;
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z14, zZzi, zIsVendor, false, false));
                                        }
                                        if (zZze) {
                                        }
                                        i2 = i5;
                                        i3 = iZza;
                                        str3 = str4;
                                        if (zZze) {
                                            continue;
                                        }
                                    } else {
                                        if (z) {
                                            if (zZzd2) {
                                                zZzd2 = true;
                                            }
                                        }
                                        i4 = Build.VERSION.SDK_INT;
                                        if (i4 >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzi(mediaCodecInfoZzb, str4)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzi = zzi(mediaCodecInfoZzb, str4);
                                        if (i4 >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfuv.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (!zZze) {
                                            z2 = zZzd2;
                                        } else if (z != zZzd2) {
                                            z2 = true;
                                        } else {
                                            boolean z15 = zIsHardwareAccelerated;
                                            str2 = name;
                                            i2 = i5;
                                            i3 = iZza;
                                            str3 = str4;
                                            arrayList.add(zzti.zzd(name, str4, str, capabilitiesForType, z15, zZzi, zIsVendor, false, false));
                                        }
                                        if (zZze) {
                                        }
                                        i2 = i5;
                                        i3 = iZza;
                                        str3 = str4;
                                        if (zZze) {
                                            continue;
                                        }
                                    }
                                }
                                i2 = i5;
                                i3 = iZza;
                                str3 = str4;
                            } catch (Exception e3) {
                                e = e3;
                                str2 = name;
                                i2 = i5;
                                i3 = iZza;
                                str3 = str4;
                            }
                        } else {
                            i2 = i5;
                            i3 = iZza;
                            str3 = str4;
                        }
                    }
                } else {
                    i2 = i5;
                    i3 = iZza;
                    str3 = str4;
                }
                i5 = i2 + 1;
                zztvVar2 = zztvVar;
                str4 = str3;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new zztw(e4, null);
        }
    }
}
