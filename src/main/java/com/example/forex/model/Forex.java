package com.example.forex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Slf4j
public class Forex {
    private String date;
    private String base;
    Rates rates;
}
