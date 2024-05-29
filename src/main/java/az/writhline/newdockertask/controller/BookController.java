package az.writhline.newdockertask.controller;

import az.writhline.newdockertask.dto.BookRequestDto;
import az.writhline.newdockertask.dto.BookResponseDto;
import az.writhline.newdockertask.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public BookResponseDto get(@PathVariable Long id){
        return bookService.get(id);
    }
    @PostMapping
    public BookResponseDto create(@RequestBody BookRequestDto bookDto){
        return bookService.create(bookDto);
    }
    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @RequestBody BookRequestDto bookDto){
        return bookService.update(id,bookDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
