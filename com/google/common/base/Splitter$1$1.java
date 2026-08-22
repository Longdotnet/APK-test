package com.google.common.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.facebook.AccessTokenCache;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class Splitter$1$1 implements Iterator {
    public final /* synthetic */ int $r8$classId;
    public int limit;
    public String next;
    public int offset;
    public int state;
    public final /* synthetic */ Object this$0;
    public final String toSplit;
    public final CharMatcher.None trimmer;

    public Splitter$1$1(Splitter splitter, String str) {
        this.state = 2;
        this.offset = 0;
        this.trimmer = (CharMatcher.None) splitter.trimmer;
        this.limit = splitter.limit;
        this.toSplit = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String string;
        int iIndexIn;
        int iEnd;
        int i = this.state;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(i);
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 2) {
            return false;
        }
        this.state = 4;
        int i2 = this.offset;
        while (true) {
            int i3 = this.offset;
            if (i3 != -1) {
                switch (this.$r8$classId) {
                    case 0:
                        iIndexIn = ((CharMatcher.Is) ((AccessTokenCache) this.this$0).sharedPreferences).indexIn(i3, this.toSplit);
                        break;
                    default:
                        Fragment.AnonymousClass7 anonymousClass7 = (Fragment.AnonymousClass7) this.this$0;
                        iIndexIn = !((Matcher) anonymousClass7.this$0).find(i3) ? -1 : ((Matcher) anonymousClass7.this$0).start();
                        break;
                }
                String str = this.toSplit;
                if (iIndexIn == -1) {
                    iIndexIn = str.length();
                    this.offset = -1;
                } else {
                    switch (this.$r8$classId) {
                        case 0:
                            iEnd = iIndexIn + 1;
                            break;
                        default:
                            iEnd = ((Matcher) ((Fragment.AnonymousClass7) this.this$0).this$0).end();
                            break;
                    }
                    this.offset = iEnd;
                }
                int i4 = this.offset;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.offset = i5;
                    if (i5 > str.length()) {
                        this.offset = -1;
                    }
                } else {
                    CharMatcher.None none = this.trimmer;
                    if (i2 < iIndexIn) {
                        str.charAt(i2);
                        none.getClass();
                    }
                    if (iIndexIn > i2) {
                        str.charAt(iIndexIn - 1);
                        none.getClass();
                    }
                    int i6 = this.limit;
                    if (i6 == 1) {
                        iIndexIn = str.length();
                        this.offset = -1;
                        if (iIndexIn > i2) {
                            str.charAt(iIndexIn - 1);
                            none.getClass();
                        }
                    } else {
                        this.limit = i6 - 1;
                    }
                    string = str.subSequence(i2, iIndexIn).toString();
                }
            } else {
                this.state = 3;
                string = null;
            }
        }
        this.next = string;
        if (this.state == 3) {
            return false;
        }
        this.state = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = 2;
        String str = this.next;
        this.next = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Splitter$1$1(AccessTokenCache accessTokenCache, Splitter splitter, String str) {
        this(splitter, str);
        this.$r8$classId = 0;
        this.this$0 = accessTokenCache;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Splitter$1$1(Splitter splitter, String str, Fragment.AnonymousClass7 anonymousClass7) {
        this(splitter, str);
        this.$r8$classId = 1;
        this.this$0 = anonymousClass7;
    }
}
