package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class GameLog extends GeneratedMessage implements GameLogOrBuilder {
    public static final int ACTION_LOG_FIELD_NUMBER = 2;
    public static final int CATEGORY_FIELD_NUMBER = 1;
    private static final GameLog DEFAULT_INSTANCE;
    public static final int ELAPSED_TIME_FIELD_NUMBER = 5;
    public static final int FRAME_FIELD_NUMBER = 4;
    private static final Parser<GameLog> PARSER;
    public static final int POINT_LOG_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private volatile Object category_;
    private int dataCase_;
    private Object data_;
    private int elapsedTime_;
    private int frame_;
    private byte memoizedIsInitialized;

    public enum DataCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        ACTION_LOG(2),
        POINT_LOG(3),
        DATA_NOT_SET(0);

        private final int value;

        DataCase(int i) {
            this.value = i;
        }

        public static DataCase forNumber(int i) {
            if (i == 0) {
                return DATA_NOT_SET;
            }
            if (i == 2) {
                return ACTION_LOG;
            }
            if (i != 3) {
                return null;
            }
            return POINT_LOG;
        }

        @Override // com.google.protobuf.Internal.EnumLite, com.google.protobuf.AbstractMessageLite.InternalOneOfEnum
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DataCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", GameLog.class.getName());
        DEFAULT_INSTANCE = new GameLog();
        PARSER = new AbstractParser<GameLog>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLog.1
            @Override // com.google.protobuf.Parser
            public GameLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = GameLog.newBuilder();
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
        };
    }

    public static GameLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLog_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static GameLog parseDelimitedFrom(InputStream inputStream) {
        return (GameLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameLog parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<GameLog> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GameLog)) {
            return super.equals(obj);
        }
        GameLog gameLog = (GameLog) obj;
        if (!getCategory().equals(gameLog.getCategory()) || getFrame() != gameLog.getFrame() || getElapsedTime() != gameLog.getElapsedTime() || !getDataCase().equals(gameLog.getDataCase())) {
            return false;
        }
        int i = this.dataCase_;
        if (i != 2) {
            if (i == 3 && !getPointLog().equals(gameLog.getPointLog())) {
                return false;
            }
        } else if (!getActionLog().equals(gameLog.getActionLog())) {
            return false;
        }
        return getUnknownFields().equals(gameLog.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public ActionLog getActionLog() {
        return this.dataCase_ == 2 ? (ActionLog) this.data_ : ActionLog.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public ActionLogOrBuilder getActionLogOrBuilder() {
        return this.dataCase_ == 2 ? (ActionLog) this.data_ : ActionLog.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public String getCategory() {
        Object obj = this.category_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.category_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public ByteString getCategoryBytes() {
        Object obj = this.category_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.category_ = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public DataCase getDataCase() {
        return DataCase.forNumber(this.dataCase_);
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public int getElapsedTime() {
        return this.elapsedTime_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public int getFrame() {
        return this.frame_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameLog> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public PointLog getPointLog() {
        return this.dataCase_ == 3 ? (PointLog) this.data_ : PointLog.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public PointLogOrBuilder getPointLogOrBuilder() {
        return this.dataCase_ == 3 ? (PointLog) this.data_ : PointLog.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !GeneratedMessage.isStringEmpty(this.category_) ? GeneratedMessage.computeStringSize(1, this.category_) : 0;
        if (this.dataCase_ == 2) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(2, (ActionLog) this.data_);
        }
        if (this.dataCase_ == 3) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(3, (PointLog) this.data_);
        }
        int i2 = this.frame_;
        if (i2 != 0) {
            iComputeStringSize += CodedOutputStream.computeInt32Size(4, i2);
        }
        int i3 = this.elapsedTime_;
        if (i3 != 0) {
            iComputeStringSize += CodedOutputStream.computeInt32Size(5, i3);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeStringSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public boolean hasActionLog() {
        return this.dataCase_ == 2;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
    public boolean hasPointLog() {
        return this.dataCase_ == 3;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int iM;
        int iHashCode;
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int elapsedTime = getElapsedTime() + ((((getFrame() + ((((getCategory().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53);
        int i2 = this.dataCase_;
        if (i2 != 2) {
            if (i2 == 3) {
                iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(elapsedTime, 37, 3, 53);
                iHashCode = getPointLog().hashCode();
            }
            int iHashCode2 = getUnknownFields().hashCode() + (elapsedTime * 29);
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }
        iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(elapsedTime, 37, 2, 53);
        iHashCode = getActionLog().hashCode();
        elapsedTime = iHashCode + iM;
        int iHashCode3 = getUnknownFields().hashCode() + (elapsedTime * 29);
        this.memoizedHashCode = iHashCode3;
        return iHashCode3;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLog_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLog.class, Builder.class);
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
        if (!GeneratedMessage.isStringEmpty(this.category_)) {
            GeneratedMessage.writeString(codedOutputStream, 1, this.category_);
        }
        if (this.dataCase_ == 2) {
            codedOutputStream.writeMessage(2, (ActionLog) this.data_);
        }
        if (this.dataCase_ == 3) {
            codedOutputStream.writeMessage(3, (PointLog) this.data_);
        }
        int i = this.frame_;
        if (i != 0) {
            codedOutputStream.writeInt32(4, i);
        }
        int i2 = this.elapsedTime_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(5, i2);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameLogOrBuilder {
        private SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> actionLogBuilder_;
        private int bitField0_;
        private Object category_;
        private int dataCase_;
        private Object data_;
        private int elapsedTime_;
        private int frame_;
        private SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> pointLogBuilder_;

        private void buildPartial0(GameLog gameLog) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                gameLog.category_ = this.category_;
            }
            if ((i & 8) != 0) {
                gameLog.frame_ = this.frame_;
            }
            if ((i & 16) != 0) {
                gameLog.elapsedTime_ = this.elapsedTime_;
            }
        }

        private void buildPartialOneofs(GameLog gameLog) {
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder;
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder2;
            gameLog.dataCase_ = this.dataCase_;
            gameLog.data_ = this.data_;
            if (this.dataCase_ == 2 && (singleFieldBuilder2 = this.actionLogBuilder_) != null) {
                gameLog.data_ = singleFieldBuilder2.build();
            }
            if (this.dataCase_ != 3 || (singleFieldBuilder = this.pointLogBuilder_) == null) {
                return;
            }
            gameLog.data_ = singleFieldBuilder.build();
        }

        private SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> getActionLogFieldBuilder() {
            if (this.actionLogBuilder_ == null) {
                if (this.dataCase_ != 2) {
                    this.data_ = ActionLog.getDefaultInstance();
                }
                this.actionLogBuilder_ = new SingleFieldBuilder<>((ActionLog) this.data_, getParentForChildren(), isClean());
                this.data_ = null;
            }
            this.dataCase_ = 2;
            onChanged();
            return this.actionLogBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLog_descriptor;
        }

        private SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> getPointLogFieldBuilder() {
            if (this.pointLogBuilder_ == null) {
                if (this.dataCase_ != 3) {
                    this.data_ = PointLog.getDefaultInstance();
                }
                this.pointLogBuilder_ = new SingleFieldBuilder<>((PointLog) this.data_, getParentForChildren(), isClean());
                this.data_ = null;
            }
            this.dataCase_ = 3;
            onChanged();
            return this.pointLogBuilder_;
        }

        public Builder clearActionLog() {
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder = this.actionLogBuilder_;
            if (singleFieldBuilder != null) {
                if (this.dataCase_ == 2) {
                    this.dataCase_ = 0;
                    this.data_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.dataCase_ == 2) {
                this.dataCase_ = 0;
                this.data_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearCategory() {
            this.category_ = GameLog.getDefaultInstance().getCategory();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearData() {
            this.dataCase_ = 0;
            this.data_ = null;
            onChanged();
            return this;
        }

        public Builder clearElapsedTime() {
            this.bitField0_ &= -17;
            this.elapsedTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFrame() {
            this.bitField0_ &= -9;
            this.frame_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPointLog() {
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder = this.pointLogBuilder_;
            if (singleFieldBuilder != null) {
                if (this.dataCase_ == 3) {
                    this.dataCase_ = 0;
                    this.data_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.dataCase_ == 3) {
                this.dataCase_ = 0;
                this.data_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public ActionLog getActionLog() {
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder = this.actionLogBuilder_;
            if (singleFieldBuilder == null) {
                return this.dataCase_ == 2 ? (ActionLog) this.data_ : ActionLog.getDefaultInstance();
            }
            return this.dataCase_ == 2 ? (ActionLog) singleFieldBuilder.getMessage() : ActionLog.getDefaultInstance();
        }

        public ActionLog.Builder getActionLogBuilder() {
            return (ActionLog.Builder) getActionLogFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public ActionLogOrBuilder getActionLogOrBuilder() {
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder;
            int i = this.dataCase_;
            if (i != 2 || (singleFieldBuilder = this.actionLogBuilder_) == null) {
                return i == 2 ? (ActionLog) this.data_ : ActionLog.getDefaultInstance();
            }
            return (ActionLogOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public String getCategory() {
            Object obj = this.category_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.category_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public ByteString getCategoryBytes() {
            Object obj = this.category_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.category_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public DataCase getDataCase() {
            return DataCase.forNumber(this.dataCase_);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLog_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public int getElapsedTime() {
            return this.elapsedTime_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public int getFrame() {
            return this.frame_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public PointLog getPointLog() {
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder = this.pointLogBuilder_;
            if (singleFieldBuilder == null) {
                return this.dataCase_ == 3 ? (PointLog) this.data_ : PointLog.getDefaultInstance();
            }
            return this.dataCase_ == 3 ? (PointLog) singleFieldBuilder.getMessage() : PointLog.getDefaultInstance();
        }

        public PointLog.Builder getPointLogBuilder() {
            return (PointLog.Builder) getPointLogFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public PointLogOrBuilder getPointLogOrBuilder() {
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder;
            int i = this.dataCase_;
            if (i != 3 || (singleFieldBuilder = this.pointLogBuilder_) == null) {
                return i == 3 ? (PointLog) this.data_ : PointLog.getDefaultInstance();
            }
            return (PointLogOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public boolean hasActionLog() {
            return this.dataCase_ == 2;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogOrBuilder
        public boolean hasPointLog() {
            return this.dataCase_ == 3;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLog_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLog.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeActionLog(ActionLog actionLog) {
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder = this.actionLogBuilder_;
            if (singleFieldBuilder == null) {
                if (this.dataCase_ != 2 || this.data_ == ActionLog.getDefaultInstance()) {
                    this.data_ = actionLog;
                } else {
                    this.data_ = ActionLog.newBuilder((ActionLog) this.data_).mergeFrom(actionLog).buildPartial();
                }
                onChanged();
            } else if (this.dataCase_ == 2) {
                singleFieldBuilder.mergeFrom(actionLog);
            } else {
                singleFieldBuilder.setMessage(actionLog);
            }
            this.dataCase_ = 2;
            return this;
        }

        public Builder mergePointLog(PointLog pointLog) {
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder = this.pointLogBuilder_;
            if (singleFieldBuilder == null) {
                if (this.dataCase_ != 3 || this.data_ == PointLog.getDefaultInstance()) {
                    this.data_ = pointLog;
                } else {
                    this.data_ = PointLog.newBuilder((PointLog) this.data_).mergeFrom(pointLog).buildPartial();
                }
                onChanged();
            } else if (this.dataCase_ == 3) {
                singleFieldBuilder.mergeFrom(pointLog);
            } else {
                singleFieldBuilder.setMessage(pointLog);
            }
            this.dataCase_ = 3;
            return this;
        }

        public Builder setActionLog(ActionLog actionLog) {
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder = this.actionLogBuilder_;
            if (singleFieldBuilder == null) {
                actionLog.getClass();
                this.data_ = actionLog;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(actionLog);
            }
            this.dataCase_ = 2;
            return this;
        }

        public Builder setCategory(String str) {
            str.getClass();
            this.category_ = str;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setCategoryBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.category_ = byteString;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setElapsedTime(int i) {
            this.elapsedTime_ = i;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setFrame(int i) {
            this.frame_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setPointLog(PointLog pointLog) {
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder = this.pointLogBuilder_;
            if (singleFieldBuilder == null) {
                pointLog.getClass();
                this.data_ = pointLog;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(pointLog);
            }
            this.dataCase_ = 3;
            return this;
        }

        private Builder() {
            this.dataCase_ = 0;
            this.category_ = "";
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLog build() {
            GameLog gameLogBuildPartial = buildPartial();
            if (gameLogBuildPartial.isInitialized()) {
                return gameLogBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) gameLogBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLog buildPartial() {
            GameLog gameLog = new GameLog(this);
            if (this.bitField0_ != 0) {
                buildPartial0(gameLog);
            }
            buildPartialOneofs(gameLog);
            onBuilt();
            return gameLog;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameLog getDefaultInstanceForType() {
            return GameLog.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.category_ = "";
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder = this.actionLogBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.clear();
            }
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder2 = this.pointLogBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.clear();
            }
            this.frame_ = 0;
            this.elapsedTime_ = 0;
            this.dataCase_ = 0;
            this.data_ = null;
            return this;
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.dataCase_ = 0;
            this.category_ = "";
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof GameLog) {
                return mergeFrom((GameLog) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setActionLog(ActionLog.Builder builder) {
            SingleFieldBuilder<ActionLog, ActionLog.Builder, ActionLogOrBuilder> singleFieldBuilder = this.actionLogBuilder_;
            if (singleFieldBuilder == null) {
                this.data_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.dataCase_ = 2;
            return this;
        }

        public Builder setPointLog(PointLog.Builder builder) {
            SingleFieldBuilder<PointLog, PointLog.Builder, PointLogOrBuilder> singleFieldBuilder = this.pointLogBuilder_;
            if (singleFieldBuilder == null) {
                this.data_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.dataCase_ = 3;
            return this;
        }

        public Builder mergeFrom(GameLog gameLog) {
            if (gameLog == GameLog.getDefaultInstance()) {
                return this;
            }
            if (!gameLog.getCategory().isEmpty()) {
                this.category_ = gameLog.category_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (gameLog.getFrame() != 0) {
                setFrame(gameLog.getFrame());
            }
            if (gameLog.getElapsedTime() != 0) {
                setElapsedTime(gameLog.getElapsedTime());
            }
            int iOrdinal = gameLog.getDataCase().ordinal();
            if (iOrdinal == 0) {
                mergeActionLog(gameLog.getActionLog());
            } else if (iOrdinal == 1) {
                mergePointLog(gameLog.getPointLog());
            }
            mergeUnknownFields(gameLog.getUnknownFields());
            onChanged();
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
                                this.category_ = codedInputStream.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                codedInputStream.readMessage(getActionLogFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.dataCase_ = 2;
                            } else if (tag == 26) {
                                codedInputStream.readMessage(getPointLogFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.dataCase_ = 3;
                            } else if (tag == 32) {
                                this.frame_ = codedInputStream.readInt32();
                                this.bitField0_ |= 8;
                            } else if (tag != 40) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.elapsedTime_ = codedInputStream.readInt32();
                                this.bitField0_ |= 16;
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

    private GameLog(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.dataCase_ = 0;
        this.category_ = "";
        this.frame_ = 0;
        this.elapsedTime_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(GameLog gameLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(gameLog);
    }

    public static GameLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GameLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameLog parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameLog getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static GameLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static GameLog parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static GameLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameLog parseFrom(InputStream inputStream) {
        return (GameLog) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    private GameLog() {
        this.dataCase_ = 0;
        this.category_ = "";
        this.frame_ = 0;
        this.elapsedTime_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.category_ = "";
    }

    public static GameLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GameLog) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameLog parseFrom(CodedInputStream codedInputStream) {
        return (GameLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GameLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
