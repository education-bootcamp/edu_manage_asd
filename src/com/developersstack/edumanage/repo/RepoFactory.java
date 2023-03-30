package com.developersstack.edumanage.repo;

import com.developersstack.edumanage.repo.custom.impl.StudentRepoImpl;
import com.developersstack.edumanage.repo.custom.impl.TeacherRepoImpl;
import com.developersstack.edumanage.repo.custom.impl.UserRepoImpl;
import com.developersstack.edumanage.util.enums.RepoType;

public class RepoFactory {
    private static RepoFactory repoFactory;
    private RepoFactory(){}

    public static RepoFactory getInstance(){
        return (null==repoFactory)?(repoFactory= new RepoFactory()):repoFactory;
    }

    public SuperRepo getRepo(RepoType type){
        switch (type){
            case TEACHER:
                return new TeacherRepoImpl();
            case USER:
                return new UserRepoImpl();
            case STUDENT:
                return new StudentRepoImpl();
            default:
                return null;
        }
    }

}
