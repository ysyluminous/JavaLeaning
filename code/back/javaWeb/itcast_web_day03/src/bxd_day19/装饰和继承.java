package bxd_day19;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.12.02
 *
 * Summary: MyReader//专门读取数据的类。
 *          |--MyTextReader
 *              |--MyBufferReader
 *          |--MyMediaReader
 *              |--MyBufferMediaReader
 *          |--MyDataReaderReader
 *  class My BufferReader{
 *      MyBufferReader(MyTextReader text){
 *
 *      }
 *      MyBufferReader(MyMediaReader media){
 *
 *      }
 *  }
 *  上面这个类拓展类很差，
 *  找到其参数的共同类型，通过多态的形式，可以提高拓展性。
 *
 *  class My BufferReader extends MyReader{
 *      private MyReader r;
 *      MyBufferReader(MyReader r){
 *
 *      }
 *
 *  }
 *  MyReader//专门读取数据的类。
 *          |--MyTextReader
 *          |--MyMediaReader
 *          |--MyBufferReader
 *      装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强的功能。
 *      所以装饰类和被装饰类通常都是属于一个体系中的。
 *
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class 装饰和继承 {
}
