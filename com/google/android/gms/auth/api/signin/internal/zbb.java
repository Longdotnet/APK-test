package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class zbb implements Runnable {
    public static final Logger zba = new Logger("RevokeAccessOperation", new String[0]);
    public final String zbb;
    public final StatusPendingResult zbc;

    public zbb(String str) {
        zzah.checkNotEmpty(str);
        this.zbb = str;
        this.zbc = new StatusPendingResult((GoogleApiClient) null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger = zba;
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            String strValueOf = String.valueOf(this.zbb);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strValueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(strValueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                logger.e("Unable to revoke access!", new Object[0]);
            }
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.d(sb.toString(), new Object[0]);
        } catch (IOException e) {
            String strValueOf2 = String.valueOf(e.toString());
            logger.e(strValueOf2.length() != 0 ? "IOException when revoking access: ".concat(strValueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            String strValueOf3 = String.valueOf(e2.toString());
            logger.e(strValueOf3.length() != 0 ? "Exception when revoking access: ".concat(strValueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.zbc.setResult(status);
    }
}
