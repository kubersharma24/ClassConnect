package com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithHandlerId;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetClassRoomWithHandlerIdResponseDTO {
    private String className;
    private String classCode;
    private String classDescription;
}
