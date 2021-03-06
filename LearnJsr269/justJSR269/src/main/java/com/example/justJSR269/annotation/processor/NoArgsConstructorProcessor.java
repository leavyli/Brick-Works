package com.example.justJSR269.annotation.processor;

import com.example.justJSR269.annotation.source.NoArgsConstructor;
import com.google.auto.service.AutoService;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.TypeTag;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.List;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

import static com.example.justJSR269.annotation.processor.ProcessUtil.*;

/**
 * Author saino
 * LastModify 6:16
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.example.justJSR269.annotation.source.NoArgsConstructor")
@SupportedSourceVersion(javax.lang.model.SourceVersion.RELEASE_17)
public class NoArgsConstructorProcessor extends BaseProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(NoArgsConstructor.class);
        set.forEach(element -> {
            JCTree jcTree = trees.getTree(element);

            jcTree.accept(new TreeTranslator() {
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClass) {
                    messager.printMessage(Diagnostic.Kind.NOTE, "@NoArgsConstructor process [" + jcClass.name.toString() + "] begin!");

                    if (!hasNoArgsConstructor(jcClass)) {
                        jcClass.defs = jcClass.defs.append(
                                createNoArgsConstructor()
                        );
                    }
                }
            });

        });

        return true;
    }

    private JCTree.JCMethodDecl createNoArgsConstructor() {
        JCTree.JCBlock jcBlock = treeMaker.Block(0, List.nil());

        return treeMaker.MethodDef(
                treeMaker.Modifiers(Flags.PUBLIC), //????????????
                names.fromString(CONSTRUCTOR_NAME), //??????
                treeMaker.TypeIdent(TypeTag.VOID), //????????????
                List.nil(), //??????????????????
                List.nil(), //????????????
                List.nil(), //????????????
                jcBlock, //?????????
                null //????????????????????????interface????????????default???
        );
    }
}
