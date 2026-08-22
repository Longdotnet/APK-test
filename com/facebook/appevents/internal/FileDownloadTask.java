package com.facebook.appevents.internal;

import android.os.AsyncTask;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FileDownloadTask extends AsyncTask {
    public final File destFile;
    public final Callback onSuccess;
    public final String uriStr;

    public interface Callback {
        void onComplete(File file);
    }

    public FileDownloadTask(String uriStr, File file, Callback callback) {
        Intrinsics.checkNotNullParameter(uriStr, "uriStr");
        this.uriStr = uriStr;
        this.destFile = file;
        this.onSuccess = callback;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return doInBackground((String[]) objArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
                return null;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (!CrashShieldHandler.isObjectCrashing(this) && zBooleanValue) {
                        try {
                            this.onSuccess.onComplete(this.destFile);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(this, th);
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(this, th2);
                    return;
                }
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(this, th3);
                return;
            }
            CrashShieldHandler.handleThrowable(this, th);
        } catch (Throwable th4) {
            CrashShieldHandler.handleThrowable(this, th4);
        }
    }

    public final Boolean doInBackground(String... args) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(args, "args");
                try {
                    URL url = new URL(this.uriStr);
                    int contentLength = url.openConnection().getContentLength();
                    DataInputStream dataInputStream = new DataInputStream(url.openStream());
                    byte[] bArr = new byte[contentLength];
                    dataInputStream.readFully(bArr);
                    dataInputStream.close();
                    DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(this, th);
                return null;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(this, th2);
            return null;
        }
    }
}
