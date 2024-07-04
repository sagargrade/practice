package edu.practice.svc.bo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookBO {
    private Long id;
    private String name;
    private String author;
}
