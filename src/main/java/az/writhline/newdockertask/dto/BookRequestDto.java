package az.writhline.newdockertask.dto;

import lombok.Data;

@Data
public class BookRequestDto {
    private String author;
    private String name;
    private int pageCount;
}
