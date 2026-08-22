package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.FriendsResolutionRequiredException;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games_v2.zzfn;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzah extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    public final com.google.android.gms.internal.games_v2.zzac zzf;
    public final String zzg;
    public PlayerEntity zzh;
    public final zzan zzi;
    public boolean zzj;
    public final long zzk;
    public final zzao zzl;
    public final com.google.android.gms.games.zzi zzm;

    public zzah(Context context, Looper looper, ClientSettings clientSettings, com.google.android.gms.games.zzi zziVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzao zzaoVar) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new zzj(this);
        this.zzj = false;
        this.zzg = clientSettings.zag;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzaoVar);
        this.zzl = zzaoVar;
        zzan zzanVarZzb = zzan.zzb(this, clientSettings.zae);
        this.zzi = zzanVarZzb;
        this.zzk = hashCode();
        this.zzm = zziVar;
        View view = clientSettings.zaf;
        if (view != null || (context instanceof Activity)) {
            zzanVarZzb.zzf(view);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzh = null;
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        this.zzj = false;
        if (isConnected()) {
            try {
                this.zzf.zzb();
                ((zzam) getService()).zzd(this.zzk);
            } catch (RemoteException unused) {
                zzfn.zze("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.games.zzd.zzj;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.api.Api.Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectedLocked(IInterface iInterface) {
        zzam zzamVar = (zzam) iInterface;
        super.onConnectedLocked(zzamVar);
        boolean z = this.zzj;
        zzan zzanVar = this.zzi;
        if (z) {
            zzanVar.zzg();
            this.zzj = false;
        }
        try {
            zzamVar.zzM(new zzk(new com.google.android.gms.internal.games_v2.zzaf(zzanVar.zze())), this.zzk);
        } catch (RemoteException e) {
            zzfn.zzf("GamesGmsClientImpl", "service died", e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzj = false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0) {
            i = 0;
            if (bundle != null) {
                bundle.setClassLoader(zzah.class.getClassLoader());
                this.zzj = bundle.getBoolean("show_welcome_popup");
                this.zzh = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            }
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzl zzlVar = new zzl(signOutCallbacks);
            this.zzf.zzb();
            try {
                ((zzam) getService()).zze(new zzm(zzlVar));
            } catch (SecurityException unused) {
                zzlVar.setFailedResult(GamesClientStatusCodes.zza(4));
            }
        } catch (RemoteException unused2) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return !this.zzm.zzn.zzc();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(TaskCompletionSource taskCompletionSource, String str, long j, String str2) {
        try {
            ((zzam) getService()).zzs(new zzaf(taskCompletionSource), str, j, str2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzB(TaskCompletionSource taskCompletionSource, boolean z) {
        try {
            ((zzam) getService()).zzp(new zzp(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzC(TaskCompletionSource taskCompletionSource, String str) {
        zzo zzoVar = taskCompletionSource == null ? null : new zzo(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzm(zzoVar, str, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzD(TaskCompletionSource taskCompletionSource, String str) {
        zzo zzoVar = taskCompletionSource == null ? null : new zzo(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzn(zzoVar, str, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzE(TaskCompletionSource taskCompletionSource, String str, int i) {
        zzn zznVar = taskCompletionSource == null ? null : new zzn(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzo(zznVar, str, i, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzF(TaskCompletionSource taskCompletionSource, String str, int i) {
        zzn zznVar = taskCompletionSource == null ? null : new zzn(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzt(zznVar, str, i, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzG(TaskCompletionSource taskCompletionSource, boolean z) {
        this.zzf.zzb();
        try {
            ((zzam) getService()).zzH(new zzs(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzH(TaskCompletionSource taskCompletionSource, boolean z, String... strArr) {
        this.zzf.zzb();
        try {
            ((zzam) getService()).zzI(new zzs(taskCompletionSource), z, strArr);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzI(String str, int i) {
        this.zzf.zzc(str, i);
    }

    public final void zzJ(TaskCompletionSource taskCompletionSource, boolean z) {
        try {
            ((zzam) getService()).zzO(new zzab(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzK(TaskCompletionSource taskCompletionSource, boolean z) {
        try {
            ((zzam) getService()).zzA(new zzaa(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzL(TaskCompletionSource taskCompletionSource, String str, boolean z, int i) {
        try {
            ((zzam) getService()).zzL(new zzag(taskCompletionSource), str, z, i);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzN(TaskCompletionSource taskCompletionSource, String str) {
        try {
            ((zzam) getService()).zzD(new zzr(taskCompletionSource), str);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzO(TaskCompletionSource taskCompletionSource, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        com.google.android.gms.common.internal.zzah.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporterZza = snapshotMetadataChange.zza();
        if (bitmapTeleporterZza != null) {
            File cacheDir = getContext().getCacheDir();
            if (cacheDir == null) {
                throw new NullPointerException("Cannot set null temp directory");
            }
            bitmapTeleporterZza.zaf = cacheDir;
        }
        Contents contentsZza = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzam) getService()).zzE(new zzag(taskCompletionSource), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZza);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzR(TaskCompletionSource taskCompletionSource, String str, boolean z) {
        ((zzam) getService()).zzS(new zzu(taskCompletionSource), str, z);
    }

    public final void zzS(TaskCompletionSource taskCompletionSource, String str, boolean z, List list) {
        ((zzam) getService()).zzT(new zzv(taskCompletionSource), str, z, list);
    }

    public final /* synthetic */ void zzT(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setException(FriendsResolutionRequiredException.zza(GamesClientStatusCodes.zzb(GamesClientStatusCodes.CONSENT_REQUIRED, ((zzam) getService()).zzQ())));
        } catch (RemoteException e) {
            taskCompletionSource.setException(e);
        }
    }

    public final void zzp(zzf zzfVar) {
        zzfVar.zzc(this.zzi);
    }

    public final Player zzq() {
        checkConnected();
        synchronized (this) {
            try {
                if (this.zzh == null) {
                    PlayerBuffer playerBuffer = new PlayerBuffer(((zzam) getService()).zzi());
                    try {
                        if (playerBuffer.getCount() > 0) {
                            this.zzh = new PlayerEntity(playerBuffer.get(0));
                        }
                        playerBuffer.release();
                    } catch (Throwable th) {
                        playerBuffer.release();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.zzh;
    }

    public final void zzr(TaskCompletionSource taskCompletionSource, boolean z) {
        try {
            ((zzam) getService()).zzK(new zzad(taskCompletionSource), null, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzs(TaskCompletionSource taskCompletionSource, String str, boolean z) {
        try {
            ((zzam) getService()).zzK(new zzad(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzt(TaskCompletionSource taskCompletionSource, String str, int i, boolean z, boolean z2) {
        if (!str.equals("played_with") && !str.equals("friends_all")) {
            throw new IllegalArgumentException("Invalid player collection: ".concat(str));
        }
        try {
            ((zzam) getService()).zzy(new zzac(this, taskCompletionSource), str, i, z, z2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzu(TaskCompletionSource taskCompletionSource, boolean z) {
        try {
            ((zzam) getService()).zzq(new zzz(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzv(TaskCompletionSource taskCompletionSource, String str, boolean z) {
        try {
            ((zzam) getService()).zzr(new zzw(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzw(TaskCompletionSource taskCompletionSource, String str, int i, int i2) {
        try {
            ((zzam) getService()).zzu(new zzx(this, taskCompletionSource), null, str, i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzx(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) {
        try {
            ((zzam) getService()).zzj(new zzy(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzy(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) {
        try {
            ((zzam) getService()).zzk(new zzy(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzz(TaskCompletionSource taskCompletionSource, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((zzam) getService()).zzl(new zzy(this, taskCompletionSource), leaderboardScoreBuffer.zza().zza(), i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        String str = iafHZUfOuHNwvy.xohmQSSgy;
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(str);
        return iInterfaceQueryLocalInterface instanceof zzam ? (zzam) iInterfaceQueryLocalInterface : new zzam(iBinder, str);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        String string = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
        com.google.android.gms.games.zzi zziVar = this.zzm;
        boolean z = zziVar.zzb;
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", true);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", 17);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", zziVar.zze);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", zziVar.zzg);
        bundle.putBoolean(DaWYVMJ.pkQT, false);
        bundle.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
        bundle.putString("com.google.android.gms.games.key.realClientPackageName", null);
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        bundle.putString("com.google.android.gms.games.key.gameRunToken", zziVar.zzm);
        bundle.putBoolean("com.google.android.gms.games.key.isGmsCoreUiInitiatedRequest", false);
        bundle.putString("com.google.android.gms.games.key.gamePackageName", this.zzg);
        bundle.putString("com.google.android.gms.games.key.desiredLocale", string);
        bundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzi.zzd()));
        if (!bundle.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        bundle.putBundle("com.google.android.gms.games.key.signInOptions", SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return bundle;
    }

    public final void zzM(TaskCompletionSource taskCompletionSource, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        com.google.android.gms.common.internal.zzah.checkState(!snapshotContents.isClosed(), gZrKCJ.kgKgd);
        BitmapTeleporter bitmapTeleporterZza = snapshotMetadataChange.zza();
        if (bitmapTeleporterZza != null) {
            File cacheDir = getContext().getCacheDir();
            if (cacheDir != null) {
                bitmapTeleporterZza.zaf = cacheDir;
            } else {
                throw new NullPointerException("Cannot set null temp directory");
            }
        }
        Contents contentsZza = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzam) getService()).zzB(new zzq(taskCompletionSource), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZza);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }
}
