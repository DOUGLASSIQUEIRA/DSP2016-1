package dsp.grupointegrado.br.dsp2016_1.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bhpachulski on 4/4/2016.
 */
public enum Combustivel {

    GASOLINA(1), ETANOL(2), DIESEL(3);

    private int id;

    private static Map<Integer, Combustivel> combustiveis;

    static {

        combustiveis = new TreeMap<>();

        for (Combustivel c : Combustivel.values())
            combustiveis.put(c.getId(), c);

    }

    private Combustivel (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Map<Integer, Combustivel> getCombustiveis() {
        return combustiveis;
    }
}
