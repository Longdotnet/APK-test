package com.google.android.gms.common.internal;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* JADX INFO: loaded from: classes.dex */
public final class zad implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Intent zaa;
    public final /* synthetic */ Object zab;

    public /* synthetic */ zad(Intent intent, Object obj, int i) {
        this.$r8$classId = i;
        this.zaa = intent;
        this.zab = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                zaa();
            } catch (ActivityNotFoundException e) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    public final void zaa() {
        switch (this.$r8$classId) {
            case 0:
                Intent intent = this.zaa;
                if (intent != null) {
                    ((GoogleApiActivity) this.zab).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.zaa;
                if (intent2 != null) {
                    ((LifecycleFragment) this.zab).startActivityForResult(intent2, 2);
                }
                break;
        }
    }
}
