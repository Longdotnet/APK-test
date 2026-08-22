package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzadq implements zzaea {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzadp zzc = new zzadp(new zzado() { // from class: com.google.android.gms.internal.ads.zzadm
        @Override // com.google.android.gms.internal.ads.zzado
        public final Constructor zza() {
            int i = zzadq.zza;
            if (Boolean.TRUE.equals(Class.forName(oKjScaD.AsMZB).getMethod("isAvailable", null).invoke(null, null))) {
                return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzadv.class).getConstructor(Integer.TYPE);
            }
            return null;
        }
    });
    private static final zzadp zzd = new zzadp(new zzado() { // from class: com.google.android.gms.internal.ads.zzadn
        @Override // com.google.android.gms.internal.ads.zzado
        public final Constructor zza() {
            int i = zzadq.zza;
            return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(zzadv.class).getConstructor(null);
        }
    });
    private zzfyq zze;
    private final zzakr zzf = new zzakm();

    private final void zzb(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzamq());
                break;
            case 1:
                list.add(new zzams());
                break;
            case 2:
                list.add(new zzamu(0));
                break;
            case 3:
                list.add(new zzafi(0));
                break;
            case 4:
                zzadv zzadvVarZza = zzc.zza(0);
                if (zzadvVarZza == null) {
                    list.add(new zzaga(0));
                } else {
                    list.add(zzadvVarZza);
                }
                break;
            case 5:
                list.add(new zzagc());
                break;
            case 6:
                list.add(new zzahy(this.zzf, 0));
                break;
            case 7:
                list.add(new zzaie(0));
                break;
            case 8:
                zzakr zzakrVar = this.zzf;
                list.add(new zzajd(zzakrVar, 0, null, null, zzfyq.zzn(), null));
                list.add(new zzajj(zzakrVar, 0));
                break;
            case 9:
                list.add(new zzajz());
                break;
            case 10:
                list.add(new zzanz());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzfyq.zzn();
                }
                list.add(new zzaoj(1, 0, this.zzf, new zzeu(0L), new zzamw(0, this.zze), 112800));
                break;
            case 12:
                list.add(new zzaov());
                break;
            case 14:
                list.add(new zzagi(0));
                break;
            case 15:
                zzadv zzadvVarZza2 = zzd.zza(new Object[0]);
                if (zzadvVarZza2 != null) {
                    list.add(zzadvVarZza2);
                }
                break;
            case 16:
                list.add(new zzafn(0, this.zzf));
                break;
            case 17:
                list.add(new zzakk());
                break;
            case 18:
                list.add(new zzapa());
                break;
            case 19:
                list.add(new zzafv());
                break;
            case 20:
                list.add(new zzagh());
                break;
            case 21:
                list.add(new zzafu());
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:142:0x0204  */
    @Override // com.google.android.gms.internal.ads.zzaea
    public final synchronized zzadv[] zza(Uri uri, Map map) {
        ArrayList arrayList;
        int i;
        int i2;
        try {
            arrayList = new ArrayList(21);
            List list = (List) map.get("Content-Type");
            String str = (list == null || list.isEmpty()) ? null : (String) list.get(0);
            if (str != null) {
                switch (zzay.zze(str)) {
                    case "audio/ac3":
                    case "audio/eac3":
                    case "audio/eac3-joc":
                        i = 0;
                        break;
                    case "audio/ac4":
                        i = 1;
                        break;
                    case "audio/amr":
                    case "audio/3gpp":
                    case "audio/amr-wb":
                        i = 3;
                        break;
                    case "audio/flac":
                        i = 4;
                        break;
                    case "video/x-flv":
                        i = 5;
                        break;
                    case "audio/midi":
                        i = 15;
                        break;
                    case "video/x-matroska":
                    case "audio/x-matroska":
                    case "video/webm":
                    case "audio/webm":
                    case "application/webm":
                        i = 6;
                        break;
                    case "audio/mpeg":
                        i = 7;
                        break;
                    case "video/mp4":
                    case "audio/mp4":
                    case "application/mp4":
                        i = 8;
                        break;
                    case "audio/ogg":
                        i = 9;
                        break;
                    case "video/mp2p":
                        i = 10;
                        break;
                    case "video/mp2t":
                        i = 11;
                        break;
                    case "audio/wav":
                        i = 12;
                        break;
                    case "text/vtt":
                        i = 13;
                        break;
                    case "image/jpeg":
                        i = 14;
                        break;
                    case "video/x-msvideo":
                        i = 16;
                        break;
                    case "image/png":
                        i = 17;
                        break;
                    case "image/webp":
                        i = 18;
                        break;
                    case "image/bmp":
                        i = 19;
                        break;
                    case "image/heif":
                    case "image/heic":
                        i = 20;
                        break;
                    case "image/avif":
                        i = 21;
                        break;
                    default:
                        i = -1;
                        break;
                }
            } else {
                i = -1;
            }
            if (i != -1) {
                zzb(i, arrayList);
            }
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                i2 = -1;
            } else if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
                i2 = 0;
            } else if (lastPathSegment.endsWith(".ac4")) {
                i2 = 1;
            } else if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
                i2 = 2;
            } else if (lastPathSegment.endsWith(".amr")) {
                i2 = 3;
            } else if (lastPathSegment.endsWith(".flac")) {
                i2 = 4;
            } else if (lastPathSegment.endsWith(".flv")) {
                i2 = 5;
            } else if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
                i2 = 15;
            } else if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
                i2 = 6;
            } else if (lastPathSegment.endsWith(".mp3")) {
                i2 = 7;
            } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
                i2 = 8;
            } else if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
                i2 = 9;
            } else if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
                i2 = 10;
            } else if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
                i2 = 11;
            } else if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
                i2 = 12;
            } else if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
                i2 = 13;
            } else if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
                i2 = 14;
            } else if (lastPathSegment.endsWith(".avi")) {
                i2 = 16;
            } else if (lastPathSegment.endsWith(".png")) {
                i2 = 17;
            } else if (lastPathSegment.endsWith(".webp")) {
                i2 = 18;
            } else if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
                i2 = 19;
            } else if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
                i2 = 20;
            } else if (lastPathSegment.endsWith(".avif")) {
                i2 = 21;
            } else {
                i2 = -1;
            }
            if (i2 != -1 && i2 != i) {
                zzb(i2, arrayList);
            }
            int[] iArr = zzb;
            for (int i3 = 0; i3 < 21; i3++) {
                int i4 = iArr[i3];
                if (i4 != i && i4 != i2) {
                    zzb(i4, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzadv[]) arrayList.toArray(new zzadv[arrayList.size()]);
    }
}
