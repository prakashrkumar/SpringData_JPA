package prakash.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prakash.entity.Student;
import prakash.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public void createStudent(Student student){
        studentRepository.save(student);
    }
    public Student fetchStudentById(Long id ){
      Optional<Student>studentOptional= studentRepository.findById(id);
      return studentOptional.get();
    }
    public List<Student> fetchStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public void updateStudent(Student studentReq,Long id){
        Optional<Student>StudentRes=studentRepository.findById(id);
        Student student= StudentRes.get();
        student.setEmail(studentReq.getEmail());
        student.setName(studentReq.getName());


    }

//    public List<Student> fetchAll(String name){
//       // Sort sort=Sort.by("age").descending();
//        // oR
//      //  Sort sort=Sort.by(Sort.Direction.ASC,"name");
//        //for multiple
//        //Sort sort=Sort.by("name").and(Sort.by("age"));
//
//        Sort sort=Sort.by("name").ascending().and(
//                Sort.by("age").descending()
//        );
//        List<Student>studentList=studentRepository.findAll(sort);
//        for(Student s :studentList){
//            System.out.println(s);
//        }
//        return studentList;
//    }

    public List<Student> fetchAll(String name){

        Sort sort=Sort.by("name").ascending().and(
                Sort.by("age").descending()
        );
        Pageable pageable= PageRequest.of(1,2);
        Page<Student> studentList=studentRepository.findAll(pageable);
        for(Student s :studentList.getContent()){
            System.out.println(s);
        }
        return studentList.getContent();
    }


}
