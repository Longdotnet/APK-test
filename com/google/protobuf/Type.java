package com.google.protobuf;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Type extends GeneratedMessage implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE;
    public static final int EDITION_FIELD_NUMBER = 7;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static final Parser<Type> PARSER;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object edition_;
    private List<Field> fields_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private LazyStringArrayList oneofs_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements TypeOrBuilder {
        private int bitField0_;
        private Object edition_;
        private RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> fieldsBuilder_;
        private List<Field> fields_;
        private Object name_;
        private LazyStringArrayList oneofs_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;

        private void buildPartial0(Type type) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                type.name_ = this.name_;
            }
            if ((i2 & 4) != 0) {
                this.oneofs_.makeImmutable();
                type.oneofs_ = this.oneofs_;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
                type.sourceContext_ = singleFieldBuilder == null ? this.sourceContext_ : (SourceContext) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 32) != 0) {
                type.syntax_ = this.syntax_;
            }
            if ((i2 & 64) != 0) {
                type.edition_ = this.edition_;
            }
            Type.access$1076(type, i);
        }

        private void buildPartialRepeatedFields(Type type) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.fields_ = Collections.unmodifiableList(this.fields_);
                    this.bitField0_ &= -3;
                }
                type.fields_ = this.fields_;
            } else {
                type.fields_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder2 = this.optionsBuilder_;
            if (repeatedFieldBuilder2 != null) {
                type.options_ = repeatedFieldBuilder2.build();
                return;
            }
            if ((this.bitField0_ & 8) != 0) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -9;
            }
            type.options_ = this.options_;
        }

        private void ensureFieldsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.fields_ = new ArrayList(this.fields_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureOneofsIsMutable() {
            if (!this.oneofs_.isModifiable()) {
                this.oneofs_ = new LazyStringArrayList((LazyStringList) this.oneofs_);
            }
            this.bitField0_ |= 4;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 8) == 0) {
                this.options_ = new ArrayList(this.options_);
                this.bitField0_ |= 8;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        private RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> getFieldsFieldBuilder() {
            if (this.fieldsBuilder_ == null) {
                this.fieldsBuilder_ = new RepeatedFieldBuilder<>(this.fields_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.fields_ = null;
            }
            return this.fieldsBuilder_;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ == null) {
                this.optionsBuilder_ = new RepeatedFieldBuilder<>(this.options_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> getSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContextBuilder_ = new SingleFieldBuilder<>(getSourceContext(), getParentForChildren(), isClean());
                this.sourceContext_ = null;
            }
            return this.sourceContextBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getFieldsFieldBuilder();
                getOptionsFieldBuilder();
                getSourceContextFieldBuilder();
            }
        }

        public Builder addAllFields(Iterable<? extends Field> iterable) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFieldsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.fields_);
                onChanged();
            } else {
                repeatedFieldBuilder.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllOneofs(Iterable<String> iterable) {
            ensureOneofsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.oneofs_);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.options_);
                onChanged();
            } else {
                repeatedFieldBuilder.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addFields(Field field) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                field.getClass();
                ensureFieldsIsMutable();
                this.fields_.add(field);
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(field);
            }
            return this;
        }

        public Field.Builder addFieldsBuilder() {
            return (Field.Builder) getFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
        }

        public Builder addOneofs(String str) {
            str.getClass();
            ensureOneofsIsMutable();
            this.oneofs_.add(str);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder addOneofsBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureOneofsIsMutable();
            this.oneofs_.add(byteString);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder addOptions(Option option) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                option.getClass();
                ensureOptionsIsMutable();
                this.options_.add(option);
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(option);
            }
            return this;
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public Builder clearEdition() {
            this.edition_ = Type.getDefaultInstance().getEdition();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder clearFields() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.fields_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilder.clear();
            }
            return this;
        }

        public Builder clearName() {
            this.name_ = Type.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOneofs() {
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
            } else {
                repeatedFieldBuilder.clear();
            }
            return this;
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.sourceContextBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getEdition() {
            Object obj = this.edition_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.edition_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getEditionBytes() {
            Object obj = this.edition_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.edition_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Field getFields(int i) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            return repeatedFieldBuilder == null ? this.fields_.get(i) : (Field) repeatedFieldBuilder.getMessage(i);
        }

        public Field.Builder getFieldsBuilder(int i) {
            return (Field.Builder) getFieldsFieldBuilder().getBuilder(i);
        }

        public List<Field.Builder> getFieldsBuilderList() {
            return getFieldsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            return repeatedFieldBuilder == null ? this.fields_.size() : repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            return repeatedFieldBuilder == null ? Collections.unmodifiableList(this.fields_) : repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public FieldOrBuilder getFieldsOrBuilder(int i) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            return repeatedFieldBuilder == null ? this.fields_.get(i) : (FieldOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            return repeatedFieldBuilder != null ? repeatedFieldBuilder.getMessageOrBuilderList() : Collections.unmodifiableList(this.fields_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getOneofs(int i) {
            return this.oneofs_.get(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int i) {
            return this.oneofs_.getByteString(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return this.oneofs_.size();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Option getOptions(int i) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            return repeatedFieldBuilder == null ? this.options_.get(i) : (Option) repeatedFieldBuilder.getMessage(i);
        }

        public Option.Builder getOptionsBuilder(int i) {
            return (Option.Builder) getOptionsFieldBuilder().getBuilder(i);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            return repeatedFieldBuilder == null ? this.options_.size() : repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            return repeatedFieldBuilder == null ? Collections.unmodifiableList(this.options_) : repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int i) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            return repeatedFieldBuilder == null ? this.options_.get(i) : (OptionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            return repeatedFieldBuilder != null ? repeatedFieldBuilder.getMessageOrBuilderList() : Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                return (SourceContext) singleFieldBuilder.getMessage();
            }
            SourceContext sourceContext = this.sourceContext_;
            return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) getSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                return (SourceContextOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            SourceContext sourceContext = this.sourceContext_;
            return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            Syntax syntaxForNumber = Syntax.forNumber(this.syntax_);
            return syntaxForNumber == null ? Syntax.UNRECOGNIZED : syntaxForNumber;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            SourceContext sourceContext2;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(sourceContext);
            } else if ((this.bitField0_ & 16) == 0 || (sourceContext2 = this.sourceContext_) == null || sourceContext2 == SourceContext.getDefaultInstance()) {
                this.sourceContext_ = sourceContext;
            } else {
                getSourceContextBuilder().mergeFrom(sourceContext);
            }
            if (this.sourceContext_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder removeFields(int i) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFieldsIsMutable();
                this.fields_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilder.remove(i);
            }
            return this;
        }

        public Builder removeOptions(int i) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilder.remove(i);
            }
            return this;
        }

        public Builder setEdition(String str) {
            str.getClass();
            this.edition_ = str;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setEditionBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.edition_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setFields(int i, Field field) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                field.getClass();
                ensureFieldsIsMutable();
                this.fields_.set(i, field);
                onChanged();
            } else {
                repeatedFieldBuilder.setMessage(i, field);
            }
            return this;
        }

        public Builder setName(String str) {
            str.getClass();
            this.name_ = str;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setOneofs(int i, String str) {
            str.getClass();
            ensureOneofsIsMutable();
            this.oneofs_.set(i, str);
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setOptions(int i, Option option) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                option.getClass();
                ensureOptionsIsMutable();
                this.options_.set(i, option);
                onChanged();
            } else {
                repeatedFieldBuilder.setMessage(i, option);
            }
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder == null) {
                sourceContext.getClass();
                this.sourceContext_ = sourceContext;
            } else {
                singleFieldBuilder.setMessage(sourceContext);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            syntax.getClass();
            this.bitField0_ |= 32;
            this.syntax_ = syntax.getNumber();
            onChanged();
            return this;
        }

        public Builder setSyntaxValue(int i) {
            this.syntax_ = i;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ProtocolStringList getOneofsList() {
            this.oneofs_.makeImmutable();
            return this.oneofs_;
        }

        private Builder() {
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type build() {
            Type typeBuildPartial = buildPartial();
            if (typeBuildPartial.isInitialized()) {
                return typeBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) typeBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Type buildPartial() {
            Type type = new Type(this);
            buildPartialRepeatedFields(type);
            if (this.bitField0_ != 0) {
                buildPartial0(type);
            }
            onBuilt();
            return type;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Type getDefaultInstanceForType() {
            return Type.getDefaultInstance();
        }

        public Field.Builder addFieldsBuilder(int i) {
            return (Field.Builder) getFieldsFieldBuilder().addBuilder(i, Field.getDefaultInstance());
        }

        public Option.Builder addOptionsBuilder(int i) {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(i, Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.fields_ = Collections.emptyList();
            } else {
                this.fields_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -3;
            this.oneofs_ = LazyStringArrayList.emptyList();
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder2 = this.optionsBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.options_ = Collections.emptyList();
            } else {
                this.options_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -9;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.sourceContextBuilder_ = null;
            }
            this.syntax_ = 0;
            this.edition_ = "";
            return this;
        }

        public Builder addFields(int i, Field field) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                field.getClass();
                ensureFieldsIsMutable();
                this.fields_.add(i, field);
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(i, field);
            }
            return this;
        }

        public Builder addOptions(int i, Option option) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                option.getClass();
                ensureOptionsIsMutable();
                this.options_.add(i, option);
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(i, option);
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Type) {
                return mergeFrom((Type) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setFields(int i, Field.Builder builder) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFieldsIsMutable();
                this.fields_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.setMessage(i, builder.build());
            }
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.setMessage(i, builder.build());
            }
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> singleFieldBuilder = this.sourceContextBuilder_;
            if (singleFieldBuilder == null) {
                this.sourceContext_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeFrom(Type type) {
            if (type == Type.getDefaultInstance()) {
                return this;
            }
            if (!type.getName().isEmpty()) {
                this.name_ = type.name_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (this.fieldsBuilder_ == null) {
                if (!type.fields_.isEmpty()) {
                    if (this.fields_.isEmpty()) {
                        this.fields_ = type.fields_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureFieldsIsMutable();
                        this.fields_.addAll(type.fields_);
                    }
                    onChanged();
                }
            } else if (!type.fields_.isEmpty()) {
                if (!this.fieldsBuilder_.isEmpty()) {
                    this.fieldsBuilder_.addAllMessages(type.fields_);
                } else {
                    this.fieldsBuilder_.dispose();
                    this.fieldsBuilder_ = null;
                    this.fields_ = type.fields_;
                    this.bitField0_ &= -3;
                    this.fieldsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getFieldsFieldBuilder() : null;
                }
            }
            if (!type.oneofs_.isEmpty()) {
                if (this.oneofs_.isEmpty()) {
                    this.oneofs_ = type.oneofs_;
                    this.bitField0_ |= 4;
                } else {
                    ensureOneofsIsMutable();
                    this.oneofs_.addAll(type.oneofs_);
                }
                onChanged();
            }
            if (this.optionsBuilder_ == null) {
                if (!type.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = type.options_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(type.options_);
                    }
                    onChanged();
                }
            } else if (!type.options_.isEmpty()) {
                if (!this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.addAllMessages(type.options_);
                } else {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = type.options_;
                    this.bitField0_ &= -9;
                    this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                }
            }
            if (type.hasSourceContext()) {
                mergeSourceContext(type.getSourceContext());
            }
            if (type.syntax_ != 0) {
                setSyntaxValue(type.getSyntaxValue());
            }
            if (!type.getEdition().isEmpty()) {
                this.edition_ = type.edition_;
                this.bitField0_ |= 64;
                onChanged();
            }
            mergeUnknownFields(type.getUnknownFields());
            onChanged();
            return this;
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.fields_ = Collections.emptyList();
            this.oneofs_ = LazyStringArrayList.emptyList();
            this.options_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder addFields(Field.Builder builder) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFieldsIsMutable();
                this.fields_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(builder.build());
            }
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(builder.build());
            }
            return this;
        }

        public Builder addFields(int i, Field.Builder builder) {
            RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFieldsIsMutable();
                this.fields_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(i, builder.build());
            }
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder = this.optionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureOptionsIsMutable();
                this.options_.add(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(i, builder.build());
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                Field field = (Field) codedInputStream.readMessage(Field.parser(), extensionRegistryLite);
                                RepeatedFieldBuilder<Field, Field.Builder, FieldOrBuilder> repeatedFieldBuilder = this.fieldsBuilder_;
                                if (repeatedFieldBuilder == null) {
                                    ensureFieldsIsMutable();
                                    this.fields_.add(field);
                                } else {
                                    repeatedFieldBuilder.addMessage(field);
                                }
                            } else if (tag == 26) {
                                String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                ensureOneofsIsMutable();
                                this.oneofs_.add(stringRequireUtf8);
                            } else if (tag == 34) {
                                Option option = (Option) codedInputStream.readMessage(Option.parser(), extensionRegistryLite);
                                RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> repeatedFieldBuilder2 = this.optionsBuilder_;
                                if (repeatedFieldBuilder2 == null) {
                                    ensureOptionsIsMutable();
                                    this.options_.add(option);
                                } else {
                                    repeatedFieldBuilder2.addMessage(option);
                                }
                            } else if (tag == 42) {
                                codedInputStream.readMessage(getSourceContextFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 16;
                            } else if (tag == 48) {
                                this.syntax_ = codedInputStream.readEnum();
                                this.bitField0_ |= 32;
                            } else if (tag != 58) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.edition_ = codedInputStream.readStringRequireUtf8();
                                this.bitField0_ |= 64;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    onChanged();
                    throw th;
                }
            }
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", Type.class.getName());
        DEFAULT_INSTANCE = new Type();
        PARSER = new AbstractParser<Type>() { // from class: com.google.protobuf.Type.1
            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream inputStream) {
                return super.parseDelimitedFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString byteString) {
                return super.parseFrom(byteString);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream inputStream) {
                return super.parsePartialDelimitedFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString byteString) {
                return super.parsePartialFrom(byteString);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialDelimitedFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream codedInputStream) {
                return super.parseFrom(codedInputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream) {
                return super.parsePartialFrom(codedInputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream inputStream) {
                return super.parseFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream inputStream) {
                return super.parsePartialFrom(inputStream);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer byteBuffer) {
                return super.parseFrom(byteBuffer);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr) {
                return super.parsePartialFrom(bArr);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(byteBuffer, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, int i, int i2) {
                return super.parsePartialFrom(bArr, i, i2);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr) {
                return super.parseFrom(bArr);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(bArr, i, i2, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, int i, int i2) {
                return super.parseFrom(bArr, i, i2);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return super.parsePartialFrom(bArr, extensionRegistryLite);
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(bArr, i, i2, extensionRegistryLite);
            }

            @Override // com.google.protobuf.Parser
            public Type parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Type.newBuilder();
                try {
                    builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return builderNewBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (UninitializedMessageException e2) {
                    throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(builderNewBuilder.buildPartial());
                }
            }

            @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
            public /* bridge */ /* synthetic */ Object parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return super.parseFrom(bArr, extensionRegistryLite);
            }
        };
    }

    public static /* synthetic */ int access$1076(Type type, int i) {
        int i2 = i | type.bitField0_;
        type.bitField0_ = i2;
        return i2;
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Type parseDelimitedFrom(InputStream inputStream) {
        return (Type) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Type parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Type> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return super.equals(obj);
        }
        Type type = (Type) obj;
        if (getName().equals(type.getName()) && getFieldsList().equals(type.getFieldsList()) && getOneofsList().equals(type.getOneofsList()) && getOptionsList().equals(type.getOptionsList()) && hasSourceContext() == type.hasSourceContext()) {
            return (!hasSourceContext() || getSourceContext().equals(type.getSourceContext())) && this.syntax_ == type.syntax_ && getEdition().equals(type.getEdition()) && getUnknownFields().equals(type.getUnknownFields());
        }
        return false;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getEdition() {
        Object obj = this.edition_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.edition_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getEditionBytes() {
        Object obj = this.edition_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.edition_ = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Field getFields(int i) {
        return this.fields_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Field> getFieldsList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public FieldOrBuilder getFieldsOrBuilder(int i) {
        return this.fields_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.name_ = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getOneofs(int i) {
        return this.oneofs_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int i) {
        return this.oneofs_.getByteString(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Type> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !GeneratedMessage.isStringEmpty(this.name_) ? GeneratedMessage.computeStringSize(1, this.name_) : 0;
        for (int i2 = 0; i2 < this.fields_.size(); i2++) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(2, this.fields_.get(i2));
        }
        int iComputeStringSizeNoTag = 0;
        for (int i3 = 0; i3 < this.oneofs_.size(); i3++) {
            iComputeStringSizeNoTag += GeneratedMessage.computeStringSizeNoTag(this.oneofs_.getRaw(i3));
        }
        int size = getOneofsList().size() + iComputeStringSize + iComputeStringSizeNoTag;
        for (int i4 = 0; i4 < this.options_.size(); i4++) {
            size += CodedOutputStream.computeMessageSize(4, this.options_.get(i4));
        }
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size += CodedOutputStream.computeEnumSize(6, this.syntax_);
        }
        if (!GeneratedMessage.isStringEmpty(this.edition_)) {
            size += GeneratedMessage.computeStringSize(7, this.edition_);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + size;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Syntax getSyntax() {
        Syntax syntaxForNumber = Syntax.forNumber(this.syntax_);
        return syntaxForNumber == null ? Syntax.UNRECOGNIZED : syntaxForNumber;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public boolean hasSourceContext() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getName().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53);
        if (getFieldsCount() > 0) {
            iHashCode = getFieldsList().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 2, 53);
        }
        if (getOneofsCount() > 0) {
            iHashCode = getOneofsList().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 3, 53);
        }
        if (getOptionsCount() > 0) {
            iHashCode = getOptionsList().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 4, 53);
        }
        if (hasSourceContext()) {
            iHashCode = getSourceContext().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 5, 53);
        }
        int iHashCode2 = getUnknownFields().hashCode() + ((getEdition().hashCode() + ((((CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 6, 53) + this.syntax_) * 37) + 7) * 53)) * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!GeneratedMessage.isStringEmpty(this.name_)) {
            GeneratedMessage.writeString(codedOutputStream, 1, this.name_);
        }
        for (int i = 0; i < this.fields_.size(); i++) {
            codedOutputStream.writeMessage(2, this.fields_.get(i));
        }
        for (int i2 = 0; i2 < this.oneofs_.size(); i2++) {
            GeneratedMessage.writeString(codedOutputStream, 3, this.oneofs_.getRaw(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            codedOutputStream.writeMessage(4, this.options_.get(i3));
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(6, this.syntax_);
        }
        if (!GeneratedMessage.isStringEmpty(this.edition_)) {
            GeneratedMessage.writeString(codedOutputStream, 7, this.edition_);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    private Type(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.name_ = "";
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(Type type) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(type);
    }

    public static Type parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }

    public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Type parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static Type parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Type parseFrom(InputStream inputStream) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    private Type() {
        String str = GsPcpBmONXh.VNQTDgEJgPqh;
        this.name_ = str;
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.syntax_ = 0;
        this.edition_ = str;
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = str;
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = str;
    }

    public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(CodedInputStream codedInputStream) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
