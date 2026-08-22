package com.facebook.internal;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.util.Arrays;
import java.util.EnumSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public enum SmartLoginOption {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("None"),
    Enabled(MnHfHMYQDPUO.KbYlcOPwuNLEnrD),
    RequireConfirm("RequireConfirm");

    public static final EnumSet ALL;
    public final long value;

    SmartLoginOption(String str) {
        this.value = j;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static SmartLoginOption[] valuesCustom() {
        return (SmartLoginOption[]) Arrays.copyOf(values(), 3);
    }

    static {
        EnumSet enumSetAllOf = EnumSet.allOf(SmartLoginOption.class);
        Intrinsics.checkNotNullExpressionValue(enumSetAllOf, "allOf(SmartLoginOption::class.java)");
        ALL = enumSetAllOf;
    }
}
