package com.example.changetext.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class TextArea {
   private String name;

   public TextArea(String name) {
      this.name = name;
   }

   public TextArea() {
   }
}
