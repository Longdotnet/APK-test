package com.google.protobuf;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.1.<init>(com.google.protobuf.Message, int):void, class status: PROCESS_STARTED
    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
    	at jadx.core.dex.visitors.ClassModifier.removeFieldUsageFromConstructor(ClassModifier.java:117)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:97)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:65)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:59)
    */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    public static final /* synthetic */ int $r8$clinit = 0;
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$1 */
    public class AnonymousClass1 extends CachedDescriptorRetriever {
        final /* synthetic */ int val$descriptorIndex;
        final /* synthetic */ Message val$scope;

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public AnonymousClass1(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.1.<init>(com.google.protobuf.Message, int):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
        public com.google.protobuf.Descriptors.FieldDescriptor loadDescriptor(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.1.loadDescriptor():com.google.protobuf.Descriptors$FieldDescriptor, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */
    }

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$2 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachTryCatchVisitor
            java.lang.NullPointerException: Cannot load from object array because "insnByOffset" is null
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.createHandler(AttachTryCatchVisitor.java:125)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.convertToHandlers(AttachTryCatchVisitor.java:114)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.initTryCatches(AttachTryCatchVisitor.java:54)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.visit(AttachTryCatchVisitor.java:42)
            */
        static {
            /*
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.protobuf.GeneratedMessage.AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r0
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE     // Catch: java.lang.NoSuchFieldError -> L12
                int r1 = r1.ordinal()     // Catch: java.lang.NoSuchFieldError -> L12
                r2 = 1
                r0[r1] = r2     // Catch: java.lang.NoSuchFieldError -> L12
            L12:
                int[] r0 = com.google.protobuf.GeneratedMessage.AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType     // Catch: java.lang.NoSuchFieldError -> L1d
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM     // Catch: java.lang.NoSuchFieldError -> L1d
                int r1 = r1.ordinal()     // Catch: java.lang.NoSuchFieldError -> L1d
                r2 = 2
                r0[r1] = r2     // Catch: java.lang.NoSuchFieldError -> L1d
            L1d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessage.AnonymousClass2.<clinit>():void");
        }
    }

    public static abstract class Builder<BuilderT extends Builder<BuilderT>> extends AbstractMessage.Builder<BuilderT> {
        private AbstractMessage.BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderT>.BuilderParentImpl meAsParent;
        private Object unknownFieldsOrBuilder;

        public class BuilderParentImpl implements AbstractMessage.BuilderParent {
            final /* synthetic */ Builder this$0;

            /* JADX WARN: Error attach source line
            java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
             */
            /* JADX WARN: Failed to parse debug info
            java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
             */
            /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
                java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
                	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
                */
            private BuilderParentImpl(
            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.BuilderParentImpl.<init>(com.google.protobuf.GeneratedMessage$Builder):void, class status: PROCESS_COMPLETE
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
                	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
                */
            /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
                java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
                */

            /* JADX WARN: Error attach source line
            java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
             */
            /* JADX WARN: Failed to parse debug info
            java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
             */
            /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
                java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
                	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
                */
            public /* synthetic */ BuilderParentImpl(
            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.BuilderParentImpl.<init>(com.google.protobuf.GeneratedMessage$Builder, com.google.protobuf.GeneratedMessage$1):void, class status: PROCESS_COMPLETE
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
                	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
                */
            /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
                java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
                */

            /* JADX WARN: Error attach source line
            java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
             */
            /* JADX WARN: Failed to parse debug info
            java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
            	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
             */
            /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
                java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
                	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
                */
            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty(
            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.BuilderParentImpl.markDirty():void, class status: PROCESS_COMPLETE
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
                	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
                */
            /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
                java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
                */
        }

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public Builder(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.<init>():void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public Builder(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.<init>(com.google.protobuf.AbstractMessage$BuilderParent):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public static /* synthetic */ java.util.Map access$900(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.access$900(com.google.protobuf.GeneratedMessage$Builder):java.util.Map, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        private java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFieldsMutable(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getAllFieldsMutable():java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        private BuilderT setUnknownFieldsInternal(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setUnknownFieldsInternal(com.google.protobuf.UnknownFieldSet):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder addRepeatedField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.addRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.AbstractMessage.Builder clear(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clear():com.google.protobuf.AbstractMessage$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clear():BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder clear(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clear():com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.MessageLite.Builder clear(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clear():com.google.protobuf.MessageLite$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public BuilderT clearField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clearField(com.google.protobuf.Descriptors$FieldDescriptor):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder clearField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clearField(com.google.protobuf.Descriptors$FieldDescriptor):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.AbstractMessage.Builder clearOneof(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clearOneof(com.google.protobuf.Descriptors$OneofDescriptor):com.google.protobuf.AbstractMessage$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearOneof(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clearOneof(com.google.protobuf.Descriptors$OneofDescriptor):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder clearOneof(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clearOneof(com.google.protobuf.Descriptors$OneofDescriptor):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ com.google.protobuf.AbstractMessage.Builder m108clone(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clone():com.google.protobuf.AbstractMessage$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ com.google.protobuf.AbstractMessageLite.Builder m108clone(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clone():com.google.protobuf.AbstractMessageLite$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* JADX INFO: renamed from: clone */
        public BuilderT m108clone(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clone():BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder m108clone(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clone():com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ com.google.protobuf.MessageLite.Builder m108clone(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clone():com.google.protobuf.MessageLite$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ java.lang.Object mo106clone(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.clone():java.lang.Object, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder
        public void dispose(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.dispose():void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getAllFields():java.util.Map<com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getDescriptorForType():com.google.protobuf.Descriptors$Descriptor, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getField(com.google.protobuf.Descriptors$FieldDescriptor):java.lang.Object, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getFieldBuilder(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getFieldBuilder(com.google.protobuf.Descriptors$FieldDescriptor):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getOneofFieldDescriptor(com.google.protobuf.Descriptors$OneofDescriptor):com.google.protobuf.Descriptors$FieldDescriptor, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public com.google.protobuf.AbstractMessage.BuilderParent getParentForChildren(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getParentForChildren():com.google.protobuf.AbstractMessage$BuilderParent, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getRepeatedField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int):java.lang.Object, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getRepeatedFieldBuilder(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getRepeatedFieldBuilder(com.google.protobuf.Descriptors$FieldDescriptor, int):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getRepeatedFieldCount(com.google.protobuf.Descriptors$FieldDescriptor):int, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder
        public com.google.protobuf.UnknownFieldSet.Builder getUnknownFieldSetBuilder(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getUnknownFieldSetBuilder():com.google.protobuf.UnknownFieldSet$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.MessageOrBuilder
        public final com.google.protobuf.UnknownFieldSet getUnknownFields(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.getUnknownFields():com.google.protobuf.UnknownFieldSet, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.hasField(com.google.protobuf.Descriptors$FieldDescriptor):boolean, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.hasOneof(com.google.protobuf.Descriptors$OneofDescriptor):boolean, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.internalGetFieldAccessorTable():com.google.protobuf.GeneratedMessage$FieldAccessorTable, class status: PROCESS_STARTED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:44)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public abstract FieldAccessorTable internalGetFieldAccessorTable(
        /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.internalGetFieldAccessorTable():com.google.protobuf.GeneratedMessage$FieldAccessorTable, class status: PROCESS_STARTED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:44)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.internalGetFieldAccessorTable():com.google.protobuf.GeneratedMessage$FieldAccessorTable, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:402)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @java.lang.Deprecated
        public com.google.protobuf.MapField internalGetMapField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.internalGetMapField(int):com.google.protobuf.MapField, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public com.google.protobuf.MapFieldReflectionAccessor internalGetMapFieldReflection(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.internalGetMapFieldReflection(int):com.google.protobuf.MapFieldReflectionAccessor, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @java.lang.Deprecated
        public com.google.protobuf.MapField internalGetMutableMapField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public com.google.protobuf.MapFieldReflectionAccessor internalGetMutableMapFieldReflection(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.internalGetMutableMapFieldReflection(int):com.google.protobuf.MapFieldReflectionAccessor, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public boolean isClean(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.isClean():boolean, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.isInitialized():boolean, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder
        public void markClean(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.markClean():void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.AbstractMessage.Builder mergeUnknownFields(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.mergeUnknownFields(com.google.protobuf.UnknownFieldSet):com.google.protobuf.AbstractMessage$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT mergeUnknownFields(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.mergeUnknownFields(com.google.protobuf.UnknownFieldSet):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder mergeUnknownFields(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.mergeUnknownFields(com.google.protobuf.UnknownFieldSet):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public final void mergeUnknownLengthDelimitedField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.mergeUnknownLengthDelimitedField(int, com.google.protobuf.ByteString):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public final void mergeUnknownVarintField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.mergeUnknownVarintField(int, int):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder newBuilderForField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.newBuilderForField(com.google.protobuf.Descriptors$FieldDescriptor):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public void onBuilt(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.onBuilt():void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public final void onChanged(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.onChanged():void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public boolean parseUnknownField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.parseUnknownField(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite, int):boolean, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public BuilderT setField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder setField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setField(com.google.protobuf.Descriptors$FieldDescriptor, java.lang.Object):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder setRepeatedField(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setRepeatedField(com.google.protobuf.Descriptors$FieldDescriptor, int, java.lang.Object):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.AbstractMessage.Builder
        public void setUnknownFieldSetBuilder(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setUnknownFieldSetBuilder(com.google.protobuf.UnknownFieldSet$Builder):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public BuilderT setUnknownFields(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setUnknownFields(com.google.protobuf.UnknownFieldSet):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ com.google.protobuf.Message.Builder setUnknownFields(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setUnknownFields(com.google.protobuf.UnknownFieldSet):com.google.protobuf.Message$Builder, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public BuilderT setUnknownFieldsProto3(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.Builder.setUnknownFieldsProto3(com.google.protobuf.UnknownFieldSet):BuilderT extends com.google.protobuf.GeneratedMessage$Builder<BuilderT>, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */
    }

    public static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        private CachedDescriptorRetriever(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever.<init>():void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            	at jadx.core.dex.visitors.AttachMethodDetails.visit(AttachMethodDetails.java:34)
            */
        public /* synthetic */ CachedDescriptorRetriever(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever.<init>(com.google.protobuf.GeneratedMessage$1):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachMethodDetails
            java.lang.NullPointerException: Cannot read the array length because "<local2>" is null
            */

        /* JADX WARN: Error attach source line
        java.lang.NullPointerException: Cannot load from object array because "insnArr" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.attachSourceLines(DebugInfoAttachVisitor.java:62)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:51)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /* JADX WARN: Failed to parse debug info
        java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.setMethodSourceLine(DebugInfoAttachVisitor.java:189)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.processDebugInfo(DebugInfoAttachVisitor.java:53)
        	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:40)
         */
        /*  JADX ERROR: NullPointerException in pass: AttachTryCatchVisitor
            java.lang.NullPointerException: Cannot load from object array because "insnByOffset" is null
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.createHandler(AttachTryCatchVisitor.java:125)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.convertToHandlers(AttachTryCatchVisitor.java:118)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.initTryCatches(AttachTryCatchVisitor.java:54)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.visit(AttachTryCatchVisitor.java:42)
            */
        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public com.google.protobuf.Descriptors.FieldDescriptor getDescriptor(
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever.getDescriptor():com.google.protobuf.Descriptors$FieldDescriptor, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
        /*  JADX ERROR: NullPointerException in pass: AttachTryCatchVisitor
            java.lang.NullPointerException: Cannot load from object array because "insnByOffset" is null
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.createHandler(AttachTryCatchVisitor.java:125)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.convertToHandlers(AttachTryCatchVisitor.java:118)
            	at jadx.core.dex.visitors.AttachTryCatchVisitor.initTryCatches(AttachTryCatchVisitor.java:54)
            */

        /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever.loadDescriptor():com.google.protobuf.Descriptors$FieldDescriptor, class status: PROCESS_STARTED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:44)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public abstract Descriptors.FieldDescriptor loadDescriptor(
        /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever.loadDescriptor():com.google.protobuf.Descriptors$FieldDescriptor, class status: PROCESS_STARTED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:44)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever.loadDescriptor():com.google.protobuf.Descriptors$FieldDescriptor, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:194)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:402)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            */
    }

    public static abstract class ExtendableBuilder<MessageT extends ExtendableMessage<MessageT>, BuilderT extends ExtendableBuilder<MessageT, BuilderT>> extends Builder<BuilderT> implements ExtendableMessageOrBuilder<MessageT> {
        private FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        public ExtendableBuilder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            return builder == null ? FieldSet.emptySet() : builder.buildPartial();
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions == null) {
                this.extensions = FieldSet.newBuilder();
            }
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void verifyExtensionContainingType(Extension<MessageT, ?> extension) {
            if (extension.getDescriptor().getContainingType() == getDescriptorForType()) {
                return;
            }
            throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public final <T> BuilderT addExtension(ExtensionLite<? extends MessageT, List<T>> extensionLite, T t) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.singularToReflectionType(t));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public final <T> BuilderT clearExtension(ExtensionLite<? extends MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.clearField(extensionCheckNotLite.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return clearField(fieldDescriptor);
        }

        public boolean extensionsAreInitialized() {
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            return builder == null || builder.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map mapAccess$900 = Builder.access$900(this);
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder != null) {
                mapAccess$900.putAll(builder.getAllFields());
            }
            return Collections.unmodifiableMap(mapAccess$900);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            Object field = builder == null ? null : builder.getField(descriptor);
            if (field != null) {
                return (T) extensionCheckNotLite.fromReflectionType(field);
            }
            if (descriptor.isRepeated()) {
                return (T) Collections.emptyList();
            }
            return descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? (T) extensionCheckNotLite.getMessageDefaultInstance() : (T) extensionCheckNotLite.fromReflectionType(descriptor.getDefaultValue());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return 0;
            }
            return builder.getRepeatedFieldCount(descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            Object field = builder == null ? null : builder.getField(fieldDescriptor);
            if (field == null) {
                return fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()) : fieldDescriptor.getDefaultValue();
            }
            return field;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getFieldBuilder(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            if (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
            ensureExtensionsIsMutable();
            Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(fieldDescriptor);
            if (fieldAllowBuilders == null) {
                DynamicMessage.Builder builderNewBuilder = DynamicMessage.newBuilder(fieldDescriptor.getMessageType());
                this.extensions.setField(fieldDescriptor, builderNewBuilder);
                onChanged();
                return builderNewBuilder;
            }
            if (fieldAllowBuilders instanceof Message.Builder) {
                return (Message.Builder) fieldAllowBuilders;
            }
            if (!(fieldAllowBuilders instanceof Message)) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            Message.Builder builder = ((Message) fieldAllowBuilders).toBuilder();
            this.extensions.setField(fieldDescriptor, builder);
            onChanged();
            return builder;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedField(fieldDescriptor, i);
            }
            verifyContainingType(fieldDescriptor);
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder != null) {
                return builder.getRepeatedField(fieldDescriptor, i);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedFieldBuilder(fieldDescriptor, i);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            if (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            Object repeatedFieldAllowBuilders = this.extensions.getRepeatedFieldAllowBuilders(fieldDescriptor, i);
            if (repeatedFieldAllowBuilders instanceof Message.Builder) {
                return (Message.Builder) repeatedFieldAllowBuilders;
            }
            if (!(repeatedFieldAllowBuilders instanceof Message)) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            Message.Builder builder = ((Message) repeatedFieldAllowBuilders).toBuilder();
            this.extensions.setRepeatedField(fieldDescriptor, i, builder);
            onChanged();
            return builder;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedFieldCount(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder == null) {
                return 0;
            }
            return builder.getRepeatedFieldCount(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> extensionLite) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            return builder != null && builder.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.hasField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            return builder != null && builder.hasField(fieldDescriptor);
        }

        public void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> fieldSet) {
            this.extensions = FieldSet.Builder.fromFieldSet(fieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        public void mergeExtensionFields(ExtendableMessage<?> extendableMessage) {
            if (((ExtendableMessage) extendableMessage).extensions != null) {
                ensureExtensionsIsMutable();
                this.extensions.mergeFrom(((ExtendableMessage) extendableMessage).extensions);
                onChanged();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            return fieldDescriptor.isExtension() ? DynamicMessage.newBuilder(fieldDescriptor.getMessageType()) : super.newBuilderForField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            ensureExtensionsIsMutable();
            return MessageReflection.mergeFieldFrom(codedInputStream, codedInputStream.shouldDiscardUnknownFields() ? null : getUnknownFieldSetBuilder(), extensionRegistryLite, getDescriptorForType(), new MessageReflection.ExtensionBuilderAdapter(this.extensions), i);
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, T> extensionLite, T t) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setField(extensionCheckNotLite.getDescriptor(), extensionCheckNotLite.toReflectionType(t));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return setRepeatedField(fieldDescriptor, i, obj);
        }

        public ExtendableBuilder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.addRepeatedField(fieldDescriptor, obj);
                onChanged();
                return this;
            }
            return (BuilderT) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.clearField(fieldDescriptor);
                onChanged();
                return this;
            }
            return (BuilderT) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.setField(fieldDescriptor, obj);
                onChanged();
                return this;
            }
            return (BuilderT) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            if (fieldDescriptor.isExtension()) {
                verifyContainingType(fieldDescriptor);
                ensureExtensionsIsMutable();
                this.extensions.setRepeatedField(fieldDescriptor, i, obj);
                onChanged();
                return this;
            }
            return (BuilderT) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderT clear() {
            this.extensions = null;
            return (BuilderT) super.clear();
        }

        public final <T> BuilderT setExtension(ExtensionLite<? extends MessageT, List<T>> extensionLite, int i, T t) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(extensionCheckNotLite.getDescriptor(), i, extensionCheckNotLite.singularToReflectionType(t));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> extensionLite, int i) {
            Extension<MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            FieldSet.Builder<Descriptors.FieldDescriptor> builder = this.extensions;
            if (builder != null) {
                return (T) extensionCheckNotLite.singularFromReflectionType(builder.getRepeatedField(descriptor, i));
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public interface ExtendableMessageOrBuilder<MessageT extends ExtendableMessage<MessageT>> extends MessageOrBuilder {

        /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
        }

        @Override // com.google.protobuf.MessageOrBuilder
        Message getDefaultInstanceForType();

        <T> T getExtension(ExtensionLite<? extends MessageT, T> extensionLite);

        <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> extensionLite, int i);

        <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> extensionLite);

        <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> extensionLite);
    }

    public interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    public static class GeneratedExtension<ContainingT extends Message, T> extends Extension<ContainingT, T> {
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final java.lang.reflect.Method enumGetValueDescriptor;
        private final java.lang.reflect.Method enumValueOf;
        private final Extension.ExtensionType extensionType;
        private final Message messageDefaultInstance;
        private final Class<?> singularType;

        public GeneratedExtension(ExtensionDescriptorRetriever extensionDescriptorRetriever, Class<?> cls, Message message, Extension.ExtensionType extensionType) {
            if (Message.class.isAssignableFrom(cls) && !cls.isInstance(message)) {
                throw new IllegalArgumentException("Bad messageDefaultInstance for ".concat(cls.getName()));
            }
            this.descriptorRetriever = extensionDescriptorRetriever;
            this.singularType = cls;
            this.messageDefaultInstance = message;
            if (ProtocolMessageEnum.class.isAssignableFrom(cls)) {
                this.enumValueOf = GeneratedMessage.getMethodOrDie(cls, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(cls, "getValueDescriptor", new Class[0]);
            } else {
                this.enumValueOf = null;
                this.enumGetValueDescriptor = null;
            }
            this.extensionType = extensionType;
        }

        @Override // com.google.protobuf.Extension
        public Object fromReflectionType(Object obj) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularFromReflectionType(obj);
            }
            if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                return obj;
            }
            ProtobufArrayList protobufArrayList = new ProtobufArrayList();
            List list = (List) obj;
            protobufArrayList.ensureCapacity(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                protobufArrayList.add(singularFromReflectionType(it.next()));
            }
            protobufArrayList.makeImmutable();
            return protobufArrayList;
        }

        @Override // com.google.protobuf.ExtensionLite
        public T getDefaultValue() {
            if (isRepeated()) {
                return (T) Collections.emptyList();
            }
            return getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? (T) this.messageDefaultInstance : (T) singularFromReflectionType(getDescriptor().getDefaultValue());
        }

        @Override // com.google.protobuf.Extension
        public Descriptors.FieldDescriptor getDescriptor() {
            ExtensionDescriptorRetriever extensionDescriptorRetriever = this.descriptorRetriever;
            if (extensionDescriptorRetriever != null) {
                return extensionDescriptorRetriever.getDescriptor();
            }
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        @Override // com.google.protobuf.Extension
        public Extension.ExtensionType getExtensionType() {
            return this.extensionType;
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return getDescriptor().getLiteType();
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public /* bridge */ /* synthetic */ MessageLite getMessageDefaultInstance() {
            return getMessageDefaultInstance();
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return getDescriptor().getNumber();
        }

        public void internalInit(final Descriptors.FieldDescriptor fieldDescriptor) {
            if (this.descriptorRetriever != null) {
                throw new IllegalStateException("Already initialized.");
            }
            this.descriptorRetriever = new ExtensionDescriptorRetriever(this) { // from class: com.google.protobuf.GeneratedMessage.GeneratedExtension.1
                final /* synthetic */ GeneratedExtension this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
                public Descriptors.FieldDescriptor getDescriptor() {
                    return fieldDescriptor;
                }
            };
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.Extension
        public Object singularFromReflectionType(Object obj) {
            int i = AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()];
            if (i != 1) {
                return i != 2 ? obj : GeneratedMessage.invokeOrDie(this.enumValueOf, null, obj);
            }
            return this.singularType.isInstance(obj) ? obj : this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) obj).build();
        }

        @Override // com.google.protobuf.Extension
        public Object singularToReflectionType(Object obj) {
            return AnonymousClass2.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()] != 2 ? obj : GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, obj, new Object[0]);
        }

        @Override // com.google.protobuf.Extension
        public Object toReflectionType(Object obj) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularToReflectionType(obj);
            }
            if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(singularToReflectionType(it.next()));
            }
            return arrayList;
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }
    }

    public static final class UnusedPrivateParameter {
        static final UnusedPrivateParameter INSTANCE = new UnusedPrivateParameter();

        static {
        }

        private UnusedPrivateParameter() {
        }
    }

    public GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    public static boolean canUseUnsafe() {
        return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageT extends ExtendableMessage<MessageT>, T> Extension<MessageT, T> checkNotLite(ExtensionLite<? extends MessageT, T> extensionLite) {
        if (extensionLite.isLite()) {
            throw new IllegalArgumentException("Expected non-lite extension.");
        }
        return (Extension) extensionLite;
    }

    public static int computeStringSize(int i, Object obj) {
        return obj instanceof String ? CodedOutputStream.computeStringSize(i, (String) obj) : CodedOutputStream.computeBytesSize(i, (ByteString) obj);
    }

    public static int computeStringSizeNoTag(Object obj) {
        return obj instanceof String ? CodedOutputStream.computeStringSizeNoTag((String) obj) : CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
    }

    public static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    public static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    public static <T> Internal.ProtobufList<T> emptyList(Class<T> cls) {
        return ProtobufArrayList.emptyList();
    }

    public static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    public static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0066  */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean z) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
        int fieldCount = 0;
        while (fieldCount < fields.size()) {
            Descriptors.FieldDescriptor oneofFieldDescriptor = fields.get(fieldCount);
            Descriptors.OneofDescriptor containingOneof = oneofFieldDescriptor.getContainingOneof();
            if (containingOneof != null) {
                fieldCount += containingOneof.getFieldCount() - 1;
                if (hasOneof(containingOneof)) {
                    oneofFieldDescriptor = getOneofFieldDescriptor(containingOneof);
                    if (z || oneofFieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) {
                        treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                    } else {
                        treeMap.put(oneofFieldDescriptor, getFieldRaw(oneofFieldDescriptor));
                    }
                }
            } else if (oneofFieldDescriptor.isRepeated()) {
                List list = (List) getField(oneofFieldDescriptor);
                if (!list.isEmpty()) {
                    treeMap.put(oneofFieldDescriptor, list);
                }
            } else if (hasField(oneofFieldDescriptor)) {
                if (z) {
                    treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                } else {
                    treeMap.put(oneofFieldDescriptor, getField(oneofFieldDescriptor));
                }
            }
            fieldCount++;
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Method getMethodOrDie(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object invokeOrDie(java.lang.reflect.Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new IllegalStateException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static boolean isStringEmpty(Object obj) {
        return obj instanceof String ? ((String) obj).isEmpty() : ((ByteString) obj).isEmpty();
    }

    public static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT listt) {
        return (ListT) makeMutableCopy(listt, 0);
    }

    private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream codedOutputStream, Map<Boolean, V> map, MapEntry<Boolean, V> mapEntry, int i, boolean z) {
        if (map.containsKey(Boolean.valueOf(z))) {
            codedOutputStream.writeMessage(i, mapEntry.newBuilderForType().setKey(Boolean.valueOf(z)).setValue(map.get(Boolean.valueOf(z))).build());
        }
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newFileScopedGeneratedExtension(Class<?> cls, Message message) {
        return new GeneratedExtension<>(null, cls, message, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingT extends Message, T> GeneratedExtension<ContainingT, T> newMessageScopedGeneratedExtension(Message message, int i, Class<?> cls, Message message2) {
        return new GeneratedExtension<>(new CachedDescriptorRetriever
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: RETURN 
              (wrap com.google.protobuf.GeneratedMessage$GeneratedExtension<ContainingT extends com.google.protobuf.Message, T>:0x0009: CONSTRUCTOR 
              (wrap com.google.protobuf.GeneratedMessage$1:0x0004: CONSTRUCTOR (r2v0 'message' com.google.protobuf.Message), (r3v0 'i' int) A[MD:(com.google.protobuf.Message, int):void (m), WRAPPED] (LINE:5) call: com.google.protobuf.GeneratedMessage.1.<init>(com.google.protobuf.Message, int):void type: CONSTRUCTOR)
              (r4v0 'cls' java.lang.Class<?>)
              (r5v0 'message2' com.google.protobuf.Message)
              (wrap com.google.protobuf.Extension$ExtensionType:0x0007: SGET  A[WRAPPED] (LINE:8) com.google.protobuf.Extension.ExtensionType.IMMUTABLE com.google.protobuf.Extension$ExtensionType)
             A[GenericInfoAttr{[ContainingT extends com.google.protobuf.Message, T], explicit=false}, MD:(com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever, java.lang.Class<?>, com.google.protobuf.Message, com.google.protobuf.Extension$ExtensionType):void (m), WRAPPED] (LINE:10) call: com.google.protobuf.GeneratedMessage.GeneratedExtension.<init>(com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever, java.lang.Class, com.google.protobuf.Message, com.google.protobuf.Extension$ExtensionType):void type: CONSTRUCTOR)
             (LINE:10) in method: com.google.protobuf.GeneratedMessage.newMessageScopedGeneratedExtension(com.google.protobuf.Message, int, java.lang.Class<?>, com.google.protobuf.Message):com.google.protobuf.GeneratedMessage$GeneratedExtension<ContainingT extends com.google.protobuf.Message, T>, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.protobuf.GeneratedMessage.1.<init>(com.google.protobuf.Message, int):void, class status: PROCESS_COMPLETE
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:829)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:782)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
            	... 35 more
            */
        /*
            com.google.protobuf.GeneratedMessage$GeneratedExtension r0 = new com.google.protobuf.GeneratedMessage$GeneratedExtension
            com.google.protobuf.GeneratedMessage$1 r1 = new com.google.protobuf.GeneratedMessage$1
            r1.<init>(r2, r3)
            com.google.protobuf.Extension$ExtensionType r2 = com.google.protobuf.Extension.ExtensionType.IMMUTABLE
            r0.<init>(r1, r4, r5, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessage.newMessageScopedGeneratedExtension(com.google.protobuf.Message, int, java.lang.Class, com.google.protobuf.Message):com.google.protobuf.GeneratedMessage$GeneratedExtension");
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream inputStream) throws IOException {
        try {
            return parser.parseDelimitedFrom(inputStream);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    public static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream inputStream) throws IOException {
        try {
            return parser.parseFrom(inputStream);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    public static <V> void serializeBooleanMapTo(CodedOutputStream codedOutputStream, MapField<Boolean, V> mapField, MapEntry<Boolean, V> mapEntry, int i) {
        Map<Boolean, V> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i);
        } else {
            maybeSerializeBooleanEntryTo(codedOutputStream, map, mapEntry, i, false);
            maybeSerializeBooleanEntryTo(codedOutputStream, map, mapEntry, i, true);
        }
    }

    public static <V> void serializeIntegerMapTo(CodedOutputStream codedOutputStream, MapField<Integer, V> mapField, MapEntry<Integer, V> mapEntry, int i) {
        Map<Integer, V> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i);
            return;
        }
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            codedOutputStream.writeMessage(i, mapEntry.newBuilderForType().setKey(Integer.valueOf(i4)).setValue(map.get(Integer.valueOf(i4))).build());
        }
    }

    public static <V> void serializeLongMapTo(CodedOutputStream codedOutputStream, MapField<Long, V> mapField, MapEntry<Long, V> mapEntry, int i) {
        Map<Long, V> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i);
            return;
        }
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (int i3 = 0; i3 < size; i3++) {
            long j = jArr[i3];
            codedOutputStream.writeMessage(i, mapEntry.newBuilderForType().setKey(Long.valueOf(j)).setValue(map.get(Long.valueOf(j))).build());
        }
    }

    private static <K, V> void serializeMapTo(CodedOutputStream codedOutputStream, Map<K, V> map, MapEntry<K, V> mapEntry, int i) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            codedOutputStream.writeMessage(i, mapEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
    }

    public static <V> void serializeStringMapTo(CodedOutputStream codedOutputStream, MapField<String, V> mapField, MapEntry<String, V> mapEntry, int i) {
        Map<String, V> map = mapField.getMap();
        if (!codedOutputStream.isSerializationDeterministic()) {
            serializeMapTo(codedOutputStream, map, mapEntry, i);
            return;
        }
        String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
        Arrays.sort(strArr);
        for (String str : strArr) {
            codedOutputStream.writeMessage(i, mapEntry.newBuilderForType().setKey(str).setValue(map.get(str)).build());
        }
    }

    public static void setAlwaysUseFieldBuildersForTesting(boolean z) {
        alwaysUseFieldBuilders = z;
    }

    public static void writeString(CodedOutputStream codedOutputStream, int i, Object obj) {
        if (obj instanceof String) {
            codedOutputStream.writeString(i, (String) obj);
        } else {
            codedOutputStream.writeBytes(i, (ByteString) obj);
        }
    }

    public static void writeStringNoTag(CodedOutputStream codedOutputStream, Object obj) {
        if (obj instanceof String) {
            codedOutputStream.writeStringNoTag((String) obj);
        } else {
            codedOutputStream.writeBytesNoTag((ByteString) obj);
        }
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).get(this);
    }

    public Object getFieldRaw(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRaw(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
        return internalGetFieldAccessorTable().getOneof(oneofDescriptor).get(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeated(this, i);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int serializedSize = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
        return internalGetFieldAccessorTable().getOneof(oneofDescriptor).has(this);
    }

    public abstract FieldAccessorTable internalGetFieldAccessorTable();

    @Deprecated
    public MapField internalGetMapField(int i) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    public MapFieldReflectionAccessor internalGetMapFieldReflection(int i) {
        return internalGetMapField(i);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !hasField(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.isRepeated()) {
                    Iterator it = ((List) getField(fieldDescriptor)).iterator();
                    while (it.hasNext()) {
                        if (!((Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (hasField(fieldDescriptor) && !((Message) getField(fieldDescriptor)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Deprecated
    public void mergeFromAndMakeImmutableInternal(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        Schema schemaSchemaFor = Protobuf.getInstance().schemaFor(this);
        try {
            schemaSchemaFor.mergeFrom(this, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
            schemaSchemaFor.makeImmutable(this);
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
        }
    }

    public Object newInstance(UnusedPrivateParameter unusedPrivateParameter) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) {
        return codedInputStream.shouldDiscardUnknownFields() ? codedInputStream.skipField(i) : builder.mergeFieldFrom(i, codedInputStream);
    }

    public boolean parseUnknownFieldProto3(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) {
        return parseUnknownField(codedInputStream, builder, extensionRegistryLite, i);
    }

    public void setUnknownFields(UnknownFieldSet unknownFieldSet) {
        this.unknownFields = unknownFieldSet;
    }

    public Object writeReplace() {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), codedOutputStream, false);
    }

    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageT> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        public interface ExtensionSerializer {
            void writeUntil(int i, CodedOutputStream codedOutputStream);
        }

        public class ExtensionWriter implements ExtensionSerializer {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            public ExtensionWriter(ExtendableMessage extendableMessage, boolean z) {
                this.this$0 = extendableMessage;
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> it = extendableMessage.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = z;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionSerializer
            public void writeUntil(int i, CodedOutputStream codedOutputStream) {
                while (true) {
                    Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.next;
                    if (entry == null || entry.getKey().getNumber() >= i) {
                        return;
                    }
                    Descriptors.FieldDescriptor key = this.next.getKey();
                    if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                        FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                    } else if (this.next instanceof LazyField.LazyEntry) {
                        codedOutputStream.writeRawMessageSetExtension(key.getNumber(), ((LazyField.LazyEntry) this.next).getField().toByteString());
                    } else {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (Message) this.next.getValue());
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        public static final class NoOpExtensionSerializer implements ExtensionSerializer {
            private static final NoOpExtensionSerializer INSTANCE = new NoOpExtensionSerializer();

            static {
            }

            private NoOpExtensionSerializer() {
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionSerializer
            public void writeUntil(int i, CodedOutputStream codedOutputStream) {
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void verifyExtensionContainingType(Extension<? extends MessageT, ?> extension) {
            if (extension.getDescriptor().getContainingType() == getDescriptorForType()) {
                return;
            }
            throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(getExtensionFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, T> extensionLite) {
            Extension<? extends MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            Descriptors.FieldDescriptor descriptor = extensionCheckNotLite.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            if (field != null) {
                return (T) extensionCheckNotLite.fromReflectionType(field);
            }
            if (descriptor.isRepeated()) {
                return (T) ProtobufArrayList.emptyList();
            }
            return descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? (T) extensionCheckNotLite.getMessageDefaultInstance() : (T) extensionCheckNotLite.fromReflectionType(descriptor.getDefaultValue());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> int getExtensionCount(ExtensionLite<? extends MessageT, List<T>> extensionLite) {
            Extension<? extends MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.getRepeatedFieldCount(extensionCheckNotLite.getDescriptor());
        }

        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            Object field = this.extensions.getField(fieldDescriptor);
            if (field != null) {
                return field;
            }
            if (fieldDescriptor.isRepeated()) {
                return Collections.emptyList();
            }
            return fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()) : fieldDescriptor.getDefaultValue();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedField(fieldDescriptor, i);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedField(fieldDescriptor, i);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedFieldCount(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedFieldCount(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> boolean hasExtension(ExtensionLite<? extends MessageT, T> extensionLite) {
            Extension<? extends MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return this.extensions.hasField(extensionCheckNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.hasField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        public ExtensionSerializer newExtensionSerializer() {
            return this.extensions.isEmpty() ? NoOpExtensionSerializer.INSTANCE : new ExtensionWriter(this, false);
        }

        @Deprecated
        public ExtendableMessage<MessageT>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false);
        }

        public ExtensionSerializer newMessageSetExtensionSerializer() {
            return this.extensions.isEmpty() ? NoOpExtensionSerializer.INSTANCE : new ExtensionWriter(this, true);
        }

        public ExtendableMessage<MessageT>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true);
        }

        public ExtendableMessage(ExtendableBuilder<MessageT, ?> extendableBuilder) {
            super(extendableBuilder);
            this.extensions = extendableBuilder.buildExtensions();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <T> T getExtension(ExtensionLite<? extends MessageT, List<T>> extensionLite, int i) {
            Extension<? extends MessageT, ?> extensionCheckNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extensionCheckNotLite);
            return (T) extensionCheckNotLite.singularFromReflectionType(this.extensions.getRepeatedField(extensionCheckNotLite.getDescriptor(), i));
        }
    }

    public static class FieldAccessorTable {
        private String[] camelCaseNames;
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;
        private final OneofAccessor[] oneofs;

        public interface FieldAccessor {
            void addRepeated(Builder<?> builder, Object obj);

            void clear(Builder<?> builder);

            Object get(Builder<?> builder);

            Object get(GeneratedMessage generatedMessage);

            Message.Builder getBuilder(Builder<?> builder);

            Object getRaw(GeneratedMessage generatedMessage);

            Object getRepeated(Builder<?> builder, int i);

            Object getRepeated(GeneratedMessage generatedMessage, int i);

            Message.Builder getRepeatedBuilder(Builder<?> builder, int i);

            int getRepeatedCount(Builder<?> builder);

            int getRepeatedCount(GeneratedMessage generatedMessage);

            boolean has(Builder<?> builder);

            boolean has(GeneratedMessage generatedMessage);

            Message.Builder newBuilder();

            void set(Builder<?> builder, Object obj);

            void setRepeated(Builder<?> builder, int i, Object obj);
        }

        public static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            public MapFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, Class<? extends GeneratedMessage> cls) {
                this.field = fieldDescriptor;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) GeneratedMessage.invokeOrDie(GeneratedMessage.getMethodOrDie(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }

            private Message coerceType(Message message) {
                if (message == null) {
                    return null;
                }
                return this.mapEntryMessageDefaultInstance.getClass().isInstance(message) ? message : this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(message).build();
            }

            private MapFieldReflectionAccessor getMapField(GeneratedMessage generatedMessage) {
                return generatedMessage.internalGetMapFieldReflection(this.field.getNumber());
            }

            private MapFieldReflectionAccessor getMutableMapField(Builder<?> builder) {
                return builder.internalGetMutableMapFieldReflection(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> builder, Object obj) {
                getMutableMapField(builder).getMutableList().add(coerceType((Message) obj));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> builder) {
                getMutableMapField(builder).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage generatedMessage) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < getRepeatedCount(generatedMessage); i++) {
                    arrayList.add(getRepeated(generatedMessage, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                return getMapField(generatedMessage).getList().get(i);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> builder, int i) {
                throw new UnsupportedOperationException("Map fields cannot be repeated");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                return getMapField(generatedMessage).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object obj) {
                clear(builder);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> builder, int i, Object obj) {
                getMutableMapField(builder).getMutableList().set(i, coerceType((Message) obj));
            }

            private MapFieldReflectionAccessor getMapField(Builder<?> builder) {
                return builder.internalGetMapFieldReflection(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> builder, int i) {
                return getMapField(builder).getList().get(i);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> builder) {
                return getMapField(builder).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> builder) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < getRepeatedCount(builder); i++) {
                    arrayList.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(arrayList);
            }
        }

        public interface OneofAccessor {
            void clear(Builder<?> builder);

            Descriptors.FieldDescriptor get(Builder<?> builder);

            Descriptors.FieldDescriptor get(GeneratedMessage generatedMessage);

            boolean has(Builder<?> builder);

            boolean has(GeneratedMessage generatedMessage);
        }

        public static class RealOneofAccessor implements OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            public RealOneofAccessor(Descriptors.Descriptor descriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2) {
                this.descriptor = descriptor;
                this.caseMethod = GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Case"), new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Case"), new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("clear", str), new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage generatedMessage) {
                int number = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage generatedMessage) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber() != 0;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> builder) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber() != 0;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> builder) {
                int number = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
                if (number > 0) {
                    return this.descriptor.findFieldByNumber(number);
                }
                return null;
            }
        }

        public static class RepeatedFieldAccessor implements FieldAccessor {
            protected final MethodInvoker invoker;
            protected final Class<?> type;

            public interface MethodInvoker {
                void addRepeated(Builder<?> builder, Object obj);

                void clear(Builder<?> builder);

                Object get(Builder<?> builder);

                Object get(GeneratedMessage generatedMessage);

                Object getRepeated(Builder<?> builder, int i);

                Object getRepeated(GeneratedMessage generatedMessage, int i);

                int getRepeatedCount(Builder<?> builder);

                int getRepeatedCount(GeneratedMessage generatedMessage);

                void setRepeated(Builder<?> builder, int i, Object obj);
            }

            public static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method addRepeatedMethod;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getCountMethod;
                private final java.lang.reflect.Method getCountMethodBuilder;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method getRepeatedMethod;
                private final java.lang.reflect.Method getRepeatedMethodBuilder;
                private final java.lang.reflect.Method setRepeatedMethod;

                public ReflectionInvoker(String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2) {
                    this.getMethod = GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "List"), new Class[0]);
                    this.getMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "List"), new Class[0]);
                    String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str);
                    Class cls3 = Integer.TYPE;
                    java.lang.reflect.Method methodOrDie = GeneratedMessage.getMethodOrDie(cls, strM$1, cls3);
                    this.getRepeatedMethod = methodOrDie;
                    this.getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str), cls3);
                    Class<?> returnType = methodOrDie.getReturnType();
                    this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("set", str), cls3, returnType);
                    this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("add", str), returnType);
                    this.getCountMethod = GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Count"), new Class[0]);
                    this.getCountMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Count"), new Class[0]);
                    this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("clear", str), new Class[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void addRepeated(Builder<?> builder, Object obj) {
                    GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, obj);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void clear(Builder<?> builder) {
                    GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage generatedMessage) {
                    return GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                    return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, generatedMessage, Integer.valueOf(i));
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(GeneratedMessage generatedMessage) {
                    return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethod, generatedMessage, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public void setRepeated(Builder<?> builder, int i, Object obj) {
                    GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, Integer.valueOf(i), obj);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object get(Builder<?> builder) {
                    return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public Object getRepeated(Builder<?> builder, int i) {
                    return GeneratedMessage.invokeOrDie(this.getRepeatedMethodBuilder, builder, Integer.valueOf(i));
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor.MethodInvoker
                public int getRepeatedCount(Builder<?> builder) {
                    return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethodBuilder, builder, new Object[0])).intValue();
                }
            }

            public RepeatedFieldAccessor(String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2) {
                ReflectionInvoker reflectionInvoker = new ReflectionInvoker(str, cls, cls2);
                this.type = reflectionInvoker.getRepeatedMethod.getReturnType();
                this.invoker = getMethodInvoker(reflectionInvoker);
            }

            public static MethodInvoker getMethodInvoker(ReflectionInvoker reflectionInvoker) {
                return reflectionInvoker;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> builder, Object obj) {
                this.invoker.addRepeated(builder, obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> builder) {
                this.invoker.clear(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage generatedMessage) {
                return this.invoker.get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                return this.invoker.getRepeated(generatedMessage, i);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> builder, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                return this.invoker.getRepeatedCount(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object obj) {
                clear(builder);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    addRepeated(builder, it.next());
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> builder, int i, Object obj) {
                this.invoker.setRepeated(builder, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                return this.invoker.get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> builder, int i) {
                return this.invoker.getRepeated(builder, i);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> builder) {
                return this.invoker.getRepeatedCount(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> builder) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }
        }

        public static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            public RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2) {
                super(str, cls, cls2);
                this.newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Builder"), Integer.TYPE);
            }

            private Object coerceType(Object obj) {
                return this.type.isInstance(obj) ? obj : ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) obj).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> builder, Object obj) {
                super.addRepeated(builder, coerceType(obj));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> builder, int i) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, Integer.valueOf(i));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> builder, int i, Object obj) {
                super.setRepeated(builder, i, coerceType(obj));
            }
        }

        public static class SingularFieldAccessor implements FieldAccessor {
            protected final Descriptors.FieldDescriptor field;
            protected final boolean hasHasMethod;
            protected final MethodInvoker invoker;
            protected final boolean isOneofField;
            protected final Class<?> type;

            public interface MethodInvoker {
                void clear(Builder<?> builder);

                Object get(Builder<?> builder);

                Object get(GeneratedMessage generatedMessage);

                int getOneofFieldNumber(Builder<?> builder);

                int getOneofFieldNumber(GeneratedMessage generatedMessage);

                boolean has(Builder<?> builder);

                boolean has(GeneratedMessage generatedMessage);

                void set(Builder<?> builder, Object obj);
            }

            public static final class ReflectionInvoker implements MethodInvoker {
                private final java.lang.reflect.Method caseMethod;
                private final java.lang.reflect.Method caseMethodBuilder;
                private final java.lang.reflect.Method clearMethod;
                private final java.lang.reflect.Method getMethod;
                private final java.lang.reflect.Method getMethodBuilder;
                private final java.lang.reflect.Method hasMethod;
                private final java.lang.reflect.Method hasMethodBuilder;
                private final java.lang.reflect.Method setMethod;

                public ReflectionInvoker(String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2, String str2, boolean z, boolean z2) {
                    java.lang.reflect.Method methodOrDie = GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str), new Class[0]);
                    this.getMethod = methodOrDie;
                    this.getMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str), new Class[0]);
                    this.setMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("set", str), methodOrDie.getReturnType());
                    this.hasMethod = z2 ? GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("has", str), new Class[0]) : null;
                    this.hasMethodBuilder = z2 ? GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("has", str), new Class[0]) : null;
                    this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("clear", str), new Class[0]);
                    this.caseMethod = z ? GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str2, "Case"), new Class[0]) : null;
                    this.caseMethodBuilder = z ? GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str2, "Case"), new Class[0]) : null;
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void clear(Builder<?> builder) {
                    GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(GeneratedMessage generatedMessage) {
                    return GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(GeneratedMessage generatedMessage) {
                    return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(GeneratedMessage generatedMessage) {
                    return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethod, generatedMessage, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public void set(Builder<?> builder, Object obj) {
                    GeneratedMessage.invokeOrDie(this.setMethod, builder, obj);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public Object get(Builder<?> builder) {
                    return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public int getOneofFieldNumber(Builder<?> builder) {
                    return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor.MethodInvoker
                public boolean has(Builder<?> builder) {
                    return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethodBuilder, builder, new Object[0])).booleanValue();
                }
            }

            public SingularFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2, String str2) {
                boolean z = fieldDescriptor.getRealContainingOneof() != null;
                this.isOneofField = z;
                boolean zHasPresence = fieldDescriptor.hasPresence();
                this.hasHasMethod = zHasPresence;
                ReflectionInvoker reflectionInvoker = new ReflectionInvoker(str, cls, cls2, str2, z, zHasPresence);
                this.field = fieldDescriptor;
                this.type = reflectionInvoker.getMethod.getReturnType();
                this.invoker = getMethodInvoker(reflectionInvoker);
            }

            public static MethodInvoker getMethodInvoker(ReflectionInvoker reflectionInvoker) {
                return reflectionInvoker;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> builder, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder<?> builder) {
                this.invoker.clear(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage generatedMessage) {
                return this.invoker.get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage generatedMessage) {
                return get(generatedMessage);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder<?> builder, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage generatedMessage) {
                if (this.hasHasMethod) {
                    return this.invoker.has(generatedMessage);
                }
                if (this.isOneofField) {
                    return this.invoker.getOneofFieldNumber(generatedMessage) == this.field.getNumber();
                }
                return !get(generatedMessage).equals(this.field.getDefaultValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object obj) {
                this.invoker.set(builder, obj);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> builder, int i, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                return this.invoker.get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> builder, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder<?> builder) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder<?> builder) {
                if (!this.hasHasMethod) {
                    if (this.isOneofField) {
                        return this.invoker.getOneofFieldNumber(builder) == this.field.getNumber();
                    }
                    return !get(builder).equals(this.field.getDefaultValue());
                }
                return this.invoker.has(builder);
            }
        }

        public static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            public SingularMessageFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Builder"), new Class[0]);
            }

            private Object coerceType(Object obj) {
                return this.type.isInstance(obj) ? obj : ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) obj).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder<?> builder) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object obj) {
                super.set(builder, coerceType(obj));
            }
        }

        public static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            public SingularStringFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.getBytesMethod = GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Bytes"), new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("set", str, "Bytes"), ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.getBytesMethod, generatedMessage, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object obj) {
                if (obj instanceof ByteString) {
                    GeneratedMessage.invokeOrDie(this.setBytesMethodBuilder, builder, obj);
                } else {
                    super.set(builder, obj);
                }
            }
        }

        public static class SyntheticOneofAccessor implements OneofAccessor {
            private final Descriptors.FieldDescriptor fieldDescriptor;

            public SyntheticOneofAccessor(Descriptors.Descriptor descriptor, int i) {
                this.fieldDescriptor = descriptor.getOneofs().get(i).getFields().get(0);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public void clear(Builder<?> builder) {
                builder.clearField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(GeneratedMessage generatedMessage) {
                if (generatedMessage.hasField(this.fieldDescriptor)) {
                    return this.fieldDescriptor;
                }
                return null;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(GeneratedMessage generatedMessage) {
                return generatedMessage.hasField(this.fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public Descriptors.FieldDescriptor get(Builder<?> builder) {
                if (builder.hasField(this.fieldDescriptor)) {
                    return this.fieldDescriptor;
                }
                return null;
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.OneofAccessor
            public boolean has(Builder<?> builder) {
                return builder.hasField(this.fieldDescriptor);
            }
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] strArr, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2) {
            this(descriptor, strArr);
            ensureFieldAccessorsInitialized(cls, cls2);
        }

        public static /* synthetic */ Descriptors.Descriptor access$000(FieldAccessorTable fieldAccessorTable) {
            return fieldAccessorTable.descriptor;
        }

        public static /* synthetic */ OneofAccessor access$100(FieldAccessorTable fieldAccessorTable, Descriptors.OneofDescriptor oneofDescriptor) {
            return fieldAccessorTable.getOneof(oneofDescriptor);
        }

        public static /* synthetic */ FieldAccessor access$200(FieldAccessorTable fieldAccessorTable, Descriptors.FieldDescriptor fieldDescriptor) {
            return fieldAccessorTable.getField(fieldDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldAccessor getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (fieldDescriptor.isExtension()) {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
            return this.fields[fieldDescriptor.getIndex()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OneofAccessor getOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            if (oneofDescriptor.getContainingType() == this.descriptor) {
                return this.oneofs[oneofDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2) {
            if (this.initialized) {
                return this;
            }
            synchronized (this) {
                try {
                    if (this.initialized) {
                        return this;
                    }
                    int length = this.fields.length;
                    int i = 0;
                    while (true) {
                        String str = null;
                        if (i >= length) {
                            break;
                        }
                        Descriptors.FieldDescriptor fieldDescriptor = this.descriptor.getFields().get(i);
                        if (fieldDescriptor.getContainingOneof() != null) {
                            int index = fieldDescriptor.getContainingOneof().getIndex() + length;
                            String[] strArr = this.camelCaseNames;
                            if (index < strArr.length) {
                                str = strArr[index];
                            }
                        }
                        String str2 = str;
                        if (fieldDescriptor.isRepeated()) {
                            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                                if (fieldDescriptor.isMapField()) {
                                    this.fields[i] = new MapFieldAccessor(fieldDescriptor, cls);
                                } else {
                                    this.fields[i] = new RepeatedMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                                }
                            } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                                this.fields[i] = new RepeatedEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                            } else {
                                this.fields[i] = new RepeatedFieldAccessor(this.camelCaseNames[i], cls, cls2);
                            }
                        } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            this.fields[i] = new SingularMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                        } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.fields[i] = new SingularEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                        } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.STRING) {
                            this.fields[i] = new SingularStringFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                        } else {
                            this.fields[i] = new SingularFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2, str2);
                        }
                        i++;
                    }
                    for (int i2 = 0; i2 < this.descriptor.getOneofs().size(); i2++) {
                        if (i2 < this.descriptor.getRealOneofs().size()) {
                            this.oneofs[i2] = new RealOneofAccessor(this.descriptor, this.camelCaseNames[i2 + length], cls, cls2);
                        } else {
                            this.oneofs[i2] = new SyntheticOneofAccessor(this.descriptor, i2);
                        }
                    }
                    this.initialized = true;
                    this.camelCaseNames = null;
                    return this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] strArr) {
            this.descriptor = descriptor;
            this.camelCaseNames = strArr;
            this.fields = new FieldAccessor[descriptor.getFields().size()];
            this.oneofs = new OneofAccessor[descriptor.getOneofs().size()];
            this.initialized = false;
        }

        public static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private final Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            public RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2) {
                super(str, cls, cls2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
                boolean zLegacyEnumFieldTreatedAsClosed = fieldDescriptor.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = !zLegacyEnumFieldTreatedAsClosed;
                if (zLegacyEnumFieldTreatedAsClosed) {
                    return;
                }
                String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Value");
                Class cls3 = Integer.TYPE;
                this.getRepeatedValueMethod = GeneratedMessage.getMethodOrDie(cls, strM$1, cls3);
                this.getRepeatedValueMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Value"), cls3);
                this.setRepeatedValueMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("set", str, "Value"), cls3, cls3);
                this.addRepeatedValueMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("add", str, "Value"), cls3);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder<?> builder, Object obj) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.addRepeatedValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.addRepeated(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage generatedMessage) {
                ArrayList arrayList = new ArrayList();
                int repeatedCount = getRepeatedCount(generatedMessage);
                for (int i = 0; i < repeatedCount; i++) {
                    arrayList.add(getRepeated(generatedMessage, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                return this.supportUnknownEnumValue ? this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethod, generatedMessage, Integer.valueOf(i))).intValue()) : GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(generatedMessage, i), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder<?> builder, int i, Object obj) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setRepeatedValueMethod, builder, Integer.valueOf(i), Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.setRepeated(builder, i, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                ArrayList arrayList = new ArrayList();
                int repeatedCount = getRepeatedCount(builder);
                for (int i = 0; i < repeatedCount; i++) {
                    arrayList.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder<?> builder, int i) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(builder, i), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethodBuilder, builder, Integer.valueOf(i))).intValue());
            }
        }

        public static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private final Descriptors.EnumDescriptor enumDescriptor;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private final boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            public SingularEnumFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder<?>> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.enumDescriptor = fieldDescriptor.getEnumType();
                this.valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
                boolean zLegacyEnumFieldTreatedAsClosed = fieldDescriptor.legacyEnumFieldTreatedAsClosed();
                this.supportUnknownEnumValue = !zLegacyEnumFieldTreatedAsClosed;
                if (zLegacyEnumFieldTreatedAsClosed) {
                    return;
                }
                this.getValueMethod = GeneratedMessage.getMethodOrDie(cls, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Value"), new Class[0]);
                this.getValueMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("get", str, "Value"), new Class[0]);
                this.setValueMethod = GeneratedMessage.getMethodOrDie(cls2, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("set", str, "Value"), Integer.TYPE);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage generatedMessage) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(generatedMessage), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethod, generatedMessage, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder<?> builder, Object obj) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                } else {
                    super.set(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder<?> builder) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethodBuilder, builder, new Object[0])).intValue());
                }
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(builder), new Object[0]);
            }
        }
    }

    public static <ListT extends Internal.ProtobufList<?>> ListT makeMutableCopy(ListT listt, int i) {
        int size = listt.size();
        if (i <= size) {
            i = size * 2;
        }
        if (i <= 0) {
            i = 10;
        }
        return (ListT) listt.mutableCopyWithCapacity2(i);
    }

    public GeneratedMessage(Builder<?> builder) {
        this.unknownFields = builder.getUnknownFields();
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        try {
            return parser.parseDelimitedFrom(inputStream, extensionRegistryLite);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    public static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        try {
            return parser.parseFrom(inputStream, extensionRegistryLite);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    public static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream codedInputStream) throws IOException {
        try {
            return parser.parseFrom(codedInputStream);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    public static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        try {
            return parser.parseFrom(codedInputStream, extensionRegistryLite);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }
}
