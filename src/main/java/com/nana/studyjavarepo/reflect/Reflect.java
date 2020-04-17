package com.nana.studyjavarepo.reflect;


import com.nana.studyjavarepo.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/12  09:33
 * Description:
 * java反射机制:
 * 在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 * java提供的功能：
 * （1）在运行时判断任意一个对象所属的类；
 * （2）在运行时构造任意一个类的对象；
 * （3）在运行时判断任意一个类所具有的成员变量和方法；
 * （4）在运行时调用任意一个对象的方法；
 * （5）生成动态代理。
 * Modified By:
 */
public class Reflect {

    /**
     * 三种获取Class对象的方式
     * 1.类型.class，如String.class;使用类名加“.class”的方式即会返回与该类对应的Class对象。
     * 这个方法可以直接获得与指定类关联的Class对象，而并不需要有该类的对象存在。
     * 2.Class.forName("类名");该方法可以根据字符串参数所指定的类名获取与该类关联的Class对象。
     * 如果该类还没有被装入，该方法会将该类装入JVM。forName方法的参数是类的完 整限定名（即包含包名）。通常用于在程序运行时根据类名动态的载入该类并获得与之对应的Class对象
     * 3.obj.getClass();所有Java对象都具备这个方法，该方法用于返回调用该方法的对象的所属类关联的Class对象
     * 注：无论哪种方式获取的都是同一个Class对象
     */
    public static void getStudentClass() {
        //第一种
        Class c1 = Student.class;
        System.out.println("第一种获取Class对象方法：Student.class，获取结果：" + c1);

        try {
            //第二种
            Class c2 = Class.forName("com.xnn.reflect.Reflect");
            System.out.println("第二种获取Class对象方法：Class.forName(\"全限定类名\")，获取结果：" + c1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Student student = new Student(1, "xnn");
        Class c3 = student.getClass();
        System.out.println("第三种获取Class对象方法：student.getClass()，获取结果：" + c1);
    }

    /**
     * 获取构造函数
     * 获取方法：
     * 1.获取Class对象
     * 2.通过Class对象获取构造函数
     * 具体为:
     * Class clazz=Student.class;
     * 1.clazz.getConstructors();//返回类中所有 public 的构造函数数组
     * 2.clazz.getConstructor(); //返回类中一个 public 且 无参 的构造函数
     * 3.clazz.getConstructor(int.class,String.class);// 返回类中一个 public 且 有两个参数的 构造函数
     * //以下是获取不分public和非public属性 的构造函数
     * 4.clazz.getDeclaredConstructors();//返回类中所有 （不分public和非public属性）构造函数数组
     * 5.clazz.getDeclaredConstructor();//返回类中一个 （不分public和非public属性） 无参的 构造哈数
     * 6.clazz.getDeclaredConstructor(int.class,String.class);//返回类中一个 （不分public和非public属性） 且 有两个参数的 构造函数
     */
    public static void getStudentConstructor() {

        //获取Class对象
        Class clazz = Student.class;


        // 返回所有具有public属性的构造函数数组
        Constructor[] constructors1 = clazz.getConstructors();
        System.out.println("类中所有（public）的构造函数数组：" + constructors1.length + ",开始.....");
        for (Constructor con : constructors1) {
            System.out.println(con);
        }
        System.out.println("类中所有（public）的构造函数数组：" + constructors1.length + ",结束.....\n");
        try {
            //返回类中public 无参的构造函数
            Constructor con1 = clazz.getConstructor();
            System.out.println("返回类中（public 且无参）的构造函数：" + con1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            //根据构造函数的参数，返回一个具体的具有public属性的构造函数
            Constructor con3 = clazz.getConstructor(int.class, String.class);
            System.out.println("返回类中(public 且有一个int参数，一个String参数)的构造函数：" + con3);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //返回该类中 所有的 构造函数数组（不分public和非public属性）
        Constructor[] constructors2 = clazz.getDeclaredConstructors();
        System.out.println("类中所有（不分public和非public属性）构造函数数组：" + constructors2.length + ",开始.....");
        for (Constructor con : constructors2) {
            System.out.println(con);
        }
        System.out.println("类中所有（不分public和非public属性）构造函数数组：" + constructors2.length + ",结束.....\n");
        try {
            //返回类中的无参构造函数不分public和非public属性）
            Constructor con4 = clazz.getDeclaredConstructor();
            System.out.println("返回类中(不分public和非public属性 且无参数)的构造函数：" + con4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            //根据构造函数的参数，返回一个的构造函数不分public和非public属性）
            Constructor con4 = clazz.getDeclaredConstructor(int.class, String.class);
            System.out.println("返回类中(不分public和非public属性 且有一个int参数，一个String参数)的构造函数：" + con4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建类Student对象
     * 有两种创建方式：
     * 第一种：
     * 1.获取Class对象
     * 2.通过clazz.newInstance();创建
     * 第二种
     * 1.获取Class对象
     * 2.获取构造函数Constructor
     * 3.通过constructor1.newInstance(100,"nana");创建
     */
    public static void createObject() {
        Class clazz = Student.class;

        try {
            //第一种方式
            Object object1 = clazz.newInstance();
            System.out.println(object1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            //第二种方式
            Constructor constructor1 = clazz.getConstructor(int.class, String.class);
            Object object2 = constructor1.newInstance(100, "nana");
            System.out.println(object2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取类的成员变量
     * 获取方法：
     * 1.获取Class对象
     * 2.通过Class对象获取类中的成员变量
     * 具体为:
     * Class clazz=Student.class;
     * 1.clazz.getFields();//返回类中具有public属性的成员变量的数组
     * 2.clazz.getField("age");//根据变量名，返回一个具体的具有public属性的成员变量
     * 3.clazz.getDeclaredFields();//返回所有成员变量组成的数组（不分public和非public属性）
     * 4.clazz.getDeclaredField("id");//id是私有成员变量  //根据变量名，返回一个成员变量（不分public和非public属性）
     */
    public static void getStudentFields() {

        //Class clazz=Student.class;
        Class clazz = null;
        try {
            //获取Class对象
            clazz = Class.forName("com.xnn.entity.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //返回具有public属性的成员变量的数组
        Field[] fields1 = clazz.getFields();
        System.out.println("公有成员变量：" + fields1.length + " 开始。。。。");
        for (Field field : fields1) {
            System.out.println(field);
        }
        System.out.println("公有成员变量：" + fields1.length + " 结束。。。。\n");
        try {
            //根据变量名，返回一个具体的具有public属性的成员变量
            Field field1 = clazz.getField("age");
            System.out.println("公有成员变量:" + field1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //返回所有成员变量组成的数组（不分public和非public属性）
        Field[] fields2 = clazz.getDeclaredFields();
        System.out.println("所有成员变量：" + fields2.length + " 开始。。。。");
        for (Field field : fields2) {
            System.out.println(field);
        }
        System.out.println("所有成员变量：" + fields2.length + " 结束。。。。\n");
        try {
            //根据变量名，返回一个成员变量（不分public和非public属性）
            Field field2 = clazz.getDeclaredField("id");//id是私有成员变量
            System.out.println("私有成员变量：" + field2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            Field field3 = clazz.getDeclaredField("age");//age是公有成员变量
            System.out.println("公有成员变量：" + field3);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    /**
     * 设置类中成员变量值
     * 1.获取Class对象
     * 2.创建Object对象(两种方式：1.通过Class对象：clazz.newInstance(); 2. 通过构造函数：constructor.newInstance(5,"nana");)
     * 3.获取成员变量Field
     * 4.修改成员变量Field的值
     */
    public static void setStudentFieldValue() {
        //1.获得Class对象
        Class clazz = Student.class;
        try {
            //Object object=clazz.newInstance();

            //2.获得构造函数并创建Object对象
            Constructor constructor = clazz.getConstructor(int.class, String.class);
            Object object = constructor.newInstance(5, "nana");
            System.out.println(object);

            //3.获取类中成员变量，并改变其值
            Field age = clazz.getField("age");//公有成员变量
            age.set(object, 20);
            System.out.println("修改公有成员变量age " + object);

            Field id = clazz.getDeclaredField("id");//私有成员变量
            //取消访问私有字段的合法性检查
            id.setAccessible(true);
            id.set(object, 100);
            System.out.println("修改私有成员变量id " + object);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取类的成员方法
     * 获取方法：
     * 1.获取Class对象
     * 2.通过Class对象获取类中的成员方法
     * 具体为：
     * Student student=new Student();
     * Class clazz=student.getClass();
     * 1.clazz.getMethods();//返回所有具有public属性的方法数组
     * 2.clazz.getMethod("getIdNameAge");或者 clazz.getMethod("getNameValue", String.class, String.class);//根据方法名和参数，返回一个具体的具有public属性的方法
     * 3.clazz.getDeclaredMethods();//返回该类中的所有的方法数组（不分public和非public属性）
     * 4.clazz.getDeclaredMethod("getIdName");//getIdName是私有方法 //根据方法名，返回一个具体的 无参 方法（不分public和非public属性）
     * 5.clazz.getDeclaredMethod("getValue", String.class); // getValue是私有方法  //根据方法名和参数，返回一个具体的方法（不分public和非public属性）
     */
    public static void getStudentMethods() {

        Student student = new Student();
        Class clazz = student.getClass();

        //返回所有具有public属性的方法数组
        Method[] methods1 = clazz.getMethods();
        System.out.println("公有成员方法：" + methods1.length + " 开始。。。。");
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("公有成员方法：" + methods1.length + " 结束。。。。\n");
        try {
            //根据方法名数，返回一个具体的具有public 无参 的方法
            Method method1 = clazz.getMethod("getIdNameAge");
            System.out.println("公有成员方法：" + method1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            //根据方法名和参数，返回一个具体的具有public属性的方法
            Method method2 = clazz.getMethod("getNameValue", String.class, String.class);
            System.out.println("公有成员方法：" + method2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 返回该类中的所有的方法数组（不分public和非public属性）
        Method[] methods2 = clazz.getDeclaredMethods();
        System.out.println("所有成员方法：" + methods2.length + " 开始。。。。");
        for (Method method : methods2) {
            System.out.println(method);
        }
        System.out.println("所有成员方法：" + methods2.length + " 结束。。。。\n");

        try {
            //根据方法名，返回一个具体的 无参 方法（不分public和非public属性）
            Method method3 = clazz.getDeclaredMethod("getIdName");
            System.out.println("私有成员方法：" + method3);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            //根据方法名和参数，返回一个具体的方法（不分public和非public属性）
            Method method4 = clazz.getDeclaredMethod("getValue", String.class);
            System.out.println("私有成员方法：" + method4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * 调用类中方法
     * 1.获取Class对象
     * 2.创建对象Object(两种方式：1.通过Class对象：clazz.newInstance(); 2. 通过构造函数：constructor.newInstance(5,"nana");)
     * 3.获取成员方法Method
     * 4.调用该方法 method2.invoke(object,"nana");
     */
    public static void invokeStudentMethod() {

        Class clazz = Student.class;
        try {
            Object object = clazz.newInstance();
            //getNameValue是公有方法
            Method method1 = clazz.getMethod("getNameValue", String.class, String.class);
            // 调用对象 带参数的方法
            method1.invoke(object, "HHHH", "hello");

            //私有方法
            Method method2 = clazz.getDeclaredMethod("getValue", String.class);
            //取消访问私有方法的合法性检查
            method2.setAccessible(true);
            method2.invoke(object, "HHHH");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
