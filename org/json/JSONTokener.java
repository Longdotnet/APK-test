package org.json;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes3.dex */
public final class JSONTokener {
    public int character;
    public boolean eof;
    public int index;
    public int line;
    public char previous;
    public final Reader reader;
    public boolean usePrevious;

    public JSONTokener(String str) {
        Reader stringReader = new StringReader(str);
        this.reader = stringReader.markSupported() ? stringReader : new BufferedReader(stringReader);
        this.eof = false;
        this.usePrevious = false;
        this.previous = (char) 0;
        this.index = 0;
        this.character = 1;
        this.line = 1;
    }

    public final void back() {
        int i;
        if (this.usePrevious || (i = this.index) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.index = i - 1;
        this.character--;
        this.usePrevious = true;
        this.eof = false;
    }

    public final char next() throws JSONException {
        int i;
        if (this.usePrevious) {
            this.usePrevious = false;
            i = this.previous;
        } else {
            try {
                i = this.reader.read();
                if (i <= 0) {
                    this.eof = true;
                    i = 0;
                }
            } catch (IOException e) {
                JSONException jSONException = new JSONException(e.getMessage());
                jSONException.cause = e;
                throw jSONException;
            }
        }
        this.index++;
        if (this.previous == '\r') {
            this.line++;
            this.character = i != 10 ? 1 : 0;
        } else if (i == 10) {
            this.line++;
            this.character = 0;
        } else {
            this.character++;
        }
        char c = (char) i;
        this.previous = c;
        return c;
    }

    public final char nextClean() {
        char next;
        do {
            next = next();
            if (next == 0) {
                break;
            }
        } while (next <= ' ');
        return next;
    }

    public final Object nextValue() {
        char cNextClean = nextClean();
        if (cNextClean != '\"' && cNextClean != '\'') {
            if (cNextClean == '[') {
                back();
                return new JSONArray(this);
            }
            if (cNextClean == '{') {
                back();
                return new JSONObject(this);
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cNextClean >= ' ' && ",:]}/\\\"[{;=#".indexOf(cNextClean) < 0) {
                stringBuffer.append(cNextClean);
                cNextClean = next();
            }
            back();
            String strTrim = stringBuffer.toString().trim();
            if (strTrim.equals("")) {
                throw syntaxError("Missing value");
            }
            return JSONObject.stringToValue(strTrim);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char next = next();
            if (next == 0 || next == '\n' || next == '\r') {
                break;
            }
            if (next == '\\') {
                char next2 = next();
                if (next2 == '\"' || next2 == '\'' || next2 == '/' || next2 == '\\') {
                    stringBuffer2.append(next2);
                } else if (next2 == 'b') {
                    stringBuffer2.append('\b');
                } else if (next2 == 'f') {
                    stringBuffer2.append('\f');
                } else if (next2 == 'n') {
                    stringBuffer2.append('\n');
                } else if (next2 == 'r') {
                    stringBuffer2.append('\r');
                } else if (next2 == 't') {
                    stringBuffer2.append('\t');
                } else {
                    if (next2 != 'u') {
                        throw syntaxError("Illegal escape.");
                    }
                    char[] cArr = new char[4];
                    for (int i = 0; i < 4; i++) {
                        cArr[i] = next();
                        if (this.eof && !this.usePrevious) {
                            throw syntaxError("Substring bounds error");
                        }
                    }
                    stringBuffer2.append((char) Integer.parseInt(new String(cArr), 16));
                }
            } else {
                if (next == cNextClean) {
                    return stringBuffer2.toString();
                }
                stringBuffer2.append(next);
            }
        }
        throw syntaxError("Unterminated string");
    }

    public final JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" at ");
        sb.append(this.index);
        sb.append(" [character ");
        sb.append(this.character);
        sb.append(" line ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.line, "]");
    }
}
