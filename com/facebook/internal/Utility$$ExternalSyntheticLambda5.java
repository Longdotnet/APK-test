package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Utility$$ExternalSyntheticLambda5 implements FilenameFilter {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Utility$$ExternalSyntheticLambda5(int i) {
        this.$r8$classId = i;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String name) {
        switch (this.$r8$classId) {
            case 0:
                return Pattern.matches("cpu[0-9]+", name);
            case 1:
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Pattern patternCompile = Pattern.compile(String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{"crash_log_", "shield_log_", "thread_check_log_"}, 3)));
                Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                return patternCompile.matcher(name).matches();
            case 2:
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Pattern patternCompile2 = Pattern.compile(String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"anr_log_"}, 1)));
                Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(pattern)");
                return patternCompile2.matcher(name).matches();
            case 3:
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Pattern patternCompile3 = Pattern.compile(String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"analysis_log_"}, 1)));
                Intrinsics.checkNotNullExpressionValue(patternCompile3, "compile(pattern)");
                return patternCompile3.matcher(name).matches();
            default:
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Pattern patternCompile4 = Pattern.compile(String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{"error_log_"}, 1)));
                Intrinsics.checkNotNullExpressionValue(patternCompile4, "compile(pattern)");
                return patternCompile4.matcher(name).matches();
        }
    }
}
