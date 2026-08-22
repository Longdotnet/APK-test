package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzxk {
    public static final zzxk zza = new zzxk(new zzbm[0]);
    public final int zzb;
    private final zzfyq zzc;
    private int zzd;

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
    }

    public zzxk(zzbm... zzbmVarArr) {
        this.zzc = zzfyq.zzm(zzbmVarArr);
        this.zzb = zzbmVarArr.length;
        int i = 0;
        while (i < this.zzc.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zzc.size(); i3++) {
                if (((zzbm) this.zzc.get(i)).equals(this.zzc.get(i3))) {
                    zzea.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzxk.class == obj.getClass()) {
            zzxk zzxkVar = (zzxk) obj;
            if (this.zzb == zzxkVar.zzb && this.zzc.equals(zzxkVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zzc.hashCode();
        this.zzd = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final int zza(zzbm zzbmVar) {
        int iIndexOf = this.zzc.indexOf(zzbmVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final zzbm zzb(int i) {
        return (zzbm) this.zzc.get(i);
    }

    public final zzfyq zzc() {
        return zzfyq.zzl(zzfzg.zzc(this.zzc, new zzfve() { // from class: com.google.android.gms.internal.ads.zzxj
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                zzxk zzxkVar = zzxk.zza;
                return Integer.valueOf(((zzbm) obj).zzc);
            }
        }));
    }
}
