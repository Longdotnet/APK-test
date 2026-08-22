package com.facebook.login;

import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class CodeChallengeMethod {
    public static final /* synthetic */ CodeChallengeMethod[] $VALUES = {new CodeChallengeMethod("S256", 0), new CodeChallengeMethod("PLAIN", 1)};

    /* JADX INFO: Fake field, exist only in values array */
    CodeChallengeMethod EF6;

    public static CodeChallengeMethod[] values() {
        return (CodeChallengeMethod[]) Arrays.copyOf($VALUES, 2);
    }

    public static CodeChallengeMethod valueOf(String str) {
        Intrinsics.checkNotNullParameter(str, TSDAbK.wJNqcId);
        return (CodeChallengeMethod) Enum.valueOf(CodeChallengeMethod.class, str);
    }
}
