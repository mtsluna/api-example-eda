package com.example.apiexample.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodeGeneratorComponent {

    public String generate(String dni, String surname) {
        return String.format("%s_%s_%s", dni, Math.random(), surname);
    }

}
