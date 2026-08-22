package androidx.profileinstaller;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public interface ProfileInstaller$DiagnosticsCallback {
    void onDiagnosticReceived();

    void onResultReceived(int i, Serializable serializable);
}
