package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.fragment.app.Fragment;
import com.facebook.GraphRequest;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.zap;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class zbt extends com.google.android.gms.internal.p000authapi.zbb {
    public final RevocationBoundService zba;

    public zbt(RevocationBoundService revocationBoundService) {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
        this.zba = revocationBoundService;
    }

    public final void zbd$1() {
        if (Hex.isGooglePlayServicesUid(this.zba, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) {
        PendingResult pendingResultExecute;
        RevocationBoundService revocationBoundService = this.zba;
        if (i == 1) {
            zbd$1();
            Storage storage = Storage.getInstance(revocationBoundService);
            GoogleSignInAccount savedDefaultGoogleSignInAccount = storage.getSavedDefaultGoogleSignInAccount();
            GoogleSignInOptions savedDefaultGoogleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
            if (savedDefaultGoogleSignInAccount != null) {
                savedDefaultGoogleSignInOptions = storage.getSavedDefaultGoogleSignInOptions();
            }
            zzah.checkNotNull(savedDefaultGoogleSignInOptions);
            GoogleSignInClient googleSignInClient = new GoogleSignInClient(revocationBoundService, Auth.GOOGLE_SIGN_IN_API, savedDefaultGoogleSignInOptions, new ApiExceptionMapper());
            if (savedDefaultGoogleSignInAccount != null) {
                GoogleApiClient googleApiClientAsGoogleApiClient = googleSignInClient.asGoogleApiClient();
                Context applicationContext = googleSignInClient.getApplicationContext();
                boolean z = googleSignInClient.zba() == 3;
                zbm.zba.d("Revoking access", new Object[0]);
                String strZaa = Storage.getInstance(applicationContext).zaa(CyjpdoedCdLTIO.jQaz);
                zbm.zbh(applicationContext);
                if (!z) {
                    pendingResultExecute = googleApiClientAsGoogleApiClient.execute(new zbk(googleApiClientAsGoogleApiClient));
                } else if (strZaa == null) {
                    Logger logger = zbb.zba;
                    pendingResultExecute = PendingResults.immediateFailedResult(new Status(4), null);
                } else {
                    zbb zbbVar = new zbb(strZaa);
                    new Thread(zbbVar).start();
                    pendingResultExecute = zbbVar.zbc;
                }
                pendingResultExecute.addStatusListener(new zap(pendingResultExecute, new TaskCompletionSource(), new GraphRequest.Companion(28)));
            } else {
                GoogleApiClient googleApiClientAsGoogleApiClient2 = googleSignInClient.asGoogleApiClient();
                Context applicationContext2 = googleSignInClient.getApplicationContext();
                boolean z2 = googleSignInClient.zba() == 3;
                zbm.zba.d("Signing out", new Object[0]);
                zbm.zbh(applicationContext2);
                PendingResult pendingResultImmediatePendingResult = z2 ? PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClientAsGoogleApiClient2) : googleApiClientAsGoogleApiClient2.execute(new zbi(googleApiClientAsGoogleApiClient2));
                pendingResultImmediatePendingResult.addStatusListener(new zap(pendingResultImmediatePendingResult, new TaskCompletionSource(), new GraphRequest.Companion(28)));
            }
        } else {
            if (i != 2) {
                return false;
            }
            zbd$1();
            Fragment.AnonymousClass7.zbc(revocationBoundService).zbd();
        }
        return true;
    }
}
