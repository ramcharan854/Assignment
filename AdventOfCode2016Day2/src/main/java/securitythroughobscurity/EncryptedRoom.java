package main.java.securitythroughobscurity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EncryptedRoom {

	public static Pattern ENCRYPTED_ROOM_PATTERN = Pattern.compile("([a-z\\-]+)-(\\d+)(\\[([a-z]+)])?");

    public String roomName;
    public int sectorId;
    public String checksum;


    public EncryptedRoom(String roomName, int sectorId, String checksum) {
		this.roomName = roomName;
		this.sectorId = sectorId;
		this.checksum = checksum;
	}


	public static EncryptedRoom parseEncryptedRoom(String encryptedRoom) {
        Matcher encryptedRoomMatcher = ENCRYPTED_ROOM_PATTERN.matcher(encryptedRoom);
        if (!encryptedRoomMatcher.matches()) {
            String message = String.format("Encrypted room doesn't match expected pattern '%s': %s",
                    ENCRYPTED_ROOM_PATTERN.pattern(), encryptedRoom);
            throw new IllegalArgumentException(message);
        }

        String roomName = encryptedRoomMatcher.group(1);
        int sectorId = Integer.parseInt(encryptedRoomMatcher.group(2));
        String checksum = encryptedRoomMatcher.group(4);
        return new EncryptedRoom(roomName, sectorId, checksum);
    }


    public boolean isValid() {
        Map<Character, LetterOccurance> letterOccurrence = new HashMap<>();
        for (int i = 0; i < roomName.length(); i++) {
            char c = roomName.charAt(i);
            if (c == '-') {
                continue;
            }

            LetterOccurance letterOccurence = letterOccurrence.computeIfAbsent(c, LetterOccurance::new);
            letterOccurence.occurence++;
        }

        List<LetterOccurance> letterRank = letterOccurrence.values()
                .stream()
                .sorted(LetterOccurance.compareByOccurrence())
                .collect(Collectors.toList());
        for (int i = 0; i < checksum.length(); i++) {
            char letter = letterRank.get(i).letter;
            char checksumLetter = checksum.charAt(i);
            if (checksumLetter != letter) {
                return false;
            }
        }
        return true;
    }

    public String decryptRoomName() {
        StringBuilder decryptedRoomName = new StringBuilder(roomName);
        int cipherShift = sectorId % 26;

        for (int i = 0; i < decryptedRoomName.length(); i++) {
            char letter = decryptedRoomName.charAt(i);
            if (letter == '-') {
                decryptedRoomName.setCharAt(i, ' ');
                continue;
            }
            letter += cipherShift;
            if (letter > 'z') {
                letter -= 26;
            }
            decryptedRoomName.setCharAt(i, letter);
        }
        return decryptedRoomName.toString();
    }


}
