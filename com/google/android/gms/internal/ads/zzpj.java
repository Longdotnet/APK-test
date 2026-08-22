package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzpj {
    static final zzfyt zzb;
    private final SparseArray zzd = new SparseArray();
    private final int zze;
    public static final zzpj zza = new zzpj(zzfyq.zzo(zzpi.zza));
    private static final zzfyq zzc = zzfyq.zzq(2, 5, 6);

    static {
        zzfys zzfysVar = new zzfys();
        zzfysVar.zza(5, 6);
        zzfysVar.zza(17, 6);
        zzfysVar.zza(7, 6);
        zzfysVar.zza(30, 10);
        zzfysVar.zza(18, 6);
        zzfysVar.zza(6, 8);
        zzfysVar.zza(8, 8);
        zzfysVar.zza(14, 8);
        zzb = zzfysVar.zzc();
    }

    private zzpj(List list) {
        for (int i = 0; i < list.size(); i++) {
            zzpi zzpiVar = (zzpi) list.get(i);
            this.zzd.put(zzpiVar.zzb, zzpiVar);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            iMax = Math.max(iMax, ((zzpi) this.zzd.valueAt(i2)).zzc);
        }
        this.zze = iMax;
    }

    public static Uri zza() {
        if (zzf()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public static zzpj zzc(Context context, zze zzeVar, zzpp zzppVar) {
        return zzd(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzeVar, zzppVar);
    }

    public static zzpj zzd(Context context, Intent intent, zze zzeVar, zzpp zzppVar) {
        AudioManager audioManagerZzc = zzcj.zzc(context);
        if (zzppVar == null) {
            zzpp zzppVar2 = null;
            if (Build.VERSION.SDK_INT >= 33) {
                List audioDevicesForAttributes = audioManagerZzc.getAudioDevicesForAttributes(zzeVar.zza().zza);
                if (!audioDevicesForAttributes.isEmpty()) {
                    zzppVar2 = new zzpp((AudioDeviceInfo) audioDevicesForAttributes.get(0));
                }
            }
            zzppVar = zzppVar2;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 && (zzex.zzN(context) || zzex.zzJ(context))) {
            List directProfilesForAttributes = audioManagerZzc.getDirectProfilesForAttributes(zzeVar.zza().zza);
            HashMap map = new HashMap();
            map.put(2, new HashSet(zzgbt.zzh(12)));
            for (int i2 = 0; i2 < directProfilesForAttributes.size(); i2++) {
                AudioProfile audioProfileM = zzpd$$ExternalSyntheticApiModelOutline4.m(directProfilesForAttributes.get(i2));
                if (audioProfileM.getEncapsulationType() != 1) {
                    int format = audioProfileM.getFormat();
                    if (zzex.zzK(format) || zzb.containsKey(Integer.valueOf(format))) {
                        Integer numValueOf = Integer.valueOf(format);
                        if (map.containsKey(numValueOf)) {
                            Set set = (Set) map.get(numValueOf);
                            set.getClass();
                            set.addAll(zzgbt.zzh(audioProfileM.getChannelMasks()));
                        } else {
                            map.put(numValueOf, new HashSet(zzgbt.zzh(audioProfileM.getChannelMasks())));
                        }
                    }
                }
            }
            int i3 = zzfyq.zzd;
            zzfyn zzfynVar = new zzfyn();
            for (Map.Entry entry : map.entrySet()) {
                zzfynVar.zzf(new zzpi(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
            }
            return new zzpj(zzfynVar.zzi());
        }
        AudioDeviceInfo[] devices = zzppVar == null ? audioManagerZzc.getDevices(2) : new AudioDeviceInfo[]{zzppVar.zza};
        zzfyu zzfyuVar = new zzfyu();
        zzfyuVar.zzg(8, 7);
        if (i >= 31) {
            zzfyuVar.zzg(26, 27);
        }
        if (i >= 33) {
            zzfyuVar.zzf((Object) 30);
        }
        zzfyv zzfyvVarZzi = zzfyuVar.zzi();
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (zzfyvVarZzi.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                return zza;
            }
        }
        zzfyu zzfyuVar2 = new zzfyu();
        zzfyuVar2.zzf((Object) 2);
        if (Build.VERSION.SDK_INT >= 29 && (zzex.zzN(context) || zzex.zzJ(context))) {
            int i4 = zzfyq.zzd;
            zzfyn zzfynVar2 = new zzfyn();
            zzgaw it = zzb.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                int iIntValue = num.intValue();
                if (Build.VERSION.SDK_INT >= zzex.zzh(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zzeVar.zza().zza)) {
                    zzfynVar2.zzf(num);
                }
            }
            zzfynVar2.zzf((Object) 2);
            zzfyuVar2.zzh(zzfynVar2.zzi());
            return new zzpj(zze(zzgbt.zzi(zzfyuVar2.zzi()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z || zzf()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            zzfyuVar2.zzh(zzc);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new zzpj(zze(zzgbt.zzi(zzfyuVar2.zzi()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            zzfyuVar2.zzh(zzgbt.zzh(intArrayExtra));
        }
        return new zzpj(zze(zzgbt.zzi(zzfyuVar2.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    private static zzfyq zze(int[] iArr, int i) {
        int i2 = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        for (int i3 : iArr) {
            zzfynVar.zzf(new zzpi(i3, i));
        }
        return zzfynVar.zzi();
    }

    private static boolean zzf() {
        String str = Build.MANUFACTURER;
        return str.equals("Amazon") || str.equals("Xiaomi");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0046 A[RETURN] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpj)) {
            return false;
        }
        zzpj zzpjVar = (zzpj) obj;
        SparseArray sparseArray = this.zzd;
        SparseArray sparseArray2 = zzpjVar.zzd;
        String str = zzex.zza;
        if (Build.VERSION.SDK_INT < 31) {
            int size = sparseArray.size();
            if (size == sparseArray2.size()) {
                for (int i = 0; i < size; i++) {
                    if (Objects.equals(sparseArray.valueAt(i), sparseArray2.get(sparseArray.keyAt(i)))) {
                    }
                }
                if (this.zze == zzpjVar.zze) {
                    return true;
                }
            }
        } else if (sparseArray.contentEquals(sparseArray2)) {
            if (this.zze == zzpjVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iContentHashCode;
        String str = zzex.zza;
        int i = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.zzd;
        if (i >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iHashCode = 17;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i2)) + ((sparseArray.keyAt(i2) + (iHashCode * 31)) * 31);
            }
            iContentHashCode = iHashCode;
        }
        return (iContentHashCode * 31) + this.zze;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.zze + ", audioProfiles=" + this.zzd.toString() + "]";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002e  */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003a A[PHI: r1
  0x003a: PHI (r1v3 int) = (r1v2 int), (r1v7 int) binds: [B:11:0x002c, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    public final Pair zzb(zzz zzzVar, zze zzeVar) {
        String str = zzzVar.zzo;
        str.getClass();
        int iZza = zzay.zza(str, zzzVar.zzk);
        if (!zzb.containsKey(Integer.valueOf(iZza))) {
            return null;
        }
        int i = 8;
        if (iZza != 18) {
            if (iZza != 8) {
                if (iZza == 30 && !zzex.zzH(this.zzd, 30)) {
                    iZza = 7;
                }
            } else if (zzex.zzH(this.zzd, 8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else if (zzex.zzH(this.zzd, 18)) {
            iZza = 18;
            if (iZza != 8) {
                if (iZza == 30) {
                    iZza = 7;
                }
            } else if (zzex.zzH(this.zzd, 8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else {
            iZza = 6;
        }
        SparseArray sparseArray = this.zzd;
        if (!zzex.zzH(sparseArray, iZza)) {
            return null;
        }
        zzpi zzpiVar = (zzpi) sparseArray.get(iZza);
        zzpiVar.getClass();
        int iZza2 = zzzVar.zzG;
        if (iZza2 == -1 || iZza == 18) {
            int i2 = zzzVar.zzH;
            if (i2 == -1) {
                i2 = 48000;
            }
            iZza2 = zzpiVar.zza(i2, zzeVar);
        } else if (!str.equals("audio/vnd.dts.uhd;profile=p2") || Build.VERSION.SDK_INT >= 33) {
            if (!zzpiVar.zzb(iZza2)) {
                return null;
            }
        } else if (iZza2 > 10) {
            return null;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 28) {
            i = iZza2;
        } else if (iZza2 != 7) {
            if (iZza2 == 3 || iZza2 == 4 || iZza2 == 5) {
                i = 6;
            } else {
                i = iZza2;
            }
        }
        if (i3 <= 26 && "fugu".equals(Build.DEVICE) && i == 1) {
            i = 2;
        }
        int iZzi = zzex.zzi(i);
        if (iZzi != 0) {
            return Pair.create(Integer.valueOf(iZza), Integer.valueOf(iZzi));
        }
        return null;
    }
}
