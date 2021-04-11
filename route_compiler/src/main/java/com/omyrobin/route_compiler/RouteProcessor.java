package com.omyrobin.route_compiler;

import com.google.auto.service.AutoService;
import com.omyrobin.route_annotation.Route;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * @author Omyrobin
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.omyrobin.route_annotation.Route")//能处理的注解
@SupportedSourceVersion(SourceVersion.RELEASE_8)//使用JDK8进行编译
@SupportedOptions("ROUTER_MODULE_NAME")//接收的参数 在build gradle中配置
public class RouteProcessor extends AbstractProcessor {

    // 操作Element工具类
    private Elements elementUtils;
    // 操作type 类信息 工具类
    private Types typeUtils;
    // 用来输出警告、错误日志等
    private Messager messager;
    //文件生成器
    private Filer filer;

    private String router_module_name;

    /**
     * 初始化工作
     * @param processingEnvironment
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        elementUtils = processingEnvironment.getElementUtils();
        typeUtils = processingEnvironment.getTypeUtils();
        messager = processingEnvironment.getMessager();
        //获取外面传进来的参数
        router_module_name = processingEnvironment.getOptions().get("ROUTER_MODULE_NAME");
        messager.printMessage(Diagnostic.Kind.NOTE, "获取到的" + router_module_name);
        //忘记初始化 搞了1个多小时 org.jetbrains.kotlin.gradle.internal.KaptExecution 一直报这个错..... 郁闷 最后在AS Compler中添加--stacktrace --info才追踪到错误信息
        filer = processingEnvironment.getFiler();
    }

//    /**
//     * 获取支持的注解类型
//     * @return
//     */
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        return super.getSupportedAnnotationTypes();
//    }
//
//    /**
//     * 需要JDK什么版本来处理
//     * @return
//     */
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        return super.getSupportedSourceVersion();
//    }
//
//    /**
//     * 接收外面传来的参数
//     * @return
//     */
//    @Override
//    public Set<String> getSupportedOptions() {
//        return super.getSupportedOptions();
//    }

    /**
     * 开始处理注解的主要函数
     *
     * @param set                    使用了Route注解的节点集合 类文件上面写了@Route的节点
     * @param roundEnvironment       运行环境，可以通过该对象查找到注解
     * @return true  表示后续处理器不会再处理（已经处理完成）
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if(set.isEmpty()){
            return false;
        }


        //获取项目中所有含有Route注解的集合
        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(Route.class);

        generatedClass(elementsAnnotatedWith);
//        for (Element element : elementsAnnotatedWith){
//            String packageName = elementUtils.getPackageOf(element).getQualifiedName().toString();
//            //获取类的简单类名
//            String className = element.getSimpleName().toString();
//            messager.printMessage(Diagnostic.Kind.NOTE, "被注解的类有：" + className);
//            //最终生成的类文件名
//            String finalClassName = className + "$$Route";
//
//            try {
//                JavaFileObject sourceFile = filer.createClassFile(packageName +"." + finalClassName);
//                Writer writer = sourceFile.openWriter();
//                Route route  = element.getAnnotation(Route.class);
//                writer.append("package " + packageName + ";\n");
//                System.out.println("package " + packageName + ";\n");
//                writer.append("import com.omyrobin.route_api.RouteMeta;\n");
//                System.out.println("import com.omyrobin.route_api.RouteMeta;\n");
//                writer.append("import " + ((TypeElement)element).getQualifiedName() +";\n");
//                System.out.println("import " + ((TypeElement)element).getQualifiedName()+";\n");
//                writer.append("import java.util.Map;\n");
//                System.out.println("import java.util.Map;\n");
//                writer.append("public class " +  finalClassName + " {\n");
//                System.out.println("public class " +  finalClassName + " {\n");
//                writer.append("public void loadInto() {\n");
//                System.out.println("public void loadInto() {\n");
//                writer.append("@Override");
//                writer.append("public void loadInto(Map<String, RouteMeta> atlas) {\n");
//                writer.append("atlas.put(\"" + route.path() +"\", RouteMeta.build(" + className + ".class,\"" +  route.path() + "\",\"" + route.group() +"\"));\n");
//                writer.append("}\n}");
//                System.out.println("}\n}");
//
//
//                writer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        return true;
    }

    private void generatedClass(Set<? extends Element> routeElements) {
        StringBuilder sb = new StringBuilder();

        sb.append("package com.omyrobin.component;\n");
        sb.append("import com.omyrobin.route_annotation.RouteMeta;\n");
        sb.append("import android.app.Activity;\n");
        sb.append("import com.omyrobin.route_api.IRouterRegister;\n");
        sb.append("import java.util.Map;\n");

        for (Element element : routeElements) {
            String packageName = elementUtils.getPackageOf(element).getQualifiedName().toString();
            //获取类的简单类名
            String className = element.getSimpleName().toString();
            messager.printMessage(Diagnostic.Kind.NOTE, "被注解的类有：" + className);
            //最终生成的类文件名
            String finalClassName = className + "$$Route";

            TypeElement typeElement = (TypeElement) element;
            sb.append("import "+ typeElement.getQualifiedName() + ";\n");

            //类
            sb.append("public class ");
            sb.append(finalClassName);
            sb.append(" implements IRouterRegister {\n");
            sb.append("public void loadInto(Map<String, RouteMeta> atlas) {\n");

            //获得注解
            Route route = element.getAnnotation(Route.class);
            //函数体
            sb.append("atlas.put(\"");
            sb.append(route.path());
            sb.append("\",");
            sb.append("RouteMeta.build(");
            sb.append(element.getSimpleName());
            sb.append(".class,\"");
            sb.append(route.path());
            sb.append("\"));");
            sb.append("}\n");
            sb.append("}");

            try {
                //创建 Java文件
                JavaFileObject sourceFile = filer.createSourceFile(packageName+ "." + finalClassName);
                //输出字符串
                OutputStream outputStream = sourceFile.openOutputStream();
                outputStream.write(sb.toString().getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}