package dataStructure.线性表.数组线性表;

import dataStructure.线性表.数组线性表.LinarList;
import dataStructure.线性表.数组线性表.SeqList;
import org.junit.Test;

public class TestList {

    @Test
    public void test(){
        int V=10;
        LinarList<Integer> list = new SeqList<>(Integer.class, V);
        list.add(2);
        list.add(22);
        list.add(224);
        list.print();
    }
}
