package com.google.android.gms.common.api.internal;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
final class zao implements Runnable {
    public final /* synthetic */ zap zaa;
    public final zam zab;

    public zao(zap zapVar, zam zamVar) {
        this.zaa = zapVar;
        this.zab = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult connectionResult = this.zab.zab;
            if (connectionResult.hasResolution()) {
                zap zapVar = this.zaa;
                LifecycleFragment lifecycleFragment = zapVar.mLifecycleFragment;
                Activity activity = zapVar.getActivity();
                PendingIntent pendingIntent = connectionResult.zzc;
                zzah.checkNotNull(pendingIntent);
                lifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(activity, pendingIntent, this.zab.zaa, false), 1);
                return;
            }
            zap zapVar2 = this.zaa;
            if (zapVar2.zac.getErrorResolutionIntent(zapVar2.getActivity(), null, connectionResult.zzb) != null) {
                zap zapVar3 = this.zaa;
                zapVar3.zac.zag(zapVar3.getActivity(), zapVar3.mLifecycleFragment, connectionResult.zzb, this.zaa);
                return;
            }
            if (connectionResult.zzb != 18) {
                zap zapVar4 = this.zaa;
                int i = this.zab.zaa;
                zapVar4.zab.set(null);
                zapVar4.zab(connectionResult, i);
                return;
            }
            zap zapVar5 = this.zaa;
            GoogleApiAvailability googleApiAvailability = zapVar5.zac;
            Activity activity2 = zapVar5.getActivity();
            googleApiAvailability.getClass();
            ProgressBar progressBar = new ProgressBar(activity2, null, R.attr.progressBarStyleLarge);
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(0);
            AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
            builder.setView(progressBar);
            builder.setMessage(com.google.android.gms.common.internal.zac.zac(activity2, 18));
            builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
            AlertDialog alertDialogCreate = builder.create();
            GoogleApiAvailability.zad(activity2, alertDialogCreate, "GooglePlayServicesUpdatingDialog", zapVar5);
            zap zapVar6 = this.zaa;
            Context applicationContext = zapVar6.getActivity().getApplicationContext();
            zan zanVar = new zan(this, alertDialogCreate);
            zapVar6.zac.getClass();
            GoogleApiAvailability.zac(applicationContext, zanVar);
        }
    }
}
