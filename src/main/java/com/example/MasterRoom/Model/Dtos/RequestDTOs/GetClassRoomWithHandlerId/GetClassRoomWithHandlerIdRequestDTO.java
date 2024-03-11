package com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId;

import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetClassRoomWithHandlerIdRequestDTO {
   private String handlerId;
   private int page;
   private int size;
}
