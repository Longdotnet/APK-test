package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
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
public final class AfterLog extends GeneratedMessage implements AfterLogOrBuilder {
    public static final int BALL_DATA_FIELD_NUMBER = 4;
    private static final AfterLog DEFAULT_INSTANCE;
    public static final int ENEMY_HP_FIELD_NUMBER = 2;
    private static final Parser<AfterLog> PARSER;
    public static final int TEAM_HP_FIELD_NUMBER = 1;
    public static final int TRIGGER_PLAYER_DATA_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private BallData ballData_;
    private int bitField0_;
    private float enemyHp_;
    private byte memoizedIsInitialized;
    private float teamHp_;
    private PlayerData triggerPlayerData_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", AfterLog.class.getName());
        DEFAULT_INSTANCE = new AfterLog();
        PARSER = new AbstractParser<AfterLog>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLog.1
            @Override // com.google.protobuf.Parser
            public AfterLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = AfterLog.newBuilder();
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

    public static /* synthetic */ int access$876(AfterLog afterLog, int i) {
        int i2 = i | afterLog.bitField0_;
        afterLog.bitField0_ = i2;
        return i2;
    }

    public static AfterLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_AfterLog_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AfterLog parseDelimitedFrom(InputStream inputStream) {
        return (AfterLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AfterLog parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<AfterLog> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AfterLog)) {
            return super.equals(obj);
        }
        AfterLog afterLog = (AfterLog) obj;
        if (Float.floatToIntBits(getTeamHp()) != Float.floatToIntBits(afterLog.getTeamHp()) || Float.floatToIntBits(getEnemyHp()) != Float.floatToIntBits(afterLog.getEnemyHp()) || hasTriggerPlayerData() != afterLog.hasTriggerPlayerData()) {
            return false;
        }
        if ((!hasTriggerPlayerData() || getTriggerPlayerData().equals(afterLog.getTriggerPlayerData())) && hasBallData() == afterLog.hasBallData()) {
            return (!hasBallData() || getBallData().equals(afterLog.getBallData())) && getUnknownFields().equals(afterLog.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public BallData getBallData() {
        BallData ballData = this.ballData_;
        return ballData == null ? BallData.getDefaultInstance() : ballData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public BallDataOrBuilder getBallDataOrBuilder() {
        BallData ballData = this.ballData_;
        return ballData == null ? BallData.getDefaultInstance() : ballData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public float getEnemyHp() {
        return this.enemyHp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AfterLog> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeFloatSize = Float.floatToRawIntBits(this.teamHp_) != 0 ? CodedOutputStream.computeFloatSize(1, this.teamHp_) : 0;
        if (Float.floatToRawIntBits(this.enemyHp_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeFloatSize(2, this.enemyHp_);
        }
        if ((1 & this.bitField0_) != 0) {
            iComputeFloatSize += CodedOutputStream.computeMessageSize(3, getTriggerPlayerData());
        }
        if ((this.bitField0_ & 2) != 0) {
            iComputeFloatSize += CodedOutputStream.computeMessageSize(4, getBallData());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeFloatSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public float getTeamHp() {
        return this.teamHp_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public PlayerData getTriggerPlayerData() {
        PlayerData playerData = this.triggerPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public PlayerDataOrBuilder getTriggerPlayerDataOrBuilder() {
        PlayerData playerData = this.triggerPlayerData_;
        return playerData == null ? PlayerData.getDefaultInstance() : playerData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public boolean hasBallData() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
    public boolean hasTriggerPlayerData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iFloatToIntBits = Float.floatToIntBits(getEnemyHp()) + ((((Float.floatToIntBits(getTeamHp()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53);
        if (hasTriggerPlayerData()) {
            iFloatToIntBits = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iFloatToIntBits, 37, 3, 53) + getTriggerPlayerData().hashCode();
        }
        if (hasBallData()) {
            iFloatToIntBits = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iFloatToIntBits, 37, 4, 53) + getBallData().hashCode();
        }
        int iHashCode = getUnknownFields().hashCode() + (iFloatToIntBits * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_AfterLog_fieldAccessorTable.ensureFieldAccessorsInitialized(AfterLog.class, Builder.class);
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
        if (Float.floatToRawIntBits(this.teamHp_) != 0) {
            codedOutputStream.writeFloat(1, this.teamHp_);
        }
        if (Float.floatToRawIntBits(this.enemyHp_) != 0) {
            codedOutputStream.writeFloat(2, this.enemyHp_);
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(3, getTriggerPlayerData());
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeMessage(4, getBallData());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AfterLogOrBuilder {
        private SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> ballDataBuilder_;
        private BallData ballData_;
        private int bitField0_;
        private float enemyHp_;
        private float teamHp_;
        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> triggerPlayerDataBuilder_;
        private PlayerData triggerPlayerData_;

        private void buildPartial0(AfterLog afterLog) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                afterLog.teamHp_ = this.teamHp_;
            }
            if ((i2 & 2) != 0) {
                afterLog.enemyHp_ = this.enemyHp_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
                afterLog.triggerPlayerData_ = singleFieldBuilder == null ? this.triggerPlayerData_ : (PlayerData) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder2 = this.ballDataBuilder_;
                afterLog.ballData_ = singleFieldBuilder2 == null ? this.ballData_ : (BallData) singleFieldBuilder2.build();
                i |= 2;
            }
            AfterLog.access$876(afterLog, i);
        }

        private SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> getBallDataFieldBuilder() {
            if (this.ballDataBuilder_ == null) {
                this.ballDataBuilder_ = new SingleFieldBuilder<>(getBallData(), getParentForChildren(), isClean());
                this.ballData_ = null;
            }
            return this.ballDataBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_AfterLog_descriptor;
        }

        private SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> getTriggerPlayerDataFieldBuilder() {
            if (this.triggerPlayerDataBuilder_ == null) {
                this.triggerPlayerDataBuilder_ = new SingleFieldBuilder<>(getTriggerPlayerData(), getParentForChildren(), isClean());
                this.triggerPlayerData_ = null;
            }
            return this.triggerPlayerDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getTriggerPlayerDataFieldBuilder();
                getBallDataFieldBuilder();
            }
        }

        public Builder clearBallData() {
            this.bitField0_ &= -9;
            this.ballData_ = null;
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.ballDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearEnemyHp() {
            this.bitField0_ &= -3;
            this.enemyHp_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTeamHp() {
            this.bitField0_ &= -2;
            this.teamHp_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTriggerPlayerData() {
            this.bitField0_ &= -5;
            this.triggerPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.triggerPlayerDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public BallData getBallData() {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                return (BallData) singleFieldBuilder.getMessage();
            }
            BallData ballData = this.ballData_;
            return ballData == null ? BallData.getDefaultInstance() : ballData;
        }

        public BallData.Builder getBallDataBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (BallData.Builder) getBallDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public BallDataOrBuilder getBallDataOrBuilder() {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                return (BallDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            BallData ballData = this.ballData_;
            return ballData == null ? BallData.getDefaultInstance() : ballData;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_AfterLog_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public float getEnemyHp() {
            return this.enemyHp_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public float getTeamHp() {
            return this.teamHp_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public PlayerData getTriggerPlayerData() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerData) singleFieldBuilder.getMessage();
            }
            PlayerData playerData = this.triggerPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        public PlayerData.Builder getTriggerPlayerDataBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (PlayerData.Builder) getTriggerPlayerDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public PlayerDataOrBuilder getTriggerPlayerDataOrBuilder() {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlayerData playerData = this.triggerPlayerData_;
            return playerData == null ? PlayerData.getDefaultInstance() : playerData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public boolean hasBallData() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.AfterLogOrBuilder
        public boolean hasTriggerPlayerData() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_AfterLog_fieldAccessorTable.ensureFieldAccessorsInitialized(AfterLog.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeBallData(BallData ballData) {
            BallData ballData2;
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(ballData);
            } else if ((this.bitField0_ & 8) == 0 || (ballData2 = this.ballData_) == null || ballData2 == BallData.getDefaultInstance()) {
                this.ballData_ = ballData;
            } else {
                getBallDataBuilder().mergeFrom(ballData);
            }
            if (this.ballData_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder mergeTriggerPlayerData(PlayerData playerData) {
            PlayerData playerData2;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(playerData);
            } else if ((this.bitField0_ & 4) == 0 || (playerData2 = this.triggerPlayerData_) == null || playerData2 == PlayerData.getDefaultInstance()) {
                this.triggerPlayerData_ = playerData;
            } else {
                getTriggerPlayerDataBuilder().mergeFrom(playerData);
            }
            if (this.triggerPlayerData_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder setBallData(BallData ballData) {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder == null) {
                ballData.getClass();
                this.ballData_ = ballData;
            } else {
                singleFieldBuilder.setMessage(ballData);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setEnemyHp(float f) {
            this.enemyHp_ = f;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setTeamHp(float f) {
            this.teamHp_ = f;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setTriggerPlayerData(PlayerData playerData) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                playerData.getClass();
                this.triggerPlayerData_ = playerData;
            } else {
                singleFieldBuilder.setMessage(playerData);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AfterLog build() {
            AfterLog afterLogBuildPartial = buildPartial();
            if (afterLogBuildPartial.isInitialized()) {
                return afterLogBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) afterLogBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AfterLog buildPartial() {
            AfterLog afterLog = new AfterLog(this);
            if (this.bitField0_ != 0) {
                buildPartial0(afterLog);
            }
            onBuilt();
            return afterLog;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AfterLog getDefaultInstanceForType() {
            return AfterLog.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.teamHp_ = 0.0f;
            this.enemyHp_ = 0.0f;
            this.triggerPlayerData_ = null;
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.triggerPlayerDataBuilder_ = null;
            }
            this.ballData_ = null;
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder2 = this.ballDataBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.ballDataBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof AfterLog) {
                return mergeFrom((AfterLog) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setBallData(BallData.Builder builder) {
            SingleFieldBuilder<BallData, BallData.Builder, BallDataOrBuilder> singleFieldBuilder = this.ballDataBuilder_;
            if (singleFieldBuilder == null) {
                this.ballData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setTriggerPlayerData(PlayerData.Builder builder) {
            SingleFieldBuilder<PlayerData, PlayerData.Builder, PlayerDataOrBuilder> singleFieldBuilder = this.triggerPlayerDataBuilder_;
            if (singleFieldBuilder == null) {
                this.triggerPlayerData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeFrom(AfterLog afterLog) {
            if (afterLog == AfterLog.getDefaultInstance()) {
                return this;
            }
            if (afterLog.getTeamHp() != 0.0f) {
                setTeamHp(afterLog.getTeamHp());
            }
            if (afterLog.getEnemyHp() != 0.0f) {
                setEnemyHp(afterLog.getEnemyHp());
            }
            if (afterLog.hasTriggerPlayerData()) {
                mergeTriggerPlayerData(afterLog.getTriggerPlayerData());
            }
            if (afterLog.hasBallData()) {
                mergeBallData(afterLog.getBallData());
            }
            mergeUnknownFields(afterLog.getUnknownFields());
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
                            if (tag == 13) {
                                this.teamHp_ = codedInputStream.readFloat();
                                this.bitField0_ |= 1;
                            } else if (tag == 21) {
                                this.enemyHp_ = codedInputStream.readFloat();
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                codedInputStream.readMessage(getTriggerPlayerDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 4;
                            } else if (tag != 34) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getBallDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 8;
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

    private AfterLog(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.teamHp_ = 0.0f;
        this.enemyHp_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(AfterLog afterLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(afterLog);
    }

    public static AfterLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AfterLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AfterLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AfterLog parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AfterLog getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static AfterLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static AfterLog parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    private AfterLog() {
        this.teamHp_ = 0.0f;
        this.enemyHp_ = 0.0f;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AfterLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AfterLog parseFrom(InputStream inputStream) {
        return (AfterLog) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static AfterLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AfterLog) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AfterLog parseFrom(CodedInputStream codedInputStream) {
        return (AfterLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static AfterLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AfterLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
