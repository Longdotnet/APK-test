package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.util.client.zzo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class RequestConfiguration {
    public static final List zza = Arrays.asList("MA", "T", "PG", "G");
    public final int zzb;
    public final int zzc;
    public final String zzd;
    public final ArrayList zze;
    public final int zzf;

    public final class Builder {
        public int zza = -1;
        public int zzb = -1;
        public String zzc = null;
        public final ArrayList zzd = new ArrayList();
        public final int zze = 1;

        public final void setMaxAdContentRating(String str) {
            if (str == null || "".equals(str)) {
                this.zzc = null;
                return;
            }
            if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
                this.zzc = str;
            } else {
                zzo.zzj("Invalid value passed to setMaxAdContentRating: ".concat(str));
            }
        }

        public final void setTagForChildDirectedTreatment(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zza = i;
                return;
            }
            zzo.zzj("Invalid value passed to setTagForChildDirectedTreatment: " + i);
        }

        public final void setTagForUnderAgeOfConsent(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzb = i;
                return;
            }
            zzo.zzj("Invalid value passed to setTagForUnderAgeOfConsent: " + i);
        }
    }

    public /* synthetic */ RequestConfiguration(int i, int i2, String str, ArrayList arrayList, int i3) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = arrayList;
        this.zzf = i3;
    }
}
