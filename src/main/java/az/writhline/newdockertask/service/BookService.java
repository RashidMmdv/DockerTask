package az.writhline.newdockertask.service;

import az.writhline.newdockertask.dto.BookRequestDto;
import az.writhline.newdockertask.dto.BookResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    BookResponseDto get(Long id);
    BookResponseDto create(BookRequestDto bookDto);
    BookResponseDto update(Long id, BookRequestDto bookDto);
    void delete(Long id);

}
