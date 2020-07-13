package com.cookandroid.davin;

import android.app.Activity;

import java.util.Random;
import java.util.Scanner;

class Card extends Activity {
    static int mainCard[] = new int[26]; // 아직 뽑히지 않은 카드의 배열, 뽑히면 값이 -1로 변경
    static int numWcard = 13; // 남은 카드의 수
    static int numBcard = 13; // 남은 카드의 수
    int mycard[] = new int[13]; // 내가 현재 가지고 있는 카드
    int showcard[] = new int[13]; // 상대방에게 보여지고 있는 카드
    int pullcard[] = new int[2]; // 0은 뽑은 카드의 인덱스, 1은 뽑은카드의 값
    int cardNum; // 내가 현재 가지고 있는 카드의 수
    int joker = 0;
    Scanner n = new Scanner(System.in);
    Random rand = new Random();

    Card() {
        cardNum = 0;
        for (int i = 0; i < 13; i++) {
            mycard[i] = -1;
            showcard[i] = -1;
        }
    }

    void pull(int color) { // 카드 뽑기
        int i = 0;

        pullcard[1] = Pull.pullCard(color); // 뽑은 카드 값 저장
        cardNum++;

        for (i = cardNum - 2; i >= 0 && mycard[i] > pullcard[1]; i--) {
            mycard[i + 1] = mycard[i]; // 레코드의 오른쪽 이동
            showcard[i + 1] = showcard[i];
        }
        mycard[i + 1] = pullcard[1] + joker;
        showcard[i + 1] = -1;
        pullcard[0] = i + 1;
    }

    int infoCardColor(int location) { // 위치의 색깔을 리턴해주는 함수
        return mycard[location] % 2;
    }

    boolean testCard(int location, int num) { // 추측한 숫자가 맞으면
        if (mycard[location] == num) {
            showcard[location] = num;
            return true;
        } else
            return false;
    }

    void openCard(int location) { // 뽑은 카드를 공개하는 함수
        showcard[location] = mycard[location];
    }

    int getGuessLocation() { // com이 추측할 위치의 숫자를 리턴해주는 함수
        int location = -1;
        while (true) {
            location = rand.nextInt(cardNum);
            if (showcard[location] == -1 && mycard[location] != -1)
                return location;
        }
    }

    boolean CheckGuessNumber(int num, int turn) { // 추측하려는 수를 내가 이미 가지고있는지 아닌지
        // 판단(false일 경우 추측 가능)
        if (turn == 0) { // 내 턴일 경우
            for (int i = 0; i < cardNum; i++)
                if (mycard[i] == num)
                    return false;
        } else { // 상대방 턴일 경우
            for (int i = 0; i < cardNum; i++)
                if (showcard[i] == num)
                    return false;
        }
        return true;
    }



    boolean CheckFinish() { //내가 컴퓨터 카드 추측
        for (int i = 0; i < cardNum; i++)
            if (showcard[i] != mycard[i])
                return false;
        return true;
    }

    int firstTurn(int location, int color) { // 첫번째차례에 랜덤으로 숫자 리턴
        int randomNum;
        while (true) {
            if (location == 0) {
                if (color == 0)
                    randomNum = ((rand.nextInt(14)) / 2) * 2;
                else
                    randomNum = ((rand.nextInt(14)) / 2) * 2 + 1;
            } else {
                if (color == 0)
                    randomNum = ((rand.nextInt(14) + 12) / 2) * 2;
                else
                    randomNum = ((rand.nextInt(14) + 12) / 2) * 2 + 1;
            }
            for (int i = 0; i < cardNum; i++)
                if (mycard[i] != randomNum)
                    return randomNum;
        }
    }
}