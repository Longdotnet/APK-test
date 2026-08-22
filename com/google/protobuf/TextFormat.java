package com.google.protobuf;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes3.dex */
public final class TextFormat {
    private static final String DEBUG_STRING_SILENT_MARKER = "\t ";
    private static final String REDACTED_MARKER = "[REDACTED]";
    private static final Logger logger = Logger.getLogger(TextFormat.class.getName());
    private static final Parser PARSER = Parser.newBuilder().build();

    /* JADX INFO: renamed from: com.google.protobuf.TextFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = iArr2;
            try {
                iArr2[Descriptors.FieldDescriptor.JavaType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        public InvalidEscapeSequenceException(String str) {
            super(str);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(String str) {
            this(-1, -1, str);
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }

        public ParseException(int i, int i2, String str) {
            super(Integer.toString(i) + ":" + i2 + ": " + str);
            this.line = i;
            this.column = i2;
        }
    }

    public static class Parser {
        private static final int BUFFER_SIZE = 4096;
        private final boolean allowUnknownEnumValues;
        private final boolean allowUnknownExtensions;
        private final boolean allowUnknownFields;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final int recursionLimit;
        private final SingularOverwritePolicy singularOverwritePolicy;
        private final TypeRegistry typeRegistry;

        public static class Builder {
            private boolean allowUnknownFields = false;
            private boolean allowUnknownEnumValues = false;
            private boolean allowUnknownExtensions = false;
            private SingularOverwritePolicy singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder = null;
            private TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();
            private int recursionLimit = 100;

            public Parser build() {
                return new Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder, this.recursionLimit, null);
            }

            public Builder setAllowUnknownExtensions(boolean z) {
                this.allowUnknownExtensions = z;
                return this;
            }

            public Builder setAllowUnknownFields(boolean z) {
                this.allowUnknownFields = z;
                return this;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder builder) {
                this.parseInfoTreeBuilder = builder;
                return this;
            }

            public Builder setRecursionLimit(int i) {
                this.recursionLimit = i;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy singularOverwritePolicy) {
                this.singularOverwritePolicy = singularOverwritePolicy;
                return this;
            }

            public Builder setTypeRegistry(TypeRegistry typeRegistry) {
                this.typeRegistry = typeRegistry;
                return this;
            }
        }

        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        public static final class UnknownField {
            final String message;
            final Type type;

            public enum Type {
                FIELD,
                EXTENSION
            }

            public UnknownField(String str, Type type) {
                this.message = str;
                this.type = type;
            }
        }

        public /* synthetic */ Parser(TypeRegistry typeRegistry, boolean z, boolean z2, boolean z3, SingularOverwritePolicy singularOverwritePolicy, TextFormatParseInfoTree.Builder builder, int i, AnonymousClass1 anonymousClass1) {
            this(typeRegistry, z, z2, z3, singularOverwritePolicy, builder, i);
        }

        private void checkUnknownFields(List<UnknownField> list) throws ParseException {
            int i;
            if (list.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder("Input contains unknown fields and/or extensions:");
            for (UnknownField unknownField : list) {
                sb.append('\n');
                sb.append(unknownField.message);
            }
            if (this.allowUnknownFields) {
                TextFormat.logger.warning(sb.toString());
                return;
            }
            if (this.allowUnknownExtensions) {
                Iterator<UnknownField> it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (it.next().type != UnknownField.Type.FIELD) {
                        i++;
                    }
                }
                TextFormat.logger.warning(sb.toString());
                return;
            }
            i = 0;
            String[] strArrSplit = list.get(i).message.split(":");
            throw new ParseException(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), sb.toString());
        }

        private void consumeFieldValue(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, Descriptors.FieldDescriptor fieldDescriptor, ExtensionRegistry.ExtensionInfo extensionInfo, TextFormatParseInfoTree.Builder builder, List<UnknownField> list, int i) throws ParseException {
            String str;
            if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && !fieldDescriptor.isRepeated()) {
                if (mergeTarget.hasField(fieldDescriptor)) {
                    throw tokenizer.parseExceptionPreviousToken("Non-repeated field \"" + fieldDescriptor.getFullName() + "\" cannot be overwritten.");
                }
                if (fieldDescriptor.getContainingOneof() != null && mergeTarget.hasOneof(fieldDescriptor.getContainingOneof())) {
                    Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
                    throw tokenizer.parseExceptionPreviousToken("Field \"" + fieldDescriptor.getFullName() + "\" is specified along with field \"" + mergeTarget.getOneofFieldDescriptor(containingOneof).getFullName() + "\", another member of oneof \"" + containingOneof.getName() + "\".");
                }
            }
            Object objValueOf = null;
            if (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        objValueOf = Integer.valueOf(tokenizer.consumeInt32());
                        break;
                    case 4:
                    case 5:
                    case 6:
                        objValueOf = Long.valueOf(tokenizer.consumeInt64());
                        break;
                    case 7:
                        objValueOf = Boolean.valueOf(tokenizer.consumeBoolean());
                        break;
                    case 8:
                        objValueOf = Float.valueOf(tokenizer.consumeFloat());
                        break;
                    case 9:
                        objValueOf = Double.valueOf(tokenizer.consumeDouble());
                        break;
                    case 10:
                    case 11:
                        objValueOf = Integer.valueOf(tokenizer.consumeUInt32());
                        break;
                    case 12:
                    case 13:
                        objValueOf = Long.valueOf(tokenizer.consumeUInt64());
                        break;
                    case 14:
                        objValueOf = tokenizer.consumeString();
                        break;
                    case 15:
                        objValueOf = tokenizer.consumeByteString();
                        break;
                    case 16:
                        Descriptors.EnumDescriptor enumType = fieldDescriptor.getEnumType();
                        if (tokenizer.lookingAtInteger()) {
                            int iConsumeInt32 = tokenizer.consumeInt32();
                            objValueOf = enumType.isClosed() ? enumType.findValueByNumber(iConsumeInt32) : enumType.findValueByNumberCreatingIfUnknown(iConsumeInt32);
                            if (objValueOf == null) {
                                String str2 = "Enum type \"" + enumType.getFullName() + "\" has no value with number " + iConsumeInt32 + '.';
                                if (this.allowUnknownEnumValues) {
                                    TextFormat.logger.warning(str2);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + iConsumeInt32 + '.');
                            }
                        } else {
                            String strConsumeIdentifier = tokenizer.consumeIdentifier();
                            objValueOf = enumType.findValueByName(strConsumeIdentifier);
                            if (objValueOf == null) {
                                String str3 = "Enum type \"" + enumType.getFullName() + "\" has no value named \"" + strConsumeIdentifier + "\".";
                                if (!this.allowUnknownEnumValues) {
                                    throw tokenizer.parseExceptionPreviousToken(str3);
                                }
                                TextFormat.logger.warning(str3);
                                return;
                            }
                        }
                    case 17:
                    case 18:
                        throw new RuntimeException("Can't get here.");
                }
            } else {
                if (i < 1) {
                    throw tokenizer.parseException("Message is nested too deep");
                }
                if (tokenizer.tryConsume("<")) {
                    str = ">";
                } else {
                    tokenizer.consume("{");
                    str = "}";
                }
                String str4 = str;
                MessageReflection.MergeTarget mergeTargetNewMergeTargetForField = mergeTarget.newMergeTargetForField(fieldDescriptor, extensionInfo != null ? extensionInfo.defaultInstance : null);
                while (!tokenizer.tryConsume(str4)) {
                    if (tokenizer.atEnd()) {
                        throw tokenizer.parseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Expected \"", str4, "\"."));
                    }
                    mergeField(tokenizer, extensionRegistry, mergeTargetNewMergeTargetForField, builder, list, i - 1);
                }
                objValueOf = mergeTargetNewMergeTargetForField.finish();
            }
            if (fieldDescriptor.isRepeated()) {
                mergeTarget.addRepeatedField(fieldDescriptor, objValueOf);
            } else {
                mergeTarget.setField(fieldDescriptor, objValueOf);
            }
        }

        private void consumeFieldValues(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, Descriptors.FieldDescriptor fieldDescriptor, ExtensionRegistry.ExtensionInfo extensionInfo, TextFormatParseInfoTree.Builder builder, List<UnknownField> list, int i) throws ParseException {
            if (!fieldDescriptor.isRepeated() || !tokenizer.tryConsume("[")) {
                consumeFieldValue(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list, i);
            } else {
                if (tokenizer.tryConsume("]")) {
                    return;
                }
                while (true) {
                    consumeFieldValue(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list, i);
                    if (tokenizer.tryConsume("]")) {
                        return;
                    } else {
                        tokenizer.consume(",");
                    }
                }
            }
        }

        private String consumeFullTypeName(Tokenizer tokenizer) throws ParseException {
            if (!tokenizer.tryConsume("[")) {
                return tokenizer.consumeIdentifier();
            }
            String strConsumeIdentifier = tokenizer.consumeIdentifier();
            while (tokenizer.tryConsume(".")) {
                strConsumeIdentifier = strConsumeIdentifier + "." + tokenizer.consumeIdentifier();
            }
            if (tokenizer.tryConsume("/")) {
                strConsumeIdentifier = strConsumeIdentifier + "/" + tokenizer.consumeIdentifier();
                while (tokenizer.tryConsume(".")) {
                    strConsumeIdentifier = strConsumeIdentifier + "." + tokenizer.consumeIdentifier();
                }
            }
            tokenizer.consume("]");
            return strConsumeIdentifier;
        }

        private void detectSilentMarker(Tokenizer tokenizer, Descriptors.Descriptor descriptor, String str) {
        }

        private void mergeAnyFieldValue(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, TextFormatParseInfoTree.Builder builder, List<UnknownField> list, Descriptors.Descriptor descriptor, int i) throws ParseException {
            String str;
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append(tokenizer.consumeIdentifier());
                if (tokenizer.tryConsume("]")) {
                    detectSilentMarker(tokenizer, descriptor, sb.toString());
                    tokenizer.tryConsume(":");
                    if (tokenizer.tryConsume("<")) {
                        str = ">";
                    } else {
                        tokenizer.consume("{");
                        str = PZmDzEagKNdW.ZmrLRdNrI;
                    }
                    String str2 = str;
                    String string = sb.toString();
                    try {
                        Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(string);
                        if (descriptorForTypeUrl == null) {
                            throw tokenizer.parseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(oKjScaD.okgXoEJWqm, string, ". Please make sure that the TypeRegistry contains the descriptors for the given types."));
                        }
                        DynamicMessage.Builder builderNewBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                        MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(builderNewBuilderForType);
                        while (!tokenizer.tryConsume(str2)) {
                            mergeField(tokenizer, extensionRegistry, builderAdapter, builder, list, i);
                        }
                        mergeTarget.setField(descriptor.findFieldByName("type_url"), sb.toString());
                        mergeTarget.setField(descriptor.findFieldByName(FirebaseAnalytics.Param.VALUE), builderNewBuilderForType.build().toByteString());
                        return;
                    } catch (InvalidProtocolBufferException unused) {
                        throw tokenizer.parseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Invalid valid type URL. Found: ", string));
                    }
                }
                if (tokenizer.tryConsume("/")) {
                    sb.append("/");
                } else {
                    if (!tokenizer.tryConsume(".")) {
                        throw tokenizer.parseExceptionPreviousToken("Expected a valid type URL.");
                    }
                    sb.append(".");
                }
            }
        }

        private void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, List<UnknownField> list, int i) throws ParseException {
            mergeField(tokenizer, extensionRegistry, mergeTarget, this.parseInfoTreeBuilder, list, i);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private void skipField(Tokenizer tokenizer, Descriptors.Descriptor descriptor, int i) {
            detectSilentMarker(tokenizer, descriptor, consumeFullTypeName(tokenizer));
            guessFieldTypeAndSkip(tokenizer, descriptor, i);
            if (tokenizer.tryConsume(";")) {
                return;
            }
            tokenizer.tryConsume(",");
        }

        private void skipFieldMessage(Tokenizer tokenizer, Descriptors.Descriptor descriptor, int i) throws ParseException {
            String str;
            if (tokenizer.tryConsume("<")) {
                str = ">";
            } else {
                tokenizer.consume("{");
                str = "}";
            }
            while (!tokenizer.lookingAt(">") && !tokenizer.lookingAt("}")) {
                skipField(tokenizer, descriptor, i);
            }
            tokenizer.consume(str);
        }

        private void skipFieldShortFormedRepeated(Tokenizer tokenizer, boolean z, Descriptors.Descriptor descriptor, int i) throws ParseException {
            if (!tokenizer.tryConsume("[") || tokenizer.tryConsume("]")) {
                return;
            }
            while (true) {
                if (tokenizer.lookingAt("{") || tokenizer.lookingAt("<")) {
                    if (i < 1) {
                        throw tokenizer.parseException("Message is nested too deep");
                    }
                    skipFieldMessage(tokenizer, descriptor, i - 1);
                } else {
                    if (!z) {
                        throw tokenizer.parseException("Invalid repeated scalar field: missing \":\" before \"[\".");
                    }
                    skipFieldValue(tokenizer);
                }
                if (tokenizer.tryConsume("]")) {
                    return;
                } else {
                    tokenizer.consume(",");
                }
            }
        }

        private void skipFieldValue(Tokenizer tokenizer) throws ParseException {
            if (tokenizer.tryConsumeByteString() || tokenizer.tryConsumeIdentifier() || tokenizer.tryConsumeInt64() || tokenizer.tryConsumeUInt64() || tokenizer.tryConsumeDouble() || tokenizer.tryConsumeFloat()) {
                return;
            }
            throw tokenizer.parseException("Invalid field value: " + tokenizer.currentToken);
        }

        private static StringBuilder toStringBuilder(Readable readable) throws IOException {
            StringBuilder sb = new StringBuilder();
            CharBuffer charBufferAllocate = CharBuffer.allocate(4096);
            while (true) {
                int i = readable.read(charBufferAllocate);
                if (i == -1) {
                    return sb;
                }
                Java8Compatibility.flip(charBufferAllocate);
                sb.append((CharSequence) charBufferAllocate, 0, i);
            }
        }

        public void merge(Readable readable, Message.Builder builder) throws ParseException {
            merge(readable, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        private Parser(TypeRegistry typeRegistry, boolean z, boolean z2, boolean z3, SingularOverwritePolicy singularOverwritePolicy, TextFormatParseInfoTree.Builder builder, int i) {
            this.typeRegistry = typeRegistry;
            this.allowUnknownFields = z;
            this.allowUnknownEnumValues = z2;
            this.allowUnknownExtensions = z3;
            this.singularOverwritePolicy = singularOverwritePolicy;
            this.parseInfoTreeBuilder = builder;
            this.recursionLimit = i;
        }

        private void guessFieldTypeAndSkip(Tokenizer tokenizer, Descriptors.Descriptor descriptor, int i) throws ParseException {
            boolean zTryConsume = tokenizer.tryConsume(":");
            if (tokenizer.lookingAt("[")) {
                skipFieldShortFormedRepeated(tokenizer, zTryConsume, descriptor, i);
                return;
            }
            if (zTryConsume && !tokenizer.lookingAt("{") && !tokenizer.lookingAt(DaWYVMJ.PfTtEjddxB)) {
                skipFieldValue(tokenizer);
            } else {
                if (i < 1) {
                    throw tokenizer.parseException("Message is nested too deep");
                }
                skipFieldMessage(tokenizer, descriptor, i - 1);
            }
        }

        private void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget mergeTarget, TextFormatParseInfoTree.Builder builder, List<UnknownField> list, int i) throws ParseException {
            String strConsumeIdentifier;
            Descriptors.FieldDescriptor fieldDescriptor;
            ExtensionRegistry.ExtensionInfo extensionInfo;
            Descriptors.FieldDescriptor fieldDescriptor2;
            int line = tokenizer.getLine();
            int column = tokenizer.getColumn();
            Descriptors.Descriptor descriptorForType = mergeTarget.getDescriptorForType();
            if ("google.protobuf.Any".equals(descriptorForType.getFullName()) && tokenizer.tryConsume("[")) {
                if (i < 1) {
                    throw tokenizer.parseException("Message is nested too deep");
                }
                mergeAnyFieldValue(tokenizer, extensionRegistry, mergeTarget, builder, list, descriptorForType, i - 1);
                return;
            }
            if (tokenizer.tryConsume("[")) {
                StringBuilder sb = new StringBuilder(tokenizer.consumeIdentifier());
                while (tokenizer.tryConsume(".")) {
                    sb.append('.');
                    sb.append(tokenizer.consumeIdentifier());
                }
                strConsumeIdentifier = sb.toString();
                ExtensionRegistry.ExtensionInfo extensionInfoFindExtensionByName = mergeTarget.findExtensionByName(extensionRegistry, strConsumeIdentifier);
                if (extensionInfoFindExtensionByName == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(tokenizer.getPreviousLine() + 1);
                    sb2.append(":");
                    sb2.append(tokenizer.getPreviousColumn() + 1);
                    sb2.append(":\t");
                    sb2.append(descriptorForType.getFullName());
                    list.add(new UnknownField(Fragment$$ExternalSyntheticOutline0.m(sb2, ".[", strConsumeIdentifier, "]"), UnknownField.Type.EXTENSION));
                    fieldDescriptor2 = null;
                } else {
                    if (extensionInfoFindExtensionByName.descriptor.getContainingType() != descriptorForType) {
                        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Extension \"", strConsumeIdentifier, JrbhsraGtto.GWDVUzUvcuOEgz);
                        sbM21m.append(descriptorForType.getFullName());
                        sbM21m.append("\".");
                        throw tokenizer.parseExceptionPreviousToken(sbM21m.toString());
                    }
                    fieldDescriptor2 = extensionInfoFindExtensionByName.descriptor;
                }
                tokenizer.consume("]");
                extensionInfo = extensionInfoFindExtensionByName;
                fieldDescriptor = fieldDescriptor2;
            } else {
                strConsumeIdentifier = tokenizer.consumeIdentifier();
                Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName(strConsumeIdentifier);
                if (fieldDescriptorFindFieldByName == null) {
                    fieldDescriptorFindFieldByName = descriptorForType.findFieldByName(strConsumeIdentifier.toLowerCase(Locale.US));
                    if (fieldDescriptorFindFieldByName != null && !fieldDescriptorFindFieldByName.isGroupLike()) {
                        fieldDescriptorFindFieldByName = null;
                    }
                    if (fieldDescriptorFindFieldByName != null && !fieldDescriptorFindFieldByName.getMessageType().getName().equals(strConsumeIdentifier)) {
                        fieldDescriptorFindFieldByName = null;
                    }
                }
                if (fieldDescriptorFindFieldByName == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(tokenizer.getPreviousLine() + 1);
                    sb3.append(":");
                    sb3.append(tokenizer.getPreviousColumn() + 1);
                    sb3.append(":\t");
                    sb3.append(descriptorForType.getFullName());
                    list.add(new UnknownField(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb3, ".", strConsumeIdentifier), UnknownField.Type.FIELD));
                }
                fieldDescriptor = fieldDescriptorFindFieldByName;
                extensionInfo = null;
            }
            if (fieldDescriptor == null) {
                detectSilentMarker(tokenizer, descriptorForType, strConsumeIdentifier);
                guessFieldTypeAndSkip(tokenizer, descriptorForType, i);
                return;
            }
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                detectSilentMarker(tokenizer, descriptorForType, fieldDescriptor.getFullName());
                tokenizer.tryConsume(":");
                if (builder != null) {
                    consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder.getBuilderForSubMessageField(fieldDescriptor), list, i);
                } else {
                    consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list, i);
                }
            } else {
                detectSilentMarker(tokenizer, descriptorForType, fieldDescriptor.getFullName());
                tokenizer.consume(":");
                consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list, i);
            }
            if (builder != null) {
                builder.setLocation(fieldDescriptor, TextFormatParseLocation.create(line, column));
            }
            if (tokenizer.tryConsume(";")) {
                return;
            }
            tokenizer.tryConsume(",");
        }

        public void merge(CharSequence charSequence, Message.Builder builder) throws ParseException {
            merge(charSequence, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(Readable readable, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
            merge(toStringBuilder(readable), extensionRegistry, builder);
        }

        public void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
            Tokenizer tokenizer = new Tokenizer(charSequence, null);
            MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(builder);
            ArrayList arrayList = new ArrayList();
            while (!tokenizer.atEnd()) {
                mergeField(tokenizer, extensionRegistry, builderAdapter, arrayList, this.recursionLimit);
            }
            checkUnknownFields(arrayList);
        }
    }

    public static final class Printer {
        private final boolean enablingSafeDebugFormat;
        private final boolean escapeNonAscii;
        private final ExtensionRegistryLite extensionRegistry;
        private final boolean singleLine;
        private final TypeRegistry typeRegistry;
        private static final Printer DEFAULT_TEXT_FORMAT = new Printer(true, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), false, false);
        private static final Printer DEFAULT_DEBUG_FORMAT = new Printer(true, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), true, false);
        private static final ThreadLocal<FieldReporterLevel> sensitiveFieldReportingLevel = new ThreadLocal<FieldReporterLevel>() { // from class: com.google.protobuf.TextFormat.Printer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public FieldReporterLevel initialValue() {
                return FieldReporterLevel.ABSTRACT_MUTABLE_TO_STRING;
            }
        };

        public enum FieldReporterLevel {
            NO_REPORT(0),
            PRINT(1),
            PRINTER_PRINT_TO_STRING(2),
            TEXTFORMAT_PRINT_TO_STRING(3),
            PRINT_UNICODE(4),
            SHORT_DEBUG_STRING(5),
            LEGACY_MULTILINE(6),
            LEGACY_SINGLE_LINE(7),
            DEBUG_MULTILINE(8),
            DEBUG_SINGLE_LINE(9),
            ABSTRACT_TO_STRING(10),
            ABSTRACT_MUTABLE_TO_STRING(11);

            private final int index;

            FieldReporterLevel(int i) {
                this.index = i;
            }
        }

        public static class MapEntryAdapter implements Comparable<MapEntryAdapter> {
            private Object entry;
            private final Descriptors.FieldDescriptor.JavaType fieldType;
            private MapEntry mapEntry;

            public MapEntryAdapter(Object obj, Descriptors.FieldDescriptor fieldDescriptor) {
                if (obj instanceof MapEntry) {
                    this.mapEntry = (MapEntry) obj;
                } else {
                    this.entry = obj;
                }
                this.fieldType = extractFieldType(fieldDescriptor);
            }

            private static Descriptors.FieldDescriptor.JavaType extractFieldType(Descriptors.FieldDescriptor fieldDescriptor) {
                return fieldDescriptor.getMessageType().getFields().get(0).getJavaType();
            }

            public Object getEntry() {
                MapEntry mapEntry = this.mapEntry;
                return mapEntry != null ? mapEntry : this.entry;
            }

            public Object getKey() {
                MapEntry mapEntry = this.mapEntry;
                if (mapEntry != null) {
                    return mapEntry.getKey();
                }
                return null;
            }

            @Override // java.lang.Comparable
            public int compareTo(MapEntryAdapter mapEntryAdapter) {
                if (getKey() == null || mapEntryAdapter.getKey() == null) {
                    TextFormat.logger.info("Invalid key for map field.");
                    return -1;
                }
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.fieldType.ordinal()];
                if (i == 1) {
                    return ((Boolean) getKey()).compareTo((Boolean) mapEntryAdapter.getKey());
                }
                if (i == 2) {
                    return ((Long) getKey()).compareTo((Long) mapEntryAdapter.getKey());
                }
                if (i == 3) {
                    return ((Integer) getKey()).compareTo((Integer) mapEntryAdapter.getKey());
                }
                if (i != 4) {
                    return 0;
                }
                String str = (String) getKey();
                String str2 = (String) mapEntryAdapter.getKey();
                if (str == null && str2 == null) {
                    return 0;
                }
                if (str == null && str2 != null) {
                    return -1;
                }
                if (str == null || str2 != null) {
                    return str.compareTo(str2);
                }
                return 1;
            }
        }

        private Printer(boolean z, TypeRegistry typeRegistry, ExtensionRegistryLite extensionRegistryLite, boolean z2, boolean z3) {
            this.escapeNonAscii = z;
            this.typeRegistry = typeRegistry;
            this.extensionRegistry = extensionRegistryLite;
            this.enablingSafeDebugFormat = z2;
            this.singleLine = z3;
        }

        private void applyUnstablePrefix(Appendable appendable) {
            try {
                appendable.append("");
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        private boolean printAny(MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) throws IOException {
            Descriptors.Descriptor descriptorForType = messageOrBuilder.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = descriptorForType.findFieldByNumber(1);
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber2 = descriptorForType.findFieldByNumber(2);
            if (fieldDescriptorFindFieldByNumber != null && fieldDescriptorFindFieldByNumber.getType() == Descriptors.FieldDescriptor.Type.STRING && fieldDescriptorFindFieldByNumber2 != null && fieldDescriptorFindFieldByNumber2.getType() == Descriptors.FieldDescriptor.Type.BYTES) {
                String str = (String) messageOrBuilder.getField(fieldDescriptorFindFieldByNumber);
                if (str.isEmpty()) {
                    return false;
                }
                Object field = messageOrBuilder.getField(fieldDescriptorFindFieldByNumber2);
                try {
                    Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(str);
                    if (descriptorForTypeUrl == null) {
                        return false;
                    }
                    DynamicMessage.Builder builderNewBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                    builderNewBuilderForType.mergeFrom((ByteString) field, this.extensionRegistry);
                    textGenerator.print("[");
                    textGenerator.print(str);
                    textGenerator.print("] {");
                    textGenerator.eol();
                    textGenerator.indent();
                    print(builderNewBuilderForType, textGenerator);
                    textGenerator.outdent();
                    textGenerator.print("}");
                    textGenerator.eol();
                    return true;
                } catch (InvalidProtocolBufferException unused) {
                }
            }
            return false;
        }

        private void printMessage(MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) throws IOException {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : messageOrBuilder.getAllFields().entrySet()) {
                printField(entry.getKey(), entry.getValue(), textGenerator);
            }
            printUnknownFields(messageOrBuilder.getUnknownFields(), textGenerator, this.enablingSafeDebugFormat);
        }

        private void printSingleField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            if (fieldDescriptor.isExtension()) {
                textGenerator.print("[");
                if (fieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.isOptional() && fieldDescriptor.getExtensionScope() == fieldDescriptor.getMessageType()) {
                    textGenerator.print(fieldDescriptor.getMessageType().getFullName());
                } else {
                    textGenerator.print(fieldDescriptor.getFullName());
                }
                textGenerator.print("]");
            } else if (fieldDescriptor.isGroupLike()) {
                textGenerator.print(fieldDescriptor.getMessageType().getName());
            } else {
                textGenerator.print(fieldDescriptor.getName());
            }
            Descriptors.FieldDescriptor.JavaType javaType = fieldDescriptor.getJavaType();
            Descriptors.FieldDescriptor.JavaType javaType2 = Descriptors.FieldDescriptor.JavaType.MESSAGE;
            if (javaType == javaType2) {
                textGenerator.print(" {");
                textGenerator.eol();
                textGenerator.indent();
            } else {
                textGenerator.print(": ");
            }
            printFieldValue(fieldDescriptor, obj, textGenerator);
            if (fieldDescriptor.getJavaType() == javaType2) {
                textGenerator.outdent();
                textGenerator.print("}");
            }
            textGenerator.eol();
        }

        private static void printUnknownField(int i, int i2, List<?> list, TextGenerator textGenerator, boolean z) throws IOException {
            for (Object obj : list) {
                textGenerator.print(String.valueOf(i));
                textGenerator.print(": ");
                printUnknownFieldValue(i2, obj, textGenerator, z);
                textGenerator.eol();
            }
        }

        private static void printUnknownFieldValue(int i, Object obj, TextGenerator textGenerator, boolean z) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                textGenerator.print(z ? "UNKNOWN_VARINT [REDACTED]" : TextFormat.unsignedToString(((Long) obj).longValue()));
                return;
            }
            if (tagWireType == 1) {
                textGenerator.print(z ? kBfGXgdfpo.krQntFD : String.format(null, "0x%016x", (Long) obj));
                return;
            }
            if (tagWireType != 2) {
                if (tagWireType == 3) {
                    printUnknownFields((UnknownFieldSet) obj, textGenerator, z);
                    return;
                } else {
                    if (tagWireType != 5) {
                        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Bad tag: "));
                    }
                    textGenerator.print(z ? "UNKNOWN_FIXED32 [REDACTED]" : String.format(null, "0x%08x", (Integer) obj));
                    return;
                }
            }
            try {
                UnknownFieldSet from = UnknownFieldSet.parseFrom((ByteString) obj);
                textGenerator.print("{");
                textGenerator.eol();
                textGenerator.indent();
                printUnknownFields(from, textGenerator, z);
                textGenerator.outdent();
                textGenerator.print("}");
            } catch (InvalidProtocolBufferException unused) {
                if (z) {
                    textGenerator.print("UNKNOWN_STRING [REDACTED]");
                    return;
                }
                String str = eoBKjVuj.CYfbJllqASKFa;
                textGenerator.print(str);
                textGenerator.print(TextFormat.escapeBytes((ByteString) obj));
                textGenerator.print(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void printUnknownFields(UnknownFieldSet unknownFieldSet, TextGenerator textGenerator, boolean z) throws IOException {
            if (unknownFieldSet.isEmpty()) {
                return;
            }
            for (Map.Entry<Integer, UnknownFieldSet.Field> entry : unknownFieldSet.asMap().entrySet()) {
                int iIntValue = entry.getKey().intValue();
                UnknownFieldSet.Field value = entry.getValue();
                printUnknownField(iIntValue, 0, value.getVarintList(), textGenerator, z);
                printUnknownField(iIntValue, 5, value.getFixed32List(), textGenerator, z);
                printUnknownField(iIntValue, 1, value.getFixed64List(), textGenerator, z);
                printUnknownField(iIntValue, 2, value.getLengthDelimitedList(), textGenerator, z);
                for (UnknownFieldSet unknownFieldSet2 : value.getGroupList()) {
                    textGenerator.print(entry.getKey().toString());
                    textGenerator.print(" {");
                    textGenerator.eol();
                    textGenerator.indent();
                    printUnknownFields(unknownFieldSet2, textGenerator, z);
                    textGenerator.outdent();
                    textGenerator.print("}");
                    textGenerator.eol();
                }
            }
        }

        private boolean shouldRedact(Descriptors.FieldDescriptor fieldDescriptor, TextGenerator textGenerator) {
            boolean z;
            if (!shouldReport(textGenerator.fieldReporterLevel) && !this.enablingSafeDebugFormat) {
                return false;
            }
            if (fieldDescriptor.getOptions().hasDebugRedact() && fieldDescriptor.getOptions().getDebugRedact()) {
                z = true;
                break;
            }
            z = false;
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fieldDescriptor.getOptions().getAllFields().entrySet()) {
                Descriptors.FieldDescriptor key = entry.getKey();
                if (key.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
                    if (!key.isRepeated()) {
                        if (shouldRedactOptionValue((Descriptors.EnumValueDescriptor) entry.getValue())) {
                            z = true;
                            break;
                        }
                    } else {
                        Iterator it = ((List) entry.getValue()).iterator();
                        while (it.hasNext()) {
                            if (shouldRedactOptionValue((Descriptors.EnumValueDescriptor) it.next())) {
                                z = true;
                                break;
                            }
                        }
                    }
                }
            }
            return z && this.enablingSafeDebugFormat;
        }

        private boolean shouldRedactOptionValue(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getOptions().hasDebugRedact()) {
                return enumValueDescriptor.getOptions().getDebugRedact();
            }
            return false;
        }

        private boolean shouldReport(FieldReporterLevel fieldReporterLevel) {
            return sensitiveFieldReportingLevel.get().compareTo(fieldReporterLevel) < 0;
        }

        public Printer emittingSingleLine(boolean z) {
            return new Printer(this.escapeNonAscii, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, z);
        }

        public Printer enablingSafeDebugFormat(boolean z) {
            return new Printer(this.escapeNonAscii, this.typeRegistry, this.extensionRegistry, z, this.singleLine);
        }

        public Printer escapingNonAscii(boolean z) {
            return new Printer(z, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        }

        public void print(MessageOrBuilder messageOrBuilder, Appendable appendable) throws IOException {
            print(messageOrBuilder, appendable, FieldReporterLevel.PRINT);
        }

        public void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
            printField(fieldDescriptor, obj, TextFormat.setSingleLineOutput(appendable, this.singleLine));
        }

        public String printFieldToString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            try {
                StringBuilder sb = new StringBuilder();
                if (this.enablingSafeDebugFormat) {
                    applyUnstablePrefix(sb);
                }
                printField(fieldDescriptor, obj, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public void printFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, Appendable appendable) throws IOException {
            printFieldValue(fieldDescriptor, obj, TextFormat.setSingleLineOutput(appendable, this.singleLine));
        }

        public String printToString(MessageOrBuilder messageOrBuilder) {
            return printToString(messageOrBuilder, FieldReporterLevel.PRINTER_PRINT_TO_STRING);
        }

        public void setSensitiveFieldReportingLevel(FieldReporterLevel fieldReporterLevel) {
            sensitiveFieldReportingLevel.set(fieldReporterLevel);
        }

        @Deprecated
        public String shortDebugString(MessageOrBuilder messageOrBuilder) {
            return emittingSingleLine(true).printToString(messageOrBuilder, FieldReporterLevel.SHORT_DEBUG_STRING);
        }

        public Printer usingExtensionRegistry(ExtensionRegistryLite extensionRegistryLite) {
            if (this.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) {
                return new Printer(this.escapeNonAscii, this.typeRegistry, extensionRegistryLite, this.enablingSafeDebugFormat, this.singleLine);
            }
            throw new IllegalArgumentException("Only one extensionRegistry is allowed.");
        }

        public Printer usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.typeRegistry == TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(this.escapeNonAscii, typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
            }
            throw new IllegalArgumentException("Only one typeRegistry is allowed.");
        }

        private void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            if (!fieldDescriptor.isMapField()) {
                if (!fieldDescriptor.isRepeated()) {
                    printSingleField(fieldDescriptor, obj, textGenerator);
                    return;
                }
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    printSingleField(fieldDescriptor, it.next(), textGenerator);
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                arrayList.add(new MapEntryAdapter(it2.next(), fieldDescriptor));
            }
            Collections.sort(arrayList);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                printSingleField(fieldDescriptor, ((MapEntryAdapter) it3.next()).getEntry(), textGenerator);
            }
        }

        private void printFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) throws IOException {
            if (shouldRedact(fieldDescriptor, textGenerator)) {
                textGenerator.print(TextFormat.REDACTED_MARKER);
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    textGenerator.eol();
                }
                return;
            }
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    textGenerator.print(((Integer) obj).toString());
                    break;
                case 4:
                case 5:
                case 6:
                    textGenerator.print(((Long) obj).toString());
                    break;
                case 7:
                    textGenerator.print(((Boolean) obj).toString());
                    break;
                case 8:
                    textGenerator.print(((Float) obj).toString());
                    break;
                case 9:
                    textGenerator.print(((Double) obj).toString());
                    break;
                case 10:
                case 11:
                    textGenerator.print(TextFormat.unsignedToString(((Integer) obj).intValue()));
                    break;
                case 12:
                case 13:
                    textGenerator.print(TextFormat.unsignedToString(((Long) obj).longValue()));
                    break;
                case 14:
                    textGenerator.print("\"");
                    textGenerator.print(this.escapeNonAscii ? TextFormatEscaper.escapeText((String) obj) : TextFormat.escapeDoubleQuotesAndBackslashes((String) obj).replace("\n", "\\n"));
                    textGenerator.print("\"");
                    break;
                case 15:
                    textGenerator.print("\"");
                    if (obj instanceof ByteString) {
                        textGenerator.print(TextFormat.escapeBytes((ByteString) obj));
                    } else {
                        textGenerator.print(TextFormat.escapeBytes((byte[]) obj));
                    }
                    textGenerator.print("\"");
                    break;
                case 16:
                    Descriptors.EnumValueDescriptor enumValueDescriptor = (Descriptors.EnumValueDescriptor) obj;
                    if (enumValueDescriptor.getIndex() != -1) {
                        textGenerator.print(enumValueDescriptor.getName());
                    } else {
                        textGenerator.print(Integer.toString(enumValueDescriptor.getNumber()));
                    }
                    break;
                case 17:
                case 18:
                    print((MessageOrBuilder) obj, textGenerator);
                    break;
            }
        }

        public void print(MessageOrBuilder messageOrBuilder, Appendable appendable, FieldReporterLevel fieldReporterLevel) throws IOException {
            print(messageOrBuilder, TextFormat.setSingleLineOutput(appendable, this.singleLine, fieldReporterLevel));
        }

        public String printToString(MessageOrBuilder messageOrBuilder, FieldReporterLevel fieldReporterLevel) {
            try {
                StringBuilder sb = new StringBuilder();
                if (this.enablingSafeDebugFormat) {
                    applyUnstablePrefix(sb);
                }
                print(messageOrBuilder, sb, fieldReporterLevel);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Deprecated
        public String shortDebugString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return emittingSingleLine(true).printFieldToString(fieldDescriptor, obj);
        }

        public void print(UnknownFieldSet unknownFieldSet, Appendable appendable) throws IOException {
            printUnknownFields(unknownFieldSet, TextFormat.setSingleLineOutput(appendable, this.singleLine), this.enablingSafeDebugFormat);
        }

        @Deprecated
        public String shortDebugString(UnknownFieldSet unknownFieldSet) {
            return emittingSingleLine(true).printToString(unknownFieldSet);
        }

        private void print(MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) throws IOException {
            if (messageOrBuilder.getDescriptorForType().getFullName().equals("google.protobuf.Any") && printAny(messageOrBuilder, textGenerator)) {
                return;
            }
            printMessage(messageOrBuilder, textGenerator);
        }

        public String printToString(UnknownFieldSet unknownFieldSet) {
            try {
                StringBuilder sb = new StringBuilder();
                if (this.enablingSafeDebugFormat) {
                    applyUnstablePrefix(sb);
                }
                print(unknownFieldSet, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static final class TextGenerator {
        private boolean atStartOfLine;
        private final Printer.FieldReporterLevel fieldReporterLevel;
        private final StringBuilder indent;
        private final Appendable output;
        private final boolean singleLineMode;

        public /* synthetic */ TextGenerator(Appendable appendable, boolean z, Printer.FieldReporterLevel fieldReporterLevel, AnonymousClass1 anonymousClass1) {
            this(appendable, z, fieldReporterLevel);
        }

        public void eol() throws IOException {
            if (!this.singleLineMode) {
                this.output.append("\n");
            }
            this.atStartOfLine = true;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.setLength(length - 2);
        }

        public void print(CharSequence charSequence) throws IOException {
            if (this.atStartOfLine) {
                this.atStartOfLine = false;
                this.output.append(this.singleLineMode ? " " : this.indent);
            }
            this.output.append(charSequence);
        }

        private TextGenerator(Appendable appendable, boolean z, Printer.FieldReporterLevel fieldReporterLevel) {
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = appendable;
            this.singleLineMode = z;
            this.fieldReporterLevel = fieldReporterLevel;
        }
    }

    public static final class Tokenizer {
        private int column;
        private boolean containsSilentMarkerAfterCurrentToken;
        private boolean containsSilentMarkerAfterPrevToken;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;
        private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);

        public /* synthetic */ Tokenizer(CharSequence charSequence, AnonymousClass1 anonymousClass1) {
            this(charSequence);
        }

        private ParseException floatParseException(NumberFormatException numberFormatException) {
            return parseException("Couldn't parse number: " + numberFormatException.getMessage());
        }

        private ParseException integerParseException(NumberFormatException numberFormatException) {
            return parseException("Couldn't parse integer: " + numberFormatException.getMessage());
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                Matcher matcher = this.matcher;
                matcher.region(matcher.end(), this.matcher.regionEnd());
            }
        }

        public boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public void consume(String str) throws ParseException {
            if (!tryConsume(str)) {
                throw parseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Expected \"", str, "\"."));
            }
        }

        public boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true") || this.currentToken.equals("True") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            }
            if (!this.currentToken.equals("false") && !this.currentToken.equals("False") && !this.currentToken.equals("f") && !this.currentToken.equals("0")) {
                throw parseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder("Expected \"true\" or \"false\". Found \""), this.currentToken, "\"."));
            }
            nextToken();
            return false;
        }

        public ByteString consumeByteString() throws ParseException {
            ArrayList arrayList = new ArrayList();
            consumeByteString(arrayList);
            while (true) {
                if (!this.currentToken.startsWith("'") && !this.currentToken.startsWith("\"")) {
                    return ByteString.copyFrom(arrayList);
                }
                consumeByteString(arrayList);
            }
        }

        public double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean zStartsWith = this.currentToken.startsWith("-");
                nextToken();
                return zStartsWith ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            }
            if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            }
            try {
                double d = Double.parseDouble(this.currentToken);
                nextToken();
                return d;
            } catch (NumberFormatException e) {
                throw floatParseException(e);
            }
        }

        public float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean zStartsWith = this.currentToken.startsWith("-");
                nextToken();
                return zStartsWith ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            }
            if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            }
            try {
                float f = Float.parseFloat(this.currentToken);
                nextToken();
                return f;
            } catch (NumberFormatException e) {
                throw floatParseException(e);
            }
        }

        public String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char cCharAt = this.currentToken.charAt(i);
                if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && !(('0' <= cCharAt && cCharAt <= '9') || cCharAt == '_' || cCharAt == '.'))) {
                    throw parseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder("Expected identifier. Found '"), this.currentToken, "'"));
                }
            }
            String str = this.currentToken;
            nextToken();
            return str;
        }

        public int consumeInt32() throws ParseException {
            try {
                int int32 = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return int32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeInt64() throws ParseException {
            try {
                long int64 = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return int64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public String consumeString() {
            return consumeByteString().toStringUtf8();
        }

        public int consumeUInt32() throws ParseException {
            try {
                int uInt32 = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return uInt32;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeUInt64() throws ParseException {
            try {
                long uInt64 = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return uInt64;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public int getColumn() {
            return this.column;
        }

        public boolean getContainsSilentMarkerAfterCurrentToken() {
            return this.containsSilentMarkerAfterCurrentToken;
        }

        public boolean getContainsSilentMarkerAfterPrevToken() {
            return this.containsSilentMarkerAfterPrevToken;
        }

        public int getLine() {
            return this.line;
        }

        public int getPreviousColumn() {
            return this.previousColumn;
        }

        public int getPreviousLine() {
            return this.previousLine;
        }

        public boolean lookingAt(String str) {
            return this.currentToken.equals(str);
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char cCharAt = this.currentToken.charAt(0);
            return ('0' <= cCharAt && cCharAt <= '9') || cCharAt == '-' || cCharAt == '+';
        }

        public ParseException parseException(String str) {
            return new ParseException(this.line + 1, this.column + 1, str);
        }

        public ParseException parseExceptionPreviousToken(String str) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, str);
        }

        public boolean tryConsume(String str) {
            if (!this.currentToken.equals(str)) {
                return false;
            }
            nextToken();
            return true;
        }

        public boolean tryConsumeByteString() {
            try {
                consumeByteString();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public boolean tryConsumeDouble() {
            try {
                consumeDouble();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public boolean tryConsumeFloat() {
            try {
                consumeFloat();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public boolean tryConsumeIdentifier() {
            try {
                consumeIdentifier();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public boolean tryConsumeInt64() {
            try {
                consumeInt64();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        public boolean tryConsumeUInt64() {
            try {
                consumeUInt64();
                return true;
            } catch (ParseException unused) {
                return false;
            }
        }

        private Tokenizer(CharSequence charSequence) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.containsSilentMarkerAfterCurrentToken = false;
            this.containsSilentMarkerAfterPrevToken = false;
            this.text = charSequence;
            this.matcher = WHITESPACE.matcher(charSequence);
            skipWhitespace();
            nextToken();
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == '\n') {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = mnwSv.vHlTiEhVgjWGj;
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                Matcher matcher = this.matcher;
                matcher.region(matcher.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                Matcher matcher2 = this.matcher;
                matcher2.region(this.pos + 1, matcher2.regionEnd());
            }
            skipWhitespace();
        }

        private void consumeByteString(List<ByteString> list) throws ParseException {
            char cCharAt = this.currentToken.length() > 0 ? this.currentToken.charAt(0) : (char) 0;
            if (cCharAt != '\"' && cCharAt != '\'') {
                throw parseException("Expected string.");
            }
            if (this.currentToken.length() >= 2) {
                String str = this.currentToken;
                if (str.charAt(str.length() - 1) == cCharAt) {
                    try {
                        String str2 = this.currentToken;
                        ByteString byteStringUnescapeBytes = TextFormat.unescapeBytes(str2.substring(1, str2.length() - 1));
                        nextToken();
                        list.add(byteStringUnescapeBytes);
                        return;
                    } catch (InvalidEscapeSequenceException e) {
                        throw parseException(e.getMessage());
                    }
                }
            }
            throw parseException("String missing ending quote.");
        }
    }

    @Deprecated
    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(String str) {
            this(-1, -1, gZrKCJ.bIJ, str);
        }

        public String getUnknownField() {
            return this.unknownField;
        }

        public UnknownFieldParseException(int i, int i2, String str, String str2) {
            super(i, i2, str2);
            this.unknownField = str;
        }
    }

    private TextFormat() {
    }

    public static Printer debugFormatPrinter() {
        return Printer.DEFAULT_DEBUG_FORMAT;
    }

    private static int digitValue(byte b) {
        if (48 > b || b > 57) {
            return (97 > b || b > 122) ? b - 55 : b - 87;
        }
        return b - 48;
    }

    public static String escapeBytes(ByteString byteString) {
        return TextFormatEscaper.escapeBytes(byteString);
    }

    public static String escapeDoubleQuotesAndBackslashes(String str) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(str);
    }

    public static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }

    public static Parser getParser() {
        return PARSER;
    }

    private static boolean isHex(byte b) {
        return (48 <= b && b <= 57) || (97 <= b && b <= 102) || (65 <= b && b <= 70);
    }

    private static boolean isOctal(byte b) {
        return 48 <= b && b <= 55;
    }

    public static void merge(Readable readable, Message.Builder builder) throws ParseException {
        PARSER.merge(readable, builder);
    }

    public static <T extends Message> T parse(CharSequence charSequence, Class<T> cls) throws ParseException {
        Message.Builder builderNewBuilderForType = ((Message) Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, builderNewBuilderForType);
        return (T) builderNewBuilderForType.build();
    }

    public static int parseInt32(String str) {
        return (int) parseInteger(str, true, false);
    }

    public static long parseInt64(String str) {
        return parseInteger(str, true, true);
    }

    public static int parseUInt32(String str) {
        return (int) parseInteger(str, false, false);
    }

    public static long parseUInt64(String str) {
        return parseInteger(str, false, true);
    }

    public static void printUnknownFieldValue(int i, Object obj, Appendable appendable) throws IOException {
        printUnknownFieldValue(i, obj, setSingleLineOutput(appendable, false), false);
    }

    public static Printer printer() {
        return Printer.DEFAULT_TEXT_FORMAT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TextGenerator setSingleLineOutput(Appendable appendable, boolean z) {
        return new TextGenerator(appendable, z, Printer.FieldReporterLevel.NO_REPORT, null);
    }

    @Deprecated
    public static String shortDebugString(MessageOrBuilder messageOrBuilder) {
        return printer().emittingSingleLine(true).printToString(messageOrBuilder, Printer.FieldReporterLevel.SHORT_DEBUG_STRING);
    }

    public static ByteString unescapeBytes(CharSequence charSequence) throws InvalidEscapeSequenceException {
        int i;
        int i2;
        int length;
        int i3;
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8(charSequence.toString());
        int size = byteStringCopyFromUtf8.size();
        byte[] bArr = new byte[size];
        int i4 = 0;
        int i5 = 0;
        while (i4 < byteStringCopyFromUtf8.size()) {
            byte bByteAt = byteStringCopyFromUtf8.byteAt(i4);
            if (bByteAt == 92) {
                int i6 = i4 + 1;
                if (i6 >= byteStringCopyFromUtf8.size()) {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
                byte bByteAt2 = byteStringCopyFromUtf8.byteAt(i6);
                if (isOctal(bByteAt2)) {
                    int iDigitValue = digitValue(bByteAt2);
                    int i7 = i4 + 2;
                    if (i7 < byteStringCopyFromUtf8.size() && isOctal(byteStringCopyFromUtf8.byteAt(i7))) {
                        iDigitValue = (iDigitValue * 8) + digitValue(byteStringCopyFromUtf8.byteAt(i7));
                        i6 = i7;
                    }
                    i4 = i6 + 1;
                    if (i4 >= byteStringCopyFromUtf8.size() || !isOctal(byteStringCopyFromUtf8.byteAt(i4))) {
                        i4 = i6;
                    } else {
                        iDigitValue = (iDigitValue * 8) + digitValue(byteStringCopyFromUtf8.byteAt(i4));
                    }
                    i3 = i5 + 1;
                    bArr[i5] = (byte) iDigitValue;
                } else {
                    if (bByteAt2 == 34) {
                        i = i5 + 1;
                        bArr[i5] = 34;
                    } else if (bByteAt2 == 39) {
                        i = i5 + 1;
                        bArr[i5] = 39;
                    } else if (bByteAt2 != 63) {
                        if (bByteAt2 == 85) {
                            int i8 = i4 + 2;
                            i2 = i4 + 9;
                            if (i2 >= byteStringCopyFromUtf8.size()) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                            }
                            int iDigitValue2 = 0;
                            int i9 = i8;
                            while (true) {
                                int i10 = i4 + 10;
                                if (i9 < i10) {
                                    byte bByteAt3 = byteStringCopyFromUtf8.byteAt(i9);
                                    if (!isHex(bByteAt3)) {
                                        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                                    }
                                    iDigitValue2 = (iDigitValue2 << 4) | digitValue(bByteAt3);
                                    i9++;
                                } else {
                                    if (!Character.isValidCodePoint(iDigitValue2)) {
                                        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + byteStringCopyFromUtf8.substring(i8, i10).toStringUtf8() + "' is not a valid code point value");
                                    }
                                    Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(iDigitValue2);
                                    if (unicodeBlockOf != null && (unicodeBlockOf.equals(Character.UnicodeBlock.LOW_SURROGATES) || unicodeBlockOf.equals(Character.UnicodeBlock.HIGH_SURROGATES) || unicodeBlockOf.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES))) {
                                        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + byteStringCopyFromUtf8.substring(i8, i10).toStringUtf8() + "' refers to a surrogate code unit");
                                    }
                                    byte[] bytes = new String(new int[]{iDigitValue2}, 0, 1).getBytes(Internal.UTF_8);
                                    System.arraycopy(bytes, 0, bArr, i5, bytes.length);
                                    length = bytes.length;
                                }
                            }
                        } else if (bByteAt2 == 92) {
                            i = i5 + 1;
                            bArr[i5] = 92;
                        } else if (bByteAt2 == 102) {
                            i = i5 + 1;
                            bArr[i5] = 12;
                        } else if (bByteAt2 == 110) {
                            i = i5 + 1;
                            bArr[i5] = 10;
                        } else if (bByteAt2 == 114) {
                            i = i5 + 1;
                            bArr[i5] = 13;
                        } else if (bByteAt2 == 120) {
                            int i11 = i4 + 2;
                            if (i11 >= byteStringCopyFromUtf8.size() || !isHex(byteStringCopyFromUtf8.byteAt(i11))) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            }
                            int iDigitValue3 = digitValue(byteStringCopyFromUtf8.byteAt(i11));
                            i4 += 3;
                            if (i4 >= byteStringCopyFromUtf8.size() || !isHex(byteStringCopyFromUtf8.byteAt(i4))) {
                                i4 = i11;
                            } else {
                                iDigitValue3 = (iDigitValue3 * 16) + digitValue(byteStringCopyFromUtf8.byteAt(i4));
                            }
                            i3 = i5 + 1;
                            bArr[i5] = (byte) iDigitValue3;
                        } else if (bByteAt2 == 97) {
                            i = i5 + 1;
                            bArr[i5] = 7;
                        } else if (bByteAt2 != 98) {
                            switch (bByteAt2) {
                                case 116:
                                    i = i5 + 1;
                                    bArr[i5] = 9;
                                    break;
                                case 117:
                                    int i12 = i4 + 2;
                                    i2 = i4 + 5;
                                    if (i2 < byteStringCopyFromUtf8.size() && isHex(byteStringCopyFromUtf8.byteAt(i12))) {
                                        int i13 = i4 + 3;
                                        if (isHex(byteStringCopyFromUtf8.byteAt(i13))) {
                                            int i14 = i4 + 4;
                                            if (isHex(byteStringCopyFromUtf8.byteAt(i14)) && isHex(byteStringCopyFromUtf8.byteAt(i2))) {
                                                char cDigitValue = (char) ((digitValue(byteStringCopyFromUtf8.byteAt(i14)) << 4) | (digitValue(byteStringCopyFromUtf8.byteAt(i12)) << 12) | (digitValue(byteStringCopyFromUtf8.byteAt(i13)) << 8) | digitValue(byteStringCopyFromUtf8.byteAt(i2)));
                                                if (cDigitValue >= 55296 && cDigitValue <= 57343) {
                                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' refers to a surrogate");
                                                }
                                                byte[] bytes2 = Character.toString(cDigitValue).getBytes(Internal.UTF_8);
                                                System.arraycopy(bytes2, 0, bArr, i5, bytes2.length);
                                                length = bytes2.length;
                                                break;
                                            }
                                        }
                                    }
                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' with too few hex chars");
                                case 118:
                                    i = i5 + 1;
                                    bArr[i5] = 11;
                                    break;
                                default:
                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) bByteAt2) + '\'');
                            }
                        } else {
                            i = i5 + 1;
                            bArr[i5] = 8;
                        }
                        i5 += length;
                        i4 = i2;
                    } else {
                        i = i5 + 1;
                        bArr[i5] = 63;
                    }
                    i5 = i;
                    i4 = i6;
                }
                i5 = i3;
            } else {
                bArr[i5] = bByteAt;
                i5++;
            }
            i4++;
        }
        return size == i5 ? ByteString.wrap(bArr) : ByteString.copyFrom(bArr, 0, i5);
    }

    public static String unescapeText(String str) {
        return unescapeBytes(str).toStringUtf8();
    }

    public static String unsignedToString(int i) {
        return i >= 0 ? Integer.toString(i) : Long.toString(((long) i) & 4294967295L);
    }

    public static String escapeBytes(byte[] bArr) {
        return TextFormatEscaper.escapeBytes(bArr);
    }

    public static void merge(CharSequence charSequence, Message.Builder builder) throws ParseException {
        PARSER.merge(charSequence, builder);
    }

    private static long parseInteger(String str, boolean z, boolean z2) {
        int i;
        int i2 = 0;
        if (str.startsWith("-", 0)) {
            if (!z) {
                throw new NumberFormatException("Number must be positive: ".concat(str));
            }
            i2 = 1;
        }
        int i3 = i2;
        if (str.startsWith("0x", i2)) {
            i2 += 2;
            i = 16;
        } else {
            i = str.startsWith("0", i2) ? 8 : 10;
        }
        String strSubstring = str.substring(i2);
        int length = strSubstring.length();
        String str2 = mnwSv.LPFib;
        if (length < 16) {
            long j = Long.parseLong(strSubstring, i);
            if (i3 != 0) {
                j = -j;
            }
            if (z2) {
                return j;
            }
            if (z) {
                if (j > 2147483647L || j < -2147483648L) {
                    throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(str));
                }
                return j;
            }
            if (j >= 4294967296L || j < 0) {
                throw new NumberFormatException(str2.concat(str));
            }
            return j;
        }
        BigInteger bigInteger = new BigInteger(strSubstring, i);
        if (i3 != 0) {
            bigInteger = bigInteger.negate();
        }
        if (z2) {
            if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(str));
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(str));
            }
        } else if (z) {
            if (bigInteger.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(str));
            }
        } else if (bigInteger.bitLength() > 32) {
            throw new NumberFormatException(str2.concat(str));
        }
        return bigInteger.longValue();
    }

    private static void printUnknownFieldValue(int i, Object obj, TextGenerator textGenerator, boolean z) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            textGenerator.print(unsignedToString(((Long) obj).longValue()));
            return;
        }
        if (tagWireType == 1) {
            textGenerator.print(String.format(null, "0x%016x", (Long) obj));
            return;
        }
        if (tagWireType != 2) {
            if (tagWireType == 3) {
                Printer.printUnknownFields((UnknownFieldSet) obj, textGenerator, z);
                return;
            } else {
                if (tagWireType != 5) {
                    throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Bad tag: "));
                }
                textGenerator.print(String.format(null, "0x%08x", (Integer) obj));
                return;
            }
        }
        try {
            UnknownFieldSet from = UnknownFieldSet.parseFrom((ByteString) obj);
            textGenerator.print("{");
            textGenerator.eol();
            textGenerator.indent();
            Printer.printUnknownFields(from, textGenerator, z);
            textGenerator.outdent();
            textGenerator.print("}");
        } catch (InvalidProtocolBufferException unused) {
            textGenerator.print("\"");
            textGenerator.print(escapeBytes((ByteString) obj));
            textGenerator.print("\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TextGenerator setSingleLineOutput(Appendable appendable, boolean z, Printer.FieldReporterLevel fieldReporterLevel) {
        return new TextGenerator(appendable, z, fieldReporterLevel, null);
    }

    public static void merge(Readable readable, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
        PARSER.merge(readable, extensionRegistry, builder);
    }

    public static String unsignedToString(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }

    public static void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
        PARSER.merge(charSequence, extensionRegistry, builder);
    }

    public static <T extends Message> T parse(CharSequence charSequence, ExtensionRegistry extensionRegistry, Class<T> cls) throws ParseException {
        Message.Builder builderNewBuilderForType = ((Message) Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, extensionRegistry, builderNewBuilderForType);
        return (T) builderNewBuilderForType.build();
    }
}
