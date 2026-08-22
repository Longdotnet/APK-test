package com.google.zxing.datamatrix.encoder;

import com.google.firebase.auth.zzr;
import kotlin.jvm.JvmClassMappingKt;

/* JADX INFO: loaded from: classes3.dex */
public final class X12Encoder extends zzr {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ X12Encoder(int i) {
        super(23);
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.auth.zzr
    public void encode(EncoderContext encoderContext) {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder();
                while (encoderContext.hasMoreCharacters()) {
                    char currentChar = encoderContext.getCurrentChar();
                    encoderContext.pos++;
                    encodeChar(currentChar, sb);
                    if (sb.length() % 3 == 0) {
                        zzr.writeNextTriplet(encoderContext, sb);
                        if (JvmClassMappingKt.lookAheadTest(encoderContext.msg, encoderContext.pos, 3) != 3) {
                            encoderContext.newEncoding = 0;
                            handleEOD(encoderContext, sb);
                            break;
                        }
                    }
                }
                handleEOD(encoderContext, sb);
                break;
            default:
                super.encode(encoderContext);
                break;
        }
    }

    @Override // com.google.firebase.auth.zzr
    public final int encodeChar(char c, StringBuilder sb) {
        switch (this.$r8$classId) {
            case 0:
                if (c == '\r') {
                    sb.append((char) 0);
                } else if (c == ' ') {
                    sb.append((char) 3);
                } else if (c == '*') {
                    sb.append((char) 1);
                } else if (c == '>') {
                    sb.append((char) 2);
                } else if (c >= '0' && c <= '9') {
                    sb.append((char) (c - ','));
                } else {
                    if (c < 'A' || c > 'Z') {
                        JvmClassMappingKt.illegalCharacter(c);
                        throw null;
                    }
                    sb.append((char) (c - '3'));
                }
                return 1;
            default:
                if (c == ' ') {
                    sb.append((char) 3);
                    return 1;
                }
                if (c >= '0' && c <= '9') {
                    sb.append((char) (c - ','));
                    return 1;
                }
                if (c >= 'a' && c <= 'z') {
                    sb.append((char) (c - 'S'));
                    return 1;
                }
                if (c < ' ') {
                    sb.append((char) 0);
                    sb.append(c);
                } else if (c >= '!' && c <= '/') {
                    sb.append((char) 1);
                    sb.append((char) (c - '!'));
                } else if (c >= ':' && c <= '@') {
                    sb.append((char) 1);
                    sb.append((char) (c - '+'));
                } else if (c >= '[' && c <= '_') {
                    sb.append((char) 1);
                    sb.append((char) (c - 'E'));
                } else if (c == '`') {
                    sb.append((char) 2);
                    sb.append((char) (c - '`'));
                } else if (c >= 'A' && c <= 'Z') {
                    sb.append((char) 2);
                    sb.append((char) (c - '@'));
                } else {
                    if (c < '{' || c > 127) {
                        sb.append("\u0001\u001e");
                        return encodeChar((char) (c - 128), sb) + 2;
                    }
                    sb.append((char) 2);
                    sb.append((char) (c - '`'));
                }
                return 2;
        }
    }

    @Override // com.google.firebase.auth.zzr
    public final int getEncodingMode() {
        switch (this.$r8$classId) {
            case 0:
                return 3;
            default:
                return 2;
        }
    }

    @Override // com.google.firebase.auth.zzr
    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb2 = encoderContext.codewords;
                encoderContext.updateSymbolInfo(sb2.length());
                int length = encoderContext.symbolInfo.dataCapacity - sb2.length();
                encoderContext.pos -= sb.length();
                String str = encoderContext.msg;
                if ((str.length() - encoderContext.skipAtEnd) - encoderContext.pos > 1 || length > 1 || (str.length() - encoderContext.skipAtEnd) - encoderContext.pos != length) {
                    encoderContext.writeCodeword((char) 254);
                }
                if (encoderContext.newEncoding < 0) {
                    encoderContext.newEncoding = 0;
                }
                break;
            default:
                super.handleEOD(encoderContext, sb);
                break;
        }
    }
}
