package com.cookandroid.davin;

import java.util.Random;
import java.util.Scanner;

class Pull {
    static Scanner n = new Scanner(System.in);
    static Random rand = new Random();

    static int pullCard(int color) { // 카드선택
        int card = -1;
        while (color == 0) { // 검은패 뽑기
            card = (rand.nextInt(26) / 2) * 2;
            if (Card.mainCard[card] != -1) {
                Card.mainCard[card] = -1;
                return card;
            }
        }
        while (color == 1) { // 흰색패 뽑기
            card = (rand.nextInt(26) / 2) * 2 + 1;
            if (Card.mainCard[card] != -1) {
                Card.mainCard[card] = -1;
                return card;
            }
        }
        return card;
    }

    static boolean CheckPullCard() { // 카드를 뽑을수 있는지 없는지 검사하는 함수
        if ((Card.numWcard == 0) && (Card.numBcard == 0))
            return false;
        else
            return true;
    }
}

