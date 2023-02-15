package com.leandro.backend.utils;

import lombok.Data;

@Data
public class RequestDeletePicture {
    private String idUser;
    private String idEntity;
    private String type;
}
