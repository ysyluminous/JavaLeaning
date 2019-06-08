package cn.itcast.domain;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.10.26
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
    private String idcard;
    private String examid;
    private String name;
    private String location;
    private float grade;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getExamid(String s) {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [examid=" + examid + ", grade=" + grade + ", idcard="
                + idcard + ", location=" + location + ", name=" + name + "]";
    }



}
