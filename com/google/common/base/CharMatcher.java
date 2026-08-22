package com.google.common.base;

import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class CharMatcher implements Predicate {

    public final class Any extends NamedFastMatcher {
        public static final Any INSTANCE = new Any("CharMatcher.any()");

        @Override // com.google.common.base.CharMatcher
        public final int indexIn(int i, String str) {
            int length = str.length();
            StringsKt__IndentKt.checkPositionIndex(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, java.util.function.Predicate
        public final CharMatcher negate() {
            return None.INSTANCE;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, java.util.function.Predicate
        public final java.util.function.Predicate negate() {
            return None.INSTANCE;
        }
    }

    public abstract class FastMatcher extends CharMatcher {
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return matches(((Character) obj).charValue());
        }

        @Override // java.util.function.Predicate
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
    }

    public final class InRange extends FastMatcher {
        public final char startInclusive = 'A';
        public final char endInclusive = 'Z';

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            return this.startInclusive <= c && c <= this.endInclusive;
        }

        public final String toString() {
            return "CharMatcher.inRange('" + CharMatcher.access$100(this.startInclusive) + "', '" + CharMatcher.access$100(this.endInclusive) + "')";
        }
    }

    public abstract class NamedFastMatcher extends FastMatcher {
        public final String description;

        public NamedFastMatcher(String str) {
            this.description = str;
        }

        public final String toString() {
            return this.description;
        }
    }

    public final class NegatedFastMatcher extends CharMatcher {
        public final FastMatcher original;

        public NegatedFastMatcher(FastMatcher fastMatcher) {
            this.original = fastMatcher;
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return matches(((Character) obj).charValue());
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            return !this.original.matches(c);
        }

        @Override // java.util.function.Predicate
        public final java.util.function.Predicate negate() {
            return this.original;
        }

        public final String toString() {
            return this.original + ".negate()";
        }
    }

    public final class None extends NamedFastMatcher {
        public static final None INSTANCE = new None("CharMatcher.none()");

        @Override // com.google.common.base.CharMatcher
        public final int indexIn(int i, String str) {
            StringsKt__IndentKt.checkPositionIndex(i, str.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, java.util.function.Predicate
        public final CharMatcher negate() {
            return Any.INSTANCE;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, java.util.function.Predicate
        public final java.util.function.Predicate negate() {
            return Any.INSTANCE;
        }
    }

    public static String access$100(char c) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public int indexIn(int i, String str) {
        int length = str.length();
        StringsKt__IndentKt.checkPositionIndex(i, length);
        while (i < length) {
            if (matches(str.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean matches(char c);

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return apply(obj);
    }

    public final class Is extends FastMatcher {
        public final /* synthetic */ int $r8$classId;
        public final char match;

        public /* synthetic */ Is(char c, int i) {
            this.$r8$classId = i;
            this.match = c;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean matches(char c) {
            switch (this.$r8$classId) {
                case 0:
                    return c == this.match;
                default:
                    return c != this.match;
            }
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, java.util.function.Predicate
        public final /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return negate();
        }

        public final String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "CharMatcher.is('" + CharMatcher.access$100(this.match) + "')";
                default:
                    return "CharMatcher.isNot('" + CharMatcher.access$100(this.match) + "')";
            }
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, java.util.function.Predicate
        public final CharMatcher negate() {
            switch (this.$r8$classId) {
                case 0:
                    return new Is(this.match, 1);
                default:
                    return new Is(this.match, 0);
            }
        }
    }
}
