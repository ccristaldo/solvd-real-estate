package controller.functionalInterfaces;

import model.apt.Apt;

import java.util.List;

@FunctionalInterface
public interface IFiltering<T> {

     List<T> filtering(List<T> aptList);

}
