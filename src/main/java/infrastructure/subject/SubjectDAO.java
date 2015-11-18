package infrastructure.subject;

import model.Subject;

import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
public interface SubjectDAO {

    Subject createNewSubject(Subject subject);
    Subject getSubjectById(int id);
    List<Subject> getAllUsersBySubject();

}
