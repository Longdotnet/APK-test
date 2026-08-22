package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Route {
    public final Address address;
    public final Proxy proxy;
    public final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (Intrinsics.areEqual(route.address, this.address) && Intrinsics.areEqual(route.proxy, this.proxy) && Intrinsics.areEqual(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
