package pattern.memento;

import pattern.memento.game.Gamer;
import pattern.memento.game.Memento;

public class Main {

	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);				// 最初の所持金は100
		Memento memento = gamer.createMemento();	// 最初の状態を保存しておく
		
		for (int i = 0; i < 100; i++) {
			System.out.println("====" + i);
			System.out.println("現状:" + gamer);
			
			gamer.bet();
			
			System.out.println("所持金は" + gamer.getMoney() + "円になりました。");
			
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("    (だいぶ増えたので、現在の状態を保存しておこう)");
				memento = gamer.createMemento();
			} else if (gamer.getMoney() < memento.getMoney()) {
				System.out.println("    (だいぶ減ったので、以前の状態に復帰しよう)");
				gamer.restoreMemento(memento);
			}
			
			// 時間待ち
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("");
		}
	}

}
