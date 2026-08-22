package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfns implements zzfmt {
    private static final zzfns zza = new zzfns();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzfno();
    private static final Runnable zze = new zzfnp();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfnl zzk = new zzfnl();
    private final zzfmv zzj = new zzfmv();
    private final zzfnm zzl = new zzfnm(new zzfnv());

    public static zzfns zzd() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzfns zzfnsVar) {
        zzfnsVar.zzg = 0;
        zzfnsVar.zzi.clear();
        zzfnsVar.zzh = false;
        for (zzflp zzflpVar : zzfmi.zza().zzb()) {
        }
        zzfnsVar.zzm = System.nanoTime();
        zzfnl zzfnlVar = zzfnsVar.zzk;
        zzfnlVar.zzi();
        long jNanoTime = System.nanoTime();
        zzfmv zzfmvVar = zzfnsVar.zzj;
        zzfmu zzfmuVarZza = zzfmvVar.zza();
        if (zzfnlVar.zze().size() > 0) {
            for (String str : zzfnlVar.zze()) {
                JSONObject jSONObjectZza = zzfmuVarZza.zza(null);
                View viewZza = zzfnlVar.zza(str);
                zzfmu zzfmuVarZzb = zzfmvVar.zzb();
                String strZzc = zzfnlVar.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfmuVarZzb.zza(viewZza);
                    zzfne.zzb(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzfnf.zza("Error with setting not visible reason", e);
                    }
                    zzfne.zzc(jSONObjectZza, jSONObjectZza2);
                }
                zzfne.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfnsVar.zzl.zzc(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        zzfnl zzfnlVar2 = zzfnsVar.zzk;
        if (zzfnlVar2.zzf().size() > 0) {
            JSONObject jSONObjectZza3 = zzfmuVarZza.zza(null);
            zzfnsVar.zzk(null, zzfmuVarZza, jSONObjectZza3, 1, false);
            zzfne.zzf(jSONObjectZza3);
            zzfnsVar.zzl.zzd(jSONObjectZza3, zzfnlVar2.zzf(), jNanoTime);
        } else {
            zzfnsVar.zzl.zzb();
        }
        zzfnlVar2.zzg();
        long jNanoTime2 = System.nanoTime() - zzfnsVar.zzm;
        List<zzfnr> list = zzfnsVar.zzf;
        if (list.size() > 0) {
            for (zzfnr zzfnrVar : list) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfnrVar.zzb();
                if (zzfnrVar instanceof zzfnq) {
                    ((zzfnq) zzfnrVar).zza();
                }
            }
        }
        zzfms.zza().zzc();
    }

    private final void zzk(View view, zzfmu zzfmuVar, JSONObject jSONObject, int i, boolean z) {
        zzfmuVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfnn(this));
    }

    @Override // com.google.android.gms.internal.ads.zzfmt
    public final void zza(View view, zzfmu zzfmuVar, JSONObject jSONObject, boolean z) {
        zzfnl zzfnlVar;
        int iZzl;
        boolean z2;
        boolean z3;
        if (zzfnj.zza(view) == null && (iZzl = (zzfnlVar = this.zzk).zzl(view)) != 3) {
            JSONObject jSONObjectZza = zzfmuVar.zza(view);
            zzfne.zzc(jSONObject, jSONObjectZza);
            String strZzd = zzfnlVar.zzd(view);
            if (strZzd != null) {
                zzfne.zzb(jSONObjectZza, strZzd);
                try {
                    jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzk(view)));
                } catch (JSONException e) {
                    zzfnf.zza("Error with setting has window focus", e);
                }
                boolean zZzj = this.zzk.zzj(strZzd);
                Object objValueOf = Boolean.valueOf(zZzj);
                if (zZzj) {
                    try {
                        jSONObjectZza.put("isPipActive", objValueOf);
                    } catch (JSONException e2) {
                        zzfnf.zza("Error with setting is picture-in-picture active", e2);
                    }
                }
                this.zzk.zzh();
            } else {
                zzfnk zzfnkVarZzb = zzfnlVar.zzb(view);
                if (zzfnkVarZzb != null) {
                    zzfml zzfmlVarZza = zzfnkVarZzb.zza();
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayListZzb = zzfnkVarZzb.zzb();
                    int size = arrayListZzb.size();
                    for (int i = 0; i < size; i++) {
                        jSONArray.put((String) arrayListZzb.get(i));
                    }
                    try {
                        jSONObjectZza.put(PZmDzEagKNdW.LBOhzICOfxd, jSONArray);
                        jSONObjectZza.put("friendlyObstructionClass", zzfmlVarZza.zzd());
                        jSONObjectZza.put("friendlyObstructionPurpose", zzfmlVarZza.zza());
                        jSONObjectZza.put(bUqMCsuPSX.CPTtb, zzfmlVarZza.zzc());
                    } catch (JSONException e3) {
                        zzfnf.zza("Error with setting friendly obstruction", e3);
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z || z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzk(view, zzfmuVar, jSONObjectZza, iZzl, z3);
            }
            this.zzg++;
        }
    }
}
