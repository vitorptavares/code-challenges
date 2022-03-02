package com.leetcode;

public class LinkedNode<T> {
    private T firstNode;
    private T lastNote;

    public void addFirstNode(T t){
        if(firstNode==null){
            firstNode = t;
        }
    }
    public void removeFirstNode(){
        if(firstNode!=null){
            firstNode = null;
        }
    }
    public void addLastNode(T t) {
        if (lastNote == null) {
                lastNote = t;
        }
    }

    public void removeLastNode(){
        if(lastNote!=null){
            lastNote = null;
        }
    }

    public T getFirstNode() {
        return firstNode;
    }

    public T getLastNote() {
        return lastNote;
    }

}
