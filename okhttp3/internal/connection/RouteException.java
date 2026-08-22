package okhttp3.internal.connection;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class RouteException extends RuntimeException {
    public final IOException firstConnectException;
    public IOException lastConnectException;

    public RouteException(IOException iOException) {
        super(iOException);
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }
}
