/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.12.01
 *
 * Summary:	装饰设计模式：
 *          当想要对已有的对象进行功能增强的时候，
 *          可以自定义类，将已有的对象传入，基于已有的功能，并加强功能。
 *          那么自定义的该类就成为装饰类。
 *
 *
 *          装饰类通常透过构造方法接受被装饰的对象，并基于被装饰的对象的功能，
 *          提供更强的功能。
 *
  * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class PersonDemo {
    public static void main(String args[]){
        Person p = new Person();
//        p.chifan();

        SuperPerson sp = new SuperPerson(p);
        sp.superChifan();
    }
}

class SuperPerson{
    private Person p;
    SuperPerson(Person p ){
        this.p = p;
    }

    public void superChifan(){
        System.out.println("开胃菜");
        p.chifan();
        System.out.println("甜点");
        System.out.println("来一根");
    }

}


class Person{
    public void chifan(){
        System.out.println("吃饭");
    }
}