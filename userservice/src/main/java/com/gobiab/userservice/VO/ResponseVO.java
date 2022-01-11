package com.gobiab.userservice.VO;

import com.gobiab.userservice.entity.Department;
import com.gobiab.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {

    private User user;
    private Department department;

}
