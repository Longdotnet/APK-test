package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends GoogleApi<Api.ApiOptions.NoOptions> implements HasApiKey {
    private static final Api.ClientKey<zzw> zza;
    private static final Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    static {
        Api.ClientKey<zzw> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzc = new Api<>("SmsCodeAutofill.API", zznVar, clientKey);
    }

    public zzr(Activity activity) {
        super(activity, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task checkPermissionState() {
        return doRead(TaskApiCall.builder().setFeatures(zzac.zza).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzk
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zzc(new zzp(this.zza, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1564).build());
    }

    public final Task hasOngoingSmsRequest(final String str) {
        zzah.checkNotNull(str);
        zzah.checkArgument(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(TaskApiCall.builder().setFeatures(zzac.zza).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzm
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzr zzrVar = this.zza;
                ((zzh) ((zzw) obj).getService()).zzd(str, new zzq(zzrVar, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1565).build());
    }

    public final Task startSmsCodeRetriever() {
        return doWrite(TaskApiCall.builder().setFeatures(zzac.zza).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzl
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzh) ((zzw) obj).getService()).zze(new zzo(this.zza, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1563).build());
    }

    public zzr(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
