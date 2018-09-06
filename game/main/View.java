package main;

import main.cards.*;
import main.players.Player;
import java.util.*;

public class View {

    private enum Position {
        TOP("/", "\\"),
        BOTTOM("\\", "/"),
        MIDDLE("|", "|");

        String left;
        String right;

        private Position(String left, String right) {
            this.left = left;
            this.right = right;
        }

        private String getLeftMark() {
            return left;
        }

        private String getRightMark() {
            return right;
        }
    }

    public enum Message {
        ASK_FOR_PARAMETER("GIVE PARAMETER"),
        PLAYER_CARD("YOUR CARD"),
        CPU_CARD("CPU CARD"),
        DRAW("DRAW");

        String message;

        private Message(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }

    private String centerString(String string, Integer widthGoal) {
        StringBuilder centeredString = new StringBuilder();
        int stringLenght = string.length();
        int margin = widthGoal - stringLenght;
        int additionalMargin = 0;

        if (margin%2 != 0) {
            additionalMargin = 1;
        }
        margin /= 2;

        for (int i=0; i < margin; i++) {
            centeredString.append(" ");
        }

        centeredString.append(string);

        for (int i=0; i < margin+additionalMargin; i++) {
            centeredString.append(" ");
        }
        return centeredString.toString();
    }

    private void printLine(Position position, int cardWidth) {
        System.out.print(position.getLeftMark());
        for (int i=0; i<cardWidth; i++) {
            System.out.print("-");
        }
        System.out.println(position.getRightMark());
    }

    public void printCard(Card card) {
        int CARD_WIDTH = 25;
        String[] parameters = card.getCardParameters();
        int index = 1;
        printLine(Position.TOP, CARD_WIDTH);
        System.out.printf("|%s|\n", centerString(card.getName(), CARD_WIDTH));
        printLine(Position.MIDDLE, CARD_WIDTH);
        for (String parameter : parameters) {
            parameter = String.format("%s - %d", parameter, card.getParameter(index));
            System.out.println("|" + centerString(parameter, CARD_WIDTH) + "|");
            index++;
        }
        printLine(Position.BOTTOM, CARD_WIDTH);
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printMainMenu() {
        String[] mainMenu = {"Play", "How to Play", "Exit"};
        String gameTitle = "BATTLE OF CARDS";

        System.out.printf("%s\n", gameTitle);
        for (int i=0; i<mainMenu.length; i++) {
            System.out.printf("\t%d) %s\n", i+1, mainMenu[i]);
        }
    }

    public void printWinner(Player winner) {
        System.out.printf("%s won!\n", winner.getName());
        System.out.printf("%s won with %d cards in his hand\n", winner.getName(), winner.getHand().getAmountOfCardsInHand());
    }
}
