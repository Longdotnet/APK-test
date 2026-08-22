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
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GameLogDataset extends GeneratedMessage implements GameLogDatasetOrBuilder {
    public static final int CLIENT_VERSION_FIELD_NUMBER = 2;
    private static final GameLogDataset DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 6;
    public static final int LENGTH_FIELD_NUMBER = 4;
    public static final int LOGS_FIELD_NUMBER = 7;
    public static final int META_FIELD_NUMBER = 8;
    private static final Parser<GameLogDataset> PARSER;
    public static final int STAGE_ID_FIELD_NUMBER = 3;
    public static final int START_AT_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object clientVersion_;
    private long endAt_;
    private int length_;
    private List<GameLog> logs_;
    private byte memoizedIsInitialized;
    private Struct meta_;
    private int stageId_;
    private long startAt_;
    private volatile Object version_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", GameLogDataset.class.getName());
        DEFAULT_INSTANCE = new GameLogDataset();
        PARSER = new AbstractParser<GameLogDataset>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDataset.1
            @Override // com.google.protobuf.Parser
            public GameLogDataset parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = GameLogDataset.newBuilder();
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

    public static /* synthetic */ int access$1276(GameLogDataset gameLogDataset, int i) {
        int i2 = i | gameLogDataset.bitField0_;
        gameLogDataset.bitField0_ = i2;
        return i2;
    }

    public static GameLogDataset getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLogDataset_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static GameLogDataset parseDelimitedFrom(InputStream inputStream) {
        return (GameLogDataset) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameLogDataset parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<GameLogDataset> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GameLogDataset)) {
            return super.equals(obj);
        }
        GameLogDataset gameLogDataset = (GameLogDataset) obj;
        if (getVersion().equals(gameLogDataset.getVersion()) && getClientVersion().equals(gameLogDataset.getClientVersion()) && getStageId() == gameLogDataset.getStageId() && getLength() == gameLogDataset.getLength() && getStartAt() == gameLogDataset.getStartAt() && getEndAt() == gameLogDataset.getEndAt() && getLogsList().equals(gameLogDataset.getLogsList()) && hasMeta() == gameLogDataset.hasMeta()) {
            return (!hasMeta() || getMeta().equals(gameLogDataset.getMeta())) && getUnknownFields().equals(gameLogDataset.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public String getClientVersion() {
        Object obj = this.clientVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.clientVersion_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public ByteString getClientVersionBytes() {
        Object obj = this.clientVersion_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.clientVersion_ = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public long getEndAt() {
        return this.endAt_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public int getLength() {
        return this.length_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public GameLog getLogs(int i) {
        return this.logs_.get(i);
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public int getLogsCount() {
        return this.logs_.size();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public List<GameLog> getLogsList() {
        return this.logs_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public GameLogOrBuilder getLogsOrBuilder(int i) {
        return this.logs_.get(i);
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public List<? extends GameLogOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public Struct getMeta() {
        Struct struct = this.meta_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public StructOrBuilder getMetaOrBuilder() {
        Struct struct = this.meta_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameLogDataset> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !GeneratedMessage.isStringEmpty(this.version_) ? GeneratedMessage.computeStringSize(1, this.version_) : 0;
        if (!GeneratedMessage.isStringEmpty(this.clientVersion_)) {
            iComputeStringSize += GeneratedMessage.computeStringSize(2, this.clientVersion_);
        }
        int i2 = this.stageId_;
        if (i2 != 0) {
            iComputeStringSize += CodedOutputStream.computeInt32Size(3, i2);
        }
        int i3 = this.length_;
        if (i3 != 0) {
            iComputeStringSize += CodedOutputStream.computeInt32Size(4, i3);
        }
        long j = this.startAt_;
        if (j != 0) {
            iComputeStringSize += CodedOutputStream.computeInt64Size(5, j);
        }
        long j2 = this.endAt_;
        if (j2 != 0) {
            iComputeStringSize += CodedOutputStream.computeInt64Size(6, j2);
        }
        for (int i4 = 0; i4 < this.logs_.size(); i4++) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(7, this.logs_.get(i4));
        }
        if ((this.bitField0_ & 1) != 0) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(8, getMeta());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeStringSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public int getStageId() {
        return this.stageId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public long getStartAt() {
        return this.startAt_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public String getVersion() {
        Object obj = this.version_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.version_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public ByteString getVersionBytes() {
        Object obj = this.version_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.version_ = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
    public boolean hasMeta() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashLong = Internal.hashLong(getEndAt()) + ((((Internal.hashLong(getStartAt()) + ((((getLength() + ((((getStageId() + ((((getClientVersion().hashCode() + ((((getVersion().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53);
        if (getLogsCount() > 0) {
            iHashLong = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashLong, 37, 7, 53) + getLogsList().hashCode();
        }
        if (hasMeta()) {
            iHashLong = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashLong, 37, 8, 53) + getMeta().hashCode();
        }
        int iHashCode = getUnknownFields().hashCode() + (iHashLong * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLogDataset_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLogDataset.class, Builder.class);
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
        if (!GeneratedMessage.isStringEmpty(this.version_)) {
            GeneratedMessage.writeString(codedOutputStream, 1, this.version_);
        }
        if (!GeneratedMessage.isStringEmpty(this.clientVersion_)) {
            GeneratedMessage.writeString(codedOutputStream, 2, this.clientVersion_);
        }
        int i = this.stageId_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        int i2 = this.length_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(4, i2);
        }
        long j = this.startAt_;
        if (j != 0) {
            codedOutputStream.writeInt64(5, j);
        }
        long j2 = this.endAt_;
        if (j2 != 0) {
            codedOutputStream.writeInt64(6, j2);
        }
        for (int i3 = 0; i3 < this.logs_.size(); i3++) {
            codedOutputStream.writeMessage(7, this.logs_.get(i3));
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(8, getMeta());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameLogDatasetOrBuilder {
        private int bitField0_;
        private Object clientVersion_;
        private long endAt_;
        private int length_;
        private RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> logsBuilder_;
        private List<GameLog> logs_;
        private SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> metaBuilder_;
        private Struct meta_;
        private int stageId_;
        private long startAt_;
        private Object version_;

        private void buildPartial0(GameLogDataset gameLogDataset) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                gameLogDataset.version_ = this.version_;
            }
            if ((i2 & 2) != 0) {
                gameLogDataset.clientVersion_ = this.clientVersion_;
            }
            if ((i2 & 4) != 0) {
                gameLogDataset.stageId_ = this.stageId_;
            }
            if ((i2 & 8) != 0) {
                gameLogDataset.length_ = this.length_;
            }
            if ((i2 & 16) != 0) {
                gameLogDataset.startAt_ = this.startAt_;
            }
            if ((i2 & 32) != 0) {
                gameLogDataset.endAt_ = this.endAt_;
            }
            if ((i2 & 128) != 0) {
                SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
                gameLogDataset.meta_ = singleFieldBuilder == null ? this.meta_ : (Struct) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            GameLogDataset.access$1276(gameLogDataset, i);
        }

        private void buildPartialRepeatedFields(GameLogDataset gameLogDataset) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder != null) {
                gameLogDataset.logs_ = repeatedFieldBuilder.build();
                return;
            }
            if ((this.bitField0_ & 64) != 0) {
                this.logs_ = Collections.unmodifiableList(this.logs_);
                this.bitField0_ &= -65;
            }
            gameLogDataset.logs_ = this.logs_;
        }

        private void ensureLogsIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.logs_ = new ArrayList(this.logs_);
                this.bitField0_ |= 64;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLogDataset_descriptor;
        }

        private RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> getLogsFieldBuilder() {
            if (this.logsBuilder_ == null) {
                this.logsBuilder_ = new RepeatedFieldBuilder<>(this.logs_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.logs_ = null;
            }
            return this.logsBuilder_;
        }

        private SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> getMetaFieldBuilder() {
            if (this.metaBuilder_ == null) {
                this.metaBuilder_ = new SingleFieldBuilder<>(getMeta(), getParentForChildren(), isClean());
                this.meta_ = null;
            }
            return this.metaBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getLogsFieldBuilder();
                getMetaFieldBuilder();
            }
        }

        public Builder addAllLogs(Iterable<? extends GameLog> iterable) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLogsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.logs_);
                onChanged();
            } else {
                repeatedFieldBuilder.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addLogs(GameLog gameLog) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLog.getClass();
                ensureLogsIsMutable();
                this.logs_.add(gameLog);
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(gameLog);
            }
            return this;
        }

        public GameLog.Builder addLogsBuilder() {
            return (GameLog.Builder) getLogsFieldBuilder().addBuilder(GameLog.getDefaultInstance());
        }

        public Builder clearClientVersion() {
            this.clientVersion_ = GameLogDataset.getDefaultInstance().getClientVersion();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearEndAt() {
            this.bitField0_ &= -33;
            this.endAt_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearLength() {
            this.bitField0_ &= -9;
            this.length_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLogs() {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.logs_ = Collections.emptyList();
                this.bitField0_ &= -65;
                onChanged();
            } else {
                repeatedFieldBuilder.clear();
            }
            return this;
        }

        public Builder clearMeta() {
            this.bitField0_ &= -129;
            this.meta_ = null;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.metaBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearStageId() {
            this.bitField0_ &= -5;
            this.stageId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStartAt() {
            this.bitField0_ &= -17;
            this.startAt_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.version_ = GameLogDataset.getDefaultInstance().getVersion();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public String getClientVersion() {
            Object obj = this.clientVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.clientVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public ByteString getClientVersionBytes() {
            Object obj = this.clientVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.clientVersion_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLogDataset_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public long getEndAt() {
            return this.endAt_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public int getLength() {
            return this.length_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public GameLog getLogs(int i) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            return repeatedFieldBuilder == null ? this.logs_.get(i) : (GameLog) repeatedFieldBuilder.getMessage(i);
        }

        public GameLog.Builder getLogsBuilder(int i) {
            return (GameLog.Builder) getLogsFieldBuilder().getBuilder(i);
        }

        public List<GameLog.Builder> getLogsBuilderList() {
            return getLogsFieldBuilder().getBuilderList();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public int getLogsCount() {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            return repeatedFieldBuilder == null ? this.logs_.size() : repeatedFieldBuilder.getCount();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public List<GameLog> getLogsList() {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            return repeatedFieldBuilder == null ? Collections.unmodifiableList(this.logs_) : repeatedFieldBuilder.getMessageList();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public GameLogOrBuilder getLogsOrBuilder(int i) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            return repeatedFieldBuilder == null ? this.logs_.get(i) : (GameLogOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public List<? extends GameLogOrBuilder> getLogsOrBuilderList() {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            return repeatedFieldBuilder != null ? repeatedFieldBuilder.getMessageOrBuilderList() : Collections.unmodifiableList(this.logs_);
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public Struct getMeta() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
            if (singleFieldBuilder != null) {
                return (Struct) singleFieldBuilder.getMessage();
            }
            Struct struct = this.meta_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        public Struct.Builder getMetaBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (Struct.Builder) getMetaFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public StructOrBuilder getMetaOrBuilder() {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
            if (singleFieldBuilder != null) {
                return (StructOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Struct struct = this.meta_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public long getStartAt() {
            return this.startAt_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.version_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public ByteString getVersionBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.version_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.GameLogDatasetOrBuilder
        public boolean hasMeta() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_GameLogDataset_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLogDataset.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeMeta(Struct struct) {
            Struct struct2;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(struct);
            } else if ((this.bitField0_ & 128) == 0 || (struct2 = this.meta_) == null || struct2 == Struct.getDefaultInstance()) {
                this.meta_ = struct;
            } else {
                getMetaBuilder().mergeFrom(struct);
            }
            if (this.meta_ != null) {
                this.bitField0_ |= 128;
                onChanged();
            }
            return this;
        }

        public Builder removeLogs(int i) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLogsIsMutable();
                this.logs_.remove(i);
                onChanged();
            } else {
                repeatedFieldBuilder.remove(i);
            }
            return this;
        }

        public Builder setClientVersion(String str) {
            str.getClass();
            this.clientVersion_ = str;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setClientVersionBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.clientVersion_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setEndAt(long j) {
            this.endAt_ = j;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setLength(int i) {
            this.length_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setLogs(int i, GameLog gameLog) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLog.getClass();
                ensureLogsIsMutable();
                this.logs_.set(i, gameLog);
                onChanged();
            } else {
                repeatedFieldBuilder.setMessage(i, gameLog);
            }
            return this;
        }

        public Builder setMeta(Struct struct) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
            if (singleFieldBuilder == null) {
                struct.getClass();
                this.meta_ = struct;
            } else {
                singleFieldBuilder.setMessage(struct);
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setStageId(int i) {
            this.stageId_ = i;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setStartAt(long j) {
            this.startAt_ = j;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setVersion(String str) {
            str.getClass();
            this.version_ = str;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.version_ = byteString;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
            this.version_ = "";
            this.clientVersion_ = "";
            this.logs_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLogDataset build() {
            GameLogDataset gameLogDatasetBuildPartial = buildPartial();
            if (gameLogDatasetBuildPartial.isInitialized()) {
                return gameLogDatasetBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) gameLogDatasetBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLogDataset buildPartial() {
            GameLogDataset gameLogDataset = new GameLogDataset(this);
            buildPartialRepeatedFields(gameLogDataset);
            if (this.bitField0_ != 0) {
                buildPartial0(gameLogDataset);
            }
            onBuilt();
            return gameLogDataset;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameLogDataset getDefaultInstanceForType() {
            return GameLogDataset.getDefaultInstance();
        }

        public GameLog.Builder addLogsBuilder(int i) {
            return (GameLog.Builder) getLogsFieldBuilder().addBuilder(i, GameLog.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.version_ = "";
            this.clientVersion_ = "";
            this.stageId_ = 0;
            this.length_ = 0;
            this.startAt_ = 0L;
            this.endAt_ = 0L;
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.logs_ = Collections.emptyList();
            } else {
                this.logs_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -65;
            this.meta_ = null;
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.metaBuilder_ = null;
            }
            return this;
        }

        public Builder addLogs(int i, GameLog gameLog) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLog.getClass();
                ensureLogsIsMutable();
                this.logs_.add(i, gameLog);
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(i, gameLog);
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof GameLogDataset) {
                return mergeFrom((GameLogDataset) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setLogs(int i, GameLog.Builder builder) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLogsIsMutable();
                this.logs_.set(i, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.setMessage(i, builder.build());
            }
            return this;
        }

        public Builder setMeta(Struct.Builder builder) {
            SingleFieldBuilder<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilder = this.metaBuilder_;
            if (singleFieldBuilder == null) {
                this.meta_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.version_ = "";
            this.clientVersion_ = "";
            this.logs_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(GameLogDataset gameLogDataset) {
            if (gameLogDataset == GameLogDataset.getDefaultInstance()) {
                return this;
            }
            if (!gameLogDataset.getVersion().isEmpty()) {
                this.version_ = gameLogDataset.version_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (!gameLogDataset.getClientVersion().isEmpty()) {
                this.clientVersion_ = gameLogDataset.clientVersion_;
                this.bitField0_ |= 2;
                onChanged();
            }
            if (gameLogDataset.getStageId() != 0) {
                setStageId(gameLogDataset.getStageId());
            }
            if (gameLogDataset.getLength() != 0) {
                setLength(gameLogDataset.getLength());
            }
            if (gameLogDataset.getStartAt() != 0) {
                setStartAt(gameLogDataset.getStartAt());
            }
            if (gameLogDataset.getEndAt() != 0) {
                setEndAt(gameLogDataset.getEndAt());
            }
            if (this.logsBuilder_ == null) {
                if (!gameLogDataset.logs_.isEmpty()) {
                    if (this.logs_.isEmpty()) {
                        this.logs_ = gameLogDataset.logs_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureLogsIsMutable();
                        this.logs_.addAll(gameLogDataset.logs_);
                    }
                    onChanged();
                }
            } else if (!gameLogDataset.logs_.isEmpty()) {
                if (!this.logsBuilder_.isEmpty()) {
                    this.logsBuilder_.addAllMessages(gameLogDataset.logs_);
                } else {
                    this.logsBuilder_.dispose();
                    this.logsBuilder_ = null;
                    this.logs_ = gameLogDataset.logs_;
                    this.bitField0_ &= -65;
                    this.logsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getLogsFieldBuilder() : null;
                }
            }
            if (gameLogDataset.hasMeta()) {
                mergeMeta(gameLogDataset.getMeta());
            }
            mergeUnknownFields(gameLogDataset.getUnknownFields());
            onChanged();
            return this;
        }

        public Builder addLogs(GameLog.Builder builder) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLogsIsMutable();
                this.logs_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilder.addMessage(builder.build());
            }
            return this;
        }

        public Builder addLogs(int i, GameLog.Builder builder) {
            RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLogsIsMutable();
                this.logs_.add(i, builder.build());
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
                                this.version_ = codedInputStream.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                this.clientVersion_ = codedInputStream.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                            } else if (tag == 24) {
                                this.stageId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 4;
                            } else if (tag == 32) {
                                this.length_ = codedInputStream.readInt32();
                                this.bitField0_ |= 8;
                            } else if (tag == 40) {
                                this.startAt_ = codedInputStream.readInt64();
                                this.bitField0_ |= 16;
                            } else if (tag == 48) {
                                this.endAt_ = codedInputStream.readInt64();
                                this.bitField0_ |= 32;
                            } else if (tag == 58) {
                                GameLog gameLog = (GameLog) codedInputStream.readMessage(GameLog.parser(), extensionRegistryLite);
                                RepeatedFieldBuilder<GameLog, GameLog.Builder, GameLogOrBuilder> repeatedFieldBuilder = this.logsBuilder_;
                                if (repeatedFieldBuilder == null) {
                                    ensureLogsIsMutable();
                                    this.logs_.add(gameLog);
                                } else {
                                    repeatedFieldBuilder.addMessage(gameLog);
                                }
                            } else if (tag != 66) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getMetaFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 128;
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

    private GameLogDataset(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.version_ = "";
        this.clientVersion_ = "";
        this.stageId_ = 0;
        this.length_ = 0;
        this.startAt_ = 0L;
        this.endAt_ = 0L;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(GameLogDataset gameLogDataset) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(gameLogDataset);
    }

    public static GameLogDataset parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameLogDataset parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GameLogDataset) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameLogDataset parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameLogDataset getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static GameLogDataset parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static GameLogDataset parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static GameLogDataset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameLogDataset parseFrom(InputStream inputStream) {
        return (GameLogDataset) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameLogDataset parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GameLogDataset) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    private GameLogDataset() {
        this.version_ = "";
        this.clientVersion_ = "";
        this.stageId_ = 0;
        this.length_ = 0;
        this.startAt_ = 0L;
        this.endAt_ = 0L;
        this.memoizedIsInitialized = (byte) -1;
        this.version_ = "";
        this.clientVersion_ = "";
        this.logs_ = Collections.emptyList();
    }

    public static GameLogDataset parseFrom(CodedInputStream codedInputStream) {
        return (GameLogDataset) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameLogDataset parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GameLogDataset) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
