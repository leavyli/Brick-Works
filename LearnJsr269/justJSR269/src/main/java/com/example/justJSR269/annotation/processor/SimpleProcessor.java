package com.example.justJSR269.annotation.processor;

import com.example.justJSR269.annotation.source.Simple;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;


/**
 * Author saino
 * LastModify 21:00
 */
//@AutoService(Processor.class)
@SupportedAnnotationTypes("com.example.justJSR269.annotation.source.Simple")
@SupportedSourceVersion(javax.lang.model.SourceVersion.RELEASE_17)
public class SimpleProcessor extends BaseProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
            for(TypeElement t : annotations)
                System.out.println(t);
            for(Element el :
                    env.getElementsAnnotatedWith(Simple.class))
                display(el);
            return false;
        }
        private void display(Element el) {
            System.out.println("==== " + el + " ====");
            System.out.println(el.getKind() +
                    " : " + el.getModifiers() +
                    " : " + el.getSimpleName() +
                    " : " + el.asType());
            if(el.getKind().equals(ElementKind.CLASS)) {
                TypeElement te = (TypeElement)el;
                System.out.println(te.getQualifiedName());
                System.out.println(te.getSuperclass());
                System.out.println(te.getEnclosedElements());
            }
            if(el.getKind().equals(ElementKind.METHOD)) {
                ExecutableElement ex = (ExecutableElement)el;
                System.out.print(ex.getReturnType() + " ");
                System.out.print(ex.getSimpleName() + "(");
                System.out.println(ex.getParameters() + ")");
            }

        }
}
