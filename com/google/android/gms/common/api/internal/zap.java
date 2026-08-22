package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference zab;
    protected final GoogleApiAvailability zac;
    public final com.google.android.gms.internal.base.zau zad;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zap(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        this.zab = new AtomicReference(null);
        this.zad = new com.google.android.gms.internal.base.zau(Looper.getMainLooper());
        this.zac = googleApiAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i, int i2, Intent intent) {
        zam zamVar = (zam) this.zab.get();
        if (i != 1) {
            if (i == 2) {
                int iIsGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity(), GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (iIsGooglePlayServicesAvailable == 0) {
                    this.zab.set(null);
                    zac();
                    return;
                } else {
                    if (zamVar == null) {
                        return;
                    }
                    if (zamVar.zab.zzb == 18 && iIsGooglePlayServicesAvailable == 18) {
                        return;
                    }
                }
            }
        } else if (i2 == -1) {
            this.zab.set(null);
            zac();
            return;
        } else if (i2 == 0) {
            if (zamVar != null) {
                ConnectionResult connectionResult = new ConnectionResult(1, intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, zamVar.zab.toString());
                this.zab.set(null);
                zab(connectionResult, zamVar.zaa);
                return;
            }
            return;
        }
        if (zamVar != null) {
            this.zab.set(null);
            zab(zamVar.zab, zamVar.zaa);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        ConnectionResult connectionResult = new ConnectionResult(13, null);
        zam zamVar = (zam) this.zab.get();
        int i = zamVar == null ? -1 : zamVar.zaa;
        this.zab.set(null);
        zab(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zab.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zamVar = (zam) this.zab.get();
        if (zamVar == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", zamVar.zaa);
        ConnectionResult connectionResult = zamVar.zab;
        bundle.putInt("failed_status", connectionResult.zzb);
        bundle.putParcelable("failed_resolution", connectionResult.zzc);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    public abstract void zab(ConnectionResult connectionResult, int i);

    public abstract void zac();

    public final void zah(ConnectionResult connectionResult, int i) {
        AtomicReference atomicReference;
        zam zamVar = new zam(connectionResult, i);
        do {
            atomicReference = this.zab;
            do {
                if (atomicReference.compareAndSet(null, zamVar)) {
                    this.zad.post(new zao(this, zamVar));
                    return;
                }
            } while (atomicReference.get() == null);
        } while (atomicReference.get() == null);
    }
}
