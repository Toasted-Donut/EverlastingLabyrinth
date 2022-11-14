package com.example.everlastinglabyrinth;

public class Node {
    byte corr = 0;
    Boolean up_fit = null;
    Boolean down_fit = null;
    Boolean right_fit = null;
    Boolean left_fit = null;

    public static Node[][] New_Map(int size) {
        Node[][] new_map = new Node[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                new_map[i][j] = new Node();
            }
        }
        return new_map;
    }
    public static Node[][] Import_Byte_Map(byte[][] map_byte){
        Node[][] map = New_Map(map_byte.length);
        for (int i = 0; i < map_byte.length; i++) {
            for (int j = 0; j < map_byte[0].length; j++) {
                map[i][j].corr=map_byte[i][j];
            }
        }
        return map;
    }

}
