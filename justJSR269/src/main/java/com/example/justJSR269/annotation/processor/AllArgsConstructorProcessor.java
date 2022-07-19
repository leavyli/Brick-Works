package com.example.justJSR269.annotation.processor;

import com.example.justJSR269.annotation.source.AllArgsConstructor;
import com.google.auto.service.AutoService;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.TypeTag;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;

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
 * LastModify 11:03
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.example.justJSR269.annotation.source.AllArgsConstructor")
@SupportedSourceVersion(javax.lang.model.SourceVersion.RELEASE_17)
public class AllArgsConstructorProcessor extends BaseProcessor {
    private List<JCTree.JCVariableDecl> fieldJCVariables;
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(AllArgsConstructor.class);

        set.forEach((element)->{
            JCTree jcTree = trees.getTree(element);
            jcTree.accept(new TreeTranslator() {
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClass) {
                    messager.printMessage(Diagnostic.Kind.NOTE, "process class [" + jcClass.name.toString() + "], start");

                    before(jcClass);

                    //添加全参构造方法
                    if (!hasAllArgsConstructor(fieldJCVariables, jcClass)) {
                        jcClass.defs = jcClass.defs.append(
                                createAllArgsConstructor()
                        );
                    }

                    after();

                    messager.printMessage(Diagnostic.Kind.NOTE, "process class [" + jcClass.name.toString() + "], end");
                }
            });
        });

        return true;
    }

    private void before(JCTree.JCClassDecl jcClass) {
        fieldJCVariables = getJCVariables(jcClass);
    }

    private void after() {
        fieldJCVariables = null;
    }

    private JCTree.JCMethodDecl createAllArgsConstructor() {

        ListBuffer<JCTree.JCStatement> jcStatements = new ListBuffer<>();
        for (JCTree.JCVariableDecl jcVariable : fieldJCVariables) {
            //添加构造方法的赋值语句 " this.xxx = xxx; "
            jcStatements.append(
                    treeMaker.Exec(
                            treeMaker.Assign(
                                    treeMaker.Select(
                                            treeMaker.Ident(names.fromString(THIS)),
                                            names.fromString(jcVariable.name.toString())
                                    ),
                                    treeMaker.Ident(names.fromString(jcVariable.name.toString()))
                            )
                    )
            );
        }

        JCTree.JCBlock jcBlock = treeMaker.Block(
                0 //访问标志
                , jcStatements.toList() //所有的语句
        );

        return treeMaker.MethodDef(
                treeMaker.Modifiers(Flags.PUBLIC), //访问标志
                names.fromString(CONSTRUCTOR_NAME), //名字
                treeMaker.TypeIdent(TypeTag.VOID), //返回类型
                List.nil(), //泛型形参列表
                cloneJCVariablesAsParams(treeMaker, fieldJCVariables), //参数列表
                List.nil(), //异常列表
                jcBlock, //方法体
                null //默认方法（可能是interface中的那个default）
        );
    }
}
