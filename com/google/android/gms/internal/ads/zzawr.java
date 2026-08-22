package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class zzawr implements zzfqf {
    private final zzfok zza;
    private final zzfoz zzb;
    private final zzaxe zzc;
    private final zzawq zzd;
    private final zzawa zze;
    private final zzaxg zzf;
    private final zzawy zzg;
    private final zzawp zzh;

    public zzawr(zzfok zzfokVar, zzfoz zzfozVar, zzaxe zzaxeVar, zzawq zzawqVar, zzawa zzawaVar, zzaxg zzaxgVar, zzawy zzawyVar, zzawp zzawpVar) {
        this.zza = zzfokVar;
        this.zzb = zzfozVar;
        this.zzc = zzaxeVar;
        this.zzd = zzawqVar;
        this.zze = zzawaVar;
        this.zzf = zzaxgVar;
        this.zzg = zzawyVar;
        this.zzh = zzawpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqf
    public final Map zza() {
        zzaxe zzaxeVar = this.zzc;
        Map mapZze = zze();
        mapZze.put("lts", Long.valueOf(zzaxeVar.zza()));
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfqf
    public final Map zzb() {
        return zze();
    }

    @Override // com.google.android.gms.internal.ads.zzfqf
    public final Map zzc() {
        zzawp zzawpVar = this.zzh;
        Map mapZze = zze();
        if (zzawpVar != null) {
            mapZze.put("vst", zzawpVar.zza());
        }
        return mapZze;
    }

    public final void zzd(View view) {
        this.zzc.zzd(view);
    }

    private final Map zze() {
        HashMap map = new HashMap();
        zzfok zzfokVar = this.zza;
        zzatq zzatqVarZzb = this.zzb.zzb();
        map.put("v", zzfokVar.zzd());
        map.put("gms", Boolean.valueOf(zzfokVar.zzg()));
        map.put("int", zzatqVarZzb.zzg());
        map.put("attts", Long.valueOf(zzatqVarZzb.zzf().zza()));
        map.put("att", zzatqVarZzb.zzf().zzd());
        map.put("attkid", zzatqVarZzb.zzf().zzf());
        map.put("up", Boolean.valueOf(this.zzd.zza()));
        map.put("t", new Throwable());
        zzawy zzawyVar = this.zzg;
        if (zzawyVar != null) {
            map.put("tcq", Long.valueOf(zzawyVar.zzc()));
            map.put(PZmDzEagKNdW.quAxXbPjJZzx, Long.valueOf(zzawyVar.zzg()));
            map.put("tcv", Long.valueOf(zzawyVar.zzd()));
            map.put("tpv", Long.valueOf(zzawyVar.zzh()));
            map.put("tchv", Long.valueOf(zzawyVar.zzb()));
            map.put("tphv", Long.valueOf(zzawyVar.zzf()));
            map.put("tcc", Long.valueOf(zzawyVar.zza()));
            map.put("tpc", Long.valueOf(zzawyVar.zze()));
            zzawa zzawaVar = this.zze;
            if (zzawaVar != null) {
                map.put("nt", Long.valueOf(zzawaVar.zza()));
            }
            zzaxg zzaxgVar = this.zzf;
            if (zzaxgVar != null) {
                map.put("vs", Long.valueOf(zzaxgVar.zzc()));
                map.put("vf", Long.valueOf(zzaxgVar.zzb()));
            }
        }
        return map;
    }
}
