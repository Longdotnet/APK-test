package com.facebook;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class HttpMethod {
    public static final /* synthetic */ HttpMethod[] $VALUES;
    public static final HttpMethod GET;
    public static final HttpMethod POST;

    static {
        HttpMethod httpMethod = new HttpMethod("GET", 0);
        GET = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("POST", 1);
        POST = httpMethod2;
        $VALUES = new HttpMethod[]{httpMethod, httpMethod2, new HttpMethod("DELETE", 2)};
    }

    public static HttpMethod valueOf(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (HttpMethod) Enum.valueOf(HttpMethod.class, value);
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) Arrays.copyOf($VALUES, 3);
    }
}
