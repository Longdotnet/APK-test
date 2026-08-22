package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class DebugFormat {
    private final boolean isSingleLine;

    private DebugFormat(boolean z) {
        this.isSingleLine = z;
    }

    public static DebugFormat multiline() {
        return new DebugFormat(false);
    }

    public static DebugFormat singleLine() {
        return new DebugFormat(true);
    }

    public Object lazyToString(MessageOrBuilder messageOrBuilder) {
        return new LazyDebugOutput(messageOrBuilder, this);
    }

    public String toString(MessageOrBuilder messageOrBuilder) {
        return TextFormat.printer().emittingSingleLine(this.isSingleLine).enablingSafeDebugFormat(true).printToString(messageOrBuilder, this.isSingleLine ? TextFormat.Printer.FieldReporterLevel.DEBUG_SINGLE_LINE : TextFormat.Printer.FieldReporterLevel.DEBUG_MULTILINE);
    }

    public Object lazyToString(UnknownFieldSet unknownFieldSet) {
        return new LazyDebugOutput(unknownFieldSet, this);
    }

    public static class LazyDebugOutput {
        private final UnknownFieldSet fields;
        private final DebugFormat format;
        private final MessageOrBuilder message;

        public LazyDebugOutput(MessageOrBuilder messageOrBuilder, DebugFormat debugFormat) {
            this.message = messageOrBuilder;
            this.fields = null;
            this.format = debugFormat;
        }

        public String toString() {
            MessageOrBuilder messageOrBuilder = this.message;
            return messageOrBuilder != null ? this.format.toString(messageOrBuilder) : this.format.toString(this.fields);
        }

        public LazyDebugOutput(UnknownFieldSet unknownFieldSet, DebugFormat debugFormat) {
            this.message = null;
            this.fields = unknownFieldSet;
            this.format = debugFormat;
        }
    }

    public String toString(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
        return TextFormat.printer().emittingSingleLine(this.isSingleLine).enablingSafeDebugFormat(true).printFieldToString(fieldDescriptor, obj);
    }

    public String toString(UnknownFieldSet unknownFieldSet) {
        return TextFormat.printer().emittingSingleLine(this.isSingleLine).enablingSafeDebugFormat(true).printToString(unknownFieldSet);
    }
}
