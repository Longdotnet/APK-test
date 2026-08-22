package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmw implements zzfmu {
    private final zzfmu zza;

    public zzfmw(zzfmu zzfmuVar) {
        this.zza = zzfmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final JSONObject zza(View view) {
        JSONObject jSONObjectZza = zzfne.zza(0, 0, 0, 0);
        int iZzb = zzfnh.zzb();
        int i = iZzb - 1;
        if (iZzb == 0) {
            throw null;
        }
        try {
            jSONObjectZza.put("noOutputDevice", i == 0);
        } catch (JSONException e) {
            zzfnf.zza("Error with setting output device status", e);
        }
        return jSONObjectZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final void zzb(View view, JSONObject jSONObject, zzfmt zzfmtVar, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        zzfmi zzfmiVarZza = zzfmi.zza();
        if (zzfmiVarZza != null) {
            Collection collectionZzb = zzfmiVarZza.zzb();
            int size = collectionZzb.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            Iterator it = collectionZzb.iterator();
            while (it.hasNext()) {
                View viewZzf = ((zzflp) it.next()).zzf();
                if (viewZzf != null && viewZzf.isAttachedToWindow() && viewZzf.isShown()) {
                    View view2 = viewZzf;
                    while (true) {
                        if (view2 == null) {
                            View rootView = viewZzf.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float z3 = rootView.getZ();
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i = size2 - 1;
                                    if (((View) arrayList.get(i)).getZ() <= z3) {
                                        break;
                                    } else {
                                        size2 = i;
                                    }
                                }
                                arrayList.add(size2, rootView);
                                break;
                            }
                            break;
                        }
                        if (view2.getAlpha() == 0.0f) {
                            break;
                        }
                        Object parent = view2.getParent();
                        view2 = parent instanceof View ? (View) parent : null;
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzfmtVar.zza((View) arrayList.get(i2), this.zza, jSONObject, z2);
        }
    }
}
