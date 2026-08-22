package okhttp3.internal.proxy;

import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public final class NullProxySelector extends ProxySelector {
    public static final NullProxySelector INSTANCE = new NullProxySelector();

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public final List select(URI uri) {
        if (uri != null) {
            return Okio.listOf(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException(FETmZwrVHuasmL.DTPcbWTGOXZn);
    }
}
