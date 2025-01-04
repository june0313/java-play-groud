package me.jun.sgt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coffee {
    private int id;
    private String name;
    private Size size;
}
