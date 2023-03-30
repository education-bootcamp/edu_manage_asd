package com.developersstack.edumanage.bo.custom.impl;

import com.developersstack.edumanage.bo.custom.StudentBo;
import com.developersstack.edumanage.dto.StudentDto;
import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.repo.RepoFactory;
import com.developersstack.edumanage.repo.custom.StudentRepo;
import com.developersstack.edumanage.repo.custom.impl.StudentRepoImpl;
import com.developersstack.edumanage.util.enums.RepoType;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBoImpl implements StudentBo {

    private final StudentRepo studentRepo =(StudentRepo) RepoFactory.getInstance().getRepo(RepoType.STUDENT);

    @Override
    public boolean saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentRepo.save(
                new Student(
                        dto.getStudentId(), dto.getFullName(), dto.getDateOfBirth(),
                        dto.getAddress()
                )
        );
    }

    @Override
    public boolean updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentRepo.update(
                new Student(
                        dto.getStudentId(), dto.getFullName(), dto.getDateOfBirth(),
                        dto.getAddress()
                )
        );
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentRepo.delete(id);
    }

    @Override
    public StudentDto findStudent(String id) throws SQLException, ClassNotFoundException {
        Student student = studentRepo.find(id);
        if (student != null) {
            return new StudentDto(student.getStudentId(), student.getFullName()
                    , student.getDateOfBirth(), student.getAddress());
        }
        return null;
    }

    @Override
    public String findStudentLastId() throws SQLException, ClassNotFoundException {
        return studentRepo.findStudentLastId();
    }

    @Override
    public ArrayList<StudentDto> searchStudents(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<Student> list = studentRepo.findAllStudents(searchText);
        ArrayList<StudentDto> dtos = new ArrayList<>();
        for (Student s : list
        ) {
            dtos.add(new StudentDto(s.getStudentId(), s.getFullName()
                    , s.getDateOfBirth(), s.getAddress()));
        }
        return dtos;
    }
}
