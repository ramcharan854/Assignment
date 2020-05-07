package main.java.securitythroughobscurity;

import java.util.ArrayList;
import java.util.*;

public class SecurityThroughObscurity {
	
	public static EncryptedRoom parseEncryptedRoom(String encryptedRoom) {
        return EncryptedRoom.parseEncryptedRoom(encryptedRoom);
    }

    public static List<EncryptedRoom> parseEncryptedRoomList(String encryptedRooms) {
        String[] splittedEncryptedRooms = encryptedRooms.split("\n");
        List<EncryptedRoom> encyptedRoomList = new ArrayList<>(splittedEncryptedRooms.length);
        for (String splittedEncryptedRoom : splittedEncryptedRooms) {
            EncryptedRoom encyptedRoom = parseEncryptedRoom(splittedEncryptedRoom);
            encyptedRoomList.add(encyptedRoom);
        }
        return encyptedRoomList;
    }
       
	
}
