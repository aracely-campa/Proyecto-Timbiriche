/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain.interfaces;

import domain.graph.Edge;

/**
 *
 * @author HP 240 G8
 */
public interface iGraphIterator {

    public Edge getNext();

    public Boolean hasNext();
}
