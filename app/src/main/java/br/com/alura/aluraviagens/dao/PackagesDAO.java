package br.com.alura.aluraviagens.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.aluraviagens.model.PackageModel;


public class PackagesDAO {

    public List<PackageModel> generateList() {
        return new ArrayList<>(Arrays.asList(new PackageModel("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99")),
                new PackageModel("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal("421.50")),
                new PackageModel("Recife", "recife_pe", 4, new BigDecimal("754.20")),
                new PackageModel("Rio de Janeiro", "rio_de_janeiro_rj", 6, new BigDecimal("532.55")),
                new PackageModel("Salvador", "salvador_ba", 5, new BigDecimal("899.99")),
                new PackageModel("Foz do Iguaçu", "foz_do_iguacu_pr", 1, new BigDecimal("289.90"))));
    }
}