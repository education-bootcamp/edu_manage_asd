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

    public <T> T  getRepo(RepoType type){
        switch (type){
            case TEACHER:
                return (T) new TeacherRepoImpl();
            case USER:
                return (T) new UserRepoImpl();
            case STUDENT:
                return (T) new StudentRepoImpl();
            default:
                return null;
        }
    }

}
