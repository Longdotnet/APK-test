package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import androidx.core.view.inputmethod.EditorInfoCompat$$ExternalSyntheticApiModelOutline0;
import androidx.work.WorkContinuation;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.games_v2.zzfq;
import com.google.android.gms.internal.games_v2.zzgz;
import com.google.android.gms.internal.games_v2.zzhd;
import com.google.android.gms.internal.games_v2.zzio;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zze extends zzf {
    public final Context zza;

    public zze(Context context) {
        this.zza = context.getApplicationContext();
    }

    public static zzhd zzf(zzhd zzhdVar) {
        int i = zzhd.zzd;
        zzgz zzgzVar = new zzgz();
        int size = zzhdVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strZza = ((zzi) zzhdVar.get(i2)).zza();
            if (strZza != null) {
                zzgzVar.zzd(strZza);
            }
        }
        return zzgzVar.zze();
    }

    public static zzhd zzg(List list) {
        int i = zzhd.zzd;
        zzgz zzgzVar = new zzgz();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShortcutInfo shortcutInfoM = EditorInfoCompat$$ExternalSyntheticApiModelOutline0.m(it.next());
            if (!shortcutInfoM.isImmutable() && shortcutInfoM.getId().startsWith("PLAY_GAMES_SERVICES_")) {
                zzgzVar.zzd(new zzi(shortcutInfoM.getId(), shortcutInfoM.getExtras(), Boolean.valueOf(shortcutInfoM.isPinned()), Boolean.valueOf(shortcutInfoM.isEnabled())));
            }
        }
        return zzgzVar.zze();
    }

    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzf
    public final void zza() {
        zzfq.zza();
        new Thread(new Runnable() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzd
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.tasks.zzw zzwVarForResult;
                zze zzeVar = this.zza;
                zzeVar.getClass();
                Class clsM18m = EditorInfoCompat$$ExternalSyntheticApiModelOutline0.m18m();
                Context context = zzeVar.zza;
                final ShortcutManager shortcutManagerM17m = EditorInfoCompat$$ExternalSyntheticApiModelOutline0.m17m(context.getSystemService(clsM18m));
                if (shortcutManagerM17m == null) {
                    return;
                }
                final zzr zzrVarZza = zzt.zza(context, PlayGamesAppShortcutsActivity.class);
                final zzhd zzhdVarZzg = zze.zzg(shortcutManagerM17m.getDynamicShortcuts());
                final zzhd zzhdVarZzg2 = zze.zzg(shortcutManagerM17m.getPinnedShortcuts());
                if (zzrVarZza == null || zzrVarZza.zza() <= 0) {
                    zzwVarForResult = WorkContinuation.forResult(new zzg(zze.zzf(zzhdVarZzg), zzhd.zzi(), zze.zzf(zzhdVarZzg2), zzhd.zzi()));
                } else {
                    final zzq zzqVar = new zzq(context, zzq.zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
                    zzwVarForResult = zzqVar.doRead(TaskApiCall.builder().setMethodKey(6744).setFeatures(com.google.android.gms.games.zzd.zzg).setAutoResolveMissingFeatures(false).run(new RemoteCall(zzqVar, zzrVarZza, zzhdVarZzg, zzhdVarZzg2) { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzp
                        public final /* synthetic */ zzr zzb;
                        public final /* synthetic */ zzhd zzc;
                        public final /* synthetic */ zzhd zzd;

                        {
                            this.zzb = zzrVarZza;
                            this.zzc = zzhdVarZzg;
                            this.zzd = zzhdVarZzg2;
                        }

                        @Override // com.google.android.gms.common.api.internal.RemoteCall
                        public final void accept(Object obj, Object obj2) {
                            ((zzv) ((zzu) obj).getService()).zzd(new zzl((TaskCompletionSource) obj2), this.zzb, this.zzc, this.zzd);
                        }
                    }).build()).continueWith(zzio.zza(), new Continuation() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzc
                        @Override // com.google.android.gms.tasks.Continuation
                        public final Object then(Task task) {
                            return task.isSuccessful() ? (zzg) task.getResult() : new zzg(zze.zzf(zzhdVarZzg), zzhd.zzi(), zze.zzf(zzhdVarZzg2), zzhd.zzi());
                        }
                    });
                }
                zzwVarForResult.addOnSuccessListener(zzio.zza(), new OnSuccessListener() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzb
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final /* synthetic */ void onSuccess(Object obj) {
                        zzg zzgVar = (zzg) obj;
                        List listZza = zzgVar.zza();
                        ShortcutManager shortcutManager = shortcutManagerM17m;
                        if (listZza != null && !listZza.isEmpty()) {
                            shortcutManager.removeDynamicShortcuts(listZza);
                        }
                        List listZzb = zzgVar.zzb();
                        if (listZzb != null && !listZzb.isEmpty()) {
                            shortcutManager.addDynamicShortcuts(listZzb);
                        }
                        List listZzc = zzgVar.zzc();
                        if (listZzc != null && !listZzc.isEmpty()) {
                            shortcutManager.disableShortcuts(listZzc);
                        }
                        List listZzd = zzgVar.zzd();
                        if (listZzd == null || listZzd.isEmpty()) {
                            return;
                        }
                        shortcutManager.enableShortcuts(listZzd);
                    }
                });
            }
        }, QTaELkFI.btVMlHySkSKcZMZ).start();
    }
}
