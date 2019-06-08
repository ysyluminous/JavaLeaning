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
public enum WeekDay {
    MON{
        @Override
        public String toLocaleString() {
            return "星期一";
        }
    },TUE{
        @Override
        public String toLocaleString() {
            return "星期二";
        }
    },WED{
        @Override
        public String toLocaleString() {
            return "星期三";
        }
    },THU{
        @Override
        public String toLocaleString() {
            return "星期四";
        }
    },FRI{
        @Override
        public String toLocaleString() {
            return "星期五";
        }
    },SAT{
        @Override
        public String toLocaleString() {
            return "星期六";
        }
    },SUN{
        @Override
        public String toLocaleString() {
            return "星期天";
        }
    };


    public abstract  String toLocaleString();
}
