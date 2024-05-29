package az.writhline.newdockertask.repository;

import az.writhline.newdockertask.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
