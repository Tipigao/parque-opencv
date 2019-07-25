/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * Retirado de https://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java
 * @author Roberto
 */
public class Tuple<X, Y> {
  public final X x;
  public final Y y;
  public Tuple(X x, Y y) {
    this.x = x;
    this.y = y;
  } 
}