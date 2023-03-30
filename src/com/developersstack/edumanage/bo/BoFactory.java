package com.developersstack.edumanage.bo;

import com.developersstack.edumanage.bo.custom.StudentBo;
import com.developersstack.edumanage.bo.custom.impl.StudentBoImpl;
import com.developersstack.edumanage.bo.custom.impl.TeacherBoImpl;
import com.developersstack.edumanage.bo.custom.impl.UserBoImpl;
import com.developersstack.edumanage.repo.custom.impl.StudentRepoImpl;
import com.developersstack.edumanage.repo.custom.impl.TeacherRepoImpl;
import com.developersstack.edumanage.repo.custom.impl.UserRepoImpl;
import com.developersstack.edumanage.util.enums.BoType;
import com.developersstack.edumanage.util.enums.RepoType;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){}

    public static BoFactory getInstance(){
        return (null==boFactory)?(boFactory= new BoFactory()):boFactory;
    }

    public <T> T  getBo(BoType type){
        switch (type){
            case TEACHER:
                return (T) new TeacherBoImpl();
            case USER:
                return (T) new UserBoImpl();
            case STUDENT:
                return (T) new StudentBoImpl();
            default:
                return null;
        }
    }

}
