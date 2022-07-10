public class Main {
    public static void main(String[] args){
        // 두 영웅 객체를 생성
        Hero arthas = new Hero("아서스");
        Hero leona = new Hero("레오나");

        // 격투 시작
        Hero.battle(arthas, leona);
        System.out.println();

    }
}
class Hero {
    // 해당 클래스를 구현하시오.
    String name;
    int hp = 30;

    Hero(String name){
        this.name = name;
    }
    void punch(Hero enermy){  //Hero 타입!!의 펀치의 대상!!
        enermy.hp -= 10; // 펀치를 날려서 10씩 체력 감소 시키기
        System.out.printf("[%s]의 펀치\n",this.name);  // \n - unix에서 줄바꿈
        // 공격자의 이름으로 펀치 메세지 출력
        System.out.printf("\t%s: %d/30\n", enermy.name, enermy.hp);
        // 상대방의 남은 체력(hp - 10 한)을 알리는 메세지 출력
        if (enermy.hp <= 0){
            System.out.println(this.name + "의 승리!");
        }
    }

    static void battle(Hero a, Hero b) {
        /* 소괄호 끝에 throws InterruptedException을 붙이고
        아래에 Thread.sleep(100);를 붙이면 딜레이 걸 수 있음 */
        // a와 b가 위의 객체들의 정보를 갖고있다.

        // 둘 중 체력이 남아있다면 펀치를 반복한다 -> 반복문
        while (a.hp > 0 && b.hp > 0){
        // 아서스와 레오나의 체력이 남아있다면 반복, 둘중 하나라도 아니라면 싸움이 끝남
            // 1/2 확률로 공격/수비 결정하기
            Hero attacker, defender;
            if(Math.random()<0.5) { // 0.0000~0.9999... 사이의 임의의 실수가 반의 확률로
                attacker = a;
                defender = b;
            } else {
                attacker = b;
                defender = a;
            }

            //대상을 공격
            attacker.punch(defender);

            /*딜레이 0.1초 넣기 -> 넣으려면 battle 메서드 안에 throws InterruptedException 추가
            Thread.sleep(100);
            */
        }
    }
}
