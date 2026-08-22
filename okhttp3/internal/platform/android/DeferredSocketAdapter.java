package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DeferredSocketAdapter implements SocketAdapter {
    public SocketAdapter delegate;
    public final Factory socketAdapterFactory;

    public interface Factory {
        SocketAdapter create(SSLSocket sSLSocket);

        boolean matchesSocket(SSLSocket sSLSocket);
    }

    public DeferredSocketAdapter(Factory factory) {
        this.socketAdapterFactory = factory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        SocketAdapter delegate = getDelegate(sSLSocket);
        if (delegate != null) {
            delegate.configureTlsExtensions(sSLSocket, str, protocols);
        }
    }

    public final synchronized SocketAdapter getDelegate(SSLSocket sSLSocket) {
        try {
            if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sSLSocket)) {
                this.delegate = this.socketAdapterFactory.create(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.delegate;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        SocketAdapter delegate = getDelegate(sSLSocket);
        if (delegate != null) {
            return delegate.getSelectedProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        return true;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return this.socketAdapterFactory.matchesSocket(sSLSocket);
    }
}
