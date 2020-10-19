package vn.codegym.chuong.common;

import vn.codegym.chuong.model.student_model.Student;

public class SettingCode {
    public static String setUpCode(Student student){
        String code = null;
        Long id = student.getStudentId();
        if (id < 10) {
            code = "SV-000" + id;
        } else if (id < 100) {
            code = "SV-00" + id;
        } else if (id < 1000) {
            code = "SV-0" + id;
        } else if(id < 10000) {
            code = "SV-" + id;
        } else {
            code = "SV-zzzz";
        }
        return code;
    }
}
