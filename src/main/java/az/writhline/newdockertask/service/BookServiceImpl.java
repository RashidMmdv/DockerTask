package az.writhline.newdockertask.service;

import az.writhline.newdockertask.dto.BookRequestDto;
import az.writhline.newdockertask.dto.BookResponseDto;
import az.writhline.newdockertask.model.BookEntity;
import az.writhline.newdockertask.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookResponseDto get(Long id) {
        return bookRepository.findById(id)
                .map(bookEntity -> modelMapper.map(bookEntity,BookResponseDto.class))
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public BookResponseDto create(BookRequestDto bookDto) {
        BookEntity book = modelMapper.map(bookDto, BookEntity.class);
        return modelMapper.map(bookRepository.save(book),BookResponseDto.class);
    }

    @Override
    public BookResponseDto update(Long id, BookRequestDto bookDto) {
       final BookEntity book = modelMapper.map(bookDto, BookEntity.class);
       book.setId(id);
        searchException(id);
        return modelMapper.map(bookRepository.save(book),BookResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        searchException(id);
        bookRepository.deleteById(id);
    }
    public void searchException(Long id){
        bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not Found: "+id+" this id"));
    }
}
