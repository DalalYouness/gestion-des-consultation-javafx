package ma.enset.gestion_consultations.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO <E,U>{

    void Create(E e) throws SQLException;
    void Update(E e) throws SQLException;
    void Delete(E e) throws SQLException;
    E FindByID(U id) throws SQLException;
    List<E> GetAll() throws SQLException;
}

