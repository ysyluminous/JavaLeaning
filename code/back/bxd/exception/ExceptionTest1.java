import java.nio.channels.Pipe;

/************************************************************************
 *
 * 文件名:	ExceptionTest1
 *
 * 文件描述:	第10天_04_面向对象_异常_练习
 *
 * 创建人:	Yao Siyuan,
 *
 * 总结:		接口的出现提高了功能拓展性
 *
 * 版本号:	0.1
 *
 * 修改记录:
 *			0.1:
 *
 ************************************************************************/
/*
	有一个圆形和长方形。
	都可以获取面积，对于面积如果出现非法的数值，视为获取面积出现问题。
	问题通过异常来表示。
	现有对这个程序进行基本设计。
*/


class NoValueException extends RuntimeException
{
    NoValueException(String message)
    {
        super(message);
    }
}

interface Shape
{
    void getArea();
}

class Circle implements Shape
{
    private int radius;
    public static final double PI = 3.14;
    Circle(int radius)
    {
        if (radius <= 0) {
            throw new NoValueException("非法");
        }
        this.radius = radius;
    }
    public void getArea(){
        System.out.print(radius * radius * PI);
    }
}

class Rec implements Shape
{
    private int len,wid;

    Rec(int len, int wid) //throws NoValueException
    {
        if (len <= 0 || wid <= 0) {
            throw new NoValueException("出现非法值");
        }

            this.len = len;
            this.wid = wid;
    }

    public void getArea()
    {
        System.out.println(len * wid);
    }
}

class ExceptionTest1
{
    public static void main(String args []) {

        Rec r = new Rec(3, 4);
        r.getArea();

        Circle c = new Circle(-8);
    }
}






