package okhttp3.internal.connection;

import com.android.billingclient.api.zzda;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: loaded from: classes3.dex */
public final class ExchangeFinder {
    public final Address address;
    public final RealCall call;
    public final RealConnectionPool connectionPool;
    public int connectionShutdownCount;
    public Route nextRouteToTry;
    public int otherFailureCount;
    public int refusedStreamCount;
    public zzda routeSelection;
    public RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool connectionPool, Address address, RealCall call) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(call, "call");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x01b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:60:0x012c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0147  */
    /* JADX WARN: Code duplicated, block: B:99:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final RealConnection findHealthyConnection(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        Route route;
        zzda zzdaVar;
        RouteSelector routeSelector;
        zzda next;
        ArrayList arrayList;
        Socket socketReleaseConnectionNoEvents$okhttp;
        while (!this.call.canceled) {
            RealConnection realConnection = this.call.connection;
            if (realConnection != null) {
                synchronized (realConnection) {
                    try {
                        socketReleaseConnectionNoEvents$okhttp = (realConnection.noNewExchanges || !sameHostAndPort(realConnection.route.address.url)) ? this.call.releaseConnectionNoEvents$okhttp() : null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.call.connection == null) {
                    if (socketReleaseConnectionNoEvents$okhttp != null) {
                        Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                    }
                    RealCall call = this.call;
                    Intrinsics.checkNotNullParameter(call, "call");
                    this.refusedStreamCount = 0;
                    this.connectionShutdownCount = 0;
                    this.otherFailureCount = 0;
                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                        realConnection = this.call.connection;
                        Intrinsics.checkNotNull(realConnection);
                        RealCall call2 = this.call;
                        Intrinsics.checkNotNullParameter(call2, "call");
                    } else {
                        route = this.nextRouteToTry;
                        try {
                            if (route != null) {
                                this.nextRouteToTry = null;
                            } else {
                                zzdaVar = this.routeSelection;
                                if (zzdaVar == null && zzdaVar.hasNext()) {
                                    zzda zzdaVar2 = this.routeSelection;
                                    Intrinsics.checkNotNull(zzdaVar2);
                                    if (!zzdaVar2.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    int i4 = zzdaVar2.zzb;
                                    zzdaVar2.zzb = i4 + 1;
                                    route = (Route) ((ArrayList) zzdaVar2.zza).get(i4);
                                } else {
                                    routeSelector = this.routeSelector;
                                    if (routeSelector == null) {
                                        Address address = this.address;
                                        RealCall realCall = this.call;
                                        routeSelector = new RouteSelector(address, realCall.client.routeDatabase, realCall);
                                        this.routeSelector = routeSelector;
                                    }
                                    next = routeSelector.next();
                                    this.routeSelection = next;
                                    arrayList = (ArrayList) next.zza;
                                    if (!this.call.canceled) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, false)) {
                                        realConnection = this.call.connection;
                                        Intrinsics.checkNotNull(realConnection);
                                        RealCall call3 = this.call;
                                        Intrinsics.checkNotNullParameter(call3, "call");
                                    } else {
                                        if (next.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        int i5 = next.zzb;
                                        next.zzb = i5 + 1;
                                        route = (Route) ((ArrayList) next.zza).get(i5);
                                        realConnection = new RealConnection(this.connectionPool, route);
                                        this.call.connectionToCancel = realConnection;
                                        realConnection.connect(i, i2, i3, z, this.call);
                                        this.call.connectionToCancel = null;
                                        this.call.client.routeDatabase.connected(route);
                                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                                            RealConnection realConnection2 = this.call.connection;
                                            Intrinsics.checkNotNull(realConnection2);
                                            this.nextRouteToTry = route;
                                            Socket socket = realConnection.socket;
                                            Intrinsics.checkNotNull(socket);
                                            Util.closeQuietly(socket);
                                            RealCall call4 = this.call;
                                            Intrinsics.checkNotNullParameter(call4, "call");
                                            realConnection = realConnection2;
                                        } else {
                                            synchronized (realConnection) {
                                                RealConnectionPool realConnectionPool = this.connectionPool;
                                                realConnectionPool.getClass();
                                                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                                                ((ConcurrentLinkedQueue) realConnectionPool.connections).add(realConnection);
                                                ((TaskQueue) realConnectionPool.cleanupQueue).schedule((TaskQueue$execute$1) realConnectionPool.cleanupTask, 0L);
                                                this.call.acquireConnectionNoEvents(realConnection);
                                            }
                                            RealCall call5 = this.call;
                                            Intrinsics.checkNotNullParameter(call5, "call");
                                        }
                                    }
                                }
                            }
                            realConnection.connect(i, i2, i3, z, this.call);
                            this.call.connectionToCancel = null;
                            this.call.client.routeDatabase.connected(route);
                            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                                RealConnection realConnection3 = this.call.connection;
                                Intrinsics.checkNotNull(realConnection3);
                                this.nextRouteToTry = route;
                                Socket socket2 = realConnection.socket;
                                Intrinsics.checkNotNull(socket2);
                                Util.closeQuietly(socket2);
                                RealCall call6 = this.call;
                                Intrinsics.checkNotNullParameter(call6, "call");
                                realConnection = realConnection3;
                            } else {
                                synchronized (realConnection) {
                                    RealConnectionPool realConnectionPool2 = this.connectionPool;
                                    realConnectionPool2.getClass();
                                    byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                                    ((ConcurrentLinkedQueue) realConnectionPool2.connections).add(realConnection);
                                    ((TaskQueue) realConnectionPool2.cleanupQueue).schedule((TaskQueue$execute$1) realConnectionPool2.cleanupTask, 0L);
                                    this.call.acquireConnectionNoEvents(realConnection);
                                    RealCall call7 = this.call;
                                    Intrinsics.checkNotNullParameter(call7, "call");
                                }
                            }
                        } catch (Throwable th2) {
                            this.call.connectionToCancel = null;
                            throw th2;
                        }
                        arrayList = null;
                        realConnection = new RealConnection(this.connectionPool, route);
                        this.call.connectionToCancel = realConnection;
                    }
                } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                this.refusedStreamCount = 0;
                this.connectionShutdownCount = 0;
                this.otherFailureCount = 0;
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                    realConnection = this.call.connection;
                    Intrinsics.checkNotNull(realConnection);
                    RealCall call8 = this.call;
                    Intrinsics.checkNotNullParameter(call8, "call");
                } else {
                    route = this.nextRouteToTry;
                    if (route != null) {
                        this.nextRouteToTry = null;
                    } else {
                        zzdaVar = this.routeSelection;
                        if (zzdaVar == null) {
                        }
                        routeSelector = this.routeSelector;
                        if (routeSelector == null) {
                            Address address2 = this.address;
                            RealCall realCall2 = this.call;
                            routeSelector = new RouteSelector(address2, realCall2.client.routeDatabase, realCall2);
                            this.routeSelector = routeSelector;
                        }
                        next = routeSelector.next();
                        this.routeSelection = next;
                        arrayList = (ArrayList) next.zza;
                        if (!this.call.canceled) {
                            throw new IOException("Canceled");
                        }
                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, false)) {
                            realConnection = this.call.connection;
                            Intrinsics.checkNotNull(realConnection);
                            RealCall call9 = this.call;
                            Intrinsics.checkNotNullParameter(call9, "call");
                        } else {
                            if (next.hasNext()) {
                                throw new NoSuchElementException();
                            }
                            int i6 = next.zzb;
                            next.zzb = i6 + 1;
                            route = (Route) ((ArrayList) next.zza).get(i6);
                            realConnection = new RealConnection(this.connectionPool, route);
                            this.call.connectionToCancel = realConnection;
                            realConnection.connect(i, i2, i3, z, this.call);
                            this.call.connectionToCancel = null;
                            this.call.client.routeDatabase.connected(route);
                            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                                RealConnection realConnection4 = this.call.connection;
                                Intrinsics.checkNotNull(realConnection4);
                                this.nextRouteToTry = route;
                                Socket socket3 = realConnection.socket;
                                Intrinsics.checkNotNull(socket3);
                                Util.closeQuietly(socket3);
                                RealCall call10 = this.call;
                                Intrinsics.checkNotNullParameter(call10, "call");
                                realConnection = realConnection4;
                            } else {
                                synchronized (realConnection) {
                                    RealConnectionPool realConnectionPool3 = this.connectionPool;
                                    realConnectionPool3.getClass();
                                    byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                                    ((ConcurrentLinkedQueue) realConnectionPool3.connections).add(realConnection);
                                    ((TaskQueue) realConnectionPool3.cleanupQueue).schedule((TaskQueue$execute$1) realConnectionPool3.cleanupTask, 0L);
                                    this.call.acquireConnectionNoEvents(realConnection);
                                    RealCall call11 = this.call;
                                    Intrinsics.checkNotNullParameter(call11, "call");
                                }
                            }
                        }
                    }
                    arrayList = null;
                    realConnection = new RealConnection(this.connectionPool, route);
                    this.call.connectionToCancel = realConnection;
                    realConnection.connect(i, i2, i3, z, this.call);
                    this.call.connectionToCancel = null;
                    this.call.client.routeDatabase.connected(route);
                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                        RealConnection realConnection5 = this.call.connection;
                        Intrinsics.checkNotNull(realConnection5);
                        this.nextRouteToTry = route;
                        Socket socket4 = realConnection.socket;
                        Intrinsics.checkNotNull(socket4);
                        Util.closeQuietly(socket4);
                        RealCall call12 = this.call;
                        Intrinsics.checkNotNullParameter(call12, "call");
                        realConnection = realConnection5;
                    } else {
                        synchronized (realConnection) {
                            RealConnectionPool realConnectionPool4 = this.connectionPool;
                            realConnectionPool4.getClass();
                            byte[] bArr4 = Util.EMPTY_BYTE_ARRAY;
                            ((ConcurrentLinkedQueue) realConnectionPool4.connections).add(realConnection);
                            ((TaskQueue) realConnectionPool4.cleanupQueue).schedule((TaskQueue$execute$1) realConnectionPool4.cleanupTask, 0L);
                            this.call.acquireConnectionNoEvents(realConnection);
                            RealCall call13 = this.call;
                            Intrinsics.checkNotNullParameter(call13, "call");
                        }
                    }
                }
            }
            if (realConnection.isHealthy(z2)) {
                return realConnection;
            }
            realConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                zzda zzdaVar3 = this.routeSelection;
                if (zzdaVar3 != null ? zzdaVar3.hasNext() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector2 = this.routeSelector;
                    if (!(routeSelector2 != null ? routeSelector2.hasNext() : true)) {
                        throw new IOException(PZmDzEagKNdW.MeANCjbCxl);
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean sameHostAndPort(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl httpUrl = this.address.url;
        return url.port == httpUrl.port && Intrinsics.areEqual(url.host, httpUrl.host);
    }

    public final void trackFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, kBfGXgdfpo.TKJHvaqbyQeQbss);
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == 8) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
