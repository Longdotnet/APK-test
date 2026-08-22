package okhttp3;

import com.google.gson.JsonIOException;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionPool implements ObjectConstructor {
    public final Object delegate;

    public ConnectionPool(int i) {
        switch (i) {
            case 2:
                this.delegate = new LinkedHashSet();
                break;
            default:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
                this.delegate = new RealConnectionPool(TaskRunner.INSTANCE, timeUnit);
                break;
        }
    }

    public synchronized void connected(Route route) {
        Intrinsics.checkNotNullParameter(route, "route");
        ((LinkedHashSet) this.delegate).remove(route);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        Type type = (Type) this.delegate;
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
    }

    public ConnectionPool(Type type) {
        this.delegate = type;
    }
}
