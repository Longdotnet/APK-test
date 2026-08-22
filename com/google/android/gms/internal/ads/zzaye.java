package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaye extends zzayk {
    private final zzaxe zzh;
    private long zzi;

    public zzaye(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, zzaxe zzaxeVar) {
        super(zzawxVar, "YdsvNQpLn71zCPsmNiBmaxgvKAoUotN+t67Ej8NmXEez61kI/ElwL7USsI8xuH+E", "BTo9KBR1VAIklcWQcnKn1k6hpYvG+18rom++PUlQVcU=", zzastVar, i, 53);
        this.zzh = zzaxeVar;
        if (zzaxeVar != null) {
            this.zzi = zzaxeVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        if (this.zzh != null) {
            this.zzd.zzN(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
