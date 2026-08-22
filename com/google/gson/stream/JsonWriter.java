package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class JsonWriter implements Closeable, Flushable {
    public static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    public static final String[] REPLACEMENT_CHARS = new String[128];
    public String deferredName;
    public boolean htmlSafe;
    public boolean lenient;
    public final Writer out;
    public final String separator;
    public boolean serializeNulls;
    public int[] stack;
    public int stackSize;

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        if (iArr.length == 0) {
            this.stack = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        iArr2[i] = 6;
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void beforeValue() throws IOException {
        int iPeek = peek();
        if (iPeek == 1) {
            this.stack[this.stackSize - 1] = 2;
            newline();
            return;
        }
        Writer writer = this.out;
        if (iPeek == 2) {
            writer.append(',');
            newline();
        } else {
            if (iPeek == 4) {
                writer.append((CharSequence) this.separator);
                this.stack[this.stackSize - 1] = 5;
                return;
            }
            if (iPeek != 6) {
                if (iPeek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.stack[this.stackSize - 1] = 7;
        }
    }

    public void beginArray() throws IOException {
        writeDeferredName();
        beforeValue();
        int i = this.stackSize;
        int[] iArr = this.stack;
        if (i == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr2[i2] = 1;
        this.out.write(91);
    }

    public void beginObject() throws IOException {
        writeDeferredName();
        beforeValue();
        int i = this.stackSize;
        int[] iArr = this.stack;
        if (i == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr2[i2] = 3;
        this.out.write(123);
    }

    public final void close(int i, int i2, char c) throws IOException {
        int iPeek = peek();
        if (iPeek != i2 && iPeek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        this.stackSize--;
        if (iPeek == i2) {
            newline();
        }
        this.out.write(c);
    }

    public void endArray() throws IOException {
        close(1, 2, ']');
    }

    public void endObject() throws IOException {
        close(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public void name(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException();
        }
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.deferredName = str;
    }

    public final void newline() {
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            writeDeferredName();
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public final int peek() {
        int i = this.stackSize;
        if (i != 0) {
            return this.stack[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    public final void string(String str) throws IOException {
        String str2;
        String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        Writer writer = this.out;
        writer.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        writer.write(str, i, i2 - i);
                    }
                    writer.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    writer.write(str, i, i2 - i);
                }
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
        writer.write(34);
    }

    public void value(String str) throws IOException {
        if (str == null) {
            nullValue();
            return;
        }
        writeDeferredName();
        beforeValue();
        string(str);
    }

    public final void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            int iPeek = peek();
            if (iPeek == 5) {
                this.out.write(44);
            } else if (iPeek != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            newline();
            this.stack[this.stackSize - 1] = 4;
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public void value(boolean z) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z ? "true" : "false");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.stackSize;
        if (i <= 1 && (i != 1 || this.stack[i - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void value(long j) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j));
    }

    public void value(Number number) throws IOException {
        if (number == null) {
            nullValue();
            return;
        }
        writeDeferredName();
        String string = number.toString();
        if (!this.lenient && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) string);
    }
}
