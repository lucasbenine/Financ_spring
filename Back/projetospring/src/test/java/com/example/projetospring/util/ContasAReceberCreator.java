package com.example.projetospring.util;

import com.example.projetospring.model.ContasAReceber;

public class ContasAReceberCreator {

    public static ContasAReceber creataContasAReceberToBeSaved() {
        ContasAReceber contasAReceber = new ContasAReceber("Sal�rio", 1500.00, "Sal�rio");
        return contasAReceber;
    }

    public static ContasAReceber createValidContasAReceber() {
        ContasAReceber contasAReceber = new ContasAReceber("Sal�rio", 1500.00, "Sal�rio");
        return contasAReceber;
    }

    public static ContasAReceber createValidUpdatedContasAReceber() {
        ContasAReceber contasAReceber = new ContasAReceber("Sal�rio", 1900.00, "Sal�rio");
        return contasAReceber;
    }

}
