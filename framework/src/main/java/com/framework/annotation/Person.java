package com.framework.annotation;

@ClassAnnotation(name = "personBean", version = "1.2.1")
public class Person {

//    告诉大家是可以用的,但是影响我测试,我就又注释掉了.
//    @ConstructorAnnotatin(constructorName="Person()")
//    public Person(String description) {
//        this.description = description;
//    }

    @FieldAnnotation(name = "description", value = "This is my personal annotation")
    private String description;

    @FieldAnnotation(name = "xxx", value = "This is my personal annotation")
    private String description1;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @MethodAnnotation(name = "sayHello", type = MethodAnnotation.MethodTypeEnum.TYPE2)
    public void sayHello() {
        System.out.println("Hello Annotation!");
    }
}


