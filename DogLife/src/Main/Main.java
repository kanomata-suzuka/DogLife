package Main;

import Service.ScheduleManagement;
import Util.InputUtil;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		ScheduleManagement management = new ScheduleManagement();

		while (true) {
			menu.display();
			int choice = InputUtil.inputInt("番号を入力してください：");

			switch (choice) {
			case 1:
				management.addSchedule();
				break;
			case 2:
				management.displaySchedules();
				break;
			case 3:
				management.updateSchedule();
				break;
			case 4:
				management.deleteSchedule();
				break;
			case 5:
				management.searchSchedule();
				break;
			case 0:
				System.out.println("わんライフを終了します。");
				return;
			default:
				System.out.println("正しい番号を入力してください。");
			}
		}
	}
}