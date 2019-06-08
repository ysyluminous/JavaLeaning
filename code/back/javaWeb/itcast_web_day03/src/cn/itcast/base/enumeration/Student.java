package cn.itcast.base.enumeration;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.24
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Student {

    //不优雅
//    private String name;
//    private String grade;//成绩，只能是ABCDE
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        if (!grade.matches("[ABCDE]")){
//            throw new RuntimeException("非法数值");
//        }
//        this.grade = grade;
//    }
    private String name;
    private Grade grade; //成绩，只能是ABCDE

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


}
//
//class Grade{
//    private  Grade(){}
//    public static Grade A = new Grade();
//    public static Grade B = new Grade();
//    public static Grade C = new Grade();
//    public static Grade D = new Grade();
//    public static Grade E = new Grade();
//}

/*
enum Grade{  // 与上面的代码功能完全一样
    A("100~90"){
        public String toLocaleString() {
            return "优秀";
        }
    },B("89-80"){
        public String toLocalString() {
            return "良好";
        },C("79-70"){
            public String toLocalString() {
                return "一般" ;
            },D("69-60"){
                public String toLocalString() {
                    return "刚及格";
                },E("59-0") {
                    public String toLocalString () {
                        return "不及格";
                    }
                };//代表着自身的一个个实例对象
    public String value; //A 100-90 B 89-80  C 79-70 D 69-60 E 59-0
    public Grade(){}
    private Grade(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
public abstract String toLocaleString() {

        }

}

*/

enum Grade{//与上面的代码功能完全一样
    A("100~90"){
        public String toLocaleString(){
            return "优秀";
        }
    },B("89~80"){
        public String toLocaleString(){
            return "良好";
        }
    },C("79~70"){
        public String toLocaleString(){
            return "一般";
        }
    },D("69~60"){
        public String toLocaleString(){
            return "刚及格";
        }
    },E("59~0"){
        public String toLocaleString(){
            return "不及格";
        }
    };//代表着自身的一个个的实例对象
    //	字段
    private String value;//  A  100~90  B 89~80 C 79~70 D 69~60 E 59~0

    //构造函数，
    private Grade(){}
    private Grade(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public abstract String toLocaleString();
}
/*
 	private String value;
	private Grade(String value){
		this.value = value;
	}
	public static Grade A = new Grade("dsfdsf"){
		public String toLocaleString(){
			return "优秀";
		}
	};
	public static Grade B = new Grade();
	public static Grade C = new Grade();
	public static Grade D = new Grade();
	public static Grade E = new Grade();
*/