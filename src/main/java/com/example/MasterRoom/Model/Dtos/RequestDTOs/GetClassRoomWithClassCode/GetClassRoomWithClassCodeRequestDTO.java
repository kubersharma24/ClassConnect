package com.example.MasterRoom.Model.Dtos.RequestDTOs.GetClassRoomWithClassCode;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetClassRoomWithClassCodeRequestDTO {
    private String handlerId;
    private String classCode;
}
