package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class LegacyUnredactedTextFormat {
    private LegacyUnredactedTextFormat() {
    }

    public static String legacyUnredactedMultilineString(MessageOrBuilder messageOrBuilder) {
        return TextFormat.printer().printToString(messageOrBuilder, TextFormat.Printer.FieldReporterLevel.LEGACY_MULTILINE);
    }

    public static String legacyUnredactedSingleLineString(MessageOrBuilder messageOrBuilder) {
        return TextFormat.printer().emittingSingleLine(true).printToString(messageOrBuilder, TextFormat.Printer.FieldReporterLevel.LEGACY_SINGLE_LINE);
    }

    public static String legacyUnredactedMultilineString(UnknownFieldSet unknownFieldSet) {
        return TextFormat.printer().printToString(unknownFieldSet);
    }

    public static String legacyUnredactedSingleLineString(UnknownFieldSet unknownFieldSet) {
        return TextFormat.printer().emittingSingleLine(true).printToString(unknownFieldSet);
    }
}
