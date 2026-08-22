package com.google.common.base;

import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class CaseFormat {
    public static final /* synthetic */ CaseFormat[] $VALUES;
    public static final AnonymousClass3 LOWER_CAMEL;
    public static final AnonymousClass1 LOWER_HYPHEN;
    public static final AnonymousClass2 LOWER_UNDERSCORE;
    public static final AnonymousClass5 UPPER_UNDERSCORE;
    public final CharMatcher.FastMatcher wordBoundary;
    public final String wordSeparator;

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$1, reason: invalid class name */
    public final enum AnonymousClass1 extends CaseFormat {
        @Override // com.google.common.base.CaseFormat
        public final String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            return caseFormat == CaseFormat.UPPER_UNDERSCORE ? ExceptionsKt.toUpperCase(str.replace('-', '_')) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public final String normalizeWord(String str) {
            return ExceptionsKt.toLowerCase(str);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$2, reason: invalid class name */
    public final enum AnonymousClass2 extends CaseFormat {
        @Override // com.google.common.base.CaseFormat
        public final String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            return caseFormat == CaseFormat.UPPER_UNDERSCORE ? ExceptionsKt.toUpperCase(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public final String normalizeWord(String str) {
            return ExceptionsKt.toLowerCase(str);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$3, reason: invalid class name */
    public final enum AnonymousClass3 extends CaseFormat {
        @Override // com.google.common.base.CaseFormat
        public final String normalizeFirstWord(String str) {
            return ExceptionsKt.toLowerCase(str);
        }

        @Override // com.google.common.base.CaseFormat
        public final String normalizeWord(String str) {
            return CaseFormat.access$100(str);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$4, reason: invalid class name */
    public final enum AnonymousClass4 extends CaseFormat {
        @Override // com.google.common.base.CaseFormat
        public final String normalizeWord(String str) {
            return CaseFormat.access$100(str);
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CaseFormat$5, reason: invalid class name */
    public final enum AnonymousClass5 extends CaseFormat {
        @Override // com.google.common.base.CaseFormat
        public final String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return ExceptionsKt.toLowerCase(str.replace('_', '-'));
            }
            return caseFormat == CaseFormat.LOWER_UNDERSCORE ? ExceptionsKt.toLowerCase(str) : super.convert(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public final String normalizeWord(String str) {
            return ExceptionsKt.toUpperCase(str);
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("LOWER_HYPHEN", 0, new CharMatcher.Is('-', 0), "-");
        LOWER_HYPHEN = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2("LOWER_UNDERSCORE", 1, new CharMatcher.Is('_', 0), "_");
        LOWER_UNDERSCORE = anonymousClass2;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3("LOWER_CAMEL", 2, new CharMatcher.InRange(), "");
        LOWER_CAMEL = anonymousClass3;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4("UPPER_CAMEL", 3, new CharMatcher.InRange(), "");
        AnonymousClass5 anonymousClass5 = new AnonymousClass5("UPPER_UNDERSCORE", 4, new CharMatcher.Is('_', 0), "_");
        UPPER_UNDERSCORE = anonymousClass5;
        $VALUES = new CaseFormat[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5};
    }

    public CaseFormat(String str, int i, CharMatcher.FastMatcher fastMatcher, String str2) {
        super(str, i);
        this.wordBoundary = fastMatcher;
        this.wordSeparator = str2;
    }

    public static String access$100(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt ^ ' ');
        }
        sb.append(cCharAt);
        sb.append(ExceptionsKt.toLowerCase(str.substring(1)));
        return sb.toString();
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int length = 0;
        int iIndexIn = -1;
        while (true) {
            iIndexIn = this.wordBoundary.indexIn(iIndexIn + 1, str);
            if (iIndexIn == -1) {
                break;
            }
            if (length == 0) {
                sb = new StringBuilder((caseFormat.wordSeparator.length() * 4) + str.length());
                sb.append(caseFormat.normalizeFirstWord(str.substring(length, iIndexIn)));
            } else {
                Objects.requireNonNull(sb);
                sb.append(caseFormat.normalizeWord(str.substring(length, iIndexIn)));
            }
            sb.append(caseFormat.wordSeparator);
            length = this.wordSeparator.length() + iIndexIn;
        }
        if (length == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        Objects.requireNonNull(sb);
        sb.append(caseFormat.normalizeWord(str.substring(length)));
        return sb.toString();
    }

    public String normalizeFirstWord(String str) {
        return normalizeWord(str);
    }

    public abstract String normalizeWord(String str);
}
