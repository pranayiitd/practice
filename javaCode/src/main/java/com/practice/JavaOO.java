/******** Inheritance ********/
class Parent{
  // Child can access 
  int parentVar0 = 0;
  // Child can access 
  protected int parentVar1 = 100;
  // Child can NOT access 
  private int parentVar2 = 200;

  public void method(){
    System.out.println("I am in parent");
  }
}

class Child extends Parent{
  public void method() {
    System.out.println("I am in child");
  }
  public void childMethod(){
    System.out.println("i am child");
  }
}

/******** Interface ********/
interface Animal{
  // ** Interfac can not have constructor function
  // Animal();

  // All vars are static and final automatically
  // can not be modified by implementing classes
  int alive = 100;

  public void eat();
  public void breate();
}

// Must implement all the abstrac methods of interface
class Human implements Animal{
  int age;
  Human(){
    age = 10;
  }
  public void eat(){
    System.out.println("Give me Indian food");
  }
  public void breate(){
    System.out.println("Deep breating....");
  }
}

class JavaOO{

  public static void testInheritance(){
    Parent p = new Parent();
    Child c = new Child();
    Parent pc = new Child();

    p.method();
    c.method();
    // the child method will be called
    // depends on the class not ref
    pc.method();
    c.childMethod();

    // Not allowed
    // accecss to only what ref type has access to
    // pc.childMethod();

    System.out.println(c.parentVar0);
    System.out.println(c.parentVar1);
   // ** NOT allowed access
   // System.out.println(c.parentVar2);
  }

  public static void testInterface(){
    // CANNOT initiate an interface
    // Animal a = new Animal();
    Animal h = new Human();
    h.eat();
    h.breate();
    // ** No access to Human's vars
    // System.out.println(h.age);

    // NOT allowed to assign, as interface vars are static and final
    // h.alive  = 200;
    System.out.println(h.alive);

    Human hm = new Human();
    // the Ref must be Human to get access to Human stuff
    System.out.println(hm.age);
    //** NOT allowed
    // hm.alive = 2000;
    System.out.println(hm.alive);
  }

  public static void main(String arg[]){
    testInheritance();
    // testInterface();

  }
}