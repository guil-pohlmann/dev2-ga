package br.unisinos.dev2.strategy;

public interface PopulatorStrategy<SOURCE, TARGET> {

    void populate (SOURCE source, TARGET target);

}