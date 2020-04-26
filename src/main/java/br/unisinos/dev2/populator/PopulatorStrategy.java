package br.unisinos.dev2.populator;

public interface PopulatorStrategy<SOURCE, TARGET> {

    void populate (SOURCE source, TARGET target);

}